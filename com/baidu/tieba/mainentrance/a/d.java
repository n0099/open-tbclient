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
    private ImageView bWj;
    private ImageView dAe;
    private FrameLayout fmO;
    private TextView fmQ;
    private BdListView fmX;
    private com.baidu.tieba.mainentrance.searchSuggestList.a fmZ;
    private EditText fnK;
    private LinearLayoutDetectsSoftKeyboard fnL;
    private QuickWebView fnM;
    private QuickWebView fnN;
    View fnO;
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
        awU();
        this.fnL = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(e.g.search_container);
        this.fnL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.fnL.setFocusable(true);
                    d.this.fnL.setFocusableInTouchMode(true);
                    if (d.this.fnK.hasFocus()) {
                        l.b(d.this.mContext, d.this.fnK);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.fmO = (FrameLayout) this.mRootView.findViewById(e.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(e.C0200e.ds200)), null, null);
        this.fmO.addView(this.mNoDataView, 0);
        aYs();
        aXV();
        aYt();
        aYu();
    }

    private void awU() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.fnO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, e.h.square_search_navigation_view, (View.OnClickListener) null);
        this.bWj = (ImageView) this.fnO.findViewById(e.g.search_bar_icon);
        this.fnK = (EditText) this.fnO.findViewById(e.g.home_et_search);
        this.dAe = (ImageView) this.fnO.findViewById(e.g.home_bt_search_del);
        this.fmQ = (TextView) this.fnO.findViewById(e.g.home_bt_search_cancel_s);
        this.dAe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.fnK.setText("");
            }
        });
        hU(false);
        this.fmQ.setText(this.mContext.getString(e.j.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.fnK.getText().toString())) {
            this.fnO.setFocusable(true);
            this.fnO.setFocusableInTouchMode(true);
            this.fnO.requestFocus();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        al.e(this.fnL, i);
        if (i == 2) {
            this.fnK.setHintTextColor(al.getColor(e.d.s_navbar_title_color));
        } else {
            this.fnK.setHintTextColor(al.getColor(e.d.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        al.c(this.dAe, e.f.del_search_btn);
        al.b(this.fnK, e.d.cp_cont_b, e.d.s_navbar_title_color);
        al.c(this.bWj, e.f.icon_search);
        al.i(this.fmO, e.d.cp_bg_line_d);
        al.c(this.fmQ, e.d.cp_link_tip_a, 1);
    }

    private void aYs() {
        this.fnN = (QuickWebView) this.mRootView.findViewById(e.g.search_history_webview);
        this.fnN.mF(true);
    }

    private void aXV() {
        this.fmX = (BdListView) this.mRootView.findViewById(e.g.home_lv_search_suggest);
        this.fmZ = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
        this.fmX.setAdapter((ListAdapter) this.fmZ);
    }

    private void aYt() {
        this.fnM = (QuickWebView) this.mRootView.findViewById(e.g.search_result_webview);
        this.fnM.mF(true);
    }

    private void aYu() {
        this.fnK.setText("");
        this.fnK.requestFocus();
        this.fmQ.setText(this.mContext.getString(e.j.cancel));
    }

    public void aYv() {
        this.fnN.setVisibility(0);
        this.fmX.setVisibility(8);
        this.fnM.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aYf() {
        this.fmX.setVisibility(8);
        this.fnN.setVisibility(8);
        this.fnM.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aYd() {
        this.fmX.setVisibility(0);
        this.fnN.setVisibility(8);
        this.fnM.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aYw() {
        this.fmX.setVisibility(8);
        this.fnN.setVisibility(8);
        this.fnM.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void hU(boolean z) {
        this.dAe.setVisibility(z ? 0 : 8);
    }

    public void qS(String str) {
        if (!StringUtils.isNull(str)) {
            this.fnK.setHint(str);
        }
    }

    public void qT(String str) {
        if (!StringUtils.isNull(str)) {
            this.fnK.setText(str);
            this.fnK.setSelection(str.length());
        }
    }

    public void i(List<String> list, String str) {
        if (!v.I(list)) {
            aYd();
            this.fmZ.qK(str);
            this.fmZ.setData(list);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.fmX.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.fmX.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.fnK.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.fnK.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.fnK.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fnK.setOnClickListener(onClickListener);
        this.fmQ.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.fnM.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.fnM.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.fnM.setOnLoadUrlListener(bVar);
    }

    public EditText aYx() {
        return this.fnK;
    }

    public TextView aYy() {
        return this.fmQ;
    }

    public QuickWebView aYz() {
        return this.fnM;
    }

    public QuickWebView aYA() {
        return this.fnN;
    }

    public boolean aYB() {
        return this.fmX.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.fmO != null) {
                this.fmO.removeView(this.fnN);
                this.fmO.removeView(this.fnM);
            }
            this.fnN.removeAllViews();
            this.fnM.removeAllViews();
            if (this.fnN != null) {
                this.fnN.destroy();
                this.fnN = null;
            }
            if (this.fnM != null) {
                this.fnM.destroy();
                this.fnM = null;
            }
        } catch (Exception e) {
        }
    }
}
