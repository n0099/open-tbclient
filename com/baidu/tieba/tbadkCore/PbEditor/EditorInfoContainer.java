package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public class EditorInfoContainer extends LinearLayout {
    private final CustomMessageListener NT;
    protected z bVj;
    private l bVk;
    private l bVl;
    private l bVm;
    private l bVn;

    public EditorInfoContainer(Context context) {
        this(context, null);
    }

    public EditorInfoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NT = new j(this, 2010041);
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(com.baidu.tieba.u.ds36);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.bVj = new z(context);
        this.bVk = new l(context);
        this.bVl = new l(context);
        this.bVm = new l(context);
        this.bVm.setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(com.baidu.tieba.v.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bVn = new l(context);
        this.bVn.setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(com.baidu.tieba.v.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(com.baidu.tieba.u.ds16);
        addView(this.bVj, layoutParams);
        addView(this.bVk, layoutParams);
        addView(this.bVl, layoutParams);
        addView(this.bVm, layoutParams);
        addView(this.bVn, layoutParams);
        this.bVk.setVisibility(8);
        this.bVl.setVisibility(8);
        this.bVm.setVisibility(8);
        this.bVn.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.adp.base.l B = com.baidu.adp.base.m.B(getContext());
        if (B != null) {
            this.NT.setTag(B.getUniqueId());
        }
        this.NT.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.NT);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.NT);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(com.baidu.tieba.u.ds62));
    }

    public z getLocationInfoView() {
        return this.bVj;
    }

    public void a(bb bbVar) {
        if (bbVar != null) {
            if (bbVar.bXd > 0) {
                this.bVk.setVisibility(0);
                this.bVk.setText(String.valueOf(bbVar.bXd));
            } else {
                this.bVk.setVisibility(8);
            }
            if (bbVar.bXe > 0) {
                this.bVl.setVisibility(0);
                this.bVl.setText(String.valueOf(bbVar.bXd));
            } else {
                this.bVl.setVisibility(8);
            }
            if (bbVar.bXf > 0) {
                this.bVm.setVisibility(0);
                this.bVm.setText(String.valueOf(bbVar.bXf + bbVar.bXh));
            } else {
                this.bVm.setVisibility(8);
            }
            if (bbVar.bXg > 0) {
                this.bVn.setVisibility(0);
                this.bVn.setText(String.valueOf(bbVar.bXg));
                return;
            }
            this.bVn.setVisibility(8);
        }
    }

    public void wo() {
        TbadkCoreApplication.m255getInst().getSkinType();
        if (this.bVj != null) {
            this.bVj.qF();
        }
        if (this.bVk != null) {
            this.bVk.qF();
        }
        if (this.bVl != null) {
            this.bVl.qF();
        }
        if (this.bVm != null) {
            this.bVm.qF();
            this.bVm.setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(com.baidu.tieba.v.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.bVn != null) {
            this.bVn.qF();
            this.bVn.setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(com.baidu.tieba.v.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
