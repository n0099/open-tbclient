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
    private c foB;
    private String heA;
    private int heB;
    private int heC;
    private int heD;
    private String hez;
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
        YW();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void bCd() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        YW();
        bCe();
    }

    private void YW() {
        if (this.mState == 1) {
            setText(this.heA);
        } else {
            setText(this.hez);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        YW();
        bCe();
    }

    public void setStateString(String str, String str2) {
        this.hez = str;
        this.heA = str2;
        YW();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.heB = i;
        this.heC = i2;
        bCe();
    }

    private void bCe() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds48);
        if (this.mState == 1 && this.heC > 0) {
            Drawable drawable = ak.getDrawable(this.heC);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        } else if (this.mState == 0 && this.heB > 0) {
            Drawable drawable2 = ak.getDrawable(this.heB);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void hideTip() {
        if (this.foB != null) {
            this.foB.ahf();
        }
    }

    public void setBackgroundId(int i) {
        this.heD = i;
        if (this.heD > 0) {
            ak.i(this, this.heD);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            ak.h(this, d.C0126d.cp_cont_f);
            if (this.heD > 0) {
                ak.i(this, this.heD);
            }
            bCe();
            this.mSkinType = i;
        }
    }
}
