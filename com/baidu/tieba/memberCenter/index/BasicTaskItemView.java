package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class BasicTaskItemView extends LinearLayout {
    private View.OnClickListener gjP;
    private TextView llA;
    private View llB;
    private View llt;
    private TbImageView llx;
    private TextView lly;
    private TextView llz;
    private Context mContext;
    private View mRootView;

    public BasicTaskItemView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public BasicTaskItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public BasicTaskItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.index_task_item, this);
        this.llt = this.mRootView.findViewById(R.id.ly_desc);
        this.llx = (TbImageView) this.mRootView.findViewById(R.id.task_icon);
        this.lly = (TextView) this.mRootView.findViewById(R.id.txt_title);
        this.llz = (TextView) this.mRootView.findViewById(R.id.txt_desc);
        this.llA = (TextView) this.mRootView.findViewById(R.id.txt_status);
        this.llA.setOnClickListener(this.gjP);
        this.llt.setOnClickListener(this.gjP);
        this.llB = this.mRootView.findViewById(R.id.divider_line);
    }

    public void setOnCommenClickListener(View.OnClickListener onClickListener) {
        this.gjP = onClickListener;
    }
}
