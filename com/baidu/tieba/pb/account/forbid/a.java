package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity edJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.edJ = forbidActivity;
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
        aVar = this.edJ.edH;
        if (aVar != null) {
            aVar2 = this.edJ.edH;
            if (!at.isEmpty(aVar2.aJC())) {
                ForbidActivity forbidActivity = this.edJ;
                radioGroup = this.edJ.edD;
                str = this.edJ.mForumId;
                str2 = this.edJ.mForumName;
                str3 = this.edJ.mThreadId;
                str4 = this.edJ.mUserName;
                str5 = this.edJ.mPostId;
                aVar3 = this.edJ.edH;
                f.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), aVar3.aJC(), new b(this));
            }
        }
    }
}
