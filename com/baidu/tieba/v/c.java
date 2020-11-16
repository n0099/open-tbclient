package com.baidu.tieba.v;

import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class c {
    public static boolean e(byte[] bArr, String str) {
        if (bArr == null) {
            return false;
        }
        com.baidu.adp.lib.network.http.e eVar = new com.baidu.adp.lib.network.http.e();
        eVar.mx().setUrl(str);
        eVar.mx().setMethod(HttpMessageTask.HTTP_METHOD.POST);
        eVar.mx().addPostData("", bArr);
        new com.baidu.adp.lib.network.http.c(eVar).f(3, -1, -1);
        int i = eVar.my().responseCode;
        byte[] bArr2 = eVar.my().retBytes;
        if (bArr2 == null || i != 200) {
            return false;
        }
        try {
            if (new JSONObject(new String(bArr2, "utf-8")).optJSONObject(BdStatsConstant.StatsType.ERROR).optInt(BaseJsonData.TAG_ERRNO) != 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static byte[] fP(List<String> list) {
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

    public static byte[] ew(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString().getBytes();
    }
}
