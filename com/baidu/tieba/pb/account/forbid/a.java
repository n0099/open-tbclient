package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.bd;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity bFJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.bFJ = forbidActivity;
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
        eVar = this.bFJ.bFH;
        if (eVar != null) {
            eVar2 = this.bFJ.bFH;
            if (!bd.isEmpty(eVar2.YI())) {
                ForbidActivity forbidActivity = this.bFJ;
                radioGroup = this.bFJ.bFE;
                str = this.bFJ.mForumId;
                str2 = this.bFJ.mForumName;
                str3 = this.bFJ.mThreadId;
                str4 = this.bFJ.acU;
                str5 = this.bFJ.mPostId;
                eVar3 = this.bFJ.bFH;
                h.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), eVar3.YI(), new b(this));
            }
        }
    }
}
