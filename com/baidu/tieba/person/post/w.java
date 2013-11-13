package com.baidu.tieba.person.post;

import android.view.View;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
class w implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReplyLinearLayout f2283a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(ReplyLinearLayout replyLinearLayout) {
        this.f2283a = replyLinearLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr = (String[]) view.getTag();
        if (strArr != null) {
            if (SocialConstants.FALSE.equals(strArr[3])) {
                NewPbActivity.a(this.f2283a.getContext(), strArr[1], strArr[2], "person_post_reply");
            } else {
                NewPbActivity.b(this.f2283a.getContext(), strArr[1], strArr[2], "person_post_reply");
            }
        }
    }
}
