package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import com.baidu.tieba.im.data.BlackListItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ f dkR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.dkR = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IMBlackListActivity iMBlackListActivity;
        Object tag = view.getTag();
        if (tag != null && (tag instanceof BlackListItemData)) {
            iMBlackListActivity = this.dkR.dkQ;
            iMBlackListActivity.a(view, (BlackListItemData) tag);
        }
    }
}
