package com.baidu.tieba.memberCenter.tail.tool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.data.TailData;
/* loaded from: classes9.dex */
public class e {
    private TextView fjs;
    private ImageView ltC;
    private View ltD;
    private TailData lta;
    private Context mContext;
    private View mRootView;

    public View gB(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.tail_tool_item, (ViewGroup) null);
        this.mContext = context;
        this.mRootView.setTag(this);
        this.fjs = (TextView) this.mRootView.findViewById(R.id.tail_tool_item_text);
        this.ltC = (ImageView) this.mRootView.findViewById(R.id.tail_tool_item_selected);
        this.ltD = this.mRootView.findViewById(R.id.tail_tool_item_scope);
        this.ltD.setTag(this);
        return this.mRootView;
    }

    public void setText(String str) {
        this.fjs.setText(TbFaceManager.bCO().a(this.mContext, com.baidu.tieba.memberCenter.tail.a.d.Oq(str), null));
    }

    public void setColor(String str) {
        this.fjs.setTextColor(com.baidu.tieba.memberCenter.tail.a.c.Op(str));
    }

    public void a(TailData tailData) {
        if (tailData != null) {
            setText(tailData.getContent());
            setColor(tailData.getFontColor());
            this.ltC.setSelected(tailData.isSelected());
        }
    }

    public void b(TailData tailData) {
        this.lta = tailData;
    }

    public TailData dga() {
        return this.lta;
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        ap.setBackgroundResource(this.ltD, R.drawable.tail_item_bg);
        ap.setViewTextColor(this.fjs, R.color.CAM_X0106, 1);
        ap.setBackgroundResource(this.ltC, R.drawable.tail_tool_list_item_checkbox_bg);
        ap.setImageResource(this.ltC, R.drawable.tail_tool_list_item_checkbox_selector);
    }

    public void M(View.OnClickListener onClickListener) {
        this.ltD.setOnClickListener(onClickListener);
    }
}
