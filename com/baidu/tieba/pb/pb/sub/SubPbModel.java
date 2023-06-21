package com.baidu.tieba.pb.pb.sub;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.a59;
import com.baidu.tieba.b0a;
import com.baidu.tieba.i0a;
import com.baidu.tieba.jb;
import com.baidu.tieba.k9;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.ug;
import com.baidu.tieba.wi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class SubPbModel extends DataModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<a59> A;
    public boolean B;
    public i0a C;
    public SmallTailInfo D;
    public ArrayList<String> E;
    public ConcurrentHashMap<String, ImageUrlData> F;
    public boolean G;
    public int H;
    public PbFakeFloorModel I;
    public boolean J;
    public boolean K;
    public String L;
    public String M;
    public int N;
    public String O;
    public String P;
    public int Q;
    public int R;
    public int S;

    /* renamed from: T  reason: collision with root package name */
    public int f1155T;
    public String U;
    public int V;
    public boolean W;
    public boolean X;
    public String Y;
    public String Z;
    public int a;
    public String a0;
    public String b;
    public boolean b0;
    public String c;
    public boolean c0;
    public String d;
    public SubPbRequestMessage d0;
    public boolean e;
    public jb e0;
    public boolean f;
    public boolean g;
    public String h;
    public String i;
    public String j;
    public boolean k;
    public String l;
    public String m;
    @Nullable
    public WorksInfoData n;
    public boolean o;
    public boolean p;
    public int pageFromType;
    public int q;
    public String r;
    public TbPageContext<?> s;
    public a59 t;
    public b u;
    public int v;
    public ArrayList<IconData> w;
    public AntiData x;
    public AttentionHostData y;
    public boolean z;

    /* loaded from: classes7.dex */
    public interface b {
        void a(boolean z, int i, String str, a59 a59Var);
    }

    public void u1(PbFakeFloorModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, bVar) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a extends jb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SubPbModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SubPbModel subPbModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subPbModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = subPbModel;
        }

        @Override // com.baidu.tieba.jb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            boolean z;
            a59 a59Var;
            String str;
            boolean z2;
            a59 a59Var2;
            long j2;
            long j3;
            int i;
            a59 a59Var3;
            ThreadData j4;
            a59 a59Var4;
            ThreadData j5;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || this.a.unique_id != responsedMessage.getOrginalMessage().getTag()) {
                return;
            }
            this.a.B = false;
            if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                this.a.s.getPageActivity().finish();
            }
            boolean z3 = responsedMessage instanceof SubPbHttpResponseMessage;
            long j6 = 0;
            if (z3) {
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                subPbHttpResponseMessage.getDownSize();
                j = responsedMessage.getCostTime();
                if (subPbHttpResponseMessage != null && (a59Var4 = subPbHttpResponseMessage.pbFloorData) != null && (j5 = a59Var4.j()) != null) {
                    this.a.C0(j5);
                }
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.a.A.add(subPbHttpResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
                z = true;
            } else {
                j = 0;
                z = false;
            }
            boolean z4 = responsedMessage instanceof SubPbSocketResponseMessage;
            if (z4) {
                j6 = responsedMessage.getCostTime();
                SubPbSocketResponseMessage subPbSocketResponseMessage = (SubPbSocketResponseMessage) responsedMessage;
                if (subPbSocketResponseMessage != null && (a59Var3 = subPbSocketResponseMessage.pbFloorData) != null && (j4 = a59Var3.j()) != null) {
                    this.a.C0(j4);
                }
                if (subPbSocketResponseMessage.isTreatDelPage()) {
                    if (!subPbSocketResponseMessage.hasError()) {
                        this.a.A.add(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            if (this.a.A != null && this.a.A.size() > 0) {
                try {
                    for (int size = this.a.A.size() - 1; size >= 0; size--) {
                        this.a.t.p((a59) this.a.A.get(size), true);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                this.a.A.clear();
            }
            int error = responsedMessage.getError();
            String errorString = responsedMessage.getErrorString();
            if (this.a.C == null) {
                this.a.C = new i0a("pbfloorStat");
            }
            if (this.a.C != null) {
                if (error == 0) {
                    if (z3) {
                        i = ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        j2 = j6;
                        j3 = responsedMessage.getCostTime();
                    } else if (z4) {
                        int downSize = ((SubPbSocketResponseMessage) responsedMessage).getDownSize();
                        j2 = responsedMessage.getCostTime();
                        j3 = j;
                        i = downSize;
                    } else {
                        j2 = j6;
                        j3 = j;
                        i = -1;
                    }
                    long j7 = i;
                    a59Var = null;
                    str = errorString;
                    z2 = z4;
                    this.a.C.b(z, true, error, errorString, j7, j3, j2);
                    this.a.C = new i0a("pbfloorStat");
                    this.a.C = null;
                } else {
                    a59Var = null;
                    str = errorString;
                    z2 = z4;
                }
                if (responsedMessage != null && ((z2 || z3) && responsedMessage.getError() == 0)) {
                    if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                        if (z3) {
                            a59Var2 = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                        } else if (z2) {
                            a59Var2 = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                        } else {
                            a59Var2 = a59Var;
                        }
                        if (a59Var2.c().errorno.intValue() != 0) {
                            if (this.a.u != null) {
                                this.a.u.a(false, a59Var2.l.errorno.intValue(), a59Var2.l.errmsg, a59Var);
                                return;
                            }
                            return;
                        }
                        if (a59Var2.j() != null && a59Var2.j().getAuthor() != null && ListUtils.isEmpty(a59Var2.g().q().getIconInfo()) && this.a.w != null) {
                            a59Var2.g().q().setIconInfo(this.a.w);
                        }
                        if (a59Var2.g() != null) {
                            this.a.c = a59Var2.g().S();
                        }
                        if (a59Var2.j() != null) {
                            this.a.b = a59Var2.j().getId();
                            this.a.p = false;
                            this.a.r = a59Var2.j().getMarkID();
                            a59Var2.j().worksInfoData = this.a.n;
                        }
                        if (this.a.r != null && this.a.c != null && this.a.r.equals(this.a.c)) {
                            this.a.p = true;
                        }
                        this.a.r1(a59Var2);
                        if (this.a.u != null) {
                            this.a.u.a(this.a.Z0(), error, str, this.a.t);
                            return;
                        }
                        return;
                    }
                    return;
                }
                String str2 = str;
                if (this.a.u != null) {
                    this.a.u.a(false, error, str2, a59Var);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = false;
        this.pageFromType = 0;
        this.o = false;
        this.p = false;
        this.q = 0;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = 0;
        this.z = false;
        this.A = null;
        this.B = false;
        this.C = null;
        this.G = true;
        this.H = 0;
        this.I = null;
        this.J = false;
        this.e0 = new a(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.s = tbPageContext;
        this.A = new ArrayList<>();
        this.t = new a59();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.e0);
        registerListener(this.e0);
    }

    public final SubPbRequestMessage z0(Integer num) {
        InterceptResult invokeL;
        long j;
        long j2;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, num)) == null) {
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int l = wi.l(TbadkCoreApplication.getInst().getApp());
            int j3 = wi.j(TbadkCoreApplication.getInst().getApp());
            long g = ug.g(this.c, 0L);
            long g2 = ug.g(this.i, 0L);
            if (1 != this.a) {
                j = ug.g(this.c, 0L);
                j2 = 0;
            } else if (!TextUtils.isEmpty(this.i) && g == g2 && !this.K) {
                j2 = g2;
                j = 0;
            } else {
                j = g;
                j2 = g2;
            }
            if (num == null) {
                intValue = s1();
            } else {
                intValue = num.intValue();
            }
            SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.s.getPageActivity(), Long.parseLong(this.b), j, j2, intValue, l, j3, f, this.d, 0);
            subPbRequestMessage.setOriUgcNid(this.L);
            subPbRequestMessage.setOriUgcTid(this.M);
            subPbRequestMessage.setOriUgcType(this.N);
            subPbRequestMessage.setOriUgcVid(this.O);
            if (j2 != 0) {
                subPbRequestMessage.setOriUgcTopPid(this.P);
            }
            subPbRequestMessage.setForumId(ug.g(this.l, 0L));
            return subPbRequestMessage;
        }
        return (SubPbRequestMessage) invokeL.objValue;
    }

    public void v1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            this.J = z;
        }
    }

    public void w1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            this.p = z;
        }
    }

    public void x1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, str) == null) {
            this.r = str;
        }
    }

    public void y1(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, bVar) == null) {
            this.u = bVar;
        }
    }

    public void A0() {
        a59 a59Var;
        int f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.v > 0 && (a59Var = this.t) != null && (f = a59Var.f()) > 0) {
                int i = ((this.v + f) - 1) / f;
                int b2 = this.t.b();
                for (int i2 = i - 1; i2 >= 0; i2--) {
                    SubPbRequestMessage z0 = z0(Integer.valueOf(b2 - i2));
                    this.d0 = z0;
                    z0.setTreatDelPage(true);
                    sendMessage(this.d0);
                }
            }
            this.v = 0;
        }
    }

    public AttentionHostData E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.y == null) {
                this.y = new AttentionHostData();
                a59 a59Var = this.t;
                if (a59Var != null && a59Var.j() != null && this.t.j().getAuthor() != null) {
                    this.y.parserWithMetaData(this.t.j().getAuthor());
                }
            }
            return this.y;
        }
        return (AttentionHostData) invokeV.objValue;
    }

    public void B0(String str) {
        a59 a59Var;
        a59 a59Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !TextUtils.isEmpty(str) && (a59Var = this.t) != null && a59Var.i() != null) {
            ArrayList<b0a> i = this.t.i();
            int size = i.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (str.equals(i.get(i2).S())) {
                    i.remove(i2);
                    this.v++;
                    this.t.A(a59Var2.k() - 1);
                    return;
                }
            }
        }
    }

    public MarkData N0(b0a b0aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, b0aVar)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.b);
            markData.setPostId(b0aVar.S());
            markData.setTime(date.getTime());
            markData.setHostMode(false);
            markData.setId(this.b);
            markData.setFloor(b0aVar.I());
            return markData;
        }
        return (MarkData) invokeL.objValue;
    }

    public final void C0(@NonNull ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) {
            threadData.isTiebaPlusAdThread = d0();
            threadData.tiebaPlusOrderId = Z();
            threadData.tiebaPlusToken = a0();
            threadData.tiebaPlusExtraParam = a0();
            threadData.tiebaplusCantDelete = e0();
            threadData.setDispatchedForumIdWithString(U());
        }
    }

    public boolean p1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048634, this, i)) == null) {
            if (this.B) {
                return false;
            }
            cancelMessage();
            if (this.b != null && this.c != null) {
                A0();
                this.a = i;
                SubPbRequestMessage y0 = y0();
                this.d0 = y0;
                sendMessage(y0);
                return true;
            }
            this.B = false;
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void r1(a59 a59Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, a59Var) == null) {
            ArrayList<b0a> i = a59Var.i();
            if (i == null || i.size() == 0) {
                a59Var.u(this.t.b());
            }
            int i2 = this.a;
            if (i2 == 1) {
                this.t = a59Var;
            } else if (i2 == 2) {
                this.t.p(a59Var, true);
            } else if (i2 == 3) {
                this.t.q(a59Var, false);
            } else {
                this.t.p(a59Var, false);
            }
        }
    }

    public AntiData D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.x;
        }
        return (AntiData) invokeV.objValue;
    }

    public a59 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.t;
        }
        return (a59) invokeV.objValue;
    }

    public int G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f1155T;
        }
        return invokeV.intValue;
    }

    public int H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.S;
        }
        return invokeV.intValue;
    }

    public String I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.U;
        }
        return (String) invokeV.objValue;
    }

    public String J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    public int K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.Q;
        }
        return invokeV.intValue;
    }

    public String L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public int M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.R;
        }
        return invokeV.intValue;
    }

    public String O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.r;
        }
        return (String) invokeV.objValue;
    }

    public int P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.H;
        }
        return invokeV.intValue;
    }

    public int Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.pageFromType;
        }
        return invokeV.intValue;
    }

    public String R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public SmallTailInfo S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.D;
        }
        return (SmallTailInfo) invokeV.objValue;
    }

    public String T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    @Nullable
    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return J0();
        }
        return (String) invokeV.objValue;
    }

    public String U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (!StringUtils.isNull(this.b) && !"0".equals(this.b)) {
                return this.b;
            }
            return this.L;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public int V() {
        InterceptResult invokeV;
        b0a g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            a59 a59Var = this.t;
            if (a59Var != null && (g = a59Var.g()) != null) {
                return g.I();
            }
            return super.V();
        }
        return invokeV.intValue;
    }

    public ArrayList<String> V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.E;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public ConcurrentHashMap<String, ImageUrlData> W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.F;
        }
        return (ConcurrentHashMap) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return T0();
        }
        return (String) invokeV.objValue;
    }

    public int X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.q;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.a0;
        }
        return (String) invokeV.objValue;
    }

    public int Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.V;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.Y;
        }
        return (String) invokeV.objValue;
    }

    public boolean Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            a59 a59Var = this.t;
            if (a59Var != null && a59Var.g() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.Z;
        }
        return (String) invokeV.objValue;
    }

    public boolean c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.G;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            cancelMessage();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.X;
        }
        return invokeV.booleanValue;
    }

    public boolean d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.c0;
        }
        return invokeV.booleanValue;
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            cancelMessage();
            MessageManager.getInstance().unRegisterListener(this.e0);
            PbFakeFloorModel pbFakeFloorModel = this.I;
            if (pbFakeFloorModel != null) {
                pbFakeFloorModel.unRegisterListener();
            }
            q1();
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.b0;
        }
        return invokeV.booleanValue;
    }

    public boolean e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            z1();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return "hot_topic".equals(getStType());
        }
        return invokeV.booleanValue;
    }

    public boolean g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            a59 a59Var = this.t;
            if (a59Var != null && a59Var.d() != null) {
                return this.t.d().getId();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getFromForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public String getStType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public boolean h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public boolean i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.W;
        }
        return invokeV.booleanValue;
    }

    public boolean j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.p;
        }
        return invokeV.booleanValue;
    }

    public boolean k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.J;
        }
        return invokeV.booleanValue;
    }

    public boolean l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return p1(0);
        }
        return invokeV.booleanValue;
    }

    public boolean m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public boolean n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return p1(1);
        }
        return invokeV.booleanValue;
    }

    public boolean o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return p1(3);
        }
        return invokeV.booleanValue;
    }

    public final void q1() {
        i0a i0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048635, this) == null) && (i0aVar = this.C) != null) {
            i0aVar.a();
            this.C = null;
        }
    }

    public final SubPbRequestMessage y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            this.B = true;
            return z0(null);
        }
        return (SubPbRequestMessage) invokeV.objValue;
    }

    public boolean z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return p1(2);
        }
        return invokeV.booleanValue;
    }

    public void a1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048609, this, bundle) != null) || bundle == null) {
            return;
        }
        this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
        this.b = bundle.getString("thread_id");
        this.c = bundle.getString("post_id");
        this.d = bundle.getString("st_type");
        this.l = bundle.getString("from_forum_id");
        this.m = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
        this.n = (WorksInfoData) bundle.getSerializable(SubPbActivityConfig.KEY_WORKS_INFO_DATA);
        this.e = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        this.f = bundle.getBoolean("is_jump_from_video_tab", false);
        this.g = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_FOLD_COMMENT, false);
        this.h = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
        this.o = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
        this.i = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
        this.q = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
        this.K = bundle.getBoolean(SubPbActivityConfig.KEI_IS_JUMP_FROM_AGREE_ME, false);
        String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
        if (!StringUtils.isNull(string)) {
            this.D = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
        }
        SmallTailInfo smallTailInfo = this.D;
        if (smallTailInfo != null) {
            smallTailInfo.updateShowInfo();
        }
        String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
        if (!StringUtils.isNull(string2)) {
            AntiData antiData = new AntiData();
            this.x = antiData;
            antiData.parserJson(string2);
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
        if (!ListUtils.isEmpty(stringArrayList)) {
            this.w = new ArrayList<>();
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                if (iconData != null) {
                    this.w.add(iconData);
                }
            }
        }
        this.z = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        this.j = bundle.getString("high_light_post_id");
        this.k = bundle.getBoolean(SubPbActivityConfig.KEY_IS_USE_SPID, false);
        this.Q = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
        this.R = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
        this.Q = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
        this.R = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
        this.S = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
        this.f1155T = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
        this.U = bundle.getString(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
        this.V = bundle.getInt(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        this.W = bundle.getBoolean(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, false);
        this.X = bundle.getBoolean("key_is_tieba_plus");
        this.Y = bundle.getString("key_tieba_plus_order_id");
        this.Z = bundle.getString("key_tieba_plus_token");
        this.a0 = bundle.getString("key_tieba_extra_param");
        this.b0 = bundle.getBoolean("key_tieba_plus_cant_delete");
        this.c0 = bundle.getBoolean(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData b0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            a59 a59Var = this.t;
            if (a59Var != null && a59Var.d() != null && this.t.j() != null && this.t.g() != null) {
                WriteData writeData = new WriteData();
                writeData.sourceFrom = String.valueOf(this.pageFromType);
                writeData.setForumName(this.t.d().getName());
                writeData.setForumId(this.t.d().getId());
                writeData.setFromForumId(this.m);
                writeData.setFloor(this.t.g().S());
                writeData.setType(2);
                writeData.setThreadId(this.t.j().getId());
                writeData.setFloorNum(0);
                return writeData;
            }
            return null;
        }
        return (WriteData) invokeL.objValue;
    }

    public void b1(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048611, this, intent) != null) || intent == null) {
            return;
        }
        this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
        this.b = intent.getStringExtra("thread_id");
        this.c = intent.getStringExtra("post_id");
        this.d = intent.getStringExtra("st_type");
        this.l = intent.getStringExtra("from_forum_id");
        this.m = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
        this.n = (WorksInfoData) intent.getSerializableExtra(SubPbActivityConfig.KEY_WORKS_INFO_DATA);
        this.e = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        this.f = intent.getBooleanExtra("is_jump_from_video_tab", false);
        this.g = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_FOLD_COMMENT, false);
        this.h = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
        this.o = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
        this.i = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
        this.q = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
        SmallTailInfo smallTailInfo = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
        this.D = smallTailInfo;
        if (smallTailInfo != null) {
            smallTailInfo.updateShowInfo();
        }
        this.x = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
        this.w = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
        this.z = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        this.K = intent.getBooleanExtra(SubPbActivityConfig.KEI_IS_JUMP_FROM_AGREE_ME, false);
        this.L = intent.getStringExtra("key_ori_ugc_nid");
        this.M = intent.getStringExtra("key_ori_ugc_tid");
        this.N = intent.getIntExtra("key_ori_ugc_type", 0);
        this.O = intent.getStringExtra("key_ori_ugc_vid");
        this.P = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
        Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
        if (bundleExtra != null) {
            ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
            this.F = new ConcurrentHashMap<>();
            if (stringArrayList != null) {
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!StringUtils.isNull(next)) {
                        this.F.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                    }
                }
            }
            this.E = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
            this.G = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
            this.H = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
        }
        this.j = intent.getStringExtra("high_light_post_id");
        this.k = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_USE_SPID, false);
        this.Q = intent.getIntExtra(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
        this.R = intent.getIntExtra(SubPbActivityConfig.KEY_IS_MANAGER, 0);
        this.S = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
        this.f1155T = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
        this.U = intent.getStringExtra(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
        this.V = intent.getIntExtra(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        this.W = intent.getBooleanExtra(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, false);
        this.X = intent.getBooleanExtra("key_is_tieba_plus", false);
        this.Y = intent.getStringExtra("key_tieba_plus_order_id");
        this.Z = intent.getStringExtra("key_tieba_plus_token");
        this.a0 = intent.getStringExtra("key_tieba_extra_param");
        this.b0 = intent.getBooleanExtra("key_tieba_plus_cant_delete", false);
        this.c0 = intent.getBooleanExtra(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT, false);
    }

    public int s1() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            int b2 = this.t.b();
            if (b2 == 0 || (i = this.a) == 0 || (i == 2 && this.t.i().size() != 0 && this.t.i().size() % this.t.f() == 0)) {
                return b2 + 1;
            }
            if (this.a == 3 && b2 > 0) {
                return this.t.h() - 1;
            }
            return b2;
        }
        return invokeV.intValue;
    }

    public void t1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048638, this, bundle) != null) || bundle == null) {
            return;
        }
        bundle.putString("thread_id", this.b);
        bundle.putString("post_id", this.c);
        bundle.putString("st_type", this.d);
        bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.e);
        bundle.putBoolean("is_jump_from_video_tab", this.f);
        bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_FOLD_COMMENT, this.g);
        bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.h);
        bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.i);
        bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.o);
        bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.q);
        bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.D));
        AntiData antiData = this.x;
        if (antiData != null) {
            bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, antiData.toJsonString());
        }
        if (!ListUtils.isEmpty(this.w)) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<IconData> it = this.w.iterator();
            while (it.hasNext()) {
                String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                if (!StringUtils.isNull(jsonStrWithObject)) {
                    arrayList.add(jsonStrWithObject);
                }
            }
            bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
        }
        bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        bundle.putString("from_forum_id", this.l);
        bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.m);
        bundle.putSerializable(SubPbActivityConfig.KEY_WORKS_INFO_DATA, this.n);
        bundle.putString("high_light_post_id", this.j);
        bundle.putBoolean("high_light_post_id", this.k);
        bundle.putBoolean(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, this.W);
        bundle.putBoolean("key_is_tieba_plus", this.X);
        bundle.putString("key_tieba_plus_order_id", this.Y);
        bundle.putString("key_tieba_plus_token", this.Z);
        bundle.putString("key_tieba_extra_param", this.a0);
        bundle.putBoolean("key_tieba_plus_cant_delete", this.b0);
        bundle.putBoolean(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT, this.c0);
    }
}
