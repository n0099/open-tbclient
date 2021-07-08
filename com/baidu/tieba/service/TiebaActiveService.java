package com.baidu.tieba.service;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.common.ConstantHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
/* loaded from: classes4.dex */
public class TiebaActiveService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACTIVE_FAIL = 1;
    public static final int ACTIVE_SUCC = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public b mActiveTask;
    public Handler mHandler;
    public int mHaveRetry;
    public Runnable mRunnable;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TiebaActiveService f20696e;

        public a(TiebaActiveService tiebaActiveService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiebaActiveService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20696e = tiebaActiveService;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20696e.sendActive();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f20697a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TiebaActiveService f20698b;

        public b(TiebaActiveService tiebaActiveService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiebaActiveService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20698b = tiebaActiveService;
            this.f20697a = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20698b.mActiveTask = null;
                NetWork netWork = this.f20697a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                super.cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                try {
                    NetWork netWork = new NetWork("http://114.113.149.3:8086/partnersService");
                    this.f20697a = netWork;
                    netWork.addPostData("apk", TbadkCoreApplication.getInst().getApp().getPackageName());
                    this.f20697a.addPostData("imei", TbadkCoreApplication.getInst().getImei());
                    this.f20697a.addPostData("model", Build.MODEL);
                    this.f20697a.addPostData("edition", TbConfig.getVersion());
                    this.f20697a.addPostData(ConstantHelper.LOG_OS, Build.VERSION.SDK);
                    this.f20697a.getNetContext().getRequest().getNetWorkParam().mIsBaiduServer = false;
                    String postNetData = this.f20697a.postNetData();
                    if (this.f20697a.isNetSuccess()) {
                        return postNetData;
                    }
                    return null;
                } catch (Exception e2) {
                    d.a.o0.r.d0.b.j().v("active", 1);
                    BdLog.e(e2.getMessage());
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((b) str);
                this.f20698b.mActiveTask = null;
                if (str == null) {
                    TiebaActiveService.access$308(this.f20698b);
                    if (this.f20698b.mHaveRetry < 10) {
                        this.f20698b.mHandler.removeCallbacks(this.f20698b.mRunnable);
                        this.f20698b.mHandler.postDelayed(this.f20698b.mRunnable, 60000L);
                    } else {
                        d.a.o0.r.d0.b.j().v("active", 1);
                        this.f20698b.stopSelf();
                    }
                }
                d.a.o0.r.d0.b.j().v("active", 2);
                this.f20698b.stopSelf();
            }
        }

        public /* synthetic */ b(TiebaActiveService tiebaActiveService, a aVar) {
            this(tiebaActiveService);
        }
    }

    public TiebaActiveService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mActiveTask = null;
        this.mHaveRetry = 0;
        this.mHandler = new Handler();
        this.mRunnable = new a(this);
    }

    public static /* synthetic */ int access$308(TiebaActiveService tiebaActiveService) {
        int i2 = tiebaActiveService.mHaveRetry;
        tiebaActiveService.mHaveRetry = i2 + 1;
        return i2;
    }

    private String getChannelByShare() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? d.a.o0.r.d0.b.j().p("channel_id", null) : (String) invokeV.objValue;
    }

    private String getChannelyFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            String str = null;
            try {
                File GetFile = FileHelper.GetFile(TbConfig.CHANNEL_FILE);
                if (GetFile != null) {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(GetFile));
                    str = bufferedReader.readLine();
                    bufferedReader.close();
                    return str;
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, "TiebaActiveService.getChannelyFile");
                return str;
            }
        }
        return (String) invokeV.objValue;
    }

    private boolean isActived() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            try {
                String channelByShare = getChannelByShare();
                if (channelByShare == null) {
                    String channelyFile = getChannelyFile();
                    if (channelyFile != null && channelyFile.length() > 0) {
                        saveChannelToShare(channelyFile);
                        return true;
                    }
                    saveChannelToShare("aishide");
                    saveChannelToFile("aishide");
                    return false;
                }
                saveChannelToFile(channelByShare);
                return true;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    private void saveChannelToFile(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, str) == null) || str == null || str.length() <= 0) {
            return;
        }
        try {
            File CreateFile = FileHelper.CreateFile(TbConfig.CHANNEL_FILE);
            if (CreateFile != null) {
                FileWriter fileWriter = new FileWriter(CreateFile);
                fileWriter.append((CharSequence) str);
                fileWriter.flush();
                fileWriter.close();
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            TiebaStatic.file(e2, "TiebaActiveService.saveChannelToFile");
        }
    }

    private void saveChannelToShare(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, this, str) == null) || str == null || str.length() <= 0) {
            return;
        }
        d.a.o0.r.d0.b.j().x("channel_id", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendActive() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            b bVar = this.mActiveTask;
            if (bVar != null) {
                bVar.cancel();
            }
            b bVar2 = new b(this, null);
            this.mActiveTask = bVar2;
            bVar2.execute(new String[0]);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b bVar = this.mActiveTask;
            if (bVar != null) {
                bVar.cancel();
            }
            this.mHaveRetry = 11;
            this.mHandler.removeCallbacks(this.mRunnable);
            super.onDestroy();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, intent, i2) == null) {
            super.onStart(intent, i2);
            if (isActived() && d.a.o0.r.d0.b.j().k("active", 2) != 1) {
                stopSelf();
            } else {
                sendActive();
            }
        }
    }
}
