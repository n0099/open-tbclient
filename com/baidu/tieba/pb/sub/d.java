package com.baidu.tieba.pb.sub;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.pb.main.bi;
import com.baidu.tieba.t;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.i {
    private Context mContext;
    private TextView mTextView = null;
    private TextView bDX = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;
    private int mNum = 0;

    public d(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public View jx() {
        this.mRoot = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, x.new_sub_pb_list_more, null);
        this.mTextView = (TextView) this.mRoot.findViewById(w.sub_pb_more_text);
        this.bDX = (TextView) this.mRoot.findViewById(w.sub_pb_more_text_marginright);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(w.progress);
        return this.mRoot;
    }

    public void startLoadData() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(z.loading));
        Zf();
    }

    public void gY(int i) {
        this.mNum = i;
        this.mProgressBar.setVisibility(8);
        if (i > 0) {
            bi.a(this.mContext, this.mTextView, i);
            this.bDX.setVisibility(0);
        } else {
            this.mTextView.setText(this.mContext.getText(z.load_more));
            this.bDX.setVisibility(8);
        }
        Zf();
    }

    public void qz() {
        this.mProgressBar.setVisibility(8);
        if (this.mNum > 0) {
            bi.a(this.mContext, this.mTextView, this.mNum);
            this.bDX.setVisibility(0);
        } else {
            this.mTextView.setText(this.mContext.getText(z.load_more));
            this.bDX.setVisibility(8);
        }
        Zf();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    protected void setTextColor(int i) {
        this.mTextView.setTextColor(i);
    }

    public void Zf() {
        int color;
        String charSequence = this.mTextView.getText().toString();
        if (charSequence != null && !charSequence.equals("")) {
            if (charSequence.equals(this.mContext.getString(z.loading))) {
                color = ax.getColor(t.cp_link_tip_c);
            } else {
                color = ax.getColor(t.cp_link_tip_c);
            }
            setTextColor(color);
        }
    }

    @Override // com.baidu.adp.widget.ListView.i
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }
}
