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
/* loaded from: classes7.dex */
public class a {
    private NavigationBar mNavigationBar;
    private PostSearchActivity mOI;
    private View mRootView;
    private View mSearchView;
    private EditText iUJ = null;
    private ImageView fhZ = null;
    private Runnable mOJ = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.mOI = postSearchActivity;
        bEP();
    }

    private void bEP() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iUJ.hasFocus()) {
                    l.hideSoftKeyPad(a.this.mOI.getPageContext().getPageActivity(), a.this.iUJ);
                }
                a.this.mOI.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.iUJ = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.fhZ = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.fhZ.setVisibility(8);
        this.iUJ.requestFocus();
        this.iUJ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.mOI.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.dBM();
                a.this.dBL();
            }
        });
        this.iUJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dBM();
                a.this.dBL();
            }
        });
        this.iUJ.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.mOI.xX(charSequence);
                        PostSearchActivity unused = a.this.mOI;
                        TiebaStatic.log(new ar("c12842").dR("obj_name", charSequence).dR("obj_source", "1").dR("obj_type", "2").dR("fid", a.this.mOI.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.fhZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.iUJ.setText("");
                a.this.dBM();
            }
        });
        this.iUJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.mOI.jfU = obj;
                if (obj.trim().length() == 0) {
                    a.this.dBM();
                    a.this.fhZ.setVisibility(8);
                    return;
                }
                a.this.fhZ.setVisibility(0);
            }
        });
        this.mOJ = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.mOI.getPageContext().getPageActivity(), a.this.iUJ);
            }
        };
        com.baidu.adp.lib.f.e.mA().postDelayed(this.mOJ, 500L);
    }

    public void QS(String str) {
        this.iUJ.setText(str);
    }

    public void cNu() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.mOI.getPageContext().getPageActivity(), this.iUJ);
    }

    public void dBK() {
        this.fhZ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBL() {
        if (!StringUtils.isNull(this.iUJ.getText().toString())) {
            this.fhZ.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBM() {
        if (!this.mOI.dBO()) {
            this.mOI.dBN();
            if (!this.iUJ.hasFocus()) {
                this.iUJ.requestFocus();
                l.showSoftKeyPad(this.mOI.getPageContext().getPageActivity(), this.iUJ);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mOI.getPageContext(), i);
        com.baidu.tbadk.r.a.a(this.mOI.getPageContext(), this.mSearchView);
        SvgManager.bsU().a(this.fhZ, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.mOJ != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mOJ);
        }
    }
}
