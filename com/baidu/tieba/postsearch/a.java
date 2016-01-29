package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a {
    private PostSearchActivity dxA;
    private View dxB;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private EditText cvX = null;
    private TextView cvY = null;
    private Runnable dxC = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.dxA = postSearchActivity;
        SG();
    }

    private void SG() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        this.dxB = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, t.h.post_search_navigation_view, (View.OnClickListener) null);
        this.cvX = (EditText) this.dxB.findViewById(t.g.search_text);
        this.cvY = (TextView) this.dxB.findViewById(t.g.search_del);
        this.cvY.setVisibility(8);
        this.cvX.setOnFocusChangeListener(new c(this));
        this.cvX.setOnClickListener(new d(this));
        this.cvX.setOnEditorActionListener(new e(this));
        this.cvY.setOnClickListener(new f(this));
        this.cvX.addTextChangedListener(new g(this));
        this.dxC = new h(this);
        com.baidu.adp.lib.h.h.hr().postDelayed(this.dxC, 500L);
    }

    public void lV(String str) {
        this.cvX.setText(str);
    }

    public void Sx() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void aCG() {
        com.baidu.adp.lib.util.k.c(this.dxA.getPageContext().getPageActivity(), this.cvX);
    }

    public void aCH() {
        this.cvY.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCI() {
        if (!StringUtils.isNull(this.cvX.getText().toString())) {
            this.cvY.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCJ() {
        if (!this.dxA.aCL()) {
            this.dxA.aCK();
            if (!this.cvX.hasFocus()) {
                this.cvX.requestFocus();
                com.baidu.adp.lib.util.k.d(this.dxA.getPageContext().getPageActivity(), this.cvX);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.dxA.getPageContext(), i);
        com.baidu.tbadk.i.a.a(this.dxA.getPageContext(), this.dxB);
    }

    public void onDestroy() {
        if (this.dxC != null) {
            com.baidu.adp.lib.h.h.hr().removeCallbacks(this.dxC);
        }
    }
}
