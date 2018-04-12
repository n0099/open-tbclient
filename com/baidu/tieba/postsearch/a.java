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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a {
    private PostSearchActivity fSQ;
    private View fSR;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private EditText cKK = null;
    private ImageView cVX = null;
    private Runnable fSS = null;

    public a(PostSearchActivity postSearchActivity, View view2) {
        this.mRootView = view2;
        this.fSQ = postSearchActivity;
        are();
    }

    private void are() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.cKK.hasFocus()) {
                    l.b(a.this.fSQ.getPageContext().getPageActivity(), a.this.cKK);
                }
                a.this.fSQ.finish();
            }
        });
        this.fSR = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.i.post_search_navigation_view, (View.OnClickListener) null);
        this.cKK = (EditText) this.fSR.findViewById(d.g.search_text);
        this.cVX = (ImageView) this.fSR.findViewById(d.g.search_del);
        this.cVX.setVisibility(8);
        this.cKK.requestFocus();
        this.cKK.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (!z) {
                    l.b(a.this.fSQ.getPageContext().getPageActivity(), view2);
                    return;
                }
                a.this.bhS();
                a.this.bhR();
            }
        });
        this.cKK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.bhS();
                a.this.bhR();
            }
        });
        this.cKK.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.fSQ.rC(charSequence);
                        PostSearchActivity unused = a.this.fSQ;
                        TiebaStatic.log(new al("c12842").ac("obj_name", charSequence).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").ac("obj_type", "2").ac(ImageViewerConfig.FORUM_ID, a.this.fSQ.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.cVX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.cKK.setText("");
                a.this.bhS();
            }
        });
        this.cKK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.fSQ.cVN = obj;
                if (obj.trim().length() == 0) {
                    a.this.bhS();
                    a.this.cVX.setVisibility(8);
                    return;
                }
                a.this.cVX.setVisibility(0);
            }
        });
        this.fSS = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.c(a.this.fSQ.getPageContext().getPageActivity(), a.this.cKK);
            }
        };
        com.baidu.adp.lib.g.e.fw().postDelayed(this.fSS, 500L);
    }

    public void rB(String str) {
        this.cKK.setText(str);
    }

    public void avQ() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void bhP() {
        l.b(this.fSQ.getPageContext().getPageActivity(), this.cKK);
    }

    public void bhQ() {
        this.cVX.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhR() {
        if (!StringUtils.isNull(this.cKK.getText().toString())) {
            this.cVX.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhS() {
        if (!this.fSQ.bhU()) {
            this.fSQ.bhT();
            if (!this.cKK.hasFocus()) {
                this.cKK.requestFocus();
                l.c(this.fSQ.getPageContext().getPageActivity(), this.cKK);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.fSQ.getPageContext(), i);
        com.baidu.tbadk.n.a.a(this.fSQ.getPageContext(), this.fSR);
        ak.a(this.cVX, d.f.search_del_btn_s, d.f.search_del_btn);
    }

    public void onDestroy() {
        if (this.fSS != null) {
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fSS);
        }
    }
}
