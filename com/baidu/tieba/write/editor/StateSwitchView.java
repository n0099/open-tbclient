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
    private int ayw;
    private d fLL;
    private String hDH;
    private String hDI;
    private int hDJ;
    private int hDK;
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
        int dimension = (int) getResources().getDimension(e.C0141e.ds26);
        setPadding(dimension, 0, dimension, 0);
        afd();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void amu() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        afd();
        bJp();
    }

    private void afd() {
        if (this.mState == 1) {
            setText(this.hDI);
        } else {
            setText(this.hDH);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        afd();
        bJp();
    }

    public void setStateString(String str, String str2) {
        this.hDH = str;
        this.hDI = str2;
        afd();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.hDJ = i;
        this.hDK = i2;
        bJp();
    }

    private void bJp() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0141e.ds48);
        if (this.mState == 1 && this.hDK > 0) {
            Drawable drawable = al.getDrawable(this.hDK);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(e.C0141e.ds8));
        } else if (this.mState == 0 && this.hDJ > 0) {
            Drawable drawable2 = al.getDrawable(this.hDJ);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(e.C0141e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void hideTip() {
        if (this.fLL != null) {
            this.fLL.amz();
        }
    }

    public void setBackgroundId(int i) {
        this.ayw = i;
        if (this.ayw > 0) {
            al.i(this, this.ayw);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            al.h(this, e.d.cp_cont_f);
            if (this.ayw > 0) {
                al.i(this, this.ayw);
            }
            bJp();
            this.mSkinType = i;
        }
    }
}
