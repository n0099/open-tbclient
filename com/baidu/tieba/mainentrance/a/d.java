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
    private ImageView eDI;
    private EditText fCQ;
    private ImageView fCR;
    private TextView fCS;
    private FrameLayout ifk;
    private BdListView ifs;
    private com.baidu.tieba.mainentrance.searchSuggestList.b ifu;
    private LinearLayoutDetectsSoftKeyboard igl;
    private QuickWebView igm;
    private QuickWebView ign;
    private View igo;
    private boolean igp = true;
    private com.baidu.tieba.mainentrance.searchSuggestList.a igq;
    View igr;
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
        bcJ();
        this.igl = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.igl.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.igl.setFocusable(true);
                    d.this.igl.setFocusableInTouchMode(true);
                    if (d.this.fCQ.hasFocus()) {
                        l.hideSoftKeyPad(d.this.mContext, d.this.fCQ);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.ifk = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.ifk.addView(this.mNoDataView, 0);
        cew();
        cdY();
        cex();
        cey();
    }

    private void bcJ() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.igr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.eDI = (ImageView) this.igr.findViewById(R.id.search_bar_icon);
        this.fCQ = (EditText) this.igr.findViewById(R.id.home_et_search);
        this.fCR = (ImageView) this.igr.findViewById(R.id.home_bt_search_del);
        this.fCS = (TextView) this.igr.findViewById(R.id.home_bt_search_cancel_s);
        this.fCR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.fCQ.setText("");
            }
        });
        kc(false);
        this.fCS.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.fCQ.getText().toString())) {
            this.igr.setFocusable(true);
            this.igr.setFocusableInTouchMode(true);
            this.igr.requestFocus();
        }
    }

    public void oG(boolean z) {
        this.igp = z;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 0 && this.igp) {
            this.igo.setVisibility(0);
            this.igo.setBackgroundColor(am.getColor(skinType == 4 ? R.color.cp_mask_b_alpha42 : R.color.cp_mask_b_alpha33));
            return;
        }
        this.igo.setVisibility(8);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        am.setBgColor(this.igl, i);
        if (i == 2) {
            this.fCQ.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
        } else {
            this.fCQ.setHintTextColor(am.getColor(R.color.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        SvgManager.aGC().a(this.fCR, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.fCQ, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.aGC().a(this.eDI, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        am.setBackgroundResource(this.ifk, R.color.cp_bg_line_d);
        am.setViewTextColor(this.fCS, R.color.cp_link_tip_a, 1);
        oG(this.igp);
        if (this.ign != null) {
            this.ign.onChangeSkinType();
        }
        if (this.igm != null) {
            this.igm.onChangeSkinType();
        }
    }

    private void cew() {
        this.ign = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.ign.rX(true);
        this.igo = this.mRootView.findViewById(R.id.search_webview_mask);
    }

    private void cdY() {
        this.ifs = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.ifu = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.igq = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void cex() {
        this.igm = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.igm.rX(true);
    }

    private void cey() {
        this.fCQ.setText("");
        this.fCQ.requestFocus();
        this.fCS.setText(this.mContext.getString(R.string.cancel));
    }

    public void cez() {
        this.ign.setVisibility(0);
        this.ifs.setVisibility(8);
        this.igm.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void cej() {
        this.ifs.setVisibility(8);
        this.ign.setVisibility(8);
        this.igm.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void ceh() {
        this.ifs.setVisibility(0);
        this.ign.setVisibility(8);
        this.igm.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void ceA() {
        this.ifs.setVisibility(8);
        this.ign.setVisibility(8);
        this.igm.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void kc(boolean z) {
        this.fCR.setVisibility(z ? 0 : 8);
    }

    public void Eu(String str) {
        if (!StringUtils.isNull(str)) {
            this.fCQ.setHint(str);
        }
    }

    public void Ev(String str) {
        if (!StringUtils.isNull(str)) {
            this.fCQ.setText(str);
            this.fCQ.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!v.isEmpty(list)) {
            ceh();
            this.ifu.Em(str);
            this.ifu.setData(list);
            this.ifs.setAdapter((ListAdapter) this.ifu);
        }
    }

    public void k(List<ForumInfo> list, String str) {
        if (!v.isEmpty(list) && !TextUtils.isEmpty(str)) {
            ceh();
            this.igq.Em(str);
            this.igq.dp(list);
            this.ifs.setAdapter((ListAdapter) this.igq);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.ifs.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.ifs.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.fCQ.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.fCQ.setOnEditorActionListener(onEditorActionListener);
    }

    public void e(TextWatcher textWatcher) {
        this.fCQ.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fCQ.setOnClickListener(onClickListener);
        this.fCS.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.igm.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.igm.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.igm.setOnLoadUrlListener(bVar);
    }

    public EditText ceB() {
        return this.fCQ;
    }

    public TextView ceC() {
        return this.fCS;
    }

    public QuickWebView ceD() {
        return this.igm;
    }

    public QuickWebView ceE() {
        return this.ign;
    }

    public boolean ceF() {
        return this.ifs.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.ifk != null) {
                this.ifk.removeView(this.ign);
                this.ifk.removeView(this.igm);
            }
            this.ign.removeAllViews();
            this.igm.removeAllViews();
            if (this.ign != null) {
                this.ign.destroy();
                this.ign = null;
            }
            if (this.igm != null) {
                this.igm.destroy();
                this.igm = null;
            }
        } catch (Exception e) {
        }
    }
}
