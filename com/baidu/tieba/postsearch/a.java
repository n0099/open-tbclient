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
/* loaded from: classes7.dex */
public class a {
    private PostSearchActivity mDk;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText iNf = null;
    private ImageView fel = null;
    private Runnable mDl = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.mDk = postSearchActivity;
        bEt();
    }

    private void bEt() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iNf.hasFocus()) {
                    l.hideSoftKeyPad(a.this.mDk.getPageContext().getPageActivity(), a.this.iNf);
                }
                a.this.mDk.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.iNf = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.fel = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.fel.setVisibility(8);
        this.iNf.requestFocus();
        this.iNf.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.mDk.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.dzn();
                a.this.dzm();
            }
        });
        this.iNf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dzn();
                a.this.dzm();
            }
        });
        this.iNf.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.mDk.xx(charSequence);
                        PostSearchActivity unused = a.this.mDk;
                        TiebaStatic.log(new aq("c12842").dW("obj_name", charSequence).dW("obj_source", "1").dW("obj_type", "2").dW("fid", a.this.mDk.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.fel.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.iNf.setText("");
                a.this.dzn();
            }
        });
        this.iNf.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.mDk.iYq = obj;
                if (obj.trim().length() == 0) {
                    a.this.dzn();
                    a.this.fel.setVisibility(8);
                    return;
                }
                a.this.fel.setVisibility(0);
            }
        });
        this.mDl = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.mDk.getPageContext().getPageActivity(), a.this.iNf);
            }
        };
        com.baidu.adp.lib.f.e.mB().postDelayed(this.mDl, 500L);
    }

    public void PT(String str) {
        this.iNf.setText(str);
    }

    public void cLt() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.mDk.getPageContext().getPageActivity(), this.iNf);
    }

    public void dzl() {
        this.fel.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzm() {
        if (!StringUtils.isNull(this.iNf.getText().toString())) {
            this.fel.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzn() {
        if (!this.mDk.dzp()) {
            this.mDk.dzo();
            if (!this.iNf.hasFocus()) {
                this.iNf.requestFocus();
                l.showSoftKeyPad(this.mDk.getPageContext().getPageActivity(), this.iNf);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mDk.getPageContext(), i);
        com.baidu.tbadk.r.a.a(this.mDk.getPageContext(), this.mSearchView);
        SvgManager.bsx().a(this.fel, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.mDl != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mDl);
        }
    }
}
