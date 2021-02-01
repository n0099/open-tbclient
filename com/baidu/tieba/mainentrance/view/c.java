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
/* loaded from: classes8.dex */
public class c {
    private ImageView fgA;
    private ImageView gXi;
    private EditText ipS;
    private TextView ipT;
    private FrameLayout liW;
    private LinearLayoutDetectsSoftKeyboard ljW;
    private QuickWebView ljX;
    private QuickWebView ljY;
    private View ljZ;
    private BdListView lje;
    private com.baidu.tieba.mainentrance.searchSuggestList.b ljg;
    private boolean lka = true;
    private com.baidu.tieba.mainentrance.searchSuggestList.a lkb;
    View lkc;
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
        bEL();
        this.ljW = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.ljW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.view.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    c.this.ljW.setFocusable(true);
                    c.this.ljW.setFocusableInTouchMode(true);
                    if (c.this.ipS.hasFocus()) {
                        l.hideSoftKeyPad(c.this.mContext, c.this.ipS);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.liW = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.liW.addView(this.mNoDataView, 0);
        dep();
        ddR();
        deq();
        der();
    }

    private void bEL() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.lkc = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.gXi = (ImageView) this.lkc.findViewById(R.id.search_bar_icon);
        this.ipS = (EditText) this.lkc.findViewById(R.id.home_et_search);
        this.fgA = (ImageView) this.lkc.findViewById(R.id.home_bt_search_del);
        this.ipT = (TextView) this.lkc.findViewById(R.id.home_bt_search_cancel_s);
        this.fgA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.ipS.setText("");
            }
        });
        po(false);
        this.ipT.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.ipS.getText().toString())) {
            this.lkc.setFocusable(true);
            this.lkc.setFocusableInTouchMode(true);
            this.lkc.requestFocus();
        }
    }

    public void tS(boolean z) {
        this.lka = z;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 0 && this.lka) {
            this.ljZ.setVisibility(0);
            this.ljZ.setBackgroundColor(ap.getColor(skinType == 4 ? R.color.CAM_X0606 : R.color.CAM_X0605));
            return;
        }
        this.ljZ.setVisibility(8);
    }

    public void onChangeSkinType(f<?> fVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(fVar, i);
        }
        ap.setBgColor(this.ljW, i);
        if (i == 2) {
            this.ipS.setHintTextColor(ap.getColor(R.color.s_navbar_title_color));
        } else {
            this.ipS.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        }
        this.mNavigationBar.onChangeSkinType(fVar, i);
        SvgManager.bsR().a(this.fgA, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.ipS, R.color.CAM_X0105, R.color.s_navbar_title_color);
        SvgManager.bsR().a(this.gXi, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.liW, R.color.CAM_X0201);
        ap.setViewTextColor(this.ipT, R.color.CAM_X0302, 1);
        tS(this.lka);
        if (this.ljY != null) {
            this.ljY.onChangeSkinType();
        }
        if (this.ljX != null) {
            this.ljX.onChangeSkinType();
        }
    }

    private void dep() {
        this.ljY = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.ljY.xx(true);
        this.ljZ = this.mRootView.findViewById(R.id.search_webview_mask);
    }

    private void ddR() {
        this.lje = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.ljg = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.lkb = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void deq() {
        this.ljX = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.ljX.xx(true);
    }

    private void der() {
        this.ipS.setText("");
        this.ipS.requestFocus();
        this.ipT.setText(this.mContext.getString(R.string.cancel));
    }

    public void des() {
        this.ljY.setVisibility(0);
        this.lje.setVisibility(8);
        this.ljX.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void dec() {
        this.lje.setVisibility(8);
        this.ljY.setVisibility(8);
        this.ljX.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void dea() {
        this.lje.setVisibility(0);
        this.ljY.setVisibility(8);
        this.ljX.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void det() {
        this.lje.setVisibility(8);
        this.ljY.setVisibility(8);
        this.ljX.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void po(boolean z) {
        this.fgA.setVisibility(z ? 0 : 8);
    }

    public void NV(String str) {
        if (!StringUtils.isNull(str)) {
            this.ipS.setHint(str);
        }
    }

    public void NW(String str) {
        if (!StringUtils.isNull(str)) {
            this.ipS.setText(str);
            this.ipS.setSelection(str.length());
        }
    }

    public void m(List<String> list, String str) {
        if (!y.isEmpty(list)) {
            dea();
            this.ljg.NP(str);
            this.ljg.setData(list);
            this.lje.setAdapter((ListAdapter) this.ljg);
        }
    }

    public void n(List<ForumInfo> list, String str) {
        if (!y.isEmpty(list) && !TextUtils.isEmpty(str)) {
            dea();
            this.lkb.NP(str);
            this.lkb.eN(list);
            this.lje.setAdapter((ListAdapter) this.lkb);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.lje.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.lje.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.ipS.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.ipS.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.ipS.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ipS.setOnClickListener(onClickListener);
        this.ipT.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.ljX.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.ljX.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.g gVar) {
        this.ljX.setOnReceivedSslErrorListener(gVar);
    }

    public void a(BaseWebView.b bVar) {
        this.ljX.setOnLoadUrlListener(bVar);
    }

    public EditText deu() {
        return this.ipS;
    }

    public TextView dev() {
        return this.ipT;
    }

    public QuickWebView dew() {
        return this.ljX;
    }

    public QuickWebView dex() {
        return this.ljY;
    }

    public boolean dey() {
        return this.lje.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.liW != null) {
                this.liW.removeView(this.ljY);
                this.liW.removeView(this.ljX);
            }
            this.ljY.removeAllViews();
            this.ljX.removeAllViews();
            if (this.ljY != null) {
                this.ljY.destroy();
                this.ljY = null;
            }
            if (this.ljX != null) {
                this.ljX.destroy();
                this.ljX = null;
            }
        } catch (Exception e) {
        }
    }
}
