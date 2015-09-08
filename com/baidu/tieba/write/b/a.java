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
    private boolean atp;
    protected LocationInfoView cZV;
    private EditorInfoView cZW;
    private EditorInfoView cZX;
    private EditorInfoView cZY;
    private EditorInfoView cZZ;
    private int daa;
    private int dab;
    private int dac;
    private int dad;
    private int dae;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.daa = 0;
        this.dab = 0;
        this.dac = 0;
        this.dad = 0;
        this.dae = 0;
        this.atp = true;
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(i.d.ds36);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.cZV = new LocationInfoView(context);
        this.cZW = new EditorInfoView(context);
        this.cZX = new EditorInfoView(context);
        this.cZY = new EditorInfoView(context);
        this.cZY.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.cZZ = new EditorInfoView(context);
        this.cZZ.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(i.d.ds16);
        addView(this.cZV, layoutParams);
        addView(this.cZW, layoutParams);
        addView(this.cZX, layoutParams);
        addView(this.cZY, layoutParams);
        addView(this.cZZ, layoutParams);
        this.cZW.setVisibility(8);
        this.cZX.setVisibility(8);
        this.cZY.setVisibility(8);
        this.cZZ.setVisibility(8);
        this.cZV.setOnClickListener(new b(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(i.d.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.cZV;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    this.daa = 0;
                    this.dae = 0;
                    this.dac = 0;
                    this.dad = 0;
                    this.dae = 0;
                    break;
                case 10:
                    this.dae++;
                    break;
                case 11:
                    this.dae--;
                    break;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.asG != null && aVar2.asG.getChosedFiles() != null) {
                            this.dac = aVar2.asG.getChosedFiles().size();
                            break;
                        }
                    }
                    break;
                case 13:
                    this.dac--;
                    break;
                case 19:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.locationtool.a)) {
                        com.baidu.tbadk.editortools.locationtool.a aVar3 = (com.baidu.tbadk.editortools.locationtool.a) aVar.data;
                        this.cZV.setVisibility(aVar3.atj ? 0 : 8);
                        this.cZV.r(aVar3.state, aVar3.addr);
                        break;
                    }
                    break;
                case 20:
                    this.cZV.setVisibility(8);
                    break;
                case 22:
                    this.dad = 1;
                    break;
                case 23:
                    this.dad = 0;
                    break;
            }
            ayv();
        }
    }

    private void ayv() {
        if (this.daa > 0) {
            this.cZW.setVisibility(0);
            this.cZW.setText(String.valueOf(this.daa));
        } else {
            this.cZW.setVisibility(8);
        }
        if (this.dab > 0) {
            this.cZX.setVisibility(0);
            this.cZX.setText(String.valueOf(this.daa));
        } else {
            this.cZX.setVisibility(8);
        }
        int i = this.dac + this.dad;
        if (i > 0) {
            this.cZY.setVisibility(0);
            this.cZY.setText(String.valueOf(i));
        } else {
            this.cZY.setVisibility(8);
        }
        if (this.dae > 0) {
            this.cZZ.setVisibility(0);
            this.cZZ.setText(String.valueOf(this.dae));
            return;
        }
        this.cZZ.setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void ov() {
        if (this.atp) {
            this.atp = false;
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
        if (this.cZV != null) {
            this.cZV.vI();
        }
        if (this.cZW != null) {
            this.cZW.vI();
        }
        if (this.cZX != null) {
            this.cZX.vI();
        }
        if (this.cZY != null) {
            this.cZY.vI();
            this.cZY.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.cZZ != null) {
            this.cZZ.vI();
            this.cZZ.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
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
