package com.baidu.tieba.mainentrance.view;

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
import com.baidu.adp.base.f;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.quickWebView.QuickWebView;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.List;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes7.dex */
public class c {
    private ImageView fhZ;
    private ImageView gZf;
    private EditText irP;
    private TextView irQ;
    private FrameLayout llm;
    private BdListView llu;
    private com.baidu.tieba.mainentrance.searchSuggestList.b llw;
    private LinearLayoutDetectsSoftKeyboard lmm;
    private QuickWebView lmn;
    private QuickWebView lmo;
    private View lmp;
    private boolean lmq = true;
    private com.baidu.tieba.mainentrance.searchSuggestList.a lmr;
    View lms;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public c(View view, Context context) {
        this.mRootView = view;
        this.mContext = context;
        initView();
    }

    private void initView() {
        bEP();
        this.lmm = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.lmm.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.view.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    c.this.lmm.setFocusable(true);
                    c.this.lmm.setFocusableInTouchMode(true);
                    if (c.this.irP.hasFocus()) {
                        l.hideSoftKeyPad(c.this.mContext, c.this.irP);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.llm = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.llm.addView(this.mNoDataView, 0);
        deF();
        deh();
        deG();
        deH();
    }

    private void bEP() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.lms = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.gZf = (ImageView) this.lms.findViewById(R.id.search_bar_icon);
        this.irP = (EditText) this.lms.findViewById(R.id.home_et_search);
        this.fhZ = (ImageView) this.lms.findViewById(R.id.home_bt_search_del);
        this.irQ = (TextView) this.lms.findViewById(R.id.home_bt_search_cancel_s);
        this.fhZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.irP.setText("");
            }
        });
        po(false);
        this.irQ.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.irP.getText().toString())) {
            this.lms.setFocusable(true);
            this.lms.setFocusableInTouchMode(true);
            this.lms.requestFocus();
        }
    }

    public void tS(boolean z) {
        this.lmq = z;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 0 && this.lmq) {
            this.lmp.setVisibility(0);
            this.lmp.setBackgroundColor(ap.getColor(skinType == 4 ? R.color.CAM_X0606 : R.color.CAM_X0605));
            return;
        }
        this.lmp.setVisibility(8);
    }

    public void onChangeSkinType(f<?> fVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(fVar, i);
        }
        ap.setBgColor(this.lmm, i);
        if (i == 2) {
            this.irP.setHintTextColor(ap.getColor(R.color.s_navbar_title_color));
        } else {
            this.irP.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        }
        this.mNavigationBar.onChangeSkinType(fVar, i);
        SvgManager.bsU().a(this.fhZ, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.irP, R.color.CAM_X0105, R.color.s_navbar_title_color);
        SvgManager.bsU().a(this.gZf, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.llm, R.color.CAM_X0201);
        ap.setViewTextColor(this.irQ, R.color.CAM_X0302, 1);
        tS(this.lmq);
        if (this.lmo != null) {
            this.lmo.onChangeSkinType();
        }
        if (this.lmn != null) {
            this.lmn.onChangeSkinType();
        }
    }

    private void deF() {
        this.lmo = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.lmo.xx(true);
        this.lmp = this.mRootView.findViewById(R.id.search_webview_mask);
    }

    private void deh() {
        this.llu = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.llw = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.lmr = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void deG() {
        this.lmn = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.lmn.xx(true);
    }

    private void deH() {
        this.irP.setText("");
        this.irP.requestFocus();
        this.irQ.setText(this.mContext.getString(R.string.cancel));
    }

    public void deI() {
        this.lmo.setVisibility(0);
        this.llu.setVisibility(8);
        this.lmn.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void des() {
        this.llu.setVisibility(8);
        this.lmo.setVisibility(8);
        this.lmn.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void deq() {
        this.llu.setVisibility(0);
        this.lmo.setVisibility(8);
        this.lmn.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void deJ() {
        this.llu.setVisibility(8);
        this.lmo.setVisibility(8);
        this.lmn.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void po(boolean z) {
        this.fhZ.setVisibility(z ? 0 : 8);
    }

    public void Oc(String str) {
        if (!StringUtils.isNull(str)) {
            this.irP.setHint(str);
        }
    }

    public void Od(String str) {
        if (!StringUtils.isNull(str)) {
            this.irP.setText(str);
            this.irP.setSelection(str.length());
        }
    }

    public void m(List<String> list, String str) {
        if (!y.isEmpty(list)) {
            deq();
            this.llw.NW(str);
            this.llw.setData(list);
            this.llu.setAdapter((ListAdapter) this.llw);
        }
    }

    public void n(List<ForumInfo> list, String str) {
        if (!y.isEmpty(list) && !TextUtils.isEmpty(str)) {
            deq();
            this.lmr.NW(str);
            this.lmr.eN(list);
            this.llu.setAdapter((ListAdapter) this.lmr);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.llu.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.llu.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.irP.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.irP.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.irP.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.irP.setOnClickListener(onClickListener);
        this.irQ.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.lmn.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.lmn.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.g gVar) {
        this.lmn.setOnReceivedSslErrorListener(gVar);
    }

    public void a(BaseWebView.b bVar) {
        this.lmn.setOnLoadUrlListener(bVar);
    }

    public EditText deK() {
        return this.irP;
    }

    public TextView deL() {
        return this.irQ;
    }

    public QuickWebView deM() {
        return this.lmn;
    }

    public QuickWebView deN() {
        return this.lmo;
    }

    public boolean deO() {
        return this.llu.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.llm != null) {
                this.llm.removeView(this.lmo);
                this.llm.removeView(this.lmn);
            }
            this.lmo.removeAllViews();
            this.lmn.removeAllViews();
            if (this.lmo != null) {
                this.lmo.destroy();
                this.lmo = null;
            }
            if (this.lmn != null) {
                this.lmn.destroy();
                this.lmn = null;
            }
        } catch (Exception e) {
        }
    }
}
