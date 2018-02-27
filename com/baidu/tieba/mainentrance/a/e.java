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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
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
    private BaseActivity bSC;
    private String dCP;
    private d fik;
    private boolean fiv = true;
    private c fiw;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;

    public e(BaseActivity baseActivity) {
        this.bSC = baseActivity;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.bSC).inflate(d.h.new_home_dialog_search, (ViewGroup) null);
            this.bSC.setContentView(this.mRootView);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> aRR = a.aRR();
            if (aRR != null) {
                int size = aRR.size();
                int i2 = 0;
                Iterator<String> it = aRR.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    a.oG(it.next());
                    try {
                        this.mRootView = LayoutInflater.from(this.bSC).inflate(d.h.new_home_dialog_search, (ViewGroup) null);
                        this.bSC.setContentView(this.mRootView);
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        i2 = i + 1;
                    }
                }
                if (i == size) {
                    this.bSC.finish();
                    return;
                }
            } else {
                this.bSC.finish();
                return;
            }
        }
        if (this.mRootView == null) {
            this.bSC.finish();
            return;
        }
        this.fik = new d(this.mRootView, this.bSC.getPageContext().getPageActivity());
        this.fiw = new c(this.bSC, this, this.fik);
        aSf();
        aSg();
        aSh();
        aRB();
        aSk();
        z.a(this.fik.aSc(), this.bSC.getUniqueId());
        z.a(this.fik.aSd(), this.bSC.getUniqueId());
    }

    public void aSf() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.a.e.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(e.this.bSC.getPageContext().getPageActivity(), view);
                } else {
                    e.this.aSj();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.a.e.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(e.this.dCP)) {
                        l.a(e.this.bSC.getPageContext().getPageActivity(), textView);
                        e.this.aSi();
                    } else {
                        e.this.L(e.this.dCP, false);
                        TiebaStatic.log(new ak("c12842").ab("obj_name", e.this.dCP).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").ab("obj_type", "1"));
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
                    if (e.this.fiv) {
                        e.this.dCP = editable.toString();
                        e.this.aSk();
                    }
                    e.this.fik.iG(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.fik.aSa()) {
                    e.this.aSj();
                } else if (view == e.this.fik.aSb()) {
                    l.a(e.this.bSC.getPageContext().getPageActivity(), e.this.fik.aSa());
                    com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.a.e.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.bSC.finish();
                        }
                    }, 200L);
                }
            }
        };
        this.fik.a(onFocusChangeListener);
        this.fik.a(onEditorActionListener);
        this.fik.d(textWatcher);
        this.fik.setOnClickListener(onClickListener);
    }

    private void aSg() {
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.6
            /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ?? adapter = adapterView.getAdapter();
                if (adapter != 0 && i < adapter.getCount()) {
                    Object item = adapter.getItem(i);
                    if (item instanceof String) {
                        String str = (String) item;
                        e.this.L(str, true);
                        TiebaStatic.eventStat(e.this.bSC.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                        TiebaStatic.log(new ak("c12842").ab("obj_name", str).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2").ab("obj_type", "1").s("obj_locate", i + 1).ab("obj_param1", e.this.dCP));
                    }
                }
            }
        };
        AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.a.e.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.a(e.this.bSC.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        };
        this.fik.c(onItemClickListener);
        this.fik.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.fik.onChangeSkinType(this.bSC.getPageContext(), i);
    }

    private void aSh() {
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
                if (aw.Dt().b(e.this.bSC.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains("jump=open_full_screen_web_page")) {
                    return false;
                }
                aw.Dt().a(e.this.bSC.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.fik.a(cVar);
        this.fik.a(fVar);
        this.fik.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSi() {
        if (this.mHotSearchInfo == null) {
            this.bSC.showToast(this.bSC.getResources().getString(d.j.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.aRs() == 0) {
            L(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.aRs() == 1 && !com.baidu.tbadk.plugins.a.e(this.bSC.getPageContext())) {
            this.bSC.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.bSC.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "")));
        }
        TiebaStatic.log(new ak("c10355").ab("obj_name", this.mHotSearchInfo.getName()).s("obj_type", this.mHotSearchInfo.aRs() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.a.b
    public void L(final String str, boolean z) {
        if (!j.oJ()) {
            this.bSC.showToast(d.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.fiv = false;
                this.fik.oL(str);
                this.fiv = true;
            }
            l.a(this.bSC.getPageContext().getPageActivity(), this.fik.aSa());
            this.fik.aRZ();
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fik.aSc().loadUrl(str2);
            v.a(new u<Boolean>() { // from class: com.baidu.tieba.mainentrance.a.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.u
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.sQ(str);
                    return true;
                }
            }, null);
            this.fiw.oH(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSj() {
        if (StringUtils.isNull(this.dCP)) {
            aRT();
        } else if (!this.fik.aSe()) {
            aRG();
        }
    }

    private void aRT() {
        this.fiw.aRT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSk() {
        if (!StringUtils.isNull(this.dCP)) {
            aRG();
        } else {
            aRT();
        }
    }

    private void aRG() {
        if (!StringUtils.isNull(this.dCP)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.dCP.trim();
            this.bSC.sendMessage(searchListNetMessage);
        }
    }

    public void b(HotSearchInfoData hotSearchInfoData) {
        this.mHotSearchInfo = hotSearchInfoData;
        aRB();
    }

    public BaseWebView aSl() {
        return this.fik.aSc();
    }

    private void aRB() {
        if (this.mHotSearchInfo == null) {
            this.fik.oK(this.bSC.getResources().getString(d.j.search_bar));
        } else {
            this.fik.oK(this.mHotSearchInfo.aqm());
        }
    }

    public void cA(List<String> list) {
        this.fik.i(list, this.dCP);
    }

    public void onDestroy() {
        if (this.fik != null) {
            this.fik.onDestroy();
        }
    }
}
