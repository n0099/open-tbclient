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
    private com.baidu.tieba.d.b fbo;
    private String hhc;
    private String hhd;
    private int hhe;
    private int hhf;
    private int hhg;
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

    public void bGL() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        Wd();
        bGM();
    }

    private void Wd() {
        if (this.mState == 1) {
            setText(this.hhd);
        } else {
            setText(this.hhc);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        Wd();
        bGM();
    }

    public void cq(String str, String str2) {
        this.hhc = str;
        this.hhd = str2;
        Wd();
    }

    public void ch(int i, int i2) {
        this.hhe = i;
        this.hhf = i2;
        bGM();
    }

    private void bGM() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds48);
        if (this.mState == 1 && this.hhf > 0) {
            Drawable drawable = aj.getDrawable(this.hhf);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        } else if (this.mState == 0 && this.hhe > 0) {
            Drawable drawable2 = aj.getDrawable(this.hhe);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void cr(String str, String str2) {
        if (this.fbo == null && (getContext() instanceof WriteActivity)) {
            this.fbo = new com.baidu.tieba.d.b(((WriteActivity) getContext()).getPageContext(), this);
            this.fbo.iU(d.f.pic_sign_tip_down);
            this.fbo.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.StateSwitchView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    StateSwitchView.this.fbo.adI();
                }
            });
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds10);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds24);
            this.fbo.n(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
            this.fbo.iX(0);
            this.fbo.iY(-67);
            this.fbo.iV(5000);
        }
        if (this.fbo != null) {
            this.fbo.aL(str, str2);
        }
    }

    public void hideTip() {
        if (this.fbo != null) {
            this.fbo.adI();
        }
    }

    public void setBackgroundId(int i) {
        this.hhg = i;
        if (this.hhg > 0) {
            aj.j(this, this.hhg);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            aj.i(this, d.C0096d.cp_cont_f);
            if (this.hhg > 0) {
                aj.j(this, this.hhg);
            }
            bGM();
            this.mSkinType = i;
        }
    }
}
