package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class a {
    private EditText bUA = null;
    private TextView bUB = null;
    private PostSearchActivity cDW;
    private View cDX;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.cDW = postSearchActivity;
        Ok();
    }

    private void Ok() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        this.cDX = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, i.g.post_search_navigation_view, (View.OnClickListener) null);
        this.bUA = (EditText) this.cDX.findViewById(i.f.search_text);
        this.bUB = (TextView) this.cDX.findViewById(i.f.search_del);
        this.bUB.setVisibility(8);
        this.bUA.setOnFocusChangeListener(new c(this));
        this.bUA.setOnClickListener(new d(this));
        this.bUA.setOnEditorActionListener(new e(this));
        this.bUB.setOnClickListener(new f(this));
        this.bUA.addTextChangedListener(new g(this));
    }

    public void kI(String str) {
        this.bUA.setText(str);
    }

    public void Od() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void aoe() {
        com.baidu.adp.lib.util.k.c(this.cDW.getPageContext().getPageActivity(), this.bUA);
    }

    public void aof() {
        this.bUB.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aog() {
        if (!StringUtils.isNull(this.bUA.getText().toString())) {
            this.bUB.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoh() {
        if (!this.cDW.aoj()) {
            this.cDW.aoi();
            if (!this.bUA.hasFocus()) {
                this.bUA.requestFocus();
                com.baidu.adp.lib.util.k.d(this.cDW.getPageContext().getPageActivity(), this.bUA);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cDW.getPageContext(), i);
        com.baidu.tbadk.h.a.a(this.cDW.getPageContext(), this.cDX);
    }
}
