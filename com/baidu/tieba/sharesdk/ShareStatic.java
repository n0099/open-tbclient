package com.baidu.tieba.sharesdk;

import android.util.Pair;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tieba.share.ImplicitShareMessage;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class ShareStatic {
    static {
        cma();
        cmb();
        cmc();
    }

    private static void cma() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001445, new CustomMessageTask.CustomRunnable<d>() { // from class: com.baidu.tieba.sharesdk.ShareStatic.1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<d> run(CustomMessage<d> customMessage) {
                return new CustomResponsedMessage<>(2001445, new c());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void cmb() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001276, new CustomMessageTask.CustomRunnable<ShareDialogConfig>() { // from class: com.baidu.tieba.sharesdk.ShareStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ShareDialogConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof ShareDialogConfig)) {
                    ShareDialogConfig data = customMessage.getData();
                    if (data.mIsShowTransmitShare || data.mShowMoreForumShare) {
                        ShareStatic.c(data);
                    } else if (data.isAlaLiveRoomShare()) {
                        ShareStatic.b(data);
                    } else {
                        com.baidu.tieba.sharesdk.d.b bVar = new com.baidu.tieba.sharesdk.d.b(data.getContext(), data.isLandscape, data.hideMode);
                        bVar.a(data.shareItem, data.showLocation);
                        if (data.mtjStatistics != null) {
                            bVar.f(data.mtjStatistics);
                        }
                        bVar.setIsCopyLink(data.isCopyLink);
                        if (data.copyLinkListener != null) {
                            bVar.setCopyLinkListener(data.copyLinkListener);
                        }
                        if (data.onDismissListener != null) {
                            bVar.d(data.onDismissListener);
                        }
                        bVar.f(data.onCancelListener);
                        if (data.textViewList != null && data.textViewList.size() > 0) {
                            Iterator<Pair<Integer, Pair<Integer, View.OnClickListener>>> it = data.textViewList.iterator();
                            while (it.hasNext()) {
                                Pair<Integer, Pair<Integer, View.OnClickListener>> next = it.next();
                                bVar.a(bVar.cu(((Integer) next.first).intValue(), ((Integer) ((Pair) next.second).first).intValue()), bVar.cmo(), (View.OnClickListener) ((Pair) next.second).second);
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
                aVar.a(aVar.cu(((Integer) next.first).intValue(), ((Integer) ((Pair) next.second).first).intValue()), aVar.cmo(), (View.OnClickListener) ((Pair) next.second).second);
            }
        }
        aVar.show();
    }

    private static void cmc() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016567, new CustomMessageTask.CustomRunnable<e>() { // from class: com.baidu.tieba.sharesdk.ShareStatic.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<e> customMessage) {
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
        cVar.rA(TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive);
        cVar.f(shareDialogConfig);
        cVar.setOnDismissListener(shareDialogConfig.onDismissListener);
        cVar.show();
    }
}
