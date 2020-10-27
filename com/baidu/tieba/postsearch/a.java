package com.baidu.tieba.postsearch;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class a {
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private PostSearchActivity mic;
    private EditText inV = null;
    private ImageView hLb = null;
    private Runnable mie = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.mic = postSearchActivity;
        bAw();
    }

    private void bAw() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.inV.hasFocus()) {
                    l.hideSoftKeyPad(a.this.mic.getPageContext().getPageActivity(), a.this.inV);
                }
                a.this.mic.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.inV = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.hLb = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.hLb.setVisibility(8);
        this.inV.requestFocus();
        this.inV.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.mic.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.dvV();
                a.this.dvU();
            }
        });
        this.inV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dvV();
                a.this.dvU();
            }
        });
        this.inV.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.mic.xT(charSequence);
                        PostSearchActivity unused = a.this.mic;
                        TiebaStatic.log(new aq("c12842").dR("obj_name", charSequence).dR("obj_source", "1").dR("obj_type", "2").dR("fid", a.this.mic.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.hLb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.inV.setText("");
                a.this.dvV();
            }
        });
        this.inV.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.mic.izg = obj;
                if (obj.trim().length() == 0) {
                    a.this.dvV();
                    a.this.hLb.setVisibility(8);
                    return;
                }
                a.this.hLb.setVisibility(0);
            }
        });
        this.mie = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.mic.getPageContext().getPageActivity(), a.this.inV);
            }
        };
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mie, 500L);
    }

    public void QB(String str) {
        this.inV.setText(str);
    }

    public void cEL() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.mic.getPageContext().getPageActivity(), this.inV);
    }

    public void dvT() {
        this.hLb.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvU() {
        if (!StringUtils.isNull(this.inV.getText().toString())) {
            this.hLb.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvV() {
        if (!this.mic.dvX()) {
            this.mic.dvW();
            if (!this.inV.hasFocus()) {
                this.inV.requestFocus();
                l.showSoftKeyPad(this.mic.getPageContext().getPageActivity(), this.inV);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mic.getPageContext(), i);
        com.baidu.tbadk.r.a.a(this.mic.getPageContext(), this.mSearchView);
        SvgManager.boN().a(this.hLb, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.mie != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mie);
        }
    }
}
