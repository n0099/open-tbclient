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
public class DressupItemView extends LinearLayout {
    private TextView jjc;
    private TbImageView ldN;
    private TbImageView ldO;
    private TextView ldP;
    private Context mContext;
    private View mRootView;

    public DressupItemView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public DressupItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public DressupItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.index_dressup_item, this);
        this.ldN = (TbImageView) this.mRootView.findViewById(R.id.bg_image);
        this.ldO = (TbImageView) this.mRootView.findViewById(R.id.permission_icon);
        this.ldO.setDefaultResource(R.drawable.transparent_bg);
        this.ldO.setDefaultBgResource(R.drawable.transparent_bg);
        this.ldP = (TextView) this.mRootView.findViewById(R.id.txt_type);
        this.jjc = (TextView) this.mRootView.findViewById(R.id.txt_name);
    }
}
