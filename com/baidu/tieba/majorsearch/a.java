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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.majorsearch.adapter.SearchMajorResultItemAdapter;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private ImageView gZe;
    private EditText ioT;
    private SearchMajorActivity lgQ;
    private RelativeLayout lgR;
    private ImageView lgS;
    private RecyclerView lgT;
    private LinearLayoutManager lgU;
    private SearchMajorResultItemAdapter lgV;
    private LinearLayout lgW;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(View view, SearchMajorActivity searchMajorActivity) {
        this.mRootView = view;
        this.lgQ = searchMajorActivity;
        initView();
    }

    private void initView() {
        bIl();
        dgC();
        dgD();
    }

    private void bIl() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.lgQ.getResources().getString(R.string.search_major));
    }

    private void dgC() {
        this.lgR = (RelativeLayout) this.mRootView.findViewById(R.id.search_container);
        this.lgR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.majorsearch.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    a.this.lgR.setFocusable(true);
                    a.this.lgR.setFocusableInTouchMode(true);
                    if (a.this.ioT.hasFocus()) {
                        l.hideSoftKeyPad(a.this.lgQ, a.this.ioT);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.gZe = (ImageView) this.mRootView.findViewById(R.id.search_icon);
        this.ioT = (EditText) this.mRootView.findViewById(R.id.search_box);
        this.lgS = (ImageView) this.mRootView.findViewById(R.id.search_del);
        this.lgS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.majorsearch.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.ioT.setText("");
            }
        });
        pi(false);
        this.ioT.setText("");
        this.ioT.requestFocus();
    }

    private void dgD() {
        this.lgW = (LinearLayout) this.mRootView.findViewById(R.id.layout_container);
        this.lgT = (RecyclerView) this.mRootView.findViewById(R.id.rv_major_list);
        this.lgU = new LinearLayoutManager(this.lgQ);
        this.lgT.setLayoutManager(this.lgU);
        this.lgV = new SearchMajorResultItemAdapter(this.lgQ);
        this.lgT.setAdapter(this.lgV);
    }

    public void onResume() {
        if (!StringUtils.isNull(this.ioT.getText().toString())) {
            this.lgR.setFocusable(true);
            this.lgR.setFocusableInTouchMode(true);
            this.lgR.requestFocus();
        }
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.ioT.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.ioT.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.ioT.addTextChangedListener(textWatcher);
    }

    public void a(SearchMajorResultItemAdapter.a aVar) {
        this.lgV.b(aVar);
    }

    public void a(RecyclerView.OnScrollListener onScrollListener) {
        this.lgT.addOnScrollListener(onScrollListener);
    }

    public LinearLayout dgE() {
        return this.lgW;
    }

    public void pi(boolean z) {
        this.lgS.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        if (this.lgV != null) {
            this.lgV.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.lgQ.getPageContext(), i);
        this.ioT.setHintTextColor(ao.getColor(R.color.CAM_X0109));
        this.ioT.setTextColor(ao.getColor(R.color.CAM_X0105));
        SvgManager.bwr().a(this.gZe, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ao.setBackgroundResource(this.lgR, R.drawable.search_major_bg);
        SvgManager.bwr().a(this.lgS, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void q(List<String> list, String str) {
        this.lgT.setVisibility(0);
        if (this.lgV != null) {
            this.lgV.Oi(str);
            this.lgV.setData(list);
            this.lgT.setAdapter(this.lgV);
        }
    }

    public void c(ErrorData errorData) {
        this.lgT.setVisibility(8);
        if (this.lgV != null) {
            this.lgV.dgG();
        }
    }
}
