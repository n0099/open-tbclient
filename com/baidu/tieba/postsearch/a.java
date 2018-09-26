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
    private PostSearchActivity grb;
    private View grc;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private EditText dby = null;
    private ImageView dqM = null;
    private Runnable grd = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.grb = postSearchActivity;
        atZ();
    }

    private void atZ() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dby.hasFocus()) {
                    l.a(a.this.grb.getPageContext().getPageActivity(), a.this.dby);
                }
                a.this.grb.finish();
            }
        });
        this.grc = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, e.h.post_search_navigation_view, (View.OnClickListener) null);
        this.dby = (EditText) this.grc.findViewById(e.g.search_text);
        this.dqM = (ImageView) this.grc.findViewById(e.g.search_del);
        this.dqM.setVisibility(8);
        this.dby.requestFocus();
        this.dby.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(a.this.grb.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.boq();
                a.this.bop();
            }
        });
        this.dby.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.boq();
                a.this.bop();
            }
        });
        this.dby.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.grb.ta(charSequence);
                        PostSearchActivity unused = a.this.grb;
                        TiebaStatic.log(new am("c12842").al("obj_name", charSequence).al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").al("obj_type", "2").al(ImageViewerConfig.FORUM_ID, a.this.grb.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.dqM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dby.setText("");
                a.this.boq();
            }
        });
        this.dby.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.grb.dqC = obj;
                if (obj.trim().length() == 0) {
                    a.this.boq();
                    a.this.dqM.setVisibility(8);
                    return;
                }
                a.this.dqM.setVisibility(0);
            }
        });
        this.grd = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.b(a.this.grb.getPageContext().getPageActivity(), a.this.dby);
            }
        };
        com.baidu.adp.lib.g.e.jt().postDelayed(this.grd, 500L);
    }

    public void sZ(String str) {
        this.dby.setText(str);
    }

    public void aDw() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void bon() {
        l.a(this.grb.getPageContext().getPageActivity(), this.dby);
    }

    public void boo() {
        this.dqM.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bop() {
        if (!StringUtils.isNull(this.dby.getText().toString())) {
            this.dqM.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boq() {
        if (!this.grb.bos()) {
            this.grb.bor();
            if (!this.dby.hasFocus()) {
                this.dby.requestFocus();
                l.b(this.grb.getPageContext().getPageActivity(), this.dby);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.grb.getPageContext(), i);
        com.baidu.tbadk.o.a.a(this.grb.getPageContext(), this.grc);
        al.a(this.dqM, e.f.search_del_btn_s, e.f.search_del_btn);
    }

    public void onDestroy() {
        if (this.grd != null) {
            com.baidu.adp.lib.g.e.jt().removeCallbacks(this.grd);
        }
    }
}
