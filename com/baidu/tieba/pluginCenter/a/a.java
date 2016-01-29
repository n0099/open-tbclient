package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pluginCenter.PluginConfigWrapper;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.g.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TbImageView NM;
    private TextView apm;
    private BdSwitchView dxs;
    private TextView dxt;
    private View dxu;
    private ImageView dxv;
    private int dxw;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.NM = (TbImageView) view.findViewById(t.g.icon);
        this.apm = (TextView) view.findViewById(t.g.title);
        this.dxs = (BdSwitchView) view.findViewById(t.g.switchview);
        this.dxv = (ImageView) view.findViewById(t.g.downloading_forground);
        this.dxu = view.findViewById(t.g.downloading_layout);
        this.dxt = (TextView) view.findViewById(t.g.download_text);
        this.dxs.setOnSwitchStateChangeListener(new b(this));
        this.dxt.setOnClickListener(new c(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: b */
    public void B(PluginConfigWrapper pluginConfigWrapper) {
        super.B(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.NM.d(pluginConfigWrapper.icon, 10, false);
            }
            this.apm.setText(pluginConfigWrapper.display_name);
            c(pluginConfigWrapper.getDownLoadStatus(), pluginConfigWrapper.getDownLoadPercent());
        }
    }

    private void c(int i, float f) {
        switch (i) {
            case 1:
                this.dxt.setVisibility(8);
                this.dxu.setVisibility(8);
                this.dxs.setVisibility(0);
                this.dxs.mt();
                return;
            case 2:
                this.dxt.setVisibility(8);
                this.dxu.setVisibility(8);
                this.dxs.setVisibility(0);
                this.dxs.ms();
                return;
            case 3:
                this.dxt.setVisibility(8);
                this.dxu.setVisibility(0);
                this.dxs.setVisibility(8);
                H(f);
                return;
            case 4:
                this.dxt.setVisibility(0);
                this.dxu.setVisibility(8);
                this.dxs.setVisibility(8);
                this.dxt.setText(t.j.plugin_update);
                return;
            default:
                this.dxt.setVisibility(0);
                this.dxu.setVisibility(8);
                this.dxs.setVisibility(8);
                this.dxt.setText(t.j.download);
                return;
        }
    }

    private void H(float f) {
        if (this.dxw == 0) {
            this.dxw = this.dxu.getWidth();
        }
        int i = (int) (this.dxw * f);
        if (i < 0) {
            i = 0;
        }
        int i2 = i > this.dxw ? this.dxw : i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dxv.getLayoutParams();
        layoutParams.width = i2;
        this.dxv.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        this.dxs.a(ar.cO(t.f.bg_switch_open), ar.cO(t.f.bg_switch_close), ar.cO(t.f.btn_handle));
        return true;
    }
}
