package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes7.dex */
public class mn9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements md5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qn9 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ rn9 c;

        @Override // com.baidu.tieba.md5
        public boolean onFileDownloaded(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.md5
        public boolean onPreDownload(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        /* renamed from: com.baidu.tieba.mn9$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0386a extends BdAsyncTask<Void, Void, Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DownloadData a;
            public final /* synthetic */ a b;

            public C0386a(a aVar, DownloadData downloadData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, downloadData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = downloadData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                    FileHelper.deleteFileOrDir(new File(this.b.b));
                    if (mn9.g(this.a.getPath(), this.b.c)) {
                        a aVar = this.b;
                        return Boolean.valueOf(mn9.f(aVar.c, aVar.b));
                    }
                    return Boolean.FALSE;
                }
                return (Boolean) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public void onPostExecute(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) == null) {
                    if (bool.booleanValue()) {
                        a aVar = this.b;
                        aVar.a.onSuccess(aVar.b);
                        return;
                    }
                    this.b.a.onFail("fail to download");
                }
            }
        }

        public a(qn9 qn9Var, String str, rn9 rn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qn9Var, str, rn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qn9Var;
            this.b = str;
            this.c = rn9Var;
        }

        @Override // com.baidu.tieba.md5
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i, str) == null) {
                ln9.a("【表情下载】 onFileDownloadFailed = " + str);
                if (this.a != null) {
                    String str2 = "faile to download:";
                    if (downloadData != null && !TextUtils.isEmpty(downloadData.getUrl())) {
                        str2 = "faile to download:" + downloadData.getUrl();
                    }
                    this.a.onFail(str2);
                }
            }
        }

        @Override // com.baidu.tieba.md5
        public void onFileDownloadSucceed(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
                ln9.a("【表情下载】 onFileDownloadSucceed = " + this.b);
                new C0386a(this, downloadData).execute(new Void[0]);
            }
        }

        @Override // com.baidu.tieba.md5
        public void onFileUpdateProgress(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) {
                qn9 qn9Var = this.a;
                if (qn9Var != null) {
                    qn9Var.onProgress(downloadData.getProcess());
                }
                ln9.a("【表情下载】 onFileUpdateProgress = " + downloadData.getProcess());
            }
        }
    }

    public static void c(rn9 rn9Var, qn9 qn9Var) {
        List<sn9> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, rn9Var, qn9Var) == null) {
            if (rn9Var != null && (list = rn9Var.e) != null && list.size() != 0 && !TextUtils.isEmpty(rn9Var.d)) {
                ln9.a("【表情下载】 url = " + rn9Var.d);
                a aVar = new a(qn9Var, nn9.c + rn9Var.a + "/", rn9Var);
                new File(nn9.c).mkdirs();
                d(rn9Var, nn9.c, aVar);
                return;
            }
            if (qn9Var != null) {
                qn9Var.onFail("group data null");
            }
            ln9.a("【表情下载】 fail = 参数异常");
        }
    }

    public static void d(rn9 rn9Var, String str, md5 md5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, rn9Var, str, md5Var) == null) {
            if (rn9Var != null && !TextUtils.isEmpty(rn9Var.d)) {
                String str2 = rn9Var.a + ".zip";
                DownloadData downloadData = new DownloadData(rn9Var.a, str2, Uri.encode(rn9Var.d, "-![.:/,%?&=]"), md5Var);
                downloadData.setPath(str + str2);
                nd5.k().l(downloadData);
            } else if (md5Var != null) {
                md5Var.onFileDownloadFailed(null, 0, ADConfigError.REASON_NULL_DATA);
            }
        }
    }

    public static String e(String str, String str2, Bitmap bitmap, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, bitmap, i)) == null) {
            if (bitmap != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                File file = new File(str + str2);
                try {
                    if ((file.exists() && !file.delete()) || !file.createNewFile()) {
                        return null;
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.PNG, i, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return file.getPath();
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (String) invokeLLLI.objValue;
    }

    public static boolean f(rn9 rn9Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, rn9Var, str)) == null) {
            File file = new File(str + "panel.png");
            File file2 = new File(str + "panel_momo.png");
            if (file.exists() && file2.exists()) {
                ln9.a("【表情下载】 savePanelImage");
                return true;
            }
            if (!new File(str + rn9Var.c).exists()) {
                return false;
            }
            Bitmap bitmap = null;
            try {
                bitmap = BitmapFactory.decodeFile(str + rn9Var.c);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
            if (bitmap == null) {
                return false;
            }
            if (!file.exists() && TextUtils.isEmpty(e(str, "panel.png", bitmap, 60))) {
                return false;
            }
            if (!file2.exists() && TextUtils.isEmpty(e(str, "panel_momo.png", bitmap, 60))) {
                return false;
            }
            ln9.a("【表情下载】 savePanelImage = " + rn9Var.c);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean g(String str, rn9 rn9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, rn9Var)) == null) {
            ZipInputStream zipInputStream = null;
            try {
                try {
                    ZipInputStream zipInputStream2 = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
                    while (true) {
                        try {
                            ZipEntry nextEntry = zipInputStream2.getNextEntry();
                            if (nextEntry != null) {
                                if (!nextEntry.isDirectory()) {
                                    String str2 = ".emotions/" + rn9Var.a;
                                    String str3 = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + str2 + "/" + nextEntry.getName();
                                    FileHelper.saveFileByStream(str3, zipInputStream2);
                                    ln9.a("【表情下载】 unZipEmotion = " + str3);
                                }
                            } else {
                                zipInputStream2.close();
                                FileHelper.deleteFile(new File(str));
                                rd.e(zipInputStream2);
                                return true;
                            }
                        } catch (FileNotFoundException e) {
                            e = e;
                            zipInputStream = zipInputStream2;
                            e.printStackTrace();
                            rd.e(zipInputStream);
                            return false;
                        } catch (IOException e2) {
                            e = e2;
                            zipInputStream = zipInputStream2;
                            e.printStackTrace();
                            rd.e(zipInputStream);
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            zipInputStream = zipInputStream2;
                            rd.e(zipInputStream);
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
            } catch (IOException e4) {
                e = e4;
            }
        } else {
            return invokeLL.booleanValue;
        }
    }
}
