package com.baidu.tieba.pb.video;

import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements c.f {
    final /* synthetic */ d etA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(d dVar) {
        this.etA = dVar;
    }

    @Override // com.baidu.tieba.play.c.f
    public void aPM() {
        bh bhVar;
        bh bhVar2;
        bh bhVar3;
        bh bhVar4;
        bh bhVar5;
        bhVar = this.etA.etu;
        if (bhVar != null) {
            long j = 0;
            bhVar2 = this.etA.etu;
            if (bhVar2.sz() != null) {
                bhVar5 = this.etA.etu;
                j = bhVar5.sz().channelId;
            }
            this.etA.JB();
            ar arVar = new ar("c10795");
            bhVar3 = this.etA.etu;
            ar ab = arVar.ab("tid", bhVar3.getTid());
            bhVar4 = this.etA.etu;
            TiebaStatic.log(ab.g("fid", bhVar4.getFid()).g("obj_id", j));
        }
    }
}
