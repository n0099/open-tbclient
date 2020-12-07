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
    private boolean eNy;
    private int eZF;
    private int mSkinType;
    private int mState;
    private String nWG;
    private String nWH;
    private int nWI;
    private int nWJ;
    private com.baidu.tbadk.core.util.d.a nWK;
    private com.baidu.tbadk.core.util.d.a nWL;

    public StateSwitchView(Context context) {
        super(context);
        this.eNy = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eNy = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eNy = false;
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
        ciM();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void bhC() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        ciM();
        dZb();
    }

    private void ciM() {
        if (this.mState == 1) {
            setText(this.nWH);
        } else {
            setText(this.nWG);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        ciM();
        dZb();
    }

    public void setStateString(String str, String str2) {
        this.nWG = str;
        this.nWH = str2;
        ciM();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.nWI = i;
        this.nWJ = i2;
        this.eNy = false;
        dZb();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.eNy = true;
            this.nWK = aVar;
            this.nWL = aVar2;
            dZb();
        }
    }

    private void dZb() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.eNy && this.nWL != null) {
                drawable2 = this.nWL.getDrawable();
            } else {
                drawable2 = this.nWJ > 0 ? ap.getDrawable(this.nWJ) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.eNy && this.nWK != null) {
                drawable = this.nWK.getDrawable();
            } else {
                drawable = this.nWJ > 0 ? ap.getDrawable(this.nWI) : null;
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
        this.eZF = i;
        if (this.eZF > 0) {
            ap.setBackgroundResource(this, this.eZF);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            ap.setViewTextColor(this, R.color.CAM_X0106);
            if (this.eZF > 0) {
                ap.setBackgroundResource(this, this.eZF);
            }
            dZb();
            this.mSkinType = i;
        }
    }
}
