package com.baidu.tieba.t;

import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.network.http.f;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public static boolean f(byte[] bArr, String str) {
        if (bArr == null) {
            return false;
        }
        f fVar = new f();
        fVar.fY().setUrl(str);
        fVar.fY().setMethod(HttpMessageTask.HTTP_METHOD.POST);
        fVar.fY().addPostData("", bArr);
        new com.baidu.adp.lib.network.http.c(fVar).e(3, -1, -1);
        int i = fVar.fZ().responseCode;
        byte[] bArr2 = fVar.fZ().retBytes;
        if (bArr2 == null || i != 200) {
            return false;
        }
        try {
            if (new JSONObject(new String(bArr2, "utf-8")).optJSONObject(BdStatsConstant.StatsType.ERROR).optInt("errno") != 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static byte[] er(List<String> list) {
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

    public static byte[] di(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString().getBytes();
    }
}
