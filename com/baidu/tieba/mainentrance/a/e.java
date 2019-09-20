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
    private BaseActivity cXM;
    private String fuk;
    private d hoC;
    private boolean hoN;
    private boolean hoO = true;
    private c hoP;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;

    public e(BaseActivity baseActivity, boolean z) {
        this.cXM = baseActivity;
        this.hoN = z;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.cXM).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
            this.cXM.setContentView(this.mRootView);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> bNo = a.bNo();
            if (bNo != null) {
                int size = bNo.size();
                int i2 = 0;
                Iterator<String> it = bNo.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    a.AO(it.next());
                    try {
                        this.mRootView = LayoutInflater.from(this.cXM).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
                        this.cXM.setContentView(this.mRootView);
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        i2 = i + 1;
                    }
                }
                if (i == size) {
                    this.cXM.finish();
                    return;
                }
            } else {
                this.cXM.finish();
                return;
            }
        }
        if (this.mRootView == null) {
            this.cXM.finish();
            return;
        }
        this.hoC = new d(this.mRootView, this.cXM.getPageContext().getPageActivity());
        this.hoP = new c(this.cXM, this, this.hoC);
        bND();
        bNE();
        bNF();
        bMY();
        bNI();
        ad.a(this.hoC.bNA(), this.cXM.getUniqueId());
        ad.a(this.hoC.bNB(), this.cXM.getUniqueId());
    }

    public void onResume() {
        if (this.hoC != null) {
            this.hoC.onResume();
        }
    }

    public void bND() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.a.e.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(e.this.cXM.getPageContext().getPageActivity(), view);
                } else {
                    e.this.bNH();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.a.e.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(e.this.fuk)) {
                        l.b(e.this.cXM.getPageContext().getPageActivity(), textView);
                        e.this.bNG();
                        return true;
                    }
                    e.this.a(e.this.fuk, false, 1);
                    TiebaStatic.log(new an("c12842").bT("obj_name", e.this.fuk).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").bT("obj_type", "1"));
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
                    if (e.this.hoO) {
                        e.this.fuk = editable.toString();
                        e.this.bNI();
                    }
                    e.this.hoC.iv(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != e.this.hoC.bNy() || e.this.hoC.bNy().getText() == null) {
                    if (view == e.this.hoC.bNz()) {
                        l.b(e.this.cXM.getPageContext().getPageActivity(), e.this.hoC.bNy());
                        com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.a.e.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.cXM.finish();
                            }
                        }, 200L);
                        return;
                    }
                    return;
                }
                e.this.fuk = e.this.hoC.bNy().getText().toString();
                if (StringUtils.isNull(e.this.fuk)) {
                    e.this.bNr();
                }
            }
        };
        this.hoC.a(onFocusChangeListener);
        this.hoC.a(onEditorActionListener);
        this.hoC.f(textWatcher);
        this.hoC.setOnClickListener(onClickListener);
    }

    private void bNE() {
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
                        TiebaStatic.eventStat(e.this.cXM.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                        TiebaStatic.log(new an("c12842").bT("obj_name", str).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2").bT("obj_type", "1").P("obj_locate", i + 1).bT("obj_param1", e.this.fuk));
                    } else if (item instanceof ForumInfo) {
                        ForumInfo forumInfo = (ForumInfo) item;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.cXM.getPageContext().getPageActivity()).createNormalCfg(forumInfo.forum_name, FrsActivityConfig.FRS_CALL_SEARCH)));
                        TiebaStatic.log(new an("c13371").bT("obj_type", forumInfo.has_concerned.intValue() > 0 ? "1" : "2").P("fid", forumInfo.forum_id.intValue()).n("uid", TbadkApplication.getCurrentAccountId()));
                    }
                }
            }
        };
        AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.a.e.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.b(e.this.cXM.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        };
        this.hoC.c(onItemClickListener);
        this.hoC.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.hoC.onChangeSkinType(this.cXM.getPageContext(), i);
    }

    private void bNF() {
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
                if (ba.ajK().b(e.this.cXM.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains("jump=open_full_screen_web_page")) {
                    return false;
                }
                ba.ajK().a(e.this.cXM.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.hoC.a(cVar);
        this.hoC.a(fVar);
        this.hoC.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNG() {
        if (this.mHotSearchInfo == null) {
            this.cXM.showToast(this.cXM.getResources().getString(R.string.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.bMP() == 0 || this.mHotSearchInfo.bMP() == 2) {
            a(this.mHotSearchInfo.getName(), false, 1);
        } else if (this.mHotSearchInfo.bMP() == 1 && !com.baidu.tbadk.plugins.b.f(this.cXM.getPageContext())) {
            this.cXM.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.cXM.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new an("c10355").bT("obj_name", this.mHotSearchInfo.getName()).P("obj_type", this.mHotSearchInfo.bMP() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.a.b
    public void a(final String str, boolean z, int i) {
        if (!j.kc()) {
            this.cXM.showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.hoO = false;
                this.hoC.AT(str);
                this.hoO = true;
            }
            l.b(this.cXM.getPageContext().getPageActivity(), this.hoC.bNy());
            this.hoC.bNx();
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str + "&sub_type=" + i;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hoC.bNA().loadUrl(str2);
            z.a(new y<Boolean>() { // from class: com.baidu.tieba.mainentrance.a.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.y
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.Fs(str);
                    return true;
                }
            }, null);
            this.hoP.AP(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921345, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNH() {
        if (!this.hoC.bNC()) {
            bNd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNr() {
        this.hoP.bNr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNI() {
        if (!StringUtils.isNull(this.fuk)) {
            bNd();
        } else {
            bNr();
        }
    }

    private void bNd() {
        if (StringUtils.isNull(this.fuk)) {
            bNr();
            return;
        }
        SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
        searchListNetMessage.mKey = this.fuk.trim();
        searchListNetMessage.isForum = Integer.valueOf(this.hoN ? 1 : 0);
        this.cXM.sendMessage(searchListNetMessage);
    }

    public void b(HotSearchInfoData hotSearchInfoData) {
        this.mHotSearchInfo = hotSearchInfoData;
        bMY();
    }

    public BaseWebView bNJ() {
        return this.hoC.bNA();
    }

    private void bMY() {
        if (this.mHotSearchInfo == null) {
            this.hoC.AS(this.cXM.getResources().getString(R.string.search_bar));
        } else {
            this.hoC.AS(this.mHotSearchInfo.bfT());
        }
    }

    public void ds(List<String> list) {
        this.hoC.k(list, this.fuk);
    }

    public void dt(List<ForumInfo> list) {
        this.hoC.l(list, this.fuk);
    }

    public void onDestroy() {
        if (this.hoC != null) {
            this.hoC.onDestroy();
        }
    }
}
