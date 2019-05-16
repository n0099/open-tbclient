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
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.quickWebView.QuickWebView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    private List<String> hfA = new ArrayList();
    private boolean hfB;
    private b hfy;
    private d hfz;
    private TbPageContext mPageContext;

    public c(BaseActivity baseActivity, b bVar, d dVar) {
        this.mPageContext = baseActivity.getPageContext();
        this.hfy = bVar;
        this.hfz = dVar;
        bJD();
        bJE();
    }

    private void bJD() {
        BaseWebView.c cVar = new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.a.c.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
            }
        };
        BaseWebView.f fVar = new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.a.c.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                if (webView == c.this.hfz.bJP()) {
                    c.this.mY(false);
                }
            }
        };
        BaseWebView.b bVar = new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.a.c.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return c.this.tx(str);
            }
        };
        QuickWebView bJP = this.hfz.bJP();
        if (bJP != null) {
            bJP.addJsPromptInterface(new a());
            bJP.setOnPageFinishedListener(cVar);
            bJP.setOnReceivedErrorListener(fVar);
            bJP.setOnLoadUrlListener(bVar);
        }
    }

    private void bJE() {
        aa.a(new z<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            public List<String> doInBackground() {
                return com.baidu.tieba.tbadkCore.util.a.cnj();
            }
        }, new k<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            public void onReturnDataInUI(List<String> list) {
                if (!v.aa(list)) {
                    c.this.hfA = list;
                }
            }
        });
    }

    public void bJF() {
        this.hfz.bJK();
        if (this.hfB) {
            String bJG = bJG();
            if (!StringUtils.isNull(bJG)) {
                this.hfz.bJP().loadUrl("javascript:setSearchHistory('" + bJG + "')");
                return;
            }
            return;
        }
        this.hfz.bJP().loadUrl("https://tieba.baidu.com/n/apage-runtime/page/search_history");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bJG() {
        int Z = v.Z(this.hfA);
        if (Z == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < Z; i++) {
            jSONArray.put(this.hfA.get(i));
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mY(boolean z) {
        NoDataViewFactory.d iH;
        if (!z) {
            this.hfz.bJu();
            if (j.jS()) {
                iH = NoDataViewFactory.d.iH(R.string.text_no_search_record);
            } else {
                iH = NoDataViewFactory.d.iH(R.string.neterror);
            }
            this.hfz.a(iH);
            return;
        }
        this.hfz.bJK();
    }

    public void zC(String str) {
        if (!StringUtils.isNull(str) && this.hfA != null && !this.hfA.contains(str)) {
            this.hfA.add(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tx(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("http://tieba.baidu.com/mo/q/newhotmessage?") || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("https://tieba.baidu.com/mo/q/newhotmessage?")) {
            String ce = ae.ce(str, "topic_id=");
            String ce2 = ae.ce(str, "topic_name=");
            if (!com.baidu.tbadk.plugins.b.f(this.mPageContext) && !StringUtils.isNull(ce) && !StringUtils.isNull(ce2, true)) {
                this.mPageContext.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(ce, ce2, "4")));
            }
            TiebaStatic.log(new am("c10363").bT("obj_name", ce2));
            return true;
        } else if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage/list") || str.startsWith(TbConfig.URL_HOST_TOPIC_LIST)) {
            if (com.baidu.tbadk.plugins.b.f(this.mPageContext)) {
                return true;
            }
            new HotRanklistActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig("hotforum", "all").start();
            return true;
        } else {
            return false;
        }
    }

    /* loaded from: classes6.dex */
    public class a implements com.baidu.tieba.tbadkCore.e.b {
        public a() {
        }

        @Override // com.baidu.tieba.tbadkCore.e.b
        public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if ("CommonJSBridge".equals(str)) {
                if ("getSearchHistory".equals(str2)) {
                    jsPromptResult.confirm(c.this.bJG());
                    c.this.hfB = true;
                    return true;
                } else if ("deleteSearchHistory".equals(str2)) {
                    zD(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("deleteAllSearchHistory".equals(str2)) {
                    biM();
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("openSearchPage".equals(str2)) {
                    zE(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private void zD(String str) {
            try {
                final String optString = new JSONObject(str).optString("query");
                aa.a(new z<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.z
                    /* renamed from: buh */
                    public String doInBackground() {
                        com.baidu.tieba.tbadkCore.util.a.Ee(optString);
                        return optString;
                    }
                }, new k<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.k
                    /* renamed from: xx */
                    public void onReturnDataInUI(String str2) {
                        c.this.hfA.remove(str2);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void biM() {
            aa.a(new z() { // from class: com.baidu.tieba.mainentrance.a.c.a.3
                @Override // com.baidu.tbadk.util.z
                public Object doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.cnl();
                    return null;
                }
            }, new k() { // from class: com.baidu.tieba.mainentrance.a.c.a.4
                @Override // com.baidu.tbadk.util.k
                public void onReturnDataInUI(Object obj) {
                    c.this.hfA.clear();
                }
            });
        }

        private void zE(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("query");
                int optInt = jSONObject.optInt("sub_type");
                if (c.this.hfy != null) {
                    c.this.hfy.a(optString, true, optInt);
                    TiebaStatic.log(new am("c12034"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
