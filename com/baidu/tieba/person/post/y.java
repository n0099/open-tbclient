package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.widget.ListView.i {
    private BaseFragmentActivity aPI;
    private View afC;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;

    public y(BaseFragmentActivity baseFragmentActivity) {
        this.aPI = null;
        this.aPI = baseFragmentActivity;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public View jy() {
        this.mRoot = com.baidu.adp.lib.g.b.ei().inflate(this.aPI.getPageContext().getContext(), com.baidu.tieba.x.new_pb_list_more, null);
        this.mRoot.setPadding(0, this.aPI.getResources().getDimensionPixelSize(com.baidu.tieba.u.listview_item_margin), 0, this.aPI.getResources().getDimensionPixelSize(com.baidu.tieba.u.listview_item_margin));
        this.mTextView = (TextView) this.mRoot.findViewById(com.baidu.tieba.w.pb_more_text);
        this.afC = this.mRoot.findViewById(com.baidu.tieba.w.pb_more_view);
        this.afC.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.w.progress);
        da(TbadkCoreApplication.m255getInst().getSkinType());
        this.afC.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.mRoot;
    }

    public void da(int i) {
        this.aPI.getLayoutMode().h(this.afC);
    }

    public void EF() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.aPI.getPageContext().getPageActivity().getText(com.baidu.tieba.z.loading));
        this.afC.setVisibility(0);
    }

    public void Fi() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mTextView != null) {
            this.afC.setVisibility(0);
            this.mTextView.setText(com.baidu.tieba.z.person_post_thread_no_more);
        }
    }

    public void EG() {
        this.mProgressBar.setVisibility(8);
        this.afC.setVisibility(0);
        this.mTextView.setText(com.baidu.tieba.z.load_more);
    }

    @Override // com.baidu.adp.widget.ListView.i
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }
}
