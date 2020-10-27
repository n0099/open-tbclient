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
    private ImageView gza;
    private EditText hLa;
    private SearchMajorActivity kHJ;
    private RelativeLayout kHK;
    private ImageView kHL;
    private RecyclerView kHM;
    private LinearLayoutManager kHN;
    private com.baidu.tieba.majorsearch.a.a kHO;
    private LinearLayout kHP;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(View view, SearchMajorActivity searchMajorActivity) {
        this.mRootView = view;
        this.kHJ = searchMajorActivity;
        initView();
    }

    private void initView() {
        bAw();
        cZD();
        cZE();
    }

    private void bAw() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.kHJ.getResources().getString(R.string.search_major));
    }

    private void cZD() {
        this.kHK = (RelativeLayout) this.mRootView.findViewById(R.id.search_container);
        this.kHK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.majorsearch.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    a.this.kHK.setFocusable(true);
                    a.this.kHK.setFocusableInTouchMode(true);
                    if (a.this.hLa.hasFocus()) {
                        l.hideSoftKeyPad(a.this.kHJ, a.this.hLa);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.gza = (ImageView) this.mRootView.findViewById(R.id.search_icon);
        this.hLa = (EditText) this.mRootView.findViewById(R.id.search_box);
        this.kHL = (ImageView) this.mRootView.findViewById(R.id.search_del);
        this.kHL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.majorsearch.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hLa.setText("");
            }
        });
        oc(false);
        this.hLa.setText("");
        this.hLa.requestFocus();
    }

    private void cZE() {
        this.kHP = (LinearLayout) this.mRootView.findViewById(R.id.layout_container);
        this.kHM = (RecyclerView) this.mRootView.findViewById(R.id.rv_major_list);
        this.kHN = new LinearLayoutManager(this.kHJ);
        this.kHM.setLayoutManager(this.kHN);
        this.kHO = new com.baidu.tieba.majorsearch.a.a(this.kHJ);
        this.kHM.setAdapter(this.kHO);
    }

    public void onResume() {
        if (!StringUtils.isNull(this.hLa.getText().toString())) {
            this.kHK.setFocusable(true);
            this.kHK.setFocusableInTouchMode(true);
            this.kHK.requestFocus();
        }
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.hLa.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.hLa.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.hLa.addTextChangedListener(textWatcher);
    }

    public void a(a.InterfaceC0776a interfaceC0776a) {
        this.kHO.b(interfaceC0776a);
    }

    public void a(RecyclerView.OnScrollListener onScrollListener) {
        this.kHM.addOnScrollListener(onScrollListener);
    }

    public LinearLayout cZF() {
        return this.kHP;
    }

    public void oc(boolean z) {
        this.kHL.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        if (this.kHO != null) {
            this.kHO.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.kHJ.getPageContext(), i);
        this.hLa.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        this.hLa.setTextColor(ap.getColor(R.color.cp_cont_b));
        SvgManager.boN().a(this.gza, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.kHK, R.drawable.search_major_bg);
        SvgManager.boN().a(this.kHL, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void o(List<String> list, String str) {
        this.kHM.setVisibility(0);
        if (this.kHO != null) {
            this.kHO.NF(str);
            this.kHO.setData(list);
            this.kHM.setAdapter(this.kHO);
        }
    }

    public void c(ErrorData errorData) {
        this.kHM.setVisibility(8);
        if (this.kHO != null) {
            this.kHO.cZH();
        }
    }
}
