package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.home.ForumTopicActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ar implements View.OnClickListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ForumTopicActivity.a(this.a, this.a.getString(R.string.member_benefits), com.baidu.tieba.data.h.b + "mo/q/topic_page/tbeannote?st_type=pb_t_show");
    }
}
