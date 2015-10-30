package com.baidu.tieba.write.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.w;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes.dex */
public class a extends LinearLayout implements w {
    private j KA;
    private int Kz;
    private boolean arN;
    private int dlA;
    private int dlB;
    private int dlC;
    private int dlD;
    protected LocationInfoView dlu;
    private EditorInfoView dlv;
    private EditorInfoView dlw;
    private EditorInfoView dlx;
    private EditorInfoView dly;
    private int dlz;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dlz = 0;
        this.dlA = 0;
        this.dlB = 0;
        this.dlC = 0;
        this.dlD = 0;
        this.arN = true;
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(i.d.ds36);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.dlu = new LocationInfoView(context);
        this.dlv = new EditorInfoView(context);
        this.dlw = new EditorInfoView(context);
        this.dlx = new EditorInfoView(context);
        this.dlx.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.dly = new EditorInfoView(context);
        this.dly.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(i.d.ds16);
        addView(this.dlu, layoutParams);
        addView(this.dlv, layoutParams);
        addView(this.dlw, layoutParams);
        addView(this.dlx, layoutParams);
        addView(this.dly, layoutParams);
        this.dlv.setVisibility(8);
        this.dlw.setVisibility(8);
        this.dlx.setVisibility(8);
        this.dly.setVisibility(8);
        this.dlu.setOnClickListener(new b(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(i.d.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.dlu;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    this.dlz = 0;
                    this.dlD = 0;
                    this.dlB = 0;
                    this.dlC = 0;
                    this.dlD = 0;
                    break;
                case 10:
                    this.dlD++;
                    break;
                case 11:
                    this.dlD--;
                    break;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.ard != null && aVar2.ard.getChosedFiles() != null) {
                            this.dlB = aVar2.ard.getChosedFiles().size();
                            break;
                        }
                    }
                    break;
                case 13:
                    this.dlB--;
                    break;
                case 19:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.locationtool.a)) {
                        com.baidu.tbadk.editortools.locationtool.a aVar3 = (com.baidu.tbadk.editortools.locationtool.a) aVar.data;
                        this.dlu.setVisibility(aVar3.arH ? 0 : 8);
                        this.dlu.r(aVar3.state, aVar3.addr);
                        break;
                    }
                    break;
                case 20:
                    this.dlu.setVisibility(8);
                    break;
                case 22:
                    this.dlC = 1;
                    break;
                case 23:
                    this.dlC = 0;
                    break;
            }
            aBI();
        }
    }

    private void aBI() {
        if (this.dlz > 0) {
            this.dlv.setVisibility(0);
            this.dlv.setText(String.valueOf(this.dlz));
        } else {
            this.dlv.setVisibility(8);
        }
        if (this.dlA > 0) {
            this.dlw.setVisibility(0);
            this.dlw.setText(String.valueOf(this.dlz));
        } else {
            this.dlw.setVisibility(8);
        }
        int i = this.dlB + this.dlC;
        if (i > 0) {
            this.dlx.setVisibility(0);
            this.dlx.setText(String.valueOf(i));
        } else {
            this.dlx.setVisibility(8);
        }
        if (this.dlD > 0) {
            this.dly.setVisibility(0);
            this.dly.setText(String.valueOf(this.dlD));
            return;
        }
        this.dly.setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void ow() {
        if (this.arN) {
            this.arN = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.w
    public int getToolId() {
        return this.Kz;
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
        if (this.dlu != null) {
            this.dlu.vx();
        }
        if (this.dlv != null) {
            this.dlv.vx();
        }
        if (this.dlw != null) {
            this.dlw.vx();
        }
        if (this.dlx != null) {
            this.dlx.vx();
            this.dlx.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.dly != null) {
            this.dly.vx();
            this.dly.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KA != null) {
            this.KA.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setEditorTools(j jVar) {
        this.KA = jVar;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setToolId(int i) {
        this.Kz = i;
    }
}
