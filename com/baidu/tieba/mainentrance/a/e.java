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
    private BaseActivity cWM;
    private String frY;
    private d hlQ;
    private boolean hmb;
    private boolean hmc = true;
    private c hmd;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;

    public e(BaseActivity baseActivity, boolean z) {
        this.cWM = baseActivity;
        this.hmb = z;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.cWM).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
            this.cWM.setContentView(this.mRootView);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> bMn = a.bMn();
            if (bMn != null) {
                int size = bMn.size();
                int i2 = 0;
                Iterator<String> it = bMn.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    a.Ao(it.next());
                    try {
                        this.mRootView = LayoutInflater.from(this.cWM).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
                        this.cWM.setContentView(this.mRootView);
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        i2 = i + 1;
                    }
                }
                if (i == size) {
                    this.cWM.finish();
                    return;
                }
            } else {
                this.cWM.finish();
                return;
            }
        }
        if (this.mRootView == null) {
            this.cWM.finish();
            return;
        }
        this.hlQ = new d(this.mRootView, this.cWM.getPageContext().getPageActivity());
        this.hmd = new c(this.cWM, this, this.hlQ);
        bMC();
        bMD();
        bME();
        bLX();
        bMH();
        ae.a(this.hlQ.bMz(), this.cWM.getUniqueId());
        ae.a(this.hlQ.bMA(), this.cWM.getUniqueId());
    }

    public void onResume() {
        if (this.hlQ != null) {
            this.hlQ.onResume();
        }
    }

    public void bMC() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.a.e.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(e.this.cWM.getPageContext().getPageActivity(), view);
                } else {
                    e.this.bMG();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.a.e.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(e.this.frY)) {
                        l.b(e.this.cWM.getPageContext().getPageActivity(), textView);
                        e.this.bMF();
                        return true;
                    }
                    e.this.a(e.this.frY, false, 1);
                    TiebaStatic.log(new an("c12842").bT("obj_name", e.this.frY).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").bT("obj_type", "1"));
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
                    if (e.this.hmc) {
                        e.this.frY = editable.toString();
                        e.this.bMH();
                    }
                    e.this.hlQ.is(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != e.this.hlQ.bMx() || e.this.hlQ.bMx().getText() == null) {
                    if (view == e.this.hlQ.bMy()) {
                        l.b(e.this.cWM.getPageContext().getPageActivity(), e.this.hlQ.bMx());
                        com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.a.e.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.cWM.finish();
                            }
                        }, 200L);
                        return;
                    }
                    return;
                }
                e.this.frY = e.this.hlQ.bMx().getText().toString();
                if (StringUtils.isNull(e.this.frY)) {
                    e.this.bMq();
                }
            }
        };
        this.hlQ.a(onFocusChangeListener);
        this.hlQ.a(onEditorActionListener);
        this.hlQ.f(textWatcher);
        this.hlQ.setOnClickListener(onClickListener);
    }

    private void bMD() {
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
                        TiebaStatic.eventStat(e.this.cWM.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                        TiebaStatic.log(new an("c12842").bT("obj_name", str).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2").bT("obj_type", "1").P("obj_locate", i + 1).bT("obj_param1", e.this.frY));
                    } else if (item instanceof ForumInfo) {
                        ForumInfo forumInfo = (ForumInfo) item;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.cWM.getPageContext().getPageActivity()).createNormalCfg(forumInfo.forum_name, FrsActivityConfig.FRS_CALL_SEARCH)));
                        TiebaStatic.log(new an("c13371").bT("obj_type", forumInfo.has_concerned.intValue() > 0 ? "1" : "2").P("fid", forumInfo.forum_id.intValue()).l("uid", TbadkApplication.getCurrentAccountId()));
                    }
                }
            }
        };
        AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.a.e.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.b(e.this.cWM.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        };
        this.hlQ.c(onItemClickListener);
        this.hlQ.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.hlQ.onChangeSkinType(this.cWM.getPageContext(), i);
    }

    private void bME() {
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
                if (bb.ajC().b(e.this.cWM.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains("jump=open_full_screen_web_page")) {
                    return false;
                }
                bb.ajC().a(e.this.cWM.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.hlQ.a(cVar);
        this.hlQ.a(fVar);
        this.hlQ.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMF() {
        if (this.mHotSearchInfo == null) {
            this.cWM.showToast(this.cWM.getResources().getString(R.string.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.bLO() == 0 || this.mHotSearchInfo.bLO() == 2) {
            a(this.mHotSearchInfo.getName(), false, 1);
        } else if (this.mHotSearchInfo.bLO() == 1 && !com.baidu.tbadk.plugins.b.f(this.cWM.getPageContext())) {
            this.cWM.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.cWM.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new an("c10355").bT("obj_name", this.mHotSearchInfo.getName()).P("obj_type", this.mHotSearchInfo.bLO() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.a.b
    public void a(final String str, boolean z, int i) {
        if (!j.kc()) {
            this.cWM.showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.hmc = false;
                this.hlQ.At(str);
                this.hmc = true;
            }
            l.b(this.cWM.getPageContext().getPageActivity(), this.hlQ.bMx());
            this.hlQ.bMw();
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str + "&sub_type=" + i;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hlQ.bMz().loadUrl(str2);
            aa.a(new z<Boolean>() { // from class: com.baidu.tieba.mainentrance.a.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.z
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.ER(str);
                    return true;
                }
            }, null);
            this.hmd.Ap(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921345, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMG() {
        if (!this.hlQ.bMB()) {
            bMc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMq() {
        this.hmd.bMq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMH() {
        if (!StringUtils.isNull(this.frY)) {
            bMc();
        } else {
            bMq();
        }
    }

    private void bMc() {
        if (StringUtils.isNull(this.frY)) {
            bMq();
            return;
        }
        SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
        searchListNetMessage.mKey = this.frY.trim();
        searchListNetMessage.isForum = Integer.valueOf(this.hmb ? 1 : 0);
        this.cWM.sendMessage(searchListNetMessage);
    }

    public void b(HotSearchInfoData hotSearchInfoData) {
        this.mHotSearchInfo = hotSearchInfoData;
        bLX();
    }

    public BaseWebView bMI() {
        return this.hlQ.bMz();
    }

    private void bLX() {
        if (this.mHotSearchInfo == null) {
            this.hlQ.As(this.cWM.getResources().getString(R.string.search_bar));
        } else {
            this.hlQ.As(this.mHotSearchInfo.bfn());
        }
    }

    public void dt(List<String> list) {
        this.hlQ.k(list, this.frY);
    }

    public void du(List<ForumInfo> list) {
        this.hlQ.l(list, this.frY);
    }

    public void onDestroy() {
        if (this.hlQ != null) {
            this.hlQ.onDestroy();
        }
    }
}
