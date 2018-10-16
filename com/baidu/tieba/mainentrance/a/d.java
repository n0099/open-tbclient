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
    private ImageView bVv;
    private ImageView dyN;
    private BdListView flF;
    private com.baidu.tieba.mainentrance.searchSuggestList.a flH;
    private FrameLayout flw;
    private TextView fly;
    private EditText fms;
    private LinearLayoutDetectsSoftKeyboard fmt;
    private QuickWebView fmu;
    private QuickWebView fmv;
    View fmw;
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
        axv();
        this.fmt = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(e.g.search_container);
        this.fmt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.fmt.setFocusable(true);
                    d.this.fmt.setFocusableInTouchMode(true);
                    if (d.this.fms.hasFocus()) {
                        l.a(d.this.mContext, d.this.fms);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.flw = (FrameLayout) this.mRootView.findViewById(e.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(e.C0175e.ds200)), null, null);
        this.flw.addView(this.mNoDataView, 0);
        aYV();
        aYy();
        aYW();
        aYX();
    }

    private void axv() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.fmw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, e.h.square_search_navigation_view, (View.OnClickListener) null);
        this.bVv = (ImageView) this.fmw.findViewById(e.g.search_bar_icon);
        this.fms = (EditText) this.fmw.findViewById(e.g.home_et_search);
        this.dyN = (ImageView) this.fmw.findViewById(e.g.home_bt_search_del);
        this.fly = (TextView) this.fmw.findViewById(e.g.home_bt_search_cancel_s);
        this.dyN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.fms.setText("");
            }
        });
        hL(false);
        this.fly.setText(this.mContext.getString(e.j.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.fms.getText().toString())) {
            this.fmw.setFocusable(true);
            this.fmw.setFocusableInTouchMode(true);
            this.fmw.requestFocus();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        al.e(this.fmt, i);
        if (i == 2) {
            this.fms.setHintTextColor(al.getColor(e.d.s_navbar_title_color));
        } else {
            this.fms.setHintTextColor(al.getColor(e.d.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        al.c(this.dyN, e.f.del_search_btn);
        al.b(this.fms, e.d.cp_cont_b, e.d.s_navbar_title_color);
        al.c(this.bVv, e.f.icon_search);
        al.i(this.flw, e.d.cp_bg_line_d);
        al.c(this.fly, e.d.cp_link_tip_a, 1);
    }

    private void aYV() {
        this.fmv = (QuickWebView) this.mRootView.findViewById(e.g.search_history_webview);
        this.fmv.mu(true);
    }

    private void aYy() {
        this.flF = (BdListView) this.mRootView.findViewById(e.g.home_lv_search_suggest);
        this.flH = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
        this.flF.setAdapter((ListAdapter) this.flH);
    }

    private void aYW() {
        this.fmu = (QuickWebView) this.mRootView.findViewById(e.g.search_result_webview);
        this.fmu.mu(true);
    }

    private void aYX() {
        this.fms.setText("");
        this.fms.requestFocus();
        this.fly.setText(this.mContext.getString(e.j.cancel));
    }

    public void aYY() {
        this.fmv.setVisibility(0);
        this.flF.setVisibility(8);
        this.fmu.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aYI() {
        this.flF.setVisibility(8);
        this.fmv.setVisibility(8);
        this.fmu.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aYG() {
        this.flF.setVisibility(0);
        this.fmv.setVisibility(8);
        this.fmu.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aYZ() {
        this.flF.setVisibility(8);
        this.fmv.setVisibility(8);
        this.fmu.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void hL(boolean z) {
        this.dyN.setVisibility(z ? 0 : 8);
    }

    public void qR(String str) {
        if (!StringUtils.isNull(str)) {
            this.fms.setHint(str);
        }
    }

    public void qS(String str) {
        if (!StringUtils.isNull(str)) {
            this.fms.setText(str);
            this.fms.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!v.J(list)) {
            aYG();
            this.flH.qJ(str);
            this.flH.setData(list);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.flF.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.flF.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.fms.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.fms.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.fms.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fms.setOnClickListener(onClickListener);
        this.fly.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.fmu.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.fmu.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.fmu.setOnLoadUrlListener(bVar);
    }

    public EditText aZa() {
        return this.fms;
    }

    public TextView aZb() {
        return this.fly;
    }

    public QuickWebView aZc() {
        return this.fmu;
    }

    public QuickWebView aZd() {
        return this.fmv;
    }

    public boolean aZe() {
        return this.flF.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.flw != null) {
                this.flw.removeView(this.fmv);
                this.flw.removeView(this.fmu);
            }
            this.fmv.removeAllViews();
            this.fmu.removeAllViews();
            if (this.fmv != null) {
                this.fmv.destroy();
                this.fmv = null;
            }
            if (this.fmu != null) {
                this.fmu.destroy();
                this.fmu = null;
            }
        } catch (Exception e) {
        }
    }
}
