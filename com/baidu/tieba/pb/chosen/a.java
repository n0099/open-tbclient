package com.baidu.tieba.pb.chosen;

import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.chosen.view.ShareThreadView;
import java.text.MessageFormat;
/* loaded from: classes7.dex */
public class a {
    private PbChosenActivity lAi;

    public a(PbChosenActivity pbChosenActivity) {
        this.lAi = pbChosenActivity;
    }

    public void a(com.baidu.tieba.pb.chosen.net.a aVar, String str) {
        if (aVar != null && aVar.getThreadInfo() != null && aVar.getThreadInfo().excid != null) {
            String str2 = aVar.getThreadInfo().forum.forum_name;
            String str3 = aVar.getThreadInfo().title;
            String str4 = aVar.getThreadInfo()._abstract;
            Resources resources = this.lAi.getPageContext().getPageActivity().getResources();
            String format = MessageFormat.format(resources.getString(R.string.share_content_tpl), str3, str4);
            String string = resources.getString(R.string.chosen_pb_share_content, str3);
            final ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            shareItem.linkUrl = "http://tieba.baidu.com/mo/q/recommendpb?ftid=" + aVar.getThreadInfo().excid;
            shareItem.fsE = string;
            shareItem.fsD = str4;
            shareItem.fsC = Long.toString(aVar.getThreadInfo().excid.longValue());
            shareItem.tid = Long.toString(aVar.getThreadInfo().thread_id.longValue());
            shareItem.fsn = true;
            if (!StringUtils.isNull(str)) {
                shareItem.imageUri = Uri.parse(str);
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.lAi.getPageContext().getPageActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(R.string.forum_friend, R.drawable.icon_share_friends_n, new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.lAi.sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(a.this.lAi.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM)));
                    TiebaStatic.eventStat(a.this.lAi.getPageContext().getPageActivity(), "pb_new_share", "loc", 0, new Object[0]);
                }
            });
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    shareItem.linkUrl = g.ea(shareItem.linkUrl, shareItem.tid);
                    com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                    l.showToast(a.this.lAi.getPageContext().getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
                }
            });
            this.lAi.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
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

    public static void a(final PbChosenActivity pbChosenActivity, final com.baidu.tieba.pb.chosen.net.a aVar, final long j, final String str, final String str2, final String str3, final String str4) {
        if (aVar != null && aVar.getThreadInfo() != null) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(pbChosenActivity.getPageContext().getPageActivity());
            final ShareThreadView shareThreadView = new ShareThreadView(pbChosenActivity.getPageContext().getPageActivity());
            shareThreadView.setTitle(aVar.getThreadInfo().title);
            shareThreadView.setDesc(aVar.getThreadInfo()._abstract);
            shareThreadView.aQ(str4, false);
            aVar2.br(shareThreadView);
            aVar2.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.chosen.a.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                    if (com.baidu.tieba.pb.chosen.net.a.this != null && com.baidu.tieba.pb.chosen.net.a.this.getThreadInfo() != null) {
                        l.hideSoftKeyPad(pbChosenActivity.getPageContext().getPageActivity(), shareThreadView.getChatMsgView());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(pbChosenActivity.getPageContext().getPageActivity(), j, str, str2, str3, 0, shareThreadView.getLeaveMsg(), a.a(com.baidu.tieba.pb.chosen.net.a.this, com.baidu.tieba.pb.chosen.net.a.this.getThreadInfo().excid.longValue(), str4).toChatMessageContent())));
                        aVar3.dismiss();
                    }
                }
            });
            aVar2.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.chosen.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                    l.hideSoftKeyPad(PbChosenActivity.this.getPageContext().getPageActivity(), shareThreadView.getChatMsgView());
                    aVar3.dismiss();
                }
            });
            aVar2.jE(false);
            aVar2.b(pbChosenActivity.getPageContext()).bqe();
        }
    }

    public static void a(final PbChosenActivity pbChosenActivity, final com.baidu.tieba.pb.chosen.net.a aVar, final long j, final String str, final long j2, final String str2) {
        if (aVar != null && aVar.getThreadInfo() != null) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(pbChosenActivity.getPageContext().getPageActivity());
            final ShareThreadView shareThreadView = new ShareThreadView(pbChosenActivity.getPageContext().getPageActivity());
            shareThreadView.aQ(str2, false);
            shareThreadView.setTitle(aVar.getThreadInfo().title);
            shareThreadView.setDesc(aVar.getThreadInfo()._abstract);
            aVar2.br(shareThreadView);
            aVar2.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.chosen.a.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                    if (com.baidu.tieba.pb.chosen.net.a.this != null && com.baidu.tieba.pb.chosen.net.a.this.getThreadInfo() != null) {
                        l.hideSoftKeyPad(pbChosenActivity.getPageContext().getPageActivity(), shareThreadView.getChatMsgView());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(pbChosenActivity.getPageContext().getPageActivity(), j, str, j2, "from_share", shareThreadView.getLeaveMsg(), a.a(com.baidu.tieba.pb.chosen.net.a.this, com.baidu.tieba.pb.chosen.net.a.this.getThreadInfo().excid.longValue(), str2).toChatMessageContent())));
                        aVar3.dismiss();
                    }
                }
            });
            aVar2.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.chosen.a.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                    l.hideSoftKeyPad(PbChosenActivity.this.getPageContext().getPageActivity(), shareThreadView.getChatMsgView());
                    aVar3.dismiss();
                }
            });
            aVar2.jE(false);
            aVar2.b(pbChosenActivity.getPageContext()).bqe();
        }
    }
}
