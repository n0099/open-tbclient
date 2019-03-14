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
import com.baidu.tieba.d;
import com.baidu.tieba.quickWebView.QuickWebView;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.List;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes6.dex */
public class d {
    private ImageView dpO;
    private ImageView eXr;
    private BdListView gNF;
    private com.baidu.tieba.mainentrance.searchSuggestList.b gNH;
    private FrameLayout gNw;
    private TextView gNy;
    private QuickWebView gOA;
    private QuickWebView gOB;
    private com.baidu.tieba.mainentrance.searchSuggestList.a gOC;
    View gOD;
    private EditText gOy;
    private LinearLayoutDetectsSoftKeyboard gOz;
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
        aBB();
        this.gOz = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(d.g.search_container);
        this.gOz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.gOz.setFocusable(true);
                    d.this.gOz.setFocusableInTouchMode(true);
                    if (d.this.gOy.hasFocus()) {
                        l.b(d.this.mContext, d.this.gOy);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.gNw = (FrameLayout) this.mRootView.findViewById(d.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds200)), null, null);
        this.gNw.addView(this.mNoDataView, 0);
        bCa();
        bBD();
        bCb();
        bCc();
    }

    private void aBB() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.gOD = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.square_search_navigation_view, (View.OnClickListener) null);
        this.dpO = (ImageView) this.gOD.findViewById(d.g.search_bar_icon);
        this.gOy = (EditText) this.gOD.findViewById(d.g.home_et_search);
        this.eXr = (ImageView) this.gOD.findViewById(d.g.home_bt_search_del);
        this.gNy = (TextView) this.gOD.findViewById(d.g.home_bt_search_cancel_s);
        this.eXr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.gOy.setText("");
            }
        });
        kA(false);
        this.gNy.setText(this.mContext.getString(d.j.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.gOy.getText().toString())) {
            this.gOD.setFocusable(true);
            this.gOD.setFocusableInTouchMode(true);
            this.gOD.requestFocus();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        al.g(this.gOz, i);
        if (i == 2) {
            this.gOy.setHintTextColor(al.getColor(d.C0277d.s_navbar_title_color));
        } else {
            this.gOy.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        al.c(this.eXr, d.f.del_search_btn);
        al.c(this.gOy, d.C0277d.cp_cont_b, d.C0277d.s_navbar_title_color);
        al.c(this.dpO, d.f.icon_search);
        al.k(this.gNw, d.C0277d.cp_bg_line_d);
        al.d(this.gNy, d.C0277d.cp_link_tip_a, 1);
    }

    private void bCa() {
        this.gOB = (QuickWebView) this.mRootView.findViewById(d.g.search_history_webview);
        this.gOB.pk(true);
    }

    private void bBD() {
        this.gNF = (BdListView) this.mRootView.findViewById(d.g.home_lv_search_suggest);
        this.gNH = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.gOC = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void bCb() {
        this.gOA = (QuickWebView) this.mRootView.findViewById(d.g.search_result_webview);
        this.gOA.pk(true);
    }

    private void bCc() {
        this.gOy.setText("");
        this.gOy.requestFocus();
        this.gNy.setText(this.mContext.getString(d.j.cancel));
    }

    public void bCd() {
        this.gOB.setVisibility(0);
        this.gNF.setVisibility(8);
        this.gOA.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bBN() {
        this.gNF.setVisibility(8);
        this.gOB.setVisibility(8);
        this.gOA.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bBL() {
        this.gNF.setVisibility(0);
        this.gOB.setVisibility(8);
        this.gOA.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bCe() {
        this.gNF.setVisibility(8);
        this.gOB.setVisibility(8);
        this.gOA.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void kA(boolean z) {
        this.eXr.setVisibility(z ? 0 : 8);
    }

    public void yq(String str) {
        if (!StringUtils.isNull(str)) {
            this.gOy.setHint(str);
        }
    }

    public void yr(String str) {
        if (!StringUtils.isNull(str)) {
            this.gOy.setText(str);
            this.gOy.setSelection(str.length());
        }
    }

    public void k(List<String> list, String str) {
        if (!v.T(list)) {
            bBL();
            this.gNH.yi(str);
            this.gNH.setData(list);
            this.gNF.setAdapter((ListAdapter) this.gNH);
        }
    }

    public void l(List<ForumInfo> list, String str) {
        if (!v.T(list) && !TextUtils.isEmpty(str)) {
            bBL();
            this.gOC.yi(str);
            this.gOC.dl(list);
            this.gNF.setAdapter((ListAdapter) this.gOC);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.gNF.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.gNF.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.gOy.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.gOy.setOnEditorActionListener(onEditorActionListener);
    }

    public void e(TextWatcher textWatcher) {
        this.gOy.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.gOy.setOnClickListener(onClickListener);
        this.gNy.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.gOA.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.gOA.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.gOA.setOnLoadUrlListener(bVar);
    }

    public EditText bCf() {
        return this.gOy;
    }

    public TextView bCg() {
        return this.gNy;
    }

    public QuickWebView bCh() {
        return this.gOA;
    }

    public QuickWebView bCi() {
        return this.gOB;
    }

    public boolean bCj() {
        return this.gNF.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.gNw != null) {
                this.gNw.removeView(this.gOB);
                this.gNw.removeView(this.gOA);
            }
            this.gOB.removeAllViews();
            this.gOA.removeAllViews();
            if (this.gOB != null) {
                this.gOB.destroy();
                this.gOB = null;
            }
            if (this.gOA != null) {
                this.gOA.destroy();
                this.gOA = null;
            }
        } catch (Exception e) {
        }
    }
}
