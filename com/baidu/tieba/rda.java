package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.WorkPublishOpenHelper;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.util.DialogUtil;
import com.baidu.tbadk.coreExtra.util.PushOpenUtil;
import com.baidu.tieba.controller.TransmitShareController;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.ShadowLinearLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Map;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes7.dex */
public class rda {
    public static /* synthetic */ Interceptable $ic;
    public static PostWriteCallBackData d;
    public static jd5 e;
    public static WriteData f;
    public static AntiData g;
    public static Intent h;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public BlueCircleProgressDialog b;
    public TbPageContext<?> c;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ NavigationBarCoverTip b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;
        public final /* synthetic */ rda e;

        public a(rda rdaVar, Activity activity, NavigationBarCoverTip navigationBarCoverTip, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rdaVar, activity, navigationBarCoverTip, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = rdaVar;
            this.a = activity;
            this.b = navigationBarCoverTip;
            this.c = j;
            this.d = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                qda.a("发帖-成功： 开始分享 -- start");
                view2.setOnClickListener(null);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(this.a, (int) R.string.obfuscated_res_0x7f0f0e21);
                    this.b.e();
                    qda.a("发帖-成功： 开始分享 -- 失败 -- 无网");
                    return;
                }
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
                int equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
                float f = this.a.getResources().getDisplayMetrics().density;
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    i = 2;
                } else {
                    i = 1;
                }
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setTag(this.e.a);
                requestGetMyPostNetMessage.setParams(this.c, this.d, 0L, equipmentWidth, equipmentHeight, f, i);
                MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                qda.a("发帖-成功： 开始分享 -- 发送GetMyPost");
                this.e.q(this.a);
                this.b.e();
                qda.a("发帖-成功： 开始分享 -- 关闭成功弹框");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NavigationBarCoverTip a;
        public final /* synthetic */ String b;
        public final /* synthetic */ rda c;

        public b(rda rdaVar, NavigationBarCoverTip navigationBarCoverTip, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rdaVar, navigationBarCoverTip, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rdaVar;
            this.a = navigationBarCoverTip;
            this.b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.e();
                if (this.c.o(this.b)) {
                    StatisticItem statisticItem = new StatisticItem("c13673");
                    statisticItem.param("obj_source", 13);
                    statisticItem.param("obj_type", 2);
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ NavigationBarCoverTip d;
        public final /* synthetic */ rda e;

        public c(rda rdaVar, String str, boolean z, Activity activity, NavigationBarCoverTip navigationBarCoverTip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rdaVar, str, Boolean.valueOf(z), activity, navigationBarCoverTip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = rdaVar;
            this.a = str;
            this.b = z;
            this.c = activity;
            this.d = navigationBarCoverTip;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                qda.a("发帖-成功： 开启 -- start");
                view2.setOnClickListener(null);
                boolean z2 = false;
                if (this.e.o(this.a)) {
                    if (!de5.d().f) {
                        new MsgRemindModel(this.e.c).S(1, true, null);
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!de5.d().g) {
                        new MsgRemindModel(this.e.c).S(20, true, null);
                        z = true;
                    }
                    if (!this.b) {
                        DialogUtil.jumpSystemNotificationSetting(this.c);
                    }
                    z2 = z;
                } else if (this.e.n(this.a)) {
                    if (!de5.d().f) {
                        new MsgRemindModel(this.e.c).S(1, true, null);
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!this.b) {
                        DialogUtil.jumpSystemNotificationSetting(this.c);
                    }
                    z2 = z;
                } else if (this.e.m(this.a) && !this.b) {
                    DialogUtil.jumpSystemNotificationSetting(this.c);
                }
                if (z2) {
                    PushOpenUtil.showPushPermissionSucToast(this.c);
                }
                this.d.e();
                if (this.e.o(this.a)) {
                    StatisticItem statisticItem = new StatisticItem("c13673");
                    statisticItem.param("obj_source", 13);
                    statisticItem.param("obj_type", 1);
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteData a;
        public final /* synthetic */ Activity b;

        public d(rda rdaVar, WriteData writeData, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rdaVar, writeData, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeData;
            this.b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                qda.a("发帖-失败： 重新编辑 -- start");
                view2.setOnClickListener(null);
                WriteData writeData = this.a;
                if (writeData != null && writeData.isWork()) {
                    WorkPublishOpenHelper.Companion.d(this.a, this.b);
                    sda.b(true);
                    return;
                }
                WriteActivityConfig newInstance = WriteActivityConfig.newInstance(this.b);
                Intent intent = rda.h;
                if (intent != null) {
                    newInstance.setIntent(intent);
                }
                newInstance.setFromErrorDialog(true);
                newInstance.send();
                sda.b(false);
                qda.a("发帖-失败： 重新编辑 -- end");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<rda> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(rda rdaVar) {
            super(CmdConfigHttp.CMD_GET_MY_POST, 303111);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rdaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(rdaVar);
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                qda.a("发帖-成功： 分享进行 -- 接受GetMyPost");
                rda rdaVar = this.a.get();
                if (rdaVar != null) {
                    rdaVar.l();
                    if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                        GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                        rdaVar.k(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
                    } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                        GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                        rdaVar.k(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
                    }
                }
            }
        }
    }

    public rda() {
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
        this.a = BdUniqueId.gen();
        p();
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            qda.a("发帖-成功： 开始分享 -- 隐藏loading -- start");
            BlueCircleProgressDialog blueCircleProgressDialog = this.b;
            if (blueCircleProgressDialog != null) {
                blueCircleProgressDialog.setDialogVisiable(false);
                qda.a("发帖-成功： 开始分享 -- 隐藏loading -- end");
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            e eVar = new e(this);
            eVar.setTag(this.a);
            eVar.getHttpMessageListener().setSelfListener(true);
            eVar.getSocketMessageListener().setSelfListener(true);
            MessageManager.getInstance().registerListener(eVar);
        }
    }

    public static int j(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, threadData)) == null) {
            if (threadData != null) {
                if (threadData.isRealGod()) {
                    return 4;
                }
                if (threadData.getIsLive() == 1) {
                    return 3;
                }
                if (!threadData.isRealVideoThread()) {
                    return 1;
                }
                return 2;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final boolean m(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return "pb_to_personalize".equals(str);
        }
        return invokeL.booleanValue;
    }

    public final boolean n(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return "post_question_success".equals(str);
        }
        return invokeL.booleanValue;
    }

    public final boolean o(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return "post_success".equals(str);
        }
        return invokeL.booleanValue;
    }

    public final void q(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
            BlueCircleProgressDialog blueCircleProgressDialog = new BlueCircleProgressDialog(activity);
            this.b = blueCircleProgressDialog;
            blueCircleProgressDialog.setDialogVisiable(true);
            qda.a("发帖-成功： 开始分享 -- 显示loading");
        }
    }

    public static String i(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, threadData)) == null) {
            if (threadData == null || threadData.getMedias() == null) {
                return null;
            }
            ArrayList<MediaData> medias = threadData.getMedias();
            int size = medias.size();
            for (int i = 0; i < size; i++) {
                MediaData mediaData = medias.get(i);
                if (mediaData != null && mediaData.getType() == 3) {
                    if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                        return mediaData.getThumbnails_url();
                    }
                    if (!StringUtils.isNull(mediaData.getPicUrl())) {
                        return mediaData.getPicUrl();
                    }
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final void k(int i, GetMyPostResIdl getMyPostResIdl) {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, getMyPostResIdl) == null) {
            qda.a("发帖-成功： 分享进行 -- 处理GetMyPost");
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity == null) {
                qda.a("发帖-成功： 分享进行 -- 处理GetMyPost -- 失败 -- ACT为NULL");
            } else if (i == 0 && getMyPostResIdl != null && (dataRes = getMyPostResIdl.data) != null && dataRes.thread_info != null) {
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(getMyPostResIdl.data.thread_info);
                r(threadData, currentActivity);
            } else {
                BdUtilHelper.showToast(currentActivity, (int) R.string.obfuscated_res_0x7f0f0e21);
                qda.a("发帖-成功： 分享进行 -- 处理GetMyPost -- 失败 -- 请求数据异常");
            }
        }
    }

    public final void r(ThreadData threadData, Activity activity) {
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, threadData, activity) == null) {
            qda.a("发帖-成功： 分享弹框 -- start");
            if (threadData != null && activity != null) {
                String valueOf = String.valueOf(threadData.getFid());
                String forum_name = threadData.getForum_name();
                String title = threadData.getTitle();
                if (TextUtils.isEmpty(title)) {
                    title = threadData.getAbstract();
                }
                String tid = threadData.getTid();
                String str = TbConfig.HTTPS_PB_PREFIX + tid + "?share=9105&fr=share";
                String i = i(threadData);
                if (i == null) {
                    parse = null;
                } else {
                    parse = Uri.parse(i);
                }
                String str2 = threadData.getAbstract();
                String format = MessageFormat.format(activity.getResources().getString(R.string.share_content_tpl), title, str2);
                ShareItem shareItem = new ShareItem();
                shareItem.title = title;
                shareItem.content = format;
                shareItem.readCount = 0L;
                shareItem.shareAbstract = str2;
                shareItem.linkUrl = str;
                shareItem.shareReportFrom = 5;
                shareItem.extData = tid;
                shareItem.objParam1 = 3;
                shareItem.fid = valueOf;
                shareItem.fName = forum_name;
                shareItem.tid = tid;
                shareItem.isFromFeed = true;
                shareItem.objSource = 15;
                shareItem.obj_type = j(threadData);
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                shareItem.originalThreadInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(threadData);
                shareItem.forwardInfo = ShareItem.ForwardInfo.generateForwardInfo(threadData);
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                shareItem.smartAppShareImageUrl = threadData.getShareImageUrl();
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.objParam1);
                bundle.putInt("obj_type", shareItem.obj_type);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putInt("obj_source", shareItem.shareReportFrom);
                shareItem.setStats(bundle);
                qda.a("发帖-成功： 分享弹框 -- 显示 -- end");
                TransmitShareController.getInstance().showShareDialog(new ShareDialogConfig((Context) activity, shareItem, true, true));
            }
        }
    }

    public void s(PostWriteCallBackData postWriteCallBackData, jd5 jd5Var, WriteData writeData, AntiData antiData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, postWriteCallBackData, jd5Var, writeData, antiData) == null) {
            if (postWriteCallBackData == null) {
                qda.a("发帖-失败： 失败弹框 -- 无backData");
                return;
            }
            d = postWriteCallBackData;
            e = jd5Var;
            f = writeData;
            g = antiData;
            qda.a("发帖-失败： 失败弹框 -- start");
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity == null) {
                qda.a("发帖-失败： 失败弹框 -- 失败 -- 当前Activity为NULL");
                return;
            }
            FrameLayout frameLayout = (FrameLayout) currentActivity.findViewById(16908290);
            if (frameLayout == null) {
                qda.a("发帖-失败： 失败弹框 -- 失败 -- 当前Activity的content为NULL");
                return;
            }
            NavigationBarCoverTip navigationBarCoverTip = null;
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                if (frameLayout.getChildAt(i) instanceof NavigationBarCoverTip) {
                    navigationBarCoverTip = (NavigationBarCoverTip) frameLayout.getChildAt(i);
                }
            }
            if (navigationBarCoverTip == null) {
                navigationBarCoverTip = new NavigationBarCoverTip(currentActivity);
                frameLayout.addView(navigationBarCoverTip, new ViewGroup.LayoutParams(-1, -2));
            }
            navigationBarCoverTip.setVisibility(8);
            ShadowLinearLayout shadowLinearLayout = (ShadowLinearLayout) LayoutInflater.from(currentActivity).inflate(R.layout.tb_top_toast_layout, (ViewGroup) null, false).findViewById(R.id.tb_top_toast_group);
            TextView textView = (TextView) shadowLinearLayout.findViewById(R.id.tb_top_toast_title);
            TextView textView2 = (TextView) shadowLinearLayout.findViewById(R.id.tb_top_toast_content);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) shadowLinearLayout.findViewById(R.id.tb_top_toast_btn);
            textView.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_fail_title));
            String errorString = postWriteCallBackData.getErrorString();
            if (TextUtils.isEmpty(errorString)) {
                textView2.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_fail_content));
            } else {
                textView2.setText(errorString);
            }
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_fail_btn));
            tBSpecificationBtn.setConfig(new y95());
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0301);
            SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0301);
            tBSpecificationBtn.k();
            shadowLinearLayout.b();
            tBSpecificationBtn.setOnClickListener(new d(this, writeData, currentActivity));
            navigationBarCoverTip.setBackgroundColor(0);
            navigationBarCoverTip.m(currentActivity, shadowLinearLayout, 5000);
            if (writeData != null && writeData.isWork()) {
                z = true;
            } else {
                z = false;
            }
            sda.a(false, z);
            qda.a("发帖-失败： 失败弹框 -- 成功 -- end");
        }
    }

    public void t(long j, long j2, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) {
            qda.a("发帖-成功： 成功弹框 -- start");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (j2 == 0) {
                qda.a("发帖-成功： 成功弹框 -- 失败 --   threadId = " + j2);
            } else if ((o(str) && j == 0) || (n(str) && j == 0)) {
                qda.a("发帖-成功： 成功弹框 -- 失败 -- postId = " + j);
            } else {
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity == null) {
                    qda.a("发帖-成功： 成功弹框 -- 失败 -- 当前Activity为NULL");
                    return;
                }
                FrameLayout frameLayout = (FrameLayout) currentActivity.findViewById(16908290);
                if (frameLayout == null) {
                    qda.a("发帖-成功： 成功弹框 -- 失败 -- 当前Activity的content为NULL");
                    return;
                }
                NavigationBarCoverTip navigationBarCoverTip = null;
                for (int i = 0; i < frameLayout.getChildCount(); i++) {
                    if (frameLayout.getChildAt(i) instanceof NavigationBarCoverTip) {
                        navigationBarCoverTip = (NavigationBarCoverTip) frameLayout.getChildAt(i);
                    }
                }
                if (navigationBarCoverTip == null) {
                    navigationBarCoverTip = new NavigationBarCoverTip(currentActivity);
                    frameLayout.addView(navigationBarCoverTip, new ViewGroup.LayoutParams(-1, -2));
                }
                NavigationBarCoverTip navigationBarCoverTip2 = navigationBarCoverTip;
                navigationBarCoverTip2.setVisibility(8);
                ShadowLinearLayout shadowLinearLayout = (ShadowLinearLayout) LayoutInflater.from(currentActivity).inflate(R.layout.tb_top_toast_layout, (ViewGroup) null, false).findViewById(R.id.tb_top_toast_group);
                TextView textView = (TextView) shadowLinearLayout.findViewById(R.id.tb_top_toast_title);
                TextView textView2 = (TextView) shadowLinearLayout.findViewById(R.id.tb_top_toast_content);
                ImageView imageView = (ImageView) shadowLinearLayout.findViewById(R.id.tb_top_toast_icon_cancel);
                TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) shadowLinearLayout.findViewById(R.id.tb_top_toast_btn);
                cd5 pushStrategyConfig = TbSingleton.getInstance().getPushStrategyConfig();
                tv9 g2 = uv9.e().g("pb_to_personalize");
                tv9 g3 = uv9.e().g("post_question_success");
                String str3 = "";
                if (!o(str) || pushStrategyConfig == null || !pushStrategyConfig.d()) {
                    str2 = "";
                } else {
                    Map<String, String> readConfig = PushOpenUtil.readConfig(str);
                    str3 = readConfig.get(PushOpenUtil.VIEW_PARAMS_KEY_TITLE);
                    str2 = readConfig.get(PushOpenUtil.VIEW_PARAMS_KEY_DESC);
                }
                if (m(str) && g2 != null) {
                    str3 = g2.f();
                    str2 = g2.d();
                }
                if (n(str) && g3 != null) {
                    str3 = g3.f();
                    str2 = g3.d();
                }
                if (TextUtils.isEmpty(str3)) {
                    str3 = TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_push_title);
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_push_text);
                }
                textView.setText(str3);
                textView2.setText(str2);
                tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b1d));
                imageView.setVisibility(0);
                uv9.e().h(str);
                if (imageView != null) {
                    imageView.setOnClickListener(new b(this, navigationBarCoverTip2, str));
                }
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0302);
                SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0302);
                SkinManager.setViewTextColor(imageView, (int) R.color.CAM_X0302);
                tBSpecificationBtn.k();
                shadowLinearLayout.b();
                tBSpecificationBtn.setOnClickListener(new c(this, str, NotificationManagerCompat.from(currentActivity).areNotificationsEnabled(), currentActivity, navigationBarCoverTip2));
                navigationBarCoverTip2.setBackgroundColor(0);
                navigationBarCoverTip2.m(currentActivity, shadowLinearLayout, 5000);
                if (o(str)) {
                    sda.a(true, false);
                    qda.a("发帖-成功： 成功弹框 -- 成功 -- end");
                    StatisticItem statisticItem = new StatisticItem("c13674");
                    statisticItem.param("obj_source", 13);
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    public void u(PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
        int i;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, postWriteCallBackData, writeData) == null) {
            qda.a("发帖-成功： 成功弹框 -- start");
            if (postWriteCallBackData == null || postWriteCallBackData.getToast() != null || writeData.isInterceptWriteResultDialog()) {
                return;
            }
            long j = JavaTypesHelper.toLong(postWriteCallBackData.getPostId(), 0L);
            long j2 = JavaTypesHelper.toLong(postWriteCallBackData.getThreadId(), 0L);
            if (j != 0 && j2 != 0) {
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity == null) {
                    qda.a("发帖-成功： 成功弹框 -- 失败 -- 当前Activity为NULL");
                    return;
                }
                FrameLayout frameLayout = (FrameLayout) currentActivity.findViewById(16908290);
                if (frameLayout == null) {
                    qda.a("发帖-成功： 成功弹框 -- 失败 -- 当前Activity的content为NULL");
                    return;
                }
                NavigationBarCoverTip navigationBarCoverTip = null;
                for (int i2 = 0; i2 < frameLayout.getChildCount(); i2++) {
                    if (frameLayout.getChildAt(i2) instanceof NavigationBarCoverTip) {
                        navigationBarCoverTip = (NavigationBarCoverTip) frameLayout.getChildAt(i2);
                    }
                }
                if (navigationBarCoverTip == null) {
                    navigationBarCoverTip = new NavigationBarCoverTip(currentActivity);
                    frameLayout.addView(navigationBarCoverTip, new ViewGroup.LayoutParams(-1, -2));
                }
                NavigationBarCoverTip navigationBarCoverTip2 = navigationBarCoverTip;
                navigationBarCoverTip2.setVisibility(8);
                ShadowLinearLayout shadowLinearLayout = (ShadowLinearLayout) LayoutInflater.from(currentActivity).inflate(R.layout.tb_top_toast_layout, (ViewGroup) null, false).findViewById(R.id.tb_top_toast_group);
                TextView textView = (TextView) shadowLinearLayout.findViewById(R.id.tb_top_toast_title);
                TextView textView2 = (TextView) shadowLinearLayout.findViewById(R.id.tb_top_toast_content);
                TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) shadowLinearLayout.findViewById(R.id.tb_top_toast_btn);
                Resources resources = TbadkCoreApplication.getInst().getResources();
                if (writeData.isQuestionThread()) {
                    i = R.string.write_thread_success_title_send_help;
                } else {
                    i = R.string.write_thread_success_title;
                }
                String string2 = resources.getString(i);
                if (writeData.isQuestionThread()) {
                    if (postWriteCallBackData.getInviteesNumberInt() < 50) {
                        string = TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_content_send_help1);
                    } else {
                        string = String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_content_send_help), postWriteCallBackData.getInviteesNumber());
                    }
                } else {
                    string = TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_content);
                }
                textView.setText(string2);
                textView2.setText(string);
                tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.share_at_once));
                tBSpecificationBtn.setConfig(new y95());
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0302);
                SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0302);
                tBSpecificationBtn.k();
                shadowLinearLayout.b();
                tBSpecificationBtn.setOnClickListener(new a(this, currentActivity, navigationBarCoverTip2, j2, j));
                navigationBarCoverTip2.setBackgroundColor(0);
                navigationBarCoverTip2.m(currentActivity, shadowLinearLayout, 5000);
                sda.a(true, false);
                qda.a("发帖-成功： 成功弹框 -- 成功 -- end");
                return;
            }
            qda.a("发帖-成功： 成功弹框 -- 失败 -- postId = " + j + "  threadId = " + j2);
        }
    }

    public void v(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, postWriteCallBackData) == null) {
            qda.a("发帖-成功-视频： 成功弹框 -- start");
            if (postWriteCallBackData == null) {
                return;
            }
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity == null) {
                qda.a("发帖-成功-视频： 成功弹框 -- 失败 -- 当前Activity为NULL");
                return;
            }
            FrameLayout frameLayout = (FrameLayout) currentActivity.findViewById(16908290);
            if (frameLayout == null) {
                qda.a("发帖-成功-视频： 成功弹框 -- 失败 -- 当前Activity的content为NULL");
                return;
            }
            NavigationBarCoverTip navigationBarCoverTip = null;
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                if (frameLayout.getChildAt(i) instanceof NavigationBarCoverTip) {
                    navigationBarCoverTip = (NavigationBarCoverTip) frameLayout.getChildAt(i);
                }
            }
            if (navigationBarCoverTip == null) {
                navigationBarCoverTip = new NavigationBarCoverTip(currentActivity);
                frameLayout.addView(navigationBarCoverTip, new ViewGroup.LayoutParams(-1, -2));
            }
            navigationBarCoverTip.setVisibility(8);
            ShadowLinearLayout shadowLinearLayout = (ShadowLinearLayout) LayoutInflater.from(currentActivity).inflate(R.layout.tb_top_toast_layout_no_tip, (ViewGroup) null, false).findViewById(R.id.tb_top_toast_group);
            TextView textView = (TextView) shadowLinearLayout.findViewById(R.id.tb_top_toast_title);
            textView.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_video_title));
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0302);
            shadowLinearLayout.b();
            navigationBarCoverTip.setBackgroundColor(0);
            navigationBarCoverTip.m(currentActivity, shadowLinearLayout, 5000);
            sda.a(true, true);
            qda.a("发帖-成功-视频： 成功弹框 -- 成功 -- end");
        }
    }
}
