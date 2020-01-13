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
/* loaded from: classes9.dex */
public class d {
    private ImageView ezA;
    private EditText fAq;
    private ImageView fAr;
    private TextView fAs;
    private FrameLayout idh;
    private BdListView idq;
    private com.baidu.tieba.mainentrance.searchSuggestList.b idu;
    private LinearLayoutDetectsSoftKeyboard iem;
    private QuickWebView ien;
    private QuickWebView ieo;
    private View iep;
    private com.baidu.tieba.mainentrance.searchSuggestList.a ieq;
    View ier;
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
        bas();
        this.iem = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.iem.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.iem.setFocusable(true);
                    d.this.iem.setFocusableInTouchMode(true);
                    if (d.this.fAq.hasFocus()) {
                        l.hideSoftKeyPad(d.this.mContext, d.this.fAq);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.idh = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.idh.addView(this.mNoDataView, 0);
        ccQ();
        ccs();
        ccR();
        ccS();
    }

    private void bas() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.ier = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.ezA = (ImageView) this.ier.findViewById(R.id.search_bar_icon);
        this.fAq = (EditText) this.ier.findViewById(R.id.home_et_search);
        this.fAr = (ImageView) this.ier.findViewById(R.id.home_bt_search_del);
        this.fAs = (TextView) this.ier.findViewById(R.id.home_bt_search_cancel_s);
        this.fAr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.fAq.setText("");
            }
        });
        ka(false);
        this.fAs.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.fAq.getText().toString())) {
            this.ier.setFocusable(true);
            this.ier.setFocusableInTouchMode(true);
            this.ier.requestFocus();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        am.setBgColor(this.iem, i);
        if (i == 2) {
            this.fAq.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
        } else {
            this.fAq.setHintTextColor(am.getColor(R.color.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        SvgManager.aEp().a(this.fAr, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.fAq, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.aEp().a(this.ezA, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        am.setBackgroundResource(this.idh, R.color.cp_bg_line_d);
        am.setViewTextColor(this.fAs, R.color.cp_link_tip_a, 1);
        if (this.iep != null) {
            if (i != 0) {
                this.iep.setVisibility(0);
                this.iep.setBackgroundColor(am.getColor(i == 4 ? R.color.cp_mask_b_alpha42 : R.color.cp_mask_b_alpha33));
                return;
            }
            this.iep.setVisibility(8);
        }
    }

    private void ccQ() {
        this.ieo = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.ieo.rU(true);
        this.iep = this.mRootView.findViewById(R.id.search_webview_mask);
    }

    private void ccs() {
        this.idq = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.idu = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.ieq = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void ccR() {
        this.ien = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.ien.rU(true);
    }

    private void ccS() {
        this.fAq.setText("");
        this.fAq.requestFocus();
        this.fAs.setText(this.mContext.getString(R.string.cancel));
    }

    public void ccT() {
        this.ieo.setVisibility(0);
        this.idq.setVisibility(8);
        this.ien.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void ccD() {
        this.idq.setVisibility(8);
        this.ieo.setVisibility(8);
        this.ien.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void ccB() {
        this.idq.setVisibility(0);
        this.ieo.setVisibility(8);
        this.ien.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void ccU() {
        this.idq.setVisibility(8);
        this.ieo.setVisibility(8);
        this.ien.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void ka(boolean z) {
        this.fAr.setVisibility(z ? 0 : 8);
    }

    public void Ee(String str) {
        if (!StringUtils.isNull(str)) {
            this.fAq.setHint(str);
        }
    }

    public void Ef(String str) {
        if (!StringUtils.isNull(str)) {
            this.fAq.setText(str);
            this.fAq.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!v.isEmpty(list)) {
            ccB();
            this.idu.DW(str);
            this.idu.setData(list);
            this.idq.setAdapter((ListAdapter) this.idu);
        }
    }

    public void k(List<ForumInfo> list, String str) {
        if (!v.isEmpty(list) && !TextUtils.isEmpty(str)) {
            ccB();
            this.ieq.DW(str);
            this.ieq.dt(list);
            this.idq.setAdapter((ListAdapter) this.ieq);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.idq.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.idq.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.fAq.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.fAq.setOnEditorActionListener(onEditorActionListener);
    }

    public void e(TextWatcher textWatcher) {
        this.fAq.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fAq.setOnClickListener(onClickListener);
        this.fAs.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.ien.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.ien.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.ien.setOnLoadUrlListener(bVar);
    }

    public EditText ccV() {
        return this.fAq;
    }

    public TextView ccW() {
        return this.fAs;
    }

    public QuickWebView ccX() {
        return this.ien;
    }

    public QuickWebView ccY() {
        return this.ieo;
    }

    public boolean ccZ() {
        return this.idq.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.idh != null) {
                this.idh.removeView(this.ieo);
                this.idh.removeView(this.ien);
            }
            this.ieo.removeAllViews();
            this.ien.removeAllViews();
            if (this.ieo != null) {
                this.ieo.destroy();
                this.ieo = null;
            }
            if (this.ien != null) {
                this.ien.destroy();
                this.ien = null;
            }
        } catch (Exception e) {
        }
    }
}
