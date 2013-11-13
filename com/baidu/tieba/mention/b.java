package com.baidu.tieba.mention;

import android.view.View;
import android.widget.ImageView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.write.AtListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MentionActivity f1855a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(MentionActivity mentionActivity) {
        this.f1855a = mentionActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        imageView = this.f1855a.Z;
        if (view == imageView && TiebaApplication.B()) {
            if (TiebaApplication.g().s()) {
                baseFragmentActivity2 = this.f1855a.ag;
                StatService.onEvent(baseFragmentActivity2, "msg_newchat_tab_c", "click", 1);
            }
            baseFragmentActivity = this.f1855a.ag;
            AtListActivity.a(baseFragmentActivity, 12011);
        }
    }
}
