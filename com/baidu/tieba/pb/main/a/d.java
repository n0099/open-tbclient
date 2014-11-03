package com.baidu.tieba.pb.main.a;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tieba.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bzm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bzm = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        pbActivity = this.bzm.bxe;
        pbActivity2 = this.bzm.bxe;
        pbActivity.sendMessage(new CustomMessage(2002001, new MemberPrivilegeActivityConfig(pbActivity2)));
    }
}
