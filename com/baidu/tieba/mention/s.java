package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.a.am;
import com.baidu.tieba.a.ar;
import com.baidu.tieba.c.bg;
import com.baidu.tieba.write.WriteActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ PostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PostActivity postActivity) {
        this.a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bg bgVar;
        bg bgVar2;
        bg bgVar3;
        bg bgVar4;
        bgVar = this.a.n;
        if (bgVar != null) {
            bgVar2 = this.a.n;
            if (bgVar2.a() != null) {
                bgVar3 = this.a.n;
                am a = bgVar3.a();
                ar arVar = (ar) a.d().get(0);
                if (arVar != null) {
                    PostActivity postActivity = this.a;
                    String a2 = a.a().a();
                    String b = a.a().b();
                    String a3 = a.b().a();
                    String d = arVar.d();
                    int f = arVar.f();
                    com.baidu.tieba.a.b f2 = a.f();
                    bgVar4 = this.a.n;
                    WriteActivity.a(postActivity, a2, b, a3, d, f, null, f2, bgVar4.a().k());
                }
            }
        }
    }
}
