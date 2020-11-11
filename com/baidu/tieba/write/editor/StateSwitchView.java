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
    private boolean eId;
    private int eTi;
    private int mSkinType;
    private int mState;
    private String nGZ;
    private String nHa;
    private int nHb;
    private int nHc;
    private com.baidu.tbadk.core.util.d.a nHd;
    private com.baidu.tbadk.core.util.d.a nHe;

    public StateSwitchView(Context context) {
        super(context);
        this.eId = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eId = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eId = false;
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
        cfx();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void bfe() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        cfx();
        dTI();
    }

    private void cfx() {
        if (this.mState == 1) {
            setText(this.nHa);
        } else {
            setText(this.nGZ);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        cfx();
        dTI();
    }

    public void setStateString(String str, String str2) {
        this.nGZ = str;
        this.nHa = str2;
        cfx();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.nHb = i;
        this.nHc = i2;
        this.eId = false;
        dTI();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.eId = true;
            this.nHd = aVar;
            this.nHe = aVar2;
            dTI();
        }
    }

    private void dTI() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.eId && this.nHe != null) {
                drawable2 = this.nHe.getDrawable();
            } else {
                drawable2 = this.nHc > 0 ? ap.getDrawable(this.nHc) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.eId && this.nHd != null) {
                drawable = this.nHd.getDrawable();
            } else {
                drawable = this.nHc > 0 ? ap.getDrawable(this.nHb) : null;
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
        this.eTi = i;
        if (this.eTi > 0) {
            ap.setBackgroundResource(this, this.eTi);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            ap.setViewTextColor(this, R.color.cp_cont_f);
            if (this.eTi > 0) {
                ap.setBackgroundResource(this, this.eTi);
            }
            dTI();
            this.mSkinType = i;
        }
    }
}
