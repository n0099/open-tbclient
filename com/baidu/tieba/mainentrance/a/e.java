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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.ae;
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
    private BaseActivity cWT;
    private String fsx;
    private d hmI;
    private boolean hmT;
    private boolean hmU = true;
    private c hmV;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;

    public e(BaseActivity baseActivity, boolean z) {
        this.cWT = baseActivity;
        this.hmT = z;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.cWT).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
            this.cWT.setContentView(this.mRootView);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> bMB = a.bMB();
            if (bMB != null) {
                int size = bMB.size();
                int i2 = 0;
                Iterator<String> it = bMB.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    a.Ap(it.next());
                    try {
                        this.mRootView = LayoutInflater.from(this.cWT).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
                        this.cWT.setContentView(this.mRootView);
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        i2 = i + 1;
                    }
                }
                if (i == size) {
                    this.cWT.finish();
                    return;
                }
            } else {
                this.cWT.finish();
                return;
            }
        }
        if (this.mRootView == null) {
            this.cWT.finish();
            return;
        }
        this.hmI = new d(this.mRootView, this.cWT.getPageContext().getPageActivity());
        this.hmV = new c(this.cWT, this, this.hmI);
        bMQ();
        bMR();
        bMS();
        bMl();
        bMV();
        ae.a(this.hmI.bMN(), this.cWT.getUniqueId());
        ae.a(this.hmI.bMO(), this.cWT.getUniqueId());
    }

    public void onResume() {
        if (this.hmI != null) {
            this.hmI.onResume();
        }
    }

    public void bMQ() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.a.e.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(e.this.cWT.getPageContext().getPageActivity(), view);
                } else {
                    e.this.bMU();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.a.e.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(e.this.fsx)) {
                        l.b(e.this.cWT.getPageContext().getPageActivity(), textView);
                        e.this.bMT();
                        return true;
                    }
                    e.this.a(e.this.fsx, false, 1);
                    TiebaStatic.log(new an("c12842").bT("obj_name", e.this.fsx).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").bT("obj_type", "1"));
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
                    if (e.this.hmU) {
                        e.this.fsx = editable.toString();
                        e.this.bMV();
                    }
                    e.this.hmI.is(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != e.this.hmI.bML() || e.this.hmI.bML().getText() == null) {
                    if (view == e.this.hmI.bMM()) {
                        l.b(e.this.cWT.getPageContext().getPageActivity(), e.this.hmI.bML());
                        com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.a.e.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.cWT.finish();
                            }
                        }, 200L);
                        return;
                    }
                    return;
                }
                e.this.fsx = e.this.hmI.bML().getText().toString();
                if (StringUtils.isNull(e.this.fsx)) {
                    e.this.bME();
                }
            }
        };
        this.hmI.a(onFocusChangeListener);
        this.hmI.a(onEditorActionListener);
        this.hmI.f(textWatcher);
        this.hmI.setOnClickListener(onClickListener);
    }

    private void bMR() {
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.6
            /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ?? adapter = adapterView.getAdapter();
                if (adapter != 0 && i < adapter.getCount()) {
                    Object item = adapter.getItem(i);
                    if (item instanceof String) {
                        String str = (String) item;
                        e.this.a(str, true, 3);
                        TiebaStatic.eventStat(e.this.cWT.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                        TiebaStatic.log(new an("c12842").bT("obj_name", str).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2").bT("obj_type", "1").P("obj_locate", i + 1).bT("obj_param1", e.this.fsx));
                    } else if (item instanceof ForumInfo) {
                        ForumInfo forumInfo = (ForumInfo) item;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.cWT.getPageContext().getPageActivity()).createNormalCfg(forumInfo.forum_name, FrsActivityConfig.FRS_CALL_SEARCH)));
                        TiebaStatic.log(new an("c13371").bT("obj_type", forumInfo.has_concerned.intValue() > 0 ? "1" : "2").P("fid", forumInfo.forum_id.intValue()).l("uid", TbadkApplication.getCurrentAccountId()));
                    }
                }
            }
        };
        AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.a.e.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.b(e.this.cWT.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        };
        this.hmI.c(onItemClickListener);
        this.hmI.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.hmI.onChangeSkinType(this.cWT.getPageContext(), i);
    }

    private void bMS() {
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
                if (bb.ajE().b(e.this.cWT.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains("jump=open_full_screen_web_page")) {
                    return false;
                }
                bb.ajE().a(e.this.cWT.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.hmI.a(cVar);
        this.hmI.a(fVar);
        this.hmI.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMT() {
        if (this.mHotSearchInfo == null) {
            this.cWT.showToast(this.cWT.getResources().getString(R.string.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.bMc() == 0 || this.mHotSearchInfo.bMc() == 2) {
            a(this.mHotSearchInfo.getName(), false, 1);
        } else if (this.mHotSearchInfo.bMc() == 1 && !com.baidu.tbadk.plugins.b.f(this.cWT.getPageContext())) {
            this.cWT.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.cWT.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new an("c10355").bT("obj_name", this.mHotSearchInfo.getName()).P("obj_type", this.mHotSearchInfo.bMc() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.a.b
    public void a(final String str, boolean z, int i) {
        if (!j.kc()) {
            this.cWT.showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.hmU = false;
                this.hmI.Au(str);
                this.hmU = true;
            }
            l.b(this.cWT.getPageContext().getPageActivity(), this.hmI.bML());
            this.hmI.bMK();
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str + "&sub_type=" + i;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hmI.bMN().loadUrl(str2);
            aa.a(new z<Boolean>() { // from class: com.baidu.tieba.mainentrance.a.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.z
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.ES(str);
                    return true;
                }
            }, null);
            this.hmV.Aq(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921345, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMU() {
        if (!this.hmI.bMP()) {
            bMq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bME() {
        this.hmV.bME();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMV() {
        if (!StringUtils.isNull(this.fsx)) {
            bMq();
        } else {
            bME();
        }
    }

    private void bMq() {
        if (StringUtils.isNull(this.fsx)) {
            bME();
            return;
        }
        SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
        searchListNetMessage.mKey = this.fsx.trim();
        searchListNetMessage.isForum = Integer.valueOf(this.hmT ? 1 : 0);
        this.cWT.sendMessage(searchListNetMessage);
    }

    public void b(HotSearchInfoData hotSearchInfoData) {
        this.mHotSearchInfo = hotSearchInfoData;
        bMl();
    }

    public BaseWebView bMW() {
        return this.hmI.bMN();
    }

    private void bMl() {
        if (this.mHotSearchInfo == null) {
            this.hmI.At(this.cWT.getResources().getString(R.string.search_bar));
        } else {
            this.hmI.At(this.mHotSearchInfo.bfp());
        }
    }

    public void ds(List<String> list) {
        this.hmI.k(list, this.fsx);
    }

    public void dt(List<ForumInfo> list) {
        this.hmI.l(list, this.fsx);
    }

    public void onDestroy() {
        if (this.hmI != null) {
            this.hmI.onDestroy();
        }
    }
}
