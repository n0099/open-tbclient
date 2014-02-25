package com.baidu.tieba.person.post;

import android.view.View;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ ReplyLinearLayout a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(ReplyLinearLayout replyLinearLayout) {
        this.a = replyLinearLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr = (String[]) view.getTag();
        if (strArr != null) {
            if (SocialConstants.FALSE.equals(strArr[3])) {
                NewPbActivity.a(this.a.getContext(), strArr[1], strArr[2], "person_post_reply");
            } else {
                NewPbActivity.b(this.a.getContext(), strArr[1], strArr[2], "person_post_reply");
            }
        }
    }
}
