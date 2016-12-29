package com.baidu.tieba.write.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes.dex */
public class a extends LinearLayout implements y {
    private int EL;
    private j EM;
    private boolean cIU;
    protected LocationInfoView fzM;
    private EditorInfoView fzN;
    private EditorInfoView fzO;
    private EditorInfoView fzP;
    private EditorInfoView fzQ;
    private int fzR;
    private int fzS;
    private int fzT;
    private int fzU;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fzR = 0;
        this.fzS = 0;
        this.fzT = 0;
        this.fzU = 0;
        this.cIU = true;
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(r.e.ds20);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.fzM = new LocationInfoView(context);
        this.fzN = new EditorInfoView(context);
        this.fzO = new EditorInfoView(context);
        this.fzP = new EditorInfoView(context);
        this.fzP.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(r.f.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fzQ = new EditorInfoView(context);
        this.fzQ.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(r.f.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(r.e.ds16);
        addView(this.fzM, layoutParams);
        addView(this.fzN, layoutParams);
        addView(this.fzO, layoutParams);
        addView(this.fzP, layoutParams);
        addView(this.fzQ, layoutParams);
        new LinearLayout.LayoutParams(-1, -2).weight = 1.0f;
        this.fzN.setVisibility(8);
        this.fzO.setVisibility(8);
        this.fzP.setVisibility(8);
        this.fzQ.setVisibility(8);
        this.fzM.setOnClickListener(new b(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(r.e.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.fzM;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    this.fzR = 0;
                    this.fzU = 0;
                    this.fzT = 0;
                    this.fzU = 0;
                    break;
                case 10:
                    this.fzU++;
                    break;
                case 11:
                    this.fzU--;
                    break;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.ave != null && aVar2.ave.getChosedFiles() != null) {
                            this.fzT = aVar2.ave.getChosedFiles().size();
                            break;
                        }
                    }
                    break;
                case 13:
                    this.fzT--;
                    break;
                case 19:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.d.a)) {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        this.fzM.setVisibility(aVar3.avR ? 0 : 8);
                        this.fzM.j(aVar3.state, aVar3.addr);
                        break;
                    }
                    break;
                case 20:
                    this.fzM.setVisibility(8);
                    break;
            }
            bma();
        }
    }

    private void bma() {
        if (this.fzR > 0) {
            this.fzN.setVisibility(0);
            this.fzN.setText(String.valueOf(this.fzR));
        } else {
            this.fzN.setVisibility(8);
        }
        if (this.fzS > 0) {
            this.fzO.setVisibility(0);
            this.fzO.setText(String.valueOf(this.fzR));
        } else {
            this.fzO.setVisibility(8);
        }
        if (this.fzT > 0) {
            this.fzP.setVisibility(0);
            this.fzP.setText(String.valueOf(this.fzT));
        } else {
            this.fzP.setVisibility(8);
        }
        if (this.fzU > 0) {
            this.fzQ.setVisibility(0);
            this.fzQ.setText(String.valueOf(this.fzU));
            return;
        }
        this.fzQ.setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lz() {
        if (this.cIU) {
            this.cIU = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.EL;
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
        if (this.fzM != null) {
            this.fzM.wx();
        }
        if (this.fzN != null) {
            this.fzN.wx();
        }
        if (this.fzO != null) {
            this.fzO.wx();
        }
        if (this.fzP != null) {
            this.fzP.wx();
            this.fzP.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(r.f.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.fzQ != null) {
            this.fzQ.wx();
            this.fzQ.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(r.f.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.EM != null) {
            this.EM.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.EM = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.EL = i;
    }
}
