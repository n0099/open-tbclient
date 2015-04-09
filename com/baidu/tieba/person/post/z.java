package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.widget.ListView.e {
    private BaseFragmentActivity aCN;
    private View aod;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;

    public z(BaseFragmentActivity baseFragmentActivity) {
        this.aCN = null;
        this.aCN = baseFragmentActivity;
    }

    @Override // com.baidu.adp.widget.ListView.e
    public View mN() {
        this.mRoot = com.baidu.adp.lib.g.b.hH().inflate(this.aCN.getPageContext().getContext(), com.baidu.tieba.w.new_pb_list_more, null);
        this.mRoot.setPadding(0, this.aCN.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_margin), 0, this.aCN.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_margin));
        this.mTextView = (TextView) this.mRoot.findViewById(com.baidu.tieba.v.pb_more_text);
        this.aod = this.mRoot.findViewById(com.baidu.tieba.v.pb_more_view);
        this.aod.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.v.progress);
        dc(TbadkCoreApplication.m411getInst().getSkinType());
        this.aod.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.mRoot;
    }

    public void dc(int i) {
        this.aCN.getLayoutMode().h(this.aod);
    }

    public void IL() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.aCN.getPageContext().getPageActivity().getText(com.baidu.tieba.y.loading));
        this.aod.setVisibility(0);
    }

    public void adL() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mTextView != null) {
            this.aod.setVisibility(0);
            this.mTextView.setText(com.baidu.tieba.y.person_post_thread_no_more);
        }
    }

    public void ia(String str) {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mTextView != null) {
            this.aod.setVisibility(0);
            this.mTextView.setText(str);
        }
    }

    public void IM() {
        this.mProgressBar.setVisibility(8);
        this.aod.setVisibility(0);
        this.mTextView.setText(com.baidu.tieba.y.load_more);
    }

    @Override // com.baidu.adp.widget.ListView.e
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }
}
