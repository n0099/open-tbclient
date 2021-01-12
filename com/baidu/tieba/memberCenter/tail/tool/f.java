package com.baidu.tieba.memberCenter.tail.tool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class f {
    private TextView llj;
    private TextView llk;
    private View mRootView;

    public void N(View.OnClickListener onClickListener) {
        this.llj.setOnClickListener(onClickListener);
    }

    public View gA(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.tail_tool_member_guide_item, (ViewGroup) null);
        this.mRootView.setTag(this);
        this.llj = (TextView) this.mRootView.findViewById(R.id.tail_tool_member_guide_button);
        this.llk = (TextView) this.mRootView.findViewById(R.id.tail_tool_member_guide_text);
        return this.mRootView;
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        ao.setBackgroundResource(this.llj, R.drawable.member_privilege_button_new_selector);
        ao.setViewTextColor(this.llj, R.color.CAM_X0101, 1);
        ao.setViewTextColor(this.llk, R.color.CAM_X0108, 1);
    }
}
