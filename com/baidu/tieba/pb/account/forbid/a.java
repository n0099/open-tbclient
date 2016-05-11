package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity ddx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.ddx = forbidActivity;
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
        aVar = this.ddx.ddv;
        if (aVar != null) {
            aVar2 = this.ddx.ddv;
            if (!ay.isEmpty(aVar2.avi())) {
                ForbidActivity forbidActivity = this.ddx;
                radioGroup = this.ddx.ddq;
                str = this.ddx.mForumId;
                str2 = this.ddx.mForumName;
                str3 = this.ddx.mThreadId;
                str4 = this.ddx.mUserName;
                str5 = this.ddx.mPostId;
                aVar3 = this.ddx.ddv;
                f.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), aVar3.avi(), new b(this));
            }
        }
    }
}
