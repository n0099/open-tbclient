package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.c.d;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes3.dex */
public class StateSwitchView extends EditorInfoView {
    private int aHv;
    private d gbC;
    private String hTQ;
    private String hTR;
    private int hTS;
    private int hTT;
    private int mSkinType;
    private int mState;

    public StateSwitchView(Context context) {
        super(context);
        this.mSkinType = 3;
        init();
    }

    private void init() {
        initData();
        initUI();
    }

    private void initUI() {
        int dimension = (int) getResources().getDimension(e.C0210e.ds26);
        setPadding(dimension, 0, dimension, 0);
        ajs();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void arh() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        ajs();
        bOf();
    }

    private void ajs() {
        if (this.mState == 1) {
            setText(this.hTR);
        } else {
            setText(this.hTQ);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        ajs();
        bOf();
    }

    public void setStateString(String str, String str2) {
        this.hTQ = str;
        this.hTR = str2;
        ajs();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.hTS = i;
        this.hTT = i2;
        bOf();
    }

    private void bOf() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds48);
        if (this.mState == 1 && this.hTT > 0) {
            Drawable drawable = al.getDrawable(this.hTT);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(e.C0210e.ds8));
        } else if (this.mState == 0 && this.hTS > 0) {
            Drawable drawable2 = al.getDrawable(this.hTS);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(e.C0210e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void hideTip() {
        if (this.gbC != null) {
            this.gbC.arm();
        }
    }

    public void setBackgroundId(int i) {
        this.aHv = i;
        if (this.aHv > 0) {
            al.i(this, this.aHv);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            al.h(this, e.d.cp_cont_f);
            if (this.aHv > 0) {
                al.i(this, this.aHv);
            }
            bOf();
            this.mSkinType = i;
        }
    }
}
