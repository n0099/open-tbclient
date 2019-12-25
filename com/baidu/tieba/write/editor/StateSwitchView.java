package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.c.d;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes10.dex */
public class StateSwitchView extends EditorInfoView {
    private boolean cQV;
    private int daZ;
    private d iID;
    private String kKa;
    private String kKb;
    private int kKc;
    private int kKd;
    private com.baidu.tbadk.core.util.e.a kKe;
    private com.baidu.tbadk.core.util.e.a kKf;
    private int mSkinType;
    private int mState;

    public StateSwitchView(Context context) {
        super(context);
        this.cQV = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cQV = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cQV = false;
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
        bmj();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void aXR() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        bmj();
        cSu();
    }

    private void bmj() {
        if (this.mState == 1) {
            setText(this.kKb);
        } else {
            setText(this.kKa);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        bmj();
        cSu();
    }

    public void setStateString(String str, String str2) {
        this.kKa = str;
        this.kKb = str2;
        bmj();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.kKc = i;
        this.kKd = i2;
        this.cQV = false;
        cSu();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.e.a aVar, com.baidu.tbadk.core.util.e.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.cQV = true;
            this.kKe = aVar;
            this.kKf = aVar2;
            cSu();
        }
    }

    private void cSu() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.cQV && this.kKf != null) {
                drawable2 = this.kKf.getDrawable();
            } else {
                drawable2 = this.kKd > 0 ? am.getDrawable(this.kKd) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.cQV && this.kKe != null) {
                drawable = this.kKe.getDrawable();
            } else {
                drawable = this.kKd > 0 ? am.getDrawable(this.kKc) : null;
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
        if (this.iID != null) {
            this.iID.wP();
        }
    }

    public void setBackgroundId(int i) {
        this.daZ = i;
        if (this.daZ > 0) {
            am.setBackgroundResource(this, this.daZ);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            am.setViewTextColor(this, (int) R.color.cp_cont_f);
            if (this.daZ > 0) {
                am.setBackgroundResource(this, this.daZ);
            }
            cSu();
            this.mSkinType = i;
        }
    }
}
