package com.baidu.tieba.majorsearch;

import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.majorsearch.adapter.SearchMajorResultItemAdapter;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private ImageView gXi;
    private EditText ipS;
    private SearchMajorActivity lkn;
    private RelativeLayout lko;
    private ImageView lkp;
    private RecyclerView lkq;
    private LinearLayoutManager lkr;
    private SearchMajorResultItemAdapter lks;
    private LinearLayout lkt;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(View view, SearchMajorActivity searchMajorActivity) {
        this.mRootView = view;
        this.lkn = searchMajorActivity;
        initView();
    }

    private void initView() {
        bEL();
        deK();
        deL();
    }

    private void bEL() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.lkn.getResources().getString(R.string.search_major));
    }

    private void deK() {
        this.lko = (RelativeLayout) this.mRootView.findViewById(R.id.search_container);
        this.lko.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.majorsearch.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    a.this.lko.setFocusable(true);
                    a.this.lko.setFocusableInTouchMode(true);
                    if (a.this.ipS.hasFocus()) {
                        l.hideSoftKeyPad(a.this.lkn, a.this.ipS);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.gXi = (ImageView) this.mRootView.findViewById(R.id.search_icon);
        this.ipS = (EditText) this.mRootView.findViewById(R.id.search_box);
        this.lkp = (ImageView) this.mRootView.findViewById(R.id.search_del);
        this.lkp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.majorsearch.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.ipS.setText("");
            }
        });
        po(false);
        this.ipS.setText("");
        this.ipS.requestFocus();
    }

    private void deL() {
        this.lkt = (LinearLayout) this.mRootView.findViewById(R.id.layout_container);
        this.lkq = (RecyclerView) this.mRootView.findViewById(R.id.rv_major_list);
        this.lkr = new LinearLayoutManager(this.lkn);
        this.lkq.setLayoutManager(this.lkr);
        this.lks = new SearchMajorResultItemAdapter(this.lkn);
        this.lkq.setAdapter(this.lks);
    }

    public void onResume() {
        if (!StringUtils.isNull(this.ipS.getText().toString())) {
            this.lko.setFocusable(true);
            this.lko.setFocusableInTouchMode(true);
            this.lko.requestFocus();
        }
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.ipS.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.ipS.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.ipS.addTextChangedListener(textWatcher);
    }

    public void a(SearchMajorResultItemAdapter.a aVar) {
        this.lks.b(aVar);
    }

    public void a(RecyclerView.OnScrollListener onScrollListener) {
        this.lkq.addOnScrollListener(onScrollListener);
    }

    public LinearLayout deM() {
        return this.lkt;
    }

    public void po(boolean z) {
        this.lkp.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        if (this.lks != null) {
            this.lks.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.lkn.getPageContext(), i);
        this.ipS.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        this.ipS.setTextColor(ap.getColor(R.color.CAM_X0105));
        SvgManager.bsR().a(this.gXi, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.lko, R.drawable.search_major_bg);
        SvgManager.bsR().a(this.lkp, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void o(List<String> list, String str) {
        this.lkq.setVisibility(0);
        if (this.lks != null) {
            this.lks.NP(str);
            this.lks.setData(list);
            this.lkq.setAdapter(this.lks);
        }
    }

    public void c(ErrorData errorData) {
        this.lkq.setVisibility(8);
        if (this.lks != null) {
            this.lks.deO();
        }
    }
}
