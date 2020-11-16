package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes3.dex */
public class StateSwitchView extends EditorInfoView {
    private boolean eGv;
    private int eSk;
    private int mSkinType;
    private int mState;
    private String nIA;
    private String nIB;
    private int nIC;
    private int nID;
    private com.baidu.tbadk.core.util.d.a nIE;
    private com.baidu.tbadk.core.util.d.a nIF;

    public StateSwitchView(Context context) {
        super(context);
        this.eGv = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eGv = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eGv = false;
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
        ceQ();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void bex() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        ceQ();
        dTH();
    }

    private void ceQ() {
        if (this.mState == 1) {
            setText(this.nIB);
        } else {
            setText(this.nIA);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        ceQ();
        dTH();
    }

    public void setStateString(String str, String str2) {
        this.nIA = str;
        this.nIB = str2;
        ceQ();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.nIC = i;
        this.nID = i2;
        this.eGv = false;
        dTH();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.eGv = true;
            this.nIE = aVar;
            this.nIF = aVar2;
            dTH();
        }
    }

    private void dTH() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.eGv && this.nIF != null) {
                drawable2 = this.nIF.getDrawable();
            } else {
                drawable2 = this.nID > 0 ? ap.getDrawable(this.nID) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.eGv && this.nIE != null) {
                drawable = this.nIE.getDrawable();
            } else {
                drawable = this.nID > 0 ? ap.getDrawable(this.nIC) : null;
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
        this.eSk = i;
        if (this.eSk > 0) {
            ap.setBackgroundResource(this, this.eSk);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            ap.setViewTextColor(this, R.color.CAM_X0106);
            if (this.eSk > 0) {
                ap.setBackgroundResource(this, this.eSk);
            }
            dTH();
            this.mSkinType = i;
        }
    }
}
