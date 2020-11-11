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
    private b kNi;
    private d kNj;
    private List<String> kNk = new ArrayList();
    private boolean kNl;
    private TbPageContext mPageContext;

    public c(BaseActivity baseActivity, b bVar, d dVar) {
        this.mPageContext = baseActivity.getPageContext();
        this.kNi = bVar;
        this.kNj = dVar;
        dbI();
        dbJ();
    }

    private void dbI() {
        BaseWebView.c cVar = new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.a.c.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
            }
        };
        BaseWebView.f fVar = new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.a.c.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                if (webView == c.this.kNj.dbU()) {
                    c.this.tb(false);
                }
            }
        };
        BaseWebView.b bVar = new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.a.c.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return c.this.Hh(str);
            }
        };
        QuickWebView dbU = this.kNj.dbU();
        if (dbU != null) {
            dbU.addJsPromptInterface(new a());
            dbU.setOnPageFinishedListener(cVar);
            dbU.setOnReceivedErrorListener(fVar);
            dbU.setOnLoadUrlListener(bVar);
        }
    }

    private void dbJ() {
        ae.a(new ad<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: bJX */
            public List<String> doInBackground() {
                return com.baidu.tieba.tbadkCore.util.a.dKO();
            }
        }, new m<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: bR */
            public void onReturnDataInUI(List<String> list) {
                if (!y.isEmpty(list)) {
                    c.this.kNk = list;
                }
            }
        });
    }

    public void dbK() {
        this.kNj.dbP();
        if (this.kNl) {
            String dbL = dbL();
            if (!StringUtils.isNull(dbL)) {
                this.kNj.dbU().loadUrl("javascript:setSearchHistory('" + dbL + "')");
                return;
            }
            return;
        }
        this.kNj.dbU().loadUrl(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + "n/apage-runtime/page/search_history");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dbL() {
        int count = y.getCount(this.kNk);
        if (count == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < count; i++) {
            jSONArray.put(this.kNk.get(i));
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tb(boolean z) {
        NoDataViewFactory.d pQ;
        if (!z) {
            this.kNj.dbz();
            if (j.isNetWorkAvailable()) {
                pQ = NoDataViewFactory.d.pQ(R.string.text_no_search_record);
            } else {
                pQ = NoDataViewFactory.d.pQ(R.string.neterror);
            }
            this.kNj.a(pQ);
            return;
        }
        this.kNj.dbP();
    }

    public void Ob(String str) {
        if (!StringUtils.isNull(str) && this.kNk != null) {
            this.kNk.remove(str);
            this.kNk.add(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Hh(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC2) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC_NEW)) {
            String matchStringFromURL = aj.getMatchStringFromURL(str, "topic_id=");
            String matchStringFromURL2 = aj.getMatchStringFromURL(str, "topic_name=");
            if (!com.baidu.tbadk.plugins.b.k(this.mPageContext) && !StringUtils.isNull(matchStringFromURL) && !StringUtils.isNull(matchStringFromURL2, true)) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(matchStringFromURL, matchStringFromURL2, "4")));
            }
            TiebaStatic.log(new aq("c10363").dR("obj_name", matchStringFromURL2));
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
                    jsPromptResult.confirm(c.this.dbL());
                    c.this.kNl = true;
                    return true;
                } else if ("deleteSearchHistory".equals(str2)) {
                    Oc(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("deleteAllSearchHistory".equals(str2)) {
                    cwX();
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("openSearchPage".equals(str2)) {
                    Od(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private void Oc(String str) {
            try {
                final String optString = new JSONObject(str).optString("query");
                ae.a(new ad<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.ad
                    /* renamed from: cLg */
                    public String doInBackground() {
                        com.baidu.tieba.tbadkCore.util.a.SX(optString);
                        return optString;
                    }
                }, new m<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.m
                    /* renamed from: LQ */
                    public void onReturnDataInUI(String str2) {
                        c.this.kNk.remove(str2);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void cwX() {
            ae.a(new ad() { // from class: com.baidu.tieba.mainentrance.a.c.a.3
                @Override // com.baidu.tbadk.util.ad
                public Object doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.dKQ();
                    return null;
                }
            }, new m() { // from class: com.baidu.tieba.mainentrance.a.c.a.4
                @Override // com.baidu.tbadk.util.m
                public void onReturnDataInUI(Object obj) {
                    c.this.kNk.clear();
                }
            });
        }

        private void Od(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("query");
                int optInt = jSONObject.optInt(FuFaceItem.JK_SUB_TYPE);
                if (c.this.kNi != null) {
                    c.this.kNi.b(optString, true, optInt);
                    TiebaStatic.log(new aq("c12034"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
