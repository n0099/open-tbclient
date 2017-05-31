package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity egH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.egH = forbidActivity;
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
        aVar = this.egH.egF;
        if (aVar != null) {
            aVar2 = this.egH.egF;
            if (!au.isEmpty(aVar2.aId())) {
                ForbidActivity forbidActivity = this.egH;
                radioGroup = this.egH.egB;
                str = this.egH.mForumId;
                str2 = this.egH.mForumName;
                str3 = this.egH.mThreadId;
                str4 = this.egH.mUserName;
                str5 = this.egH.mPostId;
                aVar3 = this.egH.egF;
                f.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), aVar3.aId(), new b(this));
            }
        }
    }
}
