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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
    private ImageView fNo;
    private EditText gPQ;
    private ImageView gPR;
    private TextView gPS;
    private FrameLayout jGG;
    private BdListView jGO;
    private com.baidu.tieba.mainentrance.searchSuggestList.b jGQ;
    private LinearLayoutDetectsSoftKeyboard jHH;
    private QuickWebView jHI;
    private QuickWebView jHJ;
    private View jHK;
    private boolean jHL = true;
    private com.baidu.tieba.mainentrance.searchSuggestList.a jHM;
    View jHN;
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
        bmb();
        this.jHH = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.jHH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.jHH.setFocusable(true);
                    d.this.jHH.setFocusableInTouchMode(true);
                    if (d.this.gPQ.hasFocus()) {
                        l.hideSoftKeyPad(d.this.mContext, d.this.gPQ);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.jGG = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.jGG.addView(this.mNoDataView, 0);
        cDV();
        cDx();
        cDW();
        cDX();
    }

    private void bmb() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.jHN = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.fNo = (ImageView) this.jHN.findViewById(R.id.search_bar_icon);
        this.gPQ = (EditText) this.jHN.findViewById(R.id.home_et_search);
        this.gPR = (ImageView) this.jHN.findViewById(R.id.home_bt_search_del);
        this.gPS = (TextView) this.jHN.findViewById(R.id.home_bt_search_cancel_s);
        this.gPR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.gPQ.setText("");
            }
        });
        mu(false);
        this.gPS.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.gPQ.getText().toString())) {
            this.jHN.setFocusable(true);
            this.jHN.setFocusableInTouchMode(true);
            this.jHN.requestFocus();
        }
    }

    public void re(boolean z) {
        this.jHL = z;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 0 && this.jHL) {
            this.jHK.setVisibility(0);
            this.jHK.setBackgroundColor(ao.getColor(skinType == 4 ? R.color.cp_mask_b_alpha42 : R.color.cp_mask_b_alpha33));
            return;
        }
        this.jHK.setVisibility(8);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        ao.setBgColor(this.jHH, i);
        if (i == 2) {
            this.gPQ.setHintTextColor(ao.getColor(R.color.s_navbar_title_color));
        } else {
            this.gPQ.setHintTextColor(ao.getColor(R.color.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        SvgManager.baR().a(this.gPR, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ao.setNavbarTitleColor(this.gPQ, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.baR().a(this.fNo, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        ao.setBackgroundResource(this.jGG, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.gPS, R.color.cp_link_tip_a, 1);
        re(this.jHL);
        if (this.jHJ != null) {
            this.jHJ.onChangeSkinType();
        }
        if (this.jHI != null) {
            this.jHI.onChangeSkinType();
        }
    }

    private void cDV() {
        this.jHJ = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.jHJ.uy(true);
        this.jHK = this.mRootView.findViewById(R.id.search_webview_mask);
    }

    private void cDx() {
        this.jGO = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.jGQ = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.jHM = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void cDW() {
        this.jHI = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.jHI.uy(true);
    }

    private void cDX() {
        this.gPQ.setText("");
        this.gPQ.requestFocus();
        this.gPS.setText(this.mContext.getString(R.string.cancel));
    }

    public void cDY() {
        this.jHJ.setVisibility(0);
        this.jGO.setVisibility(8);
        this.jHI.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void cDI() {
        this.jGO.setVisibility(8);
        this.jHJ.setVisibility(8);
        this.jHI.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cDG() {
        this.jGO.setVisibility(0);
        this.jHJ.setVisibility(8);
        this.jHI.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void cDZ() {
        this.jGO.setVisibility(8);
        this.jHJ.setVisibility(8);
        this.jHI.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void mu(boolean z) {
        this.gPR.setVisibility(z ? 0 : 8);
    }

    public void Jf(String str) {
        if (!StringUtils.isNull(str)) {
            this.gPQ.setHint(str);
        }
    }

    public void Jg(String str) {
        if (!StringUtils.isNull(str)) {
            this.gPQ.setText(str);
            this.gPQ.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!x.isEmpty(list)) {
            cDG();
            this.jGQ.IX(str);
            this.jGQ.setData(list);
            this.jGO.setAdapter((ListAdapter) this.jGQ);
        }
    }

    public void k(List<ForumInfo> list, String str) {
        if (!x.isEmpty(list) && !TextUtils.isEmpty(str)) {
            cDG();
            this.jHM.IX(str);
            this.jHM.dU(list);
            this.jGO.setAdapter((ListAdapter) this.jHM);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.jGO.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.jGO.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.gPQ.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.gPQ.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.gPQ.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.gPQ.setOnClickListener(onClickListener);
        this.gPS.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.jHI.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.jHI.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.g gVar) {
        this.jHI.setOnReceivedSslErrorListener(gVar);
    }

    public void a(BaseWebView.b bVar) {
        this.jHI.setOnLoadUrlListener(bVar);
    }

    public EditText cEa() {
        return this.gPQ;
    }

    public TextView cEb() {
        return this.gPS;
    }

    public QuickWebView cEc() {
        return this.jHI;
    }

    public QuickWebView cEd() {
        return this.jHJ;
    }

    public boolean cEe() {
        return this.jGO.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.jGG != null) {
                this.jGG.removeView(this.jHJ);
                this.jGG.removeView(this.jHI);
            }
            this.jHJ.removeAllViews();
            this.jHI.removeAllViews();
            if (this.jHJ != null) {
                this.jHJ.destroy();
                this.jHJ = null;
            }
            if (this.jHI != null) {
                this.jHI.destroy();
                this.jHI = null;
            }
        } catch (Exception e) {
        }
    }
}
