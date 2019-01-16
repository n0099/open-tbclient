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
    private int aHY;
    private d gfy;
    private String hYi;
    private String hYj;
    private int hYk;
    private int hYl;
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
        akg();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void asu() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        akg();
        bPE();
    }

    private void akg() {
        if (this.mState == 1) {
            setText(this.hYj);
        } else {
            setText(this.hYi);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        akg();
        bPE();
    }

    public void setStateString(String str, String str2) {
        this.hYi = str;
        this.hYj = str2;
        akg();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.hYk = i;
        this.hYl = i2;
        bPE();
    }

    private void bPE() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds48);
        if (this.mState == 1 && this.hYl > 0) {
            Drawable drawable = al.getDrawable(this.hYl);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(e.C0210e.ds8));
        } else if (this.mState == 0 && this.hYk > 0) {
            Drawable drawable2 = al.getDrawable(this.hYk);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(e.C0210e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void hideTip() {
        if (this.gfy != null) {
            this.gfy.asz();
        }
    }

    public void setBackgroundId(int i) {
        this.aHY = i;
        if (this.aHY > 0) {
            al.i(this, this.aHY);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            al.h(this, e.d.cp_cont_f);
            if (this.aHY > 0) {
                al.i(this, this.aHY);
            }
            bPE();
            this.mSkinType = i;
        }
    }
}
