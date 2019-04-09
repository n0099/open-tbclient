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
    private PostSearchActivity ica;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText eHN = null;
    private ImageView eXe = null;
    private Runnable icb = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.ica = postSearchActivity;
        aBy();
    }

    private void aBy() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eHN.hasFocus()) {
                    l.b(a.this.ica.getPageContext().getPageActivity(), a.this.eHN);
                }
                a.this.ica.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.post_search_navigation_view, (View.OnClickListener) null);
        this.eHN = (EditText) this.mSearchView.findViewById(d.g.search_text);
        this.eXe = (ImageView) this.mSearchView.findViewById(d.g.search_del);
        this.eXe.setVisibility(8);
        this.eHN.requestFocus();
        this.eHN.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(a.this.ica.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.bUZ();
                a.this.bUY();
            }
        });
        this.eHN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bUZ();
                a.this.bUY();
            }
        });
        this.eHN.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.ica.jg(charSequence);
                        PostSearchActivity unused = a.this.ica;
                        TiebaStatic.log(new am("c12842").bJ("obj_name", charSequence).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").bJ("obj_type", "2").bJ(ImageViewerConfig.FORUM_ID, a.this.ica.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.eXe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eHN.setText("");
                a.this.bUZ();
            }
        });
        this.eHN.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.ica.eWU = obj;
                if (obj.trim().length() == 0) {
                    a.this.bUZ();
                    a.this.eXe.setVisibility(8);
                    return;
                }
                a.this.eXe.setVisibility(0);
            }
        });
        this.icb = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.c(a.this.ica.getPageContext().getPageActivity(), a.this.eHN);
            }
        };
        com.baidu.adp.lib.g.e.jH().postDelayed(this.icb, 500L);
    }

    public void Bc(String str) {
        this.eHN.setText(str);
    }

    public void bkf() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void bUW() {
        l.b(this.ica.getPageContext().getPageActivity(), this.eHN);
    }

    public void bUX() {
        this.eXe.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUY() {
        if (!StringUtils.isNull(this.eHN.getText().toString())) {
            this.eXe.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUZ() {
        if (!this.ica.bVb()) {
            this.ica.bVa();
            if (!this.eHN.hasFocus()) {
                this.eHN.requestFocus();
                l.c(this.ica.getPageContext().getPageActivity(), this.eHN);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.ica.getPageContext(), i);
        com.baidu.tbadk.r.a.a(this.ica.getPageContext(), this.mSearchView);
        al.a(this.eXe, d.f.search_del_btn_s, d.f.search_del_btn);
    }

    public void onDestroy() {
        if (this.icb != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.icb);
        }
    }
}
