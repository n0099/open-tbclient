package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes7.dex */
public class StateSwitchView extends EditorInfoView {
    private boolean eWy;
    private int fiq;
    private int mSkinType;
    private int mState;
    private String oip;
    private String oiq;
    private int oir;
    private int ois;
    private com.baidu.tbadk.core.util.e.a oit;
    private com.baidu.tbadk.core.util.e.a oiu;

    public StateSwitchView(Context context) {
        super(context);
        this.eWy = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eWy = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eWy = false;
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
        XQ();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    private void XQ() {
        if (this.mState == 1) {
            setText(this.oiq);
        } else {
            setText(this.oip);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        XQ();
        dXw();
    }

    public void setStateString(String str, String str2) {
        this.oip = str;
        this.oiq = str2;
        XQ();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.oir = i;
        this.ois = i2;
        this.eWy = false;
        dXw();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.e.a aVar, com.baidu.tbadk.core.util.e.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.eWy = true;
            this.oit = aVar;
            this.oiu = aVar2;
            dXw();
        }
    }

    private void dXw() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.eWy && this.oiu != null) {
                drawable2 = this.oiu.getDrawable();
            } else {
                drawable2 = this.ois > 0 ? ap.getDrawable(this.ois) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.eWy && this.oit != null) {
                drawable = this.oit.getDrawable();
            } else {
                drawable = this.ois > 0 ? ap.getDrawable(this.oir) : null;
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
        this.fiq = i;
        if (this.fiq > 0) {
            ap.setBackgroundResource(this, this.fiq);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            ap.setViewTextColor(this, R.color.CAM_X0106);
            if (this.fiq > 0) {
                ap.setBackgroundResource(this, this.fiq);
            }
            dXw();
            this.mSkinType = i;
        }
    }
}
