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
    private boolean cev;
    private int cnN;
    private d hTS;
    private String jPn;
    private String jPo;
    private int jPp;
    private int jPq;
    private com.baidu.tbadk.core.util.f.a jPr;
    private com.baidu.tbadk.core.util.f.a jPs;
    private int mSkinType;
    private int mState;

    public StateSwitchView(Context context) {
        super(context);
        this.cev = false;
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
        aUs();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void aHH() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        aUs();
        cys();
    }

    private void aUs() {
        if (this.mState == 1) {
            setText(this.jPo);
        } else {
            setText(this.jPn);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        aUs();
        cys();
    }

    public void setStateString(String str, String str2) {
        this.jPn = str;
        this.jPo = str2;
        aUs();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.jPp = i;
        this.jPq = i2;
        this.cev = false;
        cys();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.f.a aVar, com.baidu.tbadk.core.util.f.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.cev = true;
            this.jPr = aVar;
            this.jPs = aVar2;
            cys();
        }
    }

    private void cys() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.cev && this.jPs != null) {
                drawable2 = this.jPs.getDrawable();
            } else {
                drawable2 = this.jPq > 0 ? am.getDrawable(this.jPq) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.cev && this.jPr != null) {
                drawable = this.jPr.getDrawable();
            } else {
                drawable = this.jPq > 0 ? am.getDrawable(this.jPp) : null;
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
        if (this.hTS != null) {
            this.hTS.uQ();
        }
    }

    public void setBackgroundId(int i) {
        this.cnN = i;
        if (this.cnN > 0) {
            am.setBackgroundResource(this, this.cnN);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            am.setViewTextColor(this, (int) R.color.cp_cont_f);
            if (this.cnN > 0) {
                am.setBackgroundResource(this, this.cnN);
            }
            cys();
            this.mSkinType = i;
        }
    }
}
