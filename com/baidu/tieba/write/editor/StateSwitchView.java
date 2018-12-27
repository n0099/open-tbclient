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
    private int aHw;
    private d gev;
    private String hXb;
    private String hXc;
    private int hXd;
    private int hXe;
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
        ajJ();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void arW() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        ajJ();
        bOW();
    }

    private void ajJ() {
        if (this.mState == 1) {
            setText(this.hXc);
        } else {
            setText(this.hXb);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        ajJ();
        bOW();
    }

    public void setStateString(String str, String str2) {
        this.hXb = str;
        this.hXc = str2;
        ajJ();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.hXd = i;
        this.hXe = i2;
        bOW();
    }

    private void bOW() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds48);
        if (this.mState == 1 && this.hXe > 0) {
            Drawable drawable = al.getDrawable(this.hXe);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(e.C0210e.ds8));
        } else if (this.mState == 0 && this.hXd > 0) {
            Drawable drawable2 = al.getDrawable(this.hXd);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(e.C0210e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void hideTip() {
        if (this.gev != null) {
            this.gev.asb();
        }
    }

    public void setBackgroundId(int i) {
        this.aHw = i;
        if (this.aHw > 0) {
            al.i(this, this.aHw);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            al.h(this, e.d.cp_cont_f);
            if (this.aHw > 0) {
                al.i(this, this.aHw);
            }
            bOW();
            this.mSkinType = i;
        }
    }
}
