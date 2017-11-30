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
    private com.baidu.tieba.d.b fal;
    private String hek;
    private String hel;
    private int hem;
    private int hen;
    private int heo;
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

    public void bGa() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        Wd();
        bGb();
    }

    private void Wd() {
        if (this.mState == 1) {
            setText(this.hel);
        } else {
            setText(this.hek);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        Wd();
        bGb();
    }

    public void cp(String str, String str2) {
        this.hek = str;
        this.hel = str2;
        Wd();
    }

    public void cg(int i, int i2) {
        this.hem = i;
        this.hen = i2;
        bGb();
    }

    private void bGb() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds48);
        if (this.mState == 1 && this.hen > 0) {
            Drawable drawable = aj.getDrawable(this.hen);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        } else if (this.mState == 0 && this.hem > 0) {
            Drawable drawable2 = aj.getDrawable(this.hem);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void cq(String str, String str2) {
        if (this.fal == null && (getContext() instanceof WriteActivity)) {
            this.fal = new com.baidu.tieba.d.b(((WriteActivity) getContext()).getPageContext(), this);
            this.fal.iS(d.f.pic_sign_tip_down);
            this.fal.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.StateSwitchView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    StateSwitchView.this.fal.adz();
                }
            });
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds10);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds24);
            this.fal.n(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
            this.fal.iV(0);
            this.fal.iW(-67);
            this.fal.iT(5000);
        }
        if (this.fal != null) {
            this.fal.aK(str, str2);
        }
    }

    public void hideTip() {
        if (this.fal != null) {
            this.fal.adz();
        }
    }

    public void setBackgroundId(int i) {
        this.heo = i;
        if (this.heo > 0) {
            aj.j(this, this.heo);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            aj.i(this, d.C0082d.cp_cont_f);
            if (this.heo > 0) {
                aj.j(this, this.heo);
            }
            bGb();
            this.mSkinType = i;
        }
    }
}
