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
    private b kHm;
    private d kHn;
    private List<String> kHo = new ArrayList();
    private boolean kHp;
    private TbPageContext mPageContext;

    public c(BaseActivity baseActivity, b bVar, d dVar) {
        this.mPageContext = baseActivity.getPageContext();
        this.kHm = bVar;
        this.kHn = dVar;
        cZg();
        cZh();
    }

    private void cZg() {
        BaseWebView.c cVar = new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.a.c.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
            }
        };
        BaseWebView.f fVar = new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.a.c.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                if (webView == c.this.kHn.cZs()) {
                    c.this.sS(false);
                }
            }
        };
        BaseWebView.b bVar = new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.a.c.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return c.this.GU(str);
            }
        };
        QuickWebView cZs = this.kHn.cZs();
        if (cZs != null) {
            cZs.addJsPromptInterface(new a());
            cZs.setOnPageFinishedListener(cVar);
            cZs.setOnReceivedErrorListener(fVar);
            cZs.setOnLoadUrlListener(bVar);
        }
    }

    private void cZh() {
        ae.a(new ad<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: bHy */
            public List<String> doInBackground() {
                return com.baidu.tieba.tbadkCore.util.a.dIm();
            }
        }, new m<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: bK */
            public void onReturnDataInUI(List<String> list) {
                if (!y.isEmpty(list)) {
                    c.this.kHo = list;
                }
            }
        });
    }

    public void cZi() {
        this.kHn.cZn();
        if (this.kHp) {
            String cZj = cZj();
            if (!StringUtils.isNull(cZj)) {
                this.kHn.cZs().loadUrl("javascript:setSearchHistory('" + cZj + "')");
                return;
            }
            return;
        }
        this.kHn.cZs().loadUrl(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + "n/apage-runtime/page/search_history");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cZj() {
        int count = y.getCount(this.kHo);
        if (count == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < count; i++) {
            jSONArray.put(this.kHo.get(i));
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sS(boolean z) {
        NoDataViewFactory.d pG;
        if (!z) {
            this.kHn.cYX();
            if (j.isNetWorkAvailable()) {
                pG = NoDataViewFactory.d.pG(R.string.text_no_search_record);
            } else {
                pG = NoDataViewFactory.d.pG(R.string.neterror);
            }
            this.kHn.a(pG);
            return;
        }
        this.kHn.cZn();
    }

    public void NK(String str) {
        if (!StringUtils.isNull(str) && this.kHo != null) {
            this.kHo.remove(str);
            this.kHo.add(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GU(String str) {
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
                    jsPromptResult.confirm(c.this.cZj());
                    c.this.kHp = true;
                    return true;
                } else if ("deleteSearchHistory".equals(str2)) {
                    NL(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("deleteAllSearchHistory".equals(str2)) {
                    cuw();
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("openSearchPage".equals(str2)) {
                    NM(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private void NL(String str) {
            try {
                final String optString = new JSONObject(str).optString("query");
                ae.a(new ad<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.ad
                    /* renamed from: cIF */
                    public String doInBackground() {
                        com.baidu.tieba.tbadkCore.util.a.SG(optString);
                        return optString;
                    }
                }, new m<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.m
                    /* renamed from: Lz */
                    public void onReturnDataInUI(String str2) {
                        c.this.kHo.remove(str2);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void cuw() {
            ae.a(new ad() { // from class: com.baidu.tieba.mainentrance.a.c.a.3
                @Override // com.baidu.tbadk.util.ad
                public Object doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.dIo();
                    return null;
                }
            }, new m() { // from class: com.baidu.tieba.mainentrance.a.c.a.4
                @Override // com.baidu.tbadk.util.m
                public void onReturnDataInUI(Object obj) {
                    c.this.kHo.clear();
                }
            });
        }

        private void NM(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("query");
                int optInt = jSONObject.optInt(FuFaceItem.JK_SUB_TYPE);
                if (c.this.kHm != null) {
                    c.this.kHm.b(optString, true, optInt);
                    TiebaStatic.log(new aq("c12034"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
