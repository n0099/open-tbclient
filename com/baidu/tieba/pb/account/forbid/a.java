package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity ege;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.ege = forbidActivity;
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
        aVar = this.ege.egc;
        if (aVar != null) {
            aVar2 = this.ege.egc;
            if (!au.isEmpty(aVar2.aIT())) {
                ForbidActivity forbidActivity = this.ege;
                radioGroup = this.ege.efY;
                str = this.ege.mForumId;
                str2 = this.ege.mForumName;
                str3 = this.ege.mThreadId;
                str4 = this.ege.mUserName;
                str5 = this.ege.mPostId;
                aVar3 = this.ege.egc;
                f.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), aVar3.aIT(), new b(this));
            }
        }
    }
}
