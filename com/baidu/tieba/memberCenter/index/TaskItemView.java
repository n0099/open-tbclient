package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class TaskItemView extends LinearLayout {
    private View.OnClickListener ghB;
    private View ldq;
    private TbImageView ldu;
    private TextView ldv;
    private TextView ldw;
    private TextView ldx;
    private View ldy;
    private Context mContext;
    private View mRootView;

    public TaskItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public TaskItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.index_task_item, this);
        this.ldq = this.mRootView.findViewById(R.id.ly_desc);
        this.ldu = (TbImageView) this.mRootView.findViewById(R.id.task_icon);
        this.ldv = (TextView) this.mRootView.findViewById(R.id.txt_title);
        this.ldw = (TextView) this.mRootView.findViewById(R.id.txt_desc);
        this.ldx = (TextView) this.mRootView.findViewById(R.id.txt_status);
        this.ldx.setOnClickListener(this.ghB);
        this.ldq.setOnClickListener(this.ghB);
        this.ldy = this.mRootView.findViewById(R.id.divider_line);
    }

    public void setOnCommenClickListener(View.OnClickListener onClickListener) {
        this.ghB = onClickListener;
        this.ldx.setOnClickListener(this.ghB);
        this.ldq.setOnClickListener(this.ghB);
    }
}
