package com.baidu.tieba.pb.chosen;

import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.chosen.view.ShareThreadView;
import java.text.MessageFormat;
/* loaded from: classes3.dex */
public class a {
    private PbChosenActivity faU;

    public a(PbChosenActivity pbChosenActivity) {
        this.faU = pbChosenActivity;
    }

    public void a(com.baidu.tieba.pb.chosen.net.a aVar, String str) {
        if (aVar != null && aVar.getThreadInfo() != null && aVar.getThreadInfo().excid != null) {
            String str2 = aVar.getThreadInfo().forum.forum_name;
            String str3 = aVar.getThreadInfo().title;
            String str4 = aVar.getThreadInfo()._abstract;
            Resources resources = this.faU.getPageContext().getPageActivity().getResources();
            String format = MessageFormat.format(resources.getString(d.k.share_content_tpl), str3, str4);
            String string = resources.getString(d.k.chosen_pb_share_content, str3);
            final com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str3;
            dVar.content = format;
            dVar.linkUrl = "http://tieba.baidu.com/mo/q/recommendpb?ftid=" + aVar.getThreadInfo().excid;
            dVar.awZ = string;
            dVar.awY = str4;
            dVar.awX = Long.toString(aVar.getThreadInfo().excid.longValue());
            dVar.tid = Long.toString(aVar.getThreadInfo().thread_id.longValue());
            dVar.awL = true;
            if (!StringUtils.isNull(str)) {
                dVar.awV = Uri.parse(str);
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.faU.getPageContext().getPageActivity(), dVar, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(d.k.forum_friend, d.f.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.faU.sendMessage(new CustomMessage(2001277));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectFriendActivityConfig(a.this.faU.getPageContext().getPageActivity(), 23007)));
                    TiebaStatic.eventStat(a.this.faU.getPageContext().getPageActivity(), "pb_new_share", "loc", 0, new Object[0]);
                }
            });
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    dVar.linkUrl = e.aj(dVar.linkUrl, dVar.tid);
                    com.baidu.adp.lib.util.a.aB(dVar.linkUrl);
                    l.showToast(a.this.faU.getPageContext().getPageActivity(), view2.getResources().getString(d.k.copy_pb_url_success));
                }
            });
            this.faU.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

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
        shareFromPBMsgData.setThreadId(aVar.getThreadInfo().thread_id + "");
        shareFromPBMsgData.setTheNewThemeId(String.valueOf(j));
        shareFromPBMsgData.setTitle(aVar.getThreadInfo().title);
        return shareFromPBMsgData;
    }

    public static void a(final PbChosenActivity pbChosenActivity, final com.baidu.tieba.pb.chosen.net.a aVar, final long j, final String str, final String str2, final String str3) {
        if (aVar != null && aVar.getThreadInfo() != null) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(pbChosenActivity.getPageContext().getPageActivity());
            final ShareThreadView shareThreadView = new ShareThreadView(pbChosenActivity.getPageContext().getPageActivity());
            shareThreadView.setTitle(aVar.getThreadInfo().title);
            shareThreadView.setDesc(aVar.getThreadInfo()._abstract);
            shareThreadView.D(str3, false);
            aVar2.w(shareThreadView);
            aVar2.a(d.k.share, new a.b() { // from class: com.baidu.tieba.pb.chosen.a.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                    if (com.baidu.tieba.pb.chosen.net.a.this != null && com.baidu.tieba.pb.chosen.net.a.this.getThreadInfo() != null) {
                        l.b(pbChosenActivity.getPageContext().getPageActivity(), shareThreadView.getChatMsgView());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(pbChosenActivity.getPageContext().getPageActivity(), j, str, str2, 0, shareThreadView.getLeaveMsg(), a.a(com.baidu.tieba.pb.chosen.net.a.this, com.baidu.tieba.pb.chosen.net.a.this.getThreadInfo().excid.longValue(), str3).toChatMessageContent())));
                        aVar3.dismiss();
                    }
                }
            });
            aVar2.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.chosen.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                    l.b(PbChosenActivity.this.getPageContext().getPageActivity(), shareThreadView.getChatMsgView());
                    aVar3.dismiss();
                }
            });
            aVar2.as(false);
            aVar2.b(pbChosenActivity.getPageContext()).tD();
        }
    }

    public static void a(final PbChosenActivity pbChosenActivity, final com.baidu.tieba.pb.chosen.net.a aVar, final long j, final String str, final long j2, final String str2) {
        if (aVar != null && aVar.getThreadInfo() != null) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(pbChosenActivity.getPageContext().getPageActivity());
            final ShareThreadView shareThreadView = new ShareThreadView(pbChosenActivity.getPageContext().getPageActivity());
            shareThreadView.D(str2, false);
            shareThreadView.setTitle(aVar.getThreadInfo().title);
            shareThreadView.setDesc(aVar.getThreadInfo()._abstract);
            aVar2.w(shareThreadView);
            aVar2.a(d.k.share, new a.b() { // from class: com.baidu.tieba.pb.chosen.a.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                    if (com.baidu.tieba.pb.chosen.net.a.this != null && com.baidu.tieba.pb.chosen.net.a.this.getThreadInfo() != null) {
                        l.b(pbChosenActivity.getPageContext().getPageActivity(), shareThreadView.getChatMsgView());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(pbChosenActivity.getPageContext().getPageActivity(), j, str, j2, "from_share", shareThreadView.getLeaveMsg(), a.a(com.baidu.tieba.pb.chosen.net.a.this, com.baidu.tieba.pb.chosen.net.a.this.getThreadInfo().excid.longValue(), str2).toChatMessageContent())));
                        aVar3.dismiss();
                    }
                }
            });
            aVar2.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.chosen.a.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                    l.b(PbChosenActivity.this.getPageContext().getPageActivity(), shareThreadView.getChatMsgView());
                    aVar3.dismiss();
                }
            });
            aVar2.as(false);
            aVar2.b(pbChosenActivity.getPageContext()).tD();
        }
    }
}
