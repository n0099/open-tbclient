package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
public class ab extends LinearLayout implements View.OnClickListener {
    private com.baidu.tbadk.editortool.v cqQ;
    private PbLocationInfoView crg;
    private ImageView crh;
    private View cri;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        com.baidu.adp.lib.g.b.hr().a(context, com.baidu.tieba.r.pb_editor_locationinfo_container, this, true);
        initView();
    }

    private void initView() {
        this.crg = (PbLocationInfoView) findViewById(com.baidu.tieba.q.location_info_view);
        this.cri = findViewById(com.baidu.tieba.q.pb_editor_location_divider);
        this.crh = (ImageView) findViewById(com.baidu.tieba.q.location_info_del);
        this.crg.setOnClickListener(this);
        this.crh.setOnClickListener(this);
    }

    public void uy() {
        this.crg.rU();
        ay.j(this.cri, com.baidu.tieba.n.cp_cont_e);
        ay.i(this, com.baidu.tieba.n.pb_editor_location_bg_alpha);
        ay.c(this.crh, com.baidu.tieba.p.icon_tips_close);
    }

    public void D(int i, String str) {
        this.crg.C(i, str);
    }

    public void setLocationInfoViewState(int i) {
        D(i, null);
    }

    public int getLocationInfoViewState() {
        return this.crg.getState();
    }

    public int getLocationInfoViewVisibility() {
        return this.crg.getVisibility();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        this.cqQ = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cqQ != null) {
            if (view == this.crg) {
                this.cqQ.handleAction(52, null);
            } else if (view == this.crh) {
                this.cqQ.handleAction(53, null);
            }
        }
    }
}
