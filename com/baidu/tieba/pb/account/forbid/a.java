package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity bZl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.bZl = forbidActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ForbidActivity.a aVar;
        ForbidActivity.a aVar2;
        RadioGroup radioGroup;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        ForbidActivity.a aVar3;
        aVar = this.bZl.bZj;
        if (aVar != null) {
            aVar2 = this.bZl.bZj;
            if (!aq.isEmpty(aVar2.acE())) {
                ForbidActivity forbidActivity = this.bZl;
                radioGroup = this.bZl.bZg;
                str = this.bZl.mForumId;
                str2 = this.bZl.mForumName;
                str3 = this.bZl.mThreadId;
                str4 = this.bZl.aju;
                str5 = this.bZl.mPostId;
                aVar3 = this.bZl.bZj;
                f.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), aVar3.acE(), new b(this));
            }
        }
    }
}
