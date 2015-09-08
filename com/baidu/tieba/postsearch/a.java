package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class a {
    private EditText bQH = null;
    private TextView bQI = null;
    private PostSearchActivity cxd;
    private View cxe;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.cxd = postSearchActivity;
        Oj();
    }

    private void Oj() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        this.cxe = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, i.g.post_search_navigation_view, (View.OnClickListener) null);
        this.bQH = (EditText) this.cxe.findViewById(i.f.search_text);
        this.bQI = (TextView) this.cxe.findViewById(i.f.search_del);
        this.bQI.setVisibility(8);
        this.bQH.setOnFocusChangeListener(new c(this));
        this.bQH.setOnClickListener(new d(this));
        this.bQH.setOnEditorActionListener(new e(this));
        this.bQI.setOnClickListener(new f(this));
        this.bQH.addTextChangedListener(new g(this));
    }

    public void kj(String str) {
        this.bQH.setText(str);
    }

    public void WT() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void alU() {
        com.baidu.adp.lib.util.k.c(this.cxd.getPageContext().getPageActivity(), this.bQH);
    }

    public void alV() {
        this.bQI.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alW() {
        if (!StringUtils.isNull(this.bQH.getText().toString())) {
            this.bQI.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alX() {
        if (!this.cxd.alZ()) {
            this.cxd.alY();
            if (!this.bQH.hasFocus()) {
                this.bQH.requestFocus();
                com.baidu.adp.lib.util.k.d(this.cxd.getPageContext().getPageActivity(), this.bQH);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cxd.getPageContext(), i);
        com.baidu.tbadk.h.a.a(this.cxd.getPageContext(), this.cxe);
    }
}
