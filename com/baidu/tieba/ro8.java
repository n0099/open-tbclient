package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
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
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.share.ShareItem;
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
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Map;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes5.dex */
public class ro8 {
    public static /* synthetic */ Interceptable $ic;
    public static PostWriteCallBackData d;
    public static l15 e;
    public static WriteData f;
    public static AntiData g;
    public static Intent h;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public fx4 b;
    public TbPageContext<?> c;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ NavigationBarCoverTip b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;
        public final /* synthetic */ ro8 e;

        public a(ro8 ro8Var, Activity activity, NavigationBarCoverTip navigationBarCoverTip, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ro8Var, activity, navigationBarCoverTip, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ro8Var;
            this.a = activity;
            this.b = navigationBarCoverTip;
            this.c = j;
            this.d = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                qo8.a("发帖-成功： 开始分享 -- start");
                view2.setOnClickListener(null);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    ej.M(this.a, R.string.obfuscated_res_0x7f0f0c59);
                    this.b.e();
                    qo8.a("发帖-成功： 开始分享 -- 失败 -- 无网");
                    return;
                }
                int k = ej.k(TbadkCoreApplication.getInst());
                int i = ej.i(TbadkCoreApplication.getInst());
                float f = this.a.getResources().getDisplayMetrics().density;
                int i2 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setTag(this.e.a);
                requestGetMyPostNetMessage.setParams(this.c, this.d, 0L, k, i, f, i2);
                MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                qo8.a("发帖-成功： 开始分享 -- 发送GetMyPost");
                this.e.l(this.a);
                this.b.e();
                qo8.a("发帖-成功： 开始分享 -- 关闭成功弹框");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NavigationBarCoverTip a;

