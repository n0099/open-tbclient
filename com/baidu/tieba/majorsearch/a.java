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
/* loaded from: classes23.dex */
public class a {
    private ImageView gEv;
    private EditText hRx;
    private SearchMajorActivity kNS;
    private RelativeLayout kNT;
    private ImageView kNU;
    private RecyclerView kNV;
    private LinearLayoutManager kNW;
    private com.baidu.tieba.majorsearch.a.a kNX;
    private LinearLayout kNY;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(View view, SearchMajorActivity searchMajorActivity) {
        this.mRootView = view;
        this.kNS = searchMajorActivity;
        initView();
    }

    private void initView() {
        bCo();
        dbC();
        dbD();
    }

    private void bCo() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.kNS.getResources().getString(R.string.search_major));
    }

    private void dbC() {
        this.kNT = (RelativeLayout) this.mRootView.findViewById(R.id.search_container);
        this.kNT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.majorsearch.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    a.this.kNT.setFocusable(true);
                    a.this.kNT.setFocusableInTouchMode(true);
                    if (a.this.hRx.hasFocus()) {
                        l.hideSoftKeyPad(a.this.kNS, a.this.hRx);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.gEv = (ImageView) this.mRootView.findViewById(R.id.search_icon);
        this.hRx = (EditText) this.mRootView.findViewById(R.id.search_box);
        this.kNU = (ImageView) this.mRootView.findViewById(R.id.search_del);
        this.kNU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.majorsearch.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hRx.setText("");
            }
        });
        on(false);
        this.hRx.setText("");
        this.hRx.requestFocus();
    }

    private void dbD() {
        this.kNY = (LinearLayout) this.mRootView.findViewById(R.id.layout_container);
        this.kNV = (RecyclerView) this.mRootView.findViewById(R.id.rv_major_list);
        this.kNW = new LinearLayoutManager(this.kNS);
        this.kNV.setLayoutManager(this.kNW);
        this.kNX = new com.baidu.tieba.majorsearch.a.a(this.kNS);
        this.kNV.setAdapter(this.kNX);
    }

    public void onResume() {
        if (!StringUtils.isNull(this.hRx.getText().toString())) {
            this.kNT.setFocusable(true);
            this.kNT.setFocusableInTouchMode(true);
            this.kNT.requestFocus();
        }
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.hRx.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.hRx.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.hRx.addTextChangedListener(textWatcher);
    }

    public void a(a.InterfaceC0793a interfaceC0793a) {
        this.kNX.b(interfaceC0793a);
    }

    public void a(RecyclerView.OnScrollListener onScrollListener) {
        this.kNV.addOnScrollListener(onScrollListener);
    }

    public LinearLayout dbE() {
        return this.kNY;
    }

    public void on(boolean z) {
        this.kNU.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        if (this.kNX != null) {
            this.kNX.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.kNS.getPageContext(), i);
        this.hRx.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        this.hRx.setTextColor(ap.getColor(R.color.CAM_X0105));
        SvgManager.bqB().a(this.gEv, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.kNT, R.drawable.search_major_bg);
        SvgManager.bqB().a(this.kNU, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void o(List<String> list, String str) {
        this.kNV.setVisibility(0);
        if (this.kNX != null) {
            this.kNX.Nu(str);
            this.kNX.setData(list);
            this.kNV.setAdapter(this.kNX);
        }
    }

    public void c(ErrorData errorData) {
        this.kNV.setVisibility(8);
        if (this.kNX != null) {
            this.kNX.dbG();
        }
    }
}
