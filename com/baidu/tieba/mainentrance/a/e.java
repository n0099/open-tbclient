package com.baidu.tieba.mainentrance.a;

import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ah;
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
/* loaded from: classes11.dex */
public class e implements b {
    private String hlt;
    private d jhN;
    private boolean jia;
    private c jic;
    private BaseActivity mActivity;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;
    private boolean jib = true;
    private CustomMessageListener jie = new CustomMessageListener(2921444) { // from class: com.baidu.tieba.mainentrance.a.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                e.this.jhN.qn(!((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public e(BaseActivity baseActivity, boolean z) {
        this.mActivity = baseActivity;
        this.jia = z;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.mActivity).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
            this.mActivity.setContentView(this.mRootView);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> cwb = com.baidu.tieba.mainentrance.a.a.cwb();
            if (cwb != null) {
                int size = cwb.size();
                int i2 = 0;
                Iterator<String> it = cwb.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    com.baidu.tieba.mainentrance.a.a.HK(it.next());
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
        this.jhN = new d(this.mRootView, this.mActivity.getPageContext().getPageActivity());
        this.jic = new c(this.mActivity, this, this.jhN);
        cwq();
        cwr();
        cws();
        cwt();
        cvK();
        cww();
        ah.a(this.jhN.cwn(), this.mActivity.getUniqueId());
        ah.a(this.jhN.cwo(), this.mActivity.getUniqueId());
        this.mActivity.registerListener(this.jie);
    }

    public void onResume() {
        if (this.jhN != null) {
            this.jhN.onResume();
        }
    }

