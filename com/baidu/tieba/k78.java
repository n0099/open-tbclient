package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.BdToastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.f05;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.settingcache.OfficialSettingCache;
import com.baidu.tieba.impersonal.dispatcher.PersonalChatDispatcher;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.LikeReturnData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.yva;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class k78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public List<TBSpecificationBtn> b;
    public LikeModel c;
    public yva d;
    public boolean e;
    public LikeReturnData f;
    public AntiHelper.k g;
    public CustomMessageListener h;
    public w4 i;
    public yva.a j;

    /* loaded from: classes6.dex */
    public class a implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(k78 k78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k78Var};
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
        public void onNavigationButtonClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k78 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(k78 k78Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k78Var, Integer.valueOf(i)};
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
            this.a = k78Var;
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

    /* loaded from: classes6.dex */
    public class c extends w4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k78 a;

        public c(k78 k78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k78Var;
        }

        @Override // com.baidu.tieba.w4
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, obj) != null) {
                return;
            }
            this.a.h(obj);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements yva.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k78 a;

        @Override // com.baidu.tieba.yva.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            }
        }

        public d(k78 k78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k78Var;
        }

        @Override // com.baidu.tieba.yva.a
        public void b(String str, long j) {
            FrsViewData Q1;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) != null) || this.a.a == null || (Q1 = this.a.a.Q1()) == null || Q1.getForum() == null) {
                return;
            }
            String m = this.a.m();
            String l = this.a.l();
            if (j == JavaTypesHelper.toLong(l, 0L) && TextUtils.equals(m, str)) {
                m78 c1 = this.a.a.c1();
                if (c1 != null) {
                    c1.w0(str);
                }
                Q1.getForum().setLike(0);
                if (c1 != null) {
                    c1.r0(0);
                }
                this.a.a.u6(Boolean.TRUE);
                this.a.r(false, l);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, l));
                LikeReturnData likeReturnData = new LikeReturnData();
                likeReturnData.setLike(0);
                likeReturnData.setFid(l);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, likeReturnData));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k78 a;

        public e(k78 k78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k78Var;
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
                if (this.a.a != null && this.a.d != null) {
                    FrsViewData Q1 = this.a.a.Q1();
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (currentAccount != null && currentAccount.length() > 0) {
                        if (Q1 != null && Q1.getForum() != null) {
                            this.a.d.c(this.a.m(), JavaTypesHelper.toLong(this.a.l(), 0L));
                            return;
                        }
                        return;
                    }
                    TbadkCoreApplication.getInst().login(this.a.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.a.getActivity(), true, 11036)));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(k78 k78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
            }
        }
    }

    public k78(FrsFragment frsFragment) {
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

    public final void r(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048587, this, z, str) == null) {
            OfficialSettingCache.getInstance().saveAcceptNotifyAsync(TbadkCoreApplication.getCurrentAccount(), str, z, null);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void v(String str, String str2) {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) && (likeModel = this.c) != null) {
            likeModel.h0(str, str2, "FRS");
        }
    }

    public void j(@NonNull List<TBSpecificationBtn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.b = list;
            u();
        }
    }

    public final void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_HTTP_FORUM_SIGN_IN_RESULT);
            httpMessage.addParam(PersonalChatDispatcher.OPEN_PAGE_FROM, "frs");
            httpMessage.addParam("forum_ids", str);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void t(boolean z) {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (likeModel = this.c) != null) {
            likeModel.f0(z ? 1 : 0);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13605");
            FrsFragment frsFragment = this.a;
            if (frsFragment != null) {
                cp5.b(frsFragment.getContext(), statisticItem);
                b38.b(statisticItem, this.a.w(), this.a.v());
            }
            b38.a(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    @Nullable
    public final ForumData k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && frsFragment.Q1() != null && this.a.Q1().getForum() != null) {
                return this.a.Q1().getForum();
            }
            return null;
        }
        return (ForumData) invokeV.objValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && frsFragment.Q1() != null && this.a.Q1().getForum() != null) {
                return this.a.Q1().getForum().getId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && frsFragment.Q1() != null && this.a.Q1().getForum() != null) {
                return this.a.Q1().getForum().getName();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void h(Object obj) {
        FrsFragment frsFragment;
        FrsViewData Q1;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) && (frsFragment = this.a) != null && (Q1 = frsFragment.Q1()) != null && Q1.getForum() != null && obj != null) {
            if (AntiHelper.m(this.c.getErrorCode(), this.c.getErrorString())) {
                if (AntiHelper.t(this.a.getActivity(), this.c.d0(), this.g) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                    return;
                }
                return;
            }
            String l = l();
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
                s(l);
            } else if (this.c.getErrorCode() == 22) {
                FrsFragment frsFragment2 = this.a;
                frsFragment2.showToast(frsFragment2.getString(R.string.had_liked_forum));
            } else {
                this.a.showToast(this.c.getErrorString());
            }
            this.a.p5(Boolean.valueOf(z2));
        }
    }

    public void i() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (frsFragment = this.a) != null && frsFragment.Q1() != null && this.f != null) {
            FrsViewData Q1 = this.a.Q1();
            String m = m();
            String l = l();
            ForumData k = k();
            m78 c1 = this.a.c1();
            if (c1 != null) {
                c1.w0(m);
            }
            this.f.setLike(1);
            Q1.updateLikeData(this.f);
            Q1.setLikeFeedForumDataList(this.f.getFeedForumDataList());
            if (c1 != null) {
                c1.D0(Q1, this.e);
                if (!ListUtils.isEmpty(this.f.getRecommendForums())) {
                    c1.M0(this.f.getRecommendForums());
                }
            }
            this.e = true;
            FrsFragment frsFragment2 = this.a;
            if (frsFragment2 != null && (frsFragment2.getActivity() instanceof FrsActivity) && !BdToastHelper.canShowToast(this.f.getToastData())) {
                ((FrsActivity) this.a.getActivity()).p1().d(k);
            }
            r(true, l);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, this.f));
            g();
        }
    }

    public final void n() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (frsFragment = this.a) != null) {
            LikeModel likeModel = new LikeModel(frsFragment.getPageContext());
            this.c = likeModel;
            likeModel.setLoadDataCallBack(this.i);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            yva yvaVar = new yva();
            this.d = yvaVar;
            yvaVar.a("from_frs");
            this.d.b(this.j);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            n();
            o();
        }
    }

    public void q() {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (likeModel = this.c) != null) {
            likeModel.c0();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (TBSpecificationBtn tBSpecificationBtn : this.b) {
                if (tBSpecificationBtn != null) {
                    tBSpecificationBtn.k();
                }
            }
        }
    }

    public void w(boolean z) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && (frsFragment = this.a) != null && this.c != null) {
            FrsViewData Q1 = frsFragment.Q1();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (Q1 != null && Q1.getForum() != null) {
                    String m = m();
                    String l = l();
                    if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.a.getFrom())) {
                        TiebaStatic.log(new StatisticItem("c10356").param("fid", l));
                    } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.a.getFrom())) {
                        TiebaStatic.log(new StatisticItem("c10590").param("obj_type", 2).param("fid", l));
                    } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.a.getFrom())) {
                        TiebaStatic.log(new StatisticItem("c10587").param("obj_type", 2).param("fid", l));
                    } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.a.getFrom())) {
                        TiebaStatic.log(new StatisticItem("c10578").param("obj_type", 2).param("fid", l));
                    }
                    this.c.setFrom("recom_flist_like_frs");
                    if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.a.getFrom())) {
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                    } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.a.getFrom())) {
                        TiebaStatic.log(new StatisticItem("c10359").param("fid", l));
                    }
                    this.c.h0(m, l, "FRS");
                    this.e = z;
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().login(this.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.getActivity(), true, 11002)));
        }
    }

    public void x() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || (frsFragment = this.a) == null) {
            return;
        }
        f05 f05Var = new f05(frsFragment.getActivity());
        String m = m();
        if (!StringUtils.isNull(m)) {
            f05Var.setMessage(String.format(this.a.getString(R.string.attention_cancel_dialog_content), m));
        } else {
            f05Var.setMessage(this.a.getString(R.string.obfuscated_res_0x7f0f02fa));
        }
        f05Var.setPositiveButton(this.a.getString(R.string.editor_dialog_yes), new e(this));
        f05Var.setNegativeButton(this.a.getString(R.string.editor_dialog_no), new f(this));
        f05Var.create(this.a.I()).show();
    }
}
