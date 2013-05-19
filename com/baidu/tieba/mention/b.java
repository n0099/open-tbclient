package com.baidu.tieba.mention;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
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
        ImageView imageView;
        ImageView imageView2;
        imageView = this.a.h;
        if (view != imageView) {
            imageView2 = this.a.g;
            if (view == imageView2) {
                Activity currentActivity = this.a.getLocalActivityManager().getCurrentActivity();
                if (currentActivity instanceof ReplyMeActivity) {
                    ((ReplyMeActivity) currentActivity).b();
                    return;
                } else if (currentActivity instanceof AtMeActivity) {
                    ((AtMeActivity) currentActivity).b();
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
