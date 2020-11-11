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
/* loaded from: classes24.dex */
public class a {
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private PostSearchActivity moa;
    private EditText itS = null;
    private ImageView hQY = null;
    private Runnable mob = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.moa = postSearchActivity;
        bCV();
    }

    private void bCV() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.itS.hasFocus()) {
                    l.hideSoftKeyPad(a.this.moa.getPageContext().getPageActivity(), a.this.itS);
                }
                a.this.moa.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.itS = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.hQY = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.hQY.setVisibility(8);
        this.itS.requestFocus();
        this.itS.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.moa.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.dyx();
                a.this.dyw();
            }
        });
        this.itS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dyx();
                a.this.dyw();
            }
        });
        this.itS.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.moa.yh(charSequence);
                        PostSearchActivity unused = a.this.moa;
                        TiebaStatic.log(new aq("c12842").dR("obj_name", charSequence).dR("obj_source", "1").dR("obj_type", "2").dR("fid", a.this.moa.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.hQY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.itS.setText("");
                a.this.dyx();
            }
        });
        this.itS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.moa.iFd = obj;
                if (obj.trim().length() == 0) {
                    a.this.dyx();
                    a.this.hQY.setVisibility(8);
                    return;
                }
                a.this.hQY.setVisibility(0);
            }
        });
        this.mob = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.moa.getPageContext().getPageActivity(), a.this.itS);
            }
        };
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mob, 500L);
    }

    public void QS(String str) {
        this.itS.setText(str);
    }

    public void cHm() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.moa.getPageContext().getPageActivity(), this.itS);
    }

    public void dyv() {
        this.hQY.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyw() {
        if (!StringUtils.isNull(this.itS.getText().toString())) {
            this.hQY.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyx() {
        if (!this.moa.dyz()) {
            this.moa.dyy();
            if (!this.itS.hasFocus()) {
                this.itS.requestFocus();
                l.showSoftKeyPad(this.moa.getPageContext().getPageActivity(), this.itS);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.moa.getPageContext(), i);
        com.baidu.tbadk.r.a.a(this.moa.getPageContext(), this.mSearchView);
        SvgManager.brn().a(this.hQY, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.mob != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mob);
        }
    }
}
