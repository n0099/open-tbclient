package com.baidu.tieba.tblauncher;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.plugins.Hao123Plugin;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ GuideActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        boolean z;
        imageView = this.a.k;
        imageView2 = this.a.k;
        imageView.setSelected(!imageView2.isSelected());
        imageView3 = this.a.k;
        if (imageView3.isSelected()) {
            TbadkApplication.m252getInst().setTiebaHelperOpen(true);
            Hao123Plugin hao123Plugin = (Hao123Plugin) com.baidu.tbadk.tbplugin.m.a().b(Hao123Plugin.class);
            if (hao123Plugin != null) {
                hao123Plugin.openFloating(this.a);
            }
            z = this.a.m;
            if (!z) {
                this.a.m = true;
                this.a.e();
            }
            com.baidu.tbadk.core.f.a(this.a, "tb_zs_loading");
            return;
        }
        TbadkApplication.m252getInst().setTiebaHelperOpen(false);
        Hao123Plugin hao123Plugin2 = (Hao123Plugin) com.baidu.tbadk.tbplugin.m.a().b(Hao123Plugin.class);
        if (hao123Plugin2 != null) {
            hao123Plugin2.closeFloating(this.a);
        }
    }
}
