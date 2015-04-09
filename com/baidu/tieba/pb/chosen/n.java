package com.baidu.tieba.pb.chosen;

import android.content.res.Resources;
import android.net.Uri;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.u;
import com.baidu.tieba.y;
import java.text.MessageFormat;
/* loaded from: classes.dex */
public class n {
    private PbChosenActivity bGp;

    public n(PbChosenActivity pbChosenActivity) {
        this.bGp = pbChosenActivity;
    }

    public void a(com.baidu.tieba.pb.chosen.net.a aVar, String str) {
        if (aVar != null && aVar.getForumInfo() != null) {
            String str2 = aVar.getForumInfo().fromfname;
            String str3 = aVar.getForumInfo().title;
            String str4 = "http://tieba.baidu.com/mo/q/recommendpb?ftid=" + aVar.getForumInfo().ftid;
            String[] b = b(aVar, str);
            String str5 = b[0];
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = b[1];
            Resources resources = this.bGp.getPageContext().getPageActivity().getResources();
            String format = MessageFormat.format(resources.getString(y.share_content_tpl), str3, str2, str6);
            String string = resources.getString(y.chosen_pb_share_content, str3);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = str3;
            fVar.content = format;
            fVar.adu = str4;
            fVar.ady = string;
            fVar.adx = str6;
            fVar.adt = true;
            if (parse != null) {
                fVar.adv = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.bGp.getPageContext().getPageActivity(), fVar, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(y.share_tieba_qunzu, u.icon_unite_share_qunzu, new o(this));
            shareDialogConfig.addOutsideTextView(y.forum_friend, u.icon_unite_share_baf, new p(this));
            shareDialogConfig.setCopyLinkListener(new q(this, fVar));
            this.bGp.sendMessage(new CustomMessage(2001283, shareDialogConfig));
        }
    }

    private static String[] b(com.baidu.tieba.pb.chosen.net.a aVar, String str) {
        return new String[]{str, aVar.getForumInfo()._abstract};
    }

    public static ShareFromPBMsgData a(com.baidu.tieba.pb.chosen.net.a aVar, long j, String str) {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] b = b(aVar, str);
        shareFromPBMsgData.setContent(b[1]);
        shareFromPBMsgData.setImageUrl(b[0]);
        shareFromPBMsgData.setForumName(aVar.getForumInfo().fromfname);
        shareFromPBMsgData.setPostId(null);
        shareFromPBMsgData.setThreadId(aVar.getForumInfo().originalurl);
        shareFromPBMsgData.setTheNewThemeId(String.valueOf(j));
        shareFromPBMsgData.setTitle(aVar.getForumInfo().title);
        return shareFromPBMsgData;
    }
}
