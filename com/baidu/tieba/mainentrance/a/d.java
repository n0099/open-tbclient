package com.baidu.tieba.mainentrance.a;

import android.content.Context;
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
import com.baidu.tieba.e;
import com.baidu.tieba.quickWebView.QuickWebView;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private ImageView caP;
    private ImageView dKa;
    private BdListView fxB;
    private com.baidu.tieba.mainentrance.searchSuggestList.a fxD;
    private FrameLayout fxs;
    private TextView fxu;
    private EditText fyo;
    private LinearLayoutDetectsSoftKeyboard fyp;
    private QuickWebView fyq;
    private QuickWebView fyr;
    View fys;
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
        azR();
        this.fyp = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(e.g.search_container);
        this.fyp.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.fyp.setFocusable(true);
                    d.this.fyp.setFocusableInTouchMode(true);
                    if (d.this.fyo.hasFocus()) {
                        l.b(d.this.mContext, d.this.fyo);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.fxs = (FrameLayout) this.mRootView.findViewById(e.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(e.C0210e.ds200)), null, null);
        this.fxs.addView(this.mNoDataView, 0);
        bbx();
        bba();
        bby();
        bbz();
    }

    private void azR() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.fys = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, e.h.square_search_navigation_view, (View.OnClickListener) null);
        this.caP = (ImageView) this.fys.findViewById(e.g.search_bar_icon);
        this.fyo = (EditText) this.fys.findViewById(e.g.home_et_search);
        this.dKa = (ImageView) this.fys.findViewById(e.g.home_bt_search_del);
        this.fxu = (TextView) this.fys.findViewById(e.g.home_bt_search_cancel_s);
        this.dKa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.fyo.setText("");
            }
        });
        ia(false);
        this.fxu.setText(this.mContext.getString(e.j.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.fyo.getText().toString())) {
            this.fys.setFocusable(true);
            this.fys.setFocusableInTouchMode(true);
            this.fys.requestFocus();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        al.e(this.fyp, i);
        if (i == 2) {
            this.fyo.setHintTextColor(al.getColor(e.d.s_navbar_title_color));
        } else {
            this.fyo.setHintTextColor(al.getColor(e.d.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        al.c(this.dKa, e.f.del_search_btn);
        al.b(this.fyo, e.d.cp_cont_b, e.d.s_navbar_title_color);
        al.c(this.caP, e.f.icon_search);
        al.i(this.fxs, e.d.cp_bg_line_d);
        al.c(this.fxu, e.d.cp_link_tip_a, 1);
    }

    private void bbx() {
        this.fyr = (QuickWebView) this.mRootView.findViewById(e.g.search_history_webview);
        this.fyr.mL(true);
    }

    private void bba() {
        this.fxB = (BdListView) this.mRootView.findViewById(e.g.home_lv_search_suggest);
        this.fxD = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
        this.fxB.setAdapter((ListAdapter) this.fxD);
    }

    private void bby() {
        this.fyq = (QuickWebView) this.mRootView.findViewById(e.g.search_result_webview);
        this.fyq.mL(true);
    }

    private void bbz() {
        this.fyo.setText("");
        this.fyo.requestFocus();
        this.fxu.setText(this.mContext.getString(e.j.cancel));
    }

    public void bbA() {
        this.fyr.setVisibility(0);
        this.fxB.setVisibility(8);
        this.fyq.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bbk() {
        this.fxB.setVisibility(8);
        this.fyr.setVisibility(8);
        this.fyq.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bbi() {
        this.fxB.setVisibility(0);
        this.fyr.setVisibility(8);
        this.fyq.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bbB() {
        this.fxB.setVisibility(8);
        this.fyr.setVisibility(8);
        this.fyq.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void ia(boolean z) {
        this.dKa.setVisibility(z ? 0 : 8);
    }

    public void rN(String str) {
        if (!StringUtils.isNull(str)) {
            this.fyo.setHint(str);
        }
    }

    public void rO(String str) {
        if (!StringUtils.isNull(str)) {
            this.fyo.setText(str);
            this.fyo.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!v.I(list)) {
            bbi();
            this.fxD.rF(str);
            this.fxD.setData(list);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.fxB.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.fxB.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.fyo.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.fyo.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.fyo.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fyo.setOnClickListener(onClickListener);
        this.fxu.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.fyq.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.fyq.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.fyq.setOnLoadUrlListener(bVar);
    }

    public EditText bbC() {
        return this.fyo;
    }

    public TextView bbD() {
        return this.fxu;
    }

    public QuickWebView bbE() {
        return this.fyq;
    }

    public QuickWebView bbF() {
        return this.fyr;
    }

    public boolean bbG() {
        return this.fxB.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.fxs != null) {
                this.fxs.removeView(this.fyr);
                this.fxs.removeView(this.fyq);
            }
            this.fyr.removeAllViews();
            this.fyq.removeAllViews();
            if (this.fyr != null) {
                this.fyr.destroy();
                this.fyr = null;
            }
            if (this.fyq != null) {
                this.fyq.destroy();
                this.fyq = null;
            }
        } catch (Exception e) {
        }
    }
}
