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
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a {
    private PostSearchActivity iuE;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText eXW = null;
    private ImageView eqz = null;
    private Runnable iuF = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.iuE = postSearchActivity;
        aHO();
    }

    private void aHO() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eXW.hasFocus()) {
                    l.b(a.this.iuE.getPageContext().getPageActivity(), a.this.eXW);
                }
                a.this.iuE.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.eXW = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.eqz = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.eqz.setVisibility(8);
        this.eXW.requestFocus();
        this.eXW.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(a.this.iuE.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.cda();
                a.this.ccZ();
            }
        });
        this.eXW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cda();
                a.this.ccZ();
            }
        });
        this.eXW.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.iuE.kf(charSequence);
                        PostSearchActivity unused = a.this.iuE;
                        TiebaStatic.log(new am("c12842").bT("obj_name", charSequence).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").bT("obj_type", "2").bT("fid", a.this.iuE.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.eqz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eXW.setText("");
                a.this.cda();
            }
        });
        this.eXW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.iuE.fmY = obj;
                if (obj.trim().length() == 0) {
                    a.this.cda();
                    a.this.eqz.setVisibility(8);
                    return;
                }
                a.this.eqz.setVisibility(0);
            }
        });
        this.iuF = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.c(a.this.iuE.getPageContext().getPageActivity(), a.this.eXW);
            }
        };
        com.baidu.adp.lib.g.e.iB().postDelayed(this.iuF, 500L);
    }

    public void Cu(String str) {
        this.eXW.setText(str);
    }

    public void brx() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void ccX() {
        l.b(this.iuE.getPageContext().getPageActivity(), this.eXW);
    }

    public void ccY() {
        this.eqz.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccZ() {
        if (!StringUtils.isNull(this.eXW.getText().toString())) {
            this.eqz.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cda() {
        if (!this.iuE.cdc()) {
            this.iuE.cdb();
            if (!this.eXW.hasFocus()) {
                this.eXW.requestFocus();
                l.c(this.iuE.getPageContext().getPageActivity(), this.eXW);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.iuE.getPageContext(), i);
        com.baidu.tbadk.s.a.a(this.iuE.getPageContext(), this.mSearchView);
        al.a(this.eqz, (int) R.drawable.search_del_btn_s, (int) R.drawable.search_del_btn);
    }

    public void onDestroy() {
        if (this.iuF != null) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iuF);
        }
    }
}
