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
    private ImageView dDS;
    private EditText evx;
    private ImageView evy;
    private TextView evz;
    private FrameLayout hkU;
    private LinearLayoutDetectsSoftKeyboard hlV;
    private QuickWebView hlW;
    private QuickWebView hlX;
    private com.baidu.tieba.mainentrance.searchSuggestList.a hlY;
    View hlZ;
    private BdListView hlc;
    private com.baidu.tieba.mainentrance.searchSuggestList.b hle;
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
        aJr();
        this.hlV = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.hlV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.hlV.setFocusable(true);
                    d.this.hlV.setFocusableInTouchMode(true);
                    if (d.this.evx.hasFocus()) {
                        l.b(d.this.mContext, d.this.evx);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.hkU = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.hkU.addView(this.mNoDataView, 0);
        bMs();
        bLV();
        bMt();
        bMu();
    }

    private void aJr() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.hlZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.dDS = (ImageView) this.hlZ.findViewById(R.id.search_bar_icon);
        this.evx = (EditText) this.hlZ.findViewById(R.id.home_et_search);
        this.evy = (ImageView) this.hlZ.findViewById(R.id.home_bt_search_del);
        this.evz = (TextView) this.hlZ.findViewById(R.id.home_bt_search_cancel_s);
        this.evy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.evx.setText("");
            }
        });
        is(false);
        this.evz.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.evx.getText().toString())) {
            this.hlZ.setFocusable(true);
            this.hlZ.setFocusableInTouchMode(true);
            this.hlZ.requestFocus();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        am.g(this.hlV, i);
        if (i == 2) {
            this.evx.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
        } else {
            this.evx.setHintTextColor(am.getColor(R.color.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        am.c(this.evy, (int) R.drawable.del_search_btn);
        am.e(this.evx, R.color.cp_cont_b, R.color.s_navbar_title_color);
        am.c(this.dDS, (int) R.drawable.icon_search);
        am.k(this.hkU, R.color.cp_bg_line_d);
        am.f(this.evz, R.color.cp_link_tip_a, 1);
    }

    private void bMs() {
        this.hlX = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.hlX.qo(true);
    }

    private void bLV() {
        this.hlc = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.hle = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.hlY = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void bMt() {
        this.hlW = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.hlW.qo(true);
    }

    private void bMu() {
        this.evx.setText("");
        this.evx.requestFocus();
        this.evz.setText(this.mContext.getString(R.string.cancel));
    }

    public void bMv() {
        this.hlX.setVisibility(0);
        this.hlc.setVisibility(8);
        this.hlW.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bMf() {
        this.hlc.setVisibility(8);
        this.hlX.setVisibility(8);
        this.hlW.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bMd() {
        this.hlc.setVisibility(0);
        this.hlX.setVisibility(8);
        this.hlW.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bMw() {
        this.hlc.setVisibility(8);
        this.hlX.setVisibility(8);
        this.hlW.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void is(boolean z) {
        this.evy.setVisibility(z ? 0 : 8);
    }

    public void As(String str) {
        if (!StringUtils.isNull(str)) {
            this.evx.setHint(str);
        }
    }

    public void At(String str) {
        if (!StringUtils.isNull(str)) {
            this.evx.setText(str);
            this.evx.setSelection(str.length());
        }
    }

    public void k(List<String> list, String str) {
        if (!v.aa(list)) {
            bMd();
            this.hle.Ak(str);
            this.hle.setData(list);
            this.hlc.setAdapter((ListAdapter) this.hle);
        }
    }

    public void l(List<ForumInfo> list, String str) {
        if (!v.aa(list) && !TextUtils.isEmpty(str)) {
            bMd();
            this.hlY.Ak(str);
            this.hlY.ds(list);
            this.hlc.setAdapter((ListAdapter) this.hlY);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.hlc.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.hlc.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.evx.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.evx.setOnEditorActionListener(onEditorActionListener);
    }

    public void f(TextWatcher textWatcher) {
        this.evx.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.evx.setOnClickListener(onClickListener);
        this.evz.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.hlW.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.hlW.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.hlW.setOnLoadUrlListener(bVar);
    }

    public EditText bMx() {
        return this.evx;
    }

    public TextView bMy() {
        return this.evz;
    }

    public QuickWebView bMz() {
        return this.hlW;
    }

    public QuickWebView bMA() {
        return this.hlX;
    }

    public boolean bMB() {
        return this.hlc.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.hkU != null) {
                this.hkU.removeView(this.hlX);
                this.hkU.removeView(this.hlW);
            }
            this.hlX.removeAllViews();
            this.hlW.removeAllViews();
            if (this.hlX != null) {
                this.hlX.destroy();
                this.hlX = null;
            }
            if (this.hlW != null) {
                this.hlW.destroy();
                this.hlW = null;
            }
        } catch (Exception e) {
        }
    }
}
