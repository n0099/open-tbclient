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
    private boolean cfm;
    private int coE;
    private d hUJ;
    private String jQe;
    private String jQf;
    private int jQg;
    private int jQh;
    private com.baidu.tbadk.core.util.f.a jQi;
    private com.baidu.tbadk.core.util.f.a jQj;
    private int mSkinType;
    private int mState;

    public StateSwitchView(Context context) {
        super(context);
        this.cfm = false;
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
        aUu();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void aHJ() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        aUu();
        cyu();
    }

    private void aUu() {
        if (this.mState == 1) {
            setText(this.jQf);
        } else {
            setText(this.jQe);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        aUu();
        cyu();
    }

    public void setStateString(String str, String str2) {
        this.jQe = str;
        this.jQf = str2;
        aUu();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.jQg = i;
        this.jQh = i2;
        this.cfm = false;
        cyu();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.f.a aVar, com.baidu.tbadk.core.util.f.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.cfm = true;
            this.jQi = aVar;
            this.jQj = aVar2;
            cyu();
        }
    }

    private void cyu() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.cfm && this.jQj != null) {
                drawable2 = this.jQj.getDrawable();
            } else {
                drawable2 = this.jQh > 0 ? am.getDrawable(this.jQh) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.cfm && this.jQi != null) {
                drawable = this.jQi.getDrawable();
            } else {
                drawable = this.jQh > 0 ? am.getDrawable(this.jQg) : null;
            }
            if (drawable != null) {
                drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        }
    }

    public int getState() {
        return this.mState;
    }

    public void hideTip() {
        if (this.hUJ != null) {
            this.hUJ.uP();
        }
    }

    public void setBackgroundId(int i) {
        this.coE = i;
        if (this.coE > 0) {
            am.setBackgroundResource(this, this.coE);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            am.setViewTextColor(this, (int) R.color.cp_cont_f);
            if (this.coE > 0) {
                am.setBackgroundResource(this, this.coE);
            }
            cyu();
            this.mSkinType = i;
        }
    }
}
