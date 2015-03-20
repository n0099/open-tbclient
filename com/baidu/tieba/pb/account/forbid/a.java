package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.bd;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity bFw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.bFw = forbidActivity;
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
        eVar = this.bFw.bFu;
        if (eVar != null) {
            eVar2 = this.bFw.bFu;
            if (!bd.isEmpty(eVar2.Yw())) {
                ForbidActivity forbidActivity = this.bFw;
                radioGroup = this.bFw.bFr;
                str = this.bFw.mForumId;
                str2 = this.bFw.mForumName;
                str3 = this.bFw.mThreadId;
                str4 = this.bFw.acM;
                str5 = this.bFw.mPostId;
                eVar3 = this.bFw.bFu;
                h.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), eVar3.Yw(), new b(this));
            }
        }
    }
}
