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
    private PostSearchActivity fSN;
    private View fSO;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private EditText cKH = null;
    private ImageView cVU = null;
    private Runnable fSP = null;

    public a(PostSearchActivity postSearchActivity, View view2) {
        this.mRootView = view2;
        this.fSN = postSearchActivity;
        are();
    }

    private void are() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.cKH.hasFocus()) {
                    l.b(a.this.fSN.getPageContext().getPageActivity(), a.this.cKH);
                }
                a.this.fSN.finish();
            }
        });
        this.fSO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.i.post_search_navigation_view, (View.OnClickListener) null);
        this.cKH = (EditText) this.fSO.findViewById(d.g.search_text);
        this.cVU = (ImageView) this.fSO.findViewById(d.g.search_del);
        this.cVU.setVisibility(8);
        this.cKH.requestFocus();
        this.cKH.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (!z) {
                    l.b(a.this.fSN.getPageContext().getPageActivity(), view2);
                    return;
                }
                a.this.bhS();
                a.this.bhR();
            }
        });
        this.cKH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.bhS();
                a.this.bhR();
            }
        });
        this.cKH.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.fSN.rC(charSequence);
                        PostSearchActivity unused = a.this.fSN;
                        TiebaStatic.log(new al("c12842").ac("obj_name", charSequence).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").ac("obj_type", "2").ac(ImageViewerConfig.FORUM_ID, a.this.fSN.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.cVU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.cKH.setText("");
                a.this.bhS();
            }
        });
        this.cKH.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.fSN.cVK = obj;
                if (obj.trim().length() == 0) {
                    a.this.bhS();
                    a.this.cVU.setVisibility(8);
                    return;
                }
                a.this.cVU.setVisibility(0);
            }
        });
        this.fSP = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.c(a.this.fSN.getPageContext().getPageActivity(), a.this.cKH);
            }
        };
        com.baidu.adp.lib.g.e.fw().postDelayed(this.fSP, 500L);
    }

    public void rB(String str) {
        this.cKH.setText(str);
    }

    public void avQ() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void bhP() {
        l.b(this.fSN.getPageContext().getPageActivity(), this.cKH);
    }

    public void bhQ() {
        this.cVU.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhR() {
        if (!StringUtils.isNull(this.cKH.getText().toString())) {
            this.cVU.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhS() {
        if (!this.fSN.bhU()) {
            this.fSN.bhT();
            if (!this.cKH.hasFocus()) {
                this.cKH.requestFocus();
                l.c(this.fSN.getPageContext().getPageActivity(), this.cKH);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.fSN.getPageContext(), i);
        com.baidu.tbadk.n.a.a(this.fSN.getPageContext(), this.fSO);
        ak.a(this.cVU, d.f.search_del_btn_s, d.f.search_del_btn);
    }

    public void onDestroy() {
        if (this.fSP != null) {
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fSP);
        }
    }
}
