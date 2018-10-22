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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.e;
import com.baidu.tieba.quickWebView.QuickWebView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    private b fmn;
    private d fmo;
    private List<String> fmp = new ArrayList();
    private boolean fmq;
    private TbPageContext mPageContext;

    public c(BaseActivity baseActivity, b bVar, d dVar) {
        this.mPageContext = baseActivity.getPageContext();
        this.fmn = bVar;
        this.fmo = dVar;
        aYR();
        aYS();
    }

    private void aYR() {
        BaseWebView.c cVar = new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.a.c.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
            }
        };
        BaseWebView.f fVar = new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.a.c.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                if (webView == c.this.fmo.aZd()) {
                    c.this.js(false);
                }
            }
        };
        BaseWebView.b bVar = new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.a.c.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return c.this.kN(str);
            }
        };
        QuickWebView aZd = this.fmo.aZd();
        if (aZd != null) {
            aZd.addJsPromptInterface(new a());
            aZd.setOnPageFinishedListener(cVar);
            aZd.setOnReceivedErrorListener(fVar);
            aZd.setOnLoadUrlListener(bVar);
        }
    }

    private void aYS() {
        x.a(new w<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            public List<String> doInBackground() {
                return com.baidu.tieba.tbadkCore.util.a.bCR();
            }
        }, new h<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(List<String> list) {
                if (!v.J(list)) {
                    c.this.fmp = list;
                }
            }
        });
    }

    public void aYT() {
        this.fmo.aYY();
        if (this.fmq) {
            String aYU = aYU();
            if (!StringUtils.isNull(aYU)) {
                this.fmo.aZd().loadUrl("javascript:setSearchHistory('" + aYU + "')");
                return;
            }
            return;
        }
        this.fmo.aZd().loadUrl("https://tieba.baidu.com/n/apage-runtime/page/search_history");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aYU() {
        int I = v.I(this.fmp);
        if (I == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < I; i++) {
            jSONArray.put(this.fmp.get(i));
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void js(boolean z) {
        NoDataViewFactory.d dO;
        if (!z) {
            this.fmo.aYI();
            if (j.kX()) {
                dO = NoDataViewFactory.d.dO(e.j.text_no_search_record);
            } else {
                dO = NoDataViewFactory.d.dO(e.j.neterror);
            }
            this.fmo.a(dO);
            return;
        }
        this.fmo.aYY();
    }

    public void qO(String str) {
        if (!StringUtils.isNull(str) && this.fmp != null && !this.fmp.contains(str)) {
            this.fmp.add(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kN(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("http://tieba.baidu.com/mo/q/newhotmessage?") || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("https://tieba.baidu.com/mo/q/newhotmessage?")) {
            String aL = ab.aL(str, "topic_id=");
            String aL2 = ab.aL(str, "topic_name=");
            if (!com.baidu.tbadk.plugins.b.e(this.mPageContext) && !StringUtils.isNull(aL) && !StringUtils.isNull(aL2, true)) {
                this.mPageContext.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(aL, aL2, "4")));
            }
            TiebaStatic.log(new am("c10363").ax("obj_name", aL2));
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
                    jsPromptResult.confirm(c.this.aYU());
                    c.this.fmq = true;
                    return true;
                } else if ("deleteSearchHistory".equals(str2)) {
                    qP(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("deleteAllSearchHistory".equals(str2)) {
                    ayG();
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("openSearchPage".equals(str2)) {
                    qQ(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private void qP(String str) {
            try {
                final String optString = new JSONObject(str).optString("query");
                x.a(new w<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.w
                    /* renamed from: aJY */
                    public String doInBackground() {
                        com.baidu.tieba.tbadkCore.util.a.vh(optString);
                        return optString;
                    }
                }, new h<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    /* renamed from: oK */
                    public void onReturnDataInUI(String str2) {
                        c.this.fmp.remove(str2);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void ayG() {
            x.a(new w() { // from class: com.baidu.tieba.mainentrance.a.c.a.3
                @Override // com.baidu.tbadk.util.w
                public Object doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.bCT();
                    return null;
                }
            }, new h() { // from class: com.baidu.tieba.mainentrance.a.c.a.4
                @Override // com.baidu.tbadk.util.h
                public void onReturnDataInUI(Object obj) {
                    c.this.fmp.clear();
                }
            });
        }

        private void qQ(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("query");
                int optInt = jSONObject.optInt("sub_type");
                if (c.this.fmn != null) {
                    c.this.fmn.a(optString, true, optInt);
                    TiebaStatic.log(new am("c12034"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
