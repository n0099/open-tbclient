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
    private PostSearchActivity iCR;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText fhY = null;
    private ImageView eFZ = null;
    private Runnable iCS = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.iCR = postSearchActivity;
        aJx();
    }

    private void aJx() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fhY.hasFocus()) {
                    l.hideSoftKeyPad(a.this.iCR.getPageContext().getPageActivity(), a.this.fhY);
                }
                a.this.iCR.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.fhY = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.eFZ = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.eFZ.setVisibility(8);
        this.fhY.requestFocus();
        this.fhY.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.iCR.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.cea();
                a.this.cdZ();
            }
        });
        this.fhY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cea();
                a.this.cdZ();
            }
        });
        this.fhY.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.iCR.kQ(charSequence);
                        PostSearchActivity unused = a.this.iCR;
                        TiebaStatic.log(new an("c12842").bS("obj_name", charSequence).bS("obj_source", "1").bS("obj_type", "2").bS("fid", a.this.iCR.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.eFZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.fhY.setText("");
                a.this.cea();
            }
        });
        this.fhY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.iCR.ftx = obj;
                if (obj.trim().length() == 0) {
                    a.this.cea();
                    a.this.eFZ.setVisibility(8);
                    return;
                }
                a.this.eFZ.setVisibility(0);
            }
        });
        this.iCS = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.iCR.getPageContext().getPageActivity(), a.this.fhY);
            }
        };
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.iCS, 500L);
    }

    public void Cc(String str) {
        this.fhY.setText(str);
    }

    public void brG() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.iCR.getPageContext().getPageActivity(), this.fhY);
    }

    public void cdY() {
        this.eFZ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdZ() {
        if (!StringUtils.isNull(this.fhY.getText().toString())) {
            this.eFZ.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cea() {
        if (!this.iCR.cec()) {
            this.iCR.ceb();
            if (!this.fhY.hasFocus()) {
                this.fhY.requestFocus();
                l.showSoftKeyPad(this.iCR.getPageContext().getPageActivity(), this.fhY);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.iCR.getPageContext(), i);
        com.baidu.tbadk.s.a.a(this.iCR.getPageContext(), this.mSearchView);
        SvgManager.amN().a(this.eFZ, R.drawable.icon_pure_search_empty_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.iCS != null) {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iCS);
        }
    }
}
