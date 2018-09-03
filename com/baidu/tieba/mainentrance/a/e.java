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
import com.baidu.ar.util.IoUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.f;
import com.baidu.tieba.mainentrance.HotSearchInfoData;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListNetMessage;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class e implements b {
    private BaseActivity bnc;
    private String dkJ;
    private d eXj;
    private boolean eXt = true;
    private c eXu;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;

    public e(BaseActivity baseActivity) {
        this.bnc = baseActivity;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.bnc).inflate(f.h.new_home_dialog_search, (ViewGroup) null);
            this.bnc.setContentView(this.mRootView);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> aTp = a.aTp();
            if (aTp != null) {
                int size = aTp.size();
                int i2 = 0;
                Iterator<String> it = aTp.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    a.pG(it.next());
                    try {
                        this.mRootView = LayoutInflater.from(this.bnc).inflate(f.h.new_home_dialog_search, (ViewGroup) null);
                        this.bnc.setContentView(this.mRootView);
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        i2 = i + 1;
                    }
                }
                if (i == size) {
                    this.bnc.finish();
                    return;
                }
            } else {
                this.bnc.finish();
                return;
            }
        }
        if (this.mRootView == null) {
            this.bnc.finish();
            return;
        }
        this.eXj = new d(this.mRootView, this.bnc.getPageContext().getPageActivity());
        this.eXu = new c(this.bnc, this, this.eXj);
        aTE();
        aTF();
        aTG();
        aSZ();
        aTJ();
        z.a(this.eXj.aTB(), this.bnc.getUniqueId());
        z.a(this.eXj.aTC(), this.bnc.getUniqueId());
    }

    public void aTE() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.a.e.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(e.this.bnc.getPageContext().getPageActivity(), view);
                } else {
                    e.this.aTI();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.a.e.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(e.this.dkJ)) {
                        l.a(e.this.bnc.getPageContext().getPageActivity(), textView);
                        e.this.aTH();
                        return true;
                    }
                    e.this.a(e.this.dkJ, false, 1);
                    TiebaStatic.log(new an("c12842").ae("obj_name", e.this.dkJ).ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").ae("obj_type", "1"));
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
                    if (e.this.eXt) {
                        e.this.dkJ = editable.toString();
                        e.this.aTJ();
                    }
                    e.this.eXj.gV(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != e.this.eXj.aTz() || e.this.eXj.aTz().getText() == null) {
                    if (view == e.this.eXj.aTA()) {
                        l.a(e.this.bnc.getPageContext().getPageActivity(), e.this.eXj.aTz());
                        com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.a.e.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.bnc.finish();
                            }
                        }, 200L);
                        return;
                    }
                    return;
                }
                e.this.dkJ = e.this.eXj.aTz().getText().toString();
                if (StringUtils.isNull(e.this.dkJ)) {
                    e.this.aTs();
                }
            }
        };
        this.eXj.a(onFocusChangeListener);
        this.eXj.a(onEditorActionListener);
        this.eXj.d(textWatcher);
        this.eXj.setOnClickListener(onClickListener);
    }

    private void aTF() {
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
                        TiebaStatic.eventStat(e.this.bnc.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                        TiebaStatic.log(new an("c12842").ae("obj_name", str).ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2").ae("obj_type", "1").r("obj_locate", i + 1).ae("obj_param1", e.this.dkJ));
                    }
                }
            }
        };
        AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.a.e.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.a(e.this.bnc.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        };
        this.eXj.c(onItemClickListener);
        this.eXj.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.eXj.onChangeSkinType(this.bnc.getPageContext(), i);
    }

    private void aTG() {
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
                if (az.zI().b(e.this.bnc.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains("jump=open_full_screen_web_page")) {
                    return false;
                }
                az.zI().a(e.this.bnc.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.eXj.a(cVar);
        this.eXj.a(fVar);
        this.eXj.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTH() {
        if (this.mHotSearchInfo == null) {
            this.bnc.showToast(this.bnc.getResources().getString(f.j.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.aSQ() == 0 || this.mHotSearchInfo.aSQ() == 2) {
            a(this.mHotSearchInfo.getName(), false, 1);
        } else if (this.mHotSearchInfo.aSQ() == 1 && !com.baidu.tbadk.plugins.b.e(this.bnc.getPageContext())) {
            this.bnc.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.bnc.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new an("c10355").ae("obj_name", this.mHotSearchInfo.getName()).r("obj_type", this.mHotSearchInfo.aSQ() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.a.b
    public void a(final String str, boolean z, int i) {
        if (!j.jE()) {
            this.bnc.showToast(f.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.eXt = false;
                this.eXj.pL(str);
                this.eXt = true;
            }
            l.a(this.bnc.getPageContext().getPageActivity(), this.eXj.aTz());
            this.eXj.aTy();
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str + "&sub_type=" + i;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, IoUtils.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.eXj.aTB().loadUrl(str2);
            v.a(new u<Boolean>() { // from class: com.baidu.tieba.mainentrance.a.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.u
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.tW(str);
                    return true;
                }
            }, null);
            this.eXu.pH(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921345, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTI() {
        if (!this.eXj.aTD()) {
            aTe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTs() {
        this.eXu.aTs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTJ() {
        if (!StringUtils.isNull(this.dkJ)) {
            aTe();
        } else {
            aTs();
        }
    }

    private void aTe() {
        if (!StringUtils.isNull(this.dkJ)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.dkJ.trim();
            this.bnc.sendMessage(searchListNetMessage);
        }
    }

    public void b(HotSearchInfoData hotSearchInfoData) {
        this.mHotSearchInfo = hotSearchInfoData;
        aSZ();
    }

    public BaseWebView aTK() {
        return this.eXj.aTB();
    }

    private void aSZ() {
        if (this.mHotSearchInfo == null) {
            this.eXj.pK(this.bnc.getResources().getString(f.j.search_bar));
        } else {
            this.eXj.pK(this.mHotSearchInfo.aov());
        }
    }

    public void cF(List<String> list) {
        this.eXj.j(list, this.dkJ);
    }

    public void onDestroy() {
        if (this.eXj != null) {
            this.eXj.onDestroy();
        }
    }
}
