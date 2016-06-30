package com.baidu.tieba.write.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a extends LinearLayout implements ab {
    private int BV;
    private l BW;
    private boolean cIu;
    protected LocationInfoView fEd;
    private EditorInfoView fEe;
    private EditorInfoView fEf;
    private EditorInfoView fEg;
    private EditorInfoView fEh;
    private int fEi;
    private int fEj;
    private int fEk;
    private int fEl;
    private int fEm;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fEi = 0;
        this.fEj = 0;
        this.fEk = 0;
        this.fEl = 0;
        this.fEm = 0;
        this.cIu = true;
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(u.e.ds20);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.fEd = new LocationInfoView(context);
        this.fEe = new EditorInfoView(context);
        this.fEf = new EditorInfoView(context);
        this.fEg = new EditorInfoView(context);
        this.fEg.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fEh = new EditorInfoView(context);
        this.fEh.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(u.e.ds16);
        addView(this.fEd, layoutParams);
        addView(this.fEe, layoutParams);
        addView(this.fEf, layoutParams);
        addView(this.fEg, layoutParams);
        addView(this.fEh, layoutParams);
        new LinearLayout.LayoutParams(-1, -2).weight = 1.0f;
        this.fEe.setVisibility(8);
        this.fEf.setVisibility(8);
        this.fEg.setVisibility(8);
        this.fEh.setVisibility(8);
        this.fEd.setOnClickListener(new b(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(u.e.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.fEd;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    this.fEi = 0;
                    this.fEm = 0;
                    this.fEk = 0;
                    this.fEl = 0;
                    this.fEm = 0;
                    break;
                case 10:
                    this.fEm++;
                    break;
                case 11:
                    this.fEm--;
                    break;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aro != null && aVar2.aro.getChosedFiles() != null) {
                            this.fEk = aVar2.aro.getChosedFiles().size();
                            break;
                        }
                    }
                    break;
                case 13:
                    this.fEk--;
                    break;
                case 19:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.c.a)) {
                        com.baidu.tbadk.editortools.c.a aVar3 = (com.baidu.tbadk.editortools.c.a) aVar.data;
                        this.fEd.setVisibility(aVar3.asb ? 0 : 8);
                        this.fEd.k(aVar3.state, aVar3.addr);
                        break;
                    }
                    break;
                case 20:
                    this.fEd.setVisibility(8);
                    break;
                case 22:
                    this.fEl = 1;
                    break;
                case 23:
                    this.fEl = 0;
                    break;
            }
            bkr();
        }
    }

    private void bkr() {
        if (this.fEi > 0) {
            this.fEe.setVisibility(0);
            this.fEe.setText(String.valueOf(this.fEi));
        } else {
            this.fEe.setVisibility(8);
        }
        if (this.fEj > 0) {
            this.fEf.setVisibility(0);
            this.fEf.setText(String.valueOf(this.fEi));
        } else {
            this.fEf.setVisibility(8);
        }
        int i = this.fEk + this.fEl;
        if (i > 0) {
            this.fEg.setVisibility(0);
            this.fEg.setText(String.valueOf(i));
        } else {
            this.fEg.setVisibility(8);
        }
        if (this.fEm > 0) {
            this.fEh.setVisibility(0);
            this.fEh.setText(String.valueOf(this.fEm));
            return;
        }
        this.fEh.setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void kF() {
        if (this.cIu) {
            this.cIu = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.BV;
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
        if (this.fEd != null) {
            this.fEd.vm();
        }
        if (this.fEe != null) {
            this.fEe.vm();
        }
        if (this.fEf != null) {
            this.fEf.vm();
        }
        if (this.fEg != null) {
            this.fEg.vm();
            this.fEg.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.fEh != null) {
            this.fEh.vm();
            this.fEh.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.BW != null) {
            this.BW.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(l lVar) {
        this.BW = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.BV = i;
    }
}
