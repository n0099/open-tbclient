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
    private int dFn;
    private boolean duH;
    private d jzz;
    private String lzC;
    private String lzD;
    private int lzE;
    private int lzF;
    private com.baidu.tbadk.core.util.d.a lzG;
    private com.baidu.tbadk.core.util.d.a lzH;
    private int mSkinType;
    private int mState;

    public StateSwitchView(Context context) {
        super(context);
        this.duH = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.duH = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.duH = false;
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
        byt();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void biK() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        byt();
        dfH();
    }

    private void byt() {
        if (this.mState == 1) {
            setText(this.lzD);
        } else {
            setText(this.lzC);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        byt();
        dfH();
    }

    public void setStateString(String str, String str2) {
        this.lzC = str;
        this.lzD = str2;
        byt();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.lzE = i;
        this.lzF = i2;
        this.duH = false;
        dfH();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.duH = true;
            this.lzG = aVar;
            this.lzH = aVar2;
            dfH();
        }
    }

    private void dfH() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.duH && this.lzH != null) {
                drawable2 = this.lzH.getDrawable();
            } else {
                drawable2 = this.lzF > 0 ? am.getDrawable(this.lzF) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.duH && this.lzG != null) {
                drawable = this.lzG.getDrawable();
            } else {
                drawable = this.lzF > 0 ? am.getDrawable(this.lzE) : null;
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
        if (this.jzz != null) {
            this.jzz.EE();
        }
    }

    public void setBackgroundId(int i) {
        this.dFn = i;
        if (this.dFn > 0) {
            am.setBackgroundResource(this, this.dFn);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            am.setViewTextColor(this, (int) R.color.cp_cont_f);
            if (this.dFn > 0) {
                am.setBackgroundResource(this, this.dFn);
            }
            dfH();
            this.mSkinType = i;
        }
    }
}
