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
    private BaseActivity bwX;
    private String dyD;
    private d fmn;
    private boolean fmy = true;
    private c fmz;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;

    public e(BaseActivity baseActivity) {
        this.bwX = baseActivity;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.bwX).inflate(e.h.new_home_dialog_search, (ViewGroup) null);
            this.bwX.setContentView(this.mRootView);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> aYQ = a.aYQ();
            if (aYQ != null) {
                int size = aYQ.size();
                int i2 = 0;
                Iterator<String> it = aYQ.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    a.qN(it.next());
                    try {
                        this.mRootView = LayoutInflater.from(this.bwX).inflate(e.h.new_home_dialog_search, (ViewGroup) null);
                        this.bwX.setContentView(this.mRootView);
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        i2 = i + 1;
                    }
                }
                if (i == size) {
                    this.bwX.finish();
                    return;
                }
            } else {
                this.bwX.finish();
                return;
            }
        }
        if (this.mRootView == null) {
            this.bwX.finish();
            return;
        }
        this.fmn = new d(this.mRootView, this.bwX.getPageContext().getPageActivity());
        this.fmz = new c(this.bwX, this, this.fmn);
        aZf();
        aZg();
        aZh();
        aYA();
        aZk();
        ab.a(this.fmn.aZc(), this.bwX.getUniqueId());
        ab.a(this.fmn.aZd(), this.bwX.getUniqueId());
    }

    public void onResume() {
        if (this.fmn != null) {
            this.fmn.onResume();
        }
    }

    public void aZf() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.a.e.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(e.this.bwX.getPageContext().getPageActivity(), view);
                } else {
                    e.this.aZj();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.a.e.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(e.this.dyD)) {
                        l.a(e.this.bwX.getPageContext().getPageActivity(), textView);
                        e.this.aZi();
                        return true;
                    }
                    e.this.a(e.this.dyD, false, 1);
                    TiebaStatic.log(new am("c12842").ax("obj_name", e.this.dyD).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").ax("obj_type", "1"));
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
                    if (e.this.fmy) {
                        e.this.dyD = editable.toString();
                        e.this.aZk();
                    }
                    e.this.fmn.hL(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != e.this.fmn.aZa() || e.this.fmn.aZa().getText() == null) {
                    if (view == e.this.fmn.aZb()) {
                        l.a(e.this.bwX.getPageContext().getPageActivity(), e.this.fmn.aZa());
                        com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.a.e.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.bwX.finish();
                            }
                        }, 200L);
                        return;
                    }
                    return;
                }
                e.this.dyD = e.this.fmn.aZa().getText().toString();
                if (StringUtils.isNull(e.this.dyD)) {
                    e.this.aYT();
                }
            }
        };
        this.fmn.a(onFocusChangeListener);
        this.fmn.a(onEditorActionListener);
        this.fmn.d(textWatcher);
        this.fmn.setOnClickListener(onClickListener);
    }

    private void aZg() {
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
                        TiebaStatic.eventStat(e.this.bwX.getPageContext().getPageActivity(), "search_bar_result_click", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                        TiebaStatic.log(new am("c12842").ax("obj_name", str).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2").ax("obj_type", "1").x("obj_locate", i + 1).ax("obj_param1", e.this.dyD));
                    }
                }
            }
        };
        AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.a.e.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.a(e.this.bwX.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        };
        this.fmn.c(onItemClickListener);
        this.fmn.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.fmn.onChangeSkinType(this.bwX.getPageContext(), i);
    }

    private void aZh() {
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
                if (ay.CU().b(e.this.bwX.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains("jump=open_full_screen_web_page")) {
                    return false;
                }
                ay.CU().a(e.this.bwX.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.fmn.a(cVar);
        this.fmn.a(fVar);
        this.fmn.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZi() {
        if (this.mHotSearchInfo == null) {
            this.bwX.showToast(this.bwX.getResources().getString(e.j.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.aYr() == 0 || this.mHotSearchInfo.aYr() == 2) {
            a(this.mHotSearchInfo.getName(), false, 1);
        } else if (this.mHotSearchInfo.aYr() == 1 && !com.baidu.tbadk.plugins.b.e(this.bwX.getPageContext())) {
            this.bwX.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.bwX.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new am("c10355").ax("obj_name", this.mHotSearchInfo.getName()).x("obj_type", this.mHotSearchInfo.aYr() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.a.b
    public void a(final String str, boolean z, int i) {
        if (!j.kX()) {
            this.bwX.showToast(e.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.fmy = false;
                this.fmn.qS(str);
                this.fmy = true;
            }
            l.a(this.bwX.getPageContext().getPageActivity(), this.fmn.aZa());
            this.fmn.aYZ();
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str + ETAG.ITEM_SEPARATOR + "sub_type" + ETAG.EQUAL + i;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, IoUtils.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fmn.aZc().loadUrl(str2);
            x.a(new w<Boolean>() { // from class: com.baidu.tieba.mainentrance.a.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.w
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.vf(str);
                    return true;
                }
            }, null);
            this.fmz.qO(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921345, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZj() {
        if (!this.fmn.aZe()) {
            aYF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYT() {
        this.fmz.aYT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZk() {
        if (!StringUtils.isNull(this.dyD)) {
            aYF();
        } else {
            aYT();
        }
    }

    private void aYF() {
        if (!StringUtils.isNull(this.dyD)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.dyD.trim();
            this.bwX.sendMessage(searchListNetMessage);
        }
    }

    public void b(HotSearchInfoData hotSearchInfoData) {
        this.mHotSearchInfo = hotSearchInfoData;
        aYA();
    }

    public BaseWebView aZl() {
        return this.fmn.aZc();
    }

    private void aYA() {
        if (this.mHotSearchInfo == null) {
            this.fmn.qR(this.bwX.getResources().getString(e.j.search_bar));
        } else {
            this.fmn.qR(this.mHotSearchInfo.atG());
        }
    }

    public void cV(List<String> list) {
        this.fmn.j(list, this.dyD);
    }

    public void onDestroy() {
        if (this.fmn != null) {
            this.fmn.onDestroy();
        }
    }
}
