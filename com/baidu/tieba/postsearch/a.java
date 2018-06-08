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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a {
    private PostSearchActivity gfi;
    private View gfj;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private EditText cUU = null;
    private ImageView dgo = null;
    private Runnable gfk = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.gfi = postSearchActivity;
        avi();
    }

    private void avi() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cUU.hasFocus()) {
                    l.b(a.this.gfi.getPageContext().getPageActivity(), a.this.cUU);
                }
                a.this.gfi.finish();
            }
        });
        this.gfj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.i.post_search_navigation_view, (View.OnClickListener) null);
        this.cUU = (EditText) this.gfj.findViewById(d.g.search_text);
        this.dgo = (ImageView) this.gfj.findViewById(d.g.search_del);
        this.dgo.setVisibility(8);
        this.cUU.requestFocus();
        this.cUU.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(a.this.gfi.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.bmQ();
                a.this.bmP();
            }
        });
        this.cUU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bmQ();
                a.this.bmP();
            }
        });
        this.cUU.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.gfi.sx(charSequence);
                        PostSearchActivity unused = a.this.gfi;
                        TiebaStatic.log(new am("c12842").ah("obj_name", charSequence).ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").ah("obj_type", "2").ah(ImageViewerConfig.FORUM_ID, a.this.gfi.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.dgo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cUU.setText("");
                a.this.bmQ();
            }
        });
        this.cUU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.gfi.dge = obj;
                if (obj.trim().length() == 0) {
                    a.this.bmQ();
                    a.this.dgo.setVisibility(8);
                    return;
                }
                a.this.dgo.setVisibility(0);
            }
        });
        this.gfk = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.c(a.this.gfi.getPageContext().getPageActivity(), a.this.cUU);
            }
        };
        com.baidu.adp.lib.g.e.im().postDelayed(this.gfk, 500L);
    }

    public void sw(String str) {
        this.cUU.setText(str);
    }

    public void azY() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void bmN() {
        l.b(this.gfi.getPageContext().getPageActivity(), this.cUU);
    }

    public void bmO() {
        this.dgo.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmP() {
        if (!StringUtils.isNull(this.cUU.getText().toString())) {
            this.dgo.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmQ() {
        if (!this.gfi.bmS()) {
            this.gfi.bmR();
            if (!this.cUU.hasFocus()) {
                this.cUU.requestFocus();
                l.c(this.gfi.getPageContext().getPageActivity(), this.cUU);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.gfi.getPageContext(), i);
        com.baidu.tbadk.n.a.a(this.gfi.getPageContext(), this.gfj);
        al.a(this.dgo, d.f.search_del_btn_s, d.f.search_del_btn);
    }

    public void onDestroy() {
        if (this.gfk != null) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.gfk);
        }
    }
}
