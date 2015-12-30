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
    private TbImageView Nm;
    private TextView ahk;
    private View djA;
    private ImageView djB;
    private int djC;
    private BdSwitchView djy;
    private TextView djz;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.Nm = (TbImageView) view.findViewById(n.g.icon);
        this.ahk = (TextView) view.findViewById(n.g.title);
        this.djy = (BdSwitchView) view.findViewById(n.g.switchview);
        this.djB = (ImageView) view.findViewById(n.g.downloading_forground);
        this.djA = view.findViewById(n.g.downloading_layout);
        this.djz = (TextView) view.findViewById(n.g.download_text);
        this.djy.setOnSwitchStateChangeListener(new b(this));
        this.djz.setOnClickListener(new c(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: b */
    public void B(PluginConfigWrapper pluginConfigWrapper) {
        super.B((a) pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.Nm.d(pluginConfigWrapper.icon, 10, false);
            }
            this.ahk.setText(pluginConfigWrapper.display_name);
            c(pluginConfigWrapper.getDownLoadStatus(), pluginConfigWrapper.getDownLoadPercent());
        }
    }

    private void c(int i, float f) {
        switch (i) {
            case 1:
                this.djz.setVisibility(8);
                this.djA.setVisibility(8);
                this.djy.setVisibility(0);
                this.djy.mf();
                return;
            case 2:
                this.djz.setVisibility(8);
                this.djA.setVisibility(8);
                this.djy.setVisibility(0);
                this.djy.me();
                return;
            case 3:
                this.djz.setVisibility(8);
                this.djA.setVisibility(0);
                this.djy.setVisibility(8);
                B(f);
                return;
            case 4:
                this.djz.setVisibility(0);
                this.djA.setVisibility(8);
                this.djy.setVisibility(8);
                this.djz.setText(n.j.plugin_update);
                return;
            default:
                this.djz.setVisibility(0);
                this.djA.setVisibility(8);
                this.djy.setVisibility(8);
                this.djz.setText(n.j.download);
                return;
        }
    }

    private void B(float f) {
        if (this.djC == 0) {
            this.djC = this.djA.getWidth();
        }
        int i = (int) (this.djC * f);
        if (i < 0) {
            i = 0;
        }
        int i2 = i > this.djC ? this.djC : i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.djB.getLayoutParams();
        layoutParams.width = i2;
        this.djB.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        this.djy.a(as.cx(n.f.bg_switch_open), as.cx(n.f.bg_switch_close), as.cx(n.f.btn_handle));
        return true;
    }
}
