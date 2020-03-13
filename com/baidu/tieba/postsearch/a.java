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
    private PostSearchActivity jAU;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText gbh = null;
    private ImageView fDe = null;
    private Runnable jAV = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.jAU = postSearchActivity;
        bcK();
    }

    private void bcK() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gbh.hasFocus()) {
                    l.hideSoftKeyPad(a.this.jAU.getPageContext().getPageActivity(), a.this.gbh);
                }
                a.this.jAU.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.gbh = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.fDe = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.fDe.setVisibility(8);
        this.gbh.requestFocus();
        this.gbh.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.jAU.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.cAy();
                a.this.cAx();
            }
        });
        this.gbh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cAy();
                a.this.cAx();
            }
        });
        this.gbh.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.jAU.qd(charSequence);
                        PostSearchActivity unused = a.this.jAU;
                        TiebaStatic.log(new an("c12842").cy("obj_name", charSequence).cy("obj_source", "1").cy("obj_type", "2").cy("fid", a.this.jAU.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.fDe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gbh.setText("");
                a.this.cAy();
            }
        });
        this.gbh.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.jAU.gmC = obj;
                if (obj.trim().length() == 0) {
                    a.this.cAy();
                    a.this.fDe.setVisibility(8);
                    return;
                }
                a.this.fDe.setVisibility(0);
            }
        });
        this.jAV = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.jAU.getPageContext().getPageActivity(), a.this.gbh);
            }
        };
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jAV, 500L);
    }

    public void Hn(String str) {
        this.gbh.setText(str);
    }

    public void bLN() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.jAU.getPageContext().getPageActivity(), this.gbh);
    }

    public void cAw() {
        this.fDe.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAx() {
        if (!StringUtils.isNull(this.gbh.getText().toString())) {
            this.fDe.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAy() {
        if (!this.jAU.cAA()) {
            this.jAU.cAz();
            if (!this.gbh.hasFocus()) {
                this.gbh.requestFocus();
                l.showSoftKeyPad(this.jAU.getPageContext().getPageActivity(), this.gbh);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.jAU.getPageContext(), i);
        com.baidu.tbadk.q.a.a(this.jAU.getPageContext(), this.mSearchView);
        SvgManager.aGC().a(this.fDe, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.jAV != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jAV);
        }
    }
}
