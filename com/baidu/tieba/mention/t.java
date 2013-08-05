package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.data.aw;
import com.baidu.tieba.model.bl;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PostActivity f1310a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PostActivity postActivity) {
        this.f1310a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        blVar = this.f1310a.n;
        if (blVar != null) {
            blVar2 = this.f1310a.n;
            if (blVar2.a() != null) {
                blVar3 = this.f1310a.n;
                aw awVar = (aw) blVar3.a().c().get(0);
                if (awVar != null) {
                    PersonInfoActivity.a(this.f1310a, awVar.g().getId(), awVar.g().getName());
                }
            }
        }
    }
}
