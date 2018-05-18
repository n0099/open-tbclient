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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.d;
import com.baidu.tieba.quickWebView.QuickWebView;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private ImageView bwq;
    private ImageView cXb;
    private BdListView eDB;
    private com.baidu.tieba.mainentrance.searchSuggestList.a eDD;
    private FrameLayout eDs;
    private TextView eDu;
    private EditText eEp;
    private LinearLayoutDetectsSoftKeyboard eEq;
    private QuickWebView eEr;
    private QuickWebView eEs;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public d(View view2, Context context) {
        this.mRootView = view2;
        this.mContext = context;
        initView();
    }

    private void initView() {
        ard();
        this.eEq = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(d.g.search_container);
        this.eEq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.eEq.setFocusable(true);
                    d.this.eEq.setFocusableInTouchMode(true);
                    if (d.this.eEp.hasFocus()) {
                        l.b(d.this.mContext, d.this.eEp);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.eDs = (FrameLayout) this.mRootView.findViewById(d.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds200)), null, null);
        this.eDs.addView(this.mNoDataView, 0);
        aMR();
        aMv();
        aMS();
        aMT();
    }

    private void ard() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.i.square_search_navigation_view, (View.OnClickListener) null);
        this.bwq = (ImageView) addCustomView.findViewById(d.g.search_bar_icon);
        this.eEp = (EditText) addCustomView.findViewById(d.g.home_et_search);
        this.cXb = (ImageView) addCustomView.findViewById(d.g.home_bt_search_del);
        this.eDu = (TextView) addCustomView.findViewById(d.g.home_bt_search_cancel_s);
        this.cXb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.eEp.setText("");
            }
        });
        gC(false);
        this.eDu.setText(this.mContext.getString(d.k.cancel));
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        ak.e(this.eEq, i);
        if (i == 2) {
            this.eEp.setHintTextColor(ak.getColor(d.C0126d.s_navbar_title_color));
        } else {
            this.eEp.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        ak.c(this.cXb, d.f.del_search_btn);
        ak.b(this.eEp, d.C0126d.cp_cont_b, d.C0126d.s_navbar_title_color);
        ak.c(this.bwq, d.f.icon_search);
        ak.i(this.eDs, d.C0126d.cp_bg_line_d);
        ak.c(this.eDu, d.C0126d.cp_link_tip_a, 1);
    }

    private void aMR() {
        this.eEs = (QuickWebView) this.mRootView.findViewById(d.g.search_history_webview);
        this.eEs.lC(true);
    }

    private void aMv() {
        this.eDB = (BdListView) this.mRootView.findViewById(d.g.home_lv_search_suggest);
        this.eDD = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
        this.eDB.setAdapter((ListAdapter) this.eDD);
    }

    private void aMS() {
        this.eEr = (QuickWebView) this.mRootView.findViewById(d.g.search_result_webview);
        this.eEr.lC(true);
    }

    private void aMT() {
        this.eEp.setText("");
        this.eEp.requestFocus();
        this.eDu.setText(this.mContext.getString(d.k.cancel));
    }

    public void aMU() {
        this.eEs.setVisibility(0);
        this.eDB.setVisibility(8);
        this.eEr.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aMF() {
        this.eDB.setVisibility(8);
        this.eEs.setVisibility(8);
        this.eEr.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aMD() {
        this.eDB.setVisibility(0);
        this.eEs.setVisibility(8);
        this.eEr.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aMV() {
        this.eDB.setVisibility(8);
        this.eEs.setVisibility(8);
        this.eEr.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void gC(boolean z) {
        this.cXb.setVisibility(z ? 0 : 8);
    }

    public void oS(String str) {
        if (!StringUtils.isNull(str)) {
            this.eEp.setHint(str);
        }
    }

    public void oT(String str) {
        if (!StringUtils.isNull(str)) {
            this.eEp.setText(str);
            this.eEp.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!v.w(list)) {
            aMD();
            this.eDD.oK(str);
            this.eDD.setData(list);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.eDB.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.eDB.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.eEp.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.eEp.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.eEp.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eEp.setOnClickListener(onClickListener);
        this.eDu.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.eEr.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.eEr.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.eEr.setOnLoadUrlListener(bVar);
    }

    public EditText aMW() {
        return this.eEp;
    }

    public TextView aMX() {
        return this.eDu;
    }

    public QuickWebView aMY() {
        return this.eEr;
    }

    public QuickWebView aMZ() {
        return this.eEs;
    }

    public boolean aNa() {
        return this.eDB.getVisibility() == 0;
    }

    public void onDestroy() {
        if (this.eDs != null) {
            this.eDs.removeView(this.eEs);
            this.eDs.removeView(this.eEr);
        }
        if (this.eEs != null) {
            this.eEs.destroy();
        }
        if (this.eEr != null) {
            this.eEr.destroy();
        }
    }
}
