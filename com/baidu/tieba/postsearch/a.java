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
/* loaded from: classes9.dex */
public class a {
    private PostSearchActivity jzQ;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText fYS = null;
    private ImageView fAr = null;
    private Runnable jzR = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.jzQ = postSearchActivity;
        bas();
    }

    private void bas() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fYS.hasFocus()) {
                    l.hideSoftKeyPad(a.this.jzQ.getPageContext().getPageActivity(), a.this.fYS);
                }
                a.this.jzQ.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.fYS = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.fAr = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.fAr.setVisibility(8);
        this.fYS.requestFocus();
        this.fYS.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.jzQ.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.cza();
                a.this.cyZ();
            }
        });
        this.fYS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cza();
                a.this.cyZ();
            }
        });
        this.fYS.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.jzQ.pO(charSequence);
                        PostSearchActivity unused = a.this.jzQ;
                        TiebaStatic.log(new an("c12842").cp("obj_name", charSequence).cp("obj_source", "1").cp("obj_type", "2").cp("fid", a.this.jzQ.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.fAr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.fYS.setText("");
                a.this.cza();
            }
        });
        this.fYS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.jzQ.gkm = obj;
                if (obj.trim().length() == 0) {
                    a.this.cza();
                    a.this.fAr.setVisibility(8);
                    return;
                }
                a.this.fAr.setVisibility(0);
            }
        });
        this.jzR = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.jzQ.getPageContext().getPageActivity(), a.this.fYS);
            }
        };
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jzR, 500L);
    }

    public void GY(String str) {
        this.fYS.setText(str);
    }

    public void bKi() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.jzQ.getPageContext().getPageActivity(), this.fYS);
    }

    public void cyY() {
        this.fAr.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyZ() {
        if (!StringUtils.isNull(this.fYS.getText().toString())) {
            this.fAr.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cza() {
        if (!this.jzQ.czc()) {
            this.jzQ.czb();
            if (!this.fYS.hasFocus()) {
                this.fYS.requestFocus();
                l.showSoftKeyPad(this.jzQ.getPageContext().getPageActivity(), this.fYS);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.jzQ.getPageContext(), i);
        com.baidu.tbadk.q.a.a(this.jzQ.getPageContext(), this.mSearchView);
        SvgManager.aEp().a(this.fAr, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.jzR != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jzR);
        }
    }
}
