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
    private PostSearchActivity gGT;
    private View gGU;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private EditText drp = null;
    private ImageView dGD = null;
    private Runnable gGV = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.gGT = postSearchActivity;
        ayF();
    }

    private void ayF() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.drp.hasFocus()) {
                    l.b(a.this.gGT.getPageContext().getPageActivity(), a.this.drp);
                }
                a.this.gGT.finish();
            }
        });
        this.gGU = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, e.h.post_search_navigation_view, (View.OnClickListener) null);
        this.drp = (EditText) this.gGU.findViewById(e.g.search_text);
        this.dGD = (ImageView) this.gGU.findViewById(e.g.search_del);
        this.dGD.setVisibility(8);
        this.drp.requestFocus();
        this.drp.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(a.this.gGT.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.bsU();
                a.this.bsT();
            }
        });
        this.drp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bsU();
                a.this.bsT();
            }
        });
        this.drp.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.gGT.startSearch(charSequence);
                        PostSearchActivity unused = a.this.gGT;
                        TiebaStatic.log(new am("c12842").aA("obj_name", charSequence).aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").aA("obj_type", "2").aA(ImageViewerConfig.FORUM_ID, a.this.gGT.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.dGD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.drp.setText("");
                a.this.bsU();
            }
        });
        this.drp.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.gGT.dGt = obj;
                if (obj.trim().length() == 0) {
                    a.this.bsU();
                    a.this.dGD.setVisibility(8);
                    return;
                }
                a.this.dGD.setVisibility(0);
            }
        });
        this.gGV = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.c(a.this.gGT.getPageContext().getPageActivity(), a.this.drp);
            }
        };
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gGV, 500L);
    }

    public void ug(String str) {
        this.drp.setText(str);
    }

    public void aHY() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void bsR() {
        l.b(this.gGT.getPageContext().getPageActivity(), this.drp);
    }

    public void bsS() {
        this.dGD.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsT() {
        if (!StringUtils.isNull(this.drp.getText().toString())) {
            this.dGD.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsU() {
        if (!this.gGT.bsW()) {
            this.gGT.bsV();
            if (!this.drp.hasFocus()) {
                this.drp.requestFocus();
                l.c(this.gGT.getPageContext().getPageActivity(), this.drp);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.gGT.getPageContext(), i);
        com.baidu.tbadk.o.a.a(this.gGT.getPageContext(), this.gGU);
        al.a(this.dGD, e.f.search_del_btn_s, e.f.search_del_btn);
    }

    public void onDestroy() {
        if (this.gGV != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGV);
        }
    }
}
