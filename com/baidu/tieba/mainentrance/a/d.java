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
    private ImageView eDH;
    private EditText fCO;
    private ImageView fCP;
    private TextView fCQ;
    private FrameLayout ifi;
    private BdListView ifq;
    private com.baidu.tieba.mainentrance.searchSuggestList.b ifs;
    private LinearLayoutDetectsSoftKeyboard igj;
    private QuickWebView igk;
    private QuickWebView igl;
    private View igm;
    private boolean ign = true;
    private com.baidu.tieba.mainentrance.searchSuggestList.a igo;
    View igp;
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
        bcH();
        this.igj = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.igj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.igj.setFocusable(true);
                    d.this.igj.setFocusableInTouchMode(true);
                    if (d.this.fCO.hasFocus()) {
                        l.hideSoftKeyPad(d.this.mContext, d.this.fCO);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.ifi = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.ifi.addView(this.mNoDataView, 0);
        ceu();
        cdW();
        cev();
        cew();
    }

    private void bcH() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.igp = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.eDH = (ImageView) this.igp.findViewById(R.id.search_bar_icon);
        this.fCO = (EditText) this.igp.findViewById(R.id.home_et_search);
        this.fCP = (ImageView) this.igp.findViewById(R.id.home_bt_search_del);
        this.fCQ = (TextView) this.igp.findViewById(R.id.home_bt_search_cancel_s);
        this.fCP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.fCO.setText("");
            }
        });
        kc(false);
        this.fCQ.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.fCO.getText().toString())) {
            this.igp.setFocusable(true);
            this.igp.setFocusableInTouchMode(true);
            this.igp.requestFocus();
        }
    }

    public void oG(boolean z) {
        this.ign = z;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 0 && this.ign) {
            this.igm.setVisibility(0);
            this.igm.setBackgroundColor(am.getColor(skinType == 4 ? R.color.cp_mask_b_alpha42 : R.color.cp_mask_b_alpha33));
            return;
        }
        this.igm.setVisibility(8);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        am.setBgColor(this.igj, i);
        if (i == 2) {
            this.fCO.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
        } else {
            this.fCO.setHintTextColor(am.getColor(R.color.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        SvgManager.aGA().a(this.fCP, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.fCO, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.aGA().a(this.eDH, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        am.setBackgroundResource(this.ifi, R.color.cp_bg_line_d);
        am.setViewTextColor(this.fCQ, R.color.cp_link_tip_a, 1);
        oG(this.ign);
        if (this.igl != null) {
            this.igl.onChangeSkinType();
        }
        if (this.igk != null) {
            this.igk.onChangeSkinType();
        }
    }

    private void ceu() {
        this.igl = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.igl.rX(true);
        this.igm = this.mRootView.findViewById(R.id.search_webview_mask);
    }

    private void cdW() {
        this.ifq = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.ifs = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.igo = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void cev() {
        this.igk = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.igk.rX(true);
    }

    private void cew() {
        this.fCO.setText("");
        this.fCO.requestFocus();
        this.fCQ.setText(this.mContext.getString(R.string.cancel));
    }

    public void cex() {
        this.igl.setVisibility(0);
        this.ifq.setVisibility(8);
        this.igk.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void ceh() {
        this.ifq.setVisibility(8);
        this.igl.setVisibility(8);
        this.igk.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cef() {
        this.ifq.setVisibility(0);
        this.igl.setVisibility(8);
        this.igk.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void cey() {
        this.ifq.setVisibility(8);
        this.igl.setVisibility(8);
        this.igk.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void kc(boolean z) {
        this.fCP.setVisibility(z ? 0 : 8);
    }

    public void Eu(String str) {
        if (!StringUtils.isNull(str)) {
            this.fCO.setHint(str);
        }
    }

    public void Ev(String str) {
        if (!StringUtils.isNull(str)) {
            this.fCO.setText(str);
            this.fCO.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!v.isEmpty(list)) {
            cef();
            this.ifs.Em(str);
            this.ifs.setData(list);
            this.ifq.setAdapter((ListAdapter) this.ifs);
        }
    }

    public void k(List<ForumInfo> list, String str) {
        if (!v.isEmpty(list) && !TextUtils.isEmpty(str)) {
            cef();
            this.igo.Em(str);
            this.igo.dp(list);
            this.ifq.setAdapter((ListAdapter) this.igo);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.ifq.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.ifq.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.fCO.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.fCO.setOnEditorActionListener(onEditorActionListener);
    }

    public void e(TextWatcher textWatcher) {
        this.fCO.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fCO.setOnClickListener(onClickListener);
        this.fCQ.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.igk.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.igk.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.igk.setOnLoadUrlListener(bVar);
    }

    public EditText cez() {
        return this.fCO;
    }

    public TextView ceA() {
        return this.fCQ;
    }

    public QuickWebView ceB() {
        return this.igk;
    }

    public QuickWebView ceC() {
        return this.igl;
    }

    public boolean ceD() {
        return this.ifq.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.ifi != null) {
                this.ifi.removeView(this.igl);
                this.ifi.removeView(this.igk);
            }
            this.igl.removeAllViews();
            this.igk.removeAllViews();
            if (this.igl != null) {
                this.igl.destroy();
                this.igl = null;
            }
            if (this.igk != null) {
                this.igk.destroy();
                this.igk = null;
            }
        } catch (Exception e) {
        }
    }
}
