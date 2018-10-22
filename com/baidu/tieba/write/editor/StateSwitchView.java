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
    private d fTn;
    private String hKV;
    private String hKW;
    private int hKX;
    private int hKY;
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
        aiK();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void apU() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        aiK();
        bMB();
    }

    private void aiK() {
        if (this.mState == 1) {
            setText(this.hKW);
        } else {
            setText(this.hKV);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        aiK();
        bMB();
    }

    public void setStateString(String str, String str2) {
        this.hKV = str;
        this.hKW = str2;
        aiK();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.hKX = i;
        this.hKY = i2;
        bMB();
    }

    private void bMB() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0175e.ds48);
        if (this.mState == 1 && this.hKY > 0) {
            Drawable drawable = al.getDrawable(this.hKY);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(e.C0175e.ds8));
        } else if (this.mState == 0 && this.hKX > 0) {
            Drawable drawable2 = al.getDrawable(this.hKX);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(e.C0175e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void hideTip() {
        if (this.fTn != null) {
            this.fTn.apZ();
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
