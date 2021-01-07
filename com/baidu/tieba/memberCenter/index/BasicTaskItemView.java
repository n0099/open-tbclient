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
    private View.OnClickListener gmj;
    private View lhW;
    private TbImageView lia;
    private TextView lib;
    private TextView lic;
    private TextView lid;
    private View lie;
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
        this.lhW = this.mRootView.findViewById(R.id.ly_desc);
        this.lia = (TbImageView) this.mRootView.findViewById(R.id.task_icon);
        this.lib = (TextView) this.mRootView.findViewById(R.id.txt_title);
        this.lic = (TextView) this.mRootView.findViewById(R.id.txt_desc);
        this.lid = (TextView) this.mRootView.findViewById(R.id.txt_status);
        this.lid.setOnClickListener(this.gmj);
        this.lhW.setOnClickListener(this.gmj);
        this.lie = this.mRootView.findViewById(R.id.divider_line);
    }

    public void setOnCommenClickListener(View.OnClickListener onClickListener) {
        this.gmj = onClickListener;
    }
}
