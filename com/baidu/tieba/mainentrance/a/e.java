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
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.util.y;
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
    private BaseActivity bBV;
    private String dJQ;
    private d fyj;
    private boolean fyu = true;
    private c fyv;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;

    public e(BaseActivity baseActivity) {
        this.bBV = baseActivity;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.bBV).inflate(e.h.new_home_dialog_search, (ViewGroup) null);
            this.bBV.setContentView(this.mRootView);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> bbs = a.bbs();
            if (bbs != null) {
                int size = bbs.size();
                int i2 = 0;
                Iterator<String> it = bbs.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    a.rJ(it.next());
                    try {
                        this.mRootView = LayoutInflater.from(this.bBV).inflate(e.h.new_home_dialog_search, (ViewGroup) null);
                        this.bBV.setContentView(this.mRootView);
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        i2 = i + 1;
                    }
                }
                if (i == size) {
                    this.bBV.finish();
                    return;
                }
            } else {
                this.bBV.finish();
                return;
            }
        }
        if (this.mRootView == null) {
            this.bBV.finish();
            return;
        }
        this.fyj = new d(this.mRootView, this.bBV.getPageContext().getPageActivity());
        this.fyv = new c(this.bBV, this, this.fyj);
        bbH();
        bbI();
        bbJ();
        bbc();
        bbM();
        ac.a(this.fyj.bbE(), this.bBV.getUniqueId());
        ac.a(this.fyj.bbF(), this.bBV.getUniqueId());
    }

    public void onResume() {
        if (this.fyj != null) {
            this.fyj.onResume();
        }
    }

    public void bbH() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.a.e.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(e.this.bBV.getPageContext().getPageActivity(), view);
                } else {
                    e.this.bbL();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.a.e.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(e.this.dJQ)) {
                        l.b(e.this.bBV.getPageContext().getPageActivity(), textView);
                        e.this.bbK();
                        return true;
                    }
                    e.this.a(e.this.dJQ, false, 1);
                    TiebaStatic.log(new am("c12842").aB("obj_name", e.this.dJQ).aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").aB("obj_type", "1"));
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
                    if (e.this.fyu) {
                        e.this.dJQ = editable.toString();
                        e.this.bbM();
                    }
                    e.this.fyj.ia(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != e.this.fyj.bbC() || e.this.fyj.bbC().getText() == null) {
                    if (view == e.this.fyj.bbD()) {
                        l.b(e.this.bBV.getPageContext().getPageActivity(), e.this.fyj.bbC());
                        com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.a.e.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.bBV.finish();
                            }
                        }, 200L);
                        return;
                    }
                    return;
                }
                e.this.dJQ = e.this.fyj.bbC().getText().toString();
                if (StringUtils.isNull(e.this.dJQ)) {
                    e.this.bbv();
                }
            }
        };
        this.fyj.a(onFocusChangeListener);
        this.fyj.a(onEditorActionListener);
        this.fyj.d(textWatcher);
        this.fyj.setOnClickListener(onClickListener);
    }

    private void bbI() {
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
                        TiebaStatic.eventStat(e.this.bBV.getPageContext().getPageActivity(), "search_bar_result_click", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                        TiebaStatic.log(new am("c12842").aB("obj_name", str).aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2").aB("obj_type", "1").y("obj_locate", i + 1).aB("obj_param1", e.this.dJQ));
                    }
                }
            }
        };
        AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.a.e.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.b(e.this.bBV.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        };
        this.fyj.c(onItemClickListener);
        this.fyj.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.fyj.onChangeSkinType(this.bBV.getPageContext(), i);
    }

    private void bbJ() {
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
                if (ay.Es().b(e.this.bBV.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains("jump=open_full_screen_web_page")) {
                    return false;
                }
                ay.Es().a(e.this.bBV.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.fyj.a(cVar);
        this.fyj.a(fVar);
        this.fyj.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbK() {
        if (this.mHotSearchInfo == null) {
            this.bBV.showToast(this.bBV.getResources().getString(e.j.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.baT() == 0 || this.mHotSearchInfo.baT() == 2) {
            a(this.mHotSearchInfo.getName(), false, 1);
        } else if (this.mHotSearchInfo.baT() == 1 && !com.baidu.tbadk.plugins.b.e(this.bBV.getPageContext())) {
            this.bBV.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.bBV.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new am("c10355").aB("obj_name", this.mHotSearchInfo.getName()).y("obj_type", this.mHotSearchInfo.baT() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.a.b
    public void a(final String str, boolean z, int i) {
        if (!j.kV()) {
            this.bBV.showToast(e.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.fyu = false;
                this.fyj.rO(str);
                this.fyu = true;
            }
            l.b(this.bBV.getPageContext().getPageActivity(), this.fyj.bbC());
            this.fyj.bbB();
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str + ETAG.ITEM_SEPARATOR + "sub_type" + ETAG.EQUAL + i;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, IoUtils.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fyj.bbE().loadUrl(str2);
            y.a(new x<Boolean>() { // from class: com.baidu.tieba.mainentrance.a.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.x
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.we(str);
                    return true;
                }
            }, null);
            this.fyv.rK(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921345, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbL() {
        if (!this.fyj.bbG()) {
            bbh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbv() {
        this.fyv.bbv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbM() {
        if (!StringUtils.isNull(this.dJQ)) {
            bbh();
        } else {
            bbv();
        }
    }

    private void bbh() {
        if (!StringUtils.isNull(this.dJQ)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.dJQ.trim();
            this.bBV.sendMessage(searchListNetMessage);
        }
    }

    public void b(HotSearchInfoData hotSearchInfoData) {
        this.mHotSearchInfo = hotSearchInfoData;
        bbc();
    }

    public BaseWebView bbN() {
        return this.fyj.bbE();
    }

    private void bbc() {
        if (this.mHotSearchInfo == null) {
            this.fyj.rN(this.bBV.getResources().getString(e.j.search_bar));
        } else {
            this.fyj.rN(this.mHotSearchInfo.awf());
        }
    }

    public void cZ(List<String> list) {
        this.fyj.j(list, this.dJQ);
    }

    public void onDestroy() {
        if (this.fyj != null) {
            this.fyj.onDestroy();
        }
    }
}
