package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class DailyPrivilegeItemView extends RelativeLayout {
    private TbImageView ldJ;
    private TbImageView ldK;
    private PrivilegeTextView ldL;
    private TextView ldM;
    private Context mContext;
    private View mRootView;

    public DailyPrivilegeItemView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public DailyPrivilegeItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public DailyPrivilegeItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.index_daily_item, this);
        this.ldJ = (TbImageView) this.mRootView.findViewById(R.id.privilege_icon);
        this.ldK = (TbImageView) this.mRootView.findViewById(R.id.privilege_tag_icon);
        this.ldK.setDefaultResource(R.drawable.transparent_bg);
        this.ldK.setDefaultBgResource(R.drawable.transparent_bg);
        this.ldL = (PrivilegeTextView) this.mRootView.findViewById(R.id.privilege_title);
        this.ldM = (TextView) this.mRootView.findViewById(R.id.privilege_desc);
    }
}
