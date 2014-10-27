package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.adp.widget.ListView.h {
    private View auN;
    private BaseFragmentActivity axV;
    final /* synthetic */ t bEe;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;

    public z(t tVar, BaseFragmentActivity baseFragmentActivity) {
        this.bEe = tVar;
        this.axV = null;
        this.axV = baseFragmentActivity;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public View hA() {
        this.mRoot = com.baidu.adp.lib.g.b.ek().inflate(this.axV, com.baidu.tieba.w.new_pb_list_more, null);
        this.mRoot.setPadding(0, this.axV.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_margin), 0, this.axV.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_margin));
        this.mTextView = (TextView) this.mRoot.findViewById(com.baidu.tieba.v.pb_more_text);
        this.auN = this.mRoot.findViewById(com.baidu.tieba.v.pb_more_view);
        this.auN.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.v.progress);
        cu(TbadkApplication.m251getInst().getSkinType());
        this.auN.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.mRoot;
    }

    public void cu(int i) {
        this.axV.getLayoutMode().h(this.auN);
    }

    public void DF() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.axV.getText(com.baidu.tieba.y.loading));
        this.auN.setVisibility(0);
    }

    public void Ep() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mTextView != null) {
            this.auN.setVisibility(0);
            this.mTextView.setText(com.baidu.tieba.y.person_post_thread_no_more);
        }
    }

    public void DG() {
        this.mProgressBar.setVisibility(8);
        this.auN.setVisibility(0);
        this.mTextView.setText(com.baidu.tieba.y.load_more);
    }

    @Override // com.baidu.adp.widget.ListView.h
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }
}
