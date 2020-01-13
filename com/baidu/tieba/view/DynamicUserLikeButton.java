package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class DynamicUserLikeButton extends TBSpecificationBtn implements com.baidu.tbadk.core.view.userLike.b {
    private a kGY;

    /* loaded from: classes6.dex */
    public interface a {
        void G(View view);
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
        cVar.lb(R.color.cp_link_tip_a);
        setConfig(cVar);
        setText(TbadkCoreApplication.getInst().getString(R.string.attention));
    }

    public void fN(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.ld(R.color.cp_cont_d);
            setConfig(cVar);
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.lb(R.color.cp_link_tip_a);
            setConfig(cVar2);
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void l(boolean z, int i) {
        if (z || i == 1 || i == 2) {
            fN(true);
        } else {
            fN(false);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void b(boolean z, int i, boolean z2) {
        l(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void lg(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void ba(View view) {
        if (this.kGY != null) {
            this.kGY.G(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        aFw();
    }

    public void setOnClickEvent(a aVar) {
        this.kGY = aVar;
    }
}
