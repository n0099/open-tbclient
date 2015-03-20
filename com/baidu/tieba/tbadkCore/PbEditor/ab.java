package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class ab extends LinearLayout implements View.OnClickListener {
    private com.baidu.tbadk.editortool.v cmA;
    private PbLocationInfoView cmR;
    private ImageView cmS;
    private View cmT;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        com.baidu.adp.lib.g.b.hH().a(context, com.baidu.tieba.w.pb_editor_locationinfo_container, this, true);
        initView();
    }

    private void initView() {
        this.cmR = (PbLocationInfoView) findViewById(com.baidu.tieba.v.location_info_view);
        this.cmT = findViewById(com.baidu.tieba.v.pb_editor_location_divider);
        this.cmS = (ImageView) findViewById(com.baidu.tieba.v.location_info_del);
        this.cmR.setOnClickListener(this);
        this.cmS.setOnClickListener(this);
    }

    public void tP() {
        this.cmR.rk();
        ba.j(this.cmT, com.baidu.tieba.s.cp_cont_e);
        ba.i(this, com.baidu.tieba.s.pb_editor_location_bg_alpha);
        ba.c(this.cmS, com.baidu.tieba.u.icon_tips_close);
    }

    public void B(int i, String str) {
        this.cmR.A(i, str);
    }

    public void setLocationInfoViewState(int i) {
        B(i, null);
    }

    public int getLocationInfoViewState() {
        return this.cmR.getState();
    }

    public int getLocationInfoViewVisibility() {
        return this.cmR.getVisibility();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        this.cmA = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cmA != null) {
            if (view == this.cmR) {
                this.cmA.handleAction(52, null);
            } else if (view == this.cmS) {
                this.cmA.handleAction(53, null);
            }
        }
    }
}
