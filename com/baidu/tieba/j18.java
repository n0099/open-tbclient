package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Personalized.DataRes;
/* loaded from: classes6.dex */
public class j18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> a;
    public final BdUniqueId b;
    public RecPersonalizePageModel c;
    public ConcernNetModel d;
    public c e;
    public RecPersonalizePageModel.b f;
    public ConcernNetModel.b g;

    /* loaded from: classes6.dex */
    public interface c {
        void a(DataRes dataRes, boolean z, boolean z2);

        void b(String str, String str2, int i, boolean z, int i2);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void d(boolean z, a78 a78Var, boolean z2, String str, String str2, boolean z3);
    }

    public d39 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (d39) invokeV.objValue;
    }

    public void i(d39 d39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, d39Var) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements RecPersonalizePageModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j18 a;

        public a(j18 j18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j18Var;
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) && this.a.e != null) {
                TbSingleton.getInstance().mIsForceLayoutMaintab = true;
                this.a.e.b("", str, i, false, 1);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void b(DataRes dataRes, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (this.a.e != null) {
                    TbSingleton.getInstance().mIsForceLayoutMaintab = true;
                    this.a.e.a(dataRes, z, z2);
                }
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_GET_NET_CACHE_KEY);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ConcernNetModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j18 a;

        public b(j18 j18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j18Var;
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) && this.a.e != null) {
                this.a.e.b("", str, i, false, 0);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes, z) == null) && this.a.e != null) {
                this.a.e.c(dataRes, z);
            }
        }
    }

    public j18(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = RecPersonalizePageModel.e();
        this.f = new a(this);
        this.g = new b(this);
        this.a = tbPageContext;
        this.b = bdUniqueId;
        ConcernNetModel concernNetModel = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.d = concernNetModel;
        concernNetModel.R(this.g);
    }

    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.e = cVar;
        }
    }

    public TbPageContext<BaseFragmentActivity> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public RecPersonalizePageModel.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (RecPersonalizePageModel.b) invokeV.objValue;
    }

    public c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (c) invokeV.objValue;
    }

    public BdUniqueId f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void g(String str, ov5 ov5Var) {
        ConcernNetModel concernNetModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, str, ov5Var) == null) && (concernNetModel = this.d) != null) {
            concernNetModel.P(str, ov5Var);
        }
    }

    public void h(int i, int i2, ov5 ov5Var, int i3, int i4) {
        RecPersonalizePageModel recPersonalizePageModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), ov5Var, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && (recPersonalizePageModel = this.c) != null) {
            recPersonalizePageModel.g(i, i2, ov5Var, i3, i4);
        }
    }
}
