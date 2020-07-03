package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes2.dex */
public class StateSwitchView extends EditorInfoView {
    private boolean dPw;
    private int eaL;
    private int mSkinType;
    private int mState;
    private String moA;
    private String moB;
    private int moC;
    private int moD;
    private com.baidu.tbadk.core.util.d.a moE;
    private com.baidu.tbadk.core.util.d.a moF;

    public StateSwitchView(Context context) {
        super(context);
        this.dPw = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dPw = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dPw = false;
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
        bHC();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void aLf() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        bHC();
        dry();
    }

    private void bHC() {
        if (this.mState == 1) {
            setText(this.moB);
        } else {
            setText(this.moA);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        bHC();
        dry();
    }

    public void setStateString(String str, String str2) {
        this.moA = str;
        this.moB = str2;
        bHC();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.moC = i;
        this.moD = i2;
        this.dPw = false;
        dry();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.dPw = true;
            this.moE = aVar;
            this.moF = aVar2;
            dry();
        }
    }

    private void dry() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.dPw && this.moF != null) {
                drawable2 = this.moF.getDrawable();
            } else {
                drawable2 = this.moD > 0 ? an.getDrawable(this.moD) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.dPw && this.moE != null) {
                drawable = this.moE.getDrawable();
            } else {
                drawable = this.moD > 0 ? an.getDrawable(this.moC) : null;
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
        this.eaL = i;
        if (this.eaL > 0) {
            an.setBackgroundResource(this, this.eaL);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            an.setViewTextColor(this, (int) R.color.cp_cont_f);
            if (this.eaL > 0) {
                an.setBackgroundResource(this, this.eaL);
            }
            dry();
            this.mSkinType = i;
        }
    }
}
