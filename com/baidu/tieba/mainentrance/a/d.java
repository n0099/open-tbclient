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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.d;
import com.baidu.tieba.quickWebView.QuickWebView;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private ImageView clF;
    private ImageView dDl;
    private FrameLayout fhE;
    private TextView fhG;
    private BdListView fhN;
    private com.baidu.tieba.mainentrance.searchSuggestList.a fhP;
    private EditText fiD;
    private LinearLayoutDetectsSoftKeyboard fiE;
    private QuickWebView fiF;
    private QuickWebView fiG;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private View mRootView;

    public d(View view, Context context) {
        this.mRootView = view;
        this.mContext = context;
        initView();
    }

    private void initView() {
        awN();
        this.fiE = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(d.g.search_container);
        this.fiE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.fiE.setFocusable(true);
                    d.this.fiE.setFocusableInTouchMode(true);
                    if (d.this.fiD.hasFocus()) {
                        l.a(d.this.mContext, d.this.fiD);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.fhE = (FrameLayout) this.mRootView.findViewById(d.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds200)), null, null);
        this.fhE.addView(this.mNoDataView, 0);
        aRW();
        aRA();
        aRX();
        aRY();
    }

    private void awN() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.square_search_navigation_view, (View.OnClickListener) null);
        this.clF = (ImageView) addCustomView.findViewById(d.g.search_bar_icon);
        this.fiD = (EditText) addCustomView.findViewById(d.g.home_et_search);
        this.dDl = (ImageView) addCustomView.findViewById(d.g.home_bt_search_del);
        this.fhG = (TextView) addCustomView.findViewById(d.g.home_bt_search_cancel_s);
        this.dDl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.fiD.setText("");
            }
        });
        iG(false);
        this.fhG.setText(this.mContext.getString(d.j.cancel));
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        aj.o(this.fiE, i);
        if (i == 2) {
            this.fiD.setHintTextColor(aj.getColor(d.C0140d.s_navbar_title_color));
        } else {
            this.fiD.setHintTextColor(aj.getColor(d.C0140d.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        aj.c(this.dDl, d.f.del_search_btn);
        aj.d(this.fiD, d.C0140d.cp_cont_b, d.C0140d.s_navbar_title_color);
        aj.c(this.clF, d.f.icon_search);
        aj.s(this.fhE, d.C0140d.cp_bg_line_d);
        aj.e(this.fhG, d.C0140d.cp_link_tip_a, 1);
    }

    private void aRW() {
        this.fiG = (QuickWebView) this.mRootView.findViewById(d.g.search_history_webview);
        this.fiG.lW(true);
    }

    private void aRA() {
        this.fhN = (BdListView) this.mRootView.findViewById(d.g.home_lv_search_suggest);
        this.fhP = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
        this.fhN.setAdapter((ListAdapter) this.fhP);
    }

    private void aRX() {
        this.fiF = (QuickWebView) this.mRootView.findViewById(d.g.search_result_webview);
        this.fiF.lW(true);
    }

    private void aRY() {
        this.fiD.setText("");
        this.fiD.requestFocus();
        this.fhG.setText(this.mContext.getString(d.j.cancel));
    }

    public void aRZ() {
        this.fiG.setVisibility(0);
        this.fhN.setVisibility(8);
        this.fiF.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aRK() {
        this.fhN.setVisibility(8);
        this.fiG.setVisibility(8);
        this.fiF.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aRI() {
        this.fhN.setVisibility(0);
        this.fiG.setVisibility(8);
        this.fiF.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aSa() {
        this.fhN.setVisibility(8);
        this.fiG.setVisibility(8);
        this.fiF.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void iG(boolean z) {
        this.dDl.setVisibility(z ? 0 : 8);
    }

    public void oK(String str) {
        if (!StringUtils.isNull(str)) {
            this.fiD.setHint(str);
        }
    }

    public void oL(String str) {
        if (!StringUtils.isNull(str)) {
            this.fiD.setText(str);
            this.fiD.setSelection(str.length());
        }
    }

    public void i(List<String> list, String str) {
        if (!v.E(list)) {
            aRI();
            this.fhP.oC(str);
            this.fhP.setData(list);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.fhN.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.fhN.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.fiD.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.fiD.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.fiD.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fiD.setOnClickListener(onClickListener);
        this.fhG.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.fiF.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.fiF.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.fiF.setOnLoadUrlListener(bVar);
    }

    public EditText aSb() {
        return this.fiD;
    }

    public TextView aSc() {
        return this.fhG;
    }

    public QuickWebView aSd() {
        return this.fiF;
    }

    public QuickWebView aSe() {
        return this.fiG;
    }

    public boolean aSf() {
        return this.fhN.getVisibility() == 0;
    }

    public void onDestroy() {
        if (this.fhE != null) {
            this.fhE.removeView(this.fiG);
            this.fhE.removeView(this.fiF);
        }
        if (this.fiG != null) {
            this.fiG.destroy();
        }
        if (this.fiF != null) {
            this.fiF.destroy();
        }
    }
}
