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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
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
    private BaseActivity cVq;
    private String fmZ;
    private d hfD;
    private boolean hfO;
    private boolean hfP = true;
    private c hfQ;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;

    public e(BaseActivity baseActivity, boolean z) {
        this.cVq = baseActivity;
        this.hfO = z;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.cVq).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
            this.cVq.setContentView(this.mRootView);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> bJG = a.bJG();
            if (bJG != null) {
                int size = bJG.size();
                int i2 = 0;
                Iterator<String> it = bJG.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    a.zD(it.next());
                    try {
                        this.mRootView = LayoutInflater.from(this.cVq).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
                        this.cVq.setContentView(this.mRootView);
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        i2 = i + 1;
                    }
                }
                if (i == size) {
                    this.cVq.finish();
                    return;
                }
            } else {
                this.cVq.finish();
                return;
            }
        }
        if (this.mRootView == null) {
            this.cVq.finish();
            return;
        }
        this.hfD = new d(this.mRootView, this.cVq.getPageContext().getPageActivity());
        this.hfQ = new c(this.cVq, this, this.hfD);
        bJV();
        bJW();
        bJX();
        bJq();
        bKa();
        ae.a(this.hfD.bJS(), this.cVq.getUniqueId());
        ae.a(this.hfD.bJT(), this.cVq.getUniqueId());
    }

    public void onResume() {
        if (this.hfD != null) {
            this.hfD.onResume();
        }
    }

    public void bJV() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.a.e.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(e.this.cVq.getPageContext().getPageActivity(), view);
                } else {
                    e.this.bJZ();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.a.e.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(e.this.fmZ)) {
                        l.b(e.this.cVq.getPageContext().getPageActivity(), textView);
                        e.this.bJY();
                        return true;
                    }
                    e.this.a(e.this.fmZ, false, 1);
                    TiebaStatic.log(new am("c12842").bT("obj_name", e.this.fmZ).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").bT("obj_type", "1"));
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
                    if (e.this.hfP) {
                        e.this.fmZ = editable.toString();
                        e.this.bKa();
                    }
                    e.this.hfD.ij(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != e.this.hfD.bJQ() || e.this.hfD.bJQ().getText() == null) {
                    if (view == e.this.hfD.bJR()) {
                        l.b(e.this.cVq.getPageContext().getPageActivity(), e.this.hfD.bJQ());
                        com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.a.e.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.cVq.finish();
                            }
                        }, 200L);
                        return;
                    }
                    return;
                }
                e.this.fmZ = e.this.hfD.bJQ().getText().toString();
                if (StringUtils.isNull(e.this.fmZ)) {
                    e.this.bJJ();
                }
            }
        };
        this.hfD.a(onFocusChangeListener);
        this.hfD.a(onEditorActionListener);
        this.hfD.e(textWatcher);
        this.hfD.setOnClickListener(onClickListener);
    }

    private void bJW() {
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
                        TiebaStatic.eventStat(e.this.cVq.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                        TiebaStatic.log(new am("c12842").bT("obj_name", str).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2").bT("obj_type", "1").P("obj_locate", i + 1).bT("obj_param1", e.this.fmZ));
                    } else if (item instanceof ForumInfo) {
                        ForumInfo forumInfo = (ForumInfo) item;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.cVq.getPageContext().getPageActivity()).createNormalCfg(forumInfo.forum_name, FrsActivityConfig.FRS_CALL_SEARCH)));
                        TiebaStatic.log(new am("c13371").bT("obj_type", forumInfo.has_concerned.intValue() > 0 ? "1" : "2").P("fid", forumInfo.forum_id.intValue()).l("uid", TbadkApplication.getCurrentAccountId()));
                    }
                }
            }
        };
        AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.a.e.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.b(e.this.cVq.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        };
        this.hfD.c(onItemClickListener);
        this.hfD.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.hfD.onChangeSkinType(this.cVq.getPageContext(), i);
    }

    private void bJX() {
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
                if (ba.aiz().b(e.this.cVq.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains("jump=open_full_screen_web_page")) {
                    return false;
                }
                ba.aiz().a(e.this.cVq.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.hfD.a(cVar);
        this.hfD.a(fVar);
        this.hfD.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJY() {
        if (this.mHotSearchInfo == null) {
            this.cVq.showToast(this.cVq.getResources().getString(R.string.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.bJh() == 0 || this.mHotSearchInfo.bJh() == 2) {
            a(this.mHotSearchInfo.getName(), false, 1);
        } else if (this.mHotSearchInfo.bJh() == 1 && !com.baidu.tbadk.plugins.b.f(this.cVq.getPageContext())) {
            this.cVq.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.cVq.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new am("c10355").bT("obj_name", this.mHotSearchInfo.getName()).P("obj_type", this.mHotSearchInfo.bJh() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.a.b
    public void a(final String str, boolean z, int i) {
        if (!j.jS()) {
            this.cVq.showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.hfP = false;
                this.hfD.zI(str);
                this.hfP = true;
            }
            l.b(this.cVq.getPageContext().getPageActivity(), this.hfD.bJQ());
            this.hfD.bJP();
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str + "&sub_type=" + i;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hfD.bJS().loadUrl(str2);
            aa.a(new z<Boolean>() { // from class: com.baidu.tieba.mainentrance.a.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.z
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.Ee(str);
                    return true;
                }
            }, null);
            this.hfQ.zE(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921345, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJZ() {
        if (!this.hfD.bJU()) {
            bJv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJJ() {
        this.hfQ.bJJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKa() {
        if (!StringUtils.isNull(this.fmZ)) {
            bJv();
        } else {
            bJJ();
        }
    }

    private void bJv() {
        if (StringUtils.isNull(this.fmZ)) {
            bJJ();
            return;
        }
        SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
        searchListNetMessage.mKey = this.fmZ.trim();
        searchListNetMessage.isForum = Integer.valueOf(this.hfO ? 1 : 0);
        this.cVq.sendMessage(searchListNetMessage);
    }

    public void b(HotSearchInfoData hotSearchInfoData) {
        this.mHotSearchInfo = hotSearchInfoData;
        bJq();
    }

    public BaseWebView bKb() {
        return this.hfD.bJS();
    }

    private void bJq() {
        if (this.mHotSearchInfo == null) {
            this.hfD.zH(this.cVq.getResources().getString(R.string.search_bar));
        } else {
            this.hfD.zH(this.mHotSearchInfo.bdl());
        }
    }

    public void dr(List<String> list) {
        this.hfD.k(list, this.fmZ);
    }

    public void ds(List<ForumInfo> list) {
        this.hfD.l(list, this.fmZ);
    }

    public void onDestroy() {
        if (this.hfD != null) {
            this.hfD.onDestroy();
        }
    }
}
