package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity ein;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.ein = forbidActivity;
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
        aVar = this.ein.eil;
        if (aVar != null) {
            aVar2 = this.ein.eil;
            if (!ba.isEmpty(aVar2.aLs())) {
                ForbidActivity forbidActivity = this.ein;
                radioGroup = this.ein.eih;
                str = this.ein.mForumId;
                str2 = this.ein.mForumName;
                str3 = this.ein.mThreadId;
                str4 = this.ein.mUserName;
                str5 = this.ein.mPostId;
                aVar3 = this.ein.eil;
                f.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), aVar3.aLs(), new b(this));
            }
        }
    }
}
