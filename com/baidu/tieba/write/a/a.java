package com.baidu.tieba.write.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.w;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes.dex */
public class a extends LinearLayout implements w {
    private int Ky;
    private j Kz;
    private boolean arM;
    protected LocationInfoView dkU;
    private EditorInfoView dkV;
    private EditorInfoView dkW;
    private EditorInfoView dkX;
    private EditorInfoView dkY;
    private int dkZ;
    private int dla;
    private int dlb;
    private int dlc;
    private int dld;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dkZ = 0;
        this.dla = 0;
        this.dlb = 0;
        this.dlc = 0;
        this.dld = 0;
        this.arM = true;
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(i.d.ds36);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.dkU = new LocationInfoView(context);
        this.dkV = new EditorInfoView(context);
        this.dkW = new EditorInfoView(context);
        this.dkX = new EditorInfoView(context);
        this.dkX.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.dkY = new EditorInfoView(context);
        this.dkY.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(i.d.ds16);
        addView(this.dkU, layoutParams);
        addView(this.dkV, layoutParams);
        addView(this.dkW, layoutParams);
        addView(this.dkX, layoutParams);
        addView(this.dkY, layoutParams);
        this.dkV.setVisibility(8);
        this.dkW.setVisibility(8);
        this.dkX.setVisibility(8);
        this.dkY.setVisibility(8);
        this.dkU.setOnClickListener(new b(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(i.d.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.dkU;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    this.dkZ = 0;
                    this.dld = 0;
                    this.dlb = 0;
                    this.dlc = 0;
                    this.dld = 0;
                    break;
                case 10:
                    this.dld++;
                    break;
                case 11:
                    this.dld--;
                    break;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.arc != null && aVar2.arc.getChosedFiles() != null) {
                            this.dlb = aVar2.arc.getChosedFiles().size();
                            break;
                        }
                    }
                    break;
                case 13:
                    this.dlb--;
                    break;
                case 19:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.locationtool.a)) {
                        com.baidu.tbadk.editortools.locationtool.a aVar3 = (com.baidu.tbadk.editortools.locationtool.a) aVar.data;
                        this.dkU.setVisibility(aVar3.arG ? 0 : 8);
                        this.dkU.r(aVar3.state, aVar3.addr);
                        break;
                    }
                    break;
                case 20:
                    this.dkU.setVisibility(8);
                    break;
                case 22:
                    this.dlc = 1;
                    break;
                case 23:
                    this.dlc = 0;
                    break;
            }
            aBC();
        }
    }

    private void aBC() {
        if (this.dkZ > 0) {
            this.dkV.setVisibility(0);
            this.dkV.setText(String.valueOf(this.dkZ));
        } else {
            this.dkV.setVisibility(8);
        }
        if (this.dla > 0) {
            this.dkW.setVisibility(0);
            this.dkW.setText(String.valueOf(this.dkZ));
        } else {
            this.dkW.setVisibility(8);
        }
        int i = this.dlb + this.dlc;
        if (i > 0) {
            this.dkX.setVisibility(0);
            this.dkX.setText(String.valueOf(i));
        } else {
            this.dkX.setVisibility(8);
        }
        if (this.dld > 0) {
            this.dkY.setVisibility(0);
            this.dkY.setText(String.valueOf(this.dld));
            return;
        }
        this.dkY.setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void ow() {
        if (this.arM) {
            this.arM = false;
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
        if (this.dkU != null) {
            this.dkU.vA();
        }
        if (this.dkV != null) {
            this.dkV.vA();
        }
        if (this.dkW != null) {
            this.dkW.vA();
        }
        if (this.dkX != null) {
            this.dkX.vA();
            this.dkX.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.dkY != null) {
            this.dkY.vA();
            this.dkY.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
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
