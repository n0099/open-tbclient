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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.quickWebView.QuickWebView;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.List;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes24.dex */
public class d {
    private ImageView gEO;
    private EditText hQX;
    private ImageView hQY;
    private TextView hQZ;
    private FrameLayout kMn;
    private BdListView kMv;
    private com.baidu.tieba.mainentrance.searchSuggestList.b kMx;
    private LinearLayoutDetectsSoftKeyboard kNo;
    private QuickWebView kNp;
    private QuickWebView kNq;
    private View kNr;
    private boolean kNs = true;
    private com.baidu.tieba.mainentrance.searchSuggestList.a kNt;
    View kNu;
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
        bCV();
        this.kNo = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.kNo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.kNo.setFocusable(true);
                    d.this.kNo.setFocusableInTouchMode(true);
                    if (d.this.hQX.hasFocus()) {
                        l.hideSoftKeyPad(d.this.mContext, d.this.hQX);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.kMn = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.kMn.addView(this.mNoDataView, 0);
        dbM();
        dbo();
        dbN();
        dbO();
    }

    private void bCV() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.kNu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.gEO = (ImageView) this.kNu.findViewById(R.id.search_bar_icon);
        this.hQX = (EditText) this.kNu.findViewById(R.id.home_et_search);
        this.hQY = (ImageView) this.kNu.findViewById(R.id.home_bt_search_del);
        this.hQZ = (TextView) this.kNu.findViewById(R.id.home_bt_search_cancel_s);
        this.hQY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.hQX.setText("");
            }
        });
        ol(false);
        this.hQZ.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.hQX.getText().toString())) {
            this.kNu.setFocusable(true);
            this.kNu.setFocusableInTouchMode(true);
            this.kNu.requestFocus();
        }
    }

    public void tc(boolean z) {
        this.kNs = z;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 0 && this.kNs) {
            this.kNr.setVisibility(0);
            this.kNr.setBackgroundColor(ap.getColor(skinType == 4 ? R.color.cp_mask_b_alpha42 : R.color.cp_mask_b_alpha33));
            return;
        }
        this.kNr.setVisibility(8);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        ap.setBgColor(this.kNo, i);
        if (i == 2) {
            this.hQX.setHintTextColor(ap.getColor(R.color.s_navbar_title_color));
        } else {
            this.hQX.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        SvgManager.brn().a(this.hQY, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.hQX, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.brn().a(this.gEO, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.kMn, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.hQZ, R.color.cp_link_tip_a, 1);
        tc(this.kNs);
        if (this.kNq != null) {
            this.kNq.onChangeSkinType();
        }
        if (this.kNp != null) {
            this.kNp.onChangeSkinType();
        }
    }

    private void dbM() {
        this.kNq = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.kNq.wB(true);
        this.kNr = this.mRootView.findViewById(R.id.search_webview_mask);
    }

    private void dbo() {
        this.kMv = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.kMx = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.kNt = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void dbN() {
        this.kNp = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.kNp.wB(true);
    }

    private void dbO() {
        this.hQX.setText("");
        this.hQX.requestFocus();
        this.hQZ.setText(this.mContext.getString(R.string.cancel));
    }

    public void dbP() {
        this.kNq.setVisibility(0);
        this.kMv.setVisibility(8);
        this.kNp.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void dbz() {
        this.kMv.setVisibility(8);
        this.kNq.setVisibility(8);
        this.kNp.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void dbx() {
        this.kMv.setVisibility(0);
        this.kNq.setVisibility(8);
        this.kNp.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void dbQ() {
        this.kMv.setVisibility(8);
        this.kNq.setVisibility(8);
        this.kNp.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void ol(boolean z) {
        this.hQY.setVisibility(z ? 0 : 8);
    }

    public void Oe(String str) {
        if (!StringUtils.isNull(str)) {
            this.hQX.setHint(str);
        }
    }

    public void Of(String str) {
        if (!StringUtils.isNull(str)) {
            this.hQX.setText(str);
            this.hQX.setSelection(str.length());
        }
    }

    public void n(List<String> list, String str) {
        if (!y.isEmpty(list)) {
            dbx();
            this.kMx.NW(str);
            this.kMx.setData(list);
            this.kMv.setAdapter((ListAdapter) this.kMx);
        }
    }

    public void o(List<ForumInfo> list, String str) {
        if (!y.isEmpty(list) && !TextUtils.isEmpty(str)) {
            dbx();
            this.kNt.NW(str);
            this.kNt.eE(list);
            this.kMv.setAdapter((ListAdapter) this.kNt);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.kMv.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.kMv.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.hQX.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.hQX.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.hQX.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.hQX.setOnClickListener(onClickListener);
        this.hQZ.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.kNp.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.kNp.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.g gVar) {
        this.kNp.setOnReceivedSslErrorListener(gVar);
    }

    public void a(BaseWebView.b bVar) {
        this.kNp.setOnLoadUrlListener(bVar);
    }

    public EditText dbR() {
        return this.hQX;
    }

    public TextView dbS() {
        return this.hQZ;
    }

    public QuickWebView dbT() {
        return this.kNp;
    }

    public QuickWebView dbU() {
        return this.kNq;
    }

    public boolean dbV() {
        return this.kMv.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.kMn != null) {
                this.kMn.removeView(this.kNq);
                this.kMn.removeView(this.kNp);
            }
            this.kNq.removeAllViews();
            this.kNp.removeAllViews();
            if (this.kNq != null) {
                this.kNq.destroy();
                this.kNq = null;
            }
            if (this.kNp != null) {
                this.kNp.destroy();
                this.kNp = null;
            }
        } catch (Exception e) {
        }
    }
}
