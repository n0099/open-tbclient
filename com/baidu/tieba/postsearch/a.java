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
    private View euy;
    private PostSearchActivity gye;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private EditText drT = null;
    private ImageView dDc = null;
    private Runnable gyf = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.gye = postSearchActivity;
        awO();
    }

    private void awO() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.drT.hasFocus()) {
                    l.a(a.this.gye.getPageContext().getPageActivity(), a.this.drT);
                }
                a.this.gye.finish();
            }
        });
        this.euy = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.post_search_navigation_view, (View.OnClickListener) null);
        this.drT = (EditText) this.euy.findViewById(d.g.search_text);
        this.dDc = (ImageView) this.euy.findViewById(d.g.search_del);
        this.dDc.setVisibility(8);
        this.drT.requestFocus();
        this.drT.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(a.this.gye.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.bmM();
                a.this.bmL();
            }
        });
        this.drT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bmM();
                a.this.bmL();
            }
        });
        this.drT.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.gye.rw(charSequence);
                        PostSearchActivity unused = a.this.gye;
                        TiebaStatic.log(new ak("c12842").ab("obj_name", charSequence).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").ab("obj_type", "2").ab(ImageViewerConfig.FORUM_ID, a.this.gye.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.dDc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.drT.setText("");
                a.this.bmM();
            }
        });
        this.drT.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.gye.dCS = obj;
                if (obj.trim().length() == 0) {
                    a.this.bmM();
                    a.this.dDc.setVisibility(8);
                    return;
                }
                a.this.dDc.setVisibility(0);
            }
        });
        this.gyf = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.b(a.this.gye.getPageContext().getPageActivity(), a.this.drT);
            }
        };
        com.baidu.adp.lib.g.e.ns().postDelayed(this.gyf, 500L);
    }

    public void rv(String str) {
        this.drT.setText(str);
    }

    public void aAV() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void bmJ() {
        l.a(this.gye.getPageContext().getPageActivity(), this.drT);
    }

    public void bmK() {
        this.dDc.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmL() {
        if (!StringUtils.isNull(this.drT.getText().toString())) {
            this.dDc.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmM() {
        if (!this.gye.bmO()) {
            this.gye.bmN();
            if (!this.drT.hasFocus()) {
                this.drT.requestFocus();
                l.b(this.gye.getPageContext().getPageActivity(), this.drT);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.gye.getPageContext(), i);
        com.baidu.tbadk.n.a.a(this.gye.getPageContext(), this.euy);
        aj.a(this.dDc, d.f.search_del_btn_s, d.f.search_del_btn);
    }

    public void onDestroy() {
        if (this.gyf != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gyf);
        }
    }
}
