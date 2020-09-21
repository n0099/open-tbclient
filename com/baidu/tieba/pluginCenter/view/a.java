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
/* loaded from: classes20.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TextView jly;
    private TbImageView lFn;
    private TextView lFo;
    private TextView lFp;
    private CircleProgressBar lFq;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.lFn = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.jly = (TextView) view.findViewById(R.id.desc);
        this.lFo = (TextView) view.findViewById(R.id.status);
        this.lFo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.buV().dispatchMvcEvent(bVar);
            }
        });
        this.lFp = (TextView) view.findViewById(R.id.install);
        this.lFp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.buV().dispatchMvcEvent(bVar);
            }
        });
        this.lFq = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void ar(PluginConfigWrapper pluginConfigWrapper) {
        super.ar(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.lFn.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.jly.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.pT().cC(pluginConfigWrapper.package_name)) {
                this.lFp.setVisibility(8);
                this.lFq.setVisibility(8);
                this.lFo.setVisibility(0);
                this.lFo.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.lFq.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.lFo.setVisibility(8);
                this.lFp.setVisibility(8);
                this.lFq.setVisibility(0);
            } else {
                this.lFo.setVisibility(8);
                this.lFp.setVisibility(0);
                this.lFq.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.r.a.a(tbPageContext, getRootView());
        this.lFq.setCircleForegroundColor(ap.getColor(R.color.cp_link_tip_a));
        this.lFq.setCircleBackgroundColor(ap.getColor(R.color.cp_cont_d));
        return true;
    }
}
