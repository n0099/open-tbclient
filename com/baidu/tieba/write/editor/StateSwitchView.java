package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes8.dex */
public class StateSwitchView extends EditorInfoView {
    private boolean eUZ;
    private int fgP;
    private int mSkinType;
    private int mState;
    private String ofK;
    private String ofL;
    private int ofM;
    private int ofN;
    private com.baidu.tbadk.core.util.e.a ofO;
    private com.baidu.tbadk.core.util.e.a ofP;

    public StateSwitchView(Context context) {
        super(context);
        this.eUZ = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eUZ = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eUZ = false;
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
        XN();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    private void XN() {
        if (this.mState == 1) {
            setText(this.ofL);
        } else {
            setText(this.ofK);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        XN();
        dXg();
    }

    public void setStateString(String str, String str2) {
        this.ofK = str;
        this.ofL = str2;
        XN();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.ofM = i;
        this.ofN = i2;
        this.eUZ = false;
        dXg();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.e.a aVar, com.baidu.tbadk.core.util.e.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.eUZ = true;
            this.ofO = aVar;
            this.ofP = aVar2;
            dXg();
        }
    }

    private void dXg() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.eUZ && this.ofP != null) {
                drawable2 = this.ofP.getDrawable();
            } else {
                drawable2 = this.ofN > 0 ? ap.getDrawable(this.ofN) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.eUZ && this.ofO != null) {
                drawable = this.ofO.getDrawable();
            } else {
                drawable = this.ofN > 0 ? ap.getDrawable(this.ofM) : null;
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
        this.fgP = i;
        if (this.fgP > 0) {
            ap.setBackgroundResource(this, this.fgP);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            ap.setViewTextColor(this, R.color.CAM_X0106);
            if (this.fgP > 0) {
                ap.setBackgroundResource(this, this.fgP);
            }
            dXg();
            this.mSkinType = i;
        }
    }
}
