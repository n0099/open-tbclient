package com.baidu.tieba.pluginCenter.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pluginCenter.PluginConfigWrapper;
/* loaded from: classes3.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TextView fYx;
    private TbImageView iaU;
    private TextView iaV;
    private TextView iaW;
    private CircleProgressBar iaX;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.iaU = (TbImageView) view.findViewById(d.g.icon);
        this.title = (TextView) view.findViewById(d.g.title);
        this.fYx = (TextView) view.findViewById(d.g.desc);
        this.iaV = (TextView) view.findViewById(d.g.status);
        this.iaV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.aoG().dispatchMvcEvent(bVar);
            }
        });
        this.iaW = (TextView) view.findViewById(d.g.install);
        this.iaW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.aoG().dispatchMvcEvent(bVar);
            }
        });
        this.iaX = (CircleProgressBar) view.findViewById(d.g.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void ad(PluginConfigWrapper pluginConfigWrapper) {
        super.ad(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.iaU.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.fYx.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.ni().bY(pluginConfigWrapper.package_name)) {
                this.iaW.setVisibility(8);
                this.iaX.setVisibility(8);
                this.iaV.setVisibility(0);
                this.iaV.setText(d.j.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.iaX.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.iaV.setVisibility(8);
                this.iaW.setVisibility(8);
                this.iaX.setVisibility(0);
            } else {
                this.iaV.setVisibility(8);
                this.iaW.setVisibility(0);
                this.iaX.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.r.a.a(tbPageContext, getRootView());
        this.iaX.setCircleForegroundColor(al.getColor(d.C0277d.cp_link_tip_a));
        this.iaX.setCircleBackgroundColor(al.getColor(d.C0277d.cp_cont_d));
        return true;
    }
}
