package com.baidu.tieba.sharesdk;

import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tieba.share.ImplicitShareMessage;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class ShareStatic {
    static {
        bsM();
        bsN();
        bsO();
    }

    private static void bsM() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001445, new CustomMessageTask.CustomRunnable<com.baidu.tbadk.coreExtra.c.c>() { // from class: com.baidu.tieba.sharesdk.ShareStatic.1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tbadk.coreExtra.c.c> run(CustomMessage<com.baidu.tbadk.coreExtra.c.c> customMessage) {
                return new CustomResponsedMessage<>(2001445, new c());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bsN() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001276, new CustomMessageTask.CustomRunnable<ShareDialogConfig>() { // from class: com.baidu.tieba.sharesdk.ShareStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ShareDialogConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof ShareDialogConfig)) {
                    ShareDialogConfig data = customMessage.getData();
                    if (data.mIsShowTransmitShare) {
                        ShareStatic.b(data);
                    } else if (data.mIsShowSlumdogMillionaireShare) {
                        ShareStatic.c(data);
                    } else {
                        com.baidu.tieba.sharesdk.d.a aVar = new com.baidu.tieba.sharesdk.d.a(data.getContext(), data.isLandscape, data.hideMode);
                        aVar.a(data.shareItem, data.showLocation);
                        if (data.mtjStatistics != null) {
                            aVar.e(data.mtjStatistics);
                        }
                        aVar.setIsCopyLink(data.isCopyLink);
                        if (data.copyLinkListener != null) {
                            aVar.setCopyLinkListener(data.copyLinkListener);
                        }
                        if (data.onDismissListener != null) {
                            aVar.b(data.onDismissListener);
                        }
                        if (data.textViewList != null && data.textViewList.size() > 0) {
                            Iterator<Pair<Integer, Pair<Integer, View.OnClickListener>>> it = data.textViewList.iterator();
                            while (it.hasNext()) {
                                Pair<Integer, Pair<Integer, View.OnClickListener>> next = it.next();
                                TextView bE = aVar.bE(((Integer) next.first).intValue(), ((Integer) ((Pair) next.second).first).intValue());
                                if (data.isInsertBack) {
                                    aVar.a(bE, aVar.bsY(), (View.OnClickListener) ((Pair) next.second).second);
                                } else {
                                    aVar.b(bE, (View.OnClickListener) ((Pair) next.second).second);
                                }
                            }
                        }
                        aVar.show();
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bsO() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016567, new CustomMessageTask.CustomRunnable<d>() { // from class: com.baidu.tieba.sharesdk.ShareStatic.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<d> customMessage) {
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
    public static void b(ShareDialogConfig shareDialogConfig) {
        com.baidu.tieba.r.d dVar = new com.baidu.tieba.r.d(shareDialogConfig.getContext());
        dVar.nd(TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive);
        dVar.a(shareDialogConfig.mForumList, shareDialogConfig.shareItem, shareDialogConfig.mPrivateThread);
        dVar.setOnDismissListener(shareDialogConfig.onDismissListener);
        dVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(ShareDialogConfig shareDialogConfig) {
        com.baidu.tieba.slumdogMillionaire.a aVar = new com.baidu.tieba.slumdogMillionaire.a(shareDialogConfig.getContext());
        aVar.setShareData(shareDialogConfig.shareItem);
        aVar.setOnDismissListener(shareDialogConfig.onDismissListener);
        aVar.show();
    }
}
