package com.baidu.tieba.s;

import com.baidu.adp.framework.task.HttpMessageTask;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {
    public static boolean h(byte[] bArr, String str) {
        if (bArr == null) {
            return false;
        }
        com.baidu.adp.lib.network.http.e eVar = new com.baidu.adp.lib.network.http.e();
        eVar.iu().setUrl(str);
        eVar.iu().setMethod(HttpMessageTask.HTTP_METHOD.POST);
        eVar.iu().d("", bArr);
        new com.baidu.adp.lib.network.http.c(eVar).f(3, -1, -1);
        int i = eVar.iv().responseCode;
        byte[] bArr2 = eVar.iv().AU;
        if (bArr2 == null || i != 200) {
            return false;
        }
        try {
            if (new JSONObject(new String(bArr2, "utf-8")).optJSONObject("error").optInt("errno") != 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static byte[] en(List<String> list) {
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

    public static byte[] bS(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString().getBytes();
    }
}
