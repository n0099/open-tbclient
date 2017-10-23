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
import com.baidu.tbadk.util.u;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
import com.baidu.tieba.write.a.c;
/* loaded from: classes2.dex */
public class a extends RelativeLayout implements s {
    private int JG;
    private i JH;
    private TextView btw;
    private boolean dpZ;
    private com.baidu.tieba.d.a eIw;
    protected LocationInfoView gIl;
    private EditorInfoView gIm;
    private String gIn;
    private View.OnClickListener mOnClickListener;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dpZ = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.btw) {
                    a.this.b(new com.baidu.tbadk.editortools.a(51, -1, null));
                }
            }
        };
        int dimension = (int) context.getResources().getDimension(d.f.ds40);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds16);
        this.gIl = new LocationInfoView(context);
        this.gIl.setId(d.h.editor_id_location);
        this.gIm = new EditorInfoView(context);
        this.gIm.setId(d.h.view_write_thread_add_title);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = dimensionPixelSize;
        addView(this.gIl, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = dimensionPixelSize;
        layoutParams2.addRule(1, d.h.editor_id_location);
        addView(this.gIm, layoutParams2);
        this.btw = (TextView) LayoutInflater.from(context).inflate(d.j.view_select_forum, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(d.f.ds48));
        layoutParams3.addRule(1, d.h.view_write_thread_add_title);
        addView(this.btw, layoutParams3);
        this.btw.setOnClickListener(this.mOnClickListener);
        this.gIm.setText(context.getString(d.l.write_add_title));
        int dimension2 = (int) context.getResources().getDimension(d.f.ds26);
        this.gIm.setPadding(dimension2, 0, dimension2, 0);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.gIm.getLayoutParams();
        layoutParams4.rightMargin = dimensionPixelSize;
        this.gIm.setLayoutParams(layoutParams4);
        aj.i(this.gIm, d.e.cp_cont_f);
        aj.j(this.gIm, d.g.write_add_title_bg);
        this.gIl.setPadding(dimension2, 0, dimension2, 0);
        aj.i(this.gIl, d.e.cp_cont_f);
        aj.j(this.gIl, d.g.write_add_title_bg);
        this.gIm.setVisibility(0);
        this.gIl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }
        });
        this.gIm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gIm.setVisibility(8);
                a.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
            }
        });
    }

    public void setCallFrom(String str) {
        this.gIn = str;
    }

    public void aRq() {
        if (this.eIw != null) {
            this.eIw.Zv();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(d.f.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.gIl;
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
                    this.gIl.setVisibility(aVar2.aCg ? 0 : 8);
                    this.gIl.k(aVar2.state, aVar2.addr);
                    return;
                }
                return;
            case 20:
                this.gIl.setVisibility(8);
                return;
            case 21:
                this.gIm.setVisibility(8);
                return;
            case 50:
                if (aVar.data instanceof c) {
                    c cVar = (c) aVar.data;
                    if ("1".equals(this.gIn)) {
                        if (this.eIw == null) {
                            this.eIw = new com.baidu.tieba.d.a(cVar.context, this.btw);
                        }
                        this.eIw.id(d.g.pic_sign_tip_down);
                        this.eIw.i(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.a.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.eIw.Zv();
                            }
                        });
                        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds10);
                        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.f.ds24);
                        this.eIw.l(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                        this.eIw.ig(0);
                        this.eIw.ih(-67);
                        this.eIw.ie(5000);
                        this.eIw.aL(getResources().getString(d.l.select_forum_tip), "show_select_forum_tip");
                    }
                    if (StringUtils.isNull(cVar.btz)) {
                        this.btw.setText(getResources().getString(d.l.select_forum));
                        return;
                    } else {
                        this.btw.setText(u.C(cVar.btz, 20));
                        return;
                    }
                }
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lM() {
        if (this.dpZ) {
            this.dpZ = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.JG;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        if (this.eIw != null) {
            this.eIw.Zv();
        }
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        if (this.gIm != null) {
            this.gIm.wu();
        }
        if (this.gIl != null) {
            this.gIl.wu();
        }
        aj.i(this.btw, d.e.cp_link_tip_a);
        Drawable drawable = aj.getDrawable(d.g.selector_select_forum);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds24);
        drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.btw.setCompoundDrawables(null, null, drawable, null);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JH != null) {
            this.JH.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.JH = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.JG = i;
    }
}
