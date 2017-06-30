package com.baidu.tieba.write.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends RelativeLayout implements y {
    private int JS;
    private j JT;
    private boolean daD;
    protected LocationInfoView ggV;
    private EditorInfoView ggW;
    private TextView ggX;
    private com.baidu.tieba.d.a ggY;
    private String ggZ;
    private View.OnClickListener mOnClickListener;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.daD = true;
        this.mOnClickListener = new b(this);
        int dimension = (int) context.getResources().getDimension(w.f.ds40);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds16);
        this.ggV = new LocationInfoView(context);
        this.ggV.setId(w.h.editor_id_location);
        this.ggW = new EditorInfoView(context);
        this.ggW.setId(w.h.view_write_thread_add_title);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = dimensionPixelSize;
        addView(this.ggV, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = dimensionPixelSize;
        layoutParams2.addRule(1, w.h.editor_id_location);
        addView(this.ggW, layoutParams2);
        this.ggX = (TextView) LayoutInflater.from(context).inflate(w.j.view_select_forum, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(w.f.ds48));
        layoutParams3.addRule(1, w.h.view_write_thread_add_title);
        addView(this.ggX, layoutParams3);
        this.ggX.setOnClickListener(this.mOnClickListener);
        this.ggW.setText(context.getString(w.l.write_add_title));
        int dimension2 = (int) context.getResources().getDimension(w.f.ds26);
        this.ggW.setPadding(dimension2, 0, dimension2, 0);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.ggW.getLayoutParams();
        layoutParams4.rightMargin = dimensionPixelSize;
        this.ggW.setLayoutParams(layoutParams4);
        as.i(this.ggW, w.e.cp_cont_f);
        as.j(this.ggW, w.g.write_add_title_bg);
        this.ggV.setPadding(dimension2, 0, dimension2, 0);
        as.i(this.ggV, w.e.cp_cont_f);
        as.j(this.ggV, w.g.write_add_title_bg);
        this.ggW.setVisibility(0);
        this.ggV.setOnClickListener(new c(this));
        this.ggW.setOnClickListener(new d(this));
    }

    public void setCallFrom(String str) {
        this.ggZ = str;
    }

    public void bsL() {
        if (this.ggY != null) {
            this.ggY.Xv();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(w.f.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.ggV;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar == null) {
            return;
        }
        switch (aVar.code) {
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case w.n.View_hapticFeedbackEnabled /* 46 */:
            case 49:
            default:
                return;
            case 19:
                if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.d.a)) {
                    com.baidu.tbadk.editortools.d.a aVar2 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                    this.ggV.setVisibility(aVar2.aBw ? 0 : 8);
                    this.ggV.l(aVar2.state, aVar2.addr);
                    return;
                }
                return;
            case 20:
                this.ggV.setVisibility(8);
                return;
            case 21:
                this.ggW.setVisibility(8);
                return;
            case 50:
                if (aVar.data instanceof com.baidu.tieba.write.a.c) {
                    com.baidu.tieba.write.a.c cVar = (com.baidu.tieba.write.a.c) aVar.data;
                    if ("1".equals(this.ggZ)) {
                        if (this.ggY == null) {
                            this.ggY = new com.baidu.tieba.d.a(cVar.context, this.ggX);
                        }
                        this.ggY.hB(w.g.pic_sign_tip_down);
                        this.ggY.o(new e(this));
                        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds10);
                        int dimensionPixelSize2 = getResources().getDimensionPixelSize(w.f.ds24);
                        this.ggY.i(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                        this.ggY.hE(0);
                        this.ggY.hF(-67);
                        this.ggY.hC(5000);
                        this.ggY.aG(getResources().getString(w.l.select_forum_tip), "show_select_forum_tip");
                    }
                    if (StringUtils.isNull(cVar.ggT)) {
                        this.ggX.setText(getResources().getString(w.l.select_forum));
                        return;
                    } else {
                        this.ggX.setText(com.baidu.tbadk.util.y.B(cVar.ggT, 20));
                        return;
                    }
                }
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lM() {
        if (this.daD) {
            this.daD = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.JS;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        if (this.ggY != null) {
            this.ggY.Xv();
        }
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        if (this.ggW != null) {
            this.ggW.wK();
        }
        if (this.ggV != null) {
            this.ggV.wK();
        }
        as.i(this.ggX, w.e.cp_link_tip_a);
        Drawable drawable = as.getDrawable(w.g.selector_select_forum);
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds24);
        drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.ggX.setCompoundDrawables(null, null, drawable, null);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JT != null) {
            this.JT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.JT = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.JS = i;
    }
}
