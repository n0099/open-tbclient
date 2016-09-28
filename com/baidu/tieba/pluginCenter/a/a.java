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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.g.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TbImageView He;
    private BdSwitchView eZM;
    private TextView eZN;
    private View eZO;
    private ImageView eZP;
    private int eZQ;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.He = (TbImageView) view.findViewById(r.g.icon);
        this.title = (TextView) view.findViewById(r.g.title);
        this.eZM = (BdSwitchView) view.findViewById(r.g.switchview);
        this.eZP = (ImageView) view.findViewById(r.g.downloading_forground);
        this.eZO = view.findViewById(r.g.downloading_layout);
        this.eZN = (TextView) view.findViewById(r.g.download_text);
        this.eZM.setOnSwitchStateChangeListener(new b(this));
        this.eZN.setOnClickListener(new c(this));
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
                this.eZN.setVisibility(8);
                this.eZO.setVisibility(8);
                this.eZM.setVisibility(0);
                this.eZM.jw();
                return;
            case 2:
                this.eZN.setVisibility(8);
                this.eZO.setVisibility(8);
                this.eZM.setVisibility(0);
                this.eZM.jv();
                return;
            case 3:
                this.eZN.setVisibility(8);
                this.eZO.setVisibility(0);
                this.eZM.setVisibility(8);
                aq(f);
                return;
            case 4:
                this.eZN.setVisibility(0);
                this.eZO.setVisibility(8);
                this.eZM.setVisibility(8);
                this.eZN.setText(r.j.plugin_update);
                return;
            default:
                this.eZN.setVisibility(0);
                this.eZO.setVisibility(8);
                this.eZM.setVisibility(8);
                this.eZN.setText(r.j.download);
                return;
        }
    }

    private void aq(float f) {
        if (this.eZQ == 0) {
            this.eZQ = this.eZO.getWidth();
        }
        int i = (int) (this.eZQ * f);
        if (i < 0) {
            i = 0;
        }
        int i2 = i > this.eZQ ? this.eZQ : i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eZP.getLayoutParams();
        layoutParams.width = i2;
        this.eZP.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        this.eZM.a(av.cN(r.f.bg_switch_open), av.cN(r.f.bg_switch_close), av.cN(r.f.btn_handle));
        return true;
    }
}
