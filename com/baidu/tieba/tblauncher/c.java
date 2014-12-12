package com.baidu.tieba.tblauncher;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.plugins.Hao123Plugin;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ GuideActivity caM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GuideActivity guideActivity) {
        this.caM = guideActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        boolean z;
        imageView = this.caM.caD;
        imageView2 = this.caM.caD;
        imageView.setSelected(!imageView2.isSelected());
        imageView3 = this.caM.caD;
        if (imageView3.isSelected()) {
            TbadkApplication.getInst().setTiebaHelperOpen(true);
            Hao123Plugin hao123Plugin = (Hao123Plugin) PluginCenter.gX().hc();
            if (hao123Plugin != null) {
                hao123Plugin.openFloating(this.caM.getPageContext().getPageActivity());
            }
            z = this.caM.bwt;
            if (!z) {
                this.caM.bwt = true;
                this.caM.aiv();
            }
            com.baidu.tbadk.core.i.B(this.caM.getPageContext().getPageActivity(), "tb_zs_loading");
            return;
        }
        TbadkApplication.getInst().setTiebaHelperOpen(false);
        Hao123Plugin hao123Plugin2 = (Hao123Plugin) PluginCenter.gX().hc();
        if (hao123Plugin2 != null) {
            hao123Plugin2.closeFloating(this.caM.getPageContext().getPageActivity());
        }
    }
}
