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
/* loaded from: classes15.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TextView jcM;
    private TbImageView lwl;
    private TextView lwm;
    private TextView lwn;
    private CircleProgressBar lwo;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.lwl = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.jcM = (TextView) view.findViewById(R.id.desc);
        this.lwm = (TextView) view.findViewById(R.id.status);
        this.lwm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.btQ().dispatchMvcEvent(bVar);
            }
        });
        this.lwn = (TextView) view.findViewById(R.id.install);
        this.lwn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.btQ().dispatchMvcEvent(bVar);
            }
        });
        this.lwo = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void aq(PluginConfigWrapper pluginConfigWrapper) {
        super.aq(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.lwl.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.jcM.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.pO().cz(pluginConfigWrapper.package_name)) {
                this.lwn.setVisibility(8);
                this.lwo.setVisibility(8);
                this.lwm.setVisibility(0);
                this.lwm.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.lwo.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.lwm.setVisibility(8);
                this.lwn.setVisibility(8);
                this.lwo.setVisibility(0);
            } else {
                this.lwm.setVisibility(8);
                this.lwn.setVisibility(0);
                this.lwo.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.r.a.a(tbPageContext, getRootView());
        this.lwo.setCircleForegroundColor(ap.getColor(R.color.cp_link_tip_a));
        this.lwo.setCircleBackgroundColor(ap.getColor(R.color.cp_cont_d));
        return true;
    }
}
