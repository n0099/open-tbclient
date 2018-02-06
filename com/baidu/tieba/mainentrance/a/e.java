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
    private BaseActivity bSO;
    private String dDb;
    private boolean fiI = true;
    private c fiJ;
    private d fiw;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;

    public e(BaseActivity baseActivity) {
        this.bSO = baseActivity;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.bSO).inflate(d.h.new_home_dialog_search, (ViewGroup) null);
            this.bSO.setContentView(this.mRootView);
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
                        this.mRootView = LayoutInflater.from(this.bSO).inflate(d.h.new_home_dialog_search, (ViewGroup) null);
                        this.bSO.setContentView(this.mRootView);
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        i2 = i + 1;
                    }
                }
                if (i == size) {
                    this.bSO.finish();
                    return;
                }
            } else {
                this.bSO.finish();
                return;
            }
        }
        if (this.mRootView == null) {
            this.bSO.finish();
            return;
        }
        this.fiw = new d(this.mRootView, this.bSO.getPageContext().getPageActivity());
        this.fiJ = new c(this.bSO, this, this.fiw);
        aSg();
        aSh();
        aSi();
        aRC();
        aSl();
        z.a(this.fiw.aSd(), this.bSO.getUniqueId());
        z.a(this.fiw.aSe(), this.bSO.getUniqueId());
    }

    public void aSg() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.a.e.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(e.this.bSO.getPageContext().getPageActivity(), view);
                } else {
                    e.this.aSk();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.a.e.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(e.this.dDb)) {
                        l.a(e.this.bSO.getPageContext().getPageActivity(), textView);
                        e.this.aSj();
                    } else {
                        e.this.M(e.this.dDb, false);
                        TiebaStatic.log(new ak("c12842").ab("obj_name", e.this.dDb).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").ab("obj_type", "1"));
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
                    if (e.this.fiI) {
                        e.this.dDb = editable.toString();
                        e.this.aSl();
                    }
                    e.this.fiw.iG(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.fiw.aSb()) {
                    e.this.aSk();
                } else if (view == e.this.fiw.aSc()) {
                    l.a(e.this.bSO.getPageContext().getPageActivity(), e.this.fiw.aSb());
                    com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.a.e.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.bSO.finish();
                        }
                    }, 200L);
                }
            }
        };
        this.fiw.a(onFocusChangeListener);
        this.fiw.a(onEditorActionListener);
        this.fiw.d(textWatcher);
        this.fiw.setOnClickListener(onClickListener);
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
                        e.this.M(str, true);
                        TiebaStatic.eventStat(e.this.bSO.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                        TiebaStatic.log(new ak("c12842").ab("obj_name", str).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2").ab("obj_type", "1").s("obj_locate", i + 1).ab("obj_param1", e.this.dDb));
                    }
                }
            }
        };
        AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.a.e.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.a(e.this.bSO.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        };
        this.fiw.c(onItemClickListener);
        this.fiw.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.fiw.onChangeSkinType(this.bSO.getPageContext(), i);
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
                if (aw.Du().b(e.this.bSO.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains("jump=open_full_screen_web_page")) {
                    return false;
                }
                aw.Du().a(e.this.bSO.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.fiw.a(cVar);
        this.fiw.a(fVar);
        this.fiw.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSj() {
        if (this.mHotSearchInfo == null) {
            this.bSO.showToast(this.bSO.getResources().getString(d.j.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.aRt() == 0) {
            M(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.aRt() == 1 && !com.baidu.tbadk.plugins.a.e(this.bSO.getPageContext())) {
            this.bSO.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.bSO.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "")));
        }
        TiebaStatic.log(new ak("c10355").ab("obj_name", this.mHotSearchInfo.getName()).s("obj_type", this.mHotSearchInfo.aRt() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.a.b
    public void M(final String str, boolean z) {
        if (!j.oJ()) {
            this.bSO.showToast(d.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.fiI = false;
                this.fiw.oL(str);
                this.fiI = true;
            }
            l.a(this.bSO.getPageContext().getPageActivity(), this.fiw.aSb());
            this.fiw.aSa();
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fiw.aSd().loadUrl(str2);
            v.a(new u<Boolean>() { // from class: com.baidu.tieba.mainentrance.a.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.u
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.sQ(str);
                    return true;
                }
            }, null);
            this.fiJ.oH(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSk() {
        if (StringUtils.isNull(this.dDb)) {
            aRU();
        } else if (!this.fiw.aSf()) {
            aRH();
        }
    }

    private void aRU() {
        this.fiJ.aRU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSl() {
        if (!StringUtils.isNull(this.dDb)) {
            aRH();
        } else {
            aRU();
        }
    }

    private void aRH() {
        if (!StringUtils.isNull(this.dDb)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.dDb.trim();
            this.bSO.sendMessage(searchListNetMessage);
        }
    }

    public void b(HotSearchInfoData hotSearchInfoData) {
        this.mHotSearchInfo = hotSearchInfoData;
        aRC();
    }

    public BaseWebView aSm() {
        return this.fiw.aSd();
    }

    private void aRC() {
        if (this.mHotSearchInfo == null) {
            this.fiw.oK(this.bSO.getResources().getString(d.j.search_bar));
        } else {
            this.fiw.oK(this.mHotSearchInfo.aqn());
        }
    }

    public void cA(List<String> list) {
        this.fiw.i(list, this.dDb);
    }

    public void onDestroy() {
        if (this.fiw != null) {
            this.fiw.onDestroy();
        }
    }
}
