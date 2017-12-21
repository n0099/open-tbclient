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
    private com.baidu.tieba.d.b fbt;
    private String hhh;
    private String hhi;
    private int hhj;
    private int hhk;
    private int hhl;
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
        Wd();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void bGM() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        Wd();
        bGN();
    }

    private void Wd() {
        if (this.mState == 1) {
            setText(this.hhi);
        } else {
            setText(this.hhh);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        Wd();
        bGN();
    }

    public void cq(String str, String str2) {
        this.hhh = str;
        this.hhi = str2;
        Wd();
    }

    public void ch(int i, int i2) {
        this.hhj = i;
        this.hhk = i2;
        bGN();
    }

    private void bGN() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds48);
        if (this.mState == 1 && this.hhk > 0) {
            Drawable drawable = aj.getDrawable(this.hhk);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        } else if (this.mState == 0 && this.hhj > 0) {
            Drawable drawable2 = aj.getDrawable(this.hhj);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void cr(String str, String str2) {
        if (this.fbt == null && (getContext() instanceof WriteActivity)) {
            this.fbt = new com.baidu.tieba.d.b(((WriteActivity) getContext()).getPageContext(), this);
            this.fbt.iU(d.f.pic_sign_tip_down);
            this.fbt.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.StateSwitchView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    StateSwitchView.this.fbt.adI();
                }
            });
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds10);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds24);
            this.fbt.n(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
            this.fbt.iX(0);
            this.fbt.iY(-67);
            this.fbt.iV(5000);
        }
        if (this.fbt != null) {
            this.fbt.aL(str, str2);
        }
    }

    public void hideTip() {
        if (this.fbt != null) {
            this.fbt.adI();
        }
    }

    public void setBackgroundId(int i) {
        this.hhl = i;
        if (this.hhl > 0) {
            aj.j(this, this.hhl);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            aj.i(this, d.C0095d.cp_cont_f);
            if (this.hhl > 0) {
                aj.j(this, this.hhl);
            }
            bGN();
            this.mSkinType = i;
        }
    }
}
