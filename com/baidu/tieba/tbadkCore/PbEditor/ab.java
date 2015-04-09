package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class ab extends LinearLayout implements View.OnClickListener {
    private com.baidu.tbadk.editortool.v cmQ;
    private PbLocationInfoView cnh;
    private ImageView cni;
    private View cnj;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        com.baidu.adp.lib.g.b.hH().a(context, com.baidu.tieba.w.pb_editor_locationinfo_container, this, true);
        initView();
    }

    private void initView() {
        this.cnh = (PbLocationInfoView) findViewById(com.baidu.tieba.v.location_info_view);
        this.cnj = findViewById(com.baidu.tieba.v.pb_editor_location_divider);
        this.cni = (ImageView) findViewById(com.baidu.tieba.v.location_info_del);
        this.cnh.setOnClickListener(this);
        this.cni.setOnClickListener(this);
    }

    public void tP() {
        this.cnh.rk();
        ba.j(this.cnj, com.baidu.tieba.s.cp_cont_e);
        ba.i(this, com.baidu.tieba.s.pb_editor_location_bg_alpha);
        ba.c(this.cni, com.baidu.tieba.u.icon_tips_close);
    }

    public void B(int i, String str) {
        this.cnh.A(i, str);
    }

    public void setLocationInfoViewState(int i) {
        B(i, null);
    }

    public int getLocationInfoViewState() {
        return this.cnh.getState();
    }

    public int getLocationInfoViewVisibility() {
        return this.cnh.getVisibility();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        this.cmQ = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cmQ != null) {
            if (view == this.cnh) {
                this.cmQ.handleAction(52, null);
            } else if (view == this.cni) {
                this.cmQ.handleAction(53, null);
            }
        }
    }
}
