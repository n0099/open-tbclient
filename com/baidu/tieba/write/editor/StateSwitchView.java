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
    private int aDV;
    private d fUM;
    private String hMF;
    private String hMG;
    private int hMH;
    private int hMI;
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
        int dimension = (int) getResources().getDimension(e.C0200e.ds26);
        setPadding(dimension, 0, dimension, 0);
        aik();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void apv() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        aik();
        bMa();
    }

    private void aik() {
        if (this.mState == 1) {
            setText(this.hMG);
        } else {
            setText(this.hMF);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        aik();
        bMa();
    }

    public void setStateString(String str, String str2) {
        this.hMF = str;
        this.hMG = str2;
        aik();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.hMH = i;
        this.hMI = i2;
        bMa();
    }

    private void bMa() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0200e.ds48);
        if (this.mState == 1 && this.hMI > 0) {
            Drawable drawable = al.getDrawable(this.hMI);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(e.C0200e.ds8));
        } else if (this.mState == 0 && this.hMH > 0) {
            Drawable drawable2 = al.getDrawable(this.hMH);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(e.C0200e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void hideTip() {
        if (this.fUM != null) {
            this.fUM.apA();
        }
    }

    public void setBackgroundId(int i) {
        this.aDV = i;
        if (this.aDV > 0) {
            al.i(this, this.aDV);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            al.h(this, e.d.cp_cont_f);
            if (this.aDV > 0) {
                al.i(this, this.aDV);
            }
            bMa();
            this.mSkinType = i;
        }
    }
}
