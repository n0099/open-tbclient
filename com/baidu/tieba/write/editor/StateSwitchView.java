package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.c.d;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes3.dex */
public class StateSwitchView extends EditorInfoView {
    private int avG;
    private d fDV;
    private String huE;
    private String huF;
    private int huG;
    private int huH;
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
        adb();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void aki() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        adb();
        bHK();
    }

    private void adb() {
        if (this.mState == 1) {
            setText(this.huF);
        } else {
            setText(this.huE);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        adb();
        bHK();
    }

    public void setStateString(String str, String str2) {
        this.huE = str;
        this.huF = str2;
        adb();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.huG = i;
        this.huH = i2;
        bHK();
    }

    private void bHK() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds48);
        if (this.mState == 1 && this.huH > 0) {
            Drawable drawable = am.getDrawable(this.huH);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        } else if (this.mState == 0 && this.huG > 0) {
            Drawable drawable2 = am.getDrawable(this.huG);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void hideTip() {
        if (this.fDV != null) {
            this.fDV.akn();
        }
    }

    public void setBackgroundId(int i) {
        this.avG = i;
        if (this.avG > 0) {
            am.i(this, this.avG);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            am.h(this, d.C0142d.cp_cont_f);
            if (this.avG > 0) {
                am.i(this, this.avG);
            }
            bHK();
            this.mSkinType = i;
        }
    }
}
