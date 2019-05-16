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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.HotSearchInfoData;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListNetMessage;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes6.dex */
public class e implements b {
    private BaseActivity cVo;
    private String fmY;
    private boolean hfK;
    private boolean hfL = true;
    private c hfM;
    private d hfz;
    private HotSearchInfoData mHotSearchInfo;
    private View mRootView;

    public e(BaseActivity baseActivity, boolean z) {
        this.cVo = baseActivity;
        this.hfK = z;
        init();
    }

    private void init() {
        int i;
        try {
            this.mRootView = LayoutInflater.from(this.cVo).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
            this.cVo.setContentView(this.mRootView);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> bJC = a.bJC();
            if (bJC != null) {
                int size = bJC.size();
                int i2 = 0;
                Iterator<String> it = bJC.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    a.zB(it.next());
                    try {
                        this.mRootView = LayoutInflater.from(this.cVo).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
                        this.cVo.setContentView(this.mRootView);
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        i2 = i + 1;
                    }
                }
                if (i == size) {
                    this.cVo.finish();
                    return;
                }
            } else {
                this.cVo.finish();
                return;
            }
        }
        if (this.mRootView == null) {
            this.cVo.finish();
            return;
        }
        this.hfz = new d(this.mRootView, this.cVo.getPageContext().getPageActivity());
        this.hfM = new c(this.cVo, this, this.hfz);
        bJR();
        bJS();
        bJT();
        bJm();
        bJW();
        ae.a(this.hfz.bJO(), this.cVo.getUniqueId());
        ae.a(this.hfz.bJP(), this.cVo.getUniqueId());
    }

    public void onResume() {
        if (this.hfz != null) {
            this.hfz.onResume();
        }
    }

    public void bJR() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.mainentrance.a.e.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(e.this.cVo.getPageContext().getPageActivity(), view);
                } else {
                    e.this.bJV();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.mainentrance.a.e.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.isNull(e.this.fmY)) {
                        l.b(e.this.cVo.getPageContext().getPageActivity(), textView);
                        e.this.bJU();
                        return true;
                    }
                    e.this.a(e.this.fmY, false, 1);
                    TiebaStatic.log(new am("c12842").bT("obj_name", e.this.fmY).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").bT("obj_type", "1"));
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
                    if (e.this.hfL) {
                        e.this.fmY = editable.toString();
                        e.this.bJW();
                    }
                    e.this.hfz.ij(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != e.this.hfz.bJM() || e.this.hfz.bJM().getText() == null) {
                    if (view == e.this.hfz.bJN()) {
                        l.b(e.this.cVo.getPageContext().getPageActivity(), e.this.hfz.bJM());
                        com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.a.e.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.cVo.finish();
                            }
                        }, 200L);
                        return;
                    }
                    return;
                }
                e.this.fmY = e.this.hfz.bJM().getText().toString();
                if (StringUtils.isNull(e.this.fmY)) {
                    e.this.bJF();
                }
            }
        };
        this.hfz.a(onFocusChangeListener);
        this.hfz.a(onEditorActionListener);
        this.hfz.e(textWatcher);
        this.hfz.setOnClickListener(onClickListener);
    }

    private void bJS() {
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
                        TiebaStatic.eventStat(e.this.cVo.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                        TiebaStatic.log(new am("c12842").bT("obj_name", str).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2").bT("obj_type", "1").P("obj_locate", i + 1).bT("obj_param1", e.this.fmY));
                    } else if (item instanceof ForumInfo) {
                        ForumInfo forumInfo = (ForumInfo) item;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.cVo.getPageContext().getPageActivity()).createNormalCfg(forumInfo.forum_name, FrsActivityConfig.FRS_CALL_SEARCH)));
                        TiebaStatic.log(new am("c13371").bT("obj_type", forumInfo.has_concerned.intValue() > 0 ? "1" : "2").P("fid", forumInfo.forum_id.intValue()).l("uid", TbadkApplication.getCurrentAccountId()));
                    }
                }
            }
        };
        AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mainentrance.a.e.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    l.b(e.this.cVo.getPageContext().getPageActivity(), absListView);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        };
        this.hfz.c(onItemClickListener);
        this.hfz.a(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.hfz.onChangeSkinType(this.cVo.getPageContext(), i);
    }

    private void bJT() {
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
                if (ba.aiz().b(e.this.cVo.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains("jump=open_full_screen_web_page")) {
                    return false;
                }
                ba.aiz().a(e.this.cVo.getPageContext(), new String[]{str}, true);
                return true;
            }
        };
        this.hfz.a(cVar);
        this.hfz.a(fVar);
        this.hfz.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJU() {
        if (this.mHotSearchInfo == null) {
            this.cVo.showToast(this.cVo.getResources().getString(R.string.write_keyword));
            return;
        }
        if (this.mHotSearchInfo.bJd() == 0 || this.mHotSearchInfo.bJd() == 2) {
            a(this.mHotSearchInfo.getName(), false, 1);
        } else if (this.mHotSearchInfo.bJd() == 1 && !com.baidu.tbadk.plugins.b.f(this.cVo.getPageContext())) {
            this.cVo.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.cVo.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.mHotSearchInfo.getId()), this.mHotSearchInfo.getName(), "4")));
        }
        TiebaStatic.log(new am("c10355").bT("obj_name", this.mHotSearchInfo.getName()).P("obj_type", this.mHotSearchInfo.bJd() == 0 ? 2 : 1));
    }

    @Override // com.baidu.tieba.mainentrance.a.b
    public void a(final String str, boolean z, int i) {
        if (!j.jS()) {
            this.cVo.showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (z) {
                this.hfL = false;
                this.hfz.zG(str);
                this.hfL = true;
            }
            l.b(this.cVo.getPageContext().getPageActivity(), this.hfz.bJM());
            this.hfz.bJL();
            String str2 = TbConfig.SQUARE_SEARCH_PAGE + str + "&sub_type=" + i;
            try {
                str2 = TbConfig.SQUARE_SEARCH_PAGE + URLEncoder.encode(str, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hfz.bJO().loadUrl(str2);
            aa.a(new z<Boolean>() { // from class: com.baidu.tieba.mainentrance.a.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.z
                public Boolean doInBackground() {
                    com.baidu.tieba.tbadkCore.util.a.Ec(str);
                    return true;
                }
            }, null);
            this.hfM.zC(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921345, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJV() {
        if (!this.hfz.bJQ()) {
            bJr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJF() {
        this.hfM.bJF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJW() {
        if (!StringUtils.isNull(this.fmY)) {
            bJr();
        } else {
            bJF();
        }
    }

    private void bJr() {
        if (StringUtils.isNull(this.fmY)) {
            bJF();
            return;
        }
        SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
        searchListNetMessage.mKey = this.fmY.trim();
        searchListNetMessage.isForum = Integer.valueOf(this.hfK ? 1 : 0);
        this.cVo.sendMessage(searchListNetMessage);
    }

    public void b(HotSearchInfoData hotSearchInfoData) {
        this.mHotSearchInfo = hotSearchInfoData;
        bJm();
    }

    public BaseWebView bJX() {
        return this.hfz.bJO();
    }

    private void bJm() {
        if (this.mHotSearchInfo == null) {
            this.hfz.zF(this.cVo.getResources().getString(R.string.search_bar));
        } else {
            this.hfz.zF(this.mHotSearchInfo.bdi());
        }
    }

    public void dr(List<String> list) {
        this.hfz.k(list, this.fmY);
    }

    public void ds(List<ForumInfo> list) {
        this.hfz.l(list, this.fmY);
    }

    public void onDestroy() {
        if (this.hfz != null) {
            this.hfz.onDestroy();
        }
    }
}
