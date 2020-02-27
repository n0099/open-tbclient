package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.c.d;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes13.dex */
public class StateSwitchView extends EditorInfoView {
    private boolean cVh;
    private int dfp;
    private d iNB;
    private String kOm;
    private String kOn;
    private int kOo;
    private int kOp;
    private com.baidu.tbadk.core.util.e.a kOq;
    private com.baidu.tbadk.core.util.e.a kOr;
    private int mSkinType;
    private int mState;

    public StateSwitchView(Context context) {
        super(context);
        this.cVh = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cVh = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cVh = false;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        initData();
        initUI();
    }

    private void initUI() {
        int dimension = (int) getResources().getDimension(R.dimen.ds26);
        setPadding(dimension, 0, dimension, 0);
        boR();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void baA() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        boR();
        cUN();
    }

    private void boR() {
        if (this.mState == 1) {
            setText(this.kOn);
        } else {
            setText(this.kOm);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        boR();
        cUN();
    }

    public void setStateString(String str, String str2) {
        this.kOm = str;
        this.kOn = str2;
        boR();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.kOo = i;
        this.kOp = i2;
        this.cVh = false;
        cUN();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.e.a aVar, com.baidu.tbadk.core.util.e.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.cVh = true;
            this.kOq = aVar;
            this.kOr = aVar2;
            cUN();
        }
    }

    private void cUN() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.cVh && this.kOr != null) {
                drawable2 = this.kOr.getDrawable();
            } else {
                drawable2 = this.kOp > 0 ? am.getDrawable(this.kOp) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.cVh && this.kOq != null) {
                drawable = this.kOq.getDrawable();
            } else {
                drawable = this.kOp > 0 ? am.getDrawable(this.kOo) : null;
            }
            if (drawable != null) {
                drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        }
    }

    public int getState() {
        return this.mState;
    }

    public void hideTip() {
        if (this.iNB != null) {
            this.iNB.zx();
        }
    }

    public void setBackgroundId(int i) {
        this.dfp = i;
        if (this.dfp > 0) {
            am.setBackgroundResource(this, this.dfp);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            am.setViewTextColor(this, (int) R.color.cp_cont_f);
            if (this.dfp > 0) {
                am.setBackgroundResource(this, this.dfp);
            }
            cUN();
            this.mSkinType = i;
        }
    }
}
