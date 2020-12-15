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
    private PostSearchActivity mCB;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText iFA = null;
    private ImageView eZs = null;
    private Runnable mCC = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.mCB = postSearchActivity;
        bFP();
    }

    private void bFP() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iFA.hasFocus()) {
                    l.hideSoftKeyPad(a.this.mCB.getPageContext().getPageActivity(), a.this.iFA);
                }
                a.this.mCB.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.iFA = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.eZs = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.eZs.setVisibility(8);
        this.iFA.requestFocus();
        this.iFA.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.mCB.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.dDp();
                a.this.dDo();
            }
        });
        this.iFA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dDp();
                a.this.dDo();
            }
        });
        this.iFA.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.mCB.yJ(charSequence);
                        PostSearchActivity unused = a.this.mCB;
                        TiebaStatic.log(new ar("c12842").dY("obj_name", charSequence).dY("obj_source", "1").dY("obj_type", "2").dY("fid", a.this.mCB.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.eZs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.iFA.setText("");
                a.this.dDp();
            }
        });
        this.iFA.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.mCB.iQL = obj;
                if (obj.trim().length() == 0) {
                    a.this.dDp();
                    a.this.eZs.setVisibility(8);
                    return;
                }
                a.this.eZs.setVisibility(0);
            }
        });
        this.mCC = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.mCB.getPageContext().getPageActivity(), a.this.iFA);
            }
        };
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mCC, 500L);
    }

    public void Rw(String str) {
        this.iFA.setText(str);
    }

    public void cMh() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.mCB.getPageContext().getPageActivity(), this.iFA);
    }

    public void dDn() {
        this.eZs.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDo() {
        if (!StringUtils.isNull(this.iFA.getText().toString())) {
            this.eZs.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDp() {
        if (!this.mCB.dDr()) {
            this.mCB.dDq();
            if (!this.iFA.hasFocus()) {
                this.iFA.requestFocus();
                l.showSoftKeyPad(this.mCB.getPageContext().getPageActivity(), this.iFA);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mCB.getPageContext(), i);
        com.baidu.tbadk.r.a.a(this.mCB.getPageContext(), this.mSearchView);
        SvgManager.btW().a(this.eZs, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.mCC != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mCC);
        }
    }
}
