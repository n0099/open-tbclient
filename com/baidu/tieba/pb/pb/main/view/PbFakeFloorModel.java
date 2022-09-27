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
import com.baidu.tieba.dh;
import com.baidu.tieba.ej;
import com.baidu.tieba.pb;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.r9;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.zv7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PbFakeFloorModel extends DataModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public zv7 b;
    public boolean c;
    public SubPbRequestMessage d;
    public TbPageContext e;
    public b f;
    public String g;
    public boolean h;
    public String i;
    public String j;
    public String k;
    public boolean l;
    public pb m;

    /* loaded from: classes5.dex */
    public class a extends pb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFakeFloorModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PbFakeFloorModel pbFakeFloorModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFakeFloorModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = pbFakeFloorModel;
        }

        @Override // com.baidu.tieba.pb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String userId;
            String errorString;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null || this.a.unique_id != responsedMessage.getOrginalMessage().getTag()) {
                return;
            }
            boolean z = false;
            this.a.c = false;
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    errorString = this.a.e.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0c59);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                this.a.e.showToast(errorString);
                return;
            }
            zv7 zv7Var = null;
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                zv7Var = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
            } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                zv7Var = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
            }
            if (zv7Var == null || zv7Var.k() == null) {
                return;
            }
            PostData postData = (PostData) ListUtils.getItem(zv7Var.k(), zv7Var.k().size() - 1);
            if (postData != null && this.a.b != null && this.a.b.i() != null) {
                if (this.a.b.l() != null && this.a.b.l().getAuthor() != null && postData.s() != null && (userId = this.a.b.l().getAuthor().getUserId()) != null && userId.equals(postData.s().getUserId())) {
                    z = true;
                }
                postData.g1(this.a.e, z);
            }
            if (this.a.f != null) {
                this.a.f.a(postData);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = false;
        this.f = null;
        a aVar = new a(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.m = aVar;
        this.e = tbPageContext;
        registerListener(aVar);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public int A() {
        InterceptResult invokeV;
        PostData i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            zv7 zv7Var = this.b;
            if (zv7Var != null && (i = zv7Var.i()) != null) {
                return i.C();
            }
            return super.A();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            zv7 zv7Var = this.b;
            if (zv7Var == null || zv7Var.l() == null) {
                return null;
            }
            return this.b.l().getTid();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.i : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            zv7 zv7Var = this.b;
            if (zv7Var == null || zv7Var.d() == null || this.b.l() == null || this.b.i() == null) {
                return null;
            }
            WriteData writeData = new WriteData();
            boolean isMutiForumThread = this.b.l().isMutiForumThread();
            if (isMutiForumThread) {
                writeData.setVForumId(this.b.d().getId());
                writeData.setVForumName(this.b.d().getName());
            } else {
                writeData.setForumName(this.b.d().getName());
                writeData.setForumId(this.b.d().getId());
            }
            writeData.setFromForumId(this.g);
            writeData.setFloor(this.b.i().L());
            writeData.setType(2);
            writeData.setCanNoForum(isMutiForumThread);
            writeData.setThreadId(this.b.l().getId());
            writeData.setFloorNum(0);
            return writeData;
        }
        return (WriteData) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.h : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.l : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            T();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void Q(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, postData) == null) || postData == null) {
            return;
        }
        this.b.i().b(postData);
        this.b.i().c(postData);
        this.b.i().R0(true);
    }

    public final SubPbRequestMessage R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            zv7 zv7Var = this.b;
            if (zv7Var != null && zv7Var.l() != null && this.b.l().getId() != null && this.b.i() != null && this.b.i().L() != null) {
                this.c = true;
                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                int k = ej.k(TbadkCoreApplication.getInst().getApp());
                int i = ej.i(TbadkCoreApplication.getInst().getApp());
                return new SubPbRequestMessage(this.e.getPageActivity(), dh.g(this.b.l().getId(), 0L), dh.g(this.b.i().L(), 0L), 0L, 1, k, i, f, "", 1);
            }
            this.c = false;
            return null;
        }
        return (SubPbRequestMessage) invokeV.objValue;
    }

    public void S(boolean z, @NonNull String str, @NonNull String str2, @NonNull String str3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), str, str2, str3, Boolean.valueOf(z2)}) == null) {
            this.h = z;
            this.i = str;
            this.j = str2;
            this.k = str3;
            this.l = z2;
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.c) {
            return;
        }
        cancelMessage();
        SubPbRequestMessage R = R();
        this.d = R;
        if (R == null) {
            return;
        }
        sendMessage(R);
    }

    public void U(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            this.f = bVar;
        }
    }

    public void V(zv7 zv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, zv7Var) == null) {
            this.b = zv7Var;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            zv7 zv7Var = this.b;
            if (zv7Var == null || zv7Var.d() == null) {
                return null;
            }
            return this.b.d().getId();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getFromForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.g : (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setFromForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.g = str;
        }
    }

    public void setPostId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.a = str;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            registerListener(this.m);
        }
    }

    public void unRegisterListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            MessageManager.getInstance().unRegisterListener(getUniqueId());
        }
    }
}
