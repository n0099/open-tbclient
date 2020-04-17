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
    private TextView iaV;
    private TbImageView klt;
    private TextView klu;
    private TextView klv;
    private CircleProgressBar klw;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.klt = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.iaV = (TextView) view.findViewById(R.id.desc);
        this.klu = (TextView) view.findViewById(R.id.status);
        this.klu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.aZe().dispatchMvcEvent(bVar);
            }
        });
        this.klv = (TextView) view.findViewById(R.id.install);
        this.klv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.aZe().dispatchMvcEvent(bVar);
            }
        });
        this.klw = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void ai(PluginConfigWrapper pluginConfigWrapper) {
        super.ai(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.klt.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.iaV.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.nV().cu(pluginConfigWrapper.package_name)) {
                this.klv.setVisibility(8);
                this.klw.setVisibility(8);
                this.klu.setVisibility(0);
                this.klu.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.klw.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.klu.setVisibility(8);
                this.klv.setVisibility(8);
                this.klw.setVisibility(0);
            } else {
                this.klu.setVisibility(8);
                this.klv.setVisibility(0);
                this.klw.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.q.a.a(tbPageContext, getRootView());
        this.klw.setCircleForegroundColor(am.getColor(R.color.cp_link_tip_a));
        this.klw.setCircleBackgroundColor(am.getColor(R.color.cp_cont_d));
        return true;
    }
}
