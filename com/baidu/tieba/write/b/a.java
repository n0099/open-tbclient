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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
import com.baidu.tieba.write.a.c;
/* loaded from: classes.dex */
public class a extends RelativeLayout implements s {
    private int Lq;
    private i Lr;
    private TextView bqq;
    private boolean dkB;
    protected LocationInfoView gCg;
    private EditorInfoView gCh;
    private com.baidu.tieba.d.a gCi;
    private String gCj;
    private View.OnClickListener mOnClickListener;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dkB = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.bqq) {
                    a.this.b(new com.baidu.tbadk.editortools.a(51, -1, null));
                }
            }
        };
        int dimension = (int) context.getResources().getDimension(d.f.ds40);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds16);
        this.gCg = new LocationInfoView(context);
        this.gCg.setId(d.h.editor_id_location);
        this.gCh = new EditorInfoView(context);
        this.gCh.setId(d.h.view_write_thread_add_title);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = dimensionPixelSize;
        addView(this.gCg, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = dimensionPixelSize;
        layoutParams2.addRule(1, d.h.editor_id_location);
        addView(this.gCh, layoutParams2);
        this.bqq = (TextView) LayoutInflater.from(context).inflate(d.j.view_select_forum, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(d.f.ds48));
        layoutParams3.addRule(1, d.h.view_write_thread_add_title);
        addView(this.bqq, layoutParams3);
        this.bqq.setOnClickListener(this.mOnClickListener);
        this.gCh.setText(context.getString(d.l.write_add_title));
        int dimension2 = (int) context.getResources().getDimension(d.f.ds26);
        this.gCh.setPadding(dimension2, 0, dimension2, 0);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.gCh.getLayoutParams();
        layoutParams4.rightMargin = dimensionPixelSize;
        this.gCh.setLayoutParams(layoutParams4);
        ai.i(this.gCh, d.e.cp_cont_f);
        ai.j(this.gCh, d.g.write_add_title_bg);
        this.gCg.setPadding(dimension2, 0, dimension2, 0);
        ai.i(this.gCg, d.e.cp_cont_f);
        ai.j(this.gCg, d.g.write_add_title_bg);
        this.gCh.setVisibility(0);
        this.gCg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }
        });
        this.gCh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gCh.setVisibility(8);
                a.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
            }
        });
    }

    public void setCallFrom(String str) {
        this.gCj = str;
    }

    public void byB() {
        if (this.gCi != null) {
            this.gCi.Yi();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(d.f.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.gCg;
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
                    this.gCg.setVisibility(aVar2.aDM ? 0 : 8);
                    this.gCg.l(aVar2.state, aVar2.addr);
                    return;
                }
                return;
            case 20:
                this.gCg.setVisibility(8);
                return;
            case 21:
                this.gCh.setVisibility(8);
                return;
            case 50:
                if (aVar.data instanceof c) {
                    c cVar = (c) aVar.data;
                    if ("1".equals(this.gCj)) {
                        if (this.gCi == null) {
                            this.gCi = new com.baidu.tieba.d.a(cVar.context, this.bqq);
                        }
                        this.gCi.hI(d.g.pic_sign_tip_down);
                        this.gCi.m(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.a.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.gCi.Yi();
                            }
                        });
                        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds10);
                        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.f.ds24);
                        this.gCi.l(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                        this.gCi.hL(0);
                        this.gCi.hM(-67);
                        this.gCi.hJ(5000);
                        this.gCi.aH(getResources().getString(d.l.select_forum_tip), "show_select_forum_tip");
                    }
                    if (StringUtils.isNull(cVar.bqt)) {
                        this.bqq.setText(getResources().getString(d.l.select_forum));
                        return;
                    } else {
                        this.bqq.setText(v.C(cVar.bqt, 20));
                        return;
                    }
                }
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lT() {
        if (this.dkB) {
            this.dkB = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Lq;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        if (this.gCi != null) {
            this.gCi.Yi();
        }
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        if (this.gCh != null) {
            this.gCh.xd();
        }
        if (this.gCg != null) {
            this.gCg.xd();
        }
        ai.i(this.bqq, d.e.cp_link_tip_a);
        Drawable drawable = ai.getDrawable(d.g.selector_select_forum);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds24);
        drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.bqq.setCompoundDrawables(null, null, drawable, null);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Lr != null) {
            this.Lr.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Lr = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Lq = i;
    }
}
