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
    private PostSearchActivity gyB;
    private View gyC;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private EditText djI = null;
    private ImageView dyN = null;
    private Runnable gyD = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.gyB = postSearchActivity;
        axv();
    }

    private void axv() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.djI.hasFocus()) {
                    l.a(a.this.gyB.getPageContext().getPageActivity(), a.this.djI);
                }
                a.this.gyB.finish();
            }
        });
        this.gyC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, e.h.post_search_navigation_view, (View.OnClickListener) null);
        this.djI = (EditText) this.gyC.findViewById(e.g.search_text);
        this.dyN = (ImageView) this.gyC.findViewById(e.g.search_del);
        this.dyN.setVisibility(8);
        this.djI.requestFocus();
        this.djI.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(a.this.gyB.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.brF();
                a.this.brE();
            }
        });
        this.djI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.brF();
                a.this.brE();
            }
        });
        this.djI.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.gyB.tA(charSequence);
                        PostSearchActivity unused = a.this.gyB;
                        TiebaStatic.log(new am("c12842").ax("obj_name", charSequence).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1").ax("obj_type", "2").ax(ImageViewerConfig.FORUM_ID, a.this.gyB.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.dyN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.djI.setText("");
                a.this.brF();
            }
        });
        this.djI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.gyB.dyD = obj;
                if (obj.trim().length() == 0) {
                    a.this.brF();
                    a.this.dyN.setVisibility(8);
                    return;
                }
                a.this.dyN.setVisibility(0);
            }
        });
        this.gyD = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.b(a.this.gyB.getPageContext().getPageActivity(), a.this.djI);
            }
        };
        com.baidu.adp.lib.g.e.jI().postDelayed(this.gyD, 500L);
    }

    public void tz(String str) {
        this.djI.setText(str);
    }

    public void aGO() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void brC() {
        l.a(this.gyB.getPageContext().getPageActivity(), this.djI);
    }

    public void brD() {
        this.dyN.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brE() {
        if (!StringUtils.isNull(this.djI.getText().toString())) {
            this.dyN.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brF() {
        if (!this.gyB.brH()) {
            this.gyB.brG();
            if (!this.djI.hasFocus()) {
                this.djI.requestFocus();
                l.b(this.gyB.getPageContext().getPageActivity(), this.djI);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.gyB.getPageContext(), i);
        com.baidu.tbadk.o.a.a(this.gyB.getPageContext(), this.gyC);
        al.a(this.dyN, e.f.search_del_btn_s, e.f.search_del_btn);
    }

    public void onDestroy() {
        if (this.gyD != null) {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gyD);
        }
    }
}
