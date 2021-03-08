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
public class BasicTaskItemView extends LinearLayout {
    private View.OnClickListener glG;
    private View lnK;
    private TbImageView lnO;
    private TextView lnP;
    private TextView lnQ;
    private TextView lnR;
    private View lnS;
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
        this.lnK = this.mRootView.findViewById(R.id.ly_desc);
        this.lnO = (TbImageView) this.mRootView.findViewById(R.id.task_icon);
        this.lnP = (TextView) this.mRootView.findViewById(R.id.txt_title);
        this.lnQ = (TextView) this.mRootView.findViewById(R.id.txt_desc);
        this.lnR = (TextView) this.mRootView.findViewById(R.id.txt_status);
        this.lnR.setOnClickListener(this.glG);
        this.lnK.setOnClickListener(this.glG);
        this.lnS = this.mRootView.findViewById(R.id.divider_line);
    }

    public void setOnCommenClickListener(View.OnClickListener onClickListener) {
        this.glG = onClickListener;
    }
}
