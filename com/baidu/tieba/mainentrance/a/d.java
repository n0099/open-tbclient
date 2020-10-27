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
    private ImageView gza;
    private EditText hLa;
    private ImageView hLb;
    private TextView hLc;
    private com.baidu.tieba.mainentrance.searchSuggestList.b kGB;
    private FrameLayout kGr;
    private BdListView kGz;
    private LinearLayoutDetectsSoftKeyboard kHs;
    private QuickWebView kHt;
    private QuickWebView kHu;
    private View kHv;
    private boolean kHw = true;
    private com.baidu.tieba.mainentrance.searchSuggestList.a kHx;
    View kHy;
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
        bAw();
        this.kHs = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.kHs.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.kHs.setFocusable(true);
                    d.this.kHs.setFocusableInTouchMode(true);
                    if (d.this.hLa.hasFocus()) {
                        l.hideSoftKeyPad(d.this.mContext, d.this.hLa);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.kGr = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.kGr.addView(this.mNoDataView, 0);
        cZk();
        cYM();
        cZl();
        cZm();
    }

    private void bAw() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.kHy = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.gza = (ImageView) this.kHy.findViewById(R.id.search_bar_icon);
        this.hLa = (EditText) this.kHy.findViewById(R.id.home_et_search);
        this.hLb = (ImageView) this.kHy.findViewById(R.id.home_bt_search_del);
        this.hLc = (TextView) this.kHy.findViewById(R.id.home_bt_search_cancel_s);
        this.hLb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.hLa.setText("");
            }
        });
        oc(false);
        this.hLc.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.hLa.getText().toString())) {
            this.kHy.setFocusable(true);
            this.kHy.setFocusableInTouchMode(true);
            this.kHy.requestFocus();
        }
    }

    public void sT(boolean z) {
        this.kHw = z;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 0 && this.kHw) {
            this.kHv.setVisibility(0);
            this.kHv.setBackgroundColor(ap.getColor(skinType == 4 ? R.color.cp_mask_b_alpha42 : R.color.cp_mask_b_alpha33));
            return;
        }
        this.kHv.setVisibility(8);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        ap.setBgColor(this.kHs, i);
        if (i == 2) {
            this.hLa.setHintTextColor(ap.getColor(R.color.s_navbar_title_color));
        } else {
            this.hLa.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        SvgManager.boN().a(this.hLb, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.hLa, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.boN().a(this.gza, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.kGr, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.hLc, R.color.cp_link_tip_a, 1);
        sT(this.kHw);
        if (this.kHu != null) {
            this.kHu.onChangeSkinType();
        }
        if (this.kHt != null) {
            this.kHt.onChangeSkinType();
        }
    }

    private void cZk() {
        this.kHu = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.kHu.ws(true);
        this.kHv = this.mRootView.findViewById(R.id.search_webview_mask);
    }

    private void cYM() {
        this.kGz = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.kGB = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.kHx = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void cZl() {
        this.kHt = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.kHt.ws(true);
    }

    private void cZm() {
        this.hLa.setText("");
        this.hLa.requestFocus();
        this.hLc.setText(this.mContext.getString(R.string.cancel));
    }

    public void cZn() {
        this.kHu.setVisibility(0);
        this.kGz.setVisibility(8);
        this.kHt.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void cYX() {
        this.kGz.setVisibility(8);
        this.kHu.setVisibility(8);
        this.kHt.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cYV() {
        this.kGz.setVisibility(0);
        this.kHu.setVisibility(8);
        this.kHt.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void cZo() {
        this.kGz.setVisibility(8);
        this.kHu.setVisibility(8);
        this.kHt.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void oc(boolean z) {
        this.hLb.setVisibility(z ? 0 : 8);
    }

    public void NN(String str) {
        if (!StringUtils.isNull(str)) {
            this.hLa.setHint(str);
        }
    }

    public void NO(String str) {
        if (!StringUtils.isNull(str)) {
            this.hLa.setText(str);
            this.hLa.setSelection(str.length());
        }
    }

    public void m(List<String> list, String str) {
        if (!y.isEmpty(list)) {
            cYV();
            this.kGB.NF(str);
            this.kGB.setData(list);
            this.kGz.setAdapter((ListAdapter) this.kGB);
        }
    }

    public void n(List<ForumInfo> list, String str) {
        if (!y.isEmpty(list) && !TextUtils.isEmpty(str)) {
            cYV();
            this.kHx.NF(str);
            this.kHx.ew(list);
            this.kGz.setAdapter((ListAdapter) this.kHx);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.kGz.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.kGz.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.hLa.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.hLa.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.hLa.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.hLa.setOnClickListener(onClickListener);
        this.hLc.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.kHt.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.kHt.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.g gVar) {
        this.kHt.setOnReceivedSslErrorListener(gVar);
    }

    public void a(BaseWebView.b bVar) {
        this.kHt.setOnLoadUrlListener(bVar);
    }

    public EditText cZp() {
        return this.hLa;
    }

    public TextView cZq() {
        return this.hLc;
    }

    public QuickWebView cZr() {
        return this.kHt;
    }

    public QuickWebView cZs() {
        return this.kHu;
    }

    public boolean cZt() {
        return this.kGz.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.kGr != null) {
                this.kGr.removeView(this.kHu);
                this.kGr.removeView(this.kHt);
            }
            this.kHu.removeAllViews();
            this.kHt.removeAllViews();
            if (this.kHu != null) {
                this.kHu.destroy();
                this.kHu = null;
            }
            if (this.kHt != null) {
                this.kHt.destroy();
                this.kHt = null;
            }
        } catch (Exception e) {
        }
    }
}
