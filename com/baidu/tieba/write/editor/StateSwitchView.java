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
    private com.baidu.tieba.d.b fQg;
    private String hFk;
    private String hFl;
    private int hFm;
    private int hFn;
    private int hFo;
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
        adC();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        this.mState = 0;
    }

    public void bGb() {
        if (this.mState == 0) {
            this.mState = 1;
        } else {
            this.mState = 0;
        }
        adC();
        bGc();
    }

    private void adC() {
        if (this.mState == 1) {
            setText(this.hFl);
        } else {
            setText(this.hFk);
        }
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.mState = i;
        }
        adC();
        bGc();
    }

    public void ck(String str, String str2) {
        this.hFk = str;
        this.hFl = str2;
        adC();
    }

    public void cX(int i, int i2) {
        this.hFm = i;
        this.hFn = i2;
        bGc();
    }

    private void bGc() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds48);
        if (this.mState == 1 && this.hFn > 0) {
            Drawable drawable = aj.getDrawable(this.hFn);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        } else if (this.mState == 0 && this.hFm > 0) {
            Drawable drawable2 = aj.getDrawable(this.hFm);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            setCompoundDrawables(drawable2, null, null, null);
            setCompoundDrawablePadding(getResources().getDimensionPixelSize(d.e.ds8));
        }
    }

    public int getState() {
        return this.mState;
    }

    public void cl(String str, String str2) {
        if (this.fQg == null && (getContext() instanceof WriteActivity)) {
            this.fQg = new com.baidu.tieba.d.b(((WriteActivity) getContext()).getPageContext(), this);
            this.fQg.lV(d.f.pic_sign_tip_down);
            this.fQg.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.StateSwitchView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    StateSwitchView.this.fQg.amw();
                }
            });
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds10);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds24);
            this.fQg.v(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
            this.fQg.lY(0);
            this.fQg.lZ(-67);
            this.fQg.lW(5000);
        }
        if (this.fQg != null) {
            this.fQg.aJ(str, str2);
        }
    }

    public void hideTip() {
        if (this.fQg != null) {
            this.fQg.amw();
        }
    }

    public void setBackgroundId(int i) {
        this.hFo = i;
        if (this.hFo > 0) {
            aj.s(this, this.hFo);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            aj.r(this, d.C0108d.cp_cont_f);
            if (this.hFo > 0) {
                aj.s(this, this.hFo);
            }
            bGc();
            this.mSkinType = i;
        }
    }
}
