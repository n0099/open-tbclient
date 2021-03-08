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
public class BasicSeperateBaMemberItemView extends LinearLayout {
    private TbImageView jvx;
    private View lnK;
    private TextView lnL;
    private TextView lnM;
    private TbImageView lnN;
    private Context mContext;
    private View mRootView;

    public BasicSeperateBaMemberItemView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public BasicSeperateBaMemberItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public BasicSeperateBaMemberItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.index_seperate_ba_item, this);
        this.lnK = this.mRootView.findViewById(R.id.ly_desc);
        this.jvx = (TbImageView) this.mRootView.findViewById(R.id.task_icon);
        this.lnL = (TextView) this.mRootView.findViewById(R.id.txt_title);
        this.lnM = (TextView) this.mRootView.findViewById(R.id.txt_desc);
        this.lnN = (TbImageView) this.mRootView.findViewById(R.id.privilege_spread_icon);
    }
}
