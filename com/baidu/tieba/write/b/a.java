package com.baidu.tieba.write.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends RelativeLayout implements y {
    private int Kf;
    private j Kg;
    private TextView bTw;
    private boolean cNj;
    protected LocationInfoView fOr;
    private EditorInfoView fOs;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cNj = true;
        int dimension = (int) context.getResources().getDimension(w.f.ds40);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds16);
        this.fOr = new LocationInfoView(context);
        this.fOr.setId(w.h.editor_id_location);
        this.fOs = new EditorInfoView(context);
        this.bTw = new TextView(context);
        this.bTw.setGravity(21);
        this.bTw.setTextSize(0, getResources().getDimension(w.f.fontsize24));
        aq.j(this.bTw, w.g.ic_post_forum_background);
        this.bTw.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        this.bTw.setCompoundDrawablePadding(dimensionPixelSize / 2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = dimensionPixelSize;
        addView(this.fOr, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = dimensionPixelSize;
        layoutParams2.addRule(1, w.h.editor_id_location);
        addView(this.fOs, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, (int) getContext().getResources().getDimension(w.f.ds48));
        layoutParams3.addRule(11);
        addView(this.bTw, layoutParams3);
        this.fOs.setText(context.getString(w.l.write_add_title));
        int dimension2 = (int) context.getResources().getDimension(w.f.ds26);
        this.fOs.setPadding(dimension2, 0, dimension2, 0);
        aq.i(this.fOs, w.e.cp_cont_f);
        aq.j(this.fOs, w.g.write_add_title_bg);
        this.fOr.setPadding(dimension2, 0, dimension2, 0);
        aq.i(this.fOr, w.e.cp_cont_f);
        aq.j(this.fOr, w.g.write_add_title_bg);
        this.fOs.setVisibility(0);
        this.fOr.setOnClickListener(new b(this));
        this.fOs.setOnClickListener(new c(this));
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(w.f.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.fOr;
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
            case 46:
            case TabData.TYPE_TAB_ALA_LIVE /* 49 */:
            default:
                return;
            case 19:
                if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.d.a)) {
                    com.baidu.tbadk.editortools.d.a aVar2 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                    this.fOr.setVisibility(aVar2.aAH ? 0 : 8);
                    this.fOr.l(aVar2.state, aVar2.addr);
                    return;
                }
                return;
            case 20:
                this.fOr.setVisibility(8);
                return;
            case 21:
                this.fOs.setVisibility(8);
                return;
            case 50:
                if (aVar.data instanceof bd) {
                    bd bdVar = (bd) aVar.data;
                    if (StringUtils.isNull(bdVar.getForumName())) {
                        this.bTw.setVisibility(8);
                        return;
                    }
                    String fixedText = au.getFixedText(bdVar.getForumName(), 5, true);
                    this.bTw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aq.getDrawable(BitmapHelper.getGradeResourceIdInEnterForum(bdVar.qU())), (Drawable) null);
                    this.bTw.setText(getContext().getString(w.l.write_publish_forum_tips, fixedText));
                    this.bTw.setVisibility(0);
                    return;
                }
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lW() {
        if (this.cNj) {
            this.cNj = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.Kf;
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
        if (this.fOs != null) {
            this.fOs.ww();
        }
        if (this.fOr != null) {
            this.fOr.ww();
        }
        aq.b(this.bTw, w.e.cp_cont_d, 1, i);
        aq.d(this.bTw, w.g.ic_post_forum_background, i);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Kg != null) {
            this.Kg.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.Kg = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.Kf = i;
    }
}
