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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
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
    private BaseActivity bkU;
    private String dge;
    private d ePD;
    private boolean ePN = true;
    private c ePO;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;

    public e(BaseActivity baseActivity) {
        this.bkU = baseActivity;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.bkU).inflate(d.i.new_home_dialog_search, (ViewGroup) null);
            this.bkU.setContentView(this.mRootView);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> aRK = a.aRK();
            if (aRK != null) {
                int size = aRK.size();
                int i2 = 0;
                Iterator<String> it = aRK.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    a.pC(it.next());
                    try {
                        this.mRootView = LayoutInflater.from(this.bkU).inflate(d.i.new_home_dialog_search, (ViewGroup) null);
                        this.bkU.setContentView(this.mRootView);
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        i2 = i + 1;
                    }
                }
                if (i == size) {
                    this.bkU.finish();
                    return;
                }
            } else {
                this.bkU.finish();
                return;
            }
        }
        if (this.mRootView == null) {
            this.bkU.finish();
            return;
        }
        this.ePD = new d(this.mRootView, this.bkU.getPageContext().getPageActivity());
        this.ePO = new c(this.bkU, this, this.ePD);
        aRY();
        aRZ();
        aSa();
        aRu();
        aSd();
        aa.a(this.ePD.aRV(), this.bkU.getUniqueId());
        aa.a(this.ePD.aRW(), this.bkU.getUniqueId());
    }

    public void aRY() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.a.e.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(e.this.bkU.getPageContext().getPageActivity(), view);
                } else {
                    e.this.aSc();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.a.e.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(e.this.dge)) {
                        l.b(e.this.bkU.getPageContext().getPageActivity(), textView);
                        e.this.aSb();
                    } else {
                        e.this.H(e.this.dge, false);
                        TiebaStatic.log(new am("c12842").ah("obj_name", e.this.dge).ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").ah("obj_type", "1"));
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
                    if (e.this.ePN) {
                        e.this.dge = editable.toString();
                        e.this.aSd();
                    }
                    e.this.ePD.gI(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != e.this.ePD.aRT() || e.this.ePD.aRT().getText() == null) {
                    if (view == e.this.ePD.aRU()) {
                        l.b(e.this.bkU.getPageContext().getPageActivity(), e.this.ePD.aRT());
                        com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.a.e.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.bkU.finish();
                            }
                        }, 200L);
                        return;
                    }
                    return;
                }
                e.this.dge = e.this.ePD.aRT().getText().toString();
                if (StringUtils.isNull(e.this.dge)) {
                    e.this.aRM();
                }
            }
        };
        this.ePD.a(onFocusChangeListener);
        this.ePD.a(onEditorActionListener);
        this.ePD.d(textWatcher);
        this.ePD.setOnClickListener(onClickListener);
    }

    private void aRZ() {
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.6
            /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ?? adapter = adapterView.getAdapter();
                if (adapter != 0 && i < adapter.getCount()) {
                    Object item = adapter.getItem(i);
                    if (item instanceof String) {
                        String str = (String) item;
                        e.this.H(str, true);
                        TiebaStatic.eventStat(e.this.bkU.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                        TiebaStatic.log(new am("c12842").ah("obj_name", str).ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2").ah("obj_type", "1").r("obj_locate", i + 1).ah("obj_param1", e.this.dge));
                    }
                }
            }
        };
        AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.a.e.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.b(e.this.bkU.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        };
        this.ePD.c(onItemClickListener);
        this.ePD.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.ePD.onChangeSkinType(this.bkU.getPageContext(), i);
    }

    private void aSa() {
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
                if (ay.zG().b(e.this.bkU.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains("jump=open_full_screen_web_page")) {
                    return false;
                }
                ay.zG().a(e.this.bkU.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.ePD.a(cVar);
        this.ePD.a(fVar);
        this.ePD.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSb() {
        if (this.mHotSearchInfo == null) {
            this.bkU.showToast(this.bkU.getResources().getString(d.k.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.aRl() == 0 || this.mHotSearchInfo.aRl() == 2) {
            H(this.mHotSearchInfo.getName(), false);
        } else if (this.mHotSearchInfo.aRl() == 1 && !com.baidu.tbadk.plugins.b.e(this.bkU.getPageContext())) {
            this.bkU.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.bkU.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new am("c10355").ah("obj_name", this.mHotSearchInfo.getName()).r("obj_type", this.mHotSearchInfo.aRl() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.a.b
    public void H(final String str, boolean z) {
        if (!j.jD()) {
            this.bkU.showToast(d.k.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.ePN = false;
                this.ePD.pH(str);
                this.ePN = true;
            }
            l.b(this.bkU.getPageContext().getPageActivity(), this.ePD.aRT());
            this.ePD.aRS();
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, IoUtils.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.ePD.aRV().loadUrl(str2);
            w.a(new v<Boolean>() { // from class: com.baidu.tieba.mainentrance.a.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.v
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.tU(str);
                    return true;
                }
            }, null);
            this.ePO.pD(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921345, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSc() {
        if (StringUtils.isNull(this.dge)) {
            aRM();
        } else if (!this.ePD.aRX()) {
            aRz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRM() {
        this.ePO.aRM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSd() {
        if (!StringUtils.isNull(this.dge)) {
            aRz();
        } else {
            aRM();
        }
    }

    private void aRz() {
        if (!StringUtils.isNull(this.dge)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.dge.trim();
            this.bkU.sendMessage(searchListNetMessage);
        }
    }

    public void b(HotSearchInfoData hotSearchInfoData) {
        this.mHotSearchInfo = hotSearchInfoData;
        aRu();
    }

    public BaseWebView aSe() {
        return this.ePD.aRV();
    }

    private void aRu() {
        if (this.mHotSearchInfo == null) {
            this.ePD.pG(this.bkU.getResources().getString(d.k.search_bar));
        } else {
            this.ePD.pG(this.mHotSearchInfo.aoC());
        }
    }

    public void cB(List<String> list) {
        this.ePD.j(list, this.dge);
    }

    public void onDestroy() {
        if (this.ePD != null) {
            this.ePD.onDestroy();
        }
    }
}
