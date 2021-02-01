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
    private TextView aDt;
    private TailData lsM;
    private TextView lsN;
    private String mColor;
    private Context mContext;
    private View mRootView;

    public View gB(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.tail_management_item, (ViewGroup) null);
        this.mRootView.setTag(this);
        this.aDt = (TextView) this.mRootView.findViewById(R.id.tail_management_item_text);
        this.lsN = (TextView) this.mRootView.findViewById(R.id.tail_management_item_delete);
        this.lsN.setTag(this);
        return this.mRootView;
    }

    private void setContent(String str) {
        this.aDt.setText(TbFaceManager.bCO().a(this.mContext, com.baidu.tieba.memberCenter.tail.a.d.Op(str), null));
    }

    private void setColor(String str) {
        this.mColor = str;
        this.aDt.setTextColor(com.baidu.tieba.memberCenter.tail.a.c.Oo(str));
    }

    public void D(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().onModeChanged(this.mRootView);
        setColor(this.mColor);
    }

    public TailData dfT() {
        return this.lsM;
    }

    public void b(TailData tailData) {
        this.lsM = tailData;
        setContent(tailData.getContent());
        setColor(tailData.getFontColor());
    }

    public void J(View.OnClickListener onClickListener) {
        this.mRootView.setOnClickListener(onClickListener);
    }

    public void K(View.OnClickListener onClickListener) {
        this.lsN.setOnClickListener(onClickListener);
    }

    public void o(Boolean bool) {
        this.lsN.setVisibility(bool.booleanValue() ? 0 : 8);
    }
}
