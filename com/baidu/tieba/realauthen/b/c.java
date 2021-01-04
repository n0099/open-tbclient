package com.baidu.tieba.realauthen.b;

import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.webkit.internal.ETAG;
import java.net.URLEncoder;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    public static String aM(String str, String str2, String str3) {
        String next;
        if (TextUtils.isEmpty(str)) {
            str = "1200532349";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = System.currentTimeMillis() + "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("reqid", str2);
            jSONObject.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = b.toMds(jSONObject, "fe1eb73d3f1a95d10c0eb8890fdfe509d95f5a53", ETAG.ITEM_SEPARATOR);
        }
        try {
            jSONObject.put("sign", str3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str4 = null;
            try {
                str4 = jSONObject.getString(keys.next());
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            sb.append(URLEncoder.encode(next) + "=" + URLEncoder.encode(str4) + ETAG.ITEM_SEPARATOR);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
