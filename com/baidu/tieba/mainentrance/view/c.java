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
    private ImageView gXw;
    private EditText iqg;
    private TextView iqh;
    private FrameLayout ljk;
    private BdListView ljs;
    private com.baidu.tieba.mainentrance.searchSuggestList.b lju;
    private LinearLayoutDetectsSoftKeyboard lkk;
    private QuickWebView lkl;
    private QuickWebView lkm;
    private View lkn;
    private boolean lko = true;
    private com.baidu.tieba.mainentrance.searchSuggestList.a lkp;
    View lkq;
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
        this.lkk = (LinearLayoutDetectsSoftKeyboard) this.mRootView.findViewById(R.id.search_container);
        this.lkk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.mainentrance.view.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    c.this.lkk.setFocusable(true);
                    c.this.lkk.setFocusableInTouchMode(true);
                    if (c.this.iqg.hasFocus()) {
                        l.hideSoftKeyPad(c.this.mContext, c.this.iqg);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.ljk = (FrameLayout) this.mRootView.findViewById(R.id.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds200)), null, null);
        this.ljk.addView(this.mNoDataView, 0);
        dew();
        ddY();
        dex();
        dey();
    }

    private void bEL() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.lkq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.gXw = (ImageView) this.lkq.findViewById(R.id.search_bar_icon);
        this.iqg = (EditText) this.lkq.findViewById(R.id.home_et_search);
        this.fgA = (ImageView) this.lkq.findViewById(R.id.home_bt_search_del);
        this.iqh = (TextView) this.lkq.findViewById(R.id.home_bt_search_cancel_s);
        this.fgA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.iqg.setText("");
            }
        });
        po(false);
        this.iqh.setText(this.mContext.getString(R.string.cancel));
    }

    public void onResume() {
        if (!StringUtils.isNull(this.iqg.getText().toString())) {
            this.lkq.setFocusable(true);
            this.lkq.setFocusableInTouchMode(true);
            this.lkq.requestFocus();
        }
    }

    public void tS(boolean z) {
        this.lko = z;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 0 && this.lko) {
            this.lkn.setVisibility(0);
            this.lkn.setBackgroundColor(ap.getColor(skinType == 4 ? R.color.CAM_X0606 : R.color.CAM_X0605));
            return;
        }
        this.lkn.setVisibility(8);
    }

    public void onChangeSkinType(f<?> fVar, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(fVar, i);
        }
        ap.setBgColor(this.lkk, i);
        if (i == 2) {
            this.iqg.setHintTextColor(ap.getColor(R.color.s_navbar_title_color));
        } else {
            this.iqg.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        }
        this.mNavigationBar.onChangeSkinType(fVar, i);
        SvgManager.bsR().a(this.fgA, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.iqg, R.color.CAM_X0105, R.color.s_navbar_title_color);
        SvgManager.bsR().a(this.gXw, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.ljk, R.color.CAM_X0201);
        ap.setViewTextColor(this.iqh, R.color.CAM_X0302, 1);
        tS(this.lko);
        if (this.lkm != null) {
            this.lkm.onChangeSkinType();
        }
        if (this.lkl != null) {
            this.lkl.onChangeSkinType();
        }
    }

    private void dew() {
        this.lkm = (QuickWebView) this.mRootView.findViewById(R.id.search_history_webview);
        this.lkm.xx(true);
        this.lkn = this.mRootView.findViewById(R.id.search_webview_mask);
    }

    private void ddY() {
        this.ljs = (BdListView) this.mRootView.findViewById(R.id.home_lv_search_suggest);
        this.lju = new com.baidu.tieba.mainentrance.searchSuggestList.b(this.mContext, null);
        this.lkp = new com.baidu.tieba.mainentrance.searchSuggestList.a(this.mContext, null);
    }

    private void dex() {
        this.lkl = (QuickWebView) this.mRootView.findViewById(R.id.search_result_webview);
        this.lkl.xx(true);
    }

    private void dey() {
        this.iqg.setText("");
        this.iqg.requestFocus();
        this.iqh.setText(this.mContext.getString(R.string.cancel));
    }

    public void dez() {
        this.lkm.setVisibility(0);
        this.ljs.setVisibility(8);
        this.lkl.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void dej() {
        this.ljs.setVisibility(8);
        this.lkm.setVisibility(8);
        this.lkl.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void deh() {
        this.ljs.setVisibility(0);
        this.lkm.setVisibility(8);
        this.lkl.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    public void deA() {
        this.ljs.setVisibility(8);
        this.lkm.setVisibility(8);
        this.lkl.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public void po(boolean z) {
        this.fgA.setVisibility(z ? 0 : 8);
    }

    public void NW(String str) {
        if (!StringUtils.isNull(str)) {
            this.iqg.setHint(str);
        }
    }

    public void NX(String str) {
        if (!StringUtils.isNull(str)) {
            this.iqg.setText(str);
            this.iqg.setSelection(str.length());
        }
    }

    public void m(List<String> list, String str) {
        if (!y.isEmpty(list)) {
            deh();
            this.lju.NQ(str);
            this.lju.setData(list);
            this.ljs.setAdapter((ListAdapter) this.lju);
        }
    }

    public void n(List<ForumInfo> list, String str) {
        if (!y.isEmpty(list) && !TextUtils.isEmpty(str)) {
            deh();
            this.lkp.NQ(str);
            this.lkp.eN(list);
            this.ljs.setAdapter((ListAdapter) this.lkp);
        }
    }

    public void a(NoDataViewFactory.d dVar) {
        this.mNoDataView.setTextOption(dVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.ljs.setOnItemClickListener(onItemClickListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.ljs.setOnScrollListener(onScrollListener);
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.iqg.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.iqg.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.iqg.addTextChangedListener(textWatcher);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.iqg.setOnClickListener(onClickListener);
        this.iqh.setOnClickListener(onClickListener);
    }

    public void a(BaseWebView.c cVar) {
        this.lkl.setOnPageFinishedListener(cVar);
    }

    public void a(BaseWebView.f fVar) {
        this.lkl.setOnReceivedErrorListener(fVar);
    }

    public void a(BaseWebView.g gVar) {
        this.lkl.setOnReceivedSslErrorListener(gVar);
    }

    public void a(BaseWebView.b bVar) {
        this.lkl.setOnLoadUrlListener(bVar);
    }

    public EditText deB() {
        return this.iqg;
    }

    public TextView deC() {
        return this.iqh;
    }

    public QuickWebView deD() {
        return this.lkl;
    }

    public QuickWebView deE() {
        return this.lkm;
    }

    public boolean deF() {
        return this.ljs.getVisibility() == 0;
    }

    public void onDestroy() {
        try {
            if (this.ljk != null) {
                this.ljk.removeView(this.lkm);
                this.ljk.removeView(this.lkl);
            }
            this.lkm.removeAllViews();
            this.lkl.removeAllViews();
            if (this.lkm != null) {
                this.lkm.destroy();
                this.lkm = null;
            }
            if (this.lkl != null) {
                this.lkl.destroy();
                this.lkl = null;
            }
        } catch (Exception e) {
        }
    }
}
