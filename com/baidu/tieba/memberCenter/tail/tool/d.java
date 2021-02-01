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
public class d {
    private TextView ltm;
    private View mRootView;

    public View gB(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.tail_tool_edit_item, (ViewGroup) null);
        this.ltm = (TextView) this.mRootView.findViewById(R.id.tail_tool_edit_item_btn);
        this.mRootView.setTag(this);
        return this.mRootView;
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        ap.setBackgroundResource(this.ltm, R.drawable.tail_tool_add_button_bg);
        ap.setViewTextColor(this.ltm, R.color.CAM_X0302, 1);
    }

    public void L(View.OnClickListener onClickListener) {
        this.mRootView.setOnClickListener(onClickListener);
    }
}
