package com.baidu.tieba.sharesdk;

import android.app.Application;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.t.g.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbPostShareDialogConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
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
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class ShareStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            if (!(extra instanceof c.a.o0.s.m.a) || TextUtils.isEmpty(commandShareHttpResMsg.token)) {
                return;
            }
            c.a.o0.s.m.a aVar = (c.a.o0.s.m.a) extra;
            String replace = aVar.f13758a.o0.replace("TOKEN", commandShareHttpResMsg.token);
            ShareItem shareItem = aVar.f13758a;
            shareItem.o0 = replace;
            int i2 = aVar.f13760c;
            if (i2 == 0) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(aVar.f13759b, aVar.f13758a, false);
                shareDialogConfig.onCancelListener = aVar.f13761d;
                MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
                return;
            }
            c.a.o0.t.g.a.e(shareItem, aVar.f13759b, i2, aVar.f13761d);
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements CustomMessageTask.CustomRunnable<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<e> run(CustomMessage<e> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) ? new CustomResponsedMessage<>(2001445, new c.a.p0.b3.c()) : (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements CustomMessageTask.CustomRunnable<ShareDialogConfig> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<ShareDialogConfig> customMessage) {
            InterceptResult invokeL;
            c.a.p0.b3.g.d dVar;
            ShareItem[] shareItemArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
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
                            dVar = new c.a.p0.b3.g.c(data.getContext(), data.isLandscape, data.hideMode, ((PbPostShareDialogConfig) data).getPbPostData());
                        } else if (data.isImageViewerDialog) {
                            dVar = new c.a.p0.b3.g.b(data.getContext(), data.originImgText, data.showAddEmotion, data.showQRCode, data.dialogSaveToDiskListener, data.dialogAddToExpressionListener, data.dialogDownloadOriginListener, data.dialogRecognizePicListener, data.qrCodeClickListener, data.onWeChatEmotionShareListener);
                            if (data.shareItem != null) {
                                Bundle bundle = new Bundle();
                                bundle.putInt("obj_locate", 13);
                                data.shareItem.k(bundle);
                            }
                        } else {
                            dVar = new c.a.p0.b3.g.d(data.getContext(), data.isLandscape, data.hideMode);
                        }
                        dVar.P(data.shareItem, data.showLocation);
                        if (data.hasSpecialItem && (shareItemArr = data.specialShareItems) != null && shareItemArr.length > 0) {
                            int i2 = 0;
                            while (true) {
                                ShareItem[] shareItemArr2 = data.specialShareItems;
                                if (i2 >= shareItemArr2.length) {
                                    break;
                                }
                                ShareItem shareItem = shareItemArr2[i2];
                                if (shareItem != null) {
                                    dVar.Q(i2, shareItem, data.showLocation);
                                }
                                i2++;
                            }
                        }
                        SparseArray<String> sparseArray = data.mtjStatistics;
                        if (sparseArray != null) {
                            dVar.N(sparseArray);
                        }
                        dVar.L(data.isCopyLink);
                        int i3 = data.copyTitleId;
                        if (i3 != 0) {
                            dVar.K(i3);
                        }
                        View.OnClickListener onClickListener = data.copyLinkListener;
                        if (onClickListener != null) {
                            dVar.J(onClickListener);
                        }
                        DialogInterface.OnDismissListener onDismissListener = data.onDismissListener;
                        if (onDismissListener != null) {
                            dVar.s(onDismissListener);
                        }
                        dVar.O(data.onCancelListener);
                        ArrayList<Pair<Integer, Pair<Integer, View.OnClickListener>>> arrayList = data.textViewList;
                        if (arrayList != null && arrayList.size() > 0) {
                            Iterator<Pair<Integer, Pair<Integer, View.OnClickListener>>> it = data.textViewList.iterator();
                            while (it.hasNext()) {
                                Pair<Integer, Pair<Integer, View.OnClickListener>> next = it.next();
                                dVar.i(dVar.t(((Integer) next.first).intValue(), ((Integer) ((Pair) next.second).first).intValue()), dVar.n(), (View.OnClickListener) ((Pair) next.second).second);
                            }
                        }
                        dVar.B(data.getFrom());
                        dVar.V();
                        return null;
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements CustomMessageTask.CustomRunnable<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                        new c.a.p0.b3.a(implicitShareMessage.getContext()).c(implicitShareMessage.getChannel(), implicitShareMessage.getData(), implicitShareMessage.isShowLocation());
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE, TbConfig.SERVER_ADDRESS + TbConfig.URL_SHARE_COMMAND_GENERATE);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setResponsedClass(CommandShareHttpResMsg.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
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
            c.a.p0.b3.g.a aVar = new c.a.p0.b3.g.a(shareDialogConfig.getContext(), shareDialogConfig.isLandscape, shareDialogConfig.hideMode);
            aVar.t(shareDialogConfig.shareItem, shareDialogConfig.showLocation);
            View.OnClickListener onClickListener = shareDialogConfig.copyLinkListener;
            if (onClickListener != null) {
                aVar.s(onClickListener);
            }
            DialogInterface.OnDismissListener onDismissListener = shareDialogConfig.onDismissListener;
            if (onDismissListener != null) {
                aVar.k(onDismissListener);
            }
            ArrayList<Pair<Integer, Pair<Integer, View.OnClickListener>>> arrayList = shareDialogConfig.textViewList;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Pair<Integer, Pair<Integer, View.OnClickListener>>> it = shareDialogConfig.textViewList.iterator();
                while (it.hasNext()) {
                    Pair<Integer, Pair<Integer, View.OnClickListener>> next = it.next();
                    aVar.c(aVar.l(((Integer) next.first).intValue(), ((Integer) ((Pair) next.second).first).intValue()), aVar.g(), (View.OnClickListener) ((Pair) next.second).second);
                }
            }
            aVar.u();
        }
    }

    public static void i(ShareDialogConfig shareDialogConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, shareDialogConfig) == null) || shareDialogConfig == null || shareDialogConfig.shareItem == null) {
            return;
        }
        c.a.p0.p3.c cVar = new c.a.p0.p3.c(shareDialogConfig.getContext());
        cVar.m((!TbadkCoreApplication.isLogin() || shareDialogConfig.mIsAd || shareDialogConfig.mIsAlaLive || shareDialogConfig.shareItem.f()) ? false : true);
        cVar.l(shareDialogConfig);
        cVar.k(shareDialogConfig.onDismissListener);
        ShareItem shareItem = shareDialogConfig.shareItem;
        if (shareItem != null && shareItem.a0) {
            cVar.i(shareDialogConfig.getFrom());
        }
        cVar.n();
    }
}
