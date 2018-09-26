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
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.e;
import com.baidu.tieba.mainentrance.HotSearchInfoData;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListNetMessage;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class e implements b {
    private BaseActivity bsQ;
    private String dqC;
    private d feE;
    private boolean feP = true;
    private c feQ;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;

    public e(BaseActivity baseActivity) {
        this.bsQ = baseActivity;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.bsQ).inflate(e.h.new_home_dialog_search, (ViewGroup) null);
            this.bsQ.setContentView(this.mRootView);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> aVD = a.aVD();
            if (aVD != null) {
                int size = aVD.size();
                int i2 = 0;
                Iterator<String> it = aVD.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    a.ql(it.next());
                    try {
                        this.mRootView = LayoutInflater.from(this.bsQ).inflate(e.h.new_home_dialog_search, (ViewGroup) null);
                        this.bsQ.setContentView(this.mRootView);
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        i2 = i + 1;
                    }
                }
                if (i == size) {
                    this.bsQ.finish();
                    return;
                }
            } else {
                this.bsQ.finish();
                return;
            }
        }
        if (this.mRootView == null) {
            this.bsQ.finish();
            return;
        }
        this.feE = new d(this.mRootView, this.bsQ.getPageContext().getPageActivity());
        this.feQ = new c(this.bsQ, this, this.feE);
        aVS();
        aVT();
        aVU();
        aVn();
        aVX();
        ab.a(this.feE.aVP(), this.bsQ.getUniqueId());
        ab.a(this.feE.aVQ(), this.bsQ.getUniqueId());
    }

    public void onResume() {
        if (this.feE != null) {
            this.feE.onResume();
        }
    }

    public void aVS() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.a.e.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(e.this.bsQ.getPageContext().getPageActivity(), view);
                } else {
                    e.this.aVW();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.a.e.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(e.this.dqC)) {
                        l.a(e.this.bsQ.getPageContext().getPageActivity(), textView);
                        e.this.aVV();
                        return true;
                    }
                    e.this.a(e.this.dqC, false, 1);
                    TiebaStatic.log(new am("c12842").al("obj_name", e.this.dqC).al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").al("obj_type", "1"));
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
                    if (e.this.feP) {
                        e.this.dqC = editable.toString();
                        e.this.aVX();
                    }
                    e.this.feE.ht(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != e.this.feE.aVN() || e.this.feE.aVN().getText() == null) {
                    if (view == e.this.feE.aVO()) {
                        l.a(e.this.bsQ.getPageContext().getPageActivity(), e.this.feE.aVN());
                        com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.a.e.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.bsQ.finish();
                            }
                        }, 200L);
                        return;
                    }
                    return;
                }
                e.this.dqC = e.this.feE.aVN().getText().toString();
                if (StringUtils.isNull(e.this.dqC)) {
                    e.this.aVG();
                }
            }
        };
        this.feE.a(onFocusChangeListener);
        this.feE.a(onEditorActionListener);
        this.feE.d(textWatcher);
        this.feE.setOnClickListener(onClickListener);
    }

    private void aVT() {
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
                        TiebaStatic.eventStat(e.this.bsQ.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                        TiebaStatic.log(new am("c12842").al("obj_name", str).al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2").al("obj_type", "1").w("obj_locate", i + 1).al("obj_param1", e.this.dqC));
                    }
                }
            }
        };
        AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.a.e.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.a(e.this.bsQ.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        };
        this.feE.c(onItemClickListener);
        this.feE.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.feE.onChangeSkinType(this.bsQ.getPageContext(), i);
    }

    private void aVU() {
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
                if (ay.AN().b(e.this.bsQ.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains("jump=open_full_screen_web_page")) {
                    return false;
                }
                ay.AN().a(e.this.bsQ.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.feE.a(cVar);
        this.feE.a(fVar);
        this.feE.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVV() {
        if (this.mHotSearchInfo == null) {
            this.bsQ.showToast(this.bsQ.getResources().getString(e.j.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.aVe() == 0 || this.mHotSearchInfo.aVe() == 2) {
            a(this.mHotSearchInfo.getName(), false, 1);
        } else if (this.mHotSearchInfo.aVe() == 1 && !com.baidu.tbadk.plugins.b.e(this.bsQ.getPageContext())) {
            this.bsQ.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.bsQ.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new am("c10355").al("obj_name", this.mHotSearchInfo.getName()).w("obj_type", this.mHotSearchInfo.aVe() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.a.b
    public void a(final String str, boolean z, int i) {
        if (!j.kK()) {
            this.bsQ.showToast(e.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.feP = false;
                this.feE.qq(str);
                this.feP = true;
            }
            l.a(this.bsQ.getPageContext().getPageActivity(), this.feE.aVN());
            this.feE.aVM();
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str + "&sub_type=" + i;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, IoUtils.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.feE.aVP().loadUrl(str2);
            x.a(new w<Boolean>() { // from class: com.baidu.tieba.mainentrance.a.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.w
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.uD(str);
                    return true;
                }
            }, null);
            this.feQ.qm(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921345, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVW() {
        if (!this.feE.aVR()) {
            aVs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVG() {
        this.feQ.aVG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVX() {
        if (!StringUtils.isNull(this.dqC)) {
            aVs();
        } else {
            aVG();
        }
    }

    private void aVs() {
        if (!StringUtils.isNull(this.dqC)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.dqC.trim();
            this.bsQ.sendMessage(searchListNetMessage);
        }
    }

    public void b(HotSearchInfoData hotSearchInfoData) {
        this.mHotSearchInfo = hotSearchInfoData;
        aVn();
    }

    public BaseWebView aVY() {
        return this.feE.aVP();
    }

    private void aVn() {
        if (this.mHotSearchInfo == null) {
            this.feE.qp(this.bsQ.getResources().getString(e.j.search_bar));
        } else {
            this.feE.qp(this.mHotSearchInfo.aqk());
        }
    }

    public void cG(List<String> list) {
        this.feE.j(list, this.dqC);
    }

    public void onDestroy() {
        if (this.feE != null) {
            this.feE.onDestroy();
        }
    }
}
