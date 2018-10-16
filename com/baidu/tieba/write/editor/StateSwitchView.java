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
    private int aDf;
    private d fTm;
    private String hKU;
    private String hKV;
    private int hKW;
    private int hKX;
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
        int dimension = (int) getResources().getDimension(e.C0175e.ds26);
        setPadding(dimension, 0, dimension, 0);
        aiJ();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void apT() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        aiJ();
        bMB();
    }

    private void aiJ() {
        if (this.mState == 1) {
            setText(this.hKV);
        } else {
            setText(this.hKU);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        aiJ();
        bMB();
    }

    public void setStateString(String str, String str2) {
        this.hKU = str;
        this.hKV = str2;
        aiJ();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.hKW = i;
        this.hKX = i2;
        bMB();
    }

    private void bMB() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0175e.ds48);
        if (this.mState == 1 && this.hKX > 0) {
            Drawable drawable = al.getDrawable(this.hKX);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(e.C0175e.ds8));
        } else if (this.mState == 0 && this.hKW > 0) {
            Drawable drawable2 = al.getDrawable(this.hKW);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(e.C0175e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void hideTip() {
        if (this.fTm != null) {
            this.fTm.apY();
        }
    }

    public void setBackgroundId(int i) {
        this.aDf = i;
        if (this.aDf > 0) {
            al.i(this, this.aDf);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            al.h(this, e.d.cp_cont_f);
            if (this.aDf > 0) {
                al.i(this, this.aDf);
            }
            bMB();
            this.mSkinType = i;
        }
    }
}
