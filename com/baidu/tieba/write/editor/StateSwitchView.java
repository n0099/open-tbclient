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
    private boolean eCo;
    private int eNt;
    private int mSkinType;
    private int mState;
    private String nBf;
    private String nBg;
    private int nBh;
    private int nBi;
    private com.baidu.tbadk.core.util.d.a nBj;
    private com.baidu.tbadk.core.util.d.a nBk;

    public StateSwitchView(Context context) {
        super(context);
        this.eCo = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eCo = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eCo = false;
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
        ccW();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void bcE() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        ccW();
        dRi();
    }

    private void ccW() {
        if (this.mState == 1) {
            setText(this.nBg);
        } else {
            setText(this.nBf);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        ccW();
        dRi();
    }

    public void setStateString(String str, String str2) {
        this.nBf = str;
        this.nBg = str2;
        ccW();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.nBh = i;
        this.nBi = i2;
        this.eCo = false;
        dRi();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.eCo = true;
            this.nBj = aVar;
            this.nBk = aVar2;
            dRi();
        }
    }

    private void dRi() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.eCo && this.nBk != null) {
                drawable2 = this.nBk.getDrawable();
            } else {
                drawable2 = this.nBi > 0 ? ap.getDrawable(this.nBi) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.eCo && this.nBj != null) {
                drawable = this.nBj.getDrawable();
            } else {
                drawable = this.nBi > 0 ? ap.getDrawable(this.nBh) : null;
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
        this.eNt = i;
        if (this.eNt > 0) {
            ap.setBackgroundResource(this, this.eNt);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            ap.setViewTextColor(this, R.color.cp_cont_f);
            if (this.eNt > 0) {
                ap.setBackgroundResource(this, this.eNt);
            }
            dRi();
            this.mSkinType = i;
        }
    }
}
