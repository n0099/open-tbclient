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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.util.al;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import com.baidu.tieba.quickWebView.QuickWebView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class SearchHistoryViewController {
    private b lmh;
    private c lmi;
    private List<String> lmj = new ArrayList();
    private boolean lmk;
    private TbPageContext mPageContext;

    public SearchHistoryViewController(BaseActivity baseActivity, b bVar, c cVar) {
        this.mPageContext = baseActivity.getPageContext();
        this.lmh = bVar;
        this.lmi = cVar;
        deB();
        deC();
    }

    private void deB() {
        BaseWebView.c cVar = new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
            }
        };
        BaseWebView.f fVar = new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                if (webView == SearchHistoryViewController.this.lmi.deN()) {
                    SearchHistoryViewController.this.tR(false);
                }
            }
        };
        BaseWebView.b bVar = new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return SearchHistoryViewController.this.GT(str);
            }
        };
        QuickWebView deN = this.lmi.deN();
        if (deN != null) {
            deN.addJsPromptInterface(new SearchJsBridge());
            deN.setOnPageFinishedListener(cVar);
            deN.setOnReceivedErrorListener(fVar);
            deN.setOnLoadUrlListener(bVar);
        }
    }

    private void deC() {
        af.a(new ae<List<String>>() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ae
            /* renamed from: bMf */
            public List<String> doInBackground() {
                return com.baidu.tieba.tbadkCore.util.a.dON();
            }
        }, new m<List<String>>() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: bX */
            public void onReturnDataInUI(List<String> list) {
                if (!y.isEmpty(list)) {
                    SearchHistoryViewController.this.lmj = list;
                }
            }
        });
    }

    public void deD() {
        this.lmi.deI();
        if (this.lmk) {
            String deE = deE();
            if (!StringUtils.isNull(deE)) {
                this.lmi.deN().loadUrl("javascript:setSearchHistory('" + deE + "')");
                return;
            }
            return;
        }
        this.lmi.deN().loadUrl(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + "mo/q/hybrid/searchHistory");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String deE() {
        int count = y.getCount(this.lmj);
        if (count == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < count; i++) {
            jSONArray.put(this.lmj.get(i));
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tR(boolean z) {
        NoDataViewFactory.d pA;
        if (!z) {
            this.lmi.des();
            if (j.isNetWorkAvailable()) {
                pA = NoDataViewFactory.d.pA(R.string.text_no_search_record);
            } else {
                pA = NoDataViewFactory.d.pA(R.string.neterror);
            }
            this.lmi.a(pA);
            return;
        }
        this.lmi.deI();
    }

    public void Ob(String str) {
        if (!StringUtils.isNull(str) && this.lmj != null) {
            this.lmj.remove(str);
            this.lmj.add(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GT(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC2) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC_NEW)) {
            String matchStringFromURL = al.getMatchStringFromURL(str, "topic_id=");
            String matchStringFromURL2 = al.getMatchStringFromURL(str, "topic_name=");
            if (!com.baidu.tbadk.plugins.b.k(this.mPageContext) && !StringUtils.isNull(matchStringFromURL) && !StringUtils.isNull(matchStringFromURL2, true)) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(matchStringFromURL, matchStringFromURL2, "4")));
            }
            TiebaStatic.log(new ar("c10363").dR("obj_name", matchStringFromURL2));
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

    /* loaded from: classes7.dex */
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
                    jsPromptResult.confirm(SearchHistoryViewController.this.deE());
                    SearchHistoryViewController.this.lmk = true;
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
                af.a(new ae<String>() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.SearchJsBridge.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.ae
                    /* renamed from: cRE */
                    public String doInBackground() {
                        com.baidu.tieba.tbadkCore.util.a.TP(optString);
                        return optString;
                    }
                }, new m<String>() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.SearchJsBridge.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.m
                    /* renamed from: Ml */
                    public void onReturnDataInUI(String str2) {
                        SearchHistoryViewController.this.lmj.remove(str2);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void deleteAllSearchHistory() {
            af.a(new ae() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.SearchJsBridge.3
                @Override // com.baidu.tbadk.util.ae
                public Object doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.dOP();
                    return null;
                }
            }, new m() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.SearchJsBridge.4
                @Override // com.baidu.tbadk.util.m
                public void onReturnDataInUI(Object obj) {
                    SearchHistoryViewController.this.lmj.clear();
                }
            });
        }

        private void openSearchPage(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("query");
                int optInt = jSONObject.optInt(FuFaceItem.JK_SUB_TYPE);
                if (SearchHistoryViewController.this.lmh != null) {
                    SearchHistoryViewController.this.lmh.b(optString, true, optInt);
                    TiebaStatic.log(new ar("c12034"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
