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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.d;
import com.baidu.tieba.quickWebView.QuickWebView;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private ImageView bHe;
    private ImageView dkV;
    private TextView eWA;
    private BdListView eWH;
    private com.baidu.tieba.mainentrance.searchSuggestList.a eWJ;
    private FrameLayout eWy;
    private EditText eXu;
    private LinearLayoutDetectsSoftKeyboard eXv;
    private QuickWebView eXw;
    private QuickWebView eXx;
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
        asl();
        this.eXv = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(d.g.search_container);
        this.eXv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.eXv.setFocusable(true);
                    d.this.eXv.setFocusableInTouchMode(true);
                    if (d.this.eXu.hasFocus()) {
                        l.a(d.this.mContext, d.this.eXu);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.eWy = (FrameLayout) this.mRootView.findViewById(d.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds200)), null, null);
        this.eWy.addView(this.mNoDataView, 0);
        aTx();
        aTa();
        aTy();
        aTz();
    }

    private void asl() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.square_search_navigation_view, (View.OnClickListener) null);
        this.bHe = (ImageView) addCustomView.findViewById(d.g.search_bar_icon);
        this.eXu = (EditText) addCustomView.findViewById(d.g.home_et_search);
        this.dkV = (ImageView) addCustomView.findViewById(d.g.home_bt_search_del);
        this.eWA = (TextView) addCustomView.findViewById(d.g.home_bt_search_cancel_s);
        this.dkV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.eXu.setText("");
            }
        });
        gV(false);
        this.eWA.setText(this.mContext.getString(d.j.cancel));
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        am.e(this.eXv, i);
        if (i == 2) {
            this.eXu.setHintTextColor(am.getColor(d.C0140d.s_navbar_title_color));
        } else {
            this.eXu.setHintTextColor(am.getColor(d.C0140d.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        am.c(this.dkV, d.f.del_search_btn);
        am.b(this.eXu, d.C0140d.cp_cont_b, d.C0140d.s_navbar_title_color);
        am.c(this.bHe, d.f.icon_search);
        am.i(this.eWy, d.C0140d.cp_bg_line_d);
        am.c(this.eWA, d.C0140d.cp_link_tip_a, 1);
    }

    private void aTx() {
        this.eXx = (QuickWebView) this.mRootView.findViewById(d.g.search_history_webview);
        this.eXx.lD(true);
    }

    private void aTa() {
        this.eWH = (BdListView) this.mRootView.findViewById(d.g.home_lv_search_suggest);
        this.eWJ = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
        this.eWH.setAdapter((ListAdapter) this.eWJ);
    }

    private void aTy() {
        this.eXw = (QuickWebView) this.mRootView.findViewById(d.g.search_result_webview);
        this.eXw.lD(true);
    }

    private void aTz() {
        this.eXu.setText("");
        this.eXu.requestFocus();
        this.eWA.setText(this.mContext.getString(d.j.cancel));
    }

    public void aTA() {
        this.eXx.setVisibility(0);
        this.eWH.setVisibility(8);
        this.eXw.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aTk() {
        this.eWH.setVisibility(8);
        this.eXx.setVisibility(8);
        this.eXw.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aTi() {
        this.eWH.setVisibility(0);
        this.eXx.setVisibility(8);
        this.eXw.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aTB() {
        this.eWH.setVisibility(8);
        this.eXx.setVisibility(8);
        this.eXw.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void gV(boolean z) {
        this.dkV.setVisibility(z ? 0 : 8);
    }

    public void pI(String str) {
        if (!StringUtils.isNull(str)) {
            this.eXu.setHint(str);
        }
    }

    public void pJ(String str) {
        if (!StringUtils.isNull(str)) {
            this.eXu.setText(str);
            this.eXu.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!w.z(list)) {
            aTi();
            this.eWJ.pA(str);
            this.eWJ.setData(list);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.eWH.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.eWH.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.eXu.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.eXu.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.eXu.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eXu.setOnClickListener(onClickListener);
        this.eWA.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.eXw.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.eXw.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.eXw.setOnLoadUrlListener(bVar);
    }

    public EditText aTC() {
        return this.eXu;
    }

    public TextView aTD() {
        return this.eWA;
    }

    public QuickWebView aTE() {
        return this.eXw;
    }

    public QuickWebView aTF() {
        return this.eXx;
    }

    public boolean aTG() {
        return this.eWH.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.eWy != null) {
                this.eWy.removeView(this.eXx);
                this.eWy.removeView(this.eXw);
            }
            this.eXx.removeAllViews();
            this.eXw.removeAllViews();
            if (this.eXx != null) {
                this.eXx.destroy();
                this.eXx = null;
            }
            if (this.eXw != null) {
                this.eXw.destroy();
                this.eXw = null;
            }
        } catch (Exception e) {
        }
    }
}
