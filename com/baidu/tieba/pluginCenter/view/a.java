package com.baidu.tieba.pluginCenter.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pluginCenter.PluginConfigWrapper;
/* loaded from: classes15.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TextView iNP;
    private TbImageView lfS;
    private TextView lfT;
    private TextView lfU;
    private CircleProgressBar lfV;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.lfS = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.iNP = (TextView) view.findViewById(R.id.desc);
        this.lfT = (TextView) view.findViewById(R.id.status);
        this.lfT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bld().dispatchMvcEvent(bVar);
            }
        });
        this.lfU = (TextView) view.findViewById(R.id.install);
        this.lfU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bld().dispatchMvcEvent(bVar);
            }
        });
        this.lfV = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void ao(PluginConfigWrapper pluginConfigWrapper) {
        super.ao(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.lfS.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.iNP.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.op().cu(pluginConfigWrapper.package_name)) {
                this.lfU.setVisibility(8);
                this.lfV.setVisibility(8);
                this.lfT.setVisibility(0);
                this.lfT.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.lfV.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.lfT.setVisibility(8);
                this.lfU.setVisibility(8);
                this.lfV.setVisibility(0);
            } else {
                this.lfT.setVisibility(8);
                this.lfU.setVisibility(0);
                this.lfV.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.r.a.a(tbPageContext, getRootView());
        this.lfV.setCircleForegroundColor(ao.getColor(R.color.cp_link_tip_a));
        this.lfV.setCircleBackgroundColor(ao.getColor(R.color.cp_cont_d));
        return true;
    }
}
