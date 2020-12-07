package com.baidu.tieba.mainentrance.view;

import android.net.http.SslError;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.aj;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import com.baidu.tieba.mainentrance.HotSearchInfoData;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListNetMessage;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.util.Base64Encoder;
import com.baidu.webkit.internal.ETAG;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes24.dex */
public class SquareSearchViewController implements b {
    private String iQJ;
    private c laQ;
    private boolean lbc;
    private SearchHistoryViewController lbe;
    private BaseActivity mActivity;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;
    private boolean lbd = true;
    private CustomMessageListener lbf = new CustomMessageListener(2921444) { // from class: com.baidu.tieba.mainentrance.view.SquareSearchViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                SquareSearchViewController.this.laQ.tH(!((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public SquareSearchViewController(BaseActivity baseActivity, boolean z) {
        this.mActivity = baseActivity;
        this.lbc = z;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.mActivity).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
            this.mActivity.setContentView(this.mRootView);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> dgq = a.dgq();
            if (dgq != null) {
                int size = dgq.size();
                int i2 = 0;
                Iterator<String> it = dgq.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    a.OF(it.next());
                    try {
                        this.mRootView = LayoutInflater.from(this.mActivity).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
                        this.mActivity.setContentView(this.mRootView);
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        i2 = i + 1;
                    }
                }
                if (i == size) {
                    this.mActivity.finish();
                    return;
                }
            } else {
                this.mActivity.finish();
                return;
            }
        }
        if (this.mRootView == null) {
            this.mActivity.finish();
            return;
        }
        this.laQ = new c(this.mRootView, this.mActivity.getPageContext().getPageActivity());
        this.lbe = new SearchHistoryViewController(this.mActivity, this, this.laQ);
        dgF();
        dgG();
        dgH();
        dgI();
        dfZ();
        dgL();
        aj.a(this.laQ.dgC(), this.mActivity.getUniqueId());
        aj.a(this.laQ.dgD(), this.mActivity.getUniqueId());
        this.mActivity.registerListener(this.lbf);
    }

    public void onResume() {
        if (this.laQ != null) {
            this.laQ.onResume();
        }
    }

    public void dgF() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.view.SquareSearchViewController.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(SquareSearchViewController.this.mActivity.getPageContext().getPageActivity(), view);
                } else {
                    SquareSearchViewController.this.dgK();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.view.SquareSearchViewController.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(SquareSearchViewController.this.iQJ)) {
                        l.hideSoftKeyPad(SquareSearchViewController.this.mActivity.getPageContext().getPageActivity(), textView);
                        SquareSearchViewController.this.dgJ();
                        return true;
                    }
                    SquareSearchViewController.this.b(SquareSearchViewController.this.iQJ, false, 1);
                    TiebaStatic.log(new ar("c12842").dY("obj_name", SquareSearchViewController.this.iQJ).dY("obj_source", "1").dY("obj_type", "1"));
                    return true;
                }
                return false;
            }
        };
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.mainentrance.view.SquareSearchViewController.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    if (SquareSearchViewController.this.lbd) {
                        SquareSearchViewController.this.iQJ = editable.toString();
                        SquareSearchViewController.this.dgL();
                    }
                    SquareSearchViewController.this.laQ.oJ(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.view.SquareSearchViewController.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != SquareSearchViewController.this.laQ.dgA() || SquareSearchViewController.this.laQ.dgA().getText() == null) {
                    if (view == SquareSearchViewController.this.laQ.dgB()) {
                        l.hideSoftKeyPad(SquareSearchViewController.this.mActivity.getPageContext().getPageActivity(), SquareSearchViewController.this.laQ.dgA());
                        e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.view.SquareSearchViewController.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SquareSearchViewController.this.mActivity.finish();
                            }
                        }, 1000L);
                        return;
                    }
                    return;
                }
                SquareSearchViewController.this.iQJ = SquareSearchViewController.this.laQ.dgA().getText().toString();
                if (StringUtils.isNull(SquareSearchViewController.this.iQJ)) {
                    SquareSearchViewController.this.dgt();
                }
            }
        };
        this.laQ.a(onFocusChangeListener);
        this.laQ.a(onEditorActionListener);
        this.laQ.d(textWatcher);
        this.laQ.setOnClickListener(onClickListener);
    }

    private void dgG() {
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.view.SquareSearchViewController.9
            /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ?? adapter = adapterView.getAdapter();
                if (adapter != 0 && i < adapter.getCount()) {
                    Object item = adapter.getItem(i);
                    if (item instanceof String) {
                        String str = (String) item;
                        SquareSearchViewController.this.b(str, true, 3);
                        TiebaStatic.eventStat(SquareSearchViewController.this.mActivity.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                        TiebaStatic.log(new ar("c12842").dY("obj_name", str).dY("obj_source", "2").dY("obj_type", "1").al("obj_locate", i + 1).dY("obj_param1", SquareSearchViewController.this.iQJ));
                    } else if (item instanceof ForumInfo) {
                        ForumInfo forumInfo = (ForumInfo) item;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(SquareSearchViewController.this.mActivity.getPageContext().getPageActivity()).createNormalCfg(forumInfo.forum_name, FrsActivityConfig.FRS_CALL_SEARCH)));
                        TiebaStatic.log(new ar("c13371").dY("obj_type", forumInfo.has_concerned.intValue() > 0 ? "1" : "2").al("fid", forumInfo.forum_id.intValue()).w("uid", TbadkApplication.getCurrentAccountId()));
                    }
                }
            }
        };
        AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.view.SquareSearchViewController.10
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.hideSoftKeyPad(SquareSearchViewController.this.mActivity.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        };
        this.laQ.b(onItemClickListener);
        this.laQ.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.laQ.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    private void dgH() {
        BaseWebView.c cVar = new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.view.SquareSearchViewController.11
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "PageFinished", 0, "", "requesturl", str);
            }
        };
        BaseWebView.f fVar = new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.view.SquareSearchViewController.12
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
            }
        };
        BaseWebView.g gVar = new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.view.SquareSearchViewController.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        };
        BaseWebView.b bVar = new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.view.SquareSearchViewController.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "OverrideUrl", 0, "", "requesturl", str);
                if (bf.bua().a(SquareSearchViewController.this.mActivity.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE)) {
                    return false;
                }
                bf.bua().a(SquareSearchViewController.this.mActivity.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.laQ.a(cVar);
        this.laQ.a(fVar);
        this.laQ.a(gVar);
        this.laQ.a(bVar);
    }

    private void dgI() {
        this.laQ.dgC().addJsPromptInterface(new UegTbJsBridge(this.mActivity.getPageContext()));
        this.laQ.dgC().addJsPromptInterface(new SearchResultJsBridge());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgJ() {
        if (this.mHotSearchInfo == null) {
            this.mActivity.showToast(this.mActivity.getResources().getString(R.string.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.getType() == 0 || this.mHotSearchInfo.getType() == 2) {
            b(this.mHotSearchInfo.getName(), true, 1);
        } else if (this.mHotSearchInfo.getType() == 1 && !com.baidu.tbadk.plugins.b.k(this.mActivity.getPageContext())) {
            this.mActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.mActivity.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new ar("c10355").dY("obj_name", this.mHotSearchInfo.getName()).al("obj_type", this.mHotSearchInfo.getType() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.view.b
    public void b(final String str, boolean z, int i) {
        if (!j.isNetWorkAvailable()) {
            this.mActivity.showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.lbd = false;
                this.laQ.OI(str);
                this.lbd = true;
            }
            l.hideSoftKeyPad(this.mActivity.getPageContext().getPageActivity(), this.laQ.dgA());
            this.laQ.dgz();
            String str2 = "https://tieba.baidu.com/n/apage-runtime/page/205?keyword=" + str + ETAG.ITEM_SEPARATOR + FuFaceItem.JK_SUB_TYPE + "=" + i;
            try {
                str2 = "https://tieba.baidu.com/n/apage-runtime/page/205?keyword=" + URLEncoder.encode(str, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.laQ.dgC().loadUrl(str2);
            ad.a(new ac<Boolean>() { // from class: com.baidu.tieba.mainentrance.view.SquareSearchViewController.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ac
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.TV(str);
                    return true;
                }
            }, null);
            this.lbe.OG(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TURN_TAB_LOC, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgK() {
        if (!this.laQ.dgE()) {
            dgf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgt() {
        this.lbe.dgt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgL() {
        if (!StringUtils.isNull(this.iQJ)) {
            dgf();
        } else {
            dgt();
        }
    }

    private void dgf() {
        if (StringUtils.isNull(this.iQJ)) {
            dgt();
            return;
        }
        SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
        searchListNetMessage.mKey = this.iQJ.trim();
        searchListNetMessage.isForum = Integer.valueOf(this.lbc ? 1 : 0);
        this.mActivity.sendMessage(searchListNetMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dgM() {
        JSONObject jSONObject = new JSONObject();
        try {
            MercatorModel.MercatorData mercatorData = MercatorModel.dQl().getMercatorData();
            if (mercatorData != null) {
                d(jSONObject, "mercator_lat", mercatorData.dQn());
                d(jSONObject, "mercator_lon", mercatorData.dQm());
                d(jSONObject, "mercator_city", String.valueOf(mercatorData.dQp()));
                d(jSONObject, "mercator_radius", mercatorData.dQo());
                d(jSONObject, "mercator_time", String.valueOf(mercatorData.dQq()));
            }
            d(jSONObject, "mod", Build.MODEL);
            d(jSONObject, "ov", Build.VERSION.RELEASE);
            d(jSONObject, HttpConstants.HTTP_OS_TYPE, String.valueOf(2));
            d(jSONObject, "net_type", String.valueOf(j.netType()));
            d(jSONObject, "imei", TbadkCoreApplication.getInst().getImei());
            d(jSONObject, "from", TbConfig.getFrom());
            d(jSONObject, BdStatsConstant.StatsKey.CURRENT_CHANNEL, TbConfig.getCurrentFrom());
            d(jSONObject, "_client_version", TbConfig.getVersion());
            d(jSONObject, "CUID", TbadkCoreApplication.getInst().getCuid());
            String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            d(jSONObject, AdExtParam.KEY_SHOUBAI_CUID, cuidGalaxy2);
            d(jSONObject, "cuid_galaxy2", cuidGalaxy2);
            if (!TextUtils.isEmpty(cuidGalaxy2)) {
                d(jSONObject, ETAG.KEY_BAIDU_ID, new String(Base64Encoder.B64Encode(cuidGalaxy2.getBytes())));
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        return jSONObject.toString();
    }

    private void d(JSONObject jSONObject, String str, String str2) throws JSONException {
        jSONObject.put(str, str2);
    }

    public void b(HotSearchInfoData hotSearchInfoData) {
        this.mHotSearchInfo = hotSearchInfoData;
        dfZ();
    }

    public BaseWebView dgN() {
        return this.laQ.dgC();
    }

    private void dfZ() {
        if (this.laQ != null) {
            if (this.mHotSearchInfo == null) {
                this.laQ.OH(this.mActivity.getResources().getString(R.string.search_bar));
            } else {
                this.laQ.OH(this.mHotSearchInfo.cuR());
            }
        }
    }

    public void eQ(List<String> list) {
        this.laQ.o(list, this.iQJ);
    }

    public void eR(List<ForumInfo> list) {
        this.laQ.p(list, this.iQJ);
    }

    public void onDestroy() {
        if (this.laQ != null) {
            this.laQ.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class SearchResultJsBridge implements com.baidu.tieba.tbadkCore.e.b {
        private static final String BIND_MOBILE_NUMBER = "bindMobileNumber";
        private static final String GET_SEARCH_AD_COOKIE = "getSearchAdCookie";
        private static final String INTERFACE_NAME = "CommonJSBridge";

        private SearchResultJsBridge() {
        }

        @Override // com.baidu.tieba.tbadkCore.e.b
        public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if ("CommonJSBridge".equals(str) && GET_SEARCH_AD_COOKIE.equals(str2)) {
                jsPromptResult.confirm(SquareSearchViewController.this.dgM());
                return true;
            }
            return false;
        }
    }
}
