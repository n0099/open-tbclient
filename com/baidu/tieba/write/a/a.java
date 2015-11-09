package com.baidu.tieba.write.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.x;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes.dex */
public class a extends LinearLayout implements x {
    private int KA;
    private j KB;
    private boolean bvf;
    protected LocationInfoView dnc;
    private EditorInfoView dnd;
    private EditorInfoView dne;
    private EditorInfoView dnf;
    private EditorInfoView dng;
    private int dnh;
    private int dni;
    private int dnj;
    private int dnk;
    private int dnl;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dnh = 0;
        this.dni = 0;
        this.dnj = 0;
        this.dnk = 0;
        this.dnl = 0;
        this.bvf = true;
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(i.d.ds36);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.dnc = new LocationInfoView(context);
        this.dnd = new EditorInfoView(context);
        this.dne = new EditorInfoView(context);
        this.dnf = new EditorInfoView(context);
        this.dnf.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.dng = new EditorInfoView(context);
        this.dng.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(i.d.ds16);
        addView(this.dnc, layoutParams);
        addView(this.dnd, layoutParams);
        addView(this.dne, layoutParams);
        addView(this.dnf, layoutParams);
        addView(this.dng, layoutParams);
        this.dnd.setVisibility(8);
        this.dne.setVisibility(8);
        this.dnf.setVisibility(8);
        this.dng.setVisibility(8);
        this.dnc.setOnClickListener(new b(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(i.d.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.dnc;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    this.dnh = 0;
                    this.dnl = 0;
                    this.dnj = 0;
                    this.dnk = 0;
                    this.dnl = 0;
                    break;
                case 10:
                    this.dnl++;
                    break;
                case 11:
                    this.dnl--;
                    break;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.apG != null && aVar2.apG.getChosedFiles() != null) {
                            this.dnj = aVar2.apG.getChosedFiles().size();
                            break;
                        }
                    }
                    break;
                case 13:
                    this.dnj--;
                    break;
                case 19:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.b.a)) {
                        com.baidu.tbadk.editortools.b.a aVar3 = (com.baidu.tbadk.editortools.b.a) aVar.data;
                        this.dnc.setVisibility(aVar3.aqm ? 0 : 8);
                        this.dnc.r(aVar3.state, aVar3.addr);
                        break;
                    }
                    break;
                case 20:
                    this.dnc.setVisibility(8);
                    break;
                case 22:
                    this.dnk = 1;
                    break;
                case 23:
                    this.dnk = 0;
                    break;
            }
            aCy();
        }
    }

    private void aCy() {
        if (this.dnh > 0) {
            this.dnd.setVisibility(0);
            this.dnd.setText(String.valueOf(this.dnh));
        } else {
            this.dnd.setVisibility(8);
        }
        if (this.dni > 0) {
            this.dne.setVisibility(0);
            this.dne.setText(String.valueOf(this.dnh));
        } else {
            this.dne.setVisibility(8);
        }
        int i = this.dnj + this.dnk;
        if (i > 0) {
            this.dnf.setVisibility(0);
            this.dnf.setText(String.valueOf(i));
        } else {
            this.dnf.setVisibility(8);
        }
        if (this.dnl > 0) {
            this.dng.setVisibility(0);
            this.dng.setText(String.valueOf(this.dnl));
            return;
        }
        this.dng.setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.x
    public void ox() {
        if (this.bvf) {
            this.bvf = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.x
    public int getToolId() {
        return this.KA;
    }

    @Override // com.baidu.tbadk.editortools.x
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.x
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.x
    public void onChangeSkinType(int i) {
        if (this.dnc != null) {
            this.dnc.vB();
        }
        if (this.dnd != null) {
            this.dnd.vB();
        }
        if (this.dne != null) {
            this.dne.vB();
        }
        if (this.dnf != null) {
            this.dnf.vB();
            this.dnf.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.dng != null) {
            this.dng.vB();
            this.dng.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.tbadk.editortools.x
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KB != null) {
            this.KB.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.x
    public void setEditorTools(j jVar) {
        this.KB = jVar;
    }

    @Override // com.baidu.tbadk.editortools.x
    public void setToolId(int i) {
        this.KA = i;
    }
}
