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
public class PrivilegeItemView extends RelativeLayout {
    private TbImageView ldJ;
    private PrivilegeTextView ldL;
    private TextView ldM;
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
        this.ldJ = (TbImageView) this.mRootView.findViewById(R.id.privilege_icon);
        this.ldL = (PrivilegeTextView) this.mRootView.findViewById(R.id.privilege_name);
        this.ldM = (TextView) this.mRootView.findViewById(R.id.privilege_desc);
    }

    public PrivilegeTextView getPrivilegeName() {
        return this.ldL;
    }
}
