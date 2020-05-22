package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.c.d;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes2.dex */
public class StateSwitchView extends EditorInfoView {
    private boolean dIG;
    private int dTD;
    private d jQU;
    private String lSV;
    private String lSW;
    private int lSX;
    private int lSY;
    private com.baidu.tbadk.core.util.d.a lSZ;
    private com.baidu.tbadk.core.util.d.a lTa;
    private int mSkinType;
    private int mState;

    public StateSwitchView(Context context) {
        super(context);
        this.dIG = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dIG = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dIG = false;
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
        bEu();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void aJZ() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        bEu();
        dmV();
    }

    private void bEu() {
        if (this.mState == 1) {
            setText(this.lSW);
        } else {
            setText(this.lSV);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        bEu();
        dmV();
    }

    public void setStateString(String str, String str2) {
        this.lSV = str;
        this.lSW = str2;
        bEu();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.lSX = i;
        this.lSY = i2;
        this.dIG = false;
        dmV();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.dIG = true;
            this.lSZ = aVar;
            this.lTa = aVar2;
            dmV();
        }
    }

    private void dmV() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.dIG && this.lTa != null) {
                drawable2 = this.lTa.getDrawable();
            } else {
                drawable2 = this.lSY > 0 ? am.getDrawable(this.lSY) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.dIG && this.lSZ != null) {
                drawable = this.lSZ.getDrawable();
            } else {
                drawable = this.lSY > 0 ? am.getDrawable(this.lSX) : null;
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
        if (this.jQU != null) {
            this.jQU.Gu();
        }
    }

    public void setBackgroundId(int i) {
        this.dTD = i;
        if (this.dTD > 0) {
            am.setBackgroundResource(this, this.dTD);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            am.setViewTextColor(this, (int) R.color.cp_cont_f);
            if (this.dTD > 0) {
                am.setBackgroundResource(this, this.dTD);
            }
            dmV();
            this.mSkinType = i;
        }
    }
}
