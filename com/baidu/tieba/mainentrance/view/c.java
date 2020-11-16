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
/* loaded from: classes23.dex */
public class c {
    private ImageView gEv;
    private EditText hRx;
    private ImageView hRy;
    private TextView hRz;
    private FrameLayout kMC;
    private BdListView kMK;
    private com.baidu.tieba.mainentrance.searchSuggestList.b kMM;
    private LinearLayoutDetectsSoftKeyboard kNC;
    private QuickWebView kND;
    private QuickWebView kNE;
    private View kNF;
    private boolean kNG = true;
    private com.baidu.tieba.mainentrance.searchSuggestList.a kNH;
    View kNI;
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
        bCo();
        this.kNC = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.kNC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.view.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    c.this.kNC.setFocusable(true);
                    c.this.kNC.setFocusableInTouchMode(true);
                    if (c.this.hRx.hasFocus()) {
                        l.hideSoftKeyPad(c.this.mContext, c.this.hRx);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.kMC = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.kMC.addView(this.mNoDataView, 0);
        dbj();
        daL();
        dbk();
        dbl();
    }

    private void bCo() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.kNI = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.gEv = (ImageView) this.kNI.findViewById(R.id.search_bar_icon);
        this.hRx = (EditText) this.kNI.findViewById(R.id.home_et_search);
        this.hRy = (ImageView) this.kNI.findViewById(R.id.home_bt_search_del);
        this.hRz = (TextView) this.kNI.findViewById(R.id.home_bt_search_cancel_s);
        this.hRy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hRx.setText("");
            }
        });
        on(false);
        this.hRz.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.hRx.getText().toString())) {
            this.kNI.setFocusable(true);
            this.kNI.setFocusableInTouchMode(true);
            this.kNI.requestFocus();
        }
    }

    public void tf(boolean z) {
        this.kNG = z;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 0 && this.kNG) {
            this.kNF.setVisibility(0);
            this.kNF.setBackgroundColor(ap.getColor(skinType == 4 ? R.color.CAM_X0606 : R.color.CAM_X0605));
            return;
        }
        this.kNF.setVisibility(8);
    }

    public void onChangeSkinType(e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        ap.setBgColor(this.kNC, i);
        if (i == 2) {
            this.hRx.setHintTextColor(ap.getColor(R.color.s_navbar_title_color));
        } else {
            this.hRx.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        SvgManager.bqB().a(this.hRy, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.hRx, R.color.CAM_X0105, R.color.s_navbar_title_color);
        SvgManager.bqB().a(this.gEv, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.kMC, R.color.CAM_X0201);
        ap.setViewTextColor(this.hRz, R.color.CAM_X0302, 1);
        tf(this.kNG);
        if (this.kNE != null) {
            this.kNE.onChangeSkinType();
        }
        if (this.kND != null) {
            this.kND.onChangeSkinType();
        }
    }

    private void dbj() {
        this.kNE = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.kNE.wE(true);
        this.kNF = this.mRootView.findViewById(R.id.search_webview_mask);
    }

    private void daL() {
        this.kMK = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.kMM = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.kNH = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void dbk() {
        this.kND = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.kND.wE(true);
    }

    private void dbl() {
        this.hRx.setText("");
        this.hRx.requestFocus();
        this.hRz.setText(this.mContext.getString(R.string.cancel));
    }

    public void dbm() {
        this.kNE.setVisibility(0);
        this.kMK.setVisibility(8);
        this.kND.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void daW() {
        this.kMK.setVisibility(8);
        this.kNE.setVisibility(8);
        this.kND.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void daU() {
        this.kMK.setVisibility(0);
        this.kNE.setVisibility(8);
        this.kND.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void dbn() {
        this.kMK.setVisibility(8);
        this.kNE.setVisibility(8);
        this.kND.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void on(boolean z) {
        this.hRy.setVisibility(z ? 0 : 8);
    }

    public void NA(String str) {
        if (!StringUtils.isNull(str)) {
            this.hRx.setHint(str);
        }
    }

    public void NB(String str) {
        if (!StringUtils.isNull(str)) {
            this.hRx.setText(str);
            this.hRx.setSelection(str.length());
        }
    }

    public void m(List<String> list, String str) {
        if (!y.isEmpty(list)) {
            daU();
            this.kMM.Nu(str);
            this.kMM.setData(list);
            this.kMK.setAdapter((ListAdapter) this.kMM);
        }
    }

    public void n(List<ForumInfo> list, String str) {
        if (!y.isEmpty(list) && !TextUtils.isEmpty(str)) {
            daU();
            this.kNH.Nu(str);
            this.kNH.eE(list);
            this.kMK.setAdapter((ListAdapter) this.kNH);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.kMK.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.kMK.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.hRx.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.hRx.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.hRx.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.hRx.setOnClickListener(onClickListener);
        this.hRz.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.kND.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.kND.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.g gVar) {
        this.kND.setOnReceivedSslErrorListener(gVar);
    }

    public void a(BaseWebView.b bVar) {
        this.kND.setOnLoadUrlListener(bVar);
    }

    public EditText dbo() {
        return this.hRx;
    }

    public TextView dbp() {
        return this.hRz;
    }

    public QuickWebView dbq() {
        return this.kND;
    }

    public QuickWebView dbr() {
        return this.kNE;
    }

    public boolean dbs() {
        return this.kMK.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.kMC != null) {
                this.kMC.removeView(this.kNE);
                this.kMC.removeView(this.kND);
            }
            this.kNE.removeAllViews();
            this.kND.removeAllViews();
            if (this.kNE != null) {
                this.kNE.destroy();
                this.kNE = null;
            }
            if (this.kND != null) {
                this.kND.destroy();
                this.kND = null;
            }
        } catch (Exception e) {
        }
    }
}
