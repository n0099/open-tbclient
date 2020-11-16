package com.baidu.tieba.tbadkCore.e;

import android.support.annotation.Nullable;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.tbadkCore.e.a.d;
import com.baidu.tieba.tbadkCore.e.a.e;
import com.baidu.tieba.tbadkCore.e.a.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private ArrayList<b> ijZ = new ArrayList<>();
    private e nae = new e();

    public void a(b bVar) {
        if (bVar != null) {
            this.ijZ.add(bVar);
        }
        if (this.nae != null && bVar != null && bVar.getClass().getAnnotation(com.baidu.c.a.a.class) != null) {
            try {
                this.nae.a((com.baidu.tieba.tbadkCore.e.a.a) Class.forName("com.baidu.tieba.h5power." + bVar.getClass().getSimpleName() + com.baidu.tieba.tbadkCore.e.a.a.PROXY_CLASS_NAME_SUFFIX).getConstructor(bVar.getClass()).newInstance(bVar));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.ijZ.remove(bVar);
        }
    }

    public void dKs() {
        this.ijZ.clear();
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
        if (this.nae != null) {
            this.nae.a(webView, this.nae.f(str, hashMap));
        }
    }

    private void b(WebView webView, String str) {
        if (this.nae != null) {
            d dVar = new d();
            com.baidu.tieba.tbadkCore.e.a.b bVar = new com.baidu.tieba.tbadkCore.e.a.b();
            String Sy = f.Sy(str);
            dVar.setAction(Sy);
            String Sz = f.Sz(str);
            dVar.ca(Sz);
            String SA = f.SA(str);
            bVar.Su(SA);
            if (au.isEmpty(Sy) || au.isEmpty(Sz) || au.isEmpty(SA)) {
                bVar.Kn(101);
            }
            try {
                dVar.eu(f.SD(str));
            } catch (JSONException e) {
                bVar.Kn(101);
            }
            dVar.Sw(f.SB(str));
            dVar.Sx(f.SC(str));
            com.baidu.tieba.tbadkCore.e.a.b a2 = this.nae.a(dVar, bVar);
            if (a2.dKv()) {
                this.nae.a(webView, a2);
            }
        }
    }

    private boolean b(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (y.getCount(this.ijZ) > 0) {
            Iterator<b> it = this.ijZ.iterator();
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
