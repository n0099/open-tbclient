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
    private int Ls;
    private i Lt;
    private TextView bqZ;
    private boolean dmy;
    protected LocationInfoView gDY;
    private EditorInfoView gDZ;
    private com.baidu.tieba.d.b gEa;
    private String gEb;
    private View.OnClickListener mOnClickListener;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dmy = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.bqZ) {
                    a.this.b(new com.baidu.tbadk.editortools.a(51, -1, null));
                }
            }
        };
        int dimension = (int) context.getResources().getDimension(d.f.ds40);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds16);
        this.gDY = new LocationInfoView(context);
        this.gDY.setId(d.h.editor_id_location);
        this.gDZ = new EditorInfoView(context);
        this.gDZ.setId(d.h.view_write_thread_add_title);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = dimensionPixelSize;
        addView(this.gDY, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = dimensionPixelSize;
        layoutParams2.addRule(1, d.h.editor_id_location);
        addView(this.gDZ, layoutParams2);
        this.bqZ = (TextView) LayoutInflater.from(context).inflate(d.j.view_select_forum, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(d.f.ds48));
        layoutParams3.addRule(1, d.h.view_write_thread_add_title);
        addView(this.bqZ, layoutParams3);
        this.bqZ.setOnClickListener(this.mOnClickListener);
        this.gDZ.setText(context.getString(d.l.write_add_title));
        int dimension2 = (int) context.getResources().getDimension(d.f.ds26);
        this.gDZ.setPadding(dimension2, 0, dimension2, 0);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.gDZ.getLayoutParams();
        layoutParams4.rightMargin = dimensionPixelSize;
        this.gDZ.setLayoutParams(layoutParams4);
        ai.i(this.gDZ, d.e.cp_cont_f);
        ai.j(this.gDZ, d.g.write_add_title_bg);
        this.gDY.setPadding(dimension2, 0, dimension2, 0);
        ai.i(this.gDY, d.e.cp_cont_f);
        ai.j(this.gDY, d.g.write_add_title_bg);
        this.gDZ.setVisibility(0);
        this.gDY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }
        });
        this.gDZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gDZ.setVisibility(8);
                a.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
            }
        });
    }

    public void setCallFrom(String str) {
        this.gEb = str;
    }

    public void bza() {
        if (this.gEa != null) {
            this.gEa.YA();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(d.f.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.gDY;
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
                    this.gDY.setVisibility(aVar2.aDO ? 0 : 8);
                    this.gDY.l(aVar2.state, aVar2.addr);
                    return;
                }
                return;
            case 20:
                this.gDY.setVisibility(8);
                return;
            case 21:
                this.gDZ.setVisibility(8);
                return;
            case 50:
                if (aVar.data instanceof c) {
                    c cVar = (c) aVar.data;
                    if ("1".equals(this.gEb)) {
                        if (this.gEa == null) {
                            this.gEa = new com.baidu.tieba.d.b(cVar.context, this.bqZ);
                        }
                        this.gEa.hJ(d.g.pic_sign_tip_down);
                        this.gEa.i(new View.OnClickListener() { // from class: com.baidu.tieba.write.b.a.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.gEa.YA();
                            }
                        });
                        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds10);
                        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.f.ds24);
                        this.gEa.l(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                        this.gEa.hN(0);
                        this.gEa.hO(-67);
                        this.gEa.hK(5000);
                        this.gEa.aI(getResources().getString(d.l.select_forum_tip), "show_select_forum_tip");
                    }
                    if (StringUtils.isNull(cVar.brc)) {
                        this.bqZ.setText(getResources().getString(d.l.select_forum));
                        return;
                    } else {
                        this.bqZ.setText(v.C(cVar.brc, 20));
                        return;
                    }
                }
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lS() {
        if (this.dmy) {
            this.dmy = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Ls;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        if (this.gEa != null) {
            this.gEa.YA();
        }
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        if (this.gDZ != null) {
            this.gDZ.xd();
        }
        if (this.gDY != null) {
            this.gDY.xd();
        }
        ai.i(this.bqZ, d.e.cp_link_tip_a);
        Drawable drawable = ai.getDrawable(d.g.selector_select_forum);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds24);
        drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.bqZ.setCompoundDrawables(null, null, drawable, null);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Lt != null) {
            this.Lt.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Lt = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Ls = i;
    }
}
