package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class di implements View.OnClickListener {
    final /* synthetic */ dc exj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public di(dc dcVar) {
        this.exj = dcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.pb.data.f fVar;
        com.baidu.tieba.pb.data.f fVar2;
        com.baidu.tieba.pb.data.f fVar3;
        PbActivity pbActivity;
        com.baidu.tieba.pb.data.f fVar4;
        com.baidu.tieba.pb.data.f fVar5;
        PbActivity pbActivity2;
        fVar = this.exj.eta;
        if (fVar.aMF() != null) {
            fVar2 = this.exj.eta;
            List<Long> list = fVar2.aMF().est;
            fVar3 = this.exj.eta;
            int count = fVar3.aMF().getCount();
            if (list.size() != count) {
                if (list.size() >= count + 5) {
                    fVar5 = this.exj.eta;
                    fVar5.aMF().setCount(count + 5);
                    pbActivity2 = this.exj.euf;
                    pbActivity2.aNz().aPk().ck(list.subList(count, count + 5));
                } else if (list.size() < count + 5) {
                    pbActivity = this.exj.euf;
                    pbActivity.aNz().aPk().ck(list.subList(count, list.size()));
                    fVar4 = this.exj.eta;
                    fVar4.aMF().setCount(list.size());
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c12040"));
            }
        }
    }
}
