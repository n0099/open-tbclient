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
    private View eui;
    private PostSearchActivity gxO;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private EditText drQ = null;
    private ImageView dCZ = null;
    private Runnable gxP = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.gxO = postSearchActivity;
        awM();
    }

    private void awM() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.drQ.hasFocus()) {
                    l.a(a.this.gxO.getPageContext().getPageActivity(), a.this.drQ);
                }
                a.this.gxO.finish();
            }
        });
        this.eui = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.post_search_navigation_view, (View.OnClickListener) null);
        this.drQ = (EditText) this.eui.findViewById(d.g.search_text);
        this.dCZ = (ImageView) this.eui.findViewById(d.g.search_del);
        this.dCZ.setVisibility(8);
        this.drQ.requestFocus();
        this.drQ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(a.this.gxO.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.bmL();
                a.this.bmK();
            }
        });
        this.drQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bmL();
                a.this.bmK();
            }
        });
        this.drQ.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.gxO.rw(charSequence);
                        PostSearchActivity unused = a.this.gxO;
                        TiebaStatic.log(new ak("c12842").ab("obj_name", charSequence).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").ab("obj_type", "2").ab(ImageViewerConfig.FORUM_ID, a.this.gxO.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.dCZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.drQ.setText("");
                a.this.bmL();
            }
        });
        this.drQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.gxO.dCP = obj;
                if (obj.trim().length() == 0) {
                    a.this.bmL();
                    a.this.dCZ.setVisibility(8);
                    return;
                }
                a.this.dCZ.setVisibility(0);
            }
        });
        this.gxP = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.b(a.this.gxO.getPageContext().getPageActivity(), a.this.drQ);
            }
        };
        com.baidu.adp.lib.g.e.ns().postDelayed(this.gxP, 500L);
    }

    public void rv(String str) {
        this.drQ.setText(str);
    }

    public void aAT() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void bmI() {
        l.a(this.gxO.getPageContext().getPageActivity(), this.drQ);
    }

    public void bmJ() {
        this.dCZ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmK() {
        if (!StringUtils.isNull(this.drQ.getText().toString())) {
            this.dCZ.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmL() {
        if (!this.gxO.bmN()) {
            this.gxO.bmM();
            if (!this.drQ.hasFocus()) {
                this.drQ.requestFocus();
                l.b(this.gxO.getPageContext().getPageActivity(), this.drQ);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.gxO.getPageContext(), i);
        com.baidu.tbadk.n.a.a(this.gxO.getPageContext(), this.eui);
        aj.a(this.dCZ, d.f.search_del_btn_s, d.f.search_del_btn);
    }

    public void onDestroy() {
        if (this.gxP != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gxP);
        }
    }
}
