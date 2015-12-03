package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dz implements View.OnClickListener {
    final /* synthetic */ da cGh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dz(da daVar) {
        this.cGh = daVar;
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
        a.InterfaceC0084a interfaceC0084a;
        String str;
        pbActivity = this.cGh.cCy;
        if (pbActivity.checkUpIsLogin()) {
            kVar = this.cGh.KS;
            if (kVar != null) {
                this.cGh.alq();
            }
            kVar2 = this.cGh.KS;
            if (kVar2 != null) {
                this.cGh.cFx = false;
                pbActivity2 = this.cGh.cCy;
                kVar3 = this.cGh.KS;
                interfaceC0084a = this.cGh.cFT;
                com.baidu.tieba.tbadkCore.b.a.a(pbActivity2, (View) kVar3.ei(3).toolView, false, interfaceC0084a);
            }
            view2 = this.cGh.cFt;
            if (view2 != null) {
                view3 = this.cGh.cFt;
                view3.setVisibility(8);
                this.cGh.cFx = false;
                return;
            }
            return;
        }
        com.baidu.tbadk.core.util.av r = new com.baidu.tbadk.core.util.av("c10517").r("obj_locate", 2);
        str = this.cGh.mForumId;
        TiebaStatic.log(r.ab(ImageViewerConfig.FORUM_ID, str));
    }
}
