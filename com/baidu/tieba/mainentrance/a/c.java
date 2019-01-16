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
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.util.y;
import com.baidu.tieba.e;
import com.baidu.tieba.quickWebView.QuickWebView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    private b fyi;
    private d fyj;
    private List<String> fyk = new ArrayList();
    private boolean fyl;
    private TbPageContext mPageContext;

    public c(BaseActivity baseActivity, b bVar, d dVar) {
        this.mPageContext = baseActivity.getPageContext();
        this.fyi = bVar;
        this.fyj = dVar;
        bbt();
        bbu();
    }

    private void bbt() {
        BaseWebView.c cVar = new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.a.c.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
            }
        };
        BaseWebView.f fVar = new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.a.c.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                if (webView == c.this.fyj.bbF()) {
                    c.this.jI(false);
                }
            }
        };
        BaseWebView.b bVar = new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.a.c.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return c.this.lA(str);
            }
        };
        QuickWebView bbF = this.fyj.bbF();
        if (bbF != null) {
            bbF.addJsPromptInterface(new a());
            bbF.setOnPageFinishedListener(cVar);
            bbF.setOnReceivedErrorListener(fVar);
            bbF.setOnLoadUrlListener(bVar);
        }
    }

    private void bbu() {
        y.a(new x<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.x
            public List<String> doInBackground() {
                return com.baidu.tieba.tbadkCore.util.a.bFH();
            }
        }, new h<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(List<String> list) {
                if (!v.I(list)) {
                    c.this.fyk = list;
                }
            }
        });
    }

    public void bbv() {
        this.fyj.bbA();
        if (this.fyl) {
            String bbw = bbw();
            if (!StringUtils.isNull(bbw)) {
                this.fyj.bbF().loadUrl("javascript:setSearchHistory('" + bbw + "')");
                return;
            }
            return;
        }
        this.fyj.bbF().loadUrl("https://tieba.baidu.com/n/apage-runtime/page/search_history");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bbw() {
        int H = v.H(this.fyk);
        if (H == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < H; i++) {
            jSONArray.put(this.fyk.get(i));
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jI(boolean z) {
        NoDataViewFactory.d eq;
        if (!z) {
            this.fyj.bbk();
            if (j.kV()) {
                eq = NoDataViewFactory.d.eq(e.j.text_no_search_record);
            } else {
                eq = NoDataViewFactory.d.eq(e.j.neterror);
            }
            this.fyj.a(eq);
            return;
        }
        this.fyj.bbA();
    }

    public void rK(String str) {
        if (!StringUtils.isNull(str) && this.fyk != null && !this.fyk.contains(str)) {
            this.fyk.add(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lA(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("http://tieba.baidu.com/mo/q/newhotmessage?") || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("https://tieba.baidu.com/mo/q/newhotmessage?")) {
            String aP = ac.aP(str, "topic_id=");
            String aP2 = ac.aP(str, "topic_name=");
            if (!com.baidu.tbadk.plugins.b.e(this.mPageContext) && !StringUtils.isNull(aP) && !StringUtils.isNull(aP2, true)) {
                this.mPageContext.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(aP, aP2, "4")));
            }
            TiebaStatic.log(new am("c10363").aB("obj_name", aP2));
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
                    jsPromptResult.confirm(c.this.bbw());
                    c.this.fyl = true;
                    return true;
                } else if ("deleteSearchHistory".equals(str2)) {
                    rL(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("deleteAllSearchHistory".equals(str2)) {
                    aAZ();
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("openSearchPage".equals(str2)) {
                    rM(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private void rL(String str) {
            try {
                final String optString = new JSONObject(str).optString("query");
                y.a(new x<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.x
                    /* renamed from: aMB */
                    public String doInBackground() {
                        com.baidu.tieba.tbadkCore.util.a.wg(optString);
                        return optString;
                    }
                }, new h<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    /* renamed from: pG */
                    public void onReturnDataInUI(String str2) {
                        c.this.fyk.remove(str2);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void aAZ() {
            y.a(new x() { // from class: com.baidu.tieba.mainentrance.a.c.a.3
                @Override // com.baidu.tbadk.util.x
                public Object doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.bFJ();
                    return null;
                }
            }, new h() { // from class: com.baidu.tieba.mainentrance.a.c.a.4
                @Override // com.baidu.tbadk.util.h
                public void onReturnDataInUI(Object obj) {
                    c.this.fyk.clear();
                }
            });
        }

        private void rM(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("query");
                int optInt = jSONObject.optInt("sub_type");
                if (c.this.fyi != null) {
                    c.this.fyi.a(optString, true, optInt);
                    TiebaStatic.log(new am("c12034"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
