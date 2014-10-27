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
    final /* synthetic */ a byY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.byY = aVar;
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
            pbActivity = this.byY.bwQ;
            if (pbActivity.Wb() != null) {
                MessageManager messageManager = MessageManager.getInstance();
                pbActivity2 = this.byY.bwQ;
                pbActivity3 = this.byY.bwQ;
                messageManager.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(pbActivity2, str2, str, pbActivity3.Wb().WE(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    }
}
