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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class a {
    private PostSearchActivity gjJ;
    private View gjK;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private EditText cVF = null;
    private ImageView dkT = null;
    private Runnable gjL = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.gjJ = postSearchActivity;
        asl();
    }

    private void asl() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cVF.hasFocus()) {
                    l.a(a.this.gjJ.getPageContext().getPageActivity(), a.this.cVF);
                }
                a.this.gjJ.finish();
            }
        });
        this.gjK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, f.h.post_search_navigation_view, (View.OnClickListener) null);
        this.cVF = (EditText) this.gjK.findViewById(f.g.search_text);
        this.dkT = (ImageView) this.gjK.findViewById(f.g.search_del);
        this.dkT.setVisibility(8);
        this.cVF.requestFocus();
        this.cVF.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(a.this.gjJ.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.blK();
                a.this.blJ();
            }
        });
        this.cVF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.blK();
                a.this.blJ();
            }
        });
        this.cVF.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.gjJ.st(charSequence);
                        PostSearchActivity unused = a.this.gjJ;
                        TiebaStatic.log(new an("c12842").ae("obj_name", charSequence).ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").ae("obj_type", "2").ae(ImageViewerConfig.FORUM_ID, a.this.gjJ.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.dkT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cVF.setText("");
                a.this.blK();
            }
        });
        this.cVF.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.gjJ.dkJ = obj;
                if (obj.trim().length() == 0) {
                    a.this.blK();
                    a.this.dkT.setVisibility(8);
                    return;
                }
                a.this.dkT.setVisibility(0);
            }
        });
        this.gjL = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.b(a.this.gjJ.getPageContext().getPageActivity(), a.this.cVF);
            }
        };
        com.baidu.adp.lib.g.e.in().postDelayed(this.gjL, 500L);
    }

    public void ss(String str) {
        this.cVF.setText(str);
    }

    public void aBl() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void blH() {
        l.a(this.gjJ.getPageContext().getPageActivity(), this.cVF);
    }

    public void blI() {
        this.dkT.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blJ() {
        if (!StringUtils.isNull(this.cVF.getText().toString())) {
            this.dkT.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blK() {
        if (!this.gjJ.blM()) {
            this.gjJ.blL();
            if (!this.cVF.hasFocus()) {
                this.cVF.requestFocus();
                l.b(this.gjJ.getPageContext().getPageActivity(), this.cVF);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.gjJ.getPageContext(), i);
        com.baidu.tbadk.o.a.a(this.gjJ.getPageContext(), this.gjK);
        am.a(this.dkT, f.C0146f.search_del_btn_s, f.C0146f.search_del_btn);
    }

    public void onDestroy() {
        if (this.gjL != null) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.gjL);
        }
    }
}
