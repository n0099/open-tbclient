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
    private ImageView gNs;
    private EditText icr;
    private TextView ics;
    private FrameLayout kZT;
    private LinearLayoutDetectsSoftKeyboard laU;
    private QuickWebView laV;
    private QuickWebView laW;
    private View laX;
    private boolean laY = true;
    private com.baidu.tieba.mainentrance.searchSuggestList.a laZ;
    private BdListView lab;
    private com.baidu.tieba.mainentrance.searchSuggestList.b lad;
    View lba;
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
        this.laU = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.laU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.view.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    c.this.laU.setFocusable(true);
                    c.this.laU.setFocusableInTouchMode(true);
                    if (c.this.icr.hasFocus()) {
                        l.hideSoftKeyPad(c.this.mContext, c.this.icr);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.kZT = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.kZT.addView(this.mNoDataView, 0);
        dgv();
        dfX();
        dgw();
        dgx();
    }

    private void bFP() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.lba = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.gNs = (ImageView) this.lba.findViewById(R.id.search_bar_icon);
        this.icr = (EditText) this.lba.findViewById(R.id.home_et_search);
        this.eZs = (ImageView) this.lba.findViewById(R.id.home_bt_search_del);
        this.ics = (TextView) this.lba.findViewById(R.id.home_bt_search_cancel_s);
        this.eZs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.icr.setText("");
            }
        });
        oJ(false);
        this.ics.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.icr.getText().toString())) {
            this.lba.setFocusable(true);
            this.lba.setFocusableInTouchMode(true);
            this.lba.requestFocus();
        }
    }

    public void tH(boolean z) {
        this.laY = z;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 0 && this.laY) {
            this.laX.setVisibility(0);
            this.laX.setBackgroundColor(ap.getColor(skinType == 4 ? R.color.CAM_X0606 : R.color.CAM_X0605));
            return;
        }
        this.laX.setVisibility(8);
    }

    public void onChangeSkinType(e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        ap.setBgColor(this.laU, i);
        if (i == 2) {
            this.icr.setHintTextColor(ap.getColor(R.color.s_navbar_title_color));
        } else {
            this.icr.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        SvgManager.btW().a(this.eZs, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.icr, R.color.CAM_X0105, R.color.s_navbar_title_color);
        SvgManager.btW().a(this.gNs, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.kZT, R.color.CAM_X0201);
        ap.setViewTextColor(this.ics, R.color.CAM_X0302, 1);
        tH(this.laY);
        if (this.laW != null) {
            this.laW.onChangeSkinType();
        }
        if (this.laV != null) {
            this.laV.onChangeSkinType();
        }
    }

    private void dgv() {
        this.laW = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.laW.xi(true);
        this.laX = this.mRootView.findViewById(R.id.search_webview_mask);
    }

    private void dfX() {
        this.lab = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.lad = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.laZ = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void dgw() {
        this.laV = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.laV.xi(true);
    }

    private void dgx() {
        this.icr.setText("");
        this.icr.requestFocus();
        this.ics.setText(this.mContext.getString(R.string.cancel));
    }

    public void dgy() {
        this.laW.setVisibility(0);
        this.lab.setVisibility(8);
        this.laV.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void dgi() {
        this.lab.setVisibility(8);
        this.laW.setVisibility(8);
        this.laV.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void dgg() {
        this.lab.setVisibility(0);
        this.laW.setVisibility(8);
        this.laV.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void dgz() {
        this.lab.setVisibility(8);
        this.laW.setVisibility(8);
        this.laV.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void oJ(boolean z) {
        this.eZs.setVisibility(z ? 0 : 8);
    }

    public void OH(String str) {
        if (!StringUtils.isNull(str)) {
            this.icr.setHint(str);
        }
    }

    public void OI(String str) {
        if (!StringUtils.isNull(str)) {
            this.icr.setText(str);
            this.icr.setSelection(str.length());
        }
    }

    public void o(List<String> list, String str) {
        if (!y.isEmpty(list)) {
            dgg();
            this.lad.OB(str);
            this.lad.setData(list);
            this.lab.setAdapter((ListAdapter) this.lad);
        }
    }

    public void p(List<ForumInfo> list, String str) {
        if (!y.isEmpty(list) && !TextUtils.isEmpty(str)) {
            dgg();
            this.laZ.OB(str);
            this.laZ.eP(list);
            this.lab.setAdapter((ListAdapter) this.laZ);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.lab.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.lab.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.icr.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.icr.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.icr.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.icr.setOnClickListener(onClickListener);
        this.ics.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.laV.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.laV.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.g gVar) {
        this.laV.setOnReceivedSslErrorListener(gVar);
    }

    public void a(BaseWebView.b bVar) {
        this.laV.setOnLoadUrlListener(bVar);
    }

    public EditText dgA() {
        return this.icr;
    }

    public TextView dgB() {
        return this.ics;
    }

    public QuickWebView dgC() {
        return this.laV;
    }

    public QuickWebView dgD() {
        return this.laW;
    }

    public boolean dgE() {
        return this.lab.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.kZT != null) {
                this.kZT.removeView(this.laW);
                this.kZT.removeView(this.laV);
            }
            this.laW.removeAllViews();
            this.laV.removeAllViews();
            if (this.laW != null) {
                this.laW.destroy();
                this.laW = null;
            }
            if (this.laV != null) {
                this.laV.destroy();
                this.laV = null;
            }
        } catch (Exception e) {
        }
    }
}
