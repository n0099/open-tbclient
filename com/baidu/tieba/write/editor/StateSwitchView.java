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
    private com.baidu.tieba.d.c fTx;
    private String hGT;
    private String hGU;
    private int hGV;
    private int hGW;
    private int hGX;
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
        aeH();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void bGT() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        aeH();
        bGU();
    }

    private void aeH() {
        if (this.mState == 1) {
            setText(this.hGU);
        } else {
            setText(this.hGT);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        aeH();
        bGU();
    }

    public void cm(String str, String str2) {
        this.hGT = str;
        this.hGU = str2;
        aeH();
    }

    public void cS(int i, int i2) {
        this.hGV = i;
        this.hGW = i2;
        bGU();
    }

    private void bGU() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds48);
        if (this.mState == 1 && this.hGW > 0) {
            Drawable drawable = aj.getDrawable(this.hGW);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        } else if (this.mState == 0 && this.hGV > 0) {
            Drawable drawable2 = aj.getDrawable(this.hGV);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void cn(String str, String str2) {
        if (this.fTx == null && (getContext() instanceof WriteActivity)) {
            this.fTx = new com.baidu.tieba.d.c(((WriteActivity) getContext()).getPageContext(), this);
            this.fTx.lS(d.f.pic_sign_tip_down);
            this.fTx.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.StateSwitchView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    StateSwitchView.this.fTx.anh();
                }
            });
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds10);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds24);
            this.fTx.v(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
            this.fTx.lV(0);
            this.fTx.lW(-67);
            this.fTx.lT(5000);
        }
        if (this.fTx != null) {
            this.fTx.aK(str, str2);
        }
    }

    public void hideTip() {
        if (this.fTx != null) {
            this.fTx.anh();
        }
    }

    public void setBackgroundId(int i) {
        this.hGX = i;
        if (this.hGX > 0) {
            aj.s(this, this.hGX);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            aj.r(this, d.C0141d.cp_cont_f);
            if (this.hGX > 0) {
                aj.s(this, this.hGX);
            }
            bGU();
            this.mSkinType = i;
        }
    }
}
