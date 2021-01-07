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
/* loaded from: classes9.dex */
public class c {
    private ImageView lpo;
    private TextView lpp;
    private Context mContext;
    private View mRootView;

    public void FU(int i) {
        this.lpp.setText(String.format(this.mContext.getString(R.string.tail_management_available), Integer.valueOf(i)));
    }

    public void I(View.OnClickListener onClickListener) {
        this.lpo.setOnClickListener(onClickListener);
    }

    public View gC(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.tail_tool_add_item, (ViewGroup) null);
        this.mRootView.setTag(this);
        this.lpp = (TextView) this.mRootView.findViewById(R.id.tail_management_new_text);
        this.lpo = (ImageView) this.mRootView.findViewById(R.id.tail_management_new_button);
        return this.mRootView;
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        ao.setBackgroundResource(this.lpo, R.drawable.tail_tool_add_button_bg);
        ao.setImageResource(this.lpo, R.drawable.icon_tail_post_add);
        ao.setViewTextColor(this.lpp, R.color.CAM_X0109, 1);
    }
}
