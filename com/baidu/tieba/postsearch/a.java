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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a {
    private PostSearchActivity jwj;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText fVJ = null;
    private ImageView fxg = null;
    private Runnable jwk = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.jwj = postSearchActivity;
        aZT();
    }

    private void aZT() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fVJ.hasFocus()) {
                    l.hideSoftKeyPad(a.this.jwj.getPageContext().getPageActivity(), a.this.fVJ);
                }
                a.this.jwj.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.fVJ = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.fxg = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.fxg.setVisibility(8);
        this.fVJ.requestFocus();
        this.fVJ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.jwj.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.cxR();
                a.this.cxQ();
            }
        });
        this.fVJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cxR();
                a.this.cxQ();
            }
        });
        this.fVJ.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.jwj.pL(charSequence);
                        PostSearchActivity unused = a.this.jwj;
                        TiebaStatic.log(new an("c12842").cp("obj_name", charSequence).cp("obj_source", "1").cp("obj_type", "2").cp("fid", a.this.jwj.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.fxg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.fVJ.setText("");
                a.this.cxR();
            }
        });
        this.fVJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.jwj.ghc = obj;
                if (obj.trim().length() == 0) {
                    a.this.cxR();
                    a.this.fxg.setVisibility(8);
                    return;
                }
                a.this.fxg.setVisibility(0);
            }
        });
        this.jwk = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.jwj.getPageContext().getPageActivity(), a.this.fVJ);
            }
        };
        com.baidu.adp.lib.f.e.gy().postDelayed(this.jwk, 500L);
    }

    public void GO(String str) {
        this.fVJ.setText(str);
    }

    public void bJg() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.jwj.getPageContext().getPageActivity(), this.fVJ);
    }

    public void cxP() {
        this.fxg.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxQ() {
        if (!StringUtils.isNull(this.fVJ.getText().toString())) {
            this.fxg.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxR() {
        if (!this.jwj.cxT()) {
            this.jwj.cxS();
            if (!this.fVJ.hasFocus()) {
                this.fVJ.requestFocus();
                l.showSoftKeyPad(this.jwj.getPageContext().getPageActivity(), this.fVJ);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.jwj.getPageContext(), i);
        com.baidu.tbadk.q.a.a(this.jwj.getPageContext(), this.mSearchView);
        SvgManager.aDW().a(this.fxg, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.jwk != null) {
            com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jwk);
        }
    }
}
