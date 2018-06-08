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
import com.baidu.tbadk.core.util.w;
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
    private ImageView bEt;
    private ImageView dgo;
    private FrameLayout eOM;
    private TextView eOO;
    private BdListView eOV;
    private com.baidu.tieba.mainentrance.searchSuggestList.a eOX;
    private EditText ePI;
    private LinearLayoutDetectsSoftKeyboard ePJ;
    private QuickWebView ePK;
    private QuickWebView ePL;
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
        avi();
        this.ePJ = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(d.g.search_container);
        this.ePJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.ePJ.setFocusable(true);
                    d.this.ePJ.setFocusableInTouchMode(true);
                    if (d.this.ePI.hasFocus()) {
                        l.b(d.this.mContext, d.this.ePI);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.eOM = (FrameLayout) this.mRootView.findViewById(d.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds200)), null, null);
        this.eOM.addView(this.mNoDataView, 0);
        aRO();
        aRs();
        aRP();
        aRQ();
    }

    private void avi() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.i.square_search_navigation_view, (View.OnClickListener) null);
        this.bEt = (ImageView) addCustomView.findViewById(d.g.search_bar_icon);
        this.ePI = (EditText) addCustomView.findViewById(d.g.home_et_search);
        this.dgo = (ImageView) addCustomView.findViewById(d.g.home_bt_search_del);
        this.eOO = (TextView) addCustomView.findViewById(d.g.home_bt_search_cancel_s);
        this.dgo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.ePI.setText("");
            }
        });
        gI(false);
        this.eOO.setText(this.mContext.getString(d.k.cancel));
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        al.e(this.ePJ, i);
        if (i == 2) {
            this.ePI.setHintTextColor(al.getColor(d.C0141d.s_navbar_title_color));
        } else {
            this.ePI.setHintTextColor(al.getColor(d.C0141d.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        al.c(this.dgo, d.f.del_search_btn);
        al.b(this.ePI, d.C0141d.cp_cont_b, d.C0141d.s_navbar_title_color);
        al.c(this.bEt, d.f.icon_search);
        al.i(this.eOM, d.C0141d.cp_bg_line_d);
        al.c(this.eOO, d.C0141d.cp_link_tip_a, 1);
    }

    private void aRO() {
        this.ePL = (QuickWebView) this.mRootView.findViewById(d.g.search_history_webview);
        this.ePL.lI(true);
    }

    private void aRs() {
        this.eOV = (BdListView) this.mRootView.findViewById(d.g.home_lv_search_suggest);
        this.eOX = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
        this.eOV.setAdapter((ListAdapter) this.eOX);
    }

    private void aRP() {
        this.ePK = (QuickWebView) this.mRootView.findViewById(d.g.search_result_webview);
        this.ePK.lI(true);
    }

    private void aRQ() {
        this.ePI.setText("");
        this.ePI.requestFocus();
        this.eOO.setText(this.mContext.getString(d.k.cancel));
    }

    public void aRR() {
        this.ePL.setVisibility(0);
        this.eOV.setVisibility(8);
        this.ePK.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aRC() {
        this.eOV.setVisibility(8);
        this.ePL.setVisibility(8);
        this.ePK.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aRA() {
        this.eOV.setVisibility(0);
        this.ePL.setVisibility(8);
        this.ePK.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aRS() {
        this.eOV.setVisibility(8);
        this.ePL.setVisibility(8);
        this.ePK.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void gI(boolean z) {
        this.dgo.setVisibility(z ? 0 : 8);
    }

    public void pG(String str) {
        if (!StringUtils.isNull(str)) {
            this.ePI.setHint(str);
        }
    }

    public void pH(String str) {
        if (!StringUtils.isNull(str)) {
            this.ePI.setText(str);
            this.ePI.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!w.z(list)) {
            aRA();
            this.eOX.py(str);
            this.eOX.setData(list);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.eOV.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.eOV.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.ePI.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.ePI.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.ePI.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ePI.setOnClickListener(onClickListener);
        this.eOO.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.ePK.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.ePK.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.ePK.setOnLoadUrlListener(bVar);
    }

    public EditText aRT() {
        return this.ePI;
    }

    public TextView aRU() {
        return this.eOO;
    }

    public QuickWebView aRV() {
        return this.ePK;
    }

    public QuickWebView aRW() {
        return this.ePL;
    }

    public boolean aRX() {
        return this.eOV.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.eOM != null) {
                this.eOM.removeView(this.ePL);
                this.eOM.removeView(this.ePK);
            }
            this.ePL.removeAllViews();
            this.ePK.removeAllViews();
            if (this.ePL != null) {
                this.ePL.destroy();
                this.ePL = null;
            }
            if (this.ePK != null) {
                this.ePK.destroy();
                this.ePK = null;
            }
        } catch (Exception e) {
        }
    }
}
