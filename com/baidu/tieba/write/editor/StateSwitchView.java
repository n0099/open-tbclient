package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
import com.baidu.tieba.write.write.WriteActivity;
/* loaded from: classes2.dex */
public class StateSwitchView extends EditorInfoView {
    private com.baidu.tieba.d.b fOl;
    private String hPi;
    private String hPj;
    private int hPk;
    private int hPl;
    private int hPm;
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
        adL();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void bMz() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        adL();
        bMA();
    }

    private void adL() {
        if (this.mState == 1) {
            setText(this.hPj);
        } else {
            setText(this.hPi);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        adL();
        bMA();
    }

    public void cr(String str, String str2) {
        this.hPi = str;
        this.hPj = str2;
        adL();
    }

    public void de(int i, int i2) {
        this.hPk = i;
        this.hPl = i2;
        bMA();
    }

    private void bMA() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds48);
        if (this.mState == 1 && this.hPl > 0) {
            Drawable drawable = aj.getDrawable(this.hPl);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        } else if (this.mState == 0 && this.hPk > 0) {
            Drawable drawable2 = aj.getDrawable(this.hPk);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void cs(String str, String str2) {
        if (this.fOl == null && (getContext() instanceof WriteActivity)) {
            this.fOl = new com.baidu.tieba.d.b(((WriteActivity) getContext()).getPageContext(), this);
            this.fOl.lS(d.f.pic_sign_tip_down);
            this.fOl.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.StateSwitchView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    StateSwitchView.this.fOl.alo();
                }
            });
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds10);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds24);
            this.fOl.v(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
            this.fOl.lV(0);
            this.fOl.lW(-67);
            this.fOl.lT(5000);
        }
        if (this.fOl != null) {
            this.fOl.aK(str, str2);
        }
    }

    public void hideTip() {
        if (this.fOl != null) {
            this.fOl.alo();
        }
    }

    public void setBackgroundId(int i) {
        this.hPm = i;
        if (this.hPm > 0) {
            aj.s(this, this.hPm);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            aj.r(this, d.C0108d.cp_cont_f);
            if (this.hPm > 0) {
                aj.s(this, this.hPm);
            }
            bMA();
            this.mSkinType = i;
        }
    }
}
