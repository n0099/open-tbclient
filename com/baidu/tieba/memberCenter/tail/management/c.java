package com.baidu.tieba.memberCenter.tail.management;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.data.TailData;
/* loaded from: classes8.dex */
public class c {
    private TextView aET;
    private TailData lvd;
    private TextView lve;
    private String mColor;
    private Context mContext;
    private View mRootView;

    public View gA(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.tail_management_item, (ViewGroup) null);
        this.mRootView.setTag(this);
        this.aET = (TextView) this.mRootView.findViewById(R.id.tail_management_item_text);
        this.lve = (TextView) this.mRootView.findViewById(R.id.tail_management_item_delete);
        this.lve.setTag(this);
        return this.mRootView;
    }

    private void setContent(String str) {
        this.aET.setText(TbFaceManager.bCR().a(this.mContext, com.baidu.tieba.memberCenter.tail.a.d.Ow(str), null));
    }

    private void setColor(String str) {
        this.mColor = str;
        this.aET.setTextColor(com.baidu.tieba.memberCenter.tail.a.c.Ov(str));
    }

    public void D(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().onModeChanged(this.mRootView);
        setColor(this.mColor);
    }

    public TailData dgj() {
        return this.lvd;
    }

    public void b(TailData tailData) {
        this.lvd = tailData;
        setContent(tailData.getContent());
        setColor(tailData.getFontColor());
    }

    public void K(View.OnClickListener onClickListener) {
        this.mRootView.setOnClickListener(onClickListener);
    }

    public void L(View.OnClickListener onClickListener) {
        this.lve.setOnClickListener(onClickListener);
    }

    public void o(Boolean bool) {
        this.lve.setVisibility(bool.booleanValue() ? 0 : 8);
    }
}
