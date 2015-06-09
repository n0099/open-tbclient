package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.widget.ListView.e {
    private View apg;
    private BaseFragmentActivity azl;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;

    public z(BaseFragmentActivity baseFragmentActivity) {
        this.azl = null;
        this.azl = baseFragmentActivity;
    }

    @Override // com.baidu.adp.widget.ListView.e
    public View ng() {
        this.mRoot = com.baidu.adp.lib.g.b.hr().inflate(this.azl.getPageContext().getContext(), com.baidu.tieba.r.new_pb_list_more, null);
        this.mRoot.setPadding(0, this.azl.getResources().getDimensionPixelSize(com.baidu.tieba.o.listview_item_margin), 0, this.azl.getResources().getDimensionPixelSize(com.baidu.tieba.o.listview_item_margin));
        this.mTextView = (TextView) this.mRoot.findViewById(com.baidu.tieba.q.pb_more_text);
        this.apg = this.mRoot.findViewById(com.baidu.tieba.q.pb_more_view);
        this.apg.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.q.progress);
        dl(TbadkCoreApplication.m411getInst().getSkinType());
        this.apg.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.mRoot;
    }

    public void dl(int i) {
        this.azl.getLayoutMode().j(this.apg);
    }

    public void JM() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.azl.getPageContext().getPageActivity().getText(com.baidu.tieba.t.loading));
        this.apg.setVisibility(0);
    }

    public void aeS() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mTextView != null) {
            this.apg.setVisibility(0);
            this.mTextView.setText(com.baidu.tieba.t.person_post_thread_no_more);
        }
    }

    public void iF(String str) {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mTextView != null) {
            this.apg.setVisibility(0);
            this.mTextView.setText(str);
        }
    }

    public void JN() {
        this.mProgressBar.setVisibility(8);
        this.apg.setVisibility(0);
        this.mTextView.setText(com.baidu.tieba.t.load_more);
    }

    @Override // com.baidu.adp.widget.ListView.e
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }
}
