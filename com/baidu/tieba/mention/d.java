package com.baidu.tieba.mention;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ MentionActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MentionActivity mentionActivity) {
        this.a = mentionActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.a(view);
    }
}
