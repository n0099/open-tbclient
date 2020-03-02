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
    private boolean cVi;
    private int dfq;
    private d iND;
    private String kOo;
    private String kOp;
    private int kOq;
    private int kOr;
    private com.baidu.tbadk.core.util.e.a kOs;
    private com.baidu.tbadk.core.util.e.a kOt;
    private int mSkinType;
    private int mState;

    public StateSwitchView(Context context) {
        super(context);
        this.cVi = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cVi = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cVi = false;
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
        boT();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void baC() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        boT();
        cUP();
    }

    private void boT() {
        if (this.mState == 1) {
            setText(this.kOp);
        } else {
            setText(this.kOo);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        boT();
        cUP();
    }

    public void setStateString(String str, String str2) {
        this.kOo = str;
        this.kOp = str2;
        boT();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.kOq = i;
        this.kOr = i2;
        this.cVi = false;
        cUP();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.e.a aVar, com.baidu.tbadk.core.util.e.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.cVi = true;
            this.kOs = aVar;
            this.kOt = aVar2;
            cUP();
        }
    }

    private void cUP() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.cVi && this.kOt != null) {
                drawable2 = this.kOt.getDrawable();
            } else {
                drawable2 = this.kOr > 0 ? am.getDrawable(this.kOr) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.cVi && this.kOs != null) {
                drawable = this.kOs.getDrawable();
            } else {
                drawable = this.kOr > 0 ? am.getDrawable(this.kOq) : null;
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
        if (this.iND != null) {
            this.iND.zz();
        }
    }

    public void setBackgroundId(int i) {
        this.dfq = i;
        if (this.dfq > 0) {
            am.setBackgroundResource(this, this.dfq);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            am.setViewTextColor(this, (int) R.color.cp_cont_f);
            if (this.dfq > 0) {
                am.setBackgroundResource(this, this.dfq);
            }
            cUP();
            this.mSkinType = i;
        }
    }
}
