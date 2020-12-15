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
    private ImageView gNu;
    private EditText ict;
    private SearchMajorActivity lbm;
    private RelativeLayout lbn;
    private ImageView lbo;
    private RecyclerView lbp;
    private LinearLayoutManager lbq;
    private com.baidu.tieba.majorsearch.a.a lbr;
    private LinearLayout lbs;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(View view, SearchMajorActivity searchMajorActivity) {
        this.mRootView = view;
        this.lbm = searchMajorActivity;
        initView();
    }

    private void initView() {
        bFP();
        dgP();
        dgQ();
    }

    private void bFP() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.lbm.getResources().getString(R.string.search_major));
    }

    private void dgP() {
        this.lbn = (RelativeLayout) this.mRootView.findViewById(R.id.search_container);
        this.lbn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.majorsearch.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    a.this.lbn.setFocusable(true);
                    a.this.lbn.setFocusableInTouchMode(true);
                    if (a.this.ict.hasFocus()) {
                        l.hideSoftKeyPad(a.this.lbm, a.this.ict);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.gNu = (ImageView) this.mRootView.findViewById(R.id.search_icon);
        this.ict = (EditText) this.mRootView.findViewById(R.id.search_box);
        this.lbo = (ImageView) this.mRootView.findViewById(R.id.search_del);
        this.lbo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.majorsearch.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.ict.setText("");
            }
        });
        oJ(false);
        this.ict.setText("");
        this.ict.requestFocus();
    }

    private void dgQ() {
        this.lbs = (LinearLayout) this.mRootView.findViewById(R.id.layout_container);
        this.lbp = (RecyclerView) this.mRootView.findViewById(R.id.rv_major_list);
        this.lbq = new LinearLayoutManager(this.lbm);
        this.lbp.setLayoutManager(this.lbq);
        this.lbr = new com.baidu.tieba.majorsearch.a.a(this.lbm);
        this.lbp.setAdapter(this.lbr);
    }

    public void onResume() {
        if (!StringUtils.isNull(this.ict.getText().toString())) {
            this.lbn.setFocusable(true);
            this.lbn.setFocusableInTouchMode(true);
            this.lbn.requestFocus();
        }
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.ict.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.ict.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.ict.addTextChangedListener(textWatcher);
    }

    public void a(a.InterfaceC0809a interfaceC0809a) {
        this.lbr.b(interfaceC0809a);
    }

    public void a(RecyclerView.OnScrollListener onScrollListener) {
        this.lbp.addOnScrollListener(onScrollListener);
    }

    public LinearLayout dgR() {
        return this.lbs;
    }

    public void oJ(boolean z) {
        this.lbo.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        if (this.lbr != null) {
            this.lbr.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.lbm.getPageContext(), i);
        this.ict.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        this.ict.setTextColor(ap.getColor(R.color.CAM_X0105));
        SvgManager.btW().a(this.gNu, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.lbn, R.drawable.search_major_bg);
        SvgManager.btW().a(this.lbo, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void q(List<String> list, String str) {
        this.lbp.setVisibility(0);
        if (this.lbr != null) {
            this.lbr.OB(str);
            this.lbr.setData(list);
            this.lbp.setAdapter(this.lbr);
        }
    }

    public void c(ErrorData errorData) {
        this.lbp.setVisibility(8);
        if (this.lbr != null) {
            this.lbr.dgT();
        }
    }
}
