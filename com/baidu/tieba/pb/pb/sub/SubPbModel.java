package com.baidu.tieba.pb.pb.sub;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.f;
import b.a.e.e.p.k;
import b.a.e.e.p.l;
import b.a.q0.s.q.d2;
import b.a.r0.k2.r.s;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class SubPbModel extends DataModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<IconData> A;
    public AntiData B;
    public AttentionHostData C;
    public boolean D;
    public ArrayList<s> E;
    public boolean F;
    public b.a.r0.l3.l0.b G;
    public SmallTailInfo H;
    public boolean I;
    public ArrayList<String> J;
    public ConcurrentHashMap<String, ImageUrlData> K;
    public boolean L;
    public int M;
    public PbFakeFloorModel N;
    public boolean O;
    public String P;
    public String Q;
    public int R;
    public String S;
    public String T;
    public int U;
    public int V;
    public int W;
    public int X;
    public String Y;
    public int Z;
    public boolean a0;
    public boolean b0;
    public String c0;

    /* renamed from: e  reason: collision with root package name */
    public int f52652e;

    /* renamed from: f  reason: collision with root package name */
    public String f52653f;

    /* renamed from: g  reason: collision with root package name */
    public String f52654g;

    /* renamed from: h  reason: collision with root package name */
    public String f52655h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f52656i;
    public String i0;
    public boolean j;
    public String j0;
    public boolean k;
    public boolean k0;
    public String l;
    public boolean l0;
    public String m;
    public SubPbRequestMessage m0;
    public String n;
    public b.a.e.c.g.a n0;
    public boolean o;
    public String p;
    public int pageFromType;
    public String q;
    @Nullable
    public WorksInfoData r;
    public boolean s;
    public boolean t;
    public int u;
    public String v;
    public TbPageContext<?> w;
    public s x;
    public b y;
    public int z;

    /* loaded from: classes9.dex */
    public class a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SubPbModel f52657a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SubPbModel subPbModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subPbModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52657a = subPbModel;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            boolean z;
            s sVar;
            String str;
            boolean z2;
            s sVar2;
            long j2;
            long j3;
            int i2;
            s sVar3;
            d2 l;
            s sVar4;
            d2 l2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && this.f52657a.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                this.f52657a.F = false;
                if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                    this.f52657a.w.getPageActivity().finish();
                }
                boolean z3 = responsedMessage instanceof SubPbHttpResponseMessage;
                long j4 = 0;
                if (z3) {
                    SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                    subPbHttpResponseMessage.getDownSize();
                    j = responsedMessage.getCostTime();
                    if (subPbHttpResponseMessage != null && (sVar4 = subPbHttpResponseMessage.pbFloorData) != null && (l2 = sVar4.l()) != null) {
                        this.f52657a.g0(l2);
                    }
                    if (subPbHttpResponseMessage.isTreatDelPage()) {
                        if (subPbHttpResponseMessage.hasError()) {
                            return;
                        }
                        this.f52657a.E.add(subPbHttpResponseMessage.pbFloorData);
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
                    if (subPbSocketResponseMessage != null && (sVar3 = subPbSocketResponseMessage.pbFloorData) != null && (l = sVar3.l()) != null) {
                        this.f52657a.g0(l);
                    }
                    if (subPbSocketResponseMessage.isTreatDelPage()) {
                        if (subPbSocketResponseMessage.hasError()) {
                            return;
                        }
                        this.f52657a.E.add(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                }
                if (this.f52657a.E != null && this.f52657a.E.size() > 0) {
                    try {
                        for (int size = this.f52657a.E.size() - 1; size >= 0; size--) {
                            s sVar5 = (s) this.f52657a.E.get(size);
                            if (this.f52657a.I) {
                                this.f52657a.x.t(sVar5, true);
                            } else {
                                this.f52657a.x.r(sVar5, true);
                            }
                        }
                    } catch (Exception e2) {
                        BdLog.detailException(e2);
                    }
                    this.f52657a.E.clear();
                }
                int error = responsedMessage.getError();
                String errorString = responsedMessage.getErrorString();
                if (this.f52657a.G == null) {
                    this.f52657a.G = new b.a.r0.l3.l0.b("pbfloorStat");
                }
                if (this.f52657a.G != null) {
                    if (error == 0) {
                        if (z3) {
                            i2 = ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                            j2 = j4;
                            j3 = responsedMessage.getCostTime();
                        } else if (z4) {
                            int downSize = ((SubPbSocketResponseMessage) responsedMessage).getDownSize();
                            j2 = responsedMessage.getCostTime();
                            j3 = j;
                            i2 = downSize;
                        } else {
                            j2 = j4;
                            j3 = j;
                            i2 = -1;
                        }
                        long j5 = i2;
                        sVar = null;
                        str = errorString;
                        z2 = z4;
                        this.f52657a.G.b(z, true, error, errorString, j5, j3, j2);
                        this.f52657a.G = new b.a.r0.l3.l0.b("pbfloorStat");
                        this.f52657a.G = null;
                    } else {
                        sVar = null;
                        str = errorString;
                        z2 = z4;
                    }
                    if (responsedMessage == null || ((!z2 && !z3) || responsedMessage.getError() != 0)) {
                        String str2 = str;
                        if (this.f52657a.y != null) {
                            this.f52657a.y.a(false, error, str2, sVar);
                        }
                    } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                        if (z3) {
                            sVar2 = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                        } else {
                            sVar2 = z2 ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : sVar;
                        }
                        if (sVar2.c().errorno.intValue() != 0) {
                            if (this.f52657a.y != null) {
                                this.f52657a.y.a(false, sVar2.m.errorno.intValue(), sVar2.m.errmsg, sVar);
                                return;
                            }
                            return;
                        }
                        if (sVar2.l() != null && sVar2.l().J() != null) {
                            sVar2.l().J().getUserId();
                            if (ListUtils.isEmpty(sVar2.i().t().getIconInfo()) && this.f52657a.A != null) {
                                sVar2.i().t().setIconInfo(this.f52657a.A);
                            }
                        }
                        if (sVar2.i() != null) {
                            this.f52657a.f52654g = sVar2.i().G();
                        }
                        if (sVar2.l() != null) {
                            this.f52657a.f52653f = sVar2.l().f0();
                            this.f52657a.t = sVar2.f();
                            this.f52657a.v = sVar2.l().D0();
                            sVar2.l().M2 = this.f52657a.r;
                        }
                        if (this.f52657a.v != null && this.f52657a.f52654g != null && this.f52657a.v.equals(this.f52657a.f52654g)) {
                            this.f52657a.t = true;
                        }
                        if (this.f52657a.I) {
                            this.f52657a.T0(sVar2);
                        } else {
                            this.f52657a.U0(sVar2);
                        }
                        if (this.f52657a.y != null) {
                            this.f52657a.y.a(this.f52657a.D0(), error, str, this.f52657a.x);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(boolean z, int i2, String str, s sVar);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52652e = 0;
        this.f52653f = null;
        this.f52654g = null;
        this.f52655h = null;
        this.f52656i = false;
        this.j = false;
        this.k = false;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = false;
        this.pageFromType = 0;
        this.s = false;
        this.t = false;
        this.u = 0;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = 0;
        this.D = false;
        this.E = null;
        this.F = false;
        this.G = null;
        this.L = true;
        this.M = 0;
        this.N = null;
        this.O = false;
        this.n0 = new a(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.w = tbPageContext;
        this.E = new ArrayList<>();
        this.x = new s();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.n0);
        registerListener(this.n0);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j0 : (String) invokeV.objValue;
    }

    public ConcurrentHashMap<String, ImageUrlData> A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.K : (ConcurrentHashMap) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c0 : (String) invokeV.objValue;
    }

    public int B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.u : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.i0 : (String) invokeV.objValue;
    }

    public int C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.Z : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            s sVar = this.x;
            if (sVar == null || sVar.d() == null || this.x.l() == null || this.x.i() == null) {
                return null;
            }
            WriteData writeData = new WriteData();
            writeData.sourceFrom = String.valueOf(this.pageFromType);
            writeData.setForumName(this.x.d().getName());
            writeData.setForumId(this.x.d().getId());
            writeData.setFromForumId(this.q);
            writeData.setFloor(this.x.i().G());
            writeData.setType(2);
            writeData.setThreadId(this.x.l().f0());
            writeData.setFloorNum(0);
            return writeData;
        }
        return (WriteData) invokeL.objValue;
    }

    public boolean D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            s sVar = this.x;
            return (sVar == null || sVar.i() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.L : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.b0 : invokeV.booleanValue;
    }

    public boolean F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.l0 : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.k0 : invokeV.booleanValue;
    }

    public boolean G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.k : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            c1();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? "hot_topic".equals(getStType()) : invokeV.booleanValue;
    }

    public boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f52656i : invokeV.booleanValue;
    }

    public boolean J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public boolean K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.a0 : invokeV.booleanValue;
    }

    public boolean L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public boolean M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.O : invokeV.booleanValue;
    }

    public boolean N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.D : invokeV.booleanValue;
    }

    public boolean O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public boolean P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? R0(1) : invokeV.booleanValue;
    }

    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? R0(3) : invokeV.booleanValue;
    }

    public boolean R0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            if (this.F) {
                return false;
            }
            cancelMessage();
            if (this.f52653f != null && this.f52654g != null) {
                e0();
                this.f52652e = i2;
                SubPbRequestMessage c0 = c0();
                this.m0 = c0;
                sendMessage(c0);
                return true;
            }
            this.F = false;
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void S0() {
        b.a.r0.l3.l0.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (bVar = this.G) == null) {
            return;
        }
        bVar.a();
        this.G = null;
    }

    public final void T0(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, sVar) == null) {
            int i2 = this.f52652e;
            if (i2 == 1) {
                this.x = sVar;
                sVar.H();
            } else if (i2 == 2) {
                this.x.t(sVar, true);
            } else if (i2 == 3) {
                this.x.u(sVar, false);
            } else {
                this.x.s(sVar);
            }
        }
    }

    public final void U0(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, sVar) == null) {
            ArrayList<PostData> k = sVar.k();
            if (k == null || k.size() == 0) {
                sVar.z(this.x.b());
            }
            int i2 = this.f52652e;
            if (i2 == 1) {
                this.x = sVar;
            } else if (i2 == 2) {
                this.x.r(sVar, true);
            } else if (i2 == 3) {
                this.x.v(sVar, false);
            } else {
                this.x.r(sVar, false);
            }
        }
    }

    public int V0() {
        InterceptResult invokeV;
        int i2;
        int j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            int b2 = this.x.b();
            if (b2 == 0 || (i2 = this.f52652e) == 0 || (i2 == 2 && this.x.k().size() != 0 && this.x.k().size() % this.x.g() == 0)) {
                return b2 + 1;
            }
            if (this.f52652e == 3 && this.I) {
                j = this.x.h();
            } else if (this.f52652e != 3 || b2 <= 0) {
                return b2;
            } else {
                j = this.x.j();
            }
            return j - 1;
        }
        return invokeV.intValue;
    }

    public void W0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, bundle) == null) || bundle == null) {
            return;
        }
        bundle.putString("thread_id", this.f52653f);
        bundle.putString("post_id", this.f52654g);
        bundle.putString("st_type", this.f52655h);
        bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.f52656i);
        bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB, this.j);
        bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_FOLD_COMMENT, this.k);
        bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.l);
        bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.m);
        bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.s);
        bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.u);
        bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.H));
        AntiData antiData = this.B;
        if (antiData != null) {
            bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, antiData.toJsonString());
        }
        if (!ListUtils.isEmpty(this.A)) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<IconData> it = this.A.iterator();
            while (it.hasNext()) {
                String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                if (!StringUtils.isNull(jsonStrWithObject)) {
                    arrayList.add(jsonStrWithObject);
                }
            }
            bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
        }
        bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        bundle.putString("from_forum_id", this.p);
        bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.q);
        bundle.putSerializable(SubPbActivityConfig.KEY_WORKS_INFO_DATA, this.r);
        bundle.putString("high_light_post_id", this.n);
        bundle.putBoolean("high_light_post_id", this.o);
        bundle.putBoolean(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, this.a0);
        bundle.putBoolean("key_is_tieba_plus", this.b0);
        bundle.putString("key_tieba_plus_order_id", this.c0);
        bundle.putString("key_tieba_plus_token", this.i0);
        bundle.putString("key_tieba_extra_param", this.j0);
        bundle.putBoolean("key_tieba_plus_cant_delete", this.k0);
        bundle.putBoolean(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT, this.l0);
    }

    public void X0(PbFakeFloorModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bVar) == null) {
        }
    }

    public void Y0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.O = z;
        }
    }

    public void Z0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.t = z;
        }
    }

    public void a1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.v = str;
        }
    }

    public void b1(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bVar) == null) {
            this.y = bVar;
        }
    }

    public final SubPbRequestMessage c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            this.F = true;
            return d0(null);
        }
        return (SubPbRequestMessage) invokeV.objValue;
    }

    public boolean c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? R0(2) : invokeV.booleanValue;
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

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0071, code lost:
        if (r4 == r6) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SubPbRequestMessage d0(Integer num) {
        InterceptResult invokeL;
        long g2;
        long j;
        long g3;
        int intValue;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, num)) == null) {
            float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int k = l.k(TbadkCoreApplication.getInst().getApp());
            int i4 = l.i(TbadkCoreApplication.getInst().getApp());
            if (1 != this.f52652e) {
                j = b.a.e.e.m.b.g(this.f52654g, 0L);
                g2 = 0;
            } else {
                if (!k.isEmpty(this.P)) {
                    g3 = b.a.e.e.m.b.g(this.f52654g, 0L);
                    g2 = b.a.e.e.m.b.g(this.m, 0L);
                } else {
                    if (!TextUtils.isEmpty(this.m)) {
                        g3 = b.a.e.e.m.b.g(this.f52654g, 0L);
                        long g4 = b.a.e.e.m.b.g(this.m, 0L);
                        g2 = g4;
                    } else {
                        g2 = b.a.e.e.m.b.g(this.f52654g, 0L);
                    }
                    j = 0;
                }
                j = g3;
            }
            if (num == null) {
                intValue = V0();
            } else {
                intValue = num.intValue();
            }
            if (this.I && this.f52652e == 0) {
                i2 = 1;
                i3 = 1;
            } else {
                i2 = intValue;
                i3 = 0;
            }
            SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.w.getPageActivity(), Long.parseLong(this.f52653f), j, g2, i2, k, i4, f2, this.f52655h, i3);
            subPbRequestMessage.setOriUgcNid(this.P);
            subPbRequestMessage.setOriUgcTid(this.Q);
            subPbRequestMessage.setOriUgcType(this.R);
            subPbRequestMessage.setOriUgcVid(this.S);
            if (g2 != 0) {
                subPbRequestMessage.setOriUgcTopPid(this.T);
            }
            subPbRequestMessage.setForumId(b.a.e.e.m.b.g(this.p, 0L));
            return subPbRequestMessage;
        }
        return (SubPbRequestMessage) invokeL.objValue;
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            cancelMessage();
            MessageManager.getInstance().unRegisterListener(this.n0);
            PbFakeFloorModel pbFakeFloorModel = this.N;
            if (pbFakeFloorModel != null) {
                pbFakeFloorModel.unRegisterListener();
            }
            S0();
        }
    }

    public void e0() {
        s sVar;
        int g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            if (this.z > 0 && (sVar = this.x) != null && (g2 = sVar.g()) > 0) {
                int i2 = ((this.z + g2) - 1) / g2;
                int b2 = this.x.b();
                for (int i3 = i2 - 1; i3 >= 0; i3--) {
                    SubPbRequestMessage d0 = d0(Integer.valueOf(b2 - i3));
                    this.m0 = d0;
                    d0.setTreatDelPage(true);
                    sendMessage(this.m0);
                }
            }
            this.z = 0;
        }
    }

    public void f0(String str) {
        s sVar;
        s sVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, str) == null) || TextUtils.isEmpty(str) || (sVar = this.x) == null || sVar.k() == null) {
            return;
        }
        ArrayList<PostData> k = this.x.k();
        int size = k.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equals(k.get(i2).G())) {
                k.remove(i2);
                this.z++;
                this.x.F(sVar2.m() - 1);
                return;
            }
        }
    }

    public final void g0(@NonNull d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, d2Var) == null) {
            d2Var.R2 = F();
            d2Var.S2 = B();
            d2Var.T2 = C();
            d2Var.U2 = C();
            d2Var.V2 = G();
            d2Var.C3(w());
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            s sVar = this.x;
            if (sVar == null || sVar.d() == null) {
                return null;
            }
            return this.x.d().getId();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getFromForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public String getStType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.f52655h : (String) invokeV.objValue;
    }

    public AntiData h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.B : (AntiData) invokeV.objValue;
    }

    public AttentionHostData i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (this.C == null) {
                this.C = new AttentionHostData();
                s sVar = this.x;
                if (sVar != null && sVar.l() != null && this.x.l().J() != null) {
                    this.C.parserWithMetaData(this.x.l().J());
                }
            }
            return this.C;
        }
        return (AttentionHostData) invokeV.objValue;
    }

    public void initWithBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, bundle) == null) || bundle == null) {
            return;
        }
        this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
        this.f52653f = bundle.getString("thread_id");
        this.f52654g = bundle.getString("post_id");
        this.f52655h = bundle.getString("st_type");
        this.p = bundle.getString("from_forum_id");
        this.q = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
        this.r = (WorksInfoData) bundle.getSerializable(SubPbActivityConfig.KEY_WORKS_INFO_DATA);
        this.f52656i = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        this.j = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB, false);
        this.k = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_FOLD_COMMENT, false);
        this.l = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
        this.s = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
        this.m = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
        this.u = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
        String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
        if (!StringUtils.isNull(string)) {
            this.H = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
        }
        SmallTailInfo smallTailInfo = this.H;
        if (smallTailInfo != null) {
            smallTailInfo.updateShowInfo();
        }
        String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
        if (!StringUtils.isNull(string2)) {
            AntiData antiData = new AntiData();
            this.B = antiData;
            antiData.parserJson(string2);
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
        if (!ListUtils.isEmpty(stringArrayList)) {
            this.A = new ArrayList<>();
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                if (iconData != null) {
                    this.A.add(iconData);
                }
            }
        }
        this.D = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        this.n = bundle.getString("high_light_post_id");
        this.o = bundle.getBoolean(SubPbActivityConfig.KEY_IS_USE_SPID, false);
        this.U = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
        this.V = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
        this.U = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
        this.V = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
        this.W = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
        this.X = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
        this.Y = bundle.getString(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
        this.Z = bundle.getInt(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        this.a0 = bundle.getBoolean(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, false);
        this.b0 = bundle.getBoolean("key_is_tieba_plus");
        this.c0 = bundle.getString("key_tieba_plus_order_id");
        this.i0 = bundle.getString("key_tieba_plus_token");
        this.j0 = bundle.getString("key_tieba_extra_param");
        this.k0 = bundle.getBoolean("key_tieba_plus_cant_delete");
        this.l0 = bundle.getBoolean(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT);
    }

    public void initWithIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, intent) == null) || intent == null) {
            return;
        }
        this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
        this.f52653f = intent.getStringExtra("thread_id");
        this.f52654g = intent.getStringExtra("post_id");
        this.f52655h = intent.getStringExtra("st_type");
        this.p = intent.getStringExtra("from_forum_id");
        this.q = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
        this.r = (WorksInfoData) intent.getSerializableExtra(SubPbActivityConfig.KEY_WORKS_INFO_DATA);
        this.f52656i = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        this.j = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB, false);
        this.k = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_FOLD_COMMENT, false);
        this.l = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
        this.s = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
        this.m = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
        this.u = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
        SmallTailInfo smallTailInfo = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
        this.H = smallTailInfo;
        if (smallTailInfo != null) {
            smallTailInfo.updateShowInfo();
        }
        this.B = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
        this.A = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
        this.D = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        this.P = intent.getStringExtra("key_ori_ugc_nid");
        this.Q = intent.getStringExtra("key_ori_ugc_tid");
        this.R = intent.getIntExtra("key_ori_ugc_type", 0);
        this.S = intent.getStringExtra("key_ori_ugc_vid");
        this.T = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
        Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
        if (bundleExtra != null) {
            ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
            this.K = new ConcurrentHashMap<>();
            if (stringArrayList != null) {
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!StringUtils.isNull(next)) {
                        this.K.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                    }
                }
            }
            this.J = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
            this.L = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
            this.M = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
        }
        this.n = intent.getStringExtra("high_light_post_id");
        this.o = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_USE_SPID, false);
        this.U = intent.getIntExtra(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
        this.V = intent.getIntExtra(SubPbActivityConfig.KEY_IS_MANAGER, 0);
        this.W = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
        this.X = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
        this.Y = intent.getStringExtra(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
        this.Z = intent.getIntExtra(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        this.a0 = intent.getBooleanExtra(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, false);
        this.b0 = intent.getBooleanExtra("key_is_tieba_plus", false);
        this.c0 = intent.getStringExtra("key_tieba_plus_order_id");
        this.i0 = intent.getStringExtra("key_tieba_plus_token");
        this.j0 = intent.getStringExtra("key_tieba_extra_param");
        this.k0 = intent.getBooleanExtra("key_tieba_plus_cant_delete", false);
        this.l0 = intent.getBooleanExtra(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT, false);
    }

    public s j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.x : (s) invokeV.objValue;
    }

    public int k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.X : invokeV.intValue;
    }

    public int l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.W : invokeV.intValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? R0(0) : invokeV.booleanValue;
    }

    public String m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.Y : (String) invokeV.objValue;
    }

    public String n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.q : (String) invokeV.objValue;
    }

    public int o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.U : invokeV.intValue;
    }

    public String p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public int q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.V : invokeV.intValue;
    }

    public MarkData r0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, postData)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.f52653f);
            markData.setPostId(postData.G());
            markData.setTime(date.getTime());
            markData.setHostMode(false);
            markData.setId(this.f52653f);
            markData.setFloor(postData.A());
            return markData;
        }
        return (MarkData) invokeL.objValue;
    }

    public String s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.v : (String) invokeV.objValue;
    }

    public int t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.M : invokeV.intValue;
    }

    public int u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.pageFromType : invokeV.intValue;
    }

    public String v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    @Nullable
    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? n0() : (String) invokeV.objValue;
    }

    public SmallTailInfo w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.H : (SmallTailInfo) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public int x() {
        InterceptResult invokeV;
        PostData i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            s sVar = this.x;
            if (sVar != null && (i2 = sVar.i()) != null) {
                return i2.A();
            }
            return super.x();
        }
        return invokeV.intValue;
    }

    public String x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.f52653f : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.f52654g : (String) invokeV.objValue;
    }

    public String y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            if (!StringUtils.isNull(this.f52653f) && !"0".equals(this.f52653f)) {
                return this.f52653f;
            }
            return this.P;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? x0() : (String) invokeV.objValue;
    }

    public ArrayList<String> z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.J : (ArrayList) invokeV.objValue;
    }
}
