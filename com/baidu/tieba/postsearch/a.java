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
/* loaded from: classes23.dex */
public class a {
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private PostSearchActivity mov;
    private EditText iuG = null;
    private ImageView hRy = null;
    private Runnable mow = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.mov = postSearchActivity;
        bCo();
    }

    private void bCo() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iuG.hasFocus()) {
                    l.hideSoftKeyPad(a.this.mov.getPageContext().getPageActivity(), a.this.iuG);
                }
                a.this.mov.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.iuG = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.hRy = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.hRy.setVisibility(8);
        this.iuG.requestFocus();
        this.iuG.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.mov.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.dxX();
                a.this.dxW();
            }
        });
        this.iuG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dxX();
                a.this.dxW();
            }
        });
        this.iuG.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.mov.yc(charSequence);
                        PostSearchActivity unused = a.this.mov;
                        TiebaStatic.log(new ar("c12842").dR("obj_name", charSequence).dR("obj_source", "1").dR("obj_type", "2").dR("fid", a.this.mov.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.hRy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.iuG.setText("");
                a.this.dxX();
            }
        });
        this.iuG.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.mov.iFR = obj;
                if (obj.trim().length() == 0) {
                    a.this.dxX();
                    a.this.hRy.setVisibility(8);
                    return;
                }
                a.this.hRy.setVisibility(0);
            }
        });
        this.mow = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.mov.getPageContext().getPageActivity(), a.this.iuG);
            }
        };
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mow, 500L);
    }

    public void Qn(String str) {
        this.iuG.setText(str);
    }

    public void cGR() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.mov.getPageContext().getPageActivity(), this.iuG);
    }

    public void dxV() {
        this.hRy.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxW() {
        if (!StringUtils.isNull(this.iuG.getText().toString())) {
            this.hRy.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxX() {
        if (!this.mov.dxZ()) {
            this.mov.dxY();
            if (!this.iuG.hasFocus()) {
                this.iuG.requestFocus();
                l.showSoftKeyPad(this.mov.getPageContext().getPageActivity(), this.iuG);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mov.getPageContext(), i);
        com.baidu.tbadk.r.a.a(this.mov.getPageContext(), this.mSearchView);
        SvgManager.bqB().a(this.hRy, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.mow != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mow);
        }
    }
}
