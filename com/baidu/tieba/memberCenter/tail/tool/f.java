package com.baidu.tieba.memberCenter.tail.tool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class f {
    private TextView lvG;
    private TextView lvH;
    private View mRootView;

    public void O(View.OnClickListener onClickListener) {
        this.lvG.setOnClickListener(onClickListener);
    }

    public View gA(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.tail_tool_member_guide_item, (ViewGroup) null);
        this.mRootView.setTag(this);
        this.lvG = (TextView) this.mRootView.findViewById(R.id.tail_tool_member_guide_button);
        this.lvH = (TextView) this.mRootView.findViewById(R.id.tail_tool_member_guide_text);
        return this.mRootView;
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        ap.setBackgroundResource(this.lvG, R.drawable.member_privilege_button_new_selector);
        ap.setViewTextColor(this.lvG, R.color.CAM_X0101, 1);
        ap.setViewTextColor(this.lvH, R.color.CAM_X0108, 1);
    }
}
