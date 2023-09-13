package com.baidu.tieba;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a extends ac {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ug c;
        public final /* synthetic */ boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, DiskFileOperate.Action action, ug ugVar, boolean z) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, action, ugVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (DiskFileOperate.Action) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ugVar;
            this.d = z;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.c.G(getFileInfo().length());
                    if (this.d || this.c.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                        kh.c(this.c, false, false, false);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ug a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, String str3, String str4, DiskFileOperate.Action action, ug ugVar, boolean z, boolean z2, boolean z3) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, str2, str3, str4, action, ugVar, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3], (DiskFileOperate.Action) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ugVar;
            this.b = z;
            this.c = z2;
            this.d = z3;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.a.G(0L);
                    dh.m().r(this.a, this.b, this.c, this.d);
                } else if (this.a.t() >= 307200 && this.a.o() != "stat") {
                    kh.a(BdStatisticsManager.getInstance().getWriteDir(), this.a.r(), this.a);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends ac {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ug c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, DiskFileOperate.Action action, ug ugVar) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, action, ugVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (DiskFileOperate.Action) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ugVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.c.G(getFileInfo().length());
                }
            }
        }
    }

    public static void a(String str, String str2, ug ugVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, str2, ugVar) == null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
            diskFileOperate.setSdCard(ugVar.E());
            diskFileOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            vb.f().a(diskFileOperate);
        }
    }

    public static long b(ug ugVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ugVar)) == null) {
            if (ugVar == null) {
                return -1L;
            }
            if (ugVar.t() <= 0) {
                c cVar = new c(BdStatisticsManager.getInstance().getWriteDir(), ugVar.s(), DiskFileOperate.Action.INFO, ugVar);
                cVar.setSdCard(ugVar.E());
                cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                if (vb.f().a(cVar)) {
                    return ugVar.t();
                }
            }
            return ugVar.t();
        }
        return invokeL.longValue;
    }

    public static void c(ug ugVar, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{ugVar, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) != null) || ugVar == null) {
            return;
        }
        b bVar = new b(BdStatisticsManager.getInstance().getWriteDir(), ugVar.s(), BdStatisticsManager.getInstance().getWriteDir(), ugVar.r(), DiskFileOperate.Action.RENAME, ugVar, z, z2, z3);
        bVar.setSdCard(ugVar.E());
        bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        vb.f().a(bVar);
    }

    public static void d(ug ugVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65539, null, ugVar, z) == null) && ugVar != null && ugVar.m() != 0) {
            a aVar = new a(BdStatisticsManager.getInstance().getWriteDir(), ugVar.s(), DiskFileOperate.Action.APPEND, ugVar, z);
            aVar.setSdCard(ugVar.E());
            aVar.b(ugVar.x().toString());
            ugVar.d();
            if (!ugVar.A()) {
                aVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                aVar.setTrySuccessWeight(3);
            }
            vb.f().a(aVar);
        }
    }
}
