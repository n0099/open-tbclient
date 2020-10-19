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
    private PostSearchActivity lVD;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText ibt = null;
    private ImageView hyF = null;
    private Runnable lVE = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.lVD = postSearchActivity;
        byD();
    }

    private void byD() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ibt.hasFocus()) {
                    l.hideSoftKeyPad(a.this.lVD.getPageContext().getPageActivity(), a.this.ibt);
                }
                a.this.lVD.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.ibt = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.hyF = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.hyF.setVisibility(8);
        this.ibt.requestFocus();
        this.ibt.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.lVD.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.dsO();
                a.this.dsN();
            }
        });
        this.ibt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dsO();
                a.this.dsN();
            }
        });
        this.ibt.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.lVD.xA(charSequence);
                        PostSearchActivity unused = a.this.lVD;
                        TiebaStatic.log(new aq("c12842").dK("obj_name", charSequence).dK("obj_source", "1").dK("obj_type", "2").dK("fid", a.this.lVD.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.hyF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.ibt.setText("");
                a.this.dsO();
            }
        });
        this.ibt.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.lVD.imJ = obj;
                if (obj.trim().length() == 0) {
                    a.this.dsO();
                    a.this.hyF.setVisibility(8);
                    return;
                }
                a.this.hyF.setVisibility(0);
            }
        });
        this.lVE = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.lVD.getPageContext().getPageActivity(), a.this.ibt);
            }
        };
        com.baidu.adp.lib.f.e.mY().postDelayed(this.lVE, 500L);
    }

    public void Qd(String str) {
        this.ibt.setText(str);
    }

    public void cBE() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.lVD.getPageContext().getPageActivity(), this.ibt);
    }

    public void dsM() {
        this.hyF.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsN() {
        if (!StringUtils.isNull(this.ibt.getText().toString())) {
            this.hyF.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsO() {
        if (!this.lVD.dsQ()) {
            this.lVD.dsP();
            if (!this.ibt.hasFocus()) {
                this.ibt.requestFocus();
                l.showSoftKeyPad(this.lVD.getPageContext().getPageActivity(), this.ibt);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.lVD.getPageContext(), i);
        com.baidu.tbadk.r.a.a(this.lVD.getPageContext(), this.mSearchView);
        SvgManager.bmU().a(this.hyF, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.lVE != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lVE);
        }
    }
}
