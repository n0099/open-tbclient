package com.baidu.tieba.mainentrance.a;

import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.quickWebView.QuickWebView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private b ihR;
    private d ihS;
    private List<String> ihT = new ArrayList();
    private boolean ihU;
    private TbPageContext mPageContext;

    public c(BaseActivity baseActivity, b bVar, d dVar) {
        this.mPageContext = baseActivity.getPageContext();
        this.ihR = bVar;
        this.ihS = dVar;
        ceM();
        ceN();
    }

    private void ceM() {
        BaseWebView.c cVar = new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.a.c.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
            }
        };
        BaseWebView.f fVar = new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.a.c.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                if (webView == c.this.ihS.ceY()) {
                    c.this.oL(false);
                }
            }
        };
        BaseWebView.b bVar = new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.a.c.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return c.this.yp(str);
            }
        };
        QuickWebView ceY = this.ihS.ceY();
        if (ceY != null) {
            ceY.addJsPromptInterface(new a());
            ceY.setOnPageFinishedListener(cVar);
            ceY.setOnReceivedErrorListener(fVar);
            ceY.setOnLoadUrlListener(bVar);
        }
    }

    private void ceN() {
        ac.a(new ab<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: aYR */
            public List<String> doInBackground() {
                return com.baidu.tieba.tbadkCore.util.a.cMn();
            }
        }, new l<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: ba */
            public void onReturnDataInUI(List<String> list) {
                if (!v.isEmpty(list)) {
                    c.this.ihT = list;
                }
            }
        });
    }

    public void ceO() {
        this.ihS.ceT();
        if (this.ihU) {
            String ceP = ceP();
            if (!StringUtils.isNull(ceP)) {
                this.ihS.ceY().loadUrl("javascript:setSearchHistory('" + ceP + "')");
                return;
            }
            return;
        }
        this.ihS.ceY().loadUrl("https://tieba.baidu.com/n/apage-runtime/page/search_history");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ceP() {
        int count = v.getCount(this.ihT);
        if (count == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < count; i++) {
            jSONArray.put(this.ihT.get(i));
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oL(boolean z) {
        NoDataViewFactory.d lh;
        if (!z) {
            this.ihS.ceD();
            if (j.isNetWorkAvailable()) {
                lh = NoDataViewFactory.d.lh(R.string.text_no_search_record);
            } else {
                lh = NoDataViewFactory.d.lh(R.string.neterror);
            }
            this.ihS.a(lh);
            return;
        }
        this.ihS.ceT();
    }

    public void Es(String str) {
        if (!StringUtils.isNull(str) && this.ihT != null && !this.ihT.contains(str)) {
            this.ihT.add(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yp(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC2) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC_NEW)) {
            String matchStringFromURL = ag.getMatchStringFromURL(str, "topic_id=");
            String matchStringFromURL2 = ag.getMatchStringFromURL(str, "topic_name=");
            if (!com.baidu.tbadk.plugins.b.h(this.mPageContext) && !StringUtils.isNull(matchStringFromURL) && !StringUtils.isNull(matchStringFromURL2, true)) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(matchStringFromURL, matchStringFromURL2, "4")));
            }
            TiebaStatic.log(new an("c10363").cx("obj_name", matchStringFromURL2));
            return true;
        } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_LIST_NEW) || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage/list")) {
            if (com.baidu.tbadk.plugins.b.h(this.mPageContext)) {
                return true;
            }
            new HotRanklistActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig("hotforum", SchemeCollecter.CLASSIFY_ALL).start();
            return true;
        } else {
            return false;
        }
    }

    /* loaded from: classes11.dex */
    public class a implements com.baidu.tieba.tbadkCore.e.b {
        public a() {
        }

        @Override // com.baidu.tieba.tbadkCore.e.b
        public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if ("CommonJSBridge".equals(str)) {
                if ("getSearchHistory".equals(str2)) {
                    jsPromptResult.confirm(c.this.ceP());
                    c.this.ihU = true;
                    return true;
                } else if ("deleteSearchHistory".equals(str2)) {
                    Et(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("deleteAllSearchHistory".equals(str2)) {
                    bCV();
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("openSearchPage".equals(str2)) {
                    Eu(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private void Et(String str) {
            try {
                final String optString = new JSONObject(str).optString("query");
                ac.a(new ab<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.ab
                    /* renamed from: bPi */
                    public String doInBackground() {
                        com.baidu.tieba.tbadkCore.util.a.Jl(optString);
                        return optString;
                    }
                }, new l<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.l
                    /* renamed from: Cl */
                    public void onReturnDataInUI(String str2) {
                        c.this.ihT.remove(str2);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void bCV() {
            ac.a(new ab() { // from class: com.baidu.tieba.mainentrance.a.c.a.3
                @Override // com.baidu.tbadk.util.ab
                public Object doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.cMp();
                    return null;
                }
            }, new l() { // from class: com.baidu.tieba.mainentrance.a.c.a.4
                @Override // com.baidu.tbadk.util.l
                public void onReturnDataInUI(Object obj) {
                    c.this.ihT.clear();
                }
            });
        }

        private void Eu(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("query");
                int optInt = jSONObject.optInt("sub_type");
                if (c.this.ihR != null) {
                    c.this.ihR.b(optString, true, optInt);
                    TiebaStatic.log(new an("c12034"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
