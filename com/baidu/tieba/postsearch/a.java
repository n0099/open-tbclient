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
    private PostSearchActivity lxy;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText hFx = null;
    private ImageView hcL = null;
    private Runnable lxz = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.lxy = postSearchActivity;
        buP();
    }

    private void buP() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hFx.hasFocus()) {
                    l.hideSoftKeyPad(a.this.lxy.getPageContext().getPageActivity(), a.this.hFx);
                }
                a.this.lxy.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.hFx = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.hcL = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.hcL.setVisibility(8);
        this.hFx.requestFocus();
        this.hFx.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.lxy.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.dlw();
                a.this.dlv();
            }
        });
        this.hFx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dlw();
                a.this.dlv();
            }
        });
        this.hFx.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.lxy.wv(charSequence);
                        PostSearchActivity unused = a.this.lxy;
                        TiebaStatic.log(new aq("c12842").dD("obj_name", charSequence).dD("obj_source", "1").dD("obj_type", "2").dD("fid", a.this.lxy.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.hcL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hFx.setText("");
                a.this.dlw();
            }
        });
        this.hFx.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.lxy.hQJ = obj;
                if (obj.trim().length() == 0) {
                    a.this.dlw();
                    a.this.hcL.setVisibility(8);
                    return;
                }
                a.this.hcL.setVisibility(0);
            }
        });
        this.lxz = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.lxy.getPageContext().getPageActivity(), a.this.hFx);
            }
        };
        com.baidu.adp.lib.f.e.mS().postDelayed(this.lxz, 500L);
    }

    public void ON(String str) {
        this.hFx.setText(str);
    }

    public void cuO() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.lxy.getPageContext().getPageActivity(), this.hFx);
    }

    public void dlu() {
        this.hcL.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlv() {
        if (!StringUtils.isNull(this.hFx.getText().toString())) {
            this.hcL.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlw() {
        if (!this.lxy.dly()) {
            this.lxy.dlx();
            if (!this.hFx.hasFocus()) {
                this.hFx.requestFocus();
                l.showSoftKeyPad(this.lxy.getPageContext().getPageActivity(), this.hFx);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.lxy.getPageContext(), i);
        com.baidu.tbadk.r.a.a(this.lxy.getPageContext(), this.mSearchView);
        SvgManager.bjq().a(this.hcL, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.lxz != null) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lxz);
        }
    }
}
