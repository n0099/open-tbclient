package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw implements View.OnClickListener {
    final /* synthetic */ cq eiw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(cq cqVar) {
        this.eiw = cqVar;
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
        fVar = this.eiw.eeB;
        if (fVar.aHQ() != null) {
            fVar2 = this.eiw.eeB;
            List<Long> list = fVar2.aHQ().edV;
            fVar3 = this.eiw.eeB;
            int count = fVar3.aHQ().getCount();
            if (list.size() != count) {
                if (list.size() >= count + 5) {
                    fVar5 = this.eiw.eeB;
                    fVar5.aHQ().setCount(count + 5);
                    pbActivity2 = this.eiw.efF;
                    pbActivity2.aIN().aKt().bW(list.subList(count, count + 5));
                } else if (list.size() < count + 5) {
                    pbActivity = this.eiw.efF;
                    pbActivity.aIN().aKt().bW(list.subList(count, list.size()));
                    fVar4 = this.eiw.eeB;
                    fVar4.aHQ().setCount(list.size());
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c12040"));
            }
        }
    }
}
