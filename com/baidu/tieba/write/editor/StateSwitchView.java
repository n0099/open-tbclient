package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.c.d;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes3.dex */
public class StateSwitchView extends EditorInfoView {
    private int bZa;
    private d hTi;
    private String jOQ;
    private String jOR;
    private int jOS;
    private int jOT;
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
        aST();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void aGQ() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        aST();
        cAB();
    }

    private void aST() {
        if (this.mState == 1) {
            setText(this.jOR);
        } else {
            setText(this.jOQ);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        aST();
        cAB();
    }

    public void setStateString(String str, String str2) {
        this.jOQ = str;
        this.jOR = str2;
        aST();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.jOS = i;
        this.jOT = i2;
        cAB();
    }

    private void cAB() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds48);
        if (this.mState == 1 && this.jOT > 0) {
            Drawable drawable = am.getDrawable(this.jOT);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
        } else if (this.mState == 0 && this.jOS > 0) {
            Drawable drawable2 = am.getDrawable(this.jOS);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void hideTip() {
        if (this.hTi != null) {
            this.hTi.bbz();
        }
    }

    public void setBackgroundId(int i) {
        this.bZa = i;
        if (this.bZa > 0) {
            am.k(this, this.bZa);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            am.j(this, R.color.cp_cont_f);
            if (this.bZa > 0) {
                am.k(this, this.bZa);
            }
            cAB();
            this.mSkinType = i;
        }
    }
}
