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
public class d {
    private TextView lvD;
    private View mRootView;

    public View gA(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.tail_tool_edit_item, (ViewGroup) null);
        this.lvD = (TextView) this.mRootView.findViewById(R.id.tail_tool_edit_item_btn);
        this.mRootView.setTag(this);
        return this.mRootView;
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        ap.setBackgroundResource(this.lvD, R.drawable.tail_tool_add_button_bg);
        ap.setViewTextColor(this.lvD, R.color.CAM_X0302, 1);
    }

    public void M(View.OnClickListener onClickListener) {
        this.mRootView.setOnClickListener(onClickListener);
    }
}
