package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity cHS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.cHS = forbidActivity;
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
        aVar = this.cHS.cHQ;
        if (aVar != null) {
            aVar2 = this.cHS.cHQ;
            if (!aw.isEmpty(aVar2.aop())) {
                ForbidActivity forbidActivity = this.cHS;
                radioGroup = this.cHS.cHN;
                str = this.cHS.mForumId;
                str2 = this.cHS.mForumName;
                str3 = this.cHS.mThreadId;
                str4 = this.cHS.mUserName;
                str5 = this.cHS.mPostId;
                aVar3 = this.cHS.cHQ;
                f.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), aVar3.aop(), new b(this));
            }
        }
    }
}
