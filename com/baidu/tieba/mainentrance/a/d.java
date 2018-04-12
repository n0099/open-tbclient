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
    private ImageView cVX;
    private FrameLayout eCn;
    private TextView eCp;
    private BdListView eCw;
    private com.baidu.tieba.mainentrance.searchSuggestList.a eCy;
    private EditText eDk;
    private LinearLayoutDetectsSoftKeyboard eDl;
    private QuickWebView eDm;
    private QuickWebView eDn;
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
        this.eDl = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(d.g.search_container);
        this.eDl.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.eDl.setFocusable(true);
                    d.this.eDl.setFocusableInTouchMode(true);
                    if (d.this.eDk.hasFocus()) {
                        l.b(d.this.mContext, d.this.eDk);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.eCn = (FrameLayout) this.mRootView.findViewById(d.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds200)), null, null);
        this.eCn.addView(this.mNoDataView, 0);
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
        this.eDk = (EditText) addCustomView.findViewById(d.g.home_et_search);
        this.cVX = (ImageView) addCustomView.findViewById(d.g.home_bt_search_del);
        this.eCp = (TextView) addCustomView.findViewById(d.g.home_bt_search_cancel_s);
        this.cVX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.eDk.setText("");
            }
        });
        gB(false);
        this.eCp.setText(this.mContext.getString(d.k.cancel));
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        ak.e(this.eDl, i);
        if (i == 2) {
            this.eDk.setHintTextColor(ak.getColor(d.C0126d.s_navbar_title_color));
        } else {
            this.eDk.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        ak.c(this.cVX, d.f.del_search_btn);
        ak.b(this.eDk, d.C0126d.cp_cont_b, d.C0126d.s_navbar_title_color);
        ak.c(this.bvG, d.f.icon_search);
        ak.i(this.eCn, d.C0126d.cp_bg_line_d);
        ak.c(this.eCp, d.C0126d.cp_link_tip_a, 1);
    }

    private void aMS() {
        this.eDn = (QuickWebView) this.mRootView.findViewById(d.g.search_history_webview);
        this.eDn.lB(true);
    }

    private void aMw() {
        this.eCw = (BdListView) this.mRootView.findViewById(d.g.home_lv_search_suggest);
        this.eCy = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
        this.eCw.setAdapter((ListAdapter) this.eCy);
    }

    private void aMT() {
        this.eDm = (QuickWebView) this.mRootView.findViewById(d.g.search_result_webview);
        this.eDm.lB(true);
    }

    private void aMU() {
        this.eDk.setText("");
        this.eDk.requestFocus();
        this.eCp.setText(this.mContext.getString(d.k.cancel));
    }

    public void aMV() {
        this.eDn.setVisibility(0);
        this.eCw.setVisibility(8);
        this.eDm.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aMG() {
        this.eCw.setVisibility(8);
        this.eDn.setVisibility(8);
        this.eDm.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aME() {
        this.eCw.setVisibility(0);
        this.eDn.setVisibility(8);
        this.eDm.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aMW() {
        this.eCw.setVisibility(8);
        this.eDn.setVisibility(8);
        this.eDm.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void gB(boolean z) {
        this.cVX.setVisibility(z ? 0 : 8);
    }

    public void oP(String str) {
        if (!StringUtils.isNull(str)) {
            this.eDk.setHint(str);
        }
    }

    public void oQ(String str) {
        if (!StringUtils.isNull(str)) {
            this.eDk.setText(str);
            this.eDk.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!v.w(list)) {
            aME();
            this.eCy.oH(str);
            this.eCy.setData(list);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.eCw.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.eCw.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.eDk.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.eDk.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.eDk.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eDk.setOnClickListener(onClickListener);
        this.eCp.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.eDm.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.eDm.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.eDm.setOnLoadUrlListener(bVar);
    }

    public EditText aMX() {
        return this.eDk;
    }

    public TextView aMY() {
        return this.eCp;
    }

    public QuickWebView aMZ() {
        return this.eDm;
    }

    public QuickWebView aNa() {
        return this.eDn;
    }

    public boolean aNb() {
        return this.eCw.getVisibility() == 0;
    }

    public void onDestroy() {
        if (this.eCn != null) {
            this.eCn.removeView(this.eDn);
            this.eCn.removeView(this.eDm);
        }
        if (this.eDn != null) {
            this.eDn.destroy();
        }
        if (this.eDm != null) {
            this.eDm.destroy();
        }
    }
}
