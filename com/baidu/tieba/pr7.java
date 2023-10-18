package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.BdToastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.hz4;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.settingcache.OfficialSettingCache;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.LikeReturnData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.zda;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class pr7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public List<TBSpecificationBtn> b;
    public LikeModel c;
    public zda d;
    public boolean e;
    public LikeReturnData f;
    public AntiHelper.k g;
    public CustomMessageListener h;
    public g4 i;
    public zda.a j;

    /* loaded from: classes7.dex */
    public class a implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(pr7 pr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hz4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pr7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(pr7 pr7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pr7Var, Integer.valueOf(i)};
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
            this.a = pr7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof LikeReturnData)) {
                this.a.h(customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends g4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pr7 a;

        public c(pr7 pr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pr7Var;
        }

        @Override // com.baidu.tieba.g4
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, obj) != null) {
                return;
            }
            this.a.h(obj);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements zda.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pr7 a;

        @Override // com.baidu.tieba.zda.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            }
        }

        public d(pr7 pr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pr7Var;
        }

        @Override // com.baidu.tieba.zda.a
        public void b(String str, long j) {
            FrsViewData s1;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) != null) || this.a.a == null || (s1 = this.a.a.s1()) == null || s1.getForum() == null) {
                return;
            }
            String l = this.a.l();
            String k = this.a.k();
            if (j == JavaTypesHelper.toLong(k, 0L) && TextUtils.equals(l, str)) {
                rr7 N0 = this.a.a.N0();
                if (N0 != null) {
                    N0.t0(str);
                }
                s1.getForum().setLike(0);
                if (N0 != null) {
                    N0.o0(0);
                }
                this.a.a.S5(Boolean.TRUE);
                this.a.q(false, k);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, k));
                LikeReturnData likeReturnData = new LikeReturnData();
                likeReturnData.setLike(0);
                likeReturnData.setFid(k);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, likeReturnData));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pr7 a;

        public e(pr7 pr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pr7Var;
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                hz4Var.dismiss();
                if (this.a.a != null && this.a.d != null) {
                    FrsViewData s1 = this.a.a.s1();
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (currentAccount != null && currentAccount.length() > 0) {
                        if (s1 != null && s1.getForum() != null) {
                            this.a.d.c(this.a.l(), JavaTypesHelper.toLong(this.a.k(), 0L));
                            return;
                        }
                        return;
                    }
                    TbadkCoreApplication.getInst().login(this.a.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.a.getActivity(), true, 11036)));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(pr7 pr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                hz4Var.dismiss();
            }
        }
    }

    public pr7(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.c = null;
        this.d = null;
        this.f = null;
        this.g = new a(this);
        this.h = new b(this, 2921600);
        this.i = new c(this);
        this.j = new d(this);
        this.a = frsFragment;
        if (frsFragment != null) {
            frsFragment.registerListener(this.h);
        }
    }

    public final void q(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048586, this, z, str) == null) {
            OfficialSettingCache.getInstance().saveAcceptNotifyAsync(TbadkCoreApplication.getCurrentAccount(), str, z, null);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void u(String str, String str2) {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) && (likeModel = this.c) != null) {
            likeModel.g0(str, str2, "FRS");
        }
    }

    public void j(@NonNull List<TBSpecificationBtn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.b = list;
            t();
        }
    }

    public final void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_HTTP_FORUM_SIGN_IN_RESULT);
            httpMessage.addParam("scene_from", "frs");
            httpMessage.addParam("forum_ids", str);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void s(boolean z) {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && (likeModel = this.c) != null) {
            likeModel.e0(z ? 1 : 0);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13605");
            FrsFragment frsFragment = this.a;
            if (frsFragment != null) {
                ym5.b(frsFragment.getContext(), statisticItem);
                mn7.b(statisticItem, this.a.w(), this.a.v());
            }
            mn7.a(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && frsFragment.s1() != null && this.a.s1().getForum() != null) {
                return this.a.s1().getForum().getId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && frsFragment.s1() != null && this.a.s1().getForum() != null) {
                return this.a.s1().getForum().getName();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void h(Object obj) {
        FrsFragment frsFragment;
        FrsViewData s1;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) && (frsFragment = this.a) != null && (s1 = frsFragment.s1()) != null && s1.getForum() != null && obj != null) {
            if (AntiHelper.m(this.c.getErrorCode(), this.c.getErrorString())) {
                if (AntiHelper.t(this.a.getActivity(), this.c.c0(), this.g) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                    return;
                }
                return;
            }
            String k = k();
            if (obj instanceof LikeReturnData) {
                this.f = (LikeReturnData) obj;
            }
            boolean z2 = false;
            if (this.f != null && this.c.getErrorCode() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (this.f.getErrorCode() == 3250013) {
                BdToast.makeText(TbadkCoreApplication.getInst().getContext(), this.f.getErrorMsg()).setIcon(BdToast.ToastIcon.FAILURE).setDuration(3000).show();
            } else {
                z2 = z;
            }
            if (this.f != null && z2) {
                r(k);
            } else if (this.c.getErrorCode() == 22) {
                FrsFragment frsFragment2 = this.a;
                frsFragment2.showToast(frsFragment2.getString(R.string.had_liked_forum));
            } else {
                this.a.showToast(this.c.getErrorString());
            }
            this.a.N4(Boolean.valueOf(z2));
        }
    }

    public void i() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (frsFragment = this.a) != null && frsFragment.s1() != null && this.f != null) {
            FrsViewData s1 = this.a.s1();
            String l = l();
            String k = k();
            rr7 N0 = this.a.N0();
            if (N0 != null) {
                N0.t0(l);
            }
            this.f.setLike(1);
            s1.updateLikeData(this.f);
            s1.setLikeFeedForumDataList(this.f.getFeedForumDataList());
            if (N0 != null) {
                N0.A0(s1, this.e);
                if (!ListUtils.isEmpty(this.f.getRecommendForums())) {
                    N0.J0(this.f.getRecommendForums());
                }
            }
            this.e = true;
            FrsFragment frsFragment2 = this.a;
            if (frsFragment2 != null && (frsFragment2.getActivity() instanceof FrsActivity) && !BdToastHelper.canShowToast(this.f.getToastData())) {
                ((FrsActivity) this.a.getActivity()).s1().d(k);
            }
            q(true, k);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, this.f));
            g();
        }
    }

    public final void m() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (frsFragment = this.a) != null) {
            LikeModel likeModel = new LikeModel(frsFragment.getPageContext());
            this.c = likeModel;
            likeModel.setLoadDataCallBack(this.i);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            zda zdaVar = new zda();
            this.d = zdaVar;
            zdaVar.a("from_frs");
            this.d.b(this.j);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            m();
            n();
        }
    }

    public void p() {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (likeModel = this.c) != null) {
            likeModel.b0();
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            for (TBSpecificationBtn tBSpecificationBtn : this.b) {
                if (tBSpecificationBtn != null) {
                    tBSpecificationBtn.k();
                }
            }
        }
    }

    public void v(boolean z) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && (frsFragment = this.a) != null && this.c != null) {
            FrsViewData s1 = frsFragment.s1();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (s1 != null && s1.getForum() != null) {
                    String l = l();
                    String k = k();
                    if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.a.getFrom())) {
                        TiebaStatic.log(new StatisticItem("c10356").param("fid", k));
                    } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.a.getFrom())) {
                        TiebaStatic.log(new StatisticItem("c10590").param("obj_type", 2).param("fid", k));
                    } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.a.getFrom())) {
                        TiebaStatic.log(new StatisticItem("c10587").param("obj_type", 2).param("fid", k));
                    } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.a.getFrom())) {
                        TiebaStatic.log(new StatisticItem("c10578").param("obj_type", 2).param("fid", k));
                    }
                    this.c.setFrom("recom_flist_like_frs");
                    if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.a.getFrom())) {
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                    } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.a.getFrom())) {
                        TiebaStatic.log(new StatisticItem("c10359").param("fid", k));
                    }
                    this.c.g0(l, k, "FRS");
                    this.e = z;
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().login(this.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.getActivity(), true, 11002)));
        }
    }

    public void w() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || (frsFragment = this.a) == null) {
            return;
        }
        hz4 hz4Var = new hz4(frsFragment.getActivity());
        String l = l();
        if (!StringUtils.isNull(l)) {
            hz4Var.setMessage(String.format(this.a.getString(R.string.attention_cancel_dialog_content), l));
        } else {
            hz4Var.setMessage(this.a.getString(R.string.obfuscated_res_0x7f0f02f2));
        }
        hz4Var.setPositiveButton(this.a.getString(R.string.editor_dialog_yes), new e(this));
        hz4Var.setNegativeButton(this.a.getString(R.string.editor_dialog_no), new f(this));
        hz4Var.create(this.a.D()).show();
    }
}
