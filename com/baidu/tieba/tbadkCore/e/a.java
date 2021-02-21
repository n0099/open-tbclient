package com.baidu.tieba.tbadkCore.e;

import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
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
    private ArrayList<b> iIy = new ArrayList<>();
    private f nzu = new f();

    public void a(b bVar) {
        if (bVar != null) {
            this.iIy.add(bVar);
        }
        if (this.nzu != null && bVar != null && bVar.getClass().getAnnotation(com.baidu.b.a.a.class) != null) {
            try {
                this.nzu.a((com.baidu.tieba.tbadkCore.e.a.a) Class.forName("com.baidu.tieba.h5power." + bVar.getClass().getSimpleName() + com.baidu.tieba.tbadkCore.e.a.a.PROXY_CLASS_NAME_SUFFIX).getConstructor(bVar.getClass()).newInstance(bVar));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.iIy.remove(bVar);
        }
    }

    public void dOh() {
        this.iIy.clear();
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
        if (this.nzu != null) {
            this.nzu.a(webView, this.nzu.g(str, hashMap));
        }
    }

    private void b(WebView webView, String str) {
        if (this.nzu != null) {
            e eVar = new e();
            com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
            String Ty = g.Ty(str);
            eVar.setAction(Ty);
            String Tz = g.Tz(str);
            eVar.bW(Tz);
            String TA = g.TA(str);
            cVar.Tt(TA);
            if (au.isEmpty(Ty) || au.isEmpty(Tz) || au.isEmpty(TA)) {
                cVar.JM(101);
            }
            try {
                eVar.eL(g.TD(str));
            } catch (JSONException e) {
                eVar.eL(new JSONObject());
                cVar.JM(101);
            }
            eVar.Tw(g.TB(str));
            eVar.Tx(g.TC(str));
            com.baidu.tieba.tbadkCore.e.a.c a2 = this.nzu.a(eVar, cVar);
            if (a2.dOm()) {
                this.nzu.a(webView, a2);
            }
        }
    }

    private boolean b(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (y.getCount(this.iIy) > 0) {
            Iterator<b> it = this.iIy.iterator();
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
