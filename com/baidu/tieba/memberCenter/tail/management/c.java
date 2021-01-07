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
/* loaded from: classes9.dex */
public class c {
    private TextView aGt;
    private TailData lpq;
    private TextView lpr;
    private String mColor;
    private Context mContext;
    private View mRootView;

    public View gC(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.tail_management_item, (ViewGroup) null);
        this.mRootView.setTag(this);
        this.aGt = (TextView) this.mRootView.findViewById(R.id.tail_management_item_text);
        this.lpr = (TextView) this.mRootView.findViewById(R.id.tail_management_item_delete);
        this.lpr.setTag(this);
        return this.mRootView;
    }

    private void setContent(String str) {
        this.aGt.setText(TbFaceManager.bGp().a(this.mContext, com.baidu.tieba.memberCenter.tail.a.d.OI(str), null));
    }

    private void setColor(String str) {
        this.mColor = str;
        this.aGt.setTextColor(com.baidu.tieba.memberCenter.tail.a.c.OH(str));
    }

    public void B(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().onModeChanged(this.mRootView);
        setColor(this.mColor);
    }

    public TailData dhL() {
        return this.lpq;
    }

    public void b(TailData tailData) {
        this.lpq = tailData;
        setContent(tailData.getContent());
        setColor(tailData.getFontColor());
    }

    public void J(View.OnClickListener onClickListener) {
        this.mRootView.setOnClickListener(onClickListener);
    }

    public void K(View.OnClickListener onClickListener) {
        this.lpr.setOnClickListener(onClickListener);
    }

    public void p(Boolean bool) {
        this.lpr.setVisibility(bool.booleanValue() ? 0 : 8);
    }
}
