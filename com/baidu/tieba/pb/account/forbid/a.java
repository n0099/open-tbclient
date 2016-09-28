package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity ekl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.ekl = forbidActivity;
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
        aVar = this.ekl.ekj;
        if (aVar != null) {
            aVar2 = this.ekl.ekj;
            if (!az.isEmpty(aVar2.aLU())) {
                ForbidActivity forbidActivity = this.ekl;
                radioGroup = this.ekl.ekf;
                str = this.ekl.mForumId;
                str2 = this.ekl.mForumName;
                str3 = this.ekl.mThreadId;
                str4 = this.ekl.mUserName;
                str5 = this.ekl.mPostId;
                aVar3 = this.ekl.ekj;
                f.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), aVar3.aLU(), new b(this));
            }
        }
    }
}
