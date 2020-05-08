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
    private PostSearchActivity kmC;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText gLg = null;
    private ImageView giw = null;
    private Runnable kmD = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.kmC = postSearchActivity;
        blD();
    }

    private void blD() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gLg.hasFocus()) {
                    l.hideSoftKeyPad(a.this.kmC.getPageContext().getPageActivity(), a.this.gLg);
                }
                a.this.kmC.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.gLg = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.giw = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.giw.setVisibility(8);
        this.gLg.requestFocus();
        this.gLg.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.kmC.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.cLA();
                a.this.cLz();
            }
        });
        this.gLg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cLA();
                a.this.cLz();
            }
        });
        this.gLg.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.kmC.rp(charSequence);
                        PostSearchActivity unused = a.this.kmC;
                        TiebaStatic.log(new an("c12842").cI("obj_name", charSequence).cI("obj_source", "1").cI("obj_type", "2").cI("fid", a.this.kmC.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.giw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gLg.setText("");
                a.this.cLA();
            }
        });
        this.gLg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.kmC.gWw = obj;
                if (obj.trim().length() == 0) {
                    a.this.cLA();
                    a.this.giw.setVisibility(8);
                    return;
                }
                a.this.giw.setVisibility(0);
            }
        });
        this.kmD = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.kmC.getPageContext().getPageActivity(), a.this.gLg);
            }
        };
        com.baidu.adp.lib.f.e.lb().postDelayed(this.kmD, 500L);
    }

    public void IX(String str) {
        this.gLg.setText(str);
    }

    public void bWF() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.kmC.getPageContext().getPageActivity(), this.gLg);
    }

    public void cLy() {
        this.giw.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLz() {
        if (!StringUtils.isNull(this.gLg.getText().toString())) {
            this.giw.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLA() {
        if (!this.kmC.cLC()) {
            this.kmC.cLB();
            if (!this.gLg.hasFocus()) {
                this.gLg.requestFocus();
                l.showSoftKeyPad(this.kmC.getPageContext().getPageActivity(), this.gLg);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.kmC.getPageContext(), i);
        com.baidu.tbadk.q.a.a(this.kmC.getPageContext(), this.mSearchView);
        SvgManager.aOR().a(this.giw, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.kmD != null) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kmD);
        }
    }
}
