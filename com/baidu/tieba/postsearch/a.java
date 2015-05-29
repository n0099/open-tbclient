package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class a {
    private EditText bBM = null;
    private TextView bBN = null;
    private PostSearchActivity bXM;
    private View bXN;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.bXM = postSearchActivity;
        MM();
    }

    private void MM() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        this.bXN = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.r.post_search_navigation_view, (View.OnClickListener) null);
        this.bBM = (EditText) this.bXN.findViewById(com.baidu.tieba.q.search_text);
        this.bBN = (TextView) this.bXN.findViewById(com.baidu.tieba.q.search_del);
        this.bBN.setVisibility(8);
        this.bBM.setOnFocusChangeListener(new c(this));
        this.bBM.setOnClickListener(new d(this));
        this.bBM.setOnEditorActionListener(new e(this));
        this.bBN.setOnClickListener(new f(this));
        this.bBM.addTextChangedListener(new g(this));
    }

    public void iK(String str) {
        this.bBM.setText(str);
    }

    public void Vj() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void afQ() {
        com.baidu.adp.lib.util.n.c(this.bXM.getPageContext().getPageActivity(), this.bBM);
    }

    public void afR() {
        this.bBN.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afS() {
        if (!StringUtils.isNull(this.bBM.getText().toString())) {
            this.bBN.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afT() {
        if (!this.bXM.afV()) {
            this.bXM.afU();
            if (!this.bBM.hasFocus()) {
                this.bBM.requestFocus();
                com.baidu.adp.lib.util.n.d(this.bXM.getPageContext().getPageActivity(), this.bBM);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bXM.getPageContext(), i);
        com.baidu.tbadk.f.a.a(this.bXM.getPageContext(), this.bXN);
    }
}
