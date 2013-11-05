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
    final /* synthetic */ MentionActivity f1858a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(MentionActivity mentionActivity) {
        this.f1858a = mentionActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        imageView = this.f1858a.j;
        if (view == imageView && TiebaApplication.D()) {
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this.f1858a, "msg_newchat_tab_c", "click", 1);
            }
            AtListActivity.a(this.f1858a, 12011);
        }
    }
}
