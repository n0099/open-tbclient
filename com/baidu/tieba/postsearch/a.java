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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a {
    private PostSearchActivity iCd;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText fdy = null;
    private ImageView evF = null;
    private Runnable iCe = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.iCd = postSearchActivity;
        aJt();
    }

    private void aJt() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fdy.hasFocus()) {
                    l.b(a.this.iCd.getPageContext().getPageActivity(), a.this.fdy);
                }
                a.this.iCd.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.fdy = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.evF = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.evF.setVisibility(8);
        this.fdy.requestFocus();
        this.fdy.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(a.this.iCd.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.cgn();
                a.this.cgm();
            }
        });
        this.fdy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cgn();
                a.this.cgm();
            }
        });
        this.fdy.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.iCd.km(charSequence);
                        PostSearchActivity unused = a.this.iCd;
                        TiebaStatic.log(new an("c12842").bT("obj_name", charSequence).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").bT("obj_type", "2").bT("fid", a.this.iCd.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.evF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.fdy.setText("");
                a.this.cgn();
            }
        });
        this.fdy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.iCd.fsx = obj;
                if (obj.trim().length() == 0) {
                    a.this.cgn();
                    a.this.evF.setVisibility(8);
                    return;
                }
                a.this.evF.setVisibility(0);
            }
        });
        this.iCe = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.c(a.this.iCd.getPageContext().getPageActivity(), a.this.fdy);
            }
        };
        com.baidu.adp.lib.g.e.iK().postDelayed(this.iCe, 500L);
    }

    public void Dk(String str) {
        this.fdy.setText(str);
    }

    public void btQ() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void cgk() {
        l.b(this.iCd.getPageContext().getPageActivity(), this.fdy);
    }

    public void cgl() {
        this.evF.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgm() {
        if (!StringUtils.isNull(this.fdy.getText().toString())) {
            this.evF.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgn() {
        if (!this.iCd.cgp()) {
            this.iCd.cgo();
            if (!this.fdy.hasFocus()) {
                this.fdy.requestFocus();
                l.c(this.iCd.getPageContext().getPageActivity(), this.fdy);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.iCd.getPageContext(), i);
        com.baidu.tbadk.s.a.a(this.iCd.getPageContext(), this.mSearchView);
        am.a(this.evF, (int) R.drawable.search_del_btn_s, (int) R.drawable.search_del_btn);
    }

    public void onDestroy() {
        if (this.iCe != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iCe);
        }
    }
}
