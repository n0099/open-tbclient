package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.c.d;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes3.dex */
public class StateSwitchView extends EditorInfoView {
    private boolean bOh;
    private int bZZ;
    private d hWb;
    private String jSs;
    private String jSt;
    private int jSu;
    private int jSv;
    private com.baidu.tbadk.core.util.f.a jSw;
    private com.baidu.tbadk.core.util.f.a jSx;
    private int mSkinType;
    private int mState;

    public StateSwitchView(Context context) {
        super(context);
        this.bOh = false;
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
        aTz();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void aHw() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        aTz();
        cBK();
    }

    private void aTz() {
        if (this.mState == 1) {
            setText(this.jSt);
        } else {
            setText(this.jSs);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        aTz();
        cBK();
    }

    public void setStateString(String str, String str2) {
        this.jSs = str;
        this.jSt = str2;
        aTz();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.jSu = i;
        this.jSv = i2;
        this.bOh = false;
        cBK();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.f.a aVar, com.baidu.tbadk.core.util.f.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.bOh = true;
            this.jSw = aVar;
            this.jSx = aVar2;
            cBK();
        }
    }

    private void cBK() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.bOh && this.jSx != null) {
                drawable2 = this.jSx.getDrawable();
            } else {
                drawable2 = this.jSv > 0 ? am.getDrawable(this.jSv) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.bOh && this.jSw != null) {
                drawable = this.jSw.getDrawable();
            } else {
                drawable = this.jSv > 0 ? am.getDrawable(this.jSu) : null;
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
        if (this.hWb != null) {
            this.hWb.bcf();
        }
    }

    public void setBackgroundId(int i) {
        this.bZZ = i;
        if (this.bZZ > 0) {
            am.k(this, this.bZZ);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            am.j(this, R.color.cp_cont_f);
            if (this.bZZ > 0) {
                am.k(this, this.bZZ);
            }
            cBK();
            this.mSkinType = i;
        }
    }
}
