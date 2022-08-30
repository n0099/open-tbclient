package com.baidu.tieba;

import android.content.Context;
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
import com.baidu.tieba.bk5;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;
/* loaded from: classes5.dex */
public class sr8 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public static final int B;
    public static int C;
    public static int D;
    public static int E;
    public static int F;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public ArrayList<TransmitForumData> b;
    public Context c;
    public View d;
    public rr8 e;
    public ShareItem f;
    public qr8 g;
    public View.OnClickListener h;
    public View.OnClickListener i;
    public View.OnClickListener j;
    public boolean k;
    public bk5 l;
    public ur8 m;
    public String n;
    public boolean o;
    public boolean p;
    public String q;
    @NonNull
    public h75 r;
    @Nullable
    public g75 s;
    public ArrayList<MetaData> t;
    public ArrayList<MetaData> u;
    public ArrayList<MetaData> v;
    public ArrayList<MetaData> w;
    public ArrayList<String> x;
    public CustomMessageListener y;
    public bk5.b z;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sr8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(sr8 sr8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr8Var, Integer.valueOf(i)};
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
            this.a = sr8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ArrayList)) {
                return;
            }
            this.a.b = (ArrayList) customResponsedMessage.getData();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements bk5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sr8 a;

        public b(sr8 sr8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sr8Var;
        }

        @Override // com.baidu.tieba.bk5.b
        public void a(boolean z) {
            ShareDialogItemView shareDialogItemView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (shareDialogItemView = (ShareDialogItemView) this.a.d.findViewWithTag(16)) == null) {
                return;
            }
            shareDialogItemView.c(z ? R.drawable.obfuscated_res_0x7f0809c7 : R.drawable.obfuscated_res_0x7f0809c6, SkinManager.getColor(R.color.CAM_X0107));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948161136, "Lcom/baidu/tieba/sr8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948161136, "Lcom/baidu/tieba/sr8;");
                return;
            }
        }
        A = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds202);
        B = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds239);
        C = 10;
        D = 8;
        E = 1;
        F = 2;
    }

    public sr8(Context context) {
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
        this.r = (h75) b75.c(h75.a);
        this.s = null;
        this.v = new ArrayList<>();
        this.w = new ArrayList<>();
        this.x = new ArrayList<>();
        this.y = new a(this, 2016563);
        this.z = new b(this);
        this.c = context;
        MessageManager.getInstance().registerListener(this.y);
    }

    public void A(qr8 qr8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qr8Var) == null) {
            this.g = qr8Var;
        }
    }

    public void B(ShareDialogConfig shareDialogConfig, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{shareDialogConfig, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            q();
            ArrayList<MetaData> arrayList = this.w;
            if (arrayList != null && arrayList.size() != 0 && z2 && TbadkCoreApplication.getCurrentAccount() != null) {
                C(shareDialogConfig, z, 0, 1, 2);
            } else {
                D(shareDialogConfig, z, 0, 1, z2);
            }
        }
    }

    public void C(ShareDialogConfig shareDialogConfig, boolean z, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{shareDialogConfig, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
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
                f(new SvgMaskType(R.drawable.obfuscated_res_0x7f08081b), R.string.obfuscated_res_0x7f0f116d, 4, i);
                f(new SvgMaskType(R.drawable.obfuscated_res_0x7f080817), R.string.obfuscated_res_0x7f0f1174, 3, i);
                f(new SvgMaskType(R.drawable.obfuscated_res_0x7f080818), R.string.obfuscated_res_0x7f0f114b, 9, i);
                f(new SvgMaskType(R.drawable.obfuscated_res_0x7f080819), R.string.obfuscated_res_0x7f0f114f, 5, i);
                f(new SvgMaskType(R.drawable.obfuscated_res_0x7f08081c), R.string.obfuscated_res_0x7f0f115a, 7, i);
                c(R.string.obfuscated_res_0x7f0f0aea, R.drawable.obfuscated_res_0x7f0809cf, 13, i);
                return;
            }
            if (this.f.k0) {
                int size = this.w.size();
                int i4 = 0;
                if (size < C) {
                    while (i4 < size) {
                        e(this.w.get(i4), 25, shareDialogConfig.isShowNovelMask(), i);
                        i4++;
                    }
                } else {
                    while (i4 < C) {
                        e(this.w.get(i4), 25, shareDialogConfig.isShowNovelMask(), i);
                        i4++;
                    }
                }
                this.e.a(i);
                if (size >= C) {
                    c(R.string.obfuscated_res_0x7f0f0aeb, R.drawable.obfuscated_res_0x7f080a61, 28, i);
                }
                d(R.string.obfuscated_res_0x7f0f1137, R.drawable.obfuscated_res_0x7f080872, 24, shareDialogConfig.isShowNovelMask(), i2);
                g(new SvgMaskType(R.drawable.obfuscated_res_0x7f08081b), R.string.obfuscated_res_0x7f0f116d, 4, shareDialogConfig.isShowNovelMask(), i2);
                g(new SvgMaskType(R.drawable.obfuscated_res_0x7f080817), R.string.obfuscated_res_0x7f0f1174, 3, shareDialogConfig.isShowNovelMask(), i2);
                g(new SvgMaskType(R.drawable.obfuscated_res_0x7f080818), R.string.obfuscated_res_0x7f0f114b, 9, shareDialogConfig.isShowNovelMask(), i2);
                g(new SvgMaskType(R.drawable.obfuscated_res_0x7f080819), R.string.obfuscated_res_0x7f0f114f, 5, shareDialogConfig.isShowNovelMask(), i2);
                g(new SvgMaskType(R.drawable.obfuscated_res_0x7f08081c), R.string.obfuscated_res_0x7f0f115a, 7, shareDialogConfig.isShowNovelMask(), i2);
                if (!shareDialogConfig.isHideShareCopyLink) {
                    c(R.string.obfuscated_res_0x7f0f1132, R.drawable.obfuscated_res_0x7f0809c8, 10, i3);
                }
            }
            boolean isPrePagePersonalPage = shareDialogConfig.isPrePagePersonalPage();
            boolean z2 = shareDialogConfig.isHost;
            if (shareDialogConfig.isFromImmersionVideo) {
                if (!isPrePagePersonalPage && s()) {
                    c(R.string.obfuscated_res_0x7f0f06ba, R.drawable.obfuscated_res_0x7f08098f, 18, i3);
                }
                if (shareDialogConfig.isCollected) {
                    h(R.string.obfuscated_res_0x7f0f0a94, R.drawable.obfuscated_res_0x7f0809c7, 0, 16, i2);
                } else {
                    c(R.string.obfuscated_res_0x7f0f0a94, R.drawable.obfuscated_res_0x7f0809c6, 16, i3);
                }
                if (!z2) {
                    c(R.string.obfuscated_res_0x7f0f0ffa, R.drawable.obfuscated_res_0x7f0809d2, 17, i3);
                } else if (isPrePagePersonalPage) {
                    c(R.string.obfuscated_res_0x7f0f04ac, R.drawable.obfuscated_res_0x7f0809c9, 19, i3);
                }
            }
            if (shareDialogConfig.showDisLike && !isPrePagePersonalPage) {
                c(R.string.obfuscated_res_0x7f0f0ca3, R.drawable.obfuscated_res_0x7f0809d3, 14, i3);
            }
            if (this.f.l0) {
                c(R.string.obfuscated_res_0x7f0f03f5, R.drawable.obfuscated_res_0x7f0809d3, 15, i3);
            }
            if (shareDialogConfig.showHeating) {
                c(shareDialogConfig.isSelfHeating ? R.string.obfuscated_res_0x7f0f0841 : R.string.obfuscated_res_0x7f0f0842, R.drawable.obfuscated_res_0x7f0809cd, 23, i3);
            }
            if (z) {
                c(R.string.obfuscated_res_0x7f0f0aea, R.drawable.obfuscated_res_0x7f0809cf, 13, i3);
            }
            if (shareDialogConfig.isFromImmersionVideo) {
                bk5 bk5Var = new bk5(this.c);
                this.l = bk5Var;
                bk5Var.i(this.z);
                this.l.g(shareDialogConfig.isCollected);
                this.l.h(k());
            }
        }
    }

    public void D(ShareDialogConfig shareDialogConfig, boolean z, int i, int i2, boolean z2) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{shareDialogConfig, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
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
                f(new SvgMaskType(R.drawable.obfuscated_res_0x7f08081b), R.string.obfuscated_res_0x7f0f116d, 4, i);
                f(new SvgMaskType(R.drawable.obfuscated_res_0x7f080817), R.string.obfuscated_res_0x7f0f1174, 3, i);
                f(new SvgMaskType(R.drawable.obfuscated_res_0x7f080818), R.string.obfuscated_res_0x7f0f114b, 9, i);
                f(new SvgMaskType(R.drawable.obfuscated_res_0x7f080819), R.string.obfuscated_res_0x7f0f114f, 5, i);
                f(new SvgMaskType(R.drawable.obfuscated_res_0x7f08081c), R.string.obfuscated_res_0x7f0f115a, 7, i);
                c(R.string.obfuscated_res_0x7f0f0aea, R.drawable.obfuscated_res_0x7f0809cf, 13, i);
                return;
            }
            if (this.f.k0) {
                if (!z2 || TbadkCoreApplication.getCurrentAccount() == null) {
                    i3 = R.drawable.obfuscated_res_0x7f08081b;
                    i4 = R.drawable.obfuscated_res_0x7f080817;
                } else {
                    boolean isShowNovelMask = shareDialogConfig.isShowNovelMask();
                    i3 = R.drawable.obfuscated_res_0x7f08081b;
                    i4 = R.drawable.obfuscated_res_0x7f080817;
                    d(R.string.obfuscated_res_0x7f0f1137, R.drawable.obfuscated_res_0x7f080872, 24, isShowNovelMask, i);
                }
                g(new SvgMaskType(i3), R.string.obfuscated_res_0x7f0f116d, 4, shareDialogConfig.isShowNovelMask(), i);
                g(new SvgMaskType(i4), R.string.obfuscated_res_0x7f0f1174, 3, shareDialogConfig.isShowNovelMask(), i);
                g(new SvgMaskType(R.drawable.obfuscated_res_0x7f080818), R.string.obfuscated_res_0x7f0f114b, 9, shareDialogConfig.isShowNovelMask(), i);
                g(new SvgMaskType(R.drawable.obfuscated_res_0x7f080819), R.string.obfuscated_res_0x7f0f114f, 5, shareDialogConfig.isShowNovelMask(), i);
                g(new SvgMaskType(R.drawable.obfuscated_res_0x7f08081c), R.string.obfuscated_res_0x7f0f115a, 7, shareDialogConfig.isShowNovelMask(), i);
                if (!shareDialogConfig.isHideShareCopyLink) {
                    c(R.string.obfuscated_res_0x7f0f1132, R.drawable.obfuscated_res_0x7f0809c8, 10, i2);
                }
            }
            boolean isPrePagePersonalPage = shareDialogConfig.isPrePagePersonalPage();
            boolean z3 = shareDialogConfig.isHost;
            if (shareDialogConfig.isFromImmersionVideo) {
                if (!isPrePagePersonalPage && s()) {
                    c(R.string.obfuscated_res_0x7f0f06ba, R.drawable.obfuscated_res_0x7f08098f, 18, i2);
                }
                if (shareDialogConfig.isCollected) {
                    h(R.string.obfuscated_res_0x7f0f0a94, R.drawable.obfuscated_res_0x7f0809c7, 0, 16, i2);
                } else {
                    c(R.string.obfuscated_res_0x7f0f0a94, R.drawable.obfuscated_res_0x7f0809c6, 16, i2);
                }
                if (!z3) {
                    c(R.string.obfuscated_res_0x7f0f0ffa, R.drawable.obfuscated_res_0x7f0809d2, 17, i2);
                } else if (isPrePagePersonalPage) {
                    c(R.string.obfuscated_res_0x7f0f04ac, R.drawable.obfuscated_res_0x7f0809c9, 19, i2);
                }
            }
            if (shareDialogConfig.showDisLike && !isPrePagePersonalPage) {
                c(R.string.obfuscated_res_0x7f0f0ca3, R.drawable.obfuscated_res_0x7f0809d3, 14, i2);
            }
            if (this.f.l0) {
                c(R.string.obfuscated_res_0x7f0f03f5, R.drawable.obfuscated_res_0x7f0809d3, 15, i2);
            }
            if (shareDialogConfig.showHeating) {
                c(shareDialogConfig.isSelfHeating ? R.string.obfuscated_res_0x7f0f0841 : R.string.obfuscated_res_0x7f0f0842, R.drawable.obfuscated_res_0x7f0809cd, 23, i2);
            }
            if (z) {
                c(R.string.obfuscated_res_0x7f0f0aea, R.drawable.obfuscated_res_0x7f0809cf, 13, i2);
            }
            if (shareDialogConfig.isFromImmersionVideo) {
                bk5 bk5Var = new bk5(this.c);
                this.l = bk5Var;
                bk5Var.i(this.z);
                this.l.g(shareDialogConfig.isCollected);
                this.l.h(k());
            }
        }
    }

    public final void E(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || this.f == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", this.f.M).param("tid", this.f.N).param("obj_type", i).param("obj_source", this.f.H).param("obj_param1", this.f.I).param(TiebaStatic.Params.OBJ_PARAM2, this.f.J));
        int i2 = this.f.P;
        int i3 = 0;
        int i4 = i2 == 5 ? 1 : i2 == 6 ? 2 : i2 == 7 ? 3 : i2 == 8 ? 4 : 0;
        int i5 = this.f.H;
        if (i5 == 4) {
            i3 = 1;
        } else if (i5 == 3) {
            i3 = 2;
        } else if (i5 == 8) {
            i3 = 3;
        } else if (i5 == 6) {
            i3 = 4;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_TRANSFER_BTN_CLICK).param("obj_locate", i != 11 ? 1 : 2).param("obj_source", i3).param("obj_type", i4));
    }

    public final void F(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, objArr) == null) {
            TiebaStatic.eventStat(this.c, str, "click", 1, objArr);
        }
    }

    public final void G(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, shareItem) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 7);
            int i = shareItem.I;
            if (i != 0) {
                param.param("obj_param1", i);
                int i2 = shareItem.I;
                if (i2 == 2) {
                    param.param("fid", shareItem.M);
                } else if (i2 == 3) {
                    int i3 = shareItem.P;
                    if (i3 != 0) {
                        param.param("obj_type", i3);
                    }
                    param.param("tid", shareItem.N).param("fid", shareItem.M);
                }
            }
            param.param("obj_locate", 9);
            TiebaStatic.log(param);
        }
    }

    public final void H(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, str) == null) {
            TiebaStatic.eventStat(this.c, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
        }
    }

    public final void J(ShareItem shareItem, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, shareItem, i) == null) || shareItem == null || shareItem.t == null) {
            return;
        }
        if (shareItem.b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.t).param("obj_type", i).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.J));
        } else if (!shareItem.c && !shareItem.f) {
            if (shareItem.d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.t).param("obj_type", i));
            } else if (shareItem.a) {
                H(i, shareItem.F);
            } else if (shareItem.e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i).param("fid", shareItem.t).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.J));
            } else if (shareItem.g) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i);
                param.param("obj_source", shareItem.H);
                param.param(TiebaStatic.Params.OBJ_PARAM2, shareItem.J);
                TiebaStatic.log(param);
            }
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.t).param("obj_type", i).param("obj_source", shareItem.H).param("obj_param1", shareItem.I).param("fid", shareItem.M).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.J));
        }
    }

    public final void c(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048585, this, i, i2, i3, i4) == null) {
            h(i, i2, SkinManager.getColor(R.color.CAM_X0107), i3, i4);
        }
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

    public final void e(@NonNull MetaData metaData, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{metaData, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.c);
            shareDialogItemView.setItemIcon(metaData.getAvater(), i, metaData);
            String name_show = metaData.getName_show();
            if (pf5.d(metaData.getName_show()) > D) {
                name_show = pf5.n(name_show, D) + StringHelper.STRING_MORE;
            }
            shareDialogItemView.setItemName(name_show);
            shareDialogItemView.setOnClickListener(this);
            shareDialogItemView.setTag(R.id.obfuscated_res_0x7f090954, metaData);
            shareDialogItemView.a();
            MaskView.c(shareDialogItemView, z);
            this.e.b(i2, shareDialogItemView);
        }
    }

    public final void f(AbsSvgType absSvgType, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048588, this, absSvgType, i, i2, i3) == null) || absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.c);
        shareDialogItemView.setItemIcon(absSvgType, i2);
        shareDialogItemView.setItemName(i);
        shareDialogItemView.setOnClickListener(this);
        rr8 rr8Var = this.e;
        shareDialogItemView.a();
        rr8Var.b(i3, shareDialogItemView);
    }

    public final void g(AbsSvgType absSvgType, int i, int i2, boolean z, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{absSvgType, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) || absSvgType == null) {
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
            rr8 rr8Var = this.e;
            shareDialogItemView.a();
            rr8Var.b(i5, shareDialogItemView);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ArrayList<MetaData> arrayList = this.t;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<MetaData> it = this.t.iterator();
                while (it.hasNext()) {
                    it.next().setItemType(E);
                }
            }
            ArrayList<MetaData> arrayList2 = this.u;
            if (arrayList2 == null || arrayList2.size() == 0) {
                return;
            }
            Iterator<MetaData> it2 = this.u.iterator();
            while (it2.hasNext()) {
                it2.next().setItemType(F);
            }
        }
    }

    @NonNull
    public g75 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.s == null) {
                this.s = this.r.b(l());
            }
            return (g75) Objects.requireNonNull(this.s);
        }
        return (g75) invokeV.objValue;
    }

    public MarkData k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.f.N);
            markData.setPostId(this.f.b0);
            markData.setTime(date.getTime());
            markData.setId(this.f.N);
            markData.setFloor(1);
            markData.setForumId(this.f.M);
            return markData;
        }
        return (MarkData) invokeV.objValue;
    }

    @NonNull
    public final TbPageContext l() {
        InterceptResult invokeV;
        TbPageContext<BaseFragmentActivity> pageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            Context context = this.c;
            if (context instanceof BaseActivity) {
                pageContext = ((BaseActivity) context).getPageContext();
            } else {
                pageContext = context instanceof BaseFragmentActivity ? ((BaseFragmentActivity) context).getPageContext() : null;
            }
            return (TbPageContext) Objects.requireNonNull(pageContext);
        }
        return (TbPageContext) invokeV.objValue;
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
                this.e.setItemParams(A, B);
                this.d = this.e.getView();
            }
            return this.d;
        }
        return (View) invokeZ.objValue;
    }

    public final void o(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048597, this, i) == null) && i == 13) {
            u();
            E(13);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Context context;
        ThreadData threadData;
        View.OnClickListener onClickListener;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view2) == null) {
            qr8 qr8Var = this.g;
            if (qr8Var != null) {
                qr8Var.a(view2);
            }
            if (view2.getTag() instanceof Integer) {
                Integer num = (Integer) view2.getTag();
                if (!pi.z() && num.intValue() != 10) {
                    ri.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1140);
                } else if (num.intValue() == 14) {
                    View.OnClickListener onClickListener2 = this.h;
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(view2);
                    }
                } else if (num.intValue() == 16) {
                    if (ViewHelper.checkUpIsLogin(this.c)) {
                        if (this.l.f()) {
                            this.l.e();
                        } else {
                            this.l.d();
                        }
                    }
                } else if (num.intValue() == 17) {
                    if (ViewHelper.checkUpIsLogin(this.c)) {
                        if (this.m == null && (runTask = MessageManager.getInstance().runTask(2921343, ur8.class, this.c)) != null) {
                            this.m = (ur8) runTask.getData();
                        }
                        ur8 ur8Var = this.m;
                        if (ur8Var != null) {
                            ur8Var.b(m(this.c));
                            this.m.a(this.f.b0);
                        }
                    }
                } else {
                    if (num.intValue() == 18) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921607, Boolean.TRUE));
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_IMMERSION_VIDEO_SHARE_DIALOG_MUSK_CLiCK);
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        ShareItem shareItem = this.f;
                        if (shareItem != null) {
                            statisticItem.param("tid", shareItem.N);
                            statisticItem.param("fid", this.f.M);
                            statisticItem.param("fname", this.f.s);
                        }
                        TiebaStatic.log(statisticItem);
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem2.param("tid", this.f.N);
                        statisticItem2.param("fid", this.f.M);
                        statisticItem2.param("fname", this.f.s);
                        statisticItem2.param("obj_source", 4);
                        TiebaStatic.log(statisticItem2);
                    } else if (num.intValue() == 19) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921607, Boolean.FALSE));
                    } else if (num.intValue() == 20) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        ShareItem shareItem2 = this.f;
                        String str = shareItem2.d0;
                        String str2 = shareItem2.e0;
                        String str3 = shareItem2.b0;
                        String str4 = shareItem2.c0;
                        Context context2 = this.c;
                        ShareItem shareItem3 = this.f;
                        new ForbidActivityConfig(context2, shareItem3.M, shareItem3.s, shareItem3.N, currentAccount, str, str2, str3, str4).start();
                    } else if (num.intValue() == 21) {
                        g75 j = j();
                        ShareItem shareItem4 = this.f;
                        j.b(shareItem4.M, shareItem4.s, shareItem4.N, this.o);
                    } else if (num.intValue() == 22) {
                        g75 j2 = j();
                        ShareItem shareItem5 = this.f;
                        j2.a(shareItem5.M, shareItem5.s, shareItem5.N, this.p);
                    } else if (num.intValue() == 23) {
                        if (ViewHelper.checkUpIsLogin(this.c) && (onClickListener = this.j) != null) {
                            onClickListener.onClick(view2);
                            return;
                        }
                        return;
                    } else if (num.intValue() == 25) {
                        wa7.a("分享弹窗触发分享");
                        Object tag = view2.getTag(R.id.obfuscated_res_0x7f090954);
                        ThreadData threadData2 = null;
                        OriginalThreadInfo.ShareInfo shareInfo = this.f.W;
                        if (shareInfo != null && (threadData = shareInfo.threadData) != null) {
                            threadData2 = threadData;
                        }
                        if (threadData2 == null) {
                            threadData2 = this.f.a0;
                        }
                        if (threadData2 != null && (tag instanceof MetaData) && (context = this.c) != null) {
                            if (q87.a(context)) {
                                return;
                            }
                            MetaData metaData = (MetaData) tag;
                            x(metaData.getUserId());
                            wa7.a("分享弹窗触发分享：分享成功");
                            ba7 ba7Var = new ba7(this.c);
                            ba7Var.o(threadData2, metaData);
                            ba7Var.p();
                        } else {
                            wa7.a("分享弹窗触发分享：数据异常");
                        }
                        qr8 qr8Var2 = this.g;
                        if (qr8Var2 instanceof tr8) {
                            ((tr8) qr8Var2).h();
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
                            v();
                            w();
                        }
                        if (num.intValue() == 28) {
                            v();
                        }
                        if (r(num.intValue())) {
                            p(num.intValue());
                        } else {
                            o(num.intValue());
                        }
                    }
                }
            }
        }
    }

    public final void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            k05 k05Var = new k05(this.c, null);
            ShareItem shareItem = this.f;
            boolean h = tu4.k().h("key_person_growth_share_switch", false);
            if (!TbSingleton.getInstance().isUserGrowthTaskCompleted(UserGrowthTaskRequestMessage.SHARE_THREAD) && !h) {
                shareItem.x0 = TbSingleton.getInstance().getUserGrowthWeight(UserGrowthTaskRequestMessage.SHARE_THREAD);
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_VOICE_ROOM_SHARE);
            if (i == 4) {
                F("share_to_weixin", new Object[0]);
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, ThirdPartyUtil.TYPE_WEIXIN);
                J(shareItem, 4);
                if (shareItem != null) {
                    k05Var.s(shareItem);
                }
            } else if (i == 3) {
                F("share_to_pyq", new Object[0]);
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, "pyq");
                J(shareItem, 3);
                if (shareItem != null) {
                    if (shareItem.b) {
                        shareItem.v = "【" + shareItem.u + "】 " + shareItem.v;
                    }
                    k05Var.t(shareItem);
                }
            } else if (i == 9) {
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, LoginConstants.QQ_LOGIN);
                if (nk8.b(this.c, "com.tencent.mobileqq")) {
                    F("share_to_qq_friend", new Object[0]);
                    J(shareItem, 9);
                    if (shareItem != null) {
                        if (!StringUtils.isNull(shareItem.u) && !StringUtils.isNull(shareItem.v) && shareItem.u.trim().equals(shareItem.v.trim())) {
                            shareItem.v = "";
                        }
                        k05Var.n(shareItem);
                    }
                } else {
                    Context context = this.c;
                    BdToast.b(context, context.getText(R.string.obfuscated_res_0x7f0f114c)).i();
                }
            } else if (i == 5) {
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, "qqzone");
                if (nk8.b(this.c, "com.tencent.mobileqq")) {
                    F("share_to_qzone", new Object[0]);
                    J(shareItem, 5);
                    if (shareItem != null) {
                        if (!StringUtils.isNull(shareItem.u) && !StringUtils.isNull(shareItem.v) && shareItem.u.trim().equals(shareItem.v.trim())) {
                            shareItem.v = "";
                        }
                        k05Var.o(shareItem);
                    }
                } else {
                    Context context2 = this.c;
                    BdToast.b(context2, context2.getText(R.string.obfuscated_res_0x7f0f114c)).i();
                }
            } else if (i == 7) {
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, "weibo");
                try {
                    if (!WbSdk.isWbInstall(this.c)) {
                        WbSdk.install(this.c, new AuthInfo(this.c, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
                F("share_to_sweibo", new Object[0]);
                J(shareItem, 7);
                if (shareItem != null) {
                    if (!shareItem.a) {
                        if (!StringUtils.isNull(shareItem.u) && !StringUtils.isNull(shareItem.v) && shareItem.u.trim().equals(shareItem.v.trim())) {
                            shareItem.v = "";
                        }
                        shareItem.v = "【" + shareItem.u + "】 " + shareItem.v;
                    }
                    k05Var.q(shareItem);
                }
            } else if (i == 10) {
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, "copylink");
                J(shareItem, 10);
                String u = k05.u(shareItem.w, shareItem.N, UtilHelper.isVideoThread(shareItem.P));
                shareItem.w = u;
                gi.a(u);
                ri.N(this.c.getApplicationContext(), this.c.getResources().getString(R.string.obfuscated_res_0x7f0f0451));
                G(shareItem);
                if (shareItem != null && shareItem.a) {
                    H(8, shareItem.F);
                }
            }
            if (shareItem.H != 8 || shareItem.X <= 0) {
                return;
            }
            statisticItem.param("obj_type", "2");
            statisticItem.param("room_id", shareItem.X);
            TiebaStatic.log(statisticItem);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.t = va7.a();
            this.u = xa7.a();
            i();
            ArrayList<MetaData> arrayList = this.t;
            if (arrayList != null && this.u != null && arrayList.size() != 0 && this.u.size() != 0) {
                this.v.addAll(this.t);
                this.v.addAll(this.u);
            } else {
                ArrayList<MetaData> arrayList2 = this.t;
                if (arrayList2 != null && arrayList2.size() != 0) {
                    this.v.addAll(this.t);
                } else {
                    ArrayList<MetaData> arrayList3 = this.u;
                    if (arrayList3 != null && arrayList3.size() != 0) {
                        this.v.addAll(this.u);
                    }
                }
            }
            z();
        }
    }

    public final boolean r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) ? i == 4 || i == 3 || i == 9 || i == 5 || i == 7 || i == 10 : invokeI.booleanValue;
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (!"frs".equals(this.n) || this.f == null) {
                return false;
            }
            return (bf6.g() || t()) && bf6.d(bf6.a()) && StringHelper.equals(this.f.M, bf6.c());
        }
        return invokeV.booleanValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            ShareItem shareItem = this.f;
            return shareItem != null && shareItem.J == 11;
        }
        return invokeV.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.c, 25018);
            selectForumActivityConfig.setIsShare(true);
            selectForumActivityConfig.setForumList(this.b);
            if (this.k) {
                selectForumActivityConfig.setFrom(4);
                selectForumActivityConfig.setMoreForumImg(this.f.z);
                selectForumActivityConfig.setMoreForumUrl(this.f.w);
                selectForumActivityConfig.setMoreForumTitle(this.f.u);
            } else {
                selectForumActivityConfig.setFrom(2);
            }
            ShareItem.ForwardInfo forwardInfo = this.f.Z;
            if (forwardInfo != null) {
                selectForumActivityConfig.setBaijiahaoData(forwardInfo.baijiahaoData);
                selectForumActivityConfig.setTransmitOriginThreadComment(this.f.Z.transmitOriginThreadComment);
                selectForumActivityConfig.setTransmitThreadAuthorNameShow(this.f.Z.transmitThreadAuthorNameShow);
            }
            selectForumActivityConfig.setOriginalThread(this.f.W);
            selectForumActivityConfig.setPrivateThread(this.a);
            if (!StringUtils.isNull(this.q)) {
                selectForumActivityConfig.setTopicId(this.q);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, selectForumActivityConfig));
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921694, this.f.W.threadData);
            MessageManager.getInstance().registerStickyMode(2921694);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            ShareFriendActivityConfig shareFriendActivityConfig = new ShareFriendActivityConfig(this.c);
            shareFriendActivityConfig.setIsForShare(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, shareFriendActivityConfig));
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SHARE_FRIEND_BTN);
            int i = this.f.H;
            int i2 = 2;
            if (i == 4 || i == 3 || i == 20 || i == 30) {
                i2 = 1;
            } else if (i != 5 && i != 10 && i != 33) {
                i2 = (i == 6 || i == 2) ? 3 : i == 8 ? 4 : (i == 25 || i == 29 || i == 11 || i == 12) ? 5 : 0;
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_source", i2);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SHARE_NEARLY_PERSON);
            int i = this.f.H;
            int i2 = 2;
            if (i == 4 || i == 3 || i == 20 || i == 30) {
                i2 = 1;
            } else if (i != 5 && i != 10 && i != 33) {
                i2 = (i == 6 || i == 2) ? 3 : i == 8 ? 4 : (i == 25 || i == 29 || i == 11 || i == 12) ? 5 : 0;
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_source", i2);
            statisticItem.param(TiebaStatic.Params.FRIEND_UID, str);
            TiebaStatic.log(statisticItem);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.y);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            for (int i = 0; i < this.v.size(); i++) {
                if (this.v.get(i).getUserId() == null) {
                    this.w.add(this.v.get(i));
                } else if (!this.x.contains(this.v.get(i).getUserId())) {
                    this.x.add(this.v.get(i).getUserId());
                    this.w.add(this.v.get(i));
                }
            }
        }
    }
}
