package com.baidu.tieba.sharesdk;

import android.app.Application;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbPostShareDialogConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.StampShareDialogConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.FestivalTaskResponseMessage;
import com.baidu.tbadk.core.message.UserGrowthTaskResponseMessage;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.cq9;
import com.baidu.tieba.eq9;
import com.baidu.tieba.hb8;
import com.baidu.tieba.hf5;
import com.baidu.tieba.lf5;
import com.baidu.tieba.n5a;
import com.baidu.tieba.qq9;
import com.baidu.tieba.rq9;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.sq9;
import com.baidu.tieba.tq9;
import com.baidu.tieba.uq9;
import com.baidu.tieba.z05;
import com.baidu.tieba.zea;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.Tun2tornado;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class ShareStatic {
    public static /* synthetic */ Interceptable $ic;
    public static g a;
    public static boolean b;
    public static long c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage instanceof CommandShareHttpResMsg) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                CommandShareHttpResMsg commandShareHttpResMsg = (CommandShareHttpResMsg) httpResponsedMessage;
                Object extra = commandShareHttpResMsg.getOrginalMessage().getExtra();
                if ((extra instanceof z05) && !TextUtils.isEmpty(commandShareHttpResMsg.token)) {
                    z05 z05Var = (z05) extra;
                    String replace = z05Var.a.E0.replace(Tun2tornado.ENV_TOKEN, commandShareHttpResMsg.token);
                    ShareItem shareItem = z05Var.a;
                    shareItem.E0 = replace;
                    int i = z05Var.c;
                    if (i == 0) {
                        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(z05Var.b, z05Var.a, false);
                        shareDialogConfig.onCancelListener = z05Var.d;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
                        return;
                    }
                    hf5.f(shareItem, z05Var.b, i, z05Var.d);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements CustomMessageTask.CustomRunnable<lf5> {
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
        public CustomResponsedMessage<lf5> run(CustomMessage<lf5> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                return new CustomResponsedMessage<>(2001445, new eq9());
            }
            return (CustomResponsedMessage) invokeL.objValue;
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
            tq9 tq9Var;
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
                    if (!data.mIsShowTransmitShare && !data.mShowMoreForumShare) {
                        if (!data.isAlaLiveRoomShare()) {
                            if (data instanceof PbPostShareDialogConfig) {
                                tq9Var = new sq9(data.getContext(), data.isLandscape, data.hideMode, ((PbPostShareDialogConfig) data).getPbPostData());
                            } else if (data instanceof StampShareDialogConfig) {
                                ShareItem shareItem = data.shareItem;
                                if (shareItem != null) {
                                    Bundle g = shareItem.g();
                                    if (g == null) {
                                        g = new Bundle();
                                    }
                                    g.putInt("obj_locate", 20);
                                    data.shareItem.r(g);
                                }
                                tq9Var = new uq9(data.getContext(), data.isLandscape, data.hideMode, ((StampShareDialogConfig) data).getStampShareData());
                            } else if (data.isImageViewerDialog) {
                                tq9Var = new rq9(data.getContext(), data.originImgText, data.showAddEmotion, data.showQRCode, data.dialogSaveToDiskListener, data.dialogAddToExpressionListener, data.dialogDownloadOriginListener, data.dialogRecognizePicListener, data.qrCodeClickListener, data.onWeChatEmotionShareListener);
                                if (data.shareItem != null) {
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("obj_locate", 13);
                                    data.shareItem.r(bundle);
                                }
                            } else {
                                tq9Var = new tq9(data.getContext(), data.isLandscape, data.hideMode);
                            }
                            tq9Var.g0(data.shareItem, data.showLocation);
                            if (data.hasSpecialItem && (shareItemArr = data.specialShareItems) != null && shareItemArr.length > 0) {
                                int i = 0;
                                while (true) {
                                    ShareItem[] shareItemArr2 = data.specialShareItems;
                                    if (i >= shareItemArr2.length) {
                                        break;
                                    }
                                    ShareItem shareItem2 = shareItemArr2[i];
                                    if (shareItem2 != null) {
                                        tq9Var.h0(i, shareItem2, data.showLocation);
                                    }
                                    i++;
                                }
                            }
                            SparseArray<String> sparseArray = data.mtjStatistics;
                            if (sparseArray != null) {
                                tq9Var.d0(sparseArray);
                            }
                            tq9Var.b0(data.isCopyLink);
                            int i2 = data.copyTitleId;
                            if (i2 != 0) {
                                tq9Var.Z(i2);
                            }
                            View.OnClickListener onClickListener = data.copyLinkListener;
                            if (onClickListener != null) {
                                tq9Var.Y(onClickListener);
                            }
                            DialogInterface.OnDismissListener onDismissListener = data.onDismissListener;
                            if (onDismissListener != null) {
                                tq9Var.H(onDismissListener);
                            }
                            tq9Var.e0(data.onCancelListener);
                            ArrayList<Pair<Integer, Pair<Integer, View.OnClickListener>>> arrayList = data.textViewList;
                            if (arrayList != null && arrayList.size() > 0) {
                                Iterator<Pair<Integer, Pair<Integer, View.OnClickListener>>> it = data.textViewList.iterator();
                                while (it.hasNext()) {
                                    Pair<Integer, Pair<Integer, View.OnClickListener>> next = it.next();
                                    tq9Var.n(tq9Var.I(((Integer) next.first).intValue(), ((Integer) ((Pair) next.second).first).intValue()), tq9Var.A(), (View.OnClickListener) ((Pair) next.second).second);
                                }
                            }
                            tq9Var.c0(data.isShowPersonalLetter);
                            tq9Var.a0(data.experimentId);
                            if (data.getPersonalLetterListener() != null) {
                                tq9Var.f0(data.getPersonalLetterListener());
                            }
                            tq9Var.W(data.msgNum, data.isShowMsg);
                            tq9Var.V(data.getFrom());
                            tq9Var.p0();
                            return null;
                        }
                        ShareStatic.r(data);
                        return null;
                    }
                    ShareStatic.s(data);
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
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
                    ImplicitShareMessage implicitShareMessage = (ImplicitShareMessage) customMessage;
                    if (implicitShareMessage.getContext() != null && implicitShareMessage.getData() != null) {
                        new cq9(implicitShareMessage.getContext()).c(implicitShareMessage.getChannel(), implicitShareMessage.getData(), implicitShareMessage.isShowLocation());
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i) {
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || customResponsedMessage.getData() == null || TbadkCoreApplication.getCurrentAccount() == null) {
                return;
            }
            g unused = ShareStatic.a = new g();
            ShareStatic.a.execute("");
            boolean unused2 = ShareStatic.b = true;
            long unused3 = ShareStatic.c = System.currentTimeMillis();
        }
    }

    /* loaded from: classes7.dex */
    public static class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(int i) {
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921666 || !ShareStatic.b || System.currentTimeMillis() - ShareStatic.c < 60000 || !PermissionUtil.isAgreePrivacyPolicy() || TbadkCoreApplication.getCurrentAccount() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            g unused = ShareStatic.a = new g();
            ShareStatic.a.execute("");
            long unused2 = ShareStatic.c = System.currentTimeMillis();
        }
    }

    /* loaded from: classes7.dex */
    public static class g extends BdAsyncTask<String, Integer, zea> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                g unused = ShareStatic.a = null;
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                super.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public zea doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                NetWork netWork = new NetWork();
                this.a = netWork;
                netWork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
                this.a.addPostData("from", "3");
                String postNetData = this.a.postNetData();
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    zea zeaVar = new zea();
                    zeaVar.d(postNetData);
                    return zeaVar;
                }
                return null;
            }
            return (zea) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(zea zeaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zeaVar) == null) {
                g unused = ShareStatic.a = null;
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    hb8.b(zeaVar.c());
                } else {
                    BdLog.d("request = error");
                }
                super.onPostExecute(zeaVar);
            }
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
        p();
        o();
        k();
        j();
        m();
        i();
        n();
        q();
        l();
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE, TbConfig.SERVER_ADDRESS + TbConfig.URL_SHARE_COMMAND_GENERATE);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setResponsedClass(CommandShareHttpResMsg.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FESTIVAL_TASK_SHARE_REPORT, TbConfig.SERVER_ADDRESS + TbConfig.GET_FESTIVAL_TASK_REPORT);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setResponsedClass(FestivalTaskResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_YINJI_TASK_SHARE_REPORT, TbConfig.SERVER_ADDRESS + TbConfig.GET_YINJI_TASK_REPORT);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setResponsedClass(UserGrowthTaskResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
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

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            MessageManager.getInstance().registerListener(2005016, new e(0));
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            MessageManager.getInstance().registerListener(new a(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE));
        }
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016567, new d());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            MessageManager.getInstance().registerListener(new f(2921666));
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001276, new c());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001445, new b());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void r(ShareDialogConfig shareDialogConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, shareDialogConfig) == null) {
            qq9 qq9Var = new qq9(shareDialogConfig.getContext(), shareDialogConfig.isLandscape, shareDialogConfig.hideMode);
            qq9Var.t(shareDialogConfig.shareItem, shareDialogConfig.showLocation);
            View.OnClickListener onClickListener = shareDialogConfig.copyLinkListener;
            if (onClickListener != null) {
                qq9Var.s(onClickListener);
            }
            DialogInterface.OnDismissListener onDismissListener = shareDialogConfig.onDismissListener;
            if (onDismissListener != null) {
                qq9Var.k(onDismissListener);
            }
            ArrayList<Pair<Integer, Pair<Integer, View.OnClickListener>>> arrayList = shareDialogConfig.textViewList;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Pair<Integer, Pair<Integer, View.OnClickListener>>> it = shareDialogConfig.textViewList.iterator();
                while (it.hasNext()) {
                    Pair<Integer, Pair<Integer, View.OnClickListener>> next = it.next();
                    qq9Var.c(qq9Var.l(((Integer) next.first).intValue(), ((Integer) ((Pair) next.second).first).intValue()), qq9Var.g(), (View.OnClickListener) ((Pair) next.second).second);
                }
            }
            qq9Var.u();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x004f, code lost:
        if (com.baidu.tbadk.core.util.ListUtils.getCount(r3.threadData.getItemStar()) <= 0) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void s(ShareDialogConfig shareDialogConfig) {
        ShareItem shareItem;
        boolean z;
        boolean z2;
        ShareItem shareItem2;
        boolean z3;
        boolean z4;
        boolean z5;
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65556, null, shareDialogConfig) == null) && shareDialogConfig != null && (shareItem = shareDialogConfig.shareItem) != null) {
            OriginalThreadInfo.ShareInfo shareInfo = shareItem.a0;
            boolean z6 = true;
            if (shareInfo != null && (threadData2 = shareInfo.threadData) != null && threadData2.getAnchorInfoData() != null && shareDialogConfig.shareItem.a0.threadData.isLiveThread()) {
                z = true;
            } else {
                z = false;
            }
            OriginalThreadInfo.ShareInfo shareInfo2 = shareDialogConfig.shareItem.a0;
            if (shareInfo2 != null && (threadData = shareInfo2.threadData) != null) {
                if (!threadData.isScoreThread()) {
                    OriginalThreadInfo.ShareInfo shareInfo3 = shareDialogConfig.shareItem.a0;
                    if (shareInfo3.itemData == null) {
                    }
                }
                z2 = true;
                shareItem2 = shareDialogConfig.shareItem;
                if (shareItem2.p0 && !shareItem2.n) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z && !z2 && !z3) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z && !z2 && !z3) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                n5a n5aVar = new n5a(shareDialogConfig.getContext(), z4);
                n5aVar.m((TbadkCoreApplication.isLogin() || shareDialogConfig.mIsAd || shareDialogConfig.mIsAlaLive || shareDialogConfig.mIsVoiceRoom || !shareDialogConfig.shareItem.l()) ? false : false);
                n5aVar.l(shareDialogConfig, z5);
                n5aVar.k(shareDialogConfig.onDismissListener);
                n5aVar.n();
            }
            z2 = false;
            shareItem2 = shareDialogConfig.shareItem;
            if (shareItem2.p0) {
            }
            z3 = true;
            if (z) {
            }
            z4 = false;
            if (z) {
            }
            z5 = false;
            n5a n5aVar2 = new n5a(shareDialogConfig.getContext(), z4);
            n5aVar2.m((TbadkCoreApplication.isLogin() || shareDialogConfig.mIsAd || shareDialogConfig.mIsAlaLive || shareDialogConfig.mIsVoiceRoom || !shareDialogConfig.shareItem.l()) ? false : false);
            n5aVar2.l(shareDialogConfig, z5);
            n5aVar2.k(shareDialogConfig.onDismissListener);
            n5aVar2.n();
        }
    }
}
