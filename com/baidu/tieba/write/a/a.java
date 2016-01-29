package com.baidu.tieba.write.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.editortools.z;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes.dex */
public class a extends LinearLayout implements z {
    private int Lw;
    private k Lx;
    private boolean bRQ;
    protected LocationInfoView eom;
    private EditorInfoView eon;
    private EditorInfoView eoo;
    private EditorInfoView eop;
    private EditorInfoView eoq;
    private int eor;
    private int eos;
    private int eot;
    private int eou;
    private int eov;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eor = 0;
        this.eos = 0;
        this.eot = 0;
        this.eou = 0;
        this.eov = 0;
        this.bRQ = true;
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(t.e.ds36);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.eom = new LocationInfoView(context);
        this.eon = new EditorInfoView(context);
        this.eoo = new EditorInfoView(context);
        this.eop = new EditorInfoView(context);
        this.eop.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.eoq = new EditorInfoView(context);
        this.eoq.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(t.e.ds16);
        addView(this.eom, layoutParams);
        addView(this.eon, layoutParams);
        addView(this.eoo, layoutParams);
        addView(this.eop, layoutParams);
        addView(this.eoq, layoutParams);
        new LinearLayout.LayoutParams(-1, -2).weight = 1.0f;
        this.eon.setVisibility(8);
        this.eoo.setVisibility(8);
        this.eop.setVisibility(8);
        this.eoq.setVisibility(8);
        this.eom.setOnClickListener(new b(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(t.e.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.eom;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    this.eor = 0;
                    this.eov = 0;
                    this.eot = 0;
                    this.eou = 0;
                    this.eov = 0;
                    break;
                case 10:
                    this.eov++;
                    break;
                case 11:
                    this.eov--;
                    break;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.atZ != null && aVar2.atZ.getChosedFiles() != null) {
                            this.eot = aVar2.atZ.getChosedFiles().size();
                            break;
                        }
                    }
                    break;
                case 13:
                    this.eot--;
                    break;
                case 19:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.c.a)) {
                        com.baidu.tbadk.editortools.c.a aVar3 = (com.baidu.tbadk.editortools.c.a) aVar.data;
                        this.eom.setVisibility(aVar3.auM ? 0 : 8);
                        this.eom.s(aVar3.state, aVar3.addr);
                        break;
                    }
                    break;
                case 20:
                    this.eom.setVisibility(8);
                    break;
                case 22:
                    this.eou = 1;
                    break;
                case 23:
                    this.eou = 0;
                    break;
            }
            aTa();
        }
    }

    private void aTa() {
        if (this.eor > 0) {
            this.eon.setVisibility(0);
            this.eon.setText(String.valueOf(this.eor));
        } else {
            this.eon.setVisibility(8);
        }
        if (this.eos > 0) {
            this.eoo.setVisibility(0);
            this.eoo.setText(String.valueOf(this.eor));
        } else {
            this.eoo.setVisibility(8);
        }
        int i = this.eot + this.eou;
        if (i > 0) {
            this.eop.setVisibility(0);
            this.eop.setText(String.valueOf(i));
        } else {
            this.eop.setVisibility(8);
        }
        if (this.eov > 0) {
            this.eoq.setVisibility(0);
            this.eoq.setText(String.valueOf(this.eov));
            return;
        }
        this.eoq.setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void ow() {
        if (this.bRQ) {
            this.bRQ = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.z
    public int getToolId() {
        return this.Lw;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.z
    public void onChangeSkinType(int i) {
        if (this.eom != null) {
            this.eom.xf();
        }
        if (this.eon != null) {
            this.eon.xf();
        }
        if (this.eoo != null) {
            this.eoo.xf();
        }
        if (this.eop != null) {
            this.eop.xf();
            this.eop.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.eoq != null) {
            this.eoq.xf();
            this.eoq.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Lx != null) {
            this.Lx.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setEditorTools(k kVar) {
        this.Lx = kVar;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setToolId(int i) {
        this.Lw = i;
    }
}
