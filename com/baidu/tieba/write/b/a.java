package com.baidu.tieba.write.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes.dex */
public class a extends LinearLayout implements ab {
    private int EI;
    private l EJ;
    private boolean cWP;
    private int gbA;
    private int gbB;
    private int gbC;
    private int gbD;
    private int gbE;
    protected LocationInfoView gbv;
    private EditorInfoView gbw;
    private EditorInfoView gbx;
    private EditorInfoView gby;
    private EditorInfoView gbz;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gbA = 0;
        this.gbB = 0;
        this.gbC = 0;
        this.gbD = 0;
        this.gbE = 0;
        this.cWP = true;
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(t.e.ds20);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.gbv = new LocationInfoView(context);
        this.gbw = new EditorInfoView(context);
        this.gbx = new EditorInfoView(context);
        this.gby = new EditorInfoView(context);
        this.gby.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(t.f.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gbz = new EditorInfoView(context);
        this.gbz.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(t.f.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(t.e.ds16);
        addView(this.gbv, layoutParams);
        addView(this.gbw, layoutParams);
        addView(this.gbx, layoutParams);
        addView(this.gby, layoutParams);
        addView(this.gbz, layoutParams);
        new LinearLayout.LayoutParams(-1, -2).weight = 1.0f;
        this.gbw.setVisibility(8);
        this.gbx.setVisibility(8);
        this.gby.setVisibility(8);
        this.gbz.setVisibility(8);
        this.gbv.setOnClickListener(new b(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(t.e.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.gbv;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    this.gbA = 0;
                    this.gbE = 0;
                    this.gbC = 0;
                    this.gbD = 0;
                    this.gbE = 0;
                    break;
                case 10:
                    this.gbE++;
                    break;
                case 11:
                    this.gbE--;
                    break;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.avk != null && aVar2.avk.getChosedFiles() != null) {
                            this.gbC = aVar2.avk.getChosedFiles().size();
                            break;
                        }
                    }
                    break;
                case 13:
                    this.gbC--;
                    break;
                case 19:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.c.a)) {
                        com.baidu.tbadk.editortools.c.a aVar3 = (com.baidu.tbadk.editortools.c.a) aVar.data;
                        this.gbv.setVisibility(aVar3.avX ? 0 : 8);
                        this.gbv.k(aVar3.state, aVar3.addr);
                        break;
                    }
                    break;
                case 20:
                    this.gbv.setVisibility(8);
                    break;
                case 22:
                    this.gbD = 1;
                    break;
                case 23:
                    this.gbD = 0;
                    break;
            }
            bsd();
        }
    }

    private void bsd() {
        if (this.gbA > 0) {
            this.gbw.setVisibility(0);
            this.gbw.setText(String.valueOf(this.gbA));
        } else {
            this.gbw.setVisibility(8);
        }
        if (this.gbB > 0) {
            this.gbx.setVisibility(0);
            this.gbx.setText(String.valueOf(this.gbA));
        } else {
            this.gbx.setVisibility(8);
        }
        int i = this.gbC + this.gbD;
        if (i > 0) {
            this.gby.setVisibility(0);
            this.gby.setText(String.valueOf(i));
        } else {
            this.gby.setVisibility(8);
        }
        if (this.gbE > 0) {
            this.gbz.setVisibility(0);
            this.gbz.setText(String.valueOf(this.gbE));
            return;
        }
        this.gbz.setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void lw() {
        if (this.cWP) {
            this.cWP = false;
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
        if (this.gbv != null) {
            this.gbv.wq();
        }
        if (this.gbw != null) {
            this.gbw.wq();
        }
        if (this.gbx != null) {
            this.gbx.wq();
        }
        if (this.gby != null) {
            this.gby.wq();
            this.gby.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(t.f.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.gbz != null) {
            this.gbz.wq();
            this.gbz.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(t.f.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
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
