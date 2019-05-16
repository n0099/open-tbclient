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
    private TextView gpL;
    private TextView itA;
    private TextView itB;
    private CircleProgressBar itC;
    private TbImageView itz;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.itz = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.gpL = (TextView) view.findViewById(R.id.desc);
        this.itA = (TextView) view.findViewById(R.id.status);
        this.itA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.atK().dispatchMvcEvent(bVar);
            }
        });
        this.itB = (TextView) view.findViewById(R.id.install);
        this.itB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.atK().dispatchMvcEvent(bVar);
            }
        });
        this.itC = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void af(PluginConfigWrapper pluginConfigWrapper) {
        super.af(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.itz.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.gpL.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.mc().bI(pluginConfigWrapper.package_name)) {
                this.itB.setVisibility(8);
                this.itC.setVisibility(8);
                this.itA.setVisibility(0);
                this.itA.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.itC.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.itA.setVisibility(8);
                this.itB.setVisibility(8);
                this.itC.setVisibility(0);
            } else {
                this.itA.setVisibility(8);
                this.itB.setVisibility(0);
                this.itC.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.s.a.a(tbPageContext, getRootView());
        this.itC.setCircleForegroundColor(al.getColor(R.color.cp_link_tip_a));
        this.itC.setCircleBackgroundColor(al.getColor(R.color.cp_cont_d));
        return true;
    }
}
