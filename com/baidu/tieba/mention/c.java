package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.BaseFragmentActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ MentionActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MentionActivity mentionActivity) {
        this.a = mentionActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseFragmentActivity baseFragmentActivity;
        baseFragmentActivity = this.a.af;
        baseFragmentActivity.finish();
    }
}
