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
    private ImageView fiR;
    private EditText giv;
    private ImageView giw;
    private TextView gix;
    private FrameLayout iRd;
    private BdListView iRl;
    private com.baidu.tieba.mainentrance.searchSuggestList.b iRn;
    private LinearLayoutDetectsSoftKeyboard iSe;
    private QuickWebView iSf;
    private QuickWebView iSg;
    private View iSh;
    private boolean iSi = true;
    private com.baidu.tieba.mainentrance.searchSuggestList.a iSj;
    View iSk;
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
        blD();
        this.iSe = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.iSe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.iSe.setFocusable(true);
                    d.this.iSe.setFocusableInTouchMode(true);
                    if (d.this.giv.hasFocus()) {
                        l.hideSoftKeyPad(d.this.mContext, d.this.giv);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.iRd = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.iRd.addView(this.mNoDataView, 0);
        cpv();
        coX();
        cpw();
        cpx();
    }

    private void blD() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.iSk = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.fiR = (ImageView) this.iSk.findViewById(R.id.search_bar_icon);
        this.giv = (EditText) this.iSk.findViewById(R.id.home_et_search);
        this.giw = (ImageView) this.iSk.findViewById(R.id.home_bt_search_del);
        this.gix = (TextView) this.iSk.findViewById(R.id.home_bt_search_cancel_s);
        this.giw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.giv.setText("");
            }
        });
        lk(false);
        this.gix.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.giv.getText().toString())) {
            this.iSk.setFocusable(true);
            this.iSk.setFocusableInTouchMode(true);
            this.iSk.requestFocus();
        }
    }

    public void pQ(boolean z) {
        this.iSi = z;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 0 && this.iSi) {
            this.iSh.setVisibility(0);
            this.iSh.setBackgroundColor(am.getColor(skinType == 4 ? R.color.cp_mask_b_alpha42 : R.color.cp_mask_b_alpha33));
            return;
        }
        this.iSh.setVisibility(8);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        am.setBgColor(this.iSe, i);
        if (i == 2) {
            this.giv.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
        } else {
            this.giv.setHintTextColor(am.getColor(R.color.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        SvgManager.aOR().a(this.giw, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.giv, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.aOR().a(this.fiR, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        am.setBackgroundResource(this.iRd, R.color.cp_bg_line_d);
        am.setViewTextColor(this.gix, R.color.cp_link_tip_a, 1);
        pQ(this.iSi);
        if (this.iSg != null) {
            this.iSg.onChangeSkinType();
        }
        if (this.iSf != null) {
            this.iSf.onChangeSkinType();
        }
    }

    private void cpv() {
        this.iSg = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.iSg.th(true);
        this.iSh = this.mRootView.findViewById(R.id.search_webview_mask);
    }

    private void coX() {
        this.iRl = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.iRn = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.iSj = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void cpw() {
        this.iSf = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.iSf.th(true);
    }

    private void cpx() {
        this.giv.setText("");
        this.giv.requestFocus();
        this.gix.setText(this.mContext.getString(R.string.cancel));
    }

    public void cpy() {
        this.iSg.setVisibility(0);
        this.iRl.setVisibility(8);
        this.iSf.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void cpi() {
        this.iRl.setVisibility(8);
        this.iSg.setVisibility(8);
        this.iSf.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cpg() {
        this.iRl.setVisibility(0);
        this.iSg.setVisibility(8);
        this.iSf.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void cpz() {
        this.iRl.setVisibility(8);
        this.iSg.setVisibility(8);
        this.iSf.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void lk(boolean z) {
        this.giw.setVisibility(z ? 0 : 8);
    }

    public void Gf(String str) {
        if (!StringUtils.isNull(str)) {
            this.giv.setHint(str);
        }
    }

    public void Gg(String str) {
        if (!StringUtils.isNull(str)) {
            this.giv.setText(str);
            this.giv.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!v.isEmpty(list)) {
            cpg();
            this.iRn.FX(str);
            this.iRn.setData(list);
            this.iRl.setAdapter((ListAdapter) this.iRn);
        }
    }

    public void k(List<ForumInfo> list, String str) {
        if (!v.isEmpty(list) && !TextUtils.isEmpty(str)) {
            cpg();
            this.iSj.FX(str);
            this.iSj.dA(list);
            this.iRl.setAdapter((ListAdapter) this.iSj);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.iRl.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.iRl.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.giv.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.giv.setOnEditorActionListener(onEditorActionListener);
    }

    public void e(TextWatcher textWatcher) {
        this.giv.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.giv.setOnClickListener(onClickListener);
        this.gix.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.iSf.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.iSf.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.iSf.setOnLoadUrlListener(bVar);
    }

    public EditText cpA() {
        return this.giv;
    }

    public TextView cpB() {
        return this.gix;
    }

    public QuickWebView cpC() {
        return this.iSf;
    }

    public QuickWebView cpD() {
        return this.iSg;
    }

    public boolean cpE() {
        return this.iRl.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.iRd != null) {
                this.iRd.removeView(this.iSg);
                this.iRd.removeView(this.iSf);
            }
            this.iSg.removeAllViews();
            this.iSf.removeAllViews();
            if (this.iSg != null) {
                this.iSg.destroy();
                this.iSg = null;
            }
            if (this.iSf != null) {
                this.iSf.destroy();
                this.iSf = null;
            }
        } catch (Exception e) {
        }
    }
}
