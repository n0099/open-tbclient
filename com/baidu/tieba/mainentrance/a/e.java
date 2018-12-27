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
    private BaseActivity bBi;
    private String dJh;
    private boolean fxA = true;
    private c fxB;
    private d fxp;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;

    public e(BaseActivity baseActivity) {
        this.bBi = baseActivity;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.bBi).inflate(e.h.new_home_dialog_search, (ViewGroup) null);
            this.bBi.setContentView(this.mRootView);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> baS = a.baS();
            if (baS != null) {
                int size = baS.size();
                int i2 = 0;
                Iterator<String> it = baS.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    a.rt(it.next());
                    try {
                        this.mRootView = LayoutInflater.from(this.bBi).inflate(e.h.new_home_dialog_search, (ViewGroup) null);
                        this.bBi.setContentView(this.mRootView);
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        i2 = i + 1;
                    }
                }
                if (i == size) {
                    this.bBi.finish();
                    return;
                }
            } else {
                this.bBi.finish();
                return;
            }
        }
        if (this.mRootView == null) {
            this.bBi.finish();
            return;
        }
        this.fxp = new d(this.mRootView, this.bBi.getPageContext().getPageActivity());
        this.fxB = new c(this.bBi, this, this.fxp);
        bbh();
        bbi();
        bbj();
        baC();
        bbm();
        ab.a(this.fxp.bbe(), this.bBi.getUniqueId());
        ab.a(this.fxp.bbf(), this.bBi.getUniqueId());
    }

    public void onResume() {
        if (this.fxp != null) {
            this.fxp.onResume();
        }
    }

    public void bbh() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.a.e.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(e.this.bBi.getPageContext().getPageActivity(), view);
                } else {
                    e.this.bbl();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.a.e.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(e.this.dJh)) {
                        l.b(e.this.bBi.getPageContext().getPageActivity(), textView);
                        e.this.bbk();
                        return true;
                    }
                    e.this.a(e.this.dJh, false, 1);
                    TiebaStatic.log(new am("c12842").aA("obj_name", e.this.dJh).aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").aA("obj_type", "1"));
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
                    if (e.this.fxA) {
                        e.this.dJh = editable.toString();
                        e.this.bbm();
                    }
                    e.this.fxp.ia(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != e.this.fxp.bbc() || e.this.fxp.bbc().getText() == null) {
                    if (view == e.this.fxp.bbd()) {
                        l.b(e.this.bBi.getPageContext().getPageActivity(), e.this.fxp.bbc());
                        com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.a.e.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.bBi.finish();
                            }
                        }, 200L);
                        return;
                    }
                    return;
                }
                e.this.dJh = e.this.fxp.bbc().getText().toString();
                if (StringUtils.isNull(e.this.dJh)) {
                    e.this.baV();
                }
            }
        };
        this.fxp.a(onFocusChangeListener);
        this.fxp.a(onEditorActionListener);
        this.fxp.d(textWatcher);
        this.fxp.setOnClickListener(onClickListener);
    }

    private void bbi() {
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
                        TiebaStatic.eventStat(e.this.bBi.getPageContext().getPageActivity(), "search_bar_result_click", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                        TiebaStatic.log(new am("c12842").aA("obj_name", str).aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2").aA("obj_type", "1").x("obj_locate", i + 1).aA("obj_param1", e.this.dJh));
                    }
                }
            }
        };
        AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.a.e.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.b(e.this.bBi.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        };
        this.fxp.c(onItemClickListener);
        this.fxp.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.fxp.onChangeSkinType(this.bBi.getPageContext(), i);
    }

    private void bbj() {
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
                if (ay.Ef().b(e.this.bBi.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains("jump=open_full_screen_web_page")) {
                    return false;
                }
                ay.Ef().a(e.this.bBi.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.fxp.a(cVar);
        this.fxp.a(fVar);
        this.fxp.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbk() {
        if (this.mHotSearchInfo == null) {
            this.bBi.showToast(this.bBi.getResources().getString(e.j.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.bat() == 0 || this.mHotSearchInfo.bat() == 2) {
            a(this.mHotSearchInfo.getName(), false, 1);
        } else if (this.mHotSearchInfo.bat() == 1 && !com.baidu.tbadk.plugins.b.e(this.bBi.getPageContext())) {
            this.bBi.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.bBi.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new am("c10355").aA("obj_name", this.mHotSearchInfo.getName()).x("obj_type", this.mHotSearchInfo.bat() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.a.b
    public void a(final String str, boolean z, int i) {
        if (!j.kV()) {
            this.bBi.showToast(e.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.fxA = false;
                this.fxp.ry(str);
                this.fxA = true;
            }
            l.b(this.bBi.getPageContext().getPageActivity(), this.fxp.bbc());
            this.fxp.bbb();
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str + ETAG.ITEM_SEPARATOR + "sub_type" + ETAG.EQUAL + i;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, IoUtils.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fxp.bbe().loadUrl(str2);
            x.a(new w<Boolean>() { // from class: com.baidu.tieba.mainentrance.a.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.w
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.vO(str);
                    return true;
                }
            }, null);
            this.fxB.ru(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921345, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbl() {
        if (!this.fxp.bbg()) {
            baH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baV() {
        this.fxB.baV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbm() {
        if (!StringUtils.isNull(this.dJh)) {
            baH();
        } else {
            baV();
        }
    }

    private void baH() {
        if (!StringUtils.isNull(this.dJh)) {
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.dJh.trim();
            this.bBi.sendMessage(searchListNetMessage);
        }
    }

    public void b(HotSearchInfoData hotSearchInfoData) {
        this.mHotSearchInfo = hotSearchInfoData;
        baC();
    }

    public BaseWebView bbn() {
        return this.fxp.bbe();
    }

    private void baC() {
        if (this.mHotSearchInfo == null) {
            this.fxp.rx(this.bBi.getResources().getString(e.j.search_bar));
        } else {
            this.fxp.rx(this.mHotSearchInfo.avH());
        }
    }

    public void cY(List<String> list) {
        this.fxp.j(list, this.dJh);
    }

    public void onDestroy() {
        if (this.fxp != null) {
            this.fxp.onDestroy();
        }
    }
}
