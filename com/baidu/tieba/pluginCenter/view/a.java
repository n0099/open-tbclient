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
    private TextView gvP;
    private TbImageView iAV;
    private TextView iAW;
    private TextView iAX;
    private CircleProgressBar iAY;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.iAV = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.gvP = (TextView) view.findViewById(R.id.desc);
        this.iAW = (TextView) view.findViewById(R.id.status);
        this.iAW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.awv().dispatchMvcEvent(bVar);
            }
        });
        this.iAX = (TextView) view.findViewById(R.id.install);
        this.iAX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.awv().dispatchMvcEvent(bVar);
            }
        });
        this.iAY = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void ab(PluginConfigWrapper pluginConfigWrapper) {
        super.ab(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.iAV.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.gvP.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.iL().aR(pluginConfigWrapper.package_name)) {
                this.iAX.setVisibility(8);
                this.iAY.setVisibility(8);
                this.iAW.setVisibility(0);
                this.iAW.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.iAY.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.iAW.setVisibility(8);
                this.iAX.setVisibility(8);
                this.iAY.setVisibility(0);
            } else {
                this.iAW.setVisibility(8);
                this.iAX.setVisibility(0);
                this.iAY.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.s.a.a(tbPageContext, getRootView());
        this.iAY.setCircleForegroundColor(am.getColor(R.color.cp_link_tip_a));
        this.iAY.setCircleBackgroundColor(am.getColor(R.color.cp_cont_d));
        return true;
    }
}
