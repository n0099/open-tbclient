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
/* loaded from: classes8.dex */
public class a extends com.baidu.tbadk.mvc.f.a<PluginConfigWrapper, com.baidu.tbadk.mvc.d.b> {
    private TextView kyk;
    private TbImageView mLD;
    private TextView mLE;
    private TextView mLF;
    private CircleProgressBar mLG;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mLD = (TbImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.kyk = (TextView) view.findViewById(R.id.desc);
        this.mLE = (TextView) view.findViewById(R.id.status);
        this.mLE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(3, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bDI().dispatchMvcEvent(bVar);
            }
        });
        this.mLF = (TextView) view.findViewById(R.id.install);
        this.mLF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(2, a.this.getData(), null, null);
                bVar.setUniqueId(a.this.getUniqueId());
                a.this.bDI().dispatchMvcEvent(bVar);
            }
        });
        this.mLG = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: b */
    public void aw(PluginConfigWrapper pluginConfigWrapper) {
        super.aw(pluginConfigWrapper);
        if (pluginConfigWrapper != null) {
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.mLD.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.title.setText(pluginConfigWrapper.display_name);
            this.kyk.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.pv().cA(pluginConfigWrapper.package_name)) {
                this.mLF.setVisibility(8);
                this.mLG.setVisibility(8);
                this.mLE.setVisibility(0);
                this.mLE.setText(R.string.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.mLG.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.mLE.setVisibility(8);
                this.mLF.setVisibility(8);
                this.mLG.setVisibility(0);
            } else {
                this.mLE.setVisibility(8);
                this.mLF.setVisibility(0);
                this.mLG.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.r.a.a(tbPageContext, getRootView());
        this.mLG.setCircleForegroundColor(ap.getColor(R.color.CAM_X0302));
        this.mLG.setCircleBackgroundColor(ap.getColor(R.color.CAM_X0109));
        return true;
    }
}
