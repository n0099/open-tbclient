package com.baidu.tieba.mention;

import android.view.View;
import android.widget.ImageView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.write.AtListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MentionActivity f1325a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(MentionActivity mentionActivity) {
        this.f1325a = mentionActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        imageView = this.f1325a.k;
        if (view == imageView && TiebaApplication.F()) {
            if (TiebaApplication.g().u()) {
                StatService.onEvent(this.f1325a, "msg_newchat_tab_c", "click", 1);
            }
            AtListActivity.a(this.f1325a, 12011);
        }
    }
}
