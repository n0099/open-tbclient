package com.baidu.tieba.person.post;

import android.app.Activity;
import android.view.View;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.pb.NewPbActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements c {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.a = lVar;
    }

    @Override // com.baidu.tieba.person.post.c
    public void a(View view) {
        Activity activity;
        Activity activity2;
        switch (view.getId()) {
            case R.id.portrait /* 2131099912 */:
                activity2 = this.a.e;
                activity2.finish();
                return;
            case R.id.item_header /* 2131100302 */:
            case R.id.original_post_title /* 2131101411 */:
                String[] strArr = (String[]) view.getTag();
                if (strArr != null) {
                    if (SocialConstants.FALSE.equals(strArr[2]) || strArr[1] == null) {
                        NewPbActivity.a(view.getContext(), strArr[0], strArr[1], "person_post_reply");
                        return;
                    } else {
                        NewPbActivity.b(view.getContext(), strArr[0], strArr[1], "person_post_reply");
                        return;
                    }
                }
                return;
            case R.id.username /* 2131101415 */:
                activity = this.a.e;
                activity.finish();
                return;
            default:
                return;
        }
    }
}
