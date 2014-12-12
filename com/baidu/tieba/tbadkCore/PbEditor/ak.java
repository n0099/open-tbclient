package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class ak extends LinearLayout implements View.OnClickListener {
    private PbLocationInfoView bUJ;
    private ImageView bUK;
    private com.baidu.tbadk.editortool.w bUt;

    public ak(Context context) {
        this(context, null);
    }

    public ak(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.x.pb_editor_locationinfo_container, this, true);
        initView();
    }

    private void initView() {
        this.bUJ = (PbLocationInfoView) findViewById(com.baidu.tieba.w.location_info_view);
        this.bUK = (ImageView) findViewById(com.baidu.tieba.w.location_info_del);
        this.bUJ.setOnClickListener(this);
        this.bUK.setOnClickListener(this);
    }

    public void qA() {
        this.bUJ.wc();
        com.baidu.tbadk.core.util.ax.i(this, com.baidu.tieba.v.bg_tips_location);
        com.baidu.tbadk.core.util.ax.c(this.bUK, com.baidu.tieba.v.icon_tips_close);
    }

    public void B(int i, String str) {
        this.bUJ.C(i, str);
    }

    public void setLocationInfoViewState(int i) {
        B(i, null);
    }

    public int getLocationInfoViewState() {
        return this.bUJ.getState();
    }

    public int getLocationInfoViewVisibility() {
        return this.bUJ.getVisibility();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        this.bUt = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bUt != null) {
            if (view == this.bUJ) {
                this.bUt.handleAction(52, null);
            } else if (view == this.bUK) {
                this.bUt.handleAction(53, null);
            }
        }
    }
}
