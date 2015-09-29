package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class a {
    private EditText bUp = null;
    private TextView bUq = null;
    private PostSearchActivity cDL;
    private View cDM;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.cDL = postSearchActivity;
        Ok();
    }

    private void Ok() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        this.cDM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, i.g.post_search_navigation_view, (View.OnClickListener) null);
        this.bUp = (EditText) this.cDM.findViewById(i.f.search_text);
        this.bUq = (TextView) this.cDM.findViewById(i.f.search_del);
        this.bUq.setVisibility(8);
        this.bUp.setOnFocusChangeListener(new c(this));
        this.bUp.setOnClickListener(new d(this));
        this.bUp.setOnEditorActionListener(new e(this));
        this.bUq.setOnClickListener(new f(this));
        this.bUp.addTextChangedListener(new g(this));
    }

    public void kI(String str) {
        this.bUp.setText(str);
    }

    public void Od() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void aoe() {
        com.baidu.adp.lib.util.k.c(this.cDL.getPageContext().getPageActivity(), this.bUp);
    }

    public void aof() {
        this.bUq.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aog() {
        if (!StringUtils.isNull(this.bUp.getText().toString())) {
            this.bUq.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoh() {
        if (!this.cDL.aoj()) {
            this.cDL.aoi();
            if (!this.bUp.hasFocus()) {
                this.bUp.requestFocus();
                com.baidu.adp.lib.util.k.d(this.cDL.getPageContext().getPageActivity(), this.bUp);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cDL.getPageContext(), i);
        com.baidu.tbadk.h.a.a(this.cDL.getPageContext(), this.cDM);
    }
}
