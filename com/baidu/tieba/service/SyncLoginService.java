package com.baidu.tieba.service;

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.ki;
import com.baidu.tieba.kx8;
import com.baidu.tieba.n05;
import com.baidu.tieba.ne5;
import com.baidu.tieba.ok9;
import com.baidu.tieba.vi;
import com.baidu.tieba.xi;
import com.baidu.tieba.z46;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* loaded from: classes7.dex */
public class SyncLoginService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic;
    public static String mStatistics;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler mHandler;
    public Runnable mRunnable;
    public b mSyncTask;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(384715980, "Lcom/baidu/tieba/service/SyncLoginService;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(384715980, "Lcom/baidu/tieba/service/SyncLoginService;");
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

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SyncLoginService a;

        public a(SyncLoginService syncLoginService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {syncLoginService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = syncLoginService;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.checkPassV6Switch();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<String, Integer, kx8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public final /* synthetic */ SyncLoginService b;

        public b(SyncLoginService syncLoginService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {syncLoginService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = syncLoginService;
            this.a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(kx8 kx8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kx8Var) == null) {
                super.onPostExecute(kx8Var);
                this.b.mSyncTask = null;
            }
        }

        public /* synthetic */ b(SyncLoginService syncLoginService, a aVar) {
            this(syncLoginService);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public kx8 doInBackground(String... strArr) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                kx8 kx8Var = null;
                try {
                    this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/switch");
                    if (ok9.b()) {
                        this.a.addPostData(HttpRequest.OS_VERSION, xi.k());
                    } else {
                        this.a.addPostData(HttpRequest.NEED_DECRYPT, ok9.c());
                        String g = ok9.g(HttpRequest.OS_VERSION);
                        if (!TextUtils.isEmpty(g)) {
                            this.a.addPostData(g, ok9.j());
                        }
                    }
                    StringBuffer stringBuffer = new StringBuffer(15);
                    stringBuffer.append(String.valueOf(vi.l(TbadkCoreApplication.getInst().getApp())));
                    stringBuffer.append(",");
                    stringBuffer.append(String.valueOf(vi.j(TbadkCoreApplication.getInst().getApp())));
                    this.a.addPostData("_phone_screen", stringBuffer.toString());
                    this.a.addPostData("scr_w", String.valueOf(vi.l(TbadkCoreApplication.getInst().getApp())));
                    this.a.addPostData("scr_h", String.valueOf(vi.j(TbadkCoreApplication.getInst().getApp())));
                    this.a.addPostData("scr_dip", String.valueOf(vi.i(TbadkCoreApplication.getInst().getApp())));
                    String str2 = "0";
                    if (ne5.d().f() > 0) {
                        this.a.addPostData("_msg_status", "0");
                    } else {
                        this.a.addPostData("_msg_status", "1");
                    }
                    String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                    if (activeVersion != null) {
                        if (activeVersion.length() >= 1) {
                            str2 = activeVersion;
                        }
                        this.a.addPostData("_active", str2);
                    }
                    this.a.addPostData("_pic_quality", String.valueOf(n05.c().e()));
                    if (SyncLoginService.mStatistics != null) {
                        this.a.addPostData("_msg_type", SyncLoginService.mStatistics);
                    }
                    String packageName = TbadkCoreApplication.getInst().getPackageName();
                    this.a.addPostData("package", packageName);
                    int versionCode = TbadkCoreApplication.getInst().getVersionCode();
                    NetWork netWork = this.a;
                    netWork.addPostData("versioncode", versionCode + "");
                    this.a.addPostData("signmd5", TbMd5.getAPKMd5(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                    this.a.addPostData(PackageTable.MD5, z46.a());
                    NetWork netWork2 = this.a;
                    String str3 = "64";
                    if (ki.a()) {
                        str = "64";
                    } else {
                        str = PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK;
                    }
                    netWork2.addPostData("running_abi", str);
                    NetWork netWork3 = this.a;
                    if (!ki.b()) {
                        str3 = PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK;
                    }
                    netWork3.addPostData("support_abi", str3);
                    String postNetData = this.a.postNetData();
                    if (!this.a.getNetContext().getResponse().isRequestSuccess()) {
                        return null;
                    }
                    kx8 kx8Var2 = new kx8();
                    try {
                        kx8Var2.a(postNetData);
                        String unused = SyncLoginService.mStatistics = null;
                        return kx8Var2;
                    } catch (Exception e) {
                        e = e;
                        kx8Var = kx8Var2;
                        BdLog.e(e.getMessage());
                        return kx8Var;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } else {
                return (kx8) invokeL.objValue;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.b.mSyncTask = null;
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                super.cancel(true);
            }
        }
    }

    public SyncLoginService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSyncTask = null;
        this.mHandler = new Handler();
        this.mRunnable = new a(this);
    }

    public static void setMsgType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            mStatistics = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPassV6Switch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            b bVar = this.mSyncTask;
            if (bVar != null) {
                bVar.cancel();
            }
            b bVar2 = new b(this, null);
            this.mSyncTask = bVar2;
            bVar2.execute(new String[0]);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b bVar = this.mSyncTask;
            if (bVar != null) {
                bVar.cancel();
            }
            this.mHandler.removeCallbacks(this.mRunnable);
            super.onDestroy();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, intent, i) == null) {
            super.onStart(intent, i);
            checkPassV6Switch();
        }
    }
}
