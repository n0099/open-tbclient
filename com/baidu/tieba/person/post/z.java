package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.widget.ListView.i {
    private BaseFragmentActivity aOz;
    private View aff;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;

    public z(BaseFragmentActivity baseFragmentActivity) {
        this.aOz = null;
        this.aOz = baseFragmentActivity;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public View jx() {
        this.mRoot = com.baidu.adp.lib.g.b.ek().inflate(this.aOz.getPageContext().getContext(), com.baidu.tieba.x.new_pb_list_more, null);
        this.mRoot.setPadding(0, this.aOz.getResources().getDimensionPixelSize(com.baidu.tieba.u.listview_item_margin), 0, this.aOz.getResources().getDimensionPixelSize(com.baidu.tieba.u.listview_item_margin));
        this.mTextView = (TextView) this.mRoot.findViewById(com.baidu.tieba.w.pb_more_text);
        this.aff = this.mRoot.findViewById(com.baidu.tieba.w.pb_more_view);
        this.aff.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.w.progress);
        cT(TbadkCoreApplication.m255getInst().getSkinType());
        this.aff.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.mRoot;
    }

    public void cT(int i) {
        this.aOz.getLayoutMode().h(this.aff);
    }

    public void Eg() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.aOz.getPageContext().getPageActivity().getText(com.baidu.tieba.z.loading));
        this.aff.setVisibility(0);
    }

    public void EJ() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mTextView != null) {
            this.aff.setVisibility(0);
            this.mTextView.setText(com.baidu.tieba.z.person_post_thread_no_more);
        }
    }

    public void Eh() {
        this.mProgressBar.setVisibility(8);
        this.aff.setVisibility(0);
        this.mTextView.setText(com.baidu.tieba.z.load_more);
    }

    @Override // com.baidu.adp.widget.ListView.i
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }
}
