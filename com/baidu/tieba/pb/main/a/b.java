package com.baidu.tieba.pb.main.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bzm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bzm = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        if (view instanceof HeadImageView) {
            str2 = ((HeadImageView) view).getUserId();
            str = ((HeadImageView) view).getUserName();
        } else {
            str = "";
            str2 = (String) view.getTag();
        }
        if (str2 != null) {
            pbActivity = this.bzm.bxe;
            if (pbActivity.We() != null) {
                MessageManager messageManager = MessageManager.getInstance();
                pbActivity2 = this.bzm.bxe;
                pbActivity3 = this.bzm.bxe;
                messageManager.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(pbActivity2, str2, str, pbActivity3.We().WH(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    }
}
