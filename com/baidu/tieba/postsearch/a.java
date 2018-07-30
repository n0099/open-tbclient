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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a {
    private PostSearchActivity gjK;
    private View gjL;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private EditText cVJ = null;
    private ImageView dkV = null;
    private Runnable gjM = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.gjK = postSearchActivity;
        asl();
    }

    private void asl() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cVJ.hasFocus()) {
                    l.a(a.this.gjK.getPageContext().getPageActivity(), a.this.cVJ);
                }
                a.this.gjK.finish();
            }
        });
        this.gjL = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.post_search_navigation_view, (View.OnClickListener) null);
        this.cVJ = (EditText) this.gjL.findViewById(d.g.search_text);
        this.dkV = (ImageView) this.gjL.findViewById(d.g.search_del);
        this.dkV.setVisibility(8);
        this.cVJ.requestFocus();
        this.cVJ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(a.this.gjK.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.blN();
                a.this.blM();
            }
        });
        this.cVJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.blN();
                a.this.blM();
            }
        });
        this.cVJ.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.gjK.sp(charSequence);
                        PostSearchActivity unused = a.this.gjK;
                        TiebaStatic.log(new an("c12842").af("obj_name", charSequence).af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").af("obj_type", "2").af(ImageViewerConfig.FORUM_ID, a.this.gjK.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.dkV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cVJ.setText("");
                a.this.blN();
            }
        });
        this.cVJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.gjK.dkL = obj;
                if (obj.trim().length() == 0) {
                    a.this.blN();
                    a.this.dkV.setVisibility(8);
                    return;
                }
                a.this.dkV.setVisibility(0);
            }
        });
        this.gjM = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.b(a.this.gjK.getPageContext().getPageActivity(), a.this.cVJ);
            }
        };
        com.baidu.adp.lib.g.e.in().postDelayed(this.gjM, 500L);
    }

    public void so(String str) {
        this.cVJ.setText(str);
    }

    public void aBo() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void blK() {
        l.a(this.gjK.getPageContext().getPageActivity(), this.cVJ);
    }

    public void blL() {
        this.dkV.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blM() {
        if (!StringUtils.isNull(this.cVJ.getText().toString())) {
            this.dkV.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blN() {
        if (!this.gjK.blP()) {
            this.gjK.blO();
            if (!this.cVJ.hasFocus()) {
                this.cVJ.requestFocus();
                l.b(this.gjK.getPageContext().getPageActivity(), this.cVJ);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.gjK.getPageContext(), i);
        com.baidu.tbadk.o.a.a(this.gjK.getPageContext(), this.gjL);
        am.a(this.dkV, d.f.search_del_btn_s, d.f.search_del_btn);
    }

    public void onDestroy() {
        if (this.gjM != null) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.gjM);
        }
    }
}
