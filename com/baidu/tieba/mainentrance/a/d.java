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
    private ImageView dJZ;
    private EditText eFh;
    private ImageView eFi;
    private TextView eFj;
    private FrameLayout hlD;
    private BdListView hlL;
    private com.baidu.tieba.mainentrance.searchSuggestList.b hlN;
    private LinearLayoutDetectsSoftKeyboard hmE;
    private QuickWebView hmF;
    private QuickWebView hmG;
    private com.baidu.tieba.mainentrance.searchSuggestList.a hmH;
    View hmI;
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
        aJv();
        this.hmE = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.hmE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.hmE.setFocusable(true);
                    d.this.hmE.setFocusableInTouchMode(true);
                    if (d.this.eFh.hasFocus()) {
                        l.hideSoftKeyPad(d.this.mContext, d.this.eFh);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.hlD = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.hlD.addView(this.mNoDataView, 0);
        bKt();
        bJW();
        bKu();
        bKv();
    }

    private void aJv() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.hmI = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.dJZ = (ImageView) this.hmI.findViewById(R.id.search_bar_icon);
        this.eFh = (EditText) this.hmI.findViewById(R.id.home_et_search);
        this.eFi = (ImageView) this.hmI.findViewById(R.id.home_bt_search_del);
        this.eFj = (TextView) this.hmI.findViewById(R.id.home_bt_search_cancel_s);
        this.eFi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.eFh.setText("");
            }
        });
        iy(false);
        this.eFj.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.eFh.getText().toString())) {
            this.hmI.setFocusable(true);
            this.hmI.setFocusableInTouchMode(true);
            this.hmI.requestFocus();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        am.setBgColor(this.hmE, i);
        if (i == 2) {
            this.eFh.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
        } else {
            this.eFh.setHintTextColor(am.getColor(R.color.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        SvgManager.amL().a(this.eFi, R.drawable.icon_pure_search_empty_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.eFh, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.amL().a(this.dJZ, R.drawable.icon_pure_search_import_n_svg, R.color.cp_cont_d, null);
        am.setBackgroundResource(this.hlD, R.color.cp_bg_line_d);
        am.setViewTextColor(this.eFj, R.color.cp_link_tip_a, 1);
    }

    private void bKt() {
        this.hmG = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.hmG.pZ(true);
    }

    private void bJW() {
        this.hlL = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.hlN = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.hmH = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void bKu() {
        this.hmF = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.hmF.pZ(true);
    }

    private void bKv() {
        this.eFh.setText("");
        this.eFh.requestFocus();
        this.eFj.setText(this.mContext.getString(R.string.cancel));
    }

    public void bKw() {
        this.hmG.setVisibility(0);
        this.hlL.setVisibility(8);
        this.hmF.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bKg() {
        this.hlL.setVisibility(8);
        this.hmG.setVisibility(8);
        this.hmF.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bKe() {
        this.hlL.setVisibility(0);
        this.hmG.setVisibility(8);
        this.hmF.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bKx() {
        this.hlL.setVisibility(8);
        this.hmG.setVisibility(8);
        this.hmF.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void iy(boolean z) {
        this.eFi.setVisibility(z ? 0 : 8);
    }

    public void zm(String str) {
        if (!StringUtils.isNull(str)) {
            this.eFh.setHint(str);
        }
    }

    public void zn(String str) {
        if (!StringUtils.isNull(str)) {
            this.eFh.setText(str);
            this.eFh.setSelection(str.length());
        }
    }

    public void i(List<String> list, String str) {
        if (!v.isEmpty(list)) {
            bKe();
            this.hlN.ze(str);
            this.hlN.setData(list);
            this.hlL.setAdapter((ListAdapter) this.hlN);
        }
    }

    public void j(List<ForumInfo> list, String str) {
        if (!v.isEmpty(list) && !TextUtils.isEmpty(str)) {
            bKe();
            this.hmH.ze(str);
            this.hmH.dE(list);
            this.hlL.setAdapter((ListAdapter) this.hmH);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.hlL.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.hlL.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.eFh.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.eFh.setOnEditorActionListener(onEditorActionListener);
    }

    public void f(TextWatcher textWatcher) {
        this.eFh.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eFh.setOnClickListener(onClickListener);
        this.eFj.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.hmF.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.hmF.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.hmF.setOnLoadUrlListener(bVar);
    }

    public EditText bKy() {
        return this.eFh;
    }

    public TextView bKz() {
        return this.eFj;
    }

    public QuickWebView bKA() {
        return this.hmF;
    }

    public QuickWebView bKB() {
        return this.hmG;
    }

    public boolean bKC() {
        return this.hlL.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.hlD != null) {
                this.hlD.removeView(this.hmG);
                this.hlD.removeView(this.hmF);
            }
            this.hmG.removeAllViews();
            this.hmF.removeAllViews();
            if (this.hmG != null) {
                this.hmG.destroy();
                this.hmG = null;
            }
            if (this.hmF != null) {
                this.hmF.destroy();
                this.hmF = null;
            }
        } catch (Exception e) {
        }
    }
}
