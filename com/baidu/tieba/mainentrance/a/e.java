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
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.mainentrance.HotSearchInfoData;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListNetMessage;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class e implements b {
    private BaseActivity bmt;
    private String dhV;
    private boolean eTE = true;
    private c eTF;
    private d eTu;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;

    public e(BaseActivity baseActivity) {
        this.bmt = baseActivity;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.bmt).inflate(d.i.new_home_dialog_search, (ViewGroup) null);
            this.bmt.setContentView(this.mRootView);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> aSq = a.aSq();
            if (aSq != null) {
                int size = aSq.size();
                int i2 = 0;
                Iterator<String> it = aSq.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    a.pD(it.next());
                    try {
                        this.mRootView = LayoutInflater.from(this.bmt).inflate(d.i.new_home_dialog_search, (ViewGroup) null);
                        this.bmt.setContentView(this.mRootView);
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        i2 = i + 1;
                    }
                }
                if (i == size) {
                    this.bmt.finish();
                    return;
                }
            } else {
                this.bmt.finish();
                return;
            }
        }
        if (this.mRootView == null) {
            this.bmt.finish();
            return;
        }
        this.eTu = new d(this.mRootView, this.bmt.getPageContext().getPageActivity());
        this.eTF = new c(this.bmt, this, this.eTu);
        aSF();
        aSG();
        aSH();
        aSa();
        aSK();
        aa.a(this.eTu.aSC(), this.bmt.getUniqueId());
        aa.a(this.eTu.aSD(), this.bmt.getUniqueId());
    }

    public void aSF() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.a.e.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(e.this.bmt.getPageContext().getPageActivity(), view);
                } else {
                    e.this.aSJ();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.a.e.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(e.this.dhV)) {
                        l.b(e.this.bmt.getPageContext().getPageActivity(), textView);
                        e.this.aSI();
                        return true;
                    }
                    e.this.b(e.this.dhV, false, 1);
                    TiebaStatic.log(new an("c12842").ah("obj_name", e.this.dhV).ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").ah("obj_type", "1"));
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
                    if (e.this.eTE) {
                        e.this.dhV = editable.toString();
                        e.this.aSK();
                    }
                    e.this.eTu.gS(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != e.this.eTu.aSA() || e.this.eTu.aSA().getText() == null) {
                    if (view == e.this.eTu.aSB()) {
                        l.b(e.this.bmt.getPageContext().getPageActivity(), e.this.eTu.aSA());
                        com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.a.e.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.bmt.finish();
                            }
                        }, 200L);
                        return;
                    }
                    return;
                }
                e.this.dhV = e.this.eTu.aSA().getText().toString();
                if (StringUtils.isNull(e.this.dhV)) {
                    e.this.aSt();
                }
            }
        };
        this.eTu.a(onFocusChangeListener);
        this.eTu.a(onEditorActionListener);
        this.eTu.d(textWatcher);
        this.eTu.setOnClickListener(onClickListener);
    }

    private void aSG() {
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
                        TiebaStatic.eventStat(e.this.bmt.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                        TiebaStatic.log(new an("c12842").ah("obj_name", str).ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2").ah("obj_type", "1").r("obj_locate", i + 1).ah("obj_param1", e.this.dhV));
                    }
                }
            }
        };
        AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.a.e.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.b(e.this.bmt.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        };
        this.eTu.c(onItemClickListener);
        this.eTu.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.eTu.onChangeSkinType(this.bmt.getPageContext(), i);
    }

    private void aSH() {
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
                if (az.zV().b(e.this.bmt.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains("jump=open_full_screen_web_page")) {
                    return false;
                }
                az.zV().a(e.this.bmt.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.eTu.a(cVar);
        this.eTu.a(fVar);
        this.eTu.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSI() {
        if (this.mHotSearchInfo == null) {
            this.bmt.showToast(this.bmt.getResources().getString(d.k.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.aRR() == 0 || this.mHotSearchInfo.aRR() == 2) {
            b(this.mHotSearchInfo.getName(), false, 1);
        } else if (this.mHotSearchInfo.aRR() == 1 && !com.baidu.tbadk.plugins.b.e(this.bmt.getPageContext())) {
            this.bmt.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.bmt.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new an("c10355").ah("obj_name", this.mHotSearchInfo.getName()).r("obj_type", this.mHotSearchInfo.aRR() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.a.b
    public void b(final String str, boolean z, int i) {
        if (!j.jD()) {
            this.bmt.showToast(d.k.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.eTE = false;
                this.eTu.pI(str);
                this.eTE = true;
            }
            l.b(this.bmt.getPageContext().getPageActivity(), this.eTu.aSA());
            this.eTu.aSz();
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str + "&sub_type=" + i;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, IoUtils.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.eTu.aSC().loadUrl(str2);
            w.a(new v<Boolean>() { // from class: com.baidu.tieba.mainentrance.a.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.v
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.tU(str);
                    return true;
                }
            }, null);
            this.eTF.pE(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921345, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSJ() {
        if (StringUtils.isNull(this.dhV)) {
            aSt();
        } else if (!this.eTu.aSE()) {
            aSf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSt() {
        this.eTF.aSt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSK() {
        if (!StringUtils.isNull(this.dhV)) {
            aSf();
        } else {
            aSt();
        }
    }

    private void aSf() {
        if (!StringUtils.isNull(this.dhV)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.dhV.trim();
            this.bmt.sendMessage(searchListNetMessage);
        }
    }

    public void b(HotSearchInfoData hotSearchInfoData) {
        this.mHotSearchInfo = hotSearchInfoData;
        aSa();
    }

    public BaseWebView aSL() {
        return this.eTu.aSC();
    }

    private void aSa() {
        if (this.mHotSearchInfo == null) {
            this.eTu.pH(this.bmt.getResources().getString(d.k.search_bar));
        } else {
            this.eTu.pH(this.mHotSearchInfo.anW());
        }
    }

    public void cF(List<String> list) {
        this.eTu.j(list, this.dhV);
    }

    public void onDestroy() {
        if (this.eTu != null) {
            this.eTu.onDestroy();
        }
    }
}
