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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class a {
    private PostSearchActivity lgU;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText hsb = null;
    private ImageView gPR = null;
    private Runnable lgV = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.lgU = postSearchActivity;
        bmb();
    }

    private void bmb() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hsb.hasFocus()) {
                    l.hideSoftKeyPad(a.this.lgU.getPageContext().getPageActivity(), a.this.hsb);
                }
                a.this.lgU.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.hsb = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.gPR = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.gPR.setVisibility(8);
        this.hsb.requestFocus();
        this.hsb.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.lgU.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.dap();
                a.this.dao();
            }
        });
        this.hsb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dap();
                a.this.dao();
            }
        });
        this.hsb.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.lgU.ue(charSequence);
                        PostSearchActivity unused = a.this.lgU;
                        TiebaStatic.log(new ap("c12842").dn("obj_name", charSequence).dn("obj_source", "1").dn("obj_type", "2").dn("fid", a.this.lgU.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.gPR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hsb.setText("");
                a.this.dap();
            }
        });
        this.hsb.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.lgU.hDo = obj;
                if (obj.trim().length() == 0) {
                    a.this.dap();
                    a.this.gPR.setVisibility(8);
                    return;
                }
                a.this.gPR.setVisibility(0);
            }
        });
        this.lgV = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.lgU.getPageContext().getPageActivity(), a.this.hsb);
            }
        };
        com.baidu.adp.lib.f.e.lt().postDelayed(this.lgV, 500L);
    }

    public void LT(String str) {
        this.hsb.setText(str);
    }

    public void ckj() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.lgU.getPageContext().getPageActivity(), this.hsb);
    }

    public void dan() {
        this.gPR.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dao() {
        if (!StringUtils.isNull(this.hsb.getText().toString())) {
            this.gPR.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dap() {
        if (!this.lgU.dar()) {
            this.lgU.daq();
            if (!this.hsb.hasFocus()) {
                this.hsb.requestFocus();
                l.showSoftKeyPad(this.lgU.getPageContext().getPageActivity(), this.hsb);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.lgU.getPageContext(), i);
        com.baidu.tbadk.r.a.a(this.lgU.getPageContext(), this.mSearchView);
        SvgManager.baR().a(this.gPR, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.lgV != null) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.lgV);
        }
    }
}
