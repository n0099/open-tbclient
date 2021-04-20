package com.baidu.tieba.sharesdk;

import android.app.Application;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbPostShareDialogConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import d.b.h0.s.g.e;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class ShareStatic {

    /* loaded from: classes4.dex */
    public static class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getOrginalMessage() == null || !(httpResponsedMessage instanceof CommandShareHttpResMsg) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                return;
            }
            CommandShareHttpResMsg commandShareHttpResMsg = (CommandShareHttpResMsg) httpResponsedMessage;
            Object extra = commandShareHttpResMsg.getOrginalMessage().getExtra();
            if (!(extra instanceof d.b.h0.r.m.a) || TextUtils.isEmpty(commandShareHttpResMsg.token)) {
                return;
            }
            d.b.h0.r.m.a aVar = (d.b.h0.r.m.a) extra;
            String replace = aVar.f51052a.l0.replace("TOKEN", commandShareHttpResMsg.token);
            ShareItem shareItem = aVar.f51052a;
            shareItem.l0 = replace;
            int i = aVar.f51054c;
            if (i == 0) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(aVar.f51053b, aVar.f51052a, false);
                shareDialogConfig.onCancelListener = aVar.f51055d;
                MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
                return;
            }
            d.b.h0.s.g.a.e(shareItem, aVar.f51053b, i, aVar.f51055d);
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements CustomMessageTask.CustomRunnable<e> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<e> run(CustomMessage<e> customMessage) {
            return new CustomResponsedMessage<>(2001445, new d.b.i0.w2.c());
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements CustomMessageTask.CustomRunnable<ShareDialogConfig> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<ShareDialogConfig> customMessage) {
            d.b.i0.w2.g.d dVar;
            ShareItem[] shareItemArr;
            if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof ShareDialogConfig)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
                try {
                    Application app = TbadkCoreApplication.getInst().getApp();
                    WbSdk.install(app, new AuthInfo(app, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
                ShareDialogConfig data = customMessage.getData();
                if (data.mIsShowTransmitShare || data.mShowMoreForumShare) {
                    ShareStatic.i(data);
                } else if (data.isAlaLiveRoomShare()) {
                    ShareStatic.h(data);
                    return null;
                } else {
                    if (data instanceof PbPostShareDialogConfig) {
                        dVar = new d.b.i0.w2.g.c(data.getContext(), data.isLandscape, data.hideMode, ((PbPostShareDialogConfig) data).getPbPostData());
                    } else if (data.isImageViewerDialog) {
                        dVar = new d.b.i0.w2.g.b(data.getContext(), data.originImgText, data.showAddEmotion, data.showQRCode, data.dialogSaveToDiskListener, data.dialogAddToExpressionListener, data.dialogDownloadOriginListener, data.dialogRecognizePicListener, data.qrCodeClickListener, data.onWeChatEmotionShareListener);
                        if (data.shareItem != null) {
                            Bundle bundle = new Bundle();
                            bundle.putInt("obj_locate", 13);
                            data.shareItem.i(bundle);
                        }
                    } else {
                        dVar = new d.b.i0.w2.g.d(data.getContext(), data.isLandscape, data.hideMode);
                    }
                    dVar.M(data.shareItem, data.showLocation);
                    if (data.hasSpecialItem && (shareItemArr = data.specialShareItems) != null && shareItemArr.length > 0) {
                        int i = 0;
                        while (true) {
                            ShareItem[] shareItemArr2 = data.specialShareItems;
                            if (i >= shareItemArr2.length) {
                                break;
                            }
                            ShareItem shareItem = shareItemArr2[i];
                            if (shareItem != null) {
                                dVar.O(i, shareItem, data.showLocation);
                            }
                            i++;
                        }
                    }
                    SparseArray<String> sparseArray = data.mtjStatistics;
                    if (sparseArray != null) {
                        dVar.K(sparseArray);
                    }
                    dVar.J(data.isCopyLink);
                    int i2 = data.copyTitleId;
                    if (i2 != 0) {
                        dVar.I(i2);
                    }
                    View.OnClickListener onClickListener = data.copyLinkListener;
                    if (onClickListener != null) {
                        dVar.G(onClickListener);
                    }
                    DialogInterface.OnDismissListener onDismissListener = data.onDismissListener;
                    if (onDismissListener != null) {
                        dVar.s(onDismissListener);
                    }
                    dVar.L(data.onCancelListener);
                    ArrayList<Pair<Integer, Pair<Integer, View.OnClickListener>>> arrayList = data.textViewList;
                    if (arrayList != null && arrayList.size() > 0) {
                        Iterator<Pair<Integer, Pair<Integer, View.OnClickListener>>> it = data.textViewList.iterator();
                        while (it.hasNext()) {
                            Pair<Integer, Pair<Integer, View.OnClickListener>> next = it.next();
                            dVar.i(dVar.u(((Integer) next.first).intValue(), ((Integer) ((Pair) next.second).first).intValue()), dVar.n(), (View.OnClickListener) ((Pair) next.second).second);
                        }
                    }
                    dVar.E(data.getFrom());
                    dVar.T();
                    return null;
                }
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements CustomMessageTask.CustomRunnable<ShareItem> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<ShareItem> customMessage) {
            if (customMessage != null && (customMessage instanceof ImplicitShareMessage)) {
                ImplicitShareMessage implicitShareMessage = (ImplicitShareMessage) customMessage;
                if (implicitShareMessage.getContext() != null && implicitShareMessage.getData() != null) {
                    new d.b.i0.w2.a(implicitShareMessage.getContext()).c(implicitShareMessage.getChannel(), implicitShareMessage.getData(), implicitShareMessage.isShowLocation());
                }
            }
            return null;
        }
    }

    static {
        g();
        f();
        d();
        c();
        e();
    }

    public static void c() {
        MessageManager.getInstance().registerListener(new a(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE));
    }

    public static void d() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE, TbConfig.SERVER_ADDRESS + TbConfig.URL_SHARE_COMMAND_GENERATE);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(CommandShareHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void e() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016567, new d());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void f() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001276, new c());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void g() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001445, new b());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void h(ShareDialogConfig shareDialogConfig) {
        d.b.i0.w2.g.a aVar = new d.b.i0.w2.g.a(shareDialogConfig.getContext(), shareDialogConfig.isLandscape, shareDialogConfig.hideMode);
        aVar.v(shareDialogConfig.shareItem, shareDialogConfig.showLocation);
        View.OnClickListener onClickListener = shareDialogConfig.copyLinkListener;
        if (onClickListener != null) {
            aVar.u(onClickListener);
        }
        DialogInterface.OnDismissListener onDismissListener = shareDialogConfig.onDismissListener;
        if (onDismissListener != null) {
            aVar.l(onDismissListener);
        }
        ArrayList<Pair<Integer, Pair<Integer, View.OnClickListener>>> arrayList = shareDialogConfig.textViewList;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Pair<Integer, Pair<Integer, View.OnClickListener>>> it = shareDialogConfig.textViewList.iterator();
            while (it.hasNext()) {
                Pair<Integer, Pair<Integer, View.OnClickListener>> next = it.next();
                aVar.c(aVar.m(((Integer) next.first).intValue(), ((Integer) ((Pair) next.second).first).intValue()), aVar.h(), (View.OnClickListener) ((Pair) next.second).second);
            }
        }
        aVar.w();
    }

    public static void i(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig == null || shareDialogConfig.shareItem == null) {
            return;
        }
        d.b.i0.k3.c cVar = new d.b.i0.k3.c(shareDialogConfig.getContext());
        cVar.n((!TbadkCoreApplication.isLogin() || shareDialogConfig.mIsAlaLive || shareDialogConfig.shareItem.e()) ? false : true);
        cVar.m(shareDialogConfig);
        cVar.l(shareDialogConfig.onDismissListener);
        ShareItem shareItem = shareDialogConfig.shareItem;
        if (shareItem != null && shareItem.Y) {
            cVar.j(shareDialogConfig.getFrom());
        }
        cVar.o();
    }
}
