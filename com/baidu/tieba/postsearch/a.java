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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a {
    private PostSearchActivity gKP;
    private View gKQ;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private EditText duN = null;
    private ImageView dKb = null;
    private Runnable gKR = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.gKP = postSearchActivity;
        azR();
    }

    private void azR() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.duN.hasFocus()) {
                    l.b(a.this.gKP.getPageContext().getPageActivity(), a.this.duN);
                }
                a.this.gKP.finish();
            }
        });
        this.gKQ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, e.h.post_search_navigation_view, (View.OnClickListener) null);
        this.duN = (EditText) this.gKQ.findViewById(e.g.search_text);
        this.dKb = (ImageView) this.gKQ.findViewById(e.g.search_del);
        this.dKb.setVisibility(8);
        this.duN.requestFocus();
        this.duN.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(a.this.gKP.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.buo();
                a.this.bun();
            }
        });
        this.duN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.buo();
                a.this.bun();
            }
        });
        this.duN.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.gKP.startSearch(charSequence);
                        PostSearchActivity unused = a.this.gKP;
                        TiebaStatic.log(new am("c12842").aB("obj_name", charSequence).aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").aB("obj_type", "2").aB(ImageViewerConfig.FORUM_ID, a.this.gKP.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.dKb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.duN.setText("");
                a.this.buo();
            }
        });
        this.duN.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.gKP.dJR = obj;
                if (obj.trim().length() == 0) {
                    a.this.buo();
                    a.this.dKb.setVisibility(8);
                    return;
                }
                a.this.dKb.setVisibility(0);
            }
        });
        this.gKR = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.c(a.this.gKP.getPageContext().getPageActivity(), a.this.duN);
            }
        };
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gKR, 500L);
    }

    public void uz(String str) {
        this.duN.setText(str);
    }

    public void aJl() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void bul() {
        l.b(this.gKP.getPageContext().getPageActivity(), this.duN);
    }

    public void bum() {
        this.dKb.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bun() {
        if (!StringUtils.isNull(this.duN.getText().toString())) {
            this.dKb.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buo() {
        if (!this.gKP.buq()) {
            this.gKP.bup();
            if (!this.duN.hasFocus()) {
                this.duN.requestFocus();
                l.c(this.gKP.getPageContext().getPageActivity(), this.duN);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.gKP.getPageContext(), i);
        com.baidu.tbadk.o.a.a(this.gKP.getPageContext(), this.gKQ);
        al.a(this.dKb, e.f.search_del_btn_s, e.f.search_del_btn);
    }

    public void onDestroy() {
        if (this.gKR != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gKR);
        }
    }
}
