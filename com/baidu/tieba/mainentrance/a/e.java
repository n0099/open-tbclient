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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.d;
import com.baidu.tieba.mainentrance.HotSearchInfoData;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListNetMessage;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes6.dex */
public class e implements b {
    private BaseActivity cNd;
    private String eWU;
    private d gOh;
    private boolean gOt;
    private boolean gOu = true;
    private c gOv;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;

    public e(BaseActivity baseActivity, boolean z) {
        this.cNd = baseActivity;
        this.gOt = z;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.cNd).inflate(d.h.new_home_dialog_search, (ViewGroup) null);
            this.cNd.setContentView(this.mRootView);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> bBS = a.bBS();
            if (bBS != null) {
                int size = bBS.size();
                int i2 = 0;
                Iterator<String> it = bBS.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    a.yl(it.next());
                    try {
                        this.mRootView = LayoutInflater.from(this.cNd).inflate(d.h.new_home_dialog_search, (ViewGroup) null);
                        this.cNd.setContentView(this.mRootView);
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        i2 = i + 1;
                    }
                }
                if (i == size) {
                    this.cNd.finish();
                    return;
                }
            } else {
                this.cNd.finish();
                return;
            }
        }
        if (this.mRootView == null) {
            this.cNd.finish();
            return;
        }
        this.gOh = new d(this.mRootView, this.cNd.getPageContext().getPageActivity());
        this.gOv = new c(this.cNd, this, this.gOh);
        bCh();
        bCi();
        bCj();
        bBC();
        bCm();
        ae.a(this.gOh.bCe(), this.cNd.getUniqueId());
        ae.a(this.gOh.bCf(), this.cNd.getUniqueId());
    }

    public void onResume() {
        if (this.gOh != null) {
            this.gOh.onResume();
        }
    }

    public void bCh() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.a.e.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(e.this.cNd.getPageContext().getPageActivity(), view);
                } else {
                    e.this.bCl();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.a.e.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(e.this.eWU)) {
                        l.b(e.this.cNd.getPageContext().getPageActivity(), textView);
                        e.this.bCk();
                        return true;
                    }
                    e.this.a(e.this.eWU, false, 1);
                    TiebaStatic.log(new am("c12842").bJ("obj_name", e.this.eWU).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").bJ("obj_type", "1"));
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
                    if (e.this.gOu) {
                        e.this.eWU = editable.toString();
                        e.this.bCm();
                    }
                    e.this.gOh.kA(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != e.this.gOh.bCc() || e.this.gOh.bCc().getText() == null) {
                    if (view == e.this.gOh.bCd()) {
                        l.b(e.this.cNd.getPageContext().getPageActivity(), e.this.gOh.bCc());
                        com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.a.e.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.cNd.finish();
                            }
                        }, 200L);
                        return;
                    }
                    return;
                }
                e.this.eWU = e.this.gOh.bCc().getText().toString();
                if (StringUtils.isNull(e.this.eWU)) {
                    e.this.bBV();
                }
            }
        };
        this.gOh.a(onFocusChangeListener);
        this.gOh.a(onEditorActionListener);
        this.gOh.e(textWatcher);
        this.gOh.setOnClickListener(onClickListener);
    }

    private void bCi() {
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
                        TiebaStatic.eventStat(e.this.cNd.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                        TiebaStatic.log(new am("c12842").bJ("obj_name", str).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2").bJ("obj_type", "1").T("obj_locate", i + 1).bJ("obj_param1", e.this.eWU));
                    } else if (item instanceof ForumInfo) {
                        ForumInfo forumInfo = (ForumInfo) item;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.cNd.getPageContext().getPageActivity()).createNormalCfg(forumInfo.forum_name, FrsActivityConfig.FRS_CALL_SEARCH)));
                        TiebaStatic.log(new am("c13371").bJ("obj_type", forumInfo.has_concerned.intValue() > 0 ? "1" : "2").T(ImageViewerConfig.FORUM_ID, forumInfo.forum_id.intValue()).k("uid", TbadkApplication.getCurrentAccountId()));
                    }
                }
            }
        };
        AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.a.e.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.b(e.this.cNd.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        };
        this.gOh.c(onItemClickListener);
        this.gOh.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.gOh.onChangeSkinType(this.cNd.getPageContext(), i);
    }

    private void bCj() {
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
                if (ba.adA().b(e.this.cNd.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains("jump=open_full_screen_web_page")) {
                    return false;
                }
                ba.adA().a(e.this.cNd.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.gOh.a(cVar);
        this.gOh.a(fVar);
        this.gOh.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCk() {
        if (this.mHotSearchInfo == null) {
            this.cNd.showToast(this.cNd.getResources().getString(d.j.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.bBt() == 0 || this.mHotSearchInfo.bBt() == 2) {
            a(this.mHotSearchInfo.getName(), false, 1);
        } else if (this.mHotSearchInfo.bBt() == 1 && !com.baidu.tbadk.plugins.b.f(this.cNd.getPageContext())) {
            this.cNd.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.cNd.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new am("c10355").bJ("obj_name", this.mHotSearchInfo.getName()).T("obj_type", this.mHotSearchInfo.bBt() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.a.b
    public void a(final String str, boolean z, int i) {
        if (!j.kY()) {
            this.cNd.showToast(d.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.gOu = false;
                this.gOh.yq(str);
                this.gOu = true;
            }
            l.b(this.cNd.getPageContext().getPageActivity(), this.gOh.bCc());
            this.gOh.bCb();
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str + "&sub_type=" + i;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gOh.bCe().loadUrl(str2);
            aa.a(new z<Boolean>() { // from class: com.baidu.tieba.mainentrance.a.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.z
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.CG(str);
                    return true;
                }
            }, null);
            this.gOv.ym(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921345, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCl() {
        if (!this.gOh.bCg()) {
            bBH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBV() {
        this.gOv.bBV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCm() {
        if (!StringUtils.isNull(this.eWU)) {
            bBH();
        } else {
            bBV();
        }
    }

    private void bBH() {
        if (StringUtils.isNull(this.eWU)) {
            bBV();
            return;
        }
        SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
        searchListNetMessage.mKey = this.eWU.trim();
        searchListNetMessage.isForum = Integer.valueOf(this.gOt ? 1 : 0);
        this.cNd.sendMessage(searchListNetMessage);
    }

    public void b(HotSearchInfoData hotSearchInfoData) {
        this.mHotSearchInfo = hotSearchInfoData;
        bBC();
    }

    public BaseWebView bCn() {
        return this.gOh.bCe();
    }

    private void bBC() {
        if (this.mHotSearchInfo == null) {
            this.gOh.yp(this.cNd.getResources().getString(d.j.search_bar));
        } else {
            this.gOh.yp(this.mHotSearchInfo.aWg());
        }
    }

    public void dj(List<String> list) {
        this.gOh.k(list, this.eWU);
    }

    public void dk(List<ForumInfo> list) {
        this.gOh.l(list, this.eWU);
    }

    public void onDestroy() {
        if (this.gOh != null) {
            this.gOh.onDestroy();
        }
    }
}
