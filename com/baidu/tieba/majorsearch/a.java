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
    private ImageView fZq;
    private EditText hcK;
    private LinearLayoutManager jXA;
    private com.baidu.tieba.majorsearch.a.a jXB;
    private LinearLayout jXC;
    private SearchMajorActivity jXw;
    private RelativeLayout jXx;
    private ImageView jXy;
    private RecyclerView jXz;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(View view, SearchMajorActivity searchMajorActivity) {
        this.mRootView = view;
        this.jXw = searchMajorActivity;
        initView();
    }

    private void initView() {
        buP();
        cPg();
        cPh();
    }

    private void buP() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.jXw.getResources().getString(R.string.search_major));
    }

    private void cPg() {
        this.jXx = (RelativeLayout) this.mRootView.findViewById(R.id.search_container);
        this.jXx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.majorsearch.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    a.this.jXx.setFocusable(true);
                    a.this.jXx.setFocusableInTouchMode(true);
                    if (a.this.hcK.hasFocus()) {
                        l.hideSoftKeyPad(a.this.jXw, a.this.hcK);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.fZq = (ImageView) this.mRootView.findViewById(R.id.search_icon);
        this.hcK = (EditText) this.mRootView.findViewById(R.id.search_box);
        this.jXy = (ImageView) this.mRootView.findViewById(R.id.search_del);
        this.jXy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.majorsearch.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hcK.setText("");
            }
        });
        mZ(false);
        this.hcK.setText("");
        this.hcK.requestFocus();
    }

    private void cPh() {
        this.jXC = (LinearLayout) this.mRootView.findViewById(R.id.layout_container);
        this.jXz = (RecyclerView) this.mRootView.findViewById(R.id.rv_major_list);
        this.jXA = new LinearLayoutManager(this.jXw);
        this.jXz.setLayoutManager(this.jXA);
        this.jXB = new com.baidu.tieba.majorsearch.a.a(this.jXw);
        this.jXz.setAdapter(this.jXB);
    }

    public void onResume() {
        if (!StringUtils.isNull(this.hcK.getText().toString())) {
            this.jXx.setFocusable(true);
            this.jXx.setFocusableInTouchMode(true);
            this.jXx.requestFocus();
        }
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.hcK.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.hcK.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.hcK.addTextChangedListener(textWatcher);
    }

    public void a(a.InterfaceC0746a interfaceC0746a) {
        this.jXB.b(interfaceC0746a);
    }

    public void a(RecyclerView.OnScrollListener onScrollListener) {
        this.jXz.addOnScrollListener(onScrollListener);
    }

    public LinearLayout cPi() {
        return this.jXC;
    }

    public void mZ(boolean z) {
        this.jXy.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        if (this.jXB != null) {
            this.jXB.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.jXw.getPageContext(), i);
        this.hcK.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        this.hcK.setTextColor(ap.getColor(R.color.cp_cont_b));
        SvgManager.bjq().a(this.fZq, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.jXx, R.drawable.search_major_bg);
        SvgManager.bjq().a(this.jXy, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void l(List<String> list, String str) {
        this.jXz.setVisibility(0);
        if (this.jXB != null) {
            this.jXB.LQ(str);
            this.jXB.setData(list);
            this.jXz.setAdapter(this.jXB);
        }
    }

    public void c(ErrorData errorData) {
        this.jXz.setVisibility(8);
        if (this.jXB != null) {
            this.jXB.cPk();
        }
    }
}
