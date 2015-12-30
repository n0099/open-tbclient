package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ej implements View.OnClickListener {
    final /* synthetic */ dk cKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ej(dk dkVar) {
        this.cKg = dkVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        View view2;
        View view3;
        PbActivity pbActivity2;
        com.baidu.tbadk.editortools.k kVar3;
        a.InterfaceC0080a interfaceC0080a;
        String str;
        pbActivity = this.cKg.cGj;
        if (pbActivity.checkUpIsLogin()) {
            kVar = this.cKg.Li;
            if (kVar != null) {
                this.cKg.amC();
            }
            kVar2 = this.cKg.Li;
            if (kVar2 != null) {
                this.cKg.cJw = false;
                pbActivity2 = this.cKg.cGj;
                kVar3 = this.cKg.Li;
                interfaceC0080a = this.cKg.cJS;
                com.baidu.tieba.tbadkCore.b.a.a(pbActivity2, (View) kVar3.ec(3).toolView, false, interfaceC0080a);
            }
            view2 = this.cKg.cJs;
            if (view2 != null) {
                view3 = this.cKg.cJs;
                view3.setVisibility(8);
                this.cKg.cJw = false;
                return;
            }
            return;
        }
        com.baidu.tbadk.core.util.av r = new com.baidu.tbadk.core.util.av("c10517").r("obj_locate", 2);
        str = this.cKg.mForumId;
        TiebaStatic.log(r.aa(ImageViewerConfig.FORUM_ID, str));
    }
}
