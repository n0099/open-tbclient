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
/* loaded from: classes11.dex */
public class a {
    private PostSearchActivity jCt;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText gbP = null;
    private ImageView fDM = null;
    private Runnable jCu = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.jCt = postSearchActivity;
        bcO();
    }

    private void bcO() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gbP.hasFocus()) {
                    l.hideSoftKeyPad(a.this.jCt.getPageContext().getPageActivity(), a.this.gbP);
                }
                a.this.jCt.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.gbP = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.fDM = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.fDM.setVisibility(8);
        this.gbP.requestFocus();
        this.gbP.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.jCt.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.cAS();
                a.this.cAR();
            }
        });
        this.gbP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cAS();
                a.this.cAR();
            }
        });
        this.gbP.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.jCt.qc(charSequence);
                        PostSearchActivity unused = a.this.jCt;
                        TiebaStatic.log(new an("c12842").cx("obj_name", charSequence).cx("obj_source", "1").cx("obj_type", "2").cx("fid", a.this.jCt.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.fDM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gbP.setText("");
                a.this.cAS();
            }
        });
        this.gbP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.jCt.gnk = obj;
                if (obj.trim().length() == 0) {
                    a.this.cAS();
                    a.this.fDM.setVisibility(8);
                    return;
                }
                a.this.fDM.setVisibility(0);
            }
        });
        this.jCu = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.jCt.getPageContext().getPageActivity(), a.this.gbP);
            }
        };
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jCu, 500L);
    }

    public void Hm(String str) {
        this.gbP.setText(str);
    }

    public void bMb() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.jCt.getPageContext().getPageActivity(), this.gbP);
    }

    public void cAQ() {
        this.fDM.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAR() {
        if (!StringUtils.isNull(this.gbP.getText().toString())) {
            this.fDM.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAS() {
        if (!this.jCt.cAU()) {
            this.jCt.cAT();
            if (!this.gbP.hasFocus()) {
                this.gbP.requestFocus();
                l.showSoftKeyPad(this.jCt.getPageContext().getPageActivity(), this.gbP);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.jCt.getPageContext(), i);
        com.baidu.tbadk.q.a.a(this.jCt.getPageContext(), this.mSearchView);
        SvgManager.aGG().a(this.fDM, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.jCu != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jCu);
        }
    }
}
