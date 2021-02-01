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
    private ArrayList<b> iIk = new ArrayList<>();
    private f nyU = new f();

    public void a(b bVar) {
        if (bVar != null) {
            this.iIk.add(bVar);
        }
        if (this.nyU != null && bVar != null && bVar.getClass().getAnnotation(com.baidu.b.a.a.class) != null) {
            try {
                this.nyU.a((com.baidu.tieba.tbadkCore.e.a.a) Class.forName("com.baidu.tieba.h5power." + bVar.getClass().getSimpleName() + com.baidu.tieba.tbadkCore.e.a.a.PROXY_CLASS_NAME_SUFFIX).getConstructor(bVar.getClass()).newInstance(bVar));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.iIk.remove(bVar);
        }
    }

    public void dNZ() {
        this.iIk.clear();
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
        if (this.nyU != null) {
            this.nyU.a(webView, this.nyU.g(str, hashMap));
        }
    }

    private void b(WebView webView, String str) {
        if (this.nyU != null) {
            e eVar = new e();
            com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
            String Tm = g.Tm(str);
            eVar.setAction(Tm);
            String Tn = g.Tn(str);
            eVar.bW(Tn);
            String To = g.To(str);
            cVar.Th(To);
            if (au.isEmpty(Tm) || au.isEmpty(Tn) || au.isEmpty(To)) {
                cVar.JM(101);
            }
            try {
                eVar.eL(g.Tr(str));
            } catch (JSONException e) {
                eVar.eL(new JSONObject());
                cVar.JM(101);
            }
            eVar.Tk(g.Tp(str));
            eVar.Tl(g.Tq(str));
            com.baidu.tieba.tbadkCore.e.a.c a2 = this.nyU.a(eVar, cVar);
            if (a2.dOe()) {
                this.nyU.a(webView, a2);
            }
        }
    }

    private boolean b(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (y.getCount(this.iIk) > 0) {
            Iterator<b> it = this.iIk.iterator();
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
