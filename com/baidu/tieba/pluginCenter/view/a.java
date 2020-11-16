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
/* loaded from: classes20.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TextView jTC;
    private TbImageView mns;
    private TextView mnt;
    private TextView mnu;
    private CircleProgressBar mnv;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mns = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.jTC = (TextView) view.findViewById(R.id.desc);
        this.mnt = (TextView) view.findViewById(R.id.status);
        this.mnt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bBn().dispatchMvcEvent(bVar);
            }
        });
        this.mnu = (TextView) view.findViewById(R.id.install);
        this.mnu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bBn().dispatchMvcEvent(bVar);
            }
        });
        this.mnv = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void au(PluginConfigWrapper pluginConfigWrapper) {
        super.au(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.mns.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.jTC.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.pT().cE(pluginConfigWrapper.package_name)) {
                this.mnu.setVisibility(8);
                this.mnv.setVisibility(8);
                this.mnt.setVisibility(0);
                this.mnt.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.mnv.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.mnt.setVisibility(8);
                this.mnu.setVisibility(8);
                this.mnv.setVisibility(0);
            } else {
                this.mnt.setVisibility(8);
                this.mnu.setVisibility(0);
                this.mnv.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.r.a.a(tbPageContext, getRootView());
        this.mnv.setCircleForegroundColor(ap.getColor(R.color.CAM_X0302));
        this.mnv.setCircleBackgroundColor(ap.getColor(R.color.CAM_X0109));
        return true;
    }
}
