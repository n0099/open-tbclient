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
/* loaded from: classes5.dex */
public class ot7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements f65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ st7 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ tt7 c;

        @Override // com.baidu.tieba.f65
        public boolean onFileDownloaded(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.f65
        public boolean onPreDownload(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        /* renamed from: com.baidu.tieba.ot7$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0374a extends BdAsyncTask<Void, Void, Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DownloadData a;
            public final /* synthetic */ a b;

            public C0374a(a aVar, DownloadData downloadData) {
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
                    if (ot7.g(this.a.getPath(), this.b.c)) {
                        a aVar = this.b;
                        return Boolean.valueOf(ot7.f(aVar.c, aVar.b));
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

        public a(st7 st7Var, String str, tt7 tt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {st7Var, str, tt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = st7Var;
            this.b = str;
            this.c = tt7Var;
        }

        @Override // com.baidu.tieba.f65
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i, str) == null) {
                nt7.a("【表情下载】 onFileDownloadFailed = " + str);
                if (this.a != null) {
                    String str2 = "faile to download:";
                    if (downloadData != null && !TextUtils.isEmpty(downloadData.getUrl())) {
                        str2 = "faile to download:" + downloadData.getUrl();
                    }
                    this.a.onFail(str2);
                }
            }
        }

        @Override // com.baidu.tieba.f65
        public void onFileDownloadSucceed(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
                nt7.a("【表情下载】 onFileDownloadSucceed = " + this.b);
                new C0374a(this, downloadData).execute(new Void[0]);
            }
        }

        @Override // com.baidu.tieba.f65
        public void onFileUpdateProgress(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) {
                st7 st7Var = this.a;
                if (st7Var != null) {
                    st7Var.onProgress(downloadData.getProcess());
                }
                nt7.a("【表情下载】 onFileUpdateProgress = " + downloadData.getProcess());
            }
        }
    }

    public static void c(tt7 tt7Var, st7 st7Var) {
        List<ut7> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, tt7Var, st7Var) == null) {
            if (tt7Var != null && (list = tt7Var.e) != null && list.size() != 0 && !TextUtils.isEmpty(tt7Var.d)) {
                nt7.a("【表情下载】 url = " + tt7Var.d);
                a aVar = new a(st7Var, pt7.c + tt7Var.a + "/", tt7Var);
                new File(pt7.c).mkdirs();
                d(tt7Var, pt7.c, aVar);
                return;
            }
            if (st7Var != null) {
                st7Var.onFail("group data null");
            }
            nt7.a("【表情下载】 fail = 参数异常");
        }
    }

    public static void d(tt7 tt7Var, String str, f65 f65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, tt7Var, str, f65Var) == null) {
            if (tt7Var != null && !TextUtils.isEmpty(tt7Var.d)) {
                String str2 = tt7Var.a + ".zip";
                DownloadData downloadData = new DownloadData(tt7Var.a, str2, Uri.encode(tt7Var.d, "-![.:/,%?&=]"), f65Var);
                downloadData.setPath(str + str2);
                g65.k().l(downloadData);
            } else if (f65Var != null) {
                f65Var.onFileDownloadFailed(null, 0, ADConfigError.REASON_NULL_DATA);
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

    public static boolean f(tt7 tt7Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, tt7Var, str)) == null) {
            File file = new File(str + "panel.png");
            File file2 = new File(str + "panel_momo.png");
            if (file.exists() && file2.exists()) {
                nt7.a("【表情下载】 savePanelImage");
                return true;
            }
            if (!new File(str + tt7Var.c).exists()) {
                return false;
            }
            Bitmap bitmap = null;
            try {
                bitmap = BitmapFactory.decodeFile(str + tt7Var.c);
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
            nt7.a("【表情下载】 savePanelImage = " + tt7Var.c);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean g(String str, tt7 tt7Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, tt7Var)) == null) {
            ZipInputStream zipInputStream = null;
            try {
                try {
                    ZipInputStream zipInputStream2 = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
                    while (true) {
                        try {
                            ZipEntry nextEntry = zipInputStream2.getNextEntry();
                            if (nextEntry != null) {
                                if (!nextEntry.isDirectory()) {
                                    String str2 = ".emotions/" + tt7Var.a;
                                    String str3 = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + str2 + "/" + nextEntry.getName();
                                    FileHelper.saveFileByStream(str3, zipInputStream2);
                                    nt7.a("【表情下载】 unZipEmotion = " + str3);
                                }
                            } else {
                                zipInputStream2.close();
                                FileHelper.deleteFile(new File(str));
                                zi.e(zipInputStream2);
                                return true;
                            }
                        } catch (FileNotFoundException e) {
                            e = e;
                            zipInputStream = zipInputStream2;
                            e.printStackTrace();
                            zi.e(zipInputStream);
                            return false;
                        } catch (IOException e2) {
                            e = e2;
                            zipInputStream = zipInputStream2;
                            e.printStackTrace();
                            zi.e(zipInputStream);
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            zipInputStream = zipInputStream2;
                            zi.e(zipInputStream);
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
