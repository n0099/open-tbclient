package com.baidu.tieba.mainentrance.view;

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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ai;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import com.baidu.tieba.quickWebView.QuickWebView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class SearchHistoryViewController {
    private b lgv;
    private c lgw;
    private List<String> lgx = new ArrayList();
    private boolean lgy;
    private TbPageContext mPageContext;

    public SearchHistoryViewController(BaseActivity baseActivity, b bVar, c cVar) {
        this.mPageContext = baseActivity.getPageContext();
        this.lgv = bVar;
        this.lgw = cVar;
        dgf();
        dgg();
    }

    private void dgf() {
        BaseWebView.c cVar = new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
            }
        };
        BaseWebView.f fVar = new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                if (webView == SearchHistoryViewController.this.lgw.dgr()) {
                    SearchHistoryViewController.this.tI(false);
                }
            }
        };
        BaseWebView.b bVar = new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return SearchHistoryViewController.this.Hv(str);
            }
        };
        QuickWebView dgr = this.lgw.dgr();
        if (dgr != null) {
            dgr.addJsPromptInterface(new SearchJsBridge());
            dgr.setOnPageFinishedListener(cVar);
            dgr.setOnReceivedErrorListener(fVar);
            dgr.setOnLoadUrlListener(bVar);
        }
    }

    private void dgg() {
        ac.a(new ab<List<String>>() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bPs */
            public List<String> doInBackground() {
                return com.baidu.tieba.tbadkCore.util.a.dQd();
            }
        }, new l<List<String>>() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: cc */
            public void onReturnDataInUI(List<String> list) {
                if (!x.isEmpty(list)) {
                    SearchHistoryViewController.this.lgx = list;
                }
            }
        });
    }

    public void dgh() {
        this.lgw.dgm();
        if (this.lgy) {
            String dgi = dgi();
            if (!StringUtils.isNull(dgi)) {
                this.lgw.dgr().loadUrl("javascript:setSearchHistory('" + dgi + "')");
                return;
            }
            return;
        }
        this.lgw.dgr().loadUrl(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + "n/apage-runtime/page/search_history");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dgi() {
        int count = x.getCount(this.lgx);
        if (count == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < count; i++) {
            jSONArray.put(this.lgx.get(i));
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tI(boolean z) {
        NoDataViewFactory.d ra;
        if (!z) {
            this.lgw.dfW();
            if (j.isNetWorkAvailable()) {
                ra = NoDataViewFactory.d.ra(R.string.text_no_search_record);
            } else {
                ra = NoDataViewFactory.d.ra(R.string.neterror);
            }
            this.lgw.a(ra);
            return;
        }
        this.lgw.dgm();
    }

    public void On(String str) {
        if (!StringUtils.isNull(str) && this.lgx != null) {
            this.lgx.remove(str);
            this.lgx.add(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Hv(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC2) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC_NEW)) {
            String matchStringFromURL = ai.getMatchStringFromURL(str, "topic_id=");
            String matchStringFromURL2 = ai.getMatchStringFromURL(str, "topic_name=");
            if (!com.baidu.tbadk.plugins.b.k(this.mPageContext) && !StringUtils.isNull(matchStringFromURL) && !StringUtils.isNull(matchStringFromURL2, true)) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(matchStringFromURL, matchStringFromURL2, "4")));
            }
            TiebaStatic.log(new aq("c10363").dX("obj_name", matchStringFromURL2));
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

    /* loaded from: classes8.dex */
    public class SearchJsBridge implements com.baidu.tieba.tbadkCore.e.b {
        public static final String INTERFACE_NAME = "CommonJSBridge";
        public static final String METHOD_DELETE_ALL_SEARCH_HISTORY = "deleteAllSearchHistory";
        public static final String METHOD_DELETE_SEARCH_HISTORY = "deleteSearchHistory";
        public static final String METHOD_GET_SEARCH_HISTORY = "getSearchHistory";
        public static final String METHOD_OPEN_SEACH_PAGE = "openSearchPage";
        public static final String METHOD_SET_SEARCH_HISTORY = "setSearchHistory";
        public static final String SUCCESS_CODE = "1";

        public SearchJsBridge() {
        }

        @Override // com.baidu.tieba.tbadkCore.e.b
        public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if ("CommonJSBridge".equals(str)) {
                if (METHOD_GET_SEARCH_HISTORY.equals(str2)) {
                    jsPromptResult.confirm(SearchHistoryViewController.this.dgi());
                    SearchHistoryViewController.this.lgy = true;
                    return true;
                } else if (METHOD_DELETE_SEARCH_HISTORY.equals(str2)) {
                    deleteSearchHistory(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else if (METHOD_DELETE_ALL_SEARCH_HISTORY.equals(str2)) {
                    deleteAllSearchHistory();
                    jsPromptResult.confirm("1");
                    return true;
                } else if (METHOD_OPEN_SEACH_PAGE.equals(str2)) {
                    openSearchPage(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private void deleteSearchHistory(String str) {
            try {
                final String optString = new JSONObject(str).optString("query");
                ac.a(new ab<String>() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.SearchJsBridge.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.ab
                    /* renamed from: cTj */
                    public String doInBackground() {
                        com.baidu.tieba.tbadkCore.util.a.TG(optString);
                        return optString;
                    }
                }, new l<String>() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.SearchJsBridge.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.l
                    /* renamed from: Mx */
                    public void onReturnDataInUI(String str2) {
                        SearchHistoryViewController.this.lgx.remove(str2);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void deleteAllSearchHistory() {
            ac.a(new ab() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.SearchJsBridge.3
                @Override // com.baidu.tbadk.util.ab
                public Object doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.dQf();
                    return null;
                }
            }, new l() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.SearchJsBridge.4
                @Override // com.baidu.tbadk.util.l
                public void onReturnDataInUI(Object obj) {
                    SearchHistoryViewController.this.lgx.clear();
                }
            });
        }

        private void openSearchPage(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("query");
                int optInt = jSONObject.optInt(FuFaceItem.JK_SUB_TYPE);
                if (SearchHistoryViewController.this.lgv != null) {
                    SearchHistoryViewController.this.lgv.b(optString, true, optInt);
                    TiebaStatic.log(new aq("c12034"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
