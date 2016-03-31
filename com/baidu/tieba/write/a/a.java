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
    private int LD;
    private l LE;
    private boolean cct;
    protected LocationInfoView eIi;
    private EditorInfoView eIj;
    private EditorInfoView eIk;
    private EditorInfoView eIl;
    private EditorInfoView eIm;
    private int eIn;
    private int eIo;
    private int eIp;
    private int eIq;
    private int eIr;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eIn = 0;
        this.eIo = 0;
        this.eIp = 0;
        this.eIq = 0;
        this.eIr = 0;
        this.cct = true;
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(t.e.ds36);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.eIi = new LocationInfoView(context);
        this.eIj = new EditorInfoView(context);
        this.eIk = new EditorInfoView(context);
        this.eIl = new EditorInfoView(context);
        this.eIl.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.eIm = new EditorInfoView(context);
        this.eIm.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(t.e.ds16);
        addView(this.eIi, layoutParams);
        addView(this.eIj, layoutParams);
        addView(this.eIk, layoutParams);
        addView(this.eIl, layoutParams);
        addView(this.eIm, layoutParams);
        new LinearLayout.LayoutParams(-1, -2).weight = 1.0f;
        this.eIj.setVisibility(8);
        this.eIk.setVisibility(8);
        this.eIl.setVisibility(8);
        this.eIm.setVisibility(8);
        this.eIi.setOnClickListener(new b(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(t.e.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.eIi;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    this.eIn = 0;
                    this.eIr = 0;
                    this.eIp = 0;
                    this.eIq = 0;
                    this.eIr = 0;
                    break;
                case 10:
                    this.eIr++;
                    break;
                case 11:
                    this.eIr--;
                    break;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.auz != null && aVar2.auz.getChosedFiles() != null) {
                            this.eIp = aVar2.auz.getChosedFiles().size();
                            break;
                        }
                    }
                    break;
                case 13:
                    this.eIp--;
                    break;
                case 19:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.c.a)) {
                        com.baidu.tbadk.editortools.c.a aVar3 = (com.baidu.tbadk.editortools.c.a) aVar.data;
                        this.eIi.setVisibility(aVar3.avm ? 0 : 8);
                        this.eIi.k(aVar3.state, aVar3.addr);
                        break;
                    }
                    break;
                case 20:
                    this.eIi.setVisibility(8);
                    break;
                case 22:
                    this.eIq = 1;
                    break;
                case 23:
                    this.eIq = 0;
                    break;
            }
            aZA();
        }
    }

    private void aZA() {
        if (this.eIn > 0) {
            this.eIj.setVisibility(0);
            this.eIj.setText(String.valueOf(this.eIn));
        } else {
            this.eIj.setVisibility(8);
        }
        if (this.eIo > 0) {
            this.eIk.setVisibility(0);
            this.eIk.setText(String.valueOf(this.eIn));
        } else {
            this.eIk.setVisibility(8);
        }
        int i = this.eIp + this.eIq;
        if (i > 0) {
            this.eIl.setVisibility(0);
            this.eIl.setText(String.valueOf(i));
        } else {
            this.eIl.setVisibility(8);
        }
        if (this.eIr > 0) {
            this.eIm.setVisibility(0);
            this.eIm.setText(String.valueOf(this.eIr));
            return;
        }
        this.eIm.setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void op() {
        if (this.cct) {
            this.cct = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.LD;
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
        if (this.eIi != null) {
            this.eIi.xy();
        }
        if (this.eIj != null) {
            this.eIj.xy();
        }
        if (this.eIk != null) {
            this.eIk.xy();
        }
        if (this.eIl != null) {
            this.eIl.xy();
            this.eIl.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.eIm != null) {
            this.eIm.xy();
            this.eIm.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.LE != null) {
            this.LE.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(l lVar) {
        this.LE = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.LD = i;
    }
}
