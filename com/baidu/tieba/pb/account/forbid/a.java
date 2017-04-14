package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity eel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.eel = forbidActivity;
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
        aVar = this.eel.eej;
        if (aVar != null) {
            aVar2 = this.eel.eej;
            if (!au.isEmpty(aVar2.aJa())) {
                ForbidActivity forbidActivity = this.eel;
                radioGroup = this.eel.eef;
                str = this.eel.mForumId;
                str2 = this.eel.mForumName;
                str3 = this.eel.mThreadId;
                str4 = this.eel.mUserName;
                str5 = this.eel.mPostId;
                aVar3 = this.eel.eej;
                f.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), aVar3.aJa(), new b(this));
            }
        }
    }
}
