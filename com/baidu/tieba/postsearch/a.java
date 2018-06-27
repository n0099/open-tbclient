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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a {
    private PostSearchActivity gjj;
    private View gjk;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private EditText cSW = null;
    private ImageView dif = null;
    private Runnable gjl = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.gjj = postSearchActivity;
        arI();
    }

    private void arI() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cSW.hasFocus()) {
                    l.b(a.this.gjj.getPageContext().getPageActivity(), a.this.cSW);
                }
                a.this.gjj.finish();
            }
        });
        this.gjk = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.i.post_search_navigation_view, (View.OnClickListener) null);
        this.cSW = (EditText) this.gjk.findViewById(d.g.search_text);
        this.dif = (ImageView) this.gjk.findViewById(d.g.search_del);
        this.dif.setVisibility(8);
        this.cSW.requestFocus();
        this.cSW.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(a.this.gjj.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.bnu();
                a.this.bnt();
            }
        });
        this.cSW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bnu();
                a.this.bnt();
            }
        });
        this.cSW.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.gjj.sw(charSequence);
                        PostSearchActivity unused = a.this.gjj;
                        TiebaStatic.log(new an("c12842").ah("obj_name", charSequence).ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").ah("obj_type", "2").ah(ImageViewerConfig.FORUM_ID, a.this.gjj.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.dif.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cSW.setText("");
                a.this.bnu();
            }
        });
        this.cSW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.gjj.dhV = obj;
                if (obj.trim().length() == 0) {
                    a.this.bnu();
                    a.this.dif.setVisibility(8);
                    return;
                }
                a.this.dif.setVisibility(0);
            }
        });
        this.gjl = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.c(a.this.gjj.getPageContext().getPageActivity(), a.this.cSW);
            }
        };
        com.baidu.adp.lib.g.e.im().postDelayed(this.gjl, 500L);
    }

    public void sv(String str) {
        this.cSW.setText(str);
    }

    public void aAF() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void bnr() {
        l.b(this.gjj.getPageContext().getPageActivity(), this.cSW);
    }

    public void bns() {
        this.dif.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnt() {
        if (!StringUtils.isNull(this.cSW.getText().toString())) {
            this.dif.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnu() {
        if (!this.gjj.bnw()) {
            this.gjj.bnv();
            if (!this.cSW.hasFocus()) {
                this.cSW.requestFocus();
                l.c(this.gjj.getPageContext().getPageActivity(), this.cSW);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.gjj.getPageContext(), i);
        com.baidu.tbadk.n.a.a(this.gjj.getPageContext(), this.gjk);
        am.a(this.dif, d.f.search_del_btn_s, d.f.search_del_btn);
    }

    public void onDestroy() {
        if (this.gjl != null) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.gjl);
        }
    }
}
