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
import com.baidu.tieba.d;
import com.baidu.tieba.quickWebView.QuickWebView;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private ImageView bGp;
    private ImageView dif;
    private FrameLayout eSD;
    private TextView eSF;
    private BdListView eSM;
    private com.baidu.tieba.mainentrance.searchSuggestList.a eSO;
    private LinearLayoutDetectsSoftKeyboard eTA;
    private QuickWebView eTB;
    private QuickWebView eTC;
    private EditText eTz;
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
        arI();
        this.eTA = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(d.g.search_container);
        this.eTA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.eTA.setFocusable(true);
                    d.this.eTA.setFocusableInTouchMode(true);
                    if (d.this.eTz.hasFocus()) {
                        l.b(d.this.mContext, d.this.eTz);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.eSD = (FrameLayout) this.mRootView.findViewById(d.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds200)), null, null);
        this.eSD.addView(this.mNoDataView, 0);
        aSv();
        aRY();
        aSw();
        aSx();
    }

    private void arI() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.i.square_search_navigation_view, (View.OnClickListener) null);
        this.bGp = (ImageView) addCustomView.findViewById(d.g.search_bar_icon);
        this.eTz = (EditText) addCustomView.findViewById(d.g.home_et_search);
        this.dif = (ImageView) addCustomView.findViewById(d.g.home_bt_search_del);
        this.eSF = (TextView) addCustomView.findViewById(d.g.home_bt_search_cancel_s);
        this.dif.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.eTz.setText("");
            }
        });
        gS(false);
        this.eSF.setText(this.mContext.getString(d.k.cancel));
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        am.e(this.eTA, i);
        if (i == 2) {
            this.eTz.setHintTextColor(am.getColor(d.C0142d.s_navbar_title_color));
        } else {
            this.eTz.setHintTextColor(am.getColor(d.C0142d.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        am.c(this.dif, d.f.del_search_btn);
        am.b(this.eTz, d.C0142d.cp_cont_b, d.C0142d.s_navbar_title_color);
        am.c(this.bGp, d.f.icon_search);
        am.i(this.eSD, d.C0142d.cp_bg_line_d);
        am.c(this.eSF, d.C0142d.cp_link_tip_a, 1);
    }

    private void aSv() {
        this.eTC = (QuickWebView) this.mRootView.findViewById(d.g.search_history_webview);
        this.eTC.lS(true);
    }

    private void aRY() {
        this.eSM = (BdListView) this.mRootView.findViewById(d.g.home_lv_search_suggest);
        this.eSO = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
        this.eSM.setAdapter((ListAdapter) this.eSO);
    }

    private void aSw() {
        this.eTB = (QuickWebView) this.mRootView.findViewById(d.g.search_result_webview);
        this.eTB.lS(true);
    }

    private void aSx() {
        this.eTz.setText("");
        this.eTz.requestFocus();
        this.eSF.setText(this.mContext.getString(d.k.cancel));
    }

    public void aSy() {
        this.eTC.setVisibility(0);
        this.eSM.setVisibility(8);
        this.eTB.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aSi() {
        this.eSM.setVisibility(8);
        this.eTC.setVisibility(8);
        this.eTB.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aSg() {
        this.eSM.setVisibility(0);
        this.eTC.setVisibility(8);
        this.eTB.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void aSz() {
        this.eSM.setVisibility(8);
        this.eTC.setVisibility(8);
        this.eTB.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void gS(boolean z) {
        this.dif.setVisibility(z ? 0 : 8);
    }

    public void pH(String str) {
        if (!StringUtils.isNull(str)) {
            this.eTz.setHint(str);
        }
    }

    public void pI(String str) {
        if (!StringUtils.isNull(str)) {
            this.eTz.setText(str);
            this.eTz.setSelection(str.length());
        }
    }

    public void j(List<String> list, String str) {
        if (!w.A(list)) {
            aSg();
            this.eSO.pz(str);
            this.eSO.setData(list);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.eSM.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.eSM.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.eTz.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.eTz.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.eTz.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eTz.setOnClickListener(onClickListener);
        this.eSF.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.eTB.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.eTB.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.eTB.setOnLoadUrlListener(bVar);
    }

    public EditText aSA() {
        return this.eTz;
    }

    public TextView aSB() {
        return this.eSF;
    }

    public QuickWebView aSC() {
        return this.eTB;
    }

    public QuickWebView aSD() {
        return this.eTC;
    }

    public boolean aSE() {
        return this.eSM.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.eSD != null) {
                this.eSD.removeView(this.eTC);
                this.eSD.removeView(this.eTB);
            }
            this.eTC.removeAllViews();
            this.eTB.removeAllViews();
            if (this.eTC != null) {
                this.eTC.destroy();
                this.eTC = null;
            }
            if (this.eTB != null) {
                this.eTB.destroy();
                this.eTB = null;
            }
        } catch (Exception e) {
        }
    }
}
