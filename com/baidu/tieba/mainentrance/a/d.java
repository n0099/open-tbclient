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
/* loaded from: classes18.dex */
public class d {
    private ImageView fZm;
    private EditText hcG;
    private ImageView hcH;
    private TextView hcI;
    private FrameLayout jVX;
    private LinearLayoutDetectsSoftKeyboard jWY;
    private QuickWebView jWZ;
    private BdListView jWf;
    private com.baidu.tieba.mainentrance.searchSuggestList.b jWh;
    private QuickWebView jXa;
    private View jXb;
    private boolean jXc = true;
    private com.baidu.tieba.mainentrance.searchSuggestList.a jXd;
    View jXe;
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
        buO();
        this.jWY = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.jWY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.jWY.setFocusable(true);
                    d.this.jWY.setFocusableInTouchMode(true);
                    if (d.this.hcG.hasFocus()) {
                        l.hideSoftKeyPad(d.this.mContext, d.this.hcG);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.jVX = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.jVX.addView(this.mNoDataView, 0);
        cOM();
        cOo();
        cON();
        cOO();
    }

    private void buO() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.jXe = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.fZm = (ImageView) this.jXe.findViewById(R.id.search_bar_icon);
        this.hcG = (EditText) this.jXe.findViewById(R.id.home_et_search);
        this.hcH = (ImageView) this.jXe.findViewById(R.id.home_bt_search_del);
        this.hcI = (TextView) this.jXe.findViewById(R.id.home_bt_search_cancel_s);
        this.hcH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.hcG.setText("");
            }
        });
        mX(false);
        this.hcI.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.hcG.getText().toString())) {
            this.jXe.setFocusable(true);
            this.jXe.setFocusableInTouchMode(true);
            this.jXe.requestFocus();
        }
    }

    public void rK(boolean z) {
        this.jXc = z;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 0 && this.jXc) {
            this.jXb.setVisibility(0);
            this.jXb.setBackgroundColor(ap.getColor(skinType == 4 ? R.color.cp_mask_b_alpha42 : R.color.cp_mask_b_alpha33));
            return;
        }
        this.jXb.setVisibility(8);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        ap.setBgColor(this.jWY, i);
        if (i == 2) {
            this.hcG.setHintTextColor(ap.getColor(R.color.s_navbar_title_color));
        } else {
            this.hcG.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        SvgManager.bjq().a(this.hcH, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.hcG, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.bjq().a(this.fZm, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.jVX, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.hcI, R.color.cp_link_tip_a, 1);
        rK(this.jXc);
        if (this.jXa != null) {
            this.jXa.onChangeSkinType();
        }
        if (this.jWZ != null) {
            this.jWZ.onChangeSkinType();
        }
    }

    private void cOM() {
        this.jXa = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.jXa.vk(true);
        this.jXb = this.mRootView.findViewById(R.id.search_webview_mask);
    }

    private void cOo() {
        this.jWf = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.jWh = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.jXd = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void cON() {
        this.jWZ = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.jWZ.vk(true);
    }

    private void cOO() {
        this.hcG.setText("");
        this.hcG.requestFocus();
        this.hcI.setText(this.mContext.getString(R.string.cancel));
    }

    public void cOP() {
        this.jXa.setVisibility(0);
        this.jWf.setVisibility(8);
        this.jWZ.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void cOz() {
        this.jWf.setVisibility(8);
        this.jXa.setVisibility(8);
        this.jWZ.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cOx() {
        this.jWf.setVisibility(0);
        this.jXa.setVisibility(8);
        this.jWZ.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void cOQ() {
        this.jWf.setVisibility(8);
        this.jXa.setVisibility(8);
        this.jWZ.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void mX(boolean z) {
        this.hcH.setVisibility(z ? 0 : 8);
    }

    public void LX(String str) {
        if (!StringUtils.isNull(str)) {
            this.hcG.setHint(str);
        }
    }

    public void LY(String str) {
        if (!StringUtils.isNull(str)) {
            this.hcG.setText(str);
            this.hcG.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!y.isEmpty(list)) {
            cOx();
            this.jWh.LP(str);
            this.jWh.setData(list);
            this.jWf.setAdapter((ListAdapter) this.jWh);
        }
    }

    public void k(List<ForumInfo> list, String str) {
        if (!y.isEmpty(list) && !TextUtils.isEmpty(str)) {
            cOx();
            this.jXd.LP(str);
            this.jXd.ec(list);
            this.jWf.setAdapter((ListAdapter) this.jXd);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.jWf.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.jWf.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.hcG.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.hcG.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.hcG.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.hcG.setOnClickListener(onClickListener);
        this.hcI.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.jWZ.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.jWZ.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.g gVar) {
        this.jWZ.setOnReceivedSslErrorListener(gVar);
    }

    public void a(BaseWebView.b bVar) {
        this.jWZ.setOnLoadUrlListener(bVar);
    }

    public EditText cOR() {
        return this.hcG;
    }

    public TextView cOS() {
        return this.hcI;
    }

    public QuickWebView cOT() {
        return this.jWZ;
    }

    public QuickWebView cOU() {
        return this.jXa;
    }

    public boolean cOV() {
        return this.jWf.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.jVX != null) {
                this.jVX.removeView(this.jXa);
                this.jVX.removeView(this.jWZ);
            }
            this.jXa.removeAllViews();
            this.jWZ.removeAllViews();
            if (this.jXa != null) {
                this.jXa.destroy();
                this.jXa = null;
            }
            if (this.jWZ != null) {
                this.jWZ.destroy();
                this.jWZ = null;
            }
        } catch (Exception e) {
        }
    }
}
