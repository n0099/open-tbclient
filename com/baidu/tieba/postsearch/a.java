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
    private PostSearchActivity kFF;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText had = null;
    private ImageView gxx = null;
    private Runnable kFG = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.kFF = postSearchActivity;
        brd();
    }

    private void brd() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.had.hasFocus()) {
                    l.hideSoftKeyPad(a.this.kFF.getPageContext().getPageActivity(), a.this.had);
                }
                a.this.kFF.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.had = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.gxx = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.gxx.setVisibility(8);
        this.had.requestFocus();
        this.had.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.kFF.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.cSR();
                a.this.cSQ();
            }
        });
        this.had.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cSR();
                a.this.cSQ();
            }
        });
        this.had.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.kFF.sT(charSequence);
                        PostSearchActivity unused = a.this.kFF;
                        TiebaStatic.log(new an("c12842").dh("obj_name", charSequence).dh("obj_source", "1").dh("obj_type", "2").dh("fid", a.this.kFF.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.gxx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.had.setText("");
                a.this.cSR();
            }
        });
        this.had.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.kFF.hlt = obj;
                if (obj.trim().length() == 0) {
                    a.this.cSR();
                    a.this.gxx.setVisibility(8);
                    return;
                }
                a.this.gxx.setVisibility(0);
            }
        });
        this.kFG = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.kFF.getPageContext().getPageActivity(), a.this.had);
            }
        };
        com.baidu.adp.lib.f.e.ld().postDelayed(this.kFG, 500L);
    }

    public void KK(String str) {
        this.had.setText(str);
    }

    public void cdm() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.kFF.getPageContext().getPageActivity(), this.had);
    }

    public void cSP() {
        this.gxx.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSQ() {
        if (!StringUtils.isNull(this.had.getText().toString())) {
            this.gxx.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSR() {
        if (!this.kFF.cST()) {
            this.kFF.cSS();
            if (!this.had.hasFocus()) {
                this.had.requestFocus();
                l.showSoftKeyPad(this.kFF.getPageContext().getPageActivity(), this.had);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.kFF.getPageContext(), i);
        com.baidu.tbadk.q.a.a(this.kFF.getPageContext(), this.mSearchView);
        SvgManager.aUW().a(this.gxx, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.kFG != null) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kFG);
        }
    }
}
