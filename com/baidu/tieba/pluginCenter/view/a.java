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
    private TbImageView jyL;
    private TextView jyM;
    private TextView jyN;
    private CircleProgressBar jyO;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.jyL = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.hny = (TextView) view.findViewById(R.id.desc);
        this.jyM = (TextView) view.findViewById(R.id.status);
        this.jyM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.aOy().dispatchMvcEvent(bVar);
            }
        });
        this.jyN = (TextView) view.findViewById(R.id.install);
        this.jyN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.aOy().dispatchMvcEvent(bVar);
            }
        });
        this.jyO = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void ag(PluginConfigWrapper pluginConfigWrapper) {
        super.ag(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.jyL.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.hny.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.jd().bd(pluginConfigWrapper.package_name)) {
                this.jyN.setVisibility(8);
                this.jyO.setVisibility(8);
                this.jyM.setVisibility(0);
                this.jyM.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.jyO.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.jyM.setVisibility(8);
                this.jyN.setVisibility(8);
                this.jyO.setVisibility(0);
            } else {
                this.jyM.setVisibility(8);
                this.jyN.setVisibility(0);
                this.jyO.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.q.a.a(tbPageContext, getRootView());
        this.jyO.setCircleForegroundColor(am.getColor(R.color.cp_link_tip_a));
        this.jyO.setCircleBackgroundColor(am.getColor(R.color.cp_cont_d));
        return true;
    }
}
