package com.baidu.tieba.write.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.editortools.z;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes.dex */
public class a extends LinearLayout implements z {
    private int Lh;
    private k Li;
    private boolean bNS;
    protected LocationInfoView dTH;
    private EditorInfoView dTI;
    private EditorInfoView dTJ;
    private EditorInfoView dTK;
    private EditorInfoView dTL;
    private int dTM;
    private int dTN;
    private int dTO;
    private int dTP;
    private int dTQ;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dTM = 0;
        this.dTN = 0;
        this.dTO = 0;
        this.dTP = 0;
        this.dTQ = 0;
        this.bNS = true;
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(n.e.ds36);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.dTH = new LocationInfoView(context);
        this.dTI = new EditorInfoView(context);
        this.dTJ = new EditorInfoView(context);
        this.dTK = new EditorInfoView(context);
        this.dTK.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.dTL = new EditorInfoView(context);
        this.dTL.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(n.e.ds16);
        addView(this.dTH, layoutParams);
        addView(this.dTI, layoutParams);
        addView(this.dTJ, layoutParams);
        addView(this.dTK, layoutParams);
        addView(this.dTL, layoutParams);
        new LinearLayout.LayoutParams(-1, -2).weight = 1.0f;
        this.dTI.setVisibility(8);
        this.dTJ.setVisibility(8);
        this.dTK.setVisibility(8);
        this.dTL.setVisibility(8);
        this.dTH.setOnClickListener(new b(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(n.e.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.dTH;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    this.dTM = 0;
                    this.dTQ = 0;
                    this.dTO = 0;
                    this.dTP = 0;
                    this.dTQ = 0;
                    break;
                case 10:
                    this.dTQ++;
                    break;
                case 11:
                    this.dTQ--;
                    break;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.ath != null && aVar2.ath.getChosedFiles() != null) {
                            this.dTO = aVar2.ath.getChosedFiles().size();
                            break;
                        }
                    }
                    break;
                case 13:
                    this.dTO--;
                    break;
                case 19:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.c.a)) {
                        com.baidu.tbadk.editortools.c.a aVar3 = (com.baidu.tbadk.editortools.c.a) aVar.data;
                        this.dTH.setVisibility(aVar3.atU ? 0 : 8);
                        this.dTH.s(aVar3.state, aVar3.addr);
                        break;
                    }
                    break;
                case 20:
                    this.dTH.setVisibility(8);
                    break;
                case 22:
                    this.dTP = 1;
                    break;
                case 23:
                    this.dTP = 0;
                    break;
            }
            aKq();
        }
    }

    private void aKq() {
        if (this.dTM > 0) {
            this.dTI.setVisibility(0);
            this.dTI.setText(String.valueOf(this.dTM));
        } else {
            this.dTI.setVisibility(8);
        }
        if (this.dTN > 0) {
            this.dTJ.setVisibility(0);
            this.dTJ.setText(String.valueOf(this.dTM));
        } else {
            this.dTJ.setVisibility(8);
        }
        int i = this.dTO + this.dTP;
        if (i > 0) {
            this.dTK.setVisibility(0);
            this.dTK.setText(String.valueOf(i));
        } else {
            this.dTK.setVisibility(8);
        }
        if (this.dTQ > 0) {
            this.dTL.setVisibility(0);
            this.dTL.setText(String.valueOf(this.dTQ));
            return;
        }
        this.dTL.setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void ob() {
        if (this.bNS) {
            this.bNS = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.z
    public int getToolId() {
        return this.Lh;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.z
    public void onChangeSkinType(int i) {
        if (this.dTH != null) {
            this.dTH.vR();
        }
        if (this.dTI != null) {
            this.dTI.vR();
        }
        if (this.dTJ != null) {
            this.dTJ.vR();
        }
        if (this.dTK != null) {
            this.dTK.vR();
            this.dTK.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.dTL != null) {
            this.dTL.vR();
            this.dTL.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Li != null) {
            this.Li.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setEditorTools(k kVar) {
        this.Li = kVar;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setToolId(int i) {
        this.Lh = i;
    }
}
