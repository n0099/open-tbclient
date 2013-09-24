package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.data.as;
import com.baidu.tieba.model.bm;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PostActivity f1379a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PostActivity postActivity) {
        this.f1379a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        bmVar = this.f1379a.n;
        if (bmVar != null) {
            bmVar2 = this.f1379a.n;
            if (bmVar2.a() != null) {
                bmVar3 = this.f1379a.n;
                as asVar = bmVar3.a().d().get(0);
                if (asVar != null) {
                    PersonInfoActivity.a(this.f1379a, asVar.g().getId(), asVar.g().getName());
                }
            }
        }
    }
}
