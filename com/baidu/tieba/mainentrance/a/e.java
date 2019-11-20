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
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.HotSearchInfoData;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListNetMessage;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes6.dex */
public class e implements b {
    private String fsG;
    private boolean hmK;
    private boolean hmL = true;
    private c hmM;
    private d hmz;
    private BaseActivity mActivity;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;

    public e(BaseActivity baseActivity, boolean z) {
        this.mActivity = baseActivity;
        this.hmK = z;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.mActivity).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
            this.mActivity.setContentView(this.mRootView);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> bKo = a.bKo();
            if (bKo != null) {
                int size = bKo.size();
                int i2 = 0;
                Iterator<String> it = bKo.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    a.zi(it.next());
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
        this.hmz = new d(this.mRootView, this.mActivity.getPageContext().getPageActivity());
        this.hmM = new c(this.mActivity, this, this.hmz);
        bKD();
        bKE();
        bKF();
        bJY();
        bKI();
        ad.a(this.hmz.bKA(), this.mActivity.getUniqueId());
        ad.a(this.hmz.bKB(), this.mActivity.getUniqueId());
    }

    public void onResume() {
        if (this.hmz != null) {
            this.hmz.onResume();
        }
    }

    public void bKD() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.a.e.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(e.this.mActivity.getPageContext().getPageActivity(), view);
                } else {
                    e.this.bKH();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.a.e.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(e.this.fsG)) {
                        l.hideSoftKeyPad(e.this.mActivity.getPageContext().getPageActivity(), textView);
                        e.this.bKG();
                        return true;
                    }
                    e.this.b(e.this.fsG, false, 1);
                    TiebaStatic.log(new an("c12842").bS("obj_name", e.this.fsG).bS("obj_source", "1").bS("obj_type", "1"));
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
                    if (e.this.hmL) {
                        e.this.fsG = editable.toString();
                        e.this.bKI();
                    }
                    e.this.hmz.iy(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != e.this.hmz.bKy() || e.this.hmz.bKy().getText() == null) {
                    if (view == e.this.hmz.bKz()) {
                        l.hideSoftKeyPad(e.this.mActivity.getPageContext().getPageActivity(), e.this.hmz.bKy());
                        com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.a.e.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.mActivity.finish();
                            }
                        }, 200L);
                        return;
                    }
                    return;
                }
                e.this.fsG = e.this.hmz.bKy().getText().toString();
                if (StringUtils.isNull(e.this.fsG)) {
                    e.this.bKr();
                }
            }
        };
        this.hmz.a(onFocusChangeListener);
        this.hmz.a(onEditorActionListener);
        this.hmz.f(textWatcher);
        this.hmz.setOnClickListener(onClickListener);
    }

    private void bKE() {
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
                        TiebaStatic.log(new an("c12842").bS("obj_name", str).bS("obj_source", "2").bS("obj_type", "1").O("obj_locate", i + 1).bS("obj_param1", e.this.fsG));
                    } else if (item instanceof ForumInfo) {
                        ForumInfo forumInfo = (ForumInfo) item;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.mActivity.getPageContext().getPageActivity()).createNormalCfg(forumInfo.forum_name, FrsActivityConfig.FRS_CALL_SEARCH)));
                        TiebaStatic.log(new an("c13371").bS("obj_type", forumInfo.has_concerned.intValue() > 0 ? "1" : "2").O("fid", forumInfo.forum_id.intValue()).p("uid", TbadkApplication.getCurrentAccountId()));
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
        this.hmz.c(onItemClickListener);
        this.hmz.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.hmz.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    private void bKF() {
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
                if (ba.amO().a(e.this.mActivity.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE)) {
                    return false;
                }
                ba.amO().a(e.this.mActivity.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.hmz.a(cVar);
        this.hmz.a(fVar);
        this.hmz.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKG() {
        if (this.mHotSearchInfo == null) {
            this.mActivity.showToast(this.mActivity.getResources().getString(R.string.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.getType() == 0 || this.mHotSearchInfo.getType() == 2) {
            b(this.mHotSearchInfo.getName(), false, 1);
        } else if (this.mHotSearchInfo.getType() == 1 && !com.baidu.tbadk.plugins.b.f(this.mActivity.getPageContext())) {
            this.mActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.mActivity.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new an("c10355").bS("obj_name", this.mHotSearchInfo.getName()).O("obj_type", this.mHotSearchInfo.getType() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.a.b
    public void b(final String str, boolean z, int i) {
        if (!j.isNetWorkAvailable()) {
            this.mActivity.showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.hmL = false;
                this.hmz.zn(str);
                this.hmL = true;
            }
            l.hideSoftKeyPad(this.mActivity.getPageContext().getPageActivity(), this.hmz.bKy());
            this.hmz.bKx();
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str + "&sub_type=" + i;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hmz.bKA().loadUrl(str2);
            z.a(new y<Boolean>() { // from class: com.baidu.tieba.mainentrance.a.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.y
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.DW(str);
                    return true;
                }
            }, null);
            this.hmM.zj(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921345, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKH() {
        if (!this.hmz.bKC()) {
            bKd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKr() {
        this.hmM.bKr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKI() {
        if (!StringUtils.isNull(this.fsG)) {
            bKd();
        } else {
            bKr();
        }
    }

    private void bKd() {
        if (StringUtils.isNull(this.fsG)) {
            bKr();
            return;
        }
        SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
        searchListNetMessage.mKey = this.fsG.trim();
        searchListNetMessage.isForum = Integer.valueOf(this.hmK ? 1 : 0);
        this.mActivity.sendMessage(searchListNetMessage);
    }

    public void b(HotSearchInfoData hotSearchInfoData) {
        this.mHotSearchInfo = hotSearchInfoData;
        bJY();
    }

    public BaseWebView bKJ() {
        return this.hmz.bKA();
    }

    private void bJY() {
        if (this.mHotSearchInfo == null) {
            this.hmz.zm(this.mActivity.getResources().getString(R.string.search_bar));
        } else {
            this.hmz.zm(this.mHotSearchInfo.bdL());
        }
    }

    public void dF(List<String> list) {
        this.hmz.i(list, this.fsG);
    }

    public void dG(List<ForumInfo> list) {
        this.hmz.j(list, this.fsG);
    }

    public void onDestroy() {
        if (this.hmz != null) {
            this.hmz.onDestroy();
        }
    }
}
