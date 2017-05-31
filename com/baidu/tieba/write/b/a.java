package com.baidu.tieba.write.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends RelativeLayout implements y {
    private int JT;
    private j JU;
    private TextView bZo;
    private boolean cSH;
    protected LocationInfoView fWj;
    private EditorInfoView fWk;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cSH = true;
        int dimension = (int) context.getResources().getDimension(w.f.ds40);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds16);
        this.fWj = new LocationInfoView(context);
        this.fWj.setId(w.h.editor_id_location);
        this.fWk = new EditorInfoView(context);
        this.bZo = new TextView(context);
        this.bZo.setGravity(21);
        this.bZo.setTextSize(0, getResources().getDimension(w.f.fontsize24));
        aq.j(this.bZo, w.g.ic_post_forum_background);
        this.bZo.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        this.bZo.setCompoundDrawablePadding(dimensionPixelSize / 2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = dimensionPixelSize;
        addView(this.fWj, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = dimensionPixelSize;
        layoutParams2.addRule(1, w.h.editor_id_location);
        addView(this.fWk, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, (int) getContext().getResources().getDimension(w.f.ds48));
        layoutParams3.addRule(11);
        addView(this.bZo, layoutParams3);
        this.fWk.setText(context.getString(w.l.write_add_title));
        int dimension2 = (int) context.getResources().getDimension(w.f.ds26);
        this.fWk.setPadding(dimension2, 0, dimension2, 0);
        aq.i(this.fWk, w.e.cp_cont_f);
        aq.j(this.fWk, w.g.write_add_title_bg);
        this.fWj.setPadding(dimension2, 0, dimension2, 0);
        aq.i(this.fWj, w.e.cp_cont_f);
        aq.j(this.fWj, w.g.write_add_title_bg);
        this.fWk.setVisibility(0);
        this.fWj.setOnClickListener(new b(this));
        this.fWk.setOnClickListener(new c(this));
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(w.f.ds62));
    }

    public LocationInfoView getLocationInfoView() {
        return this.fWj;
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
                    this.fWj.setVisibility(aVar2.aAt ? 0 : 8);
                    this.fWj.l(aVar2.state, aVar2.addr);
                    return;
                }
                return;
            case 20:
                this.fWj.setVisibility(8);
                return;
            case 21:
                this.fWk.setVisibility(8);
                return;
            case 50:
                if (aVar.data instanceof be) {
                    be beVar = (be) aVar.data;
                    if (StringUtils.isNull(beVar.getForumName())) {
                        this.bZo.setVisibility(8);
                        return;
                    }
                    String fixedText = au.getFixedText(beVar.getForumName(), 5, true);
                    this.bZo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aq.getDrawable(BitmapHelper.getGradeResourceIdInEnterForum(beVar.qQ())), (Drawable) null);
                    this.bZo.setText(getContext().getString(w.l.write_publish_forum_tips, fixedText));
                    this.bZo.setVisibility(0);
                    return;
                }
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lO() {
        if (this.cSH) {
            this.cSH = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.JT;
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
        if (this.fWk != null) {
            this.fWk.ws();
        }
        if (this.fWj != null) {
            this.fWj.ws();
        }
        aq.b(this.bZo, w.e.cp_cont_d, 1, i);
        aq.d(this.bZo, w.g.ic_post_forum_background, i);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JU != null) {
            this.JU.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.JU = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.JT = i;
    }
}
