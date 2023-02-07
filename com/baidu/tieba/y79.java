package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.ShareFriendActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.message.UserGrowthTaskRequestMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.nu5;
import com.baidu.tieba.sharesdk.view.ShareDialogItemView;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.baidu.tieba.transmitShare.ShareScrollableLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
/* loaded from: classes7.dex */
public class y79 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int x;
    public static final int y;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public ArrayList<TransmitForumData> b;
    public Context c;
    public View d;
    public x79 e;
    public ShareItem f;
    public w79 g;
    public View.OnClickListener h;
    public View.OnClickListener i;
    public View.OnClickListener j;
    public boolean k;
    public nu5 l;
    public a89 m;
    public String n;
    public boolean o;
    public boolean p;
    public String q;
    @NonNull
    public yg5 r;
    @Nullable
    public xg5 s;
    public List<MetaData> t;
    public final xn7 u;
    public CustomMessageListener v;
    public nu5.b w;

    public final boolean q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) ? i == 4 || i == 3 || i == 9 || i == 5 || i == 7 || i == 10 : invokeI.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class a implements nu5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y79 a;

        public a(y79 y79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y79Var;
        }

        @Override // com.baidu.tieba.nu5.b
        public void a(boolean z) {
            ShareDialogItemView shareDialogItemView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (shareDialogItemView = (ShareDialogItemView) this.a.d.findViewWithTag(16)) != null) {
                if (z) {
                    i = R.drawable.obfuscated_res_0x7f080a2d;
                } else {
                    i = R.drawable.obfuscated_res_0x7f080a2c;
                }
                shareDialogItemView.c(i, SkinManager.getColor(R.color.CAM_X0107));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<y79> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(y79 y79Var) {
            super(2016563);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(y79Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            y79 y79Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || (y79Var = this.a.get()) == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ArrayList)) {
                return;
            }
            y79Var.b = (ArrayList) customResponsedMessage.getData();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948283214, "Lcom/baidu/tieba/y79;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948283214, "Lcom/baidu/tieba/y79;");
                return;
            }
        }
        x = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds202);
        y = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds239);
    }

    @NonNull
    public final TbPageContext l() {
        InterceptResult invokeV;
        TbPageContext<BaseFragmentActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            Context context = this.c;
            if (context instanceof BaseActivity) {
                tbPageContext = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                tbPageContext = ((BaseFragmentActivity) context).getPageContext();
            } else {
                tbPageContext = null;
            }
            return (TbPageContext) Objects.requireNonNull(tbPageContext);
        }
        return (TbPageContext) invokeV.objValue;
    }

    public y79(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = false;
        this.r = (yg5) zf5.c(yg5.a);
        this.s = null;
        this.t = new ArrayList();
        this.u = new xn7();
        this.v = new b(this);
        this.w = new a(this);
        this.c = context;
        MessageManager.getInstance().registerListener(this.v);
    }

    public final BdUniqueId m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, context)) == null) {
            if (context instanceof BaseActivity) {
                return ((BaseActivity) context).getUniqueId();
            }
            if (context instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) context).getUniqueId();
            }
            return null;
        }
        return (BdUniqueId) invokeL.objValue;
    }

    public final void o(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048597, this, i) == null) && i == 13) {
            t();
            D(13);
        }
    }

    public void y(w79 w79Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, w79Var) == null) {
            this.g = w79Var;
        }
    }

    public final void F(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, objArr) == null) {
            TiebaStatic.eventStat(this.c, str, "click", 1, objArr);
        }
    }

    public final void H(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, str) == null) {
            TiebaStatic.eventStat(this.c, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
        }
    }

    public final void A(ShareDialogConfig shareDialogConfig, boolean z, int i, int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{shareDialogConfig, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            this.f = shareDialogConfig.shareItem;
            this.b = shareDialogConfig.mForumList;
            this.a = shareDialogConfig.mPrivateThread;
            this.h = shareDialogConfig.disLikeListener;
            this.i = shareDialogConfig.closeAdListener;
            this.j = shareDialogConfig.heatingListener;
            this.q = shareDialogConfig.topicId;
            this.e.removeAllViews();
            this.k = shareDialogConfig.mShowMoreForumShare;
            this.n = shareDialogConfig.getPrePage();
            this.o = shareDialogConfig.isMadeTop;
            this.p = shareDialogConfig.isAddedGood;
            if (this.k) {
                if (this.f.p) {
                    k(shareDialogConfig, i, i2);
                    f(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4, i2);
                    f(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3, i2);
                    f(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9, i2);
                    f(new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5, i2);
                    f(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7, i2);
                    c(R.string.obfuscated_res_0x7f0f0b93, R.drawable.icon_pure_share_moreba40, 13, i3);
                    return;
                }
                f(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4, i);
                f(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3, i);
                f(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9, i);
                f(new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5, i);
                f(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7, i);
                c(R.string.obfuscated_res_0x7f0f0b93, R.drawable.icon_pure_share_moreba40, 13, i);
                return;
            }
            if (this.f.o0) {
                k(shareDialogConfig, i, i2);
                g(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4, shareDialogConfig.isShowNovelMask(), i2);
                g(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3, shareDialogConfig.isShowNovelMask(), i2);
                g(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9, shareDialogConfig.isShowNovelMask(), i2);
                g(new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5, shareDialogConfig.isShowNovelMask(), i2);
                g(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7, shareDialogConfig.isShowNovelMask(), i2);
                if (!shareDialogConfig.isHideShareCopyLink) {
                    c(R.string.share_copy, R.drawable.icon_pure_share_copy40, 10, i3);
                }
            }
            boolean isPrePagePersonalPage = shareDialogConfig.isPrePagePersonalPage();
            boolean z2 = shareDialogConfig.isHost;
            if (shareDialogConfig.isFromImmersionVideo) {
                if (!isPrePagePersonalPage && r()) {
                    c(R.string.forum_shield, R.drawable.icon_pure_pb_shield40, 18, i3);
                }
                if (shareDialogConfig.isCollected) {
                    h(R.string.obfuscated_res_0x7f0f0b3c, R.drawable.obfuscated_res_0x7f080a2d, 0, 16, i3);
                } else {
                    c(R.string.obfuscated_res_0x7f0f0b3c, R.drawable.obfuscated_res_0x7f080a2c, 16, i3);
                }
                if (!z2) {
                    c(R.string.report_text, R.drawable.obfuscated_res_0x7f080a38, 17, i3);
                } else if (isPrePagePersonalPage) {
                    c(R.string.obfuscated_res_0x7f0f04d5, R.drawable.obfuscated_res_0x7f080a2f, 19, i3);
                }
            }
            if (shareDialogConfig.showDisLike && !isPrePagePersonalPage) {
                c(R.string.not_interested, R.drawable.icon_pure_share_unlike40, 14, i3);
            }
            if (this.f.p0) {
                c(R.string.close_ad, R.drawable.icon_pure_share_unlike40, 15, i3);
            }
            if (shareDialogConfig.showHeating) {
                if (shareDialogConfig.isSelfHeating) {
                    i4 = R.string.heating_thread;
                } else {
                    i4 = R.string.help_heating_thread;
                }
                c(i4, R.drawable.icon_pure_share_fire_40, 23, i3);
            }
            if (z) {
                c(R.string.obfuscated_res_0x7f0f0b93, R.drawable.icon_pure_share_moreba40, 13, i3);
            }
            if (shareDialogConfig.isFromImmersionVideo) {
                nu5 nu5Var = new nu5(this.c);
                this.l = nu5Var;
                nu5Var.i(this.w);
                this.l.g(shareDialogConfig.isCollected);
                this.l.h(j());
            }
        }
    }

    public final void B(ShareDialogConfig shareDialogConfig, boolean z, int i, int i2, boolean z2) {
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{shareDialogConfig, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            this.f = shareDialogConfig.shareItem;
            this.b = shareDialogConfig.mForumList;
            this.a = shareDialogConfig.mPrivateThread;
            this.h = shareDialogConfig.disLikeListener;
            this.i = shareDialogConfig.closeAdListener;
            this.j = shareDialogConfig.heatingListener;
            this.q = shareDialogConfig.topicId;
            this.e.removeAllViews();
            this.k = shareDialogConfig.mShowMoreForumShare;
            this.n = shareDialogConfig.getPrePage();
            this.o = shareDialogConfig.isMadeTop;
            this.p = shareDialogConfig.isAddedGood;
            if (this.k) {
                f(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4, i);
                f(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3, i);
                f(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9, i);
                f(new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5, i);
                f(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7, i);
                c(R.string.obfuscated_res_0x7f0f0b93, R.drawable.icon_pure_share_moreba40, 13, i);
                return;
            }
            if (this.f.o0) {
                if (z2 && TbadkCoreApplication.getCurrentAccount() != null) {
                    boolean isShowNovelMask = shareDialogConfig.isShowNovelMask();
                    i4 = R.drawable.icon_mask_share_wechat40_svg;
                    i5 = R.drawable.icon_mask_share_circle40_svg;
                    d(R.string.share_friend, R.drawable.icon_more_share2, 24, isShowNovelMask, i);
                } else {
                    i4 = R.drawable.icon_mask_share_wechat40_svg;
                    i5 = R.drawable.icon_mask_share_circle40_svg;
                }
                g(new SvgMaskType(i4), R.string.share_weixin, 4, shareDialogConfig.isShowNovelMask(), i);
                g(new SvgMaskType(i5), R.string.share_weixin_timeline, 3, shareDialogConfig.isShowNovelMask(), i);
                g(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9, shareDialogConfig.isShowNovelMask(), i);
                g(new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5, shareDialogConfig.isShowNovelMask(), i);
                g(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7, shareDialogConfig.isShowNovelMask(), i);
                if (!shareDialogConfig.isHideShareCopyLink) {
                    c(R.string.share_copy, R.drawable.icon_pure_share_copy40, 10, i2);
                }
            }
            boolean isPrePagePersonalPage = shareDialogConfig.isPrePagePersonalPage();
            boolean z3 = shareDialogConfig.isHost;
            if (shareDialogConfig.isFromImmersionVideo) {
                if (!isPrePagePersonalPage && r()) {
                    c(R.string.forum_shield, R.drawable.icon_pure_pb_shield40, 18, i2);
                }
                if (shareDialogConfig.isCollected) {
                    h(R.string.obfuscated_res_0x7f0f0b3c, R.drawable.obfuscated_res_0x7f080a2d, 0, 16, i2);
                } else {
                    c(R.string.obfuscated_res_0x7f0f0b3c, R.drawable.obfuscated_res_0x7f080a2c, 16, i2);
                }
                if (!z3) {
                    c(R.string.report_text, R.drawable.obfuscated_res_0x7f080a38, 17, i2);
                } else if (isPrePagePersonalPage) {
                    c(R.string.obfuscated_res_0x7f0f04d5, R.drawable.obfuscated_res_0x7f080a2f, 19, i2);
                }
            }
            if (shareDialogConfig.showDisLike && !isPrePagePersonalPage) {
                c(R.string.not_interested, R.drawable.icon_pure_share_unlike40, 14, i2);
            }
            if (this.f.p0) {
                c(R.string.close_ad, R.drawable.icon_pure_share_unlike40, 15, i2);
            }
            if (shareDialogConfig.showHeating) {
                if (shareDialogConfig.isSelfHeating) {
                    i3 = R.string.heating_thread;
                } else {
                    i3 = R.string.help_heating_thread;
                }
                c(i3, R.drawable.icon_pure_share_fire_40, 23, i2);
            }
            if (z) {
                c(R.string.obfuscated_res_0x7f0f0b93, R.drawable.icon_pure_share_moreba40, 13, i2);
            }
            if (shareDialogConfig.isFromImmersionVideo) {
                nu5 nu5Var = new nu5(this.c);
                this.l = nu5Var;
                nu5Var.i(this.w);
                this.l.g(shareDialogConfig.isCollected);
                this.l.h(j());
            }
        }
    }

    public final void C(@NonNull MetaData metaData, @NonNull GroupInfoData groupInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, metaData, groupInfoData) != null) || vl7.a(this.c)) {
            return;
        }
        Context context = this.c;
        en7 en7Var = new en7(context, new hn7(context));
        wn7.a(groupInfoData, metaData, 1);
        en7Var.j(groupInfoData, metaData);
        ao7.a("分享弹窗触发分享：分享成功");
        en7Var.k();
    }

    public final void E(@NonNull MetaData metaData, @NonNull ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, metaData, threadData) != null) || vl7.a(this.c)) {
            return;
        }
        Context context = this.c;
        en7 en7Var = new en7(context, new in7(context));
        w(metaData);
        en7Var.j(threadData, metaData);
        ao7.a("分享弹窗触发分享：分享成功");
        en7Var.k();
    }

    public final void D(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || this.f == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", this.f.N).param("tid", this.f.O).param("obj_type", i).param("obj_source", this.f.I).param("obj_param1", this.f.J).param(TiebaStatic.Params.OBJ_PARAM2, this.f.K));
        int i3 = this.f.R;
        int i4 = 0;
        int i5 = 2;
        if (i3 == 5) {
            i2 = 1;
        } else if (i3 == 6) {
            i2 = 2;
        } else if (i3 == 7) {
            i2 = 3;
        } else if (i3 == 8) {
            i2 = 4;
        } else {
            i2 = 0;
        }
        int i6 = this.f.I;
        if (i6 == 4) {
            i4 = 1;
        } else if (i6 == 3) {
            i4 = 2;
        } else if (i6 == 8) {
            i4 = 3;
        } else if (i6 == 6) {
            i4 = 4;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TRANSFER_BTN_CLICK);
        if (i != 11) {
            i5 = 1;
        }
        TiebaStatic.log(statisticItem.param("obj_locate", i5).param("obj_source", i4).param("obj_type", i2));
    }

    public final void w(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048606, this, metaData) != null) || metaData == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SHARE_NEARLY_PERSON);
        int i = 0;
        int i2 = this.f.I;
        if (i2 != 4 && i2 != 3 && i2 != 20 && i2 != 30) {
            if (i2 != 5 && i2 != 10 && i2 != 33) {
                if (i2 != 6 && i2 != 2) {
                    if (i2 == 8) {
                        i = 4;
                    } else if (i2 == 25 || i2 == 29 || i2 == 11 || i2 == 12) {
                        i = 5;
                    }
                } else {
                    i = 3;
                }
            } else {
                i = 2;
            }
        } else {
            i = 1;
        }
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_source", i);
        if (GroupInfoData.isValidGroup(metaData.groupData)) {
            statisticItem.addParam("room_id", metaData.groupData.getGroupId());
            statisticItem.addParam("fid", metaData.groupData.getForumId());
            statisticItem.addParam("fname", metaData.groupData.getForumName());
        } else {
            statisticItem.addParam(TiebaStatic.Params.FRIEND_UID, metaData.getUserId());
        }
        TiebaStatic.log(statisticItem);
    }

    public final void G(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, shareItem) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 7);
            int i = shareItem.J;
            if (i != 0) {
                param.param("obj_param1", i);
                int i2 = shareItem.J;
                if (i2 == 2) {
                    param.param("fid", shareItem.N);
                } else if (i2 == 3) {
                    int i3 = shareItem.R;
                    if (i3 != 0) {
                        param.param("obj_type", i3);
                    }
                    param.param("tid", shareItem.O).param("fid", shareItem.N);
                }
            }
            param.param("obj_locate", 9);
            TiebaStatic.log(param);
        }
    }

    public final void J(ShareItem shareItem, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, shareItem, i) != null) || shareItem == null) {
            return;
        }
        if (GroupInfoData.isValidGroup(shareItem.M0)) {
            wn7.a(shareItem.M0, null, i);
        } else if (shareItem.u == null) {
        } else {
            if (shareItem.b) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.u).param("obj_type", i).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.K));
            } else if (!shareItem.c && !shareItem.f) {
                if (shareItem.d) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.u).param("obj_type", i));
                } else if (shareItem.a) {
                    H(i, shareItem.G);
                } else if (shareItem.e) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i).param("fid", shareItem.u).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.K));
                } else if (shareItem.g) {
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i);
                    param.param("obj_source", shareItem.I);
                    param.param(TiebaStatic.Params.OBJ_PARAM2, shareItem.K);
                    TiebaStatic.log(param);
                }
            } else {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.u).param("obj_type", i).param("obj_source", shareItem.I).param("obj_param1", shareItem.J).param("fid", shareItem.N).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.K));
            }
        }
    }

    public final void c(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048585, this, i, i2, i3, i4) == null) {
            h(i, i2, SkinManager.getColor(R.color.CAM_X0107), i3, i4);
        }
    }

    public final void f(AbsSvgType absSvgType, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIII(1048588, this, absSvgType, i, i2, i3) != null) || absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.c);
        shareDialogItemView.setItemIcon(absSvgType, i2);
        shareDialogItemView.setItemName(i);
        shareDialogItemView.setOnClickListener(this);
        x79 x79Var = this.e;
        shareDialogItemView.a();
        x79Var.b(i3, shareDialogItemView);
    }

    public final void d(int i, int i2, int i3, boolean z, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.c);
            shareDialogItemView.setItemIcon(i2, 0, i3);
            shareDialogItemView.setItemName(i);
            shareDialogItemView.setOnClickListener(this);
            shareDialogItemView.a();
            MaskView.c(shareDialogItemView, z);
            this.e.b(i4, shareDialogItemView);
        }
    }

    public final void g(AbsSvgType absSvgType, int i, int i2, boolean z, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048589, this, new Object[]{absSvgType, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) != null) || absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.c);
        shareDialogItemView.setItemIcon(absSvgType, i2);
        shareDialogItemView.setItemName(i);
        shareDialogItemView.setOnClickListener(this);
        shareDialogItemView.a();
        MaskView.c(shareDialogItemView, z);
        this.e.b(i3, shareDialogItemView);
    }

    public final void h(int i, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.c);
            shareDialogItemView.setItemIcon(i2, i3, i4);
            shareDialogItemView.setItemName(i);
            shareDialogItemView.setOnClickListener(this);
            x79 x79Var = this.e;
            shareDialogItemView.a();
            x79Var.b(i5, shareDialogItemView);
        }
    }

    public final void e(@NonNull MetaData metaData, int i, boolean z, int i2) {
        String avater;
        String name_show;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{metaData, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.c);
            if (GroupInfoData.isValidGroup(metaData.groupData)) {
                avater = metaData.groupData.getPortrait();
                name_show = metaData.groupData.getName();
            } else {
                avater = metaData.getAvater();
                name_show = metaData.getName_show();
            }
            if (rp5.e(name_show) > 8) {
                name_show = rp5.m(name_show, 8) + StringHelper.STRING_MORE;
            }
            shareDialogItemView.setItemIcon(avater, i, metaData);
            shareDialogItemView.setItemName(name_show);
            shareDialogItemView.setOnClickListener(this);
            shareDialogItemView.setTag(R.id.obfuscated_res_0x7f0909e6, metaData);
            shareDialogItemView.a();
            MaskView.c(shareDialogItemView, z);
            this.e.b(i2, shareDialogItemView);
        }
    }

    @NonNull
    public xg5 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.s == null) {
                this.s = this.r.b(l());
            }
            return (xg5) Objects.requireNonNull(this.s);
        }
        return (xg5) invokeV.objValue;
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            ShareItem shareItem = this.f;
            if (shareItem == null || shareItem.K != 11) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.v);
        }
    }

    public MarkData j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.f.O);
            markData.setPostId(this.f.f0);
            markData.setTime(date.getTime());
            markData.setId(this.f.O);
            markData.setFloor(1);
            markData.setForumId(this.f.N);
            return markData;
        }
        return (MarkData) invokeV.objValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if ("frs".equals(this.n) && this.f != null) {
                if ((zr6.g() || s()) && zr6.d(zr6.a()) && StringHelper.equals(this.f.N, zr6.c())) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void k(ShareDialogConfig shareDialogConfig, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048593, this, shareDialogConfig, i, i2) == null) {
            int size = this.t.size();
            int i3 = 0;
            if (size < 10) {
                while (i3 < size) {
                    e(this.t.get(i3), 25, shareDialogConfig.isShowNovelMask(), i);
                    i3++;
                }
            } else {
                while (i3 < 10) {
                    e(this.t.get(i3), 25, shareDialogConfig.isShowNovelMask(), i);
                    i3++;
                }
            }
            this.e.a(i);
            if (size >= 10) {
                c(R.string.more_friend, R.drawable.icon_share_morefriends, 28, i);
            }
            d(R.string.share_friend, R.drawable.icon_more_share2, 24, shareDialogConfig.isShowNovelMask(), i2);
        }
    }

    public View n(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) {
            if (this.d == null) {
                if (z) {
                    this.e = new ShareScrollableLayout(this.c);
                } else {
                    this.e = new ShareGridLayout(this.c);
                }
                this.e.setItemParams(x, y);
                this.d = this.e.getView();
            }
            return this.d;
        }
        return (View) invokeZ.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        ThreadData threadData;
        View.OnClickListener onClickListener;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view2) == null) {
            w79 w79Var = this.g;
            if (w79Var != null) {
                w79Var.a(view2);
            }
            if (!(view2.getTag() instanceof Integer)) {
                return;
            }
            Integer num = (Integer) view2.getTag();
            if (!BdNetTypeUtil.isNetWorkAvailable() && num.intValue() != 10) {
                ej.P(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                return;
            }
            this.f.O0 = num.intValue();
            if (num.intValue() == 14) {
                View.OnClickListener onClickListener2 = this.h;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view2);
                }
            } else if (num.intValue() == 16) {
                if (!ViewHelper.checkUpIsLogin(this.c)) {
                    return;
                }
                if (this.l.f()) {
                    this.l.e();
                } else {
                    this.l.d();
                }
            } else if (num.intValue() == 17) {
                if (!ViewHelper.checkUpIsLogin(this.c)) {
                    return;
                }
                if (this.m == null && (runTask = MessageManager.getInstance().runTask(2921343, a89.class, this.c)) != null) {
                    this.m = (a89) runTask.getData();
                }
                a89 a89Var = this.m;
                if (a89Var != null) {
                    a89Var.b(m(this.c));
                    this.m.a(this.f.f0);
                }
            } else {
                if (num.intValue() == 18) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921607, Boolean.TRUE));
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_IMMERSION_VIDEO_SHARE_DIALOG_MUSK_CLiCK);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    ShareItem shareItem = this.f;
                    if (shareItem != null) {
                        statisticItem.param("tid", shareItem.O);
                        statisticItem.param("fid", this.f.N);
                        statisticItem.param("fname", this.f.t);
                    }
                    TiebaStatic.log(statisticItem);
                    StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("tid", this.f.O);
                    statisticItem2.param("fid", this.f.N);
                    statisticItem2.param("fname", this.f.t);
                    statisticItem2.param("obj_source", 4);
                    TiebaStatic.log(statisticItem2);
                } else if (num.intValue() == 19) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921607, Boolean.FALSE));
                } else if (num.intValue() == 20) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    ShareItem shareItem2 = this.f;
                    String str = shareItem2.h0;
                    String str2 = shareItem2.i0;
                    String str3 = shareItem2.f0;
                    String str4 = shareItem2.g0;
                    Context context = this.c;
                    ShareItem shareItem3 = this.f;
                    new ForbidActivityConfig(context, shareItem3.N, shareItem3.t, shareItem3.O, currentAccount, str, str2, str3, str4).start();
                } else if (num.intValue() == 21) {
                    xg5 i = i();
                    ShareItem shareItem4 = this.f;
                    i.b(shareItem4.N, shareItem4.t, shareItem4.O, this.o);
                } else if (num.intValue() == 22) {
                    xg5 i2 = i();
                    ShareItem shareItem5 = this.f;
                    i2.a(shareItem5.N, shareItem5.t, shareItem5.O, this.p);
                } else if (num.intValue() == 23) {
                    if (ViewHelper.checkUpIsLogin(this.c) && (onClickListener = this.j) != null) {
                        onClickListener.onClick(view2);
                        return;
                    }
                    return;
                } else if (num.intValue() == 25) {
                    ao7.a("分享弹窗触发分享");
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f0909e6);
                    OriginalThreadInfo.ShareInfo shareInfo = this.f.a0;
                    if (shareInfo == null || (threadData = shareInfo.threadData) == null) {
                        threadData = null;
                    }
                    if (threadData == null) {
                        threadData = this.f.e0;
                    }
                    GroupInfoData groupInfoData = this.f.M0;
                    if (this.c != null && (tag instanceof MetaData)) {
                        if (threadData != null) {
                            E((MetaData) tag, threadData);
                        } else if (GroupInfoData.isValidGroup(groupInfoData)) {
                            C((MetaData) tag, groupInfoData);
                        } else {
                            ao7.a("分享弹窗触发分享：数据异常");
                        }
                    } else {
                        ao7.a("分享弹窗触发分享：数据异常");
                    }
                    w79 w79Var2 = this.g;
                    if (w79Var2 instanceof z79) {
                        ((z79) w79Var2).h();
                    }
                }
                if (num.intValue() == 14) {
                    View.OnClickListener onClickListener3 = this.h;
                    if (onClickListener3 != null) {
                        onClickListener3.onClick(view2);
                    }
                } else if (num.intValue() == 15) {
                    View.OnClickListener onClickListener4 = this.i;
                    if (onClickListener4 != null) {
                        onClickListener4.onClick(view2);
                    }
                } else {
                    if (num.intValue() == 24) {
                        u();
                        v();
                        wn7.a(this.f.M0, null, num.intValue());
                    }
                    if (num.intValue() == 28) {
                        u();
                        wn7.a(this.f.M0, null, num.intValue());
                    }
                    if (q(num.intValue())) {
                        p(num.intValue());
                    } else {
                        o(num.intValue());
                    }
                }
            }
        }
    }

    public final void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            ShareItem shareItem = this.f;
            if (shareItem != null && GroupInfoData.isValidGroup(shareItem.M0)) {
                Context context = this.c;
                ShareItem shareItem2 = this.f;
                ev8.b(context, shareItem2, shareItem2.M0, i);
            }
            g95 g95Var = new g95(this.c, null);
            ShareItem shareItem3 = this.f;
            boolean i2 = p35.m().i("key_person_growth_share_switch", false);
            if (!TbSingleton.getInstance().isUserGrowthTaskCompleted(UserGrowthTaskRequestMessage.SHARE_THREAD) && !i2 && !GroupInfoData.isValidGroup(this.f.M0)) {
                String userGrowthWeight = TbSingleton.getInstance().getUserGrowthWeight(UserGrowthTaskRequestMessage.SHARE_THREAD);
                if (!TextUtils.isEmpty(userGrowthWeight) && TbadkCoreApplication.getCurrentMemberType() > 0) {
                    try {
                        userGrowthWeight = (Integer.parseInt(userGrowthWeight) * 2) + "";
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                }
                shareItem3.B0 = userGrowthWeight;
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_VOICE_ROOM_SHARE);
            if (i == 4) {
                F("share_to_weixin", new Object[0]);
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, ThirdPartyUtil.TYPE_WEIXIN);
                J(shareItem3, 4);
                if (shareItem3 != null) {
                    g95Var.r(shareItem3);
                }
            } else if (i == 3) {
                F("share_to_pyq", new Object[0]);
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, "pyq");
                J(shareItem3, 3);
                if (shareItem3 != null) {
                    if (shareItem3.b) {
                        shareItem3.w = "【" + shareItem3.v + "】 " + shareItem3.w;
                    }
                    g95Var.s(shareItem3);
                }
            } else if (i == 9) {
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, LoginConstants.QQ_LOGIN);
                if (k09.b(this.c, "com.tencent.mobileqq")) {
                    F("share_to_qq_friend", new Object[0]);
                    J(shareItem3, 9);
                    if (shareItem3 != null) {
                        if (!StringUtils.isNull(shareItem3.v) && !StringUtils.isNull(shareItem3.w) && shareItem3.v.trim().equals(shareItem3.w.trim())) {
                            shareItem3.w = "";
                        }
                        g95Var.m(shareItem3);
                    }
                } else {
                    Context context2 = this.c;
                    BdToast.b(context2, context2.getText(R.string.share_qq_not_install)).k();
                }
            } else if (i == 5) {
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, "qqzone");
                if (k09.b(this.c, "com.tencent.mobileqq")) {
                    F("share_to_qzone", new Object[0]);
                    J(shareItem3, 5);
                    if (shareItem3 != null) {
                        if (!StringUtils.isNull(shareItem3.v) && !StringUtils.isNull(shareItem3.w) && shareItem3.v.trim().equals(shareItem3.w.trim())) {
                            shareItem3.w = "";
                        }
                        g95Var.n(shareItem3);
                    }
                } else {
                    Context context3 = this.c;
                    BdToast.b(context3, context3.getText(R.string.share_qq_not_install)).k();
                }
            } else if (i == 7) {
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, "weibo");
                try {
                    if (!WbSdk.isWbInstall(this.c)) {
                        WbSdk.install(this.c, new AuthInfo(this.c, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
                    }
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
                F("share_to_sweibo", new Object[0]);
                J(shareItem3, 7);
                if (shareItem3 != null) {
                    if (!shareItem3.a) {
                        if (!StringUtils.isNull(shareItem3.v) && !StringUtils.isNull(shareItem3.w) && shareItem3.v.trim().equals(shareItem3.w.trim())) {
                            shareItem3.w = "";
                        }
                        shareItem3.w = "【" + shareItem3.v + "】 " + shareItem3.w;
                    }
                    g95Var.p(shareItem3);
                }
            } else if (i == 10) {
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, "copylink");
                J(shareItem3, 10);
                String t = g95.t(shareItem3.x, shareItem3.O, UtilHelper.isVideoThread(shareItem3.R));
                shareItem3.x = t;
                ui.a(t);
                ej.Q(this.c.getApplicationContext(), this.c.getResources().getString(R.string.copy_pb_url_success));
                G(shareItem3);
                if (shareItem3 != null && shareItem3.a) {
                    H(8, shareItem3.G);
                }
            }
            if (shareItem3.I == 8 && shareItem3.b0 > 0) {
                statisticItem.param("obj_type", "2");
                statisticItem.param("room_id", shareItem3.b0);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.c, 25018);
            selectForumActivityConfig.setIsShare(true);
            selectForumActivityConfig.setForumList(this.b);
            if (this.k) {
                selectForumActivityConfig.setFrom(4);
                selectForumActivityConfig.setMoreForumImg(this.f.A);
                selectForumActivityConfig.setMoreForumUrl(this.f.x);
                selectForumActivityConfig.setMoreForumTitle(this.f.v);
            } else {
                selectForumActivityConfig.setFrom(2);
            }
            ShareItem.ForwardInfo forwardInfo = this.f.d0;
            if (forwardInfo != null) {
                selectForumActivityConfig.setBaijiahaoData(forwardInfo.baijiahaoData);
                selectForumActivityConfig.setTransmitOriginThreadComment(this.f.d0.transmitOriginThreadComment);
                selectForumActivityConfig.setTransmitThreadAuthorNameShow(this.f.d0.transmitThreadAuthorNameShow);
            }
            selectForumActivityConfig.setOriginalThread(this.f.a0);
            selectForumActivityConfig.setPrivateThread(this.a);
            if (!StringUtils.isNull(this.q)) {
                selectForumActivityConfig.setTopicId(this.q);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, selectForumActivityConfig));
        }
    }

    public final void u() {
        CustomResponsedMessage customResponsedMessage;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (GroupInfoData.isValidGroup(this.f.M0)) {
                customResponsedMessage = new CustomResponsedMessage(2921694, this.f.M0);
            } else {
                OriginalThreadInfo.ShareInfo shareInfo = this.f.a0;
                if (shareInfo != null && (threadData = shareInfo.threadData) != null) {
                    customResponsedMessage = new CustomResponsedMessage(2921694, threadData);
                } else {
                    customResponsedMessage = null;
                }
            }
            if (customResponsedMessage == null) {
                return;
            }
            MessageManager.getInstance().registerStickyMode(2921694);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            ShareFriendActivityConfig shareFriendActivityConfig = new ShareFriendActivityConfig(this.c);
            shareFriendActivityConfig.setIsForShare(true);
            shareFriendActivityConfig.setFilterGroup(this.f.N0);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, shareFriendActivityConfig));
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SHARE_FRIEND_BTN);
            int i = this.f.I;
            int i2 = 2;
            if (i != 4 && i != 3 && i != 20 && i != 30) {
                if (i != 5 && i != 10 && i != 33) {
                    i2 = (i == 6 || i == 2) ? 3 : i == 8 ? 4 : (i == 25 || i == 29 || i == 11 || i == 12) ? 5 : 0;
                }
            } else {
                i2 = 1;
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_source", i2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void z(@NonNull ShareDialogConfig shareDialogConfig, boolean z, boolean z2) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{shareDialogConfig, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            xn7 xn7Var = this.u;
            ShareItem shareItem = shareDialogConfig.shareItem;
            if (shareItem != null && !shareItem.N0) {
                z3 = true;
            } else {
                z3 = false;
            }
            List<MetaData> c = xn7Var.c(z3, true);
            this.t = c;
            if (c != null && c.size() != 0 && z2 && TbadkCoreApplication.getCurrentAccount() != null) {
                A(shareDialogConfig, z, 0, 1, 2);
            } else {
                B(shareDialogConfig, z, 0, 1, z2);
            }
        }
    }
}
