package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity dWi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.dWi = forbidActivity;
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
        aVar = this.dWi.dWg;
        if (aVar != null) {
            aVar2 = this.dWi.dWg;
            if (!ba.isEmpty(aVar2.aGA())) {
                ForbidActivity forbidActivity = this.dWi;
                radioGroup = this.dWi.dWc;
                str = this.dWi.mForumId;
                str2 = this.dWi.mForumName;
                str3 = this.dWi.mThreadId;
                str4 = this.dWi.mUserName;
                str5 = this.dWi.mPostId;
                aVar3 = this.dWi.dWg;
                f.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), aVar3.aGA(), new b(this));
            }
        }
    }
}
