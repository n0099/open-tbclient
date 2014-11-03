package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.CaptureActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ w bRT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.bRT = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        activity = this.bRT.mCurrentActivity;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CaptureActivityConfig(activity, 16003)));
    }
}
