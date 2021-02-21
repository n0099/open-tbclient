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
    private PostSearchActivity mMG;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText iTa = null;
    private ImageView fgA = null;
    private Runnable mMH = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.mMG = postSearchActivity;
        bEL();
    }

    private void bEL() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iTa.hasFocus()) {
                    l.hideSoftKeyPad(a.this.mMG.getPageContext().getPageActivity(), a.this.iTa);
                }
                a.this.mMG.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.iTa = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.fgA = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.fgA.setVisibility(8);
        this.iTa.requestFocus();
        this.iTa.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.mMG.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.dBE();
                a.this.dBD();
            }
        });
        this.iTa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dBE();
                a.this.dBD();
            }
        });
        this.iTa.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.mMG.xQ(charSequence);
                        PostSearchActivity unused = a.this.mMG;
                        TiebaStatic.log(new ar("c12842").dR("obj_name", charSequence).dR("obj_source", "1").dR("obj_type", "2").dR("fid", a.this.mMG.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.fgA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.iTa.setText("");
                a.this.dBE();
            }
        });
        this.iTa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.mMG.jel = obj;
                if (obj.trim().length() == 0) {
                    a.this.dBE();
                    a.this.fgA.setVisibility(8);
                    return;
                }
                a.this.fgA.setVisibility(0);
            }
        });
        this.mMH = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.mMG.getPageContext().getPageActivity(), a.this.iTa);
            }
        };
        com.baidu.adp.lib.f.e.mA().postDelayed(this.mMH, 500L);
    }

    public void QM(String str) {
        this.iTa.setText(str);
    }

    public void cNo() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.mMG.getPageContext().getPageActivity(), this.iTa);
    }

    public void dBC() {
        this.fgA.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBD() {
        if (!StringUtils.isNull(this.iTa.getText().toString())) {
            this.fgA.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBE() {
        if (!this.mMG.dBG()) {
            this.mMG.dBF();
            if (!this.iTa.hasFocus()) {
                this.iTa.requestFocus();
                l.showSoftKeyPad(this.mMG.getPageContext().getPageActivity(), this.iTa);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mMG.getPageContext(), i);
        com.baidu.tbadk.r.a.a(this.mMG.getPageContext(), this.mSearchView);
        SvgManager.bsR().a(this.fgA, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.mMH != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mMH);
        }
    }
}
