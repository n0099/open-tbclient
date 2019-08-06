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
    private ImageView dDZ;
    private EditText evE;
    private ImageView evF;
    private TextView evG;
    private FrameLayout hlM;
    private BdListView hlU;
    private com.baidu.tieba.mainentrance.searchSuggestList.b hlW;
    private LinearLayoutDetectsSoftKeyboard hmN;
    private QuickWebView hmO;
    private QuickWebView hmP;
    private com.baidu.tieba.mainentrance.searchSuggestList.a hmQ;
    View hmR;
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
        aJt();
        this.hmN = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.hmN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.hmN.setFocusable(true);
                    d.this.hmN.setFocusableInTouchMode(true);
                    if (d.this.evE.hasFocus()) {
                        l.b(d.this.mContext, d.this.evE);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.hlM = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.hlM.addView(this.mNoDataView, 0);
        bMG();
        bMj();
        bMH();
        bMI();
    }

    private void aJt() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.hmR = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.dDZ = (ImageView) this.hmR.findViewById(R.id.search_bar_icon);
        this.evE = (EditText) this.hmR.findViewById(R.id.home_et_search);
        this.evF = (ImageView) this.hmR.findViewById(R.id.home_bt_search_del);
        this.evG = (TextView) this.hmR.findViewById(R.id.home_bt_search_cancel_s);
        this.evF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.evE.setText("");
            }
        });
        is(false);
        this.evG.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.evE.getText().toString())) {
            this.hmR.setFocusable(true);
            this.hmR.setFocusableInTouchMode(true);
            this.hmR.requestFocus();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        am.g(this.hmN, i);
        if (i == 2) {
            this.evE.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
        } else {
            this.evE.setHintTextColor(am.getColor(R.color.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        am.c(this.evF, (int) R.drawable.del_search_btn);
        am.e(this.evE, R.color.cp_cont_b, R.color.s_navbar_title_color);
        am.c(this.dDZ, (int) R.drawable.icon_search);
        am.k(this.hlM, R.color.cp_bg_line_d);
        am.f(this.evG, R.color.cp_link_tip_a, 1);
    }

    private void bMG() {
        this.hmP = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.hmP.qp(true);
    }

    private void bMj() {
        this.hlU = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.hlW = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.hmQ = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void bMH() {
        this.hmO = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.hmO.qp(true);
    }

    private void bMI() {
        this.evE.setText("");
        this.evE.requestFocus();
        this.evG.setText(this.mContext.getString(R.string.cancel));
    }

    public void bMJ() {
        this.hmP.setVisibility(0);
        this.hlU.setVisibility(8);
        this.hmO.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bMt() {
        this.hlU.setVisibility(8);
        this.hmP.setVisibility(8);
        this.hmO.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bMr() {
        this.hlU.setVisibility(0);
        this.hmP.setVisibility(8);
        this.hmO.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bMK() {
        this.hlU.setVisibility(8);
        this.hmP.setVisibility(8);
        this.hmO.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void is(boolean z) {
        this.evF.setVisibility(z ? 0 : 8);
    }

    public void At(String str) {
        if (!StringUtils.isNull(str)) {
            this.evE.setHint(str);
        }
    }

    public void Au(String str) {
        if (!StringUtils.isNull(str)) {
            this.evE.setText(str);
            this.evE.setSelection(str.length());
        }
    }

    public void k(List<String> list, String str) {
        if (!v.aa(list)) {
            bMr();
            this.hlW.Al(str);
            this.hlW.setData(list);
            this.hlU.setAdapter((ListAdapter) this.hlW);
        }
    }

    public void l(List<ForumInfo> list, String str) {
        if (!v.aa(list) && !TextUtils.isEmpty(str)) {
            bMr();
            this.hmQ.Al(str);
            this.hmQ.dr(list);
            this.hlU.setAdapter((ListAdapter) this.hmQ);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.hlU.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.hlU.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.evE.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.evE.setOnEditorActionListener(onEditorActionListener);
    }

    public void f(TextWatcher textWatcher) {
        this.evE.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.evE.setOnClickListener(onClickListener);
        this.evG.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.hmO.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.hmO.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.hmO.setOnLoadUrlListener(bVar);
    }

    public EditText bML() {
        return this.evE;
    }

    public TextView bMM() {
        return this.evG;
    }

    public QuickWebView bMN() {
        return this.hmO;
    }

    public QuickWebView bMO() {
        return this.hmP;
    }

    public boolean bMP() {
        return this.hlU.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.hlM != null) {
                this.hlM.removeView(this.hmP);
                this.hlM.removeView(this.hmO);
            }
            this.hmP.removeAllViews();
            this.hmO.removeAllViews();
            if (this.hmP != null) {
                this.hmP.destroy();
                this.hmP = null;
            }
            if (this.hmO != null) {
                this.hmO.destroy();
                this.hmO = null;
            }
        } catch (Exception e) {
        }
    }
}
