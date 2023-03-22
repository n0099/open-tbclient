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
import com.baidu.tieba.a9;
import com.baidu.tieba.aj8;
import com.baidu.tieba.bc9;
import com.baidu.tieba.gg;
import com.baidu.tieba.hi;
import com.baidu.tieba.ic9;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.za;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class SubPbModel extends DataModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<aj8> A;
    public boolean B;
    public ic9 C;
    public SmallTailInfo D;
    public boolean E;
    public ArrayList<String> F;
    public ConcurrentHashMap<String, ImageUrlData> G;
    public boolean H;
    public int I;
    public PbFakeFloorModel J;
    public boolean K;
    public boolean L;
    public String M;
    public String N;
    public int O;
    public String P;
    public String Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public String V;
    public int W;
    public boolean X;
    public boolean Y;
    public String Z;
    public int a;
    public String a0;
    public String b;
    public String b0;
    public String c;
    public boolean c0;
    public String d;
    public boolean d0;
    public boolean e;
    public SubPbRequestMessage e0;
    public boolean f;
    public za f0;
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
    public aj8 t;
    public b u;
    public int v;
    public ArrayList<IconData> w;
    public AntiData x;
    public AttentionHostData y;
    public boolean z;

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, int i, String str, aj8 aj8Var);
    }

    public void u1(PbFakeFloorModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, bVar) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends za {
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

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            boolean z;
            aj8 aj8Var;
            String str;
            boolean z2;
            aj8 aj8Var2;
            long j2;
            long j3;
            int i;
            aj8 aj8Var3;
            ThreadData l;
            aj8 aj8Var4;
            ThreadData l2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || this.a.unique_id != responsedMessage.getOrginalMessage().getTag()) {
                return;
            }
            this.a.B = false;
            if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                this.a.s.getPageActivity().finish();
            }
            boolean z3 = responsedMessage instanceof SubPbHttpResponseMessage;
            long j4 = 0;
            if (z3) {
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                subPbHttpResponseMessage.getDownSize();
                j = responsedMessage.getCostTime();
                if (subPbHttpResponseMessage != null && (aj8Var4 = subPbHttpResponseMessage.pbFloorData) != null && (l2 = aj8Var4.l()) != null) {
                    this.a.B0(l2);
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
                j4 = responsedMessage.getCostTime();
                SubPbSocketResponseMessage subPbSocketResponseMessage = (SubPbSocketResponseMessage) responsedMessage;
                if (subPbSocketResponseMessage != null && (aj8Var3 = subPbSocketResponseMessage.pbFloorData) != null && (l = aj8Var3.l()) != null) {
                    this.a.B0(l);
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
                        aj8 aj8Var5 = (aj8) this.a.A.get(size);
                        if (this.a.E) {
                            this.a.t.t(aj8Var5, true);
                        } else {
                            this.a.t.r(aj8Var5, true);
                        }
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                this.a.A.clear();
            }
            int error = responsedMessage.getError();
            String errorString = responsedMessage.getErrorString();
            if (this.a.C == null) {
                this.a.C = new ic9("pbfloorStat");
            }
            if (this.a.C != null) {
                if (error == 0) {
                    if (z3) {
                        i = ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        j2 = j4;
                        j3 = responsedMessage.getCostTime();
                    } else if (z4) {
                        int downSize = ((SubPbSocketResponseMessage) responsedMessage).getDownSize();
                        j2 = responsedMessage.getCostTime();
                        j3 = j;
                        i = downSize;
                    } else {
                        j2 = j4;
                        j3 = j;
                        i = -1;
                    }
                    long j5 = i;
                    aj8Var = null;
                    str = errorString;
                    z2 = z4;
                    this.a.C.b(z, true, error, errorString, j5, j3, j2);
                    this.a.C = new ic9("pbfloorStat");
                    this.a.C = null;
                } else {
                    aj8Var = null;
                    str = errorString;
                    z2 = z4;
                }
                if (responsedMessage != null && ((z2 || z3) && responsedMessage.getError() == 0)) {
                    if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                        if (z3) {
                            aj8Var2 = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                        } else if (z2) {
                            aj8Var2 = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                        } else {
                            aj8Var2 = aj8Var;
                        }
                        if (aj8Var2.c().errorno.intValue() != 0) {
                            if (this.a.u != null) {
                                this.a.u.a(false, aj8Var2.m.errorno.intValue(), aj8Var2.m.errmsg, aj8Var);
                                return;
                            }
                            return;
                        }
                        if (aj8Var2.l() != null && aj8Var2.l().getAuthor() != null) {
                            aj8Var2.l().getAuthor().getUserId();
                            if (ListUtils.isEmpty(aj8Var2.i().r().getIconInfo()) && this.a.w != null) {
                                aj8Var2.i().r().setIconInfo(this.a.w);
                            }
                        }
                        if (aj8Var2.i() != null) {
                            this.a.c = aj8Var2.i().O();
                        }
                        if (aj8Var2.l() != null) {
                            this.a.b = aj8Var2.l().getId();
                            this.a.p = aj8Var2.f();
                            this.a.r = aj8Var2.l().getMarkID();
                            aj8Var2.l().worksInfoData = this.a.n;
                        }
                        if (this.a.r != null && this.a.c != null && this.a.r.equals(this.a.c)) {
                            this.a.p = true;
                        }
                        if (this.a.E) {
                            this.a.q1(aj8Var2);
                        } else {
                            this.a.r1(aj8Var2);
                        }
                        if (this.a.u != null) {
                            this.a.u.a(this.a.Y0(), error, str, this.a.t);
                            return;
                        }
                        return;
                    }
                    return;
                }
                String str2 = str;
                if (this.a.u != null) {
                    this.a.u.a(false, error, str2, aj8Var);
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
                super((a9) newInitContext.callArgs[0]);
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
        this.H = true;
        this.I = 0;
        this.J = null;
        this.K = false;
        this.f0 = new a(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.s = tbPageContext;
        this.A = new ArrayList<>();
        this.t = new aj8();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.f0);
        registerListener(this.f0);
    }

    public void v1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            this.K = z;
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
        if (interceptable == null || interceptable.invokeL(1048643, this, str) == null) {
            this.r = str;
        }
    }

    public void y1(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, bVar) == null) {
            this.u = bVar;
        }
    }

    public void A0(String str) {
        aj8 aj8Var;
        aj8 aj8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !TextUtils.isEmpty(str) && (aj8Var = this.t) != null && aj8Var.k() != null) {
            ArrayList<bc9> k = this.t.k();
            int size = k.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(k.get(i).O())) {
                    k.remove(i);
                    this.v++;
                    this.t.F(aj8Var2.m() - 1);
                    return;
                }
            }
        }
    }

    public MarkData M0(bc9 bc9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bc9Var)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.b);
            markData.setPostId(bc9Var.O());
            markData.setTime(date.getTime());
            markData.setHostMode(false);
            markData.setId(this.b);
            markData.setFloor(bc9Var.E());
            return markData;
        }
        return (MarkData) invokeL.objValue;
    }

    public final void B0(@NonNull ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) {
            threadData.isTiebaPlusAdThread = a0();
            threadData.tiebaPlusOrderId = W();
            threadData.tiebaPlusToken = X();
            threadData.tiebaPlusExtraParam = X();
            threadData.tiebaplusCantDelete = b0();
            threadData.setDispatchedForumIdWithString(R());
        }
    }

    public boolean o1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048633, this, i)) == null) {
            if (this.B) {
                return false;
            }
            cancelMessage();
            if (this.b != null && this.c != null) {
                z0();
                this.a = i;
                SubPbRequestMessage x0 = x0();
                this.e0 = x0;
                sendMessage(x0);
                return true;
            }
            this.B = false;
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void q1(aj8 aj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, aj8Var) == null) {
            int i = this.a;
            if (i == 1) {
                this.t = aj8Var;
                aj8Var.H();
            } else if (i == 2) {
                this.t.t(aj8Var, true);
            } else if (i == 3) {
                this.t.u(aj8Var, false);
            } else {
                this.t.s(aj8Var);
            }
        }
    }

    public final void r1(aj8 aj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, aj8Var) == null) {
            ArrayList<bc9> k = aj8Var.k();
            if (k == null || k.size() == 0) {
                aj8Var.z(this.t.b());
            }
            int i = this.a;
            if (i == 1) {
                this.t = aj8Var;
            } else if (i == 2) {
                this.t.r(aj8Var, true);
            } else if (i == 3) {
                this.t.v(aj8Var, false);
            } else {
                this.t.r(aj8Var, false);
            }
        }
    }

    public AntiData C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.x;
        }
        return (AntiData) invokeV.objValue;
    }

    public aj8 E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.t;
        }
        return (aj8) invokeV.objValue;
    }

    public int F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.U;
        }
        return invokeV.intValue;
    }

    public int G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.T;
        }
        return invokeV.intValue;
    }

    public String H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.V;
        }
        return (String) invokeV.objValue;
    }

    public String I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    public int J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.R;
        }
        return invokeV.intValue;
    }

    public String K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public int L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.S;
        }
        return invokeV.intValue;
    }

    public String N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.r;
        }
        return (String) invokeV.objValue;
    }

    public int O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.I;
        }
        return invokeV.intValue;
    }

    public int P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.pageFromType;
        }
        return invokeV.intValue;
    }

    public String Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    @Nullable
    public String R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return I0();
        }
        return (String) invokeV.objValue;
    }

    public SmallTailInfo R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.D;
        }
        return (SmallTailInfo) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public int S() {
        InterceptResult invokeV;
        bc9 i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            aj8 aj8Var = this.t;
            if (aj8Var != null && (i = aj8Var.i()) != null) {
                return i.E();
            }
            return super.S();
        }
        return invokeV.intValue;
    }

    public String S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public String T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (!StringUtils.isNull(this.b) && !"0".equals(this.b)) {
                return this.b;
            }
            return this.M;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return S0();
        }
        return (String) invokeV.objValue;
    }

    public ArrayList<String> U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.F;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.b0;
        }
        return (String) invokeV.objValue;
    }

    public ConcurrentHashMap<String, ImageUrlData> V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.G;
        }
        return (ConcurrentHashMap) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.Z;
        }
        return (String) invokeV.objValue;
    }

    public int W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.q;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.a0;
        }
        return (String) invokeV.objValue;
    }

    public int X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.W;
        }
        return invokeV.intValue;
    }

    public boolean Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            aj8 aj8Var = this.t;
            if (aj8Var != null && aj8Var.i() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.Y;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.c0;
        }
        return invokeV.booleanValue;
    }

    public boolean b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.H;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            z1();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.d0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            cancelMessage();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            cancelMessage();
            MessageManager.getInstance().unRegisterListener(this.f0);
            PbFakeFloorModel pbFakeFloorModel = this.J;
            if (pbFakeFloorModel != null) {
                pbFakeFloorModel.unRegisterListener();
            }
            p1();
        }
    }

    public boolean e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return "hot_topic".equals(getStType());
        }
        return invokeV.booleanValue;
    }

    public boolean f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public boolean g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            aj8 aj8Var = this.t;
            if (aj8Var != null && aj8Var.d() != null) {
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
            return this.X;
        }
        return invokeV.booleanValue;
    }

    public boolean i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.p;
        }
        return invokeV.booleanValue;
    }

    public boolean j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.K;
        }
        return invokeV.booleanValue;
    }

    public boolean k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.z;
        }
        return invokeV.booleanValue;
    }

    public boolean l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return o1(0);
        }
        return invokeV.booleanValue;
    }

    public boolean m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return o1(1);
        }
        return invokeV.booleanValue;
    }

    public boolean n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return o1(3);
        }
        return invokeV.booleanValue;
    }

    public final void p1() {
        ic9 ic9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && (ic9Var = this.C) != null) {
            ic9Var.a();
            this.C = null;
        }
    }

    public final SubPbRequestMessage x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            this.B = true;
            return y0(null);
        }
        return (SubPbRequestMessage) invokeV.objValue;
    }

    public boolean z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return o1(2);
        }
        return invokeV.booleanValue;
    }

    public AttentionHostData D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.y == null) {
                this.y = new AttentionHostData();
                aj8 aj8Var = this.t;
                if (aj8Var != null && aj8Var.l() != null && this.t.l().getAuthor() != null) {
                    this.y.parserWithMetaData(this.t.l().getAuthor());
                }
            }
            return this.y;
        }
        return (AttentionHostData) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData Y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            aj8 aj8Var = this.t;
            if (aj8Var != null && aj8Var.d() != null && this.t.l() != null && this.t.i() != null) {
                WriteData writeData = new WriteData();
                writeData.sourceFrom = String.valueOf(this.pageFromType);
                writeData.setForumName(this.t.d().getName());
                writeData.setForumId(this.t.d().getId());
                writeData.setFromForumId(this.m);
                writeData.setFloor(this.t.i().O());
                writeData.setType(2);
                writeData.setThreadId(this.t.l().getId());
                writeData.setFloorNum(0);
                return writeData;
            }
            return null;
        }
        return (WriteData) invokeL.objValue;
    }

    public void Z0(Bundle bundle) {
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
        this.L = bundle.getBoolean(SubPbActivityConfig.KEI_IS_JUMP_FROM_AGREE_ME, false);
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
        this.R = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
        this.S = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
        this.R = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
        this.S = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
        this.T = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
        this.U = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
        this.V = bundle.getString(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
        this.W = bundle.getInt(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        this.X = bundle.getBoolean(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, false);
        this.Y = bundle.getBoolean("key_is_tieba_plus");
        this.Z = bundle.getString("key_tieba_plus_order_id");
        this.a0 = bundle.getString("key_tieba_plus_token");
        this.b0 = bundle.getString("key_tieba_extra_param");
        this.c0 = bundle.getBoolean("key_tieba_plus_cant_delete");
        this.d0 = bundle.getBoolean(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT);
    }

    public void a1(Intent intent) {
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
        this.L = intent.getBooleanExtra(SubPbActivityConfig.KEI_IS_JUMP_FROM_AGREE_ME, false);
        this.M = intent.getStringExtra("key_ori_ugc_nid");
        this.N = intent.getStringExtra("key_ori_ugc_tid");
        this.O = intent.getIntExtra("key_ori_ugc_type", 0);
        this.P = intent.getStringExtra("key_ori_ugc_vid");
        this.Q = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
        Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
        if (bundleExtra != null) {
            ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
            this.G = new ConcurrentHashMap<>();
            if (stringArrayList != null) {
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!StringUtils.isNull(next)) {
                        this.G.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                    }
                }
            }
            this.F = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
            this.H = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
            this.I = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
        }
        this.j = intent.getStringExtra("high_light_post_id");
        this.k = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_USE_SPID, false);
        this.R = intent.getIntExtra(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
        this.S = intent.getIntExtra(SubPbActivityConfig.KEY_IS_MANAGER, 0);
        this.T = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
        this.U = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
        this.V = intent.getStringExtra(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
        this.W = intent.getIntExtra(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        this.X = intent.getBooleanExtra(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, false);
        this.Y = intent.getBooleanExtra("key_is_tieba_plus", false);
        this.Z = intent.getStringExtra("key_tieba_plus_order_id");
        this.a0 = intent.getStringExtra("key_tieba_plus_token");
        this.b0 = intent.getStringExtra("key_tieba_extra_param");
        this.c0 = intent.getBooleanExtra("key_tieba_plus_cant_delete", false);
        this.d0 = intent.getBooleanExtra(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT, false);
    }

    public int s1() {
        InterceptResult invokeV;
        int i;
        int j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            int b2 = this.t.b();
            if (b2 == 0 || (i = this.a) == 0 || (i == 2 && this.t.k().size() != 0 && this.t.k().size() % this.t.g() == 0)) {
                return b2 + 1;
            }
            if (this.a == 3 && this.E) {
                j = this.t.h();
            } else if (this.a == 3 && b2 > 0) {
                j = this.t.j();
            } else {
                return b2;
            }
            return j - 1;
        }
        return invokeV.intValue;
    }

    public void z0() {
        aj8 aj8Var;
        int g;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            if (this.v > 0 && (aj8Var = this.t) != null && (g = aj8Var.g()) > 0) {
                int i = ((this.v + g) - 1) / g;
                int b2 = this.t.b();
                for (int i2 = i - 1; i2 >= 0; i2--) {
                    SubPbRequestMessage y0 = y0(Integer.valueOf(b2 - i2));
                    this.e0 = y0;
                    y0.setTreatDelPage(true);
                    sendMessage(this.e0);
                }
            }
            this.v = 0;
        }
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
        bundle.putBoolean(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, this.X);
        bundle.putBoolean("key_is_tieba_plus", this.Y);
        bundle.putString("key_tieba_plus_order_id", this.Z);
        bundle.putString("key_tieba_plus_token", this.a0);
        bundle.putString("key_tieba_extra_param", this.b0);
        bundle.putBoolean("key_tieba_plus_cant_delete", this.c0);
        bundle.putBoolean(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT, this.d0);
    }

    public final SubPbRequestMessage y0(Integer num) {
        InterceptResult invokeL;
        long j;
        long j2;
        int intValue;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, num)) == null) {
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int l = hi.l(TbadkCoreApplication.getInst().getApp());
            int j3 = hi.j(TbadkCoreApplication.getInst().getApp());
            long g = gg.g(this.c, 0L);
            long g2 = gg.g(this.i, 0L);
            if (1 != this.a) {
                j = gg.g(this.c, 0L);
                j2 = 0;
            } else if (!TextUtils.isEmpty(this.i) && g == g2 && !this.L) {
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
            if (this.E && this.a == 0) {
                i = 1;
                i2 = 1;
            } else {
                i = intValue;
                i2 = 0;
            }
            SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.s.getPageActivity(), Long.parseLong(this.b), j, j2, i, l, j3, f, this.d, i2);
            subPbRequestMessage.setOriUgcNid(this.M);
            subPbRequestMessage.setOriUgcTid(this.N);
            subPbRequestMessage.setOriUgcType(this.O);
            subPbRequestMessage.setOriUgcVid(this.P);
            if (j2 != 0) {
                subPbRequestMessage.setOriUgcTopPid(this.Q);
            }
            subPbRequestMessage.setForumId(gg.g(this.l, 0L));
            return subPbRequestMessage;
        }
        return (SubPbRequestMessage) invokeL.objValue;
    }
}
