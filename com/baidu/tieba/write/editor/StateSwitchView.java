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
    private boolean cVj;
    private int dfD;
    private d iNP;
    private String kOA;
    private String kOB;
    private int kOC;
    private int kOD;
    private com.baidu.tbadk.core.util.d.a kOE;
    private com.baidu.tbadk.core.util.d.a kOF;
    private int mSkinType;
    private int mState;

    public StateSwitchView(Context context) {
        super(context);
        this.cVj = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cVj = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cVj = false;
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
        boU();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void baD() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        boU();
        cUQ();
    }

    private void boU() {
        if (this.mState == 1) {
            setText(this.kOB);
        } else {
            setText(this.kOA);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        boU();
        cUQ();
    }

    public void setStateString(String str, String str2) {
        this.kOA = str;
        this.kOB = str2;
        boU();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.kOC = i;
        this.kOD = i2;
        this.cVj = false;
        cUQ();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.cVj = true;
            this.kOE = aVar;
            this.kOF = aVar2;
            cUQ();
        }
    }

    private void cUQ() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.cVj && this.kOF != null) {
                drawable2 = this.kOF.getDrawable();
            } else {
                drawable2 = this.kOD > 0 ? am.getDrawable(this.kOD) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.cVj && this.kOE != null) {
                drawable = this.kOE.getDrawable();
            } else {
                drawable = this.kOD > 0 ? am.getDrawable(this.kOC) : null;
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
        if (this.iNP != null) {
            this.iNP.zz();
        }
    }

    public void setBackgroundId(int i) {
        this.dfD = i;
        if (this.dfD > 0) {
            am.setBackgroundResource(this, this.dfD);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            am.setViewTextColor(this, (int) R.color.cp_cont_f);
            if (this.dfD > 0) {
                am.setBackgroundResource(this, this.dfD);
            }
            cUQ();
            this.mSkinType = i;
        }
    }
}
