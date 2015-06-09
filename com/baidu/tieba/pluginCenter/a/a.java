package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pluginCenter.PluginConfigWrapper;
import com.baidu.tieba.q;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.j.a<PluginConfigWrapper, com.baidu.tbadk.mvc.e.c> {
    private TbImageView Ms;
    private TextView aiA;
    private BdSwitchView bXF;
    private TextView bXG;
    private View bXH;
    private ImageView bXI;
    private int bXJ;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.Ms = (TbImageView) view.findViewById(q.icon);
        this.aiA = (TextView) view.findViewById(q.title);
        this.bXF = (BdSwitchView) view.findViewById(q.switchview);
        this.bXI = (ImageView) view.findViewById(q.downloading_forground);
        this.bXH = view.findViewById(q.downloading_layout);
        this.bXG = (TextView) view.findViewById(q.download_text);
        this.bXF.setOnSwitchStateChangeListener(new b(this));
        this.bXG.setOnClickListener(new c(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: b */
    public void z(PluginConfigWrapper pluginConfigWrapper) {
        super.z(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.Ms.c(pluginConfigWrapper.icon, 10, false);
            }
            this.aiA.setText(pluginConfigWrapper.display_name);
            b(pluginConfigWrapper.getDownLoadStatus(), pluginConfigWrapper.getDownLoadPercent());
        }
    }

    private void b(int i, float f) {
        switch (i) {
            case 1:
                this.bXG.setVisibility(8);
                this.bXH.setVisibility(8);
                this.bXF.setVisibility(0);
                this.bXF.mu();
                return;
            case 2:
                this.bXG.setVisibility(8);
                this.bXH.setVisibility(8);
                this.bXF.setVisibility(0);
                this.bXF.mt();
                return;
            case 3:
                this.bXG.setVisibility(8);
                this.bXH.setVisibility(0);
                this.bXF.setVisibility(8);
                x(f);
                return;
            case 4:
                this.bXG.setVisibility(0);
                this.bXH.setVisibility(8);
                this.bXF.setVisibility(8);
                this.bXG.setText(t.plugin_update);
                return;
            default:
                this.bXG.setVisibility(0);
                this.bXH.setVisibility(8);
                this.bXF.setVisibility(8);
                this.bXG.setText(t.download);
                return;
        }
    }

    private void x(float f) {
        if (this.bXJ == 0) {
            this.bXJ = this.bXH.getWidth();
        }
        int i = (int) (this.bXJ * f);
        if (i < 0) {
            i = 0;
        }
        int i2 = i > this.bXJ ? this.bXJ : i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bXI.getLayoutParams();
        layoutParams.width = i2;
        this.bXI.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        return true;
    }
}
