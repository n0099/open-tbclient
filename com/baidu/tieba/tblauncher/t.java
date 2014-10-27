package com.baidu.tieba.tblauncher;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SingleMentionActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(MainTabActivity mainTabActivity) {
        this.this$0 = mainTabActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2 = this.this$0;
        textView = this.this$0.aEv;
        mainTabActivity2.p(textView, 0);
        MainTabActivity.bOo = false;
        mainTabActivity = this.this$0.bOO;
        this.this$0.sendMessage(new CustomMessage(2002001, new SingleMentionActivityConfig(mainTabActivity)));
    }
}
