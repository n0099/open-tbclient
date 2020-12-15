package com.baidu.tieba.mainentrance.view;

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
import com.baidu.adp.base.e;
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
public class c {
    private ImageView eZs;
    private ImageView gNu;
    private EditText ict;
    private TextView icu;
    private FrameLayout kZV;
    private LinearLayoutDetectsSoftKeyboard laW;
    private QuickWebView laX;
    private QuickWebView laY;
    private View laZ;
    private BdListView lad;
    private com.baidu.tieba.mainentrance.searchSuggestList.b laf;
    private boolean lba = true;
    private com.baidu.tieba.mainentrance.searchSuggestList.a lbb;
    View lbc;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public c(View view, Context context) {
        this.mRootView = view;
        this.mContext = context;
        initView();
    }

    private void initView() {
        bFP();
        this.laW = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.laW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.view.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    c.this.laW.setFocusable(true);
                    c.this.laW.setFocusableInTouchMode(true);
                    if (c.this.ict.hasFocus()) {
                        l.hideSoftKeyPad(c.this.mContext, c.this.ict);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.kZV = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.kZV.addView(this.mNoDataView, 0);
        dgw();
        dfY();
        dgx();
        dgy();
    }

    private void bFP() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.lbc = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.gNu = (ImageView) this.lbc.findViewById(R.id.search_bar_icon);
        this.ict = (EditText) this.lbc.findViewById(R.id.home_et_search);
        this.eZs = (ImageView) this.lbc.findViewById(R.id.home_bt_search_del);
        this.icu = (TextView) this.lbc.findViewById(R.id.home_bt_search_cancel_s);
        this.eZs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.ict.setText("");
            }
        });
        oJ(false);
        this.icu.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.ict.getText().toString())) {
            this.lbc.setFocusable(true);
            this.lbc.setFocusableInTouchMode(true);
            this.lbc.requestFocus();
        }
    }

    public void tH(boolean z) {
        this.lba = z;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 0 && this.lba) {
            this.laZ.setVisibility(0);
            this.laZ.setBackgroundColor(ap.getColor(skinType == 4 ? R.color.CAM_X0606 : R.color.CAM_X0605));
            return;
        }
        this.laZ.setVisibility(8);
    }

    public void onChangeSkinType(e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        ap.setBgColor(this.laW, i);
        if (i == 2) {
            this.ict.setHintTextColor(ap.getColor(R.color.s_navbar_title_color));
        } else {
            this.ict.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        SvgManager.btW().a(this.eZs, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.ict, R.color.CAM_X0105, R.color.s_navbar_title_color);
        SvgManager.btW().a(this.gNu, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.kZV, R.color.CAM_X0201);
        ap.setViewTextColor(this.icu, R.color.CAM_X0302, 1);
        tH(this.lba);
        if (this.laY != null) {
            this.laY.onChangeSkinType();
        }
        if (this.laX != null) {
            this.laX.onChangeSkinType();
        }
    }

    private void dgw() {
        this.laY = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.laY.xi(true);
        this.laZ = this.mRootView.findViewById(R.id.search_webview_mask);
    }

    private void dfY() {
        this.lad = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.laf = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.lbb = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void dgx() {
        this.laX = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.laX.xi(true);
    }

    private void dgy() {
        this.ict.setText("");
        this.ict.requestFocus();
        this.icu.setText(this.mContext.getString(R.string.cancel));
    }

    public void dgz() {
        this.laY.setVisibility(0);
        this.lad.setVisibility(8);
        this.laX.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void dgj() {
        this.lad.setVisibility(8);
        this.laY.setVisibility(8);
        this.laX.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void dgh() {
        this.lad.setVisibility(0);
        this.laY.setVisibility(8);
        this.laX.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void dgA() {
        this.lad.setVisibility(8);
        this.laY.setVisibility(8);
        this.laX.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void oJ(boolean z) {
        this.eZs.setVisibility(z ? 0 : 8);
    }

    public void OH(String str) {
        if (!StringUtils.isNull(str)) {
            this.ict.setHint(str);
        }
    }

    public void OI(String str) {
        if (!StringUtils.isNull(str)) {
            this.ict.setText(str);
            this.ict.setSelection(str.length());
        }
    }

    public void o(List<String> list, String str) {
        if (!y.isEmpty(list)) {
            dgh();
            this.laf.OB(str);
            this.laf.setData(list);
            this.lad.setAdapter((ListAdapter) this.laf);
        }
    }

    public void p(List<ForumInfo> list, String str) {
        if (!y.isEmpty(list) && !TextUtils.isEmpty(str)) {
            dgh();
            this.lbb.OB(str);
            this.lbb.eP(list);
            this.lad.setAdapter((ListAdapter) this.lbb);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.lad.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.lad.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.ict.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.ict.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.ict.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ict.setOnClickListener(onClickListener);
        this.icu.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.laX.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.laX.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.g gVar) {
        this.laX.setOnReceivedSslErrorListener(gVar);
    }

    public void a(BaseWebView.b bVar) {
        this.laX.setOnLoadUrlListener(bVar);
    }

    public EditText dgB() {
        return this.ict;
    }

    public TextView dgC() {
        return this.icu;
    }

    public QuickWebView dgD() {
        return this.laX;
    }

    public QuickWebView dgE() {
        return this.laY;
    }

    public boolean dgF() {
        return this.lad.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.kZV != null) {
                this.kZV.removeView(this.laY);
                this.kZV.removeView(this.laX);
            }
            this.laY.removeAllViews();
            this.laX.removeAllViews();
            if (this.laY != null) {
                this.laY.destroy();
                this.laY = null;
            }
            if (this.laX != null) {
                this.laX.destroy();
                this.laX = null;
            }
        } catch (Exception e) {
        }
    }
}
