package com.baidu.tieba.write.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes.dex */
public class a extends LinearLayout implements y {
    private int DW;
    private j DX;
    private boolean cQb;
    protected LocationInfoView fIp;
    private EditorInfoView fIq;
    private EditorInfoView fIr;
    private EditorInfoView fIs;
    private EditorInfoView fIt;
    private int fIu;
    private int fIv;
    private int fIw;
    private int fIx;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fIu = 0;
        this.fIv = 0;
        this.fIw = 0;
        this.fIx = 0;
        this.cQb = true;
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(r.f.ds20);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.fIp = new LocationInfoView(context);
        this.fIq = new EditorInfoView(context);
        this.fIr = new EditorInfoView(context);
        this.fIs = new EditorInfoView(context);
        this.fIs.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(r.g.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fIt = new EditorInfoView(context);
        this.fIt.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(r.g.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(r.f.ds16);
        addView(this.fIp, layoutParams);
        addView(this.fIq, layoutParams);
        addView(this.fIr, layoutParams);
        addView(this.fIs, layoutParams);
        addView(this.fIt, layoutParams);
        new LinearLayout.LayoutParams(-1, -2).weight = 1.0f;
        this.fIq.setVisibility(8);
        this.fIr.setVisibility(8);
        this.fIs.setVisibility(8);
        this.fIt.setVisibility(8);
        this.fIp.setOnClickListener(new b(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(r.f.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.fIp;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    this.fIu = 0;
                    this.fIx = 0;
                    this.fIw = 0;
                    this.fIx = 0;
                    break;
                case 10:
                    this.fIx++;
                    break;
                case 11:
                    this.fIx--;
                    break;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.auj != null && aVar2.auj.getChosedFiles() != null) {
                            this.fIw = aVar2.auj.getChosedFiles().size();
                            break;
                        }
                    }
                    break;
                case 13:
                    this.fIw--;
                    break;
                case 19:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.d.a)) {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        this.fIp.setVisibility(aVar3.auW ? 0 : 8);
                        this.fIp.j(aVar3.state, aVar3.addr);
                        break;
                    }
                    break;
                case 20:
                    this.fIp.setVisibility(8);
                    break;
            }
            bny();
        }
    }

    private void bny() {
        if (this.fIu > 0) {
            this.fIq.setVisibility(0);
            this.fIq.setText(String.valueOf(this.fIu));
        } else {
            this.fIq.setVisibility(8);
        }
        if (this.fIv > 0) {
            this.fIr.setVisibility(0);
            this.fIr.setText(String.valueOf(this.fIu));
        } else {
            this.fIr.setVisibility(8);
        }
        if (this.fIw > 0) {
            this.fIs.setVisibility(0);
            this.fIs.setText(String.valueOf(this.fIw));
        } else {
            this.fIs.setVisibility(8);
        }
        if (this.fIx > 0) {
            this.fIt.setVisibility(0);
            this.fIt.setText(String.valueOf(this.fIx));
            return;
        }
        this.fIt.setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lr() {
        if (this.cQb) {
            this.cQb = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.DW;
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
        if (this.fIp != null) {
            this.fIp.ws();
        }
        if (this.fIq != null) {
            this.fIq.ws();
        }
        if (this.fIr != null) {
            this.fIr.ws();
        }
        if (this.fIs != null) {
            this.fIs.ws();
            this.fIs.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(r.g.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.fIt != null) {
            this.fIt.ws();
            this.fIt.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(r.g.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.DX != null) {
            this.DX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.DX = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.DW = i;
    }
}
