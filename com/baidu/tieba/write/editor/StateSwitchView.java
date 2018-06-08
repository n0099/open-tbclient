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
    private d fzU;
    private String hqu;
    private String hqv;
    private int hqw;
    private int hqx;
    private int hqy;
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
        acu();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void akO() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        acu();
        bHj();
    }

    private void acu() {
        if (this.mState == 1) {
            setText(this.hqv);
        } else {
            setText(this.hqu);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        acu();
        bHj();
    }

    public void setStateString(String str, String str2) {
        this.hqu = str;
        this.hqv = str2;
        acu();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.hqw = i;
        this.hqx = i2;
        bHj();
    }

    private void bHj() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds48);
        if (this.mState == 1 && this.hqx > 0) {
            Drawable drawable = al.getDrawable(this.hqx);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        } else if (this.mState == 0 && this.hqw > 0) {
            Drawable drawable2 = al.getDrawable(this.hqw);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void hideTip() {
        if (this.fzU != null) {
            this.fzU.akT();
        }
    }

    public void setBackgroundId(int i) {
        this.hqy = i;
        if (this.hqy > 0) {
            al.i(this, this.hqy);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            al.h(this, d.C0141d.cp_cont_f);
            if (this.hqy > 0) {
                al.i(this, this.hqy);
            }
            bHj();
            this.mSkinType = i;
        }
    }
}
