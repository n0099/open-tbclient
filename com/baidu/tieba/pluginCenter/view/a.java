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
/* loaded from: classes6.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TextView hny;
    private TbImageView jyG;
    private TextView jyH;
    private TextView jyI;
    private CircleProgressBar jyJ;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.jyG = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.hny = (TextView) view.findViewById(R.id.desc);
        this.jyH = (TextView) view.findViewById(R.id.status);
        this.jyH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.aOy().dispatchMvcEvent(bVar);
            }
        });
        this.jyI = (TextView) view.findViewById(R.id.install);
        this.jyI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.aOy().dispatchMvcEvent(bVar);
            }
        });
        this.jyJ = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void ag(PluginConfigWrapper pluginConfigWrapper) {
        super.ag(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.jyG.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.hny.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.jd().bd(pluginConfigWrapper.package_name)) {
                this.jyI.setVisibility(8);
                this.jyJ.setVisibility(8);
                this.jyH.setVisibility(0);
                this.jyH.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.jyJ.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.jyH.setVisibility(8);
                this.jyI.setVisibility(8);
                this.jyJ.setVisibility(0);
            } else {
                this.jyH.setVisibility(8);
                this.jyI.setVisibility(0);
                this.jyJ.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.q.a.a(tbPageContext, getRootView());
        this.jyJ.setCircleForegroundColor(am.getColor(R.color.cp_link_tip_a));
        this.jyJ.setCircleBackgroundColor(am.getColor(R.color.cp_cont_d));
        return true;
    }
}
