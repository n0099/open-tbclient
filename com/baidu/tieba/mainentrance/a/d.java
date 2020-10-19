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
    private ImageView goV;
    private EditText hyE;
    private ImageView hyF;
    private TextView hyG;
    private FrameLayout ktU;
    private LinearLayoutDetectsSoftKeyboard kuV;
    private QuickWebView kuW;
    private QuickWebView kuX;
    private View kuY;
    private boolean kuZ = true;
    private BdListView kuc;
    private com.baidu.tieba.mainentrance.searchSuggestList.b kue;
    private com.baidu.tieba.mainentrance.searchSuggestList.a kva;
    View kvb;
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
        byD();
        this.kuV = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.kuV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.kuV.setFocusable(true);
                    d.this.kuV.setFocusableInTouchMode(true);
                    if (d.this.hyE.hasFocus()) {
                        l.hideSoftKeyPad(d.this.mContext, d.this.hyE);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.ktU = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.ktU.addView(this.mNoDataView, 0);
        cWc();
        cVE();
        cWd();
        cWe();
    }

    private void byD() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.kvb = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.goV = (ImageView) this.kvb.findViewById(R.id.search_bar_icon);
        this.hyE = (EditText) this.kvb.findViewById(R.id.home_et_search);
        this.hyF = (ImageView) this.kvb.findViewById(R.id.home_bt_search_del);
        this.hyG = (TextView) this.kvb.findViewById(R.id.home_bt_search_cancel_s);
        this.hyF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.hyE.setText("");
            }
        });
        nK(false);
        this.hyG.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.hyE.getText().toString())) {
            this.kvb.setFocusable(true);
            this.kvb.setFocusableInTouchMode(true);
            this.kvb.requestFocus();
        }
    }

    public void sB(boolean z) {
        this.kuZ = z;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 0 && this.kuZ) {
            this.kuY.setVisibility(0);
            this.kuY.setBackgroundColor(ap.getColor(skinType == 4 ? R.color.cp_mask_b_alpha42 : R.color.cp_mask_b_alpha33));
            return;
        }
        this.kuY.setVisibility(8);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        ap.setBgColor(this.kuV, i);
        if (i == 2) {
            this.hyE.setHintTextColor(ap.getColor(R.color.s_navbar_title_color));
        } else {
            this.hyE.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        SvgManager.bmU().a(this.hyF, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.hyE, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.bmU().a(this.goV, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.ktU, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.hyG, R.color.cp_link_tip_a, 1);
        sB(this.kuZ);
        if (this.kuX != null) {
            this.kuX.onChangeSkinType();
        }
        if (this.kuW != null) {
            this.kuW.onChangeSkinType();
        }
    }

    private void cWc() {
        this.kuX = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.kuX.wb(true);
        this.kuY = this.mRootView.findViewById(R.id.search_webview_mask);
    }

    private void cVE() {
        this.kuc = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.kue = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.kva = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void cWd() {
        this.kuW = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.kuW.wb(true);
    }

    private void cWe() {
        this.hyE.setText("");
        this.hyE.requestFocus();
        this.hyG.setText(this.mContext.getString(R.string.cancel));
    }

    public void cWf() {
        this.kuX.setVisibility(0);
        this.kuc.setVisibility(8);
        this.kuW.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void cVP() {
        this.kuc.setVisibility(8);
        this.kuX.setVisibility(8);
        this.kuW.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cVN() {
        this.kuc.setVisibility(0);
        this.kuX.setVisibility(8);
        this.kuW.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void cWg() {
        this.kuc.setVisibility(8);
        this.kuX.setVisibility(8);
        this.kuW.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void nK(boolean z) {
        this.hyF.setVisibility(z ? 0 : 8);
    }

    public void Np(String str) {
        if (!StringUtils.isNull(str)) {
            this.hyE.setHint(str);
        }
    }

    public void Nq(String str) {
        if (!StringUtils.isNull(str)) {
            this.hyE.setText(str);
            this.hyE.setSelection(str.length());
        }
    }

    public void k(List<String> list, String str) {
        if (!y.isEmpty(list)) {
            cVN();
            this.kue.Nh(str);
            this.kue.setData(list);
            this.kuc.setAdapter((ListAdapter) this.kue);
        }
    }

    public void l(List<ForumInfo> list, String str) {
        if (!y.isEmpty(list) && !TextUtils.isEmpty(str)) {
            cVN();
            this.kva.Nh(str);
            this.kva.en(list);
            this.kuc.setAdapter((ListAdapter) this.kva);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.kuc.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.kuc.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.hyE.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.hyE.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.hyE.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.hyE.setOnClickListener(onClickListener);
        this.hyG.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.kuW.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.kuW.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.g gVar) {
        this.kuW.setOnReceivedSslErrorListener(gVar);
    }

    public void a(BaseWebView.b bVar) {
        this.kuW.setOnLoadUrlListener(bVar);
    }

    public EditText cWh() {
        return this.hyE;
    }

    public TextView cWi() {
        return this.hyG;
    }

    public QuickWebView cWj() {
        return this.kuW;
    }

    public QuickWebView cWk() {
        return this.kuX;
    }

    public boolean cWl() {
        return this.kuc.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.ktU != null) {
                this.ktU.removeView(this.kuX);
                this.ktU.removeView(this.kuW);
            }
            this.kuX.removeAllViews();
            this.kuW.removeAllViews();
            if (this.kuX != null) {
                this.kuX.destroy();
                this.kuX = null;
            }
            if (this.kuW != null) {
                this.kuW.destroy();
                this.kuW = null;
            }
        } catch (Exception e) {
        }
    }
}
