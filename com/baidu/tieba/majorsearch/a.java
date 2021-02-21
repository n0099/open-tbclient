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
    private ImageView gXw;
    private EditText iqg;
    private SearchMajorActivity lkB;
    private RelativeLayout lkC;
    private ImageView lkD;
    private RecyclerView lkE;
    private LinearLayoutManager lkF;
    private SearchMajorResultItemAdapter lkG;
    private LinearLayout lkH;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(View view, SearchMajorActivity searchMajorActivity) {
        this.mRootView = view;
        this.lkB = searchMajorActivity;
        initView();
    }

    private void initView() {
        bEL();
        deR();
        deS();
    }

    private void bEL() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.lkB.getResources().getString(R.string.search_major));
    }

    private void deR() {
        this.lkC = (RelativeLayout) this.mRootView.findViewById(R.id.search_container);
        this.lkC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.majorsearch.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    a.this.lkC.setFocusable(true);
                    a.this.lkC.setFocusableInTouchMode(true);
                    if (a.this.iqg.hasFocus()) {
                        l.hideSoftKeyPad(a.this.lkB, a.this.iqg);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.gXw = (ImageView) this.mRootView.findViewById(R.id.search_icon);
        this.iqg = (EditText) this.mRootView.findViewById(R.id.search_box);
        this.lkD = (ImageView) this.mRootView.findViewById(R.id.search_del);
        this.lkD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.majorsearch.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.iqg.setText("");
            }
        });
        po(false);
        this.iqg.setText("");
        this.iqg.requestFocus();
    }

    private void deS() {
        this.lkH = (LinearLayout) this.mRootView.findViewById(R.id.layout_container);
        this.lkE = (RecyclerView) this.mRootView.findViewById(R.id.rv_major_list);
        this.lkF = new LinearLayoutManager(this.lkB);
        this.lkE.setLayoutManager(this.lkF);
        this.lkG = new SearchMajorResultItemAdapter(this.lkB);
        this.lkE.setAdapter(this.lkG);
    }

    public void onResume() {
        if (!StringUtils.isNull(this.iqg.getText().toString())) {
            this.lkC.setFocusable(true);
            this.lkC.setFocusableInTouchMode(true);
            this.lkC.requestFocus();
        }
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.iqg.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.iqg.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.iqg.addTextChangedListener(textWatcher);
    }

    public void a(SearchMajorResultItemAdapter.a aVar) {
        this.lkG.b(aVar);
    }

    public void a(RecyclerView.OnScrollListener onScrollListener) {
        this.lkE.addOnScrollListener(onScrollListener);
    }

    public LinearLayout deT() {
        return this.lkH;
    }

    public void po(boolean z) {
        this.lkD.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        if (this.lkG != null) {
            this.lkG.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.lkB.getPageContext(), i);
        this.iqg.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        this.iqg.setTextColor(ap.getColor(R.color.CAM_X0105));
        SvgManager.bsR().a(this.gXw, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.lkC, R.drawable.search_major_bg);
        SvgManager.bsR().a(this.lkD, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void o(List<String> list, String str) {
        this.lkE.setVisibility(0);
        if (this.lkG != null) {
            this.lkG.NQ(str);
            this.lkG.setData(list);
            this.lkE.setAdapter(this.lkG);
        }
    }

    public void c(ErrorData errorData) {
        this.lkE.setVisibility(8);
        if (this.lkG != null) {
            this.lkG.deV();
        }
    }
}
