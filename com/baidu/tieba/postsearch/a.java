package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a {
    private PostSearchActivity dUY;
    private View dUZ;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private EditText cLO = null;
    private TextView cLP = null;
    private Runnable dVa = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.dUY = postSearchActivity;
        Ux();
    }

    private void Ux() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        this.dUZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, t.h.post_search_navigation_view, (View.OnClickListener) null);
        this.cLO = (EditText) this.dUZ.findViewById(t.g.search_text);
        this.cLP = (TextView) this.dUZ.findViewById(t.g.search_del);
        this.cLP.setVisibility(8);
        this.cLO.setOnFocusChangeListener(new c(this));
        this.cLO.setOnClickListener(new d(this));
        this.cLO.setOnEditorActionListener(new e(this));
        this.cLP.setOnClickListener(new f(this));
        this.cLO.addTextChangedListener(new g(this));
        this.dVa = new h(this);
        com.baidu.adp.lib.h.h.dL().postDelayed(this.dVa, 500L);
    }

    public void nj(String str) {
        this.cLO.setText(str);
    }

    public void Uo() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void aKB() {
        com.baidu.adp.lib.util.k.a(this.dUY.getPageContext().getPageActivity(), this.cLO);
    }

    public void aKC() {
        this.cLP.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKD() {
        if (!StringUtils.isNull(this.cLO.getText().toString())) {
            this.cLP.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKE() {
        if (!this.dUY.aKG()) {
            this.dUY.aKF();
            if (!this.cLO.hasFocus()) {
                this.cLO.requestFocus();
                com.baidu.adp.lib.util.k.b(this.dUY.getPageContext().getPageActivity(), this.cLO);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.dUY.getPageContext(), i);
        com.baidu.tbadk.i.a.a(this.dUY.getPageContext(), this.dUZ);
    }

    public void onDestroy() {
        if (this.dVa != null) {
            com.baidu.adp.lib.h.h.dL().removeCallbacks(this.dVa);
        }
    }
}
