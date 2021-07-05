package com.baidu.tieba.pb.pb.main.view;

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
import d.a.c.a.f;
import d.a.c.e.p.l;
import d.a.s0.h2.h.r;
/* loaded from: classes5.dex */
public class PbFakeFloorModel extends DataModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f19499e;

    /* renamed from: f  reason: collision with root package name */
    public r f19500f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19501g;

    /* renamed from: h  reason: collision with root package name */
    public SubPbRequestMessage f19502h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext f19503i;
    public b j;
    public String k;
    public d.a.c.c.g.a l;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFakeFloorModel f19504a;

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
            this.f19504a = pbFakeFloorModel;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String userId;
            String errorString;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null || this.f19504a.unique_id != responsedMessage.getOrginalMessage().getTag()) {
                return;
            }
            boolean z = false;
            this.f19504a.f19501g = false;
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    errorString = this.f19504a.f19503i.getPageActivity().getResources().getString(R.string.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                this.f19504a.f19503i.showToast(errorString);
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
            if (postData != null && this.f19504a.f19500f != null && this.f19504a.f19500f.i() != null) {
                if (this.f19504a.f19500f.l() != null && this.f19504a.f19500f.l().H() != null && postData.t() != null && (userId = this.f19504a.f19500f.l().H().getUserId()) != null && userId.equals(postData.t().getUserId())) {
                    z = true;
                }
                postData.z0(this.f19504a.f19503i, z);
            }
            if (this.f19504a.j != null) {
                this.f19504a.j.a(postData);
            }
        }
    }

    /* loaded from: classes5.dex */
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
        this.f19500f = null;
        this.f19501g = false;
        this.j = null;
        a aVar = new a(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.l = aVar;
        this.f19503i = tbPageContext;
        registerListener(aVar);
    }

    public void E(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, postData) == null) || postData == null) {
            return;
        }
        this.f19500f.i().c(postData);
        this.f19500f.i().d(postData);
        this.f19500f.i().p0(true);
    }

    public final SubPbRequestMessage F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            r rVar = this.f19500f;
            if (rVar != null && rVar.l() != null && this.f19500f.l().c0() != null && this.f19500f.i() != null && this.f19500f.i().E() != null) {
                this.f19501g = true;
                float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                int k = l.k(TbadkCoreApplication.getInst().getApp());
                int i2 = l.i(TbadkCoreApplication.getInst().getApp());
                return new SubPbRequestMessage(this.f19503i.getPageActivity(), d.a.c.e.m.b.f(this.f19500f.l().c0(), 0L), d.a.c.e.m.b.f(this.f19500f.i().E(), 0L), 0L, 1, k, i2, f2, "", 1);
            }
            this.f19501g = false;
            return null;
        }
        return (SubPbRequestMessage) invokeV.objValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f19501g) {
            return;
        }
        cancelMessage();
        SubPbRequestMessage F = F();
        this.f19502h = F;
        if (F == null) {
            return;
        }
        sendMessage(F);
    }

    public void H(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.j = bVar;
        }
    }

    public void I(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, rVar) == null) {
            this.f19500f = rVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setFromForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.k = str;
        }
    }

    public void setPostId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f19499e = str;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            registerListener(this.l);
        }
    }

    public void unRegisterListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            MessageManager.getInstance().unRegisterListener(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f19499e : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            r rVar = this.f19500f;
            if (rVar == null || rVar.d() == null || this.f19500f.l() == null || this.f19500f.i() == null) {
                return null;
            }
            WriteData writeData = new WriteData();
            boolean b2 = this.f19500f.l().b2();
            if (b2) {
                writeData.setVForumId(this.f19500f.d().getId());
                writeData.setVForumName(this.f19500f.d().getName());
            } else {
                writeData.setForumName(this.f19500f.d().getName());
                writeData.setForumId(this.f19500f.d().getId());
            }
            writeData.setFromForumId(this.k);
            writeData.setFloor(this.f19500f.i().E());
            writeData.setType(2);
            writeData.setCanNoForum(b2);
            writeData.setThreadId(this.f19500f.l().c0());
            writeData.setFloorNum(0);
            return writeData;
        }
        return (WriteData) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            G();
            return true;
        }
        return invokeV.booleanValue;
    }
}
