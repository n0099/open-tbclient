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
    private ImageView eDV;
    private EditText fDd;
    private ImageView fDe;
    private TextView fDf;
    private BdListView ifE;
    private com.baidu.tieba.mainentrance.searchSuggestList.b ifG;
    private FrameLayout ifw;
    private View igA;
    private boolean igB = true;
    private com.baidu.tieba.mainentrance.searchSuggestList.a igC;
    View igD;
    private LinearLayoutDetectsSoftKeyboard igx;
    private QuickWebView igy;
    private QuickWebView igz;
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
        bcK();
        this.igx = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.igx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.igx.setFocusable(true);
                    d.this.igx.setFocusableInTouchMode(true);
                    if (d.this.fDd.hasFocus()) {
                        l.hideSoftKeyPad(d.this.mContext, d.this.fDd);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.ifw = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.ifw.addView(this.mNoDataView, 0);
        cex();
        cdZ();
        cey();
        cez();
    }

    private void bcK() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.igD = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.eDV = (ImageView) this.igD.findViewById(R.id.search_bar_icon);
        this.fDd = (EditText) this.igD.findViewById(R.id.home_et_search);
        this.fDe = (ImageView) this.igD.findViewById(R.id.home_bt_search_del);
        this.fDf = (TextView) this.igD.findViewById(R.id.home_bt_search_cancel_s);
        this.fDe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.fDd.setText("");
            }
        });
        kc(false);
        this.fDf.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.fDd.getText().toString())) {
            this.igD.setFocusable(true);
            this.igD.setFocusableInTouchMode(true);
            this.igD.requestFocus();
        }
    }

    public void oG(boolean z) {
        this.igB = z;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 0 && this.igB) {
            this.igA.setVisibility(0);
            this.igA.setBackgroundColor(am.getColor(skinType == 4 ? R.color.cp_mask_b_alpha42 : R.color.cp_mask_b_alpha33));
            return;
        }
        this.igA.setVisibility(8);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        am.setBgColor(this.igx, i);
        if (i == 2) {
            this.fDd.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
        } else {
            this.fDd.setHintTextColor(am.getColor(R.color.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        SvgManager.aGC().a(this.fDe, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.fDd, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.aGC().a(this.eDV, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        am.setBackgroundResource(this.ifw, R.color.cp_bg_line_d);
        am.setViewTextColor(this.fDf, R.color.cp_link_tip_a, 1);
        oG(this.igB);
        if (this.igz != null) {
            this.igz.onChangeSkinType();
        }
        if (this.igy != null) {
            this.igy.onChangeSkinType();
        }
    }

    private void cex() {
        this.igz = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.igz.rX(true);
        this.igA = this.mRootView.findViewById(R.id.search_webview_mask);
    }

    private void cdZ() {
        this.ifE = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.ifG = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.igC = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void cey() {
        this.igy = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.igy.rX(true);
    }

    private void cez() {
        this.fDd.setText("");
        this.fDd.requestFocus();
        this.fDf.setText(this.mContext.getString(R.string.cancel));
    }

    public void ceA() {
        this.igz.setVisibility(0);
        this.ifE.setVisibility(8);
        this.igy.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void cek() {
        this.ifE.setVisibility(8);
        this.igz.setVisibility(8);
        this.igy.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cei() {
        this.ifE.setVisibility(0);
        this.igz.setVisibility(8);
        this.igy.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void ceB() {
        this.ifE.setVisibility(8);
        this.igz.setVisibility(8);
        this.igy.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void kc(boolean z) {
        this.fDe.setVisibility(z ? 0 : 8);
    }

    public void Ev(String str) {
        if (!StringUtils.isNull(str)) {
            this.fDd.setHint(str);
        }
    }

    public void Ew(String str) {
        if (!StringUtils.isNull(str)) {
            this.fDd.setText(str);
            this.fDd.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!v.isEmpty(list)) {
            cei();
            this.ifG.En(str);
            this.ifG.setData(list);
            this.ifE.setAdapter((ListAdapter) this.ifG);
        }
    }

    public void k(List<ForumInfo> list, String str) {
        if (!v.isEmpty(list) && !TextUtils.isEmpty(str)) {
            cei();
            this.igC.En(str);
            this.igC.dp(list);
            this.ifE.setAdapter((ListAdapter) this.igC);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.ifE.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.ifE.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.fDd.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.fDd.setOnEditorActionListener(onEditorActionListener);
    }

    public void e(TextWatcher textWatcher) {
        this.fDd.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fDd.setOnClickListener(onClickListener);
        this.fDf.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.igy.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.igy.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.igy.setOnLoadUrlListener(bVar);
    }

    public EditText ceC() {
        return this.fDd;
    }

    public TextView ceD() {
        return this.fDf;
    }

    public QuickWebView ceE() {
        return this.igy;
    }

    public QuickWebView ceF() {
        return this.igz;
    }

    public boolean ceG() {
        return this.ifE.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.ifw != null) {
                this.ifw.removeView(this.igz);
                this.ifw.removeView(this.igy);
            }
            this.igz.removeAllViews();
            this.igy.removeAllViews();
            if (this.igz != null) {
                this.igz.destroy();
                this.igz = null;
            }
            if (this.igy != null) {
                this.igy.destroy();
                this.igy = null;
            }
        } catch (Exception e) {
        }
    }
}
