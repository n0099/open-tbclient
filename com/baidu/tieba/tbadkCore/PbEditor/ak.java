package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public class ak extends LinearLayout implements View.OnClickListener {
    private PbLocationInfoView bWA;
    private ImageView bWB;
    private View bWC;
    private com.baidu.tbadk.editortool.w bWk;

    public ak(Context context) {
        this(context, null);
    }

    public ak(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        com.baidu.adp.lib.g.b.ei().a(context, com.baidu.tieba.x.pb_editor_locationinfo_container, this, true);
        initView();
    }

    private void initView() {
        this.bWA = (PbLocationInfoView) findViewById(com.baidu.tieba.w.location_info_view);
        this.bWC = findViewById(com.baidu.tieba.w.pb_editor_location_divider);
        this.bWB = (ImageView) findViewById(com.baidu.tieba.w.location_info_del);
        this.bWA.setOnClickListener(this);
        this.bWB.setOnClickListener(this);
    }

    public void qF() {
        this.bWA.wo();
        bc.j(this.bWC, com.baidu.tieba.t.cp_cont_e);
        bc.i(this, com.baidu.tieba.t.pb_editor_location_bg_alpha);
        bc.c(this.bWB, com.baidu.tieba.v.icon_tips_close);
    }

    public void B(int i, String str) {
        this.bWA.C(i, str);
    }

    public void setLocationInfoViewState(int i) {
        B(i, null);
    }

    public int getLocationInfoViewState() {
        return this.bWA.getState();
    }

    public int getLocationInfoViewVisibility() {
        return this.bWA.getVisibility();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        this.bWk = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bWk != null) {
            if (view == this.bWA) {
                this.bWk.handleAction(52, null);
            } else if (view == this.bWB) {
                this.bWk.handleAction(53, null);
            }
        }
    }
}
