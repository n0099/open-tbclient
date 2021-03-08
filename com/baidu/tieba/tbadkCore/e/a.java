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
    private ArrayList<b> iKh = new ArrayList<>();
    private f nBz = new f();

    public void a(b bVar) {
        if (bVar != null) {
            this.iKh.add(bVar);
        }
        if (this.nBz != null && bVar != null && bVar.getClass().getAnnotation(com.baidu.b.a.a.class) != null) {
            try {
                this.nBz.a((com.baidu.tieba.tbadkCore.e.a.a) Class.forName("com.baidu.tieba.h5power." + bVar.getClass().getSimpleName() + com.baidu.tieba.tbadkCore.e.a.a.PROXY_CLASS_NAME_SUFFIX).getConstructor(bVar.getClass()).newInstance(bVar));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.iKh.remove(bVar);
        }
    }

    public void dOq() {
        this.iKh.clear();
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
        if (this.nBz != null) {
            this.nBz.a(webView, this.nBz.g(str, hashMap));
        }
    }

    private void b(WebView webView, String str) {
        if (this.nBz != null) {
            e eVar = new e();
            com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
            String TF = g.TF(str);
            eVar.setAction(TF);
            String TG = g.TG(str);
            eVar.ca(TG);
            String TH = g.TH(str);
            cVar.TA(TH);
            if (au.isEmpty(TF) || au.isEmpty(TG) || au.isEmpty(TH)) {
                cVar.JR(101);
            }
            try {
                eVar.eO(g.TK(str));
            } catch (JSONException e) {
                eVar.eO(new JSONObject());
                cVar.JR(101);
            }
            eVar.TD(g.TI(str));
            eVar.TE(g.TJ(str));
            com.baidu.tieba.tbadkCore.e.a.c a2 = this.nBz.a(eVar, cVar);
            if (a2.dOv()) {
                this.nBz.a(webView, a2);
            }
        }
    }

    private boolean b(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (y.getCount(this.iKh) > 0) {
            Iterator<b> it = this.iKh.iterator();
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
