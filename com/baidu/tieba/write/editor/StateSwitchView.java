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
    private String mwC;
    private String mwD;
    private int mwE;
    private int mwF;
    private com.baidu.tbadk.core.util.d.a mwG;
    private com.baidu.tbadk.core.util.d.a mwH;

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
        duO();
    }

    private void bKJ() {
        if (this.mState == 1) {
            setText(this.mwD);
        } else {
            setText(this.mwC);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        bKJ();
        duO();
    }

    public void setStateString(String str, String str2) {
        this.mwC = str;
        this.mwD = str2;
        bKJ();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.mwE = i;
        this.mwF = i2;
        this.dVO = false;
        duO();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.dVO = true;
            this.mwG = aVar;
            this.mwH = aVar2;
            duO();
        }
    }

    private void duO() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.dVO && this.mwH != null) {
                drawable2 = this.mwH.getDrawable();
            } else {
                drawable2 = this.mwF > 0 ? ao.getDrawable(this.mwF) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.dVO && this.mwG != null) {
                drawable = this.mwG.getDrawable();
            } else {
                drawable = this.mwF > 0 ? ao.getDrawable(this.mwE) : null;
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
            duO();
            this.mSkinType = i;
        }
    }
}
