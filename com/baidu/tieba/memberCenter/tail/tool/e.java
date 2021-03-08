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
/* loaded from: classes8.dex */
public class e {
    private TextView fkR;
    private ImageView lvE;
    private View lvF;
    private TailData lvd;
    private Context mContext;
    private View mRootView;

    public View gA(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.tail_tool_item, (ViewGroup) null);
        this.mContext = context;
        this.mRootView.setTag(this);
        this.fkR = (TextView) this.mRootView.findViewById(R.id.tail_tool_item_text);
        this.lvE = (ImageView) this.mRootView.findViewById(R.id.tail_tool_item_selected);
        this.lvF = this.mRootView.findViewById(R.id.tail_tool_item_scope);
        this.lvF.setTag(this);
        return this.mRootView;
    }

    public void setText(String str) {
        this.fkR.setText(TbFaceManager.bCR().a(this.mContext, com.baidu.tieba.memberCenter.tail.a.d.Ow(str), null));
    }

    public void setColor(String str) {
        this.fkR.setTextColor(com.baidu.tieba.memberCenter.tail.a.c.Ov(str));
    }

    public void a(TailData tailData) {
        if (tailData != null) {
            setText(tailData.getContent());
            setColor(tailData.getFontColor());
            this.lvE.setSelected(tailData.isSelected());
        }
    }

    public void b(TailData tailData) {
        this.lvd = tailData;
    }

    public TailData dgj() {
        return this.lvd;
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        ap.setBackgroundResource(this.lvF, R.drawable.tail_item_bg);
        ap.setViewTextColor(this.fkR, R.color.CAM_X0106, 1);
        ap.setBackgroundResource(this.lvE, R.drawable.tail_tool_list_item_checkbox_bg);
        ap.setImageResource(this.lvE, R.drawable.tail_tool_list_item_checkbox_selector);
    }

    public void N(View.OnClickListener onClickListener) {
        this.lvF.setOnClickListener(onClickListener);
    }
}
