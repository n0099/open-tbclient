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
    private BaseActivity cNc;
    private String eWT;
    private d gOg;
    private boolean gOs;
    private boolean gOt = true;
    private c gOu;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;

    public e(BaseActivity baseActivity, boolean z) {
        this.cNc = baseActivity;
        this.gOs = z;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.cNc).inflate(d.h.new_home_dialog_search, (ViewGroup) null);
            this.cNc.setContentView(this.mRootView);
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
                        this.mRootView = LayoutInflater.from(this.cNc).inflate(d.h.new_home_dialog_search, (ViewGroup) null);
                        this.cNc.setContentView(this.mRootView);
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        i2 = i + 1;
                    }
                }
                if (i == size) {
                    this.cNc.finish();
                    return;
                }
            } else {
                this.cNc.finish();
                return;
            }
        }
        if (this.mRootView == null) {
            this.cNc.finish();
            return;
        }
        this.gOg = new d(this.mRootView, this.cNc.getPageContext().getPageActivity());
        this.gOu = new c(this.cNc, this, this.gOg);
        bCh();
        bCi();
        bCj();
        bBC();
        bCm();
        ae.a(this.gOg.bCe(), this.cNc.getUniqueId());
        ae.a(this.gOg.bCf(), this.cNc.getUniqueId());
    }

    public void onResume() {
        if (this.gOg != null) {
            this.gOg.onResume();
        }
    }

    public void bCh() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.a.e.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(e.this.cNc.getPageContext().getPageActivity(), view);
                } else {
                    e.this.bCl();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.a.e.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(e.this.eWT)) {
                        l.b(e.this.cNc.getPageContext().getPageActivity(), textView);
                        e.this.bCk();
                        return true;
                    }
                    e.this.a(e.this.eWT, false, 1);
                    TiebaStatic.log(new am("c12842").bJ("obj_name", e.this.eWT).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").bJ("obj_type", "1"));
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
                    if (e.this.gOt) {
                        e.this.eWT = editable.toString();
                        e.this.bCm();
                    }
                    e.this.gOg.kA(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != e.this.gOg.bCc() || e.this.gOg.bCc().getText() == null) {
                    if (view == e.this.gOg.bCd()) {
                        l.b(e.this.cNc.getPageContext().getPageActivity(), e.this.gOg.bCc());
                        com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.a.e.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.cNc.finish();
                            }
                        }, 200L);
                        return;
                    }
                    return;
                }
                e.this.eWT = e.this.gOg.bCc().getText().toString();
                if (StringUtils.isNull(e.this.eWT)) {
                    e.this.bBV();
                }
            }
        };
        this.gOg.a(onFocusChangeListener);
        this.gOg.a(onEditorActionListener);
        this.gOg.e(textWatcher);
        this.gOg.setOnClickListener(onClickListener);
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
                        TiebaStatic.eventStat(e.this.cNc.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                        TiebaStatic.log(new am("c12842").bJ("obj_name", str).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2").bJ("obj_type", "1").T("obj_locate", i + 1).bJ("obj_param1", e.this.eWT));
                    } else if (item instanceof ForumInfo) {
                        ForumInfo forumInfo = (ForumInfo) item;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.cNc.getPageContext().getPageActivity()).createNormalCfg(forumInfo.forum_name, FrsActivityConfig.FRS_CALL_SEARCH)));
                        TiebaStatic.log(new am("c13371").bJ("obj_type", forumInfo.has_concerned.intValue() > 0 ? "1" : "2").T(ImageViewerConfig.FORUM_ID, forumInfo.forum_id.intValue()).k("uid", TbadkApplication.getCurrentAccountId()));
                    }
                }
            }
        };
        AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.a.e.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.b(e.this.cNc.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        };
        this.gOg.c(onItemClickListener);
        this.gOg.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.gOg.onChangeSkinType(this.cNc.getPageContext(), i);
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
                if (ba.adA().b(e.this.cNc.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains("jump=open_full_screen_web_page")) {
                    return false;
                }
                ba.adA().a(e.this.cNc.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.gOg.a(cVar);
        this.gOg.a(fVar);
        this.gOg.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCk() {
        if (this.mHotSearchInfo == null) {
            this.cNc.showToast(this.cNc.getResources().getString(d.j.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.bBt() == 0 || this.mHotSearchInfo.bBt() == 2) {
            a(this.mHotSearchInfo.getName(), false, 1);
        } else if (this.mHotSearchInfo.bBt() == 1 && !com.baidu.tbadk.plugins.b.f(this.cNc.getPageContext())) {
            this.cNc.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.cNc.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new am("c10355").bJ("obj_name", this.mHotSearchInfo.getName()).T("obj_type", this.mHotSearchInfo.bBt() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.a.b
    public void a(final String str, boolean z, int i) {
        if (!j.kY()) {
            this.cNc.showToast(d.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.gOt = false;
                this.gOg.yq(str);
                this.gOt = true;
            }
            l.b(this.cNc.getPageContext().getPageActivity(), this.gOg.bCc());
            this.gOg.bCb();
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str + "&sub_type=" + i;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gOg.bCe().loadUrl(str2);
            aa.a(new z<Boolean>() { // from class: com.baidu.tieba.mainentrance.a.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.z
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.CG(str);
                    return true;
                }
            }, null);
            this.gOu.ym(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921345, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCl() {
        if (!this.gOg.bCg()) {
            bBH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBV() {
        this.gOu.bBV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCm() {
        if (!StringUtils.isNull(this.eWT)) {
            bBH();
        } else {
            bBV();
        }
    }

    private void bBH() {
        if (StringUtils.isNull(this.eWT)) {
            bBV();
            return;
        }
        SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
        searchListNetMessage.mKey = this.eWT.trim();
        searchListNetMessage.isForum = Integer.valueOf(this.gOs ? 1 : 0);
        this.cNc.sendMessage(searchListNetMessage);
    }

    public void b(HotSearchInfoData hotSearchInfoData) {
        this.mHotSearchInfo = hotSearchInfoData;
        bBC();
    }

    public BaseWebView bCn() {
        return this.gOg.bCe();
    }

    private void bBC() {
        if (this.mHotSearchInfo == null) {
            this.gOg.yp(this.cNc.getResources().getString(d.j.search_bar));
        } else {
            this.gOg.yp(this.mHotSearchInfo.aWg());
        }
    }

    public void dj(List<String> list) {
        this.gOg.k(list, this.eWT);
    }

    public void dk(List<ForumInfo> list) {
        this.gOg.l(list, this.eWT);
    }

    public void onDestroy() {
        if (this.gOg != null) {
            this.gOg.onDestroy();
        }
    }
}
