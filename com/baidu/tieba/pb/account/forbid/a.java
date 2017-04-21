package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity egB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.egB = forbidActivity;
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
        aVar = this.egB.egz;
        if (aVar != null) {
            aVar2 = this.egB.egz;
            if (!au.isEmpty(aVar2.aKb())) {
                ForbidActivity forbidActivity = this.egB;
                radioGroup = this.egB.egv;
                str = this.egB.mForumId;
                str2 = this.egB.mForumName;
                str3 = this.egB.mThreadId;
                str4 = this.egB.mUserName;
                str5 = this.egB.mPostId;
                aVar3 = this.egB.egz;
                f.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), aVar3.aKb(), new b(this));
            }
        }
    }
}
