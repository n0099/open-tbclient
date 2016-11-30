package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity eqj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.eqj = forbidActivity;
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
        aVar = this.eqj.eqh;
        if (aVar != null) {
            aVar2 = this.eqj.eqh;
            if (!ax.isEmpty(aVar2.aNN())) {
                ForbidActivity forbidActivity = this.eqj;
                radioGroup = this.eqj.eqd;
                str = this.eqj.mForumId;
                str2 = this.eqj.mForumName;
                str3 = this.eqj.mThreadId;
                str4 = this.eqj.mUserName;
                str5 = this.eqj.mPostId;
                aVar3 = this.eqj.eqh;
                f.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), aVar3.aNN(), new b(this));
            }
        }
    }
}
