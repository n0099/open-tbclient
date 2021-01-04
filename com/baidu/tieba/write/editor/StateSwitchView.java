package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes8.dex */
public class StateSwitchView extends EditorInfoView {
    private boolean eXv;
    private int fjk;
    private int mSkinType;
    private int mState;
    private String oai;
    private String oaj;
    private int oak;
    private int oal;
    private com.baidu.tbadk.core.util.e.a oam;
    private com.baidu.tbadk.core.util.e.a oan;

    public StateSwitchView(Context context) {
        super(context);
        this.eXv = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eXv = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eXv = false;
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
        ZW();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    private void ZW() {
        if (this.mState == 1) {
            setText(this.oaj);
        } else {
            setText(this.oai);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        ZW();
        dYJ();
    }

    public void setStateString(String str, String str2) {
        this.oai = str;
        this.oaj = str2;
        ZW();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.oak = i;
        this.oal = i2;
        this.eXv = false;
        dYJ();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.e.a aVar, com.baidu.tbadk.core.util.e.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.eXv = true;
            this.oam = aVar;
            this.oan = aVar2;
            dYJ();
        }
    }

    private void dYJ() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.eXv && this.oan != null) {
                drawable2 = this.oan.getDrawable();
            } else {
                drawable2 = this.oal > 0 ? ao.getDrawable(this.oal) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.eXv && this.oam != null) {
                drawable = this.oam.getDrawable();
            } else {
                drawable = this.oal > 0 ? ao.getDrawable(this.oak) : null;
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
        this.fjk = i;
        if (this.fjk > 0) {
            ao.setBackgroundResource(this, this.fjk);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            ao.setViewTextColor(this, R.color.CAM_X0106);
            if (this.fjk > 0) {
                ao.setBackgroundResource(this, this.fjk);
            }
            dYJ();
            this.mSkinType = i;
        }
    }
}
