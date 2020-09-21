package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class FollowUserButton extends TBSpecificationBtn implements com.baidu.tbadk.core.view.userLike.b {
    private a mRp;
    private int mRq;
    private boolean mRr;

    /* loaded from: classes20.dex */
    public interface a {
        void onClick(View view);
    }

    public FollowUserButton(Context context) {
        this(context, null);
    }

    public FollowUserButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FollowUserButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRq = R.drawable.icon_pure_add12_svg;
        this.mRr = true;
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.pj(UtilHelper.getDimenPixelSize(R.dimen.tbds30));
        bVar.a(this.mRq, 0, TBSpecificationButtonConfig.IconType.SVG);
        bVar.pp(R.color.cp_link_tip_a);
        setConfig(bVar);
        setText(TbadkCoreApplication.getInst().getString(R.string.attention));
    }

    public void aN(boolean z) {
        if (z) {
            setVisibility(0);
            setClickable(this.mRr);
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.pr(R.color.cp_cont_d);
            bVar.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
            setConfig(bVar);
            setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        } else {
            setVisibility(0);
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.pj(UtilHelper.getDimenPixelSize(R.dimen.tbds30));
            bVar2.a(this.mRq, 0, TBSpecificationButtonConfig.IconType.SVG);
            bVar2.pp(R.color.cp_link_tip_a);
            setConfig(bVar2);
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void r(boolean z, int i) {
        if (z) {
            aN(true);
        } else {
            aN(false);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        r(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void py(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bm(View view) {
        if (this.mRp != null) {
            this.mRp.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        blA();
    }

    public void setOnClickEvent(a aVar) {
        this.mRp = aVar;
    }

    public void setSvgIconResId(int i) {
        this.mRq = i;
        blA();
    }

    public void setClickableUnLike(boolean z) {
        this.mRr = z;
    }
}
