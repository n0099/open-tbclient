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
/* loaded from: classes8.dex */
public class d {
    private ImageView eyp;
    private EditText fxf;
    private ImageView fxg;
    private TextView fxh;
    private FrameLayout hZD;
    private BdListView hZL;
    private com.baidu.tieba.mainentrance.searchSuggestList.b hZN;
    private LinearLayoutDetectsSoftKeyboard iaE;
    private QuickWebView iaF;
    private QuickWebView iaG;
    private View iaH;
    private com.baidu.tieba.mainentrance.searchSuggestList.a iaI;
    View iaJ;
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
        aZT();
        this.iaE = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.iaE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.iaE.setFocusable(true);
                    d.this.iaE.setFocusableInTouchMode(true);
                    if (d.this.fxf.hasFocus()) {
                        l.hideSoftKeyPad(d.this.mContext, d.this.fxf);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.hZD = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.hZD.addView(this.mNoDataView, 0);
        cbH();
        cbj();
        cbI();
        cbJ();
    }

    private void aZT() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.iaJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.eyp = (ImageView) this.iaJ.findViewById(R.id.search_bar_icon);
        this.fxf = (EditText) this.iaJ.findViewById(R.id.home_et_search);
        this.fxg = (ImageView) this.iaJ.findViewById(R.id.home_bt_search_del);
        this.fxh = (TextView) this.iaJ.findViewById(R.id.home_bt_search_cancel_s);
        this.fxg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.fxf.setText("");
            }
        });
        jP(false);
        this.fxh.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.fxf.getText().toString())) {
            this.iaJ.setFocusable(true);
            this.iaJ.setFocusableInTouchMode(true);
            this.iaJ.requestFocus();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        am.setBgColor(this.iaE, i);
        if (i == 2) {
            this.fxf.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
        } else {
            this.fxf.setHintTextColor(am.getColor(R.color.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        SvgManager.aDW().a(this.fxg, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.fxf, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.aDW().a(this.eyp, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        am.setBackgroundResource(this.hZD, R.color.cp_bg_line_d);
        am.setViewTextColor(this.fxh, R.color.cp_link_tip_a, 1);
        if (this.iaH != null) {
            if (i != 0) {
                this.iaH.setVisibility(0);
                this.iaH.setBackgroundColor(am.getColor(i == 4 ? R.color.cp_mask_b_alpha42 : R.color.cp_mask_b_alpha33));
                return;
            }
            this.iaH.setVisibility(8);
        }
    }

    private void cbH() {
        this.iaG = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.iaG.rI(true);
        this.iaH = this.mRootView.findViewById(R.id.search_webview_mask);
    }

    private void cbj() {
        this.hZL = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.hZN = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.iaI = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void cbI() {
        this.iaF = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.iaF.rI(true);
    }

    private void cbJ() {
        this.fxf.setText("");
        this.fxf.requestFocus();
        this.fxh.setText(this.mContext.getString(R.string.cancel));
    }

    public void cbK() {
        this.iaG.setVisibility(0);
        this.hZL.setVisibility(8);
        this.iaF.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void cbu() {
        this.hZL.setVisibility(8);
        this.iaG.setVisibility(8);
        this.iaF.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cbs() {
        this.hZL.setVisibility(0);
        this.iaG.setVisibility(8);
        this.iaF.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void cbL() {
        this.hZL.setVisibility(8);
        this.iaG.setVisibility(8);
        this.iaF.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void jP(boolean z) {
        this.fxg.setVisibility(z ? 0 : 8);
    }

    public void DU(String str) {
        if (!StringUtils.isNull(str)) {
            this.fxf.setHint(str);
        }
    }

    public void DV(String str) {
        if (!StringUtils.isNull(str)) {
            this.fxf.setText(str);
            this.fxf.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!v.isEmpty(list)) {
            cbs();
            this.hZN.DM(str);
            this.hZN.setData(list);
            this.hZL.setAdapter((ListAdapter) this.hZN);
        }
    }

    public void k(List<ForumInfo> list, String str) {
        if (!v.isEmpty(list) && !TextUtils.isEmpty(str)) {
            cbs();
            this.iaI.DM(str);
            this.iaI.dt(list);
            this.hZL.setAdapter((ListAdapter) this.iaI);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.hZL.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.hZL.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.fxf.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.fxf.setOnEditorActionListener(onEditorActionListener);
    }

    public void e(TextWatcher textWatcher) {
        this.fxf.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fxf.setOnClickListener(onClickListener);
        this.fxh.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.iaF.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.iaF.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.iaF.setOnLoadUrlListener(bVar);
    }

    public EditText cbM() {
        return this.fxf;
    }

    public TextView cbN() {
        return this.fxh;
    }

    public QuickWebView cbO() {
        return this.iaF;
    }

    public QuickWebView cbP() {
        return this.iaG;
    }

    public boolean cbQ() {
        return this.hZL.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.hZD != null) {
                this.hZD.removeView(this.iaG);
                this.hZD.removeView(this.iaF);
            }
            this.iaG.removeAllViews();
            this.iaF.removeAllViews();
            if (this.iaG != null) {
                this.iaG.destroy();
                this.iaG = null;
            }
            if (this.iaF != null) {
                this.iaF.destroy();
                this.iaF = null;
            }
        } catch (Exception e) {
        }
    }
}
