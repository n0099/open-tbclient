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
    private ImageView clt;
    private ImageView dCZ;
    private BdListView fhB;
    private com.baidu.tieba.mainentrance.searchSuggestList.a fhD;
    private FrameLayout fhs;
    private TextView fhu;
    private EditText fiq;
    private LinearLayoutDetectsSoftKeyboard fir;
    private QuickWebView fis;
    private QuickWebView fit;
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
        awM();
        this.fir = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(d.g.search_container);
        this.fir.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.fir.setFocusable(true);
                    d.this.fir.setFocusableInTouchMode(true);
                    if (d.this.fiq.hasFocus()) {
                        l.a(d.this.mContext, d.this.fiq);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.fhs = (FrameLayout) this.mRootView.findViewById(d.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds200)), null, null);
        this.fhs.addView(this.mNoDataView, 0);
        aRV();
        aRz();
        aRW();
        aRX();
    }

    private void awM() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.square_search_navigation_view, (View.OnClickListener) null);
        this.clt = (ImageView) addCustomView.findViewById(d.g.search_bar_icon);
        this.fiq = (EditText) addCustomView.findViewById(d.g.home_et_search);
        this.dCZ = (ImageView) addCustomView.findViewById(d.g.home_bt_search_del);
        this.fhu = (TextView) addCustomView.findViewById(d.g.home_bt_search_cancel_s);
        this.dCZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.fiq.setText("");
            }
        });
        iG(false);
        this.fhu.setText(this.mContext.getString(d.j.cancel));
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        aj.o(this.fir, i);
        if (i == 2) {
            this.fiq.setHintTextColor(aj.getColor(d.C0141d.s_navbar_title_color));
        } else {
            this.fiq.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        aj.c(this.dCZ, d.f.del_search_btn);
        aj.d(this.fiq, d.C0141d.cp_cont_b, d.C0141d.s_navbar_title_color);
        aj.c(this.clt, d.f.icon_search);
        aj.s(this.fhs, d.C0141d.cp_bg_line_d);
        aj.e(this.fhu, d.C0141d.cp_link_tip_a, 1);
    }

    private void aRV() {
        this.fit = (QuickWebView) this.mRootView.findViewById(d.g.search_history_webview);
        this.fit.lW(true);
    }

    private void aRz() {
        this.fhB = (BdListView) this.mRootView.findViewById(d.g.home_lv_search_suggest);
        this.fhD = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
        this.fhB.setAdapter((ListAdapter) this.fhD);
    }

    private void aRW() {
        this.fis = (QuickWebView) this.mRootView.findViewById(d.g.search_result_webview);
        this.fis.lW(true);
    }

    private void aRX() {
        this.fiq.setText("");
        this.fiq.requestFocus();
        this.fhu.setText(this.mContext.getString(d.j.cancel));
    }

    public void aRY() {
        this.fit.setVisibility(0);
        this.fhB.setVisibility(8);
        this.fis.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aRJ() {
        this.fhB.setVisibility(8);
        this.fit.setVisibility(8);
        this.fis.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aRH() {
        this.fhB.setVisibility(0);
        this.fit.setVisibility(8);
        this.fis.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aRZ() {
        this.fhB.setVisibility(8);
        this.fit.setVisibility(8);
        this.fis.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void iG(boolean z) {
        this.dCZ.setVisibility(z ? 0 : 8);
    }

    public void oK(String str) {
        if (!StringUtils.isNull(str)) {
            this.fiq.setHint(str);
        }
    }

    public void oL(String str) {
        if (!StringUtils.isNull(str)) {
            this.fiq.setText(str);
            this.fiq.setSelection(str.length());
        }
    }

    public void i(List<String> list, String str) {
        if (!v.E(list)) {
            aRH();
            this.fhD.oC(str);
            this.fhD.setData(list);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.fhB.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.fhB.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.fiq.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.fiq.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.fiq.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fiq.setOnClickListener(onClickListener);
        this.fhu.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.fis.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.fis.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.fis.setOnLoadUrlListener(bVar);
    }

    public EditText aSa() {
        return this.fiq;
    }

    public TextView aSb() {
        return this.fhu;
    }

    public QuickWebView aSc() {
        return this.fis;
    }

    public QuickWebView aSd() {
        return this.fit;
    }

    public boolean aSe() {
        return this.fhB.getVisibility() == 0;
    }

    public void onDestroy() {
        if (this.fhs != null) {
            this.fhs.removeView(this.fit);
            this.fhs.removeView(this.fis);
        }
        if (this.fit != null) {
            this.fit.destroy();
        }
        if (this.fis != null) {
            this.fis.destroy();
        }
    }
}
