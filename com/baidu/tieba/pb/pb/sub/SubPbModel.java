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
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d9;
import com.repackage.ng;
import com.repackage.oi;
import com.repackage.pi;
import com.repackage.ui8;
import com.repackage.za;
import com.repackage.zr7;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class SubPbModel extends DataModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<zr7> A;
    public boolean B;
    public ui8 C;
    public SmallTailInfo D;
    public boolean E;
    public ArrayList<String> F;
    public ConcurrentHashMap<String, ImageUrlData> G;
    public boolean H;
    public int I;
    public PbFakeFloorModel J;
    public boolean K;
    public String L;
    public String M;
    public int N;
    public String O;
    public String P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public String U;
    public int V;
    public boolean W;
    public boolean X;
    public String Y;
    public String Z;
    public int a;
    public String b;
    public String c;
    public String d;
    public boolean e;
    public boolean f;
    public boolean g;
    public String g0;
    public String h;
    public boolean h0;
    public String i;
    public boolean i0;
    public String j;
    public SubPbRequestMessage j0;
    public boolean k;
    public za k0;
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
    public zr7 t;
    public b u;
    public int v;
    public ArrayList<IconData> w;
    public AntiData x;
    public AttentionHostData y;
    public boolean z;

    /* loaded from: classes3.dex */
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

        @Override // com.repackage.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            boolean z;
            zr7 zr7Var;
            String str;
            boolean z2;
            zr7 zr7Var2;
            long j2;
            long j3;
            int i;
            zr7 zr7Var3;
            ThreadData l;
            zr7 zr7Var4;
            ThreadData l2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && this.a.unique_id == responsedMessage.getOrginalMessage().getTag()) {
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
                    if (subPbHttpResponseMessage != null && (zr7Var4 = subPbHttpResponseMessage.pbFloorData) != null && (l2 = zr7Var4.l()) != null) {
                        this.a.k0(l2);
                    }
                    if (subPbHttpResponseMessage.isTreatDelPage()) {
                        if (subPbHttpResponseMessage.hasError()) {
                            return;
                        }
                        this.a.A.add(subPbHttpResponseMessage.pbFloorData);
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
                    if (subPbSocketResponseMessage != null && (zr7Var3 = subPbSocketResponseMessage.pbFloorData) != null && (l = zr7Var3.l()) != null) {
                        this.a.k0(l);
                    }
                    if (subPbSocketResponseMessage.isTreatDelPage()) {
                        if (subPbSocketResponseMessage.hasError()) {
                            return;
                        }
                        this.a.A.add(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                }
                if (this.a.A != null && this.a.A.size() > 0) {
                    try {
                        for (int size = this.a.A.size() - 1; size >= 0; size--) {
                            zr7 zr7Var5 = (zr7) this.a.A.get(size);
                            if (this.a.E) {
                                this.a.t.t(zr7Var5, true);
                            } else {
                                this.a.t.r(zr7Var5, true);
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
                    this.a.C = new ui8("pbfloorStat");
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
                        zr7Var = null;
                        str = errorString;
                        z2 = z4;
                        this.a.C.b(z, true, error, errorString, j5, j3, j2);
                        this.a.C = new ui8("pbfloorStat");
                        this.a.C = null;
                    } else {
                        zr7Var = null;
                        str = errorString;
                        z2 = z4;
                    }
                    if (responsedMessage == null || ((!z2 && !z3) || responsedMessage.getError() != 0)) {
                        String str2 = str;
                        if (this.a.u != null) {
                            this.a.u.a(false, error, str2, zr7Var);
                        }
                    } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                        if (z3) {
                            zr7Var2 = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                        } else {
                            zr7Var2 = z2 ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : zr7Var;
                        }
                        if (zr7Var2.c().errorno.intValue() != 0) {
                            if (this.a.u != null) {
                                this.a.u.a(false, zr7Var2.m.errorno.intValue(), zr7Var2.m.errmsg, zr7Var);
                                return;
                            }
                            return;
                        }
                        if (zr7Var2.l() != null && zr7Var2.l().getAuthor() != null) {
                            zr7Var2.l().getAuthor().getUserId();
                            if (ListUtils.isEmpty(zr7Var2.i().s().getIconInfo()) && this.a.w != null) {
                                zr7Var2.i().s().setIconInfo(this.a.w);
                            }
                        }
                        if (zr7Var2.i() != null) {
                            this.a.c = zr7Var2.i().J();
                        }
                        if (zr7Var2.l() != null) {
                            this.a.b = zr7Var2.l().getId();
                            this.a.p = zr7Var2.f();
                            this.a.r = zr7Var2.l().getMarkID();
                            zr7Var2.l().worksInfoData = this.a.n;
                        }
                        if (this.a.r != null && this.a.c != null && this.a.r.equals(this.a.c)) {
                            this.a.p = true;
                        }
                        if (this.a.E) {
                            this.a.X0(zr7Var2);
                        } else {
                            this.a.Y0(zr7Var2);
                        }
                        if (this.a.u != null) {
                            this.a.u.a(this.a.H0(), error, str, this.a.t);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z, int i, String str, zr7 zr7Var);
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
                super((d9) newInitContext.callArgs[0]);
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
        this.k0 = new a(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.s = tbPageContext;
        this.A = new ArrayList<>();
        this.t = new zr7();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.k0);
        registerListener(this.k0);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    @Nullable
    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? r0() : (String) invokeV.objValue;
    }

    public SmallTailInfo A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.D : (SmallTailInfo) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public int B() {
        InterceptResult invokeV;
        PostData i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            zr7 zr7Var = this.t;
            if (zr7Var != null && (i = zr7Var.i()) != null) {
                return i.B();
            }
            return super.B();
        }
        return invokeV.intValue;
    }

    public String B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public String C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!StringUtils.isNull(this.b) && !"0".equals(this.b)) {
                return this.b;
            }
            return this.L;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? B0() : (String) invokeV.objValue;
    }

    public ArrayList<String> D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.F : (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.g0 : (String) invokeV.objValue;
    }

    public ConcurrentHashMap<String, ImageUrlData> E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.G : (ConcurrentHashMap) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.Y : (String) invokeV.objValue;
    }

    public int F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.q : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.Z : (String) invokeV.objValue;
    }

    public int G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.V : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            zr7 zr7Var = this.t;
            if (zr7Var == null || zr7Var.d() == null || this.t.l() == null || this.t.i() == null) {
                return null;
            }
            WriteData writeData = new WriteData();
            writeData.sourceFrom = String.valueOf(this.pageFromType);
            writeData.setForumName(this.t.d().getName());
            writeData.setForumId(this.t.d().getId());
            writeData.setFromForumId(this.m);
            writeData.setFloor(this.t.i().J());
            writeData.setType(2);
            writeData.setThreadId(this.t.l().getId());
            writeData.setFloorNum(0);
            return writeData;
        }
        return (WriteData) invokeL.objValue;
    }

    public boolean H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            zr7 zr7Var = this.t;
            return (zr7Var == null || zr7Var.i() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.H : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.X : invokeV.booleanValue;
    }

    public boolean J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.i0 : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.h0 : invokeV.booleanValue;
    }

    public boolean K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.g : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            g1();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? "hot_topic".equals(getStType()) : invokeV.booleanValue;
    }

    public boolean M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public boolean N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f : invokeV.booleanValue;
    }

    public boolean O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.W : invokeV.booleanValue;
    }

    public boolean P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.K : invokeV.booleanValue;
    }

    public boolean R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.z : invokeV.booleanValue;
    }

    public boolean S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? V0(1) : invokeV.booleanValue;
    }

    public boolean U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? V0(3) : invokeV.booleanValue;
    }

    public boolean V0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i)) == null) {
            if (this.B) {
                return false;
            }
            cancelMessage();
            if (this.b != null && this.c != null) {
                i0();
                this.a = i;
                SubPbRequestMessage g0 = g0();
                this.j0 = g0;
                sendMessage(g0);
                return true;
            }
            this.B = false;
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void W0() {
        ui8 ui8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (ui8Var = this.C) == null) {
            return;
        }
        ui8Var.a();
        this.C = null;
    }

    public final void X0(zr7 zr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, zr7Var) == null) {
            int i = this.a;
            if (i == 1) {
                this.t = zr7Var;
                zr7Var.H();
            } else if (i == 2) {
                this.t.t(zr7Var, true);
            } else if (i == 3) {
                this.t.u(zr7Var, false);
            } else {
                this.t.s(zr7Var);
            }
        }
    }

    public final void Y0(zr7 zr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, zr7Var) == null) {
            ArrayList<PostData> k = zr7Var.k();
            if (k == null || k.size() == 0) {
                zr7Var.z(this.t.b());
            }
            int i = this.a;
            if (i == 1) {
                this.t = zr7Var;
            } else if (i == 2) {
                this.t.r(zr7Var, true);
            } else if (i == 3) {
                this.t.v(zr7Var, false);
            } else {
                this.t.r(zr7Var, false);
            }
        }
    }

    public int Z0() {
        InterceptResult invokeV;
        int i;
        int j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            int b2 = this.t.b();
            if (b2 == 0 || (i = this.a) == 0 || (i == 2 && this.t.k().size() != 0 && this.t.k().size() % this.t.g() == 0)) {
                return b2 + 1;
            }
            if (this.a == 3 && this.E) {
                j = this.t.h();
            } else if (this.a != 3 || b2 <= 0) {
                return b2;
            } else {
                j = this.t.j();
            }
            return j - 1;
        }
        return invokeV.intValue;
    }

    public void a1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, bundle) == null) || bundle == null) {
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
        bundle.putString("key_tieba_extra_param", this.g0);
        bundle.putBoolean("key_tieba_plus_cant_delete", this.h0);
        bundle.putBoolean(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT, this.i0);
    }

    public void b1(PbFakeFloorModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, bVar) == null) {
        }
    }

    public void c1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.K = z;
        }
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

    public void d1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.p = z;
        }
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            cancelMessage();
            MessageManager.getInstance().unRegisterListener(this.k0);
            PbFakeFloorModel pbFakeFloorModel = this.J;
            if (pbFakeFloorModel != null) {
                pbFakeFloorModel.unRegisterListener();
            }
            W0();
        }
    }

    public void e1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.r = str;
        }
    }

    public void f1(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, bVar) == null) {
            this.u = bVar;
        }
    }

    public final SubPbRequestMessage g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            this.B = true;
            return h0(null);
        }
        return (SubPbRequestMessage) invokeV.objValue;
    }

    public boolean g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? V0(2) : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            zr7 zr7Var = this.t;
            if (zr7Var == null || zr7Var.d() == null) {
                return null;
            }
            return this.t.d().getId();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getFromForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public String getStType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0071, code lost:
        if (r4 == r6) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SubPbRequestMessage h0(Integer num) {
        InterceptResult invokeL;
        long g;
        long j;
        long g2;
        int intValue;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, num)) == null) {
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int k = pi.k(TbadkCoreApplication.getInst().getApp());
            int i3 = pi.i(TbadkCoreApplication.getInst().getApp());
            if (1 != this.a) {
                j = ng.g(this.c, 0L);
                g = 0;
            } else {
                if (!oi.isEmpty(this.L)) {
                    g2 = ng.g(this.c, 0L);
                    g = ng.g(this.i, 0L);
                } else {
                    if (!TextUtils.isEmpty(this.i)) {
                        g2 = ng.g(this.c, 0L);
                        long g3 = ng.g(this.i, 0L);
                        g = g3;
                    } else {
                        g = ng.g(this.c, 0L);
                    }
                    j = 0;
                }
                j = g2;
            }
            if (num == null) {
                intValue = Z0();
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
            SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.s.getPageActivity(), Long.parseLong(this.b), j, g, i, k, i3, f, this.d, i2);
            subPbRequestMessage.setOriUgcNid(this.L);
            subPbRequestMessage.setOriUgcTid(this.M);
            subPbRequestMessage.setOriUgcType(this.N);
            subPbRequestMessage.setOriUgcVid(this.O);
            if (g != 0) {
                subPbRequestMessage.setOriUgcTopPid(this.P);
            }
            subPbRequestMessage.setForumId(ng.g(this.l, 0L));
            return subPbRequestMessage;
        }
        return (SubPbRequestMessage) invokeL.objValue;
    }

    public void i0() {
        zr7 zr7Var;
        int g;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            if (this.v > 0 && (zr7Var = this.t) != null && (g = zr7Var.g()) > 0) {
                int i = ((this.v + g) - 1) / g;
                int b2 = this.t.b();
                for (int i2 = i - 1; i2 >= 0; i2--) {
                    SubPbRequestMessage h0 = h0(Integer.valueOf(b2 - i2));
                    this.j0 = h0;
                    h0.setTreatDelPage(true);
                    sendMessage(this.j0);
                }
            }
            this.v = 0;
        }
    }

    public void initWithBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048628, this, bundle) == null) || bundle == null) {
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
        this.T = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
        this.U = bundle.getString(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
        this.V = bundle.getInt(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        this.W = bundle.getBoolean(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, false);
        this.X = bundle.getBoolean("key_is_tieba_plus");
        this.Y = bundle.getString("key_tieba_plus_order_id");
        this.Z = bundle.getString("key_tieba_plus_token");
        this.g0 = bundle.getString("key_tieba_extra_param");
        this.h0 = bundle.getBoolean("key_tieba_plus_cant_delete");
        this.i0 = bundle.getBoolean(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT);
    }

    public void initWithIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048629, this, intent) == null) || intent == null) {
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
        this.L = intent.getStringExtra("key_ori_ugc_nid");
        this.M = intent.getStringExtra("key_ori_ugc_tid");
        this.N = intent.getIntExtra("key_ori_ugc_type", 0);
        this.O = intent.getStringExtra("key_ori_ugc_vid");
        this.P = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
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
        this.Q = intent.getIntExtra(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
        this.R = intent.getIntExtra(SubPbActivityConfig.KEY_IS_MANAGER, 0);
        this.S = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
        this.T = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
        this.U = intent.getStringExtra(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
        this.V = intent.getIntExtra(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        this.W = intent.getBooleanExtra(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, false);
        this.X = intent.getBooleanExtra("key_is_tieba_plus", false);
        this.Y = intent.getStringExtra("key_tieba_plus_order_id");
        this.Z = intent.getStringExtra("key_tieba_plus_token");
        this.g0 = intent.getStringExtra("key_tieba_extra_param");
        this.h0 = intent.getBooleanExtra("key_tieba_plus_cant_delete", false);
        this.i0 = intent.getBooleanExtra(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT, false);
    }

    public void j0(String str) {
        zr7 zr7Var;
        zr7 zr7Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, str) == null) || TextUtils.isEmpty(str) || (zr7Var = this.t) == null || zr7Var.k() == null) {
            return;
        }
        ArrayList<PostData> k = this.t.k();
        int size = k.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(k.get(i).J())) {
                k.remove(i);
                this.v++;
                this.t.F(zr7Var2.m() - 1);
                return;
            }
        }
    }

    public final void k0(@NonNull ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, threadData) == null) {
            threadData.isTiebaPlusAdThread = J();
            threadData.tiebaPlusOrderId = F();
            threadData.tiebaPlusToken = G();
            threadData.tiebaPlusExtraParam = G();
            threadData.tiebaplusCantDelete = K();
            threadData.setDispatchedForumIdWithString(A());
        }
    }

    public AntiData l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.x : (AntiData) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? V0(0) : invokeV.booleanValue;
    }

    public AttentionHostData m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            if (this.y == null) {
                this.y = new AttentionHostData();
                zr7 zr7Var = this.t;
                if (zr7Var != null && zr7Var.l() != null && this.t.l().getAuthor() != null) {
                    this.y.parserWithMetaData(this.t.l().getAuthor());
                }
            }
            return this.y;
        }
        return (AttentionHostData) invokeV.objValue;
    }

    public zr7 n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.t : (zr7) invokeV.objValue;
    }

    public int o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.T : invokeV.intValue;
    }

    public int p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.S : invokeV.intValue;
    }

    public String q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.U : (String) invokeV.objValue;
    }

    public String r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public int s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.Q : invokeV.intValue;
    }

    public String t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public int u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.R : invokeV.intValue;
    }

    public MarkData v0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, postData)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.b);
            markData.setPostId(postData.J());
            markData.setTime(date.getTime());
            markData.setHostMode(false);
            markData.setId(this.b);
            markData.setFloor(postData.B());
            return markData;
        }
        return (MarkData) invokeL.objValue;
    }

    public String w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.r : (String) invokeV.objValue;
    }

    public int x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.I : invokeV.intValue;
    }

    public int y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.pageFromType : invokeV.intValue;
    }

    public String z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.i : (String) invokeV.objValue;
    }
}
