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
public class BasicSeperateBaMemberItemView extends LinearLayout {
    private TbImageView jsA;
    private View lhW;
    private TextView lhX;
    private TextView lhY;
    private TbImageView lhZ;
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
        this.lhW = this.mRootView.findViewById(R.id.ly_desc);
        this.jsA = (TbImageView) this.mRootView.findViewById(R.id.task_icon);
        this.lhX = (TextView) this.mRootView.findViewById(R.id.txt_title);
        this.lhY = (TextView) this.mRootView.findViewById(R.id.txt_desc);
        this.lhZ = (TbImageView) this.mRootView.findViewById(R.id.privilege_spread_icon);
    }
}
