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
    private PostSearchActivity fTT;
    private View fTU;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private EditText cLO = null;
    private ImageView cXb = null;
    private Runnable fTV = null;

    public a(PostSearchActivity postSearchActivity, View view2) {
        this.mRootView = view2;
        this.fTT = postSearchActivity;
        ard();
    }

    private void ard() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.cLO.hasFocus()) {
                    l.b(a.this.fTT.getPageContext().getPageActivity(), a.this.cLO);
                }
                a.this.fTT.finish();
            }
        });
        this.fTU = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.i.post_search_navigation_view, (View.OnClickListener) null);
        this.cLO = (EditText) this.fTU.findViewById(d.g.search_text);
        this.cXb = (ImageView) this.fTU.findViewById(d.g.search_del);
        this.cXb.setVisibility(8);
        this.cLO.requestFocus();
        this.cLO.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (!z) {
                    l.b(a.this.fTT.getPageContext().getPageActivity(), view2);
                    return;
                }
                a.this.bhS();
                a.this.bhR();
            }
        });
        this.cLO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.bhS();
                a.this.bhR();
            }
        });
        this.cLO.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.fTT.rF(charSequence);
                        PostSearchActivity unused = a.this.fTT;
                        TiebaStatic.log(new al("c12842").ac("obj_name", charSequence).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").ac("obj_type", "2").ac(ImageViewerConfig.FORUM_ID, a.this.fTT.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.cXb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.cLO.setText("");
                a.this.bhS();
            }
        });
        this.cLO.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.fTT.cWR = obj;
                if (obj.trim().length() == 0) {
                    a.this.bhS();
                    a.this.cXb.setVisibility(8);
                    return;
                }
                a.this.cXb.setVisibility(0);
            }
        });
        this.fTV = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.c(a.this.fTT.getPageContext().getPageActivity(), a.this.cLO);
            }
        };
        com.baidu.adp.lib.g.e.fw().postDelayed(this.fTV, 500L);
    }

    public void rE(String str) {
        this.cLO.setText(str);
    }

    public void avP() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void bhP() {
        l.b(this.fTT.getPageContext().getPageActivity(), this.cLO);
    }

    public void bhQ() {
        this.cXb.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhR() {
        if (!StringUtils.isNull(this.cLO.getText().toString())) {
            this.cXb.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhS() {
        if (!this.fTT.bhU()) {
            this.fTT.bhT();
            if (!this.cLO.hasFocus()) {
                this.cLO.requestFocus();
                l.c(this.fTT.getPageContext().getPageActivity(), this.cLO);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.fTT.getPageContext(), i);
        com.baidu.tbadk.n.a.a(this.fTT.getPageContext(), this.fTU);
        ak.a(this.cXb, d.f.search_del_btn_s, d.f.search_del_btn);
    }

    public void onDestroy() {
        if (this.fTV != null) {
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fTV);
        }
    }
}
