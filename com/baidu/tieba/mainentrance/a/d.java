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
    private ImageView clw;
    private ImageView dDc;
    private FrameLayout fhI;
    private TextView fhK;
    private BdListView fhR;
    private com.baidu.tieba.mainentrance.searchSuggestList.a fhT;
    private EditText fiH;
    private LinearLayoutDetectsSoftKeyboard fiI;
    private QuickWebView fiJ;
    private QuickWebView fiK;
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
        awO();
        this.fiI = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(d.g.search_container);
        this.fiI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.fiI.setFocusable(true);
                    d.this.fiI.setFocusableInTouchMode(true);
                    if (d.this.fiH.hasFocus()) {
                        l.a(d.this.mContext, d.this.fiH);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.fhI = (FrameLayout) this.mRootView.findViewById(d.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds200)), null, null);
        this.fhI.addView(this.mNoDataView, 0);
        aRW();
        aRA();
        aRX();
        aRY();
    }

    private void awO() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.square_search_navigation_view, (View.OnClickListener) null);
        this.clw = (ImageView) addCustomView.findViewById(d.g.search_bar_icon);
        this.fiH = (EditText) addCustomView.findViewById(d.g.home_et_search);
        this.dDc = (ImageView) addCustomView.findViewById(d.g.home_bt_search_del);
        this.fhK = (TextView) addCustomView.findViewById(d.g.home_bt_search_cancel_s);
        this.dDc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.fiH.setText("");
            }
        });
        iL(false);
        this.fhK.setText(this.mContext.getString(d.j.cancel));
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        aj.o(this.fiI, i);
        if (i == 2) {
            this.fiH.setHintTextColor(aj.getColor(d.C0141d.s_navbar_title_color));
        } else {
            this.fiH.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        aj.c(this.dDc, d.f.del_search_btn);
        aj.d(this.fiH, d.C0141d.cp_cont_b, d.C0141d.s_navbar_title_color);
        aj.c(this.clw, d.f.icon_search);
        aj.s(this.fhI, d.C0141d.cp_bg_line_d);
        aj.e(this.fhK, d.C0141d.cp_link_tip_a, 1);
    }

    private void aRW() {
        this.fiK = (QuickWebView) this.mRootView.findViewById(d.g.search_history_webview);
        this.fiK.mb(true);
    }

    private void aRA() {
        this.fhR = (BdListView) this.mRootView.findViewById(d.g.home_lv_search_suggest);
        this.fhT = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
        this.fhR.setAdapter((ListAdapter) this.fhT);
    }

    private void aRX() {
        this.fiJ = (QuickWebView) this.mRootView.findViewById(d.g.search_result_webview);
        this.fiJ.mb(true);
    }

    private void aRY() {
        this.fiH.setText("");
        this.fiH.requestFocus();
        this.fhK.setText(this.mContext.getString(d.j.cancel));
    }

    public void aRZ() {
        this.fiK.setVisibility(0);
        this.fhR.setVisibility(8);
        this.fiJ.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aRK() {
        this.fhR.setVisibility(8);
        this.fiK.setVisibility(8);
        this.fiJ.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aRI() {
        this.fhR.setVisibility(0);
        this.fiK.setVisibility(8);
        this.fiJ.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aSa() {
        this.fhR.setVisibility(8);
        this.fiK.setVisibility(8);
        this.fiJ.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void iL(boolean z) {
        this.dDc.setVisibility(z ? 0 : 8);
    }

    public void oK(String str) {
        if (!StringUtils.isNull(str)) {
            this.fiH.setHint(str);
        }
    }

    public void oL(String str) {
        if (!StringUtils.isNull(str)) {
            this.fiH.setText(str);
            this.fiH.setSelection(str.length());
        }
    }

    public void i(List<String> list, String str) {
        if (!v.E(list)) {
            aRI();
            this.fhT.oC(str);
            this.fhT.setData(list);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.fhR.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.fhR.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.fiH.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.fiH.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.fiH.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fiH.setOnClickListener(onClickListener);
        this.fhK.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.fiJ.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.fiJ.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.fiJ.setOnLoadUrlListener(bVar);
    }

    public EditText aSb() {
        return this.fiH;
    }

    public TextView aSc() {
        return this.fhK;
    }

    public QuickWebView aSd() {
        return this.fiJ;
    }

    public QuickWebView aSe() {
        return this.fiK;
    }

    public boolean aSf() {
        return this.fhR.getVisibility() == 0;
    }

    public void onDestroy() {
        if (this.fhI != null) {
            this.fhI.removeView(this.fiK);
            this.fhI.removeView(this.fiJ);
        }
        if (this.fiK != null) {
            this.fiK.destroy();
        }
        if (this.fiJ != null) {
            this.fiJ.destroy();
        }
    }
}
