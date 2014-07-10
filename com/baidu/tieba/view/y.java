package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ SearchBoxView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(SearchBoxView searchBoxView) {
        this.a = searchBoxView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        activity = this.a.a;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.g(activity, 16003)));
    }
}
