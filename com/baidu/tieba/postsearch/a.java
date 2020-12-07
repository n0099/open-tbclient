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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class a {
    private PostSearchActivity mCz;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText iFy = null;
    private ImageView eZs = null;
    private Runnable mCA = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.mCz = postSearchActivity;
        bFP();
    }

    private void bFP() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iFy.hasFocus()) {
                    l.hideSoftKeyPad(a.this.mCz.getPageContext().getPageActivity(), a.this.iFy);
                }
                a.this.mCz.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.iFy = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.eZs = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.eZs.setVisibility(8);
        this.iFy.requestFocus();
        this.iFy.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.mCz.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.dDo();
                a.this.dDn();
            }
        });
        this.iFy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dDo();
                a.this.dDn();
            }
        });
        this.iFy.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.mCz.yJ(charSequence);
                        PostSearchActivity unused = a.this.mCz;
                        TiebaStatic.log(new ar("c12842").dY("obj_name", charSequence).dY("obj_source", "1").dY("obj_type", "2").dY("fid", a.this.mCz.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.eZs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.iFy.setText("");
                a.this.dDo();
            }
        });
        this.iFy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.mCz.iQJ = obj;
                if (obj.trim().length() == 0) {
                    a.this.dDo();
                    a.this.eZs.setVisibility(8);
                    return;
                }
                a.this.eZs.setVisibility(0);
            }
        });
        this.mCA = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.mCz.getPageContext().getPageActivity(), a.this.iFy);
            }
        };
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mCA, 500L);
    }

    public void Rw(String str) {
        this.iFy.setText(str);
    }

    public void cMg() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.mCz.getPageContext().getPageActivity(), this.iFy);
    }

    public void dDm() {
        this.eZs.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDn() {
        if (!StringUtils.isNull(this.iFy.getText().toString())) {
            this.eZs.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDo() {
        if (!this.mCz.dDq()) {
            this.mCz.dDp();
            if (!this.iFy.hasFocus()) {
                this.iFy.requestFocus();
                l.showSoftKeyPad(this.mCz.getPageContext().getPageActivity(), this.iFy);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mCz.getPageContext(), i);
        com.baidu.tbadk.r.a.a(this.mCz.getPageContext(), this.mSearchView);
        SvgManager.btW().a(this.eZs, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.mCA != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mCA);
        }
    }
}
