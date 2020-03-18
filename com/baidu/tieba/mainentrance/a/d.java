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
    private ImageView eEr;
    private EditText fDL;
    private ImageView fDM;
    private TextView fDN;
    private FrameLayout igW;
    private LinearLayoutDetectsSoftKeyboard ihX;
    private QuickWebView ihY;
    private QuickWebView ihZ;
    private BdListView ihe;
    private com.baidu.tieba.mainentrance.searchSuggestList.b ihg;
    private View iia;
    private boolean iib = true;
    private com.baidu.tieba.mainentrance.searchSuggestList.a iic;
    View iid;
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
        bcO();
        this.ihX = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.ihX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.ihX.setFocusable(true);
                    d.this.ihX.setFocusableInTouchMode(true);
                    if (d.this.fDL.hasFocus()) {
                        l.hideSoftKeyPad(d.this.mContext, d.this.fDL);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.igW = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.igW.addView(this.mNoDataView, 0);
        ceQ();
        ces();
        ceR();
        ceS();
    }

    private void bcO() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.iid = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.eEr = (ImageView) this.iid.findViewById(R.id.search_bar_icon);
        this.fDL = (EditText) this.iid.findViewById(R.id.home_et_search);
        this.fDM = (ImageView) this.iid.findViewById(R.id.home_bt_search_del);
        this.fDN = (TextView) this.iid.findViewById(R.id.home_bt_search_cancel_s);
        this.fDM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.fDL.setText("");
            }
        });
        kh(false);
        this.fDN.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.fDL.getText().toString())) {
            this.iid.setFocusable(true);
            this.iid.setFocusableInTouchMode(true);
            this.iid.requestFocus();
        }
    }

    public void oM(boolean z) {
        this.iib = z;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 0 && this.iib) {
            this.iia.setVisibility(0);
            this.iia.setBackgroundColor(am.getColor(skinType == 4 ? R.color.cp_mask_b_alpha42 : R.color.cp_mask_b_alpha33));
            return;
        }
        this.iia.setVisibility(8);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        am.setBgColor(this.ihX, i);
        if (i == 2) {
            this.fDL.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
        } else {
            this.fDL.setHintTextColor(am.getColor(R.color.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        SvgManager.aGG().a(this.fDM, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.fDL, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.aGG().a(this.eEr, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        am.setBackgroundResource(this.igW, R.color.cp_bg_line_d);
        am.setViewTextColor(this.fDN, R.color.cp_link_tip_a, 1);
        oM(this.iib);
        if (this.ihZ != null) {
            this.ihZ.onChangeSkinType();
        }
        if (this.ihY != null) {
            this.ihY.onChangeSkinType();
        }
    }

    private void ceQ() {
        this.ihZ = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.ihZ.sd(true);
        this.iia = this.mRootView.findViewById(R.id.search_webview_mask);
    }

    private void ces() {
        this.ihe = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.ihg = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.iic = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void ceR() {
        this.ihY = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.ihY.sd(true);
    }

    private void ceS() {
        this.fDL.setText("");
        this.fDL.requestFocus();
        this.fDN.setText(this.mContext.getString(R.string.cancel));
    }

    public void ceT() {
        this.ihZ.setVisibility(0);
        this.ihe.setVisibility(8);
        this.ihY.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void ceD() {
        this.ihe.setVisibility(8);
        this.ihZ.setVisibility(8);
        this.ihY.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void ceB() {
        this.ihe.setVisibility(0);
        this.ihZ.setVisibility(8);
        this.ihY.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void ceU() {
        this.ihe.setVisibility(8);
        this.ihZ.setVisibility(8);
        this.ihY.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void kh(boolean z) {
        this.fDM.setVisibility(z ? 0 : 8);
    }

    public void Eu(String str) {
        if (!StringUtils.isNull(str)) {
            this.fDL.setHint(str);
        }
    }

    public void Ev(String str) {
        if (!StringUtils.isNull(str)) {
            this.fDL.setText(str);
            this.fDL.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!v.isEmpty(list)) {
            ceB();
            this.ihg.Em(str);
            this.ihg.setData(list);
            this.ihe.setAdapter((ListAdapter) this.ihg);
        }
    }

    public void k(List<ForumInfo> list, String str) {
        if (!v.isEmpty(list) && !TextUtils.isEmpty(str)) {
            ceB();
            this.iic.Em(str);
            this.iic.dp(list);
            this.ihe.setAdapter((ListAdapter) this.iic);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.ihe.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.ihe.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.fDL.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.fDL.setOnEditorActionListener(onEditorActionListener);
    }

    public void e(TextWatcher textWatcher) {
        this.fDL.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fDL.setOnClickListener(onClickListener);
        this.fDN.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.ihY.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.ihY.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.ihY.setOnLoadUrlListener(bVar);
    }

    public EditText ceV() {
        return this.fDL;
    }

    public TextView ceW() {
        return this.fDN;
    }

    public QuickWebView ceX() {
        return this.ihY;
    }

    public QuickWebView ceY() {
        return this.ihZ;
    }

    public boolean ceZ() {
        return this.ihe.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.igW != null) {
                this.igW.removeView(this.ihZ);
                this.igW.removeView(this.ihY);
            }
            this.ihZ.removeAllViews();
            this.ihY.removeAllViews();
            if (this.ihZ != null) {
                this.ihZ.destroy();
                this.ihZ = null;
            }
            if (this.ihY != null) {
                this.ihY.destroy();
                this.ihY = null;
            }
        } catch (Exception e) {
        }
    }
}
