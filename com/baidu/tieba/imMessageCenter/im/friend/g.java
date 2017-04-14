package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import com.baidu.tieba.im.data.BlackListItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ f diA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.diA = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IMBlackListActivity iMBlackListActivity;
        Object tag = view.getTag();
        if (tag != null && (tag instanceof BlackListItemData)) {
            iMBlackListActivity = this.diA.diz;
            iMBlackListActivity.a(view, (BlackListItemData) tag);
        }
    }
}
