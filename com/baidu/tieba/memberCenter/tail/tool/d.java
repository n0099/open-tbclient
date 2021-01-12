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
public class d {
    private TextView llg;
    private View mRootView;

    public View gA(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.tail_tool_edit_item, (ViewGroup) null);
        this.llg = (TextView) this.mRootView.findViewById(R.id.tail_tool_edit_item_btn);
        this.mRootView.setTag(this);
        return this.mRootView;
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        ao.setBackgroundResource(this.llg, R.drawable.tail_tool_add_button_bg);
        ao.setViewTextColor(this.llg, R.color.CAM_X0302, 1);
    }

    public void L(View.OnClickListener onClickListener) {
        this.mRootView.setOnClickListener(onClickListener);
    }
}
