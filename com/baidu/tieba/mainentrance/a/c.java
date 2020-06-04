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
    private b jhM;
    private d jhN;
    private List<String> jhO = new ArrayList();
    private boolean jhP;
    private TbPageContext mPageContext;

    public c(BaseActivity baseActivity, b bVar, d dVar) {
        this.mPageContext = baseActivity.getPageContext();
        this.jhM = bVar;
        this.jhN = dVar;
        cwc();
        cwd();
    }

    private void cwc() {
        BaseWebView.c cVar = new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.a.c.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
            }
        };
        BaseWebView.f fVar = new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.a.c.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                if (webView == c.this.jhN.cwo()) {
                    c.this.qm(false);
                }
            }
        };
        BaseWebView.b bVar = new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.a.c.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return c.this.BH(str);
            }
        };
        QuickWebView cwo = this.jhN.cwo();
        if (cwo != null) {
            cwo.addJsPromptInterface(new a());
            cwo.setOnPageFinishedListener(cVar);
            cwo.setOnReceivedErrorListener(fVar);
            cwo.setOnLoadUrlListener(bVar);
        }
    }

    private void cwd() {
        ad.a(new ac<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: bng */
            public List<String> doInBackground() {
                return com.baidu.tieba.tbadkCore.util.a.deD();
            }
        }, new l<List<String>>() { // from class: com.baidu.tieba.mainentrance.a.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: bf */
            public void onReturnDataInUI(List<String> list) {
                if (!v.isEmpty(list)) {
                    c.this.jhO = list;
                }
            }
        });
    }

    public void cwe() {
        this.jhN.cwj();
        if (this.jhP) {
            String cwf = cwf();
            if (!StringUtils.isNull(cwf)) {
                this.jhN.cwo().loadUrl("javascript:setSearchHistory('" + cwf + "')");
                return;
            }
            return;
        }
        this.jhN.cwo().loadUrl("https://tieba.baidu.com/n/apage-runtime/page/search_history");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cwf() {
        int count = v.getCount(this.jhO);
        if (count == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < count; i++) {
            jSONArray.put(this.jhO.get(i));
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qm(boolean z) {
        NoDataViewFactory.d lV;
        if (!z) {
            this.jhN.cvT();
            if (j.isNetWorkAvailable()) {
                lV = NoDataViewFactory.d.lV(R.string.text_no_search_record);
            } else {
                lV = NoDataViewFactory.d.lV(R.string.neterror);
            }
            this.jhN.a(lV);
            return;
        }
        this.jhN.cwj();
    }

    public void HL(String str) {
        if (!StringUtils.isNull(str) && this.jhO != null && !this.jhO.contains(str)) {
            this.jhO.add(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean BH(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC2) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC_NEW)) {
            String matchStringFromURL = ah.getMatchStringFromURL(str, "topic_id=");
            String matchStringFromURL2 = ah.getMatchStringFromURL(str, "topic_name=");
            if (!com.baidu.tbadk.plugins.b.i(this.mPageContext) && !StringUtils.isNull(matchStringFromURL) && !StringUtils.isNull(matchStringFromURL2, true)) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(matchStringFromURL, matchStringFromURL2, "4")));
            }
            TiebaStatic.log(new an("c10363").dh("obj_name", matchStringFromURL2));
            return true;
        } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_LIST_NEW) || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage/list")) {
            if (com.baidu.tbadk.plugins.b.i(this.mPageContext)) {
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
                    jsPromptResult.confirm(c.this.cwf());
                    c.this.jhP = true;
                    return true;
                } else if ("deleteSearchHistory".equals(str2)) {
                    HM(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("deleteAllSearchHistory".equals(str2)) {
                    bTR();
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("openSearchPage".equals(str2)) {
                    HN(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private void HM(String str) {
            try {
                final String optString = new JSONObject(str).optString("query");
                ad.a(new ac<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.ac
                    /* renamed from: cgm */
                    public String doInBackground() {
                        com.baidu.tieba.tbadkCore.util.a.ML(optString);
                        return optString;
                    }
                }, new l<String>() { // from class: com.baidu.tieba.mainentrance.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.l
                    /* renamed from: FF */
                    public void onReturnDataInUI(String str2) {
                        c.this.jhO.remove(str2);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void bTR() {
            ad.a(new ac() { // from class: com.baidu.tieba.mainentrance.a.c.a.3
                @Override // com.baidu.tbadk.util.ac
                public Object doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.deF();
                    return null;
                }
            }, new l() { // from class: com.baidu.tieba.mainentrance.a.c.a.4
                @Override // com.baidu.tbadk.util.l
                public void onReturnDataInUI(Object obj) {
                    c.this.jhO.clear();
                }
            });
        }

        private void HN(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("query");
                int optInt = jSONObject.optInt(FuFaceItem.JK_SUB_TYPE);
                if (c.this.jhM != null) {
                    c.this.jhM.b(optString, true, optInt);
                    TiebaStatic.log(new an("c12034"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
