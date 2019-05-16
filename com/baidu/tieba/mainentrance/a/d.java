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
import com.baidu.tbadk.core.util.al;
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
    private ImageView dAx;
    private TextView eqA;
    private EditText eqy;
    private ImageView eqz;
    private FrameLayout heD;
    private BdListView heL;
    private com.baidu.tieba.mainentrance.searchSuggestList.b heN;
    private LinearLayoutDetectsSoftKeyboard hfE;
    private QuickWebView hfF;
    private QuickWebView hfG;
    private com.baidu.tieba.mainentrance.searchSuggestList.a hfH;
    View hfI;
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
        aHO();
        this.hfE = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.hfE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.hfE.setFocusable(true);
                    d.this.hfE.setFocusableInTouchMode(true);
                    if (d.this.eqy.hasFocus()) {
                        l.b(d.this.mContext, d.this.eqy);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.heD = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.heD.addView(this.mNoDataView, 0);
        bJH();
        bJk();
        bJI();
        bJJ();
    }

    private void aHO() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.hfI = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.dAx = (ImageView) this.hfI.findViewById(R.id.search_bar_icon);
        this.eqy = (EditText) this.hfI.findViewById(R.id.home_et_search);
        this.eqz = (ImageView) this.hfI.findViewById(R.id.home_bt_search_del);
        this.eqA = (TextView) this.hfI.findViewById(R.id.home_bt_search_cancel_s);
        this.eqz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.eqy.setText("");
            }
        });
        ij(false);
        this.eqA.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.eqy.getText().toString())) {
            this.hfI.setFocusable(true);
            this.hfI.setFocusableInTouchMode(true);
            this.hfI.requestFocus();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        al.g(this.hfE, i);
        if (i == 2) {
            this.eqy.setHintTextColor(al.getColor(R.color.s_navbar_title_color));
        } else {
            this.eqy.setHintTextColor(al.getColor(R.color.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        al.c(this.eqz, (int) R.drawable.del_search_btn);
        al.e(this.eqy, R.color.cp_cont_b, R.color.s_navbar_title_color);
        al.c(this.dAx, (int) R.drawable.icon_search);
        al.k(this.heD, R.color.cp_bg_line_d);
        al.f(this.eqA, R.color.cp_link_tip_a, 1);
    }

    private void bJH() {
        this.hfG = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.hfG.pY(true);
    }

    private void bJk() {
        this.heL = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.heN = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.hfH = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void bJI() {
        this.hfF = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.hfF.pY(true);
    }

    private void bJJ() {
        this.eqy.setText("");
        this.eqy.requestFocus();
        this.eqA.setText(this.mContext.getString(R.string.cancel));
    }

    public void bJK() {
        this.hfG.setVisibility(0);
        this.heL.setVisibility(8);
        this.hfF.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bJu() {
        this.heL.setVisibility(8);
        this.hfG.setVisibility(8);
        this.hfF.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bJs() {
        this.heL.setVisibility(0);
        this.hfG.setVisibility(8);
        this.hfF.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bJL() {
        this.heL.setVisibility(8);
        this.hfG.setVisibility(8);
        this.hfF.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void ij(boolean z) {
        this.eqz.setVisibility(z ? 0 : 8);
    }

    public void zF(String str) {
        if (!StringUtils.isNull(str)) {
            this.eqy.setHint(str);
        }
    }

    public void zG(String str) {
        if (!StringUtils.isNull(str)) {
            this.eqy.setText(str);
            this.eqy.setSelection(str.length());
        }
    }

    public void k(List<String> list, String str) {
        if (!v.aa(list)) {
            bJs();
            this.heN.zx(str);
            this.heN.setData(list);
            this.heL.setAdapter((ListAdapter) this.heN);
        }
    }

    public void l(List<ForumInfo> list, String str) {
        if (!v.aa(list) && !TextUtils.isEmpty(str)) {
            bJs();
            this.hfH.zx(str);
            this.hfH.dq(list);
            this.heL.setAdapter((ListAdapter) this.hfH);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.heL.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.heL.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.eqy.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.eqy.setOnEditorActionListener(onEditorActionListener);
    }

    public void e(TextWatcher textWatcher) {
        this.eqy.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eqy.setOnClickListener(onClickListener);
        this.eqA.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.hfF.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.hfF.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.hfF.setOnLoadUrlListener(bVar);
    }

    public EditText bJM() {
        return this.eqy;
    }

    public TextView bJN() {
        return this.eqA;
    }

    public QuickWebView bJO() {
        return this.hfF;
    }

    public QuickWebView bJP() {
        return this.hfG;
    }

    public boolean bJQ() {
        return this.heL.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.heD != null) {
                this.heD.removeView(this.hfG);
                this.heD.removeView(this.hfF);
            }
            this.hfG.removeAllViews();
            this.hfF.removeAllViews();
            if (this.hfG != null) {
                this.hfG.destroy();
                this.hfG = null;
            }
            if (this.hfF != null) {
                this.hfF.destroy();
                this.hfF = null;
            }
        } catch (Exception e) {
        }
    }
}
