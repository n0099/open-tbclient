package com.baidu.tieba.pluginCenter.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pluginCenter.PluginConfigWrapper;
/* loaded from: classes3.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TextView gpM;
    private TbImageView itC;
    private TextView itD;
    private TextView itE;
    private CircleProgressBar itF;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.itC = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.gpM = (TextView) view.findViewById(R.id.desc);
        this.itD = (TextView) view.findViewById(R.id.status);
        this.itD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.atK().dispatchMvcEvent(bVar);
            }
        });
        this.itE = (TextView) view.findViewById(R.id.install);
        this.itE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.atK().dispatchMvcEvent(bVar);
            }
        });
        this.itF = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void af(PluginConfigWrapper pluginConfigWrapper) {
        super.af(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.itC.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.gpM.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.mc().bI(pluginConfigWrapper.package_name)) {
                this.itE.setVisibility(8);
                this.itF.setVisibility(8);
                this.itD.setVisibility(0);
                this.itD.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.itF.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.itD.setVisibility(8);
                this.itE.setVisibility(8);
                this.itF.setVisibility(0);
            } else {
                this.itD.setVisibility(8);
                this.itE.setVisibility(0);
                this.itF.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.s.a.a(tbPageContext, getRootView());
        this.itF.setCircleForegroundColor(al.getColor(R.color.cp_link_tip_a));
        this.itF.setCircleBackgroundColor(al.getColor(R.color.cp_cont_d));
        return true;
    }
}
