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
import com.baidu.tbadk.core.util.ak;
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
    private BaseActivity bSO;
    private b fiv;
    private d fiw;
    private List<String> fiy = new ArrayList();
    private boolean fiz;
    private TbPageContext mPageContext;

    public c(BaseActivity baseActivity, b bVar, d dVar) {
        this.bSO = baseActivity;
        this.mPageContext = baseActivity.getPageContext();
        this.fiv = bVar;
        this.fiw = dVar;
        init();
    }

    private void init() {
        this.fiw.aSe();
        this.fiw.aSe().addJsPromptInterface(new a());
        initListener();
        aRT();
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
                if (webView == c.this.fiw.aSe()) {
                    c.this.iF(false);
                }
            }
        };
        BaseWebView.b bVar = new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.a.c.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return c.this.iZ(str);
            }
        };
        QuickWebView aSe = this.fiw.aSe();
        if (aSe != null) {
            aSe.setOnPageFinishedListener(cVar);
            aSe.setOnReceivedErrorListener(fVar);
            aSe.setOnLoadUrlListener(bVar);
        }
    }

    private void aRT() {
        v.a(new u<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            public List<String> doInBackground() {
                return com.baidu.tieba.tbadkCore.util.a.bxJ();
            }
        }, new h<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(List<String> list) {
                if (!com.baidu.tbadk.core.util.v.E(list)) {
                    c.this.fiy = list;
                }
            }
        });
    }

    public void aRU() {
        this.fiw.aRZ();
        if (this.fiz) {
            String aRV = aRV();
            if (!StringUtils.isNull(aRV)) {
                this.fiw.aSe().loadUrl("javascript:setSearchHistory('" + aRV + "')");
                return;
            }
            return;
        }
        this.fiw.aSe().loadUrl("https://tieba.baidu.com/n/apage-runtime/page/search_history");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aRV() {
        int D = com.baidu.tbadk.core.util.v.D(this.fiy);
        if (D == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < D; i++) {
            jSONArray.put(this.fiy.get(i));
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iF(boolean z) {
        NoDataViewFactory.d gp;
        if (!z) {
            this.fiw.aRK();
            if (j.oJ()) {
                gp = NoDataViewFactory.d.gp(d.j.text_no_search_record);
            } else {
                gp = NoDataViewFactory.d.gp(d.j.neterror);
            }
            this.fiw.a(gp);
            return;
        }
        this.fiw.aRZ();
    }

    public void oH(String str) {
        if (!StringUtils.isNull(str) && this.fiy != null && !this.fiy.contains(str)) {
            this.fiy.add(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iZ(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("http://tieba.baidu.com/mo/q/newhotmessage?") || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("https://tieba.baidu.com/mo/q/newhotmessage?")) {
            String ar = z.ar(str, "topic_id=");
            String ar2 = z.ar(str, "topic_name=");
            if (!com.baidu.tbadk.plugins.a.e(this.mPageContext) && !StringUtils.isNull(ar) && !StringUtils.isNull(ar2, true)) {
                this.mPageContext.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(ar, ar2, null)));
            }
            TiebaStatic.log(new ak("c10363").ab("obj_name", ar2));
            return true;
        } else if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage/list") || str.startsWith(TbConfig.URL_HOST_TOPIC_LIST)) {
            if (com.baidu.tbadk.plugins.a.e(this.mPageContext)) {
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
                    jsPromptResult.confirm(c.this.aRV());
                    c.this.fiz = true;
                    return true;
                } else if ("deleteSearchHistory".equals(str2)) {
                    oI(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("deleteAllSearchHistory".equals(str2)) {
                    auo();
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("openSearchPage".equals(str2)) {
                    oJ(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private void oI(String str) {
            try {
                final String optString = new JSONObject(str).optString("query");
                v.a(new u<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.u
                    /* renamed from: aCY */
                    public String doInBackground() {
                        com.baidu.tieba.tbadkCore.util.a.sS(optString);
                        return optString;
                    }
                }, new h<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    /* renamed from: mF */
                    public void onReturnDataInUI(String str2) {
                        c.this.fiy.remove(str2);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void auo() {
            v.a(new u() { // from class: com.baidu.tieba.mainentrance.a.c.a.3
                @Override // com.baidu.tbadk.util.u
                public Object doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.bxL();
                    return null;
                }
            }, new h() { // from class: com.baidu.tieba.mainentrance.a.c.a.4
                @Override // com.baidu.tbadk.util.h
                public void onReturnDataInUI(Object obj) {
                    c.this.fiy.clear();
                }
            });
        }

        private void oJ(String str) {
            try {
                String optString = new JSONObject(str).optString("query");
                if (c.this.fiv != null) {
                    c.this.fiv.M(optString, true);
                    TiebaStatic.log(new ak("c12034"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