    public void cwq() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.a.e.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(e.this.mActivity.getPageContext().getPageActivity(), view);
                } else {
                    e.this.cwv();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.a.e.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(e.this.hlt)) {
                        l.hideSoftKeyPad(e.this.mActivity.getPageContext().getPageActivity(), textView);
                        e.this.cwu();
                        return true;
                    }
                    e.this.b(e.this.hlt, false, 1);
                    TiebaStatic.log(new an("c12842").dh("obj_name", e.this.hlt).dh("obj_source", "1").dh("obj_type", "1"));
                    return true;
                }
                return false;
            }
        };
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.mainentrance.a.e.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    if (e.this.jib) {
                        e.this.hlt = editable.toString();
                        e.this.cww();
                    }
                    e.this.jhN.lG(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != e.this.jhN.cwl() || e.this.jhN.cwl().getText() == null) {
                    if (view == e.this.jhN.cwm()) {
                        l.hideSoftKeyPad(e.this.mActivity.getPageContext().getPageActivity(), e.this.jhN.cwl());
                        com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.a.e.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.mActivity.finish();
                            }
                        }, 200L);
                        return;
                    }
                    return;
                }
                e.this.hlt = e.this.jhN.cwl().getText().toString();
                if (StringUtils.isNull(e.this.hlt)) {
                    e.this.cwe();
                }
            }
        };
        this.jhN.a(onFocusChangeListener);
        this.jhN.a(onEditorActionListener);
        this.jhN.d(textWatcher);
        this.jhN.setOnClickListener(onClickListener);
    }

    private void cwr() {
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.8
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
                        TiebaStatic.log(new an("c12842").dh("obj_name", str).dh("obj_source", "2").dh("obj_type", "1").ag("obj_locate", i + 1).dh("obj_param1", e.this.hlt));
                    } else if (item instanceof ForumInfo) {
                        ForumInfo forumInfo = (ForumInfo) item;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.mActivity.getPageContext().getPageActivity()).createNormalCfg(forumInfo.forum_name, FrsActivityConfig.FRS_CALL_SEARCH)));
                        TiebaStatic.log(new an("c13371").dh("obj_type", forumInfo.has_concerned.intValue() > 0 ? "1" : "2").ag("fid", forumInfo.forum_id.intValue()).s("uid", TbadkApplication.getCurrentAccountId()));
                    }
                }
            }
        };
        AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.a.e.9
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
        this.jhN.b(onItemClickListener);
        this.jhN.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.jhN.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    private void cws() {
        BaseWebView.c cVar = new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.a.e.10
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
            }
        };
        BaseWebView.f fVar = new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.a.e.11
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
            }
        };
        BaseWebView.b bVar = new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.a.e.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (ba.aVa().a(e.this.mActivity.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE)) {
                    return false;
                }
                ba.aVa().a(e.this.mActivity.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.jhN.a(cVar);
        this.jhN.a(fVar);
        this.jhN.a(bVar);
    }

    private void cwt() {
        this.jhN.cwn().addJsPromptInterface(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwu() {
        if (this.mHotSearchInfo == null) {
            this.mActivity.showToast(this.mActivity.getResources().getString(R.string.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.getType() == 0 || this.mHotSearchInfo.getType() == 2) {
            b(this.mHotSearchInfo.getName(), false, 1);
        } else if (this.mHotSearchInfo.getType() == 1 && !com.baidu.tbadk.plugins.b.i(this.mActivity.getPageContext())) {
            this.mActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.mActivity.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new an("c10355").dh("obj_name", this.mHotSearchInfo.getName()).ag("obj_type", this.mHotSearchInfo.getType() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.a.b
    public void b(final String str, boolean z, int i) {
        if (!j.isNetWorkAvailable()) {
            this.mActivity.showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.jib = false;
                this.jhN.HP(str);
                this.jib = true;
            }
            l.hideSoftKeyPad(this.mActivity.getPageContext().getPageActivity(), this.jhN.cwl());
            this.jhN.cwk();
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str + ETAG.ITEM_SEPARATOR + FuFaceItem.JK_SUB_TYPE + ETAG.EQUAL + i;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.jhN.cwn().loadUrl(str2);
            ad.a(new ac<Boolean>() { // from class: com.baidu.tieba.mainentrance.a.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ac
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.MJ(str);
                    return true;
                }
            }, null);
            this.jic.HL(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TURN_TAB_LOC, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwv() {
        if (!this.jhN.cwp()) {
            cvQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwe() {
        this.jic.cwe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cww() {
        if (!StringUtils.isNull(this.hlt)) {
            cvQ();
        } else {
            cwe();
        }
    }

    private void cvQ() {
        if (StringUtils.isNull(this.hlt)) {
            cwe();
            return;
        }
        SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
        searchListNetMessage.mKey = this.hlt.trim();
        searchListNetMessage.isForum = Integer.valueOf(this.jia ? 1 : 0);
        this.mActivity.sendMessage(searchListNetMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cwx() {
        JSONObject jSONObject = new JSONObject();
        try {
            MercatorModel.MercatorData mercatorData = MercatorModel.deJ().getMercatorData();
            if (mercatorData != null) {
                d(jSONObject, "mercator_lat", mercatorData.deL());
                d(jSONObject, "mercator_lon", mercatorData.deK());
                d(jSONObject, "mercator_city", String.valueOf(mercatorData.deN()));
                d(jSONObject, "mercator_radius", mercatorData.deM());
                d(jSONObject, "mercator_time", String.valueOf(mercatorData.deO()));
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
        cvK();
    }

    public BaseWebView cwy() {
        return this.jhN.cwn();
    }

    private void cvK() {
        if (this.jhN != null) {
            if (this.mHotSearchInfo == null) {
                this.jhN.HO(this.mActivity.getResources().getString(R.string.search_bar));
            } else {
                this.jhN.HO(this.mHotSearchInfo.bOc());
            }
        }
    }

    public void dA(List<String> list) {
        this.jhN.j(list, this.hlt);
    }

    public void dB(List<ForumInfo> list) {
        this.jhN.k(list, this.hlt);
    }

    public void onDestroy() {
        if (this.jhN != null) {
            this.jhN.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
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
                    jsPromptResult.confirm(e.this.cwx());
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
    }
}
