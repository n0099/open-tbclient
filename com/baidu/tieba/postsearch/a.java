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
/* loaded from: classes6.dex */
public class a {
    private PostSearchActivity iCa;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText fhh = null;
    private ImageView eFi = null;
    private Runnable iCb = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.iCa = postSearchActivity;
        aJv();
    }

    private void aJv() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fhh.hasFocus()) {
                    l.hideSoftKeyPad(a.this.iCa.getPageContext().getPageActivity(), a.this.fhh);
                }
                a.this.iCa.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.fhh = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.eFi = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.eFi.setVisibility(8);
        this.fhh.requestFocus();
        this.fhh.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.iCa.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.cdY();
                a.this.cdX();
            }
        });
        this.fhh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cdY();
                a.this.cdX();
            }
        });
        this.fhh.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.iCa.kQ(charSequence);
                        PostSearchActivity unused = a.this.iCa;
                        TiebaStatic.log(new an("c12842").bS("obj_name", charSequence).bS("obj_source", "1").bS("obj_type", "2").bS("fid", a.this.iCa.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.eFi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.fhh.setText("");
                a.this.cdY();
            }
        });
        this.fhh.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.iCa.fsG = obj;
                if (obj.trim().length() == 0) {
                    a.this.cdY();
                    a.this.eFi.setVisibility(8);
                    return;
                }
                a.this.eFi.setVisibility(0);
            }
        });
        this.iCb = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.iCa.getPageContext().getPageActivity(), a.this.fhh);
            }
        };
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.iCb, 500L);
    }

    public void Cc(String str) {
        this.fhh.setText(str);
    }

    public void brE() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.iCa.getPageContext().getPageActivity(), this.fhh);
    }

    public void cdW() {
        this.eFi.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdX() {
        if (!StringUtils.isNull(this.fhh.getText().toString())) {
            this.eFi.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdY() {
        if (!this.iCa.cea()) {
            this.iCa.cdZ();
            if (!this.fhh.hasFocus()) {
                this.fhh.requestFocus();
                l.showSoftKeyPad(this.iCa.getPageContext().getPageActivity(), this.fhh);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.iCa.getPageContext(), i);
        com.baidu.tbadk.s.a.a(this.iCa.getPageContext(), this.mSearchView);
        SvgManager.amL().a(this.eFi, R.drawable.icon_pure_search_empty_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.iCb != null) {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iCb);
        }
    }
}
