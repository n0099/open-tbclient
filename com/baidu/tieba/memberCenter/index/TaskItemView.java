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
public class TaskItemView extends LinearLayout {
    private View.OnClickListener gkd;
    private View llH;
    private TbImageView llL;
    private TextView llM;
    private TextView llN;
    private TextView llO;
    private View llP;
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
        this.llH = this.mRootView.findViewById(R.id.ly_desc);
        this.llL = (TbImageView) this.mRootView.findViewById(R.id.task_icon);
        this.llM = (TextView) this.mRootView.findViewById(R.id.txt_title);
        this.llN = (TextView) this.mRootView.findViewById(R.id.txt_desc);
        this.llO = (TextView) this.mRootView.findViewById(R.id.txt_status);
        this.llO.setOnClickListener(this.gkd);
        this.llH.setOnClickListener(this.gkd);
        this.llP = this.mRootView.findViewById(R.id.divider_line);
    }

    public void setOnCommenClickListener(View.OnClickListener onClickListener) {
        this.gkd = onClickListener;
        this.llO.setOnClickListener(this.gkd);
        this.llH.setOnClickListener(this.gkd);
    }
}
