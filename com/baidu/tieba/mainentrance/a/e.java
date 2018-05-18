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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.d;
import com.baidu.tieba.mainentrance.HotSearchInfoData;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListNetMessage;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class e implements b {
    private BaseActivity bcK;
    private String cWR;
    private d eEj;
    private boolean eEu = true;
    private c eEv;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;

    public e(BaseActivity baseActivity) {
        this.bcK = baseActivity;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.bcK).inflate(d.i.new_home_dialog_search, (ViewGroup) null);
            this.bcK.setContentView(this.mRootView);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> aMN = a.aMN();
            if (aMN != null) {
                int size = aMN.size();
                int i2 = 0;
                Iterator<String> it = aMN.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    a.oO(it.next());
                    try {
                        this.mRootView = LayoutInflater.from(this.bcK).inflate(d.i.new_home_dialog_search, (ViewGroup) null);
                        this.bcK.setContentView(this.mRootView);
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        i2 = i + 1;
                    }
                }
                if (i == size) {
                    this.bcK.finish();
                    return;
                }
            } else {
                this.bcK.finish();
                return;
            }
        }
        if (this.mRootView == null) {
            this.bcK.finish();
            return;
        }
        this.eEj = new d(this.mRootView, this.bcK.getPageContext().getPageActivity());
        this.eEv = new c(this.bcK, this, this.eEj);
        aNb();
        aNc();
        aNd();
        aMx();
        aNg();
        z.a(this.eEj.aMY(), this.bcK.getUniqueId());
        z.a(this.eEj.aMZ(), this.bcK.getUniqueId());
    }

    public void aNb() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.a.e.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (!z) {
                    l.b(e.this.bcK.getPageContext().getPageActivity(), view2);
                } else {
                    e.this.aNf();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.a.e.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(e.this.cWR)) {
                        l.b(e.this.bcK.getPageContext().getPageActivity(), textView);
                        e.this.aNe();
                    } else {
                        e.this.H(e.this.cWR, false);
                        TiebaStatic.log(new al("c12842").ac("obj_name", e.this.cWR).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").ac("obj_type", "1"));
                    }
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
                    if (e.this.eEu) {
                        e.this.cWR = editable.toString();
                        e.this.aNg();
                    }
                    e.this.eEj.gC(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 == e.this.eEj.aMW()) {
                    e.this.aNf();
                } else if (view2 == e.this.eEj.aMX()) {
                    l.b(e.this.bcK.getPageContext().getPageActivity(), e.this.eEj.aMW());
                    com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.a.e.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.bcK.finish();
                        }
                    }, 200L);
                }
            }
        };
        this.eEj.a(onFocusChangeListener);
        this.eEj.a(onEditorActionListener);
        this.eEj.d(textWatcher);
        this.eEj.setOnClickListener(onClickListener);
    }

    private void aNc() {
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.6
            /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                ?? adapter = adapterView.getAdapter();
                if (adapter != 0 && i < adapter.getCount()) {
                    Object item = adapter.getItem(i);
                    if (item instanceof String) {
                        String str = (String) item;
                        e.this.H(str, true);
                        TiebaStatic.eventStat(e.this.bcK.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                        TiebaStatic.log(new al("c12842").ac("obj_name", str).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2").ac("obj_type", "1").r("obj_locate", i + 1).ac("obj_param1", e.this.cWR));
                    }
                }
            }
        };
        AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.a.e.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.b(e.this.bcK.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        };
        this.eEj.c(onItemClickListener);
        this.eEj.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.eEj.onChangeSkinType(this.bcK.getPageContext(), i);
    }

    private void aNd() {
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
                if (ax.wf().b(e.this.bcK.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains("jump=open_full_screen_web_page")) {
                    return false;
                }
                ax.wf().a(e.this.bcK.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.eEj.a(cVar);
        this.eEj.a(fVar);
        this.eEj.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNe() {
        if (this.mHotSearchInfo == null) {
            this.bcK.showToast(this.bcK.getResources().getString(d.k.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.aMo() == 0 || this.mHotSearchInfo.aMo() == 2) {
            H(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.aMo() == 1 && !com.baidu.tbadk.plugins.b.e(this.bcK.getPageContext())) {
            this.bcK.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.bcK.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "")));
        }
        TiebaStatic.log(new al("c10355").ac("obj_name", this.mHotSearchInfo.getName()).r("obj_type", this.mHotSearchInfo.aMo() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.a.b
    public void H(final String str, boolean z) {
        if (!j.gP()) {
            this.bcK.showToast(d.k.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.eEu = false;
                this.eEj.oT(str);
                this.eEu = true;
            }
            l.b(this.bcK.getPageContext().getPageActivity(), this.eEj.aMW());
            this.eEj.aMV();
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.eEj.aMY().loadUrl(str2);
            v.a(new u<Boolean>() { // from class: com.baidu.tieba.mainentrance.a.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.u
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.ta(str);
                    return true;
                }
            }, null);
            this.eEv.oP(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNf() {
        if (StringUtils.isNull(this.cWR)) {
            aMP();
        } else if (!this.eEj.aNa()) {
            aMC();
        }
    }

    private void aMP() {
        this.eEv.aMP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNg() {
        if (!StringUtils.isNull(this.cWR)) {
            aMC();
        } else {
            aMP();
        }
    }

    private void aMC() {
        if (!StringUtils.isNull(this.cWR)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.cWR.trim();
            this.bcK.sendMessage(searchListNetMessage);
        }
    }

    public void b(HotSearchInfoData hotSearchInfoData) {
        this.mHotSearchInfo = hotSearchInfoData;
        aMx();
    }

    public BaseWebView aNh() {
        return this.eEj.aMY();
    }

    private void aMx() {
        if (this.mHotSearchInfo == null) {
            this.eEj.oS(this.bcK.getResources().getString(d.k.search_bar));
        } else {
            this.eEj.oS(this.mHotSearchInfo.akw());
        }
    }

    public void cw(List<String> list) {
        this.eEj.j(list, this.cWR);
    }

    public void onDestroy() {
        if (this.eEj != null) {
            this.eEj.onDestroy();
        }
    }
}
