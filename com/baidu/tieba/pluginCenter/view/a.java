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
    private TextView hpA;
    private TbImageView jzD;
    private TextView jzE;
    private TextView jzF;
    private CircleProgressBar jzG;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.jzD = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.hpA = (TextView) view.findViewById(R.id.desc);
        this.jzE = (TextView) view.findViewById(R.id.status);
        this.jzE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.aQP().dispatchMvcEvent(bVar);
            }
        });
        this.jzF = (TextView) view.findViewById(R.id.install);
        this.jzF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.aQP().dispatchMvcEvent(bVar);
            }
        });
        this.jzG = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void ai(PluginConfigWrapper pluginConfigWrapper) {
        super.ai(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.jzD.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.hpA.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.js().bf(pluginConfigWrapper.package_name)) {
                this.jzF.setVisibility(8);
                this.jzG.setVisibility(8);
                this.jzE.setVisibility(0);
                this.jzE.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.jzG.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.jzE.setVisibility(8);
                this.jzF.setVisibility(8);
                this.jzG.setVisibility(0);
            } else {
                this.jzE.setVisibility(8);
                this.jzF.setVisibility(0);
                this.jzG.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.q.a.a(tbPageContext, getRootView());
        this.jzG.setCircleForegroundColor(am.getColor(R.color.cp_link_tip_a));
        this.jzG.setCircleBackgroundColor(am.getColor(R.color.cp_cont_d));
        return true;
    }
}
