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
    private TbImageView Er;
    private BdSwitchView eEl;
    private TextView eEm;
    private View eEn;
    private ImageView eEo;
    private int eEp;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.Er = (TbImageView) view.findViewById(u.g.icon);
        this.title = (TextView) view.findViewById(u.g.title);
        this.eEl = (BdSwitchView) view.findViewById(u.g.switchview);
        this.eEo = (ImageView) view.findViewById(u.g.downloading_forground);
        this.eEn = view.findViewById(u.g.downloading_layout);
        this.eEm = (TextView) view.findViewById(u.g.download_text);
        this.eEl.setOnSwitchStateChangeListener(new b(this));
        this.eEm.setOnClickListener(new c(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: b */
    public void B(PluginConfigWrapper pluginConfigWrapper) {
        super.B(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.Er.c(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            f(pluginConfigWrapper.getDownLoadStatus(), pluginConfigWrapper.getDownLoadPercent());
        }
    }

    private void f(int i, float f) {
        switch (i) {
            case 1:
                this.eEm.setVisibility(8);
                this.eEn.setVisibility(8);
                this.eEl.setVisibility(0);
                this.eEl.iC();
                return;
            case 2:
                this.eEm.setVisibility(8);
                this.eEn.setVisibility(8);
                this.eEl.setVisibility(0);
                this.eEl.iB();
                return;
            case 3:
                this.eEm.setVisibility(8);
                this.eEn.setVisibility(0);
                this.eEl.setVisibility(8);
                M(f);
                return;
            case 4:
                this.eEm.setVisibility(0);
                this.eEn.setVisibility(8);
                this.eEl.setVisibility(8);
                this.eEm.setText(u.j.plugin_update);
                return;
            default:
                this.eEm.setVisibility(0);
                this.eEn.setVisibility(8);
                this.eEl.setVisibility(8);
                this.eEm.setText(u.j.download);
                return;
        }
    }

    private void M(float f) {
        if (this.eEp == 0) {
            this.eEp = this.eEn.getWidth();
        }
        int i = (int) (this.eEp * f);
        if (i < 0) {
            i = 0;
        }
        int i2 = i > this.eEp ? this.eEp : i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eEo.getLayoutParams();
        layoutParams.width = i2;
        this.eEo.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
        this.eEl.a(av.cA(u.f.bg_switch_open), av.cA(u.f.bg_switch_close), av.cA(u.f.btn_handle));
        return true;
    }
}
