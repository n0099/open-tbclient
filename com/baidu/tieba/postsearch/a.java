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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a {
    private View euu;
    private PostSearchActivity gxZ;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private EditText dsc = null;
    private ImageView dDl = null;
    private Runnable gya = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.gxZ = postSearchActivity;
        awN();
    }

    private void awN() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dsc.hasFocus()) {
                    l.a(a.this.gxZ.getPageContext().getPageActivity(), a.this.dsc);
                }
                a.this.gxZ.finish();
            }
        });
        this.euu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.post_search_navigation_view, (View.OnClickListener) null);
        this.dsc = (EditText) this.euu.findViewById(d.g.search_text);
        this.dDl = (ImageView) this.euu.findViewById(d.g.search_del);
        this.dDl.setVisibility(8);
        this.dsc.requestFocus();
        this.dsc.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(a.this.gxZ.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.bmM();
                a.this.bmL();
            }
        });
        this.dsc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bmM();
                a.this.bmL();
            }
        });
        this.dsc.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.gxZ.rw(charSequence);
                        PostSearchActivity unused = a.this.gxZ;
                        TiebaStatic.log(new ak("c12842").ab("obj_name", charSequence).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").ab("obj_type", "2").ab(ImageViewerConfig.FORUM_ID, a.this.gxZ.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.dDl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dsc.setText("");
                a.this.bmM();
            }
        });
        this.dsc.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.gxZ.dDb = obj;
                if (obj.trim().length() == 0) {
                    a.this.bmM();
                    a.this.dDl.setVisibility(8);
                    return;
                }
                a.this.dDl.setVisibility(0);
            }
        });
        this.gya = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.b(a.this.gxZ.getPageContext().getPageActivity(), a.this.dsc);
            }
        };
        com.baidu.adp.lib.g.e.ns().postDelayed(this.gya, 500L);
    }

    public void rv(String str) {
        this.dsc.setText(str);
    }

    public void aAU() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void bmJ() {
        l.a(this.gxZ.getPageContext().getPageActivity(), this.dsc);
    }

    public void bmK() {
        this.dDl.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmL() {
        if (!StringUtils.isNull(this.dsc.getText().toString())) {
            this.dDl.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmM() {
        if (!this.gxZ.bmO()) {
            this.gxZ.bmN();
            if (!this.dsc.hasFocus()) {
                this.dsc.requestFocus();
                l.b(this.gxZ.getPageContext().getPageActivity(), this.dsc);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.gxZ.getPageContext(), i);
        com.baidu.tbadk.n.a.a(this.gxZ.getPageContext(), this.euu);
        aj.a(this.dDl, d.f.search_del_btn_s, d.f.search_del_btn);
    }

    public void onDestroy() {
        if (this.gya != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gya);
        }
    }
}
