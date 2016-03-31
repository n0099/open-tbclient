package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pluginCenter.PluginConfigWrapper;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.g.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TbImageView NV;
    private TextView apE;
    private BdSwitchView dRY;
    private TextView dRZ;
    private View dSa;
    private ImageView dSb;
    private int dSc;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.NV = (TbImageView) view.findViewById(t.g.icon);
        this.apE = (TextView) view.findViewById(t.g.title);
        this.dRY = (BdSwitchView) view.findViewById(t.g.switchview);
        this.dSb = (ImageView) view.findViewById(t.g.downloading_forground);
        this.dSa = view.findViewById(t.g.downloading_layout);
        this.dRZ = (TextView) view.findViewById(t.g.download_text);
        this.dRY.setOnSwitchStateChangeListener(new b(this));
        this.dRZ.setOnClickListener(new c(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: b */
    public void B(PluginConfigWrapper pluginConfigWrapper) {
        super.B(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.NV.c(pluginConfigWrapper.icon, 10, false);
            }
            this.apE.setText(pluginConfigWrapper.display_name);
            d(pluginConfigWrapper.getDownLoadStatus(), pluginConfigWrapper.getDownLoadPercent());
        }
    }

    private void d(int i, float f) {
        switch (i) {
            case 1:
                this.dRZ.setVisibility(8);
                this.dSa.setVisibility(8);
                this.dRY.setVisibility(0);
                this.dRY.ml();
                return;
            case 2:
                this.dRZ.setVisibility(8);
                this.dSa.setVisibility(8);
                this.dRY.setVisibility(0);
                this.dRY.mk();
                return;
            case 3:
                this.dRZ.setVisibility(8);
                this.dSa.setVisibility(0);
                this.dRY.setVisibility(8);
                J(f);
                return;
            case 4:
                this.dRZ.setVisibility(0);
                this.dSa.setVisibility(8);
                this.dRY.setVisibility(8);
                this.dRZ.setText(t.j.plugin_update);
                return;
            default:
                this.dRZ.setVisibility(0);
                this.dSa.setVisibility(8);
                this.dRY.setVisibility(8);
                this.dRZ.setText(t.j.download);
                return;
        }
    }

    private void J(float f) {
        if (this.dSc == 0) {
            this.dSc = this.dSa.getWidth();
        }
        int i = (int) (this.dSc * f);
        if (i < 0) {
            i = 0;
        }
        int i2 = i > this.dSc ? this.dSc : i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dSb.getLayoutParams();
        layoutParams.width = i2;
        this.dSb.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        this.dRY.a(at.cR(t.f.bg_switch_open), at.cR(t.f.bg_switch_close), at.cR(t.f.btn_handle));
        return true;
    }
}
