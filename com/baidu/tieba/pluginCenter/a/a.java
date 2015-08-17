package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.pluginCenter.PluginConfigWrapper;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.g.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TbImageView MF;
    private TextView anH;
    private View coA;
    private ImageView coB;
    private int coC;
    private BdSwitchView coy;
    private TextView coz;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.MF = (TbImageView) view.findViewById(i.f.icon);
        this.anH = (TextView) view.findViewById(i.f.title);
        this.coy = (BdSwitchView) view.findViewById(i.f.switchview);
        this.coB = (ImageView) view.findViewById(i.f.downloading_forground);
        this.coA = view.findViewById(i.f.downloading_layout);
        this.coz = (TextView) view.findViewById(i.f.download_text);
        this.coy.setOnSwitchStateChangeListener(new b(this));
        this.coz.setOnClickListener(new c(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: b */
    public void A(PluginConfigWrapper pluginConfigWrapper) {
        super.A(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.MF.d(pluginConfigWrapper.icon, 10, false);
            }
            this.anH.setText(pluginConfigWrapper.display_name);
            c(pluginConfigWrapper.getDownLoadStatus(), pluginConfigWrapper.getDownLoadPercent());
        }
    }

    private void c(int i, float f) {
        switch (i) {
            case 1:
                this.coz.setVisibility(8);
                this.coA.setVisibility(8);
                this.coy.setVisibility(0);
                this.coy.mE();
                return;
            case 2:
                this.coz.setVisibility(8);
                this.coA.setVisibility(8);
                this.coy.setVisibility(0);
                this.coy.mD();
                return;
            case 3:
                this.coz.setVisibility(8);
                this.coA.setVisibility(0);
                this.coy.setVisibility(8);
                x(f);
                return;
            case 4:
                this.coz.setVisibility(0);
                this.coA.setVisibility(8);
                this.coy.setVisibility(8);
                this.coz.setText(i.C0057i.plugin_update);
                return;
            default:
                this.coz.setVisibility(0);
                this.coA.setVisibility(8);
                this.coy.setVisibility(8);
                this.coz.setText(i.C0057i.download);
                return;
        }
    }

    private void x(float f) {
        if (this.coC == 0) {
            this.coC = this.coA.getWidth();
        }
        int i = (int) (this.coC * f);
        if (i < 0) {
            i = 0;
        }
        int i2 = i > this.coC ? this.coC : i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.coB.getLayoutParams();
        layoutParams.width = i2;
        this.coB.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        this.coy.a(al.cq(i.e.bg_switch_open), al.cq(i.e.bg_switch_close), al.cq(i.e.btn_handle));
        return true;
    }
}
