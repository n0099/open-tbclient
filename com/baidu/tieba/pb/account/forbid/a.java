package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity epE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.epE = forbidActivity;
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
        aVar = this.epE.epC;
        if (aVar != null) {
            aVar2 = this.epE.epC;
            if (!aw.isEmpty(aVar2.aLX())) {
                ForbidActivity forbidActivity = this.epE;
                radioGroup = this.epE.epy;
                str = this.epE.mForumId;
                str2 = this.epE.mForumName;
                str3 = this.epE.mThreadId;
                str4 = this.epE.mUserName;
                str5 = this.epE.mPostId;
                aVar3 = this.epE.epC;
                f.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), aVar3.aLX(), new b(this));
            }
        }
    }
}
