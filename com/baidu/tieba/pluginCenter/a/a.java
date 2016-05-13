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
    private TbImageView El;
    private BdSwitchView dUQ;
    private TextView dUR;
    private View dUS;
    private ImageView dUT;
    private int dUU;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.El = (TbImageView) view.findViewById(t.g.icon);
        this.title = (TextView) view.findViewById(t.g.title);
        this.dUQ = (BdSwitchView) view.findViewById(t.g.switchview);
        this.dUT = (ImageView) view.findViewById(t.g.downloading_forground);
        this.dUS = view.findViewById(t.g.downloading_layout);
        this.dUR = (TextView) view.findViewById(t.g.download_text);
        this.dUQ.setOnSwitchStateChangeListener(new b(this));
        this.dUR.setOnClickListener(new c(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: b */
    public void B(PluginConfigWrapper pluginConfigWrapper) {
        super.B(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.El.c(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            d(pluginConfigWrapper.getDownLoadStatus(), pluginConfigWrapper.getDownLoadPercent());
        }
    }

    private void d(int i, float f) {
        switch (i) {
            case 1:
                this.dUR.setVisibility(8);
                this.dUS.setVisibility(8);
                this.dUQ.setVisibility(0);
                this.dUQ.iz();
                return;
            case 2:
                this.dUR.setVisibility(8);
                this.dUS.setVisibility(8);
                this.dUQ.setVisibility(0);
                this.dUQ.iy();
                return;
            case 3:
                this.dUR.setVisibility(8);
                this.dUS.setVisibility(0);
                this.dUQ.setVisibility(8);
                E(f);
                return;
            case 4:
                this.dUR.setVisibility(0);
                this.dUS.setVisibility(8);
                this.dUQ.setVisibility(8);
                this.dUR.setText(t.j.plugin_update);
                return;
            default:
                this.dUR.setVisibility(0);
                this.dUS.setVisibility(8);
                this.dUQ.setVisibility(8);
                this.dUR.setText(t.j.download);
                return;
        }
    }

    private void E(float f) {
        if (this.dUU == 0) {
            this.dUU = this.dUS.getWidth();
        }
        int i = (int) (this.dUU * f);
        if (i < 0) {
            i = 0;
        }
        int i2 = i > this.dUU ? this.dUU : i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dUT.getLayoutParams();
        layoutParams.width = i2;
        this.dUT.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        this.dUQ.a(at.cz(t.f.bg_switch_open), at.cz(t.f.bg_switch_close), at.cz(t.f.btn_handle));
        return true;
    }
}
