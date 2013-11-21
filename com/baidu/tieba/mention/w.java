package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.data.ar;
import com.baidu.tieba.model.bv;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PostActivity f1856a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PostActivity postActivity) {
        this.f1856a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bv bvVar;
        bv bvVar2;
        bv bvVar3;
        bvVar = this.f1856a.l;
        if (bvVar != null) {
            bvVar2 = this.f1856a.l;
            if (bvVar2.a() != null) {
                bvVar3 = this.f1856a.l;
                ar arVar = bvVar3.a().e().get(0);
                if (arVar != null) {
                    PersonInfoActivity.a(this.f1856a, arVar.g().getId(), arVar.g().getName());
                }
            }
        }
    }
}
