package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class DailyPrivilegeItemView extends RelativeLayout {
    private TbImageView llM;
    private TbImageView llN;
    private PrivilegeTextView llO;
    private TextView llP;
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
        this.llM = (TbImageView) this.mRootView.findViewById(R.id.privilege_icon);
        this.llN = (TbImageView) this.mRootView.findViewById(R.id.privilege_tag_icon);
        this.llN.setDefaultResource(R.drawable.transparent_bg);
        this.llN.setDefaultBgResource(R.drawable.transparent_bg);
        this.llO = (PrivilegeTextView) this.mRootView.findViewById(R.id.privilege_title);
        this.llP = (TextView) this.mRootView.findViewById(R.id.privilege_desc);
    }
}
