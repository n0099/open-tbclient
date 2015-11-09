package com.baidu.tieba.pb.chosen;

import android.content.res.Resources;
import android.net.Uri;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.i;
import java.text.MessageFormat;
/* loaded from: classes.dex */
public class s {
    private PbChosenActivity cfO;

    public s(PbChosenActivity pbChosenActivity) {
        this.cfO = pbChosenActivity;
    }

    public void a(com.baidu.tieba.pb.chosen.net.a aVar, String str) {
        if (aVar != null && aVar.getForumInfo() != null && aVar.getForumInfo().ftid != null) {
            String str2 = aVar.getForumInfo().fromfname;
            String str3 = aVar.getForumInfo().title;
            String str4 = aVar.getForumInfo()._abstract;
            Resources resources = this.cfO.getPageContext().getPageActivity().getResources();
            String format = MessageFormat.format(resources.getString(i.h.share_content_tpl), str3, str2, str4);
            String string = resources.getString(i.h.chosen_pb_share_content, str3);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = str3;
            fVar.content = format;
            fVar.linkUrl = "http://tieba.baidu.com/mo/q/recommendpb?ftid=" + aVar.getForumInfo().ftid;
            fVar.aiX = string;
            fVar.aiW = str4;
            fVar.aiV = Long.toString(aVar.getForumInfo().ftid.longValue());
            fVar.aiS = true;
            if (!StringUtils.isNull(str)) {
                fVar.imageUri = Uri.parse(str);
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.cfO.getPageContext().getPageActivity(), fVar, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(i.h.share_tieba_qunzu, i.e.icon_unite_share_qunzu, new t(this));
            shareDialogConfig.addOutsideTextView(i.h.forum_friend, i.e.icon_unite_share_baf, new u(this));
            shareDialogConfig.setCopyLinkListener(new v(this, fVar));
            this.cfO.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ShareFromPBMsgData a(com.baidu.tieba.pb.chosen.net.a aVar, long j, String str) {
        if (aVar == null || aVar.getForumInfo() == null) {
            return null;
        }
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setContent(aVar.getForumInfo()._abstract);
        shareFromPBMsgData.setImageUrl(str);
        shareFromPBMsgData.setForumName(aVar.getForumInfo().fromfname);
        shareFromPBMsgData.setPostId(null);
        shareFromPBMsgData.setThreadId(aVar.getForumInfo().originalurl);
        shareFromPBMsgData.setTheNewThemeId(String.valueOf(j));
        shareFromPBMsgData.setTitle(aVar.getForumInfo().title);
        return shareFromPBMsgData;
    }

    public static void a(PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.net.a aVar, long j, String str, String str2, String str3) {
        if (aVar != null && aVar.getForumInfo() != null) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(pbChosenActivity.getPageContext().getPageActivity());
            com.baidu.tieba.pb.chosen.a.n nVar = new com.baidu.tieba.pb.chosen.a.n(pbChosenActivity.getPageContext().getPageActivity());
            nVar.setTitle(aVar.getForumInfo().title);
            nVar.setDesc(aVar.getForumInfo()._abstract);
            nVar.w(str3, false);
            aVar2.m(nVar);
            aVar2.a(i.h.share, new w(aVar, pbChosenActivity, nVar, j, str, str2, str3));
            aVar2.b(i.h.alert_no_button, new x(pbChosenActivity, nVar));
            aVar2.ak(false);
            aVar2.b(pbChosenActivity.getPageContext()).sR();
        }
    }

    public static void a(PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.net.a aVar, int i, String str, long j, String str2) {
        if (aVar != null && aVar.getForumInfo() != null) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(pbChosenActivity.getPageContext().getPageActivity());
            com.baidu.tieba.pb.chosen.a.n nVar = new com.baidu.tieba.pb.chosen.a.n(pbChosenActivity.getPageContext().getPageActivity());
            nVar.w(str2, false);
            nVar.setTitle(aVar.getForumInfo().title);
            nVar.setDesc(aVar.getForumInfo()._abstract);
            aVar2.m(nVar);
            aVar2.a(i.h.share, new y(aVar, pbChosenActivity, nVar, i, str, j, str2));
            aVar2.b(i.h.alert_no_button, new z(pbChosenActivity, nVar));
            aVar2.ak(false);
            aVar2.b(pbChosenActivity.getPageContext()).sR();
        }
    }
}
