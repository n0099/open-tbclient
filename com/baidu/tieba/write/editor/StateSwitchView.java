package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.c.d;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes13.dex */
public class StateSwitchView extends EditorInfoView {
    private boolean cVw;
    private int dfQ;
    private d iPq;
    private String kQk;
    private String kQl;
    private int kQm;
    private int kQn;
    private com.baidu.tbadk.core.util.d.a kQo;
    private com.baidu.tbadk.core.util.d.a kQp;
    private int mSkinType;
    private int mState;

    public StateSwitchView(Context context) {
        super(context);
        this.cVw = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cVw = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cVw = false;
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
        boZ();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void baH() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        boZ();
        cVl();
    }

    private void boZ() {
        if (this.mState == 1) {
            setText(this.kQl);
        } else {
            setText(this.kQk);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        boZ();
        cVl();
    }

    public void setStateString(String str, String str2) {
        this.kQk = str;
        this.kQl = str2;
        boZ();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.kQm = i;
        this.kQn = i2;
        this.cVw = false;
        cVl();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.cVw = true;
            this.kQo = aVar;
            this.kQp = aVar2;
            cVl();
        }
    }

    private void cVl() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.cVw && this.kQp != null) {
                drawable2 = this.kQp.getDrawable();
            } else {
                drawable2 = this.kQn > 0 ? am.getDrawable(this.kQn) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.cVw && this.kQo != null) {
                drawable = this.kQo.getDrawable();
            } else {
                drawable = this.kQn > 0 ? am.getDrawable(this.kQm) : null;
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
        if (this.iPq != null) {
            this.iPq.zG();
        }
    }

    public void setBackgroundId(int i) {
        this.dfQ = i;
        if (this.dfQ > 0) {
            am.setBackgroundResource(this, this.dfQ);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            am.setViewTextColor(this, (int) R.color.cp_cont_f);
            if (this.dfQ > 0) {
                am.setBackgroundResource(this, this.dfQ);
            }
            cVl();
            this.mSkinType = i;
        }
    }
}
