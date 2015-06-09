package com.baidu.tieba.pb.chosen;

import android.content.res.Resources;
import android.net.Uri;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.p;
import com.baidu.tieba.t;
import java.text.MessageFormat;
/* loaded from: classes.dex */
public class h {
    private PbChosenActivity bJc;

    public h(PbChosenActivity pbChosenActivity) {
        this.bJc = pbChosenActivity;
    }

    public void a(com.baidu.tieba.pb.chosen.net.a aVar, String str) {
        if (aVar != null && aVar.getForumInfo() != null && aVar.getForumInfo().ftid != null) {
            String str2 = aVar.getForumInfo().fromfname;
            String str3 = aVar.getForumInfo().title;
            String str4 = aVar.getForumInfo()._abstract;
            Resources resources = this.bJc.getPageContext().getPageActivity().getResources();
            String format = MessageFormat.format(resources.getString(t.share_content_tpl), str3, str2, str4);
            String string = resources.getString(t.chosen_pb_share_content, str3);
            com.baidu.tbadk.coreExtra.share.g gVar = new com.baidu.tbadk.coreExtra.share.g();
            gVar.title = str3;
            gVar.content = format;
            gVar.linkUrl = "http://tieba.baidu.com/mo/q/recommendpb?ftid=" + aVar.getForumInfo().ftid;
            gVar.aeD = string;
            gVar.aeC = str4;
            gVar.aeB = Long.toString(aVar.getForumInfo().ftid.longValue());
            gVar.aeA = true;
            if (!StringUtils.isNull(str)) {
                gVar.imageUri = Uri.parse(str);
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.bJc.getPageContext().getPageActivity(), gVar, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(t.share_tieba_qunzu, p.icon_unite_share_qunzu, new i(this));
            shareDialogConfig.addOutsideTextView(t.forum_friend, p.icon_unite_share_baf, new j(this));
            shareDialogConfig.setCopyLinkListener(new k(this, gVar));
            this.bJc.sendMessage(new CustomMessage(2001283, shareDialogConfig));
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
            com.baidu.tieba.pb.chosen.a.l lVar = new com.baidu.tieba.pb.chosen.a.l(pbChosenActivity.getPageContext().getPageActivity());
            lVar.setTitle(aVar.getForumInfo().title);
            lVar.setDesc(aVar.getForumInfo()._abstract);
            lVar.v(str3, false);
            aVar2.l(lVar);
            aVar2.a(t.share, new l(aVar, pbChosenActivity, lVar, j, str, str2, str3));
            aVar2.b(t.alert_no_button, new m(pbChosenActivity, lVar));
            aVar2.ah(false);
            aVar2.b(pbChosenActivity.getPageContext()).rL();
        }
    }

    public static void a(PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.net.a aVar, int i, String str, int i2, String str2) {
        if (aVar != null && aVar.getForumInfo() != null) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(pbChosenActivity.getPageContext().getPageActivity());
            com.baidu.tieba.pb.chosen.a.l lVar = new com.baidu.tieba.pb.chosen.a.l(pbChosenActivity.getPageContext().getPageActivity());
            lVar.v(str2, false);
            lVar.setTitle(aVar.getForumInfo().title);
            lVar.setDesc(aVar.getForumInfo()._abstract);
            aVar2.l(lVar);
            aVar2.a(t.share, new n(aVar, pbChosenActivity, lVar, i, str, i2, str2));
            aVar2.b(t.alert_no_button, new o(pbChosenActivity, lVar));
            aVar2.ah(false);
            aVar2.b(pbChosenActivity.getPageContext()).rL();
        }
    }
}
