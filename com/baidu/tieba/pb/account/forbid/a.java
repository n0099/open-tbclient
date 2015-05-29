package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.bb;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity bIE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.bIE = forbidActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e eVar;
        e eVar2;
        RadioGroup radioGroup;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        e eVar3;
        eVar = this.bIE.bIC;
        if (eVar != null) {
            eVar2 = this.bIE.bIC;
            if (!bb.isEmpty(eVar2.aai())) {
                ForbidActivity forbidActivity = this.bIE;
                radioGroup = this.bIE.bIz;
                str = this.bIE.mForumId;
                str2 = this.bIE.mForumName;
                str3 = this.bIE.mThreadId;
                str4 = this.bIE.aec;
                str5 = this.bIE.mPostId;
                eVar3 = this.bIE.bIC;
                h.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), eVar3.aai(), new b(this));
            }
        }
    }
}
