package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.c.d;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes3.dex */
public class StateSwitchView extends EditorInfoView {
    private int bQf;
    private d hvI;
    private String jpa;
    private String jpb;
    private int jpc;
    private int jpd;
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
        aLc();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void aSn() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        aLc();
        cpv();
    }

    private void aLc() {
        if (this.mState == 1) {
            setText(this.jpb);
        } else {
            setText(this.jpa);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        aLc();
        cpv();
    }

    public void setStateString(String str, String str2) {
        this.jpa = str;
        this.jpb = str2;
        aLc();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.jpc = i;
        this.jpd = i2;
        cpv();
    }

    private void cpv() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds48);
        if (this.mState == 1 && this.jpd > 0) {
            Drawable drawable = al.getDrawable(this.jpd);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        } else if (this.mState == 0 && this.jpc > 0) {
            Drawable drawable2 = al.getDrawable(this.jpc);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void hideTip() {
        if (this.hvI != null) {
            this.hvI.aSs();
        }
    }

    public void setBackgroundId(int i) {
        this.bQf = i;
        if (this.bQf > 0) {
            al.k(this, this.bQf);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            al.j(this, d.C0236d.cp_cont_f);
            if (this.bQf > 0) {
                al.k(this, this.bQf);
            }
            cpv();
            this.mSkinType = i;
        }
    }
}
