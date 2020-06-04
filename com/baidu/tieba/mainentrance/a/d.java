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
    private ImageView fwJ;
    private EditText gxw;
    private ImageView gxx;
    private TextView gxy;
    private FrameLayout jgR;
    private BdListView jgZ;
    private LinearLayoutDetectsSoftKeyboard jhS;
    private QuickWebView jhT;
    private QuickWebView jhU;
    private View jhV;
    private boolean jhW = true;
    private com.baidu.tieba.mainentrance.searchSuggestList.a jhX;
    View jhY;
    private com.baidu.tieba.mainentrance.searchSuggestList.b jhb;
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
        brd();
        this.jhS = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.jhS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.jhS.setFocusable(true);
                    d.this.jhS.setFocusableInTouchMode(true);
                    if (d.this.gxw.hasFocus()) {
                        l.hideSoftKeyPad(d.this.mContext, d.this.gxw);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.jgR = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.jgR.addView(this.mNoDataView, 0);
        cwg();
        cvI();
        cwh();
        cwi();
    }

    private void brd() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.jhY = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.fwJ = (ImageView) this.jhY.findViewById(R.id.search_bar_icon);
        this.gxw = (EditText) this.jhY.findViewById(R.id.home_et_search);
        this.gxx = (ImageView) this.jhY.findViewById(R.id.home_bt_search_del);
        this.gxy = (TextView) this.jhY.findViewById(R.id.home_bt_search_cancel_s);
        this.gxx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.gxw.setText("");
            }
        });
        lG(false);
        this.gxy.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.gxw.getText().toString())) {
            this.jhY.setFocusable(true);
            this.jhY.setFocusableInTouchMode(true);
            this.jhY.requestFocus();
        }
    }

    public void qn(boolean z) {
        this.jhW = z;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 0 && this.jhW) {
            this.jhV.setVisibility(0);
            this.jhV.setBackgroundColor(am.getColor(skinType == 4 ? R.color.cp_mask_b_alpha42 : R.color.cp_mask_b_alpha33));
            return;
        }
        this.jhV.setVisibility(8);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        am.setBgColor(this.jhS, i);
        if (i == 2) {
            this.gxw.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
        } else {
            this.gxw.setHintTextColor(am.getColor(R.color.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        SvgManager.aUW().a(this.gxx, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.gxw, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.aUW().a(this.fwJ, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        am.setBackgroundResource(this.jgR, R.color.cp_bg_line_d);
        am.setViewTextColor(this.gxy, R.color.cp_link_tip_a, 1);
        qn(this.jhW);
        if (this.jhU != null) {
            this.jhU.onChangeSkinType();
        }
        if (this.jhT != null) {
            this.jhT.onChangeSkinType();
        }
    }

    private void cwg() {
        this.jhU = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.jhU.tF(true);
        this.jhV = this.mRootView.findViewById(R.id.search_webview_mask);
    }

    private void cvI() {
        this.jgZ = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.jhb = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.jhX = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void cwh() {
        this.jhT = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.jhT.tF(true);
    }

    private void cwi() {
        this.gxw.setText("");
        this.gxw.requestFocus();
        this.gxy.setText(this.mContext.getString(R.string.cancel));
    }

    public void cwj() {
        this.jhU.setVisibility(0);
        this.jgZ.setVisibility(8);
        this.jhT.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void cvT() {
        this.jgZ.setVisibility(8);
        this.jhU.setVisibility(8);
        this.jhT.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cvR() {
        this.jgZ.setVisibility(0);
        this.jhU.setVisibility(8);
        this.jhT.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void cwk() {
        this.jgZ.setVisibility(8);
        this.jhU.setVisibility(8);
        this.jhT.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void lG(boolean z) {
        this.gxx.setVisibility(z ? 0 : 8);
    }

    public void HO(String str) {
        if (!StringUtils.isNull(str)) {
            this.gxw.setHint(str);
        }
    }

    public void HP(String str) {
        if (!StringUtils.isNull(str)) {
            this.gxw.setText(str);
            this.gxw.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!v.isEmpty(list)) {
            cvR();
            this.jhb.HG(str);
            this.jhb.setData(list);
            this.jgZ.setAdapter((ListAdapter) this.jhb);
        }
    }

    public void k(List<ForumInfo> list, String str) {
        if (!v.isEmpty(list) && !TextUtils.isEmpty(str)) {
            cvR();
            this.jhX.HG(str);
            this.jhX.dz(list);
            this.jgZ.setAdapter((ListAdapter) this.jhX);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.jgZ.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.jgZ.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.gxw.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.gxw.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.gxw.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.gxw.setOnClickListener(onClickListener);
        this.gxy.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.jhT.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.jhT.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.jhT.setOnLoadUrlListener(bVar);
    }

    public EditText cwl() {
        return this.gxw;
    }

    public TextView cwm() {
        return this.gxy;
    }

    public QuickWebView cwn() {
        return this.jhT;
    }

    public QuickWebView cwo() {
        return this.jhU;
    }

    public boolean cwp() {
        return this.jgZ.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.jgR != null) {
                this.jgR.removeView(this.jhU);
                this.jgR.removeView(this.jhT);
            }
            this.jhU.removeAllViews();
            this.jhT.removeAllViews();
            if (this.jhU != null) {
                this.jhU.destroy();
                this.jhU = null;
            }
            if (this.jhT != null) {
                this.jhT.destroy();
                this.jhT = null;
            }
        } catch (Exception e) {
        }
    }
}
