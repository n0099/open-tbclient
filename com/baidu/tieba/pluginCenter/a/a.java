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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.g.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TbImageView He;
    private BdSwitchView eXf;
    private TextView eXg;
    private View eXh;
    private ImageView eXi;
    private int eXj;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.He = (TbImageView) view.findViewById(t.g.icon);
        this.title = (TextView) view.findViewById(t.g.title);
        this.eXf = (BdSwitchView) view.findViewById(t.g.switchview);
        this.eXi = (ImageView) view.findViewById(t.g.downloading_forground);
        this.eXh = view.findViewById(t.g.downloading_layout);
        this.eXg = (TextView) view.findViewById(t.g.download_text);
        this.eXf.setOnSwitchStateChangeListener(new b(this));
        this.eXg.setOnClickListener(new c(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: b */
    public void E(PluginConfigWrapper pluginConfigWrapper) {
        super.E(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.He.c(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            f(pluginConfigWrapper.getDownLoadStatus(), pluginConfigWrapper.getDownLoadPercent());
        }
    }

    private void f(int i, float f) {
        switch (i) {
            case 1:
                this.eXg.setVisibility(8);
                this.eXh.setVisibility(8);
                this.eXf.setVisibility(0);
                this.eXf.jw();
                return;
            case 2:
                this.eXg.setVisibility(8);
                this.eXh.setVisibility(8);
                this.eXf.setVisibility(0);
                this.eXf.jv();
                return;
            case 3:
                this.eXg.setVisibility(8);
                this.eXh.setVisibility(0);
                this.eXf.setVisibility(8);
                aq(f);
                return;
            case 4:
                this.eXg.setVisibility(0);
                this.eXh.setVisibility(8);
                this.eXf.setVisibility(8);
                this.eXg.setText(t.j.plugin_update);
                return;
            default:
                this.eXg.setVisibility(0);
                this.eXh.setVisibility(8);
                this.eXf.setVisibility(8);
                this.eXg.setText(t.j.download);
                return;
        }
    }

    private void aq(float f) {
        if (this.eXj == 0) {
            this.eXj = this.eXh.getWidth();
        }
        int i = (int) (this.eXj * f);
        if (i < 0) {
            i = 0;
        }
        int i2 = i > this.eXj ? this.eXj : i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eXi.getLayoutParams();
        layoutParams.width = i2;
        this.eXi.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
        this.eXf.a(av.cN(t.f.bg_switch_open), av.cN(t.f.bg_switch_close), av.cN(t.f.btn_handle));
        return true;
    }
}
