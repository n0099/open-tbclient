package com.baidu.tieba.memberCenter.tail.tool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class c {
    private ImageView lkE;
    private TextView lkF;
    private Context mContext;
    private View mRootView;

    public void Eo(int i) {
        this.lkF.setText(String.format(this.mContext.getString(R.string.tail_management_available), Integer.valueOf(i)));
    }

    public void I(View.OnClickListener onClickListener) {
        this.lkE.setOnClickListener(onClickListener);
    }

    public View gA(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.tail_tool_add_item, (ViewGroup) null);
        this.mRootView.setTag(this);
        this.lkF = (TextView) this.mRootView.findViewById(R.id.tail_management_new_text);
        this.lkE = (ImageView) this.mRootView.findViewById(R.id.tail_management_new_button);
        return this.mRootView;
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        ao.setBackgroundResource(this.lkE, R.drawable.tail_tool_add_button_bg);
        ao.setImageResource(this.lkE, R.drawable.icon_tail_post_add);
        ao.setViewTextColor(this.lkF, R.color.CAM_X0109, 1);
    }
}
