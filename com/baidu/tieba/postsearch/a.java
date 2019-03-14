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
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class a {
    private PostSearchActivity icn;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText eIa = null;
    private ImageView eXr = null;
    private Runnable ico = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.icn = postSearchActivity;
        aBB();
    }

    private void aBB() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eIa.hasFocus()) {
                    l.b(a.this.icn.getPageContext().getPageActivity(), a.this.eIa);
                }
                a.this.icn.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.post_search_navigation_view, (View.OnClickListener) null);
        this.eIa = (EditText) this.mSearchView.findViewById(d.g.search_text);
        this.eXr = (ImageView) this.mSearchView.findViewById(d.g.search_del);
        this.eXr.setVisibility(8);
        this.eIa.requestFocus();
        this.eIa.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(a.this.icn.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.bVd();
                a.this.bVc();
            }
        });
        this.eIa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bVd();
                a.this.bVc();
            }
        });
        this.eIa.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.icn.jf(charSequence);
                        PostSearchActivity unused = a.this.icn;
                        TiebaStatic.log(new am("c12842").bJ("obj_name", charSequence).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").bJ("obj_type", "2").bJ(ImageViewerConfig.FORUM_ID, a.this.icn.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.eXr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eIa.setText("");
                a.this.bVd();
            }
        });
        this.eIa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.icn.eXh = obj;
                if (obj.trim().length() == 0) {
                    a.this.bVd();
                    a.this.eXr.setVisibility(8);
                    return;
                }
                a.this.eXr.setVisibility(0);
            }
        });
        this.ico = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.c(a.this.icn.getPageContext().getPageActivity(), a.this.eIa);
            }
        };
        com.baidu.adp.lib.g.e.jH().postDelayed(this.ico, 500L);
    }

    public void Bd(String str) {
        this.eIa.setText(str);
    }

    public void bkh() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void bVa() {
        l.b(this.icn.getPageContext().getPageActivity(), this.eIa);
    }

    public void bVb() {
        this.eXr.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVc() {
        if (!StringUtils.isNull(this.eIa.getText().toString())) {
            this.eXr.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVd() {
        if (!this.icn.bVf()) {
            this.icn.bVe();
            if (!this.eIa.hasFocus()) {
                this.eIa.requestFocus();
                l.c(this.icn.getPageContext().getPageActivity(), this.eIa);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.icn.getPageContext(), i);
        com.baidu.tbadk.r.a.a(this.icn.getPageContext(), this.mSearchView);
        al.a(this.eXr, d.f.search_del_btn_s, d.f.search_del_btn);
    }

    public void onDestroy() {
        if (this.ico != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.ico);
        }
    }
}
