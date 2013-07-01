package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.aj;
import com.baidu.tieba.data.an;
import com.baidu.tieba.model.bg;
import com.baidu.tieba.write.WriteActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PostActivity f996a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PostActivity postActivity) {
        this.f996a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bg bgVar;
        bg bgVar2;
        bg bgVar3;
        bg bgVar4;
        bgVar = this.f996a.n;
        if (bgVar != null) {
            bgVar2 = this.f996a.n;
            if (bgVar2.a() != null) {
                bgVar3 = this.f996a.n;
                aj a2 = bgVar3.a();
                an anVar = (an) a2.d().get(0);
                if (anVar != null) {
                    PostActivity postActivity = this.f996a;
                    String a3 = a2.a().a();
                    String b = a2.a().b();
                    String a4 = a2.b().a();
                    String d = anVar.d();
                    int f = anVar.f();
                    AntiData f2 = a2.f();
                    bgVar4 = this.f996a.n;
                    WriteActivity.a(postActivity, a3, b, a4, d, f, null, f2, bgVar4.a().k());
                }
            }
        }
    }
}
