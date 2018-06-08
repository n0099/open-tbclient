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
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.quickWebView.QuickWebView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    private BaseActivity bkU;
    private b ePC;
    private d ePD;
    private List<String> ePE = new ArrayList();
    private boolean ePF;
    private TbPageContext mPageContext;

    public c(BaseActivity baseActivity, b bVar, d dVar) {
        this.bkU = baseActivity;
        this.mPageContext = baseActivity.getPageContext();
        this.ePC = bVar;
        this.ePD = dVar;
        init();
    }

    private void init() {
        this.ePD.aRW();
        this.ePD.aRW().addJsPromptInterface(new a());
        initListener();
        aRL();
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
                if (webView == c.this.ePD.aRW()) {
                    c.this.io(false);
                }
            }
        };
        BaseWebView.b bVar = new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.a.c.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return c.this.jE(str);
            }
        };
        QuickWebView aRW = this.ePD.aRW();
        if (aRW != null) {
            aRW.setOnPageFinishedListener(cVar);
            aRW.setOnReceivedErrorListener(fVar);
            aRW.setOnLoadUrlListener(bVar);
        }
    }

    private void aRL() {
        w.a(new v<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.v
            public List<String> doInBackground() {
                return com.baidu.tieba.tbadkCore.util.a.bxQ();
            }
        }, new h<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(List<String> list) {
                if (!com.baidu.tbadk.core.util.w.z(list)) {
                    c.this.ePE = list;
                }
            }
        });
    }

    public void aRM() {
        this.ePD.aRR();
        if (this.ePF) {
            String aRN = aRN();
            if (!StringUtils.isNull(aRN)) {
                this.ePD.aRW().loadUrl("javascript:setSearchHistory('" + aRN + "')");
                return;
            }
            return;
        }
        this.ePD.aRW().loadUrl("https://tieba.baidu.com/n/apage-runtime/page/search_history");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aRN() {
        int y = com.baidu.tbadk.core.util.w.y(this.ePE);
        if (y == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < y; i++) {
            jSONArray.put(this.ePE.get(i));
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void io(boolean z) {
        NoDataViewFactory.d dr;
        if (!z) {
            this.ePD.aRC();
            if (j.jD()) {
                dr = NoDataViewFactory.d.dr(d.k.text_no_search_record);
            } else {
                dr = NoDataViewFactory.d.dr(d.k.neterror);
            }
            this.ePD.a(dr);
            return;
        }
        this.ePD.aRR();
    }

    public void pD(String str) {
        if (!StringUtils.isNull(str) && this.ePE != null && !this.ePE.contains(str)) {
            this.ePE.add(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jE(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("http://tieba.baidu.com/mo/q/newhotmessage?") || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("https://tieba.baidu.com/mo/q/newhotmessage?")) {
            String ax = aa.ax(str, "topic_id=");
            String ax2 = aa.ax(str, "topic_name=");
            if (!com.baidu.tbadk.plugins.b.e(this.mPageContext) && !StringUtils.isNull(ax) && !StringUtils.isNull(ax2, true)) {
                this.mPageContext.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(ax, ax2, "4")));
            }
            TiebaStatic.log(new am("c10363").ah("obj_name", ax2));
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
                    jsPromptResult.confirm(c.this.aRN());
                    c.this.ePF = true;
                    return true;
                } else if ("deleteSearchHistory".equals(str2)) {
                    pE(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("deleteAllSearchHistory".equals(str2)) {
                    asH();
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("openSearchPage".equals(str2)) {
                    pF(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private void pE(String str) {
            try {
                final String optString = new JSONObject(str).optString("query");
                w.a(new v<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.v
                    /* renamed from: aCP */
                    public String doInBackground() {
                        com.baidu.tieba.tbadkCore.util.a.tW(optString);
                        return optString;
                    }
                }, new h<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    /* renamed from: nw */
                    public void onReturnDataInUI(String str2) {
                        c.this.ePE.remove(str2);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void asH() {
            w.a(new v() { // from class: com.baidu.tieba.mainentrance.a.c.a.3
                @Override // com.baidu.tbadk.util.v
                public Object doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.bxS();
                    return null;
                }
            }, new h() { // from class: com.baidu.tieba.mainentrance.a.c.a.4
                @Override // com.baidu.tbadk.util.h
                public void onReturnDataInUI(Object obj) {
                    c.this.ePE.clear();
                }
            });
        }

        private void pF(String str) {
            try {
                String optString = new JSONObject(str).optString("query");
                if (c.this.ePC != null) {
                    c.this.ePC.H(optString, true);
                    TiebaStatic.log(new am("c12034"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
