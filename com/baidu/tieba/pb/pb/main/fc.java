package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fc implements View.OnClickListener {
    final /* synthetic */ dz cSw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fc(dz dzVar) {
        this.cSw = dzVar;
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
        pbActivity = this.cSw.cNL;
        if (pbActivity.checkUpIsLogin()) {
            kVar = this.cSw.Lx;
            if (kVar != null) {
                this.cSw.aqZ();
            }
            kVar2 = this.cSw.Lx;
            if (kVar2 != null) {
                this.cSw.cRB = false;
                pbActivity2 = this.cSw.cNL;
                kVar3 = this.cSw.Lx;
                interfaceC0084a = this.cSw.cRX;
                com.baidu.tieba.tbadkCore.b.a.a(pbActivity2, (View) kVar3.ex(3).toolView, false, interfaceC0084a);
            }
            view2 = this.cSw.cRx;
            if (view2 != null) {
                view3 = this.cSw.cRx;
                view3.setVisibility(8);
                this.cSw.cRB = false;
                return;
            }
            return;
        }
        com.baidu.tbadk.core.util.au r = new com.baidu.tbadk.core.util.au("c10517").r("obj_locate", 2);
        str = this.cSw.mForumId;
        TiebaStatic.log(r.aa(ImageViewerConfig.FORUM_ID, str));
    }
}
