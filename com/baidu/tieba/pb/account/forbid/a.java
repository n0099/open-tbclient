package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity ebk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.ebk = forbidActivity;
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
        aVar = this.ebk.ebi;
        if (aVar != null) {
            aVar2 = this.ebk.ebi;
            if (!au.isEmpty(aVar2.aHi())) {
                ForbidActivity forbidActivity = this.ebk;
                radioGroup = this.ebk.ebe;
                str = this.ebk.mForumId;
                str2 = this.ebk.mForumName;
                str3 = this.ebk.mThreadId;
                str4 = this.ebk.mUserName;
                str5 = this.ebk.mPostId;
                aVar3 = this.ebk.ebi;
                f.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), aVar3.aHi(), new b(this));
            }
        }
    }
}
