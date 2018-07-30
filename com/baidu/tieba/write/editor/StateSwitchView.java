package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.c.d;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes3.dex */
public class StateSwitchView extends EditorInfoView {
    private int avm;
    private d fEi;
    private String hvK;
    private String hvL;
    private int hvM;
    private int hvN;
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
        int dimension = (int) getResources().getDimension(d.e.ds26);
        setPadding(dimension, 0, dimension, 0);
        adp();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void akH() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        adp();
        bGv();
    }

    private void adp() {
        if (this.mState == 1) {
            setText(this.hvL);
        } else {
            setText(this.hvK);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        adp();
        bGv();
    }

    public void setStateString(String str, String str2) {
        this.hvK = str;
        this.hvL = str2;
        adp();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.hvM = i;
        this.hvN = i2;
        bGv();
    }

    private void bGv() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds48);
        if (this.mState == 1 && this.hvN > 0) {
            Drawable drawable = am.getDrawable(this.hvN);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        } else if (this.mState == 0 && this.hvM > 0) {
            Drawable drawable2 = am.getDrawable(this.hvM);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void hideTip() {
        if (this.fEi != null) {
            this.fEi.akM();
        }
    }

    public void setBackgroundId(int i) {
        this.avm = i;
        if (this.avm > 0) {
            am.i(this, this.avm);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            am.h(this, d.C0140d.cp_cont_f);
            if (this.avm > 0) {
                am.i(this, this.avm);
            }
            bGv();
            this.mSkinType = i;
        }
    }
}
