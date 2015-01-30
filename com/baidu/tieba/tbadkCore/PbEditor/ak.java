package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public class ak extends LinearLayout implements View.OnClickListener {
    private PbLocationInfoView bWB;
    private ImageView bWC;
    private View bWD;
    private com.baidu.tbadk.editortool.w bWl;

    public ak(Context context) {
        this(context, null);
    }

    public ak(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        com.baidu.adp.lib.g.b.ei().a(context, com.baidu.tieba.x.pb_editor_locationinfo_container, this, true);
        initView();
    }

    private void initView() {
        this.bWB = (PbLocationInfoView) findViewById(com.baidu.tieba.w.location_info_view);
        this.bWD = findViewById(com.baidu.tieba.w.pb_editor_location_divider);
        this.bWC = (ImageView) findViewById(com.baidu.tieba.w.location_info_del);
        this.bWB.setOnClickListener(this);
        this.bWC.setOnClickListener(this);
    }

    public void qL() {
        this.bWB.wu();
        bc.j(this.bWD, com.baidu.tieba.t.cp_cont_e);
        bc.i(this, com.baidu.tieba.t.pb_editor_location_bg_alpha);
        bc.c(this.bWC, com.baidu.tieba.v.icon_tips_close);
    }

    public void B(int i, String str) {
        this.bWB.C(i, str);
    }

    public void setLocationInfoViewState(int i) {
        B(i, null);
    }

    public int getLocationInfoViewState() {
        return this.bWB.getState();
    }

    public int getLocationInfoViewVisibility() {
        return this.bWB.getVisibility();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        this.bWl = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bWl != null) {
            if (view == this.bWB) {
                this.bWl.handleAction(52, null);
            } else if (view == this.bWC) {
                this.bWl.handleAction(53, null);
            }
        }
    }
}
