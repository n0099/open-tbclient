package com.baidu.tieba.tbadkCore.e;

import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.tbadkCore.e.a.e;
import com.baidu.tieba.tbadkCore.e.a.f;
import com.baidu.tieba.tbadkCore.e.a.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private ArrayList<b> iHh = new ArrayList<>();
    private f ntQ = new f();

    public void a(b bVar) {
        if (bVar != null) {
            this.iHh.add(bVar);
        }
        if (this.ntQ != null && bVar != null && bVar.getClass().getAnnotation(com.baidu.c.a.a.class) != null) {
            try {
                this.ntQ.a((com.baidu.tieba.tbadkCore.e.a.a) Class.forName("com.baidu.tieba.h5power." + bVar.getClass().getSimpleName() + com.baidu.tieba.tbadkCore.e.a.a.PROXY_CLASS_NAME_SUFFIX).getConstructor(bVar.getClass()).newInstance(bVar));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.iHh.remove(bVar);
        }
    }

    public void dPF() {
        this.iHh.clear();
    }

    public boolean a(WebView webView, String str, JsPromptResult jsPromptResult) {
        if (str.startsWith("tiebaapp")) {
            b(webView, str);
            return false;
        }
        return a(str, jsPromptResult);
    }

    public boolean a(String str, JsPromptResult jsPromptResult) {
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

    public void a(WebView webView, String str, @Nullable HashMap hashMap) {
        if (this.ntQ != null) {
            this.ntQ.a(webView, this.ntQ.f(str, hashMap));
        }
    }

    private void b(WebView webView, String str) {
        if (this.ntQ != null) {
            e eVar = new e();
            com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
            String Tx = g.Tx(str);
            eVar.setAction(Tx);
            String Ty = g.Ty(str);
            eVar.bW(Ty);
            String Tz = g.Tz(str);
            cVar.Ts(Tz);
            if (at.isEmpty(Tx) || at.isEmpty(Ty) || at.isEmpty(Tz)) {
                cVar.KZ(101);
            }
            try {
                eVar.eK(g.TC(str));
            } catch (JSONException e) {
                eVar.eK(new JSONObject());
                cVar.KZ(101);
            }
            eVar.Tv(g.TA(str));
            eVar.Tw(g.TB(str));
            com.baidu.tieba.tbadkCore.e.a.c a2 = this.ntQ.a(eVar, cVar);
            if (a2.dPK()) {
                this.ntQ.a(webView, a2);
            }
        }
    }

    private boolean b(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (x.getCount(this.iHh) > 0) {
            Iterator<b> it = this.iHh.iterator();
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
