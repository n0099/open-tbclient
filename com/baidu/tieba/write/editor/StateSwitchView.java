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
    private int bQg;
    private d hvB;
    private String joS;
    private String joT;
    private int joU;
    private int joV;
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
        aLb();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void aSm() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        aLb();
        cpy();
    }

    private void aLb() {
        if (this.mState == 1) {
            setText(this.joT);
        } else {
            setText(this.joS);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        aLb();
        cpy();
    }

    public void setStateString(String str, String str2) {
        this.joS = str;
        this.joT = str2;
        aLb();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.joU = i;
        this.joV = i2;
        cpy();
    }

    private void cpy() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds48);
        if (this.mState == 1 && this.joV > 0) {
            Drawable drawable = al.getDrawable(this.joV);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        } else if (this.mState == 0 && this.joU > 0) {
            Drawable drawable2 = al.getDrawable(this.joU);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void hideTip() {
        if (this.hvB != null) {
            this.hvB.aSr();
        }
    }

    public void setBackgroundId(int i) {
        this.bQg = i;
        if (this.bQg > 0) {
            al.k(this, this.bQg);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            al.j(this, d.C0277d.cp_cont_f);
            if (this.bQg > 0) {
                al.k(this, this.bQg);
            }
            cpy();
            this.mSkinType = i;
        }
    }
}
