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
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
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
public class SearchHistoryViewController {
    private b laR;
    private c laS;
    private List<String> laT = new ArrayList();
    private boolean laU;
    private TbPageContext mPageContext;

    public SearchHistoryViewController(BaseActivity baseActivity, b bVar, c cVar) {
        this.mPageContext = baseActivity.getPageContext();
        this.laR = bVar;
        this.laS = cVar;
        dgs();
        dgt();
    }

    private void dgs() {
        BaseWebView.c cVar = new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
            }
        };
        BaseWebView.f fVar = new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                if (webView == SearchHistoryViewController.this.laS.dgE()) {
                    SearchHistoryViewController.this.tG(false);
                }
            }
        };
        BaseWebView.b bVar = new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return SearchHistoryViewController.this.Hw(str);
            }
        };
        QuickWebView dgE = this.laS.dgE();
        if (dgE != null) {
            dgE.addJsPromptInterface(new SearchJsBridge());
            dgE.setOnPageFinishedListener(cVar);
            dgE.setOnReceivedErrorListener(fVar);
            dgE.setOnLoadUrlListener(bVar);
        }
    }

    private void dgt() {
        ad.a(new ac<List<String>>() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: bMZ */
            public List<String> doInBackground() {
                return com.baidu.tieba.tbadkCore.util.a.dQg();
            }
        }, new m<List<String>>() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: bV */
            public void onReturnDataInUI(List<String> list) {
                if (!y.isEmpty(list)) {
                    SearchHistoryViewController.this.laT = list;
                }
            }
        });
    }

    public void dgu() {
        this.laS.dgz();
        if (this.laU) {
            String dgv = dgv();
            if (!StringUtils.isNull(dgv)) {
                this.laS.dgE().loadUrl("javascript:setSearchHistory('" + dgv + "')");
                return;
            }
            return;
        }
        this.laS.dgE().loadUrl(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + "n/apage-runtime/page/search_history");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dgv() {
        int count = y.getCount(this.laT);
        if (count == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < count; i++) {
            jSONArray.put(this.laT.get(i));
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tG(boolean z) {
        NoDataViewFactory.d qP;
        if (!z) {
            this.laS.dgj();
            if (j.isNetWorkAvailable()) {
                qP = NoDataViewFactory.d.qP(R.string.text_no_search_record);
            } else {
                qP = NoDataViewFactory.d.qP(R.string.neterror);
            }
            this.laS.a(qP);
            return;
        }
        this.laS.dgz();
    }

    public void OG(String str) {
        if (!StringUtils.isNull(str) && this.laT != null) {
            this.laT.remove(str);
            this.laT.add(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Hw(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC2) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC_NEW)) {
            String matchStringFromURL = aj.getMatchStringFromURL(str, "topic_id=");
            String matchStringFromURL2 = aj.getMatchStringFromURL(str, "topic_name=");
            if (!com.baidu.tbadk.plugins.b.k(this.mPageContext) && !StringUtils.isNull(matchStringFromURL) && !StringUtils.isNull(matchStringFromURL2, true)) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(matchStringFromURL, matchStringFromURL2, "4")));
            }
            TiebaStatic.log(new ar("c10363").dY("obj_name", matchStringFromURL2));
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
                    jsPromptResult.confirm(SearchHistoryViewController.this.dgv());
                    SearchHistoryViewController.this.laU = true;
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
                ad.a(new ac<String>() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.SearchJsBridge.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.ac
                    /* renamed from: cQc */
                    public String doInBackground() {
                        com.baidu.tieba.tbadkCore.util.a.TX(optString);
                        return optString;
                    }
                }, new m<String>() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.SearchJsBridge.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.m
                    /* renamed from: My */
                    public void onReturnDataInUI(String str2) {
                        SearchHistoryViewController.this.laT.remove(str2);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void deleteAllSearchHistory() {
            ad.a(new ac() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.SearchJsBridge.3
                @Override // com.baidu.tbadk.util.ac
                public Object doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.dQi();
                    return null;
                }
            }, new m() { // from class: com.baidu.tieba.mainentrance.view.SearchHistoryViewController.SearchJsBridge.4
                @Override // com.baidu.tbadk.util.m
                public void onReturnDataInUI(Object obj) {
                    SearchHistoryViewController.this.laT.clear();
                }
            });
        }

        private void openSearchPage(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("query");
                int optInt = jSONObject.optInt(FuFaceItem.JK_SUB_TYPE);
                if (SearchHistoryViewController.this.laR != null) {
                    SearchHistoryViewController.this.laR.b(optString, true, optInt);
                    TiebaStatic.log(new ar("c12034"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
