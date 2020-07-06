package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class DynamicUserLikeButton extends TBSpecificationBtn implements com.baidu.tbadk.core.view.userLike.b {
    private a mhR;

    /* loaded from: classes8.dex */
    public interface a {
        void bR(View view);
    }

    public DynamicUserLikeButton(Context context) {
        this(context, null);
    }

    public DynamicUserLikeButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DynamicUserLikeButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.mC(R.color.cp_link_tip_a);
        setConfig(cVar);
        setText(TbadkCoreApplication.getInst().getString(R.string.attention));
    }

    public void hA(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.mE(R.color.cp_cont_d);
            setConfig(cVar);
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.mC(R.color.cp_link_tip_a);
            setConfig(cVar2);
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void r(boolean z, int i) {
        if (z) {
            hA(true);
        } else {
            hA(false);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        r(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void mK(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bc(View view) {
        if (this.mhR != null) {
            this.mhR.bR(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        aYj();
    }

    public void setOnClickEvent(a aVar) {
        this.mhR = aVar;
    }
}
