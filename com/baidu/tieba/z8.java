package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes7.dex */
public class z8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    public z8(File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.a = file.getAbsolutePath();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b() : invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0088 A[Catch: Exception -> 0x0084, TRY_LEAVE, TryCatch #6 {Exception -> 0x0084, blocks: (B:50:0x0080, B:54:0x0088), top: B:68:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b() {
        InterceptResult invokeV;
        FileInputStream fileInputStream;
        Exception e;
        ZipInputStream zipInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
            return invokeV.booleanValue;
        }
        if (TextUtils.isEmpty(this.a)) {
            return false;
        }
        ZipInputStream zipInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(new File(this.a));
        } catch (Exception e2) {
            fileInputStream = null;
            e = e2;
            zipInputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream));
            while (true) {
                try {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            try {
                                zipInputStream.close();
                                fileInputStream.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            return true;
                        } else if (!nextEntry.isDirectory() && nextEntry.getName().contains("../")) {
                            try {
                                zipInputStream.close();
                                fileInputStream.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                            return false;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        e.printStackTrace();
                        if (zipInputStream != null) {
                            try {
                                zipInputStream.close();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                                return false;
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                            return false;
                        }
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    zipInputStream2 = zipInputStream;
                    if (zipInputStream2 != null) {
                        try {
                            zipInputStream2.close();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                            throw th;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e8) {
            e = e8;
            zipInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            if (zipInputStream2 != null) {
            }
            if (fileInputStream != null) {
            }
            throw th;
        }
    }
}
