package com.baidu.tieba.majorsearch;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.majorsearch.a.a;
import java.util.List;
/* loaded from: classes24.dex */
public class a {
    private ImageView gNs;
    private EditText icr;
    private SearchMajorActivity lbk;
    private RelativeLayout lbl;
    private ImageView lbm;
    private RecyclerView lbn;
    private LinearLayoutManager lbo;
    private com.baidu.tieba.majorsearch.a.a lbp;
    private LinearLayout lbq;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(View view, SearchMajorActivity searchMajorActivity) {
        this.mRootView = view;
        this.lbk = searchMajorActivity;
        initView();
    }

    private void initView() {
        bFP();
        dgO();
        dgP();
    }

    private void bFP() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.lbk.getResources().getString(R.string.search_major));
    }

    private void dgO() {
        this.lbl = (RelativeLayout) this.mRootView.findViewById(R.id.search_container);
        this.lbl.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.majorsearch.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    a.this.lbl.setFocusable(true);
                    a.this.lbl.setFocusableInTouchMode(true);
                    if (a.this.icr.hasFocus()) {
                        l.hideSoftKeyPad(a.this.lbk, a.this.icr);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.gNs = (ImageView) this.mRootView.findViewById(R.id.search_icon);
        this.icr = (EditText) this.mRootView.findViewById(R.id.search_box);
        this.lbm = (ImageView) this.mRootView.findViewById(R.id.search_del);
        this.lbm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.majorsearch.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.icr.setText("");
            }
        });
        oJ(false);
        this.icr.setText("");
        this.icr.requestFocus();
    }

    private void dgP() {
        this.lbq = (LinearLayout) this.mRootView.findViewById(R.id.layout_container);
        this.lbn = (RecyclerView) this.mRootView.findViewById(R.id.rv_major_list);
        this.lbo = new LinearLayoutManager(this.lbk);
        this.lbn.setLayoutManager(this.lbo);
        this.lbp = new com.baidu.tieba.majorsearch.a.a(this.lbk);
        this.lbn.setAdapter(this.lbp);
    }

    public void onResume() {
        if (!StringUtils.isNull(this.icr.getText().toString())) {
            this.lbl.setFocusable(true);
            this.lbl.setFocusableInTouchMode(true);
            this.lbl.requestFocus();
        }
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.icr.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.icr.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.icr.addTextChangedListener(textWatcher);
    }

    public void a(a.InterfaceC0809a interfaceC0809a) {
        this.lbp.b(interfaceC0809a);
    }

    public void a(RecyclerView.OnScrollListener onScrollListener) {
        this.lbn.addOnScrollListener(onScrollListener);
    }

    public LinearLayout dgQ() {
        return this.lbq;
    }

    public void oJ(boolean z) {
        this.lbm.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        if (this.lbp != null) {
            this.lbp.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.lbk.getPageContext(), i);
        this.icr.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        this.icr.setTextColor(ap.getColor(R.color.CAM_X0105));
        SvgManager.btW().a(this.gNs, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.lbl, R.drawable.search_major_bg);
        SvgManager.btW().a(this.lbm, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void q(List<String> list, String str) {
        this.lbn.setVisibility(0);
        if (this.lbp != null) {
            this.lbp.OB(str);
            this.lbp.setData(list);
            this.lbn.setAdapter(this.lbp);
        }
    }

    public void c(ErrorData errorData) {
        this.lbn.setVisibility(8);
        if (this.lbp != null) {
            this.lbp.dgS();
        }
    }
}
