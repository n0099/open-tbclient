package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity dJZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.dJZ = forbidActivity;
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
        aVar = this.dJZ.dJX;
        if (aVar != null) {
            aVar2 = this.dJZ.dJX;
            if (!ba.isEmpty(aVar2.aDq())) {
                ForbidActivity forbidActivity = this.dJZ;
                radioGroup = this.dJZ.dJT;
                str = this.dJZ.mForumId;
                str2 = this.dJZ.mForumName;
                str3 = this.dJZ.mThreadId;
                str4 = this.dJZ.mUserName;
                str5 = this.dJZ.mPostId;
                aVar3 = this.dJZ.dJX;
                f.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), aVar3.aDq(), new b(this));
            }
        }
    }
}
