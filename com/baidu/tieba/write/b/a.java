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
import com.baidu.tbadk.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
import com.baidu.tieba.write.a.c;
/* loaded from: classes2.dex */
public class a extends RelativeLayout implements s {
    private int Ja;
    private i Jb;
    private TextView bzi;
    private boolean dxO;
    private com.baidu.tieba.d.a eRj;
    protected LocationInfoView gSj;
    private EditorInfoView gSk;
    private String gSl;
    private View.OnClickListener mOnClickListener;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dxO = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.bzi) {
                    a.this.b(new com.baidu.tbadk.editortools.a(51, -1, null));
                }
            }
        };
        int dimension = (int) context.getResources().getDimension(d.e.ds40);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds16);
        this.gSj = new LocationInfoView(context);
        this.gSj.setId(d.g.editor_id_location);
        this.gSk = new EditorInfoView(context);
        this.gSk.setId(d.g.view_write_thread_add_title);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = dimensionPixelSize;
        addView(this.gSj, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = dimensionPixelSize;
        layoutParams2.addRule(1, d.g.editor_id_location);
        addView(this.gSk, layoutParams2);
        this.bzi = (TextView) LayoutInflater.from(context).inflate(d.h.view_select_forum, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(d.e.ds48));
        layoutParams3.addRule(1, d.g.view_write_thread_add_title);
        addView(this.bzi, layoutParams3);
        this.bzi.setOnClickListener(this.mOnClickListener);
        this.gSk.setText(context.getString(d.j.write_add_title));
        int dimension2 = (int) context.getResources().getDimension(d.e.ds26);
        this.gSk.setPadding(dimension2, 0, dimension2, 0);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.gSk.getLayoutParams();
        layoutParams4.rightMargin = dimensionPixelSize;
        this.gSk.setLayoutParams(layoutParams4);
        aj.i(this.gSk, d.C0080d.cp_cont_f);
        aj.j(this.gSk, d.f.write_add_title_bg);
        this.gSj.setPadding(dimension2, 0, dimension2, 0);
        aj.i(this.gSj, d.C0080d.cp_cont_f);
        aj.j(this.gSj, d.f.write_add_title_bg);
        this.gSk.setVisibility(0);
        this.gSj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }
        });
        this.gSk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gSk.setVisibility(8);
                a.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
            }
        });
    }

    public void setCallFrom(String str) {
        this.gSl = str;
    }

    public void aUy() {
        if (this.eRj != null) {
            this.eRj.abE();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(d.e.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.gSj;
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
            case d.l.View_hapticFeedbackEnabled /* 46 */:
            case 49:
            default:
                return;
            case 19:
                if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.d.a)) {
                    com.baidu.tbadk.editortools.d.a aVar2 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                    this.gSj.setVisibility(aVar2.aCP ? 0 : 8);
                    this.gSj.k(aVar2.state, aVar2.addr);
                    return;
                }
                return;
            case 20:
                this.gSj.setVisibility(8);
                return;
            case 21:
                this.gSk.setVisibility(8);
                return;
            case 50:
                if (aVar.data instanceof c) {
                    c cVar = (c) aVar.data;
                    if ("1".equals(this.gSl)) {
                        if (this.eRj == null) {
                            this.eRj = new com.baidu.tieba.d.a(cVar.context, this.bzi);
                        }
                        this.eRj.iw(d.f.pic_sign_tip_down);
                        this.eRj.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.a.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.eRj.abE();
                            }
                        });
                        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds10);
                        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds24);
                        this.eRj.n(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                        this.eRj.iz(0);
                        this.eRj.iA(-67);
                        this.eRj.ix(5000);
                        this.eRj.aH(getResources().getString(d.j.select_forum_tip), "show_select_forum_tip");
                    }
                    if (StringUtils.isNull(cVar.bzl)) {
                        this.bzi.setText(getResources().getString(d.j.select_forum));
                        return;
                    } else {
                        this.bzi.setText(w.F(cVar.bzl, 20));
                        return;
                    }
                }
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lG() {
        if (this.dxO) {
            this.dxO = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Ja;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        if (this.eRj != null) {
            this.eRj.abE();
        }
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        if (this.gSk != null) {
            this.gSk.wB();
        }
        if (this.gSj != null) {
            this.gSj.wB();
        }
        aj.i(this.bzi, d.C0080d.cp_link_tip_a);
        Drawable drawable = aj.getDrawable(d.f.selector_select_forum);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds24);
        drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.bzi.setCompoundDrawables(null, null, drawable, null);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Jb != null) {
            this.Jb.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Jb = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Ja = i;
    }
}
