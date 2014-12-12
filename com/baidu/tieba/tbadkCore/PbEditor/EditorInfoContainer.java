package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class EditorInfoContainer extends LinearLayout {
    protected z bTr;
    private l bTs;
    private l bTt;
    private l bTu;
    private l bTv;
    private final CustomMessageListener bTw;

    public EditorInfoContainer(Context context) {
        this(context, null);
    }

    public EditorInfoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bTw = new j(this, 2010041);
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(com.baidu.tieba.u.ds20);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.bTr = new z(context);
        this.bTs = new l(context);
        this.bTt = new l(context);
        this.bTu = new l(context);
        this.bTu.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bTv = new l(context);
        this.bTv.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(com.baidu.tieba.u.ds16);
        addView(this.bTr, layoutParams);
        addView(this.bTs, layoutParams);
        addView(this.bTt, layoutParams);
        addView(this.bTu, layoutParams);
        addView(this.bTv, layoutParams);
        this.bTs.setVisibility(8);
        this.bTt.setVisibility(8);
        this.bTu.setVisibility(8);
        this.bTv.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.adp.base.l B = com.baidu.adp.base.m.B(getContext());
        if (B != null) {
            this.bTw.setTag(B.getUniqueId());
        }
        this.bTw.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.bTw);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bTw);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(com.baidu.tieba.u.ds62));
    }

    public z getLocationInfoView() {
        return this.bTr;
    }

    public void a(bb bbVar) {
        if (bbVar != null) {
            if (bbVar.bVm > 0) {
                this.bTs.setVisibility(0);
                this.bTs.setText(String.valueOf(bbVar.bVm));
            } else {
                this.bTs.setVisibility(8);
            }
            if (bbVar.bVn > 0) {
                this.bTt.setVisibility(0);
                this.bTt.setText(String.valueOf(bbVar.bVm));
            } else {
                this.bTt.setVisibility(8);
            }
            if (bbVar.bVo > 0) {
                this.bTu.setVisibility(0);
                this.bTu.setText(String.valueOf(bbVar.bVo + bbVar.bVq));
            } else {
                this.bTu.setVisibility(8);
            }
            if (bbVar.bVp > 0) {
                this.bTv.setVisibility(0);
                this.bTv.setText(String.valueOf(bbVar.bVp));
                return;
            }
            this.bTv.setVisibility(8);
        }
    }

    public void wc() {
        TbadkCoreApplication.m255getInst().getSkinType();
        if (this.bTr != null) {
            this.bTr.qA();
        }
        if (this.bTs != null) {
            this.bTs.qA();
        }
        if (this.bTt != null) {
            this.bTt.qA();
        }
        if (this.bTu != null) {
            this.bTu.qA();
            this.bTu.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.bTv != null) {
            this.bTv.qA();
            this.bTv.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
