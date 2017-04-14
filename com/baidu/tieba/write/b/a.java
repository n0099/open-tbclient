package com.baidu.tieba.write.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends LinearLayout implements y {
    private int KL;
    private j KM;
    private boolean cQQ;
    private int fOA;
    protected LocationInfoView fOs;
    private EditorInfoView fOt;
    private EditorInfoView fOu;
    private EditorInfoView fOv;
    private EditorInfoView fOw;
    private int fOx;
    private int fOy;
    private int fOz;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fOx = 0;
        this.fOy = 0;
        this.fOz = 0;
        this.fOA = 0;
        this.cQQ = true;
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(w.f.ds20);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.fOs = new LocationInfoView(context);
        this.fOt = new EditorInfoView(context);
        this.fOu = new EditorInfoView(context);
        this.fOv = new EditorInfoView(context);
        this.fOv.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fOw = new EditorInfoView(context);
        this.fOw.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(w.f.ds16);
        addView(this.fOs, layoutParams);
        addView(this.fOt, layoutParams);
        addView(this.fOu, layoutParams);
        addView(this.fOv, layoutParams);
        addView(this.fOw, layoutParams);
        new LinearLayout.LayoutParams(-1, -2).weight = 1.0f;
        this.fOt.setVisibility(8);
        this.fOu.setVisibility(8);
        this.fOv.setVisibility(8);
        this.fOw.setVisibility(8);
        this.fOs.setOnClickListener(new b(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(w.f.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.fOs;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    this.fOx = 0;
                    this.fOA = 0;
                    this.fOz = 0;
                    this.fOA = 0;
                    break;
                case 10:
                    this.fOA++;
                    break;
                case 11:
                    this.fOA--;
                    break;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.azU != null && aVar2.azU.getChosedFiles() != null) {
                            this.fOz = aVar2.azU.getChosedFiles().size();
                            break;
                        }
                    }
                    break;
                case 13:
                    this.fOz--;
                    break;
                case 19:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.d.a)) {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        this.fOs.setVisibility(aVar3.aAH ? 0 : 8);
                        this.fOs.k(aVar3.state, aVar3.addr);
                        break;
                    }
                    break;
                case 20:
                    this.fOs.setVisibility(8);
                    break;
            }
            bnV();
        }
    }

    private void bnV() {
        if (this.fOx > 0) {
            this.fOt.setVisibility(0);
            this.fOt.setText(String.valueOf(this.fOx));
        } else {
            this.fOt.setVisibility(8);
        }
        if (this.fOy > 0) {
            this.fOu.setVisibility(0);
            this.fOu.setText(String.valueOf(this.fOx));
        } else {
            this.fOu.setVisibility(8);
        }
        if (this.fOz > 0) {
            this.fOv.setVisibility(0);
            this.fOv.setText(String.valueOf(this.fOz));
        } else {
            this.fOv.setVisibility(8);
        }
        if (this.fOA > 0) {
            this.fOw.setVisibility(0);
            this.fOw.setText(String.valueOf(this.fOA));
            return;
        }
        this.fOw.setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void mp() {
        if (this.cQQ) {
            this.cQQ = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.KL;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        if (this.fOs != null) {
            this.fOs.xl();
        }
        if (this.fOt != null) {
            this.fOt.xl();
        }
        if (this.fOu != null) {
            this.fOu.xl();
        }
        if (this.fOv != null) {
            this.fOv.xl();
            this.fOv.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.fOw != null) {
            this.fOw.xl();
            this.fOw.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KM != null) {
            this.KM.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.KM = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.KL = i;
    }
}