        public b(ro8 ro8Var, NavigationBarCoverTip navigationBarCoverTip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ro8Var, navigationBarCoverTip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = navigationBarCoverTip;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.e();
                StatisticItem statisticItem = new StatisticItem("c13673");
                statisticItem.param("obj_source", 13);
                statisticItem.param("obj_type", 2);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ NavigationBarCoverTip b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ ro8 d;

        public c(ro8 ro8Var, boolean z, NavigationBarCoverTip navigationBarCoverTip, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ro8Var, Boolean.valueOf(z), navigationBarCoverTip, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ro8Var;
            this.a = z;
            this.b = navigationBarCoverTip;
            this.c = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                qo8.a("发帖-成功： 开启 -- start");
                view2.setOnClickListener(null);
                if (!this.a) {
                    new MsgRemindModel(this.d.c).E(1, true, null);
                    new MsgRemindModel(this.d.c).E(20, true, null);
                    this.b.e();
                }
                if (this.a) {
                    w25.l(this.c);
                    new MsgRemindModel(this.d.c).E(1, true, null);
                    new MsgRemindModel(this.d.c).E(20, true, null);
                    this.b.e();
                } else {
                    s25.d(this.c);
                    this.b.e();
                }
                StatisticItem statisticItem = new StatisticItem("c13673");
                statisticItem.param("obj_source", 13);
                statisticItem.param("obj_type", 1);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteData a;
        public final /* synthetic */ Activity b;

        public d(ro8 ro8Var, WriteData writeData, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ro8Var, writeData, activity};
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
                qo8.a("发帖-失败： 重新编辑 -- start");
                view2.setOnClickListener(null);
                WriteData writeData = this.a;
                if (writeData != null && writeData.isWork()) {
                    WorkPublishOpenHelper.Companion.d(this.a, this.b);
                    so8.b(true);
                    return;
                }
                WriteActivityConfig newInstance = WriteActivityConfig.newInstance(this.b);
                Intent intent = ro8.h;
                if (intent != null) {
                    newInstance.setIntent(intent);
                }
                newInstance.setFromErrorDialog(true);
                newInstance.send();
                so8.b(false);
                qo8.a("发帖-失败： 重新编辑 -- end");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends pb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ro8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ro8 ro8Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ro8Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ro8Var;
        }

        @Override // com.baidu.tieba.pb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                qo8.a("发帖-成功： 分享进行 -- 接受GetMyPost");
                this.a.j();
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    this.a.i(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    this.a.i(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
                }
            }
        }
    }

    public ro8() {
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
        k();
    }

    public static String f(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, threadData)) == null) {
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

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) ? i == 9 ? "post_success" : "default" : (String) invokeI.objValue;
    }

    public static int h(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, threadData)) == null) {
            if (threadData != null) {
                if (threadData.isRealGod()) {
                    return 4;
                }
                if (threadData.getIsLive() == 1) {
                    return 3;
                }
                return threadData.isRealVideoThread() ? 2 : 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final void i(int i, GetMyPostResIdl getMyPostResIdl) {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, getMyPostResIdl) == null) {
            qo8.a("发帖-成功： 分享进行 -- 处理GetMyPost");
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity == null) {
                qo8.a("发帖-成功： 分享进行 -- 处理GetMyPost -- 失败 -- ACT为NULL");
            } else if (i == 0 && getMyPostResIdl != null && (dataRes = getMyPostResIdl.data) != null && dataRes.thread_info != null) {
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(getMyPostResIdl.data.thread_info);
                m(threadData, currentActivity);
            } else {
                ej.M(currentActivity, R.string.obfuscated_res_0x7f0f0c59);
                qo8.a("发帖-成功： 分享进行 -- 处理GetMyPost -- 失败 -- 请求数据异常");
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            qo8.a("发帖-成功： 开始分享 -- 隐藏loading -- start");
            fx4 fx4Var = this.b;
            if (fx4Var != null) {
                fx4Var.h(false);
                qo8.a("发帖-成功： 开始分享 -- 隐藏loading -- end");
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e eVar = new e(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
            eVar.setTag(this.a);
            eVar.getHttpMessageListener().setSelfListener(true);
            eVar.getSocketMessageListener().setSelfListener(true);
            MessageManager.getInstance().registerListener(eVar);
        }
    }

    public final void l(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            fx4 fx4Var = new fx4(activity);
            this.b = fx4Var;
            fx4Var.h(true);
            qo8.a("发帖-成功： 开始分享 -- 显示loading");
        }
    }

    public final void m(ThreadData threadData, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, threadData, activity) == null) {
            qo8.a("发帖-成功： 分享弹框 -- start");
            if (threadData == null || activity == null) {
                return;
            }
            String valueOf = String.valueOf(threadData.getFid());
            String forum_name = threadData.getForum_name();
            String title = threadData.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = threadData.getAbstract();
            }
            String tid = threadData.getTid();
            String str = TbConfig.HTTPS_PB_PREFIX + tid + "?share=9105&fr=share";
            String f2 = f(threadData);
            Uri parse = f2 == null ? null : Uri.parse(f2);
            String str2 = threadData.getAbstract();
            String format = MessageFormat.format(activity.getResources().getString(R.string.obfuscated_res_0x7f0f114e), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.v = title;
            shareItem.w = format;
            shareItem.V = 0L;
            shareItem.H = str2;
            shareItem.x = str;
            shareItem.s = 5;
            shareItem.u = tid;
            shareItem.J = 3;
            shareItem.N = valueOf;
            shareItem.t = forum_name;
            shareItem.O = tid;
            shareItem.f = true;
            shareItem.I = 15;
            shareItem.Q = h(threadData);
            if (parse != null) {
                shareItem.z = parse;
            }
            shareItem.X = OriginalThreadInfo.ShareInfo.generateShareInfo(threadData);
            shareItem.a0 = ShareItem.ForwardInfo.generateForwardInfo(threadData);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.q0 = threadData.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.J);
            bundle.putInt("obj_type", shareItem.Q);
            bundle.putString("fid", shareItem.N);
            bundle.putString("tid", shareItem.O);
            bundle.putInt("obj_source", shareItem.s);
            shareItem.k(bundle);
            qo8.a("发帖-成功： 分享弹框 -- 显示 -- end");
            l36.c().l(new ShareDialogConfig((Context) activity, shareItem, true, true));
        }
    }

    public void n(PostWriteCallBackData postWriteCallBackData, l15 l15Var, WriteData writeData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, postWriteCallBackData, l15Var, writeData, antiData) == null) {
            if (postWriteCallBackData == null) {
                qo8.a("发帖-失败： 失败弹框 -- 无backData");
                return;
            }
            d = postWriteCallBackData;
            e = l15Var;
            f = writeData;
            g = antiData;
            qo8.a("发帖-失败： 失败弹框 -- start");
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity == null) {
                qo8.a("发帖-失败： 失败弹框 -- 失败 -- 当前Activity为NULL");
                return;
            }
            FrameLayout frameLayout = (FrameLayout) currentActivity.findViewById(16908290);
            if (frameLayout == null) {
                qo8.a("发帖-失败： 失败弹框 -- 失败 -- 当前Activity的content为NULL");
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
            ShadowLinearLayout shadowLinearLayout = (ShadowLinearLayout) LayoutInflater.from(currentActivity).inflate(R.layout.obfuscated_res_0x7f0d0867, (ViewGroup) null, false).findViewById(R.id.obfuscated_res_0x7f0920e6);
            TextView textView = (TextView) shadowLinearLayout.findViewById(R.id.obfuscated_res_0x7f0920e8);
            TextView textView2 = (TextView) shadowLinearLayout.findViewById(R.id.obfuscated_res_0x7f0920e5);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) shadowLinearLayout.findViewById(R.id.obfuscated_res_0x7f0920e4);
            textView.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1602));
            String errorString = postWriteCallBackData.getErrorString();
            if (TextUtils.isEmpty(errorString)) {
                textView2.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1601));
            } else {
                textView2.setText(errorString);
            }
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1600));
            tBSpecificationBtn.setConfig(new by4());
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0301);
            SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0301);
            tBSpecificationBtn.k();
            shadowLinearLayout.b();
            tBSpecificationBtn.setOnClickListener(new d(this, writeData, currentActivity));
            navigationBarCoverTip.setBackgroundColor(0);
            navigationBarCoverTip.n(currentActivity, shadowLinearLayout, 5000);
            so8.a(false, writeData != null && writeData.isWork());
            qo8.a("发帖-失败： 失败弹框 -- 成功 -- end");
        }
    }

    public void o(PostWriteCallBackData postWriteCallBackData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, postWriteCallBackData, i) == null) {
            qo8.a("发帖-成功： 成功弹框 -- start");
            if (postWriteCallBackData == null) {
                return;
            }
            long g2 = dh.g(postWriteCallBackData.getPostId(), 0L);
            long g3 = dh.g(postWriteCallBackData.getThreadId(), 0L);
            if (g2 != 0 && g3 != 0) {
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity == null) {
                    qo8.a("发帖-成功： 成功弹框 -- 失败 -- 当前Activity为NULL");
                    return;
                }
                FrameLayout frameLayout = (FrameLayout) currentActivity.findViewById(16908290);
                if (frameLayout == null) {
                    qo8.a("发帖-成功： 成功弹框 -- 失败 -- 当前Activity的content为NULL");
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
                navigationBarCoverTip.setVisibility(8);
                ShadowLinearLayout shadowLinearLayout = (ShadowLinearLayout) LayoutInflater.from(currentActivity).inflate(R.layout.obfuscated_res_0x7f0d0867, (ViewGroup) null, false).findViewById(R.id.obfuscated_res_0x7f0920e6);
                TextView textView = (TextView) shadowLinearLayout.findViewById(R.id.obfuscated_res_0x7f0920e8);
                TextView textView2 = (TextView) shadowLinearLayout.findViewById(R.id.obfuscated_res_0x7f0920e5);
                ImageView imageView = (ImageView) shadowLinearLayout.findViewById(R.id.obfuscated_res_0x7f0920e7);
                TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) shadowLinearLayout.findViewById(R.id.obfuscated_res_0x7f0920e4);
                e15 pushStrategyConfig = TbSingleton.getInstance().getPushStrategyConfig();
                if (pushStrategyConfig != null && pushStrategyConfig.d()) {
                    Map<String, String> f2 = w25.f(g(i));
                    textView.setText(f2.get("view_params_key_title"));
                    textView2.setText(f2.get("view_params_key_desc"));
                } else {
                    textView.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1607));
                    textView2.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1606));
                }
                tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0997));
                imageView.setVisibility(0);
                if (imageView != null) {
                    imageView.setOnClickListener(new b(this, navigationBarCoverTip));
                }
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0302);
                SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0302);
                SkinManager.setViewTextColor(imageView, (int) R.color.CAM_X0302);
                tBSpecificationBtn.k();
                shadowLinearLayout.b();
                tBSpecificationBtn.setOnClickListener(new c(this, NotificationManagerCompat.from(currentActivity).areNotificationsEnabled(), navigationBarCoverTip, currentActivity));
                navigationBarCoverTip.setBackgroundColor(0);
                navigationBarCoverTip.k(currentActivity, shadowLinearLayout);
                so8.a(true, false);
                qo8.a("发帖-成功： 成功弹框 -- 成功 -- end");
                StatisticItem statisticItem = new StatisticItem("c13674");
                statisticItem.param("obj_source", 13);
                TiebaStatic.log(statisticItem);
                return;
            }
            qo8.a("发帖-成功： 成功弹框 -- 失败 -- postId = " + g2 + "  threadId = " + g3);
        }
    }

    public void p(PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, postWriteCallBackData, writeData) == null) {
            qo8.a("发帖-成功： 成功弹框 -- start");
            if (postWriteCallBackData != null && postWriteCallBackData.getToast() == null) {
                long g2 = dh.g(postWriteCallBackData.getPostId(), 0L);
                long g3 = dh.g(postWriteCallBackData.getThreadId(), 0L);
                if (g2 != 0 && g3 != 0) {
                    Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                    if (currentActivity == null) {
                        qo8.a("发帖-成功： 成功弹框 -- 失败 -- 当前Activity为NULL");
                        return;
                    }
                    FrameLayout frameLayout = (FrameLayout) currentActivity.findViewById(16908290);
                    if (frameLayout == null) {
                        qo8.a("发帖-成功： 成功弹框 -- 失败 -- 当前Activity的content为NULL");
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
                    ShadowLinearLayout shadowLinearLayout = (ShadowLinearLayout) LayoutInflater.from(currentActivity).inflate(R.layout.obfuscated_res_0x7f0d0867, (ViewGroup) null, false).findViewById(R.id.obfuscated_res_0x7f0920e6);
                    TextView textView = (TextView) shadowLinearLayout.findViewById(R.id.obfuscated_res_0x7f0920e8);
                    TextView textView2 = (TextView) shadowLinearLayout.findViewById(R.id.obfuscated_res_0x7f0920e5);
                    TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) shadowLinearLayout.findViewById(R.id.obfuscated_res_0x7f0920e4);
                    String string2 = TbadkCoreApplication.getInst().getResources().getString(writeData.isQuestionThread() ? R.string.obfuscated_res_0x7f0f160a : R.string.obfuscated_res_0x7f0f1609);
                    if (writeData.isQuestionThread()) {
                        if (postWriteCallBackData.getInviteesNumberInt() < 50) {
                            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1605);
                        } else {
                            string = String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1604), postWriteCallBackData.getInviteesNumber());
                        }
                    } else {
                        string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1603);
                    }
                    textView.setText(string2);
                    textView2.setText(string);
                    tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1149));
                    tBSpecificationBtn.setConfig(new by4());
                    SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0302);
                    SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0302);
                    tBSpecificationBtn.k();
                    shadowLinearLayout.b();
                    tBSpecificationBtn.setOnClickListener(new a(this, currentActivity, navigationBarCoverTip2, g3, g2));
                    navigationBarCoverTip2.setBackgroundColor(0);
                    navigationBarCoverTip2.n(currentActivity, shadowLinearLayout, 5000);
                    so8.a(true, false);
                    qo8.a("发帖-成功： 成功弹框 -- 成功 -- end");
                    return;
                }
                qo8.a("发帖-成功： 成功弹框 -- 失败 -- postId = " + g2 + "  threadId = " + g3);
            }
        }
    }

    public void q(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, postWriteCallBackData) == null) {
            qo8.a("发帖-成功-视频： 成功弹框 -- start");
            if (postWriteCallBackData == null) {
                return;
            }
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity == null) {
                qo8.a("发帖-成功-视频： 成功弹框 -- 失败 -- 当前Activity为NULL");
                return;
            }
            FrameLayout frameLayout = (FrameLayout) currentActivity.findViewById(16908290);
            if (frameLayout == null) {
                qo8.a("发帖-成功-视频： 成功弹框 -- 失败 -- 当前Activity的content为NULL");
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
            ShadowLinearLayout shadowLinearLayout = (ShadowLinearLayout) LayoutInflater.from(currentActivity).inflate(R.layout.obfuscated_res_0x7f0d0868, (ViewGroup) null, false).findViewById(R.id.obfuscated_res_0x7f0920e6);
            TextView textView = (TextView) shadowLinearLayout.findViewById(R.id.obfuscated_res_0x7f0920e8);
            textView.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f160b));
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0302);
            shadowLinearLayout.b();
            navigationBarCoverTip.setBackgroundColor(0);
            navigationBarCoverTip.n(currentActivity, shadowLinearLayout, 5000);
            so8.a(true, true);
            qo8.a("发帖-成功-视频： 成功弹框 -- 成功 -- end");
        }
    }
}
