package com.baidu.ufosdk.b;

import android.os.Build;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes21.dex */
public final class b {
    public static String a() {
        String str;
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
            } catch (IOException e) {
                return str;
            }
        } catch (IOException e2) {
            return "";
        }
    }
}
