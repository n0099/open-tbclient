package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/* loaded from: classes6.dex */
public class izb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public File a;
        @NonNull
        public String b;

        public a(@NonNull File file, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = file;
            if (TextUtils.isEmpty(str)) {
                this.b = this.a.getName();
            } else {
                this.b = str;
            }
        }

        public a(@NonNull File file, @NonNull String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = file;
            if (TextUtils.isEmpty(str)) {
                this.b = this.a.getName();
            } else {
                this.b = str;
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x007d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:0x009c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.titan.sdk.runtime.Interceptable] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0098 -> B:72:0x009b). Please submit an issue!!! */
    public static void a(File file, List<a> list) throws IOException {
        ?? r2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r2 = interceptable;
            if (r2.invokeLL(65536, null, file, list) != null) {
                return;
            }
        }
        if (file != null && file.exists() && list != null && list.size() != 0) {
            FileInputStream fileInputStream = null;
            try {
                try {
                    try {
                        byte[] bArr = new byte[8192];
                        r2 = new ZipOutputStream(new FileOutputStream(file));
                        try {
                            r2.setComment(file.getName());
                            for (a aVar : list) {
                                File file2 = aVar.a;
                                if (file2.canRead()) {
                                    FileInputStream fileInputStream2 = new FileInputStream(file2);
                                    try {
                                        r2.putNextEntry(new ZipEntry(aVar.b));
                                        while (true) {
                                            int read = fileInputStream2.read(bArr);
                                            if (read == -1) {
                                                break;
                                            }
                                            r2.write(bArr, 0, read);
                                        }
                                        fileInputStream2.close();
                                        fileInputStream = fileInputStream2;
                                    } catch (FileNotFoundException e) {
                                        e = e;
                                        fileInputStream = fileInputStream2;
                                        e.printStackTrace();
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (IOException e2) {
                                                e2.printStackTrace();
                                            }
                                        }
                                        if (r2 != 0) {
                                            r2.close();
                                        }
                                        return;
                                    } catch (Throwable th) {
                                        th = th;
                                        fileInputStream = fileInputStream2;
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (IOException e3) {
                                                e3.printStackTrace();
                                            }
                                        }
                                        if (r2 != 0) {
                                            try {
                                                r2.close();
                                            } catch (IOException e4) {
                                                e4.printStackTrace();
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                            r2.flush();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            r2.close();
                        } catch (FileNotFoundException e6) {
                            e = e6;
                        }
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                } catch (FileNotFoundException e8) {
                    e = e8;
                    r2 = 0;
                } catch (Throwable th2) {
                    th = th2;
                    r2 = 0;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }
}
