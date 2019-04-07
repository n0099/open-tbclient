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
    private int bQi;
    private d hvo;
    private String joH;
    private String joI;
    private int joJ;
    private int joK;
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
            setText(this.joI);
        } else {
            setText(this.joH);
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
        this.joH = str;
        this.joI = str2;
        aKQ();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.joJ = i;
        this.joK = i2;
        cpw();
    }

    private void cpw() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds48);
        if (this.mState == 1 && this.joK > 0) {
            Drawable drawable = al.getDrawable(this.joK);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        } else if (this.mState == 0 && this.joJ > 0) {
            Drawable drawable2 = al.getDrawable(this.joJ);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void hideTip() {
        if (this.hvo != null) {
            this.hvo.aSp();
        }
    }

    public void setBackgroundId(int i) {
        this.bQi = i;
        if (this.bQi > 0) {
            al.k(this, this.bQi);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            al.j(this, d.C0277d.cp_cont_f);
            if (this.bQi > 0) {
                al.k(this, this.bQi);
            }
            cpw();
            this.mSkinType = i;
        }
    }
}
