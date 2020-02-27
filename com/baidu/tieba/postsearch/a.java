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
    private PostSearchActivity jAG;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText gaS = null;
    private ImageView fCP = null;
    private Runnable jAH = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.jAG = postSearchActivity;
        bcH();
    }

    private void bcH() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gaS.hasFocus()) {
                    l.hideSoftKeyPad(a.this.jAG.getPageContext().getPageActivity(), a.this.gaS);
                }
                a.this.jAG.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.gaS = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.fCP = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.fCP.setVisibility(8);
        this.gaS.requestFocus();
        this.gaS.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.jAG.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.cAv();
                a.this.cAu();
            }
        });
        this.gaS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cAv();
                a.this.cAu();
            }
        });
        this.gaS.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.jAG.qd(charSequence);
                        PostSearchActivity unused = a.this.jAG;
                        TiebaStatic.log(new an("c12842").cy("obj_name", charSequence).cy("obj_source", "1").cy("obj_type", "2").cy("fid", a.this.jAG.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.fCP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gaS.setText("");
                a.this.cAv();
            }
        });
        this.gaS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.jAG.gmn = obj;
                if (obj.trim().length() == 0) {
                    a.this.cAv();
                    a.this.fCP.setVisibility(8);
                    return;
                }
                a.this.fCP.setVisibility(0);
            }
        });
        this.jAH = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.jAG.getPageContext().getPageActivity(), a.this.gaS);
            }
        };
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jAH, 500L);
    }

    public void Hm(String str) {
        this.gaS.setText(str);
    }

    public void bLK() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.jAG.getPageContext().getPageActivity(), this.gaS);
    }

    public void cAt() {
        this.fCP.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAu() {
        if (!StringUtils.isNull(this.gaS.getText().toString())) {
            this.fCP.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAv() {
        if (!this.jAG.cAx()) {
            this.jAG.cAw();
            if (!this.gaS.hasFocus()) {
                this.gaS.requestFocus();
                l.showSoftKeyPad(this.jAG.getPageContext().getPageActivity(), this.gaS);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.jAG.getPageContext(), i);
        com.baidu.tbadk.q.a.a(this.jAG.getPageContext(), this.mSearchView);
        SvgManager.aGA().a(this.fCP, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.jAH != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jAH);
        }
    }
}
