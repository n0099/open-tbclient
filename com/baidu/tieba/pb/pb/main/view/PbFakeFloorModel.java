package com.baidu.tieba.pb.pb.main.view;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.f;
import d.a.d.e.p.l;
import d.a.q0.h2.h.r;
/* loaded from: classes4.dex */
public class PbFakeFloorModel extends DataModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f19640e;

    /* renamed from: f  reason: collision with root package name */
    public r f19641f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19642g;

    /* renamed from: h  reason: collision with root package name */
    public SubPbRequestMessage f19643h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext f19644i;
    public b j;
    public String k;
    public boolean l;
    public String m;
    public String n;
    public String o;
    public boolean p;
    public d.a.d.c.g.a q;

    /* loaded from: classes4.dex */
    public class a extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFakeFloorModel f19645a;

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
            this.f19645a = pbFakeFloorModel;
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String userId;
            String errorString;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null || this.f19645a.unique_id != responsedMessage.getOrginalMessage().getTag()) {
                return;
            }
            boolean z = false;
            this.f19645a.f19642g = false;
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    errorString = this.f19645a.f19644i.getPageActivity().getResources().getString(R.string.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                this.f19645a.f19644i.showToast(errorString);
                return;
            }
            r rVar = null;
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                rVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
            } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                rVar = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
            }
            if (rVar == null || rVar.k() == null) {
                return;
            }
            PostData postData = (PostData) ListUtils.getItem(rVar.k(), rVar.k().size() - 1);
            if (postData != null && this.f19645a.f19641f != null && this.f19645a.f19641f.i() != null) {
                if (this.f19645a.f19641f.l() != null && this.f19645a.f19641f.l().H() != null && postData.t() != null && (userId = this.f19645a.f19641f.l().H().getUserId()) != null && userId.equals(postData.t().getUserId())) {
                    z = true;
                }
                postData.z0(this.f19645a.f19644i, z);
            }
            if (this.f19645a.j != null) {
                this.f19645a.j.a(postData);
            }
        }
    }

    /* loaded from: classes4.dex */
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
        this.f19641f = null;
        this.f19642g = false;
        this.j = null;
        a aVar = new a(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.q = aVar;
        this.f19644i = tbPageContext;
        registerListener(aVar);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r rVar = this.f19641f;
            if (rVar == null || rVar.d() == null || this.f19641f.l() == null || this.f19641f.i() == null) {
                return null;
            }
            WriteData writeData = new WriteData();
            boolean c2 = this.f19641f.l().c2();
            if (c2) {
                writeData.setVForumId(this.f19641f.d().getId());
                writeData.setVForumName(this.f19641f.d().getName());
            } else {
                writeData.setForumName(this.f19641f.d().getName());
                writeData.setForumId(this.f19641f.d().getId());
            }
            writeData.setFromForumId(this.k);
            writeData.setFloor(this.f19641f.i().E());
            writeData.setType(2);
            writeData.setCanNoForum(c2);
            writeData.setThreadId(this.f19641f.l().d0());
            writeData.setFloorNum(0);
            return writeData;
        }
        return (WriteData) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.p : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            P();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void M(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, postData) == null) || postData == null) {
            return;
        }
        this.f19641f.i().c(postData);
        this.f19641f.i().d(postData);
        this.f19641f.i().p0(true);
    }

    public final SubPbRequestMessage N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            r rVar = this.f19641f;
            if (rVar != null && rVar.l() != null && this.f19641f.l().d0() != null && this.f19641f.i() != null && this.f19641f.i().E() != null) {
                this.f19642g = true;
                float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                int k = l.k(TbadkCoreApplication.getInst().getApp());
                int i2 = l.i(TbadkCoreApplication.getInst().getApp());
                return new SubPbRequestMessage(this.f19644i.getPageActivity(), d.a.d.e.m.b.f(this.f19641f.l().d0(), 0L), d.a.d.e.m.b.f(this.f19641f.i().E(), 0L), 0L, 1, k, i2, f2, "", 1);
            }
            this.f19642g = false;
            return null;
        }
        return (SubPbRequestMessage) invokeV.objValue;
    }

    public void O(boolean z, @NonNull String str, @NonNull String str2, @NonNull String str3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), str, str2, str3, Boolean.valueOf(z2)}) == null) {
            this.l = z;
            this.m = str;
            this.n = str2;
            this.o = str3;
            this.p = z2;
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f19642g) {
            return;
        }
        cancelMessage();
        SubPbRequestMessage N = N();
        this.f19643h = N;
        if (N == null) {
            return;
        }
        sendMessage(N);
    }

    public void Q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.j = bVar;
        }
    }

    public void R(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, rVar) == null) {
            this.f19641f = rVar;
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
    public String getFromForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public void setFromForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.k = str;
        }
    }

    public void setPostId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.f19640e = str;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            registerListener(this.q);
        }
    }

    public void unRegisterListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            MessageManager.getInstance().unRegisterListener(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public int x() {
        InterceptResult invokeV;
        PostData i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            r rVar = this.f19641f;
            if (rVar != null && (i2 = rVar.i()) != null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f19640e : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.o : (String) invokeV.objValue;
    }
}
