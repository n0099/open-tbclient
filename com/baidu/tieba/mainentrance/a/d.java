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
/* loaded from: classes11.dex */
public class d {
    private ImageView fiM;
    private EditText gip;
    private ImageView giq;
    private TextView gir;
    private FrameLayout iQZ;
    private BdListView iRh;
    private com.baidu.tieba.mainentrance.searchSuggestList.b iRj;
    private LinearLayoutDetectsSoftKeyboard iSa;
    private QuickWebView iSb;
    private QuickWebView iSc;
    private View iSd;
    private boolean iSe = true;
    private com.baidu.tieba.mainentrance.searchSuggestList.a iSf;
    View iSg;
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
        blF();
        this.iSa = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.iSa.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.iSa.setFocusable(true);
                    d.this.iSa.setFocusableInTouchMode(true);
                    if (d.this.gip.hasFocus()) {
                        l.hideSoftKeyPad(d.this.mContext, d.this.gip);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.iQZ = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.iQZ.addView(this.mNoDataView, 0);
        cpx();
        coZ();
        cpy();
        cpz();
    }

    private void blF() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.iSg = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.fiM = (ImageView) this.iSg.findViewById(R.id.search_bar_icon);
        this.gip = (EditText) this.iSg.findViewById(R.id.home_et_search);
        this.giq = (ImageView) this.iSg.findViewById(R.id.home_bt_search_del);
        this.gir = (TextView) this.iSg.findViewById(R.id.home_bt_search_cancel_s);
        this.giq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.gip.setText("");
            }
        });
        lk(false);
        this.gir.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.gip.getText().toString())) {
            this.iSg.setFocusable(true);
            this.iSg.setFocusableInTouchMode(true);
            this.iSg.requestFocus();
        }
    }

    public void pQ(boolean z) {
        this.iSe = z;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 0 && this.iSe) {
            this.iSd.setVisibility(0);
            this.iSd.setBackgroundColor(am.getColor(skinType == 4 ? R.color.cp_mask_b_alpha42 : R.color.cp_mask_b_alpha33));
            return;
        }
        this.iSd.setVisibility(8);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        am.setBgColor(this.iSa, i);
        if (i == 2) {
            this.gip.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
        } else {
            this.gip.setHintTextColor(am.getColor(R.color.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        SvgManager.aOU().a(this.giq, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.gip, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.aOU().a(this.fiM, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        am.setBackgroundResource(this.iQZ, R.color.cp_bg_line_d);
        am.setViewTextColor(this.gir, R.color.cp_link_tip_a, 1);
        pQ(this.iSe);
        if (this.iSc != null) {
            this.iSc.onChangeSkinType();
        }
        if (this.iSb != null) {
            this.iSb.onChangeSkinType();
        }
    }

    private void cpx() {
        this.iSc = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.iSc.th(true);
        this.iSd = this.mRootView.findViewById(R.id.search_webview_mask);
    }

    private void coZ() {
        this.iRh = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.iRj = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.iSf = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void cpy() {
        this.iSb = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.iSb.th(true);
    }

    private void cpz() {
        this.gip.setText("");
        this.gip.requestFocus();
        this.gir.setText(this.mContext.getString(R.string.cancel));
    }

    public void cpA() {
        this.iSc.setVisibility(0);
        this.iRh.setVisibility(8);
        this.iSb.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void cpk() {
        this.iRh.setVisibility(8);
        this.iSc.setVisibility(8);
        this.iSb.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cpi() {
        this.iRh.setVisibility(0);
        this.iSc.setVisibility(8);
        this.iSb.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void cpB() {
        this.iRh.setVisibility(8);
        this.iSc.setVisibility(8);
        this.iSb.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void lk(boolean z) {
        this.giq.setVisibility(z ? 0 : 8);
    }

    public void Gc(String str) {
        if (!StringUtils.isNull(str)) {
            this.gip.setHint(str);
        }
    }

    public void Gd(String str) {
        if (!StringUtils.isNull(str)) {
            this.gip.setText(str);
            this.gip.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!v.isEmpty(list)) {
            cpi();
            this.iRj.FU(str);
            this.iRj.setData(list);
            this.iRh.setAdapter((ListAdapter) this.iRj);
        }
    }

    public void k(List<ForumInfo> list, String str) {
        if (!v.isEmpty(list) && !TextUtils.isEmpty(str)) {
            cpi();
            this.iSf.FU(str);
            this.iSf.dA(list);
            this.iRh.setAdapter((ListAdapter) this.iSf);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.iRh.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.iRh.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.gip.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.gip.setOnEditorActionListener(onEditorActionListener);
    }

    public void e(TextWatcher textWatcher) {
        this.gip.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.gip.setOnClickListener(onClickListener);
        this.gir.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.iSb.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.iSb.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.iSb.setOnLoadUrlListener(bVar);
    }

    public EditText cpC() {
        return this.gip;
    }

    public TextView cpD() {
        return this.gir;
    }

    public QuickWebView cpE() {
        return this.iSb;
    }

    public QuickWebView cpF() {
        return this.iSc;
    }

    public boolean cpG() {
        return this.iRh.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.iQZ != null) {
                this.iQZ.removeView(this.iSc);
                this.iQZ.removeView(this.iSb);
            }
            this.iSc.removeAllViews();
            this.iSb.removeAllViews();
            if (this.iSc != null) {
                this.iSc.destroy();
                this.iSc = null;
            }
            if (this.iSb != null) {
                this.iSb.destroy();
                this.iSb = null;
            }
        } catch (Exception e) {
        }
    }
}
