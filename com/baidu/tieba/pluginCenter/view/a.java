package com.baidu.tieba.pluginCenter.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pluginCenter.PluginConfigWrapper;
/* loaded from: classes8.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TextView iHI;
    private TbImageView kYw;
    private TextView kYx;
    private TextView kYy;
    private CircleProgressBar kYz;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.kYw = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.iHI = (TextView) view.findViewById(R.id.desc);
        this.kYx = (TextView) view.findViewById(R.id.status);
        this.kYx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bhs().dispatchMvcEvent(bVar);
            }
        });
        this.kYy = (TextView) view.findViewById(R.id.install);
        this.kYy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bhs().dispatchMvcEvent(bVar);
            }
        });
        this.kYz = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void ao(PluginConfigWrapper pluginConfigWrapper) {
        super.ao(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.kYw.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.iHI.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.oo().cw(pluginConfigWrapper.package_name)) {
                this.kYy.setVisibility(8);
                this.kYz.setVisibility(8);
                this.kYx.setVisibility(0);
                this.kYx.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.kYz.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.kYx.setVisibility(8);
                this.kYy.setVisibility(8);
                this.kYz.setVisibility(0);
            } else {
                this.kYx.setVisibility(8);
                this.kYy.setVisibility(0);
                this.kYz.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.r.a.a(tbPageContext, getRootView());
        this.kYz.setCircleForegroundColor(an.getColor(R.color.cp_link_tip_a));
        this.kYz.setCircleBackgroundColor(an.getColor(R.color.cp_cont_d));
        return true;
    }
}
