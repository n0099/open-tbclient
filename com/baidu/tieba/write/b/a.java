package com.baidu.tieba.write.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a extends LinearLayout implements ab {
    private int Cv;
    private l Cw;
    private boolean cLk;
    protected LocationInfoView fRq;
    private EditorInfoView fRr;
    private EditorInfoView fRs;
    private EditorInfoView fRt;
    private EditorInfoView fRu;
    private int fRv;
    private int fRw;
    private int fRx;
    private int fRy;
    private int fRz;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fRv = 0;
        this.fRw = 0;
        this.fRx = 0;
        this.fRy = 0;
        this.fRz = 0;
        this.cLk = true;
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(u.e.ds20);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.fRq = new LocationInfoView(context);
        this.fRr = new EditorInfoView(context);
        this.fRs = new EditorInfoView(context);
        this.fRt = new EditorInfoView(context);
        this.fRt.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fRu = new EditorInfoView(context);
        this.fRu.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(u.e.ds16);
        addView(this.fRq, layoutParams);
        addView(this.fRr, layoutParams);
        addView(this.fRs, layoutParams);
        addView(this.fRt, layoutParams);
        addView(this.fRu, layoutParams);
        new LinearLayout.LayoutParams(-1, -2).weight = 1.0f;
        this.fRr.setVisibility(8);
        this.fRs.setVisibility(8);
        this.fRt.setVisibility(8);
        this.fRu.setVisibility(8);
        this.fRq.setOnClickListener(new b(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(u.e.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.fRq;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    this.fRv = 0;
                    this.fRz = 0;
                    this.fRx = 0;
                    this.fRy = 0;
                    this.fRz = 0;
                    break;
                case 10:
                    this.fRz++;
                    break;
                case 11:
                    this.fRz--;
                    break;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.asd != null && aVar2.asd.getChosedFiles() != null) {
                            this.fRx = aVar2.asd.getChosedFiles().size();
                            break;
                        }
                    }
                    break;
                case 13:
                    this.fRx--;
                    break;
                case 19:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.c.a)) {
                        com.baidu.tbadk.editortools.c.a aVar3 = (com.baidu.tbadk.editortools.c.a) aVar.data;
                        this.fRq.setVisibility(aVar3.asQ ? 0 : 8);
                        this.fRq.k(aVar3.state, aVar3.addr);
                        break;
                    }
                    break;
                case 20:
                    this.fRq.setVisibility(8);
                    break;
                case 22:
                    this.fRy = 1;
                    break;
                case 23:
                    this.fRy = 0;
                    break;
            }
            bnN();
        }
    }

    private void bnN() {
        if (this.fRv > 0) {
            this.fRr.setVisibility(0);
            this.fRr.setText(String.valueOf(this.fRv));
        } else {
            this.fRr.setVisibility(8);
        }
        if (this.fRw > 0) {
            this.fRs.setVisibility(0);
            this.fRs.setText(String.valueOf(this.fRv));
        } else {
            this.fRs.setVisibility(8);
        }
        int i = this.fRx + this.fRy;
        if (i > 0) {
            this.fRt.setVisibility(0);
            this.fRt.setText(String.valueOf(i));
        } else {
            this.fRt.setVisibility(8);
        }
        if (this.fRz > 0) {
            this.fRu.setVisibility(0);
            this.fRu.setText(String.valueOf(this.fRz));
            return;
        }
        this.fRu.setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void kB() {
        if (this.cLk) {
            this.cLk = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.Cv;
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
        if (this.fRq != null) {
            this.fRq.vm();
        }
        if (this.fRr != null) {
            this.fRr.vm();
        }
        if (this.fRs != null) {
            this.fRs.vm();
        }
        if (this.fRt != null) {
            this.fRt.vm();
            this.fRt.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.fRu != null) {
            this.fRu.vm();
            this.fRu.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Cw != null) {
            this.Cw.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(l lVar) {
        this.Cw = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.Cv = i;
    }
}
