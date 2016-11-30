package com.baidu.tieba.pb.pb.main.a;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a eDm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.eDm = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        String str3;
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        if (view instanceof HeadImageView) {
            String userId = ((HeadImageView) view).getUserId();
            str2 = ((HeadImageView) view).getUserName();
            str3 = userId;
        } else {
            if (view.getTag(r.g.tag_user_id) instanceof String) {
                str = (String) view.getTag(r.g.tag_user_id);
            } else {
                str = view.getTag() instanceof String ? (String) view.getTag() : null;
            }
            if (view.getTag(r.g.tag_user_name) instanceof String) {
                str2 = (String) view.getTag(r.g.tag_user_name);
                str3 = str;
            } else {
                str2 = null;
                str3 = str;
            }
        }
        if (str3 != null) {
            pbActivity = this.eDm.eug;
            if (pbActivity.aPd() != null) {
                MessageManager messageManager = MessageManager.getInstance();
                pbActivity2 = this.eDm.eug;
                Activity pageActivity = pbActivity2.getPageContext().getPageActivity();
                pbActivity3 = this.eDm.eug;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, str3, str2, pbActivity3.aPd().aQo(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    }
}
