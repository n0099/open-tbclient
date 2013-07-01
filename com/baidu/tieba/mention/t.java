package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.data.an;
import com.baidu.tieba.model.bg;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PostActivity f997a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PostActivity postActivity) {
        this.f997a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bg bgVar;
        bg bgVar2;
        bg bgVar3;
        bgVar = this.f997a.n;
        if (bgVar != null) {
            bgVar2 = this.f997a.n;
            if (bgVar2.a() != null) {
                bgVar3 = this.f997a.n;
                an anVar = (an) bgVar3.a().d().get(0);
                if (anVar != null) {
                    PersonInfoActivity.a(this.f997a, anVar.h().getId(), anVar.h().getName());
                }
            }
        }
    }
}
