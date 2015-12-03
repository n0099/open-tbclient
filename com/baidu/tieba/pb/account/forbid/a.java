package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity cxF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.cxF = forbidActivity;
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
        aVar = this.cxF.cxD;
        if (aVar != null) {
            aVar2 = this.cxF.cxD;
            if (!ax.isEmpty(aVar2.ajk())) {
                ForbidActivity forbidActivity = this.cxF;
                radioGroup = this.cxF.cxA;
                str = this.cxF.mForumId;
                str2 = this.cxF.mForumName;
                str3 = this.cxF.mThreadId;
                str4 = this.cxF.mUserName;
                str5 = this.cxF.mPostId;
                aVar3 = this.cxF.cxD;
                f.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), aVar3.ajk(), new b(this));
            }
        }
    }
}
