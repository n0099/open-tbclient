package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        str = this.a.ak;
        if (str != null) {
            PbActivity pbActivity = this.a;
            str2 = this.a.ak;
            FrsActivity.a(pbActivity, str2, (String) null);
        }
    }
}
