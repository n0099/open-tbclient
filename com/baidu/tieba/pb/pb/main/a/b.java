package com.baidu.tieba.pb.pb.main.a;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a eFZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.eFZ = aVar;
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
        PbActivity pbActivity6;
        PbActivity pbActivity7;
        if (view instanceof HeadImageView) {
            String userId = ((HeadImageView) view).getUserId();
            str2 = ((HeadImageView) view).getUserName();
            str3 = userId;
        } else {
            if (view.getTag(w.h.tag_user_id) instanceof String) {
                str = (String) view.getTag(w.h.tag_user_id);
            } else {
                str = view.getTag() instanceof String ? (String) view.getTag() : null;
            }
            if (view.getTag(w.h.tag_user_name) instanceof String) {
                str2 = (String) view.getTag(w.h.tag_user_name);
                str3 = str;
            } else {
                str2 = null;
                str3 = str;
            }
        }
        if (view.getTag(w.h.tag_nick_name_activity) != null && (view.getTag(w.h.tag_nick_name_activity) instanceof String)) {
            String str4 = (String) view.getTag(w.h.tag_nick_name_activity);
            if (!TextUtils.isEmpty(str4)) {
                pbActivity6 = this.eFZ.euf;
                if (pbActivity6.checkUpIsLogin()) {
                    MessageManager messageManager = MessageManager.getInstance();
                    pbActivity7 = this.eFZ.euf;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(pbActivity7.getPageContext().getPageActivity(), null, str4, true)));
                    return;
                }
            }
        }
        String str5 = view.getTag(w.h.tag_virtual_user_url) instanceof String ? (String) view.getTag(w.h.tag_virtual_user_url) : null;
        if (str5 != null) {
            pbActivity4 = this.eFZ.euf;
            if (pbActivity4.checkUpIsLogin()) {
                be vP = be.vP();
                pbActivity5 = this.eFZ.euf;
                vP.c(pbActivity5.getPageContext(), new String[]{str5});
            }
        } else if (str3 != null) {
            pbActivity = this.eFZ.euf;
            if (pbActivity.aNz() != null) {
                MessageManager messageManager2 = MessageManager.getInstance();
                pbActivity2 = this.eFZ.euf;
                Activity pageActivity = pbActivity2.getPageContext().getPageActivity();
                pbActivity3 = this.eFZ.euf;
                messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, str3, str2, pbActivity3.aNz().aOJ(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    }
}
