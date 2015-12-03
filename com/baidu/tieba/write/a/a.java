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
    private int KR;
    private k KS;
    private boolean bKl;
    protected LocationInfoView dMi;
    private EditorInfoView dMj;
    private EditorInfoView dMk;
    private EditorInfoView dMl;
    private EditorInfoView dMm;
    private int dMn;
    private int dMo;
    private int dMp;
    private int dMq;
    private int dMr;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dMn = 0;
        this.dMo = 0;
        this.dMp = 0;
        this.dMq = 0;
        this.dMr = 0;
        this.bKl = true;
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(n.d.ds36);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.dMi = new LocationInfoView(context);
        this.dMj = new EditorInfoView(context);
        this.dMk = new EditorInfoView(context);
        this.dMl = new EditorInfoView(context);
        this.dMl.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.dMm = new EditorInfoView(context);
        this.dMm.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(n.d.ds16);
        addView(this.dMi, layoutParams);
        addView(this.dMj, layoutParams);
        addView(this.dMk, layoutParams);
        addView(this.dMl, layoutParams);
        addView(this.dMm, layoutParams);
        new LinearLayout.LayoutParams(-1, -2).weight = 1.0f;
        this.dMj.setVisibility(8);
        this.dMk.setVisibility(8);
        this.dMl.setVisibility(8);
        this.dMm.setVisibility(8);
        this.dMi.setOnClickListener(new b(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(n.d.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.dMi;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    this.dMn = 0;
                    this.dMr = 0;
                    this.dMp = 0;
                    this.dMq = 0;
                    this.dMr = 0;
                    break;
                case 10:
                    this.dMr++;
                    break;
                case 11:
                    this.dMr--;
                    break;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.arD != null && aVar2.arD.getChosedFiles() != null) {
                            this.dMp = aVar2.arD.getChosedFiles().size();
                            break;
                        }
                    }
                    break;
                case 13:
                    this.dMp--;
                    break;
                case 19:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.c.a)) {
                        com.baidu.tbadk.editortools.c.a aVar3 = (com.baidu.tbadk.editortools.c.a) aVar.data;
                        this.dMi.setVisibility(aVar3.asq ? 0 : 8);
                        this.dMi.s(aVar3.state, aVar3.addr);
                        break;
                    }
                    break;
                case 20:
                    this.dMi.setVisibility(8);
                    break;
                case 22:
                    this.dMq = 1;
                    break;
                case 23:
                    this.dMq = 0;
                    break;
            }
            aHV();
        }
    }

    private void aHV() {
        if (this.dMn > 0) {
            this.dMj.setVisibility(0);
            this.dMj.setText(String.valueOf(this.dMn));
        } else {
            this.dMj.setVisibility(8);
        }
        if (this.dMo > 0) {
            this.dMk.setVisibility(0);
            this.dMk.setText(String.valueOf(this.dMn));
        } else {
            this.dMk.setVisibility(8);
        }
        int i = this.dMp + this.dMq;
        if (i > 0) {
            this.dMl.setVisibility(0);
            this.dMl.setText(String.valueOf(i));
        } else {
            this.dMl.setVisibility(8);
        }
        if (this.dMr > 0) {
            this.dMm.setVisibility(0);
            this.dMm.setText(String.valueOf(this.dMr));
            return;
        }
        this.dMm.setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void oD() {
        if (this.bKl) {
            this.bKl = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.z
    public int getToolId() {
        return this.KR;
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
        if (this.dMi != null) {
            this.dMi.wh();
        }
        if (this.dMj != null) {
            this.dMj.wh();
        }
        if (this.dMk != null) {
            this.dMk.wh();
        }
        if (this.dMl != null) {
            this.dMl.wh();
            this.dMl.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.dMm != null) {
            this.dMm.wh();
            this.dMm.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KS != null) {
            this.KS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setEditorTools(k kVar) {
        this.KS = kVar;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setToolId(int i) {
        this.KR = i;
    }
}
