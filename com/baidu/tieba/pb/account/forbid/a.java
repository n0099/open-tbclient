package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity ceE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.ceE = forbidActivity;
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
        aVar = this.ceE.ceC;
        if (aVar != null) {
            aVar2 = this.ceE.ceC;
            if (!as.isEmpty(aVar2.aeB())) {
                ForbidActivity forbidActivity = this.ceE;
                radioGroup = this.ceE.cez;
                str = this.ceE.mForumId;
                str2 = this.ceE.mForumName;
                str3 = this.ceE.mThreadId;
                str4 = this.ceE.air;
                str5 = this.ceE.mPostId;
                aVar3 = this.ceE.ceC;
                f.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), aVar3.aeB(), new b(this));
            }
        }
    }
}
