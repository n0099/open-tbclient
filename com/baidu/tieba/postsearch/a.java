package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class a {
    private EditText bQb = null;
    private TextView bQc = null;
    private PostSearchActivity coG;
    private View coH;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.coG = postSearchActivity;
        Oi();
    }

    private void Oi() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        this.coH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, i.g.post_search_navigation_view, (View.OnClickListener) null);
        this.bQb = (EditText) this.coH.findViewById(i.f.search_text);
        this.bQc = (TextView) this.coH.findViewById(i.f.search_del);
        this.bQc.setVisibility(8);
        this.bQb.setOnFocusChangeListener(new c(this));
        this.bQb.setOnClickListener(new d(this));
        this.bQb.setOnEditorActionListener(new e(this));
        this.bQc.setOnClickListener(new f(this));
        this.bQb.addTextChangedListener(new g(this));
    }

    public void jE(String str) {
        this.bQb.setText(str);
    }

    public void WR() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void ahP() {
        com.baidu.adp.lib.util.k.c(this.coG.getPageContext().getPageActivity(), this.bQb);
    }

    public void ahQ() {
        this.bQc.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahR() {
        if (!StringUtils.isNull(this.bQb.getText().toString())) {
            this.bQc.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahS() {
        if (!this.coG.ahU()) {
            this.coG.ahT();
            if (!this.bQb.hasFocus()) {
                this.bQb.requestFocus();
                com.baidu.adp.lib.util.k.d(this.coG.getPageContext().getPageActivity(), this.bQb);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.coG.getPageContext(), i);
        com.baidu.tbadk.f.a.a(this.coG.getPageContext(), this.coH);
    }
}
