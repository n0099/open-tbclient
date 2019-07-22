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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a {
    private PostSearchActivity iAZ;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText fcY = null;
    private ImageView evy = null;
    private Runnable iBa = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.iAZ = postSearchActivity;
        aJr();
    }

    private void aJr() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fcY.hasFocus()) {
                    l.b(a.this.iAZ.getPageContext().getPageActivity(), a.this.fcY);
                }
                a.this.iAZ.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.fcY = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.evy = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.evy.setVisibility(8);
        this.fcY.requestFocus();
        this.fcY.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(a.this.iAZ.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.cfV();
                a.this.cfU();
            }
        });
        this.fcY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cfV();
                a.this.cfU();
            }
        });
        this.fcY.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.iAZ.km(charSequence);
                        PostSearchActivity unused = a.this.iAZ;
                        TiebaStatic.log(new an("c12842").bT("obj_name", charSequence).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").bT("obj_type", "2").bT("fid", a.this.iAZ.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.evy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.fcY.setText("");
                a.this.cfV();
            }
        });
        this.fcY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.iAZ.frY = obj;
                if (obj.trim().length() == 0) {
                    a.this.cfV();
                    a.this.evy.setVisibility(8);
                    return;
                }
                a.this.evy.setVisibility(0);
            }
        });
        this.iBa = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.c(a.this.iAZ.getPageContext().getPageActivity(), a.this.fcY);
            }
        };
        com.baidu.adp.lib.g.e.iK().postDelayed(this.iBa, 500L);
    }

    public void Dj(String str) {
        this.fcY.setText(str);
    }

    public void btD() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void cfS() {
        l.b(this.iAZ.getPageContext().getPageActivity(), this.fcY);
    }

    public void cfT() {
        this.evy.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfU() {
        if (!StringUtils.isNull(this.fcY.getText().toString())) {
            this.evy.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfV() {
        if (!this.iAZ.cfX()) {
            this.iAZ.cfW();
            if (!this.fcY.hasFocus()) {
                this.fcY.requestFocus();
                l.c(this.iAZ.getPageContext().getPageActivity(), this.fcY);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.iAZ.getPageContext(), i);
        com.baidu.tbadk.s.a.a(this.iAZ.getPageContext(), this.mSearchView);
        am.a(this.evy, (int) R.drawable.search_del_btn_s, (int) R.drawable.search_del_btn);
    }

    public void onDestroy() {
        if (this.iBa != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iBa);
        }
    }
}
