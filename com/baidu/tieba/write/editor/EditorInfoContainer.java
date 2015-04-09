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
    private final CustomMessageListener Zf;
    protected p cvc;
    private com.baidu.tieba.tbadkCore.PbEditor.b cvd;
    private com.baidu.tieba.tbadkCore.PbEditor.b cve;
    private com.baidu.tieba.tbadkCore.PbEditor.b cvf;
    private com.baidu.tieba.tbadkCore.PbEditor.b cvg;

    public EditorInfoContainer(Context context) {
        this(context, null);
    }

    public EditorInfoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Zf = new a(this, 2010041);
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(t.ds36);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.cvc = new p(context);
        this.cvd = new com.baidu.tieba.tbadkCore.PbEditor.b(context);
        this.cve = new com.baidu.tieba.tbadkCore.PbEditor.b(context);
        this.cvf = new com.baidu.tieba.tbadkCore.PbEditor.b(context);
        this.cvf.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(u.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.cvg = new com.baidu.tieba.tbadkCore.PbEditor.b(context);
        this.cvg.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(u.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(t.ds16);
        addView(this.cvc, layoutParams);
        addView(this.cvd, layoutParams);
        addView(this.cve, layoutParams);
        addView(this.cvf, layoutParams);
        addView(this.cvg, layoutParams);
        this.cvd.setVisibility(8);
        this.cve.setVisibility(8);
        this.cvf.setVisibility(8);
        this.cvg.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        l B = m.B(getContext());
        if (B != null) {
            this.Zf.setTag(B.getUniqueId());
        }
        this.Zf.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.Zf);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.Zf);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(t.ds62));
    }

    public p getLocationInfoView() {
        return this.cvc;
    }

    public void a(af afVar) {
        if (afVar != null) {
            if (afVar.cnn > 0) {
                this.cvd.setVisibility(0);
                this.cvd.setText(String.valueOf(afVar.cnn));
            } else {
                this.cvd.setVisibility(8);
            }
            if (afVar.cno > 0) {
                this.cve.setVisibility(0);
                this.cve.setText(String.valueOf(afVar.cnn));
            } else {
                this.cve.setVisibility(8);
            }
            if (afVar.cnp > 0 || afVar.cnr > 0) {
                this.cvf.setVisibility(0);
                this.cvf.setText(String.valueOf(afVar.cnp + afVar.cnr));
            } else {
                this.cvf.setVisibility(8);
            }
            if (afVar.cnq > 0) {
                this.cvg.setVisibility(0);
                this.cvg.setText(String.valueOf(afVar.cnq));
                return;
            }
            this.cvg.setVisibility(8);
        }
    }

    public void rk() {
        TbadkCoreApplication.m411getInst().getSkinType();
        if (this.cvc != null) {
            this.cvc.tP();
        }
        if (this.cvd != null) {
            this.cvd.tP();
        }
        if (this.cve != null) {
            this.cve.tP();
        }
        if (this.cvf != null) {
            this.cvf.tP();
            this.cvf.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(u.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.cvg != null) {
            this.cvg.tP();
            this.cvg.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(u.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
