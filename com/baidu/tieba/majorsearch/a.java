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
    private ImageView gEO;
    private EditText hQX;
    private SearchMajorActivity kNF;
    private RelativeLayout kNG;
    private ImageView kNH;
    private RecyclerView kNI;
    private LinearLayoutManager kNJ;
    private com.baidu.tieba.majorsearch.a.a kNK;
    private LinearLayout kNL;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(View view, SearchMajorActivity searchMajorActivity) {
        this.mRootView = view;
        this.kNF = searchMajorActivity;
        initView();
    }

    private void initView() {
        bCV();
        dcf();
        dcg();
    }

    private void bCV() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.kNF.getResources().getString(R.string.search_major));
    }

    private void dcf() {
        this.kNG = (RelativeLayout) this.mRootView.findViewById(R.id.search_container);
        this.kNG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.majorsearch.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    a.this.kNG.setFocusable(true);
                    a.this.kNG.setFocusableInTouchMode(true);
                    if (a.this.hQX.hasFocus()) {
                        l.hideSoftKeyPad(a.this.kNF, a.this.hQX);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.gEO = (ImageView) this.mRootView.findViewById(R.id.search_icon);
        this.hQX = (EditText) this.mRootView.findViewById(R.id.search_box);
        this.kNH = (ImageView) this.mRootView.findViewById(R.id.search_del);
        this.kNH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.majorsearch.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hQX.setText("");
            }
        });
        ol(false);
        this.hQX.setText("");
        this.hQX.requestFocus();
    }

    private void dcg() {
        this.kNL = (LinearLayout) this.mRootView.findViewById(R.id.layout_container);
        this.kNI = (RecyclerView) this.mRootView.findViewById(R.id.rv_major_list);
        this.kNJ = new LinearLayoutManager(this.kNF);
        this.kNI.setLayoutManager(this.kNJ);
        this.kNK = new com.baidu.tieba.majorsearch.a.a(this.kNF);
        this.kNI.setAdapter(this.kNK);
    }

    public void onResume() {
        if (!StringUtils.isNull(this.hQX.getText().toString())) {
            this.kNG.setFocusable(true);
            this.kNG.setFocusableInTouchMode(true);
            this.kNG.requestFocus();
        }
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.hQX.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.hQX.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.hQX.addTextChangedListener(textWatcher);
    }

    public void a(a.InterfaceC0791a interfaceC0791a) {
        this.kNK.b(interfaceC0791a);
    }

    public void a(RecyclerView.OnScrollListener onScrollListener) {
        this.kNI.addOnScrollListener(onScrollListener);
    }

    public LinearLayout dch() {
        return this.kNL;
    }

    public void ol(boolean z) {
        this.kNH.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        if (this.kNK != null) {
            this.kNK.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.kNF.getPageContext(), i);
        this.hQX.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        this.hQX.setTextColor(ap.getColor(R.color.cp_cont_b));
        SvgManager.brn().a(this.gEO, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.kNG, R.drawable.search_major_bg);
        SvgManager.brn().a(this.kNH, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void p(List<String> list, String str) {
        this.kNI.setVisibility(0);
        if (this.kNK != null) {
            this.kNK.NW(str);
            this.kNK.setData(list);
            this.kNI.setAdapter(this.kNK);
        }
    }

    public void c(ErrorData errorData) {
        this.kNI.setVisibility(8);
        if (this.kNK != null) {
            this.kNK.dcj();
        }
    }
}
