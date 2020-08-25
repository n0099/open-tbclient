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
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ai;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import com.baidu.tieba.quickWebView.QuickWebView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class c {
    private b jWS;
    private d jWT;
    private List<String> jWU = new ArrayList();
    private boolean jWV;
    private TbPageContext mPageContext;

    public c(BaseActivity baseActivity, b bVar, d dVar) {
        this.mPageContext = baseActivity.getPageContext();
        this.jWS = bVar;
        this.jWT = dVar;
        cOI();
        cOJ();
    }

    private void cOI() {
        BaseWebView.c cVar = new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.a.c.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
            }
        };
        BaseWebView.f fVar = new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.a.c.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                if (webView == c.this.jWT.cOU()) {
                    c.this.rJ(false);
                }
            }
        };
        BaseWebView.b bVar = new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.a.c.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return c.this.Fm(str);
            }
        };
        QuickWebView cOU = this.jWT.cOU();
        if (cOU != null) {
            cOU.addJsPromptInterface(new a());
            cOU.setOnPageFinishedListener(cVar);
            cOU.setOnReceivedErrorListener(fVar);
            cOU.setOnLoadUrlListener(bVar);
        }
    }

    private void cOJ() {
        ad.a(new ac<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: bBG */
            public List<String> doInBackground() {
                return com.baidu.tieba.tbadkCore.util.a.dxu();
            }
        }, new l<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: bt */
            public void onReturnDataInUI(List<String> list) {
                if (!y.isEmpty(list)) {
                    c.this.jWU = list;
                }
            }
        });
    }

    public void cOK() {
        this.jWT.cOP();
        if (this.jWV) {
            String cOL = cOL();
            if (!StringUtils.isNull(cOL)) {
                this.jWT.cOU().loadUrl("javascript:setSearchHistory('" + cOL + "')");
                return;
            }
            return;
        }
        this.jWT.cOU().loadUrl(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + "n/apage-runtime/page/search_history");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cOL() {
        int count = y.getCount(this.jWU);
        if (count == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < count; i++) {
            jSONArray.put(this.jWU.get(i));
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rJ(boolean z) {
        NoDataViewFactory.d oK;
        if (!z) {
            this.jWT.cOz();
            if (j.isNetWorkAvailable()) {
                oK = NoDataViewFactory.d.oK(R.string.text_no_search_record);
            } else {
                oK = NoDataViewFactory.d.oK(R.string.neterror);
            }
            this.jWT.a(oK);
            return;
        }
        this.jWT.cOP();
    }

    public void LU(String str) {
        if (!StringUtils.isNull(str) && this.jWU != null) {
            this.jWU.remove(str);
            this.jWU.add(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Fm(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC2) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC_NEW)) {
            String matchStringFromURL = ai.getMatchStringFromURL(str, "topic_id=");
            String matchStringFromURL2 = ai.getMatchStringFromURL(str, "topic_name=");
            if (!com.baidu.tbadk.plugins.b.k(this.mPageContext) && !StringUtils.isNull(matchStringFromURL) && !StringUtils.isNull(matchStringFromURL2, true)) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(matchStringFromURL, matchStringFromURL2, "4")));
            }
            TiebaStatic.log(new aq("c10363").dD("obj_name", matchStringFromURL2));
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

    /* loaded from: classes18.dex */
    public class a implements com.baidu.tieba.tbadkCore.e.b {
        public a() {
        }

        @Override // com.baidu.tieba.tbadkCore.e.b
        public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if ("CommonJSBridge".equals(str)) {
                if ("getSearchHistory".equals(str2)) {
                    jsPromptResult.confirm(c.this.cOL());
                    c.this.jWV = true;
                    return true;
                } else if ("deleteSearchHistory".equals(str2)) {
                    LV(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("deleteAllSearchHistory".equals(str2)) {
                    ckD();
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("openSearchPage".equals(str2)) {
                    LW(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private void LV(String str) {
            try {
                final String optString = new JSONObject(str).optString("query");
                ad.a(new ac<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.ac
                    /* renamed from: cyg */
                    public String doInBackground() {
                        com.baidu.tieba.tbadkCore.util.a.QT(optString);
                        return optString;
                    }
                }, new l<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.l
                    /* renamed from: JJ */
                    public void onReturnDataInUI(String str2) {
                        c.this.jWU.remove(str2);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void ckD() {
            ad.a(new ac() { // from class: com.baidu.tieba.mainentrance.a.c.a.3
                @Override // com.baidu.tbadk.util.ac
                public Object doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.dxw();
                    return null;
                }
            }, new l() { // from class: com.baidu.tieba.mainentrance.a.c.a.4
                @Override // com.baidu.tbadk.util.l
                public void onReturnDataInUI(Object obj) {
                    c.this.jWU.clear();
                }
            });
        }

        private void LW(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("query");
                int optInt = jSONObject.optInt(FuFaceItem.JK_SUB_TYPE);
                if (c.this.jWS != null) {
                    c.this.jWS.b(optString, true, optInt);
                    TiebaStatic.log(new aq("c12034"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
