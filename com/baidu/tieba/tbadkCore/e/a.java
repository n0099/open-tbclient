package com.baidu.tieba.tbadkCore.e;

import android.support.annotation.Nullable;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
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
    private ArrayList<b> iuS = new ArrayList<>();
    private f nod = new f();

    public void a(b bVar) {
        if (bVar != null) {
            this.iuS.add(bVar);
        }
        if (this.nod != null && bVar != null && bVar.getClass().getAnnotation(com.baidu.c.a.a.class) != null) {
            try {
                this.nod.a((com.baidu.tieba.tbadkCore.e.a.a) Class.forName("com.baidu.tieba.h5power." + bVar.getClass().getSimpleName() + com.baidu.tieba.tbadkCore.e.a.a.PROXY_CLASS_NAME_SUFFIX).getConstructor(bVar.getClass()).newInstance(bVar));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.iuS.remove(bVar);
        }
    }

    public void dPI() {
        this.iuS.clear();
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
        if (this.nod != null) {
            this.nod.a(webView, this.nod.f(str, hashMap));
        }
    }

    private void b(WebView webView, String str) {
        if (this.nod != null) {
            e eVar = new e();
            com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
            String TN = g.TN(str);
            eVar.setAction(TN);
            String TO = g.TO(str);
            eVar.cd(TO);
            String TP = g.TP(str);
            cVar.TI(TP);
            if (au.isEmpty(TN) || au.isEmpty(TO) || au.isEmpty(TP)) {
                cVar.Ld(101);
            }
            try {
                eVar.ew(g.TS(str));
            } catch (JSONException e) {
                cVar.Ld(101);
            }
            eVar.TL(g.TQ(str));
            eVar.TM(g.TR(str));
            com.baidu.tieba.tbadkCore.e.a.c a2 = this.nod.a(eVar, cVar);
            if (a2.dPN()) {
                this.nod.a(webView, a2);
            }
        }
    }

    private boolean b(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (y.getCount(this.iuS) > 0) {
            Iterator<b> it = this.iuS.iterator();
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
