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
/* loaded from: classes8.dex */
public class a {
    private PostSearchActivity mHS;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText iRM = null;
    private ImageView fiW = null;
    private Runnable mHT = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.mHS = postSearchActivity;
        bIk();
    }

    private void bIk() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iRM.hasFocus()) {
                    l.hideSoftKeyPad(a.this.mHS.getPageContext().getPageActivity(), a.this.iRM);
                }
                a.this.mHS.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.iRM = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.fiW = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.fiW.setVisibility(8);
        this.iRM.requestFocus();
        this.iRM.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.mHS.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.dDe();
                a.this.dDd();
            }
        });
        this.iRM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dDe();
                a.this.dDd();
            }
        });
        this.iRM.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.mHS.yI(charSequence);
                        PostSearchActivity unused = a.this.mHS;
                        TiebaStatic.log(new aq("c12842").dX("obj_name", charSequence).dX("obj_source", "1").dX("obj_type", "2").dX("fid", a.this.mHS.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.fiW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.iRM.setText("");
                a.this.dDe();
            }
        });
        this.iRM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.mHS.jcX = obj;
                if (obj.trim().length() == 0) {
                    a.this.dDe();
                    a.this.fiW.setVisibility(8);
                    return;
                }
                a.this.fiW.setVisibility(0);
            }
        });
        this.mHT = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.mHS.getPageContext().getPageActivity(), a.this.iRM);
            }
        };
        com.baidu.adp.lib.f.e.mB().postDelayed(this.mHT, 500L);
    }

    public void Rc(String str) {
        this.iRM.setText(str);
    }

    public void cPk() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.mHS.getPageContext().getPageActivity(), this.iRM);
    }

    public void dDc() {
        this.fiW.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDd() {
        if (!StringUtils.isNull(this.iRM.getText().toString())) {
            this.fiW.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDe() {
        if (!this.mHS.dDg()) {
            this.mHS.dDf();
            if (!this.iRM.hasFocus()) {
                this.iRM.requestFocus();
                l.showSoftKeyPad(this.mHS.getPageContext().getPageActivity(), this.iRM);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mHS.getPageContext(), i);
        com.baidu.tbadk.r.a.a(this.mHS.getPageContext(), this.mSearchView);
        SvgManager.bwq().a(this.fiW, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.mHT != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mHT);
        }
    }
}
