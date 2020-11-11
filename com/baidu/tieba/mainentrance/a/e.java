package com.baidu.tieba.mainentrance.a;

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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.aj;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import com.baidu.tieba.mainentrance.HotSearchInfoData;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListNetMessage;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.tbadkCore.util.f;
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
public class e implements b {
    private String iFd;
    private d kNj;
    private boolean kNw;
    private c kNy;
    private BaseActivity mActivity;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;
    private boolean kNx = true;
    private CustomMessageListener kNz = new CustomMessageListener(2921444) { // from class: com.baidu.tieba.mainentrance.a.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                e.this.kNj.tc(!((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public e(BaseActivity baseActivity, boolean z) {
        this.mActivity = baseActivity;
        this.kNw = z;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.mActivity).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
            this.mActivity.setContentView(this.mRootView);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> dbH = com.baidu.tieba.mainentrance.a.a.dbH();
            if (dbH != null) {
                int size = dbH.size();
                int i2 = 0;
                Iterator<String> it = dbH.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    com.baidu.tieba.mainentrance.a.a.Oa(it.next());
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
        this.kNj = new d(this.mRootView, this.mActivity.getPageContext().getPageActivity());
        this.kNy = new c(this.mActivity, this, this.kNj);
        dbW();
        dbX();
        dbY();
        dbZ();
        dbq();
        dcc();
        aj.a(this.kNj.dbT(), this.mActivity.getUniqueId());
        aj.a(this.kNj.dbU(), this.mActivity.getUniqueId());
        this.mActivity.registerListener(this.kNz);
    }

    public void onResume() {
        if (this.kNj != null) {
            this.kNj.onResume();
        }
    }

