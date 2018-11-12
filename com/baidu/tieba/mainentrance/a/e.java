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
    private BaseActivity bxI;
    private String dzU;
    private d fnF;
    private boolean fnQ = true;
    private c fnR;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;

    public e(BaseActivity baseActivity) {
        this.bxI = baseActivity;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.bxI).inflate(e.h.new_home_dialog_search, (ViewGroup) null);
            this.bxI.setContentView(this.mRootView);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> aYn = a.aYn();
            if (aYn != null) {
                int size = aYn.size();
                int i2 = 0;
                Iterator<String> it = aYn.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    a.qO(it.next());
                    try {
                        this.mRootView = LayoutInflater.from(this.bxI).inflate(e.h.new_home_dialog_search, (ViewGroup) null);
                        this.bxI.setContentView(this.mRootView);
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        i2 = i + 1;
                    }
                }
                if (i == size) {
                    this.bxI.finish();
                    return;
                }
            } else {
                this.bxI.finish();
                return;
            }
        }
        if (this.mRootView == null) {
            this.bxI.finish();
            return;
        }
        this.fnF = new d(this.mRootView, this.bxI.getPageContext().getPageActivity());
        this.fnR = new c(this.bxI, this, this.fnF);
        aYC();
        aYD();
        aYE();
        aXX();
        aYH();
        ab.a(this.fnF.aYz(), this.bxI.getUniqueId());
        ab.a(this.fnF.aYA(), this.bxI.getUniqueId());
    }

    public void onResume() {
        if (this.fnF != null) {
            this.fnF.onResume();
        }
    }

    public void aYC() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.a.e.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(e.this.bxI.getPageContext().getPageActivity(), view);
                } else {
                    e.this.aYG();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.a.e.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(e.this.dzU)) {
                        l.b(e.this.bxI.getPageContext().getPageActivity(), textView);
                        e.this.aYF();
                        return true;
                    }
                    e.this.a(e.this.dzU, false, 1);
                    TiebaStatic.log(new am("c12842").ax("obj_name", e.this.dzU).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").ax("obj_type", "1"));
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
                    if (e.this.fnQ) {
                        e.this.dzU = editable.toString();
                        e.this.aYH();
                    }
                    e.this.fnF.hU(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != e.this.fnF.aYx() || e.this.fnF.aYx().getText() == null) {
                    if (view == e.this.fnF.aYy()) {
                        l.b(e.this.bxI.getPageContext().getPageActivity(), e.this.fnF.aYx());
                        com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.a.e.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.bxI.finish();
                            }
                        }, 200L);
                        return;
                    }
                    return;
                }
                e.this.dzU = e.this.fnF.aYx().getText().toString();
                if (StringUtils.isNull(e.this.dzU)) {
                    e.this.aYq();
                }
            }
        };
        this.fnF.a(onFocusChangeListener);
        this.fnF.a(onEditorActionListener);
        this.fnF.d(textWatcher);
        this.fnF.setOnClickListener(onClickListener);
    }

    private void aYD() {
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
                        TiebaStatic.eventStat(e.this.bxI.getPageContext().getPageActivity(), "search_bar_result_click", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                        TiebaStatic.log(new am("c12842").ax("obj_name", str).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2").ax("obj_type", "1").x("obj_locate", i + 1).ax("obj_param1", e.this.dzU));
                    }
                }
            }
        };
        AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.a.e.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.b(e.this.bxI.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        };
        this.fnF.c(onItemClickListener);
        this.fnF.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.fnF.onChangeSkinType(this.bxI.getPageContext(), i);
    }

    private void aYE() {
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
                if (ay.Db().b(e.this.bxI.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains("jump=open_full_screen_web_page")) {
                    return false;
                }
                ay.Db().a(e.this.bxI.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.fnF.a(cVar);
        this.fnF.a(fVar);
        this.fnF.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYF() {
        if (this.mHotSearchInfo == null) {
            this.bxI.showToast(this.bxI.getResources().getString(e.j.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.aXO() == 0 || this.mHotSearchInfo.aXO() == 2) {
            a(this.mHotSearchInfo.getName(), false, 1);
        } else if (this.mHotSearchInfo.aXO() == 1 && !com.baidu.tbadk.plugins.b.e(this.bxI.getPageContext())) {
            this.bxI.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.bxI.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new am("c10355").ax("obj_name", this.mHotSearchInfo.getName()).x("obj_type", this.mHotSearchInfo.aXO() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.a.b
    public void a(final String str, boolean z, int i) {
        if (!j.kV()) {
            this.bxI.showToast(e.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.fnQ = false;
                this.fnF.qT(str);
                this.fnQ = true;
            }
            l.b(this.bxI.getPageContext().getPageActivity(), this.fnF.aYx());
            this.fnF.aYw();
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str + ETAG.ITEM_SEPARATOR + "sub_type" + ETAG.EQUAL + i;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, IoUtils.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fnF.aYz().loadUrl(str2);
            x.a(new w<Boolean>() { // from class: com.baidu.tieba.mainentrance.a.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.w
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.vk(str);
                    return true;
                }
            }, null);
            this.fnR.qP(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921345, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYG() {
        if (!this.fnF.aYB()) {
            aYc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYq() {
        this.fnR.aYq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYH() {
        if (!StringUtils.isNull(this.dzU)) {
            aYc();
        } else {
            aYq();
        }
    }

    private void aYc() {
        if (!StringUtils.isNull(this.dzU)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.dzU.trim();
            this.bxI.sendMessage(searchListNetMessage);
        }
    }

    public void b(HotSearchInfoData hotSearchInfoData) {
        this.mHotSearchInfo = hotSearchInfoData;
        aXX();
    }

    public BaseWebView aYI() {
        return this.fnF.aYz();
    }

    private void aXX() {
        if (this.mHotSearchInfo == null) {
            this.fnF.qS(this.bxI.getResources().getString(e.j.search_bar));
        } else {
            this.fnF.qS(this.mHotSearchInfo.atg());
        }
    }

    public void cT(List<String> list) {
        this.fnF.i(list, this.dzU);
    }

    public void onDestroy() {
        if (this.fnF != null) {
            this.fnF.onDestroy();
        }
    }
}
