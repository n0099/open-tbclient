package com.baidu.tieba.memberCenter.tail.tool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class f {
    private TextView lpT;
    private TextView lpU;
    private View mRootView;

    public void N(View.OnClickListener onClickListener) {
        this.lpT.setOnClickListener(onClickListener);
    }

    public View gC(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.tail_tool_member_guide_item, (ViewGroup) null);
        this.mRootView.setTag(this);
        this.lpT = (TextView) this.mRootView.findViewById(R.id.tail_tool_member_guide_button);
        this.lpU = (TextView) this.mRootView.findViewById(R.id.tail_tool_member_guide_text);
        return this.mRootView;
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        ao.setBackgroundResource(this.lpT, R.drawable.member_privilege_button_new_selector);
        ao.setViewTextColor(this.lpT, R.color.CAM_X0101, 1);
        ao.setViewTextColor(this.lpU, R.color.CAM_X0108, 1);
    }
}
