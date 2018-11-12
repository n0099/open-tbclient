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
    private b fnE;
    private d fnF;
    private List<String> fnG = new ArrayList();
    private boolean fnH;
    private TbPageContext mPageContext;

    public c(BaseActivity baseActivity, b bVar, d dVar) {
        this.mPageContext = baseActivity.getPageContext();
        this.fnE = bVar;
        this.fnF = dVar;
        aYo();
        aYp();
    }

    private void aYo() {
        BaseWebView.c cVar = new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.a.c.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
            }
        };
        BaseWebView.f fVar = new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.a.c.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                if (webView == c.this.fnF.aYA()) {
                    c.this.jC(false);
                }
            }
        };
        BaseWebView.b bVar = new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.a.c.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return c.this.kP(str);
            }
        };
        QuickWebView aYA = this.fnF.aYA();
        if (aYA != null) {
            aYA.addJsPromptInterface(new a());
            aYA.setOnPageFinishedListener(cVar);
            aYA.setOnReceivedErrorListener(fVar);
            aYA.setOnLoadUrlListener(bVar);
        }
    }

    private void aYp() {
        x.a(new w<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            public List<String> doInBackground() {
                return com.baidu.tieba.tbadkCore.util.a.bCm();
            }
        }, new h<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(List<String> list) {
                if (!v.I(list)) {
                    c.this.fnG = list;
                }
            }
        });
    }

    public void aYq() {
        this.fnF.aYv();
        if (this.fnH) {
            String aYr = aYr();
            if (!StringUtils.isNull(aYr)) {
                this.fnF.aYA().loadUrl("javascript:setSearchHistory('" + aYr + "')");
                return;
            }
            return;
        }
        this.fnF.aYA().loadUrl("https://tieba.baidu.com/n/apage-runtime/page/search_history");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aYr() {
        int H = v.H(this.fnG);
        if (H == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < H; i++) {
            jSONArray.put(this.fnG.get(i));
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jC(boolean z) {
        NoDataViewFactory.d ec;
        if (!z) {
            this.fnF.aYf();
            if (j.kV()) {
                ec = NoDataViewFactory.d.ec(e.j.text_no_search_record);
            } else {
                ec = NoDataViewFactory.d.ec(e.j.neterror);
            }
            this.fnF.a(ec);
            return;
        }
        this.fnF.aYv();
    }

    public void qP(String str) {
        if (!StringUtils.isNull(str) && this.fnG != null && !this.fnG.contains(str)) {
            this.fnG.add(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kP(String str) {
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
                    jsPromptResult.confirm(c.this.aYr());
                    c.this.fnH = true;
                    return true;
                } else if ("deleteSearchHistory".equals(str2)) {
                    qQ(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("deleteAllSearchHistory".equals(str2)) {
                    ayd();
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("openSearchPage".equals(str2)) {
                    qR(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private void qQ(String str) {
            try {
                final String optString = new JSONObject(str).optString("query");
                x.a(new w<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.w
                    /* renamed from: aJw */
                    public String doInBackground() {
                        com.baidu.tieba.tbadkCore.util.a.vm(optString);
                        return optString;
                    }
                }, new h<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    /* renamed from: oL */
                    public void onReturnDataInUI(String str2) {
                        c.this.fnG.remove(str2);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void ayd() {
            x.a(new w() { // from class: com.baidu.tieba.mainentrance.a.c.a.3
                @Override // com.baidu.tbadk.util.w
                public Object doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.bCo();
                    return null;
                }
            }, new h() { // from class: com.baidu.tieba.mainentrance.a.c.a.4
                @Override // com.baidu.tbadk.util.h
                public void onReturnDataInUI(Object obj) {
                    c.this.fnG.clear();
                }
            });
        }

        private void qR(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("query");
                int optInt = jSONObject.optInt("sub_type");
                if (c.this.fnE != null) {
                    c.this.fnE.a(optString, true, optInt);
                    TiebaStatic.log(new am("c12034"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
