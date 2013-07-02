package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.data.an;
import com.baidu.tieba.model.bg;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ PostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PostActivity postActivity) {
        this.a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bg bgVar;
        bg bgVar2;
        bg bgVar3;
        bgVar = this.a.n;
        if (bgVar != null) {
            bgVar2 = this.a.n;
            if (bgVar2.a() != null) {
                bgVar3 = this.a.n;
                an anVar = (an) bgVar3.a().d().get(0);
                if (anVar != null) {
                    PersonInfoActivity.a(this.a, anVar.h().getId(), anVar.h().getName());
                }
            }
        }
    }
}
