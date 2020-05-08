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
    private TextView ibb;
    private CircleProgressBar klA;
    private TbImageView klx;
    private TextView kly;
    private TextView klz;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.klx = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.ibb = (TextView) view.findViewById(R.id.desc);
        this.kly = (TextView) view.findViewById(R.id.status);
        this.kly.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.aZc().dispatchMvcEvent(bVar);
            }
        });
        this.klz = (TextView) view.findViewById(R.id.install);
        this.klz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.aZc().dispatchMvcEvent(bVar);
            }
        });
        this.klA = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void aj(PluginConfigWrapper pluginConfigWrapper) {
        super.aj(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.klx.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.ibb.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.nV().cu(pluginConfigWrapper.package_name)) {
                this.klz.setVisibility(8);
                this.klA.setVisibility(8);
                this.kly.setVisibility(0);
                this.kly.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.klA.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.kly.setVisibility(8);
                this.klz.setVisibility(8);
                this.klA.setVisibility(0);
            } else {
                this.kly.setVisibility(8);
                this.klz.setVisibility(0);
                this.klA.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.q.a.a(tbPageContext, getRootView());
        this.klA.setCircleForegroundColor(am.getColor(R.color.cp_link_tip_a));
        this.klA.setCircleBackgroundColor(am.getColor(R.color.cp_cont_d));
        return true;
    }
}
