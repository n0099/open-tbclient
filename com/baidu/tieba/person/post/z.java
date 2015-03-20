package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.widget.ListView.e {
    private BaseFragmentActivity aCF;
    private View anV;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;

    public z(BaseFragmentActivity baseFragmentActivity) {
        this.aCF = null;
        this.aCF = baseFragmentActivity;
    }

    @Override // com.baidu.adp.widget.ListView.e
    public View mN() {
        this.mRoot = com.baidu.adp.lib.g.b.hH().inflate(this.aCF.getPageContext().getContext(), com.baidu.tieba.w.new_pb_list_more, null);
        this.mRoot.setPadding(0, this.aCF.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_margin), 0, this.aCF.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_margin));
        this.mTextView = (TextView) this.mRoot.findViewById(com.baidu.tieba.v.pb_more_text);
        this.anV = this.mRoot.findViewById(com.baidu.tieba.v.pb_more_view);
        this.anV.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.v.progress);
        dc(TbadkCoreApplication.m411getInst().getSkinType());
        this.anV.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.mRoot;
    }

    public void dc(int i) {
        this.aCF.getLayoutMode().h(this.anV);
    }

    public void IF() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.aCF.getPageContext().getPageActivity().getText(com.baidu.tieba.y.loading));
        this.anV.setVisibility(0);
    }

    public void adw() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mTextView != null) {
            this.anV.setVisibility(0);
            this.mTextView.setText(com.baidu.tieba.y.person_post_thread_no_more);
        }
    }

    public void hX(String str) {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mTextView != null) {
            this.anV.setVisibility(0);
            this.mTextView.setText(str);
        }
    }

    public void IG() {
        this.mProgressBar.setVisibility(8);
        this.anV.setVisibility(0);
        this.mTextView.setText(com.baidu.tieba.y.load_more);
    }

    @Override // com.baidu.adp.widget.ListView.e
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }
}
