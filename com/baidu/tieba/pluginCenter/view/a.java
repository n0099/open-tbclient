package com.baidu.tieba.pluginCenter.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pluginCenter.PluginConfigWrapper;
/* loaded from: classes21.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TextView jMV;
    private TbImageView mha;
    private TextView mhb;
    private TextView mhc;
    private CircleProgressBar mhd;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mha = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.jMV = (TextView) view.findViewById(R.id.desc);
        this.mhb = (TextView) view.findViewById(R.id.status);
        this.mhb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bzy().dispatchMvcEvent(bVar);
            }
        });
        this.mhc = (TextView) view.findViewById(R.id.install);
        this.mhc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bzy().dispatchMvcEvent(bVar);
            }
        });
        this.mhd = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void au(PluginConfigWrapper pluginConfigWrapper) {
        super.au(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.mha.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.jMV.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.pT().cC(pluginConfigWrapper.package_name)) {
                this.mhc.setVisibility(8);
                this.mhd.setVisibility(8);
                this.mhb.setVisibility(0);
                this.mhb.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.mhd.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.mhb.setVisibility(8);
                this.mhc.setVisibility(8);
                this.mhd.setVisibility(0);
            } else {
                this.mhb.setVisibility(8);
                this.mhc.setVisibility(0);
                this.mhd.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.r.a.a(tbPageContext, getRootView());
        this.mhd.setCircleForegroundColor(ap.getColor(R.color.cp_link_tip_a));
        this.mhd.setCircleBackgroundColor(ap.getColor(R.color.cp_cont_d));
        return true;
    }
}
