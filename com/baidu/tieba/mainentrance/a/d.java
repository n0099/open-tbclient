package com.baidu.tieba.mainentrance.a;

import android.content.Context;
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
import com.baidu.tieba.e;
import com.baidu.tieba.quickWebView.QuickWebView;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private ImageView cab;
    private ImageView dGD;
    private FrameLayout ftG;
    private TextView ftI;
    private BdListView ftP;
    private com.baidu.tieba.mainentrance.searchSuggestList.a ftR;
    private EditText fuC;
    private LinearLayoutDetectsSoftKeyboard fuD;
    private QuickWebView fuE;
    private QuickWebView fuF;
    View fuG;
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
        ayF();
        this.fuD = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(e.g.search_container);
        this.fuD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.fuD.setFocusable(true);
                    d.this.fuD.setFocusableInTouchMode(true);
                    if (d.this.fuC.hasFocus()) {
                        l.b(d.this.mContext, d.this.fuC);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.ftG = (FrameLayout) this.mRootView.findViewById(e.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(e.C0210e.ds200)), null, null);
        this.ftG.addView(this.mNoDataView, 0);
        bak();
        aZN();
        bal();
        bam();
    }

    private void ayF() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.fuG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, e.h.square_search_navigation_view, (View.OnClickListener) null);
        this.cab = (ImageView) this.fuG.findViewById(e.g.search_bar_icon);
        this.fuC = (EditText) this.fuG.findViewById(e.g.home_et_search);
        this.dGD = (ImageView) this.fuG.findViewById(e.g.home_bt_search_del);
        this.ftI = (TextView) this.fuG.findViewById(e.g.home_bt_search_cancel_s);
        this.dGD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.fuC.setText("");
            }
        });
        hX(false);
        this.ftI.setText(this.mContext.getString(e.j.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.fuC.getText().toString())) {
            this.fuG.setFocusable(true);
            this.fuG.setFocusableInTouchMode(true);
            this.fuG.requestFocus();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        al.e(this.fuD, i);
        if (i == 2) {
            this.fuC.setHintTextColor(al.getColor(e.d.s_navbar_title_color));
        } else {
            this.fuC.setHintTextColor(al.getColor(e.d.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        al.c(this.dGD, e.f.del_search_btn);
        al.b(this.fuC, e.d.cp_cont_b, e.d.s_navbar_title_color);
        al.c(this.cab, e.f.icon_search);
        al.i(this.ftG, e.d.cp_bg_line_d);
        al.c(this.ftI, e.d.cp_link_tip_a, 1);
    }

    private void bak() {
        this.fuF = (QuickWebView) this.mRootView.findViewById(e.g.search_history_webview);
        this.fuF.mI(true);
    }

    private void aZN() {
        this.ftP = (BdListView) this.mRootView.findViewById(e.g.home_lv_search_suggest);
        this.ftR = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
        this.ftP.setAdapter((ListAdapter) this.ftR);
    }

    private void bal() {
        this.fuE = (QuickWebView) this.mRootView.findViewById(e.g.search_result_webview);
        this.fuE.mI(true);
    }

    private void bam() {
        this.fuC.setText("");
        this.fuC.requestFocus();
        this.ftI.setText(this.mContext.getString(e.j.cancel));
    }

    public void ban() {
        this.fuF.setVisibility(0);
        this.ftP.setVisibility(8);
        this.fuE.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aZX() {
        this.ftP.setVisibility(8);
        this.fuF.setVisibility(8);
        this.fuE.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aZV() {
        this.ftP.setVisibility(0);
        this.fuF.setVisibility(8);
        this.fuE.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bao() {
        this.ftP.setVisibility(8);
        this.fuF.setVisibility(8);
        this.fuE.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void hX(boolean z) {
        this.dGD.setVisibility(z ? 0 : 8);
    }

    public void ru(String str) {
        if (!StringUtils.isNull(str)) {
            this.fuC.setHint(str);
        }
    }

    public void rv(String str) {
        if (!StringUtils.isNull(str)) {
            this.fuC.setText(str);
            this.fuC.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!v.I(list)) {
            aZV();
            this.ftR.rm(str);
            this.ftR.setData(list);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.ftP.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.ftP.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.fuC.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.fuC.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.fuC.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fuC.setOnClickListener(onClickListener);
        this.ftI.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.fuE.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.fuE.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.fuE.setOnLoadUrlListener(bVar);
    }

    public EditText bap() {
        return this.fuC;
    }

    public TextView baq() {
        return this.ftI;
    }

    public QuickWebView bar() {
        return this.fuE;
    }

    public QuickWebView bas() {
        return this.fuF;
    }

    public boolean bat() {
        return this.ftP.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.ftG != null) {
                this.ftG.removeView(this.fuF);
                this.ftG.removeView(this.fuE);
            }
            this.fuF.removeAllViews();
            this.fuE.removeAllViews();
            if (this.fuF != null) {
                this.fuF.destroy();
                this.fuF = null;
            }
            if (this.fuE != null) {
                this.fuE.destroy();
                this.fuE = null;
            }
        } catch (Exception e) {
        }
    }
}
