package com.baidu.tieba.mention;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ MentionActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(MentionActivity mentionActivity) {
        this.a = mentionActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        Button button2;
        button = this.a.h;
        if (view != button) {
            button2 = this.a.g;
            if (view == button2) {
                Activity currentActivity = this.a.getLocalActivityManager().getCurrentActivity();
                if (currentActivity instanceof ReplyMeActivity) {
                    ((ReplyMeActivity) currentActivity).i();
                    return;
                } else if (currentActivity instanceof AtMeActivity) {
                    ((AtMeActivity) currentActivity).i();
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        this.a.finish();
    }
}
