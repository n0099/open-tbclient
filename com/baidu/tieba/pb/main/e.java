package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        bm bmVar;
        bm bmVar2;
        if (view instanceof HeadImageView) {
            str = ((HeadImageView) view).getUserId();
        } else {
            str = (String) view.getTag();
        }
        if (str != null) {
            bmVar = this.a.x;
            if (bmVar != null) {
                MessageManager messageManager = MessageManager.getInstance();
                PbActivity pbActivity = this.a;
                bmVar2 = this.a.x;
                messageManager.sendMessage(new CustomMessage(2002003, new com.baidu.tbadk.core.atomData.bb(pbActivity, str, null, bmVar2.f())));
            }
        }
    }
}
