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
/* loaded from: classes23.dex */
public class d {
    private ImageView gcE;
    private EditText hjJ;
    private ImageView hjK;
    private TextView hjL;
    private FrameLayout keH;
    private BdListView keP;
    private com.baidu.tieba.mainentrance.searchSuggestList.b keR;
    private LinearLayoutDetectsSoftKeyboard kfI;
    private QuickWebView kfJ;
    private QuickWebView kfK;
    private View kfL;
    private boolean kfM = true;
    private com.baidu.tieba.mainentrance.searchSuggestList.a kfN;
    View kfO;
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
        bvT();
        this.kfI = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.kfI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.kfI.setFocusable(true);
                    d.this.kfI.setFocusableInTouchMode(true);
                    if (d.this.hjJ.hasFocus()) {
                        l.hideSoftKeyPad(d.this.mContext, d.this.hjJ);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.keH = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.keH.addView(this.mNoDataView, 0);
        cSs();
        cRU();
        cSt();
        cSu();
    }

    private void bvT() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.kfO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.gcE = (ImageView) this.kfO.findViewById(R.id.search_bar_icon);
        this.hjJ = (EditText) this.kfO.findViewById(R.id.home_et_search);
        this.hjK = (ImageView) this.kfO.findViewById(R.id.home_bt_search_del);
        this.hjL = (TextView) this.kfO.findViewById(R.id.home_bt_search_cancel_s);
        this.hjK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.hjJ.setText("");
            }
        });
        nf(false);
        this.hjL.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.hjJ.getText().toString())) {
            this.kfO.setFocusable(true);
            this.kfO.setFocusableInTouchMode(true);
            this.kfO.requestFocus();
        }
    }

    public void rU(boolean z) {
        this.kfM = z;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 0 && this.kfM) {
            this.kfL.setVisibility(0);
            this.kfL.setBackgroundColor(ap.getColor(skinType == 4 ? R.color.cp_mask_b_alpha42 : R.color.cp_mask_b_alpha33));
            return;
        }
        this.kfL.setVisibility(8);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        ap.setBgColor(this.kfI, i);
        if (i == 2) {
            this.hjJ.setHintTextColor(ap.getColor(R.color.s_navbar_title_color));
        } else {
            this.hjJ.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        SvgManager.bkl().a(this.hjK, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.hjJ, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.bkl().a(this.gcE, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.keH, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.hjL, R.color.cp_link_tip_a, 1);
        rU(this.kfM);
        if (this.kfK != null) {
            this.kfK.onChangeSkinType();
        }
        if (this.kfJ != null) {
            this.kfJ.onChangeSkinType();
        }
    }

    private void cSs() {
        this.kfK = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.kfK.vu(true);
        this.kfL = this.mRootView.findViewById(R.id.search_webview_mask);
    }

    private void cRU() {
        this.keP = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.keR = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.kfN = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void cSt() {
        this.kfJ = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.kfJ.vu(true);
    }

    private void cSu() {
        this.hjJ.setText("");
        this.hjJ.requestFocus();
        this.hjL.setText(this.mContext.getString(R.string.cancel));
    }

    public void cSv() {
        this.kfK.setVisibility(0);
        this.keP.setVisibility(8);
        this.kfJ.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void cSf() {
        this.keP.setVisibility(8);
        this.kfK.setVisibility(8);
        this.kfJ.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cSd() {
        this.keP.setVisibility(0);
        this.kfK.setVisibility(8);
        this.kfJ.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void cSw() {
        this.keP.setVisibility(8);
        this.kfK.setVisibility(8);
        this.kfJ.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void nf(boolean z) {
        this.hjK.setVisibility(z ? 0 : 8);
    }

    public void MA(String str) {
        if (!StringUtils.isNull(str)) {
            this.hjJ.setHint(str);
        }
    }

    public void MB(String str) {
        if (!StringUtils.isNull(str)) {
            this.hjJ.setText(str);
            this.hjJ.setSelection(str.length());
        }
    }

    public void k(List<String> list, String str) {
        if (!y.isEmpty(list)) {
            cSd();
            this.keR.Ms(str);
            this.keR.setData(list);
            this.keP.setAdapter((ListAdapter) this.keR);
        }
    }

    public void l(List<ForumInfo> list, String str) {
        if (!y.isEmpty(list) && !TextUtils.isEmpty(str)) {
            cSd();
            this.kfN.Ms(str);
            this.kfN.ek(list);
            this.keP.setAdapter((ListAdapter) this.kfN);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.keP.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.keP.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.hjJ.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.hjJ.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.hjJ.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.hjJ.setOnClickListener(onClickListener);
        this.hjL.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.kfJ.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.kfJ.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.g gVar) {
        this.kfJ.setOnReceivedSslErrorListener(gVar);
    }

    public void a(BaseWebView.b bVar) {
        this.kfJ.setOnLoadUrlListener(bVar);
    }

    public EditText cSx() {
        return this.hjJ;
    }

    public TextView cSy() {
        return this.hjL;
    }

    public QuickWebView cSz() {
        return this.kfJ;
    }

    public QuickWebView cSA() {
        return this.kfK;
    }

    public boolean cSB() {
        return this.keP.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.keH != null) {
                this.keH.removeView(this.kfK);
                this.keH.removeView(this.kfJ);
            }
            this.kfK.removeAllViews();
            this.kfJ.removeAllViews();
            if (this.kfK != null) {
                this.kfK.destroy();
                this.kfK = null;
            }
            if (this.kfJ != null) {
                this.kfJ.destroy();
                this.kfJ = null;
            }
        } catch (Exception e) {
        }
    }
}
