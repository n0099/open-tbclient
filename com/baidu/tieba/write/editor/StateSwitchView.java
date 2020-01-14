package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.c.d;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes11.dex */
public class StateSwitchView extends EditorInfoView {
    private boolean cRf;
    private int dbk;
    private d iMh;
    private String kNG;
    private String kNH;
    private int kNI;
    private int kNJ;
    private com.baidu.tbadk.core.util.e.a kNK;
    private com.baidu.tbadk.core.util.e.a kNL;
    private int mSkinType;
    private int mState;

    public StateSwitchView(Context context) {
        super(context);
        this.cRf = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cRf = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cRf = false;
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
        bnh();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void aYl() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        bnh();
        cTz();
    }

    private void bnh() {
        if (this.mState == 1) {
            setText(this.kNH);
        } else {
            setText(this.kNG);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        bnh();
        cTz();
    }

    public void setStateString(String str, String str2) {
        this.kNG = str;
        this.kNH = str2;
        bnh();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.kNI = i;
        this.kNJ = i2;
        this.cRf = false;
        cTz();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.e.a aVar, com.baidu.tbadk.core.util.e.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.cRf = true;
            this.kNK = aVar;
            this.kNL = aVar2;
            cTz();
        }
    }

    private void cTz() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.cRf && this.kNL != null) {
                drawable2 = this.kNL.getDrawable();
            } else {
                drawable2 = this.kNJ > 0 ? am.getDrawable(this.kNJ) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.cRf && this.kNK != null) {
                drawable = this.kNK.getDrawable();
            } else {
                drawable = this.kNJ > 0 ? am.getDrawable(this.kNI) : null;
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
        if (this.iMh != null) {
            this.iMh.xg();
        }
    }

    public void setBackgroundId(int i) {
        this.dbk = i;
        if (this.dbk > 0) {
            am.setBackgroundResource(this, this.dbk);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            am.setViewTextColor(this, (int) R.color.cp_cont_f);
            if (this.dbk > 0) {
                am.setBackgroundResource(this, this.dbk);
            }
            cTz();
            this.mSkinType = i;
        }
    }
}
