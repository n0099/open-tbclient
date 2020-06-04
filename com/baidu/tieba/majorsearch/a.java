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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.majorsearch.a.a;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private ImageView fwJ;
    private EditText gxw;
    private SearchMajorActivity jik;
    private RelativeLayout jil;
    private ImageView jim;
    private RecyclerView jin;
    private LinearLayoutManager jio;
    private com.baidu.tieba.majorsearch.a.a jip;
    private LinearLayout jiq;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(View view, SearchMajorActivity searchMajorActivity) {
        this.mRootView = view;
        this.jik = searchMajorActivity;
        initView();
    }

    private void initView() {
        brd();
        cwz();
        cwA();
    }

    private void brd() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.jik.getResources().getString(R.string.search_major));
    }

    private void cwz() {
        this.jil = (RelativeLayout) this.mRootView.findViewById(R.id.search_container);
        this.jil.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.majorsearch.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    a.this.jil.setFocusable(true);
                    a.this.jil.setFocusableInTouchMode(true);
                    if (a.this.gxw.hasFocus()) {
                        l.hideSoftKeyPad(a.this.jik, a.this.gxw);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.fwJ = (ImageView) this.mRootView.findViewById(R.id.search_icon);
        this.gxw = (EditText) this.mRootView.findViewById(R.id.search_box);
        this.jim = (ImageView) this.mRootView.findViewById(R.id.search_del);
        this.jim.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.majorsearch.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gxw.setText("");
            }
        });
        lG(false);
        this.gxw.setText("");
        this.gxw.requestFocus();
    }

    private void cwA() {
        this.jiq = (LinearLayout) this.mRootView.findViewById(R.id.layout_container);
        this.jin = (RecyclerView) this.mRootView.findViewById(R.id.rv_major_list);
        this.jio = new LinearLayoutManager(this.jik);
        this.jin.setLayoutManager(this.jio);
        this.jip = new com.baidu.tieba.majorsearch.a.a(this.jik);
        this.jin.setAdapter(this.jip);
    }

    public void onResume() {
        if (!StringUtils.isNull(this.gxw.getText().toString())) {
            this.jil.setFocusable(true);
            this.jil.setFocusableInTouchMode(true);
            this.jil.requestFocus();
        }
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.gxw.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.gxw.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.gxw.addTextChangedListener(textWatcher);
    }

    public void a(a.InterfaceC0671a interfaceC0671a) {
        this.jip.b(interfaceC0671a);
    }

    public void a(RecyclerView.OnScrollListener onScrollListener) {
        this.jin.addOnScrollListener(onScrollListener);
    }

    public LinearLayout cwB() {
        return this.jiq;
    }

    public void lG(boolean z) {
        this.jim.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        if (this.jip != null) {
            this.jip.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.jik.getPageContext(), i);
        this.gxw.setHintTextColor(am.getColor(R.color.cp_cont_d));
        this.gxw.setTextColor(am.getColor(R.color.cp_cont_b));
        SvgManager.aUW().a(this.fwJ, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        am.setBackgroundResource(this.jil, R.drawable.search_major_bg);
        SvgManager.aUW().a(this.jim, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void l(List<String> list, String str) {
        this.jin.setVisibility(0);
        if (this.jip != null) {
            this.jip.HG(str);
            this.jip.setData(list);
            this.jin.setAdapter(this.jip);
        }
    }

    public void c(ErrorData errorData) {
        this.jin.setVisibility(8);
        if (this.jip != null) {
            this.jip.cwD();
        }
    }
}
