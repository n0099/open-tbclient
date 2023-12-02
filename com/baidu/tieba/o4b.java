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
import com.baidu.adp.lib.util.AndroidUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
import com.baidu.tieba.g06;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.ShareIMCommonCardData;
import com.baidu.tieba.sharesdk.ShareHandlerActivity;
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
public class o4b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int x;
    public static final int y;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public ArrayList<TransmitForumData> b;
    public Context c;
    public View d;
    public n4b e;
    public ShareItem f;
    public m4b g;
    public View.OnClickListener h;
    public View.OnClickListener i;
    public View.OnClickListener j;
    public boolean k;
    public g06 l;
    public q4b m;
    public String n;
    public boolean o;
    public boolean p;
    public String q;
    @NonNull
    public im5 r;
    @Nullable
    public hm5 s;
    public List<MetaData> t;
    public final oz8 u;
    public CustomMessageListener v;
    public g06.b w;

    public final boolean r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) ? i == 4 || i == 3 || i == 9 || i == 5 || i == 7 || i == 10 : invokeI.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class a implements g06.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o4b a;

        public a(o4b o4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o4bVar;
        }

        @Override // com.baidu.tieba.g06.b
        public void a(boolean z) {
            ShareDialogItemView shareDialogItemView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (shareDialogItemView = (ShareDialogItemView) this.a.d.findViewWithTag(16)) != null) {
                if (z) {
                    i = R.drawable.obfuscated_res_0x7f080c15;
                } else {
                    i = R.drawable.obfuscated_res_0x7f080c14;
                }
                shareDialogItemView.c(i, SkinManager.getColor(R.color.CAM_X0107));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<o4b> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(o4b o4bVar) {
            super(2016563);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o4bVar};
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
            this.a = new WeakReference<>(o4bVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            o4b o4bVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || (o4bVar = this.a.get()) == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ArrayList)) {
                return;
            }
            o4bVar.b = (ArrayList) customResponsedMessage.getData();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947983692, "Lcom/baidu/tieba/o4b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947983692, "Lcom/baidu/tieba/o4b;");
                return;
            }
        }
        x = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds202);
        y = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds239);
    }

    @NonNull
    public final TbPageContext l() {
        InterceptResult invokeV;
        TbPageContext<BaseFragmentActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
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

    public o4b(Context context) {
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
        this.r = (im5) qk5.c(im5.a);
        this.s = null;
        this.t = new ArrayList();
        this.u = new oz8();
        this.v = new b(this);
        this.w = new a(this);
        this.c = context;
        MessageManager.getInstance().registerListener(this.v);
    }

    public void B(m4b m4bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m4bVar) == null) {
            this.g = m4bVar;
        }
    }

    public final BdUniqueId n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, context)) == null) {
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

    public final void p(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048603, this, i) == null) && i == 13) {
            u();
            H(13);
        }
    }

    public final void J(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, objArr) == null) {
            TiebaStatic.eventStat(this.c, str, "click", 1, objArr);
        }
    }

    public final void L(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i, str) == null) {
            TiebaStatic.eventStat(this.c, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
        }
    }

    public final void M(ShareItem shareItem, int i) {
        ShareIMCommonCardData shareIMCommonCardData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048588, this, shareItem, i) == null) && shareItem != null && (shareIMCommonCardData = shareItem.mShareCommonInfoData) != null) {
            mz8.a(shareIMCommonCardData, i);
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.v);
        }
    }

    @NonNull
    public hm5 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.s == null) {
                this.s = this.r.b(l());
            }
            return (hm5) Objects.requireNonNull(this.s);
        }
        return (hm5) invokeV.objValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            ShareItem shareItem = this.f;
            if (shareItem == null || shareItem.objParam2 != 11) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void C(@NonNull ShareDialogConfig shareDialogConfig, boolean z, boolean z2) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{shareDialogConfig, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ShareItem shareItem = shareDialogConfig.shareItem;
            boolean z4 = true;
            boolean z5 = false;
            if (shareItem != null && !shareItem.isFilterRooms()) {
                z3 = true;
            } else {
                z3 = false;
            }
            ShareItem shareItem2 = shareDialogConfig.shareItem;
            if (shareItem2 != null && shareItem2.isFilterPerson()) {
                z4 = false;
            } else {
                z5 = true;
            }
            List<MetaData> d = this.u.d(z3, z4, z5);
            this.t = d;
            if (d != null && d.size() != 0 && z2 && TbadkCoreApplication.getCurrentAccount() != null) {
                D(shareDialogConfig, z, 0, 1, 2);
            } else {
                E(shareDialogConfig, z, 0, 1, z2);
            }
        }
    }

    public final void k(ShareDialogConfig shareDialogConfig, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048598, this, shareDialogConfig, i, i2) == null) {
            int size = this.t.size();
            int i3 = 0;
            if (size < 10) {
                while (i3 < size) {
                    e(this.t.get(i3), 25, shareDialogConfig.isShowMask(), shareDialogConfig.getDisableShareToast(), i);
                    i3++;
                }
            } else {
                while (i3 < 10) {
                    e(this.t.get(i3), 25, shareDialogConfig.isShowMask(), shareDialogConfig.getDisableShareToast(), i);
                    i3++;
                }
            }
            this.e.a(i);
            if (size >= 10) {
                c(R.string.more_friend, R.drawable.icon_share_morefriends, 28, i);
            }
            d(R.string.share_friend, R.drawable.icon_more_share2, 24, shareDialogConfig.isShowMask(), shareDialogConfig.getDisableShareToast(), i2);
        }
    }

    public final void D(ShareDialogConfig shareDialogConfig, boolean z, int i, int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{shareDialogConfig, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
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
                if (this.f.isDirectFromWeb) {
                    k(shareDialogConfig, i, i2);
                    f(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4, i2);
                    f(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3, i2);
                    f(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9, i2);
                    f(new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5, i2);
                    f(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7, i2);
                    c(R.string.obfuscated_res_0x7f0f0ce2, R.drawable.icon_pure_share_moreba40, 13, i3);
                    return;
                }
                f(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4, i);
                f(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3, i);
                f(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9, i);
                f(new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5, i);
                f(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7, i);
                c(R.string.obfuscated_res_0x7f0f0ce2, R.drawable.icon_pure_share_moreba40, 13, i);
                return;
            }
            if (this.f.isShowShareOuerItem) {
                k(shareDialogConfig, i, i2);
                g(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4, shareDialogConfig.isShowMask(), shareDialogConfig.getDisableShareToast(), i2);
                g(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3, shareDialogConfig.isShowMask(), shareDialogConfig.getDisableShareToast(), i2);
                g(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9, shareDialogConfig.isShowMask(), shareDialogConfig.getDisableShareToast(), i2);
                g(new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5, shareDialogConfig.isShowMask(), shareDialogConfig.getDisableShareToast(), i2);
                g(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7, shareDialogConfig.isShowMask(), shareDialogConfig.getDisableShareToast(), i2);
                if (!shareDialogConfig.isHideShareCopyLink) {
                    c(R.string.share_copy, R.drawable.icon_pure_share_copy40, 10, i3);
                }
            }
            boolean isPrePagePersonalPage = shareDialogConfig.isPrePagePersonalPage();
            boolean z2 = shareDialogConfig.isHost;
            if (shareDialogConfig.isFromImmersionVideo) {
                if (!isPrePagePersonalPage && s()) {
                    c(R.string.forum_shield, R.drawable.icon_pure_pb_shield40, 18, i3);
                }
                if (shareDialogConfig.isCollected) {
                    h(R.string.obfuscated_res_0x7f0f0c89, R.drawable.obfuscated_res_0x7f080c15, 0, 16, i3);
                } else {
                    c(R.string.obfuscated_res_0x7f0f0c89, R.drawable.obfuscated_res_0x7f080c14, 16, i3);
                }
                if (!z2) {
                    c(R.string.report_text, R.drawable.obfuscated_res_0x7f080c20, 17, i3);
                } else if (isPrePagePersonalPage) {
                    c(R.string.obfuscated_res_0x7f0f055b, R.drawable.obfuscated_res_0x7f080c17, 19, i3);
                }
            }
            if (shareDialogConfig.showDisLike && !isPrePagePersonalPage) {
                c(R.string.not_interested, R.drawable.icon_pure_share_unlike40, 14, i3);
            }
            if (this.f.isVideoAdShare) {
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
                c(R.string.obfuscated_res_0x7f0f0ce2, R.drawable.icon_pure_share_moreba40, 13, i3);
            }
            if (shareDialogConfig.isFromImmersionVideo) {
                g06 g06Var = new g06(this.c);
                this.l = g06Var;
                g06Var.i(this.w);
                this.l.g(shareDialogConfig.isCollected);
                this.l.h(j());
            }
        }
    }

    public final void E(ShareDialogConfig shareDialogConfig, boolean z, int i, int i2, boolean z2) {
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{shareDialogConfig, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
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
                c(R.string.obfuscated_res_0x7f0f0ce2, R.drawable.icon_pure_share_moreba40, 13, i);
                return;
            }
            if (this.f.isShowShareOuerItem) {
                if (z2 && TbadkCoreApplication.getCurrentAccount() != null) {
                    boolean isShowMask = shareDialogConfig.isShowMask();
                    String disableShareToast = shareDialogConfig.getDisableShareToast();
                    i4 = R.drawable.icon_mask_share_wechat40_svg;
                    i5 = R.drawable.icon_mask_share_circle40_svg;
                    i6 = R.drawable.icon_mask_share_qq40_svg;
                    d(R.string.share_friend, R.drawable.icon_more_share2, 24, isShowMask, disableShareToast, i);
                } else {
                    i4 = R.drawable.icon_mask_share_wechat40_svg;
                    i5 = R.drawable.icon_mask_share_circle40_svg;
                    i6 = R.drawable.icon_mask_share_qq40_svg;
                }
                g(new SvgMaskType(i4), R.string.share_weixin, 4, shareDialogConfig.isShowMask(), shareDialogConfig.getDisableShareToast(), i);
                g(new SvgMaskType(i5), R.string.share_weixin_timeline, 3, shareDialogConfig.isShowMask(), shareDialogConfig.getDisableShareToast(), i);
                g(new SvgMaskType(i6), R.string.share_qq_friends, 9, shareDialogConfig.isShowMask(), shareDialogConfig.getDisableShareToast(), i);
                g(new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5, shareDialogConfig.isShowMask(), shareDialogConfig.getDisableShareToast(), i);
                g(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7, shareDialogConfig.isShowMask(), shareDialogConfig.getDisableShareToast(), i);
                if (!shareDialogConfig.isHideShareCopyLink) {
                    c(R.string.share_copy, R.drawable.icon_pure_share_copy40, 10, i2);
                }
            }
            boolean isPrePagePersonalPage = shareDialogConfig.isPrePagePersonalPage();
            boolean z3 = shareDialogConfig.isHost;
            if (shareDialogConfig.isFromImmersionVideo) {
                if (!isPrePagePersonalPage && s()) {
                    c(R.string.forum_shield, R.drawable.icon_pure_pb_shield40, 18, i2);
                }
                if (shareDialogConfig.isCollected) {
                    h(R.string.obfuscated_res_0x7f0f0c89, R.drawable.obfuscated_res_0x7f080c15, 0, 16, i2);
                } else {
                    c(R.string.obfuscated_res_0x7f0f0c89, R.drawable.obfuscated_res_0x7f080c14, 16, i2);
                }
                if (!z3) {
                    c(R.string.report_text, R.drawable.obfuscated_res_0x7f080c20, 17, i2);
                } else if (isPrePagePersonalPage) {
                    c(R.string.obfuscated_res_0x7f0f055b, R.drawable.obfuscated_res_0x7f080c17, 19, i2);
                }
            }
            if (shareDialogConfig.showDisLike && !isPrePagePersonalPage) {
                c(R.string.not_interested, R.drawable.icon_pure_share_unlike40, 14, i2);
            }
            if (this.f.isVideoAdShare) {
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
                c(R.string.obfuscated_res_0x7f0f0ce2, R.drawable.icon_pure_share_moreba40, 13, i2);
            }
            if (shareDialogConfig.isFromImmersionVideo) {
                g06 g06Var = new g06(this.c);
                this.l = g06Var;
                g06Var.i(this.w);
                this.l.g(shareDialogConfig.isCollected);
                this.l.h(j());
            }
        }
    }

    public final void F(@NonNull MetaData metaData, @NonNull ShareIMCommonCardData shareIMCommonCardData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048581, this, metaData, shareIMCommonCardData) != null) || cw8.a(this.c)) {
            return;
        }
        Context context = this.c;
        lx8 lx8Var = new lx8(context, new nx8(context));
        lx8Var.j(shareIMCommonCardData, metaData);
        rz8.a("合辑、话题分享弹窗触发分享：分享成功");
        if (metaData.groupData != null) {
            mz8.a(shareIMCommonCardData, 2);
        } else if (!TextUtils.isEmpty(metaData.getUserId())) {
            mz8.a(shareIMCommonCardData, 1);
        }
        lx8Var.k();
    }

    public final void G(@NonNull MetaData metaData, @NonNull GroupInfoData groupInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048582, this, metaData, groupInfoData) != null) || cw8.a(this.c)) {
            return;
        }
        Context context = this.c;
        lx8 lx8Var = new lx8(context, new px8(context));
        nz8.a(groupInfoData, metaData, 1);
        lx8Var.j(groupInfoData, metaData);
        rz8.a("群组分享弹窗触发分享：分享成功");
        lx8Var.k();
    }

    public final void I(@NonNull MetaData metaData, @NonNull ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, metaData, threadData) != null) || cw8.a(this.c)) {
            return;
        }
        Context context = this.c;
        lx8 lx8Var = new lx8(context, new qx8(context));
        z(metaData);
        lx8Var.j(threadData, metaData);
        rz8.a("帖子分享弹窗触发分享：分享成功");
        lx8Var.k();
    }

    public final void H(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048583, this, i) != null) || this.f == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", this.f.fid).param("tid", this.f.tid).param("obj_type", i).param("obj_source", this.f.objSource).param("obj_param1", this.f.objParam1).param(TiebaStatic.Params.OBJ_PARAM2, this.f.objParam2));
        int i3 = this.f.obj_type;
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
        int i6 = this.f.objSource;
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

    public final void z(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048611, this, metaData) != null) || metaData == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SHARE_NEARLY_PERSON);
        int i = 0;
        int i2 = this.f.objSource;
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

    public final void K(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, shareItem) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 7);
            int i = shareItem.objParam1;
            if (i != 0) {
                param.param("obj_param1", i);
                int i2 = shareItem.objParam1;
                if (i2 == 2) {
                    param.param("fid", shareItem.fid);
                } else if (i2 == 3) {
                    int i3 = shareItem.obj_type;
                    if (i3 != 0) {
                        param.param("obj_type", i3);
                    }
                    param.param("tid", shareItem.tid).param("fid", shareItem.fid);
                }
            }
            param.param("obj_locate", 9);
            TiebaStatic.log(param);
        }
    }

    public final void N(ShareItem shareItem, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048589, this, shareItem, i) != null) || shareItem == null) {
            return;
        }
        if (GroupInfoData.isValidGroup(shareItem.groupData)) {
            nz8.a(shareItem.groupData, null, i);
        } else if (shareItem.extData == null) {
        } else {
            if (shareItem.isFromShareFrs) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.extData).param("obj_type", i).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.objParam2));
            } else if (!shareItem.isFromSharePb && !shareItem.isFromFeed) {
                if (shareItem.isFromPhotoLive) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.extData).param("obj_type", i));
                } else if (shareItem.isFromChosenPb) {
                    L(i, shareItem.ftid);
                } else if (shareItem.isFromAcrossForum) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i).param("fid", shareItem.extData).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.objParam2));
                } else if (shareItem.isFromWebActivity) {
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i);
                    param.param("obj_source", shareItem.objSource);
                    param.param(TiebaStatic.Params.OBJ_PARAM2, shareItem.objParam2);
                    TiebaStatic.log(param);
                }
            } else {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.extData).param("obj_type", i).param("obj_source", shareItem.objSource).param("obj_param1", shareItem.objParam1).param("fid", shareItem.fid).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.objParam2));
            }
        }
    }

    public final void c(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048590, this, i, i2, i3, i4) == null) {
            h(i, i2, SkinManager.getColor(R.color.CAM_X0107), i3, i4);
        }
    }

    public final void f(AbsSvgType absSvgType, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIII(1048593, this, absSvgType, i, i2, i3) != null) || absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.c);
        shareDialogItemView.setItemIcon(absSvgType, i2);
        shareDialogItemView.setItemName(i);
        shareDialogItemView.setOnClickListener(this);
        n4b n4bVar = this.e;
        shareDialogItemView.a();
        n4bVar.b(i3, shareDialogItemView);
    }

    public final void d(int i, int i2, int i3, boolean z, String str, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), str, Integer.valueOf(i4)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.c);
            shareDialogItemView.setItemIcon(i2, 0, i3);
            shareDialogItemView.setItemName(i);
            shareDialogItemView.setOnClickListener(this);
            shareDialogItemView.a();
            MaskView.e(shareDialogItemView, z, str);
            this.e.b(i4, shareDialogItemView);
        }
    }

    public final void g(AbsSvgType absSvgType, int i, int i2, boolean z, String str, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048594, this, new Object[]{absSvgType, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str, Integer.valueOf(i3)}) != null) || absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.c);
        shareDialogItemView.setItemIcon(absSvgType, i2);
        shareDialogItemView.setItemName(i);
        shareDialogItemView.setOnClickListener(this);
        shareDialogItemView.a();
        MaskView.e(shareDialogItemView, z, str);
        this.e.b(i3, shareDialogItemView);
    }

    public final void e(@NonNull MetaData metaData, int i, boolean z, String str, int i2) {
        String avater;
        String name_show;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{metaData, Integer.valueOf(i), Boolean.valueOf(z), str, Integer.valueOf(i2)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.c);
            if (GroupInfoData.isValidGroup(metaData.groupData)) {
                avater = metaData.groupData.getPortrait();
                name_show = metaData.groupData.getName();
            } else {
                avater = metaData.getAvater();
                name_show = metaData.getName_show();
            }
            if (uu5.e(name_show) > 8) {
                name_show = uu5.m(name_show, 8) + "...";
            }
            shareDialogItemView.setItemIcon(avater, i, metaData);
            shareDialogItemView.setItemName(name_show);
            shareDialogItemView.setOnClickListener(this);
            shareDialogItemView.setTag(R.id.obfuscated_res_0x7f090b13, metaData);
            shareDialogItemView.a();
            MaskView.e(shareDialogItemView, z, str);
            this.e.b(i2, shareDialogItemView);
        }
    }

    public final void h(int i, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.c);
            shareDialogItemView.setItemIcon(i2, i3, i4);
            shareDialogItemView.setItemName(i);
            shareDialogItemView.setOnClickListener(this);
            n4b n4bVar = this.e;
            shareDialogItemView.a();
            n4bVar.b(i5, shareDialogItemView);
        }
    }

    public MarkData j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.f.tid);
            markData.setPostId(this.f.pid);
            markData.setTime(date.getTime());
            markData.setId(this.f.tid);
            markData.setFloor(1);
            markData.setForumId(this.f.fid);
            return markData;
        }
        return (MarkData) invokeV.objValue;
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if ("frs".equals(this.n) && this.f != null) {
                if ((fs7.g() || t()) && fs7.d(fs7.a()) && StringHelper.equals(this.f.fid, fs7.c())) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public View o(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048601, this, z)) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048602, this, view2) == null) {
            m4b m4bVar = this.g;
            if (m4bVar != null) {
                m4bVar.a(view2);
            }
            if (!(view2.getTag() instanceof Integer)) {
                return;
            }
            Integer num = (Integer) view2.getTag();
            if (!BdNetTypeUtil.isNetWorkAvailable() && num.intValue() != 10) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                return;
            }
            this.f.shareMediaType = num.intValue();
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
                if (this.m == null && (runTask = MessageManager.getInstance().runTask(2921343, q4b.class, this.c)) != null) {
                    this.m = (q4b) runTask.getData();
                }
                q4b q4bVar = this.m;
                if (q4bVar != null) {
                    q4bVar.b(n(this.c));
                    this.m.a(this.f.pid);
                }
            } else {
                if (num.intValue() == 18) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921607, Boolean.TRUE));
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_IMMERSION_VIDEO_SHARE_DIALOG_MUSK_CLiCK);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    ShareItem shareItem = this.f;
                    if (shareItem != null) {
                        statisticItem.param("tid", shareItem.tid);
                        statisticItem.param("fid", this.f.fid);
                        statisticItem.param("fname", this.f.fName);
                    }
                    TiebaStatic.log(statisticItem);
                    StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("tid", this.f.tid);
                    statisticItem2.param("fid", this.f.fid);
                    statisticItem2.param("fname", this.f.fName);
                    statisticItem2.param("obj_source", 4);
                    TiebaStatic.log(statisticItem2);
                } else if (num.intValue() == 19) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921607, Boolean.FALSE));
                } else if (num.intValue() == 20) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    ShareItem shareItem2 = this.f;
                    String str = shareItem2.userName;
                    String str2 = shareItem2.userShowName;
                    String str3 = shareItem2.pid;
                    String str4 = shareItem2.portrait;
                    Context context = this.c;
                    ShareItem shareItem3 = this.f;
                    new ForbidActivityConfig(context, shareItem3.fid, shareItem3.fName, shareItem3.tid, currentAccount, str, str2, str3, str4).start();
                } else if (num.intValue() == 21) {
                    hm5 i = i();
                    ShareItem shareItem4 = this.f;
                    i.b(shareItem4.fid, shareItem4.fName, shareItem4.tid, this.o);
                } else if (num.intValue() == 22) {
                    hm5 i2 = i();
                    ShareItem shareItem5 = this.f;
                    i2.a(shareItem5.fid, shareItem5.fName, shareItem5.tid, this.p);
                } else if (num.intValue() == 23) {
                    if (ViewHelper.checkUpIsLogin(this.c) && (onClickListener = this.j) != null) {
                        onClickListener.onClick(view2);
                        return;
                    }
                    return;
                } else if (num.intValue() == 25) {
                    rz8.a("分享弹窗触发分享");
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f090b13);
                    OriginalThreadInfo.ShareInfo shareInfo = this.f.originalThreadInfo;
                    if (shareInfo == null || (threadData = shareInfo.threadData) == null) {
                        threadData = null;
                    }
                    if (threadData == null) {
                        threadData = this.f.threadData;
                    }
                    GroupInfoData groupInfoData = this.f.groupData;
                    if (this.c != null && (tag instanceof MetaData)) {
                        if (threadData != null) {
                            I((MetaData) tag, threadData);
                        } else if (GroupInfoData.isValidGroup(groupInfoData)) {
                            G((MetaData) tag, groupInfoData);
                        } else if (!this.f.isShareAlbum() && !this.f.isShareTopic() && !this.f.isShareActive()) {
                            rz8.a("分享弹窗触发分享：数据异常");
                        } else {
                            F((MetaData) tag, this.f.mShareCommonInfoData);
                        }
                    } else {
                        rz8.a("分享弹窗触发分享：数据异常");
                    }
                    m4b m4bVar2 = this.g;
                    if (m4bVar2 instanceof p4b) {
                        ((p4b) m4bVar2).i();
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
                        x();
                        y();
                        if (this.f.isShareGroup()) {
                            nz8.a(this.f.groupData, null, num.intValue());
                        }
                    }
                    if (num.intValue() == 28) {
                        x();
                        if (this.f.isShareGroup()) {
                            nz8.a(this.f.groupData, null, num.intValue());
                        }
                    }
                    if (r(num.intValue())) {
                        q(num.intValue());
                    } else {
                        p(num.intValue());
                    }
                }
            }
        }
    }

    public final void q(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            ShareItem shareItem = this.f;
            if (shareItem != null && GroupInfoData.isValidGroup(shareItem.groupData)) {
                Context context = this.c;
                ShareItem shareItem2 = this.f;
                koa.b(context, shareItem2, shareItem2.groupData, i);
            }
            kb5 kb5Var = new kb5(this.c, null);
            ShareItem shareItem3 = this.f;
            if (shareItem3 == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_VOICE_ROOM_SHARE);
            if (i == 4) {
                if (loa.a("wechat", shareItem3)) {
                    return;
                }
                UtilHelper.copyToClipBoard(shareItem3.linkUrl);
                J("share_to_weixin", new Object[0]);
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, ThirdPartyUtil.TYPE_WEIXIN);
                N(shareItem3, 4);
                M(shareItem3, 3);
                kb5Var.r(shareItem3);
            } else if (i == 3) {
                if (loa.a("circle", shareItem3)) {
                    return;
                }
                J("share_to_pyq", new Object[0]);
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, "pyq");
                N(shareItem3, 3);
                M(shareItem3, 4);
                if (shareItem3.isFromShareFrs) {
                    shareItem3.content = "【" + shareItem3.title + "】 " + shareItem3.content;
                }
                kb5Var.s(shareItem3);
            } else if (i == 9) {
                if (loa.a("qq", shareItem3)) {
                    return;
                }
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, "qq");
                if (rva.b(this.c, "com.tencent.mobileqq")) {
                    J("share_to_qq_friend", new Object[0]);
                    N(shareItem3, 9);
                    M(shareItem3, 5);
                    if (!StringUtils.isNull(shareItem3.title) && !StringUtils.isNull(shareItem3.content) && shareItem3.title.trim().equals(shareItem3.content.trim())) {
                        shareItem3.content = "";
                    }
                    kb5Var.m(shareItem3);
                } else {
                    Context context2 = this.c;
                    BdToast.makeText(context2, context2.getText(R.string.share_qq_not_install)).show();
                    new IntentConfig(this.c).startActivityForResult(24007, ShareHandlerActivity.class);
                }
            } else if (i == 5) {
                if (loa.a(ShareItem.OUTSIDE_SHARE_QQZONE, shareItem3)) {
                    return;
                }
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, ShareItem.OUTSIDE_SHARE_QQZONE);
                if (rva.b(this.c, "com.tencent.mobileqq")) {
                    J("share_to_qzone", new Object[0]);
                    N(shareItem3, 5);
                    M(shareItem3, 6);
                    if (!StringUtils.isNull(shareItem3.title) && !StringUtils.isNull(shareItem3.content) && shareItem3.title.trim().equals(shareItem3.content.trim())) {
                        shareItem3.content = "";
                    }
                    kb5Var.n(shareItem3);
                } else {
                    Context context3 = this.c;
                    BdToast.makeText(context3, context3.getText(R.string.share_qq_not_install)).show();
                    new IntentConfig(this.c).startActivityForResult(24007, ShareHandlerActivity.class);
                }
            } else if (i == 7) {
                if (loa.a(ShareItem.OUTSIDE_SHARE_WEIBO, shareItem3)) {
                    return;
                }
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, ShareItem.OUTSIDE_SHARE_WEIBO);
                try {
                    if (!WbSdk.isWbInstall(this.c)) {
                        WbSdk.install(this.c, new AuthInfo(this.c, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
                J("share_to_sweibo", new Object[0]);
                N(shareItem3, 7);
                if (!shareItem3.isFromChosenPb) {
                    if (!StringUtils.isNull(shareItem3.title) && !StringUtils.isNull(shareItem3.content) && shareItem3.title.trim().equals(shareItem3.content.trim())) {
                        shareItem3.content = "";
                    }
                    shareItem3.content = "【" + shareItem3.title + "】 " + shareItem3.content;
                }
                if (!rva.b(this.c, "com.sina.weibo")) {
                    BdToast.makeText(TbadkApplication.getInst().getApplicationContext(), TbadkApplication.getInst().getApplicationContext().getText(R.string.share_sina_weibo_not_install)).show();
                    new IntentConfig(this.c).startActivityForResult(24007, ShareHandlerActivity.class);
                } else {
                    kb5Var.p(shareItem3);
                }
            } else if (i == 10) {
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, "copylink");
                N(shareItem3, 10);
                String t = kb5.t(shareItem3.linkUrl, shareItem3.tid, UtilHelper.isVideoThread(shareItem3.obj_type));
                shareItem3.linkUrl = t;
                AndroidUtils.copyToClipboard(t);
                BdUtilHelper.showToast(this.c.getApplicationContext(), this.c.getResources().getString(R.string.copy_pb_url_success));
                K(shareItem3);
                if (shareItem3.isFromChosenPb) {
                    i2 = 8;
                    L(8, shareItem3.ftid);
                    if (shareItem3.objSource != i2 && shareItem3.voiceRoomId > 0) {
                        statisticItem.param("obj_type", "2");
                        statisticItem.param("room_id", shareItem3.voiceRoomId);
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                }
            }
            i2 = 8;
            if (shareItem3.objSource != i2) {
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.c, 25018);
            selectForumActivityConfig.setIsShare(true);
            selectForumActivityConfig.setForumList(this.b);
            if (this.k) {
                selectForumActivityConfig.setFrom(4);
                selectForumActivityConfig.setMoreForumImg(this.f.imageUrl);
                selectForumActivityConfig.setMoreForumUrl(this.f.linkUrl);
                selectForumActivityConfig.setMoreForumTitle(this.f.title);
            } else {
                selectForumActivityConfig.setFrom(2);
            }
            ShareItem.ForwardInfo forwardInfo = this.f.forwardInfo;
            if (forwardInfo != null) {
                selectForumActivityConfig.setBaijiahaoData(forwardInfo.baijiahaoData);
                selectForumActivityConfig.setTransmitOriginThreadComment(this.f.forwardInfo.transmitOriginThreadComment);
                selectForumActivityConfig.setTransmitThreadAuthorNameShow(this.f.forwardInfo.transmitThreadAuthorNameShow);
            }
            selectForumActivityConfig.setOriginalThread(this.f.originalThreadInfo);
            selectForumActivityConfig.setPrivateThread(this.a);
            if (!StringUtils.isNull(this.q)) {
                selectForumActivityConfig.setTopicId(this.q);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, selectForumActivityConfig));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SHARE_FRIEND_BTN);
            int i = this.f.objSource;
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

    public final void x() {
        CustomResponsedMessage customResponsedMessage;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (GroupInfoData.isValidGroup(this.f.groupData)) {
                customResponsedMessage = new CustomResponsedMessage(2921694, this.f.groupData);
            } else {
                OriginalThreadInfo.ShareInfo shareInfo = this.f.originalThreadInfo;
                if (shareInfo != null && (threadData = shareInfo.threadData) != null) {
                    customResponsedMessage = new CustomResponsedMessage(2921694, threadData);
                } else if (!ShareIMCommonCardData.isValidTopic(this.f.mShareCommonInfoData) && !ShareIMCommonCardData.isValidAlbum(this.f.mShareCommonInfoData) && !ShareIMCommonCardData.isValidActive(this.f.mShareCommonInfoData)) {
                    customResponsedMessage = null;
                } else {
                    customResponsedMessage = new CustomResponsedMessage(2921694, this.f.mShareCommonInfoData);
                }
            }
            if (customResponsedMessage == null) {
                return;
            }
            MessageManager.getInstance().registerStickyMode(2921694);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            ShareFriendActivityConfig shareFriendActivityConfig = new ShareFriendActivityConfig(this.c);
            shareFriendActivityConfig.setIsForShare(true);
            shareFriendActivityConfig.setFilterGroup(this.f.isFilterRooms());
            shareFriendActivityConfig.setFilterPerson(this.f.isFilterPerson());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, shareFriendActivityConfig));
        }
    }
}
