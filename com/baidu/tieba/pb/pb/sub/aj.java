package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
public class aj extends com.baidu.adp.widget.ListView.e {
    private Context mContext;
    private TextView mTextView = null;
    private TextView bQm = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;

    public aj(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    @Override // com.baidu.adp.widget.ListView.e
    public View ng() {
        this.mRoot = com.baidu.adp.lib.g.b.hr().inflate(this.mContext, com.baidu.tieba.r.new_sub_pb_list_more, null);
        this.mTextView = (TextView) this.mRoot.findViewById(com.baidu.tieba.q.sub_pb_more_text);
        this.bQm = (TextView) this.mRoot.findViewById(com.baidu.tieba.q.sub_pb_more_text_marginright);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.q.progress);
        return this.mRoot;
    }

    public void startLoadData() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(com.baidu.tieba.t.loading));
        adB();
    }

    public void ux() {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(this.mContext.getText(com.baidu.tieba.t.list_no_more));
        this.bQm.setVisibility(8);
        adB();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    protected void setTextColor(int i) {
        this.mTextView.setTextColor(i);
    }

    public void adB() {
        int color;
        String charSequence = this.mTextView.getText().toString();
        if (charSequence != null && !charSequence.equals("")) {
            if (charSequence.equals(this.mContext.getString(com.baidu.tieba.t.loading))) {
                color = ay.getColor(com.baidu.tieba.n.cp_link_tip_c);
            } else {
                color = ay.getColor(com.baidu.tieba.n.cp_link_tip_c);
            }
            setTextColor(color);
        }
    }

    @Override // com.baidu.adp.widget.ListView.e
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }
}
