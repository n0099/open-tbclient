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
    private BaseActivity cNa;
    private String eXh;
    private boolean gOF;
    private boolean gOG = true;
    private c gOH;
    private d gOt;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;

    public e(BaseActivity baseActivity, boolean z) {
        this.cNa = baseActivity;
        this.gOF = z;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.cNa).inflate(d.h.new_home_dialog_search, (ViewGroup) null);
            this.cNa.setContentView(this.mRootView);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> bBV = a.bBV();
            if (bBV != null) {
                int size = bBV.size();
                int i2 = 0;
                Iterator<String> it = bBV.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    a.ym(it.next());
                    try {
                        this.mRootView = LayoutInflater.from(this.cNa).inflate(d.h.new_home_dialog_search, (ViewGroup) null);
                        this.cNa.setContentView(this.mRootView);
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        i2 = i + 1;
                    }
                }
                if (i == size) {
                    this.cNa.finish();
                    return;
                }
            } else {
                this.cNa.finish();
                return;
            }
        }
        if (this.mRootView == null) {
            this.cNa.finish();
            return;
        }
        this.gOt = new d(this.mRootView, this.cNa.getPageContext().getPageActivity());
        this.gOH = new c(this.cNa, this, this.gOt);
        bCk();
        bCl();
        bCm();
        bBF();
        bCp();
        ae.a(this.gOt.bCh(), this.cNa.getUniqueId());
        ae.a(this.gOt.bCi(), this.cNa.getUniqueId());
    }

    public void onResume() {
        if (this.gOt != null) {
            this.gOt.onResume();
        }
    }

    public void bCk() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.a.e.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(e.this.cNa.getPageContext().getPageActivity(), view);
                } else {
                    e.this.bCo();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.a.e.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(e.this.eXh)) {
                        l.b(e.this.cNa.getPageContext().getPageActivity(), textView);
                        e.this.bCn();
                        return true;
                    }
                    e.this.a(e.this.eXh, false, 1);
                    TiebaStatic.log(new am("c12842").bJ("obj_name", e.this.eXh).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").bJ("obj_type", "1"));
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
                    if (e.this.gOG) {
                        e.this.eXh = editable.toString();
                        e.this.bCp();
                    }
                    e.this.gOt.kA(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != e.this.gOt.bCf() || e.this.gOt.bCf().getText() == null) {
                    if (view == e.this.gOt.bCg()) {
                        l.b(e.this.cNa.getPageContext().getPageActivity(), e.this.gOt.bCf());
                        com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.a.e.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.cNa.finish();
                            }
                        }, 200L);
                        return;
                    }
                    return;
                }
                e.this.eXh = e.this.gOt.bCf().getText().toString();
                if (StringUtils.isNull(e.this.eXh)) {
                    e.this.bBY();
                }
            }
        };
        this.gOt.a(onFocusChangeListener);
        this.gOt.a(onEditorActionListener);
        this.gOt.e(textWatcher);
        this.gOt.setOnClickListener(onClickListener);
    }

    private void bCl() {
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
                        TiebaStatic.eventStat(e.this.cNa.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                        TiebaStatic.log(new am("c12842").bJ("obj_name", str).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2").bJ("obj_type", "1").T("obj_locate", i + 1).bJ("obj_param1", e.this.eXh));
                    } else if (item instanceof ForumInfo) {
                        ForumInfo forumInfo = (ForumInfo) item;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.cNa.getPageContext().getPageActivity()).createNormalCfg(forumInfo.forum_name, FrsActivityConfig.FRS_CALL_SEARCH)));
                        TiebaStatic.log(new am("c13371").bJ("obj_type", forumInfo.has_concerned.intValue() > 0 ? "1" : "2").T(ImageViewerConfig.FORUM_ID, forumInfo.forum_id.intValue()).k("uid", TbadkApplication.getCurrentAccountId()));
                    }
                }
            }
        };
        AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.a.e.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.b(e.this.cNa.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        };
        this.gOt.c(onItemClickListener);
        this.gOt.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.gOt.onChangeSkinType(this.cNa.getPageContext(), i);
    }

    private void bCm() {
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
                if (ba.adD().b(e.this.cNa.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains("jump=open_full_screen_web_page")) {
                    return false;
                }
                ba.adD().a(e.this.cNa.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.gOt.a(cVar);
        this.gOt.a(fVar);
        this.gOt.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCn() {
        if (this.mHotSearchInfo == null) {
            this.cNa.showToast(this.cNa.getResources().getString(d.j.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.bBw() == 0 || this.mHotSearchInfo.bBw() == 2) {
            a(this.mHotSearchInfo.getName(), false, 1);
        } else if (this.mHotSearchInfo.bBw() == 1 && !com.baidu.tbadk.plugins.b.f(this.cNa.getPageContext())) {
            this.cNa.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.cNa.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new am("c10355").bJ("obj_name", this.mHotSearchInfo.getName()).T("obj_type", this.mHotSearchInfo.bBw() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.a.b
    public void a(final String str, boolean z, int i) {
        if (!j.kY()) {
            this.cNa.showToast(d.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.gOG = false;
                this.gOt.yr(str);
                this.gOG = true;
            }
            l.b(this.cNa.getPageContext().getPageActivity(), this.gOt.bCf());
            this.gOt.bCe();
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str + "&sub_type=" + i;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gOt.bCh().loadUrl(str2);
            aa.a(new z<Boolean>() { // from class: com.baidu.tieba.mainentrance.a.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.z
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.CH(str);
                    return true;
                }
            }, null);
            this.gOH.yn(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921345, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCo() {
        if (!this.gOt.bCj()) {
            bBK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBY() {
        this.gOH.bBY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCp() {
        if (!StringUtils.isNull(this.eXh)) {
            bBK();
        } else {
            bBY();
        }
    }

    private void bBK() {
        if (StringUtils.isNull(this.eXh)) {
            bBY();
            return;
        }
        SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
        searchListNetMessage.mKey = this.eXh.trim();
        searchListNetMessage.isForum = Integer.valueOf(this.gOF ? 1 : 0);
        this.cNa.sendMessage(searchListNetMessage);
    }

    public void b(HotSearchInfoData hotSearchInfoData) {
        this.mHotSearchInfo = hotSearchInfoData;
        bBF();
    }

    public BaseWebView bCq() {
        return this.gOt.bCh();
    }

    private void bBF() {
        if (this.mHotSearchInfo == null) {
            this.gOt.yq(this.cNa.getResources().getString(d.j.search_bar));
        } else {
            this.gOt.yq(this.mHotSearchInfo.aWi());
        }
    }

    public void dm(List<String> list) {
        this.gOt.k(list, this.eXh);
    }

    public void dn(List<ForumInfo> list) {
        this.gOt.l(list, this.eXh);
    }

    public void onDestroy() {
        if (this.gOt != null) {
            this.gOt.onDestroy();
        }
    }
}
