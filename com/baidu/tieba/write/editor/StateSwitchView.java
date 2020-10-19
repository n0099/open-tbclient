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
    private int eEX;
    private boolean etP;
    private int mSkinType;
    private int mState;
    private String noG;
    private String noH;
    private int noI;
    private int noJ;
    private com.baidu.tbadk.core.util.d.a noK;
    private com.baidu.tbadk.core.util.d.a noL;

    public StateSwitchView(Context context) {
        super(context);
        this.etP = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.etP = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.etP = false;
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
        bZS();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void baL() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        bZS();
        dOa();
    }

    private void bZS() {
        if (this.mState == 1) {
            setText(this.noH);
        } else {
            setText(this.noG);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        bZS();
        dOa();
    }

    public void setStateString(String str, String str2) {
        this.noG = str;
        this.noH = str2;
        bZS();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.noI = i;
        this.noJ = i2;
        this.etP = false;
        dOa();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.etP = true;
            this.noK = aVar;
            this.noL = aVar2;
            dOa();
        }
    }

    private void dOa() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.etP && this.noL != null) {
                drawable2 = this.noL.getDrawable();
            } else {
                drawable2 = this.noJ > 0 ? ap.getDrawable(this.noJ) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.etP && this.noK != null) {
                drawable = this.noK.getDrawable();
            } else {
                drawable = this.noJ > 0 ? ap.getDrawable(this.noI) : null;
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
        this.eEX = i;
        if (this.eEX > 0) {
            ap.setBackgroundResource(this, this.eEX);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            ap.setViewTextColor(this, R.color.cp_cont_f);
            if (this.eEX > 0) {
                ap.setBackgroundResource(this, this.eEX);
            }
            dOa();
            this.mSkinType = i;
        }
    }
}
