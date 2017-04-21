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
    private int KN;
    private j KO;
    private boolean cTh;
    protected LocationInfoView fQO;
    private EditorInfoView fQP;
    private EditorInfoView fQQ;
    private EditorInfoView fQR;
    private EditorInfoView fQS;
    private int fQT;
    private int fQU;
    private int fQV;
    private int fQW;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fQT = 0;
        this.fQU = 0;
        this.fQV = 0;
        this.fQW = 0;
        this.cTh = true;
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(w.f.ds20);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.fQO = new LocationInfoView(context);
        this.fQP = new EditorInfoView(context);
        this.fQQ = new EditorInfoView(context);
        this.fQR = new EditorInfoView(context);
        this.fQR.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fQS = new EditorInfoView(context);
        this.fQS.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(w.f.ds16);
        addView(this.fQO, layoutParams);
        addView(this.fQP, layoutParams);
        addView(this.fQQ, layoutParams);
        addView(this.fQR, layoutParams);
        addView(this.fQS, layoutParams);
        new LinearLayout.LayoutParams(-1, -2).weight = 1.0f;
        this.fQP.setVisibility(8);
        this.fQQ.setVisibility(8);
        this.fQR.setVisibility(8);
        this.fQS.setVisibility(8);
        this.fQO.setOnClickListener(new b(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(w.f.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.fQO;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    this.fQT = 0;
                    this.fQW = 0;
                    this.fQV = 0;
                    this.fQW = 0;
                    break;
                case 10:
                    this.fQW++;
                    break;
                case 11:
                    this.fQW--;
                    break;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.azW != null && aVar2.azW.getChosedFiles() != null) {
                            this.fQV = aVar2.azW.getChosedFiles().size();
                            break;
                        }
                    }
                    break;
                case 13:
                    this.fQV--;
                    break;
                case 19:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.d.a)) {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        this.fQO.setVisibility(aVar3.aAJ ? 0 : 8);
                        this.fQO.k(aVar3.state, aVar3.addr);
                        break;
                    }
                    break;
                case 20:
                    this.fQO.setVisibility(8);
                    break;
            }
            boW();
        }
    }

    private void boW() {
        if (this.fQT > 0) {
            this.fQP.setVisibility(0);
            this.fQP.setText(String.valueOf(this.fQT));
        } else {
            this.fQP.setVisibility(8);
        }
        if (this.fQU > 0) {
            this.fQQ.setVisibility(0);
            this.fQQ.setText(String.valueOf(this.fQT));
        } else {
            this.fQQ.setVisibility(8);
        }
        if (this.fQV > 0) {
            this.fQR.setVisibility(0);
            this.fQR.setText(String.valueOf(this.fQV));
        } else {
            this.fQR.setVisibility(8);
        }
        if (this.fQW > 0) {
            this.fQS.setVisibility(0);
            this.fQS.setText(String.valueOf(this.fQW));
            return;
        }
        this.fQS.setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void mp() {
        if (this.cTh) {
            this.cTh = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.KN;
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
        if (this.fQO != null) {
            this.fQO.xl();
        }
        if (this.fQP != null) {
            this.fQP.xl();
        }
        if (this.fQQ != null) {
            this.fQQ.xl();
        }
        if (this.fQR != null) {
            this.fQR.xl();
            this.fQR.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.fQS != null) {
            this.fQS.xl();
            this.fQS.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KO != null) {
            this.KO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.KO = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.KN = i;
    }
}
