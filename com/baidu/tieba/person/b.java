package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ BasePersonInfoActivity bES;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BasePersonInfoActivity basePersonInfoActivity) {
        this.bES = basePersonInfoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        z = this.bES.bEP;
        if (z) {
            MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(false));
            com.baidu.tbadk.core.b.b.a(this.bES.getPageContext().getPageActivity(), Constants.MEDIA_INFO, false);
        }
        this.bES.finish();
    }
}
