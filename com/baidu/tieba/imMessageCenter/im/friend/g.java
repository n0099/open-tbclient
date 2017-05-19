package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import com.baidu.tieba.im.data.BlackListItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ f deU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.deU = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IMBlackListActivity iMBlackListActivity;
        Object tag = view.getTag();
        if (tag != null && (tag instanceof BlackListItemData)) {
            iMBlackListActivity = this.deU.deT;
            iMBlackListActivity.a(view, (BlackListItemData) tag);
        }
    }
}
