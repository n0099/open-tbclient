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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class a {
    private PostSearchActivity lxn;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText hFr = null;
    private ImageView hcH = null;
    private Runnable lxo = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.lxn = postSearchActivity;
        buO();
    }

    private void buO() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hFr.hasFocus()) {
                    l.hideSoftKeyPad(a.this.lxn.getPageContext().getPageActivity(), a.this.hFr);
                }
                a.this.lxn.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.hFr = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.hcH = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.hcH.setVisibility(8);
        this.hFr.requestFocus();
        this.hFr.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.lxn.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.dlt();
                a.this.dls();
            }
        });
        this.hFr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dlt();
                a.this.dls();
            }
        });
        this.hFr.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.lxn.wu(charSequence);
                        PostSearchActivity unused = a.this.lxn;
                        TiebaStatic.log(new aq("c12842").dD("obj_name", charSequence).dD("obj_source", "1").dD("obj_type", "2").dD("fid", a.this.lxn.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.hcH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hFr.setText("");
                a.this.dlt();
            }
        });
        this.hFr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.lxn.hQD = obj;
                if (obj.trim().length() == 0) {
                    a.this.dlt();
                    a.this.hcH.setVisibility(8);
                    return;
                }
                a.this.hcH.setVisibility(0);
            }
        });
        this.lxo = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.lxn.getPageContext().getPageActivity(), a.this.hFr);
            }
        };
        com.baidu.adp.lib.f.e.mS().postDelayed(this.lxo, 500L);
    }

    public void OM(String str) {
        this.hFr.setText(str);
    }

    public void cuN() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.lxn.getPageContext().getPageActivity(), this.hFr);
    }

    public void dlr() {
        this.hcH.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dls() {
        if (!StringUtils.isNull(this.hFr.getText().toString())) {
            this.hcH.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlt() {
        if (!this.lxn.dlv()) {
            this.lxn.dlu();
            if (!this.hFr.hasFocus()) {
                this.hFr.requestFocus();
                l.showSoftKeyPad(this.lxn.getPageContext().getPageActivity(), this.hFr);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.lxn.getPageContext(), i);
        com.baidu.tbadk.r.a.a(this.lxn.getPageContext(), this.mSearchView);
        SvgManager.bjq().a(this.hcH, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.lxo != null) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lxo);
        }
    }
}
