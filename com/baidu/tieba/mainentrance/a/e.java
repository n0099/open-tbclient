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
    private BaseActivity bSF;
    private String dCS;
    private d fiB;
    private boolean fiM = true;
    private c fiN;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;

    public e(BaseActivity baseActivity) {
        this.bSF = baseActivity;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.bSF).inflate(d.h.new_home_dialog_search, (ViewGroup) null);
            this.bSF.setContentView(this.mRootView);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> aRS = a.aRS();
            if (aRS != null) {
                int size = aRS.size();
                int i2 = 0;
                Iterator<String> it = aRS.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    a.oG(it.next());
                    try {
                        this.mRootView = LayoutInflater.from(this.bSF).inflate(d.h.new_home_dialog_search, (ViewGroup) null);
                        this.bSF.setContentView(this.mRootView);
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        i2 = i + 1;
                    }
                }
                if (i == size) {
                    this.bSF.finish();
                    return;
                }
            } else {
                this.bSF.finish();
                return;
            }
        }
        if (this.mRootView == null) {
            this.bSF.finish();
            return;
        }
        this.fiB = new d(this.mRootView, this.bSF.getPageContext().getPageActivity());
        this.fiN = new c(this.bSF, this, this.fiB);
        aSg();
        aSh();
        aSi();
        aRC();
        aSl();
        z.a(this.fiB.aSd(), this.bSF.getUniqueId());
        z.a(this.fiB.aSe(), this.bSF.getUniqueId());
    }

    public void aSg() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.a.e.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(e.this.bSF.getPageContext().getPageActivity(), view);
                } else {
                    e.this.aSk();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.a.e.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(e.this.dCS)) {
                        l.a(e.this.bSF.getPageContext().getPageActivity(), textView);
                        e.this.aSj();
                    } else {
                        e.this.L(e.this.dCS, false);
                        TiebaStatic.log(new ak("c12842").ab("obj_name", e.this.dCS).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").ab("obj_type", "1"));
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
                    if (e.this.fiM) {
                        e.this.dCS = editable.toString();
                        e.this.aSl();
                    }
                    e.this.fiB.iL(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.fiB.aSb()) {
                    e.this.aSk();
                } else if (view == e.this.fiB.aSc()) {
                    l.a(e.this.bSF.getPageContext().getPageActivity(), e.this.fiB.aSb());
                    com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.a.e.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.bSF.finish();
                        }
                    }, 200L);
                }
            }
        };
        this.fiB.a(onFocusChangeListener);
        this.fiB.a(onEditorActionListener);
        this.fiB.d(textWatcher);
        this.fiB.setOnClickListener(onClickListener);
    }

    private void aSh() {
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
                        TiebaStatic.eventStat(e.this.bSF.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                        TiebaStatic.log(new ak("c12842").ab("obj_name", str).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2").ab("obj_type", "1").s("obj_locate", i + 1).ab("obj_param1", e.this.dCS));
                    }
                }
            }
        };
        AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.a.e.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.a(e.this.bSF.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        };
        this.fiB.c(onItemClickListener);
        this.fiB.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.fiB.onChangeSkinType(this.bSF.getPageContext(), i);
    }

    private void aSi() {
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
                if (aw.Du().b(e.this.bSF.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains("jump=open_full_screen_web_page")) {
                    return false;
                }
                aw.Du().a(e.this.bSF.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.fiB.a(cVar);
        this.fiB.a(fVar);
        this.fiB.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSj() {
        if (this.mHotSearchInfo == null) {
            this.bSF.showToast(this.bSF.getResources().getString(d.j.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.aRt() == 0 || this.mHotSearchInfo.aRt() == 2) {
            L(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.aRt() == 1 && !com.baidu.tbadk.plugins.a.e(this.bSF.getPageContext())) {
            this.bSF.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.bSF.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "")));
        }
        TiebaStatic.log(new ak("c10355").ab("obj_name", this.mHotSearchInfo.getName()).s("obj_type", this.mHotSearchInfo.aRt() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.a.b
    public void L(final String str, boolean z) {
        if (!j.oJ()) {
            this.bSF.showToast(d.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.fiM = false;
                this.fiB.oL(str);
                this.fiM = true;
            }
            l.a(this.bSF.getPageContext().getPageActivity(), this.fiB.aSb());
            this.fiB.aSa();
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fiB.aSd().loadUrl(str2);
            v.a(new u<Boolean>() { // from class: com.baidu.tieba.mainentrance.a.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.u
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.sQ(str);
                    return true;
                }
            }, null);
            this.fiN.oH(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSk() {
        if (StringUtils.isNull(this.dCS)) {
            aRU();
        } else if (!this.fiB.aSf()) {
            aRH();
        }
    }

    private void aRU() {
        this.fiN.aRU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSl() {
        if (!StringUtils.isNull(this.dCS)) {
            aRH();
        } else {
            aRU();
        }
    }

    private void aRH() {
        if (!StringUtils.isNull(this.dCS)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.dCS.trim();
            this.bSF.sendMessage(searchListNetMessage);
        }
    }

    public void b(HotSearchInfoData hotSearchInfoData) {
        this.mHotSearchInfo = hotSearchInfoData;
        aRC();
    }

    public BaseWebView aSm() {
        return this.fiB.aSd();
    }

    private void aRC() {
        if (this.mHotSearchInfo == null) {
            this.fiB.oK(this.bSF.getResources().getString(d.j.search_bar));
        } else {
            this.fiB.oK(this.mHotSearchInfo.aqn());
        }
    }

    public void cA(List<String> list) {
        this.fiB.i(list, this.dCS);
    }

    public void onDestroy() {
        if (this.fiB != null) {
            this.fiB.onDestroy();
        }
    }
}
