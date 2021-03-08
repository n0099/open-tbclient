package com.baidu.tieba.memberCenter.tail.tool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class c {
    private ImageView lvb;
    private TextView lvc;
    private Context mContext;
    private View mRootView;

    public void EJ(int i) {
        this.lvc.setText(String.format(this.mContext.getString(R.string.tail_management_available), Integer.valueOf(i)));
    }

    public void J(View.OnClickListener onClickListener) {
        this.lvb.setOnClickListener(onClickListener);
    }

    public View gA(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.tail_tool_add_item, (ViewGroup) null);
        this.mRootView.setTag(this);
        this.lvc = (TextView) this.mRootView.findViewById(R.id.tail_management_new_text);
        this.lvb = (ImageView) this.mRootView.findViewById(R.id.tail_management_new_button);
        return this.mRootView;
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        ap.setBackgroundResource(this.lvb, R.drawable.tail_tool_add_button_bg);
        ap.setImageResource(this.lvb, R.drawable.icon_tail_post_add);
        ap.setViewTextColor(this.lvc, R.color.CAM_X0109, 1);
    }
}
