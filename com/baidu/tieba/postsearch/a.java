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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a {
    private PostSearchActivity gJK;
    private View gJL;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private EditText dud = null;
    private ImageView dJr = null;
    private Runnable gJM = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.gJK = postSearchActivity;
        azu();
    }

    private void azu() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dud.hasFocus()) {
                    l.b(a.this.gJK.getPageContext().getPageActivity(), a.this.dud);
                }
                a.this.gJK.finish();
            }
        });
        this.gJL = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, e.h.post_search_navigation_view, (View.OnClickListener) null);
        this.dud = (EditText) this.gJL.findViewById(e.g.search_text);
        this.dJr = (ImageView) this.gJL.findViewById(e.g.search_del);
        this.dJr.setVisibility(8);
        this.dud.requestFocus();
        this.dud.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(a.this.gJK.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.btF();
                a.this.btE();
            }
        });
        this.dud.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.btF();
                a.this.btE();
            }
        });
        this.dud.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.gJK.startSearch(charSequence);
                        PostSearchActivity unused = a.this.gJK;
                        TiebaStatic.log(new am("c12842").aA("obj_name", charSequence).aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").aA("obj_type", "2").aA(ImageViewerConfig.FORUM_ID, a.this.gJK.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.dJr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dud.setText("");
                a.this.btF();
            }
        });
        this.dud.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.gJK.dJh = obj;
                if (obj.trim().length() == 0) {
                    a.this.btF();
                    a.this.dJr.setVisibility(8);
                    return;
                }
                a.this.dJr.setVisibility(0);
            }
        });
        this.gJM = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.c(a.this.gJK.getPageContext().getPageActivity(), a.this.dud);
            }
        };
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gJM, 500L);
    }

    public void uj(String str) {
        this.dud.setText(str);
    }

    public void aIN() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void btC() {
        l.b(this.gJK.getPageContext().getPageActivity(), this.dud);
    }

    public void btD() {
        this.dJr.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btE() {
        if (!StringUtils.isNull(this.dud.getText().toString())) {
            this.dJr.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btF() {
        if (!this.gJK.btH()) {
            this.gJK.btG();
            if (!this.dud.hasFocus()) {
                this.dud.requestFocus();
                l.c(this.gJK.getPageContext().getPageActivity(), this.dud);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.gJK.getPageContext(), i);
        com.baidu.tbadk.o.a.a(this.gJK.getPageContext(), this.gJL);
        al.a(this.dJr, e.f.search_del_btn_s, e.f.search_del_btn);
    }

    public void onDestroy() {
        if (this.gJM != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gJM);
        }
    }
}
