package com.baidu.tieba.person.post;

import android.app.Activity;
import android.view.View;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.pb.NewPbActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f2276a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.f2276a = jVar;
    }

    @Override // com.baidu.tieba.person.post.c
    public void a(View view) {
        Activity activity;
        Activity activity2;
        switch (view.getId()) {
            case R.id.portrait /* 2131099850 */:
                activity2 = this.f2276a.e;
                activity2.finish();
                return;
            case R.id.item_header /* 2131100060 */:
            case R.id.original_post_title /* 2131100798 */:
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
            case R.id.username /* 2131100802 */:
                activity = this.f2276a.e;
                activity.finish();
                return;
            default:
                return;
        }
    }
}
