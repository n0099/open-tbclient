package com.baidu.tieba.memberCenter.tail.edit.color;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class b {
    private View luJ;
    private String mColor;
    private View mRootView;

    public String getColor() {
        return this.mColor;
    }

    public View gA(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.tail_edit_color_item, (ViewGroup) null);
        this.luJ = this.mRootView.findViewById(R.id.tail_edit_color_item_selected);
        this.mRootView.setTag(this);
        return this.mRootView;
    }

    public void setColor(String str) {
        this.mColor = str;
        this.mRootView.setBackgroundColor(com.baidu.tieba.memberCenter.tail.a.c.Ov(str));
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mRootView.setOnClickListener(onClickListener);
    }

    public void tW(boolean z) {
        this.luJ.setVisibility(z ? 0 : 4);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().onModeChanged(this.mRootView);
        this.mRootView.setBackgroundColor(com.baidu.tieba.memberCenter.tail.a.c.Ov(this.mColor));
    }
}
