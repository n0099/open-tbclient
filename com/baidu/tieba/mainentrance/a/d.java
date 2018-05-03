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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
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
    private ImageView bvG;
    private ImageView cVU;
    private FrameLayout eCk;
    private TextView eCm;
    private BdListView eCt;
    private com.baidu.tieba.mainentrance.searchSuggestList.a eCv;
    private EditText eDh;
    private LinearLayoutDetectsSoftKeyboard eDi;
    private QuickWebView eDj;
    private QuickWebView eDk;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public d(View view2, Context context) {
        this.mRootView = view2;
        this.mContext = context;
        initView();
    }

    private void initView() {
        are();
        this.eDi = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(d.g.search_container);
        this.eDi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.eDi.setFocusable(true);
                    d.this.eDi.setFocusableInTouchMode(true);
                    if (d.this.eDh.hasFocus()) {
                        l.b(d.this.mContext, d.this.eDh);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.eCk = (FrameLayout) this.mRootView.findViewById(d.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds200)), null, null);
        this.eCk.addView(this.mNoDataView, 0);
        aMS();
        aMw();
        aMT();
        aMU();
    }

    private void are() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.i.square_search_navigation_view, (View.OnClickListener) null);
        this.bvG = (ImageView) addCustomView.findViewById(d.g.search_bar_icon);
        this.eDh = (EditText) addCustomView.findViewById(d.g.home_et_search);
        this.cVU = (ImageView) addCustomView.findViewById(d.g.home_bt_search_del);
        this.eCm = (TextView) addCustomView.findViewById(d.g.home_bt_search_cancel_s);
        this.cVU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.eDh.setText("");
            }
        });
        gB(false);
        this.eCm.setText(this.mContext.getString(d.k.cancel));
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        ak.e(this.eDi, i);
        if (i == 2) {
            this.eDh.setHintTextColor(ak.getColor(d.C0126d.s_navbar_title_color));
        } else {
            this.eDh.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        ak.c(this.cVU, d.f.del_search_btn);
        ak.b(this.eDh, d.C0126d.cp_cont_b, d.C0126d.s_navbar_title_color);
        ak.c(this.bvG, d.f.icon_search);
        ak.i(this.eCk, d.C0126d.cp_bg_line_d);
        ak.c(this.eCm, d.C0126d.cp_link_tip_a, 1);
    }

    private void aMS() {
        this.eDk = (QuickWebView) this.mRootView.findViewById(d.g.search_history_webview);
        this.eDk.lB(true);
    }

    private void aMw() {
        this.eCt = (BdListView) this.mRootView.findViewById(d.g.home_lv_search_suggest);
        this.eCv = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
        this.eCt.setAdapter((ListAdapter) this.eCv);
    }

    private void aMT() {
        this.eDj = (QuickWebView) this.mRootView.findViewById(d.g.search_result_webview);
        this.eDj.lB(true);
    }

    private void aMU() {
        this.eDh.setText("");
        this.eDh.requestFocus();
        this.eCm.setText(this.mContext.getString(d.k.cancel));
    }

    public void aMV() {
        this.eDk.setVisibility(0);
        this.eCt.setVisibility(8);
        this.eDj.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aMG() {
        this.eCt.setVisibility(8);
        this.eDk.setVisibility(8);
        this.eDj.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aME() {
        this.eCt.setVisibility(0);
        this.eDk.setVisibility(8);
        this.eDj.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aMW() {
        this.eCt.setVisibility(8);
        this.eDk.setVisibility(8);
        this.eDj.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void gB(boolean z) {
        this.cVU.setVisibility(z ? 0 : 8);
    }

    public void oP(String str) {
        if (!StringUtils.isNull(str)) {
            this.eDh.setHint(str);
        }
    }

    public void oQ(String str) {
        if (!StringUtils.isNull(str)) {
            this.eDh.setText(str);
            this.eDh.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!v.w(list)) {
            aME();
            this.eCv.oH(str);
            this.eCv.setData(list);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.eCt.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.eCt.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.eDh.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.eDh.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.eDh.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eDh.setOnClickListener(onClickListener);
        this.eCm.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.eDj.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.eDj.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.eDj.setOnLoadUrlListener(bVar);
    }

    public EditText aMX() {
        return this.eDh;
    }

    public TextView aMY() {
        return this.eCm;
    }

    public QuickWebView aMZ() {
        return this.eDj;
    }

    public QuickWebView aNa() {
        return this.eDk;
    }

    public boolean aNb() {
        return this.eCt.getVisibility() == 0;
    }

    public void onDestroy() {
        if (this.eCk != null) {
            this.eCk.removeView(this.eDk);
            this.eCk.removeView(this.eDj);
        }
        if (this.eDk != null) {
            this.eDk.destroy();
        }
        if (this.eDj != null) {
            this.eDj.destroy();
        }
    }
}
