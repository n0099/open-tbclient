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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.majorsearch.a.a;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private ImageView fHT;
    private EditText gKk;
    private SearchMajorActivity jzs;
    private RelativeLayout jzt;
    private ImageView jzu;
    private RecyclerView jzv;
    private LinearLayoutManager jzw;
    private com.baidu.tieba.majorsearch.a.a jzx;
    private LinearLayout jzy;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(View view, SearchMajorActivity searchMajorActivity) {
        this.mRootView = view;
        this.jzs = searchMajorActivity;
        initView();
    }

    private void initView() {
        biq();
        cAr();
        cAs();
    }

    private void biq() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.jzs.getResources().getString(R.string.search_major));
    }

    private void cAr() {
        this.jzt = (RelativeLayout) this.mRootView.findViewById(R.id.search_container);
        this.jzt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.majorsearch.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    a.this.jzt.setFocusable(true);
                    a.this.jzt.setFocusableInTouchMode(true);
                    if (a.this.gKk.hasFocus()) {
                        l.hideSoftKeyPad(a.this.jzs, a.this.gKk);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.fHT = (ImageView) this.mRootView.findViewById(R.id.search_icon);
        this.gKk = (EditText) this.mRootView.findViewById(R.id.search_box);
        this.jzu = (ImageView) this.mRootView.findViewById(R.id.search_del);
        this.jzu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.majorsearch.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gKk.setText("");
            }
        });
        lP(false);
        this.gKk.setText("");
        this.gKk.requestFocus();
    }

    private void cAs() {
        this.jzy = (LinearLayout) this.mRootView.findViewById(R.id.layout_container);
        this.jzv = (RecyclerView) this.mRootView.findViewById(R.id.rv_major_list);
        this.jzw = new LinearLayoutManager(this.jzs);
        this.jzv.setLayoutManager(this.jzw);
        this.jzx = new com.baidu.tieba.majorsearch.a.a(this.jzs);
        this.jzv.setAdapter(this.jzx);
    }

    public void onResume() {
        if (!StringUtils.isNull(this.gKk.getText().toString())) {
            this.jzt.setFocusable(true);
            this.jzt.setFocusableInTouchMode(true);
            this.jzt.requestFocus();
        }
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.gKk.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.gKk.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.gKk.addTextChangedListener(textWatcher);
    }

    public void a(a.InterfaceC0684a interfaceC0684a) {
        this.jzx.b(interfaceC0684a);
    }

    public void a(RecyclerView.OnScrollListener onScrollListener) {
        this.jzv.addOnScrollListener(onScrollListener);
    }

    public LinearLayout cAt() {
        return this.jzy;
    }

    public void lP(boolean z) {
        this.jzu.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        if (this.jzx != null) {
            this.jzx.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.jzs.getPageContext(), i);
        this.gKk.setHintTextColor(an.getColor(R.color.cp_cont_d));
        this.gKk.setTextColor(an.getColor(R.color.cp_cont_b));
        SvgManager.aWQ().a(this.fHT, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        an.setBackgroundResource(this.jzt, R.drawable.search_major_bg);
        SvgManager.aWQ().a(this.jzu, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void k(List<String> list, String str) {
        this.jzv.setVisibility(0);
        if (this.jzx != null) {
            this.jzx.Ii(str);
            this.jzx.setData(list);
            this.jzv.setAdapter(this.jzx);
        }
    }

    public void c(ErrorData errorData) {
        this.jzv.setVisibility(8);
        if (this.jzx != null) {
            this.jzx.cAv();
        }
    }
}
