package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.bb;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity bIF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.bIF = forbidActivity;
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
        eVar = this.bIF.bID;
        if (eVar != null) {
            eVar2 = this.bIF.bID;
            if (!bb.isEmpty(eVar2.aaj())) {
                ForbidActivity forbidActivity = this.bIF;
                radioGroup = this.bIF.bIA;
                str = this.bIF.mForumId;
                str2 = this.bIF.mForumName;
                str3 = this.bIF.mThreadId;
                str4 = this.bIF.aec;
                str5 = this.bIF.mPostId;
                eVar3 = this.bIF.bID;
                h.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), eVar3.aaj(), new b(this));
            }
        }
    }
}
