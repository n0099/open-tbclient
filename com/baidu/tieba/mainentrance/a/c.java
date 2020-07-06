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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ah;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import com.baidu.tieba.quickWebView.QuickWebView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private b jyV;
    private d jyW;
    private List<String> jyX = new ArrayList();
    private boolean jyY;
    private TbPageContext mPageContext;

    public c(BaseActivity baseActivity, b bVar, d dVar) {
        this.mPageContext = baseActivity.getPageContext();
        this.jyV = bVar;
        this.jyW = dVar;
        czU();
        czV();
    }

    private void czU() {
        BaseWebView.c cVar = new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.a.c.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
            }
        };
        BaseWebView.f fVar = new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.a.c.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                if (webView == c.this.jyW.cAg()) {
                    c.this.qw(false);
                }
            }
        };
        BaseWebView.b bVar = new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.a.c.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return c.this.Cf(str);
            }
        };
        QuickWebView cAg = this.jyW.cAg();
        if (cAg != null) {
            cAg.addJsPromptInterface(new a());
            cAg.setOnPageFinishedListener(cVar);
            cAg.setOnReceivedErrorListener(fVar);
            cAg.setOnLoadUrlListener(bVar);
        }
    }

    private void czV() {
        ad.a(new ac<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: bpH */
            public List<String> doInBackground() {
                return com.baidu.tieba.tbadkCore.util.a.diQ();
            }
        }, new l<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: bp */
            public void onReturnDataInUI(List<String> list) {
                if (!w.isEmpty(list)) {
                    c.this.jyX = list;
                }
            }
        });
    }

    public void czW() {
        this.jyW.cAb();
        if (this.jyY) {
            String czX = czX();
            if (!StringUtils.isNull(czX)) {
                this.jyW.cAg().loadUrl("javascript:setSearchHistory('" + czX + "')");
                return;
            }
            return;
        }
        this.jyW.cAg().loadUrl("https://tieba.baidu.com/n/apage-runtime/page/search_history");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String czX() {
        int count = w.getCount(this.jyX);
        if (count == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < count; i++) {
            jSONArray.put(this.jyX.get(i));
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qw(boolean z) {
        NoDataViewFactory.d mm;
        if (!z) {
            this.jyW.czL();
            if (j.isNetWorkAvailable()) {
                mm = NoDataViewFactory.d.mm(R.string.text_no_search_record);
            } else {
                mm = NoDataViewFactory.d.mm(R.string.neterror);
            }
            this.jyW.a(mm);
            return;
        }
        this.jyW.cAb();
    }

    public void In(String str) {
        if (!StringUtils.isNull(str) && this.jyX != null && !this.jyX.contains(str)) {
            this.jyX.add(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Cf(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC2) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC_NEW)) {
            String matchStringFromURL = ah.getMatchStringFromURL(str, "topic_id=");
            String matchStringFromURL2 = ah.getMatchStringFromURL(str, "topic_name=");
            if (!com.baidu.tbadk.plugins.b.l(this.mPageContext) && !StringUtils.isNull(matchStringFromURL) && !StringUtils.isNull(matchStringFromURL2, true)) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(matchStringFromURL, matchStringFromURL2, "4")));
            }
            TiebaStatic.log(new ao("c10363").dk("obj_name", matchStringFromURL2));
            return true;
        } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_LIST_NEW) || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage/list")) {
            if (com.baidu.tbadk.plugins.b.l(this.mPageContext)) {
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
                    jsPromptResult.confirm(c.this.czX());
                    c.this.jyY = true;
                    return true;
                } else if ("deleteSearchHistory".equals(str2)) {
                    Io(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("deleteAllSearchHistory".equals(str2)) {
                    bWO();
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("openSearchPage".equals(str2)) {
                    Ip(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private void Io(String str) {
            try {
                final String optString = new JSONObject(str).optString("query");
                ad.a(new ac<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.ac
                    /* renamed from: cjO */
                    public String doInBackground() {
                        com.baidu.tieba.tbadkCore.util.a.Nn(optString);
                        return optString;
                    }
                }, new l<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.l
                    /* renamed from: Gg */
                    public void onReturnDataInUI(String str2) {
                        c.this.jyX.remove(str2);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void bWO() {
            ad.a(new ac() { // from class: com.baidu.tieba.mainentrance.a.c.a.3
                @Override // com.baidu.tbadk.util.ac
                public Object doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.diS();
                    return null;
                }
            }, new l() { // from class: com.baidu.tieba.mainentrance.a.c.a.4
                @Override // com.baidu.tbadk.util.l
                public void onReturnDataInUI(Object obj) {
                    c.this.jyX.clear();
                }
            });
        }

        private void Ip(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("query");
                int optInt = jSONObject.optInt(FuFaceItem.JK_SUB_TYPE);
                if (c.this.jyV != null) {
                    c.this.jyV.b(optString, true, optInt);
                    TiebaStatic.log(new ao("c12034"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
