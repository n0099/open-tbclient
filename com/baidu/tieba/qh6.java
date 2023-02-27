package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
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
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes5.dex */
public class qh6 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBarCoverTip a;
    public ShadowLinearLayout b;
    public TextView c;
    public TextView d;
    public TBSpecificationBtn e;
    public e55 f;
    public long g;
    public long h;
    public ThreadData i;
    public Activity j;
    public TbPageContext k;
    public boolean l;
    public boolean m;
    public final wb n;

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 15;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class a extends wb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qh6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qh6 qh6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qh6Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = qh6Var;
        }

        @Override // com.baidu.tieba.wb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.g();
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    this.a.f(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    this.a.f(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
                }
            }
        }
    }

    public qh6(TbPageContext tbPageContext, NavigationBarCoverTip navigationBarCoverTip) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBarCoverTip};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = false;
        this.m = false;
        this.n = new a(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.j = tbPageContext.getPageActivity();
        this.k = tbPageContext;
        this.a = navigationBarCoverTip;
        this.n.setTag(tbPageContext.getUniqueId());
        this.n.getHttpMessageListener().setSelfListener(true);
        this.n.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.n);
    }

    public final int e(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData)) == null) {
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

    public final String c(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
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

    public final void f(int i, GetMyPostResIdl getMyPostResIdl) {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, getMyPostResIdl) == null) {
            if (i == 0 && getMyPostResIdl != null && (dataRes = getMyPostResIdl.data) != null && dataRes.thread_info != null) {
                ThreadData threadData = new ThreadData();
                this.i = threadData;
                threadData.parserProtobuf(getMyPostResIdl.data.thread_info);
                k();
                return;
            }
            this.k.showToast(R.string.obfuscated_res_0x7f0f0d11);
        }
    }

    public final void g() {
        e55 e55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (e55Var = this.f) != null) {
            e55Var.h(false);
        }
    }

    public void h() {
        NavigationBarCoverTip navigationBarCoverTip;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (navigationBarCoverTip = this.a) != null) {
            navigationBarCoverTip.i();
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f == null) {
                this.f = new e55(this.k);
            }
            this.f.h(true);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem.param("tid", this.h);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_locate", 7);
            if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void k() {
        ThreadData threadData;
        Uri parse;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (threadData = this.i) != null && this.j != null) {
            String valueOf = String.valueOf(threadData.getFid());
            String forum_name = this.i.getForum_name();
            String title = this.i.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.i.getAbstract();
            }
            String tid = this.i.getTid();
            String str = TbConfig.HTTPS_PB_PREFIX + tid + "?share=9105&fr=share";
            String c = c(this.i);
            if (c == null) {
                parse = null;
            } else {
                parse = Uri.parse(c);
            }
            String str2 = this.i.getAbstract();
            String format = MessageFormat.format(this.j.getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.v = title;
            shareItem.w = format;
            shareItem.W = 0L;
            shareItem.H = str2;
            shareItem.x = str;
            shareItem.s = 5;
            shareItem.u = tid;
            shareItem.J = 3;
            shareItem.N = valueOf;
            shareItem.t = forum_name;
            shareItem.O = tid;
            shareItem.f = true;
            shareItem.I = d();
            shareItem.R = e(this.i);
            if (parse != null) {
                shareItem.z = parse;
            }
            shareItem.a0 = OriginalThreadInfo.ShareInfo.generateShareInfo(this.i);
            shareItem.d0 = ShareItem.ForwardInfo.generateForwardInfo(this.i);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.t0 = this.i.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.J);
            bundle.putInt("obj_type", shareItem.R);
            bundle.putString("fid", shareItem.N);
            bundle.putString("tid", shareItem.O);
            bundle.putInt("obj_source", shareItem.s);
            shareItem.l(bundle);
            oh6.c().l(new ShareDialogConfig((Context) this.j, shareItem, true, true));
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, postWriteCallBackData) == null) && postWriteCallBackData != null && this.a != null) {
            this.g = dh.g(postWriteCallBackData.getPostId(), 0L);
            long g = dh.g(postWriteCallBackData.getThreadId(), 0L);
            this.h = g;
            if (this.g != 0 && g != 0) {
                this.m = false;
                if (this.b == null) {
                    ShadowLinearLayout shadowLinearLayout = (ShadowLinearLayout) LayoutInflater.from(this.j).inflate(R.layout.tb_top_toast_layout, (ViewGroup) null, false).findViewById(R.id.tb_top_toast_group);
                    this.b = shadowLinearLayout;
                    this.c = (TextView) shadowLinearLayout.findViewById(R.id.tb_top_toast_title);
                    this.d = (TextView) this.b.findViewById(R.id.tb_top_toast_content);
                    this.e = (TBSpecificationBtn) this.b.findViewById(R.id.tb_top_toast_btn);
                    this.c.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_title));
                    this.d.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_content));
                    this.e.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.share_at_once));
                    this.e.setConfig(new y55());
                }
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0302);
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0302);
                this.e.k();
                this.b.b();
                this.e.setOnClickListener(this);
                this.a.setBackgroundColor(0);
                this.a.n(this.j, this.b, 5000);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, view2) != null) || this.m) {
            return;
        }
        this.m = true;
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.k.showToast(R.string.obfuscated_res_0x7f0f0d11);
            this.a.e();
            return;
        }
        int l = ej.l(TbadkCoreApplication.getInst());
        int j = ej.j(TbadkCoreApplication.getInst());
        float f = this.j.getResources().getDisplayMetrics().density;
        if (TbImageHelper.getInstance().isShowBigImage()) {
            i = 2;
        } else {
            i = 1;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setTag(this.k.getUniqueId());
        requestGetMyPostNetMessage.setParams(this.h, this.g, 0L, l, j, f, i);
        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        j();
        this.a.e();
        i();
    }
}
