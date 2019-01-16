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
    private PostSearchActivity gKO;
    private View gKP;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private EditText duM = null;
    private ImageView dKa = null;
    private Runnable gKQ = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.gKO = postSearchActivity;
        azR();
    }

    private void azR() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.duM.hasFocus()) {
                    l.b(a.this.gKO.getPageContext().getPageActivity(), a.this.duM);
                }
                a.this.gKO.finish();
            }
        });
        this.gKP = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, e.h.post_search_navigation_view, (View.OnClickListener) null);
        this.duM = (EditText) this.gKP.findViewById(e.g.search_text);
        this.dKa = (ImageView) this.gKP.findViewById(e.g.search_del);
        this.dKa.setVisibility(8);
        this.duM.requestFocus();
        this.duM.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(a.this.gKO.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.buo();
                a.this.bun();
            }
        });
        this.duM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.buo();
                a.this.bun();
            }
        });
        this.duM.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.gKO.startSearch(charSequence);
                        PostSearchActivity unused = a.this.gKO;
                        TiebaStatic.log(new am("c12842").aB("obj_name", charSequence).aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").aB("obj_type", "2").aB(ImageViewerConfig.FORUM_ID, a.this.gKO.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.dKa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.duM.setText("");
                a.this.buo();
            }
        });
        this.duM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.gKO.dJQ = obj;
                if (obj.trim().length() == 0) {
                    a.this.buo();
                    a.this.dKa.setVisibility(8);
                    return;
                }
                a.this.dKa.setVisibility(0);
            }
        });
        this.gKQ = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.c(a.this.gKO.getPageContext().getPageActivity(), a.this.duM);
            }
        };
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gKQ, 500L);
    }

    public void uz(String str) {
        this.duM.setText(str);
    }

    public void aJl() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void bul() {
        l.b(this.gKO.getPageContext().getPageActivity(), this.duM);
    }

    public void bum() {
        this.dKa.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bun() {
        if (!StringUtils.isNull(this.duM.getText().toString())) {
            this.dKa.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buo() {
        if (!this.gKO.buq()) {
            this.gKO.bup();
            if (!this.duM.hasFocus()) {
                this.duM.requestFocus();
                l.c(this.gKO.getPageContext().getPageActivity(), this.duM);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.gKO.getPageContext(), i);
        com.baidu.tbadk.o.a.a(this.gKO.getPageContext(), this.gKP);
        al.a(this.dKa, e.f.search_del_btn_s, e.f.search_del_btn);
    }

    public void onDestroy() {
        if (this.gKQ != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gKQ);
        }
    }
}
