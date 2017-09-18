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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
import com.baidu.tieba.write.a.c;
/* loaded from: classes2.dex */
public class a extends RelativeLayout implements s {
    private int Jo;
    private i Jp;
    private TextView brY;
    private boolean dtW;
    protected LocationInfoView gDE;
    private EditorInfoView gDF;
    private com.baidu.tieba.d.a gDG;
    private String gDH;
    private View.OnClickListener mOnClickListener;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dtW = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.brY) {
                    a.this.b(new com.baidu.tbadk.editortools.a(51, -1, null));
                }
            }
        };
        int dimension = (int) context.getResources().getDimension(d.f.ds40);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds16);
        this.gDE = new LocationInfoView(context);
        this.gDE.setId(d.h.editor_id_location);
        this.gDF = new EditorInfoView(context);
        this.gDF.setId(d.h.view_write_thread_add_title);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = dimensionPixelSize;
        addView(this.gDE, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = dimensionPixelSize;
        layoutParams2.addRule(1, d.h.editor_id_location);
        addView(this.gDF, layoutParams2);
        this.brY = (TextView) LayoutInflater.from(context).inflate(d.j.view_select_forum, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(d.f.ds48));
        layoutParams3.addRule(1, d.h.view_write_thread_add_title);
        addView(this.brY, layoutParams3);
        this.brY.setOnClickListener(this.mOnClickListener);
        this.gDF.setText(context.getString(d.l.write_add_title));
        int dimension2 = (int) context.getResources().getDimension(d.f.ds26);
        this.gDF.setPadding(dimension2, 0, dimension2, 0);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.gDF.getLayoutParams();
        layoutParams4.rightMargin = dimensionPixelSize;
        this.gDF.setLayoutParams(layoutParams4);
        aj.i(this.gDF, d.e.cp_cont_f);
        aj.j(this.gDF, d.g.write_add_title_bg);
        this.gDE.setPadding(dimension2, 0, dimension2, 0);
        aj.i(this.gDE, d.e.cp_cont_f);
        aj.j(this.gDE, d.g.write_add_title_bg);
        this.gDF.setVisibility(0);
        this.gDE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }
        });
        this.gDF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gDF.setVisibility(8);
                a.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
            }
        });
    }

    public void setCallFrom(String str) {
        this.gDH = str;
    }

    public void aTp() {
        if (this.gDG != null) {
            this.gDG.ZO();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(d.f.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.gDE;
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
            case d.n.View_hapticFeedbackEnabled /* 46 */:
            case 49:
            default:
                return;
            case 19:
                if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.d.a)) {
                    com.baidu.tbadk.editortools.d.a aVar2 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                    this.gDE.setVisibility(aVar2.aDc ? 0 : 8);
                    this.gDE.k(aVar2.state, aVar2.addr);
                    return;
                }
                return;
            case 20:
                this.gDE.setVisibility(8);
                return;
            case 21:
                this.gDF.setVisibility(8);
                return;
            case 50:
                if (aVar.data instanceof c) {
                    c cVar = (c) aVar.data;
                    if ("1".equals(this.gDH)) {
                        if (this.gDG == null) {
                            this.gDG = new com.baidu.tieba.d.a(cVar.context, this.brY);
                        }
                        this.gDG.hW(d.g.pic_sign_tip_down);
                        this.gDG.i(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.a.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.gDG.ZO();
                            }
                        });
                        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds10);
                        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.f.ds24);
                        this.gDG.j(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                        this.gDG.hZ(0);
                        this.gDG.ia(-67);
                        this.gDG.hX(5000);
                        this.gDG.aM(getResources().getString(d.l.select_forum_tip), "show_select_forum_tip");
                    }
                    if (StringUtils.isNull(cVar.bsb)) {
                        this.brY.setText(getResources().getString(d.l.select_forum));
                        return;
                    } else {
                        this.brY.setText(v.C(cVar.bsb, 20));
                        return;
                    }
                }
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lK() {
        if (this.dtW) {
            this.dtW = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Jo;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        if (this.gDG != null) {
            this.gDG.ZO();
        }
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        if (this.gDF != null) {
            this.gDF.xc();
        }
        if (this.gDE != null) {
            this.gDE.xc();
        }
        aj.i(this.brY, d.e.cp_link_tip_a);
        Drawable drawable = aj.getDrawable(d.g.selector_select_forum);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds24);
        drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.brY.setCompoundDrawables(null, null, drawable, null);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Jp != null) {
            this.Jp.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Jp = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Jo = i;
    }
}
