package com.baidu.tieba.mainentrance.a;

import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.j;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.quickWebView.QuickWebView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    private b hoB;
    private d hoC;
    private List<String> hoD = new ArrayList();
    private boolean hoE;
    private TbPageContext mPageContext;

    public c(BaseActivity baseActivity, b bVar, d dVar) {
        this.mPageContext = baseActivity.getPageContext();
        this.hoB = bVar;
        this.hoC = dVar;
        bNp();
        bNq();
    }

    private void bNp() {
        BaseWebView.c cVar = new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.a.c.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
            }
        };
        BaseWebView.f fVar = new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.a.c.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                if (webView == c.this.hoC.bNB()) {
                    c.this.nq(false);
                }
            }
        };
        BaseWebView.b bVar = new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.a.c.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return c.this.ut(str);
            }
        };
        QuickWebView bNB = this.hoC.bNB();
        if (bNB != null) {
            bNB.addJsPromptInterface(new a());
            bNB.setOnPageFinishedListener(cVar);
            bNB.setOnReceivedErrorListener(fVar);
            bNB.setOnLoadUrlListener(bVar);
        }
    }

    private void bNq() {
        z.a(new y<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.y
            public List<String> doInBackground() {
                return com.baidu.tieba.tbadkCore.util.a.crp();
            }
        }, new j<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.j
            public void onReturnDataInUI(List<String> list) {
                if (!v.aa(list)) {
                    c.this.hoD = list;
                }
            }
        });
    }

    public void bNr() {
        this.hoC.bNw();
        if (this.hoE) {
            String bNs = bNs();
            if (!StringUtils.isNull(bNs)) {
                this.hoC.bNB().loadUrl("javascript:setSearchHistory('" + bNs + "')");
                return;
            }
            return;
        }
        this.hoC.bNB().loadUrl("https://tieba.baidu.com/n/apage-runtime/page/search_history");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bNs() {
        int Z = v.Z(this.hoD);
        if (Z == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < Z; i++) {
            jSONArray.put(this.hoD.get(i));
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nq(boolean z) {
        NoDataViewFactory.d iQ;
        if (!z) {
            this.hoC.bNg();
            if (com.baidu.adp.lib.util.j.kc()) {
                iQ = NoDataViewFactory.d.iQ(R.string.text_no_search_record);
            } else {
                iQ = NoDataViewFactory.d.iQ(R.string.neterror);
            }
            this.hoC.a(iQ);
            return;
        }
        this.hoC.bNw();
    }

    public void AP(String str) {
        if (!StringUtils.isNull(str) && this.hoD != null && !this.hoD.contains(str)) {
            this.hoD.add(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ut(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("http://tieba.baidu.com/mo/q/newhotmessage?") || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("https://tieba.baidu.com/mo/q/newhotmessage?")) {
            String cf = ad.cf(str, "topic_id=");
            String cf2 = ad.cf(str, "topic_name=");
            if (!com.baidu.tbadk.plugins.b.f(this.mPageContext) && !StringUtils.isNull(cf) && !StringUtils.isNull(cf2, true)) {
                this.mPageContext.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(cf, cf2, "4")));
            }
            TiebaStatic.log(new an("c10363").bT("obj_name", cf2));
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
                    jsPromptResult.confirm(c.this.bNs());
                    c.this.hoE = true;
                    return true;
                } else if ("deleteSearchHistory".equals(str2)) {
                    AQ(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("deleteAllSearchHistory".equals(str2)) {
                    blJ();
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("openSearchPage".equals(str2)) {
                    AR(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private void AQ(String str) {
            try {
                final String optString = new JSONObject(str).optString("query");
                z.a(new y<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.y
                    /* renamed from: bxR */
                    public String doInBackground() {
                        com.baidu.tieba.tbadkCore.util.a.Fu(optString);
                        return optString;
                    }
                }, new j<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.j
                    /* renamed from: yI */
                    public void onReturnDataInUI(String str2) {
                        c.this.hoD.remove(str2);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void blJ() {
            z.a(new y() { // from class: com.baidu.tieba.mainentrance.a.c.a.3
                @Override // com.baidu.tbadk.util.y
                public Object doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.crr();
                    return null;
                }
            }, new j() { // from class: com.baidu.tieba.mainentrance.a.c.a.4
                @Override // com.baidu.tbadk.util.j
                public void onReturnDataInUI(Object obj) {
                    c.this.hoD.clear();
                }
            });
        }

        private void AR(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("query");
                int optInt = jSONObject.optInt("sub_type");
                if (c.this.hoB != null) {
                    c.this.hoB.a(optString, true, optInt);
                    TiebaStatic.log(new an("c12034"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
