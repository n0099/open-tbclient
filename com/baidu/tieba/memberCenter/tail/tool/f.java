package com.baidu.tieba.memberCenter.tail.tool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class f {
    private TextView ltE;
    private TextView ltF;
    private View mRootView;

    public void N(View.OnClickListener onClickListener) {
        this.ltE.setOnClickListener(onClickListener);
    }

    public View gB(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.tail_tool_member_guide_item, (ViewGroup) null);
        this.mRootView.setTag(this);
        this.ltE = (TextView) this.mRootView.findViewById(R.id.tail_tool_member_guide_button);
        this.ltF = (TextView) this.mRootView.findViewById(R.id.tail_tool_member_guide_text);
        return this.mRootView;
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        ap.setBackgroundResource(this.ltE, R.drawable.member_privilege_button_new_selector);
        ap.setViewTextColor(this.ltE, R.color.CAM_X0101, 1);
        ap.setViewTextColor(this.ltF, R.color.CAM_X0108, 1);
    }
}
