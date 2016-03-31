package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity dbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.dbb = forbidActivity;
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
        aVar = this.dbb.daZ;
        if (aVar != null) {
            aVar2 = this.dbb.daZ;
            if (!ay.isEmpty(aVar2.avc())) {
                ForbidActivity forbidActivity = this.dbb;
                radioGroup = this.dbb.daW;
                str = this.dbb.mForumId;
                str2 = this.dbb.mForumName;
                str3 = this.dbb.mThreadId;
                str4 = this.dbb.mUserName;
                str5 = this.dbb.mPostId;
                aVar3 = this.dbb.daZ;
                f.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), aVar3.avc(), new b(this));
            }
        }
    }
}
