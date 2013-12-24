package com.baidu.tieba.mention;

import android.view.View;
import android.widget.ImageView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.av;
import com.baidu.tieba.write.AtListActivity;
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
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        imageView = this.a.Y;
        if (view == imageView && TiebaApplication.C()) {
            if (TiebaApplication.h().t()) {
                baseFragmentActivity2 = this.a.af;
                StatService.onEvent(baseFragmentActivity2, "msg_newchat_tab_c", "click", 1);
            }
            new av("pchat", "2").start();
            baseFragmentActivity = this.a.af;
            AtListActivity.a(baseFragmentActivity, 12011);
        }
    }
}
