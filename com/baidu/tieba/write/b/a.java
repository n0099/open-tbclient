package com.baidu.tieba.write.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes.dex */
public class a extends LinearLayout implements ab {
    private int EI;
    private l EJ;
    private boolean cYm;
    protected LocationInfoView gdE;
    private EditorInfoView gdF;
    private EditorInfoView gdG;
    private EditorInfoView gdH;
    private EditorInfoView gdI;
    private int gdJ;
    private int gdK;
    private int gdL;
    private int gdM;
    private int gdN;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gdJ = 0;
        this.gdK = 0;
        this.gdL = 0;
        this.gdM = 0;
        this.gdN = 0;
        this.cYm = true;
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(r.e.ds20);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.gdE = new LocationInfoView(context);
        this.gdF = new EditorInfoView(context);
        this.gdG = new EditorInfoView(context);
        this.gdH = new EditorInfoView(context);
        this.gdH.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(r.f.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gdI = new EditorInfoView(context);
        this.gdI.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(r.f.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(r.e.ds16);
        addView(this.gdE, layoutParams);
        addView(this.gdF, layoutParams);
        addView(this.gdG, layoutParams);
        addView(this.gdH, layoutParams);
        addView(this.gdI, layoutParams);
        new LinearLayout.LayoutParams(-1, -2).weight = 1.0f;
        this.gdF.setVisibility(8);
        this.gdG.setVisibility(8);
        this.gdH.setVisibility(8);
        this.gdI.setVisibility(8);
        this.gdE.setOnClickListener(new b(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(r.e.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.gdE;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    this.gdJ = 0;
                    this.gdN = 0;
                    this.gdL = 0;
                    this.gdM = 0;
                    this.gdN = 0;
                    break;
                case 10:
                    this.gdN++;
                    break;
                case 11:
                    this.gdN--;
                    break;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.auN != null && aVar2.auN.getChosedFiles() != null) {
                            this.gdL = aVar2.auN.getChosedFiles().size();
                            break;
                        }
                    }
                    break;
                case 13:
                    this.gdL--;
                    break;
                case 19:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.d.a)) {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        this.gdE.setVisibility(aVar3.avA ? 0 : 8);
                        this.gdE.k(aVar3.state, aVar3.addr);
                        break;
                    }
                    break;
                case 20:
                    this.gdE.setVisibility(8);
                    break;
                case 22:
                    this.gdM = 1;
                    break;
                case 23:
                    this.gdM = 0;
                    break;
            }
            bsJ();
        }
    }

    private void bsJ() {
        if (this.gdJ > 0) {
            this.gdF.setVisibility(0);
            this.gdF.setText(String.valueOf(this.gdJ));
        } else {
            this.gdF.setVisibility(8);
        }
        if (this.gdK > 0) {
            this.gdG.setVisibility(0);
            this.gdG.setText(String.valueOf(this.gdJ));
        } else {
            this.gdG.setVisibility(8);
        }
        int i = this.gdL + this.gdM;
        if (i > 0) {
            this.gdH.setVisibility(0);
            this.gdH.setText(String.valueOf(i));
        } else {
            this.gdH.setVisibility(8);
        }
        if (this.gdN > 0) {
            this.gdI.setVisibility(0);
            this.gdI.setText(String.valueOf(this.gdN));
            return;
        }
        this.gdI.setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void lw() {
        if (this.cYm) {
            this.cYm = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.EI;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
        if (this.gdE != null) {
            this.gdE.wH();
        }
        if (this.gdF != null) {
            this.gdF.wH();
        }
        if (this.gdG != null) {
            this.gdG.wH();
        }
        if (this.gdH != null) {
            this.gdH.wH();
            this.gdH.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(r.f.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.gdI != null) {
            this.gdI.wH();
            this.gdI.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(r.f.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.EJ != null) {
            this.EJ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(l lVar) {
        this.EJ = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.EI = i;
    }
}
