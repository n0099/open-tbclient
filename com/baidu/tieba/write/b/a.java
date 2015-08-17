package com.baidu.tieba.write.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.w;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes.dex */
public class a extends LinearLayout implements w {
    private int Ky;
    private j Kz;
    private boolean arF;
    protected LocationInfoView cRk;
    private EditorInfoView cRl;
    private EditorInfoView cRm;
    private EditorInfoView cRn;
    private EditorInfoView cRo;
    private int cRp;
    private int cRq;
    private int cRr;
    private int cRs;
    private int cRt;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cRp = 0;
        this.cRq = 0;
        this.cRr = 0;
        this.cRs = 0;
        this.cRt = 0;
        this.arF = true;
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(i.d.ds36);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.cRk = new LocationInfoView(context);
        this.cRl = new EditorInfoView(context);
        this.cRm = new EditorInfoView(context);
        this.cRn = new EditorInfoView(context);
        this.cRn.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.cRo = new EditorInfoView(context);
        this.cRo.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(i.d.ds16);
        addView(this.cRk, layoutParams);
        addView(this.cRl, layoutParams);
        addView(this.cRm, layoutParams);
        addView(this.cRn, layoutParams);
        addView(this.cRo, layoutParams);
        this.cRl.setVisibility(8);
        this.cRm.setVisibility(8);
        this.cRn.setVisibility(8);
        this.cRo.setVisibility(8);
        this.cRk.setOnClickListener(new b(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(i.d.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.cRk;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    this.cRp = 0;
                    this.cRt = 0;
                    this.cRr = 0;
                    this.cRs = 0;
                    this.cRt = 0;
                    break;
                case 10:
                    this.cRt++;
                    break;
                case 11:
                    this.cRt--;
                    break;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aqW != null && aVar2.aqW.getChosedFiles() != null) {
                            this.cRr = aVar2.aqW.getChosedFiles().size();
                            break;
                        }
                    }
                    break;
                case 13:
                    this.cRr--;
                    break;
                case 19:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.locationtool.a)) {
                        com.baidu.tbadk.editortools.locationtool.a aVar3 = (com.baidu.tbadk.editortools.locationtool.a) aVar.data;
                        this.cRk.setVisibility(aVar3.arz ? 0 : 8);
                        this.cRk.r(aVar3.state, aVar3.addr);
                        break;
                    }
                    break;
                case 20:
                    this.cRk.setVisibility(8);
                    break;
                case 22:
                    this.cRs = 1;
                    break;
                case 23:
                    this.cRs = 0;
                    break;
            }
            auc();
        }
    }

    private void auc() {
        if (this.cRp > 0) {
            this.cRl.setVisibility(0);
            this.cRl.setText(String.valueOf(this.cRp));
        } else {
            this.cRl.setVisibility(8);
        }
        if (this.cRq > 0) {
            this.cRm.setVisibility(0);
            this.cRm.setText(String.valueOf(this.cRp));
        } else {
            this.cRm.setVisibility(8);
        }
        int i = this.cRr + this.cRs;
        if (i > 0) {
            this.cRn.setVisibility(0);
            this.cRn.setText(String.valueOf(i));
        } else {
            this.cRn.setVisibility(8);
        }
        if (this.cRt > 0) {
            this.cRo.setVisibility(0);
            this.cRo.setText(String.valueOf(this.cRt));
            return;
        }
        this.cRo.setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void oy() {
        if (this.arF) {
            this.arF = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.w
    public int getToolId() {
        return this.Ky;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.w
    public void onChangeSkinType(int i) {
        if (this.cRk != null) {
            this.cRk.vD();
        }
        if (this.cRl != null) {
            this.cRl.vD();
        }
        if (this.cRm != null) {
            this.cRm.vD();
        }
        if (this.cRn != null) {
            this.cRn.vD();
            this.cRn.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.cRo != null) {
            this.cRo.vD();
            this.cRo.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Kz != null) {
            this.Kz.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setEditorTools(j jVar) {
        this.Kz = jVar;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setToolId(int i) {
        this.Ky = i;
    }
}
