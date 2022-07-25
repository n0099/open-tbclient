package com.baidu.tieba.service;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.utils.Constant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pi;
import com.repackage.vj5;
import java.io.File;
/* loaded from: classes4.dex */
public class TiebaUpdateService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INSTALL_DELAY = 300;
    public static final long MAX_WAIT_MILLS = 20000;
    public static final int MSG_DOWNLOAD_PROCESS = 0;
    public static final int MSG_MAIN_APK_EXIST = 1;
    public static final int MSG_OTHER_APK_EXIST = 2;
    public static final int MSG_SHOW_ERROR_TOAST = 3;
    public static boolean sHasStart;
    public transient /* synthetic */ FieldHolder $fh;
    public String info;
    public b mDowndMainApkTask;
    public c mDowndOtherApkTask;
    public boolean mHasAs;
    public boolean mHasOther;
    public boolean mHasTieba;
    public boolean mIsMainApkDone;
    public long mMainApkCurSize;
    public String mMainApkFileName;
    public final Handler mMainApkHandler;
    public boolean mMainApkInstallEnable;
    public String mMainApkMd5RSA;
    public long mMainApkSize;
    public String mMainApkUrl;
    public long mMainTaskWaitingTimestamp;
    public long mOtherApkCurSize;
    public String mOtherApkFileName;
    public final Handler mOtherApkHandler;
    public String mOtherApkMd5RSA;
    public long mOtherApkSize;
    public String mOtherApkUrl;
    public long mOtherTaskWaitingTimestamp;
    public int mProgressAfter;
    public int mProgressBefore;
    public VersionData mVersionData;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<String, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public volatile boolean b;
        public final /* synthetic */ TiebaUpdateService c;

        public b(TiebaUpdateService tiebaUpdateService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiebaUpdateService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tiebaUpdateService;
            this.b = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                Boolean bool = Boolean.FALSE;
                while (true) {
                    try {
                        if (!this.b) {
                            this.a = new NetWork(this.c.mMainApkUrl);
                            bool = Boolean.valueOf(this.a.downloadFile(FileHelper.CreateFileIfNotFound(this.c.mMainApkFileName + ".tmp").getAbsolutePath(), this.c.mMainApkHandler, 0, 5, 100, true));
                            if (!bool.booleanValue() && this.a.getServerErrorCode() != -2) {
                                if (!this.a.getNetContext().getResponse().isFileSegSuccess()) {
                                    try {
                                        Thread.sleep(10000L);
                                    } catch (Exception unused) {
                                    }
                                }
                                if (TiebaUpdateService.sHasStart && System.currentTimeMillis() - this.c.mMainTaskWaitingTimestamp > 20000) {
                                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.UPDATE_TIEFA_DOWNLOAD_FAILED).param("obj_param1", this.a.getErrorString()));
                                    this.c.downloadError();
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                }
                if (bool.booleanValue()) {
                    if (!vj5.a(this.c.mMainApkMd5RSA, FileHelper.GetFile(this.c.mMainApkFileName + ".tmp"))) {
                        bool = Boolean.FALSE;
                        FileHelper.DelFile(this.c.mMainApkFileName + ".tmp");
                        FileHelper.DelFile(this.c.mMainApkFileName);
                    }
                    this.c.renameFile(this.c.mMainApkFileName);
                }
                return bool;
            }
            return (Boolean) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.cancel(true);
                this.c.mDowndMainApkTask = null;
                this.b = true;
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bool) == null) {
                super.onPostExecute((b) bool);
                this.c.mDowndMainApkTask = null;
                try {
                    if (bool.booleanValue()) {
                        this.c.mIsMainApkDone = true;
                        this.c.mMainApkHandler.sendMessageDelayed(this.c.mMainApkHandler.obtainMessage(1, this.c.mMainApkFileName), 300L);
                        return;
                    }
                    this.c.downloadError();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }

        public /* synthetic */ b(TiebaUpdateService tiebaUpdateService, a aVar) {
            this(tiebaUpdateService);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask<String, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public volatile boolean b;
        public final /* synthetic */ TiebaUpdateService c;

        public c(TiebaUpdateService tiebaUpdateService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiebaUpdateService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tiebaUpdateService;
            this.a = null;
            this.b = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                Boolean bool = Boolean.FALSE;
                while (true) {
                    try {
                        if (!this.b) {
                            NetWork netWork = new NetWork(this.c.mOtherApkUrl);
                            this.a = netWork;
                            bool = Boolean.valueOf(netWork.downloadFile(this.c.mOtherApkFileName + ".tmp", this.c.mOtherApkHandler, 0));
                            if (bool.booleanValue() || this.a.getServerErrorCode() == -2) {
                                break;
                            }
                            if (!this.a.getNetContext().getResponse().isFileSegSuccess()) {
                                try {
                                    Thread.sleep(10000L);
                                } catch (Exception unused) {
                                }
                            }
                            if (TiebaUpdateService.sHasStart && System.currentTimeMillis() - this.c.mOtherTaskWaitingTimestamp > 20000) {
                                if ((this.c.mHasTieba || this.c.mHasAs) && this.c.mIsMainApkDone) {
                                    this.c.downloadError();
                                }
                            }
                        } else {
                            break;
                        }
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                }
                if (bool.booleanValue()) {
                    if (!vj5.a(this.c.mOtherApkMd5RSA, FileHelper.GetFile(this.c.mOtherApkFileName + ".tmp"))) {
                        bool = Boolean.FALSE;
                        FileHelper.DelFile(this.c.mOtherApkFileName + ".tmp");
                        FileHelper.DelFile(this.c.mOtherApkFileName);
                    }
                    this.c.renameFile(this.c.mOtherApkFileName);
                }
                return bool;
            }
            return (Boolean) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.cancel(true);
                this.c.mDowndOtherApkTask = null;
                this.b = true;
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                if (this.c.mHasTieba || this.c.mHasAs) {
                    return;
                }
                boolean unused = TiebaUpdateService.sHasStart = false;
                this.c.stopSelf();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bool) == null) {
                super.onPostExecute((c) bool);
                this.c.mDowndOtherApkTask = null;
                if (bool.booleanValue()) {
                    this.c.mOtherTaskWaitingTimestamp = System.currentTimeMillis();
                }
                if (this.c.mHasTieba || this.c.mHasAs) {
                    if (!this.c.mMainApkInstallEnable) {
                        this.c.mMainApkInstallEnable = true;
                    } else {
                        this.c.mOtherApkHandler.sendMessageDelayed(this.c.mOtherApkHandler.obtainMessage(2, null), 300L);
                    }
                } else {
                    boolean unused = TiebaUpdateService.sHasStart = false;
                    this.c.stopSelf();
                }
                if (bool.booleanValue()) {
                    return;
                }
                this.c.downloadError();
            }
        }

        public /* synthetic */ c(TiebaUpdateService tiebaUpdateService, a aVar) {
            this(tiebaUpdateService);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiebaUpdateService a;

        public d(TiebaUpdateService tiebaUpdateService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiebaUpdateService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tiebaUpdateService;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                int i = message.what;
                if (i != 0) {
                    if (i != 1) {
                        if (i == 3) {
                            pi.N(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f1481);
                        }
                    } else if (this.a.mMainApkInstallEnable) {
                        if (this.a.mHasAs) {
                            this.a.startAsInstallService();
                        }
                        UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), this.a.mMainApkFileName);
                        this.a.finishDownload();
                    } else {
                        this.a.mMainApkInstallEnable = true;
                    }
                } else if (message.arg2 > 0) {
                    this.a.mMainApkCurSize = message.arg1;
                    this.a.mMainApkSize = message.arg2;
                    if (this.a.mMainApkSize > this.a.mMainApkCurSize) {
                        this.a.mMainTaskWaitingTimestamp = System.currentTimeMillis();
                    }
                    if (this.a.mMainApkSize <= this.a.mMainApkCurSize) {
                        this.a.mIsMainApkDone = true;
                    }
                    int i2 = (int) ((this.a.mMainApkCurSize * 100) / this.a.mMainApkSize);
                    if (!this.a.mHasOther || this.a.mOtherApkSize == 0) {
                        if (!this.a.mHasOther || this.a.mOtherApkSize != 0) {
                            if (this.a.mHasOther) {
                                return;
                            }
                            TiebaUpdateService tiebaUpdateService = this.a;
                            tiebaUpdateService.updateProgress(tiebaUpdateService.mMainApkCurSize, this.a.mMainApkSize);
                            this.a.sendBroadcast(i2);
                            return;
                        }
                        if (i2 < 60) {
                            TiebaUpdateService tiebaUpdateService2 = this.a;
                            tiebaUpdateService2.updateProgress(tiebaUpdateService2.mMainApkCurSize, this.a.mMainApkSize);
                            this.a.sendBroadcast(i2);
                        }
                        this.a.mProgressBefore = i2;
                        return;
                    }
                    TiebaUpdateService tiebaUpdateService3 = this.a;
                    tiebaUpdateService3.mProgressAfter = (int) (((tiebaUpdateService3.mMainApkCurSize + this.a.mOtherApkCurSize) * 100) / (this.a.mMainApkSize + this.a.mOtherApkSize));
                    if (this.a.mProgressAfter > this.a.mProgressBefore) {
                        TiebaUpdateService tiebaUpdateService4 = this.a;
                        tiebaUpdateService4.updateProgress(tiebaUpdateService4.mMainApkCurSize + this.a.mOtherApkCurSize, this.a.mMainApkSize + this.a.mOtherApkSize);
                        TiebaUpdateService tiebaUpdateService5 = this.a;
                        tiebaUpdateService5.sendBroadcast(tiebaUpdateService5.mProgressAfter);
                        TiebaUpdateService tiebaUpdateService6 = this.a;
                        tiebaUpdateService6.mProgressBefore = tiebaUpdateService6.mProgressAfter;
                    }
                }
            }
        }

        public /* synthetic */ d(TiebaUpdateService tiebaUpdateService, a aVar) {
            this(tiebaUpdateService);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiebaUpdateService a;

        public e(TiebaUpdateService tiebaUpdateService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiebaUpdateService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tiebaUpdateService;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                int i = message.what;
                if (i != 0) {
                    if (i == 2) {
                        if (this.a.mHasTieba || this.a.mHasAs) {
                            if (!this.a.mMainApkInstallEnable) {
                                this.a.mMainApkInstallEnable = true;
                                return;
                            } else {
                                this.a.mMainApkHandler.sendMessageDelayed(this.a.mMainApkHandler.obtainMessage(1, null), 300L);
                                return;
                            }
                        }
                        this.a.finishDownload();
                    }
                } else if (message.arg2 > 0) {
                    this.a.mOtherApkCurSize = message.arg1;
                    this.a.mOtherApkSize = message.arg2;
                    if (this.a.mOtherApkSize > this.a.mOtherApkCurSize) {
                        this.a.mOtherTaskWaitingTimestamp = System.currentTimeMillis();
                    }
                    TiebaUpdateService tiebaUpdateService = this.a;
                    tiebaUpdateService.mProgressAfter = (int) (((tiebaUpdateService.mMainApkCurSize + this.a.mOtherApkCurSize) * 100) / (this.a.mMainApkSize + this.a.mOtherApkSize));
                    if (this.a.mHasOther) {
                        if ((this.a.mHasTieba || this.a.mHasAs) && this.a.mMainApkSize == this.a.mMainApkCurSize && this.a.mProgressAfter > this.a.mProgressBefore) {
                            TiebaUpdateService tiebaUpdateService2 = this.a;
                            tiebaUpdateService2.updateProgress(tiebaUpdateService2.mMainApkCurSize + this.a.mOtherApkCurSize, this.a.mMainApkSize + this.a.mOtherApkSize);
                            TiebaUpdateService tiebaUpdateService3 = this.a;
                            tiebaUpdateService3.sendBroadcast(tiebaUpdateService3.mProgressAfter);
                            TiebaUpdateService tiebaUpdateService4 = this.a;
                            tiebaUpdateService4.mProgressBefore = tiebaUpdateService4.mProgressAfter;
                        }
                    }
                }
            }
        }

        public /* synthetic */ e(TiebaUpdateService tiebaUpdateService, a aVar) {
            this(tiebaUpdateService);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1927417270, "Lcom/baidu/tieba/service/TiebaUpdateService;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1927417270, "Lcom/baidu/tieba/service/TiebaUpdateService;");
        }
    }

    public TiebaUpdateService() {
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
        this.mMainApkHandler = new d(this, null);
        this.mOtherApkHandler = new e(this, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            Handler handler = this.mMainApkHandler;
            handler.sendMessage(handler.obtainMessage(3));
            NotificationHelper.cancelNotification(this, 10);
            sHasStart = false;
            stopSelf();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void downloadMainApk(String str) {
        boolean z;
        File GetFile;
        PackageInfo packageArchiveInfo;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65579, this, str) != null) {
            return;
        }
        String fileDireciory = FileHelper.getFileDireciory(this.mMainApkFileName);
        if (fileDireciory != null && (packageArchiveInfo = getPackageManager().getPackageArchiveInfo(fileDireciory, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                GetFile = FileHelper.GetFile(this.mMainApkFileName);
                if (this.mHasAs ? !(GetFile != null && GetFile.exists() && z) : GetFile == null || !GetFile.exists()) {
                    Handler handler = this.mMainApkHandler;
                    handler.sendMessageDelayed(handler.obtainMessage(1, null), 300L);
                    return;
                }
                pi.N(this, R.string.obfuscated_res_0x7f0f04f1);
                if (GetFile != null) {
                    GetFile.delete();
                }
                if (this.mDowndMainApkTask == null) {
                    b bVar = new b(this, null);
                    this.mDowndMainApkTask = bVar;
                    bVar.execute(new String[0]);
                    this.info = str;
                    NotificationHelper.showProgressNotification(this, 10, null, 0, null, str, true);
                    return;
                }
                return;
            }
        }
        z = false;
        GetFile = FileHelper.GetFile(this.mMainApkFileName);
        if (this.mHasAs ? !(GetFile != null && GetFile.exists() && z) : GetFile == null || !GetFile.exists()) {
        }
    }

    private void downloadOtherApk() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, this) == null) {
            if (FileHelper.GetFile(this.mOtherApkFileName) != null) {
                this.mHasOther = false;
                Handler handler = this.mOtherApkHandler;
                handler.sendMessageDelayed(handler.obtainMessage(2, null), 300L);
            } else if (this.mDowndOtherApkTask == null) {
                this.mHasOther = true;
                c cVar = new c(this, null);
                this.mDowndOtherApkTask = cVar;
                cVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65581, this) == null) {
            sendBroadcast("action_update_complete", true);
            NotificationHelper.cancelNotification(this, 10);
            String str = this.mOtherApkFileName;
            if (str != null && str.length() > 4) {
                TbadkCoreApplication.getInst().setInstallOtherApp(this.mOtherApkFileName);
            }
            stopSelf();
        }
    }

    private String getFileOfUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.contains("?")) {
                str = str.substring(0, str.indexOf("?"));
            }
            String[] split = str.split("/");
            return split[split.length - 1];
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renameFile(String str) {
        File FileObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65583, this, str) == null) {
            FileHelper.DelFile(str);
            File GetFile = FileHelper.GetFile(str + ".tmp");
            if (GetFile == null || (FileObject = FileHelper.FileObject(str)) == null || GetFile.renameTo(FileObject)) {
                return;
            }
            TiebaStatic.file("renameTo erro", "TiebaUpdateService.DownLoadingOtherAsyncTask");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAsInstallService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65584, this) == null) {
            Intent intent = new Intent();
            intent.setClass(this, AsInstallService.class);
            VersionData versionData = this.mVersionData;
            if (versionData != null) {
                intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, versionData);
                startService(intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress(long j, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65585, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || j2 <= 0) {
            return;
        }
        int i = (int) ((100 * j) / j2);
        StringBuffer stringBuffer = new StringBuffer(20);
        stringBuffer.append(String.valueOf(j / 1000));
        stringBuffer.append("K/");
        stringBuffer.append(String.valueOf(j2 / 1000));
        stringBuffer.append("K");
        NotificationHelper.showProgressNotification(this, 10, null, i, i + "%", this.info, true);
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
            super.onDestroy();
            this.mMainApkHandler.removeMessages(0);
            this.mOtherApkHandler.removeMessages(0);
            b bVar = this.mDowndMainApkTask;
            if (bVar != null) {
                bVar.cancel();
            }
            c cVar = this.mDowndOtherApkTask;
            if (cVar != null) {
                cVar.cancel();
            }
            NotificationHelper.cancelNotification(this, 10);
            sHasStart = false;
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, intent, i) == null) || intent == null) {
            return;
        }
        if ("action_stop".equals(intent.getAction()) && (this.mHasTieba || this.mHasAs)) {
            stopSelf();
        } else if (sHasStart) {
            sendBroadcast("action_background_downloading", true);
        } else {
            sHasStart = true;
            this.mMainTaskWaitingTimestamp = System.currentTimeMillis();
            this.mOtherTaskWaitingTimestamp = System.currentTimeMillis();
            this.mMainApkUrl = intent.getStringExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL);
            this.mMainApkMd5RSA = intent.getStringExtra("MD5_RSA_tieba_apk");
            this.mVersionData = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
            if (URLUtil.isNetworkUrl(this.mMainApkUrl) && !TextUtils.isEmpty(this.mMainApkMd5RSA)) {
                this.mHasTieba = true;
                this.mMainApkFileName = getString(R.string.obfuscated_res_0x7f0f029e) + TbadkCoreApplication.getInst().getVersionName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX;
            } else {
                this.mMainApkMd5RSA = intent.getStringExtra("MD5_RSA_as_apk");
                String stringExtra = intent.getStringExtra(UpdateDialogConfig.KEY_AS_APK_URL);
                this.mMainApkUrl = stringExtra;
                if (URLUtil.isNetworkUrl(stringExtra) && !TextUtils.isEmpty(this.mMainApkMd5RSA)) {
                    this.mHasAs = true;
                    this.mMainApkFileName = getFileOfUrl(this.mMainApkUrl);
                }
            }
            this.mOtherApkUrl = intent.getStringExtra(UpdateDialogConfig.KEY_OTHER_APK_URL);
            this.mOtherApkMd5RSA = intent.getStringExtra("MD5_RSA_other_apk");
            this.mOtherApkFileName = getFileOfUrl(this.mOtherApkUrl);
            if (URLUtil.isNetworkUrl(this.mOtherApkUrl) && this.mOtherApkFileName.length() >= 4 && !TextUtils.isEmpty(this.mOtherApkMd5RSA)) {
                this.mHasOther = true;
            } else {
                this.mMainApkInstallEnable = true;
            }
            if (!this.mHasTieba && !this.mHasAs && !this.mHasOther) {
                stopSelf(i);
            } else if (!this.mHasTieba && !this.mHasAs) {
                this.info = getString(R.string.obfuscated_res_0x7f0f0508);
                downloadOtherApk();
            } else {
                if (this.mHasTieba) {
                    string = getString(R.string.obfuscated_res_0x7f0f13a4);
                } else {
                    string = getString(R.string.obfuscated_res_0x7f0f02a0);
                }
                downloadMainApk(string);
                if (this.mHasOther) {
                    downloadOtherApk();
                }
            }
        }
    }

    public void sendBroadcast(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            Intent intent = new Intent();
            intent.setAction(TbConfig.APP_UPDATE_ACTION);
            intent.putExtra("action_update_download_progress", i);
            intent.setPackage(getPackageName());
            sendBroadcast(intent);
        }
    }

    public void sendBroadcast(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) {
            Intent intent = new Intent();
            intent.setAction(TbConfig.APP_UPDATE_ACTION);
            intent.putExtra(str, z);
            intent.setPackage(getPackageName());
            sendBroadcast(intent);
        }
    }
}
