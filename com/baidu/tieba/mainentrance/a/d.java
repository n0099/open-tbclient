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
/* loaded from: classes6.dex */
public class d {
    private ImageView dFK;
    private EditText exo;
    private ImageView exp;
    private TextView exq;
    private FrameLayout hnG;
    private BdListView hnO;
    private com.baidu.tieba.mainentrance.searchSuggestList.b hnQ;
    private LinearLayoutDetectsSoftKeyboard hoH;
    private QuickWebView hoI;
    private QuickWebView hoJ;
    private com.baidu.tieba.mainentrance.searchSuggestList.a hoK;
    View hoL;
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
        aJX();
        this.hoH = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.hoH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.hoH.setFocusable(true);
                    d.this.hoH.setFocusableInTouchMode(true);
                    if (d.this.exo.hasFocus()) {
                        l.b(d.this.mContext, d.this.exo);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.hnG = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.hnG.addView(this.mNoDataView, 0);
        bNt();
        bMW();
        bNu();
        bNv();
    }

    private void aJX() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.hoL = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.dFK = (ImageView) this.hoL.findViewById(R.id.search_bar_icon);
        this.exo = (EditText) this.hoL.findViewById(R.id.home_et_search);
        this.exp = (ImageView) this.hoL.findViewById(R.id.home_bt_search_del);
        this.exq = (TextView) this.hoL.findViewById(R.id.home_bt_search_cancel_s);
        this.exp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.exo.setText("");
            }
        });
        iv(false);
        this.exq.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.exo.getText().toString())) {
            this.hoL.setFocusable(true);
            this.hoL.setFocusableInTouchMode(true);
            this.hoL.requestFocus();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        am.g(this.hoH, i);
        if (i == 2) {
            this.exo.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
        } else {
            this.exo.setHintTextColor(am.getColor(R.color.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        SvgManager.ajv().a(this.exp, R.drawable.icon_pure_search_empty_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.e(this.exo, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.ajv().a(this.dFK, R.drawable.icon_pure_search_import_n_svg, R.color.cp_cont_d, null);
        am.k(this.hnG, R.color.cp_bg_line_d);
        am.f(this.exq, R.color.cp_link_tip_a, 1);
    }

    private void bNt() {
        this.hoJ = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.hoJ.qs(true);
    }

    private void bMW() {
        this.hnO = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.hnQ = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.hoK = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void bNu() {
        this.hoI = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.hoI.qs(true);
    }

    private void bNv() {
        this.exo.setText("");
        this.exo.requestFocus();
        this.exq.setText(this.mContext.getString(R.string.cancel));
    }

    public void bNw() {
        this.hoJ.setVisibility(0);
        this.hnO.setVisibility(8);
        this.hoI.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bNg() {
        this.hnO.setVisibility(8);
        this.hoJ.setVisibility(8);
        this.hoI.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bNe() {
        this.hnO.setVisibility(0);
        this.hoJ.setVisibility(8);
        this.hoI.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bNx() {
        this.hnO.setVisibility(8);
        this.hoJ.setVisibility(8);
        this.hoI.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void iv(boolean z) {
        this.exp.setVisibility(z ? 0 : 8);
    }

    public void AS(String str) {
        if (!StringUtils.isNull(str)) {
            this.exo.setHint(str);
        }
    }

    public void AT(String str) {
        if (!StringUtils.isNull(str)) {
            this.exo.setText(str);
            this.exo.setSelection(str.length());
        }
    }

    public void k(List<String> list, String str) {
        if (!v.aa(list)) {
            bNe();
            this.hnQ.AK(str);
            this.hnQ.setData(list);
            this.hnO.setAdapter((ListAdapter) this.hnQ);
        }
    }

    public void l(List<ForumInfo> list, String str) {
        if (!v.aa(list) && !TextUtils.isEmpty(str)) {
            bNe();
            this.hoK.AK(str);
            this.hoK.dr(list);
            this.hnO.setAdapter((ListAdapter) this.hoK);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.hnO.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.hnO.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.exo.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.exo.setOnEditorActionListener(onEditorActionListener);
    }

    public void f(TextWatcher textWatcher) {
        this.exo.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.exo.setOnClickListener(onClickListener);
        this.exq.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.hoI.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.hoI.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.hoI.setOnLoadUrlListener(bVar);
    }

    public EditText bNy() {
        return this.exo;
    }

    public TextView bNz() {
        return this.exq;
    }

    public QuickWebView bNA() {
        return this.hoI;
    }

    public QuickWebView bNB() {
        return this.hoJ;
    }

    public boolean bNC() {
        return this.hnO.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.hnG != null) {
                this.hnG.removeView(this.hoJ);
                this.hnG.removeView(this.hoI);
            }
            this.hoJ.removeAllViews();
            this.hoI.removeAllViews();
            if (this.hoJ != null) {
                this.hoJ.destroy();
                this.hoJ = null;
            }
            if (this.hoI != null) {
                this.hoI.destroy();
                this.hoI = null;
            }
        } catch (Exception e) {
        }
    }
}
