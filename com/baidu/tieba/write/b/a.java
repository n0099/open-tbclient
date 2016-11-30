package com.baidu.tieba.write.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes.dex */
public class a extends LinearLayout implements ab {
    private int EK;
    private l EL;
    private boolean ddZ;
    protected LocationInfoView glj;
    private EditorInfoView glk;
    private EditorInfoView gll;
    private EditorInfoView glm;
    private EditorInfoView gln;
    private int glo;
    private int glp;
    private int glq;
    private int glr;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.glo = 0;
        this.glp = 0;
        this.glq = 0;
        this.glr = 0;
        this.ddZ = true;
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(r.e.ds20);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.glj = new LocationInfoView(context);
        this.glk = new EditorInfoView(context);
        this.gll = new EditorInfoView(context);
        this.glm = new EditorInfoView(context);
        this.glm.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(r.f.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gln = new EditorInfoView(context);
        this.gln.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(r.f.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(r.e.ds16);
        addView(this.glj, layoutParams);
        addView(this.glk, layoutParams);
        addView(this.gll, layoutParams);
        addView(this.glm, layoutParams);
        addView(this.gln, layoutParams);
        new LinearLayout.LayoutParams(-1, -2).weight = 1.0f;
        this.glk.setVisibility(8);
        this.gll.setVisibility(8);
        this.glm.setVisibility(8);
        this.gln.setVisibility(8);
        this.glj.setOnClickListener(new b(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(r.e.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.glj;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    this.glo = 0;
                    this.glr = 0;
                    this.glq = 0;
                    this.glr = 0;
                    break;
                case 10:
                    this.glr++;
                    break;
                case 11:
                    this.glr--;
                    break;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.avH != null && aVar2.avH.getChosedFiles() != null) {
                            this.glq = aVar2.avH.getChosedFiles().size();
                            break;
                        }
                    }
                    break;
                case 13:
                    this.glq--;
                    break;
                case 19:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.d.a)) {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        this.glj.setVisibility(aVar3.awu ? 0 : 8);
                        this.glj.j(aVar3.state, aVar3.addr);
                        break;
                    }
                    break;
                case 20:
                    this.glj.setVisibility(8);
                    break;
            }
            bve();
        }
    }

    private void bve() {
        if (this.glo > 0) {
            this.glk.setVisibility(0);
            this.glk.setText(String.valueOf(this.glo));
        } else {
            this.glk.setVisibility(8);
        }
        if (this.glp > 0) {
            this.gll.setVisibility(0);
            this.gll.setText(String.valueOf(this.glo));
        } else {
            this.gll.setVisibility(8);
        }
        if (this.glq > 0) {
            this.glm.setVisibility(0);
            this.glm.setText(String.valueOf(this.glq));
        } else {
            this.glm.setVisibility(8);
        }
        if (this.glr > 0) {
            this.gln.setVisibility(0);
            this.gln.setText(String.valueOf(this.glr));
            return;
        }
        this.gln.setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void lz() {
        if (this.ddZ) {
            this.ddZ = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.EK;
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
        if (this.glj != null) {
            this.glj.wM();
        }
        if (this.glk != null) {
            this.glk.wM();
        }
        if (this.gll != null) {
            this.gll.wM();
        }
        if (this.glm != null) {
            this.glm.wM();
            this.glm.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(r.f.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.gln != null) {
            this.gln.wM();
            this.gln.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(r.f.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.EL != null) {
            this.EL.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(l lVar) {
        this.EL = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.EK = i;
    }
}
