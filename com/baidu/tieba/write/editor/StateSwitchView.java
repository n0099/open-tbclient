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
    private int bZg;
    private d hUe;
    private String jPX;
    private String jPY;
    private int jPZ;
    private int jQa;
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
        aSV();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void aGS() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        aSV();
        cAW();
    }

    private void aSV() {
        if (this.mState == 1) {
            setText(this.jPY);
        } else {
            setText(this.jPX);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        aSV();
        cAW();
    }

    public void setStateString(String str, String str2) {
        this.jPX = str;
        this.jPY = str2;
        aSV();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.jPZ = i;
        this.jQa = i2;
        cAW();
    }

    private void cAW() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds48);
        if (this.mState == 1 && this.jQa > 0) {
            Drawable drawable = am.getDrawable(this.jQa);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
        } else if (this.mState == 0 && this.jPZ > 0) {
            Drawable drawable2 = am.getDrawable(this.jPZ);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void hideTip() {
        if (this.hUe != null) {
            this.hUe.bbB();
        }
    }

    public void setBackgroundId(int i) {
        this.bZg = i;
        if (this.bZg > 0) {
            am.k(this, this.bZg);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            am.j(this, R.color.cp_cont_f);
            if (this.bZg > 0) {
                am.k(this, this.bZg);
            }
            cAW();
            this.mSkinType = i;
        }
    }
}
