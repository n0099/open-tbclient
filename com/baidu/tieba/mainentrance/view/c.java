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
/* loaded from: classes7.dex */
public class c {
    private ImageView fel;
    private ImageView gUy;
    private EditText ikk;
    private TextView ikl;
    private FrameLayout laT;
    private LinearLayoutDetectsSoftKeyboard lbT;
    private QuickWebView lbU;
    private QuickWebView lbV;
    private View lbW;
    private boolean lbX = true;
    private com.baidu.tieba.mainentrance.searchSuggestList.a lbY;
    View lbZ;
    private BdListView lbb;
    private com.baidu.tieba.mainentrance.searchSuggestList.b lbd;
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
        bEt();
        this.lbT = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.lbT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.view.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    c.this.lbT.setFocusable(true);
                    c.this.lbT.setFocusableInTouchMode(true);
                    if (c.this.ikk.hasFocus()) {
                        l.hideSoftKeyPad(c.this.mContext, c.this.ikk);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.laT = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.laT.addView(this.mNoDataView, 0);
        dcr();
        dbT();
        dcs();
        dct();
    }

    private void bEt() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.lbZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.gUy = (ImageView) this.lbZ.findViewById(R.id.search_bar_icon);
        this.ikk = (EditText) this.lbZ.findViewById(R.id.home_et_search);
        this.fel = (ImageView) this.lbZ.findViewById(R.id.home_bt_search_del);
        this.ikl = (TextView) this.lbZ.findViewById(R.id.home_bt_search_cancel_s);
        this.fel.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.ikk.setText("");
            }
        });
        pe(false);
        this.ikl.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.ikk.getText().toString())) {
            this.lbZ.setFocusable(true);
            this.lbZ.setFocusableInTouchMode(true);
            this.lbZ.requestFocus();
        }
    }

    public void tF(boolean z) {
        this.lbX = z;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 0 && this.lbX) {
            this.lbW.setVisibility(0);
            this.lbW.setBackgroundColor(ao.getColor(skinType == 4 ? R.color.CAM_X0606 : R.color.CAM_X0605));
            return;
        }
        this.lbW.setVisibility(8);
    }

    public void onChangeSkinType(f<?> fVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(fVar, i);
        }
        ao.setBgColor(this.lbT, i);
        if (i == 2) {
            this.ikk.setHintTextColor(ao.getColor(R.color.s_navbar_title_color));
        } else {
            this.ikk.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        }
        this.mNavigationBar.onChangeSkinType(fVar, i);
        SvgManager.bsx().a(this.fel, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ao.setNavbarTitleColor(this.ikk, R.color.CAM_X0105, R.color.s_navbar_title_color);
        SvgManager.bsx().a(this.gUy, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ao.setBackgroundResource(this.laT, R.color.CAM_X0201);
        ao.setViewTextColor(this.ikl, R.color.CAM_X0302, 1);
        tF(this.lbX);
        if (this.lbV != null) {
            this.lbV.onChangeSkinType();
        }
        if (this.lbU != null) {
            this.lbU.onChangeSkinType();
        }
    }

    private void dcr() {
        this.lbV = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.lbV.xf(true);
        this.lbW = this.mRootView.findViewById(R.id.search_webview_mask);
    }

    private void dbT() {
        this.lbb = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.lbd = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.lbY = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void dcs() {
        this.lbU = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.lbU.xf(true);
    }

    private void dct() {
        this.ikk.setText("");
        this.ikk.requestFocus();
        this.ikl.setText(this.mContext.getString(R.string.cancel));
    }

    public void dcu() {
        this.lbV.setVisibility(0);
        this.lbb.setVisibility(8);
        this.lbU.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void dce() {
        this.lbb.setVisibility(8);
        this.lbV.setVisibility(8);
        this.lbU.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void dcc() {
        this.lbb.setVisibility(0);
        this.lbV.setVisibility(8);
        this.lbU.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void dcv() {
        this.lbb.setVisibility(8);
        this.lbV.setVisibility(8);
        this.lbU.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void pe(boolean z) {
        this.fel.setVisibility(z ? 0 : 8);
    }

    public void Ng(String str) {
        if (!StringUtils.isNull(str)) {
            this.ikk.setHint(str);
        }
    }

    public void Nh(String str) {
        if (!StringUtils.isNull(str)) {
            this.ikk.setText(str);
            this.ikk.setSelection(str.length());
        }
    }

    public void o(List<String> list, String str) {
        if (!x.isEmpty(list)) {
            dcc();
            this.lbd.Na(str);
            this.lbd.setData(list);
            this.lbb.setAdapter((ListAdapter) this.lbd);
        }
    }

    public void p(List<ForumInfo> list, String str) {
        if (!x.isEmpty(list) && !TextUtils.isEmpty(str)) {
            dcc();
            this.lbY.Na(str);
            this.lbY.eP(list);
            this.lbb.setAdapter((ListAdapter) this.lbY);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.lbb.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.lbb.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.ikk.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.ikk.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.ikk.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ikk.setOnClickListener(onClickListener);
        this.ikl.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.lbU.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.lbU.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.g gVar) {
        this.lbU.setOnReceivedSslErrorListener(gVar);
    }

    public void a(BaseWebView.b bVar) {
        this.lbU.setOnLoadUrlListener(bVar);
    }

    public EditText dcw() {
        return this.ikk;
    }

    public TextView dcx() {
        return this.ikl;
    }

    public QuickWebView dcy() {
        return this.lbU;
    }

    public QuickWebView dcz() {
        return this.lbV;
    }

    public boolean dcA() {
        return this.lbb.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.laT != null) {
                this.laT.removeView(this.lbV);
                this.laT.removeView(this.lbU);
            }
            this.lbV.removeAllViews();
            this.lbU.removeAllViews();
            if (this.lbV != null) {
                this.lbV.destroy();
                this.lbV = null;
            }
            if (this.lbU != null) {
                this.lbU.destroy();
                this.lbU = null;
            }
        } catch (Exception e) {
        }
    }
}
