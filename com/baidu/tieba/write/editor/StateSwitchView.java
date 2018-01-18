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
    private com.baidu.tieba.d.b fPL;
    private String hEQ;
    private String hER;
    private int hES;
    private int hET;
    private int hEU;
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
        adz();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void bFZ() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        adz();
        bGa();
    }

    private void adz() {
        if (this.mState == 1) {
            setText(this.hER);
        } else {
            setText(this.hEQ);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        adz();
        bGa();
    }

    public void cl(String str, String str2) {
        this.hEQ = str;
        this.hER = str2;
        adz();
    }

    public void cX(int i, int i2) {
        this.hES = i;
        this.hET = i2;
        bGa();
    }

    private void bGa() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds48);
        if (this.mState == 1 && this.hET > 0) {
            Drawable drawable = aj.getDrawable(this.hET);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        } else if (this.mState == 0 && this.hES > 0) {
            Drawable drawable2 = aj.getDrawable(this.hES);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void cm(String str, String str2) {
        if (this.fPL == null && (getContext() instanceof WriteActivity)) {
            this.fPL = new com.baidu.tieba.d.b(((WriteActivity) getContext()).getPageContext(), this);
            this.fPL.lV(d.f.pic_sign_tip_down);
            this.fPL.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.StateSwitchView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    StateSwitchView.this.fPL.amr();
                }
            });
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds10);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds24);
            this.fPL.v(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
            this.fPL.lY(0);
            this.fPL.lZ(-67);
            this.fPL.lW(5000);
        }
        if (this.fPL != null) {
            this.fPL.aK(str, str2);
        }
    }

    public void hideTip() {
        if (this.fPL != null) {
            this.fPL.amr();
        }
    }

    public void setBackgroundId(int i) {
        this.hEU = i;
        if (this.hEU > 0) {
            aj.s(this, this.hEU);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            aj.r(this, d.C0107d.cp_cont_f);
            if (this.hEU > 0) {
                aj.s(this, this.hEU);
            }
            bGa();
            this.mSkinType = i;
        }
    }
}
