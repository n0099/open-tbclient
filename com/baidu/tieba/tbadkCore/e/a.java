package com.baidu.tieba.tbadkCore.e;

import android.webkit.JsPromptResult;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private ArrayList<b> fEl = new ArrayList<>();

    public void a(b bVar) {
        if (bVar != null) {
            this.fEl.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.fEl.remove(bVar);
        }
    }

    public void bmK() {
        this.fEl.clear();
    }

    public boolean b(String str, JsPromptResult jsPromptResult) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("interfaceName");
            String optString2 = jSONObject.optString("methodName");
            String optString3 = jSONObject.optString("param");
            if (StringUtils.isNull(optString) || StringUtils.isNull(optString2) || StringUtils.isNull(optString3)) {
                return false;
            }
            return b(optString, optString2, optString3, jsPromptResult);
        } catch (JSONException e) {
            return false;
        }
    }

    private boolean b(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (x.s(this.fEl) > 0) {
            Iterator<b> it = this.fEl.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.dealJsInterface(str, str2, str3, jsPromptResult)) {
                    return true;
                }
            }
        }
        return false;
    }
}
