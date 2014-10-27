package com.baidu.tieba.pb.sub;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.pb.main.bh;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.h {
    private Context mContext;
    private TextView mTextView = null;
    private TextView bzY = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;
    private int mNum = 0;

    public d(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public View hA() {
        this.mRoot = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, w.new_sub_pb_list_more, null);
        this.mTextView = (TextView) this.mRoot.findViewById(v.sub_pb_more_text);
        this.bzY = (TextView) this.mRoot.findViewById(v.sub_pb_more_text_marginright);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(v.progress);
        return this.mRoot;
    }

    public void YH() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(y.loading));
        YI();
    }

    public void gS(int i) {
        this.mNum = i;
        this.mProgressBar.setVisibility(8);
        if (i > 0) {
            bh.a(this.mContext, this.mTextView, i);
            this.bzY.setVisibility(0);
        } else {
            this.mTextView.setText(this.mContext.getText(y.load_more));
            this.bzY.setVisibility(8);
        }
        YI();
    }

    public void XT() {
        this.mProgressBar.setVisibility(8);
        if (this.mNum > 0) {
            bh.a(this.mContext, this.mTextView, this.mNum);
            this.bzY.setVisibility(0);
        } else {
            this.mTextView.setText(this.mContext.getText(y.load_more));
            this.bzY.setVisibility(8);
        }
        YI();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    protected void setTextColor(int i) {
        this.mTextView.setTextColor(i);
    }

    public void YI() {
        int color;
        String charSequence = this.mTextView.getText().toString();
        if (charSequence != null && !charSequence.equals("")) {
            if (charSequence.equals(this.mContext.getString(y.loading))) {
                color = aw.getColor(com.baidu.tieba.s.sub_pb_more_text);
            } else {
                color = aw.getColor(com.baidu.tieba.s.cp_link_tip_c);
            }
            setTextColor(color);
        }
    }

    @Override // com.baidu.adp.widget.ListView.h
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }
}
