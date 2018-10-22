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
    private BdListView flG;
    private com.baidu.tieba.mainentrance.searchSuggestList.a flI;
    private FrameLayout flx;
    private TextView flz;
    private EditText fmt;
    private LinearLayoutDetectsSoftKeyboard fmu;
    private QuickWebView fmv;
    private QuickWebView fmw;
    View fmx;
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
        axw();
        this.fmu = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(e.g.search_container);
        this.fmu.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.fmu.setFocusable(true);
                    d.this.fmu.setFocusableInTouchMode(true);
                    if (d.this.fmt.hasFocus()) {
                        l.a(d.this.mContext, d.this.fmt);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.flx = (FrameLayout) this.mRootView.findViewById(e.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(e.C0175e.ds200)), null, null);
        this.flx.addView(this.mNoDataView, 0);
        aYV();
        aYy();
        aYW();
        aYX();
    }

    private void axw() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.fmx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, e.h.square_search_navigation_view, (View.OnClickListener) null);
        this.bVv = (ImageView) this.fmx.findViewById(e.g.search_bar_icon);
        this.fmt = (EditText) this.fmx.findViewById(e.g.home_et_search);
        this.dyN = (ImageView) this.fmx.findViewById(e.g.home_bt_search_del);
        this.flz = (TextView) this.fmx.findViewById(e.g.home_bt_search_cancel_s);
        this.dyN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.fmt.setText("");
            }
        });
        hL(false);
        this.flz.setText(this.mContext.getString(e.j.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.fmt.getText().toString())) {
            this.fmx.setFocusable(true);
            this.fmx.setFocusableInTouchMode(true);
            this.fmx.requestFocus();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        al.e(this.fmu, i);
        if (i == 2) {
            this.fmt.setHintTextColor(al.getColor(e.d.s_navbar_title_color));
        } else {
            this.fmt.setHintTextColor(al.getColor(e.d.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        al.c(this.dyN, e.f.del_search_btn);
        al.b(this.fmt, e.d.cp_cont_b, e.d.s_navbar_title_color);
        al.c(this.bVv, e.f.icon_search);
        al.i(this.flx, e.d.cp_bg_line_d);
        al.c(this.flz, e.d.cp_link_tip_a, 1);
    }

    private void aYV() {
        this.fmw = (QuickWebView) this.mRootView.findViewById(e.g.search_history_webview);
        this.fmw.mu(true);
    }

    private void aYy() {
        this.flG = (BdListView) this.mRootView.findViewById(e.g.home_lv_search_suggest);
        this.flI = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
        this.flG.setAdapter((ListAdapter) this.flI);
    }

    private void aYW() {
        this.fmv = (QuickWebView) this.mRootView.findViewById(e.g.search_result_webview);
        this.fmv.mu(true);
    }

    private void aYX() {
        this.fmt.setText("");
        this.fmt.requestFocus();
        this.flz.setText(this.mContext.getString(e.j.cancel));
    }

    public void aYY() {
        this.fmw.setVisibility(0);
        this.flG.setVisibility(8);
        this.fmv.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aYI() {
        this.flG.setVisibility(8);
        this.fmw.setVisibility(8);
        this.fmv.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aYG() {
        this.flG.setVisibility(0);
        this.fmw.setVisibility(8);
        this.fmv.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aYZ() {
        this.flG.setVisibility(8);
        this.fmw.setVisibility(8);
        this.fmv.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void hL(boolean z) {
        this.dyN.setVisibility(z ? 0 : 8);
    }

    public void qR(String str) {
        if (!StringUtils.isNull(str)) {
            this.fmt.setHint(str);
        }
    }

    public void qS(String str) {
        if (!StringUtils.isNull(str)) {
            this.fmt.setText(str);
            this.fmt.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!v.J(list)) {
            aYG();
            this.flI.qJ(str);
            this.flI.setData(list);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.flG.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.flG.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.fmt.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.fmt.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.fmt.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fmt.setOnClickListener(onClickListener);
        this.flz.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.fmv.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.fmv.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.fmv.setOnLoadUrlListener(bVar);
    }

    public EditText aZa() {
        return this.fmt;
    }

    public TextView aZb() {
        return this.flz;
    }

    public QuickWebView aZc() {
        return this.fmv;
    }

    public QuickWebView aZd() {
        return this.fmw;
    }

    public boolean aZe() {
        return this.flG.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.flx != null) {
                this.flx.removeView(this.fmw);
                this.flx.removeView(this.fmv);
            }
            this.fmw.removeAllViews();
            this.fmv.removeAllViews();
            if (this.fmw != null) {
                this.fmw.destroy();
                this.fmw = null;
            }
            if (this.fmv != null) {
                this.fmv.destroy();
                this.fmv = null;
            }
        } catch (Exception e) {
        }
    }
}
