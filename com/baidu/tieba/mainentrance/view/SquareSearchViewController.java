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
import com.baidu.tbadk.core.util.h;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.util.al;
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
import java.util.Stack;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes8.dex */
public class SquareSearchViewController implements b {
    private String jel;
    private c lkg;
    private boolean lks;
    private SearchHistoryViewController lkv;
    private BaseActivity mActivity;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;
    private boolean lkt = true;
    private Stack<String> lku = new Stack<>();
    private CustomMessageListener lkw = new CustomMessageListener(2921444) { // from class: com.baidu.tieba.mainentrance.view.SquareSearchViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                SquareSearchViewController.this.lkg.tS(!((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public SquareSearchViewController(BaseActivity baseActivity, boolean z) {
        this.mActivity = baseActivity;
        this.lks = z;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.mActivity).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
            this.mActivity.setContentView(this.mRootView);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> der = a.der();
            if (der != null) {
                int size = der.size();
                int i2 = 0;
                Iterator<String> it = der.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    a.NU(it.next());
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
        this.lkg = new c(this.mRootView, this.mActivity.getPageContext().getPageActivity());
        this.lkv = new SearchHistoryViewController(this.mActivity, this, this.lkg);
        deG();
        deH();
        deI();
        deJ();
        dea();
        deN();
        al.a(this.lkg.deD(), this.mActivity.getUniqueId());
        al.a(this.lkg.deE(), this.mActivity.getUniqueId());
        this.mActivity.registerListener(this.lkw);
    }

    public void onResume() {
        if (this.lkg != null) {
            this.lkg.onResume();
        }
    }

