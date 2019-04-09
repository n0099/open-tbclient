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
    private int bQj;
    private d hvp;
    private String joI;
    private String joJ;
    private int joK;
    private int joL;
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
        aKQ();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void aSk() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        aKQ();
        cpw();
    }

    private void aKQ() {
        if (this.mState == 1) {
            setText(this.joJ);
        } else {
            setText(this.joI);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        aKQ();
        cpw();
    }

    public void setStateString(String str, String str2) {
        this.joI = str;
        this.joJ = str2;
        aKQ();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.joK = i;
        this.joL = i2;
        cpw();
    }

    private void cpw() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds48);
        if (this.mState == 1 && this.joL > 0) {
            Drawable drawable = al.getDrawable(this.joL);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        } else if (this.mState == 0 && this.joK > 0) {
            Drawable drawable2 = al.getDrawable(this.joK);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void hideTip() {
        if (this.hvp != null) {
            this.hvp.aSp();
        }
    }

    public void setBackgroundId(int i) {
        this.bQj = i;
        if (this.bQj > 0) {
            al.k(this, this.bQj);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            al.j(this, d.C0277d.cp_cont_f);
            if (this.bQj > 0) {
                al.k(this, this.bQj);
            }
            cpw();
            this.mSkinType = i;
        }
    }
}
