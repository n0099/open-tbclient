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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.f;
import com.baidu.tieba.quickWebView.QuickWebView;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private ImageView bHe;
    private ImageView dkT;
    private BdListView eWB;
    private com.baidu.tieba.mainentrance.searchSuggestList.a eWD;
    private FrameLayout eWs;
    private TextView eWu;
    private EditText eXo;
    private LinearLayoutDetectsSoftKeyboard eXp;
    private QuickWebView eXq;
    private QuickWebView eXr;
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
        asl();
        this.eXp = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(f.g.search_container);
        this.eXp.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.eXp.setFocusable(true);
                    d.this.eXp.setFocusableInTouchMode(true);
                    if (d.this.eXo.hasFocus()) {
                        l.a(d.this.mContext, d.this.eXo);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.eWs = (FrameLayout) this.mRootView.findViewById(f.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(f.e.ds200)), null, null);
        this.eWs.addView(this.mNoDataView, 0);
        aTu();
        aSX();
        aTv();
        aTw();
    }

    private void asl() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, f.h.square_search_navigation_view, (View.OnClickListener) null);
        this.bHe = (ImageView) addCustomView.findViewById(f.g.search_bar_icon);
        this.eXo = (EditText) addCustomView.findViewById(f.g.home_et_search);
        this.dkT = (ImageView) addCustomView.findViewById(f.g.home_bt_search_del);
        this.eWu = (TextView) addCustomView.findViewById(f.g.home_bt_search_cancel_s);
        this.dkT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.eXo.setText("");
            }
        });
        gV(false);
        this.eWu.setText(this.mContext.getString(f.j.cancel));
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        am.e(this.eXp, i);
        if (i == 2) {
            this.eXo.setHintTextColor(am.getColor(f.d.s_navbar_title_color));
        } else {
            this.eXo.setHintTextColor(am.getColor(f.d.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        am.c(this.dkT, f.C0146f.del_search_btn);
        am.b(this.eXo, f.d.cp_cont_b, f.d.s_navbar_title_color);
        am.c(this.bHe, f.C0146f.icon_search);
        am.i(this.eWs, f.d.cp_bg_line_d);
        am.c(this.eWu, f.d.cp_link_tip_a, 1);
    }

    private void aTu() {
        this.eXr = (QuickWebView) this.mRootView.findViewById(f.g.search_history_webview);
        this.eXr.lD(true);
    }

    private void aSX() {
        this.eWB = (BdListView) this.mRootView.findViewById(f.g.home_lv_search_suggest);
        this.eWD = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
        this.eWB.setAdapter((ListAdapter) this.eWD);
    }

    private void aTv() {
        this.eXq = (QuickWebView) this.mRootView.findViewById(f.g.search_result_webview);
        this.eXq.lD(true);
    }

    private void aTw() {
        this.eXo.setText("");
        this.eXo.requestFocus();
        this.eWu.setText(this.mContext.getString(f.j.cancel));
    }

    public void aTx() {
        this.eXr.setVisibility(0);
        this.eWB.setVisibility(8);
        this.eXq.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aTh() {
        this.eWB.setVisibility(8);
        this.eXr.setVisibility(8);
        this.eXq.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aTf() {
        this.eWB.setVisibility(0);
        this.eXr.setVisibility(8);
        this.eXq.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aTy() {
        this.eWB.setVisibility(8);
        this.eXr.setVisibility(8);
        this.eXq.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void gV(boolean z) {
        this.dkT.setVisibility(z ? 0 : 8);
    }

    public void pK(String str) {
        if (!StringUtils.isNull(str)) {
            this.eXo.setHint(str);
        }
    }

    public void pL(String str) {
        if (!StringUtils.isNull(str)) {
            this.eXo.setText(str);
            this.eXo.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!w.z(list)) {
            aTf();
            this.eWD.pC(str);
            this.eWD.setData(list);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.eWB.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.eWB.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.eXo.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.eXo.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.eXo.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eXo.setOnClickListener(onClickListener);
        this.eWu.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.eXq.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.eXq.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.eXq.setOnLoadUrlListener(bVar);
    }

    public EditText aTz() {
        return this.eXo;
    }

    public TextView aTA() {
        return this.eWu;
    }

    public QuickWebView aTB() {
        return this.eXq;
    }

    public QuickWebView aTC() {
        return this.eXr;
    }

    public boolean aTD() {
        return this.eWB.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.eWs != null) {
                this.eWs.removeView(this.eXr);
                this.eWs.removeView(this.eXq);
            }
            this.eXr.removeAllViews();
            this.eXq.removeAllViews();
            if (this.eXr != null) {
                this.eXr.destroy();
                this.eXr = null;
            }
            if (this.eXq != null) {
                this.eXq.destroy();
                this.eXq = null;
            }
        } catch (Exception e) {
        }
    }
}
