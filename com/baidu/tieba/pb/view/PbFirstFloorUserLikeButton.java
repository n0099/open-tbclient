package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class PbFirstFloorUserLikeButton extends TBSpecificationBtn implements com.baidu.tbadk.core.view.userLike.b {
    protected String eYD;
    protected String eYE;
    private com.baidu.tbadk.core.view.commonBtn.b lQi;
    private com.baidu.tbadk.core.view.commonBtn.b lQj;
    public View.OnClickListener lQk;

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
        this.eYD = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.eYE = TbadkCoreApplication.getInst().getString(R.string.attention);
        setTextSize(R.dimen.T_X08);
        setText(this.eYE);
        this.lQi = new com.baidu.tbadk.core.view.commonBtn.b();
        this.lQi.qG(R.color.CAM_X0302);
        this.lQj = new com.baidu.tbadk.core.view.commonBtn.b();
        this.lQj.qI(R.color.CAM_X0109);
        setConfig(this.lQi);
    }

    public void setFollowIconSize(int i) {
        this.lQi.qB(i);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void aP(boolean z) {
        if (!(this.eYb instanceof Boolean) || ((Boolean) this.eYb).booleanValue() != z) {
            this.eYb = Boolean.valueOf(z);
            if (z) {
                setVisibility(8);
                setClickable(false);
                setText(this.eYD);
                setConfig(this.lQj);
            } else {
                setVisibility(0);
                setClickable(true);
                setText(this.eYE);
                setConfig(this.lQi);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void s(boolean z, int i) {
        aP(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        aP(z);
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void qP(int i) {
    }

    public void by(View view) {
        if (this.lQk != null) {
            this.lQk.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void h(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        brT();
    }
}
