package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
public class ab extends LinearLayout implements View.OnClickListener {
    private com.baidu.tbadk.editortool.v cqP;
    private PbLocationInfoView crf;
    private ImageView crg;
    private View crh;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        com.baidu.adp.lib.g.b.hr().a(context, com.baidu.tieba.r.pb_editor_locationinfo_container, this, true);
        initView();
    }

    private void initView() {
        this.crf = (PbLocationInfoView) findViewById(com.baidu.tieba.q.location_info_view);
        this.crh = findViewById(com.baidu.tieba.q.pb_editor_location_divider);
        this.crg = (ImageView) findViewById(com.baidu.tieba.q.location_info_del);
        this.crf.setOnClickListener(this);
        this.crg.setOnClickListener(this);
    }

    public void uy() {
        this.crf.rU();
        ay.j(this.crh, com.baidu.tieba.n.cp_cont_e);
        ay.i(this, com.baidu.tieba.n.pb_editor_location_bg_alpha);
        ay.c(this.crg, com.baidu.tieba.p.icon_tips_close);
    }

    public void D(int i, String str) {
        this.crf.C(i, str);
    }

    public void setLocationInfoViewState(int i) {
        D(i, null);
    }

    public int getLocationInfoViewState() {
        return this.crf.getState();
    }

    public int getLocationInfoViewVisibility() {
        return this.crf.getVisibility();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        this.cqP = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cqP != null) {
            if (view == this.crf) {
                this.cqP.handleAction(52, null);
            } else if (view == this.crg) {
                this.cqP.handleAction(53, null);
            }
        }
    }
}
