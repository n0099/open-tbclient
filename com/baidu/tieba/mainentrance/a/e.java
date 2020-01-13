package com.baidu.tieba.mainentrance.a;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.HotSearchInfoData;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListNetMessage;
import com.baidu.webkit.internal.ETAG;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes9.dex */
public class e implements b {
    private String gkm;
    private d ieh;
    private boolean iet;
    private boolean ieu = true;
    private c iev;
    private BaseActivity mActivity;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;

    public e(BaseActivity baseActivity, boolean z) {
        this.mActivity = baseActivity;
        this.iet = z;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.mActivity).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
            this.mActivity.setContentView(this.mRootView);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> ccL = a.ccL();
            if (ccL != null) {
                int size = ccL.size();
                int i2 = 0;
                Iterator<String> it = ccL.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    a.Ea(it.next());
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
        this.ieh = new d(this.mRootView, this.mActivity.getPageContext().getPageActivity());
        this.iev = new c(this.mActivity, this, this.ieh);
        cda();
        cdb();
        cdc();
        ccu();
        cdf();
        ag.a(this.ieh.ccX(), this.mActivity.getUniqueId());
        ag.a(this.ieh.ccY(), this.mActivity.getUniqueId());
    }

    public void onResume() {
        if (this.ieh != null) {
            this.ieh.onResume();
        }
    }

    public void cda() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.a.e.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(e.this.mActivity.getPageContext().getPageActivity(), view);
                } else {
                    e.this.cde();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.a.e.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(e.this.gkm)) {
                        l.hideSoftKeyPad(e.this.mActivity.getPageContext().getPageActivity(), textView);
                        e.this.cdd();
                        return true;
                    }
                    e.this.b(e.this.gkm, false, 1);
                    TiebaStatic.log(new an("c12842").cp("obj_name", e.this.gkm).cp("obj_source", "1").cp("obj_type", "1"));
                    return true;
                }
                return false;
            }
        };
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.mainentrance.a.e.4
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    if (e.this.ieu) {
                        e.this.gkm = editable.toString();
                        e.this.cdf();
                    }
                    e.this.ieh.ka(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != e.this.ieh.ccV() || e.this.ieh.ccV().getText() == null) {
                    if (view == e.this.ieh.ccW()) {
                        l.hideSoftKeyPad(e.this.mActivity.getPageContext().getPageActivity(), e.this.ieh.ccV());
                        com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.a.e.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.mActivity.finish();
                            }
                        }, 200L);
                        return;
                    }
                    return;
                }
                e.this.gkm = e.this.ieh.ccV().getText().toString();
                if (StringUtils.isNull(e.this.gkm)) {
                    e.this.ccO();
                }
            }
        };
        this.ieh.a(onFocusChangeListener);
        this.ieh.a(onEditorActionListener);
        this.ieh.e(textWatcher);
        this.ieh.setOnClickListener(onClickListener);
    }

    private void cdb() {
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.6
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
                        TiebaStatic.log(new an("c12842").cp("obj_name", str).cp("obj_source", "2").cp("obj_type", "1").Z("obj_locate", i + 1).cp("obj_param1", e.this.gkm));
                    } else if (item instanceof ForumInfo) {
                        ForumInfo forumInfo = (ForumInfo) item;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.mActivity.getPageContext().getPageActivity()).createNormalCfg(forumInfo.forum_name, FrsActivityConfig.FRS_CALL_SEARCH)));
                        TiebaStatic.log(new an("c13371").cp("obj_type", forumInfo.has_concerned.intValue() > 0 ? "1" : "2").Z("fid", forumInfo.forum_id.intValue()).s("uid", TbadkApplication.getCurrentAccountId()));
                    }
                }
            }
        };
        AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.a.e.7
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
        this.ieh.c(onItemClickListener);
        this.ieh.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.ieh.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    private void cdc() {
        BaseWebView.c cVar = new BaseWebView.c() { // from class: com.baidu.tieba.mainentrance.a.e.8
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
            }
        };
        BaseWebView.f fVar = new BaseWebView.f() { // from class: com.baidu.tieba.mainentrance.a.e.9
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
            }
        };
        BaseWebView.b bVar = new BaseWebView.b() { // from class: com.baidu.tieba.mainentrance.a.e.10
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (ba.aEt().a(e.this.mActivity.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE)) {
                    return false;
                }
                ba.aEt().a(e.this.mActivity.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.ieh.a(cVar);
        this.ieh.a(fVar);
        this.ieh.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdd() {
        if (this.mHotSearchInfo == null) {
            this.mActivity.showToast(this.mActivity.getResources().getString(R.string.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.getType() == 0 || this.mHotSearchInfo.getType() == 2) {
            b(this.mHotSearchInfo.getName(), false, 1);
        } else if (this.mHotSearchInfo.getType() == 1 && !com.baidu.tbadk.plugins.b.h(this.mActivity.getPageContext())) {
            this.mActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.mActivity.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new an("c10355").cp("obj_name", this.mHotSearchInfo.getName()).Z("obj_type", this.mHotSearchInfo.getType() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.a.b
    public void b(final String str, boolean z, int i) {
        if (!j.isNetWorkAvailable()) {
            this.mActivity.showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.ieu = false;
                this.ieh.Ef(str);
                this.ieu = true;
            }
            l.hideSoftKeyPad(this.mActivity.getPageContext().getPageActivity(), this.ieh.ccV());
            this.ieh.ccU();
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str + ETAG.ITEM_SEPARATOR + "sub_type" + ETAG.EQUAL + i;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.ieh.ccX().loadUrl(str2);
            ac.a(new ab<Boolean>() { // from class: com.baidu.tieba.mainentrance.a.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ab
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.IV(str);
                    return true;
                }
            }, null);
            this.iev.Eb(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TURN_TAB_LOC, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cde() {
        if (!this.ieh.ccZ()) {
            ccA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccO() {
        this.iev.ccO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdf() {
        if (!StringUtils.isNull(this.gkm)) {
            ccA();
        } else {
            ccO();
        }
    }

    private void ccA() {
        if (StringUtils.isNull(this.gkm)) {
            ccO();
            return;
        }
        SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
        searchListNetMessage.mKey = this.gkm.trim();
        searchListNetMessage.isForum = Integer.valueOf(this.iet ? 1 : 0);
        this.mActivity.sendMessage(searchListNetMessage);
    }

    public void b(HotSearchInfoData hotSearchInfoData) {
        this.mHotSearchInfo = hotSearchInfoData;
        ccu();
    }

    public BaseWebView cdg() {
        return this.ieh.ccX();
    }

    private void ccu() {
        if (this.mHotSearchInfo == null) {
            this.ieh.Ee(this.mActivity.getResources().getString(R.string.search_bar));
        } else {
            this.ieh.Ee(this.mHotSearchInfo.bwj());
        }
    }

    public void du(List<String> list) {
        this.ieh.j(list, this.gkm);
    }

    public void dv(List<ForumInfo> list) {
        this.ieh.k(list, this.gkm);
    }

    public void onDestroy() {
        if (this.ieh != null) {
            this.ieh.onDestroy();
        }
    }
}
