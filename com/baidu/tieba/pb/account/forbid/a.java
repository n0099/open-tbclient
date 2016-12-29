package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity dUQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.dUQ = forbidActivity;
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
        aVar = this.dUQ.dUO;
        if (aVar != null) {
            aVar2 = this.dUQ.dUO;
            if (!av.isEmpty(aVar2.aHO())) {
                ForbidActivity forbidActivity = this.dUQ;
                radioGroup = this.dUQ.dUK;
                str = this.dUQ.mForumId;
                str2 = this.dUQ.mForumName;
                str3 = this.dUQ.mThreadId;
                str4 = this.dUQ.mUserName;
                str5 = this.dUQ.mPostId;
                aVar3 = this.dUQ.dUO;
                f.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), aVar3.aHO(), new b(this));
            }
        }
    }
}
