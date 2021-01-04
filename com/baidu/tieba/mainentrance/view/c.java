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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.quickWebView.QuickWebView;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.List;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes8.dex */
public class c {
    private ImageView fiW;
    private ImageView gZe;
    private EditText ioT;
    private TextView ioU;
    private FrameLayout lfA;
    private BdListView lfI;
    private com.baidu.tieba.mainentrance.searchSuggestList.b lfK;
    private LinearLayoutDetectsSoftKeyboard lgA;
    private QuickWebView lgB;
    private QuickWebView lgC;
    private View lgD;
    private boolean lgE = true;
    private com.baidu.tieba.mainentrance.searchSuggestList.a lgF;
    View lgG;
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
        bIk();
        this.lgA = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.lgA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.view.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    c.this.lgA.setFocusable(true);
                    c.this.lgA.setFocusableInTouchMode(true);
                    if (c.this.ioT.hasFocus()) {
                        l.hideSoftKeyPad(c.this.mContext, c.this.ioT);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.lfA = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.lfA.addView(this.mNoDataView, 0);
        dgi();
        dfK();
        dgj();
        dgk();
    }

    private void bIk() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.lgG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.gZe = (ImageView) this.lgG.findViewById(R.id.search_bar_icon);
        this.ioT = (EditText) this.lgG.findViewById(R.id.home_et_search);
        this.fiW = (ImageView) this.lgG.findViewById(R.id.home_bt_search_del);
        this.ioU = (TextView) this.lgG.findViewById(R.id.home_bt_search_cancel_s);
        this.fiW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.ioT.setText("");
            }
        });
        pi(false);
        this.ioU.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.ioT.getText().toString())) {
            this.lgG.setFocusable(true);
            this.lgG.setFocusableInTouchMode(true);
            this.lgG.requestFocus();
        }
    }

    public void tJ(boolean z) {
        this.lgE = z;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 0 && this.lgE) {
            this.lgD.setVisibility(0);
            this.lgD.setBackgroundColor(ao.getColor(skinType == 4 ? R.color.CAM_X0606 : R.color.CAM_X0605));
            return;
        }
        this.lgD.setVisibility(8);
    }

    public void onChangeSkinType(f<?> fVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(fVar, i);
        }
        ao.setBgColor(this.lgA, i);
        if (i == 2) {
            this.ioT.setHintTextColor(ao.getColor(R.color.s_navbar_title_color));
        } else {
            this.ioT.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        }
        this.mNavigationBar.onChangeSkinType(fVar, i);
        SvgManager.bwq().a(this.fiW, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ao.setNavbarTitleColor(this.ioT, R.color.CAM_X0105, R.color.s_navbar_title_color);
        SvgManager.bwq().a(this.gZe, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ao.setBackgroundResource(this.lfA, R.color.CAM_X0201);
        ao.setViewTextColor(this.ioU, R.color.CAM_X0302, 1);
        tJ(this.lgE);
        if (this.lgC != null) {
            this.lgC.onChangeSkinType();
        }
        if (this.lgB != null) {
            this.lgB.onChangeSkinType();
        }
    }

    private void dgi() {
        this.lgC = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.lgC.xj(true);
        this.lgD = this.mRootView.findViewById(R.id.search_webview_mask);
    }

    private void dfK() {
        this.lfI = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.lfK = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.lgF = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void dgj() {
        this.lgB = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.lgB.xj(true);
    }

    private void dgk() {
        this.ioT.setText("");
        this.ioT.requestFocus();
        this.ioU.setText(this.mContext.getString(R.string.cancel));
    }

    public void dgl() {
        this.lgC.setVisibility(0);
        this.lfI.setVisibility(8);
        this.lgB.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void dfV() {
        this.lfI.setVisibility(8);
        this.lgC.setVisibility(8);
        this.lgB.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void dfT() {
        this.lfI.setVisibility(0);
        this.lgC.setVisibility(8);
        this.lgB.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void dgm() {
        this.lfI.setVisibility(8);
        this.lgC.setVisibility(8);
        this.lgB.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void pi(boolean z) {
        this.fiW.setVisibility(z ? 0 : 8);
    }

    public void Op(String str) {
        if (!StringUtils.isNull(str)) {
            this.ioT.setHint(str);
        }
    }

    public void Oq(String str) {
        if (!StringUtils.isNull(str)) {
            this.ioT.setText(str);
            this.ioT.setSelection(str.length());
        }
    }

    public void o(List<String> list, String str) {
        if (!x.isEmpty(list)) {
            dfT();
            this.lfK.Oj(str);
            this.lfK.setData(list);
            this.lfI.setAdapter((ListAdapter) this.lfK);
        }
    }

    public void p(List<ForumInfo> list, String str) {
        if (!x.isEmpty(list) && !TextUtils.isEmpty(str)) {
            dfT();
            this.lgF.Oj(str);
            this.lgF.eP(list);
            this.lfI.setAdapter((ListAdapter) this.lgF);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.lfI.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.lfI.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.ioT.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.ioT.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.ioT.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ioT.setOnClickListener(onClickListener);
        this.ioU.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.lgB.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.lgB.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.g gVar) {
        this.lgB.setOnReceivedSslErrorListener(gVar);
    }

    public void a(BaseWebView.b bVar) {
        this.lgB.setOnLoadUrlListener(bVar);
    }

    public EditText dgn() {
        return this.ioT;
    }

    public TextView dgo() {
        return this.ioU;
    }

    public QuickWebView dgp() {
        return this.lgB;
    }

    public QuickWebView dgq() {
        return this.lgC;
    }

    public boolean dgr() {
        return this.lfI.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.lfA != null) {
                this.lfA.removeView(this.lgC);
                this.lfA.removeView(this.lgB);
            }
            this.lgC.removeAllViews();
            this.lgB.removeAllViews();
            if (this.lgC != null) {
                this.lgC.destroy();
                this.lgC = null;
            }
            if (this.lgB != null) {
                this.lgB.destroy();
                this.lgB = null;
            }
        } catch (Exception e) {
        }
    }
}
