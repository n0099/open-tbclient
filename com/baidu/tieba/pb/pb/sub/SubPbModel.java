package com.baidu.tieba.pb.pb.sub;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.o0.s.q.c2;
import c.a.p0.i2.h.r;
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
/* loaded from: classes7.dex */
public class SubPbModel extends DataModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public AntiData A;
    public AttentionHostData B;
    public boolean C;
    public ArrayList<r> D;
    public boolean E;
    public c.a.p0.i3.j0.b F;
    public SmallTailInfo G;
    public boolean H;
    public ArrayList<String> I;
    public ConcurrentHashMap<String, ImageUrlData> J;
    public boolean K;
    public int L;
    public PbFakeFloorModel M;
    public boolean N;
    public String O;
    public String P;
    public int Q;
    public String R;
    public String S;
    public int T;
    public int U;
    public int V;
    public int W;
    public String X;
    public int Y;
    public boolean Z;
    public boolean a0;
    public String b0;
    public String c0;

    /* renamed from: e  reason: collision with root package name */
    public int f55112e;

    /* renamed from: f  reason: collision with root package name */
    public String f55113f;

    /* renamed from: g  reason: collision with root package name */
    public String f55114g;

    /* renamed from: h  reason: collision with root package name */
    public String f55115h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f55116i;
    public String i0;

    /* renamed from: j  reason: collision with root package name */
    public boolean f55117j;
    public boolean j0;
    public String k;
    public SubPbRequestMessage k0;
    public String l;
    public c.a.e.c.g.a l0;
    public String m;
    public boolean n;
    public String o;
    public String p;
    public int pageFromType;
    @Nullable
    public WorksInfoData q;
    public boolean r;
    public boolean s;
    public int t;
    public String u;
    public TbPageContext<?> v;
    public r w;
    public b x;
    public int y;
    public ArrayList<IconData> z;

    /* loaded from: classes7.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SubPbModel f55118a;

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
            this.f55118a = subPbModel;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j2;
            boolean z;
            r rVar;
            String str;
            boolean z2;
            r rVar2;
            long j3;
            long j4;
            int i2;
            r rVar3;
            c2 l;
            r rVar4;
            c2 l2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && this.f55118a.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                this.f55118a.E = false;
                if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                    this.f55118a.v.getPageActivity().finish();
                }
                boolean z3 = responsedMessage instanceof SubPbHttpResponseMessage;
                long j5 = 0;
                if (z3) {
                    SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                    subPbHttpResponseMessage.getDownSize();
                    j2 = responsedMessage.getCostTime();
                    if (subPbHttpResponseMessage != null && (rVar4 = subPbHttpResponseMessage.pbFloorData) != null && (l2 = rVar4.l()) != null) {
                        this.f55118a.f0(l2);
                    }
                    if (subPbHttpResponseMessage.isTreatDelPage()) {
                        if (subPbHttpResponseMessage.hasError()) {
                            return;
                        }
                        this.f55118a.D.add(subPbHttpResponseMessage.pbFloorData);
                        return;
                    }
                    z = true;
                } else {
                    j2 = 0;
                    z = false;
                }
                boolean z4 = responsedMessage instanceof SubPbSocketResponseMessage;
                if (z4) {
                    j5 = responsedMessage.getCostTime();
                    SubPbSocketResponseMessage subPbSocketResponseMessage = (SubPbSocketResponseMessage) responsedMessage;
                    if (subPbSocketResponseMessage != null && (rVar3 = subPbSocketResponseMessage.pbFloorData) != null && (l = rVar3.l()) != null) {
                        this.f55118a.f0(l);
                    }
                    if (subPbSocketResponseMessage.isTreatDelPage()) {
                        if (subPbSocketResponseMessage.hasError()) {
                            return;
                        }
                        this.f55118a.D.add(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                }
                if (this.f55118a.D != null && this.f55118a.D.size() > 0) {
                    try {
                        for (int size = this.f55118a.D.size() - 1; size >= 0; size--) {
                            r rVar5 = (r) this.f55118a.D.get(size);
                            if (this.f55118a.H) {
                                this.f55118a.w.t(rVar5, true);
                            } else {
                                this.f55118a.w.r(rVar5, true);
                            }
                        }
                    } catch (Exception e2) {
                        BdLog.detailException(e2);
                    }
                    this.f55118a.D.clear();
                }
                int error = responsedMessage.getError();
                String errorString = responsedMessage.getErrorString();
                if (this.f55118a.F == null) {
                    this.f55118a.F = new c.a.p0.i3.j0.b("pbfloorStat");
                }
                if (this.f55118a.F != null) {
                    if (error == 0) {
                        if (z3) {
                            i2 = ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                            j3 = j5;
                            j4 = responsedMessage.getCostTime();
                        } else if (z4) {
                            int downSize = ((SubPbSocketResponseMessage) responsedMessage).getDownSize();
                            j3 = responsedMessage.getCostTime();
                            j4 = j2;
                            i2 = downSize;
                        } else {
                            j3 = j5;
                            j4 = j2;
                            i2 = -1;
                        }
                        long j6 = i2;
                        rVar = null;
                        str = errorString;
                        z2 = z4;
                        this.f55118a.F.b(z, true, error, errorString, j6, j4, j3);
                        this.f55118a.F = new c.a.p0.i3.j0.b("pbfloorStat");
                        this.f55118a.F = null;
                    } else {
                        rVar = null;
                        str = errorString;
                        z2 = z4;
                    }
                    if (responsedMessage == null || ((!z2 && !z3) || responsedMessage.getError() != 0)) {
                        String str2 = str;
                        if (this.f55118a.x != null) {
                            this.f55118a.x.a(false, error, str2, rVar);
                        }
                    } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                        if (z3) {
                            rVar2 = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                        } else {
                            rVar2 = z2 ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : rVar;
                        }
                        if (rVar2.c().errorno.intValue() != 0) {
                            if (this.f55118a.x != null) {
                                this.f55118a.x.a(false, rVar2.m.errorno.intValue(), rVar2.m.errmsg, rVar);
                                return;
                            }
                            return;
                        }
                        if (rVar2.l() != null && rVar2.l().J() != null) {
                            rVar2.l().J().getUserId();
                            if (ListUtils.isEmpty(rVar2.i().t().getIconInfo()) && this.f55118a.z != null) {
                                rVar2.i().t().setIconInfo(this.f55118a.z);
                            }
                        }
                        if (rVar2.i() != null) {
                            this.f55118a.f55114g = rVar2.i().E();
                        }
                        if (rVar2.l() != null) {
                            this.f55118a.f55113f = rVar2.l().f0();
                            this.f55118a.s = rVar2.f();
                            this.f55118a.u = rVar2.l().B0();
                            rVar2.l().J2 = this.f55118a.q;
                        }
                        if (this.f55118a.u != null && this.f55118a.f55114g != null && this.f55118a.u.equals(this.f55118a.f55114g)) {
                            this.f55118a.s = true;
                        }
                        if (this.f55118a.H) {
                            this.f55118a.R0(rVar2);
                        } else {
                            this.f55118a.S0(rVar2);
                        }
                        if (this.f55118a.x != null) {
                            this.f55118a.x.a(this.f55118a.C0(), error, str, this.f55118a.w);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
        this.f55112e = 0;
        this.f55113f = null;
        this.f55114g = null;
        this.f55115h = null;
        this.f55116i = false;
        this.f55117j = false;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.pageFromType = 0;
        this.r = false;
        this.s = false;
        this.t = 0;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = 0;
        this.C = false;
        this.D = null;
        this.E = false;
        this.F = null;
        this.K = true;
        this.L = 0;
        this.M = null;
        this.N = false;
        this.l0 = new a(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.v = tbPageContext;
        this.D = new ArrayList<>();
        this.w = new r();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.l0);
        registerListener(this.l0);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b0 : (String) invokeV.objValue;
    }

    public int A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.t : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.Y : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            r rVar = this.w;
            if (rVar == null || rVar.d() == null || this.w.l() == null || this.w.i() == null) {
                return null;
            }
            WriteData writeData = new WriteData();
            writeData.sourceFrom = String.valueOf(this.pageFromType);
            writeData.setForumName(this.w.d().getName());
            writeData.setForumId(this.w.d().getId());
            writeData.setFromForumId(this.p);
            writeData.setFloor(this.w.i().E());
            writeData.setType(2);
            writeData.setThreadId(this.w.l().f0());
            writeData.setFloorNum(0);
            return writeData;
        }
        return (WriteData) invokeL.objValue;
    }

    public boolean C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            r rVar = this.w;
            return (rVar == null || rVar.i() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.K : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a0 : invokeV.booleanValue;
    }

    public boolean E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "hot_topic".equals(getStType()) : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j0 : invokeV.booleanValue;
    }

    public boolean F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f55116i : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            a1();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f55117j : invokeV.booleanValue;
    }

    public boolean H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.Z : invokeV.booleanValue;
    }

    public boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public boolean J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.N : invokeV.booleanValue;
    }

    public boolean K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.C : invokeV.booleanValue;
    }

    public boolean L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.n : invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? P0(0) : invokeV.booleanValue;
    }

    public boolean N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? P0(1) : invokeV.booleanValue;
    }

    public boolean O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? P0(3) : invokeV.booleanValue;
    }

    public boolean P0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            if (this.E) {
                return false;
            }
            cancelMessage();
            if (this.f55113f != null && this.f55114g != null) {
                d0();
                this.f55112e = i2;
                SubPbRequestMessage b0 = b0();
                this.k0 = b0;
                sendMessage(b0);
                return true;
            }
            this.E = false;
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void Q0() {
        c.a.p0.i3.j0.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (bVar = this.F) == null) {
            return;
        }
        bVar.a();
        this.F = null;
    }

    public final void R0(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, rVar) == null) {
            int i2 = this.f55112e;
            if (i2 == 1) {
                this.w = rVar;
                rVar.H();
            } else if (i2 == 2) {
                this.w.t(rVar, true);
            } else if (i2 == 3) {
                this.w.u(rVar, false);
            } else {
                this.w.s(rVar);
            }
        }
    }

    public final void S0(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, rVar) == null) {
            ArrayList<PostData> k = rVar.k();
            if (k == null || k.size() == 0) {
                rVar.z(this.w.b());
            }
            int i2 = this.f55112e;
            if (i2 == 1) {
                this.w = rVar;
            } else if (i2 == 2) {
                this.w.r(rVar, true);
            } else if (i2 == 3) {
                this.w.v(rVar, false);
            } else {
                this.w.r(rVar, false);
            }
        }
    }

    public int T0() {
        InterceptResult invokeV;
        int i2;
        int j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            int b2 = this.w.b();
            if (b2 == 0 || (i2 = this.f55112e) == 0 || (i2 == 2 && this.w.k().size() != 0 && this.w.k().size() % this.w.g() == 0)) {
                return b2 + 1;
            }
            if (this.f55112e == 3 && this.H) {
                j2 = this.w.h();
            } else if (this.f55112e != 3 || b2 <= 0) {
                return b2;
            } else {
                j2 = this.w.j();
            }
            return j2 - 1;
        }
        return invokeV.intValue;
    }

    public void U0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) || bundle == null) {
            return;
        }
        bundle.putString("thread_id", this.f55113f);
        bundle.putString("post_id", this.f55114g);
        bundle.putString("st_type", this.f55115h);
        bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.f55116i);
        bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB, this.f55117j);
        bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.k);
        bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.l);
        bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.r);
        bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.t);
        bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.G));
        AntiData antiData = this.A;
        if (antiData != null) {
            bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, antiData.toJsonString());
        }
        if (!ListUtils.isEmpty(this.z)) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<IconData> it = this.z.iterator();
            while (it.hasNext()) {
                String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                if (!StringUtils.isNull(jsonStrWithObject)) {
                    arrayList.add(jsonStrWithObject);
                }
            }
            bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
        }
        bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        bundle.putString("from_forum_id", this.o);
        bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.p);
        bundle.putSerializable(SubPbActivityConfig.KEY_WORKS_INFO_DATA, this.q);
        bundle.putString("high_light_post_id", this.m);
        bundle.putBoolean("high_light_post_id", this.n);
        bundle.putBoolean(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, this.Z);
        bundle.putBoolean("key_is_tieba_plus", this.a0);
        bundle.putString("key_tieba_plus_order_id", this.b0);
        bundle.putString("key_tieba_plus_token", this.c0);
        bundle.putString("key_tieba_extra_param", this.i0);
        bundle.putBoolean("key_tieba_plus_cant_delete", this.j0);
    }

    public void V0(PbFakeFloorModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bVar) == null) {
        }
    }

    public void W0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.N = z;
        }
    }

    public void X0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.s = z;
        }
    }

    public void Y0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.u = str;
        }
    }

    public void Z0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bVar) == null) {
            this.x = bVar;
        }
    }

    public boolean a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? P0(2) : invokeV.booleanValue;
    }

    public final SubPbRequestMessage b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            this.E = true;
            return c0(null);
        }
        return (SubPbRequestMessage) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0071, code lost:
        if (r4 == r6) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SubPbRequestMessage c0(Integer num) {
        InterceptResult invokeL;
        long f2;
        long j2;
        long f3;
        int intValue;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, num)) == null) {
            float f4 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int k = l.k(TbadkCoreApplication.getInst().getApp());
            int i4 = l.i(TbadkCoreApplication.getInst().getApp());
            if (1 != this.f55112e) {
                j2 = c.a.e.e.m.b.f(this.f55114g, 0L);
                f2 = 0;
            } else {
                if (!k.isEmpty(this.O)) {
                    f3 = c.a.e.e.m.b.f(this.f55114g, 0L);
                    f2 = c.a.e.e.m.b.f(this.l, 0L);
                } else {
                    if (!TextUtils.isEmpty(this.l)) {
                        f3 = c.a.e.e.m.b.f(this.f55114g, 0L);
                        long f5 = c.a.e.e.m.b.f(this.l, 0L);
                        f2 = f5;
                    } else {
                        f2 = c.a.e.e.m.b.f(this.f55114g, 0L);
                    }
                    j2 = 0;
                }
                j2 = f3;
            }
            if (num == null) {
                intValue = T0();
            } else {
                intValue = num.intValue();
            }
            if (this.H && this.f55112e == 0) {
                i2 = 1;
                i3 = 1;
            } else {
                i2 = intValue;
                i3 = 0;
            }
            SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.v.getPageActivity(), Long.parseLong(this.f55113f), j2, f2, i2, k, i4, f4, this.f55115h, i3);
            subPbRequestMessage.setOriUgcNid(this.O);
            subPbRequestMessage.setOriUgcTid(this.P);
            subPbRequestMessage.setOriUgcType(this.Q);
            subPbRequestMessage.setOriUgcVid(this.R);
            if (f2 != 0) {
                subPbRequestMessage.setOriUgcTopPid(this.S);
            }
            subPbRequestMessage.setForumId(c.a.e.e.m.b.f(this.o, 0L));
            return subPbRequestMessage;
        }
        return (SubPbRequestMessage) invokeL.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            cancelMessage();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void d0() {
        r rVar;
        int g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            if (this.y > 0 && (rVar = this.w) != null && (g2 = rVar.g()) > 0) {
                int i2 = ((this.y + g2) - 1) / g2;
                int b2 = this.w.b();
                for (int i3 = i2 - 1; i3 >= 0; i3--) {
                    SubPbRequestMessage c0 = c0(Integer.valueOf(b2 - i3));
                    this.k0 = c0;
                    c0.setTreatDelPage(true);
                    sendMessage(this.k0);
                }
            }
            this.y = 0;
        }
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            cancelMessage();
            MessageManager.getInstance().unRegisterListener(this.l0);
            PbFakeFloorModel pbFakeFloorModel = this.M;
            if (pbFakeFloorModel != null) {
                pbFakeFloorModel.unRegisterListener();
            }
            Q0();
        }
    }

    public void e0(String str) {
        r rVar;
        r rVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, str) == null) || TextUtils.isEmpty(str) || (rVar = this.w) == null || rVar.k() == null) {
            return;
        }
        ArrayList<PostData> k = this.w.k();
        int size = k.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equals(k.get(i2).E())) {
                k.remove(i2);
                this.y++;
                this.w.F(rVar2.m() - 1);
                return;
            }
        }
    }

    public final void f0(@NonNull c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, c2Var) == null) {
            c2Var.O2 = E();
            c2Var.P2 = A();
            c2Var.Q2 = B();
            c2Var.R2 = B();
            c2Var.S2 = F();
            c2Var.w3(w());
        }
    }

    public AntiData g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.A : (AntiData) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getFromForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public String getStType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.f55115h : (String) invokeV.objValue;
    }

    public AttentionHostData h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (this.B == null) {
                this.B = new AttentionHostData();
                r rVar = this.w;
                if (rVar != null && rVar.l() != null && this.w.l().J() != null) {
                    this.B.parserWithMetaData(this.w.l().J());
                }
            }
            return this.B;
        }
        return (AttentionHostData) invokeV.objValue;
    }

    public r i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.w : (r) invokeV.objValue;
    }

    public void initWithBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048622, this, bundle) == null) || bundle == null) {
            return;
        }
        this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
        this.f55113f = bundle.getString("thread_id");
        this.f55114g = bundle.getString("post_id");
        this.f55115h = bundle.getString("st_type");
        this.o = bundle.getString("from_forum_id");
        this.p = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
        this.q = (WorksInfoData) bundle.getSerializable(SubPbActivityConfig.KEY_WORKS_INFO_DATA);
        this.f55116i = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        this.f55117j = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB, false);
        this.k = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
        this.r = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
        this.l = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
        this.t = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
        String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
        if (!StringUtils.isNull(string)) {
            this.G = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
        }
        SmallTailInfo smallTailInfo = this.G;
        if (smallTailInfo != null) {
            smallTailInfo.updateShowInfo();
        }
        String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
        if (!StringUtils.isNull(string2)) {
            AntiData antiData = new AntiData();
            this.A = antiData;
            antiData.parserJson(string2);
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
        if (!ListUtils.isEmpty(stringArrayList)) {
            this.z = new ArrayList<>();
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                if (iconData != null) {
                    this.z.add(iconData);
                }
            }
        }
        this.C = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        this.m = bundle.getString("high_light_post_id");
        this.n = bundle.getBoolean(SubPbActivityConfig.KEY_IS_USE_SPID, false);
        this.T = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
        this.U = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
        this.T = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
        this.U = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
        this.V = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
        this.W = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
        this.X = bundle.getString(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
        this.Y = bundle.getInt(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        this.Z = bundle.getBoolean(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, false);
        this.a0 = bundle.getBoolean("key_is_tieba_plus");
        this.b0 = bundle.getString("key_tieba_plus_order_id");
        this.c0 = bundle.getString("key_tieba_plus_token");
        this.i0 = bundle.getString("key_tieba_extra_param");
        this.j0 = bundle.getBoolean("key_tieba_plus_cant_delete");
    }

    public void initWithIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, intent) == null) || intent == null) {
            return;
        }
        this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
        this.f55113f = intent.getStringExtra("thread_id");
        this.f55114g = intent.getStringExtra("post_id");
        this.f55115h = intent.getStringExtra("st_type");
        this.o = intent.getStringExtra("from_forum_id");
        this.p = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
        this.q = (WorksInfoData) intent.getSerializableExtra(SubPbActivityConfig.KEY_WORKS_INFO_DATA);
        this.f55116i = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        this.f55117j = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB, false);
        this.k = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
        this.r = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
        this.l = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
        this.t = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
        SmallTailInfo smallTailInfo = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
        this.G = smallTailInfo;
        if (smallTailInfo != null) {
            smallTailInfo.updateShowInfo();
        }
        this.A = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
        this.z = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
        this.C = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        this.O = intent.getStringExtra("key_ori_ugc_nid");
        this.P = intent.getStringExtra("key_ori_ugc_tid");
        this.Q = intent.getIntExtra("key_ori_ugc_type", 0);
        this.R = intent.getStringExtra("key_ori_ugc_vid");
        this.S = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
        Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
        if (bundleExtra != null) {
            ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
            this.J = new ConcurrentHashMap<>();
            if (stringArrayList != null) {
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!StringUtils.isNull(next)) {
                        this.J.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                    }
                }
            }
            this.I = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
            this.K = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
            this.L = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
        }
        this.m = intent.getStringExtra("high_light_post_id");
        this.n = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_USE_SPID, false);
        this.T = intent.getIntExtra(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
        this.U = intent.getIntExtra(SubPbActivityConfig.KEY_IS_MANAGER, 0);
        this.V = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
        this.W = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
        this.X = intent.getStringExtra(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
        this.Y = intent.getIntExtra(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        this.Z = intent.getBooleanExtra(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, false);
        this.a0 = intent.getBooleanExtra("key_is_tieba_plus", false);
        this.b0 = intent.getStringExtra("key_tieba_plus_order_id");
        this.c0 = intent.getStringExtra("key_tieba_plus_token");
        this.i0 = intent.getStringExtra("key_tieba_extra_param");
        this.j0 = intent.getBooleanExtra("key_tieba_plus_cant_delete", false);
    }

    public int j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.W : invokeV.intValue;
    }

    public int k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.V : invokeV.intValue;
    }

    public String l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.X : (String) invokeV.objValue;
    }

    public String m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public int n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.T : invokeV.intValue;
    }

    public String o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public int p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.U : invokeV.intValue;
    }

    public MarkData q0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, postData)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.f55113f);
            markData.setPostId(postData.E());
            markData.setTime(date.getTime());
            markData.setHostMode(false);
            markData.setId(this.f55113f);
            markData.setFloor(postData.A());
            return markData;
        }
        return (MarkData) invokeL.objValue;
    }

    public String r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.u : (String) invokeV.objValue;
    }

    public int s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.L : invokeV.intValue;
    }

    public int t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.pageFromType : invokeV.intValue;
    }

    public String u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public SmallTailInfo v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.G : (SmallTailInfo) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    @Nullable
    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? m0() : (String) invokeV.objValue;
    }

    public String w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.f55113f : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public int x() {
        InterceptResult invokeV;
        PostData i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            r rVar = this.w;
            if (rVar != null && (i2 = rVar.i()) != null) {
                return i2.A();
            }
            return super.x();
        }
        return invokeV.intValue;
    }

    public String x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            if (!StringUtils.isNull(this.f55113f) && !"0".equals(this.f55113f)) {
                return this.f55113f;
            }
            return this.O;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.f55114g : (String) invokeV.objValue;
    }

    public ArrayList<String> y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.I : (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.i0 : (String) invokeV.objValue;
    }

    public ConcurrentHashMap<String, ImageUrlData> z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.J : (ConcurrentHashMap) invokeV.objValue;
    }
}
