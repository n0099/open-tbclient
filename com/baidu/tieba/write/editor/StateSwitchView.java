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
    private com.baidu.tieba.d.c fTs;
    private String hGI;
    private String hGJ;
    private int hGK;
    private int hGL;
    private int hGM;
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

    public void bGP() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        aeH();
        bGQ();
    }

    private void aeH() {
        if (this.mState == 1) {
            setText(this.hGJ);
        } else {
            setText(this.hGI);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        aeH();
        bGQ();
    }

    public void cm(String str, String str2) {
        this.hGI = str;
        this.hGJ = str2;
        aeH();
    }

    public void cS(int i, int i2) {
        this.hGK = i;
        this.hGL = i2;
        bGQ();
    }

    private void bGQ() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds48);
        if (this.mState == 1 && this.hGL > 0) {
            Drawable drawable = aj.getDrawable(this.hGL);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        } else if (this.mState == 0 && this.hGK > 0) {
            Drawable drawable2 = aj.getDrawable(this.hGK);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void cn(String str, String str2) {
        if (this.fTs == null && (getContext() instanceof WriteActivity)) {
            this.fTs = new com.baidu.tieba.d.c(((WriteActivity) getContext()).getPageContext(), this);
            this.fTs.lS(d.f.pic_sign_tip_down);
            this.fTs.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.StateSwitchView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    StateSwitchView.this.fTs.anh();
                }
            });
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds10);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds24);
            this.fTs.v(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
            this.fTs.lV(0);
            this.fTs.lW(-67);
            this.fTs.lT(5000);
        }
        if (this.fTs != null) {
            this.fTs.aK(str, str2);
        }
    }

    public void hideTip() {
        if (this.fTs != null) {
            this.fTs.anh();
        }
    }

    public void setBackgroundId(int i) {
        this.hGM = i;
        if (this.hGM > 0) {
            aj.s(this, this.hGM);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            aj.r(this, d.C0140d.cp_cont_f);
            if (this.hGM > 0) {
                aj.s(this, this.hGM);
            }
            bGQ();
            this.mSkinType = i;
        }
    }
}
