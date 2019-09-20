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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a {
    private PostSearchActivity iEv;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText ffl = null;
    private ImageView exp = null;
    private Runnable iEw = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.iEv = postSearchActivity;
        aJX();
    }

    private void aJX() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ffl.hasFocus()) {
                    l.b(a.this.iEv.getPageContext().getPageActivity(), a.this.ffl);
                }
                a.this.iEv.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.ffl = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.exp = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.exp.setVisibility(8);
        this.ffl.requestFocus();
        this.ffl.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(a.this.iEv.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.chb();
                a.this.cha();
            }
        });
        this.ffl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.chb();
                a.this.cha();
            }
        });
        this.ffl.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.iEv.ko(charSequence);
                        PostSearchActivity unused = a.this.iEv;
                        TiebaStatic.log(new an("c12842").bT("obj_name", charSequence).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").bT("obj_type", "2").bT("fid", a.this.iEv.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.exp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.ffl.setText("");
                a.this.chb();
            }
        });
        this.ffl.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.iEv.fuk = obj;
                if (obj.trim().length() == 0) {
                    a.this.chb();
                    a.this.exp.setVisibility(8);
                    return;
                }
                a.this.exp.setVisibility(0);
            }
        });
        this.iEw = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.c(a.this.iEv.getPageContext().getPageActivity(), a.this.ffl);
            }
        };
        com.baidu.adp.lib.g.e.iK().postDelayed(this.iEw, 500L);
    }

    public void DJ(String str) {
        this.ffl.setText(str);
    }

    public void buE() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void cgY() {
        l.b(this.iEv.getPageContext().getPageActivity(), this.ffl);
    }

    public void cgZ() {
        this.exp.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cha() {
        if (!StringUtils.isNull(this.ffl.getText().toString())) {
            this.exp.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chb() {
        if (!this.iEv.chd()) {
            this.iEv.chc();
            if (!this.ffl.hasFocus()) {
                this.ffl.requestFocus();
                l.c(this.iEv.getPageContext().getPageActivity(), this.ffl);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.iEv.getPageContext(), i);
        com.baidu.tbadk.s.a.a(this.iEv.getPageContext(), this.mSearchView);
        SvgManager.ajv().a(this.exp, R.drawable.icon_pure_search_empty_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.iEw != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iEw);
        }
    }
}
