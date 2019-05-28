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
    private ImageView dAy;
    private ImageView eqA;
    private TextView eqB;
    private EditText eqz;
    private FrameLayout heG;
    private BdListView heO;
    private com.baidu.tieba.mainentrance.searchSuggestList.b heQ;
    private LinearLayoutDetectsSoftKeyboard hfH;
    private QuickWebView hfI;
    private QuickWebView hfJ;
    private com.baidu.tieba.mainentrance.searchSuggestList.a hfK;
    View hfL;
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
        aHR();
        this.hfH = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.hfH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.hfH.setFocusable(true);
                    d.this.hfH.setFocusableInTouchMode(true);
                    if (d.this.eqz.hasFocus()) {
                        l.b(d.this.mContext, d.this.eqz);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.heG = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.heG.addView(this.mNoDataView, 0);
        bJK();
        bJn();
        bJL();
        bJM();
    }

    private void aHR() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.hfL = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.dAy = (ImageView) this.hfL.findViewById(R.id.search_bar_icon);
        this.eqz = (EditText) this.hfL.findViewById(R.id.home_et_search);
        this.eqA = (ImageView) this.hfL.findViewById(R.id.home_bt_search_del);
        this.eqB = (TextView) this.hfL.findViewById(R.id.home_bt_search_cancel_s);
        this.eqA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.eqz.setText("");
            }
        });
        ij(false);
        this.eqB.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.eqz.getText().toString())) {
            this.hfL.setFocusable(true);
            this.hfL.setFocusableInTouchMode(true);
            this.hfL.requestFocus();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        al.g(this.hfH, i);
        if (i == 2) {
            this.eqz.setHintTextColor(al.getColor(R.color.s_navbar_title_color));
        } else {
            this.eqz.setHintTextColor(al.getColor(R.color.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        al.c(this.eqA, (int) R.drawable.del_search_btn);
        al.e(this.eqz, R.color.cp_cont_b, R.color.s_navbar_title_color);
        al.c(this.dAy, (int) R.drawable.icon_search);
        al.k(this.heG, R.color.cp_bg_line_d);
        al.f(this.eqB, R.color.cp_link_tip_a, 1);
    }

    private void bJK() {
        this.hfJ = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.hfJ.pY(true);
    }

    private void bJn() {
        this.heO = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.heQ = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.hfK = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void bJL() {
        this.hfI = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.hfI.pY(true);
    }

    private void bJM() {
        this.eqz.setText("");
        this.eqz.requestFocus();
        this.eqB.setText(this.mContext.getString(R.string.cancel));
    }

    public void bJN() {
        this.hfJ.setVisibility(0);
        this.heO.setVisibility(8);
        this.hfI.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bJx() {
        this.heO.setVisibility(8);
        this.hfJ.setVisibility(8);
        this.hfI.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bJv() {
        this.heO.setVisibility(0);
        this.hfJ.setVisibility(8);
        this.hfI.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bJO() {
        this.heO.setVisibility(8);
        this.hfJ.setVisibility(8);
        this.hfI.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void ij(boolean z) {
        this.eqA.setVisibility(z ? 0 : 8);
    }

    public void zF(String str) {
        if (!StringUtils.isNull(str)) {
            this.eqz.setHint(str);
        }
    }

    public void zG(String str) {
        if (!StringUtils.isNull(str)) {
            this.eqz.setText(str);
            this.eqz.setSelection(str.length());
        }
    }

    public void k(List<String> list, String str) {
        if (!v.aa(list)) {
            bJv();
            this.heQ.zx(str);
            this.heQ.setData(list);
            this.heO.setAdapter((ListAdapter) this.heQ);
        }
    }

    public void l(List<ForumInfo> list, String str) {
        if (!v.aa(list) && !TextUtils.isEmpty(str)) {
            bJv();
            this.hfK.zx(str);
            this.hfK.dq(list);
            this.heO.setAdapter((ListAdapter) this.hfK);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.heO.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.heO.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.eqz.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.eqz.setOnEditorActionListener(onEditorActionListener);
    }

    public void e(TextWatcher textWatcher) {
        this.eqz.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eqz.setOnClickListener(onClickListener);
        this.eqB.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.hfI.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.hfI.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.hfI.setOnLoadUrlListener(bVar);
    }

    public EditText bJP() {
        return this.eqz;
    }

    public TextView bJQ() {
        return this.eqB;
    }

    public QuickWebView bJR() {
        return this.hfI;
    }

    public QuickWebView bJS() {
        return this.hfJ;
    }

    public boolean bJT() {
        return this.heO.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.heG != null) {
                this.heG.removeView(this.hfJ);
                this.heG.removeView(this.hfI);
            }
            this.hfJ.removeAllViews();
            this.hfI.removeAllViews();
            if (this.hfJ != null) {
                this.hfJ.destroy();
                this.hfJ = null;
            }
            if (this.hfI != null) {
                this.hfI.destroy();
                this.hfI = null;
            }
        } catch (Exception e) {
        }
    }
}
