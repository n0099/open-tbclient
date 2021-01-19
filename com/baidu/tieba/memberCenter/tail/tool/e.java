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
/* loaded from: classes8.dex */
public class e {
    private TextView fgZ;
    private TailData lkG;
    private ImageView llh;
    private View lli;
    private Context mContext;
    private View mRootView;

    public View gA(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.tail_tool_item, (ViewGroup) null);
        this.mContext = context;
        this.mRootView.setTag(this);
        this.fgZ = (TextView) this.mRootView.findViewById(R.id.tail_tool_item_text);
        this.llh = (ImageView) this.mRootView.findViewById(R.id.tail_tool_item_selected);
        this.lli = this.mRootView.findViewById(R.id.tail_tool_item_scope);
        this.lli.setTag(this);
        return this.mRootView;
    }

    public void setText(String str) {
        this.fgZ.setText(TbFaceManager.bCw().a(this.mContext, com.baidu.tieba.memberCenter.tail.a.d.NB(str), null));
    }

    public void setColor(String str) {
        this.fgZ.setTextColor(com.baidu.tieba.memberCenter.tail.a.c.NA(str));
    }

    public void a(TailData tailData) {
        if (tailData != null) {
            setText(tailData.getContent());
            setColor(tailData.getFontColor());
            this.llh.setSelected(tailData.isSelected());
        }
    }

    public void b(TailData tailData) {
        this.lkG = tailData;
    }

    public TailData ddT() {
        return this.lkG;
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        ao.setBackgroundResource(this.lli, R.drawable.tail_item_bg);
        ao.setViewTextColor(this.fgZ, R.color.CAM_X0106, 1);
        ao.setBackgroundResource(this.llh, R.drawable.tail_tool_list_item_checkbox_bg);
        ao.setImageResource(this.llh, R.drawable.tail_tool_list_item_checkbox_selector);
    }

    public void M(View.OnClickListener onClickListener) {
        this.lli.setOnClickListener(onClickListener);
    }
}
