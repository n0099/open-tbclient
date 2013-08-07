package com.baidu.tieba.mention;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MentionActivity f1291a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(MentionActivity mentionActivity) {
        this.f1291a = mentionActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        ImageView imageView2;
        imageView = this.f1291a.h;
        if (view != imageView) {
            imageView2 = this.f1291a.g;
            if (view == imageView2) {
                Activity currentActivity = this.f1291a.getLocalActivityManager().getCurrentActivity();
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
        this.f1291a.finish();
    }
}
