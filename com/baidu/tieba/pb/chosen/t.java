package com.baidu.tieba.pb.chosen;

import android.content.res.Resources;
import android.net.Uri;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.t;
import java.text.MessageFormat;
/* loaded from: classes.dex */
public class t {
    private PbChosenActivity cIC;

    public t(PbChosenActivity pbChosenActivity) {
        this.cIC = pbChosenActivity;
    }

    public void a(com.baidu.tieba.pb.chosen.net.a aVar, String str) {
        if (aVar != null && aVar.getThreadInfo() != null && aVar.getThreadInfo().excid != null) {
            String str2 = aVar.getThreadInfo().forum.forum_name;
            String str3 = aVar.getThreadInfo().title;
            String str4 = aVar.getThreadInfo()._abstract;
            Resources resources = this.cIC.getPageContext().getPageActivity().getResources();
            String format = MessageFormat.format(resources.getString(t.j.share_content_tpl), str3, str2, str4);
            String string = resources.getString(t.j.chosen_pb_share_content, str3);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = str3;
            fVar.content = format;
            fVar.linkUrl = "http://tieba.baidu.com/mo/q/recommendpb?ftid=" + aVar.getThreadInfo().excid;
            fVar.amK = string;
            fVar.amJ = str4;
            fVar.amI = Long.toString(aVar.getThreadInfo().excid.longValue());
            fVar.amE = true;
            if (!StringUtils.isNull(str)) {
                fVar.imageUri = Uri.parse(str);
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.cIC.getPageContext().getPageActivity(), fVar, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(t.j.share_tieba_qunzu, t.f.icon_unite_share_qunzu, new u(this));
            shareDialogConfig.addOutsideTextView(t.j.forum_friend, t.f.icon_unite_share_baf, new v(this));
            shareDialogConfig.setCopyLinkListener(new w(this, fVar));
            this.cIC.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0033: IGET  (r2v6 java.lang.Long A[REMOVE]) = 
      (wrap: tbclient.ExcPbPage.ExcellentPbThreadInfo : 0x002f: INVOKE  (r2v5 tbclient.ExcPbPage.ExcellentPbThreadInfo A[REMOVE]) = (r3v0 com.baidu.tieba.pb.chosen.net.a) type: INTERFACE call: com.baidu.tieba.pb.chosen.net.a.getThreadInfo():tbclient.ExcPbPage.ExcellentPbThreadInfo)
     tbclient.ExcPbPage.ExcellentPbThreadInfo.thread_id java.lang.Long)] */
    /* JADX INFO: Access modifiers changed from: private */
    public static ShareFromPBMsgData a(com.baidu.tieba.pb.chosen.net.a aVar, long j, String str) {
        if (aVar == null || aVar.getThreadInfo() == null) {
            return null;
        }
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setContent(aVar.getThreadInfo()._abstract);
        shareFromPBMsgData.setImageUrl(str);
        shareFromPBMsgData.setForumName(aVar.getThreadInfo().forum.forum_name);
        shareFromPBMsgData.setPostId(null);
        shareFromPBMsgData.setThreadId(new StringBuilder().append(aVar.getThreadInfo().thread_id).toString());
        shareFromPBMsgData.setTheNewThemeId(String.valueOf(j));
        shareFromPBMsgData.setTitle(aVar.getThreadInfo().title);
        return shareFromPBMsgData;
    }

    public static void a(PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.net.a aVar, long j, String str, String str2, String str3) {
        if (aVar != null && aVar.getThreadInfo() != null) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(pbChosenActivity.getPageContext().getPageActivity());
            com.baidu.tieba.pb.chosen.a.m mVar = new com.baidu.tieba.pb.chosen.a.m(pbChosenActivity.getPageContext().getPageActivity());
            mVar.setTitle(aVar.getThreadInfo().title);
            mVar.setDesc(aVar.getThreadInfo()._abstract);
            mVar.x(str3, false);
            aVar2.z(mVar);
            aVar2.a(t.j.share, new x(aVar, pbChosenActivity, mVar, j, str, str2, str3));
            aVar2.b(t.j.alert_no_button, new y(pbChosenActivity, mVar));
            aVar2.ak(false);
            aVar2.b(pbChosenActivity.getPageContext()).uj();
        }
    }

    public static void a(PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.net.a aVar, int i, String str, long j, String str2) {
        if (aVar != null && aVar.getThreadInfo() != null) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(pbChosenActivity.getPageContext().getPageActivity());
            com.baidu.tieba.pb.chosen.a.m mVar = new com.baidu.tieba.pb.chosen.a.m(pbChosenActivity.getPageContext().getPageActivity());
            mVar.x(str2, false);
            mVar.setTitle(aVar.getThreadInfo().title);
            mVar.setDesc(aVar.getThreadInfo()._abstract);
            aVar2.z(mVar);
            aVar2.a(t.j.share, new z(aVar, pbChosenActivity, mVar, i, str, j, str2));
            aVar2.b(t.j.alert_no_button, new aa(pbChosenActivity, mVar));
            aVar2.ak(false);
            aVar2.b(pbChosenActivity.getPageContext()).uj();
        }
    }
}
