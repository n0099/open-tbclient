package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.pb.pb.main.bj;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.e {
    private Context mContext;
    private TextView mTextView = null;
    private TextView bNp = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;
    private int mNum = 0;

    public d(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    @Override // com.baidu.adp.widget.ListView.e
    public View mN() {
        this.mRoot = com.baidu.adp.lib.g.b.hH().inflate(this.mContext, w.new_sub_pb_list_more, null);
        this.mTextView = (TextView) this.mRoot.findViewById(com.baidu.tieba.v.sub_pb_more_text);
        this.bNp = (TextView) this.mRoot.findViewById(com.baidu.tieba.v.sub_pb_more_text_marginright);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.v.progress);
        return this.mRoot;
    }

    public void startLoadData() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(y.loading));
        abN();
    }

    public void hr(int i) {
        this.mNum = i;
        this.mProgressBar.setVisibility(8);
        if (i > 0) {
            bj.a(this.mContext, this.mTextView, i);
            this.bNp.setVisibility(0);
        } else {
            this.mTextView.setText(this.mContext.getText(y.load_more));
            this.bNp.setVisibility(8);
        }
        abN();
    }

    public void tO() {
        this.mProgressBar.setVisibility(8);
        if (this.mNum > 0) {
            bj.a(this.mContext, this.mTextView, this.mNum);
            this.bNp.setVisibility(0);
        } else {
            this.mTextView.setText(this.mContext.getText(y.load_more));
            this.bNp.setVisibility(8);
        }
        abN();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    protected void setTextColor(int i) {
        this.mTextView.setTextColor(i);
    }

    public void abN() {
        int color;
        String charSequence = this.mTextView.getText().toString();
        if (charSequence != null && !charSequence.equals("")) {
            if (charSequence.equals(this.mContext.getString(y.loading))) {
                color = ba.getColor(com.baidu.tieba.s.cp_link_tip_c);
            } else {
                color = ba.getColor(com.baidu.tieba.s.cp_link_tip_c);
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
