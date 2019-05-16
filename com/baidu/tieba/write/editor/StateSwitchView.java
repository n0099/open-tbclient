package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.c.d;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes3.dex */
public class StateSwitchView extends EditorInfoView {
    private int bXX;
    private d hMR;
    private String jHK;
    private String jHL;
    private int jHM;
    private int jHN;
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
        int dimension = (int) getResources().getDimension(R.dimen.ds26);
        setPadding(dimension, 0, dimension, 0);
        aRb();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void aFr() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        aRb();
        cxB();
    }

    private void aRb() {
        if (this.mState == 1) {
            setText(this.jHL);
        } else {
            setText(this.jHK);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        aRb();
        cxB();
    }

    public void setStateString(String str, String str2) {
        this.jHK = str;
        this.jHL = str2;
        aRb();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.jHM = i;
        this.jHN = i2;
        cxB();
    }

    private void cxB() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds48);
        if (this.mState == 1 && this.jHN > 0) {
            Drawable drawable = al.getDrawable(this.jHN);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
        } else if (this.mState == 0 && this.jHM > 0) {
            Drawable drawable2 = al.getDrawable(this.jHM);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void hideTip() {
        if (this.hMR != null) {
            this.hMR.aZx();
        }
    }

    public void setBackgroundId(int i) {
        this.bXX = i;
        if (this.bXX > 0) {
            al.k(this, this.bXX);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            al.j(this, R.color.cp_cont_f);
            if (this.bXX > 0) {
                al.k(this, this.bXX);
            }
            cxB();
            this.mSkinType = i;
        }
    }
}
