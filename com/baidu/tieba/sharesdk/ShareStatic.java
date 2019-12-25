package com.baidu.tieba.sharesdk;

import android.app.Application;
import android.util.Pair;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.d;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class ShareStatic {
    static {
        cEF();
        cEG();
        cEH();
    }

    private static void cEF() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG, new CustomMessageTask.CustomRunnable<d>() { // from class: com.baidu.tieba.sharesdk.ShareStatic.1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<d> run(CustomMessage<d> customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG, new c());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void cEG() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new CustomMessageTask.CustomRunnable<ShareDialogConfig>() { // from class: com.baidu.tieba.sharesdk.ShareStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ShareDialogConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof ShareDialogConfig)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
                    try {
                        Application app = TbadkCoreApplication.getInst().getApp();
                        WbSdk.install(app, new AuthInfo(app, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    ShareDialogConfig data = customMessage.getData();
                    if (data.mIsShowTransmitShare || data.mShowMoreForumShare) {
                        ShareStatic.c(data);
                    } else if (data.isAlaLiveRoomShare()) {
                        ShareStatic.b(data);
                    } else {
                        com.baidu.tieba.sharesdk.d.b bVar = new com.baidu.tieba.sharesdk.d.b(data.getContext(), data.isLandscape, data.hideMode);
                        bVar.a(data.shareItem, data.showLocation);
                        if (data.hasSpecialItem && data.specialShareItems != null && data.specialShareItems.length > 0) {
                            for (int i = 0; i < data.specialShareItems.length; i++) {
                                ShareItem shareItem = data.specialShareItems[i];
                                if (shareItem != null) {
                                    bVar.b(i, shareItem, data.showLocation);
                                }
                            }
                        }
                        if (data.mtjStatistics != null) {
                            bVar.e(data.mtjStatistics);
                        }
                        bVar.setIsCopyLink(data.isCopyLink);
                        if (data.copyTitleId != 0) {
                            bVar.setCustomCopyTitle(data.copyTitleId);
                        }
                        if (data.copyLinkListener != null) {
                            bVar.setCopyLinkListener(data.copyLinkListener);
                        }
                        if (data.onDismissListener != null) {
                            bVar.d(data.onDismissListener);
                        }
                        bVar.g(data.onCancelListener);
                        if (data.textViewList != null && data.textViewList.size() > 0) {
                            Iterator<Pair<Integer, Pair<Integer, View.OnClickListener>>> it = data.textViewList.iterator();
                            while (it.hasNext()) {
                                Pair<Integer, Pair<Integer, View.OnClickListener>> next = it.next();
                                bVar.a(bVar.cF(((Integer) next.first).intValue(), ((Integer) ((Pair) next.second).first).intValue()), bVar.cEV(), (View.OnClickListener) ((Pair) next.second).second);
                            }
                        }
                        bVar.show();
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ShareDialogConfig shareDialogConfig) {
        com.baidu.tieba.sharesdk.d.a aVar = new com.baidu.tieba.sharesdk.d.a(shareDialogConfig.getContext(), shareDialogConfig.isLandscape, shareDialogConfig.hideMode);
        aVar.a(shareDialogConfig.shareItem, shareDialogConfig.showLocation);
        if (shareDialogConfig.copyLinkListener != null) {
            aVar.setCopyLinkListener(shareDialogConfig.copyLinkListener);
        }
        if (shareDialogConfig.onDismissListener != null) {
            aVar.d(shareDialogConfig.onDismissListener);
        }
        if (shareDialogConfig.textViewList != null && shareDialogConfig.textViewList.size() > 0) {
            Iterator<Pair<Integer, Pair<Integer, View.OnClickListener>>> it = shareDialogConfig.textViewList.iterator();
            while (it.hasNext()) {
                Pair<Integer, Pair<Integer, View.OnClickListener>> next = it.next();
                aVar.a(aVar.cF(((Integer) next.first).intValue(), ((Integer) ((Pair) next.second).first).intValue()), aVar.cEV(), (View.OnClickListener) ((Pair) next.second).second);
            }
        }
        aVar.show();
    }

    private static void cEH() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016567, new CustomMessageTask.CustomRunnable<ShareItem>() { // from class: com.baidu.tieba.sharesdk.ShareStatic.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ShareItem> customMessage) {
                if (customMessage != null && (customMessage instanceof ImplicitShareMessage)) {
                    ImplicitShareMessage implicitShareMessage = (ImplicitShareMessage) customMessage;
                    if (implicitShareMessage.getContext() != null && implicitShareMessage.getData() != null) {
                        new a(implicitShareMessage.getContext()).a(implicitShareMessage.getChannel(), implicitShareMessage.getData(), implicitShareMessage.isShowLocation());
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(ShareDialogConfig shareDialogConfig) {
        com.baidu.tieba.transmitShare.c cVar = new com.baidu.tieba.transmitShare.c(shareDialogConfig.getContext());
        cVar.sT(TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive);
        cVar.f(shareDialogConfig);
        cVar.setOnDismissListener(shareDialogConfig.onDismissListener);
        cVar.show();
    }
}
