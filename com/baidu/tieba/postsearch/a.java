package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a {
    private PostSearchActivity dSg;
    private View dSh;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private EditText cKS = null;
    private TextView cKT = null;
    private Runnable dSi = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.dSg = postSearchActivity;
        Ux();
    }

    private void Ux() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        this.dSh = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, t.h.post_search_navigation_view, (View.OnClickListener) null);
        this.cKS = (EditText) this.dSh.findViewById(t.g.search_text);
        this.cKT = (TextView) this.dSh.findViewById(t.g.search_del);
        this.cKT.setVisibility(8);
        this.cKS.setOnFocusChangeListener(new c(this));
        this.cKS.setOnClickListener(new d(this));
        this.cKS.setOnEditorActionListener(new e(this));
        this.cKT.setOnClickListener(new f(this));
        this.cKS.addTextChangedListener(new g(this));
        this.dSi = new h(this);
        com.baidu.adp.lib.h.h.hx().postDelayed(this.dSi, 500L);
    }

    public void nk(String str) {
        this.cKS.setText(str);
    }

    public void Uo() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void aKu() {
        com.baidu.adp.lib.util.k.c(this.dSg.getPageContext().getPageActivity(), this.cKS);
    }

    public void aKv() {
        this.cKT.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKw() {
        if (!StringUtils.isNull(this.cKS.getText().toString())) {
            this.cKT.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKx() {
        if (!this.dSg.aKz()) {
            this.dSg.aKy();
            if (!this.cKS.hasFocus()) {
                this.cKS.requestFocus();
                com.baidu.adp.lib.util.k.d(this.dSg.getPageContext().getPageActivity(), this.cKS);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.dSg.getPageContext(), i);
        com.baidu.tbadk.i.a.a(this.dSg.getPageContext(), this.dSh);
    }

    public void onDestroy() {
        if (this.dSi != null) {
            com.baidu.adp.lib.h.h.hx().removeCallbacks(this.dSi);
        }
    }
}
