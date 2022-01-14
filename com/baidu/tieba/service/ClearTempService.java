package com.baidu.tieba.service;

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Date;
/* loaded from: classes12.dex */
public class ClearTempService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DELETE_FILE_COUNT = 300;
    public static final int MAX_FILE_COUNT = 500;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler handler;
    public volatile boolean interrupted;
    public Thread thread;

    /* loaded from: classes12.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ClearTempService a;

        public a(ClearTempService clearTempService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {clearTempService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = clearTempService;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                this.a.stopSelf();
                this.a.thread = null;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ClearTempService f47753e;

        public b(ClearTempService clearTempService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {clearTempService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47753e = clearTempService;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.run();
                try {
                    File file = new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/image");
                    File file2 = new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/share");
                    File file3 = new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/voice");
                    File file4 = new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_ALA_IM_RECORD_DIR_NAME);
                    this.f47753e.deleteCache(file, false);
                    this.f47753e.deleteDir(file2);
                    this.f47753e.deleteDir(file3);
                    this.f47753e.deleteDir(file4);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                this.f47753e.handler.sendMessage(this.f47753e.handler.obtainMessage());
            }
        }
    }

    public ClearTempService() {
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
        this.interrupted = false;
        this.thread = null;
        this.handler = new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteCache(File file, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65541, this, file, z) == null) {
            try {
                File[] listFiles = file.listFiles();
                long time = new Date().getTime();
                int length = listFiles.length > 500 ? listFiles.length - 300 : 0;
                if (listFiles != null) {
                    for (int i2 = 0; i2 < listFiles.length && !this.interrupted; i2++) {
                        File file2 = listFiles[i2];
                        if (file2.isDirectory()) {
                            deleteCache(file2, false);
                        } else if (length > 0 && i2 < length) {
                            file2.delete();
                        } else if (time - listFiles[i2].lastModified() > 259200000) {
                            file2.delete();
                        }
                    }
                }
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
                if (z) {
                    return;
                }
                deleteImageCacheByName();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteDir(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, file) == null) {
            try {
                File[] listFiles = file.listFiles();
                long time = new Date().getTime();
                if (listFiles != null) {
                    for (int i2 = 0; i2 < listFiles.length && !this.interrupted; i2++) {
                        if (time - listFiles[i2].lastModified() > 259200000) {
                            listFiles[i2].delete();
                        }
                    }
                }
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    private void deleteImageCacheByName() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            String str = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/image";
            for (int i2 = 0; i2 < 20; i2++) {
                File file = new File(str + "/" + i2);
                if (file.exists() && file.isDirectory()) {
                    deleteCache(file, true);
                }
            }
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
            super.onDestroy();
            this.interrupted = true;
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, intent, i2) == null) {
            super.onStart(intent, i2);
            this.interrupted = false;
            try {
                if (this.thread == null) {
                    b bVar = new b(this);
                    this.thread = bVar;
                    bVar.start();
                }
            } catch (OutOfMemoryError e2) {
                System.gc();
                BdLog.e(e2.getMessage());
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }
}
