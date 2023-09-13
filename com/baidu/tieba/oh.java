package com.baidu.tieba;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class oh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
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
                    this.c.F(getFileInfo().length());
                    if (this.d || this.c.l() > 20480) {
                        oh.b(this.c);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ug a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, String str3, String str4, DiskFileOperate.Action action, ug ugVar) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, str2, str3, str4, action, ugVar};
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
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.a.F(0L);
                    dh.m().s(this.a);
                    return;
                }
                BdLog.e("Track Log rename fail!");
            }
        }
    }

    /* loaded from: classes7.dex */
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
                    this.c.F(getFileInfo().length());
                }
            }
        }
    }

    public static long a(ug ugVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ugVar)) == null) {
            if (ugVar == null) {
                return -1L;
            }
            if (ugVar.v() <= 0) {
                c cVar = new c(BdStatisticsManager.getInstance().getTrackLogWriteDir(), ugVar.s(), DiskFileOperate.Action.INFO, ugVar);
                cVar.setSdCard(ugVar.C());
                cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                if (vb.f().a(cVar)) {
                    return ugVar.v();
                }
            }
            return ugVar.v();
        }
        return invokeL.longValue;
    }

    public static void b(ug ugVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, ugVar) != null) || ugVar == null) {
            return;
        }
        b bVar = new b(BdStatisticsManager.getInstance().getTrackLogWriteDir(), ugVar.s(), BdStatisticsManager.getInstance().getTrackLogWriteDir(), ugVar.r(), DiskFileOperate.Action.RENAME, ugVar);
        bVar.setSdCard(ugVar.C());
        bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        vb.f().a(bVar);
    }

    public static void c(ug ugVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65538, null, ugVar, z) == null) && ugVar != null && ugVar.l() != 0) {
            a aVar = new a(BdStatisticsManager.getInstance().getTrackLogWriteDir(), ugVar.s(), DiskFileOperate.Action.APPEND, ugVar, z);
            aVar.setSdCard(ugVar.C());
            aVar.b(ugVar.z().toString());
            ugVar.f();
            if (!ugVar.A()) {
                aVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                aVar.setTrySuccessWeight(3);
            }
            if (!vb.f().a(aVar)) {
                BdLog.e("Track Log write to disk fail!");
            }
        }
    }
}
