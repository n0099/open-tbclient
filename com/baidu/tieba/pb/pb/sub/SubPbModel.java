package com.baidu.tieba.pb.pb.sub;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.p0.h2.h.r;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class SubPbModel extends DataModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public ArrayList<r> B;
    public boolean C;
    public d.a.p0.h3.j0.b D;
    public SmallTailInfo E;
    public boolean F;
    public ArrayList<String> G;
    public ConcurrentHashMap<String, ImageUrlData> H;
    public boolean I;
    public int J;
    public PbFakeFloorModel K;
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
    public SubPbRequestMessage Y;
    public d.a.c.c.g.a Z;

    /* renamed from: e  reason: collision with root package name */
    public int f19657e;

    /* renamed from: f  reason: collision with root package name */
    public String f19658f;

    /* renamed from: g  reason: collision with root package name */
    public String f19659g;

    /* renamed from: h  reason: collision with root package name */
    public String f19660h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19661i;
    public String j;
    public String k;
    public String l;
    public boolean m;
    public String n;
    public String o;
    public boolean p;
    public int pageFromType;
    public boolean q;
    public int r;
    public String s;
    public TbPageContext<?> t;
    public r u;
    public b v;
    public int w;
    public ArrayList<IconData> x;
    public AntiData y;
    public AttentionHostData z;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SubPbModel f19662a;

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
            this.f19662a = subPbModel;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            boolean z;
            r rVar;
            String str;
            boolean z2;
            r rVar2;
            long j2;
            long j3;
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && this.f19662a.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                this.f19662a.C = false;
                if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                    this.f19662a.t.getPageActivity().finish();
                }
                boolean z3 = responsedMessage instanceof SubPbHttpResponseMessage;
                long j4 = 0;
                if (z3) {
                    SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                    subPbHttpResponseMessage.getDownSize();
                    j = responsedMessage.getCostTime();
                    if (subPbHttpResponseMessage.isTreatDelPage()) {
                        if (subPbHttpResponseMessage.hasError()) {
                            return;
                        }
                        this.f19662a.B.add(subPbHttpResponseMessage.pbFloorData);
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
                    if (subPbSocketResponseMessage.isTreatDelPage()) {
                        if (subPbSocketResponseMessage.hasError()) {
                            return;
                        }
                        this.f19662a.B.add(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                }
                if (this.f19662a.B != null && this.f19662a.B.size() > 0) {
                    try {
                        for (int size = this.f19662a.B.size() - 1; size >= 0; size--) {
                            r rVar3 = (r) this.f19662a.B.get(size);
                            if (this.f19662a.F) {
                                this.f19662a.u.t(rVar3, true);
                            } else {
                                this.f19662a.u.r(rVar3, true);
                            }
                        }
                    } catch (Exception e2) {
                        BdLog.detailException(e2);
                    }
                    this.f19662a.B.clear();
                }
                int error = responsedMessage.getError();
                String errorString = responsedMessage.getErrorString();
                if (this.f19662a.D == null) {
                    this.f19662a.D = new d.a.p0.h3.j0.b("pbfloorStat");
                }
                if (this.f19662a.D != null) {
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
                        rVar = null;
                        str = errorString;
                        z2 = z4;
                        this.f19662a.D.b(z, true, error, errorString, j5, j3, j2);
                        this.f19662a.D = new d.a.p0.h3.j0.b("pbfloorStat");
                        this.f19662a.D = null;
                    } else {
                        rVar = null;
                        str = errorString;
                        z2 = z4;
                    }
                    if (responsedMessage == null || ((!z2 && !z3) || responsedMessage.getError() != 0)) {
                        String str2 = str;
                        if (this.f19662a.v != null) {
                            this.f19662a.v.a(false, error, str2, rVar);
                        }
                    } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                        if (z3) {
                            rVar2 = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                        } else {
                            rVar2 = z2 ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : rVar;
                        }
                        if (rVar2.c().errorno.intValue() != 0) {
                            if (this.f19662a.v != null) {
                                this.f19662a.v.a(false, rVar2.m.errorno.intValue(), rVar2.m.errmsg, rVar);
                                return;
                            }
                            return;
                        }
                        if (rVar2.l() != null && rVar2.l().H() != null) {
                            rVar2.l().H().getUserId();
                            if (ListUtils.isEmpty(rVar2.i().t().getIconInfo()) && this.f19662a.x != null) {
                                rVar2.i().t().setIconInfo(this.f19662a.x);
                            }
                        }
                        if (rVar2.i() != null) {
                            this.f19662a.f19659g = rVar2.i().E();
                        }
                        if (rVar2.l() != null) {
                            this.f19662a.f19658f = rVar2.l().c0();
                            this.f19662a.q = rVar2.f();
                            this.f19662a.s = rVar2.l().y0();
                        }
                        if (this.f19662a.s != null && this.f19662a.f19659g != null && this.f19662a.s.equals(this.f19662a.f19659g)) {
                            this.f19662a.q = true;
                        }
                        if (this.f19662a.F) {
                            this.f19662a.E0(rVar2);
                        } else {
                            this.f19662a.F0(rVar2);
                        }
                        if (this.f19662a.v != null) {
                            this.f19662a.v.a(this.f19662a.q0(), error, str, this.f19662a.u);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, int i2, String str, r rVar);
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
        this.f19657e = 0;
        this.f19658f = null;
        this.f19659g = null;
        this.f19660h = null;
        this.f19661i = false;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = false;
        this.pageFromType = 0;
        this.p = false;
        this.q = false;
        this.r = 0;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = 0;
        this.A = false;
        this.B = null;
        this.C = false;
        this.D = null;
        this.I = true;
        this.J = 0;
        this.K = null;
        this.L = false;
        this.Z = new a(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.t = tbPageContext;
        this.B = new ArrayList<>();
        this.u = new r();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.Z);
        registerListener(this.Z);
    }

    public boolean A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? C0(1) : invokeV.booleanValue;
    }

    public boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? C0(3) : invokeV.booleanValue;
    }

    public boolean C0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (this.C) {
                return false;
            }
            cancelMessage();
            if (this.f19658f != null && this.f19659g != null) {
                T();
                this.f19657e = i2;
                SubPbRequestMessage R = R();
                this.Y = R;
                sendMessage(R);
                return true;
            }
            this.C = false;
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void D0() {
        d.a.p0.h3.j0.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = this.D) == null) {
            return;
        }
        bVar.a();
        this.D = null;
    }

    public final void E0(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, rVar) == null) {
            int i2 = this.f19657e;
            if (i2 == 1) {
                this.u = rVar;
                rVar.H();
            } else if (i2 == 2) {
                this.u.t(rVar, true);
            } else if (i2 == 3) {
                this.u.u(rVar, false);
            } else {
                this.u.s(rVar);
            }
        }
    }

    public final void F0(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, rVar) == null) {
            ArrayList<PostData> k = rVar.k();
            if (k == null || k.size() == 0) {
                rVar.z(this.u.b());
            }
            int i2 = this.f19657e;
            if (i2 == 1) {
                this.u = rVar;
            } else if (i2 == 2) {
                this.u.r(rVar, true);
            } else if (i2 == 3) {
                this.u.v(rVar, false);
            } else {
                this.u.r(rVar, false);
            }
        }
    }

    public int G0() {
        InterceptResult invokeV;
        int i2;
        int j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int b2 = this.u.b();
            if (b2 == 0 || (i2 = this.f19657e) == 0 || (i2 == 2 && this.u.k().size() != 0 && this.u.k().size() % this.u.g() == 0)) {
                return b2 + 1;
            }
            if (this.f19657e == 3 && this.F) {
                j = this.u.h();
            } else if (this.f19657e != 3 || b2 <= 0) {
                return b2;
            } else {
                j = this.u.j();
            }
            return j - 1;
        }
        return invokeV.intValue;
    }

    public void H0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) || bundle == null) {
            return;
        }
        bundle.putString("thread_id", this.f19658f);
        bundle.putString("post_id", this.f19659g);
        bundle.putString("st_type", this.f19660h);
        bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.f19661i);
        bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.j);
        bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.k);
        bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.p);
        bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.r);
        bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.E));
        AntiData antiData = this.y;
        if (antiData != null) {
            bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, antiData.toJsonString());
        }
        if (!ListUtils.isEmpty(this.x)) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<IconData> it = this.x.iterator();
            while (it.hasNext()) {
                String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                if (!StringUtils.isNull(jsonStrWithObject)) {
                    arrayList.add(jsonStrWithObject);
                }
            }
            bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
        }
        bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        bundle.putString("from_forum_id", this.n);
        bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.o);
        bundle.putString("high_light_post_id", this.l);
        bundle.putBoolean("high_light_post_id", this.m);
        bundle.putBoolean(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, this.X);
    }

    public void I0(PbFakeFloorModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
        }
    }

    public void J0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.L = z;
        }
    }

    public void K0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.q = z;
        }
    }

    public void L0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.s = str;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void M0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.v = bVar;
        }
    }

    public boolean N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? C0(2) : invokeV.booleanValue;
    }

    public final SubPbRequestMessage R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            this.C = true;
            return S(null);
        }
        return (SubPbRequestMessage) invokeV.objValue;
    }

    public final SubPbRequestMessage S(Integer num) {
        InterceptResult invokeL;
        long f2;
        long j;
        long f3;
        long f4;
        int intValue;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, num)) == null) {
            float f5 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int k = l.k(TbadkCoreApplication.getInst().getApp());
            int i4 = l.i(TbadkCoreApplication.getInst().getApp());
            if (1 != this.f19657e) {
                j = d.a.c.e.m.b.f(this.f19659g, 0L);
                f2 = 0;
            } else {
                if (!k.isEmpty(this.M)) {
                    f3 = d.a.c.e.m.b.f(this.f19659g, 0L);
                    f4 = d.a.c.e.m.b.f(this.k, 0L);
                } else if (!TextUtils.isEmpty(this.k)) {
                    f3 = d.a.c.e.m.b.f(this.f19659g, 0L);
                    f4 = d.a.c.e.m.b.f(this.k, 0L);
                } else {
                    f2 = d.a.c.e.m.b.f(this.f19659g, 0L);
                    j = 0;
                }
                f2 = f4;
                j = f3;
            }
            if (num == null) {
                intValue = G0();
            } else {
                intValue = num.intValue();
            }
            if (this.F && this.f19657e == 0) {
                i2 = 1;
                i3 = 1;
            } else {
                i2 = intValue;
                i3 = 0;
            }
            SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.t.getPageActivity(), Long.parseLong(this.f19658f), j, f2, i2, k, i4, f5, this.f19660h, i3);
            subPbRequestMessage.setOriUgcNid(this.M);
            subPbRequestMessage.setOriUgcTid(this.N);
            subPbRequestMessage.setOriUgcType(this.O);
            subPbRequestMessage.setOriUgcVid(this.P);
            if (f2 != 0) {
                subPbRequestMessage.setOriUgcTopPid(this.Q);
            }
            subPbRequestMessage.setForumId(d.a.c.e.m.b.f(this.n, 0L));
            return subPbRequestMessage;
        }
        return (SubPbRequestMessage) invokeL.objValue;
    }

    public void T() {
        r rVar;
        int g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.w > 0 && (rVar = this.u) != null && (g2 = rVar.g()) > 0) {
                int i2 = ((this.w + g2) - 1) / g2;
                int b2 = this.u.b();
                for (int i3 = i2 - 1; i3 >= 0; i3--) {
                    SubPbRequestMessage S = S(Integer.valueOf(b2 - i3));
                    this.Y = S;
                    S.setTreatDelPage(true);
                    sendMessage(this.Y);
                }
            }
            this.w = 0;
        }
    }

    public void U(String str) {
        r rVar;
        r rVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || TextUtils.isEmpty(str) || (rVar = this.u) == null || rVar.k() == null) {
            return;
        }
        ArrayList<PostData> k = this.u.k();
        int size = k.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equals(k.get(i2).E())) {
                k.remove(i2);
                this.w++;
                this.u.F(rVar2.m() - 1);
                return;
            }
        }
    }

    public AntiData V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.y : (AntiData) invokeV.objValue;
    }

    public AttentionHostData W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.z == null) {
                this.z = new AttentionHostData();
                r rVar = this.u;
                if (rVar != null && rVar.l() != null && this.u.l().H() != null) {
                    this.z.parserWithMetaData(this.u.l().H());
                }
            }
            return this.z;
        }
        return (AttentionHostData) invokeV.objValue;
    }

    public r X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.u : (r) invokeV.objValue;
    }

    public int Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.U : invokeV.intValue;
    }

    public int Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.T : invokeV.intValue;
    }

    public String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.V : (String) invokeV.objValue;
    }

    public int b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.R : invokeV.intValue;
    }

    public String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            cancelMessage();
            return true;
        }
        return invokeV.booleanValue;
    }

    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.S : invokeV.intValue;
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            cancelMessage();
            MessageManager.getInstance().unRegisterListener(this.Z);
            PbFakeFloorModel pbFakeFloorModel = this.K;
            if (pbFakeFloorModel != null) {
                pbFakeFloorModel.unRegisterListener();
            }
            D0();
        }
    }

    public MarkData e0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, postData)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.f19658f);
            markData.setPostId(postData.E());
            markData.setTime(date.getTime());
            markData.setHostMode(false);
            markData.setId(this.f19658f);
            markData.setFloor(postData.A());
            return markData;
        }
        return (MarkData) invokeL.objValue;
    }

    public String f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    public int g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.J : invokeV.intValue;
    }

    public String getFromForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public String getStType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f19660h : (String) invokeV.objValue;
    }

    public int h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.pageFromType : invokeV.intValue;
    }

    public String i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public void initWithBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, bundle) == null) || bundle == null) {
            return;
        }
        this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
        this.f19658f = bundle.getString("thread_id");
        this.f19659g = bundle.getString("post_id");
        this.f19660h = bundle.getString("st_type");
        this.n = bundle.getString("from_forum_id");
        this.o = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
        this.f19661i = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        this.j = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
        this.p = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
        this.k = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
        this.r = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
        String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
        if (!StringUtils.isNull(string)) {
            this.E = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
        }
        SmallTailInfo smallTailInfo = this.E;
        if (smallTailInfo != null) {
            smallTailInfo.updateShowInfo();
        }
        String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
        if (!StringUtils.isNull(string2)) {
            AntiData antiData = new AntiData();
            this.y = antiData;
            antiData.parserJson(string2);
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
        if (!ListUtils.isEmpty(stringArrayList)) {
            this.x = new ArrayList<>();
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                if (iconData != null) {
                    this.x.add(iconData);
                }
            }
        }
        this.A = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        this.l = bundle.getString("high_light_post_id");
        this.m = bundle.getBoolean(SubPbActivityConfig.KEY_IS_USE_SPID, false);
        this.R = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
        this.S = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
        this.R = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
        this.S = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
        this.T = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
        this.U = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
        this.V = bundle.getString(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
        this.W = bundle.getInt(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        this.X = bundle.getBoolean(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, false);
    }

    public void initWithIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, intent) == null) || intent == null) {
            return;
        }
        this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
        this.f19658f = intent.getStringExtra("thread_id");
        this.f19659g = intent.getStringExtra("post_id");
        this.f19660h = intent.getStringExtra("st_type");
        this.n = intent.getStringExtra("from_forum_id");
        this.o = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
        this.f19661i = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        this.j = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
        this.p = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
        this.k = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
        this.r = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
        SmallTailInfo smallTailInfo = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
        this.E = smallTailInfo;
        if (smallTailInfo != null) {
            smallTailInfo.updateShowInfo();
        }
        this.y = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
        this.x = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
        this.A = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        this.M = intent.getStringExtra("key_ori_ugc_nid");
        this.N = intent.getStringExtra("key_ori_ugc_tid");
        this.O = intent.getIntExtra("key_ori_ugc_type", 0);
        this.P = intent.getStringExtra("key_ori_ugc_vid");
        this.Q = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
        Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
        if (bundleExtra != null) {
            ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
            this.H = new ConcurrentHashMap<>();
            if (stringArrayList != null) {
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!StringUtils.isNull(next)) {
                        this.H.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                    }
                }
            }
            this.G = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
            this.I = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
            this.J = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
        }
        this.l = intent.getStringExtra("high_light_post_id");
        this.m = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_USE_SPID, false);
        this.R = intent.getIntExtra(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
        this.S = intent.getIntExtra(SubPbActivityConfig.KEY_IS_MANAGER, 0);
        this.T = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
        this.U = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
        this.V = intent.getStringExtra(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
        this.W = intent.getIntExtra(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        this.X = intent.getBooleanExtra(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, false);
    }

    public SmallTailInfo j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.E : (SmallTailInfo) invokeV.objValue;
    }

    public String k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f19658f : (String) invokeV.objValue;
    }

    public String l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (!StringUtils.isNull(this.f19658f) && !"0".equals(this.f19658f)) {
                return this.f19658f;
            }
            return this.M;
        }
        return (String) invokeV.objValue;
    }

    public ArrayList<String> m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.G : (ArrayList) invokeV.objValue;
    }

    public ConcurrentHashMap<String, ImageUrlData> n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.H : (ConcurrentHashMap) invokeV.objValue;
    }

    public int o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.r : invokeV.intValue;
    }

    public int p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.W : invokeV.intValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            r rVar = this.u;
            return (rVar == null || rVar.i() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.I : invokeV.booleanValue;
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? "hot_topic".equals(getStType()) : invokeV.booleanValue;
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.f19661i : invokeV.booleanValue;
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.X : invokeV.booleanValue;
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.q : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.f19659g : (String) invokeV.objValue;
    }

    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.L : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, str)) == null) {
            r rVar = this.u;
            if (rVar == null || rVar.d() == null || this.u.l() == null || this.u.i() == null) {
                return null;
            }
            WriteData writeData = new WriteData();
            writeData.sourceFrom = String.valueOf(this.pageFromType);
            writeData.setForumName(this.u.d().getName());
            writeData.setForumId(this.u.d().getId());
            writeData.setFromForumId(this.o);
            writeData.setFloor(this.u.i().E());
            writeData.setType(2);
            writeData.setThreadId(this.u.l().c0());
            writeData.setFloorNum(0);
            return writeData;
        }
        return (WriteData) invokeL.objValue;
    }

    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.A : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            N0();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? C0(0) : invokeV.booleanValue;
    }
}
