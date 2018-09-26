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
    private ImageView bMT;
    private ImageView dqM;
    private FrameLayout fdN;
    private TextView fdP;
    private BdListView fdW;
    private com.baidu.tieba.mainentrance.searchSuggestList.a fdY;
    private EditText feJ;
    private LinearLayoutDetectsSoftKeyboard feK;
    private QuickWebView feL;
    private QuickWebView feM;
    View feN;
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
        atZ();
        this.feK = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(e.g.search_container);
        this.feK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.feK.setFocusable(true);
                    d.this.feK.setFocusableInTouchMode(true);
                    if (d.this.feJ.hasFocus()) {
                        l.a(d.this.mContext, d.this.feJ);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.fdN = (FrameLayout) this.mRootView.findViewById(e.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(e.C0141e.ds200)), null, null);
        this.fdN.addView(this.mNoDataView, 0);
        aVI();
        aVl();
        aVJ();
        aVK();
    }

    private void atZ() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.feN = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, e.h.square_search_navigation_view, (View.OnClickListener) null);
        this.bMT = (ImageView) this.feN.findViewById(e.g.search_bar_icon);
        this.feJ = (EditText) this.feN.findViewById(e.g.home_et_search);
        this.dqM = (ImageView) this.feN.findViewById(e.g.home_bt_search_del);
        this.fdP = (TextView) this.feN.findViewById(e.g.home_bt_search_cancel_s);
        this.dqM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.feJ.setText("");
            }
        });
        ht(false);
        this.fdP.setText(this.mContext.getString(e.j.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.feJ.getText().toString())) {
            this.feN.setFocusable(true);
            this.feN.setFocusableInTouchMode(true);
            this.feN.requestFocus();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        al.e(this.feK, i);
        if (i == 2) {
            this.feJ.setHintTextColor(al.getColor(e.d.s_navbar_title_color));
        } else {
            this.feJ.setHintTextColor(al.getColor(e.d.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        al.c(this.dqM, e.f.del_search_btn);
        al.b(this.feJ, e.d.cp_cont_b, e.d.s_navbar_title_color);
        al.c(this.bMT, e.f.icon_search);
        al.i(this.fdN, e.d.cp_bg_line_d);
        al.c(this.fdP, e.d.cp_link_tip_a, 1);
    }

    private void aVI() {
        this.feM = (QuickWebView) this.mRootView.findViewById(e.g.search_history_webview);
        this.feM.mc(true);
    }

    private void aVl() {
        this.fdW = (BdListView) this.mRootView.findViewById(e.g.home_lv_search_suggest);
        this.fdY = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
        this.fdW.setAdapter((ListAdapter) this.fdY);
    }

    private void aVJ() {
        this.feL = (QuickWebView) this.mRootView.findViewById(e.g.search_result_webview);
        this.feL.mc(true);
    }

    private void aVK() {
        this.feJ.setText("");
        this.feJ.requestFocus();
        this.fdP.setText(this.mContext.getString(e.j.cancel));
    }

    public void aVL() {
        this.feM.setVisibility(0);
        this.fdW.setVisibility(8);
        this.feL.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aVv() {
        this.fdW.setVisibility(8);
        this.feM.setVisibility(8);
        this.feL.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aVt() {
        this.fdW.setVisibility(0);
        this.feM.setVisibility(8);
        this.feL.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aVM() {
        this.fdW.setVisibility(8);
        this.feM.setVisibility(8);
        this.feL.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void ht(boolean z) {
        this.dqM.setVisibility(z ? 0 : 8);
    }

    public void qp(String str) {
        if (!StringUtils.isNull(str)) {
            this.feJ.setHint(str);
        }
    }

    public void qq(String str) {
        if (!StringUtils.isNull(str)) {
            this.feJ.setText(str);
            this.feJ.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!v.z(list)) {
            aVt();
            this.fdY.qh(str);
            this.fdY.setData(list);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.fdW.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.fdW.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.feJ.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.feJ.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.feJ.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.feJ.setOnClickListener(onClickListener);
        this.fdP.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.feL.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.feL.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.feL.setOnLoadUrlListener(bVar);
    }

    public EditText aVN() {
        return this.feJ;
    }

    public TextView aVO() {
        return this.fdP;
    }

    public QuickWebView aVP() {
        return this.feL;
    }

    public QuickWebView aVQ() {
        return this.feM;
    }

    public boolean aVR() {
        return this.fdW.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.fdN != null) {
                this.fdN.removeView(this.feM);
                this.fdN.removeView(this.feL);
            }
            this.feM.removeAllViews();
            this.feL.removeAllViews();
            if (this.feM != null) {
                this.feM.destroy();
                this.feM = null;
            }
            if (this.feL != null) {
                this.feL.destroy();
                this.feL = null;
            }
        } catch (Exception e) {
        }
    }
}
