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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class a {
    private PostSearchActivity jAI;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View mSearchView;
    private EditText gaU = null;
    private ImageView fCR = null;
    private Runnable jAJ = null;

    public a(PostSearchActivity postSearchActivity, View view) {
        this.mRootView = view;
        this.jAI = postSearchActivity;
        bcJ();
    }

    private void bcJ() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gaU.hasFocus()) {
                    l.hideSoftKeyPad(a.this.jAI.getPageContext().getPageActivity(), a.this.gaU);
                }
                a.this.jAI.finish();
            }
        });
        this.mSearchView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.gaU = (EditText) this.mSearchView.findViewById(R.id.search_text);
        this.fCR = (ImageView) this.mSearchView.findViewById(R.id.search_del);
        this.fCR.setVisibility(8);
        this.gaU.requestFocus();
        this.gaU.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.postsearch.a.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.jAI.getPageContext().getPageActivity(), view);
                    return;
                }
                a.this.cAx();
                a.this.cAw();
            }
        });
        this.gaU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cAx();
                a.this.cAw();
            }
        });
        this.gaU.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.postsearch.a.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 6 || i == 4 || i == 3) {
                    String charSequence = textView.getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        a.this.jAI.qd(charSequence);
                        PostSearchActivity unused = a.this.jAI;
                        TiebaStatic.log(new an("c12842").cy("obj_name", charSequence).cy("obj_source", "1").cy("obj_type", "2").cy("fid", a.this.jAI.mForumId));
                    }
                    return true;
                }
                return false;
            }
        });
        this.fCR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gaU.setText("");
                a.this.cAx();
            }
        });
        this.gaU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.postsearch.a.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                a.this.jAI.gmp = obj;
                if (obj.trim().length() == 0) {
                    a.this.cAx();
                    a.this.fCR.setVisibility(8);
                    return;
                }
                a.this.fCR.setVisibility(0);
            }
        });
        this.jAJ = new Runnable() { // from class: com.baidu.tieba.postsearch.a.7
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(a.this.jAI.getPageContext().getPageActivity(), a.this.gaU);
            }
        };
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jAJ, 500L);
    }

    public void Hm(String str) {
        this.gaU.setText(str);
    }

    public void bLM() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void hideSoftKeyPad() {
        l.hideSoftKeyPad(this.jAI.getPageContext().getPageActivity(), this.gaU);
    }

    public void cAv() {
        this.fCR.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAw() {
        if (!StringUtils.isNull(this.gaU.getText().toString())) {
            this.fCR.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAx() {
        if (!this.jAI.cAz()) {
            this.jAI.cAy();
            if (!this.gaU.hasFocus()) {
                this.gaU.requestFocus();
                l.showSoftKeyPad(this.jAI.getPageContext().getPageActivity(), this.gaU);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.jAI.getPageContext(), i);
        com.baidu.tbadk.q.a.a(this.jAI.getPageContext(), this.mSearchView);
        SvgManager.aGC().a(this.fCR, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void onDestroy() {
        if (this.jAJ != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jAJ);
        }
    }
}
