package com.baidu.tieba.play;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.b {
    final /* synthetic */ c eIS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.eIS = cVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        String str;
        c.d dVar;
        c.d dVar2;
        com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("video_list_confirm_play_in_mobile", true);
        c cVar = this.eIS;
        str = this.eIS.aPj;
        cVar.startPlay(str);
        dVar = this.eIS.aSj;
        if (dVar != null) {
            dVar2 = this.eIS.aSj;
            dVar2.Ls();
        }
        aVar.dismiss();
    }
}