    public void dbW() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.a.e.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(e.this.mActivity.getPageContext().getPageActivity(), view);
                } else {
                    e.this.dcb();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.a.e.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(e.this.iFd)) {
                        l.hideSoftKeyPad(e.this.mActivity.getPageContext().getPageActivity(), textView);
                        e.this.dca();
                        return true;
                    }
                    e.this.b(e.this.iFd, false, 1);
                    TiebaStatic.log(new aq("c12842").dR("obj_name", e.this.iFd).dR("obj_source", "1").dR("obj_type", "1"));
                    return true;
                }
                return false;
            }
        };
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.mainentrance.a.e.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    if (e.this.kNx) {
                        e.this.iFd = editable.toString();
                        e.this.dcc();
                    }
                    e.this.kNj.ol(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != e.this.kNj.dbR() || e.this.kNj.dbR().getText() == null) {
                    if (view == e.this.kNj.dbS()) {
                        l.hideSoftKeyPad(e.this.mActivity.getPageContext().getPageActivity(), e.this.kNj.dbR());
                        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.a.e.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.mActivity.finish();
                            }
                        }, 1000L);
                        return;
                    }
                    return;
                }
                e.this.iFd = e.this.kNj.dbR().getText().toString();
                if (StringUtils.isNull(e.this.iFd)) {
                    e.this.dbK();
                }
            }
        };
        this.kNj.a(onFocusChangeListener);
        this.kNj.a(onEditorActionListener);
        this.kNj.d(textWatcher);
        this.kNj.setOnClickListener(onClickListener);
    }

    private void dbX() {
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.9
            /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ?? adapter = adapterView.getAdapter();
                if (adapter != 0 && i < adapter.getCount()) {
                    Object item = adapter.getItem(i);
                    if (item instanceof String) {
                        String str = (String) item;
                        e.this.b(str, true, 3);
                        TiebaStatic.eventStat(e.this.mActivity.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                        TiebaStatic.log(new aq("c12842").dR("obj_name", str).dR("obj_source", "2").dR("obj_type", "1").al("obj_locate", i + 1).dR("obj_param1", e.this.iFd));
                    } else if (item instanceof ForumInfo) {
                        ForumInfo forumInfo = (ForumInfo) item;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.mActivity.getPageContext().getPageActivity()).createNormalCfg(forumInfo.forum_name, FrsActivityConfig.FRS_CALL_SEARCH)));
                        TiebaStatic.log(new aq("c13371").dR("obj_type", forumInfo.has_concerned.intValue() > 0 ? "1" : "2").al("fid", forumInfo.forum_id.intValue()).w("uid", TbadkApplication.getCurrentAccountId()));
                    }
                }
            }
        };
        AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.a.e.10
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.hideSoftKeyPad(e.this.mActivity.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        };
        this.kNj.b(onItemClickListener);
        this.kNj.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.kNj.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    private void dbY() {
        BaseWebView.c cVar = new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.a.e.11
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "PageFinished", 0, "", "requesturl", str);
            }
        };
        BaseWebView.f fVar = new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.a.e.12
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i), "description", str);
            }
        };
        BaseWebView.g gVar = new BaseWebView.g() { // from class: com.baidu.tieba.mainentrance.a.e.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError != null) {
                    com.baidu.tbadk.core.d.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
                }
            }
        };
        BaseWebView.b bVar = new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.a.e.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "OverrideUrl", 0, "", "requesturl", str);
                if (be.brr().a(e.this.mActivity.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE)) {
                    return false;
                }
                be.brr().a(e.this.mActivity.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.kNj.a(cVar);
        this.kNj.a(fVar);
        this.kNj.a(gVar);
        this.kNj.a(bVar);
    }

    private void dbZ() {
        this.kNj.dbT().addJsPromptInterface(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dca() {
        if (this.mHotSearchInfo == null) {
            this.mActivity.showToast(this.mActivity.getResources().getString(R.string.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.getType() == 0 || this.mHotSearchInfo.getType() == 2) {
            b(this.mHotSearchInfo.getName(), true, 1);
        } else if (this.mHotSearchInfo.getType() == 1 && !com.baidu.tbadk.plugins.b.k(this.mActivity.getPageContext())) {
            this.mActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.mActivity.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new aq("c10355").dR("obj_name", this.mHotSearchInfo.getName()).al("obj_type", this.mHotSearchInfo.getType() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.a.b
    public void b(final String str, boolean z, int i) {
        if (!j.isNetWorkAvailable()) {
            this.mActivity.showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.kNx = false;
                this.kNj.Of(str);
                this.kNx = true;
            }
            l.hideSoftKeyPad(this.mActivity.getPageContext().getPageActivity(), this.kNj.dbR());
            this.kNj.dbQ();
            String str2 = "https://tieba.baidu.com/n/apage-runtime/page/205?keyword=" + str + ETAG.ITEM_SEPARATOR + FuFaceItem.JK_SUB_TYPE + ETAG.EQUAL + i;
            try {
                str2 = "https://tieba.baidu.com/n/apage-runtime/page/205?keyword=" + URLEncoder.encode(str, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.kNj.dbT().loadUrl(str2);
            ae.a(new ad<Boolean>() { // from class: com.baidu.tieba.mainentrance.a.e.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ad
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.SV(str);
                    return true;
                }
            }, null);
            this.kNy.Ob(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TURN_TAB_LOC, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcb() {
        if (!this.kNj.dbV()) {
            dbw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbK() {
        this.kNy.dbK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcc() {
        if (!StringUtils.isNull(this.iFd)) {
            dbw();
        } else {
            dbK();
        }
    }

    private void dbw() {
        if (StringUtils.isNull(this.iFd)) {
            dbK();
            return;
        }
        SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
        searchListNetMessage.mKey = this.iFd.trim();
        searchListNetMessage.isForum = Integer.valueOf(this.kNw ? 1 : 0);
        this.mActivity.sendMessage(searchListNetMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dcd() {
        JSONObject jSONObject = new JSONObject();
        try {
            MercatorModel.MercatorData mercatorData = MercatorModel.dKU().getMercatorData();
            if (mercatorData != null) {
                d(jSONObject, "mercator_lat", mercatorData.dKW());
                d(jSONObject, "mercator_lon", mercatorData.dKV());
                d(jSONObject, "mercator_city", String.valueOf(mercatorData.dKY()));
                d(jSONObject, "mercator_radius", mercatorData.dKX());
                d(jSONObject, "mercator_time", String.valueOf(mercatorData.dKZ()));
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
            d(jSONObject, "shoubai_cuid", cuidGalaxy2);
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
        dbq();
    }

    public BaseWebView dce() {
        return this.kNj.dbT();
    }

    private void dbq() {
        if (this.kNj != null) {
            if (this.mHotSearchInfo == null) {
                this.kNj.Oe(this.mActivity.getResources().getString(R.string.search_bar));
            } else {
                this.kNj.Oe(this.mHotSearchInfo.cra());
            }
        }
    }

    public void eF(List<String> list) {
        this.kNj.n(list, this.iFd);
    }

    public void eG(List<ForumInfo> list) {
        this.kNj.o(list, this.iFd);
    }

    public void onDestroy() {
        if (this.kNj != null) {
            this.kNj.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class a implements com.baidu.tieba.tbadkCore.e.b {
        private a() {
        }

        @Override // com.baidu.tieba.tbadkCore.e.b
        public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if ("CommonJSBridge".equals(str)) {
                if ("bindMobileNumber".equals(str2)) {
                    f.a(3250017, "", (f.a) null);
                    jsPromptResult.confirm();
                    return true;
                } else if ("getSearchAdCookie".equals(str2)) {
                    jsPromptResult.confirm(e.this.dcd());
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
    }
}
