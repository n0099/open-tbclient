package com.baidu.tieba.pb.pb.main.a;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a eqB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.eqB = aVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        String str3;
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        PbActivity pbActivity4;
        PbActivity pbActivity5;
        if (view instanceof HeadImageView) {
            String userId = ((HeadImageView) view).getUserId();
            str2 = ((HeadImageView) view).getUserName();
            str3 = userId;
        } else {
            if (view.getTag(r.h.tag_user_id) instanceof String) {
                str = (String) view.getTag(r.h.tag_user_id);
            } else {
                str = view.getTag() instanceof String ? (String) view.getTag() : null;
            }
            if (view.getTag(r.h.tag_user_name) instanceof String) {
                str2 = (String) view.getTag(r.h.tag_user_name);
                str3 = str;
            } else {
                str2 = null;
                str3 = str;
            }
        }
        String str4 = view.getTag(r.h.tag_virtual_user_url) instanceof String ? (String) view.getTag(r.h.tag_virtual_user_url) : null;
        if (str4 != null) {
            pbActivity4 = this.eqB.ehi;
            if (pbActivity4.checkUpIsLogin()) {
                ba vt = ba.vt();
                pbActivity5 = this.eqB.ehi;
                vt.c(pbActivity5.getPageContext(), new String[]{str4});
            }
        } else if (str3 != null) {
            pbActivity = this.eqB.ehi;
            if (pbActivity.aKP() != null) {
                MessageManager messageManager = MessageManager.getInstance();
                pbActivity2 = this.eqB.ehi;
                Activity pageActivity = pbActivity2.getPageContext().getPageActivity();
                pbActivity3 = this.eqB.ehi;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, str3, str2, pbActivity3.aKP().aLX(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    }
}
