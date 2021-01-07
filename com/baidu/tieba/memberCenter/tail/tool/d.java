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
public class d {
    private TextView lpQ;
    private View mRootView;

    public View gC(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.tail_tool_edit_item, (ViewGroup) null);
        this.lpQ = (TextView) this.mRootView.findViewById(R.id.tail_tool_edit_item_btn);
        this.mRootView.setTag(this);
        return this.mRootView;
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        ao.setBackgroundResource(this.lpQ, R.drawable.tail_tool_add_button_bg);
        ao.setViewTextColor(this.lpQ, R.color.CAM_X0302, 1);
    }

    public void L(View.OnClickListener onClickListener) {
        this.mRootView.setOnClickListener(onClickListener);
    }
}
