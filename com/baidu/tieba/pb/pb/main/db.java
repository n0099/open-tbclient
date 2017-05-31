package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class db implements View.OnClickListener {
    final /* synthetic */ cv eod;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(cv cvVar) {
        this.eod = cvVar;
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
        fVar = this.eod.ekc;
        if (fVar.aIL() != null) {
            fVar2 = this.eod.ekc;
            List<Long> list = fVar2.aIL().ejv;
            fVar3 = this.eod.ekc;
            int count = fVar3.aIL().getCount();
            if (list.size() != count) {
                if (list.size() >= count + 5) {
                    fVar5 = this.eod.ekc;
                    fVar5.aIL().setCount(count + 5);
                    pbActivity2 = this.eod.elf;
                    pbActivity2.aJF().aLn().bV(list.subList(count, count + 5));
                } else if (list.size() < count + 5) {
                    pbActivity = this.eod.elf;
                    pbActivity.aJF().aLn().bV(list.subList(count, list.size()));
                    fVar4 = this.eod.ekc;
                    fVar4.aIL().setCount(list.size());
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c12040"));
            }
        }
    }
}
