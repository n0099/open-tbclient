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
    private TextView gwa;
    private TbImageView izU;
    private TextView izV;
    private TextView izW;
    private CircleProgressBar izX;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.izU = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.gwa = (TextView) view.findViewById(R.id.desc);
        this.izV = (TextView) view.findViewById(R.id.status);
        this.izV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.auS().dispatchMvcEvent(bVar);
            }
        });
        this.izW = (TextView) view.findViewById(R.id.install);
        this.izW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.auS().dispatchMvcEvent(bVar);
            }
        });
        this.izX = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void af(PluginConfigWrapper pluginConfigWrapper) {
        super.af(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.izU.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.gwa.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.ms().bK(pluginConfigWrapper.package_name)) {
                this.izW.setVisibility(8);
                this.izX.setVisibility(8);
                this.izV.setVisibility(0);
                this.izV.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.izX.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.izV.setVisibility(8);
                this.izW.setVisibility(8);
                this.izX.setVisibility(0);
            } else {
                this.izV.setVisibility(8);
                this.izW.setVisibility(0);
                this.izX.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.s.a.a(tbPageContext, getRootView());
        this.izX.setCircleForegroundColor(am.getColor(R.color.cp_link_tip_a));
        this.izX.setCircleBackgroundColor(am.getColor(R.color.cp_cont_d));
        return true;
    }
}
