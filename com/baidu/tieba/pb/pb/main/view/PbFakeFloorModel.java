package com.baidu.tieba.pb.pb.main.view;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.f;
import b.a.r0.k2.l;
import b.a.r0.k2.r.t;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class PbFakeFloorModel extends DataModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f53452e;

    /* renamed from: f  reason: collision with root package name */
    public t f53453f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53454g;

    /* renamed from: h  reason: collision with root package name */
    public SubPbRequestMessage f53455h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext f53456i;
    public b j;
    public String k;
    public boolean l;
    public String m;
    public String n;
    public String o;
    public boolean p;
    public b.a.e.c.g.a q;

    /* loaded from: classes9.dex */
    public class a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFakeFloorModel f53457a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PbFakeFloorModel pbFakeFloorModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFakeFloorModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f53457a = pbFakeFloorModel;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String userId;
            String errorString;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null || this.f53457a.unique_id != responsedMessage.getOrginalMessage().getTag()) {
                return;
            }
            boolean z = false;
            this.f53457a.f53454g = false;
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    errorString = this.f53457a.f53456i.getPageActivity().getResources().getString(l.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                this.f53457a.f53456i.showToast(errorString);
                return;
            }
            t tVar = null;
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                tVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
            } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                tVar = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
            }
            if (tVar == null || tVar.k() == null) {
                return;
            }
            PostData postData = (PostData) ListUtils.getItem(tVar.k(), tVar.k().size() - 1);
            if (postData != null && this.f53457a.f53453f != null && this.f53457a.f53453f.i() != null) {
                if (this.f53457a.f53453f.l() != null && this.f53457a.f53453f.l().J() != null && postData.t() != null && (userId = this.f53457a.f53453f.l().J().getUserId()) != null && userId.equals(postData.t().getUserId())) {
                    z = true;
                }
                postData.F0(this.f53457a.f53456i, z);
            }
            if (this.f53457a.j != null) {
                this.f53457a.j.a(postData);
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(PostData postData);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFakeFloorModel(TbPageContext tbPageContext) {
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
        this.f53453f = null;
        this.f53454g = false;
        this.j = null;
        a aVar = new a(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.q = aVar;
        this.f53456i = tbPageContext;
        registerListener(aVar);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            t tVar = this.f53453f;
            if (tVar == null || tVar.d() == null || this.f53453f.l() == null || this.f53453f.i() == null) {
                return null;
            }
            WriteData writeData = new WriteData();
            boolean n2 = this.f53453f.l().n2();
            if (n2) {
                writeData.setVForumId(this.f53453f.d().getId());
                writeData.setVForumName(this.f53453f.d().getName());
            } else {
                writeData.setForumName(this.f53453f.d().getName());
                writeData.setForumId(this.f53453f.d().getId());
            }
            writeData.setFromForumId(this.k);
            writeData.setFloor(this.f53453f.i().G());
            writeData.setType(2);
            writeData.setCanNoForum(n2);
            writeData.setThreadId(this.f53453f.l().f0());
            writeData.setFloorNum(0);
            return writeData;
        }
        return (WriteData) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.l : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.p : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Q();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void N(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, postData) == null) || postData == null) {
            return;
        }
        this.f53453f.i().d(postData);
        this.f53453f.i().e(postData);
        this.f53453f.i().u0(true);
    }

    public final SubPbRequestMessage O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            t tVar = this.f53453f;
            if (tVar != null && tVar.l() != null && this.f53453f.l().f0() != null && this.f53453f.i() != null && this.f53453f.i().G() != null) {
                this.f53454g = true;
                float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                int k = b.a.e.f.p.l.k(TbadkCoreApplication.getInst().getApp());
                int i2 = b.a.e.f.p.l.i(TbadkCoreApplication.getInst().getApp());
                return new SubPbRequestMessage(this.f53456i.getPageActivity(), b.a.e.f.m.b.g(this.f53453f.l().f0(), 0L), b.a.e.f.m.b.g(this.f53453f.i().G(), 0L), 0L, 1, k, i2, f2, "", 1);
            }
            this.f53454g = false;
            return null;
        }
        return (SubPbRequestMessage) invokeV.objValue;
    }

    public void P(boolean z, @NonNull String str, @NonNull String str2, @NonNull String str3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), str, str2, str3, Boolean.valueOf(z2)}) == null) {
            this.l = z;
            this.m = str;
            this.n = str2;
            this.o = str3;
            this.p = z2;
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f53454g) {
            return;
        }
        cancelMessage();
        SubPbRequestMessage O = O();
        this.f53455h = O;
        if (O == null) {
            return;
        }
        sendMessage(O);
    }

    public void R(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.j = bVar;
        }
    }

    public void S(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, tVar) == null) {
            this.f53453f = tVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            t tVar = this.f53453f;
            if (tVar == null || tVar.d() == null) {
                return null;
            }
            return this.f53453f.d().getId();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getFromForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setFromForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.k = str;
        }
    }

    public void setPostId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.f53452e = str;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            registerListener(this.q);
        }
    }

    public void unRegisterListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            MessageManager.getInstance().unRegisterListener(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public int x() {
        InterceptResult invokeV;
        PostData i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            t tVar = this.f53453f;
            if (tVar != null && (i2 = tVar.i()) != null) {
                return i2.A();
            }
            return super.x();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f53452e : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            t tVar = this.f53453f;
            if (tVar == null || tVar.l() == null) {
                return null;
            }
            return this.f53453f.l().t1();
        }
        return (String) invokeV.objValue;
    }
}
