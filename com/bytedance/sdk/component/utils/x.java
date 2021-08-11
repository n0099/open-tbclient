package com.bytedance.sdk.component.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.retrieve.Constants;
import com.baidu.android.util.io.ZipUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes9.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<File> a(String str, String str2) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) ? a(str, str2, (String) null) : (List) invokeLL.objValue;
    }

    public static boolean b(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, file)) == null) {
            if (file == null) {
                return false;
            }
            if (file.exists()) {
                return file.isFile();
            }
            if (a(file.getParentFile())) {
                try {
                    return file.createNewFile();
                } catch (Throwable unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static List<File> a(String str, String str2, String str3) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) ? a(a(str), a(str2), str3) : (List) invokeLLL.objValue;
    }

    public static List<File> a(File file, File file2, String str) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, file, file2, str)) == null) {
            if (file == null || file2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            try {
                if (b(str)) {
                    while (entries.hasMoreElements()) {
                        ZipEntry nextElement = entries.nextElement();
                        String name = nextElement.getName();
                        if (name.contains(Constants.PATH_PARENT)) {
                            k.d(ZipUtils.TAG, "entryName: " + name + " is dangerous!");
                        } else if (!a(file2, arrayList, zipFile, nextElement, name)) {
                            return arrayList;
                        }
                    }
                } else {
                    while (entries.hasMoreElements()) {
                        ZipEntry nextElement2 = entries.nextElement();
                        String name2 = nextElement2.getName();
                        if (name2.contains(Constants.PATH_PARENT)) {
                            k.d(ZipUtils.TAG, "entryName: " + name2 + " is dangerous!");
                        } else if (name2.contains(str) && !a(file2, arrayList, zipFile, nextElement2, name2)) {
                            return arrayList;
                        }
                    }
                }
                return arrayList;
            } finally {
                zipFile.close();
            }
        }
        return (List) invokeLLL.objValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (str == null) {
                return true;
            }
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (!Character.isWhitespace(str.charAt(i2))) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(File file, List<File> list, ZipFile zipFile, ZipEntry zipEntry, String str) throws IOException {
        InterceptResult invokeLLLLL;
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLLL = interceptable.invokeLLLLL(AdIconUtil.AD_TEXT_ID, null, file, list, zipFile, zipEntry, str)) != null) {
            return invokeLLLLL.booleanValue;
        }
        File file2 = new File(file, str);
        list.add(file2);
        if (zipEntry.isDirectory()) {
            return a(file2);
        }
        if (!b(file2)) {
            return false;
        }
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
                bufferedInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
            fileOutputStream = null;
            bufferedInputStream = null;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read != -1) {
                        bufferedOutputStream.write(bArr, 0, read);
                    } else {
                        bufferedInputStream.close();
                        bufferedOutputStream.close();
                        fileOutputStream.close();
                        return true;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedOutputStream = null;
            th = th;
            if (bufferedInputStream != null) {
            }
            if (bufferedOutputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    public static boolean a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) ? file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory()) : invokeL.booleanValue;
    }

    public static File a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (b(str)) {
                return null;
            }
            return new File(str);
        }
        return (File) invokeL.objValue;
    }
}
