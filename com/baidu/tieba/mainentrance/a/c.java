package com.baidu.tieba.mainentrance.a;

import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.d;
import com.baidu.tieba.quickWebView.QuickWebView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    private BaseActivity bcJ;
    private b eDd;
    private d eDe;
    private List<String> eDf = new ArrayList();
    private boolean eDg;
    private TbPageContext mPageContext;

    public c(BaseActivity baseActivity, b bVar, d dVar) {
        this.bcJ = baseActivity;
        this.mPageContext = baseActivity.getPageContext();
        this.eDd = bVar;
        this.eDe = dVar;
        init();
    }

    private void init() {
        this.eDe.aNa();
        this.eDe.aNa().addJsPromptInterface(new a());
        initListener();
        aMP();
    }

    private void initListener() {
        BaseWebView.c cVar = new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.a.c.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
            }
        };
        BaseWebView.f fVar = new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.a.c.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                if (webView == c.this.eDe.aNa()) {
                    c.this.ih(false);
                }
            }
        };
        BaseWebView.b bVar = new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.a.c.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return c.this.jb(str);
            }
        };
        QuickWebView aNa = this.eDe.aNa();
        if (aNa != null) {
            aNa.setOnPageFinishedListener(cVar);
            aNa.setOnReceivedErrorListener(fVar);
            aNa.setOnLoadUrlListener(bVar);
        }
    }

    private void aMP() {
        v.a(new u<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            public List<String> doInBackground() {
                return com.baidu.tieba.tbadkCore.util.a.bsN();
            }
        }, new h<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(List<String> list) {
                if (!com.baidu.tbadk.core.util.v.w(list)) {
                    c.this.eDf = list;
                }
            }
        });
    }

    public void aMQ() {
        this.eDe.aMV();
        if (this.eDg) {
            String aMR = aMR();
            if (!StringUtils.isNull(aMR)) {
                this.eDe.aNa().loadUrl("javascript:setSearchHistory('" + aMR + "')");
                return;
            }
            return;
        }
        this.eDe.aNa().loadUrl("https://tieba.baidu.com/n/apage-runtime/page/search_history");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aMR() {
        int v = com.baidu.tbadk.core.util.v.v(this.eDf);
        if (v == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < v; i++) {
            jSONArray.put(this.eDf.get(i));
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ih(boolean z) {
        NoDataViewFactory.d m16do;
        if (!z) {
            this.eDe.aMG();
            if (j.gP()) {
                m16do = NoDataViewFactory.d.m16do(d.k.text_no_search_record);
            } else {
                m16do = NoDataViewFactory.d.m16do(d.k.neterror);
            }
            this.eDe.a(m16do);
            return;
        }
        this.eDe.aMV();
    }

    public void oM(String str) {
        if (!StringUtils.isNull(str) && this.eDf != null && !this.eDf.contains(str)) {
            this.eDf.add(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jb(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("http://tieba.baidu.com/mo/q/newhotmessage?") || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("https://tieba.baidu.com/mo/q/newhotmessage?")) {
            String ar = z.ar(str, "topic_id=");
            String ar2 = z.ar(str, "topic_name=");
            if (!com.baidu.tbadk.plugins.b.e(this.mPageContext) && !StringUtils.isNull(ar) && !StringUtils.isNull(ar2, true)) {
                this.mPageContext.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(ar, ar2, null)));
            }
            TiebaStatic.log(new al("c10363").ac("obj_name", ar2));
            return true;
        } else if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage/list") || str.startsWith(TbConfig.URL_HOST_TOPIC_LIST)) {
            if (com.baidu.tbadk.plugins.b.e(this.mPageContext)) {
                return true;
            }
            new HotRanklistActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig("hotforum", "all").start();
            return true;
        } else {
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements com.baidu.tieba.tbadkCore.e.b {
        public a() {
        }

        @Override // com.baidu.tieba.tbadkCore.e.b
        public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if ("CommonJSBridge".equals(str)) {
                if ("getSearchHistory".equals(str2)) {
                    jsPromptResult.confirm(c.this.aMR());
                    c.this.eDg = true;
                    return true;
                } else if ("deleteSearchHistory".equals(str2)) {
                    oN(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("deleteAllSearchHistory".equals(str2)) {
                    aoD();
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("openSearchPage".equals(str2)) {
                    oO(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private void oN(String str) {
            try {
                final String optString = new JSONObject(str).optString("query");
                v.a(new u<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.u
                    /* renamed from: axW */
                    public String doInBackground() {
                        com.baidu.tieba.tbadkCore.util.a.sZ(optString);
                        return optString;
                    }
                }, new h<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    /* renamed from: mI */
                    public void onReturnDataInUI(String str2) {
                        c.this.eDf.remove(str2);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void aoD() {
            v.a(new u() { // from class: com.baidu.tieba.mainentrance.a.c.a.3
                @Override // com.baidu.tbadk.util.u
                public Object doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.bsP();
                    return null;
                }
            }, new h() { // from class: com.baidu.tieba.mainentrance.a.c.a.4
                @Override // com.baidu.tbadk.util.h
                public void onReturnDataInUI(Object obj) {
                    c.this.eDf.clear();
                }
            });
        }

        private void oO(String str) {
            try {
                String optString = new JSONObject(str).optString("query");
                if (c.this.eDd != null) {
                    c.this.eDd.H(optString, true);
                    TiebaStatic.log(new al("c12034"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
