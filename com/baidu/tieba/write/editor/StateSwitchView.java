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
    private boolean efs;
    private int eqH;
    private String mPj;
    private String mPk;
    private int mPl;
    private int mPo;
    private com.baidu.tbadk.core.util.d.a mPp;
    private com.baidu.tbadk.core.util.d.a mPq;
    private int mSkinType;
    private int mState;

    public StateSwitchView(Context context) {
        super(context);
        this.efs = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.efs = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.efs = false;
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
        bUN();
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
        bUN();
        dGu();
    }

    private void bUN() {
        if (this.mState == 1) {
            setText(this.mPk);
        } else {
            setText(this.mPj);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        bUN();
        dGu();
    }

    public void setStateString(String str, String str2) {
        this.mPj = str;
        this.mPk = str2;
        bUN();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.mPl = i;
        this.mPo = i2;
        this.efs = false;
        dGu();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.efs = true;
            this.mPp = aVar;
            this.mPq = aVar2;
            dGu();
        }
    }

    private void dGu() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.efs && this.mPq != null) {
                drawable2 = this.mPq.getDrawable();
            } else {
                drawable2 = this.mPo > 0 ? ap.getDrawable(this.mPo) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.efs && this.mPp != null) {
                drawable = this.mPp.getDrawable();
            } else {
                drawable = this.mPo > 0 ? ap.getDrawable(this.mPl) : null;
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
        this.eqH = i;
        if (this.eqH > 0) {
            ap.setBackgroundResource(this, this.eqH);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            ap.setViewTextColor(this, R.color.cp_cont_f);
            if (this.eqH > 0) {
                ap.setBackgroundResource(this, this.eqH);
            }
            dGu();
            this.mSkinType = i;
        }
    }
}
