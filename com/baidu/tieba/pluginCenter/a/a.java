package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.pluginCenter.PluginConfigWrapper;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.g.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TbImageView MW;
    private TextView agd;
    private BdSwitchView ddT;
    private TextView ddU;
    private View ddV;
    private ImageView ddW;
    private int ddX;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.MW = (TbImageView) view.findViewById(n.f.icon);
        this.agd = (TextView) view.findViewById(n.f.title);
        this.ddT = (BdSwitchView) view.findViewById(n.f.switchview);
        this.ddW = (ImageView) view.findViewById(n.f.downloading_forground);
        this.ddV = view.findViewById(n.f.downloading_layout);
        this.ddU = (TextView) view.findViewById(n.f.download_text);
        this.ddT.setOnSwitchStateChangeListener(new b(this));
        this.ddU.setOnClickListener(new c(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: b */
    public void B(PluginConfigWrapper pluginConfigWrapper) {
        super.B(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.MW.d(pluginConfigWrapper.icon, 10, false);
            }
            this.agd.setText(pluginConfigWrapper.display_name);
            c(pluginConfigWrapper.getDownLoadStatus(), pluginConfigWrapper.getDownLoadPercent());
        }
    }

    private void c(int i, float f) {
        switch (i) {
            case 1:
                this.ddU.setVisibility(8);
                this.ddV.setVisibility(8);
                this.ddT.setVisibility(0);
                this.ddT.mH();
                return;
            case 2:
                this.ddU.setVisibility(8);
                this.ddV.setVisibility(8);
                this.ddT.setVisibility(0);
                this.ddT.mG();
                return;
            case 3:
                this.ddU.setVisibility(8);
                this.ddV.setVisibility(0);
                this.ddT.setVisibility(8);
                y(f);
                return;
            case 4:
                this.ddU.setVisibility(0);
                this.ddV.setVisibility(8);
                this.ddT.setVisibility(8);
                this.ddU.setText(n.i.plugin_update);
                return;
            default:
                this.ddU.setVisibility(0);
                this.ddV.setVisibility(8);
                this.ddT.setVisibility(8);
                this.ddU.setText(n.i.download);
                return;
        }
    }

    private void y(float f) {
        if (this.ddX == 0) {
            this.ddX = this.ddV.getWidth();
        }
        int i = (int) (this.ddX * f);
        if (i < 0) {
            i = 0;
        }
        int i2 = i > this.ddX ? this.ddX : i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ddW.getLayoutParams();
        layoutParams.width = i2;
        this.ddW.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        this.ddT.a(as.cE(n.e.bg_switch_open), as.cE(n.e.bg_switch_close), as.cE(n.e.btn_handle));
        return true;
    }
}
