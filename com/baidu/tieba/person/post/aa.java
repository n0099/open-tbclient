package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
class aa extends com.baidu.adp.widget.ListView.h {
    private View auW;
    private BaseFragmentActivity aye;
    final /* synthetic */ u bEs;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;

    public aa(u uVar, BaseFragmentActivity baseFragmentActivity) {
        this.bEs = uVar;
        this.aye = null;
        this.aye = baseFragmentActivity;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public View hA() {
        this.mRoot = com.baidu.adp.lib.g.b.ek().inflate(this.aye, com.baidu.tieba.w.new_pb_list_more, null);
        this.mRoot.setPadding(0, this.aye.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_margin), 0, this.aye.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_margin));
        this.mTextView = (TextView) this.mRoot.findViewById(com.baidu.tieba.v.pb_more_text);
        this.auW = this.mRoot.findViewById(com.baidu.tieba.v.pb_more_view);
        this.auW.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.v.progress);
        cu(TbadkApplication.m251getInst().getSkinType());
        this.auW.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.mRoot;
    }

    public void cu(int i) {
        this.aye.getLayoutMode().h(this.auW);
    }

    public void DH() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.aye.getText(com.baidu.tieba.y.loading));
        this.auW.setVisibility(0);
    }

    public void Er() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mTextView != null) {
            this.auW.setVisibility(0);
            this.mTextView.setText(com.baidu.tieba.y.person_post_thread_no_more);
        }
    }

    public void DI() {
        this.mProgressBar.setVisibility(8);
        this.auW.setVisibility(0);
        this.mTextView.setText(com.baidu.tieba.y.load_more);
    }

    @Override // com.baidu.adp.widget.ListView.h
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }
}
