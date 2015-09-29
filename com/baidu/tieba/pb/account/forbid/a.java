package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity cet;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.cet = forbidActivity;
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
        aVar = this.cet.cer;
        if (aVar != null) {
            aVar2 = this.cet.cer;
            if (!ar.isEmpty(aVar2.aeB())) {
                ForbidActivity forbidActivity = this.cet;
                radioGroup = this.cet.ceo;
                str = this.cet.mForumId;
                str2 = this.cet.mForumName;
                str3 = this.cet.mThreadId;
                str4 = this.cet.aiq;
                str5 = this.cet.mPostId;
                aVar3 = this.cet.cer;
                f.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), aVar3.aeB(), new b(this));
            }
        }
    }
}
