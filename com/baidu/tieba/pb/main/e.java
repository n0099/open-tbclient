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
        String str2;
        bl blVar;
        bl blVar2;
        if (view instanceof HeadImageView) {
            str2 = ((HeadImageView) view).getUserId();
            str = ((HeadImageView) view).getUserName();
        } else {
            str = "";
            str2 = (String) view.getTag();
        }
        if (str2 != null) {
            blVar = this.a.x;
            if (blVar != null) {
                MessageManager messageManager = MessageManager.getInstance();
                PbActivity pbActivity = this.a;
                blVar2 = this.a.x;
                messageManager.sendMessage(new CustomMessage(2002003, new com.baidu.tbadk.core.atomData.bg(pbActivity, str2, str, blVar2.f(), "pb_head")));
            }
        }
    }
}
