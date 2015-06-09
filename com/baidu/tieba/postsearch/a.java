package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class a {
    private EditText bBN = null;
    private TextView bBO = null;
    private PostSearchActivity bXN;
    private View bXO;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.bXN = postSearchActivity;
        MN();
    }

    private void MN() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        this.bXO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.r.post_search_navigation_view, (View.OnClickListener) null);
        this.bBN = (EditText) this.bXO.findViewById(com.baidu.tieba.q.search_text);
        this.bBO = (TextView) this.bXO.findViewById(com.baidu.tieba.q.search_del);
        this.bBO.setVisibility(8);
        this.bBN.setOnFocusChangeListener(new c(this));
        this.bBN.setOnClickListener(new d(this));
        this.bBN.setOnEditorActionListener(new e(this));
        this.bBO.setOnClickListener(new f(this));
        this.bBN.addTextChangedListener(new g(this));
    }

    public void iK(String str) {
        this.bBN.setText(str);
    }

    public void Vk() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void afR() {
        com.baidu.adp.lib.util.n.c(this.bXN.getPageContext().getPageActivity(), this.bBN);
    }

    public void afS() {
        this.bBO.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afT() {
        if (!StringUtils.isNull(this.bBN.getText().toString())) {
            this.bBO.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afU() {
        if (!this.bXN.afW()) {
            this.bXN.afV();
            if (!this.bBN.hasFocus()) {
                this.bBN.requestFocus();
                com.baidu.adp.lib.util.n.d(this.bXN.getPageContext().getPageActivity(), this.bBN);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bXN.getPageContext(), i);
        com.baidu.tbadk.f.a.a(this.bXN.getPageContext(), this.bXO);
    }
}
