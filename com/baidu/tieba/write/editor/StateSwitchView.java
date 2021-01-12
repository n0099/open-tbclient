package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes7.dex */
public class StateSwitchView extends EditorInfoView {
    private boolean eSK;
    private int fez;
    private int mSkinType;
    private int mState;
    private String nVC;
    private String nVD;
    private int nVE;
    private int nVF;
    private com.baidu.tbadk.core.util.e.a nVG;
    private com.baidu.tbadk.core.util.e.a nVH;

    public StateSwitchView(Context context) {
        super(context);
        this.eSK = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eSK = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eSK = false;
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
        We();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    private void We() {
        if (this.mState == 1) {
            setText(this.nVD);
        } else {
            setText(this.nVC);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        We();
        dUS();
    }

    public void setStateString(String str, String str2) {
        this.nVC = str;
        this.nVD = str2;
        We();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.nVE = i;
        this.nVF = i2;
        this.eSK = false;
        dUS();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.e.a aVar, com.baidu.tbadk.core.util.e.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.eSK = true;
            this.nVG = aVar;
            this.nVH = aVar2;
            dUS();
        }
    }

    private void dUS() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.eSK && this.nVH != null) {
                drawable2 = this.nVH.getDrawable();
            } else {
                drawable2 = this.nVF > 0 ? ao.getDrawable(this.nVF) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.eSK && this.nVG != null) {
                drawable = this.nVG.getDrawable();
            } else {
                drawable = this.nVF > 0 ? ao.getDrawable(this.nVE) : null;
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

    public void setBackgroundId(int i) {
        this.fez = i;
        if (this.fez > 0) {
            ao.setBackgroundResource(this, this.fez);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            ao.setViewTextColor(this, R.color.CAM_X0106);
            if (this.fez > 0) {
                ao.setBackgroundResource(this, this.fez);
            }
            dUS();
            this.mSkinType = i;
        }
    }
}
