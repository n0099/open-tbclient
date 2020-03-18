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
    private TextView hrm;
    private TbImageView jBo;
    private TextView jBp;
    private TextView jBq;
    private CircleProgressBar jBr;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.jBo = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.hrm = (TextView) view.findViewById(R.id.desc);
        this.jBp = (TextView) view.findViewById(R.id.status);
        this.jBp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.aQU().dispatchMvcEvent(bVar);
            }
        });
        this.jBq = (TextView) view.findViewById(R.id.install);
        this.jBq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.aQU().dispatchMvcEvent(bVar);
            }
        });
        this.jBr = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void ai(PluginConfigWrapper pluginConfigWrapper) {
        super.ai(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.jBo.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.hrm.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.js().bf(pluginConfigWrapper.package_name)) {
                this.jBq.setVisibility(8);
                this.jBr.setVisibility(8);
                this.jBp.setVisibility(0);
                this.jBp.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.jBr.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.jBp.setVisibility(8);
                this.jBq.setVisibility(8);
                this.jBr.setVisibility(0);
            } else {
                this.jBp.setVisibility(8);
                this.jBq.setVisibility(0);
                this.jBr.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.q.a.a(tbPageContext, getRootView());
        this.jBr.setCircleForegroundColor(am.getColor(R.color.cp_link_tip_a));
        this.jBr.setCircleBackgroundColor(am.getColor(R.color.cp_cont_d));
        return true;
    }
}
