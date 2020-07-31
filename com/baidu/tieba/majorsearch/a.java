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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.majorsearch.a.a;
import java.util.List;
/* loaded from: classes18.dex */
public class a {
    private ImageView fNo;
    private EditText gPQ;
    private SearchMajorActivity jHW;
    private RelativeLayout jHX;
    private ImageView jHY;
    private RecyclerView jHZ;
    private LinearLayoutManager jIa;
    private com.baidu.tieba.majorsearch.a.a jIb;
    private LinearLayout jIc;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(View view, SearchMajorActivity searchMajorActivity) {
        this.mRootView = view;
        this.jHW = searchMajorActivity;
        initView();
    }

    private void initView() {
        bmb();
        cEo();
        cEp();
    }

    private void bmb() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.jHW.getResources().getString(R.string.search_major));
    }

    private void cEo() {
        this.jHX = (RelativeLayout) this.mRootView.findViewById(R.id.search_container);
        this.jHX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.majorsearch.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    a.this.jHX.setFocusable(true);
                    a.this.jHX.setFocusableInTouchMode(true);
                    if (a.this.gPQ.hasFocus()) {
                        l.hideSoftKeyPad(a.this.jHW, a.this.gPQ);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.fNo = (ImageView) this.mRootView.findViewById(R.id.search_icon);
        this.gPQ = (EditText) this.mRootView.findViewById(R.id.search_box);
        this.jHY = (ImageView) this.mRootView.findViewById(R.id.search_del);
        this.jHY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.majorsearch.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gPQ.setText("");
            }
        });
        mu(false);
        this.gPQ.setText("");
        this.gPQ.requestFocus();
    }

    private void cEp() {
        this.jIc = (LinearLayout) this.mRootView.findViewById(R.id.layout_container);
        this.jHZ = (RecyclerView) this.mRootView.findViewById(R.id.rv_major_list);
        this.jIa = new LinearLayoutManager(this.jHW);
        this.jHZ.setLayoutManager(this.jIa);
        this.jIb = new com.baidu.tieba.majorsearch.a.a(this.jHW);
        this.jHZ.setAdapter(this.jIb);
    }

    public void onResume() {
        if (!StringUtils.isNull(this.gPQ.getText().toString())) {
            this.jHX.setFocusable(true);
            this.jHX.setFocusableInTouchMode(true);
            this.jHX.requestFocus();
        }
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.gPQ.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.gPQ.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.gPQ.addTextChangedListener(textWatcher);
    }

    public void a(a.InterfaceC0695a interfaceC0695a) {
        this.jIb.b(interfaceC0695a);
    }

    public void a(RecyclerView.OnScrollListener onScrollListener) {
        this.jHZ.addOnScrollListener(onScrollListener);
    }

    public LinearLayout cEq() {
        return this.jIc;
    }

    public void mu(boolean z) {
        this.jHY.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        if (this.jIb != null) {
            this.jIb.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.jHW.getPageContext(), i);
        this.gPQ.setHintTextColor(ao.getColor(R.color.cp_cont_d));
        this.gPQ.setTextColor(ao.getColor(R.color.cp_cont_b));
        SvgManager.baR().a(this.fNo, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        ao.setBackgroundResource(this.jHX, R.drawable.search_major_bg);
        SvgManager.baR().a(this.jHY, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void l(List<String> list, String str) {
        this.jHZ.setVisibility(0);
        if (this.jIb != null) {
            this.jIb.IX(str);
            this.jIb.setData(list);
            this.jHZ.setAdapter(this.jIb);
        }
    }

    public void c(ErrorData errorData) {
        this.jHZ.setVisibility(8);
        if (this.jIb != null) {
            this.jIb.cEs();
        }
    }
}
