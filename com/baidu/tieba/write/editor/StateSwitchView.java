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
    private boolean efo;
    private int eqD;
    private String mOR;
    private String mOS;
    private int mOT;
    private int mOU;
    private com.baidu.tbadk.core.util.d.a mOV;
    private com.baidu.tbadk.core.util.d.a mOW;
    private int mSkinType;
    private int mState;

    public StateSwitchView(Context context) {
        super(context);
        this.efo = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.efo = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.efo = false;
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
        bUM();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void aXr() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        bUM();
        dGl();
    }

    private void bUM() {
        if (this.mState == 1) {
            setText(this.mOS);
        } else {
            setText(this.mOR);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        bUM();
        dGl();
    }

    public void setStateString(String str, String str2) {
        this.mOR = str;
        this.mOS = str2;
        bUM();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.mOT = i;
        this.mOU = i2;
        this.efo = false;
        dGl();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.efo = true;
            this.mOV = aVar;
            this.mOW = aVar2;
            dGl();
        }
    }

    private void dGl() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.efo && this.mOW != null) {
                drawable2 = this.mOW.getDrawable();
            } else {
                drawable2 = this.mOU > 0 ? ap.getDrawable(this.mOU) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.efo && this.mOV != null) {
                drawable = this.mOV.getDrawable();
            } else {
                drawable = this.mOU > 0 ? ap.getDrawable(this.mOT) : null;
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
        this.eqD = i;
        if (this.eqD > 0) {
            ap.setBackgroundResource(this, this.eqD);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            ap.setViewTextColor(this, R.color.cp_cont_f);
            if (this.eqD > 0) {
                ap.setBackgroundResource(this, this.eqD);
            }
            dGl();
            this.mSkinType = i;
        }
    }
}
