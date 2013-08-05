package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.as;
import com.baidu.tieba.data.aw;
import com.baidu.tieba.model.bl;
import com.baidu.tieba.write.WriteActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PostActivity f1309a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PostActivity postActivity) {
        this.f1309a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        blVar = this.f1309a.n;
        if (blVar != null) {
            blVar2 = this.f1309a.n;
            if (blVar2.a() != null) {
                blVar3 = this.f1309a.n;
                as a2 = blVar3.a();
                aw awVar = (aw) a2.c().get(0);
                if (awVar != null) {
                    PostActivity postActivity = this.f1309a;
                    String a3 = a2.a().a();
                    String b = a2.a().b();
                    String a4 = a2.b().a();
                    String d = awVar.d();
                    int e = awVar.e();
                    AntiData e2 = a2.e();
                    blVar4 = this.f1309a.n;
                    WriteActivity.a(postActivity, a3, b, a4, d, e, null, e2, blVar4.a().h());
                }
            }
        }
    }
}
