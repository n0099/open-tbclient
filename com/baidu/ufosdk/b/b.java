package com.baidu.ufosdk.b;

import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("logcat");
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(Arrays.asList("-t", "2000", "-v", "time"));
            int indexOf = arrayList2.indexOf("-t");
            if (indexOf >= 0 && indexOf < arrayList2.size() && Build.VERSION.SDK_INT < 8) {
                arrayList2.remove(indexOf + 1);
                arrayList2.remove(indexOf);
                arrayList2.add("-d");
            }
            com.baidu.ufosdk.f.e eVar = new com.baidu.ufosdk.f.e();
            arrayList.addAll(arrayList2);
            try {
                Process exec = Runtime.getRuntime().exec((String[]) arrayList.toArray(new String[arrayList.size()]));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 8192);
                new Thread(new c(exec)).start();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    eVar.add(readLine + "\n");
                }
                String linkedList = eVar.toString();
                try {
                    return linkedList.length() > 65535 ? linkedList.substring(linkedList.length() - 65535, linkedList.length() - 1) : linkedList;
                } catch (IOException unused) {
                    return str;
                }
            } catch (IOException unused2) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
