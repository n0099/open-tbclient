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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.g;
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
    private b eXo;
    private d eXp;
    private List<String> eXq = new ArrayList();
    private boolean eXr;
    private TbPageContext mPageContext;

    public c(BaseActivity baseActivity, b bVar, d dVar) {
        this.mPageContext = baseActivity.getPageContext();
        this.eXo = bVar;
        this.eXp = dVar;
        aTt();
        aTu();
    }

    private void aTt() {
        BaseWebView.c cVar = new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.a.c.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
            }
        };
        BaseWebView.f fVar = new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.a.c.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                if (webView == c.this.eXp.aTF()) {
                    c.this.iC(false);
                }
            }
        };
        BaseWebView.b bVar = new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.a.c.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return c.this.jG(str);
            }
        };
        QuickWebView aTF = this.eXp.aTF();
        if (aTF != null) {
            aTF.addJsPromptInterface(new a());
            aTF.setOnPageFinishedListener(cVar);
            aTF.setOnReceivedErrorListener(fVar);
            aTF.setOnLoadUrlListener(bVar);
        }
    }

    private void aTu() {
        v.a(new u<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            public List<String> doInBackground() {
                return com.baidu.tieba.tbadkCore.util.a.bwX();
            }
        }, new g<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            public void onReturnDataInUI(List<String> list) {
                if (!w.z(list)) {
                    c.this.eXq = list;
                }
            }
        });
    }

    public void aTv() {
        this.eXp.aTA();
        if (this.eXr) {
            String aTw = aTw();
            if (!StringUtils.isNull(aTw)) {
                this.eXp.aTF().loadUrl("javascript:setSearchHistory('" + aTw + "')");
                return;
            }
            return;
        }
        this.eXp.aTF().loadUrl("https://tieba.baidu.com/n/apage-runtime/page/search_history");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aTw() {
        int y = w.y(this.eXq);
        if (y == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < y; i++) {
            jSONArray.put(this.eXq.get(i));
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iC(boolean z) {
        NoDataViewFactory.d du;
        if (!z) {
            this.eXp.aTk();
            if (j.jE()) {
                du = NoDataViewFactory.d.du(d.j.text_no_search_record);
            } else {
                du = NoDataViewFactory.d.du(d.j.neterror);
            }
            this.eXp.a(du);
            return;
        }
        this.eXp.aTA();
    }

    public void pF(String str) {
        if (!StringUtils.isNull(str) && this.eXq != null && !this.eXq.contains(str)) {
            this.eXq.add(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jG(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("http://tieba.baidu.com/mo/q/newhotmessage?") || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("https://tieba.baidu.com/mo/q/newhotmessage?")) {
            String at = z.at(str, "topic_id=");
            String at2 = z.at(str, "topic_name=");
            if (!com.baidu.tbadk.plugins.b.e(this.mPageContext) && !StringUtils.isNull(at) && !StringUtils.isNull(at2, true)) {
                this.mPageContext.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(at, at2, "4")));
            }
            TiebaStatic.log(new an("c10363").af("obj_name", at2));
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
                    jsPromptResult.confirm(c.this.aTw());
                    c.this.eXr = true;
                    return true;
                } else if ("deleteSearchHistory".equals(str2)) {
                    pG(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("deleteAllSearchHistory".equals(str2)) {
                    atw();
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("openSearchPage".equals(str2)) {
                    pH(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private void pG(String str) {
            try {
                final String optString = new JSONObject(str).optString("query");
                v.a(new u<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.u
                    /* renamed from: aEu */
                    public String doInBackground() {
                        com.baidu.tieba.tbadkCore.util.a.tU(optString);
                        return optString;
                    }
                }, new g<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.g
                    /* renamed from: nz */
                    public void onReturnDataInUI(String str2) {
                        c.this.eXq.remove(str2);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void atw() {
            v.a(new u() { // from class: com.baidu.tieba.mainentrance.a.c.a.3
                @Override // com.baidu.tbadk.util.u
                public Object doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.bwZ();
                    return null;
                }
            }, new g() { // from class: com.baidu.tieba.mainentrance.a.c.a.4
                @Override // com.baidu.tbadk.util.g
                public void onReturnDataInUI(Object obj) {
                    c.this.eXq.clear();
                }
            });
        }

        private void pH(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("query");
                int optInt = jSONObject.optInt("sub_type");
                if (c.this.eXo != null) {
                    c.this.eXo.b(optString, true, optInt);
                    TiebaStatic.log(new an("c12034"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
