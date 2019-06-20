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
    private FrameLayout heH;
    private BdListView heP;
    private com.baidu.tieba.mainentrance.searchSuggestList.b heR;
    private LinearLayoutDetectsSoftKeyboard hfI;
    private QuickWebView hfJ;
    private QuickWebView hfK;
    private com.baidu.tieba.mainentrance.searchSuggestList.a hfL;
    View hfM;
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
        this.hfI = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.hfI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.a.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    d.this.hfI.setFocusable(true);
                    d.this.hfI.setFocusableInTouchMode(true);
                    if (d.this.eqz.hasFocus()) {
                        l.b(d.this.mContext, d.this.eqz);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.heH = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.heH.addView(this.mNoDataView, 0);
        bJL();
        bJo();
        bJM();
        bJN();
    }

    private void aHR() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.hfM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.dAy = (ImageView) this.hfM.findViewById(R.id.search_bar_icon);
        this.eqz = (EditText) this.hfM.findViewById(R.id.home_et_search);
        this.eqA = (ImageView) this.hfM.findViewById(R.id.home_bt_search_del);
        this.eqB = (TextView) this.hfM.findViewById(R.id.home_bt_search_cancel_s);
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
            this.hfM.setFocusable(true);
            this.hfM.setFocusableInTouchMode(true);
            this.hfM.requestFocus();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(eVar, i);
        }
        al.g(this.hfI, i);
        if (i == 2) {
            this.eqz.setHintTextColor(al.getColor(R.color.s_navbar_title_color));
        } else {
            this.eqz.setHintTextColor(al.getColor(R.color.cp_cont_e));
        }
        this.mNavigationBar.onChangeSkinType(eVar, i);
        al.c(this.eqA, (int) R.drawable.del_search_btn);
        al.e(this.eqz, R.color.cp_cont_b, R.color.s_navbar_title_color);
        al.c(this.dAy, (int) R.drawable.icon_search);
        al.k(this.heH, R.color.cp_bg_line_d);
        al.f(this.eqB, R.color.cp_link_tip_a, 1);
    }

    private void bJL() {
        this.hfK = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.hfK.pZ(true);
    }

    private void bJo() {
        this.heP = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.heR = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.hfL = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void bJM() {
        this.hfJ = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.hfJ.pZ(true);
    }

    private void bJN() {
        this.eqz.setText("");
        this.eqz.requestFocus();
        this.eqB.setText(this.mContext.getString(R.string.cancel));
    }

    public void bJO() {
        this.hfK.setVisibility(0);
        this.heP.setVisibility(8);
        this.hfJ.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bJy() {
        this.heP.setVisibility(8);
        this.hfK.setVisibility(8);
        this.hfJ.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bJw() {
        this.heP.setVisibility(0);
        this.hfK.setVisibility(8);
        this.hfJ.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void bJP() {
        this.heP.setVisibility(8);
        this.hfK.setVisibility(8);
        this.hfJ.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void ij(boolean z) {
        this.eqA.setVisibility(z ? 0 : 8);
    }

    public void zH(String str) {
        if (!StringUtils.isNull(str)) {
            this.eqz.setHint(str);
        }
    }

    public void zI(String str) {
        if (!StringUtils.isNull(str)) {
            this.eqz.setText(str);
            this.eqz.setSelection(str.length());
        }
    }

    public void k(List<String> list, String str) {
        if (!v.aa(list)) {
            bJw();
            this.heR.zz(str);
            this.heR.setData(list);
            this.heP.setAdapter((ListAdapter) this.heR);
        }
    }

    public void l(List<ForumInfo> list, String str) {
        if (!v.aa(list) && !TextUtils.isEmpty(str)) {
            bJw();
            this.hfL.zz(str);
            this.hfL.dq(list);
            this.heP.setAdapter((ListAdapter) this.hfL);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.heP.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.heP.setOnScrollListener(onScrollListener);
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
        this.hfJ.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.hfJ.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.b bVar) {
        this.hfJ.setOnLoadUrlListener(bVar);
    }

    public EditText bJQ() {
        return this.eqz;
    }

    public TextView bJR() {
        return this.eqB;
    }

    public QuickWebView bJS() {
        return this.hfJ;
    }

    public QuickWebView bJT() {
        return this.hfK;
    }

    public boolean bJU() {
        return this.heP.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.heH != null) {
                this.heH.removeView(this.hfK);
                this.heH.removeView(this.hfJ);
            }
            this.hfK.removeAllViews();
            this.hfJ.removeAllViews();
            if (this.hfK != null) {
                this.hfK.destroy();
                this.hfK = null;
            }
            if (this.hfJ != null) {
                this.hfJ.destroy();
                this.hfJ = null;
            }
        } catch (Exception e) {
        }
    }
}
