package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdMixFloor;
/* loaded from: classes7.dex */
public class oo7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FrsFragment a;
    public final FrsLoadMoreModel b;
    public final FrsSmartLoadMoreModel c;
    public final FrsModelController d;
    public final mf7 e;
    public final b f;

    /* loaded from: classes7.dex */
    public interface b {
        void removeItem(int i);
    }

    /* loaded from: classes7.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oo7 a;

        public a(oo7 oo7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oo7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oo7Var;
        }

        @Override // com.baidu.tieba.oo7.b
        public void removeItem(int i) {
            int itemCount;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.a.e == null) {
                return;
            }
            try {
                if (this.a.e.g0() != null) {
                    List<ym> data = this.a.e.g0().getData();
                    if (!ListUtils.isEmpty(data) && this.a.e.g0().getAdapter() != null && ((ym) ListUtils.remove(data, i)) != null) {
                        this.a.e.g0().getAdapter().notifyItemRemoved(i);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
                if (this.a.e.g0().getAdapter() == null) {
                    itemCount = 0;
                } else {
                    itemCount = this.a.e.g0().getAdapter().getItemCount();
                }
                nt7.f("frsLoadMoreController-removeItem()", i, itemCount, e);
                throw null;
            }
        }
    }

    public oo7(FrsFragment frsFragment, wo7 wo7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, wo7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new a(this);
        if (frsFragment != null) {
            this.a = frsFragment;
            this.b = new FrsLoadMoreModel(frsFragment, wo7Var);
            FrsSmartLoadMoreModel frsSmartLoadMoreModel = new FrsSmartLoadMoreModel(frsFragment, wo7Var);
            this.c = frsSmartLoadMoreModel;
            frsSmartLoadMoreModel.d0(this.f);
            this.b.j0(this.f);
            this.e = frsFragment.z1();
            FrsModelController W0 = frsFragment.W0();
            this.d = W0;
            this.c.setSortType(W0.s0());
            this.b.setSortType(this.d.s0());
            return;
        }
        throw new NullPointerException("FrsFragment is NullPointerException");
    }

    public boolean b(List<Long> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            FrsModelController frsModelController = this.d;
            if (frsModelController == null || frsModelController.L0()) {
                return false;
            }
            return this.b.R(list);
        }
        return invokeL.booleanValue;
    }

    public void j(ym ymVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ymVar) != null) || ymVar == null) {
            return;
        }
        if (this.d.L0()) {
            this.c.X(ymVar);
        } else {
            this.b.c0(ymVar);
        }
    }

    public void k(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (this.d.L0()) {
                this.c.Y(str);
            } else {
                this.b.d0(str);
            }
        }
    }

    public void m(jv7 jv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jv7Var) == null) {
            this.b.h0(jv7Var);
            this.c.c0(jv7Var);
        }
    }

    public void n(int i) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048588, this, i) != null) || (frsModelController = this.d) == null) {
            return;
        }
        if (frsModelController.L0()) {
            this.c.setHasMore(i);
        } else {
            this.b.setHasMore(i);
        }
    }

    public void o(int i) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048589, this, i) != null) || (frsModelController = this.d) == null) {
            return;
        }
        if (frsModelController.L0()) {
            this.c.setPn(i);
        } else {
            this.b.setPn(i);
        }
    }

    public ArrayList<ym> c(boolean z, boolean z2, ArrayList<ym> arrayList, hba hbaVar, boolean z3, int i, List<AdMixFloor> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, hbaVar, Boolean.valueOf(z3), Integer.valueOf(i), list})) == null) {
            return d(z, z2, arrayList, hbaVar, false, z3, i, list);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<ym> d(boolean z, boolean z2, ArrayList<ym> arrayList, hba hbaVar, boolean z3, boolean z4, int i, List<AdMixFloor> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, hbaVar, Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i), list})) == null) {
            if (this.d == null) {
                return arrayList;
            }
            boolean K0 = this.a.W0().K0();
            if (this.d.L0()) {
                return this.c.P(z, K0, arrayList, z3, z4, i, list);
            }
            return this.b.U(z, K0, z2, arrayList, hbaVar, list, i);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<ym> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.d.L0()) {
                return this.c.Q();
            }
            return this.d.o0();
        }
        return (ArrayList) invokeV.objValue;
    }

    public FrsSmartLoadMoreModel f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (FrsSmartLoadMoreModel) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsModelController frsModelController = this.d;
            if (frsModelController == null) {
                return 1;
            }
            if (frsModelController.L0()) {
                return this.c.getPn();
            }
            return this.b.getPn();
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrsModelController frsModelController = this.d;
            if (frsModelController == null) {
                return -1;
            }
            if (frsModelController.L0()) {
                return this.c.R();
            }
            return this.b.W();
        }
        return invokeV.intValue;
    }

    public void l() {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || (frsModelController = this.d) == null) {
            return;
        }
        if (frsModelController.L0()) {
            this.c.Z();
        } else {
            this.b.g0();
        }
    }

    public void i(String str, String str2, FrsViewData frsViewData) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, frsViewData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (this.d != null && this.e != null && frsViewData != null) {
                this.a.I = System.currentTimeMillis();
                if (this.d.L0()) {
                    if (this.c.R() == 1 && !this.d.J0()) {
                        this.c.setSortType(this.d.s0());
                        this.c.O();
                        int pn = this.c.getPn();
                        this.c.setPn(pn);
                        this.d.O0(pn + 1);
                    }
                } else if (this.d.t0() == 1) {
                    if (!this.b.isLoading && !this.d.J0()) {
                        int pn2 = this.b.getPn();
                        if (this.b.R(frsViewData.getThreadListIds())) {
                            this.b.S();
                            this.b.setSortType(this.d.s0());
                            long j = JavaTypesHelper.toLong(str2, 0L);
                            if (this.d.v0() != null) {
                                str3 = ow9.e(this.d.v0().getThreadList(), false);
                            } else {
                                str3 = "";
                            }
                            this.b.f0(j, frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum, str3);
                        } else if (this.b.W() == 1) {
                            this.b.S();
                            this.b.setPn(pn2);
                            this.d.O0(pn2 + 1);
                            FrsLoadMoreModel frsLoadMoreModel = this.b;
                            frsLoadMoreModel.loadingDone = false;
                            frsLoadMoreModel.loadIndex = 0;
                        }
                    }
                } else if (this.d.M0()) {
                } else {
                    this.d.N0();
                }
            }
        }
    }
}
