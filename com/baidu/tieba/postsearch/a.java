package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class a {
    private PostSearchActivity djG;
    private View djH;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private EditText cpr = null;
    private TextView cps = null;
    private Runnable djI = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.djG = postSearchActivity;
        Qz();
    }

    private void Qz() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        this.djH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, n.h.post_search_navigation_view, (View.OnClickListener) null);
        this.cpr = (EditText) this.djH.findViewById(n.g.search_text);
        this.cps = (TextView) this.djH.findViewById(n.g.search_del);
        this.cps.setVisibility(8);
        this.cpr.setOnFocusChangeListener(new c(this));
        this.cpr.setOnClickListener(new d(this));
        this.cpr.setOnEditorActionListener(new e(this));
        this.cps.setOnClickListener(new f(this));
        this.cpr.addTextChangedListener(new g(this));
        this.djI = new h(this);
        com.baidu.adp.lib.h.h.hj().postDelayed(this.djI, 500L);
    }

    public void lH(String str) {
        this.cpr.setText(str);
    }

    public void Qt() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void awl() {
        com.baidu.adp.lib.util.k.c(this.djG.getPageContext().getPageActivity(), this.cpr);
    }

    public void awm() {
        this.cps.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awn() {
        if (!StringUtils.isNull(this.cpr.getText().toString())) {
            this.cps.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awo() {
        if (!this.djG.awq()) {
            this.djG.awp();
            if (!this.cpr.hasFocus()) {
                this.cpr.requestFocus();
                com.baidu.adp.lib.util.k.d(this.djG.getPageContext().getPageActivity(), this.cpr);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.djG.getPageContext(), i);
        com.baidu.tbadk.i.a.a(this.djG.getPageContext(), this.djH);
    }

    public void onDestroy() {
        if (this.djI != null) {
            com.baidu.adp.lib.h.h.hj().removeCallbacks(this.djI);
        }
    }
}