    public void deG() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.view.SquareSearchViewController.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(SquareSearchViewController.this.mActivity.getPageContext().getPageActivity(), view);
                } else {
                    SquareSearchViewController.this.deL();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.view.SquareSearchViewController.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(SquareSearchViewController.this.jel)) {
                        l.hideSoftKeyPad(SquareSearchViewController.this.mActivity.getPageContext().getPageActivity(), textView);
                        SquareSearchViewController.this.deK();
                        return true;
                    }
                    SquareSearchViewController.this.b(SquareSearchViewController.this.jel, false, 1);
                    TiebaStatic.log(new ar("c12842").dR("obj_name", SquareSearchViewController.this.jel).dR("obj_source", "1").dR("obj_type", "1"));
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
                    if (SquareSearchViewController.this.lkt) {
                        SquareSearchViewController.this.jel = editable.toString();
                        SquareSearchViewController.this.deN();
                    }
                    SquareSearchViewController.this.lkg.po(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.view.SquareSearchViewController.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != SquareSearchViewController.this.lkg.deB() || SquareSearchViewController.this.lkg.deB().getText() == null) {
                    if (view == SquareSearchViewController.this.lkg.deC()) {
                        l.hideSoftKeyPad(SquareSearchViewController.this.mActivity.getPageContext().getPageActivity(), SquareSearchViewController.this.lkg.deB());
                        e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.view.SquareSearchViewController.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SquareSearchViewController.this.mActivity.finish();
                            }
                        }, 1000L);
                        return;
                    }
                    return;
                }
                SquareSearchViewController.this.jel = SquareSearchViewController.this.lkg.deB().getText().toString();
                if (StringUtils.isNull(SquareSearchViewController.this.jel)) {
                    SquareSearchViewController.this.deu();
                }
            }
        };
        this.lkg.a(onFocusChangeListener);
        this.lkg.a(onEditorActionListener);
        this.lkg.d(textWatcher);
        this.lkg.setOnClickListener(onClickListener);
    }

    private void deH() {
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
                        TiebaStatic.log(new ar("c12842").dR("obj_name", str).dR("obj_source", "2").dR("obj_type", "1").ap("obj_locate", i + 1).dR("obj_param1", SquareSearchViewController.this.jel));
                    } else if (item instanceof ForumInfo) {
                        ForumInfo forumInfo = (ForumInfo) item;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(SquareSearchViewController.this.mActivity.getPageContext().getPageActivity()).createNormalCfg(forumInfo.forum_name, FrsActivityConfig.FRS_CALL_SEARCH)));
                        TiebaStatic.log(new ar("c13371").dR("obj_type", forumInfo.has_concerned.intValue() > 0 ? "1" : "2").ap("fid", forumInfo.forum_id.intValue()).v("uid", TbadkApplication.getCurrentAccountId()));
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
        this.lkg.b(onItemClickListener);
        this.lkg.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.lkg.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    private void deI() {
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
                if (!TbadkCoreApplication.isLogin() && str != null && ad.DR(str) && ad.bFL()) {
                    com.baidu.tbadk.core.data.ar arVar = new com.baidu.tbadk.core.data.ar(SquareSearchViewController.this.mActivity, "sousuo_dianji");
                    arVar.setUrl(str);
                    h.a(arVar);
                    return true;
                } else if (bf.bsV().a(SquareSearchViewController.this.mActivity.getPageContext(), new String[]{str}) != 3) {
                    return true;
                } else {
                    if (str == null || !str.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE)) {
                        return false;
                    }
                    bf.bsV().a(SquareSearchViewController.this.mActivity.getPageContext(), new String[]{str}, true);
                    return true;
                }
            }
        };
        this.lkg.a(cVar);
        this.lkg.a(fVar);
        this.lkg.a(gVar);
        this.lkg.a(bVar);
    }

    private void deJ() {
        this.lkg.deD().addJsPromptInterface(new UegTbJsBridge(this.mActivity.getPageContext()));
        this.lkg.deD().addJsPromptInterface(new SearchResultJsBridge());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deK() {
        if (this.mHotSearchInfo == null) {
            this.mActivity.showToast(this.mActivity.getResources().getString(R.string.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.getType() == 0 || this.mHotSearchInfo.getType() == 2) {
            b(this.mHotSearchInfo.getName(), true, 1);
        } else if (this.mHotSearchInfo.getType() == 1 && !com.baidu.tbadk.plugins.b.k(this.mActivity.getPageContext())) {
            this.mActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.mActivity.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new ar("c10355").dR("obj_name", this.mHotSearchInfo.getName()).ap("obj_type", this.mHotSearchInfo.getType() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.view.b
    public void b(final String str, boolean z, int i) {
        if (!j.isNetWorkAvailable()) {
            this.mActivity.showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.lkt = false;
                this.lkg.NX(str);
                this.lkt = true;
            }
            l.hideSoftKeyPad(this.mActivity.getPageContext().getPageActivity(), this.lkg.deB());
            this.lkg.deA();
            String str2 = "https://tieba.baidu.com/mo/q/hybrid/search?keyword=" + str + ETAG.ITEM_SEPARATOR + FuFaceItem.JK_SUB_TYPE + "=" + i;
            try {
                str2 = "https://tieba.baidu.com/mo/q/hybrid/search?keyword=" + URLEncoder.encode(str, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.lkg.deD().loadUrl(str2);
            this.lku.push(str);
            af.a(new ae<Boolean>() { // from class: com.baidu.tieba.mainentrance.view.SquareSearchViewController.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ae
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.TG(str);
                    return true;
                }
            }, null);
            this.lkv.NV(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TURN_TAB_LOC, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deL() {
        if (!this.lkg.deF()) {
            deg();
        }
    }

    public void deM() {
        if (this.lku.size() > 1) {
            this.lku.pop();
            String peek = this.lku.peek();
            if (!TextUtils.isEmpty(peek) && this.lkg != null) {
                boolean z = this.lkt;
                this.lkt = false;
                this.lkg.NX(peek);
                this.lkt = z;
                this.lkg.deA();
                return;
            }
            return;
        }
        this.lku.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deu() {
        this.lkv.deu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deN() {
        if (!StringUtils.isNull(this.jel)) {
            deg();
        } else {
            deu();
        }
    }

    private void deg() {
        if (StringUtils.isNull(this.jel)) {
            deu();
            return;
        }
        SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
        searchListNetMessage.mKey = this.jel.trim();
        searchListNetMessage.isForum = Integer.valueOf(this.lks ? 1 : 0);
        this.mActivity.sendMessage(searchListNetMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String deO() {
        JSONObject jSONObject = new JSONObject();
        try {
            MercatorModel.MercatorData mercatorData = MercatorModel.dOK().getMercatorData();
            if (mercatorData != null) {
                d(jSONObject, "mercator_lat", mercatorData.dOM());
                d(jSONObject, "mercator_lon", mercatorData.dOL());
                d(jSONObject, "mercator_city", String.valueOf(mercatorData.dOO()));
                d(jSONObject, "mercator_radius", mercatorData.dON());
                d(jSONObject, "mercator_time", String.valueOf(mercatorData.dOP()));
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
        dea();
    }

    public BaseWebView deP() {
        return this.lkg.deD();
    }

    public View deQ() {
        return this.lkg.deB();
    }

    private void dea() {
        if (this.lkg != null) {
            if (this.mHotSearchInfo == null) {
                this.lkg.NW(this.mActivity.getResources().getString(R.string.search_bar));
            } else {
                this.lkg.NW(this.mHotSearchInfo.cvn());
            }
        }
    }

    public void eO(List<String> list) {
        this.lkg.m(list, this.jel);
    }

    public void eP(List<ForumInfo> list) {
        this.lkg.n(list, this.jel);
    }

    public void onDestroy() {
        if (this.lkg != null) {
            this.lkg.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class SearchResultJsBridge implements com.baidu.tieba.tbadkCore.e.b {
        private static final String BIND_MOBILE_NUMBER = "bindMobileNumber";
        private static final String GET_SEARCH_AD_COOKIE = "getSearchAdCookie";
        private static final String INTERFACE_NAME = "CommonJSBridge";

        private SearchResultJsBridge() {
        }

        @Override // com.baidu.tieba.tbadkCore.e.b
        public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if ("CommonJSBridge".equals(str) && GET_SEARCH_AD_COOKIE.equals(str2)) {
                jsPromptResult.confirm(SquareSearchViewController.this.deO());
                return true;
            }
            return false;
        }
    }
}
