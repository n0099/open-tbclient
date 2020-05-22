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
    private ImageView fwy;
    private EditText gxl;
    private ImageView gxm;
    private TextView gxn;
    private FrameLayout jge;
    private BdListView jgm;
    private com.baidu.tieba.mainentrance.searchSuggestList.b jgo;
    private LinearLayoutDetectsSoftKeyboard jhf;
    private QuickWebView jhg;
    private QuickWebView jhh;
    private View jhi;
    private boolean jhj = true;
    private com.baidu.tieba.mainentrance.searchSuggestList.a jhk;
    View jhl;
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
        brb();
        this.jhf = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.jhf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.jhf.setFocusable(true);
                    d.this.jhf.setFocusableInTouchMode(true);
                    if (d.this.gxl.hasFocus()) {
                        l.hideSoftKeyPad(d.this.mContext, d.this.gxl);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.jge = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.jge.addView(this.mNoDataView, 0);
        cvX();
        cvz();
        cvY();
        cvZ();
    }

    private void brb() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.jhl = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.fwy = (ImageView) this.jhl.findViewById(R.id.search_bar_icon);
        this.gxl = (EditText) this.jhl.findViewById(R.id.home_et_search);
        this.gxm = (ImageView) this.jhl.findViewById(R.id.home_bt_search_del);
        this.gxn = (TextView) this.jhl.findViewById(R.id.home_bt_search_cancel_s);
        this.gxm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.gxl.setText("");
            }
        });
        lG(false);
        this.gxn.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.gxl.getText().toString())) {
            this.jhl.setFocusable(true);
            this.jhl.setFocusableInTouchMode(true);
            this.jhl.requestFocus();
        }
    }

    public void qn(boolean z) {
        this.jhj = z;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 0 && this.jhj) {
            this.jhi.setVisibility(0);
            this.jhi.setBackgroundColor(am.getColor(skinType == 4 ? R.color.cp_mask_b_alpha42 : R.color.cp_mask_b_alpha33));
            return;
        }
        this.jhi.setVisibility(8);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        am.setBgColor(this.jhf, i);
        if (i == 2) {
            this.gxl.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
        } else {
            this.gxl.setHintTextColor(am.getColor(R.color.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        SvgManager.aUV().a(this.gxm, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.gxl, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.aUV().a(this.fwy, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        am.setBackgroundResource(this.jge, R.color.cp_bg_line_d);
        am.setViewTextColor(this.gxn, R.color.cp_link_tip_a, 1);
        qn(this.jhj);
        if (this.jhh != null) {
            this.jhh.onChangeSkinType();
        }
        if (this.jhg != null) {
            this.jhg.onChangeSkinType();
        }
    }

    private void cvX() {
        this.jhh = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.jhh.tF(true);
        this.jhi = this.mRootView.findViewById(R.id.search_webview_mask);
    }

    private void cvz() {
        this.jgm = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.jgo = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.jhk = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void cvY() {
        this.jhg = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.jhg.tF(true);
    }

    private void cvZ() {
        this.gxl.setText("");
        this.gxl.requestFocus();
        this.gxn.setText(this.mContext.getString(R.string.cancel));
    }

    public void cwa() {
        this.jhh.setVisibility(0);
        this.jgm.setVisibility(8);
        this.jhg.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void cvK() {
        this.jgm.setVisibility(8);
        this.jhh.setVisibility(8);
        this.jhg.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cvI() {
        this.jgm.setVisibility(0);
        this.jhh.setVisibility(8);
        this.jhg.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void cwb() {
        this.jgm.setVisibility(8);
        this.jhh.setVisibility(8);
        this.jhg.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void lG(boolean z) {
        this.gxm.setVisibility(z ? 0 : 8);
    }

    public void HO(String str) {
        if (!StringUtils.isNull(str)) {
            this.gxl.setHint(str);
        }
    }

    public void HP(String str) {
        if (!StringUtils.isNull(str)) {
            this.gxl.setText(str);
            this.gxl.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!v.isEmpty(list)) {
            cvI();
            this.jgo.HG(str);
            this.jgo.setData(list);
            this.jgm.setAdapter((ListAdapter) this.jgo);
        }
    }

    public void k(List<ForumInfo> list, String str) {
        if (!v.isEmpty(list) && !TextUtils.isEmpty(str)) {
            cvI();
            this.jhk.HG(str);
            this.jhk.dy(list);
            this.jgm.setAdapter((ListAdapter) this.jhk);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.jgm.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.jgm.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.gxl.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.gxl.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.gxl.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.gxl.setOnClickListener(onClickListener);
        this.gxn.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.jhg.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.jhg.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.jhg.setOnLoadUrlListener(bVar);
    }

    public EditText cwc() {
        return this.gxl;
    }

    public TextView cwd() {
        return this.gxn;
    }

    public QuickWebView cwe() {
        return this.jhg;
    }

    public QuickWebView cwf() {
        return this.jhh;
    }

    public boolean cwg() {
        return this.jgm.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.jge != null) {
                this.jge.removeView(this.jhh);
                this.jge.removeView(this.jhg);
            }
            this.jhh.removeAllViews();
            this.jhg.removeAllViews();
            if (this.jhh != null) {
                this.jhh.destroy();
                this.jhh = null;
            }
            if (this.jhg != null) {
                this.jhg.destroy();
                this.jhg = null;
            }
        } catch (Exception e) {
        }
    }
}
