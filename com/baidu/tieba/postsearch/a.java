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
    private PostSearchActivity kmy;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText gLa = null;
    private ImageView giq = null;
    private Runnable kmz = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.kmy = postSearchActivity;
        blF();
    }

    private void blF() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gLa.hasFocus()) {
                    l.hideSoftKeyPad(a.this.kmy.getPageContext().getPageActivity(), a.this.gLa);
                }
                a.this.kmy.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.gLa = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.giq = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.giq.setVisibility(8);
        this.gLa.requestFocus();
        this.gLa.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.kmy.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.cLD();
                a.this.cLC();
            }
        });
        this.gLa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cLD();
                a.this.cLC();
            }
        });
        this.gLa.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.kmy.rp(charSequence);
                        PostSearchActivity unused = a.this.kmy;
                        TiebaStatic.log(new an("c12842").cI("obj_name", charSequence).cI("obj_source", "1").cI("obj_type", "2").cI("fid", a.this.kmy.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.giq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gLa.setText("");
                a.this.cLD();
            }
        });
        this.gLa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.kmy.gWq = obj;
                if (obj.trim().length() == 0) {
                    a.this.cLD();
                    a.this.giq.setVisibility(8);
                    return;
                }
                a.this.giq.setVisibility(0);
            }
        });
        this.kmz = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.kmy.getPageContext().getPageActivity(), a.this.gLa);
            }
        };
        com.baidu.adp.lib.f.e.lb().postDelayed(this.kmz, 500L);
    }

    public void IU(String str) {
        this.gLa.setText(str);
    }

    public void bWH() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.kmy.getPageContext().getPageActivity(), this.gLa);
    }

    public void cLB() {
        this.giq.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLC() {
        if (!StringUtils.isNull(this.gLa.getText().toString())) {
            this.giq.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLD() {
        if (!this.kmy.cLF()) {
            this.kmy.cLE();
            if (!this.gLa.hasFocus()) {
                this.gLa.requestFocus();
                l.showSoftKeyPad(this.kmy.getPageContext().getPageActivity(), this.gLa);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.kmy.getPageContext(), i);
        com.baidu.tbadk.q.a.a(this.kmy.getPageContext(), this.mSearchView);
        SvgManager.aOU().a(this.giq, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.kmz != null) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kmz);
        }
    }
}
