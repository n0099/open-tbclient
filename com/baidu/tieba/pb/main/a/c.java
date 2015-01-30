package com.baidu.tieba.pb.main.a;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tieba.pb.main.PbActivity;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bET;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bET = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        pbActivity = this.bET.bCG;
        Activity pageActivity = pbActivity.getPageContext().getPageActivity();
        pbActivity2 = this.bET.bCG;
        String string = pbActivity2.getPageContext().getString(z.user_icon_intro);
        str = a.bEO;
        messageManager.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(pageActivity, string, String.valueOf(str) + "?st_type=pb_user_icon", true, true, false, false, false)));
    }
}
