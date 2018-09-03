package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.c.d;
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes3.dex */
public class StateSwitchView extends EditorInfoView {
    private int avk;
    private d fEb;
    private String hvM;
    private String hvN;
    private int hvO;
    private int hvP;
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
        int dimension = (int) getResources().getDimension(f.e.ds26);
        setPadding(dimension, 0, dimension, 0);
        adr();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void akJ() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        adr();
        bGz();
    }

    private void adr() {
        if (this.mState == 1) {
            setText(this.hvN);
        } else {
            setText(this.hvM);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        adr();
        bGz();
    }

    public void setStateString(String str, String str2) {
        this.hvM = str;
        this.hvN = str2;
        adr();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.hvO = i;
        this.hvP = i2;
        bGz();
    }

    private void bGz() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(f.e.ds48);
        if (this.mState == 1 && this.hvP > 0) {
            Drawable drawable = am.getDrawable(this.hvP);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(f.e.ds8));
        } else if (this.mState == 0 && this.hvO > 0) {
            Drawable drawable2 = am.getDrawable(this.hvO);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(f.e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void hideTip() {
        if (this.fEb != null) {
            this.fEb.akO();
        }
    }

    public void setBackgroundId(int i) {
        this.avk = i;
        if (this.avk > 0) {
            am.i(this, this.avk);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            am.h(this, f.d.cp_cont_f);
            if (this.avk > 0) {
                am.i(this, this.avk);
            }
            bGz();
            this.mSkinType = i;
        }
    }
}
