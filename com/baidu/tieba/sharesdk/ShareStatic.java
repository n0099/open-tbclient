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
import com.baidu.tbadk.core.message.UserGrowthTaskResponseMessage;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.bc7;
import com.baidu.tieba.dq4;
import com.baidu.tieba.gh8;
import com.baidu.tieba.hh8;
import com.baidu.tieba.ht8;
import com.baidu.tieba.ih8;
import com.baidu.tieba.jh8;
import com.baidu.tieba.kh8;
import com.baidu.tieba.l25;
import com.baidu.tieba.p25;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tg8;
import com.baidu.tieba.vg8;
import com.baidu.tieba.w19;
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
/* loaded from: classes5.dex */
public class ShareStatic {
    public static /* synthetic */ Interceptable $ic;
    public static g a;
    public static boolean b;
    public static long c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
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
            if (!(extra instanceof dq4) || TextUtils.isEmpty(commandShareHttpResMsg.token)) {
                return;
            }
            dq4 dq4Var = (dq4) extra;
            String replace = dq4Var.a.C0.replace(Tun2tornado.ENV_TOKEN, commandShareHttpResMsg.token);
            ShareItem shareItem = dq4Var.a;
            shareItem.C0 = replace;
            int i = dq4Var.c;
            if (i == 0) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(dq4Var.b, dq4Var.a, false);
                shareDialogConfig.onCancelListener = dq4Var.d;
                MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
                return;
            }
            l25.e(shareItem, dq4Var.b, i, dq4Var.d);
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements CustomMessageTask.CustomRunnable<p25> {
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
        public CustomResponsedMessage<p25> run(CustomMessage<p25> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) ? new CustomResponsedMessage<>(2001445, new vg8()) : (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
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
            jh8 jh8Var;
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
                        ShareStatic.r(data);
                    } else if (data.isAlaLiveRoomShare()) {
                        ShareStatic.q(data);
                        return null;
                    } else {
                        if (data instanceof PbPostShareDialogConfig) {
                            jh8Var = new ih8(data.getContext(), data.isLandscape, data.hideMode, ((PbPostShareDialogConfig) data).getPbPostData());
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
                            jh8Var = new kh8(data.getContext(), data.isLandscape, data.hideMode, ((StampShareDialogConfig) data).getStampShareData());
                        } else if (data.isImageViewerDialog) {
                            jh8Var = new hh8(data.getContext(), data.originImgText, data.showAddEmotion, data.showQRCode, data.dialogSaveToDiskListener, data.dialogAddToExpressionListener, data.dialogDownloadOriginListener, data.dialogRecognizePicListener, data.qrCodeClickListener, data.onWeChatEmotionShareListener);
                            if (data.shareItem != null) {
                                Bundle bundle = new Bundle();
                                bundle.putInt("obj_locate", 13);
                                data.shareItem.k(bundle);
                            }
                        } else {
                            jh8Var = new jh8(data.getContext(), data.isLandscape, data.hideMode);
                        }
                        jh8Var.f0(data.shareItem, data.showLocation);
                        if (data.hasSpecialItem && (shareItemArr = data.specialShareItems) != null && shareItemArr.length > 0) {
                            int i = 0;
                            while (true) {
                                ShareItem[] shareItemArr2 = data.specialShareItems;
                                if (i >= shareItemArr2.length) {
                                    break;
                                }
                                ShareItem shareItem2 = shareItemArr2[i];
                                if (shareItem2 != null) {
                                    jh8Var.g0(i, shareItem2, data.showLocation);
                                }
                                i++;
                            }
                        }
                        SparseArray<String> sparseArray = data.mtjStatistics;
                        if (sparseArray != null) {
                            jh8Var.c0(sparseArray);
                        }
                        jh8Var.a0(data.isCopyLink);
                        int i2 = data.copyTitleId;
                        if (i2 != 0) {
                            jh8Var.X(i2);
                        }
                        View.OnClickListener onClickListener = data.copyLinkListener;
                        if (onClickListener != null) {
                            jh8Var.W(onClickListener);
                        }
                        DialogInterface.OnDismissListener onDismissListener = data.onDismissListener;
                        if (onDismissListener != null) {
                            jh8Var.F(onDismissListener);
                        }
                        jh8Var.d0(data.onCancelListener);
                        ArrayList<Pair<Integer, Pair<Integer, View.OnClickListener>>> arrayList = data.textViewList;
                        if (arrayList != null && arrayList.size() > 0) {
                            Iterator<Pair<Integer, Pair<Integer, View.OnClickListener>>> it = data.textViewList.iterator();
                            while (it.hasNext()) {
                                Pair<Integer, Pair<Integer, View.OnClickListener>> next = it.next();
                                jh8Var.m(jh8Var.G(((Integer) next.first).intValue(), ((Integer) ((Pair) next.second).first).intValue()), jh8Var.y(), (View.OnClickListener) ((Pair) next.second).second);
                            }
                        }
                        jh8Var.b0(data.isShowPersonalLetter);
                        jh8Var.Y(data.experimentId);
                        if (data.getPersonalLetterListener() != null) {
                            jh8Var.e0(data.getPersonalLetterListener());
                        }
                        jh8Var.U(data.msgNum, data.isShowMsg);
                        jh8Var.T(data.getFrom());
                        jh8Var.m0();
                        return null;
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
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
                        new tg8(implicitShareMessage.getContext()).c(implicitShareMessage.getChannel(), implicitShareMessage.getData(), implicitShareMessage.isShowLocation());
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || customResponsedMessage.getData() == null || TbadkCoreApplication.getCurrentAccount() == null) {
                return;
            }
            g unused = ShareStatic.a = new g();
            ShareStatic.a.execute("");
            boolean unused2 = ShareStatic.b = true;
            long unused3 = ShareStatic.c = System.currentTimeMillis();
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921666 && ShareStatic.b && System.currentTimeMillis() - ShareStatic.c >= 60000 && PermissionUtil.isAgreePrivacyPolicy() && TbadkCoreApplication.getCurrentAccount() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                g unused = ShareStatic.a = new g();
                ShareStatic.a.execute("");
                long unused2 = ShareStatic.c = System.currentTimeMillis();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g extends BdAsyncTask<String, Integer, w19> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public w19 doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                NetWork netWork = new NetWork();
                this.a = netWork;
                netWork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
                this.a.addPostData("from", "3");
                String postNetData = this.a.postNetData();
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    w19 w19Var = new w19();
                    w19Var.b(postNetData);
                    return w19Var;
                }
                return null;
            }
            return (w19) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(w19 w19Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w19Var) == null) {
                g unused = ShareStatic.a = null;
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    bc7.b(w19Var.a());
                } else {
                    BdLog.d("request = error");
                }
                super.onPostExecute(w19Var);
            }
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
        o();
        n();
        k();
        j();
        l();
        i();
        m();
        p();
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
            CustomMessageTask customMessageTask = new CustomMessageTask(2016567, new d());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            MessageManager.getInstance().registerListener(new f(2921666));
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001276, new c());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001445, new b());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_YINJI_TASK_SHARE_REPORT, TbConfig.SERVER_ADDRESS + TbConfig.GET_YINJI_TASK_REPORT);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setResponsedClass(UserGrowthTaskResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void q(ShareDialogConfig shareDialogConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, shareDialogConfig) == null) {
            gh8 gh8Var = new gh8(shareDialogConfig.getContext(), shareDialogConfig.isLandscape, shareDialogConfig.hideMode);
            gh8Var.t(shareDialogConfig.shareItem, shareDialogConfig.showLocation);
            View.OnClickListener onClickListener = shareDialogConfig.copyLinkListener;
            if (onClickListener != null) {
                gh8Var.s(onClickListener);
            }
            DialogInterface.OnDismissListener onDismissListener = shareDialogConfig.onDismissListener;
            if (onDismissListener != null) {
                gh8Var.k(onDismissListener);
            }
            ArrayList<Pair<Integer, Pair<Integer, View.OnClickListener>>> arrayList = shareDialogConfig.textViewList;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Pair<Integer, Pair<Integer, View.OnClickListener>>> it = shareDialogConfig.textViewList.iterator();
                while (it.hasNext()) {
                    Pair<Integer, Pair<Integer, View.OnClickListener>> next = it.next();
                    gh8Var.c(gh8Var.l(((Integer) next.first).intValue(), ((Integer) ((Pair) next.second).first).intValue()), gh8Var.g(), (View.OnClickListener) ((Pair) next.second).second);
                }
            }
            gh8Var.u();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x004f, code lost:
        if (com.baidu.tbadk.core.util.ListUtils.getCount(r3.threadData.getItemStar()) <= 0) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void r(ShareDialogConfig shareDialogConfig) {
        ShareItem shareItem;
        boolean z;
        ht8 ht8Var;
        ShareItem shareItem2;
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, null, shareDialogConfig) == null) || shareDialogConfig == null || (shareItem = shareDialogConfig.shareItem) == null) {
            return;
        }
        OriginalThreadInfo.ShareInfo shareInfo = shareItem.X;
        boolean z2 = true;
        boolean z3 = (shareInfo == null || (threadData2 = shareInfo.threadData) == null || threadData2.getAnchorInfoData() == null || !shareDialogConfig.shareItem.X.threadData.isLiveThread()) ? false : true;
        OriginalThreadInfo.ShareInfo shareInfo2 = shareDialogConfig.shareItem.X;
        if (shareInfo2 != null && (threadData = shareInfo2.threadData) != null) {
            if (!threadData.isScoreThread()) {
                OriginalThreadInfo.ShareInfo shareInfo3 = shareDialogConfig.shareItem.X;
                if (shareInfo3.itemData == null) {
                }
            }
            z = true;
            ShareItem shareItem3 = shareDialogConfig.shareItem;
            boolean z4 = !shareItem3.m0 || shareItem3.n;
            boolean z5 = (!z3 || z || z4) ? false : true;
            boolean z6 = (!z3 || z || z4) ? false : true;
            ht8Var = new ht8(shareDialogConfig.getContext(), z5);
            ht8Var.m((TbadkCoreApplication.isLogin() || shareDialogConfig.mIsAd || shareDialogConfig.mIsAlaLive || shareDialogConfig.mIsVoiceRoom || shareDialogConfig.shareItem.f()) ? false : false);
            ht8Var.l(shareDialogConfig, z6);
            ht8Var.k(shareDialogConfig.onDismissListener);
            shareItem2 = shareDialogConfig.shareItem;
            if (shareItem2 != null && shareItem2.l0) {
                ht8Var.i(shareDialogConfig.getFrom());
            }
            ht8Var.n();
        }
        z = false;
        ShareItem shareItem32 = shareDialogConfig.shareItem;
        if (shareItem32.m0) {
        }
        if (!z3) {
        }
        if (!z3) {
        }
        ht8Var = new ht8(shareDialogConfig.getContext(), z5);
        ht8Var.m((TbadkCoreApplication.isLogin() || shareDialogConfig.mIsAd || shareDialogConfig.mIsAlaLive || shareDialogConfig.mIsVoiceRoom || shareDialogConfig.shareItem.f()) ? false : false);
        ht8Var.l(shareDialogConfig, z6);
        ht8Var.k(shareDialogConfig.onDismissListener);
        shareItem2 = shareDialogConfig.shareItem;
        if (shareItem2 != null) {
            ht8Var.i(shareDialogConfig.getFrom());
        }
        ht8Var.n();
    }
}
