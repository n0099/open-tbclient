package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ ForbidActivity.a eko;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ForbidActivity.a aVar) {
        this.eko = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.eko.cxd = ((ForbidActivity.b) view.getTag()).mIndex;
        this.eko.notifyDataSetChanged();
    }
}
