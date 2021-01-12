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
/* loaded from: classes7.dex */
public class a {
    private ImageView gUy;
    private EditText ikk;
    private SearchMajorActivity lcj;
    private RelativeLayout lck;
    private ImageView lcl;
    private RecyclerView lcm;
    private LinearLayoutManager lcn;
    private SearchMajorResultItemAdapter lco;
    private LinearLayout lcp;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(View view, SearchMajorActivity searchMajorActivity) {
        this.mRootView = view;
        this.lcj = searchMajorActivity;
        initView();
    }

    private void initView() {
        bEt();
        dcK();
        dcL();
    }

    private void bEt() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.lcj.getResources().getString(R.string.search_major));
    }

    private void dcK() {
        this.lck = (RelativeLayout) this.mRootView.findViewById(R.id.search_container);
        this.lck.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.majorsearch.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    a.this.lck.setFocusable(true);
                    a.this.lck.setFocusableInTouchMode(true);
                    if (a.this.ikk.hasFocus()) {
                        l.hideSoftKeyPad(a.this.lcj, a.this.ikk);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.gUy = (ImageView) this.mRootView.findViewById(R.id.search_icon);
        this.ikk = (EditText) this.mRootView.findViewById(R.id.search_box);
        this.lcl = (ImageView) this.mRootView.findViewById(R.id.search_del);
        this.lcl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.majorsearch.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.ikk.setText("");
            }
        });
        pe(false);
        this.ikk.setText("");
        this.ikk.requestFocus();
    }

    private void dcL() {
        this.lcp = (LinearLayout) this.mRootView.findViewById(R.id.layout_container);
        this.lcm = (RecyclerView) this.mRootView.findViewById(R.id.rv_major_list);
        this.lcn = new LinearLayoutManager(this.lcj);
        this.lcm.setLayoutManager(this.lcn);
        this.lco = new SearchMajorResultItemAdapter(this.lcj);
        this.lcm.setAdapter(this.lco);
    }

    public void onResume() {
        if (!StringUtils.isNull(this.ikk.getText().toString())) {
            this.lck.setFocusable(true);
            this.lck.setFocusableInTouchMode(true);
            this.lck.requestFocus();
        }
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.ikk.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void a(TextView.OnEditorActionListener onEditorActionListener) {
        this.ikk.setOnEditorActionListener(onEditorActionListener);
    }

    public void d(TextWatcher textWatcher) {
        this.ikk.addTextChangedListener(textWatcher);
    }

    public void a(SearchMajorResultItemAdapter.a aVar) {
        this.lco.b(aVar);
    }

    public void a(RecyclerView.OnScrollListener onScrollListener) {
        this.lcm.addOnScrollListener(onScrollListener);
    }

    public LinearLayout dcM() {
        return this.lcp;
    }

    public void pe(boolean z) {
        this.lcl.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        if (this.lco != null) {
            this.lco.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.lcj.getPageContext(), i);
        this.ikk.setHintTextColor(ao.getColor(R.color.CAM_X0109));
        this.ikk.setTextColor(ao.getColor(R.color.CAM_X0105));
        SvgManager.bsx().a(this.gUy, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ao.setBackgroundResource(this.lck, R.drawable.search_major_bg);
        SvgManager.bsx().a(this.lcl, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void q(List<String> list, String str) {
        this.lcm.setVisibility(0);
        if (this.lco != null) {
            this.lco.Na(str);
            this.lco.setData(list);
            this.lcm.setAdapter(this.lco);
        }
    }

    public void c(ErrorData errorData) {
        this.lcm.setVisibility(8);
        if (this.lco != null) {
            this.lco.dcO();
        }
    }
}
