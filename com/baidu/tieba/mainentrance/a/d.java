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
    private ImageView dpS;
    private ImageView eXe;
    private FrameLayout gNk;
    private TextView gNm;
    private BdListView gNt;
    private com.baidu.tieba.mainentrance.searchSuggestList.b gNv;
    private EditText gOm;
    private LinearLayoutDetectsSoftKeyboard gOn;
    private QuickWebView gOo;
    private QuickWebView gOp;
    private com.baidu.tieba.mainentrance.searchSuggestList.a gOq;
    View gOr;
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
        aBy();
        this.gOn = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(d.g.search_container);
        this.gOn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.gOn.setFocusable(true);
                    d.this.gOn.setFocusableInTouchMode(true);
                    if (d.this.gOm.hasFocus()) {
                        l.b(d.this.mContext, d.this.gOm);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.gNk = (FrameLayout) this.mRootView.findViewById(d.g.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds200)), null, null);
        this.gNk.addView(this.mNoDataView, 0);
        bBX();
        bBA();
        bBY();
        bBZ();
    }

    private void aBy() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.gOr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.square_search_navigation_view, (View.OnClickListener) null);
        this.dpS = (ImageView) this.gOr.findViewById(d.g.search_bar_icon);
        this.gOm = (EditText) this.gOr.findViewById(d.g.home_et_search);
        this.eXe = (ImageView) this.gOr.findViewById(d.g.home_bt_search_del);
        this.gNm = (TextView) this.gOr.findViewById(d.g.home_bt_search_cancel_s);
        this.eXe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.gOm.setText("");
            }
        });
        kA(false);
        this.gNm.setText(this.mContext.getString(d.j.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.gOm.getText().toString())) {
            this.gOr.setFocusable(true);
            this.gOr.setFocusableInTouchMode(true);
            this.gOr.requestFocus();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        al.g(this.gOn, i);
        if (i == 2) {
            this.gOm.setHintTextColor(al.getColor(d.C0277d.s_navbar_title_color));
        } else {
            this.gOm.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        al.c(this.eXe, d.f.del_search_btn);
        al.c(this.gOm, d.C0277d.cp_cont_b, d.C0277d.s_navbar_title_color);
        al.c(this.dpS, d.f.icon_search);
        al.k(this.gNk, d.C0277d.cp_bg_line_d);
        al.d(this.gNm, d.C0277d.cp_link_tip_a, 1);
    }

    private void bBX() {
        this.gOp = (QuickWebView) this.mRootView.findViewById(d.g.search_history_webview);
        this.gOp.pk(true);
    }

    private void bBA() {
        this.gNt = (BdListView) this.mRootView.findViewById(d.g.home_lv_search_suggest);
        this.gNv = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.gOq = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void bBY() {
        this.gOo = (QuickWebView) this.mRootView.findViewById(d.g.search_result_webview);
        this.gOo.pk(true);
    }

    private void bBZ() {
        this.gOm.setText("");
        this.gOm.requestFocus();
        this.gNm.setText(this.mContext.getString(d.j.cancel));
    }

    public void bCa() {
        this.gOp.setVisibility(0);
        this.gNt.setVisibility(8);
        this.gOo.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bBK() {
        this.gNt.setVisibility(8);
        this.gOp.setVisibility(8);
        this.gOo.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bBI() {
        this.gNt.setVisibility(0);
        this.gOp.setVisibility(8);
        this.gOo.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bCb() {
        this.gNt.setVisibility(8);
        this.gOp.setVisibility(8);
        this.gOo.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void kA(boolean z) {
        this.eXe.setVisibility(z ? 0 : 8);
    }

    public void yp(String str) {
        if (!StringUtils.isNull(str)) {
            this.gOm.setHint(str);
        }
    }

    public void yq(String str) {
        if (!StringUtils.isNull(str)) {
            this.gOm.setText(str);
            this.gOm.setSelection(str.length());
        }
    }

    public void k(List<String> list, String str) {
        if (!v.T(list)) {
            bBI();
            this.gNv.yh(str);
            this.gNv.setData(list);
            this.gNt.setAdapter((ListAdapter) this.gNv);
        }
    }

    public void l(List<ForumInfo> list, String str) {
        if (!v.T(list) && !TextUtils.isEmpty(str)) {
            bBI();
            this.gOq.yh(str);
            this.gOq.di(list);
            this.gNt.setAdapter((ListAdapter) this.gOq);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.gNt.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.gNt.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.gOm.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.gOm.setOnEditorActionListener(onEditorActionListener);
    }

    public void e(TextWatcher textWatcher) {
        this.gOm.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.gOm.setOnClickListener(onClickListener);
        this.gNm.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.gOo.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.gOo.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.gOo.setOnLoadUrlListener(bVar);
    }

    public EditText bCc() {
        return this.gOm;
    }

    public TextView bCd() {
        return this.gNm;
    }

    public QuickWebView bCe() {
        return this.gOo;
    }

    public QuickWebView bCf() {
        return this.gOp;
    }

    public boolean bCg() {
        return this.gNt.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.gNk != null) {
                this.gNk.removeView(this.gOp);
                this.gNk.removeView(this.gOo);
            }
            this.gOp.removeAllViews();
            this.gOo.removeAllViews();
            if (this.gOp != null) {
                this.gOp.destroy();
                this.gOp = null;
            }
            if (this.gOo != null) {
                this.gOo.destroy();
                this.gOo = null;
            }
        } catch (Exception e) {
        }
    }
}
