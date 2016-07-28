package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pluginCenter.PluginConfigWrapper;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.g.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TbImageView ER;
    private BdSwitchView ePU;
    private TextView ePV;
    private View ePW;
    private ImageView ePX;
    private int ePY;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.ER = (TbImageView) view.findViewById(u.g.icon);
        this.title = (TextView) view.findViewById(u.g.title);
        this.ePU = (BdSwitchView) view.findViewById(u.g.switchview);
        this.ePX = (ImageView) view.findViewById(u.g.downloading_forground);
        this.ePW = view.findViewById(u.g.downloading_layout);
        this.ePV = (TextView) view.findViewById(u.g.download_text);
        this.ePU.setOnSwitchStateChangeListener(new b(this));
        this.ePV.setOnClickListener(new c(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: b */
    public void E(PluginConfigWrapper pluginConfigWrapper) {
        super.E(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.ER.c(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            f(pluginConfigWrapper.getDownLoadStatus(), pluginConfigWrapper.getDownLoadPercent());
        }
    }

    private void f(int i, float f) {
        switch (i) {
            case 1:
                this.ePV.setVisibility(8);
                this.ePW.setVisibility(8);
                this.ePU.setVisibility(0);
                this.ePU.iB();
                return;
            case 2:
                this.ePV.setVisibility(8);
                this.ePW.setVisibility(8);
                this.ePU.setVisibility(0);
                this.ePU.iA();
                return;
            case 3:
                this.ePV.setVisibility(8);
                this.ePW.setVisibility(0);
                this.ePU.setVisibility(8);
                W(f);
                return;
            case 4:
                this.ePV.setVisibility(0);
                this.ePW.setVisibility(8);
                this.ePU.setVisibility(8);
                this.ePV.setText(u.j.plugin_update);
                return;
            default:
                this.ePV.setVisibility(0);
                this.ePW.setVisibility(8);
                this.ePU.setVisibility(8);
                this.ePV.setText(u.j.download);
                return;
        }
    }

    private void W(float f) {
        if (this.ePY == 0) {
            this.ePY = this.ePW.getWidth();
        }
        int i = (int) (this.ePY * f);
        if (i < 0) {
            i = 0;
        }
        int i2 = i > this.ePY ? this.ePY : i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ePX.getLayoutParams();
        layoutParams.width = i2;
        this.ePX.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
        this.ePU.a(av.cA(u.f.bg_switch_open), av.cA(u.f.bg_switch_close), av.cA(u.f.btn_handle));
        return true;
    }
}
