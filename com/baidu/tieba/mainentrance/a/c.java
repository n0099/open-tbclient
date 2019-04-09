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
import com.baidu.tieba.d;
import com.baidu.tieba.quickWebView.QuickWebView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    private b gOg;
    private d gOh;
    private List<String> gOi = new ArrayList();
    private boolean gOj;
    private TbPageContext mPageContext;

    public c(BaseActivity baseActivity, b bVar, d dVar) {
        this.mPageContext = baseActivity.getPageContext();
        this.gOg = bVar;
        this.gOh = dVar;
        bBT();
        bBU();
    }

    private void bBT() {
        BaseWebView.c cVar = new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.a.c.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
            }
        };
        BaseWebView.f fVar = new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.a.c.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                if (webView == c.this.gOh.bCf()) {
                    c.this.mj(false);
                }
            }
        };
        BaseWebView.b bVar = new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.a.c.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return c.this.sj(str);
            }
        };
        QuickWebView bCf = this.gOh.bCf();
        if (bCf != null) {
            bCf.addJsPromptInterface(new a());
            bCf.setOnPageFinishedListener(cVar);
            bCf.setOnReceivedErrorListener(fVar);
            bCf.setOnLoadUrlListener(bVar);
        }
    }

    private void bBU() {
        aa.a(new z<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            public List<String> doInBackground() {
                return com.baidu.tieba.tbadkCore.util.a.cff();
            }
        }, new k<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            public void onReturnDataInUI(List<String> list) {
                if (!v.T(list)) {
                    c.this.gOi = list;
                }
            }
        });
    }

    public void bBV() {
        this.gOh.bCa();
        if (this.gOj) {
            String bBW = bBW();
            if (!StringUtils.isNull(bBW)) {
                this.gOh.bCf().loadUrl("javascript:setSearchHistory('" + bBW + "')");
                return;
            }
            return;
        }
        this.gOh.bCf().loadUrl("https://tieba.baidu.com/n/apage-runtime/page/search_history");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bBW() {
        int S = v.S(this.gOi);
        if (S == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < S; i++) {
            jSONArray.put(this.gOi.get(i));
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mj(boolean z) {
        NoDataViewFactory.d hT;
        if (!z) {
            this.gOh.bBK();
            if (j.kY()) {
                hT = NoDataViewFactory.d.hT(d.j.text_no_search_record);
            } else {
                hT = NoDataViewFactory.d.hT(d.j.neterror);
            }
            this.gOh.a(hT);
            return;
        }
        this.gOh.bCa();
    }

    public void ym(String str) {
        if (!StringUtils.isNull(str) && this.gOi != null && !this.gOi.contains(str)) {
            this.gOi.add(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sj(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("http://tieba.baidu.com/mo/q/newhotmessage?") || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("https://tieba.baidu.com/mo/q/newhotmessage?")) {
            String bU = ae.bU(str, "topic_id=");
            String bU2 = ae.bU(str, "topic_name=");
            if (!com.baidu.tbadk.plugins.b.f(this.mPageContext) && !StringUtils.isNull(bU) && !StringUtils.isNull(bU2, true)) {
                this.mPageContext.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(bU, bU2, "4")));
            }
            TiebaStatic.log(new am("c10363").bJ("obj_name", bU2));
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
                    jsPromptResult.confirm(c.this.bBW());
                    c.this.gOj = true;
                    return true;
                } else if ("deleteSearchHistory".equals(str2)) {
                    yn(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("deleteAllSearchHistory".equals(str2)) {
                    bbw();
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("openSearchPage".equals(str2)) {
                    yo(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private void yn(String str) {
            try {
                final String optString = new JSONObject(str).optString("query");
                aa.a(new z<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.z
                    /* renamed from: bmF */
                    public String doInBackground() {
                        com.baidu.tieba.tbadkCore.util.a.CI(optString);
                        return optString;
                    }
                }, new k<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.k
                    /* renamed from: wi */
                    public void onReturnDataInUI(String str2) {
                        c.this.gOi.remove(str2);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void bbw() {
            aa.a(new z() { // from class: com.baidu.tieba.mainentrance.a.c.a.3
                @Override // com.baidu.tbadk.util.z
                public Object doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.cfh();
                    return null;
                }
            }, new k() { // from class: com.baidu.tieba.mainentrance.a.c.a.4
                @Override // com.baidu.tbadk.util.k
                public void onReturnDataInUI(Object obj) {
                    c.this.gOi.clear();
                }
            });
        }

        private void yo(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("query");
                int optInt = jSONObject.optInt("sub_type");
                if (c.this.gOg != null) {
                    c.this.gOg.a(optString, true, optInt);
                    TiebaStatic.log(new am("c12034"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
