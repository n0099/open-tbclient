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
    private ImageView gcE;
    private EditText hjJ;
    private SearchMajorActivity kfZ;
    private RelativeLayout kga;
    private ImageView kgb;
    private RecyclerView kgc;
    private LinearLayoutManager kgd;
    private com.baidu.tieba.majorsearch.a.a kge;
    private LinearLayout kgf;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(View view, SearchMajorActivity searchMajorActivity) {
        this.mRootView = view;
        this.kfZ = searchMajorActivity;
        initView();
    }

    private void initView() {
        bvT();
        cSL();
        cSM();
    }

    private void bvT() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.kfZ.getResources().getString(R.string.search_major));
    }

    private void cSL() {
        this.kga = (RelativeLayout) this.mRootView.findViewById(R.id.search_container);
        this.kga.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.majorsearch.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    a.this.kga.setFocusable(true);
                    a.this.kga.setFocusableInTouchMode(true);
                    if (a.this.hjJ.hasFocus()) {
                        l.hideSoftKeyPad(a.this.kfZ, a.this.hjJ);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.gcE = (ImageView) this.mRootView.findViewById(R.id.search_icon);
        this.hjJ = (EditText) this.mRootView.findViewById(R.id.search_box);
        this.kgb = (ImageView) this.mRootView.findViewById(R.id.search_del);
        this.kgb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.majorsearch.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hjJ.setText("");
            }
        });
        nf(false);
        this.hjJ.setText("");
        this.hjJ.requestFocus();
    }

    private void cSM() {
        this.kgf = (LinearLayout) this.mRootView.findViewById(R.id.layout_container);
        this.kgc = (RecyclerView) this.mRootView.findViewById(R.id.rv_major_list);
        this.kgd = new LinearLayoutManager(this.kfZ);
        this.kgc.setLayoutManager(this.kgd);
        this.kge = new com.baidu.tieba.majorsearch.a.a(this.kfZ);
        this.kgc.setAdapter(this.kge);
    }

    public void onResume() {
        if (!StringUtils.isNull(this.hjJ.getText().toString())) {
            this.kga.setFocusable(true);
            this.kga.setFocusableInTouchMode(true);
            this.kga.requestFocus();
        }
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.hjJ.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.hjJ.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.hjJ.addTextChangedListener(textWatcher);
    }

    public void a(a.InterfaceC0743a interfaceC0743a) {
        this.kge.b(interfaceC0743a);
    }

    public void a(RecyclerView.OnScrollListener onScrollListener) {
        this.kgc.addOnScrollListener(onScrollListener);
    }

    public LinearLayout cSN() {
        return this.kgf;
    }

    public void nf(boolean z) {
        this.kgb.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        if (this.kge != null) {
            this.kge.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.kfZ.getPageContext(), i);
        this.hjJ.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        this.hjJ.setTextColor(ap.getColor(R.color.cp_cont_b));
        SvgManager.bkl().a(this.gcE, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.kga, R.drawable.search_major_bg);
        SvgManager.bkl().a(this.kgb, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void m(List<String> list, String str) {
        this.kgc.setVisibility(0);
        if (this.kge != null) {
            this.kge.Ms(str);
            this.kge.setData(list);
            this.kgc.setAdapter(this.kge);
        }
    }

    public void c(ErrorData errorData) {
        this.kgc.setVisibility(8);
        if (this.kge != null) {
            this.kge.cSP();
        }
    }
}
