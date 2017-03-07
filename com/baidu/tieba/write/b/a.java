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
    private int Lk;
    private j Ll;
    private boolean cSt;
    protected LocationInfoView fMJ;
    private EditorInfoView fMK;
    private EditorInfoView fML;
    private EditorInfoView fMM;
    private EditorInfoView fMN;
    private int fMO;
    private int fMP;
    private int fMQ;
    private int fMR;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fMO = 0;
        this.fMP = 0;
        this.fMQ = 0;
        this.fMR = 0;
        this.cSt = true;
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(w.f.ds20);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.fMJ = new LocationInfoView(context);
        this.fMK = new EditorInfoView(context);
        this.fML = new EditorInfoView(context);
        this.fMM = new EditorInfoView(context);
        this.fMM.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fMN = new EditorInfoView(context);
        this.fMN.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(w.f.ds16);
        addView(this.fMJ, layoutParams);
        addView(this.fMK, layoutParams);
        addView(this.fML, layoutParams);
        addView(this.fMM, layoutParams);
        addView(this.fMN, layoutParams);
        new LinearLayout.LayoutParams(-1, -2).weight = 1.0f;
        this.fMK.setVisibility(8);
        this.fML.setVisibility(8);
        this.fMM.setVisibility(8);
        this.fMN.setVisibility(8);
        this.fMJ.setOnClickListener(new b(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(w.f.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.fMJ;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    this.fMO = 0;
                    this.fMR = 0;
                    this.fMQ = 0;
                    this.fMR = 0;
                    break;
                case 10:
                    this.fMR++;
                    break;
                case 11:
                    this.fMR--;
                    break;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.azE != null && aVar2.azE.getChosedFiles() != null) {
                            this.fMQ = aVar2.azE.getChosedFiles().size();
                            break;
                        }
                    }
                    break;
                case 13:
                    this.fMQ--;
                    break;
                case 19:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.d.a)) {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        this.fMJ.setVisibility(aVar3.aAr ? 0 : 8);
                        this.fMJ.k(aVar3.state, aVar3.addr);
                        break;
                    }
                    break;
                case 20:
                    this.fMJ.setVisibility(8);
                    break;
            }
            bnl();
        }
    }

    private void bnl() {
        if (this.fMO > 0) {
            this.fMK.setVisibility(0);
            this.fMK.setText(String.valueOf(this.fMO));
        } else {
            this.fMK.setVisibility(8);
        }
        if (this.fMP > 0) {
            this.fML.setVisibility(0);
            this.fML.setText(String.valueOf(this.fMO));
        } else {
            this.fML.setVisibility(8);
        }
        if (this.fMQ > 0) {
            this.fMM.setVisibility(0);
            this.fMM.setText(String.valueOf(this.fMQ));
        } else {
            this.fMM.setVisibility(8);
        }
        if (this.fMR > 0) {
            this.fMN.setVisibility(0);
            this.fMN.setText(String.valueOf(this.fMR));
            return;
        }
        this.fMN.setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void ml() {
        if (this.cSt) {
            this.cSt = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.Lk;
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
        if (this.fMJ != null) {
            this.fMJ.wP();
        }
        if (this.fMK != null) {
            this.fMK.wP();
        }
        if (this.fML != null) {
            this.fML.wP();
        }
        if (this.fMM != null) {
            this.fMM.wP();
            this.fMM.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.fMN != null) {
            this.fMN.wP();
            this.fMN.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Ll != null) {
            this.Ll.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.Ll = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.Lk = i;
    }
}
