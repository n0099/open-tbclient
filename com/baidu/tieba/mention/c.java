package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.BaseFragmentActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MentionActivity f1856a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MentionActivity mentionActivity) {
        this.f1856a = mentionActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseFragmentActivity baseFragmentActivity;
        baseFragmentActivity = this.f1856a.ag;
        baseFragmentActivity.finish();
    }
}
