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
import com.baidu.tbadk.core.util.an;
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
    private b hmH;
    private d hmI;
    private List<String> hmJ = new ArrayList();
    private boolean hmK;
    private TbPageContext mPageContext;

    public c(BaseActivity baseActivity, b bVar, d dVar) {
        this.mPageContext = baseActivity.getPageContext();
        this.hmH = bVar;
        this.hmI = dVar;
        bMC();
        bMD();
    }

    private void bMC() {
        BaseWebView.c cVar = new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.a.c.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
            }
        };
        BaseWebView.f fVar = new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.a.c.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                if (webView == c.this.hmI.bMO()) {
                    c.this.nn(false);
                }
            }
        };
        BaseWebView.b bVar = new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.a.c.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return c.this.tU(str);
            }
        };
        QuickWebView bMO = this.hmI.bMO();
        if (bMO != null) {
            bMO.addJsPromptInterface(new a());
            bMO.setOnPageFinishedListener(cVar);
            bMO.setOnReceivedErrorListener(fVar);
            bMO.setOnLoadUrlListener(bVar);
        }
    }

    private void bMD() {
        aa.a(new z<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            public List<String> doInBackground() {
                return com.baidu.tieba.tbadkCore.util.a.cqB();
            }
        }, new k<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            public void onReturnDataInUI(List<String> list) {
                if (!v.aa(list)) {
                    c.this.hmJ = list;
                }
            }
        });
    }

    public void bME() {
        this.hmI.bMJ();
        if (this.hmK) {
            String bMF = bMF();
            if (!StringUtils.isNull(bMF)) {
                this.hmI.bMO().loadUrl("javascript:setSearchHistory('" + bMF + "')");
                return;
            }
            return;
        }
        this.hmI.bMO().loadUrl("https://tieba.baidu.com/n/apage-runtime/page/search_history");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bMF() {
        int Z = v.Z(this.hmJ);
        if (Z == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < Z; i++) {
            jSONArray.put(this.hmJ.get(i));
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nn(boolean z) {
        NoDataViewFactory.d iN;
        if (!z) {
            this.hmI.bMt();
            if (j.kc()) {
                iN = NoDataViewFactory.d.iN(R.string.text_no_search_record);
            } else {
                iN = NoDataViewFactory.d.iN(R.string.neterror);
            }
            this.hmI.a(iN);
            return;
        }
        this.hmI.bMJ();
    }

    public void Aq(String str) {
        if (!StringUtils.isNull(str) && this.hmJ != null && !this.hmJ.contains(str)) {
            this.hmJ.add(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tU(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("http://tieba.baidu.com/mo/q/newhotmessage?") || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("https://tieba.baidu.com/mo/q/newhotmessage?")) {
            String cf = ae.cf(str, "topic_id=");
            String cf2 = ae.cf(str, "topic_name=");
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
                    jsPromptResult.confirm(c.this.bMF());
                    c.this.hmK = true;
                    return true;
                } else if ("deleteSearchHistory".equals(str2)) {
                    Ar(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("deleteAllSearchHistory".equals(str2)) {
                    bkY();
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("openSearchPage".equals(str2)) {
                    As(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private void Ar(String str) {
            try {
                final String optString = new JSONObject(str).optString("query");
                aa.a(new z<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.z
                    /* renamed from: bxd */
                    public String doInBackground() {
                        com.baidu.tieba.tbadkCore.util.a.EU(optString);
                        return optString;
                    }
                }, new k<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.k
                    /* renamed from: yj */
                    public void onReturnDataInUI(String str2) {
                        c.this.hmJ.remove(str2);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void bkY() {
            aa.a(new z() { // from class: com.baidu.tieba.mainentrance.a.c.a.3
                @Override // com.baidu.tbadk.util.z
                public Object doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.cqD();
                    return null;
                }
            }, new k() { // from class: com.baidu.tieba.mainentrance.a.c.a.4
                @Override // com.baidu.tbadk.util.k
                public void onReturnDataInUI(Object obj) {
                    c.this.hmJ.clear();
                }
            });
        }

        private void As(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("query");
                int optInt = jSONObject.optInt("sub_type");
                if (c.this.hmH != null) {
                    c.this.hmH.a(optString, true, optInt);
                    TiebaStatic.log(new an("c12034"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
