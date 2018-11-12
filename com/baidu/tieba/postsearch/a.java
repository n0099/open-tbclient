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
    private PostSearchActivity gAd;
    private View gAe;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private EditText dkN = null;
    private ImageView dAe = null;
    private Runnable gAf = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.gAd = postSearchActivity;
        awU();
    }

    private void awU() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dkN.hasFocus()) {
                    l.b(a.this.gAd.getPageContext().getPageActivity(), a.this.dkN);
                }
                a.this.gAd.finish();
            }
        });
        this.gAe = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, e.h.post_search_navigation_view, (View.OnClickListener) null);
        this.dkN = (EditText) this.gAe.findViewById(e.g.search_text);
        this.dAe = (ImageView) this.gAe.findViewById(e.g.search_del);
        this.dAe.setVisibility(8);
        this.dkN.requestFocus();
        this.dkN.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(a.this.gAd.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.brb();
                a.this.bra();
            }
        });
        this.dkN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.brb();
                a.this.bra();
            }
        });
        this.dkN.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.gAd.startSearch(charSequence);
                        PostSearchActivity unused = a.this.gAd;
                        TiebaStatic.log(new am("c12842").ax("obj_name", charSequence).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").ax("obj_type", "2").ax(ImageViewerConfig.FORUM_ID, a.this.gAd.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.dAe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dkN.setText("");
                a.this.brb();
            }
        });
        this.dkN.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.gAd.dzU = obj;
                if (obj.trim().length() == 0) {
                    a.this.brb();
                    a.this.dAe.setVisibility(8);
                    return;
                }
                a.this.dAe.setVisibility(0);
            }
        });
        this.gAf = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.c(a.this.gAd.getPageContext().getPageActivity(), a.this.dkN);
            }
        };
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gAf, 500L);
    }

    public void tE(String str) {
        this.dkN.setText(str);
    }

    public void aGm() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void bqY() {
        l.b(this.gAd.getPageContext().getPageActivity(), this.dkN);
    }

    public void bqZ() {
        this.dAe.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bra() {
        if (!StringUtils.isNull(this.dkN.getText().toString())) {
            this.dAe.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brb() {
        if (!this.gAd.brd()) {
            this.gAd.brc();
            if (!this.dkN.hasFocus()) {
                this.dkN.requestFocus();
                l.c(this.gAd.getPageContext().getPageActivity(), this.dkN);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.gAd.getPageContext(), i);
        com.baidu.tbadk.o.a.a(this.gAd.getPageContext(), this.gAe);
        al.a(this.dAe, e.f.search_del_btn_s, e.f.search_del_btn);
    }

    public void onDestroy() {
        if (this.gAf != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gAf);
        }
    }
}
