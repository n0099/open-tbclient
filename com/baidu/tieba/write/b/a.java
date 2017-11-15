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
    private TextView bzu;
    private boolean dyi;
    private com.baidu.tieba.d.a eRD;
    protected LocationInfoView gTr;
    private EditorInfoView gTs;
    private String gTt;
    private View.OnClickListener mOnClickListener;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dyi = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.bzu) {
                    a.this.b(new com.baidu.tbadk.editortools.a(51, -1, null));
                }
            }
        };
        int dimension = (int) context.getResources().getDimension(d.e.ds40);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds16);
        this.gTr = new LocationInfoView(context);
        this.gTr.setId(d.g.editor_id_location);
        this.gTs = new EditorInfoView(context);
        this.gTs.setId(d.g.view_write_thread_add_title);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = dimensionPixelSize;
        addView(this.gTr, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = dimensionPixelSize;
        layoutParams2.addRule(1, d.g.editor_id_location);
        addView(this.gTs, layoutParams2);
        this.bzu = (TextView) LayoutInflater.from(context).inflate(d.h.view_select_forum, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(d.e.ds48));
        layoutParams3.addRule(1, d.g.view_write_thread_add_title);
        addView(this.bzu, layoutParams3);
        this.bzu.setOnClickListener(this.mOnClickListener);
        this.gTs.setText(context.getString(d.j.write_add_title));
        int dimension2 = (int) context.getResources().getDimension(d.e.ds26);
        this.gTs.setPadding(dimension2, 0, dimension2, 0);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.gTs.getLayoutParams();
        layoutParams4.rightMargin = dimensionPixelSize;
        this.gTs.setLayoutParams(layoutParams4);
        aj.i(this.gTs, d.C0080d.cp_cont_f);
        aj.j(this.gTs, d.f.write_add_title_bg);
        this.gTr.setPadding(dimension2, 0, dimension2, 0);
        aj.i(this.gTr, d.C0080d.cp_cont_f);
        aj.j(this.gTr, d.f.write_add_title_bg);
        this.gTs.setVisibility(0);
        this.gTr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }
        });
        this.gTs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gTs.setVisibility(8);
                a.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
            }
        });
    }

    public void setCallFrom(String str) {
        this.gTt = str;
    }

    public void aUG() {
        if (this.eRD != null) {
            this.eRD.abQ();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(d.e.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.gTr;
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
                    this.gTr.setVisibility(aVar2.aCX ? 0 : 8);
                    this.gTr.k(aVar2.state, aVar2.addr);
                    return;
                }
                return;
            case 20:
                this.gTr.setVisibility(8);
                return;
            case 21:
                this.gTs.setVisibility(8);
                return;
            case 50:
                if (aVar.data instanceof c) {
                    c cVar = (c) aVar.data;
                    if ("1".equals(this.gTt)) {
                        if (this.eRD == null) {
                            this.eRD = new com.baidu.tieba.d.a(cVar.context, this.bzu);
                        }
                        this.eRD.iu(d.f.pic_sign_tip_down);
                        this.eRD.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.a.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.eRD.abQ();
                            }
                        });
                        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds10);
                        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds24);
                        this.eRD.n(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                        this.eRD.ix(0);
                        this.eRD.iy(-67);
                        this.eRD.iv(5000);
                        this.eRD.aI(getResources().getString(d.j.select_forum_tip), "show_select_forum_tip");
                    }
                    if (StringUtils.isNull(cVar.bzx)) {
                        this.bzu.setText(getResources().getString(d.j.select_forum));
                        return;
                    } else {
                        this.bzu.setText(w.F(cVar.bzx, 20));
                        return;
                    }
                }
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lG() {
        if (this.dyi) {
            this.dyi = false;
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
        if (this.eRD != null) {
            this.eRD.abQ();
        }
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        if (this.gTs != null) {
            this.gTs.wB();
        }
        if (this.gTr != null) {
            this.gTr.wB();
        }
        aj.i(this.bzu, d.C0080d.cp_link_tip_a);
        Drawable drawable = aj.getDrawable(d.f.selector_select_forum);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds24);
        drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.bzu.setCompoundDrawables(null, null, drawable, null);
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
