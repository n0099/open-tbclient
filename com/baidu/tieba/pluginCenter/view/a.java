package com.baidu.tieba.pluginCenter.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pluginCenter.PluginConfigWrapper;
/* loaded from: classes21.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TextView jAw;
    private TbImageView lUB;
    private TextView lUC;
    private TextView lUD;
    private CircleProgressBar lUE;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.lUB = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.jAw = (TextView) view.findViewById(R.id.desc);
        this.lUC = (TextView) view.findViewById(R.id.status);
        this.lUC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bxF().dispatchMvcEvent(bVar);
            }
        });
        this.lUD = (TextView) view.findViewById(R.id.install);
        this.lUD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bxF().dispatchMvcEvent(bVar);
            }
        });
        this.lUE = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void au(PluginConfigWrapper pluginConfigWrapper) {
        super.au(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.lUB.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.jAw.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.pT().cC(pluginConfigWrapper.package_name)) {
                this.lUD.setVisibility(8);
                this.lUE.setVisibility(8);
                this.lUC.setVisibility(0);
                this.lUC.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.lUE.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.lUC.setVisibility(8);
                this.lUD.setVisibility(8);
                this.lUE.setVisibility(0);
            } else {
                this.lUC.setVisibility(8);
                this.lUD.setVisibility(0);
                this.lUE.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.r.a.a(tbPageContext, getRootView());
        this.lUE.setCircleForegroundColor(ap.getColor(R.color.cp_link_tip_a));
        this.lUE.setCircleBackgroundColor(ap.getColor(R.color.cp_cont_d));
        return true;
    }
}
