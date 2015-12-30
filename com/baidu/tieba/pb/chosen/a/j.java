package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import com.baidu.tieba.pb.chosen.a.i;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i cCF;
    private final /* synthetic */ ExcellentPbThreadInfo cCG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, ExcellentPbThreadInfo excellentPbThreadInfo) {
        this.cCF = iVar;
        this.cCG = excellentPbThreadInfo;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x001f: IGET  (r4v1 java.lang.Long A[REMOVE]) = 
      (wrap: tbclient.ExcPbPage.ExcellentPbThreadInfo : 0x001d: IGET  (r4v0 tbclient.ExcPbPage.ExcellentPbThreadInfo A[REMOVE]) = (r5v0 'this' com.baidu.tieba.pb.chosen.a.j A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.pb.chosen.a.j.cCG tbclient.ExcPbPage.ExcellentPbThreadInfo)
     tbclient.ExcPbPage.ExcellentPbThreadInfo.thread_id java.lang.Long)] */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i.a aVar;
        i.a aVar2;
        aVar = this.cCF.cCA;
        if (aVar != null) {
            aVar2 = this.cCF.cCA;
            aVar2.g(this.cCG.forum.forum_id.longValue(), new StringBuilder().append(this.cCG.thread_id).toString());
        }
    }
}
