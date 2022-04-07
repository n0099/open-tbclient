package com.baidu.tieba.sharesdk;

import android.app.Application;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tbadk.core.atomData.StampShareDialogConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.Tun2tornado;
import com.repackage.ff8;
import com.repackage.gf8;
import com.repackage.hf8;
import com.repackage.if8;
import com.repackage.jf8;
import com.repackage.jr8;
import com.repackage.kn4;
import com.repackage.my4;
import com.repackage.qy4;
import com.repackage.se8;
import com.repackage.ue8;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class ShareStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null || httpResponsedMessage.getOrginalMessage() == null || !(httpResponsedMessage instanceof CommandShareHttpResMsg) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                return;
            }
            CommandShareHttpResMsg commandShareHttpResMsg = (CommandShareHttpResMsg) httpResponsedMessage;
            Object extra = commandShareHttpResMsg.getOrginalMessage().getExtra();
            if (!(extra instanceof kn4) || TextUtils.isEmpty(commandShareHttpResMsg.token)) {
                return;
            }
            kn4 kn4Var = (kn4) extra;
            String replace = kn4Var.a.u0.replace(Tun2tornado.ENV_TOKEN, commandShareHttpResMsg.token);
            ShareItem shareItem = kn4Var.a;
            shareItem.u0 = replace;
            int i = kn4Var.c;
            if (i == 0) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(kn4Var.b, kn4Var.a, false);
                shareDialogConfig.onCancelListener = kn4Var.d;
                MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
                return;
            }
            my4.e(shareItem, kn4Var.b, i, kn4Var.d);
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements CustomMessageTask.CustomRunnable<qy4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<qy4> run(CustomMessage<qy4> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) ? new CustomResponsedMessage<>(2001445, new ue8()) : (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements CustomMessageTask.CustomRunnable<ShareDialogConfig> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<ShareDialogConfig> customMessage) {
            InterceptResult invokeL;
            if8 if8Var;
            ShareItem[] shareItemArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
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
                        ShareStatic.i(data);
                    } else if (data.isAlaLiveRoomShare()) {
                        ShareStatic.h(data);
                        return null;
                    } else {
                        if (data instanceof PbPostShareDialogConfig) {
                            if8Var = new hf8(data.getContext(), data.isLandscape, data.hideMode, ((PbPostShareDialogConfig) data).getPbPostData());
                        } else if (data instanceof StampShareDialogConfig) {
                            ShareItem shareItem = data.shareItem;
                            if (shareItem != null) {
                                Bundle e2 = shareItem.e();
                                if (e2 == null) {
                                    e2 = new Bundle();
                                }
                                e2.putInt("obj_locate", 20);
                                data.shareItem.k(e2);
                            }
                            if8Var = new jf8(data.getContext(), data.isLandscape, data.hideMode, ((StampShareDialogConfig) data).getStampShareData());
                        } else if (data.isImageViewerDialog) {
                            if8Var = new gf8(data.getContext(), data.originImgText, data.showAddEmotion, data.showQRCode, data.dialogSaveToDiskListener, data.dialogAddToExpressionListener, data.dialogDownloadOriginListener, data.dialogRecognizePicListener, data.qrCodeClickListener, data.onWeChatEmotionShareListener);
                            if (data.shareItem != null) {
                                Bundle bundle = new Bundle();
                                bundle.putInt("obj_locate", 13);
                                data.shareItem.k(bundle);
                            }
                        } else {
                            if8Var = new if8(data.getContext(), data.isLandscape, data.hideMode);
                        }
                        if8Var.P(data.shareItem, data.showLocation);
                        if (data.hasSpecialItem && (shareItemArr = data.specialShareItems) != null && shareItemArr.length > 0) {
                            int i = 0;
                            while (true) {
                                ShareItem[] shareItemArr2 = data.specialShareItems;
                                if (i >= shareItemArr2.length) {
                                    break;
                                }
                                ShareItem shareItem2 = shareItemArr2[i];
                                if (shareItem2 != null) {
                                    if8Var.Q(i, shareItem2, data.showLocation);
                                }
                                i++;
                            }
                        }
                        SparseArray<String> sparseArray = data.mtjStatistics;
                        if (sparseArray != null) {
                            if8Var.M(sparseArray);
                        }
                        if8Var.K(data.isCopyLink);
                        int i2 = data.copyTitleId;
                        if (i2 != 0) {
                            if8Var.I(i2);
                        }
                        View.OnClickListener onClickListener = data.copyLinkListener;
                        if (onClickListener != null) {
                            if8Var.H(onClickListener);
                        }
                        DialogInterface.OnDismissListener onDismissListener = data.onDismissListener;
                        if (onDismissListener != null) {
                            if8Var.u(onDismissListener);
                        }
                        if8Var.N(data.onCancelListener);
                        ArrayList<Pair<Integer, Pair<Integer, View.OnClickListener>>> arrayList = data.textViewList;
                        if (arrayList != null && arrayList.size() > 0) {
                            Iterator<Pair<Integer, Pair<Integer, View.OnClickListener>>> it = data.textViewList.iterator();
                            while (it.hasNext()) {
                                Pair<Integer, Pair<Integer, View.OnClickListener>> next = it.next();
                                if8Var.i(if8Var.v(((Integer) next.first).intValue(), ((Integer) ((Pair) next.second).first).intValue()), if8Var.o(), (View.OnClickListener) ((Pair) next.second).second);
                            }
                        }
                        if8Var.L(data.isShowPersonalLetter);
                        if8Var.J(data.experimentId);
                        if (data.getPersonalLetterListener() != null) {
                            if8Var.O(data.getPersonalLetterListener());
                        }
                        if8Var.F(data.msgNum, data.isShowMsg);
                        if8Var.E(data.getFrom());
                        if8Var.V();
                        return null;
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements CustomMessageTask.CustomRunnable<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<ShareItem> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && (customMessage instanceof ImplicitShareMessage)) {
                    ImplicitShareMessage implicitShareMessage = (ImplicitShareMessage) customMessage;
                    if (implicitShareMessage.getContext() != null && implicitShareMessage.getData() != null) {
                        new se8(implicitShareMessage.getContext()).c(implicitShareMessage.getChannel(), implicitShareMessage.getData(), implicitShareMessage.isShowLocation());
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-196492460, "Lcom/baidu/tieba/sharesdk/ShareStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-196492460, "Lcom/baidu/tieba/sharesdk/ShareStatic;");
                return;
            }
        }
        g();
        f();
        d();
        c();
        e();
    }

    public ShareStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            MessageManager.getInstance().registerListener(new a(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE));
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE, TbConfig.SERVER_ADDRESS + TbConfig.URL_SHARE_COMMAND_GENERATE);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setResponsedClass(CommandShareHttpResMsg.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016567, new d());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001276, new c());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001445, new b());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void h(ShareDialogConfig shareDialogConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, shareDialogConfig) == null) {
            ff8 ff8Var = new ff8(shareDialogConfig.getContext(), shareDialogConfig.isLandscape, shareDialogConfig.hideMode);
            ff8Var.u(shareDialogConfig.shareItem, shareDialogConfig.showLocation);
            View.OnClickListener onClickListener = shareDialogConfig.copyLinkListener;
            if (onClickListener != null) {
                ff8Var.t(onClickListener);
            }
            DialogInterface.OnDismissListener onDismissListener = shareDialogConfig.onDismissListener;
            if (onDismissListener != null) {
                ff8Var.k(onDismissListener);
            }
            ArrayList<Pair<Integer, Pair<Integer, View.OnClickListener>>> arrayList = shareDialogConfig.textViewList;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Pair<Integer, Pair<Integer, View.OnClickListener>>> it = shareDialogConfig.textViewList.iterator();
                while (it.hasNext()) {
                    Pair<Integer, Pair<Integer, View.OnClickListener>> next = it.next();
                    ff8Var.c(ff8Var.l(((Integer) next.first).intValue(), ((Integer) ((Pair) next.second).first).intValue()), ff8Var.g(), (View.OnClickListener) ((Pair) next.second).second);
                }
            }
            ff8Var.v();
        }
    }

    public static void i(ShareDialogConfig shareDialogConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, shareDialogConfig) == null) || shareDialogConfig == null || shareDialogConfig.shareItem == null) {
            return;
        }
        jr8 jr8Var = new jr8(shareDialogConfig.getContext(), shareDialogConfig.isPrePagePersonalPage());
        jr8Var.m((!TbadkCoreApplication.isLogin() || shareDialogConfig.mIsAd || shareDialogConfig.mIsAlaLive || shareDialogConfig.mIsVoiceRoom || shareDialogConfig.shareItem.f()) ? false : true);
        jr8Var.l(shareDialogConfig);
        jr8Var.k(shareDialogConfig.onDismissListener);
        ShareItem shareItem = shareDialogConfig.shareItem;
        if (shareItem != null && shareItem.f0) {
            jr8Var.i(shareDialogConfig.getFrom());
        }
        jr8Var.n();
    }
}
