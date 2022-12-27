package com.bytedance.pangle.util.a;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.pangle.util.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String[] a(File file) {
        InterceptResult invokeL;
        String str;
        String str2;
        ZipFile zipFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, file)) == null) {
            ZipFile zipFile2 = null;
            try {
                zipFile = new ZipFile(file);
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                ArrayList<Long> arrayList = new ArrayList();
                boolean z = false;
                boolean z2 = false;
                boolean z3 = false;
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    if (nextElement.getName().startsWith("META-INF/")) {
                        if (nextElement.getName().endsWith("MANIFEST.MF")) {
                            z3 = true;
                        } else if (nextElement.getName().endsWith(".SF")) {
                            z = true;
                        } else if (nextElement.getName().endsWith(".RSA")) {
                            z2 = true;
                        }
                        arrayList.add(Long.valueOf(nextElement.getCrc()));
                    }
                }
                Collections.sort(arrayList, Collections.reverseOrder());
                StringBuilder sb = new StringBuilder();
                for (Long l : arrayList) {
                    sb.append(l);
                }
                if (z3 && z && z2) {
                    str2 = e.a(sb.toString());
                    str = "";
                } else {
                    str = "without v1 signature.";
                    str2 = "";
                }
                c.a(zipFile);
            } catch (Exception unused2) {
                zipFile2 = zipFile;
                c.a(zipFile2);
                str = "";
                str2 = str;
                String[] strArr = new String[3];
                strArr[0] = str2;
                strArr[1] = TextUtils.isEmpty(str2) ? "" : "V1";
                strArr[2] = str;
                return strArr;
            } catch (Throwable th2) {
                th = th2;
                zipFile2 = zipFile;
                c.a(zipFile2);
                throw th;
            }
            String[] strArr2 = new String[3];
            strArr2[0] = str2;
            strArr2[1] = TextUtils.isEmpty(str2) ? "" : "V1";
            strArr2[2] = str;
            return strArr2;
        }
        return (String[]) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0013 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a1654612903174dc(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            while (true) {
                char c = 'J';
                char c2 = '7';
                while (true) {
                    switch (c) {
                        case 'H':
                            break;
                        case 'I':
                            switch (c2) {
                                case '^':
                                    break;
                                case '_':
                                case '`':
                                    break;
                                default:
                                    switch (c2) {
                                    }
                            }
                            c = 'I';
                            c2 = '`';
                            break;
                        case 'J':
                            switch (c2) {
                            }
                            c = 'I';
                            c2 = '`';
                            break;
                        default:
                            c = 'H';
                    }
                }
            }
            char[] charArray = str.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                charArray[i] = (char) (charArray[i] ^ i);
            }
            return new String(charArray);
        }
        return (String) invokeL.objValue;
    }
}
