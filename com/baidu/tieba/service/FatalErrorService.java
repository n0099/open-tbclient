package com.baidu.tieba.service;

import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ei;
import com.baidu.tieba.f55;
import com.baidu.tieba.ji;
import com.baidu.tieba.ki;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes6.dex */
public class FatalErrorService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ERROR_TYPE_KEY = "errortype";
    public static final String ERROR_TYPE_NATIVE_C = "4";
    public static final String ERROR_TYPE_UNKNOW = "0";
    public static final int NATIVE_CRASH_DUMP_MIN_SIZE = 1024;
    public transient /* synthetic */ FieldHolder $fh;
    public a mTask;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Intent a;
        public NetWork b;
        public final /* synthetic */ FatalErrorService c;

        public a(FatalErrorService fatalErrorService, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fatalErrorService, intent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fatalErrorService;
            this.b = null;
            this.a = intent;
        }

        public final void b(FileWriter fileWriter, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, fileWriter, str, str2) == null) {
                try {
                    fileWriter.append((CharSequence) str);
                    if (str2 != null) {
                        fileWriter.append("=");
                        fileWriter.append((CharSequence) str2);
                    }
                    fileWriter.append("\n");
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }

        public final void c(File file) {
            FileWriter fileWriter;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) && file != null && file.exists() && file.isFile() && this.a != null) {
                FileWriter fileWriter2 = null;
                try {
                    try {
                        fileWriter = new FileWriter(file, true);
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileWriter.append("\n##TIEBA_NATIVE##\n");
                    b(fileWriter, StringHelper.getCurrentString(), null);
                    b(fileWriter, "version", TbConfig.getVersion());
                    b(fileWriter, "model", ki.g());
                    b(fileWriter, "android_version", ki.k());
                    b(fileWriter, MapController.ANDROID_SDK_LAYER_TAG, String.valueOf(Build.VERSION.SDK_INT));
                    b(fileWriter, "from", TbConfig.getFrom());
                    b(fileWriter, "current_from", TbConfig.getCurrentFrom());
                    b(fileWriter, "uid", this.a.getStringExtra("uid"));
                    b(fileWriter, "client_id", TbadkCoreApplication.getClientId());
                    b(fileWriter, "imei", TbadkCoreApplication.getInst().getImei());
                    b(fileWriter, "uname", this.a.getStringExtra("uname"));
                    fileWriter.append("\n##TIEBA_NATIVE_END##\n");
                    ji.h(fileWriter);
                } catch (Exception e2) {
                    e = e2;
                    fileWriter2 = fileWriter;
                    e.printStackTrace();
                    ji.h(fileWriter2);
                } catch (Throwable th2) {
                    th = th2;
                    fileWriter2 = fileWriter;
                    ji.h(fileWriter2);
                    throw th;
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                NetWork netWork = this.b;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.c.mTask = null;
                super.cancel(true);
                this.c.stopSelf();
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x0026 */
        /* JADX WARN: Type inference failed for: r0v13, types: [boolean] */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v15 */
        public final void d(File file) {
            BufferedReader bufferedReader;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, file) == null) {
                BufferedReader bufferedReader2 = null;
                try {
                    try {
                        try {
                            bufferedReader = new BufferedReader(new FileReader(file));
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Exception e) {
                        e = e;
                    }
                    try {
                        String readLine = bufferedReader.readLine();
                        while (readLine != null) {
                            ?? startsWith = readLine.startsWith("crash_type=");
                            if (startsWith != 0) {
                                startsWith = 10;
                                TiebaStatic.crash(readLine.substring(10));
                            }
                            readLine = bufferedReader.readLine();
                            bufferedReader2 = startsWith;
                        }
                        bufferedReader.close();
                    } catch (Exception e2) {
                        e = e2;
                        bufferedReader2 = bufferedReader;
                        BdLog.e(e.toString());
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (Exception e3) {
                                BdLog.e(e3.toString());
                            }
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    BdLog.e(e4.toString());
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            boolean z;
            File[] listFiles;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, strArr)) == null) {
                try {
                    e(FileHelper.GetFileByAbsolutePath(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.FATAL_ERROR_FILE), TbConfig.ERROR_UPLOAD_SERVER, "0", true, true);
                    e(FileHelper.GetFileByAbsolutePath(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.LOG_ERROR_FILE), "c/s/clientlog", "0", false, false);
                    f();
                    if (TbConfig.getVersion().equals(f55.m().s("native_crash_dump_version", ""))) {
                        z = true;
                    } else {
                        f55.m().B("native_crash_dump_version", TbConfig.getVersion());
                        z = false;
                    }
                    File GetFile = FileHelper.GetFile(TbConfig.FATAL_ERROR_NATIVE_DIR);
                    if (GetFile != null && (listFiles = GetFile.listFiles()) != null) {
                        for (File file : listFiles) {
                            if (file != null) {
                                if (file.length() >= 1024 && z) {
                                    c(file);
                                    e(file, TbConfig.ERROR_UPLOAD_SERVER, "4", true, true);
                                } else {
                                    file.delete();
                                }
                            }
                        }
                        return null;
                    }
                    return null;
                } catch (Exception e) {
                    BdLog.e(e.toString());
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:74:0x00fe */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:119:0x010f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:125:0x0101 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:131:0x011d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.io.ByteArrayOutputStream, java.io.FileWriter, java.io.FileInputStream] */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.io.ByteArrayOutputStream] */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.io.ByteArrayOutputStream] */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void e(File file, String str, String str2, boolean z, boolean z2) {
            FileWriter fileWriter;
            FileInputStream fileInputStream;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{file, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                ?? r0 = 0;
                r0 = 0;
                r0 = 0;
                r0 = 0;
                r0 = 0;
                r0 = 0;
                try {
                    if (file != null) {
                        try {
                            if (file.length() > 50) {
                                fileInputStream = new FileInputStream(file);
                                try {
                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                                    try {
                                        if (z) {
                                            ei.a(fileInputStream, byteArrayOutputStream);
                                        } else {
                                            byte[] bArr = new byte[1024];
                                            while (true) {
                                                int read = fileInputStream.read(bArr, 0, 1024);
                                                if (read == -1) {
                                                    break;
                                                }
                                                byteArrayOutputStream.write(bArr, 0, read);
                                            }
                                            byteArrayOutputStream.flush();
                                        }
                                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                                        if (byteArray == null) {
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception e) {
                                                BdLog.e(e.getMessage());
                                            }
                                            try {
                                                fileInputStream.close();
                                                return;
                                            } catch (Exception e2) {
                                                BdLog.e(e2.getMessage());
                                                return;
                                            }
                                        }
                                        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + str);
                                        this.b = netWork;
                                        netWork.addPostData("logfile", byteArray);
                                        if (!TextUtils.isEmpty(str2) && !"0".equals(str2)) {
                                            this.b.addPostData(FatalErrorService.ERROR_TYPE_KEY, str2);
                                        }
                                        this.b.postMultiNetData();
                                        byteArrayOutputStream.close();
                                        fileInputStream.close();
                                        if (this.b.getNetContext().getResponse().isRequestSuccess()) {
                                            if (z2) {
                                                d(file);
                                            }
                                            fileWriter = new FileWriter(file, false);
                                            try {
                                                fileWriter.append((CharSequence) "");
                                                fileWriter.flush();
                                                fileWriter.close();
                                                file.delete();
                                            } catch (Exception e3) {
                                                e = e3;
                                                fileInputStream = null;
                                                try {
                                                    BdLog.e(e.getMessage());
                                                    if (r0 != 0) {
                                                        try {
                                                            r0.close();
                                                        } catch (Exception e4) {
                                                            BdLog.e(e4.getMessage());
                                                        }
                                                    }
                                                    if (fileInputStream != null) {
                                                        try {
                                                            fileInputStream.close();
                                                        } catch (Exception e5) {
                                                            BdLog.e(e5.getMessage());
                                                        }
                                                    }
                                                    if (fileWriter != null) {
                                                        fileWriter.close();
                                                    }
                                                    return;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    if (r0 != 0) {
                                                        try {
                                                            r0.close();
                                                        } catch (Exception e6) {
                                                            BdLog.e(e6.getMessage());
                                                        }
                                                    }
                                                    if (fileInputStream != null) {
                                                        try {
                                                            fileInputStream.close();
                                                        } catch (Exception e7) {
                                                            BdLog.e(e7.getMessage());
                                                        }
                                                    }
                                                    if (fileWriter != null) {
                                                        try {
                                                            fileWriter.close();
                                                        } catch (Exception e8) {
                                                            BdLog.e(e8.getMessage());
                                                        }
                                                    }
                                                    throw th;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                fileInputStream = null;
                                                if (r0 != 0) {
                                                }
                                                if (fileInputStream != null) {
                                                }
                                                if (fileWriter != null) {
                                                }
                                                throw th;
                                            }
                                        }
                                    } catch (Exception e9) {
                                        e = e9;
                                        fileWriter = null;
                                        r0 = byteArrayOutputStream;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        fileWriter = null;
                                        r0 = byteArrayOutputStream;
                                    }
                                } catch (Exception e10) {
                                    e = e10;
                                    fileWriter = null;
                                } catch (Throwable th4) {
                                    th = th4;
                                    fileWriter = null;
                                }
                            }
                        } catch (Exception e11) {
                            e = e11;
                            fileWriter = null;
                            fileInputStream = null;
                        } catch (Throwable th5) {
                            th = th5;
                            fileWriter = null;
                            fileInputStream = null;
                        }
                    }
                    if (0 != 0) {
                        try {
                            r0.close();
                        } catch (Exception e12) {
                            BdLog.e(e12.getMessage());
                        }
                    }
                    if (0 != 0) {
                        try {
                            r0.close();
                        } catch (Exception e13) {
                            BdLog.e(e13.getMessage());
                        }
                    }
                    if (0 != 0) {
                        r0.close();
                    }
                } catch (Exception e14) {
                    BdLog.e(e14.getMessage());
                }
            }
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                File GetFileByAbsolutePath = FileHelper.GetFileByAbsolutePath(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.FATAL_ERROR_ALERT_FILE);
                if (GetFileByAbsolutePath == null) {
                    return;
                }
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(GetFileByAbsolutePath)));
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            stringBuffer.append(readLine);
                        } else {
                            String stringBuffer2 = stringBuffer.toString();
                            BdLog.i("sendLogForAlert log = " + stringBuffer2);
                            BdStatisticsManager.getInstance().alert("alert_crash", stringBuffer2);
                            GetFileByAbsolutePath.delete();
                            return;
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                super.onPostExecute((a) str);
                this.c.mTask = null;
                this.c.stopSelf();
            }
        }
    }

    public FatalErrorService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTask = null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDestroy();
            a aVar = this.mTask;
            if (aVar != null) {
                aVar.cancel();
            }
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, intent, i) == null) {
            super.onStart(intent, i);
            if (this.mTask == null) {
                a aVar = new a(this, intent);
                this.mTask = aVar;
                aVar.execute(new String[0]);
            }
        }
    }
}
