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
    private com.baidu.tieba.d.c fTh;
    private String hGv;
    private String hGw;
    private int hGx;
    private int hGy;
    private int hGz;
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
        aeG();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void bGO() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        aeG();
        bGP();
    }

    private void aeG() {
        if (this.mState == 1) {
            setText(this.hGw);
        } else {
            setText(this.hGv);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        aeG();
        bGP();
    }

    public void cm(String str, String str2) {
        this.hGv = str;
        this.hGw = str2;
        aeG();
    }

    public void cS(int i, int i2) {
        this.hGx = i;
        this.hGy = i2;
        bGP();
    }

    private void bGP() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds48);
        if (this.mState == 1 && this.hGy > 0) {
            Drawable drawable = aj.getDrawable(this.hGy);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        } else if (this.mState == 0 && this.hGx > 0) {
            Drawable drawable2 = aj.getDrawable(this.hGx);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void cn(String str, String str2) {
        if (this.fTh == null && (getContext() instanceof WriteActivity)) {
            this.fTh = new com.baidu.tieba.d.c(((WriteActivity) getContext()).getPageContext(), this);
            this.fTh.lS(d.f.pic_sign_tip_down);
            this.fTh.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.StateSwitchView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    StateSwitchView.this.fTh.ang();
                }
            });
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds10);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds24);
            this.fTh.v(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
            this.fTh.lV(0);
            this.fTh.lW(-67);
            this.fTh.lT(5000);
        }
        if (this.fTh != null) {
            this.fTh.aK(str, str2);
        }
    }

    public void hideTip() {
        if (this.fTh != null) {
            this.fTh.ang();
        }
    }

    public void setBackgroundId(int i) {
        this.hGz = i;
        if (this.hGz > 0) {
            aj.s(this, this.hGz);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            aj.r(this, d.C0141d.cp_cont_f);
            if (this.hGz > 0) {
                aj.s(this, this.hGz);
            }
            bGP();
            this.mSkinType = i;
        }
    }
}
