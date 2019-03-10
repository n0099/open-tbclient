package com.baidu.tieba.pluginCenter.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pluginCenter.PluginConfigWrapper;
/* loaded from: classes3.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TextView fYK;
    private TbImageView ibo;
    private TextView ibp;
    private TextView ibq;
    private CircleProgressBar ibr;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.ibo = (TbImageView) view.findViewById(d.g.icon);
        this.title = (TextView) view.findViewById(d.g.title);
        this.fYK = (TextView) view.findViewById(d.g.desc);
        this.ibp = (TextView) view.findViewById(d.g.status);
        this.ibp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.aoK().dispatchMvcEvent(bVar);
            }
        });
        this.ibq = (TextView) view.findViewById(d.g.install);
        this.ibq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.aoK().dispatchMvcEvent(bVar);
            }
        });
        this.ibr = (CircleProgressBar) view.findViewById(d.g.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void af(PluginConfigWrapper pluginConfigWrapper) {
        super.af(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.ibo.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.fYK.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.ni().bY(pluginConfigWrapper.package_name)) {
                this.ibq.setVisibility(8);
                this.ibr.setVisibility(8);
                this.ibp.setVisibility(0);
                this.ibp.setText(d.j.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.ibr.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.ibp.setVisibility(8);
                this.ibq.setVisibility(8);
                this.ibr.setVisibility(0);
            } else {
                this.ibp.setVisibility(8);
                this.ibq.setVisibility(0);
                this.ibr.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.r.a.a(tbPageContext, getRootView());
        this.ibr.setCircleForegroundColor(al.getColor(d.C0236d.cp_link_tip_a));
        this.ibr.setCircleBackgroundColor(al.getColor(d.C0236d.cp_cont_d));
        return true;
    }
}
