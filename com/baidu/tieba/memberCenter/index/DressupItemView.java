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
    private TextView jqG;
    private TbImageView loj;
    private TbImageView lok;
    private TextView lol;
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
        this.loj = (TbImageView) this.mRootView.findViewById(R.id.bg_image);
        this.lok = (TbImageView) this.mRootView.findViewById(R.id.permission_icon);
        this.lok.setDefaultResource(R.drawable.transparent_bg);
        this.lok.setDefaultBgResource(R.drawable.transparent_bg);
        this.lol = (TextView) this.mRootView.findViewById(R.id.txt_type);
        this.jqG = (TextView) this.mRootView.findViewById(R.id.txt_name);
    }
}
