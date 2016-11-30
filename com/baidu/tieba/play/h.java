package com.baidu.tieba.play;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.b {
    final /* synthetic */ c ffA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.ffA = cVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        String str;
        c.d dVar;
        c.d dVar2;
        com.baidu.tbadk.core.sharedPref.b.um().putBoolean("video_list_confirm_play_in_mobile", true);
        c cVar = this.ffA;
        str = this.ffA.aPS;
        cVar.lm(str);
        dVar = this.ffA.aSS;
        if (dVar != null) {
            dVar2 = this.ffA.aSS;
            dVar2.LZ();
        }
        aVar.dismiss();
    }
}
