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
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.e;
import com.baidu.tieba.mainentrance.HotSearchInfoData;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListNetMessage;
import com.baidu.webkit.internal.ETAG;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class e implements b {
    private BaseActivity bBf;
    private String dGt;
    private boolean fuI = true;
    private c fuJ;
    private d fux;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;

    public e(BaseActivity baseActivity) {
        this.bBf = baseActivity;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.bBf).inflate(e.h.new_home_dialog_search, (ViewGroup) null);
            this.bBf.setContentView(this.mRootView);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> baf = a.baf();
            if (baf != null) {
                int size = baf.size();
                int i2 = 0;
                Iterator<String> it = baf.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    a.rq(it.next());
                    try {
                        this.mRootView = LayoutInflater.from(this.bBf).inflate(e.h.new_home_dialog_search, (ViewGroup) null);
                        this.bBf.setContentView(this.mRootView);
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        i2 = i + 1;
                    }
                }
                if (i == size) {
                    this.bBf.finish();
                    return;
                }
            } else {
                this.bBf.finish();
                return;
            }
        }
        if (this.mRootView == null) {
            this.bBf.finish();
            return;
        }
        this.fux = new d(this.mRootView, this.bBf.getPageContext().getPageActivity());
        this.fuJ = new c(this.bBf, this, this.fux);
        bau();
        bav();
        baw();
        aZP();
        baz();
        ab.a(this.fux.bar(), this.bBf.getUniqueId());
        ab.a(this.fux.bas(), this.bBf.getUniqueId());
    }

    public void onResume() {
        if (this.fux != null) {
            this.fux.onResume();
        }
    }

    public void bau() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.a.e.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(e.this.bBf.getPageContext().getPageActivity(), view);
                } else {
                    e.this.bay();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.a.e.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(e.this.dGt)) {
                        l.b(e.this.bBf.getPageContext().getPageActivity(), textView);
                        e.this.bax();
                        return true;
                    }
                    e.this.a(e.this.dGt, false, 1);
                    TiebaStatic.log(new am("c12842").aA("obj_name", e.this.dGt).aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").aA("obj_type", "1"));
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
                    if (e.this.fuI) {
                        e.this.dGt = editable.toString();
                        e.this.baz();
                    }
                    e.this.fux.hX(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != e.this.fux.bap() || e.this.fux.bap().getText() == null) {
                    if (view == e.this.fux.baq()) {
                        l.b(e.this.bBf.getPageContext().getPageActivity(), e.this.fux.bap());
                        com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.a.e.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.bBf.finish();
                            }
                        }, 200L);
                        return;
                    }
                    return;
                }
                e.this.dGt = e.this.fux.bap().getText().toString();
                if (StringUtils.isNull(e.this.dGt)) {
                    e.this.bai();
                }
            }
        };
        this.fux.a(onFocusChangeListener);
        this.fux.a(onEditorActionListener);
        this.fux.d(textWatcher);
        this.fux.setOnClickListener(onClickListener);
    }

    private void bav() {
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
                        TiebaStatic.eventStat(e.this.bBf.getPageContext().getPageActivity(), "search_bar_result_click", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                        TiebaStatic.log(new am("c12842").aA("obj_name", str).aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2").aA("obj_type", "1").x("obj_locate", i + 1).aA("obj_param1", e.this.dGt));
                    }
                }
            }
        };
        AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.a.e.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.b(e.this.bBf.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        };
        this.fux.c(onItemClickListener);
        this.fux.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.fux.onChangeSkinType(this.bBf.getPageContext(), i);
    }

    private void baw() {
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
                if (ay.Ef().b(e.this.bBf.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains("jump=open_full_screen_web_page")) {
                    return false;
                }
                ay.Ef().a(e.this.bBf.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.fux.a(cVar);
        this.fux.a(fVar);
        this.fux.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bax() {
        if (this.mHotSearchInfo == null) {
            this.bBf.showToast(this.bBf.getResources().getString(e.j.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.aZG() == 0 || this.mHotSearchInfo.aZG() == 2) {
            a(this.mHotSearchInfo.getName(), false, 1);
        } else if (this.mHotSearchInfo.aZG() == 1 && !com.baidu.tbadk.plugins.b.e(this.bBf.getPageContext())) {
            this.bBf.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.bBf.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new am("c10355").aA("obj_name", this.mHotSearchInfo.getName()).x("obj_type", this.mHotSearchInfo.aZG() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.a.b
    public void a(final String str, boolean z, int i) {
        if (!j.kV()) {
            this.bBf.showToast(e.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.fuI = false;
                this.fux.rv(str);
                this.fuI = true;
            }
            l.b(this.bBf.getPageContext().getPageActivity(), this.fux.bap());
            this.fux.bao();
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str + ETAG.ITEM_SEPARATOR + "sub_type" + ETAG.EQUAL + i;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, IoUtils.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fux.bar().loadUrl(str2);
            x.a(new w<Boolean>() { // from class: com.baidu.tieba.mainentrance.a.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.w
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.vL(str);
                    return true;
                }
            }, null);
            this.fuJ.rr(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921345, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bay() {
        if (!this.fux.bat()) {
            aZU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bai() {
        this.fuJ.bai();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baz() {
        if (!StringUtils.isNull(this.dGt)) {
            aZU();
        } else {
            bai();
        }
    }

    private void aZU() {
        if (!StringUtils.isNull(this.dGt)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.dGt.trim();
            this.bBf.sendMessage(searchListNetMessage);
        }
    }

    public void b(HotSearchInfoData hotSearchInfoData) {
        this.mHotSearchInfo = hotSearchInfoData;
        aZP();
    }

    public BaseWebView baA() {
        return this.fux.bar();
    }

    private void aZP() {
        if (this.mHotSearchInfo == null) {
            this.fux.ru(this.bBf.getResources().getString(e.j.search_bar));
        } else {
            this.fux.ru(this.mHotSearchInfo.auS());
        }
    }

    public void cX(List<String> list) {
        this.fux.j(list, this.dGt);
    }

    public void onDestroy() {
        if (this.fux != null) {
            this.fux.onDestroy();
        }
    }
}
