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
    private int dFr;
    private boolean duL;
    private d jzD;
    private String lzG;
    private String lzH;
    private int lzI;
    private int lzJ;
    private com.baidu.tbadk.core.util.d.a lzK;
    private com.baidu.tbadk.core.util.d.a lzL;
    private int mSkinType;
    private int mState;

    public StateSwitchView(Context context) {
        super(context);
        this.duL = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.duL = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.duL = false;
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
        byr();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void biI() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        byr();
        dfF();
    }

    private void byr() {
        if (this.mState == 1) {
            setText(this.lzH);
        } else {
            setText(this.lzG);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        byr();
        dfF();
    }

    public void setStateString(String str, String str2) {
        this.lzG = str;
        this.lzH = str2;
        byr();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.lzI = i;
        this.lzJ = i2;
        this.duL = false;
        dfF();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.duL = true;
            this.lzK = aVar;
            this.lzL = aVar2;
            dfF();
        }
    }

    private void dfF() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.duL && this.lzL != null) {
                drawable2 = this.lzL.getDrawable();
            } else {
                drawable2 = this.lzJ > 0 ? am.getDrawable(this.lzJ) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.duL && this.lzK != null) {
                drawable = this.lzK.getDrawable();
            } else {
                drawable = this.lzJ > 0 ? am.getDrawable(this.lzI) : null;
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
        if (this.jzD != null) {
            this.jzD.ED();
        }
    }

    public void setBackgroundId(int i) {
        this.dFr = i;
        if (this.dFr > 0) {
            am.setBackgroundResource(this, this.dFr);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            am.setViewTextColor(this, (int) R.color.cp_cont_f);
            if (this.dFr > 0) {
                am.setBackgroundResource(this, this.dFr);
            }
            dfF();
            this.mSkinType = i;
        }
    }
}
