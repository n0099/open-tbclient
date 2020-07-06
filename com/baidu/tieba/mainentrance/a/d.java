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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
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
    private ImageView fHT;
    private EditText gKk;
    private ImageView gKl;
    private TextView gKm;
    private FrameLayout jya;
    private BdListView jyi;
    private com.baidu.tieba.mainentrance.searchSuggestList.b jyk;
    private LinearLayoutDetectsSoftKeyboard jzb;
    private QuickWebView jzc;
    private QuickWebView jzd;
    private View jze;
    private boolean jzf = true;
    private com.baidu.tieba.mainentrance.searchSuggestList.a jzg;
    View jzh;
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
        biq();
        this.jzb = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.jzb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.jzb.setFocusable(true);
                    d.this.jzb.setFocusableInTouchMode(true);
                    if (d.this.gKk.hasFocus()) {
                        l.hideSoftKeyPad(d.this.mContext, d.this.gKk);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.jya = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.jya.addView(this.mNoDataView, 0);
        czY();
        czA();
        czZ();
        cAa();
    }

    private void biq() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.jzh = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.fHT = (ImageView) this.jzh.findViewById(R.id.search_bar_icon);
        this.gKk = (EditText) this.jzh.findViewById(R.id.home_et_search);
        this.gKl = (ImageView) this.jzh.findViewById(R.id.home_bt_search_del);
        this.gKm = (TextView) this.jzh.findViewById(R.id.home_bt_search_cancel_s);
        this.gKl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.gKk.setText("");
            }
        });
        lP(false);
        this.gKm.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.gKk.getText().toString())) {
            this.jzh.setFocusable(true);
            this.jzh.setFocusableInTouchMode(true);
            this.jzh.requestFocus();
        }
    }

    public void qx(boolean z) {
        this.jzf = z;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 0 && this.jzf) {
            this.jze.setVisibility(0);
            this.jze.setBackgroundColor(an.getColor(skinType == 4 ? R.color.cp_mask_b_alpha42 : R.color.cp_mask_b_alpha33));
            return;
        }
        this.jze.setVisibility(8);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        an.setBgColor(this.jzb, i);
        if (i == 2) {
            this.gKk.setHintTextColor(an.getColor(R.color.s_navbar_title_color));
        } else {
            this.gKk.setHintTextColor(an.getColor(R.color.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        SvgManager.aWQ().a(this.gKl, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        an.setNavbarTitleColor(this.gKk, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.aWQ().a(this.fHT, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        an.setBackgroundResource(this.jya, R.color.cp_bg_line_d);
        an.setViewTextColor(this.gKm, R.color.cp_link_tip_a, 1);
        qx(this.jzf);
        if (this.jzd != null) {
            this.jzd.onChangeSkinType();
        }
        if (this.jzc != null) {
            this.jzc.onChangeSkinType();
        }
    }

    private void czY() {
        this.jzd = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.jzd.tU(true);
        this.jze = this.mRootView.findViewById(R.id.search_webview_mask);
    }

    private void czA() {
        this.jyi = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.jyk = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.jzg = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void czZ() {
        this.jzc = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.jzc.tU(true);
    }

    private void cAa() {
        this.gKk.setText("");
        this.gKk.requestFocus();
        this.gKm.setText(this.mContext.getString(R.string.cancel));
    }

    public void cAb() {
        this.jzd.setVisibility(0);
        this.jyi.setVisibility(8);
        this.jzc.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void czL() {
        this.jyi.setVisibility(8);
        this.jzd.setVisibility(8);
        this.jzc.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void czJ() {
        this.jyi.setVisibility(0);
        this.jzd.setVisibility(8);
        this.jzc.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void cAc() {
        this.jyi.setVisibility(8);
        this.jzd.setVisibility(8);
        this.jzc.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void lP(boolean z) {
        this.gKl.setVisibility(z ? 0 : 8);
    }

    public void Iq(String str) {
        if (!StringUtils.isNull(str)) {
            this.gKk.setHint(str);
        }
    }

    public void Ir(String str) {
        if (!StringUtils.isNull(str)) {
            this.gKk.setText(str);
            this.gKk.setSelection(str.length());
        }
    }

    public void i(List<String> list, String str) {
        if (!w.isEmpty(list)) {
            czJ();
            this.jyk.Ii(str);
            this.jyk.setData(list);
            this.jyi.setAdapter((ListAdapter) this.jyk);
        }
    }

    public void j(List<ForumInfo> list, String str) {
        if (!w.isEmpty(list) && !TextUtils.isEmpty(str)) {
            czJ();
            this.jzg.Ii(str);
            this.jzg.dN(list);
            this.jyi.setAdapter((ListAdapter) this.jzg);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.jyi.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.jyi.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.gKk.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.gKk.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.gKk.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.gKk.setOnClickListener(onClickListener);
        this.gKm.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.jzc.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.jzc.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.g gVar) {
        this.jzc.setOnReceivedSslErrorListener(gVar);
    }

    public void a(BaseWebView.b bVar) {
        this.jzc.setOnLoadUrlListener(bVar);
    }

    public EditText cAd() {
        return this.gKk;
    }

    public TextView cAe() {
        return this.gKm;
    }

    public QuickWebView cAf() {
        return this.jzc;
    }

    public QuickWebView cAg() {
        return this.jzd;
    }

    public boolean cAh() {
        return this.jyi.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.jya != null) {
                this.jya.removeView(this.jzd);
                this.jya.removeView(this.jzc);
            }
            this.jzd.removeAllViews();
            this.jzc.removeAllViews();
            if (this.jzd != null) {
                this.jzd.destroy();
                this.jzd = null;
            }
            if (this.jzc != null) {
                this.jzc.destroy();
                this.jzc = null;
            }
        } catch (Exception e) {
        }
    }
}
