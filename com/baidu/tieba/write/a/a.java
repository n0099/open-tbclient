package com.baidu.tieba.write.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes.dex */
public class a extends LinearLayout implements ab {
    private int BU;
    private l BV;
    private boolean ccY;
    protected LocationInfoView eYZ;
    private EditorInfoView eZa;
    private EditorInfoView eZb;
    private EditorInfoView eZc;
    private EditorInfoView eZd;
    private int eZe;
    private int eZf;
    private int eZg;
    private int eZh;
    private int eZi;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eZe = 0;
        this.eZf = 0;
        this.eZg = 0;
        this.eZh = 0;
        this.eZi = 0;
        this.ccY = true;
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(t.e.ds36);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.eYZ = new LocationInfoView(context);
        this.eZa = new EditorInfoView(context);
        this.eZb = new EditorInfoView(context);
        this.eZc = new EditorInfoView(context);
        this.eZc.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.eZd = new EditorInfoView(context);
        this.eZd.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(t.e.ds16);
        addView(this.eYZ, layoutParams);
        addView(this.eZa, layoutParams);
        addView(this.eZb, layoutParams);
        addView(this.eZc, layoutParams);
        addView(this.eZd, layoutParams);
        new LinearLayout.LayoutParams(-1, -2).weight = 1.0f;
        this.eZa.setVisibility(8);
        this.eZb.setVisibility(8);
        this.eZc.setVisibility(8);
        this.eZd.setVisibility(8);
        this.eYZ.setOnClickListener(new b(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(t.e.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.eYZ;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    this.eZe = 0;
                    this.eZi = 0;
                    this.eZg = 0;
                    this.eZh = 0;
                    this.eZi = 0;
                    break;
                case 10:
                    this.eZi++;
                    break;
                case 11:
                    this.eZi--;
                    break;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aqy != null && aVar2.aqy.getChosedFiles() != null) {
                            this.eZg = aVar2.aqy.getChosedFiles().size();
                            break;
                        }
                    }
                    break;
                case 13:
                    this.eZg--;
                    break;
                case 19:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.c.a)) {
                        com.baidu.tbadk.editortools.c.a aVar3 = (com.baidu.tbadk.editortools.c.a) aVar.data;
                        this.eYZ.setVisibility(aVar3.arl ? 0 : 8);
                        this.eYZ.k(aVar3.state, aVar3.addr);
                        break;
                    }
                    break;
                case 20:
                    this.eYZ.setVisibility(8);
                    break;
                case 22:
                    this.eZh = 1;
                    break;
                case 23:
                    this.eZh = 0;
                    break;
            }
            bbV();
        }
    }

    private void bbV() {
        if (this.eZe > 0) {
            this.eZa.setVisibility(0);
            this.eZa.setText(String.valueOf(this.eZe));
        } else {
            this.eZa.setVisibility(8);
        }
        if (this.eZf > 0) {
            this.eZb.setVisibility(0);
            this.eZb.setText(String.valueOf(this.eZe));
        } else {
            this.eZb.setVisibility(8);
        }
        int i = this.eZg + this.eZh;
        if (i > 0) {
            this.eZc.setVisibility(0);
            this.eZc.setText(String.valueOf(i));
        } else {
            this.eZc.setVisibility(8);
        }
        if (this.eZi > 0) {
            this.eZd.setVisibility(0);
            this.eZd.setText(String.valueOf(this.eZi));
            return;
        }
        this.eZd.setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void kC() {
        if (this.ccY) {
            this.ccY = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.BU;
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
        if (this.eYZ != null) {
            this.eYZ.vm();
        }
        if (this.eZa != null) {
            this.eZa.vm();
        }
        if (this.eZb != null) {
            this.eZb.vm();
        }
        if (this.eZc != null) {
            this.eZc.vm();
            this.eZc.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.eZd != null) {
            this.eZd.vm();
            this.eZd.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.BV != null) {
            this.BV.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(l lVar) {
        this.BV = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.BU = i;
    }
}
