package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class PbFirstFloorUserLikeButton extends TBSpecificationBtn implements com.baidu.tbadk.core.view.userLike.b {
    protected String foR;
    protected String foS;
    private com.baidu.tbadk.core.view.commonBtn.b mqn;
    private com.baidu.tbadk.core.view.commonBtn.b mqo;
    public View.OnClickListener mqp;

    public PbFirstFloorUserLikeButton(Context context) {
        super(context);
        init();
    }

    public PbFirstFloorUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PbFirstFloorUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.foR = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.foS = TbadkCoreApplication.getInst().getString(R.string.attention);
        setTextSize(R.dimen.T_X08);
        setText(this.foS);
        this.mqn = new com.baidu.tbadk.core.view.commonBtn.b();
        this.mqn.pS(R.color.CAM_X0302);
        this.mqo = new com.baidu.tbadk.core.view.commonBtn.b();
        this.mqo.pU(R.color.CAM_X0109);
        setConfig(this.mqn);
    }

    public void setFollowIconSize(int i) {
        this.mqn.setIconSize(i);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void aM(boolean z) {
        if (!(this.foo instanceof Boolean) || ((Boolean) this.foo).booleanValue() != z) {
            this.foo = Boolean.valueOf(z);
            if (z) {
                setVisibility(8);
                setClickable(false);
                setText(this.foR);
                setConfig(this.mqo);
            } else {
                setVisibility(0);
                setClickable(true);
                setText(this.foS);
                setConfig(this.mqn);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void r(boolean z, int i) {
        aM(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void b(boolean z, int i, boolean z2) {
        aM(z);
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void qc(int i) {
    }

    public void bG(View view) {
        if (this.mqp != null) {
            this.mqp.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void i(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        bus();
    }
}
