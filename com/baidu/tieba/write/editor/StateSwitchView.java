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
    private int bXY;
    private d hMV;
    private String jHO;
    private String jHP;
    private int jHQ;
    private int jHR;
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
        aRe();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void aFu() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        aRe();
        cxC();
    }

    private void aRe() {
        if (this.mState == 1) {
            setText(this.jHP);
        } else {
            setText(this.jHO);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        aRe();
        cxC();
    }

    public void setStateString(String str, String str2) {
        this.jHO = str;
        this.jHP = str2;
        aRe();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.jHQ = i;
        this.jHR = i2;
        cxC();
    }

    private void cxC() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds48);
        if (this.mState == 1 && this.jHR > 0) {
            Drawable drawable = al.getDrawable(this.jHR);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
        } else if (this.mState == 0 && this.jHQ > 0) {
            Drawable drawable2 = al.getDrawable(this.jHQ);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void hideTip() {
        if (this.hMV != null) {
            this.hMV.aZA();
        }
    }

    public void setBackgroundId(int i) {
        this.bXY = i;
        if (this.bXY > 0) {
            al.k(this, this.bXY);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            al.j(this, R.color.cp_cont_f);
            if (this.bXY > 0) {
                al.k(this, this.bXY);
            }
            cxC();
            this.mSkinType = i;
        }
    }
}
