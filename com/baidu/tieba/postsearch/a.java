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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class a {
    private PostSearchActivity kZB;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText hmp = null;
    private ImageView gKl = null;
    private Runnable kZC = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.kZB = postSearchActivity;
        biq();
    }

    private void biq() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hmp.hasFocus()) {
                    l.hideSoftKeyPad(a.this.kZB.getPageContext().getPageActivity(), a.this.hmp);
                }
                a.this.kZB.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.hmp = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.gKl = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.gKl.setVisibility(8);
        this.hmp.requestFocus();
        this.hmp.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.kZB.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.cXi();
                a.this.cXh();
            }
        });
        this.hmp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cXi();
                a.this.cXh();
            }
        });
        this.hmp.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.kZB.tb(charSequence);
                        PostSearchActivity unused = a.this.kZB;
                        TiebaStatic.log(new ao("c12842").dk("obj_name", charSequence).dk("obj_source", "1").dk("obj_type", "2").dk("fid", a.this.kZB.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.gKl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hmp.setText("");
                a.this.cXi();
            }
        });
        this.hmp.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.kZB.hxA = obj;
                if (obj.trim().length() == 0) {
                    a.this.cXi();
                    a.this.gKl.setVisibility(8);
                    return;
                }
                a.this.gKl.setVisibility(0);
            }
        });
        this.kZC = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.kZB.getPageContext().getPageActivity(), a.this.hmp);
            }
        };
        com.baidu.adp.lib.f.e.lt().postDelayed(this.kZC, 500L);
    }

    public void Ll(String str) {
        this.hmp.setText(str);
    }

    public void cgK() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.kZB.getPageContext().getPageActivity(), this.hmp);
    }

    public void cXg() {
        this.gKl.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXh() {
        if (!StringUtils.isNull(this.hmp.getText().toString())) {
            this.gKl.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXi() {
        if (!this.kZB.cXk()) {
            this.kZB.cXj();
            if (!this.hmp.hasFocus()) {
                this.hmp.requestFocus();
                l.showSoftKeyPad(this.kZB.getPageContext().getPageActivity(), this.hmp);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.kZB.getPageContext(), i);
        com.baidu.tbadk.r.a.a(this.kZB.getPageContext(), this.mSearchView);
        SvgManager.aWQ().a(this.gKl, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.kZC != null) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kZC);
        }
    }
}
