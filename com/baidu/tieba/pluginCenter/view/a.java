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
/* loaded from: classes5.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TextView hjV;
    private TbImageView jve;
    private TextView jvf;
    private TextView jvg;
    private CircleProgressBar jvh;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.jve = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.hjV = (TextView) view.findViewById(R.id.desc);
        this.jvf = (TextView) view.findViewById(R.id.status);
        this.jvf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.aOf().dispatchMvcEvent(bVar);
            }
        });
        this.jvg = (TextView) view.findViewById(R.id.install);
        this.jvg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.aOf().dispatchMvcEvent(bVar);
            }
        });
        this.jvh = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void ag(PluginConfigWrapper pluginConfigWrapper) {
        super.ag(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.jve.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.hjV.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.je().bd(pluginConfigWrapper.package_name)) {
                this.jvg.setVisibility(8);
                this.jvh.setVisibility(8);
                this.jvf.setVisibility(0);
                this.jvf.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.jvh.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.jvf.setVisibility(8);
                this.jvg.setVisibility(8);
                this.jvh.setVisibility(0);
            } else {
                this.jvf.setVisibility(8);
                this.jvg.setVisibility(0);
                this.jvh.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.q.a.a(tbPageContext, getRootView());
        this.jvh.setCircleForegroundColor(am.getColor(R.color.cp_link_tip_a));
        this.jvh.setCircleBackgroundColor(am.getColor(R.color.cp_cont_d));
        return true;
    }
}
