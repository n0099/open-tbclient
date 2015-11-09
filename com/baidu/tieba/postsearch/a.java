package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class a {
    private EditText bVb = null;
    private TextView bVc = null;
    private PostSearchActivity cFs;
    private View cFt;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.cFs = postSearchActivity;
        OC();
    }

    private void OC() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        this.cFt = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, i.g.post_search_navigation_view, (View.OnClickListener) null);
        this.bVb = (EditText) this.cFt.findViewById(i.f.search_text);
        this.bVc = (TextView) this.cFt.findViewById(i.f.search_del);
        this.bVc.setVisibility(8);
        this.bVb.setOnFocusChangeListener(new c(this));
        this.bVb.setOnClickListener(new d(this));
        this.bVb.setOnEditorActionListener(new e(this));
        this.bVc.setOnClickListener(new f(this));
        this.bVb.addTextChangedListener(new g(this));
    }

    public void kM(String str) {
        this.bVb.setText(str);
    }

    public void Ov() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void aoG() {
        com.baidu.adp.lib.util.k.c(this.cFs.getPageContext().getPageActivity(), this.bVb);
    }

    public void aoH() {
        this.bVc.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoI() {
        if (!StringUtils.isNull(this.bVb.getText().toString())) {
            this.bVc.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoJ() {
        if (!this.cFs.aoL()) {
            this.cFs.aoK();
            if (!this.bVb.hasFocus()) {
                this.bVb.requestFocus();
                com.baidu.adp.lib.util.k.d(this.cFs.getPageContext().getPageActivity(), this.bVb);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cFs.getPageContext(), i);
        com.baidu.tbadk.h.a.a(this.cFs.getPageContext(), this.cFt);
    }
}
