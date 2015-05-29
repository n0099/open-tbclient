package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.base.m;
import com.baidu.adp.base.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.o;
import com.baidu.tieba.tbadkCore.PbEditor.af;
import com.baidu.tieba.tbadkCore.PbEditor.p;
/* loaded from: classes.dex */
public class EditorInfoContainer extends LinearLayout {
    private final CustomMessageListener aag;
    protected p czu;
    private com.baidu.tieba.tbadkCore.PbEditor.b czv;
    private com.baidu.tieba.tbadkCore.PbEditor.b czw;
    private com.baidu.tieba.tbadkCore.PbEditor.b czx;
    private com.baidu.tieba.tbadkCore.PbEditor.b czy;

    public EditorInfoContainer(Context context) {
        this(context, null);
    }

    public EditorInfoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aag = new a(this, 2010041);
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(o.ds36);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.czu = new p(context);
        this.czv = new com.baidu.tieba.tbadkCore.PbEditor.b(context);
        this.czw = new com.baidu.tieba.tbadkCore.PbEditor.b(context);
        this.czx = new com.baidu.tieba.tbadkCore.PbEditor.b(context);
        this.czx.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.czy = new com.baidu.tieba.tbadkCore.PbEditor.b(context);
        this.czy.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(o.ds16);
        addView(this.czu, layoutParams);
        addView(this.czv, layoutParams);
        addView(this.czw, layoutParams);
        addView(this.czx, layoutParams);
        addView(this.czy, layoutParams);
        this.czv.setVisibility(8);
        this.czw.setVisibility(8);
        this.czx.setVisibility(8);
        this.czy.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m B = n.B(getContext());
        if (B != null) {
            this.aag.setTag(B.getUniqueId());
        }
        this.aag.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.aag);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.aag);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(o.ds62));
    }

    public p getLocationInfoView() {
        return this.czu;
    }

    public void a(af afVar) {
        if (afVar != null) {
            if (afVar.crl > 0) {
                this.czv.setVisibility(0);
                this.czv.setText(String.valueOf(afVar.crl));
            } else {
                this.czv.setVisibility(8);
            }
            if (afVar.crm > 0) {
                this.czw.setVisibility(0);
                this.czw.setText(String.valueOf(afVar.crl));
            } else {
                this.czw.setVisibility(8);
            }
            if (afVar.crn > 0 || afVar.crp > 0) {
                this.czx.setVisibility(0);
                this.czx.setText(String.valueOf(afVar.crn + afVar.crp));
            } else {
                this.czx.setVisibility(8);
            }
            if (afVar.cro > 0) {
                this.czy.setVisibility(0);
                this.czy.setText(String.valueOf(afVar.cro));
                return;
            }
            this.czy.setVisibility(8);
        }
    }

    public void rU() {
        TbadkCoreApplication.m411getInst().getSkinType();
        if (this.czu != null) {
            this.czu.uy();
        }
        if (this.czv != null) {
            this.czv.uy();
        }
        if (this.czw != null) {
            this.czw.uy();
        }
        if (this.czx != null) {
            this.czx.uy();
            this.czx.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.czy != null) {
            this.czy.uy();
            this.czy.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
