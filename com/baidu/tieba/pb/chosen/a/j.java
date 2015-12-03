package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import com.baidu.tieba.pb.chosen.a.i;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i cyZ;
    private final /* synthetic */ ExcellentPbThreadInfo cza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, ExcellentPbThreadInfo excellentPbThreadInfo) {
        this.cyZ = iVar;
        this.cza = excellentPbThreadInfo;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x001f: IGET  (r4v1 java.lang.Long A[REMOVE]) = 
      (wrap: tbclient.ExcPbPage.ExcellentPbThreadInfo : 0x001d: IGET  (r4v0 tbclient.ExcPbPage.ExcellentPbThreadInfo A[REMOVE]) = (r5v0 'this' com.baidu.tieba.pb.chosen.a.j A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.pb.chosen.a.j.cza tbclient.ExcPbPage.ExcellentPbThreadInfo)
     tbclient.ExcPbPage.ExcellentPbThreadInfo.thread_id java.lang.Long)] */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i.a aVar;
        i.a aVar2;
        aVar = this.cyZ.cyU;
        if (aVar != null) {
            aVar2 = this.cyZ.cyU;
            aVar2.g(this.cza.forum.forum_id.longValue(), new StringBuilder().append(this.cza.thread_id).toString());
        }
    }
}
