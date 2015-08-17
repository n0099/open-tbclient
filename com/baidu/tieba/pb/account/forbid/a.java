package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity bYr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.bYr = forbidActivity;
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
        aVar = this.bYr.bYp;
        if (aVar != null) {
            aVar2 = this.bYr.bYp;
            if (!aq.isEmpty(aVar2.acv())) {
                ForbidActivity forbidActivity = this.bYr;
                radioGroup = this.bYr.bYm;
                str = this.bYr.mForumId;
                str2 = this.bYr.mForumName;
                str3 = this.bYr.mThreadId;
                str4 = this.bYr.ajl;
                str5 = this.bYr.mPostId;
                aVar3 = this.bYr.bYp;
                f.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), aVar3.acv(), new b(this));
            }
        }
    }
}
