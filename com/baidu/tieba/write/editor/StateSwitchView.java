package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes3.dex */
public class StateSwitchView extends EditorInfoView {
    private boolean ehH;
    private int esM;
    private int mSkinType;
    private int mState;
    private String mZg;
    private String mZh;
    private int mZi;
    private int mZj;
    private com.baidu.tbadk.core.util.d.a mZk;
    private com.baidu.tbadk.core.util.d.a mZl;

    public StateSwitchView(Context context) {
        super(context);
        this.ehH = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ehH = false;
        this.mSkinType = 3;
        init();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ehH = false;
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
        bWx();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void aYd() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        bWx();
        dKo();
    }

    private void bWx() {
        if (this.mState == 1) {
            setText(this.mZh);
        } else {
            setText(this.mZg);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        bWx();
        dKo();
    }

    public void setStateString(String str, String str2) {
        this.mZg = str;
        this.mZh = str2;
        bWx();
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.mZi = i;
        this.mZj = i2;
        this.ehH = false;
        dKo();
    }

    public void setLeftStateDrawable(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.ehH = true;
            this.mZk = aVar;
            this.mZl = aVar2;
            dKo();
        }
    }

    private void dKo() {
        Drawable drawable;
        Drawable drawable2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        if (this.mState == 1) {
            if (this.ehH && this.mZl != null) {
                drawable2 = this.mZl.getDrawable();
            } else {
                drawable2 = this.mZj > 0 ? ap.getDrawable(this.mZj) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (this.mState == 0) {
            if (this.ehH && this.mZk != null) {
                drawable = this.mZk.getDrawable();
            } else {
                drawable = this.mZj > 0 ? ap.getDrawable(this.mZi) : null;
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

    public void setBackgroundId(int i) {
        this.esM = i;
        if (this.esM > 0) {
            ap.setBackgroundResource(this, this.esM);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            ap.setViewTextColor(this, R.color.cp_cont_f);
            if (this.esM > 0) {
                ap.setBackgroundResource(this, this.esM);
            }
            dKo();
            this.mSkinType = i;
        }
    }
}
