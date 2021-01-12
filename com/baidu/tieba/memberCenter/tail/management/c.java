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
    private TextView aBG;
    private TailData lkG;
    private TextView lkH;
    private String mColor;
    private Context mContext;
    private View mRootView;

    public View gA(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.tail_management_item, (ViewGroup) null);
        this.mRootView.setTag(this);
        this.aBG = (TextView) this.mRootView.findViewById(R.id.tail_management_item_text);
        this.lkH = (TextView) this.mRootView.findViewById(R.id.tail_management_item_delete);
        this.lkH.setTag(this);
        return this.mRootView;
    }

    private void setContent(String str) {
        this.aBG.setText(TbFaceManager.bCw().a(this.mContext, com.baidu.tieba.memberCenter.tail.a.d.NA(str), null));
    }

    private void setColor(String str) {
        this.mColor = str;
        this.aBG.setTextColor(com.baidu.tieba.memberCenter.tail.a.c.Nz(str));
    }

    public void B(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().onModeChanged(this.mRootView);
        setColor(this.mColor);
    }

    public TailData ddT() {
        return this.lkG;
    }

    public void b(TailData tailData) {
        this.lkG = tailData;
        setContent(tailData.getContent());
        setColor(tailData.getFontColor());
    }

    public void J(View.OnClickListener onClickListener) {
        this.mRootView.setOnClickListener(onClickListener);
    }

    public void K(View.OnClickListener onClickListener) {
        this.lkH.setOnClickListener(onClickListener);
    }

    public void p(Boolean bool) {
        this.lkH.setVisibility(bool.booleanValue() ? 0 : 8);
    }
}
