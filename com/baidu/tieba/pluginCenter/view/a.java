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
/* loaded from: classes3.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TextView gyJ;
    private TbImageView iDq;
    private TextView iDr;
    private TextView iDs;
    private CircleProgressBar iDt;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.iDq = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.gyJ = (TextView) view.findViewById(R.id.desc);
        this.iDr = (TextView) view.findViewById(R.id.status);
        this.iDr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.avg().dispatchMvcEvent(bVar);
            }
        });
        this.iDs = (TextView) view.findViewById(R.id.install);
        this.iDs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.avg().dispatchMvcEvent(bVar);
            }
        });
        this.iDt = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void af(PluginConfigWrapper pluginConfigWrapper) {
        super.af(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.iDq.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.gyJ.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.ms().bK(pluginConfigWrapper.package_name)) {
                this.iDs.setVisibility(8);
                this.iDt.setVisibility(8);
                this.iDr.setVisibility(0);
                this.iDr.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.iDt.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.iDr.setVisibility(8);
                this.iDs.setVisibility(8);
                this.iDt.setVisibility(0);
            } else {
                this.iDr.setVisibility(8);
                this.iDs.setVisibility(0);
                this.iDt.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.s.a.a(tbPageContext, getRootView());
        this.iDt.setCircleForegroundColor(am.getColor(R.color.cp_link_tip_a));
        this.iDt.setCircleBackgroundColor(am.getColor(R.color.cp_cont_d));
        return true;
    }
}
