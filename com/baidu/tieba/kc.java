package com.baidu.tieba;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a extends y6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qb c;
        public final /* synthetic */ boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, DiskFileOperate.Action action, qb qbVar, boolean z) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, action, qbVar, Boolean.valueOf(z)};
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
            this.c = qbVar;
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
                        kc.b(this.c);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qb a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, String str3, String str4, DiskFileOperate.Action action, qb qbVar) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, str2, str3, str4, action, qbVar};
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
            this.a = qbVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.a.F(0L);
                    zb.m().s(this.a);
                    return;
                }
                BdLog.e("Track Log rename fail!");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends y6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qb c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, DiskFileOperate.Action action, qb qbVar) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, action, qbVar};
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
            this.c = qbVar;
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

    public static long a(qb qbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, qbVar)) == null) {
            if (qbVar == null) {
                return -1L;
            }
            if (qbVar.v() <= 0) {
                c cVar = new c(BdStatisticsManager.getInstance().getTrackLogWriteDir(), qbVar.s(), DiskFileOperate.Action.INFO, qbVar);
                cVar.setSdCard(qbVar.C());
                cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                if (t6.g().a(cVar)) {
                    return qbVar.v();
                }
            }
            return qbVar.v();
        }
        return invokeL.longValue;
    }

    public static void b(qb qbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, qbVar) != null) || qbVar == null) {
            return;
        }
        b bVar = new b(BdStatisticsManager.getInstance().getTrackLogWriteDir(), qbVar.s(), BdStatisticsManager.getInstance().getTrackLogWriteDir(), qbVar.r(), DiskFileOperate.Action.RENAME, qbVar);
        bVar.setSdCard(qbVar.C());
        bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        t6.g().a(bVar);
    }

    public static void c(qb qbVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65538, null, qbVar, z) == null) && qbVar != null && qbVar.l() != 0) {
            a aVar = new a(BdStatisticsManager.getInstance().getTrackLogWriteDir(), qbVar.s(), DiskFileOperate.Action.APPEND, qbVar, z);
            aVar.setSdCard(qbVar.C());
            aVar.b(qbVar.z().toString());
            qbVar.f();
            if (!qbVar.A()) {
                aVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                aVar.setTrySuccessWeight(3);
            }
            if (!t6.g().a(aVar)) {
                BdLog.e("Track Log write to disk fail!");
            }
        }
    }
}
