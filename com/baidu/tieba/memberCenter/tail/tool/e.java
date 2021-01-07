package com.baidu.tieba.memberCenter.tail.tool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.data.TailData;
/* loaded from: classes9.dex */
public class e {
    private TextView flK;
    private ImageView lpR;
    private View lpS;
    private TailData lpq;
    private Context mContext;
    private View mRootView;

    public View gC(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.tail_tool_item, (ViewGroup) null);
        this.mContext = context;
        this.mRootView.setTag(this);
        this.flK = (TextView) this.mRootView.findViewById(R.id.tail_tool_item_text);
        this.lpR = (ImageView) this.mRootView.findViewById(R.id.tail_tool_item_selected);
        this.lpS = this.mRootView.findViewById(R.id.tail_tool_item_scope);
        this.lpS.setTag(this);
        return this.mRootView;
    }

    public void setText(String str) {
        this.flK.setText(TbFaceManager.bGp().a(this.mContext, com.baidu.tieba.memberCenter.tail.a.d.OI(str), null));
    }

    public void setColor(String str) {
        this.flK.setTextColor(com.baidu.tieba.memberCenter.tail.a.c.OH(str));
    }

    public void a(TailData tailData) {
        if (tailData != null) {
            setText(tailData.getContent());
            setColor(tailData.getFontColor());
            this.lpR.setSelected(tailData.isSelected());
        }
    }

    public void b(TailData tailData) {
        this.lpq = tailData;
    }

    public TailData dhL() {
        return this.lpq;
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        ao.setBackgroundResource(this.lpS, R.drawable.tail_item_bg);
        ao.setViewTextColor(this.flK, R.color.CAM_X0106, 1);
        ao.setBackgroundResource(this.lpR, R.drawable.tail_tool_list_item_checkbox_bg);
        ao.setImageResource(this.lpR, R.drawable.tail_tool_list_item_checkbox_selector);
    }

    public void M(View.OnClickListener onClickListener) {
        this.lpS.setOnClickListener(onClickListener);
    }
}
