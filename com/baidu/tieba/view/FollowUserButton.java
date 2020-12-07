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
/* loaded from: classes21.dex */
public class FollowUserButton extends TBSpecificationBtn implements com.baidu.tbadk.core.view.userLike.b {
    private boolean nOA;
    private a nOy;
    private int nOz;

    /* loaded from: classes21.dex */
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
        this.nOz = 0;
        this.nOA = true;
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.rc(UtilHelper.getDimenPixelSize(R.dimen.tbds30));
        bVar.a(this.nOz, 0, TBSpecificationButtonConfig.IconType.SVG);
        bVar.rh(R.color.CAM_X0304);
        setConfig(bVar);
        setText(TbadkCoreApplication.getInst().getString(R.string.attention));
    }

    public void aP(boolean z) {
        if (z) {
            setVisibility(0);
            setClickable(this.nOA);
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.rj(R.color.CAM_X0109);
            bVar.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
            setConfig(bVar);
            setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        } else {
            setVisibility(0);
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.rc(UtilHelper.getDimenPixelSize(R.dimen.tbds30));
            bVar2.a(this.nOz, 0, TBSpecificationButtonConfig.IconType.SVG);
            bVar2.rh(R.color.CAM_X0304);
            setConfig(bVar2);
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void s(boolean z, int i) {
        if (z) {
            aP(true);
        } else {
            aP(false);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        s(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void rq(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bB(View view) {
        if (this.nOy != null) {
            this.nOy.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void h(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        bvt();
    }

    public void setOnClickEvent(a aVar) {
        this.nOy = aVar;
    }

    public void setSvgIconResId(int i) {
        this.nOz = i;
        bvt();
    }

    public void setClickableUnLike(boolean z) {
        this.nOA = z;
    }
}
