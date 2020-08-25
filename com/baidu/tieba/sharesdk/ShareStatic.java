package com.baidu.tieba.sharesdk;

import android.app.Application;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbPostShareDialogConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.e;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import java.util.Iterator;
/* loaded from: classes18.dex */
public class ShareStatic {
    public static String Tag = "tag";

    static {
        dss();
        dsu();
        dst();
        dsr();
        dsv();
    }

    private static void dsr() {
        MessageManager.getInstance().registerListener(new HttpMessageListener(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE) { // from class: com.baidu.tieba.sharesdk.ShareStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage instanceof CommandShareHttpResMsg) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    CommandShareHttpResMsg commandShareHttpResMsg = (CommandShareHttpResMsg) httpResponsedMessage;
                    Object extra = commandShareHttpResMsg.getOrginalMessage().getExtra();
                    if ((extra instanceof com.baidu.tbadk.core.atomData.a) && !TextUtils.isEmpty(commandShareHttpResMsg.token)) {
                        com.baidu.tbadk.core.atomData.a aVar = (com.baidu.tbadk.core.atomData.a) extra;
                        aVar.dVa.eEO = aVar.dVa.eEO.replace("TOKEN", commandShareHttpResMsg.token);
                        if (aVar.channel == 0) {
                            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(aVar.activity, aVar.dVa, false);
                            shareDialogConfig.onCancelListener = aVar.onCancelListener;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
                            return;
                        }
                        com.baidu.tbadk.coreExtra.share.a.a(aVar.dVa, aVar.activity, aVar.channel, aVar.onCancelListener);
                    }
                }
            }
        });
    }

    private static void dss() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG, new CustomMessageTask.CustomRunnable<e>() { // from class: com.baidu.tieba.sharesdk.ShareStatic.2
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<e> run(CustomMessage<e> customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG, new c());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void dst() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE, TbConfig.SERVER_ADDRESS + TbConfig.URL_SHARE_COMMAND_GENERATE);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(CommandShareHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void dsu() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new CustomMessageTask.CustomRunnable<ShareDialogConfig>() { // from class: com.baidu.tieba.sharesdk.ShareStatic.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ShareDialogConfig> customMessage) {
                com.baidu.tieba.sharesdk.d.b cVar;
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
                        ShareStatic.d(data);
                    } else if (data.isAlaLiveRoomShare()) {
                        ShareStatic.c(data);
                    } else {
                        if (data instanceof PbPostShareDialogConfig) {
                            cVar = new com.baidu.tieba.sharesdk.d.b(data.getContext(), data.isLandscape, data.hideMode, ((PbPostShareDialogConfig) data).getPbPostData());
                        } else {
                            cVar = new com.baidu.tieba.sharesdk.d.c(data.getContext(), data.isLandscape, data.hideMode);
                        }
                        cVar.a(data.shareItem, data.showLocation);
                        if (data.hasSpecialItem && data.specialShareItems != null && data.specialShareItems.length > 0) {
                            for (int i = 0; i < data.specialShareItems.length; i++) {
                                ShareItem shareItem = data.specialShareItems[i];
                                if (shareItem != null) {
                                    cVar.b(i, shareItem, data.showLocation);
                                }
                            }
                        }
                        if (data.mtjStatistics != null) {
                            cVar.g(data.mtjStatistics);
                        }
                        cVar.setIsCopyLink(data.isCopyLink);
                        if (data.copyTitleId != 0) {
                            cVar.setCustomCopyTitle(data.copyTitleId);
                        }
                        if (data.copyLinkListener != null) {
                            cVar.setCopyLinkListener(data.copyLinkListener);
                        }
                        if (data.onDismissListener != null) {
                            cVar.e(data.onDismissListener);
                        }
                        cVar.f(data.onCancelListener);
                        if (data.textViewList != null && data.textViewList.size() > 0) {
                            Iterator<Pair<Integer, Pair<Integer, View.OnClickListener>>> it = data.textViewList.iterator();
                            while (it.hasNext()) {
                                Pair<Integer, Pair<Integer, View.OnClickListener>> next = it.next();
                                cVar.a(cVar.di(((Integer) next.first).intValue(), ((Integer) ((Pair) next.second).first).intValue()), cVar.dsN(), (View.OnClickListener) ((Pair) next.second).second);
                            }
                        }
                        cVar.b(data.getFrom());
                        cVar.show();
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
        com.baidu.tieba.sharesdk.d.a aVar = new com.baidu.tieba.sharesdk.d.a(shareDialogConfig.getContext(), shareDialogConfig.isLandscape, shareDialogConfig.hideMode);
        aVar.a(shareDialogConfig.shareItem, shareDialogConfig.showLocation);
        if (shareDialogConfig.copyLinkListener != null) {
            aVar.setCopyLinkListener(shareDialogConfig.copyLinkListener);
        }
        if (shareDialogConfig.onDismissListener != null) {
            aVar.e(shareDialogConfig.onDismissListener);
        }
        if (shareDialogConfig.textViewList != null && shareDialogConfig.textViewList.size() > 0) {
            Iterator<Pair<Integer, Pair<Integer, View.OnClickListener>>> it = shareDialogConfig.textViewList.iterator();
            while (it.hasNext()) {
                Pair<Integer, Pair<Integer, View.OnClickListener>> next = it.next();
                aVar.a(aVar.di(((Integer) next.first).intValue(), ((Integer) ((Pair) next.second).first).intValue()), aVar.dsN(), (View.OnClickListener) ((Pair) next.second).second);
            }
        }
        aVar.show();
    }

    private static void dsv() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016567, new CustomMessageTask.CustomRunnable<ShareItem>() { // from class: com.baidu.tieba.sharesdk.ShareStatic.4
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
    public static void d(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null) {
            com.baidu.tieba.transmitShare.c cVar = new com.baidu.tieba.transmitShare.c(shareDialogConfig.getContext());
            cVar.ww((!TbadkCoreApplication.isLogin() || shareDialogConfig.mIsAlaLive || shareDialogConfig.shareItem.bpA()) ? false : true);
            cVar.g(shareDialogConfig);
            cVar.setOnDismissListener(shareDialogConfig.onDismissListener);
            if (shareDialogConfig.shareItem != null && shareDialogConfig.shareItem.eED) {
                cVar.b(shareDialogConfig.getFrom());
            }
            cVar.show();
        }
    }
}
