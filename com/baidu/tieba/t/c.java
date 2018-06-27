package com.baidu.tieba.t;

import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.ar.util.IoUtils;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public static boolean f(byte[] bArr, String str) {
        if (bArr == null) {
            return false;
        }
        com.baidu.adp.lib.network.http.e eVar = new com.baidu.adp.lib.network.http.e();
        eVar.hV().setUrl(str);
        eVar.hV().setMethod(HttpMessageTask.HTTP_METHOD.POST);
        eVar.hV().d("", bArr);
        new com.baidu.adp.lib.network.http.c(eVar).f(3, -1, -1);
        int i = eVar.hW().responseCode;
        byte[] bArr2 = eVar.hW().Ab;
        if (bArr2 == null || i != 200) {
            return false;
        }
        try {
            if (new JSONObject(new String(bArr2, IoUtils.UTF_8)).optJSONObject("error").optInt("errno") != 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static byte[] dI(List<String> list) {
        if (list == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(list.get(i));
            sb.append("\n");
        }
        return sb.toString().getBytes();
    }

    public static byte[] ac(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString().getBytes();
    }
}
