package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tieba.ao;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
public class q implements DialogInterface.OnClickListener {
    final /* synthetic */ j a;
    private com.baidu.tieba.data.u b = null;

    public q(j jVar) {
        this.a = jVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        int i3;
        Activity activity;
        Activity activity2;
        Activity activity3;
        int i4;
        int i5;
        Activity activity4;
        Activity activity5;
        int i6;
        int i7;
        Activity activity6;
        Activity activity7;
        Activity activity8;
        if (this.b != null) {
            switch (i) {
                case 0:
                    i6 = this.a.i;
                    if (i6 == 2) {
                        activity8 = this.a.c;
                        ao.a(activity8, "at_me_visit_post");
                    } else {
                        i7 = this.a.i;
                        if (i7 == 1) {
                            activity6 = this.a.c;
                            ao.a(activity6, "my_reply_visit_post");
                        }
                    }
                    if (this.b.j()) {
                        this.a.b(this.b);
                        return;
                    }
                    activity7 = this.a.c;
                    NewPbActivity.a(activity7, this.b.g(), this.b.h(), "mention");
                    return;
                case 1:
                    i4 = this.a.i;
                    if (i4 == 2) {
                        activity5 = this.a.c;
                        ao.a(activity5, "at_me_to_reply");
                    } else {
                        i5 = this.a.i;
                        if (i5 == 1) {
                            activity4 = this.a.c;
                            ao.a(activity4, "my_reply_to_reply");
                        }
                    }
                    if (this.b.j()) {
                        this.a.a(this.b.g(), this.b.h(), this.b.i() != null ? this.b.i().getName() : null, 2);
                        return;
                    } else {
                        this.a.a(this.b.g(), this.b.h(), null, 1);
                        return;
                    }
                case 2:
                    i2 = this.a.i;
                    if (i2 == 2) {
                        activity3 = this.a.c;
                        ao.a(activity3, "at_me_visit_pb");
                    } else {
                        i3 = this.a.i;
                        if (i3 == 1) {
                            activity = this.a.c;
                            ao.a(activity, "my_reply_visit_pb");
                        }
                    }
                    activity2 = this.a.c;
                    NewPbActivity.a(activity2, this.b.g(), null, "mention");
                    return;
                default:
                    return;
            }
        }
    }
}
