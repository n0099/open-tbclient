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
/* loaded from: classes18.dex */
public class a {
    private ImageView fZm;
    private EditText hcG;
    private SearchMajorActivity jXp;
    private RelativeLayout jXq;
    private ImageView jXr;
    private RecyclerView jXs;
    private LinearLayoutManager jXt;
    private com.baidu.tieba.majorsearch.a.a jXu;
    private LinearLayout jXv;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(View view, SearchMajorActivity searchMajorActivity) {
        this.mRootView = view;
        this.jXp = searchMajorActivity;
        initView();
    }

    private void initView() {
        buO();
        cPf();
        cPg();
    }

    private void buO() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.jXp.getResources().getString(R.string.search_major));
    }

    private void cPf() {
        this.jXq = (RelativeLayout) this.mRootView.findViewById(R.id.search_container);
        this.jXq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.majorsearch.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    a.this.jXq.setFocusable(true);
                    a.this.jXq.setFocusableInTouchMode(true);
                    if (a.this.hcG.hasFocus()) {
                        l.hideSoftKeyPad(a.this.jXp, a.this.hcG);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.fZm = (ImageView) this.mRootView.findViewById(R.id.search_icon);
        this.hcG = (EditText) this.mRootView.findViewById(R.id.search_box);
        this.jXr = (ImageView) this.mRootView.findViewById(R.id.search_del);
        this.jXr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.majorsearch.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hcG.setText("");
            }
        });
        mX(false);
        this.hcG.setText("");
        this.hcG.requestFocus();
    }

    private void cPg() {
        this.jXv = (LinearLayout) this.mRootView.findViewById(R.id.layout_container);
        this.jXs = (RecyclerView) this.mRootView.findViewById(R.id.rv_major_list);
        this.jXt = new LinearLayoutManager(this.jXp);
        this.jXs.setLayoutManager(this.jXt);
        this.jXu = new com.baidu.tieba.majorsearch.a.a(this.jXp);
        this.jXs.setAdapter(this.jXu);
    }

    public void onResume() {
        if (!StringUtils.isNull(this.hcG.getText().toString())) {
            this.jXq.setFocusable(true);
            this.jXq.setFocusableInTouchMode(true);
            this.jXq.requestFocus();
        }
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.hcG.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.hcG.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.hcG.addTextChangedListener(textWatcher);
    }

    public void a(a.InterfaceC0746a interfaceC0746a) {
        this.jXu.b(interfaceC0746a);
    }

    public void a(RecyclerView.OnScrollListener onScrollListener) {
        this.jXs.addOnScrollListener(onScrollListener);
    }

    public LinearLayout cPh() {
        return this.jXv;
    }

    public void mX(boolean z) {
        this.jXr.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        if (this.jXu != null) {
            this.jXu.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.jXp.getPageContext(), i);
        this.hcG.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        this.hcG.setTextColor(ap.getColor(R.color.cp_cont_b));
        SvgManager.bjq().a(this.fZm, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.jXq, R.drawable.search_major_bg);
        SvgManager.bjq().a(this.jXr, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void l(List<String> list, String str) {
        this.jXs.setVisibility(0);
        if (this.jXu != null) {
            this.jXu.LP(str);
            this.jXu.setData(list);
            this.jXs.setAdapter(this.jXu);
        }
    }

    public void c(ErrorData errorData) {
        this.jXs.setVisibility(8);
        if (this.jXu != null) {
            this.jXu.cPj();
        }
    }
}
