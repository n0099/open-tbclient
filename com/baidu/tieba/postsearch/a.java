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
    private PostSearchActivity iuI;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText eXX = null;
    private ImageView eqA = null;
    private Runnable iuJ = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.iuI = postSearchActivity;
        aHR();
    }

    private void aHR() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eXX.hasFocus()) {
                    l.b(a.this.iuI.getPageContext().getPageActivity(), a.this.eXX);
                }
                a.this.iuI.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.eXX = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.eqA = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.eqA.setVisibility(8);
        this.eXX.requestFocus();
        this.eXX.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(a.this.iuI.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.cde();
                a.this.cdd();
            }
        });
        this.eXX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cde();
                a.this.cdd();
            }
        });
        this.eXX.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.iuI.ke(charSequence);
                        PostSearchActivity unused = a.this.iuI;
                        TiebaStatic.log(new am("c12842").bT("obj_name", charSequence).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").bT("obj_type", "2").bT("fid", a.this.iuI.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.eqA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eXX.setText("");
                a.this.cde();
            }
        });
        this.eXX.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.iuI.fmZ = obj;
                if (obj.trim().length() == 0) {
                    a.this.cde();
                    a.this.eqA.setVisibility(8);
                    return;
                }
                a.this.eqA.setVisibility(0);
            }
        });
        this.iuJ = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.c(a.this.iuI.getPageContext().getPageActivity(), a.this.eXX);
            }
        };
        com.baidu.adp.lib.g.e.iB().postDelayed(this.iuJ, 500L);
    }

    public void Cw(String str) {
        this.eXX.setText(str);
    }

    public void brC() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void cdb() {
        l.b(this.iuI.getPageContext().getPageActivity(), this.eXX);
    }

    public void cdc() {
        this.eqA.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdd() {
        if (!StringUtils.isNull(this.eXX.getText().toString())) {
            this.eqA.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cde() {
        if (!this.iuI.cdg()) {
            this.iuI.cdf();
            if (!this.eXX.hasFocus()) {
                this.eXX.requestFocus();
                l.c(this.iuI.getPageContext().getPageActivity(), this.eXX);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.iuI.getPageContext(), i);
        com.baidu.tbadk.s.a.a(this.iuI.getPageContext(), this.mSearchView);
        al.a(this.eqA, (int) R.drawable.search_del_btn_s, (int) R.drawable.search_del_btn);
    }

    public void onDestroy() {
        if (this.iuJ != null) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iuJ);
        }
    }
}
