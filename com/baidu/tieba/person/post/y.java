package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.widget.ListView.i {
    private BaseFragmentActivity aPH;
    private View afz;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;

    public y(BaseFragmentActivity baseFragmentActivity) {
        this.aPH = null;
        this.aPH = baseFragmentActivity;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public View jr() {
        this.mRoot = com.baidu.adp.lib.g.b.ei().inflate(this.aPH.getPageContext().getContext(), com.baidu.tieba.x.new_pb_list_more, null);
        this.mRoot.setPadding(0, this.aPH.getResources().getDimensionPixelSize(com.baidu.tieba.u.listview_item_margin), 0, this.aPH.getResources().getDimensionPixelSize(com.baidu.tieba.u.listview_item_margin));
        this.mTextView = (TextView) this.mRoot.findViewById(com.baidu.tieba.w.pb_more_text);
        this.afz = this.mRoot.findViewById(com.baidu.tieba.w.pb_more_view);
        this.afz.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.w.progress);
        da(TbadkCoreApplication.m255getInst().getSkinType());
        this.afz.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.mRoot;
    }

    public void da(int i) {
        this.aPH.getLayoutMode().h(this.afz);
    }

    public void Ez() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.aPH.getPageContext().getPageActivity().getText(com.baidu.tieba.z.loading));
        this.afz.setVisibility(0);
    }

    public void Fc() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mTextView != null) {
            this.afz.setVisibility(0);
            this.mTextView.setText(com.baidu.tieba.z.person_post_thread_no_more);
        }
    }

    public void hL(String str) {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mTextView != null) {
            this.afz.setVisibility(0);
            this.mTextView.setText(str);
        }
    }

    public void EA() {
        this.mProgressBar.setVisibility(8);
        this.afz.setVisibility(0);
        this.mTextView.setText(com.baidu.tieba.z.load_more);
    }

    @Override // com.baidu.adp.widget.ListView.i
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }
}
