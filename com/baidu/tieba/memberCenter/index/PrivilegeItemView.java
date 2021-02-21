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
public class PrivilegeItemView extends RelativeLayout {
    private TbImageView lma;
    private PrivilegeTextView lmc;
    private TextView lmd;
    private Context mContext;
    private View mRootView;

    public PrivilegeItemView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public PrivilegeItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public PrivilegeItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.index_privilege_item, this);
        this.lma = (TbImageView) this.mRootView.findViewById(R.id.privilege_icon);
        this.lmc = (PrivilegeTextView) this.mRootView.findViewById(R.id.privilege_name);
        this.lmd = (TextView) this.mRootView.findViewById(R.id.privilege_desc);
    }

    public PrivilegeTextView getPrivilegeName() {
        return this.lmc;
    }
}
