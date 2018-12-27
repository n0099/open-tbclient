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
    private ImageView cae;
    private ImageView dJr;
    private TextView fwA;
    private BdListView fwH;
    private com.baidu.tieba.mainentrance.searchSuggestList.a fwJ;
    private FrameLayout fwy;
    private EditText fxu;
    private LinearLayoutDetectsSoftKeyboard fxv;
    private QuickWebView fxw;
    private QuickWebView fxx;
    View fxy;
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
        azu();
        this.fxv = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(e.g.search_container);
        this.fxv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.fxv.setFocusable(true);
                    d.this.fxv.setFocusableInTouchMode(true);
                    if (d.this.fxu.hasFocus()) {
                        l.b(d.this.mContext, d.this.fxu);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.fwy = (FrameLayout) this.mRootView.findViewById(e.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(e.C0210e.ds200)), null, null);
        this.fwy.addView(this.mNoDataView, 0);
        baX();
        baA();
        baY();
        baZ();
    }

    private void azu() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.fxy = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, e.h.square_search_navigation_view, (View.OnClickListener) null);
        this.cae = (ImageView) this.fxy.findViewById(e.g.search_bar_icon);
        this.fxu = (EditText) this.fxy.findViewById(e.g.home_et_search);
        this.dJr = (ImageView) this.fxy.findViewById(e.g.home_bt_search_del);
        this.fwA = (TextView) this.fxy.findViewById(e.g.home_bt_search_cancel_s);
        this.dJr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.fxu.setText("");
            }
        });
        ia(false);
        this.fwA.setText(this.mContext.getString(e.j.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.fxu.getText().toString())) {
            this.fxy.setFocusable(true);
            this.fxy.setFocusableInTouchMode(true);
            this.fxy.requestFocus();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        al.e(this.fxv, i);
        if (i == 2) {
            this.fxu.setHintTextColor(al.getColor(e.d.s_navbar_title_color));
        } else {
            this.fxu.setHintTextColor(al.getColor(e.d.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        al.c(this.dJr, e.f.del_search_btn);
        al.b(this.fxu, e.d.cp_cont_b, e.d.s_navbar_title_color);
        al.c(this.cae, e.f.icon_search);
        al.i(this.fwy, e.d.cp_bg_line_d);
        al.c(this.fwA, e.d.cp_link_tip_a, 1);
    }

    private void baX() {
        this.fxx = (QuickWebView) this.mRootView.findViewById(e.g.search_history_webview);
        this.fxx.mL(true);
    }

    private void baA() {
        this.fwH = (BdListView) this.mRootView.findViewById(e.g.home_lv_search_suggest);
        this.fwJ = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
        this.fwH.setAdapter((ListAdapter) this.fwJ);
    }

    private void baY() {
        this.fxw = (QuickWebView) this.mRootView.findViewById(e.g.search_result_webview);
        this.fxw.mL(true);
    }

    private void baZ() {
        this.fxu.setText("");
        this.fxu.requestFocus();
        this.fwA.setText(this.mContext.getString(e.j.cancel));
    }

    public void bba() {
        this.fxx.setVisibility(0);
        this.fwH.setVisibility(8);
        this.fxw.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void baK() {
        this.fwH.setVisibility(8);
        this.fxx.setVisibility(8);
        this.fxw.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void baI() {
        this.fwH.setVisibility(0);
        this.fxx.setVisibility(8);
        this.fxw.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bbb() {
        this.fwH.setVisibility(8);
        this.fxx.setVisibility(8);
        this.fxw.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void ia(boolean z) {
        this.dJr.setVisibility(z ? 0 : 8);
    }

    public void rx(String str) {
        if (!StringUtils.isNull(str)) {
            this.fxu.setHint(str);
        }
    }

    public void ry(String str) {
        if (!StringUtils.isNull(str)) {
            this.fxu.setText(str);
            this.fxu.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!v.I(list)) {
            baI();
            this.fwJ.rp(str);
            this.fwJ.setData(list);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.fwH.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.fwH.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.fxu.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.fxu.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.fxu.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fxu.setOnClickListener(onClickListener);
        this.fwA.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.fxw.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.fxw.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.fxw.setOnLoadUrlListener(bVar);
    }

    public EditText bbc() {
        return this.fxu;
    }

    public TextView bbd() {
        return this.fwA;
    }

    public QuickWebView bbe() {
        return this.fxw;
    }

    public QuickWebView bbf() {
        return this.fxx;
    }

    public boolean bbg() {
        return this.fwH.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.fwy != null) {
                this.fwy.removeView(this.fxx);
                this.fwy.removeView(this.fxw);
            }
            this.fxx.removeAllViews();
            this.fxw.removeAllViews();
            if (this.fxx != null) {
                this.fxx.destroy();
                this.fxx = null;
            }
            if (this.fxw != null) {
                this.fxw.destroy();
                this.fxw = null;
            }
        } catch (Exception e) {
        }
    }
}
