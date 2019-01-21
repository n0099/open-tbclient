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
    private ImageView caQ;
    private ImageView dKb;
    private BdListView fxC;
    private com.baidu.tieba.mainentrance.searchSuggestList.a fxE;
    private FrameLayout fxt;
    private TextView fxv;
    private EditText fyp;
    private LinearLayoutDetectsSoftKeyboard fyq;
    private QuickWebView fyr;
    private QuickWebView fys;
    View fyt;
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
        this.fyq = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(e.g.search_container);
        this.fyq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.fyq.setFocusable(true);
                    d.this.fyq.setFocusableInTouchMode(true);
                    if (d.this.fyp.hasFocus()) {
                        l.b(d.this.mContext, d.this.fyp);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.fxt = (FrameLayout) this.mRootView.findViewById(e.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(e.C0210e.ds200)), null, null);
        this.fxt.addView(this.mNoDataView, 0);
        bbx();
        bba();
        bby();
        bbz();
    }

    private void azR() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.fyt = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, e.h.square_search_navigation_view, (View.OnClickListener) null);
        this.caQ = (ImageView) this.fyt.findViewById(e.g.search_bar_icon);
        this.fyp = (EditText) this.fyt.findViewById(e.g.home_et_search);
        this.dKb = (ImageView) this.fyt.findViewById(e.g.home_bt_search_del);
        this.fxv = (TextView) this.fyt.findViewById(e.g.home_bt_search_cancel_s);
        this.dKb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.fyp.setText("");
            }
        });
        ia(false);
        this.fxv.setText(this.mContext.getString(e.j.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.fyp.getText().toString())) {
            this.fyt.setFocusable(true);
            this.fyt.setFocusableInTouchMode(true);
            this.fyt.requestFocus();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        al.e(this.fyq, i);
        if (i == 2) {
            this.fyp.setHintTextColor(al.getColor(e.d.s_navbar_title_color));
        } else {
            this.fyp.setHintTextColor(al.getColor(e.d.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        al.c(this.dKb, e.f.del_search_btn);
        al.b(this.fyp, e.d.cp_cont_b, e.d.s_navbar_title_color);
        al.c(this.caQ, e.f.icon_search);
        al.i(this.fxt, e.d.cp_bg_line_d);
        al.c(this.fxv, e.d.cp_link_tip_a, 1);
    }

    private void bbx() {
        this.fys = (QuickWebView) this.mRootView.findViewById(e.g.search_history_webview);
        this.fys.mL(true);
    }

    private void bba() {
        this.fxC = (BdListView) this.mRootView.findViewById(e.g.home_lv_search_suggest);
        this.fxE = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
        this.fxC.setAdapter((ListAdapter) this.fxE);
    }

    private void bby() {
        this.fyr = (QuickWebView) this.mRootView.findViewById(e.g.search_result_webview);
        this.fyr.mL(true);
    }

    private void bbz() {
        this.fyp.setText("");
        this.fyp.requestFocus();
        this.fxv.setText(this.mContext.getString(e.j.cancel));
    }

    public void bbA() {
        this.fys.setVisibility(0);
        this.fxC.setVisibility(8);
        this.fyr.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bbk() {
        this.fxC.setVisibility(8);
        this.fys.setVisibility(8);
        this.fyr.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bbi() {
        this.fxC.setVisibility(0);
        this.fys.setVisibility(8);
        this.fyr.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bbB() {
        this.fxC.setVisibility(8);
        this.fys.setVisibility(8);
        this.fyr.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void ia(boolean z) {
        this.dKb.setVisibility(z ? 0 : 8);
    }

    public void rN(String str) {
        if (!StringUtils.isNull(str)) {
            this.fyp.setHint(str);
        }
    }

    public void rO(String str) {
        if (!StringUtils.isNull(str)) {
            this.fyp.setText(str);
            this.fyp.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!v.I(list)) {
            bbi();
            this.fxE.rF(str);
            this.fxE.setData(list);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.fxC.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.fxC.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.fyp.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.fyp.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.fyp.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fyp.setOnClickListener(onClickListener);
        this.fxv.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.fyr.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.fyr.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.fyr.setOnLoadUrlListener(bVar);
    }

    public EditText bbC() {
        return this.fyp;
    }

    public TextView bbD() {
        return this.fxv;
    }

    public QuickWebView bbE() {
        return this.fyr;
    }

    public QuickWebView bbF() {
        return this.fys;
    }

    public boolean bbG() {
        return this.fxC.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.fxt != null) {
                this.fxt.removeView(this.fys);
                this.fxt.removeView(this.fyr);
            }
            this.fys.removeAllViews();
            this.fyr.removeAllViews();
            if (this.fys != null) {
                this.fys.destroy();
                this.fys = null;
            }
            if (this.fyr != null) {
                this.fyr.destroy();
                this.fyr = null;
            }
        } catch (Exception e) {
        }
    }
}
