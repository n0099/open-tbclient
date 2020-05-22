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
    private PostSearchActivity kEx;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText gZS = null;
    private ImageView gxm = null;
    private Runnable kEy = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.kEx = postSearchActivity;
        brb();
    }

    private void brb() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gZS.hasFocus()) {
                    l.hideSoftKeyPad(a.this.kEx.getPageContext().getPageActivity(), a.this.gZS);
                }
                a.this.kEx.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.gZS = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.gxm = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.gxm.setVisibility(8);
        this.gZS.requestFocus();
        this.gZS.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.kEx.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.cSB();
                a.this.cSA();
            }
        });
        this.gZS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cSB();
                a.this.cSA();
            }
        });
        this.gZS.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.kEx.sT(charSequence);
                        PostSearchActivity unused = a.this.kEx;
                        TiebaStatic.log(new an("c12842").dh("obj_name", charSequence).dh("obj_source", "1").dh("obj_type", "2").dh("fid", a.this.kEx.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.gxm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gZS.setText("");
                a.this.cSB();
            }
        });
        this.gZS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.kEx.hli = obj;
                if (obj.trim().length() == 0) {
                    a.this.cSB();
                    a.this.gxm.setVisibility(8);
                    return;
                }
                a.this.gxm.setVisibility(0);
            }
        });
        this.kEy = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.kEx.getPageContext().getPageActivity(), a.this.gZS);
            }
        };
        com.baidu.adp.lib.f.e.ld().postDelayed(this.kEy, 500L);
    }

    public void KJ(String str) {
        this.gZS.setText(str);
    }

    public void cde() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.kEx.getPageContext().getPageActivity(), this.gZS);
    }

    public void cSz() {
        this.gxm.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSA() {
        if (!StringUtils.isNull(this.gZS.getText().toString())) {
            this.gxm.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSB() {
        if (!this.kEx.cSD()) {
            this.kEx.cSC();
            if (!this.gZS.hasFocus()) {
                this.gZS.requestFocus();
                l.showSoftKeyPad(this.kEx.getPageContext().getPageActivity(), this.gZS);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.kEx.getPageContext(), i);
        com.baidu.tbadk.q.a.a(this.kEx.getPageContext(), this.mSearchView);
        SvgManager.aUV().a(this.gxm, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.kEy != null) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kEy);
        }
    }
}
