package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ ForbidActivity.a cHW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ForbidActivity.a aVar) {
        this.cHW = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cHW.cHV = ((ForbidActivity.b) view.getTag()).mIndex;
        this.cHW.notifyDataSetChanged();
    }
}
