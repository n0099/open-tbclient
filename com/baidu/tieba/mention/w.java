package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.data.ar;
import com.baidu.tieba.model.bv;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ PostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PostActivity postActivity) {
        this.a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bv bvVar;
        bv bvVar2;
        bv bvVar3;
        bvVar = this.a.l;
        if (bvVar != null) {
            bvVar2 = this.a.l;
            if (bvVar2.a() != null) {
                bvVar3 = this.a.l;
                ar arVar = bvVar3.a().e().get(0);
                if (arVar != null) {
                    PersonInfoActivity.a(this.a, arVar.g().getId(), arVar.g().getName());
                }
            }
        }
    }
}
