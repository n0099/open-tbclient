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
/* loaded from: classes8.dex */
public class a {
    private PostSearchActivity mMr;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText iSM = null;
    private ImageView fgA = null;
    private Runnable mMs = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.mMr = postSearchActivity;
        bEL();
    }

    private void bEL() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iSM.hasFocus()) {
                    l.hideSoftKeyPad(a.this.mMr.getPageContext().getPageActivity(), a.this.iSM);
                }
                a.this.mMr.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.iSM = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.fgA = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.fgA.setVisibility(8);
        this.iSM.requestFocus();
        this.iSM.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.mMr.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.dBx();
                a.this.dBw();
            }
        });
        this.iSM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dBx();
                a.this.dBw();
            }
        });
        this.iSM.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.mMr.xQ(charSequence);
                        PostSearchActivity unused = a.this.mMr;
                        TiebaStatic.log(new ar("c12842").dR("obj_name", charSequence).dR("obj_source", "1").dR("obj_type", "2").dR("fid", a.this.mMr.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.fgA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.iSM.setText("");
                a.this.dBx();
            }
        });
        this.iSM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.mMr.jdX = obj;
                if (obj.trim().length() == 0) {
                    a.this.dBx();
                    a.this.fgA.setVisibility(8);
                    return;
                }
                a.this.fgA.setVisibility(0);
            }
        });
        this.mMs = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.mMr.getPageContext().getPageActivity(), a.this.iSM);
            }
        };
        com.baidu.adp.lib.f.e.mA().postDelayed(this.mMs, 500L);
    }

    public void QL(String str) {
        this.iSM.setText(str);
    }

    public void cNh() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.mMr.getPageContext().getPageActivity(), this.iSM);
    }

    public void dBv() {
        this.fgA.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBw() {
        if (!StringUtils.isNull(this.iSM.getText().toString())) {
            this.fgA.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBx() {
        if (!this.mMr.dBz()) {
            this.mMr.dBy();
            if (!this.iSM.hasFocus()) {
                this.iSM.requestFocus();
                l.showSoftKeyPad(this.mMr.getPageContext().getPageActivity(), this.iSM);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mMr.getPageContext(), i);
        com.baidu.tbadk.r.a.a(this.mMr.getPageContext(), this.mSearchView);
        SvgManager.bsR().a(this.fgA, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.mMs != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mMs);
        }
    }
}
