package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity cBm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.cBm = forbidActivity;
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
        aVar = this.cBm.cBk;
        if (aVar != null) {
            aVar2 = this.cBm.cBk;
            if (!ax.isEmpty(aVar2.akr())) {
                ForbidActivity forbidActivity = this.cBm;
                radioGroup = this.cBm.cBh;
                str = this.cBm.mForumId;
                str2 = this.cBm.mForumName;
                str3 = this.cBm.mThreadId;
                str4 = this.cBm.mUserName;
                str5 = this.cBm.mPostId;
                aVar3 = this.cBm.cBk;
                f.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), aVar3.akr(), new b(this));
            }
        }
    }
}
