package com.baidu.tieba.pluginCenter.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pluginCenter.PluginConfigWrapper;
/* loaded from: classes8.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TextView iqB;
    private TbImageView kEA;
    private TextView kEB;
    private TextView kEC;
    private CircleProgressBar kED;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.kEA = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.iqB = (TextView) view.findViewById(R.id.desc);
        this.kEB = (TextView) view.findViewById(R.id.status);
        this.kEB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bfn().dispatchMvcEvent(bVar);
            }
        });
        this.kEC = (TextView) view.findViewById(R.id.install);
        this.kEC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bfn().dispatchMvcEvent(bVar);
            }
        });
        this.kED = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void an(PluginConfigWrapper pluginConfigWrapper) {
        super.an(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.kEA.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.iqB.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.nX().cv(pluginConfigWrapper.package_name)) {
                this.kEC.setVisibility(8);
                this.kED.setVisibility(8);
                this.kEB.setVisibility(0);
                this.kEB.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.kED.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.kEB.setVisibility(8);
                this.kEC.setVisibility(8);
                this.kED.setVisibility(0);
            } else {
                this.kEB.setVisibility(8);
                this.kEC.setVisibility(0);
                this.kED.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.q.a.a(tbPageContext, getRootView());
        this.kED.setCircleForegroundColor(am.getColor(R.color.cp_link_tip_a));
        this.kED.setCircleBackgroundColor(am.getColor(R.color.cp_cont_d));
        return true;
    }
}
