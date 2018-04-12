package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.d.c;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes3.dex */
public class StateSwitchView extends EditorInfoView {
    private c fnw;
    private int hdA;
    private int hdB;
    private int hdC;
    private String hdy;
    private String hdz;
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
        YT();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void bCf() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        YT();
        bCg();
    }

    private void YT() {
        if (this.mState == 1) {
            setText(this.hdz);
        } else {
            setText(this.hdy);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        YT();
        bCg();
    }

    public void setStateString(String str, String str2) {
        this.hdy = str;
        this.hdz = str2;
        YT();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.hdA = i;
        this.hdB = i2;
        bCg();
    }

    private void bCg() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds48);
        if (this.mState == 1 && this.hdB > 0) {
            Drawable drawable = ak.getDrawable(this.hdB);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        } else if (this.mState == 0 && this.hdA > 0) {
            Drawable drawable2 = ak.getDrawable(this.hdA);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void hideTip() {
        if (this.fnw != null) {
            this.fnw.ahf();
        }
    }

    public void setBackgroundId(int i) {
        this.hdC = i;
        if (this.hdC > 0) {
            ak.i(this, this.hdC);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            ak.h(this, d.C0126d.cp_cont_f);
            if (this.hdC > 0) {
                ak.i(this, this.hdC);
            }
            bCg();
            this.mSkinType = i;
        }
    }
}
