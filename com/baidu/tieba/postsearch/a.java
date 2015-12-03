package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class a {
    private EditText cln = null;
    private TextView clo = null;
    private PostSearchActivity deb;
    private View dec;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.deb = postSearchActivity;
        Qh();
    }

    private void Qh() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        this.dec = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, n.g.post_search_navigation_view, (View.OnClickListener) null);
        this.cln = (EditText) this.dec.findViewById(n.f.search_text);
        this.clo = (TextView) this.dec.findViewById(n.f.search_del);
        this.clo.setVisibility(8);
        this.cln.setOnFocusChangeListener(new c(this));
        this.cln.setOnClickListener(new d(this));
        this.cln.setOnEditorActionListener(new e(this));
        this.clo.setOnClickListener(new f(this));
        this.cln.addTextChangedListener(new g(this));
    }

    public void lJ(String str) {
        this.cln.setText(str);
    }

    public void Qb() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void aus() {
        com.baidu.adp.lib.util.k.c(this.deb.getPageContext().getPageActivity(), this.cln);
    }

    public void aut() {
        this.clo.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auu() {
        if (!StringUtils.isNull(this.cln.getText().toString())) {
            this.clo.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auv() {
        if (!this.deb.aux()) {
            this.deb.auw();
            if (!this.cln.hasFocus()) {
                this.cln.requestFocus();
                com.baidu.adp.lib.util.k.d(this.deb.getPageContext().getPageActivity(), this.cln);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.deb.getPageContext(), i);
        com.baidu.tbadk.i.a.a(this.deb.getPageContext(), this.dec);
    }
}
