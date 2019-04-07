package com.baidu.tieba.mainentrance.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.d;
import com.baidu.tieba.quickWebView.QuickWebView;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.List;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes6.dex */
public class d {
    private ImageView dpR;
    private ImageView eXd;
    private FrameLayout gNj;
    private TextView gNl;
    private BdListView gNs;
    private com.baidu.tieba.mainentrance.searchSuggestList.b gNu;
    private EditText gOl;
    private LinearLayoutDetectsSoftKeyboard gOm;
    private QuickWebView gOn;
    private QuickWebView gOo;
    private com.baidu.tieba.mainentrance.searchSuggestList.a gOp;
    View gOq;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public d(View view, Context context) {
        this.mRootView = view;
        this.mContext = context;
        initView();
    }

    private void initView() {
        aBy();
        this.gOm = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(d.g.search_container);
        this.gOm.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.gOm.setFocusable(true);
                    d.this.gOm.setFocusableInTouchMode(true);
                    if (d.this.gOl.hasFocus()) {
                        l.b(d.this.mContext, d.this.gOl);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.gNj = (FrameLayout) this.mRootView.findViewById(d.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds200)), null, null);
        this.gNj.addView(this.mNoDataView, 0);
        bBX();
        bBA();
        bBY();
        bBZ();
    }

    private void aBy() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.gOq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.square_search_navigation_view, (View.OnClickListener) null);
        this.dpR = (ImageView) this.gOq.findViewById(d.g.search_bar_icon);
        this.gOl = (EditText) this.gOq.findViewById(d.g.home_et_search);
        this.eXd = (ImageView) this.gOq.findViewById(d.g.home_bt_search_del);
        this.gNl = (TextView) this.gOq.findViewById(d.g.home_bt_search_cancel_s);
        this.eXd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.gOl.setText("");
            }
        });
        kA(false);
        this.gNl.setText(this.mContext.getString(d.j.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.gOl.getText().toString())) {
            this.gOq.setFocusable(true);
            this.gOq.setFocusableInTouchMode(true);
            this.gOq.requestFocus();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        al.g(this.gOm, i);
        if (i == 2) {
            this.gOl.setHintTextColor(al.getColor(d.C0277d.s_navbar_title_color));
        } else {
            this.gOl.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        al.c(this.eXd, d.f.del_search_btn);
        al.c(this.gOl, d.C0277d.cp_cont_b, d.C0277d.s_navbar_title_color);
        al.c(this.dpR, d.f.icon_search);
        al.k(this.gNj, d.C0277d.cp_bg_line_d);
        al.d(this.gNl, d.C0277d.cp_link_tip_a, 1);
    }

    private void bBX() {
        this.gOo = (QuickWebView) this.mRootView.findViewById(d.g.search_history_webview);
        this.gOo.pk(true);
    }

    private void bBA() {
        this.gNs = (BdListView) this.mRootView.findViewById(d.g.home_lv_search_suggest);
        this.gNu = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.gOp = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void bBY() {
        this.gOn = (QuickWebView) this.mRootView.findViewById(d.g.search_result_webview);
        this.gOn.pk(true);
    }

    private void bBZ() {
        this.gOl.setText("");
        this.gOl.requestFocus();
        this.gNl.setText(this.mContext.getString(d.j.cancel));
    }

    public void bCa() {
        this.gOo.setVisibility(0);
        this.gNs.setVisibility(8);
        this.gOn.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bBK() {
        this.gNs.setVisibility(8);
        this.gOo.setVisibility(8);
        this.gOn.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bBI() {
        this.gNs.setVisibility(0);
        this.gOo.setVisibility(8);
        this.gOn.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bCb() {
        this.gNs.setVisibility(8);
        this.gOo.setVisibility(8);
        this.gOn.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void kA(boolean z) {
        this.eXd.setVisibility(z ? 0 : 8);
    }

    public void yp(String str) {
        if (!StringUtils.isNull(str)) {
            this.gOl.setHint(str);
        }
    }

    public void yq(String str) {
        if (!StringUtils.isNull(str)) {
            this.gOl.setText(str);
            this.gOl.setSelection(str.length());
        }
    }

    public void k(List<String> list, String str) {
        if (!v.T(list)) {
            bBI();
            this.gNu.yh(str);
            this.gNu.setData(list);
            this.gNs.setAdapter((ListAdapter) this.gNu);
        }
    }

    public void l(List<ForumInfo> list, String str) {
        if (!v.T(list) && !TextUtils.isEmpty(str)) {
            bBI();
            this.gOp.yh(str);
            this.gOp.di(list);
            this.gNs.setAdapter((ListAdapter) this.gOp);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.gNs.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.gNs.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.gOl.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.gOl.setOnEditorActionListener(onEditorActionListener);
    }

    public void e(TextWatcher textWatcher) {
        this.gOl.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.gOl.setOnClickListener(onClickListener);
        this.gNl.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.gOn.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.gOn.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.gOn.setOnLoadUrlListener(bVar);
    }

    public EditText bCc() {
        return this.gOl;
    }

    public TextView bCd() {
        return this.gNl;
    }

    public QuickWebView bCe() {
        return this.gOn;
    }

    public QuickWebView bCf() {
        return this.gOo;
    }

    public boolean bCg() {
        return this.gNs.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.gNj != null) {
                this.gNj.removeView(this.gOo);
                this.gNj.removeView(this.gOn);
            }
            this.gOo.removeAllViews();
            this.gOn.removeAllViews();
            if (this.gOo != null) {
                this.gOo.destroy();
                this.gOo = null;
            }
            if (this.gOn != null) {
                this.gOn.destroy();
                this.gOn = null;
            }
        } catch (Exception e) {
        }
    }
}
