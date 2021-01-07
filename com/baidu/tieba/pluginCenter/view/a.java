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
/* loaded from: classes8.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TextView kuu;
    private TbImageView mGO;
    private TextView mGP;
    private TextView mGQ;
    private CircleProgressBar mGR;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mGO = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.kuu = (TextView) view.findViewById(R.id.desc);
        this.mGP = (TextView) view.findViewById(R.id.status);
        this.mGP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bHj().dispatchMvcEvent(bVar);
            }
        });
        this.mGQ = (TextView) view.findViewById(R.id.install);
        this.mGQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bHj().dispatchMvcEvent(bVar);
            }
        });
        this.mGR = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void aw(PluginConfigWrapper pluginConfigWrapper) {
        super.aw(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.mGO.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.kuu.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.px().cA(pluginConfigWrapper.package_name)) {
                this.mGQ.setVisibility(8);
                this.mGR.setVisibility(8);
                this.mGP.setVisibility(0);
                this.mGP.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.mGR.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.mGP.setVisibility(8);
                this.mGQ.setVisibility(8);
                this.mGR.setVisibility(0);
            } else {
                this.mGP.setVisibility(8);
                this.mGQ.setVisibility(0);
                this.mGR.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.r.a.a(tbPageContext, getRootView());
        this.mGR.setCircleForegroundColor(ao.getColor(R.color.CAM_X0302));
        this.mGR.setCircleBackgroundColor(ao.getColor(R.color.CAM_X0109));
        return true;
    }
}
