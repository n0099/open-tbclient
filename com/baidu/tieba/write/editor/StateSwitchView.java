package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes3.dex */
public class StateSwitchView extends EditorInfoView {
    private boolean dVO;
    private int egW;
    private int mSkinType;
    private int mState;
    private String mwE;
    private String mwF;
    private int mwG;
    private int mwH;
    private com.baidu.tbadk.core.util.d.a mwI;
    private com.baidu.tbadk.core.util.d.a mwJ;

    public StateSwitchView(Context context) {
        super(context);
        this.dVO = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dVO = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dVO = false;
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
        bKJ();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void aOT() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        bKJ();
        duP();
    }

    private void bKJ() {
        if (this.mState == 1) {
            setText(this.mwF);
        } else {
            setText(this.mwE);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        bKJ();
        duP();
    }

    public void setStateString(String str, String str2) {
        this.mwE = str;
        this.mwF = str2;
        bKJ();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.mwG = i;
        this.mwH = i2;
        this.dVO = false;
        duP();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.dVO = true;
            this.mwI = aVar;
            this.mwJ = aVar2;
            duP();
        }
    }

    private void duP() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.dVO && this.mwJ != null) {
                drawable2 = this.mwJ.getDrawable();
            } else {
                drawable2 = this.mwH > 0 ? ao.getDrawable(this.mwH) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.dVO && this.mwI != null) {
                drawable = this.mwI.getDrawable();
            } else {
                drawable = this.mwH > 0 ? ao.getDrawable(this.mwG) : null;
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
        this.egW = i;
        if (this.egW > 0) {
            ao.setBackgroundResource(this, this.egW);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            ao.setViewTextColor(this, R.color.cp_cont_f);
            if (this.egW > 0) {
                ao.setBackgroundResource(this, this.egW);
            }
            duP();
            this.mSkinType = i;
        }
    }
}
