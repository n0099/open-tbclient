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
    private ImageView goV;
    private EditText hyE;
    private SearchMajorActivity kvm;
    private RelativeLayout kvn;
    private ImageView kvo;
    private RecyclerView kvp;
    private LinearLayoutManager kvq;
    private com.baidu.tieba.majorsearch.a.a kvr;
    private LinearLayout kvs;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(View view, SearchMajorActivity searchMajorActivity) {
        this.mRootView = view;
        this.kvm = searchMajorActivity;
        initView();
    }

    private void initView() {
        byD();
        cWv();
        cWw();
    }

    private void byD() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.kvm.getResources().getString(R.string.search_major));
    }

    private void cWv() {
        this.kvn = (RelativeLayout) this.mRootView.findViewById(R.id.search_container);
        this.kvn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.majorsearch.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    a.this.kvn.setFocusable(true);
                    a.this.kvn.setFocusableInTouchMode(true);
                    if (a.this.hyE.hasFocus()) {
                        l.hideSoftKeyPad(a.this.kvm, a.this.hyE);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.goV = (ImageView) this.mRootView.findViewById(R.id.search_icon);
        this.hyE = (EditText) this.mRootView.findViewById(R.id.search_box);
        this.kvo = (ImageView) this.mRootView.findViewById(R.id.search_del);
        this.kvo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.majorsearch.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hyE.setText("");
            }
        });
        nK(false);
        this.hyE.setText("");
        this.hyE.requestFocus();
    }

    private void cWw() {
        this.kvs = (LinearLayout) this.mRootView.findViewById(R.id.layout_container);
        this.kvp = (RecyclerView) this.mRootView.findViewById(R.id.rv_major_list);
        this.kvq = new LinearLayoutManager(this.kvm);
        this.kvp.setLayoutManager(this.kvq);
        this.kvr = new com.baidu.tieba.majorsearch.a.a(this.kvm);
        this.kvp.setAdapter(this.kvr);
    }

    public void onResume() {
        if (!StringUtils.isNull(this.hyE.getText().toString())) {
            this.kvn.setFocusable(true);
            this.kvn.setFocusableInTouchMode(true);
            this.kvn.requestFocus();
        }
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.hyE.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.hyE.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.hyE.addTextChangedListener(textWatcher);
    }

    public void a(a.InterfaceC0761a interfaceC0761a) {
        this.kvr.b(interfaceC0761a);
    }

    public void a(RecyclerView.OnScrollListener onScrollListener) {
        this.kvp.addOnScrollListener(onScrollListener);
    }

    public LinearLayout cWx() {
        return this.kvs;
    }

    public void nK(boolean z) {
        this.kvo.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        if (this.kvr != null) {
            this.kvr.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.kvm.getPageContext(), i);
        this.hyE.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        this.hyE.setTextColor(ap.getColor(R.color.cp_cont_b));
        SvgManager.bmU().a(this.goV, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.kvn, R.drawable.search_major_bg);
        SvgManager.bmU().a(this.kvo, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void m(List<String> list, String str) {
        this.kvp.setVisibility(0);
        if (this.kvr != null) {
            this.kvr.Nh(str);
            this.kvr.setData(list);
            this.kvp.setAdapter(this.kvr);
        }
    }

    public void c(ErrorData errorData) {
        this.kvp.setVisibility(8);
        if (this.kvr != null) {
            this.kvr.cWz();
        }
    }
}
