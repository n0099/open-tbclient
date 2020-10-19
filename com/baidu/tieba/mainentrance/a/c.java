package com.baidu.tieba.mainentrance.a;

import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.aj;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import com.baidu.tieba.quickWebView.QuickWebView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class c {
    private b kuP;
    private d kuQ;
    private List<String> kuR = new ArrayList();
    private boolean kuS;
    private TbPageContext mPageContext;

    public c(BaseActivity baseActivity, b bVar, d dVar) {
        this.mPageContext = baseActivity.getPageContext();
        this.kuP = bVar;
        this.kuQ = dVar;
        cVY();
        cVZ();
    }

    private void cVY() {
        BaseWebView.c cVar = new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.a.c.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
            }
        };
        BaseWebView.f fVar = new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.a.c.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                if (webView == c.this.kuQ.cWk()) {
                    c.this.sA(false);
                }
            }
        };
        BaseWebView.b bVar = new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.a.c.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return c.this.Gw(str);
            }
        };
        QuickWebView cWk = this.kuQ.cWk();
        if (cWk != null) {
            cWk.addJsPromptInterface(new a());
            cWk.setOnPageFinishedListener(cVar);
            cWk.setOnReceivedErrorListener(fVar);
            cWk.setOnLoadUrlListener(bVar);
        }
    }

    private void cVZ() {
        ae.a(new ad<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: bFF */
            public List<String> doInBackground() {
                return com.baidu.tieba.tbadkCore.util.a.dFe();
            }
        }, new m<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: bB */
            public void onReturnDataInUI(List<String> list) {
                if (!y.isEmpty(list)) {
                    c.this.kuR = list;
                }
            }
        });
    }

    public void cWa() {
        this.kuQ.cWf();
        if (this.kuS) {
            String cWb = cWb();
            if (!StringUtils.isNull(cWb)) {
                this.kuQ.cWk().loadUrl("javascript:setSearchHistory('" + cWb + "')");
                return;
            }
            return;
        }
        this.kuQ.cWk().loadUrl(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + "n/apage-runtime/page/search_history");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cWb() {
        int count = y.getCount(this.kuR);
        if (count == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < count; i++) {
            jSONArray.put(this.kuR.get(i));
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sA(boolean z) {
        NoDataViewFactory.d pv;
        if (!z) {
            this.kuQ.cVP();
            if (j.isNetWorkAvailable()) {
                pv = NoDataViewFactory.d.pv(R.string.text_no_search_record);
            } else {
                pv = NoDataViewFactory.d.pv(R.string.neterror);
            }
            this.kuQ.a(pv);
            return;
        }
        this.kuQ.cWf();
    }

    public void Nm(String str) {
        if (!StringUtils.isNull(str) && this.kuR != null) {
            this.kuR.remove(str);
            this.kuR.add(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Gw(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC2) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC_NEW)) {
            String matchStringFromURL = aj.getMatchStringFromURL(str, "topic_id=");
            String matchStringFromURL2 = aj.getMatchStringFromURL(str, "topic_name=");
            if (!com.baidu.tbadk.plugins.b.k(this.mPageContext) && !StringUtils.isNull(matchStringFromURL) && !StringUtils.isNull(matchStringFromURL2, true)) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(matchStringFromURL, matchStringFromURL2, "4")));
            }
            TiebaStatic.log(new aq("c10363").dK("obj_name", matchStringFromURL2));
            return true;
        } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_LIST_NEW) || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage/list")) {
            if (com.baidu.tbadk.plugins.b.k(this.mPageContext)) {
                return true;
            }
            new HotRanklistActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig("hotforum", "all").start();
            return true;
        } else {
            return false;
        }
    }

    /* loaded from: classes24.dex */
    public class a implements com.baidu.tieba.tbadkCore.e.b {
        public a() {
        }

        @Override // com.baidu.tieba.tbadkCore.e.b
        public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if ("CommonJSBridge".equals(str)) {
                if ("getSearchHistory".equals(str2)) {
                    jsPromptResult.confirm(c.this.cWb());
                    c.this.kuS = true;
                    return true;
                } else if ("deleteSearchHistory".equals(str2)) {
                    Nn(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("deleteAllSearchHistory".equals(str2)) {
                    crp();
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("openSearchPage".equals(str2)) {
                    No(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private void Nn(String str) {
            try {
                final String optString = new JSONObject(str).optString("query");
                ae.a(new ad<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.ad
                    /* renamed from: cFy */
                    public String doInBackground() {
                        com.baidu.tieba.tbadkCore.util.a.Sh(optString);
                        return optString;
                    }
                }, new m<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.m
                    /* renamed from: Lb */
                    public void onReturnDataInUI(String str2) {
                        c.this.kuR.remove(str2);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void crp() {
            ae.a(new ad() { // from class: com.baidu.tieba.mainentrance.a.c.a.3
                @Override // com.baidu.tbadk.util.ad
                public Object doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.dFg();
                    return null;
                }
            }, new m() { // from class: com.baidu.tieba.mainentrance.a.c.a.4
                @Override // com.baidu.tbadk.util.m
                public void onReturnDataInUI(Object obj) {
                    c.this.kuR.clear();
                }
            });
        }

        private void No(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("query");
                int optInt = jSONObject.optInt(FuFaceItem.JK_SUB_TYPE);
                if (c.this.kuP != null) {
                    c.this.kuP.b(optString, true, optInt);
                    TiebaStatic.log(new aq("c12034"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
