package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AgreeMeActivityConfig;
import com.baidu.tbadk.core.atomData.AtMeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.ReplyMeActivityConfig;
import com.baidu.tieba.immessagecenter.msgtab.data.NotifyType;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class tu8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-391508683, "Lcom/baidu/tieba/tu8$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-391508683, "Lcom/baidu/tieba/tu8$a;");
                    return;
                }
            }
            int[] iArr = new int[NotifyType.values().length];
            iArr[NotifyType.AT_ME.ordinal()] = 1;
            iArr[NotifyType.AGREE_ME.ordinal()] = 2;
            iArr[NotifyType.REPLY_ME.ordinal()] = 3;
            iArr[NotifyType.FANS.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public tu8() {
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

    public final void a(nt8 nt8Var) {
        NotifyType notifyType;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nt8Var) == null) {
            if (nt8Var != null) {
                notifyType = nt8Var.getType();
            } else {
                notifyType = null;
            }
            if (notifyType == null) {
                i = -1;
            } else {
                i = a.$EnumSwitchMapping$0[notifyType.ordinal()];
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            ie8.b().g(4, 0);
                            PersonRedTipManager.getInstance().updateRedTipState(2, false, true);
                            ie5.p0().l();
                            ie5.p0().j0(0);
                            return;
                        }
                        return;
                    }
                    ie8.b().g(2, 0);
                    ie5.p0().o();
                    ie5.p0().m0(0);
                    return;
                }
                ie8.b().g(1, 0);
                ie5.p0().h();
                ie5.p0().f0(0);
                return;
            }
            ie8.b().g(3, 0);
            ie5.p0().j();
            ie5.p0().g0(0);
        }
    }

    public final void b(BaseFragment frag, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frag, i) == null) {
            Intrinsics.checkNotNullParameter(frag, "frag");
            AgreeMeActivityConfig agreeMeActivityConfig = new AgreeMeActivityConfig(frag.getContext());
            BdUniqueId uniqueId = frag.getUniqueId();
            if (uniqueId != null) {
                agreeMeActivityConfig.setLastUniqueId(uniqueId.getId());
            }
            agreeMeActivityConfig.setAgreeNumber(i);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, agreeMeActivityConfig));
        }
    }

    public final void c(BaseFragment frag, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, frag, i) == null) {
            Intrinsics.checkNotNullParameter(frag, "frag");
            AtMeActivityConfig atMeActivityConfig = new AtMeActivityConfig(frag.getContext());
            BdUniqueId uniqueId = frag.getUniqueId();
            if (uniqueId != null) {
                atMeActivityConfig.setLastUniqueId(uniqueId.getId());
            }
            atMeActivityConfig.setAtNumber(i);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atMeActivityConfig));
        }
    }

    public final void d(BaseFragment frag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, frag) == null) {
            Intrinsics.checkNotNullParameter(frag, "frag");
            PersonListActivityConfig personListActivityConfig = new PersonListActivityConfig(frag.getContext(), false, TbadkCoreApplication.getCurrentAccount(), 0);
            BdUniqueId uniqueId = frag.getUniqueId();
            if (uniqueId != null) {
                personListActivityConfig.setLastUniqueId(uniqueId.getId());
            }
            personListActivityConfig.setFansNumber(ie5.p0().y());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, personListActivityConfig));
        }
    }

    public final void e(BaseFragment frag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, frag) == null) {
            Intrinsics.checkNotNullParameter(frag, "frag");
            ReplyMeActivityConfig replyMeActivityConfig = new ReplyMeActivityConfig(frag.getContext());
            replyMeActivityConfig.setFrom(1);
            BdUniqueId uniqueId = frag.getUniqueId();
            if (uniqueId != null) {
                replyMeActivityConfig.setLastUniqueId(uniqueId.getId());
            }
            replyMeActivityConfig.setReplyNumber(ie5.p0().B());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, replyMeActivityConfig));
        }
    }
}
