package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.base.l;
import com.baidu.adp.base.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.PbEditor.af;
import com.baidu.tieba.tbadkCore.PbEditor.p;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class EditorInfoContainer extends LinearLayout {
    private final CustomMessageListener Zd;
    protected p cuM;
    private com.baidu.tieba.tbadkCore.PbEditor.b cuN;
    private com.baidu.tieba.tbadkCore.PbEditor.b cuO;
    private com.baidu.tieba.tbadkCore.PbEditor.b cuP;
    private com.baidu.tieba.tbadkCore.PbEditor.b cuQ;

    public EditorInfoContainer(Context context) {
        this(context, null);
    }

    public EditorInfoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Zd = new a(this, 2010041);
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(t.ds36);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.cuM = new p(context);
        this.cuN = new com.baidu.tieba.tbadkCore.PbEditor.b(context);
        this.cuO = new com.baidu.tieba.tbadkCore.PbEditor.b(context);
        this.cuP = new com.baidu.tieba.tbadkCore.PbEditor.b(context);
        this.cuP.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(u.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.cuQ = new com.baidu.tieba.tbadkCore.PbEditor.b(context);
        this.cuQ.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(u.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(t.ds16);
        addView(this.cuM, layoutParams);
        addView(this.cuN, layoutParams);
        addView(this.cuO, layoutParams);
        addView(this.cuP, layoutParams);
        addView(this.cuQ, layoutParams);
        this.cuN.setVisibility(8);
        this.cuO.setVisibility(8);
        this.cuP.setVisibility(8);
        this.cuQ.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        l B = m.B(getContext());
        if (B != null) {
            this.Zd.setTag(B.getUniqueId());
        }
        this.Zd.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.Zd);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.Zd);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(t.ds62));
    }

    public p getLocationInfoView() {
        return this.cuM;
    }

    public void a(af afVar) {
        if (afVar != null) {
            if (afVar.cmX > 0) {
                this.cuN.setVisibility(0);
                this.cuN.setText(String.valueOf(afVar.cmX));
            } else {
                this.cuN.setVisibility(8);
            }
            if (afVar.cmY > 0) {
                this.cuO.setVisibility(0);
                this.cuO.setText(String.valueOf(afVar.cmX));
            } else {
                this.cuO.setVisibility(8);
            }
            if (afVar.cmZ > 0 || afVar.cnb > 0) {
                this.cuP.setVisibility(0);
                this.cuP.setText(String.valueOf(afVar.cmZ + afVar.cnb));
            } else {
                this.cuP.setVisibility(8);
            }
            if (afVar.cna > 0) {
                this.cuQ.setVisibility(0);
                this.cuQ.setText(String.valueOf(afVar.cna));
                return;
            }
            this.cuQ.setVisibility(8);
        }
    }

    public void rk() {
        TbadkCoreApplication.m411getInst().getSkinType();
        if (this.cuM != null) {
            this.cuM.tP();
        }
        if (this.cuN != null) {
            this.cuN.tP();
        }
        if (this.cuO != null) {
            this.cuO.tP();
        }
        if (this.cuP != null) {
            this.cuP.tP();
            this.cuP.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(u.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.cuQ != null) {
            this.cuQ.tP();
            this.cuQ.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(u.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
