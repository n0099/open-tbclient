package com.baidu.tieba.mainentrance.a;

import android.content.Context;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.quickWebView.QuickWebView;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.List;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes6.dex */
public class d {
    private ImageView dKQ;
    private EditText eFY;
    private ImageView eFZ;
    private TextView eGa;
    private BdListView hmC;
    private com.baidu.tieba.mainentrance.searchSuggestList.b hmE;
    private FrameLayout hmu;
    private LinearLayoutDetectsSoftKeyboard hnv;
    private QuickWebView hnw;
    private QuickWebView hnx;
    private com.baidu.tieba.mainentrance.searchSuggestList.a hny;
    View hnz;
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
        aJx();
        this.hnv = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.hnv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.hnv.setFocusable(true);
                    d.this.hnv.setFocusableInTouchMode(true);
                    if (d.this.eFY.hasFocus()) {
                        l.hideSoftKeyPad(d.this.mContext, d.this.eFY);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.hmu = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.hmu.addView(this.mNoDataView, 0);
        bKv();
        bJY();
        bKw();
        bKx();
    }

    private void aJx() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.hnz = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.dKQ = (ImageView) this.hnz.findViewById(R.id.search_bar_icon);
        this.eFY = (EditText) this.hnz.findViewById(R.id.home_et_search);
        this.eFZ = (ImageView) this.hnz.findViewById(R.id.home_bt_search_del);
        this.eGa = (TextView) this.hnz.findViewById(R.id.home_bt_search_cancel_s);
        this.eFZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.eFY.setText("");
            }
        });
        iy(false);
        this.eGa.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.eFY.getText().toString())) {
            this.hnz.setFocusable(true);
            this.hnz.setFocusableInTouchMode(true);
            this.hnz.requestFocus();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        am.setBgColor(this.hnv, i);
        if (i == 2) {
            this.eFY.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
        } else {
            this.eFY.setHintTextColor(am.getColor(R.color.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        SvgManager.amN().a(this.eFZ, R.drawable.icon_pure_search_empty_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.eFY, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.amN().a(this.dKQ, R.drawable.icon_pure_search_import_n_svg, R.color.cp_cont_d, null);
        am.setBackgroundResource(this.hmu, R.color.cp_bg_line_d);
        am.setViewTextColor(this.eGa, R.color.cp_link_tip_a, 1);
    }

    private void bKv() {
        this.hnx = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.hnx.pZ(true);
    }

    private void bJY() {
        this.hmC = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.hmE = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.hny = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void bKw() {
        this.hnw = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.hnw.pZ(true);
    }

    private void bKx() {
        this.eFY.setText("");
        this.eFY.requestFocus();
        this.eGa.setText(this.mContext.getString(R.string.cancel));
    }

    public void bKy() {
        this.hnx.setVisibility(0);
        this.hmC.setVisibility(8);
        this.hnw.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bKi() {
        this.hmC.setVisibility(8);
        this.hnx.setVisibility(8);
        this.hnw.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bKg() {
        this.hmC.setVisibility(0);
        this.hnx.setVisibility(8);
        this.hnw.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bKz() {
        this.hmC.setVisibility(8);
        this.hnx.setVisibility(8);
        this.hnw.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void iy(boolean z) {
        this.eFZ.setVisibility(z ? 0 : 8);
    }

    public void zm(String str) {
        if (!StringUtils.isNull(str)) {
            this.eFY.setHint(str);
        }
    }

    public void zn(String str) {
        if (!StringUtils.isNull(str)) {
            this.eFY.setText(str);
            this.eFY.setSelection(str.length());
        }
    }

    public void i(List<String> list, String str) {
        if (!v.isEmpty(list)) {
            bKg();
            this.hmE.ze(str);
            this.hmE.setData(list);
            this.hmC.setAdapter((ListAdapter) this.hmE);
        }
    }

    public void j(List<ForumInfo> list, String str) {
        if (!v.isEmpty(list) && !TextUtils.isEmpty(str)) {
            bKg();
            this.hny.ze(str);
            this.hny.dE(list);
            this.hmC.setAdapter((ListAdapter) this.hny);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.hmC.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.hmC.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.eFY.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.eFY.setOnEditorActionListener(onEditorActionListener);
    }

    public void f(TextWatcher textWatcher) {
        this.eFY.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eFY.setOnClickListener(onClickListener);
        this.eGa.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.hnw.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.hnw.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.hnw.setOnLoadUrlListener(bVar);
    }

    public EditText bKA() {
        return this.eFY;
    }

    public TextView bKB() {
        return this.eGa;
    }

    public QuickWebView bKC() {
        return this.hnw;
    }

    public QuickWebView bKD() {
        return this.hnx;
    }

    public boolean bKE() {
        return this.hmC.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.hmu != null) {
                this.hmu.removeView(this.hnx);
                this.hmu.removeView(this.hnw);
            }
            this.hnx.removeAllViews();
            this.hnw.removeAllViews();
            if (this.hnx != null) {
                this.hnx.destroy();
                this.hnx = null;
            }
            if (this.hnw != null) {
                this.hnw.destroy();
                this.hnw = null;
            }
        } catch (Exception e) {
        }
    }
}
